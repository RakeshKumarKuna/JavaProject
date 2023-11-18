package com.krk.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="docs_tab")
public class Document {
	@Id
	//@GeneratedValue
	@Column(name="doc_id")
	private Integer docId;
	@Column(name="doc_name")
	private String docName;
	@Column(name="doc_data")
	@Lob // byte[] + @Lob   = BLOB
	private byte[] docData;
		
}
