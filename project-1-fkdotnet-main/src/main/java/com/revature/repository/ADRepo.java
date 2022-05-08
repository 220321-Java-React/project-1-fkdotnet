package com.revature.repository;

public class ADRepo {
	private int resolver;
	private int reimb_id;
	public ADRepo(int resolver, int reimb_id) {
		super();
		this.resolver = resolver;
		this.reimb_id = reimb_id;
	}
	public ADRepo() {
		// TODO Auto-generated constructor stub
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

}
