package helloworld;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.HashSet;

public class UMLBuilder {
    private JSONObject umlData;
    private HashSet<String> edgeSet;
    private S3Handler s3Handler;


    public UMLBuilder(JSONObject umlData, S3Handler s3Handler) {
        this.umlData = umlData;
        this.edgeSet = new HashSet<>();
        this.s3Handler = s3Handler;
    }

    public String buildUMLDiagram() {
        JSONArray nodes = umlData.getJSONArray("Nodes");
        JSONArray edges = umlData.getJSONArray("Edges");
        StringBuilder uml = new StringBuilder("@startuml\n");

        for (int i = 0; i < nodes.length(); i++) {
            JSONObject node = nodes.getJSONObject(i);
            String nodeType = node.getString("type");
            String nodeName = node.getString("name");
            switch (nodeType) {
                case "iface":
                    uml.append("interface ");
                    break;
                case "class":
                    uml.append("class ");
                    break;
                case "aclass":
                    uml.append("abstract class ");
                    break;
            }
            uml.append(nodeName).append(" {\n}\n");
        }

        for (int i = 0; i < edges.length(); i++) {
            JSONObject edge = edges.getJSONObject(i);
            String from = edge.getString("from");
            String to = edge.getString("to");
            String type = edge.getString("type");

            if (!edgeSet.contains(from + to)) {
                switch (type) {
                    case "realization":
                        uml.append(from).append(" ..|> ");
                        break;
                    case "composition":
                        uml.append(from).append(" *-- ");
                        break;
                    case "dependencies":
                        uml.append(from).append(" ..> ");
                        break;
                    case "association":
                        uml.append(from).append(" -- ");
                        break;
                }
                uml.append(to).append("\n");
                edgeSet.add(from + to);
            }
        }

        uml.append("@enduml");
        return generateImage(uml.toString());
    }

    private String generateImage(String uml) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            SourceStringReader reader = new SourceStringReader(uml);
            String desc = reader.generateImage(os, new FileFormatOption(FileFormat.SVG));
            byte[] imageBytes = os.toByteArray();

            // Upload to S3
            InputStream is = new ByteArrayInputStream(imageBytes);
            String s3Link = s3Handler.uploadImageToS3(is, "uml_diagram.svg", imageBytes.length);
            return s3Link;
        } catch (Exception e) {
            System.err.println("Failed to generate or upload UML diagram.");
            e.printStackTrace();
            return null;
        }
    }
}
