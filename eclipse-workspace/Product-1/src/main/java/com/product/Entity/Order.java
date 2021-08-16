package com.product.Entity;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  id; 
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "phone")
	private int phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "total_price")
	private int total;
	
	@Column(name = "shpping_price")
	private int ship;
	
	@Column(name = "final_price")
	private int finalprice;
	
	@Column(name = "status")
	private String Status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getShip() {
		return ship;
	}

	public void setShip(int ship) {
		this.ship = ship;
	}

	public int getFinalprice() {
		return finalprice;
	}

	public void setFinalprice(int finalprice) {
		this.finalprice = finalprice;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Order))
			return false;
		Order order = (Order) o;
		return Objects.equals (this.id,order.id) && Objects.equals(this.user_id, order.user_id) && Objects.equals(this.time, order.time)
				&& Objects.equals(this.address, order.address) && Objects.equals(this.phone, order.phone) && Objects.equals(this.total, order.total)
				&& Objects.equals(this.ship, order.ship) && Objects.equals(this.finalprice, order.finalprice) && Objects.equals(this.Status, order.Status);
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.user_id, this.time, this.address, this.phone, this.total, this.ship, this.finalprice, this.Status);
	}
	@Override
	public String toString() {
		return "Order{" + "id=" + this.id + ", user_id='" + this.user_id + '\'' +",time='"+ this.time + '\'' + ",address='"+this.address+'\''+ ",phone='"+this.phone
				+'\''+",total='"+this.total+'\''+", ship='"+this.ship+'\''+",finalprice='"+this.finalprice+'\''+",status='"+this.Status +'\''+'}';
	}
}
