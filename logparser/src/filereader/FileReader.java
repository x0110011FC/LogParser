package filereader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileReader {

    private String args;

    public FileReader(String args) {
        this.args = args;
    }

    public String readFile() throws IOException {
        File file = new File(args);
        String filePath = file.getAbsolutePath();
        String logFileContent = Files.lines(Paths.get(filePath)).collect(Collectors.joining("\n"));
        return logFileContent;
    }
}
