package helloworld.GraphBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
//            String fetcherApiEndpoint = "https://9uae89tfti.execute-api.us-east-1.amazonaws.com/default/FileChecker";
//            String parserApiEndpoint = "https://0sv98jg18l.execute-api.us-east-1.amazonaws.com/default/Parser";
//            String githubUrl = "https://github.com/smartyro/FinalProject308";
//
//            HttpClient client = HttpClient.newHttpClient();
//
//            // Prepare the JSON body for the fetcher API request
//            JSONObject fetcherRequestBody = new JSONObject();
//            fetcherRequestBody.put("message", "github");
//            fetcherRequestBody.put("url", githubUrl);
//
//            // Call the fetcher API
//            HttpRequest fetcherRequest = HttpRequest.newBuilder()
//                    .uri(new URI(fetcherApiEndpoint))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(fetcherRequestBody.toString()))
//                    .build();
//            HttpResponse<String> fetcherResponse = client.send(fetcherRequest, HttpResponse.BodyHandlers.ofString());
//
//            // Parse the fetcher API response
//            JSONObject fetcherResponseBody = new JSONObject(fetcherResponse.body());
//            System.out.println(fetcherResponseBody.toString());
//            String bucket = fetcherResponseBody.getString("bucket");
//            JSONArray fileTags = fetcherResponseBody.getJSONArray("fileTags");
//
//            // Prepare the JSON body for the parser API request
//            JSONObject parserRequestBody = new JSONObject();
//            parserRequestBody.put("bucket", bucket);
//            parserRequestBody.put("fileTags", fileTags);
//
//            // Call the parser API
//            HttpRequest parserRequest = HttpRequest.newBuilder()
//                    .uri(new URI(parserApiEndpoint))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(parserRequestBody.toString()))
//                    .build();
//            HttpResponse<String> parserResponse = client.send(parserRequest, HttpResponse.BodyHandlers.ofString());

            // Print the body of the parser API response
            //JSONArray parserResponseBody = new JSONArray(parserResponse.body());
            //System.out.println(parserResponseBody.getJSONObject(0).getString("name"));

            String body = "[{\"associations\":[\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\"],\"linesOfCode\":125,\"name\":\"ControlHandler\",\"realizations\":[],\"compositions\":[\"Shape\",\"StatusBar\"],\"fullyQualifiedName\":\"Controller.ControlHandler\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":91,\"name\":\"Arrow\",\"realizations\":[],\"compositions\":[\"Shape\"],\"fullyQualifiedName\":\"Model.Arrow\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":73,\"name\":\"BackgroundMusicPlayer\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.BackgroundMusicPlayer\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":82,\"parent\":\"Shape\",\"name\":\"BeginShape\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.BeginShape\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Shape\"]}," +
                    "{\"associations\":[\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\"],\"linesOfCode\":91,\"name\":\"CheckDiagram\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.CheckDiagram\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Problem\"]}," +
                    "{\"associations\":[],\"linesOfCode\":80,\"parent\":\"Shape\",\"name\":\"ConditionShape\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.ConditionShape\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Shape\"]}," +
                    "{\"associations\":[],\"linesOfCode\":331,\"name\":\"DatabaseConnect\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.DatabaseConnect\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":82,\"parent\":\"Shape\",\"name\":\"EndShape\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.EndShape\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Shape\"]}," +
                    "{\"associations\":[],\"linesOfCode\":214,\"name\":\"Flowchart\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.Flowchart\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Flowchart\"]}," +
                    "{\"associations\":[],\"linesOfCode\":118,\"parent\":\"Shape\",\"name\":\"InputOutputShape\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.InputOutputShape\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Shape\"]}," +
                    "{\"associations\":[],\"linesOfCode\":80,\"parent\":\"Shape\",\"name\":\"InstructionShape\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.InstructionShape\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Shape\"]}," +
                    "{\"associations\":[],\"linesOfCode\":81,\"parent\":\"Shape\",\"name\":\"MethodShape\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.MethodShape\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Shape\"]}," +
                    "{\"associations\":[\"CheckDiagram\",\"DatabaseConnect\",\"Login\",\"DatabaseConnect\",\"Login\",\"CheckDiagram\"],\"linesOfCode\":302,\"name\":\"Repository\",\"realizations\":[\"RepositoryInterface\"],\"compositions\":[\"Repository\",\"Shape\",\"BackgroundMusicPlayer\"],\"fullyQualifiedName\":\"Model.Repository\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Shape\",\"Problem\"]},{\"linesOfCode\":25,\"name\":\"RepositoryInterface\",\"fullyQualifiedName\":\"Model.RepositoryInterface\",\"type\":\"JAVA_INTERFACE\",\"dependencies\":[\"Shape\"]}," +
                    "{\"associations\":[],\"linesOfCode\":153,\"name\":\"Shape\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.Shape\",\"type\":\"JAVA_ABSTRACT_CLASS\",\"dependencies\":[\"Arrow\",\"Shape\"]}," +
                    "{\"associations\":[],\"linesOfCode\":82,\"parent\":\"Shape\",\"name\":\"VariableShape\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.VariableShape\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[\"Shape\"]}," +
                    "{\"associations\":[\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"Repository\"],\"linesOfCode\":164,\"name\":\"problemContainer\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.problemContainer\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\"],\"linesOfCode\":72,\"name\":\"Blackboard\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.Blackboard\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":51,\"name\":\"Chat\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.Chat\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"CheckDiagram\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\",\"Repository\"],\"linesOfCode\":41,\"name\":\"CodePanel\",\"realizations\":[],\"compositions\":[\"Problem\"],\"fullyQualifiedName\":\"View.CodePanel\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"problemContainer\"],\"linesOfCode\":137,\"name\":\"FinalProject\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.FinalProject\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"RepositoryInterface\"],\"linesOfCode\":46,\"name\":\"HintPanel\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.HintPanel\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"DatabaseConnect\",\"DatabaseConnect\",\"userPanel\",\"Repository\",\"CheckDiagram\",\"CodePanel\",\"DatabaseConnect\",\"DatabaseConnect\",\"teacherView\"],\"linesOfCode\":179,\"name\":\"Login\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.Login\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"CheckDiagram\"],\"linesOfCode\":38,\"name\":\"Menu\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.Menu\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":19,\"name\":\"Problem\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.Problem\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":17,\"name\":\"StatusBar\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.StatusBar\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"RepositoryInterface\",\"RepositoryInterface\",\"RepositoryInterface\"],\"linesOfCode\":40,\"name\":\"fileMenu\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"View.fileMenu\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":83,\"name\":\"helpMenu\",\"realizations\":[],\"compositions\":[\"Chat\"],\"fullyQualifiedName\":\"View.helpMenu\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":70,\"name\":\"shapeMenu\",\"realizations\":[],\"compositions\":[\"ControlHandler\"],\"fullyQualifiedName\":\"View.shapeMenu\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"DatabaseConnect\"],\"linesOfCode\":58,\"name\":\"teacherView\",\"realizations\":[],\"compositions\":[\"teacherView\"],\"fullyQualifiedName\":\"View.teacherView\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":30,\"name\":\"userPanel\",\"realizations\":[],\"compositions\":[\"userPanel\"],\"fullyQualifiedName\":\"View.userPanel\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":18,\"name\":\"BeginShapeTest\",\"realizations\":[],\"compositions\":[\"BeginShape\"],\"fullyQualifiedName\":\"Model.BeginShapeTest\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":18,\"name\":\"ConditionShapeTest\",\"realizations\":[],\"compositions\":[\"ConditionShape\"],\"fullyQualifiedName\":\"Model.ConditionShapeTest\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[\"DatabaseConnect\",\"DatabaseConnect\",\"DatabaseConnect\",\"DatabaseConnect\",\"DatabaseConnect\",\"DatabaseConnect\"],\"linesOfCode\":45,\"name\":\"DatabaseConnectTest\",\"realizations\":[],\"compositions\":[],\"fullyQualifiedName\":\"Model.DatabaseConnectTest\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":18,\"name\":\"EndShapeTest\",\"realizations\":[],\"compositions\":[\"EndShape\"],\"fullyQualifiedName\":\"Model.EndShapeTest\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":20,\"name\":\"InputOutputShapeTest\",\"realizations\":[],\"compositions\":[\"InputOutputShape\"],\"fullyQualifiedName\":\"Model.InputOutputShapeTest\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":18,\"name\":\"InstructionShapeTest\",\"realizations\":[],\"compositions\":[\"InstructionShape\"],\"fullyQualifiedName\":\"Model.InstructionShapeTest\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":18,\"name\":\"MethodShapeTest\",\"realizations\":[],\"compositions\":[\"MethodShape\"],\"fullyQualifiedName\":\"Model.MethodShapeTest\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}," +
                    "{\"associations\":[],\"linesOfCode\":18,\"name\":\"VariableShapeTest\",\"realizations\":[],\"compositions\":[\"VariableShape\"],\"fullyQualifiedName\":\"Model.VariableShapeTest\",\"type\":\"JAVA_BASE_CLASS\",\"dependencies\":[]}]";
            JSONArray parserResponseBody = new JSONArray(body);
            JSONObject data = Functionality.toGraphData(parserResponseBody);
            System.out.println(data);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}