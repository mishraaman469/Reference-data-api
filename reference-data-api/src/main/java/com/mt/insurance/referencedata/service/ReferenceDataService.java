package com.mt.insurance.referencedata.service;

import java.util.List;

import com.mt.insurance.referencedata.model.VreferenceData;

public interface ReferenceDataService {

	List<VreferenceData> getReferenceData(String language, List<String> referenceDataType);

}
