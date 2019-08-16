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
import javax.persistence.Table;

@Entity
@Table(name = "categories", catalog = "sales_management")
public class Categories implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Categories categories;
	private String name;
	private String note;
	private Long created;
	private Long updated;
	private Set<Categories> categorieses = new HashSet<Categories>(0);
	private Set<Products> productses = new HashSet<Products>(0);
	private Set<Properties> propertieses = new HashSet<Properties>(0);

	public Categories() {
	}

	public Categories(Categories categories, String name, String note, Long created, Long updated,
			Set<Categories> categorieses, Set<Products> productses, Set<Properties> propertieses) {
		this.categories = categories;
		this.name = name;
		this.note = note;
		this.created = created;
		this.updated = updated;
		this.categorieses = categorieses;
		this.productses = productses;
		this.propertieses = propertieses;
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
	@JoinColumn(name = "parent_id")
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Categories> getCategorieses() {
		return this.categorieses;
	}

	public void setCategorieses(Set<Categories> categorieses) {
		this.categorieses = categorieses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Products> getProductses() {
		return this.productses;
	}

	public void setProductses(Set<Products> productses) {
		this.productses = productses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Properties> getPropertieses() {
		return this.propertieses;
	}

	public void setPropertieses(Set<Properties> propertieses) {
		this.propertieses = propertieses;
	}

}
