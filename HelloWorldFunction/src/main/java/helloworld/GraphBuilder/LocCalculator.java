package helloworld.GraphBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

public class LocCalculator {
    public static void calculateLOC(JSONArray jsonArray) {
        int totalLOC = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            totalLOC += jsonObject.optInt("linesOfCode", 0);
        }
        double averageLOC = jsonArray.length() > 0 ? (double) totalLOC / jsonArray.length() : 0;
        DataStorage.setAverageLOC(averageLOC);
    }
}
