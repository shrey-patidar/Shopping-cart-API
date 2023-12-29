package cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cart.entity.Categories;
import cart.entity.Products;
import cart.entity.SubCategories;
import cart.requestObjects.FilterObject;
import cart.service.ProductService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Products product) {
		productService.addProduct(product);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	
	@PostMapping("/products/deleteProduct")
	public ResponseEntity<?> deleteProduct(@RequestBody Products product){
		productService.deleteProduct(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/products/update")
	public ResponseEntity<?> updateProduct(@RequestBody Products product) {
		productService.updateProduct(product);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	
	@PostMapping("/category/add")
	public ResponseEntity<HttpStatus> addCategory(@RequestBody Categories category){
		;
		return productService.addCategory(category);
	}
	
	
	@PostMapping("/subcategory/add")
	public ResponseEntity<HttpStatus> addSubCategory(@RequestBody SubCategories subcategory){
		
		return productService.addSubCategory(subcategory);
	}
	
	@RequestMapping("products/allCategories")
	public ResponseEntity<?> allCategories(){
		return new ResponseEntity<>(productService.allCategories(),HttpStatus.OK);
	}
	
	@RequestMapping("products/allSubCategories")
	public ResponseEntity<?> allSubCategories(){
		return new ResponseEntity<>(productService.allSubCategories(),HttpStatus.OK);
	}
	
	
	@RequestMapping("products/allProducts")
	public ResponseEntity<?> allProducts(){
		return new ResponseEntity<>(productService.allProducts(),HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/products/getById/{productid}")
	public ResponseEntity<?> getProductById(@PathVariable Integer productid) {
		return new ResponseEntity<>(productService.getProductById(productid),HttpStatus.OK);
	}
	
	
	@RequestMapping("/products/{category}")
	public List<Products> getProductsByCategory(@PathVariable String category){
		return productService.getProductsByCategory(category);
	}
	
	
	@RequestMapping("/products/subcategory/{subcategory}")
	public ResponseEntity<?> getProductsBySubCategory(@PathVariable String subcategory){
		return new ResponseEntity<>(productService.getProductsBySubCategory(subcategory), HttpStatus.OK);
	}
	
	
	@RequestMapping("/products/search/{searchString}")
	public List<Products> getProductsBySearch(@PathVariable String searchString){
		return productService.getProductsBySearch(searchString);
	}
	
	@RequestMapping("/products/{category}/getFilteredProducts")
	public ResponseEntity<?> getFilteredProducts(@PathVariable String category, @RequestBody FilterObject filterObject){
		return new ResponseEntity<>(productService.getFilteredProducts(category,filterObject),HttpStatus.OK);
	}
}
