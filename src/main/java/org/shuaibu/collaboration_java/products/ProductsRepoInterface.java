package org.shuaibu.collaboration_java.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepoInterface
        extends JpaRepository<ProductsModel, Integer> {
}