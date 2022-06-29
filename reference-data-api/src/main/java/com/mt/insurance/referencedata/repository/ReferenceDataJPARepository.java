package com.mt.insurance.referencedata.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mt.insurance.referencedata.repository.entity.VreferenceData;

public interface ReferenceDataJPARepository extends JpaRepository<VreferenceData, Integer> {

	@Query(value = "SELECT rd from VreferenceData rd where type in :referenceDataType")
	List<VreferenceData> getReferenceDataType(@Param("referenceDataType") List<String> referenceDataType,Sort sort);


}
