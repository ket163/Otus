import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class TestReader {
    public static Object[] readFromFile (String filename) {
        Path filePath = new File(filename).toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList = null;
        try {
            stringList = Files.readAllLines(filePath, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] stringArray = stringList.toArray(new String[]{});

        return stringArray;
    }



    }


