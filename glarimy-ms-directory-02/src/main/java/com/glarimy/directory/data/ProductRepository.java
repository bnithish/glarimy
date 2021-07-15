package com.glarimy.directory.data;

import com.glarimy.directory.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Repository
@EnableSwagger2
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByName(String name);

    List<Product> findAllByName(String name);

    int deleteAllByName(String name);
}
