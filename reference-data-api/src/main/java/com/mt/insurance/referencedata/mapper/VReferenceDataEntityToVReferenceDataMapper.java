package com.mt.insurance.referencedata.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mt.insurance.referencedata.model.VreferenceData;

@Mapper(componentModel = "spring")
public interface VReferenceDataEntityToVReferenceDataMapper {

	List<VreferenceData> mapToModel(
			List<com.mt.insurance.referencedata.repository.entity.VreferenceData> vreferenceData);
}
