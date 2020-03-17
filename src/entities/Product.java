package entities;

public class Product {
	private String name;
	private Double price;
	private Integer amount;
	private Double total;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product(String name, Double price, Integer amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.total = price * amount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	@Override
	public String toString() {
		
		return name +","+String.format("%.2f", total);
	}
}
