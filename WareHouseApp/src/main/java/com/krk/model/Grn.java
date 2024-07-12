package com.krk.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "Grn_tab")
@Entity
@Data
public class Grn {
	@Id
	@GeneratedValue
	private Integer id;
	private String code;
	private String Discription;
	@ManyToOne
	@JoinColumn(name="grn_fk_order_col",unique = true)
    private PurchaseOrder pc;
}
