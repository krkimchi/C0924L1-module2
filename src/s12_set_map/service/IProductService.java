package s12_set_map.service;

import s12_set_map.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    List<Product> getAllProducts();
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    Product getProductById(int id);
    void sortProductsByPriceAscending();
    void sortProductsByPriceDescending();
    List<Product> searchProductByName(String name);

}
