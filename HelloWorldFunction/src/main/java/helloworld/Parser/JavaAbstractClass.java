package helloworld.Parser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Optional;

public class JavaAbstractClass extends JavaClass{
    public JavaAbstractClass(String name, String fullyQualifiedName, int linesOfCode,
                             ArrayList<String> dependencies, ArrayList<String> realizations,
                             ArrayList<String> compositions, ArrayList<String> associations,
                             Optional<String> parent) {
        super(name, fullyQualifiedName, linesOfCode, dependencies, realizations, compositions, associations, parent);
    }
    @Override
    public JavaEntityType getType() {
        return JavaEntityType.JAVA_ABSTRACT_CLASS;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.getName());
        jsonObject.put("fullyQualifiedName", this.getFullyQualifiedName());
        jsonObject.put("linesOfCode", this.getLinesOfCode());
        jsonObject.put("dependencies", this.getDependencies());
        jsonObject.put("realizations", this.getRealizations());
        jsonObject.put("compositions", this.getCompositions());
        jsonObject.put("associations", this.getAssociations());
        jsonObject.put("parent", this.getParent());
        jsonObject.put("type", this.getType());
        return jsonObject;
    }
}
