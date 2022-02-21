package com.customer.customerService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	private String doorNo;
	private String streetName;
	private String landmark;
	private String city;
	private String pincode;
	@OneToOne
	@JoinColumn(name="customerId")
	@JsonBackReference
	private Customer customer;
}
