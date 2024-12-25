package s12_set_map.service;

import s12_set_map.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductService implements IProductService {
    private List<Product> productList = new LinkedList<>();

    public ProductService() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Laptop", 1500.0));
        productList.add(new Product(2, "Smartphone", 800.0));
        productList.add(new Product(3, "Tablet", 600.0));
    }

    @Override
    public void addProduct(Product product) {
        this.productList.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    public boolean updateProduct(Product updatedProduct) {
        for (Product product : productList) {
            if (product.getId() == updatedProduct.getId()) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void sortProductsByPriceAscending() {
        productList.sort(Comparator.comparingDouble(Product::getPrice));
    }

    @Override
    public void sortProductsByPriceDescending() {
        productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }


}
