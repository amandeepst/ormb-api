package com.worldpay.servicing.model.entity;

import java.util.List;

public class SRV131Json {

	private String partyId;
	private List<String> children;

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public List<String> getChildren() {
		return children;
	}

	public void setChildren(List<String> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "SRV131Json [partyId=" + partyId + ", children=" + children + "]";
	}
	

}
