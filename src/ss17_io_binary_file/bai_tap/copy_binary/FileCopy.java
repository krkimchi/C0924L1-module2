package ss17_io_binary_file.bai_tap.copy_binary;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Chương Trình Sao Chép Tập Tin ===");
        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Nhập đường dẫn tệp đích: ");
        String targetPath = scanner.nextLine();

        copyFile(sourcePath, targetPath);
    }

    public static void copyFile(String sourcePath, String targetPath) {
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        if (!sourceFile.exists()) {
            System.out.println("Lỗi: Tệp nguồn không tồn tại.");
            return;
        }

        if (targetFile.exists()) {
            System.out.print("Cảnh báo: Tệp đích đã tồn tại. Bạn có muốn ghi đè? (có/không): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("có")) {
                System.out.println("Thao tác sao chép bị hủy.");
                return;
            }
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);

            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytes = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println("Sao chép thành công. Số byte đã sao chép: " + totalBytes);
        } catch (IOException e) {
            System.out.println("Lỗi trong quá trình sao chép: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng FileInputStream: " + e.getMessage());
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng FileOutputStream: " + e.getMessage());
                }
            }
        }
    }
}
