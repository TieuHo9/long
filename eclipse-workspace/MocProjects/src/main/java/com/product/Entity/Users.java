package com.product.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class Users  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Getter
@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
