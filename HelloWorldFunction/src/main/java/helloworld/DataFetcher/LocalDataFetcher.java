package helloworld.DataFetcher;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalDataFetcher implements DataFetcher {
    private static final String LAMBDA_TMP_DIR = "/tmp/";
    private static final Logger LOGGER = Logger.getLogger(LocalDataFetcher.class.getName());
    private static final long MAX_SIZE = 15728640; // 15 MB

    @Override
    public ArrayList<File> downloadPackage(String data, boolean isLambdaEnvironment) {
        ArrayList<File> downloadedFiles = new ArrayList<>();
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(data);
            String targetPath = isLambdaEnvironment ? LAMBDA_TMP_DIR : "temp";
            Path targetDirectory = Paths.get(targetPath);

            if (!Files.exists(targetDirectory)) {
                Files.createDirectories(targetDirectory);
            }

            // Unzip the file
            Path zipFilePath = targetDirectory.resolve("decodedFile.zip");
            Files.write(zipFilePath, decodedBytes);
            unzipFile(zipFilePath, targetDirectory, downloadedFiles);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while decoding the file: ", e);
        }

        return downloadedFiles;
    }

    private void unzipFile(Path zipFilePath, Path targetDir, ArrayList<File> downloadedFiles) throws IOException {
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath.toFile()))) {
            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {
                Path filePath = targetDir.resolve(entry.getName());
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                    downloadedFiles.add(filePath.toFile());
                } else {
                    Files.createDirectories(filePath);
                }
                zipIn.closeEntry();
            }
        }
    }

    private void extractFile(ZipInputStream zipIn, Path filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath.toFile()))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }
}

