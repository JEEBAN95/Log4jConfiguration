package com.jk.model;

public class Contact {

	private Integer personId;
	private String personName;
	private String personEmail;
	private String personMobileNum;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonMobileNum() {
		return personMobileNum;
	}

	public void setPersonMobileNum(String personMobileNum) {
		this.personMobileNum = personMobileNum;
	}

	@Override
	public String toString() {
		return "Contact [personId=" + personId + ", personName=" + personName + ", personEmail=" + personEmail
				+ ", personMobileNum=" + personMobileNum + "]";
	}
}
