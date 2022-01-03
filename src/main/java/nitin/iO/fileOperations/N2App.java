package nitin.iO.fileOperations;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class N2App {
    public static void main(String[] args) {

        Path readFilesFromFolderPath = Paths.get("src/main/resources/releases");
        Path input = Paths.get("src/main/resources/input.txt");
        Path writeIntoFilename = Paths.get("src/main/resources/nitin.txt");

        List<File> filesInFolder = getAllFilesFromFolder(readFilesFromFolderPath);
        List<String> configFileStr = getStringsFromEachFileInFolder(filesInFolder);
        List<String> inputStr = getInputStrings(input);

        List<String> writeLine = compareAndPrepareWriteLines(configFileStr, inputStr);
        try {
            Files.write(writeIntoFilename, writeLine, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> compareAndPrepareWriteLines(List<String> configFileStr, List<String> inputStr) {
        List<String> writeLine = new ArrayList<>();
        for (String str : inputStr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (configFileStr.contains(str)) {
                sb.append(" ").append("Verified");
                writeLine.add(sb.toString());//.replaceAll("\\s", ""));
            } else {
                sb.append(" ").append("NotVerified");
                writeLine.add(sb.toString());//.replaceAll("\\s", ""));
            }
        }
        return writeLine;
    }

    private static List<String> getStringsFromEachFileInFolder(List<File> filesInFolder) {
        List<String> configFileStr = new ArrayList<>();
        for (File f : filesInFolder) {
            StringBuilder sb = new StringBuilder();
            sb.append(f.getName().substring(0, f.getName().length() - 5)).append(" ");
            try {
                List<String> temp =
                        Files.lines(f.toPath())
                                .filter(line -> line.contains("tag"))
                                .map(str -> str.substring(11))
                                .collect(Collectors.toList());

                if (temp.size() == 1) {
                    sb.append(temp.get(0));
                    configFileStr.add(sb.toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configFileStr;
    }

    private static List<String> getInputStrings(Path input) {
        List<String> inputStr = new ArrayList<>();
        try {
            inputStr = Files
                    .readAllLines(input)
                    .stream()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStr;
    }

    private static List<File> getAllFilesFromFolder(Path path) {
        List<File> filesInFolder = new ArrayList<>();
        try {
            filesInFolder = Files.walk(path)
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .filter(filename -> filename.getName().endsWith("yaml"))
                    //.peek(file -> System.out.println(file))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filesInFolder;
    }

    private static void extracted(List<File> filesInFolder, List<String> inputStr, List<String> writeLine) {
        for (File f : filesInFolder) {
            StringBuilder sb = new StringBuilder();
            sb.append(f.getName().substring(0, f.getName().length() - 5)).append(" ");
            try {
                Files.lines(f.toPath())
                        .filter(line -> line.contains("tag")) // this line filters any line out which does not meet the condition
                        .forEach(line -> {
                            //System.out.println(line);
                            sb.append(line.substring(11));
                        });//print each line
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (inputStr.contains(sb.toString())) {
                sb.append(" ").append("Verified");
                writeLine.add(sb.toString());//.replaceAll("\\s", ""));
            } else {
                sb.append(" ").append("NotVerified");
                writeLine.add(sb.toString());//.replaceAll("\\s", ""));
            }
        }
    }
}