package com.example.catalog.repository;


import com.example.catalog.entity.Product;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;


@Transactional
public interface ProductRepository  extends  CrudRepository<Product,Long>{

}
