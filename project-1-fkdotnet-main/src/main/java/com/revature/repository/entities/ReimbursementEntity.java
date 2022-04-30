package com.revature.repository.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class ReimbursementEntity {
	private int reimb_id;
	private int reimb_status_id;
	private int reimb_type_id;
	private float reimb_amount;
	private int reimb_author;
	private int reimb_resolver;
	private String reimb_description;
	private LocalDateTime reimb_submitted;
	private LocalDateTime reimb_resolved;
	@Override
	public String toString() {
		return "ReimbursementEntity [reimb_id=" + reimb_id + ", reimb_status_id=" + reimb_status_id + ", reimb_type_id="
				+ reimb_type_id + ", reimb_amount=" + reimb_amount + ", reimb_author=" + reimb_author
				+ ", reimb_resolver=" + reimb_resolver + ", reimb_description=" + reimb_description
				+ ", reimb_submitted=" + reimb_submitted + ", reimb_resolved=" + reimb_resolved + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(reimb_amount, reimb_author, reimb_description, reimb_id, reimb_resolved, reimb_resolver,
				reimb_status_id, reimb_submitted, reimb_type_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementEntity other = (ReimbursementEntity) obj;
		return Float.floatToIntBits(reimb_amount) == Float.floatToIntBits(other.reimb_amount)
				&& reimb_author == other.reimb_author && Objects.equals(reimb_description, other.reimb_description)
				&& reimb_id == other.reimb_id && Objects.equals(reimb_resolved, other.reimb_resolved)
				&& reimb_resolver == other.reimb_resolver && reimb_status_id == other.reimb_status_id
				&& Objects.equals(reimb_submitted, other.reimb_submitted) && reimb_type_id == other.reimb_type_id;
	}
	public ReimbursementEntity() {
		super();
	}
	public ReimbursementEntity(int reimb_id, int reimb_status_id, int reimb_type_id, float reimb_amount,
			int reimb_author, int reimb_resolver, String reimb_description, LocalDateTime reimb_submitted,
			LocalDateTime reimb_resolved) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
		this.reimb_amount = reimb_amount;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_description = reimb_description;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
	}
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	public int getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}
	public float getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(float reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public int getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}
	public int getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public LocalDateTime getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(LocalDateTime reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public LocalDateTime getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(LocalDateTime reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	
}
