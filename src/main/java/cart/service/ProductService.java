package cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cart.entity.Categories;
import cart.entity.Products;
import cart.entity.SubCategories;
import cart.repository.CategoryRepository;
import cart.repository.ProductRepository;
import cart.repository.SubCategoryRepository;
import cart.requestObjects.FilterObject;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	
	public void addProduct(Products product) {
		productRepository.save(product);	
	}
	
	public void deleteProduct(Products product) {
		productRepository.delete(product);
	}
	
	
	public void updateProduct(Products product) {
		productRepository.save(product);	
	}
	
	
	public List<Products> allProducts() {
		return productRepository.findAll();
	}
	
	
	public ResponseEntity<HttpStatus> addCategory(Categories category) {
		if(categoryRepository.findByCategoryIgnoreCase(category.getCategory())!=null) {
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		else {
			categoryRepository.save(category);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
	
	
	public ResponseEntity<HttpStatus> addSubCategory(SubCategories subcategory) {
		
		if(subCategoryRepository.findBySubcategoryIgnoreCase(subcategory.getSubcategory())!=null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
			}
			else {
				subCategoryRepository.save(subcategory);
				return new ResponseEntity<>(HttpStatus.OK);
			}
	}
	

	public Optional<Products> getProductById(Integer productid) {
		return productRepository.findById(productid);
	}

	
	public List<Products> getProductsByCategory(String category) {

		return productRepository.findAllByCategory_category(category);
	}
	
	
	public List<Products> getProductsBySubCategory(String subcategory) {
		
		return productRepository.findAllBySubcategory_subcategory(subcategory);
	}
	
	
	
	public List<Products> getProductsBySearch(String searchString){

		
		List<Products> searchList= productRepository.findAll()
				.stream().filter(
						p -> (p.getCategory().getCategory()+p.getDetails()+p.getName())
								.toLowerCase().contains(searchString.toLowerCase()) )
										.collect(Collectors.toList());
		return searchList;
	}

	

	public List<Products> getFilteredProducts(String category, FilterObject filterObject) {
		List<Products> filteredList=new ArrayList<>(); 
		
		int min=filterObject.getMinPrice();
		int max=filterObject.getMaxPrice();
		
		if(max - min >0) {	
		filteredList =	getProductsByCategory(category).stream().filter
							(product ->  product.getPrice()>=min
									&& product.getPrice()<=max)
					.collect(Collectors.toList());
			return filteredList;
		}
		
		else if (min>0) {
			filteredList =	getProductsByCategory(category).stream().filter
					(product ->  product.getPrice()>=min)
			.collect(Collectors.toList());
	return filteredList;
		}
		
		else if (max>0) {
			filteredList =	getProductsByCategory(category).stream().filter
					(product ->  product.getPrice()<=max)
			.collect(Collectors.toList());
	return filteredList;
		}
		
		
		else {
			filteredList =	getProductsByCategory(category);
			return filteredList;
		}
				
	}

	public List<Categories> allCategories() {
		return categoryRepository.findAll();
	}

	public List<SubCategories> allSubCategories() {
		return subCategoryRepository.findAll();
	}


	

	

	
}
