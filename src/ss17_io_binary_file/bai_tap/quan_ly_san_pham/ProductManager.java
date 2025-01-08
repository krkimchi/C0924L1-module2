package ss17_io_binary_file.bai_tap.quan_ly_san_pham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String FILE_NAME = "src/ss17_io_binary_file/bai_tap/quan_ly_san_pham/products.dat";

    public static void writeProductsToFile(List<Product> products) {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            System.out.println("Dữ liệu sản phẩm đã được ghi vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể ghi dữ liệu vào file. " + e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
    }

    public static List<Product> readProductsFromFile() {
        List<Product> products = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if (obj != null && obj instanceof ArrayList) {
                products = (ArrayList<Product>) obj;
            } else {
                System.out.println("Dữ liệu trong file không phải là danh sách sản phẩm.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File dữ liệu chưa tồn tại. Hệ thống sẽ tạo file mới sau.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy lớp phù hợp để đọc dữ liệu.");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("Lỗi khi đóng file: " + e.getMessage());
                }
            }
        }
        return products;
    }

}