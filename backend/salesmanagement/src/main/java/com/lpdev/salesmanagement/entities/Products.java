package com.lpdev.salesmanagement.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products", catalog = "sales_management")
public class Products implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Brand brand;
	private Categories categories;
	private String images;
	private String name;
	private String code;
	private String barCode;
	private String properties;
	private String note;
	private Long created;
	private Long updated;
	private Set<BillDetails> billDetailses = new HashSet<BillDetails>(0);
	private Storage storage;
	private Set<Supply> supplies = new HashSet<Supply>(0);

	public Products() {
	}

	public Products(Brand brand, Categories categories, String images, String name, String code, String barCode,
			String properties, String note, Long created, Long updated, Set<BillDetails> billDetailses, Storage storage,
			Set<Supply> supplies) {
		this.brand = brand;
		this.categories = categories;
		this.images = images;
		this.name = name;
		this.code = code;
		this.barCode = barCode;
		this.properties = properties;
		this.note = note;
		this.created = created;
		this.updated = updated;
		this.billDetailses = billDetailses;
		this.storage = storage;
		this.supplies = supplies;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@Column(name = "images")
	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "bar_code")
	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Column(name = "properties")
	public String getProperties() {
		return this.properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<BillDetails> getBillDetailses() {
		return this.billDetailses;
	}

	public void setBillDetailses(Set<BillDetails> billDetailses) {
		this.billDetailses = billDetailses;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "products")
	public Storage getStorage() {
		return this.storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Supply> getSupplies() {
		return this.supplies;
	}

	public void setSupplies(Set<Supply> supplies) {
		this.supplies = supplies;
	}

}
