package case_study.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String DATA_PATH = "src/case_study/data/";

    public static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File(DATA_PATH + fileName);

        if (!file.exists()) {
            return lines;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng BufferedReader: " + e.getMessage());
                }
            }
        }
        return lines;
    }


    public static void writeFile(String fileName, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_PATH + fileName, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    public static void overwriteFile(String fileName, List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_PATH + fileName))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi đè vào file: " + e.getMessage());
        }
    }
}
