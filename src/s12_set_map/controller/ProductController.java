package s12_set_map.controller;

import s12_set_map.service.ProductService;
import s12_set_map.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private ProductService productService;
    private Scanner scanner;

    public ProductController() {
        this.productService = new ProductService();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n----- Quản lý sản phẩm -----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Product newProduct = inputProductData();
                    productService.addProduct(newProduct);
                    System.out.println("Thêm sản phẩm thành công!");
                    break;
                case 2:
                    List<Product> products = productService.getAllProducts();
                    displayProducts(products);
                    break;
                case 3:
                    int updateId = inputProductId("Nhập ID sản phẩm cần cập nhật: ");
                    Product existingProduct = productService.getProductById(updateId);
                    if (existingProduct != null) {
                        Product updatedProduct = inputProductData();
                        updatedProduct.setId(updateId);
                        productService.updateProduct(updatedProduct);
                        System.out.println("Cập nhật sản phẩm thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm với ID = " + updateId);
                    }
                    break;
                case 4:
                    int deleteId = inputProductId("Nhập ID sản phẩm cần xóa: ");
                    if (productService.deleteProduct(deleteId)) {
                        System.out.println("Xóa sản phẩm thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm với ID = " + deleteId);
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String searchName = scanner.nextLine();
                    List<Product> foundProducts = productService.searchProductByName(searchName);
                    displayProducts(foundProducts);
                    break;
                case 6:
                    productService.sortProductsByPriceAscending();
                    System.out.println("Danh sách sản phẩm đã được sắp xếp tăng dần theo giá.");
                    displayProducts(productService.getAllProducts());
                    break;
                case 7:
                    productService.sortProductsByPriceDescending();
                    System.out.println("Danh sách sản phẩm đã được sắp xếp giảm dần theo giá.");
                    displayProducts(productService.getAllProducts());
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 8);
    }

    private Product inputProductData() {
        String name;
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            name = scanner.nextLine().trim();
            if (!name.isEmpty() && name.length() <= 50) {
                break;
            } else {
                System.out.println("Tên sản phẩm không được để trống và không dài hơn 50 ký tự.");
            }
        }

        double price;
        while (true) {
            try {
                System.out.print("Nhập giá sản phẩm: ");
                price = Double.parseDouble(scanner.nextLine());
                if (price > 0) {
                    break;
                } else {
                    System.out.println("Giá sản phẩm không hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập một số.");
            }
        }

        return new Product(0, name, price);
    }

    private int inputProductId(String message) {
        while (true) {
            try {
                System.out.print(message);
                int id = Integer.parseInt(scanner.nextLine());
                if (id > 0) {
                    return id;
                } else {
                    System.out.println("ID phải là số nguyên.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    private void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
