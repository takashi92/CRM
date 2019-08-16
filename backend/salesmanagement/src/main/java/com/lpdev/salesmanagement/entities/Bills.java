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
@Table(name = "bills", catalog = "sales_management")
public class Bills implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Customers customers;
	private String note;
	private Long created;
	private Long updated;
	private Set<BillDetails> billDetailses = new HashSet<BillDetails>(0);

	public Bills() {
	}

	public Bills(Customers customers, String note, Long created, Long updated, Set<BillDetails> billDetailses) {
		this.customers = customers;
		this.note = note;
		this.created = created;
		this.updated = updated;
		this.billDetailses = billDetailses;
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
	@JoinColumn(name = "customer_id")
	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bills")
	public Set<BillDetails> getBillDetailses() {
		return this.billDetailses;
	}

	public void setBillDetailses(Set<BillDetails> billDetailses) {
		this.billDetailses = billDetailses;
	}

}
