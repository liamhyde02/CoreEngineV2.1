package helloworld.GraphBuilder;

import org.json.JSONArray;
import org.json.JSONObject;


public class EdgeFactory {

    public static void createEdges(JSONObject jsonObject){
        String name = jsonObject.getString("name");
        if (jsonObject.has("associations")) {
            createOuts(name, "association", jsonObject.getJSONArray("associations"));
        }
        if (jsonObject.has("realizations")) {
            createOuts(name, "realization", jsonObject.getJSONArray("realizations"));
        }
        if (jsonObject.has("compositions")) {
            createIns(name, "composition", jsonObject.getJSONArray("compositions"));
        }
        if (jsonObject.has("dependencies")) {
            createOuts(name, "dependencies", jsonObject.getJSONArray("dependencies"));
        }
    }

    public static void createOuts(String name, String type, JSONArray outs){
        for (int i = 0; i < outs.length(); i++) {
            Edge newEdge = new Edge(name, outs.getString(i), type);
            DataStorage.addEdge(newEdge);
        }
    }
    public static void createIns(String name, String type, JSONArray ins){
        for (int i = 0; i < ins.length(); i++) {
            Edge newEdge = new Edge(ins.getString(i), name, type);
            DataStorage.addEdge(newEdge);
        }
    }
}
