package com.mt.insurance.referencedata.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VreferenceData {

	@ApiModelProperty(notes = "Unique identifier for each record")
	private String id;

	@ApiModelProperty(notes= "Unique reference data type ")
	private String type;

	@ApiModelProperty(notes = "Unique Sequence number within particular reference data type")
	private int sqn;

	@ApiModelProperty(notes = "Value which will be used internally within the application")
	private String value;

	@ApiModelProperty(notes = "Refers to external communication system")
	private int systemId;

	@ApiModelProperty(notes = "Reference data code which is used to link the external system")
	private String externalSystemCd;

	@ApiModelProperty("Exernal system text")
	private String externalSystemText;

	@ApiModelProperty(notes = "Display value in the english")
	private String displayValueEn;

	@ApiModelProperty(notes="Display value in hindi")
	private String displayValueHi;
}
