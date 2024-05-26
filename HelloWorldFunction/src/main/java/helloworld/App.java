package helloworld;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import helloworld.DataFetcher.GithubDataFetcher;
import helloworld.GraphBuilder.Functionality;
import helloworld.Parser.JavaParserFunctionality;
import helloworld.Parser.Parser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);
        try {
            JSONObject body = new JSONObject(input.getBody());
            String message = body.getString("type");
            JSONObject fetcherRequestBody = new JSONObject();

            fetcherRequestBody.put("type", message);
            switch (message) {
                case "github":
                    System.out.println("Github");
                    fetcherRequestBody.put("url", body.getString("url"));
                    break;
                default:
                    return response
                            .withBody("{\"error\": \"Invalid fetching type: " + message + "\"}")
                            .withStatusCode(500);
            }
            ArrayList<File> files = new ArrayList<>();
            files.addAll(new GithubDataFetcher().downloadPackage(body.getString("url"), true));

            JavaParserFunctionality parser = new JavaParserFunctionality();
            JSONArray parserResponseBody = parser.parse(files);
            JSONObject output = Functionality.toGraphData(parserResponseBody);
            S3Handler s3Handler = new S3Handler("lihydeseniorprojectactionbucket");
            UMLBuilder umlBuilder = new UMLBuilder(output, s3Handler);
            String S3Link = umlBuilder.buildUMLDiagram();

            return response
                    .withStatusCode(200)
                    .withBody("{\"S3Link\": \"" + S3Link + "\"}");
        } catch (Exception e) {
            return response
                    .withBody(e.getMessage())
                    .withStatusCode(500);
        }
    }

    private String getPageContents(String address) throws IOException{
        URL url = new URL(address);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
