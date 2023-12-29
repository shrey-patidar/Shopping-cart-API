package cart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;
	private String name;
	private int price;
	private String details;
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Categories category;
	
	@ManyToMany
	@JoinTable(
			name = "product_subCat",
			joinColumns = @JoinColumn(name = "productId"),
			inverseJoinColumns = @JoinColumn(name = "subcategoryId"))	
	private List<SubCategories> subcategory;

	
	
	
	
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int productid, String name, int price, String details, String image, Categories category,
			List<SubCategories> subcategory) {
		super();
		this.productid = productid;
		this.name = name;
		this.price = price;
		this.details = details;
		this.image = image;
		this.category = category;
		this.subcategory = subcategory;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public List<SubCategories> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(List<SubCategories> subcategory) {
		this.subcategory = subcategory;
	}

	
	
	
}
