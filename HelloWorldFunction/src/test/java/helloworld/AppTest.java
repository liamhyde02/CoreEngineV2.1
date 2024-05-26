//package helloworld;
//
//import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
//import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class AppTest {
//    @Test
//    public void successfulResponse() {
//        App app = new App();
//        APIGatewayProxyRequestEvent input = new APIGatewayProxyRequestEvent();
//        input.setBody("{\"type\":\"github\",\"url\":\"https://github.com/smartyro/FinalProject308\"}");
//
//        APIGatewayProxyResponseEvent result = app.handleRequest(input, null);
//        System.out.println("Result: " + result.getBody());
//        assertEquals("application/json", result.getHeaders().get("Content-Type"));
//        String content = result.getBody();
//        assertNotNull(content);
//    }
//}
