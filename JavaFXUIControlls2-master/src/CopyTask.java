import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Task;

public class CopyTask extends Task<List<File>> {

    private List<File> copied;

    @Override
    protected List<File> call() throws Exception {

        // Pfad
        // C:/Windows/Desktop
        final File dir = new File("C:\\Users\\tajik\\Documents");
        final File[] files = dir.listFiles();
        final int fileCount = files.length;

        copied = new ArrayList<>();

        int i = 0;
        for (final File file : files) {
            if (file.isFile()) {
                copy(file);
                copied.add(file);
                System.out.println("" + file);
            }
            i++;
            this.updateProgress(i, fileCount);
        }

        return copied;
    }

    private void copy(final File file) throws Exception {
        this.updateMessage("Kopiere: " + file.getAbsolutePath());
        Thread.sleep(500);
    }

}
