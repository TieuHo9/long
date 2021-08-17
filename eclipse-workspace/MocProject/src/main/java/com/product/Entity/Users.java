package com.product.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.product.Entity.Dto.UsersDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class Users implements Serializable{
@Getter
@Setter
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long  id; 
		
		@Column(name = "name")
		private String username;
		
		@Column(name = "pass")
		private String password;
		
		@Column(name = "phone")
		private int phone;
		
		@Column(name= "address")
		private String address;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "role")
		private String role;
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		@JoinColumn(name = "user_id")
		
		private List<Orders> orders = new ArrayList<>();
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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

		public String getEmail() {
			return email;
		}

		public List<Orders> getOrders() {
			return orders;
		}

		public void setOrders(List<Orders> orders) {
			this.orders = orders;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
		
/*		@Override
		public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			if(!(o instanceof User))
				return false;
			User users = (User) o;
			return Objects.equals (this.id,users.id) && Objects.equals(this.username, users.username) && Objects.equals(this.password, users.password)
					&& Objects.equals(this.address,users.address) && Objects.equals(this.phone, users.phone) && Objects.equals(this.email, users.email)
					&& Objects.equals(this.role, users.role);
		}
		@Override
		public int hashCode() {
			return Objects.hash(this.id, this.username, this.password, this.address, this.phone, this.email, this.role);
		}
		@Override
		public String toString() {
			return "Order{" + "id=" + this.id + ", username='" + this.username + '\'' +",password='"+ this.password + '\'' + ",address='"+this.address+'\''+ ",phone='"+this.phone
					+'\''+",email='"+this.email+'\''+", role='"+this.role +'\''+'}';
		}*/

		public static Users from(UsersDto usersDto) {
			Users user = new Users();
			user.setUsername(usersDto.getUsername());
			user.setPassword(usersDto.getPassword());
			user.setAddress(usersDto.getAddress());
			user.setPhone(usersDto.getPhone());
			user.setEmail(usersDto.getEmail());
			user.setRole(usersDto.getRole());
			return user;
		}
		
		public void addOrder(Orders orders) {
			
		}
		
		public void removeOrder(Orders orders) {
			
		}
		
}
