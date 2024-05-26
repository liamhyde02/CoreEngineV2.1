package helloworld.DataFetcher;
import org.kohsuke.github.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GithubDataFetcher implements DataFetcher {
    private static final String LAMBDA_TMP_DIR = "/tmp/";
    private static String downloadDirectory = LAMBDA_TMP_DIR; // default to Lambda tmp directory

    public ArrayList<File> downloadPackage(String repoUrl, boolean isLambdaEnvironment) throws IOException {
        if (!isLambdaEnvironment) {
            downloadDirectory = System.getProperty("user.dir") + File.separator + "downloaded_files"; // or any other directory
            new File(downloadDirectory).mkdirs(); // create the directory if it doesn't exist
        }

        GitHub github = new GitHubBuilder().build();
        if (github.getRateLimit().getRemaining() <= 0) {
            System.out.println("Github rate limited until: " + github.getRateLimit().getResetDate());
        }
        GHRepository repository = github.getRepository(repoUrl.substring(repoUrl.indexOf("github.com/") + 11));

        ArrayList<File> javaFiles = new ArrayList<>();
        processDirectory(repository, "", javaFiles);

        return javaFiles;
    }

    private static void processDirectory(GHRepository repository, String path, ArrayList<File> javaFiles) throws IOException {
        List<GHContent> contents = repository.getDirectoryContent(path);
        for (GHContent content : contents) {
            if (content.isDirectory()) {
                processDirectory(repository, content.getPath(), javaFiles);
            } else if (content.isFile() && content.getName().endsWith(".java")) {
                File downloadedFile = downloadFile(new URL(content.getDownloadUrl()), content.getName());
                javaFiles.add(downloadedFile);
            }
        }
    }

    private static File downloadFile(URL url, String fileName) throws IOException {
        File file = new File(downloadDirectory + File.separator + fileName);
        try (InputStream in = url.openStream(); FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        return file;
    }
}
