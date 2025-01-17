package com.silaev.wms.dao;

import com.silaev.wms.entity.Product;
import com.silaev.wms.model.Brand;
import com.silaev.wms.model.ProductArticleSizeDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.math.BigInteger;
import java.util.Collection;

@Repository
public interface ProductDao extends ReactiveMongoRepository<Product, String> {
  Flux<Product> findByNameOrBrand(String name, Brand brand);

  Flux<Product> findAllByOrderByQuantityAsc();

  Flux<Product> findAllByQuantityIsLessThanEqualOrderByQuantityAsc(BigInteger lastSize);

  Flux<ProductArticleSizeDto> findByArticleIn(Collection<Long> articles);
}
