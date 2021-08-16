package com.product.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  id; 

	@Column( name = "name")
	private String name;
	
	@Column( name = "price")
	private int price;
	
	@Column( name = "brand_id")//collection
	private String brand_id;
	
	//@Column( name = "category_id")
	//private int cate_id;
	
	
	@Column( name = "status")
	private String status;
	
	@Column( name = "size")
	private int size;
	
	@Column( name = "color")
	private String color;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Products))
			return false;
		Products products = (Products) o;
		return Objects.equals (this.id,products.id) && Objects.equals(this.name, products.name)
				&& Objects.equals(this.brand_id, products.brand_id) &&  Objects.equals(this.color, products.color)
				&& Objects.equals(this.price, products.price) && Objects.equals(this.size, products.size) && Objects.equals(this.status, products.status);
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.color, this.brand_id, this.name
				, this.price, this.size, this.status);
	}
	@Override
	public String toString() {
		return "Products{" + "id=" + this.id + ", name='" + this.name + '\'' +", brand_id='"+ this.brand_id +  '\'' + ", color='" +this.color + '\''+ ", price='" +this.price+'\''+
				",size='" + this.size + ", status='" +this.status +'\''+'}';
	}
}
