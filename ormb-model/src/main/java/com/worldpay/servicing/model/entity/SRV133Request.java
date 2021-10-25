package com.worldpay.servicing.model.entity;

import java.util.Objects;

public class SRV133Request {

	private String perIdNbr;
	private String classVal;
	private String sClassVal;
	private String priceItemCd;

	SRV133Request(SRV133RequestBuilder builder) {

		this.perIdNbr = builder.perIdNbr;
		this.classVal = builder.classVal;
		this.sClassVal = builder.sClassVal;
		this.priceItemCd = builder.priceItemCd;
	}
	public String getPerIdNbr() {
		return perIdNbr;
	}

	public String getClassVal() {
		return classVal;
	}

	public String getsClassVal() {
		return sClassVal;
	}

	public String getPriceItemCd() {
		return priceItemCd;
	}

	public static SRV133RequestBuilder builder() {
		return new SRV133RequestBuilder();
	}

	public static class SRV133RequestBuilder {

		private String perIdNbr;
		private String classVal;
		private String sClassVal;
		private String priceItemCd;

		SRV133RequestBuilder() {
		}

		public SRV133RequestBuilder perIdNbr(String perIdNbr) {
			this.perIdNbr = perIdNbr;
			return this;
		}

		public SRV133RequestBuilder classVal(String classVal) {
			this.classVal = classVal;
			return this;
		}

		public SRV133RequestBuilder sClassVal(String sClassVal) {
			this.sClassVal = sClassVal;
			return this;
		}

		public SRV133RequestBuilder priceItemCd(String priceItemCd) {
			this.priceItemCd = priceItemCd;
			return this;
		}

		public SRV133Request build() {
			return new SRV133Request(this);
		}

	}

	
	@Override
	public int hashCode() {
		return Objects.hash(perIdNbr, classVal, sClassVal, priceItemCd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SRV133Request srv133Request = (SRV133Request) obj;
		return Objects.equals(perIdNbr, srv133Request.perIdNbr)
				&& Objects.equals(classVal, srv133Request.classVal)
				&& Objects.equals(sClassVal, srv133Request.sClassVal)
				&& Objects.equals(priceItemCd, srv133Request.priceItemCd);
	}
	@Override
	public String toString() {
		return "SRV133Request [perIdNbr=" + perIdNbr + ", classVal=" + classVal + ", sClassVal=" + sClassVal
				+ ", priceItemCd=" + priceItemCd + "]";
	}
	
}
