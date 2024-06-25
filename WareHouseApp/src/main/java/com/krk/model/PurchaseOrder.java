package com.krk.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column(name = "orderCode")
	private String orderCode;
	@ManyToOne
	@JoinColumn(name = "ship_id_fk_col")
	private ShipmentType shipmentType;
	@ManyToOne
	@JoinColumn(name="whuser_id_fk_col")
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
