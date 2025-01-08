package ss17_io_binary_file.bai_tap.quan_ly_san_pham;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private List<Product> products;
    private Scanner scanner;

    public ProductMenu() {
        this.products = ProductManager.readProductsFromFile();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n=== Hệ Thống Quản Lý Sản Phẩm ===");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị tất cả sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo mã");
            System.out.println("4. Thoát chương trình");
            System.out.print("Vui lòng chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    searchProductById();
                    break;
                case 4:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private void addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        String productId = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();

        Product newProduct = new Product(productId, productName, price, manufacturer, description);
        products.add(newProduct);
        ProductManager.writeProductsToFile(products);
        System.out.println("Sản phẩm đã được thêm thành công.");
    }

    private void displayAllProducts() {
        System.out.println("\n=== Danh Sách Sản Phẩm ===");
        if (products.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private void searchProductById() {
        System.out.print("Nhập mã sản phẩm cần tìm: ");
        String searchId = scanner.nextLine();

        Product foundProduct = null;
        for (Product product : products) {
            if (product.getProductId().equalsIgnoreCase(searchId)) {
                foundProduct = product;
                break;
            }
        }

        if (foundProduct == null) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + searchId);
        } else {
            System.out.println("Sản phẩm tìm thấy: " + foundProduct);
        }
    }

}
