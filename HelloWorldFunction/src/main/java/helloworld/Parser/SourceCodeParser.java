package helloworld.Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SourceCodeParser implements Parser {
  private ArrayList<JavaEntity> entities;

  public SourceCodeParser() {
    this.entities = new ArrayList<>();
  };

  @Override
  public ArrayList<JavaEntity> parseSourceFiles(ArrayList<File> sourceCodeFiles) throws IOException {
    JavaEntityFactory entityFactory = new JavaEntityFactory();

    // Iterate through the provided ArrayList of Files
    for (File file : sourceCodeFiles) {
      JavaEntity entity = entityFactory.createEntityFromFile(file);
      if (entity != null) {
        entities.add(entity);
      } else {
        System.out.println(file.getName() + " is not a valid java file");
      }
    }

    return entities;
  }
}
