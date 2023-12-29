package cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cart.entity.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {
	Categories findByCategoryIgnoreCase(String category);
}
