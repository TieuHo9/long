	package com.product.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.product.Entity.Dto.OrdersDto;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "orders")
public class Orders implements Serializable{
@Getter
@Setter
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long  id; 
		
		@Column(name = "phone")
		private int phone;
		
		@Column(name = "address")
		private String address;
		
		@Column(name = "time")
		private LocalDate time;
		
		@Column(name = "total_price")
		private int total;
		
		@Column(name = "shipping_price")
		private int ship;
		
		@Column(name = "final_price")
		private int finalprice;
		
		@Column(name = "status")
		private String Status;
		
		@ManyToOne
		private Users user;
	
		
		
		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

//		public int getUser_id() {
//			return user_id;
//		}
//
//		public void setUser_id(int user_id) {
//			this.user_id = user_id;
//		}

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

		public LocalDate getTime() {
			return time;
		}

		public void setTime(LocalDate time) {
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
		
/*		@Override
		public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			if(!(o instanceof Order))
				return false;
			Order orders = (Order) o;
			return Objects.equals (this.id,orders.id) && Objects.equals(this.user_id, orders.user_id) && Objects.equals(this.time, orders.time)
					&& Objects.equals(this.address, orders.address) && Objects.equals(this.phone, orders.phone) && Objects.equals(this.total, orders.total)
					&& Objects.equals(this.ship, orders.ship) && Objects.equals(this.finalprice, orders.finalprice) && Objects.equals(this.Status, orders.Status);
		}
		@Override
		public int hashCode() {
			return Objects.hash(this.id, this.user_id, this.time, this.address, this.phone, this.total, this.ship, this.finalprice, this.Status);
		}
		@Override
		public String toString() {
			return "Order{" + "id=" + this.id + ", user_id='" + this.user_id + '\'' +",time='"+ this.time + '\'' + ",address='"+this.address+'\''+ ",phone='"+this.phone
					+'\''+",total='"+this.total+'\''+", ship='"+this.ship+'\''+",finalprice='"+this.finalprice+'\''+",status='"+this.Status +'\''+'}';
		}*/
		public static Orders from(OrdersDto ordersDto) {
			Orders orders = new Orders();
			orders.setAddress(ordersDto.getAddress());
			orders.setPhone(ordersDto.getPhone());
			orders.setShip(ordersDto.getShip());
			orders.setStatus(ordersDto.getStatus());
			orders.setTime(ordersDto.getTime());
			orders.setTotal(ordersDto.getTotal());
			orders.setFinalprice(ordersDto.getFinalprice());
			return orders;
		}
}
