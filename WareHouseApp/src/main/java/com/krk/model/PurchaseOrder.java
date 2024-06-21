package com.krk.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Table(name = "Purchase_Order")
@Entity
@Data
public class PurchaseOrder {
	@Column(name = "orderId")
	@Id
	@GeneratedValue	
	private int orderId;
	@Column(name="orderCode")
	private String orderCode;
	  @Transient
	  @ElementCollection(targetClass = ShipmentType.class)
	  @ManyToOne(cascade = CascadeType.ALL) 
	  private ShipmentType shimpmentType;
	  @Transient
	  @ElementCollection(targetClass = WhUserType.class)
	  @ManyToOne(cascade = CascadeType.ALL) 
	  private WhUserType whuserType;
	@Column(name = "ref_num")
	private String refernceNumber;
	@Column(name = "qulaity_check")
	private String qualityCheck;
	@Column(name = "status")
	private String status;
	@Column(name = "descripition")
	private String description;
}
