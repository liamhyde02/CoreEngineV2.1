package helloworld.GraphBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

public class Functionality {

    public static JSONObject toGraphData(JSONArray body){
        LocCalculator.calculateLOC(body);
        LoopingFunctionality.runChain(body);
        DataStorage.removeDuplicateEdges();
        MetricsCalculator.calculateMetrics(DataStorage.getNodes(), DataStorage.getEdges());
        DataStorage.removeDuplicateNodes();
        return DataStorage.returnData();
    }
}
