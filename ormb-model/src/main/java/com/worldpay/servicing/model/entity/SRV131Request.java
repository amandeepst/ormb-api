package com.worldpay.servicing.model.entity;

import java.math.BigDecimal;
import java.util.List;

public class SRV131Request {
	private String partyId;
	private List<String> children;
	private String currency;
	private String legalCounterParty;
	private String billDateFrom;
	private String billDateTo;
	private String billPaymentStatus;
	private String altBillId;
	private BigDecimal billAmountFrom;
	private BigDecimal billAmountTo;

	public SRV131Request(SRV131RequestBuilder builder) {
		super();
		this.partyId = builder.partyId;
		this.children = builder.children;
		this.currency = builder.currency;
		this.legalCounterParty = builder.legalCounterParty;
		this.billDateFrom = builder.billDateFrom;
		this.billDateTo = builder.billDateTo;
		this.altBillId=builder.altBillId;
		this.billPaymentStatus=builder.billPaymentStatus;
		this.billAmountFrom=builder.billAmountFrom;
		this.billAmountTo=builder.billAmountTo;
	}

	public BigDecimal getBillAmountFrom() {
		return billAmountFrom;
	}

	public BigDecimal getBillAmountTo() {
		return billAmountTo;
	}

	public String getBillPaymentStatus() {
		return billPaymentStatus;
	}

	public String getAltBillId() {
		return altBillId;
	}

	public String getPartyId() {
		return partyId;
	}

	public List<String> getChildren() {
		return children;
	}

	public String getCurrency() {
		return currency;
	}

	public String getLegalCounterParty() {
		return legalCounterParty;
	}

	public String getBillDateFrom() {
		return billDateFrom;
	}

	public String getBillDateTo() {
		return billDateTo;
	}

	public static SRV131RequestBuilder builder() {
		return new SRV131RequestBuilder();
	}

	public static class SRV131RequestBuilder {

		private String partyId;
		private List<String> children;
		private String currency;
		private String legalCounterParty;
		private String billDateFrom;
		private String billDateTo;
		private String billPaymentStatus;
		private String altBillId;
		private BigDecimal billAmountFrom;
		private BigDecimal billAmountTo;

		SRV131RequestBuilder() {
		}

		public SRV131RequestBuilder billAmountFrom(BigDecimal billAmountFrom) {
			this.billAmountFrom = billAmountFrom;
			return this;
		}

		public SRV131RequestBuilder billAmountTo(BigDecimal billAmountTo) {
			this.billAmountTo = billAmountTo;
			return this;
		}


		public SRV131RequestBuilder billPaymentStatus(String billPaymentStatus) {
			this.billPaymentStatus = billPaymentStatus;
			return this;
		}

		public SRV131RequestBuilder altBillId(String altBillId) {
			this.altBillId = altBillId;
			return this;
		}

		public SRV131RequestBuilder partyId(String partyId) {
			this.partyId = partyId;
			return this;
		}

		public SRV131RequestBuilder children(List<String> children) {
			this.children = children;
			return this;
		}

		public SRV131RequestBuilder currency(String currency) {
			this.currency = currency;
			return this;
		}

		public SRV131RequestBuilder legalCounterParty(String legalCounterParty) {
			this.legalCounterParty = legalCounterParty;
			return this;
		}

		public SRV131RequestBuilder billDateFrom(String billDateFrom) {
			this.billDateFrom = billDateFrom;
			return this;
		}

		public SRV131RequestBuilder billDateTo(String billDateTo) {
			this.billDateTo = billDateTo;
			return this;
		}

		public SRV131Request build() {
			return new SRV131Request(this);
		}

	}

	
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((altBillId == null) ? 0 : altBillId.hashCode());
    result = prime * result + ((billAmountFrom == null) ? 0 : billAmountFrom.hashCode());
    result = prime * result + ((billAmountTo == null) ? 0 : billAmountTo.hashCode());
    result = prime * result + ((billDateFrom == null) ? 0 : billDateFrom.hashCode());
    result = prime * result + ((billDateTo == null) ? 0 : billDateTo.hashCode());
    result = prime * result + ((billPaymentStatus == null) ? 0 : billPaymentStatus.hashCode());
    result = prime * result + ((children == null) ? 0 : children.hashCode());
    result = prime * result + ((currency == null) ? 0 : currency.hashCode());
    result = prime * result + ((legalCounterParty == null) ? 0 : legalCounterParty.hashCode());
    result = prime * result + ((partyId == null) ? 0 : partyId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SRV131Request other = (SRV131Request) obj;
    if (altBillId == null) {
      if (other.altBillId != null)
        return false;
    } else if (!altBillId.equals(other.altBillId))
      return false;
    if (billAmountFrom == null) {
      if (other.billAmountFrom != null)
        return false;
    } else if (!billAmountFrom.equals(other.billAmountFrom))
      return false;
    if (billAmountTo == null) {
      if (other.billAmountTo != null)
        return false;
    } else if (!billAmountTo.equals(other.billAmountTo))
      return false;
    if (billDateFrom == null) {
      if (other.billDateFrom != null)
        return false;
    } else if (!billDateFrom.equals(other.billDateFrom))
      return false;
    if (billDateTo == null) {
      if (other.billDateTo != null)
        return false;
    } else if (!billDateTo.equals(other.billDateTo))
      return false;
    if (billPaymentStatus == null) {
      if (other.billPaymentStatus != null)
        return false;
    } else if (!billPaymentStatus.equals(other.billPaymentStatus))
      return false;
    if (children == null) {
      if (other.children != null)
        return false;
    } else if (!children.equals(other.children))
      return false;
    if (currency == null) {
      if (other.currency != null)
        return false;
    } else if (!currency.equals(other.currency))
      return false;
    if (legalCounterParty == null) {
      if (other.legalCounterParty != null)
        return false;
    } else if (!legalCounterParty.equals(other.legalCounterParty))
      return false;
    if (partyId == null) {
      if (other.partyId != null)
        return false;
    } else if (!partyId.equals(other.partyId))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "SRV131Request [partyId=" + partyId + ", children=" + children + ", currency=" + currency
        + ", legalCounterParty=" + legalCounterParty + ", billDateFrom=" + billDateFrom
        + ", billDateTo=" + billDateTo + ", billPaymentStatus=" + billPaymentStatus + ", altBillId="
        + altBillId + ", billAmountFrom=" + billAmountFrom + ", billAmountTo=" + billAmountTo + "]";
  }

		
	}
