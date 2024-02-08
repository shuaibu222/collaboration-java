package org.shuaibu.collaboration_java.products;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    public final ProductsRepoInterface PRODUCT_REPO_INTERFACE;

    public ProductsController(ProductsRepoInterface productsRepoInterface) {
        this.PRODUCT_REPO_INTERFACE = productsRepoInterface;
    }

    // record here for storing the data
    record Request( String name){}

    @GetMapping("/")
    public String greeting(){
        return "Hello,  Coders";
    }

    // Get all products
    @GetMapping("/api/v1/products")
    public List<ProductsModel> getAllProducts() { return PRODUCT_REPO_INTERFACE.findAll(); }

    // Get product by its id
    @GetMapping("/api/v1/products/{id}")
    public Optional<ProductsModel> getById(@PathVariable Integer id){
        return PRODUCT_REPO_INTERFACE.findById(id);
    }

    //  Create a new products
    @PostMapping("/api/v1/products")
    public ProductsModel createProduct (@RequestBody @Valid ProductsModel product) {
        return PRODUCT_REPO_INTERFACE.save(product);
    }

    // Update an existing product
    @PutMapping("/api/v1/products/{id}")
    public ProductsModel updateProduct(@PathVariable Integer id, @RequestBody Request request){
        return PRODUCT_REPO_INTERFACE.findById(id)
                .map(targetProduct -> {
                    targetProduct.setName(request.name());
                    return PRODUCT_REPO_INTERFACE.save(targetProduct);
                }).orElseThrow(() -> new EntityNotFoundException());
    }

    // Delete a product by its id
    @DeleteMapping("/api/v1/products/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        PRODUCT_REPO_INTERFACE.deleteById(id);
        return "Deleted Successfully";
    }


}

