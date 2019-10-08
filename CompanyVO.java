package com.exam;

public class CompanyVO {
	private long companyCd;
	private String companyNm;
	private String filmoNames;
	public long getCompanyCd() {
		return companyCd;
	}
	public void setCompanyCd(long companyCd) {
		this.companyCd = companyCd;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getFilmoNames() {
		return filmoNames;
	}
	public void setFilmoNames(String filmoNames) {
		this.filmoNames = filmoNames;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyVO [companyCd=").append(companyCd).append(", company=").append(companyNm)
				.append(", filmoNames=").append(filmoNames).append("]");
		return builder.toString();
	}
	
	
}
