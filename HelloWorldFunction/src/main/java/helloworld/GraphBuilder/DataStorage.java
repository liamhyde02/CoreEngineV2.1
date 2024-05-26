package helloworld.GraphBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataStorage {
    private static double averageLOC = 0;
    private static List<Node> nodeList = new ArrayList<>();
    private static List<Edge> edgeList = new ArrayList<>();
    public static double getAverageLOC() {
        return averageLOC;
    }
    public static void setAverageLOC(double avgLOC) {
        averageLOC = avgLOC;
    }

    public static void addNode(Node node) {
        nodeList.add(node);
    }

    public static void addEdge(Edge edge) {
        edgeList.add(edge);
    }

    public static List<Node> getNodes() {
        return new ArrayList<>(nodeList);
    }

    public static List<Edge> getEdges() {
        return new ArrayList<>(edgeList);
    }

    public static void removeDuplicateEdges() {
        Set<Edge> uniqueEdges = new HashSet<>(edgeList);
        edgeList.clear();
        edgeList.addAll(uniqueEdges);
    }
    public static void removeDuplicateNodes() {
        Set<Node> uniqueNodes = new HashSet<>(nodeList);
        nodeList.clear();
        nodeList.addAll(uniqueNodes);
    }

    public static JSONObject returnData() {
        JSONObject data = new JSONObject();

        JSONArray nodesArray = new JSONArray();
        for (Node node : nodeList) {
            nodesArray.put(node.toJsonObject());
        }

        JSONArray edgesArray = new JSONArray();
        for (Edge edge : edgeList) {
            edgesArray.put(edge.toJsonObject());
        }

        data.put("Nodes", nodesArray);
        data.put("Edges", edgesArray);

        return data;
    }

    public static void clearData() {
        nodeList.clear();
        edgeList.clear();
        averageLOC = 0;
    }
}
