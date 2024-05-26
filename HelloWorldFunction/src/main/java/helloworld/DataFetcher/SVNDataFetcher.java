package helloworld.DataFetcher;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc2.SvnCheckout;
import org.tmatesoft.svn.core.wc2.SvnOperationFactory;
import org.tmatesoft.svn.core.wc2.SvnTarget;

import java.io.File;
import java.util.ArrayList;
public class SVNDataFetcher implements DataFetcher {
    private static final String LAMBDA_TMP_DIR = "/tmp/";
    private final SvnOperationFactory svnOperationFactory;

    public SVNDataFetcher() {
        svnOperationFactory = new SvnOperationFactory();
    }

    @Override
    public ArrayList<File> downloadPackage(String sourceUrl, boolean isLambdaEnvironment) {
        ArrayList<File> downloadedFiles = new ArrayList<>();

        try {
            SVNURL svnurl = SVNURL.parseURIEncoded(sourceUrl);

            // Handle Lambda environment specific path
            String checkoutPath = isLambdaEnvironment ? LAMBDA_TMP_DIR : "temp";
            File checkoutDirectory = new File(checkoutPath);

            if (!checkoutDirectory.exists()) {
            checkoutDirectory.mkdirs();
            }

            SvnCheckout checkout = svnOperationFactory.createCheckout();
            checkout.setSource(SvnTarget.fromURL(svnurl));
            checkout.setSingleTarget(SvnTarget.fromFile(checkoutDirectory));
            checkout.setRevision(SVNRevision.HEAD);
            checkout.run();

            populateDownloadedFilesList(checkoutDirectory, downloadedFiles);
        } catch (SVNException e) {
            throw new RuntimeException(e);
        } finally {
            svnOperationFactory.dispose();
        }

        return downloadedFiles;
    }

    private void populateDownloadedFilesList(File directory, ArrayList<File> downloadedFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    populateDownloadedFilesList(file, downloadedFiles);
                } else {
                    downloadedFiles.add(file);
                }
            }
        }
    }
}
