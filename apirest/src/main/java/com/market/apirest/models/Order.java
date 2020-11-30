package com.market.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "order_status", nullable=false, length = 50 )
	private String status;
	
	 @OneToMany(targetEntity = Item.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 private List<Item> items;
	
	@ManyToOne(targetEntity = Consumer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Consumer consumer;
	
	@OneToOne(targetEntity = Payment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Payment payment;
	
	@ManyToOne(targetEntity = Delivery.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Delivery delivery;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}


	
}
