package com.product.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")

public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  id; 
	
	@Column(name = "name")
	private String name;

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
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Branch))
			return false;
		Branch branch = (Branch) o;
		return Objects.equals (this.id,branch.id) && Objects.equals(this.name, branch.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}
	@Override
	public String toString() {
		return "Products{" + "id=" + this.id + ", name='" + this.name  +'\''+'}';
	}
}
