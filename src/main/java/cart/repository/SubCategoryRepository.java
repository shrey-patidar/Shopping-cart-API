package cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cart.entity.Categories;
import cart.entity.SubCategories;

public interface SubCategoryRepository extends JpaRepository<SubCategories, Integer> {
	SubCategories findBySubcategoryIgnoreCase(String subcategory);

}
