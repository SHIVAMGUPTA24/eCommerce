package com.customer.customerService.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Customer {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String customerEmail;
	@OneToOne(mappedBy ="customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private ShippingAddress shippingAddress;
	@OneToOne(mappedBy ="customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private BillingAddress billingAddress;

}

/*
insert into BILLING_ADDRESS values(1,'Agra','52','Tej','282005','Tej Nagar',101);
insert into SHIPPING_ADDRESS values(1,'Agra','52','Kamla','282005','Kamla Nagar',101);
insert into CUSTOMER values(101,'abc@gmail.com','abc');
{
    "customerId": 101,
    "customerName": "abc",
    "customerEmail": "abc@gmail.com",
    "shippingAddress": {
        "doorNo": "52",
        "streetName": "Kamla Nagar",
        "landmark": "Kamla",
        "city": "Agra",
        "pincode": "282005",
        "sid": 1
    },
    "billingAddress": {
        "doorNo": "52",
        "streetName": "Tej Nagar",
        "landmark": "Tej",
        "city": "Agra",
        "pincode": "282005",
        "bid": 1
    }
}
 */ 
