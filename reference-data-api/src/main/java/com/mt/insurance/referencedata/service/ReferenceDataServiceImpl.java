package com.mt.insurance.referencedata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mt.insurance.referencedata.exception.BusinessException;
import com.mt.insurance.referencedata.model.VreferenceData;
import com.mt.insurance.referencedata.repository.ReferenceDataRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReferenceDataServiceImpl implements ReferenceDataService {

	@NonNull
	private ReferenceDataRepository referenceDataRepository;

	@Override
	public List<VreferenceData> getReferenceData(String language, List<String> referenceDataType) {
		return this.referenceDataRepository.getReferenceData(language, referenceDataType).orElseThrow(() -> {
			log.error("");
			throw new BusinessException("");
		});
	}

}
