package com.mt.insurance.referencedata.repository;

import java.util.List;
import java.util.Optional;

import com.mt.insurance.referencedata.model.VreferenceData;

public interface ReferenceDataRepository {

	Optional<List<VreferenceData>> getReferenceData(String language, List<String> referenceDataType);

}
