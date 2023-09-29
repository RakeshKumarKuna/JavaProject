package com.krk.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "shipment_type_tab")
public class ShipmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shp_id_col")
	private Integer id;
	@Column(name = "shp_mod_col")
	private String shipmentMode;
	@Column(name = "shp_code_col")
	private String shipmentCode;
	@Column(name = "shp_enable_shp_col")
	private String enableShipment;
	@Column(name = "shp_grade_col")
	private String shipmentGrade;
	@Column(name = "shp_desc_col")
	private String description;
}
