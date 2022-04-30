package com.revature.repository.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class ReimbursementEntity {
	private int id;
	private int status_id;
	private int type_id;
	private float amount;
	private int author;
	private int resolver;
	private String description;
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	@Override
	public String toString() {
		return "ReimbursementEntity [id=" + id + ", status_id=" + status_id + ", type_id=" + type_id + ", amount="
				+ amount + ", author=" + author + ", resolver=" + resolver + ", description=" + description
				+ ", submitted=" + submitted + ", resolved=" + resolved + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getSubmitted() {
		return submitted;
	}
	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}
	public LocalDateTime getResolved() {
		return resolved;
	}
	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}
	public ReimbursementEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementEntity(int id, int status_id, int type_id, float amount, int author, int resolver,
			String description, LocalDateTime submitted, LocalDateTime resolved) {
		super();
		this.id = id;
		this.status_id = status_id;
		this.type_id = type_id;
		this.amount = amount;
		this.author = author;
		this.resolver = resolver;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
	}
	
	
	
	
}