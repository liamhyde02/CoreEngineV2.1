package helloworld.GraphBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

public class LoopingFunctionality {

    public static void runChain(JSONArray jsonArray){
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            NodeFactory.createNode(jsonObject);
            EdgeFactory.createEdges(jsonObject);
        }
    }
}
