package com.lpdev.salesmanagement.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "property", catalog = "sales_management")
public class Property implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String code;
	private String name;
	private String note;
	private Long created;
	private Long updated;
	private Set<ProductDetail> productDetails = new HashSet<ProductDetail>(0);

	public Property() {
	}

	public Property(String code, String name, String note, Long created, Long updated,
			Set<ProductDetail> productDetails) {
		this.code = code;
		this.name = name;
		this.note = note;
		this.created = created;
		this.updated = updated;
		this.productDetails = productDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "code")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "created")
	public Long getCreated() {
		return this.created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	@Column(name = "updated")
	public Long getUpdated() {
		return this.updated;
	}

	public void setUpdated(Long updated) {
		this.updated = updated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "property")
	public Set<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

}
