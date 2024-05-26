package helloworld;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.InputStream;

public class S3Handler {
    private final S3Client s3Client;
    private final String bucketName;

    public S3Handler(String bucketName) {
        this.s3Client = S3Client.builder().region(Region.US_EAST_1).build();
        this.bucketName = bucketName;
    }

    public String uploadImageToS3(InputStream imageStream, String imageName, long contentLength) throws Exception {
        try {
            String imageKey = "images/" + System.currentTimeMillis() + "-" + imageName;
            String S3Link = "https://" + bucketName + ".s3.amazonaws.com/" + imageKey;

            try {
                HeadObjectResponse headResponse = s3Client.headObject(HeadObjectRequest.builder()
                        .bucket(bucketName)
                        .key(imageKey)
                        .build());
                System.out.println("Image already in S3, Link: " + S3Link);
                return imageKey;
            } catch (NoSuchKeyException e) {
                // File does not exist, which is expected for new uploads
            }

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(imageKey)
                    .contentType("image/svg+xml")
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(imageStream, contentLength));
            System.out.println("Image Link: " + S3Link);
            return S3Link;
        } catch (Exception e) {
            System.err.println("Failed to upload image to S3: " + e.getMessage());
            throw e;
        }
    }

    public void close() {
        s3Client.close();
    }
}
