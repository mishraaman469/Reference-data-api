package com.mt.insurance.referencedata.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.insurance.referencedata.constant.APIConstant;
import com.mt.insurance.referencedata.model.VreferenceData;
import com.mt.insurance.referencedata.service.ReferenceDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController(APIConstant.REFERENCE_DATA_BASE_PATH)
@RequiredArgsConstructor
@Slf4j
@RequestMapping(APIConstant.REFERENCE_DATA_BASE_PATH)
@Api("Reference data for application to have all the form values")
public class ReferenceDataController {

	@NonNull
	private ReferenceDataService referenceDataService;

	
	@ApiOperation(value = "Getting all the reference data type for the application based on the type name",response = Iterable.class )
	@GetMapping(APIConstant.REFERENCE_DATA_TYPE)
	public List<VreferenceData> getReferenceData(@RequestHeader("Accept-language") String language,
		@RequestBody()	List<String> referenceDataType) {
		return this.referenceDataService.getReferenceData(language, referenceDataType);
	}
}
