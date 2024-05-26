package helloworld.Parser;

import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;

public class JavaParserFunctionality implements JavaParser{
    public JSONArray parse(ArrayList<File> files) {
        JSONArray jsonArray = new JSONArray();
        ArrayList<JavaEntity> entities = new ArrayList<>();
        SourceCodeParser sourceCodeParser = new SourceCodeParser();
        try {
            entities = sourceCodeParser.parseSourceFiles(files);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityCleaning entityCleaning = new EntityCleaning();
        entityCleaning.clean(entities);
        for (JavaEntity entity : entities) {
            jsonArray.put(entity.toJSON());
        }
        return jsonArray;
    }
}
