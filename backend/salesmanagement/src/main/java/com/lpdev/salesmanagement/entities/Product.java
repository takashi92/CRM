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
@Table(name = "product", catalog = "sales_management")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Brand brand;
	private Category category;
	private String name;
	private String note;
	private Long created;
	private Long updated;
	private Set<ProductDetail> productDetails = new HashSet<ProductDetail>(0);
	private Set<Image> images = new HashSet<Image>(0);
	private Storage storage;
	private Set<Supply> supplies = new HashSet<Supply>(0);
	private Set<BillDetail> billDetails = new HashSet<BillDetail>(0);

	public Product() {
	}

	public Product(Brand brand, Category category, String name, String note, Long created, Long updated,
			Set<ProductDetail> productDetails, Set<Image> images, Storage storage, Set<Supply> supplies,
			Set<BillDetail> billDetails) {
		this.brand = brand;
		this.category = category;
		this.name = name;
		this.note = note;
		this.created = created;
		this.updated = updated;
		this.productDetails = productDetails;
		this.images = images;
		this.storage = storage;
		this.supplies = supplies;
		this.billDetails = billDetails;
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
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
	public Storage getStorage() {
		return this.storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Supply> getSupplies() {
		return this.supplies;
	}

	public void setSupplies(Set<Supply> supplies) {
		this.supplies = supplies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<BillDetail> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(Set<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

}
