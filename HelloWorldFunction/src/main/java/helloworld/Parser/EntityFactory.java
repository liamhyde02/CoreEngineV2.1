package helloworld.Parser;

import java.io.File;
import java.io.IOException;

public interface EntityFactory {
    public JavaEntity createEntityFromFile(File filename) throws IOException;
}
