package com.mt.insurance.referencedata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.mt.insurance.referencedata.mapper.VReferenceDataEntityToVReferenceDataMapper;
import com.mt.insurance.referencedata.model.VreferenceData;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReferenceDataRepositoryImpl implements ReferenceDataRepository {

	@NonNull
	private ReferenceDataJPARepository referenceDataJPARepository;

	@NonNull
	private VReferenceDataEntityToVReferenceDataMapper referenceDataMapper;

	@Override
	public Optional<List<VreferenceData>> getReferenceData(String language, List<String> referenceDataType) {
		language = language.equals("en-IN") ? "displayValueEn" : "displayValueHi";
		Sort sort = Sort.by(language).ascending();
		return Optional.ofNullable(this.referenceDataJPARepository.getReferenceDataType(referenceDataType, sort))
				.map(referenceDataMapper::mapToModel);
	}

}
