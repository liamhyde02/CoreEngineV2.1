package helloworld.GraphBuilder;

import org.json.JSONObject;

import javax.xml.crypto.Data;

import static org.tmatesoft.sqljet.core.internal.vdbe.SqlJetVdbeMemFlags.Null;

public class NodeFactory {

    public static void createNode(JSONObject jsonObject){
        try {
            String name = jsonObject.getString("name");
            String type = getType(jsonObject.getString("type"));
            double size = getSize(jsonObject.getInt("linesOfCode"));
            Node newNode = new Node(name, type, size);
            DataStorage.addNode(newNode);
        } catch (Exception e) {
            return;
        }

    }

    private static String getType(String type){
        if(type.equals("JAVA_BASE_CLASS")) return "class";
        else if(type.equals("JAVA_INTERFACE")) return "iface";
        else return "aclass";
    }

    private static double getSize(int loc){
        double size = (double) loc / DataStorage.getAverageLOC();
        size = Math.round(size * 1000) / 1000.0;
        return size;
    }
}
