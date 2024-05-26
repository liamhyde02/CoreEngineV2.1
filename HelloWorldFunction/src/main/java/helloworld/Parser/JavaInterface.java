package helloworld.Parser;

import org.json.JSONObject;

import java.util.ArrayList;

public class JavaInterface implements JavaEntity{
    String name, fullyQualifiedName;
    int linesOfCode;
    ArrayList<String> dependencies;
    public JavaInterface(String name, String fullyQualifiedName, int linesOfCode, ArrayList<String> dependencies) {
        this.name = name;
        this.fullyQualifiedName = fullyQualifiedName;
        this.linesOfCode = linesOfCode;
        this.dependencies = dependencies;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getFullyQualifiedName() {
        return this.fullyQualifiedName;
    }

    @Override
    public ArrayList<String> getDependencies() {
        return this.dependencies;
    }

    @Override
    public int getLinesOfCode() {
        return this.linesOfCode;
    }

    @Override
    public JavaEntityType getType() {
        return JavaEntityType.JAVA_INTERFACE;
    }
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.getName());
        jsonObject.put("fullyQualifiedName", this.getFullyQualifiedName());
        jsonObject.put("linesOfCode", this.getLinesOfCode());
        jsonObject.put("dependencies", this.getDependencies());
        jsonObject.put("type", this.getType());
        return jsonObject;
    }
}
