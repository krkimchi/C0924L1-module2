package ss5_static.bai_tap.quan_ly_san_pham;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Thêm sản phẩm thành công: " + product);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.get(i).setName(product.getName());
                products.get(i).setPrice(product.getPrice());
                System.out.println("Cập nhật sản phẩm thành công: " + products.get(i));
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với ID: " + product.getId());
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                System.out.println("Xóa sản phẩm thành công: " + products.get(i));
                products.remove(i);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với ID: " + id);
    }
}
