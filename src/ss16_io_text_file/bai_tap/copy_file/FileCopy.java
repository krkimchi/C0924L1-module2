package ss16_io_text_file.bai_tap.copy_file;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập đường dẫn tệp nguồn: ");
            String sourceFilePath = scanner.nextLine();

            System.out.print("Nhập đường dẫn tệp đích: ");
            String targetFilePath = scanner.nextLine();

            File sourceFile = new File(sourceFilePath);
            File targetFile = new File(targetFilePath);

            if (!sourceFile.exists()) {
                System.out.println("Tệp nguồn không tồn tại. Vui lòng kiểm tra lại.");
                return;
            }

            if (targetFile.exists()) {
                System.out.println("Tệp đích đã tồn tại. Sao chép bị hủy.");
                return;
            }

            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                fileInputStream = new FileInputStream(sourceFile);
                fileOutputStream = new FileOutputStream(targetFile);

                int byteData;
                int charCount = 0;
                while ((byteData = fileInputStream.read()) != -1) {
                    fileOutputStream.write(byteData);
                    charCount++;
                }

                System.out.println("Sao chép thành công. Số ký tự đã sao chép: " + charCount);
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi sao chép tệp: " + e.getMessage());
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        System.out.println("Không thể đóng FileInputStream: " + e.getMessage());
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        System.out.println("Không thể đóng FileOutputStream: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

