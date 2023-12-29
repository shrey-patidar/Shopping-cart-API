package cart.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import cart.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	List<Products> findAllByCategory_category(String category);
	Products findById(int Id);
	List<Products> findAllBySubcategory_subcategory(String subcategory);
}
