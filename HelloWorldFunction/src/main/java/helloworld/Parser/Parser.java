package helloworld.Parser;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public interface Parser {
  public ArrayList<JavaEntity> parseSourceFiles(ArrayList<File> files) throws IOException;
}
