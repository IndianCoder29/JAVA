package slip14;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class FileSearch implements Callable<String> {
    private String filePath;
    private String searchString;

    public FileSearch(String filePath, String searchString) {
        this.filePath = filePath;
        this.searchString = searchString;
    }

    @Override
    public String call() throws Exception {
        int lineNumber = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    return "String found in file: " + filePath + " at line: " +
                            lineNumber;
                }
                lineNumber++;
            }
        }
        return "String not found in file: " + filePath;
    }
}

public class SearchEngine {
    public static void main(String[] args) throws Exception {
        String searchString = args[0];
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("."))) {
            for (Path path : directoryStream) {
                if (!Files.isDirectory(path) && path.toString().endsWith(".txt")) {
                    futures.add(executor.submit(new FileSearch(path.toString(),
                            searchString)));
                }
            }
        }
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}