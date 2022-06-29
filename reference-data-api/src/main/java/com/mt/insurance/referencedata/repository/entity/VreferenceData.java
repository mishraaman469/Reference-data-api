package com.mt.insurance.referencedata.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class VreferenceData {

	@Id
	private String id;

	private String type;

	private int sqn;

	private String value;

	private int systemId;

	private String externalSystemCd;

	private String externalSystemText;

	private String displayValueEn;

	private String displayValueHi;

}
