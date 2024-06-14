package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class OrderTable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private String orderStatus;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private UserTable client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	public OrderTable() {
		
	}

	public OrderTable(Long id, Instant moment, UserTable client, String status) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		this.orderStatus = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public UserTable getClient() {
		return client;
	}

	public void setClient(UserTable client) {
		this.client = client;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderTable other = (OrderTable) obj;
		return Objects.equals(id, other.id);
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public String getOrderStatus() {
		return orderStatus;
	}
	
	public Double getTotal() {
	    double sum = 0.0;
	    for(OrderItem x : items) {
	        sum += x.getSubTotal(); 
	    }
	    return sum;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
