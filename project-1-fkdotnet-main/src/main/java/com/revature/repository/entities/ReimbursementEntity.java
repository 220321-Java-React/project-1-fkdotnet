package com.revature.repository.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class ReimbursementEntity {
	private int ReimbursementID;
	private int ReimbursementStatus;
	private int ReimbursementType;
	private float ReimbursementAmount;
	private int ReimbursementAuthor;
	private int ReimbursementResolver;
	private String ReimbursementDescription;
	private LocalDateTime ReimbursementSubmittedTimestamp;
	private LocalDateTime ReimbursementResolvedTimestamp;
	
	public ReimbursementEntity() {
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(ReimbursementAmount, ReimbursementAuthor, ReimbursementDescription, ReimbursementID,
				ReimbursementResolvedTimestamp, ReimbursementResolver, ReimbursementStatus,
				ReimbursementSubmittedTimestamp, ReimbursementType);
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
		return Float.floatToIntBits(ReimbursementAmount) == Float.floatToIntBits(other.ReimbursementAmount)
				&& ReimbursementAuthor == other.ReimbursementAuthor
				&& Objects.equals(ReimbursementDescription, other.ReimbursementDescription)
				&& ReimbursementID == other.ReimbursementID
				&& Objects.equals(ReimbursementResolvedTimestamp, other.ReimbursementResolvedTimestamp)
				&& ReimbursementResolver == other.ReimbursementResolver
				&& ReimbursementStatus == other.ReimbursementStatus
				&& Objects.equals(ReimbursementSubmittedTimestamp, other.ReimbursementSubmittedTimestamp)
				&& ReimbursementType == other.ReimbursementType;
	}
	public ReimbursementEntity(int reimbursementID, int reimbursementStatus, int reimbursementType,
			float reimbursementAmount, int reimbursementAuthor, int reimbursementResolver,
			String reimbursementDescription, LocalDateTime reimbursementSubmittedTimestamp,
			LocalDateTime reimbursementResolvedTimestamp) {
		super();
		ReimbursementID = reimbursementID;
		ReimbursementStatus = reimbursementStatus;
		ReimbursementType = reimbursementType;
		ReimbursementAmount = reimbursementAmount;
		ReimbursementAuthor = reimbursementAuthor;
		ReimbursementResolver = reimbursementResolver;
		ReimbursementDescription = reimbursementDescription;
		ReimbursementSubmittedTimestamp = reimbursementSubmittedTimestamp;
		ReimbursementResolvedTimestamp = reimbursementResolvedTimestamp;
	}
	@Override
	public String toString() {
		return "ReimbursementEntity [ReimbursementID=" + ReimbursementID + ", ReimbursementStatus="
				+ ReimbursementStatus + ", ReimbursementType=" + ReimbursementType + ", ReimbursementAmount="
				+ ReimbursementAmount + ", ReimbursementAuthor=" + ReimbursementAuthor + ", ReimbursementResolver="
				+ ReimbursementResolver + ", ReimbursementDescription=" + ReimbursementDescription
				+ ", ReimbursementSubmittedTimestamp=" + ReimbursementSubmittedTimestamp
				+ ", ReimbursementResolvedTimestamp=" + ReimbursementResolvedTimestamp + "]";
	}
	public int getReimbursementID() {
		return ReimbursementID;
	}
	public void setReimbursementID(int reimbursementID) {
		ReimbursementID = reimbursementID;
	}
	public int getReimbursementStatus() {
		return ReimbursementStatus;
	}
	public void setReimbursementStatus(int reimbursementStatus) {
		ReimbursementStatus = reimbursementStatus;
	}
	public int getReimbursementType() {
		return ReimbursementType;
	}
	public void setReimbursementType(int reimbursementType) {
		ReimbursementType = reimbursementType;
	}
	public float getReimbursementAmount() {
		return ReimbursementAmount;
	}
	public void setReimbursementAmount(float reimbursementAmount) {
		ReimbursementAmount = reimbursementAmount;
	}
	public int getReimbursementAuthor() {
		return ReimbursementAuthor;
	}
	public void setReimbursementAuthor(int reimbursementAuthor) {
		ReimbursementAuthor = reimbursementAuthor;
	}
	public int getReimbursementResolver() {
		return ReimbursementResolver;
	}
	public void setReimbursementResolver(int reimbursementResolver) {
		ReimbursementResolver = reimbursementResolver;
	}
	public String getReimbursementDescription() {
		return ReimbursementDescription;
	}
	public void setReimbursementDescription(String reimbursementDescription) {
		ReimbursementDescription = reimbursementDescription;
	}
	public LocalDateTime getReimbursementSubmittedTimestamp() {
		return ReimbursementSubmittedTimestamp;
	}
	public void setReimbursementSubmittedTimestamp(LocalDateTime reimbursementSubmittedTimestamp) {
		ReimbursementSubmittedTimestamp = reimbursementSubmittedTimestamp;
	}
	public LocalDateTime getReimbursementResolvedTimestamp() {
		return ReimbursementResolvedTimestamp;
	}
	public void setReimbursementResolvedTimestamp(LocalDateTime reimbursementResolvedTimestamp) {
		ReimbursementResolvedTimestamp = reimbursementResolvedTimestamp;
	}


}
