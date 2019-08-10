package com.lpdev.salesmanagement.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "bills", catalog = "sales_management")
@Proxy(lazy = false)
public class Bills implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Customers customers;
	private String note;
	private Date created;
	private Date updated;
	private Set<BillDetails> billDetailses = new HashSet<BillDetails>(0);

	public Bills() {
	}

	public Bills(Date created, Date updated) {
		this.created = created;
		this.updated = updated;
	}

	public Bills(Customers customers, String note, Date created, Date updated, Set<BillDetails> billDetailses) {
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = false, length = 19)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
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
