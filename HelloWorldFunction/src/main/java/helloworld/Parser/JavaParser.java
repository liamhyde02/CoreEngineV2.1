package helloworld.Parser;
import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;

public interface JavaParser {
    public JSONArray parse(ArrayList<File> files);
}
