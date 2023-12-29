package cart.requestObjects;

public class FilterObject {
	private int minPrice;
	private int maxPrice;
	public FilterObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilterObject(int minPrice, int maxPrice) {
		super();
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	
	
}
