package com.krk.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_dtl_tab")
@Data
public class PurchaseDtl {
	@Id
	@Column(name = "po_col_dtl_id")
	@GeneratedValue
	private Integer id;
	@Column(name = "po_col_dtl_qty")
	private Integer qty;
	@ManyToOne
	@JoinColumn(name = "po_id_fk_col")
	private Part part;
	@ManyToOne
	@JoinColumn(name = "pu_id_fk_col")
	private PurchaseOrder order;
}
