package com.educandoweb.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.educandoweb.course.entities.OrderTable;
import com.educandoweb.course.entities.ProductTable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK implements Serializable{
	
	private static final long serialVersionUID = 2303558326099208900L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderTable order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductTable product;

	public OrderTable getOrder() {
		return order;
	}

	public void setOrder(OrderTable order) {
		this.order = order;
	}

	public ProductTable getProduct() {
		return product;
	}

	public void setProduct(ProductTable product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}

}
