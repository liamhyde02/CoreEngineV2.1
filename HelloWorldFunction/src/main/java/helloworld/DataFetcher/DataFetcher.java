package helloworld.DataFetcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface DataFetcher {
    public ArrayList<File> downloadPackage(String url, boolean isLambdaEnvironment) throws IOException;
}
