package dailybread.bean;

import java.sql.Timestamp;

public class BreadDataBean {
	
	private int breadId;
	private String breadName;
	private String imageUrl;
	private int price;
	private int createdCount;
	private String ingredient;
	private int remains;
	private Timestamp createdDate;
	
	public int getBreadId() {
		return breadId;
	}
	public void setBreadId(int breadId) {
		this.breadId = breadId;
	}
	public String getBreadName() {
		return breadName;
	}
	public void setBreadName(String breadName) {
		this.breadName = breadName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCreatedCount() {
		return createdCount;
	}
	public void setCreatedCount(int createdCount) {
		this.createdCount = createdCount;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public int getRemains() {
		return remains;
	}
	public void setRemains(int remains) {
		this.remains = remains;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
}
