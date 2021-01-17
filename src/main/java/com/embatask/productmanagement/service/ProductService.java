package com.embatask.productmanagement.service;
import com.embatask.productmanagement.domain.Category;
import com.embatask.productmanagement.domain.Product;
import com.embatask.productmanagement.repository.CategoryRepository;
import com.embatask.productmanagement.repository.ProductRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final static Logger logger = LogManager.getLogger(Product.class);
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        Category newCategory = categoryRepository.save(product.getCategory());
        product.getCategory().setCategoryID(newCategory.getCategoryID());
        Product newProduct = productRepository.save(product);
        return product;
    }

    public Product updateProduct(Product product){
        Optional<Product>optionalProduct = productRepository.findById(product.getProductID());
        Product product1 = null;
        if (optionalProduct.isPresent()){
           productRepository.save(product);
        }
        return product1;
    }

    public Product getProductById(int id){
        Optional<Product>optionalProduct = productRepository.findById(id);
        Product product = null;
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();
        }
        return  product;
    }

    public void deleteProduct(int id){
        Optional<Product>optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            productRepository.deleteById(id);
        }
    }

    public List<Product> getAll(){
        List<Product>productList = new ArrayList<>();
        Iterable<Product>productIterable = productRepository.findAll();
        productIterable.forEach(productList::add);
        return productList;
    }
}
