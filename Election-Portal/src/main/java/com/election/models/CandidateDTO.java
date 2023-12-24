package com.election.models;

public class CandidateDTO extends Response{
	private String condidateName;
	private int count;
	
	public String getCondidateName() {
		return condidateName;
	}
	public void setCondidateName(String condidateName) {
		this.condidateName = condidateName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
