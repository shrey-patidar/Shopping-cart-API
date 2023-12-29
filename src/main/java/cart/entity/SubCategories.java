package cart.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCategoryId;
	
	@Column(unique = true)
	private String subcategory;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "subcategory")
	private List<Products> products;

	
	
	
	
	
	public SubCategories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubCategories(int subCategoryId, String subcategory, List<Products> products) {
		super();
		this.subCategoryId = subCategoryId;
		this.subcategory = subcategory;
		this.products = products;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	
	
}
