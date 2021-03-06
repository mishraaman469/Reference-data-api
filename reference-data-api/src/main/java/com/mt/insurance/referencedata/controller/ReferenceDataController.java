package com.mt.insurance.referencedata.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cradle.core.web.Response;
import com.cradle.core.web.ResponseEntityBuilder;
import com.mt.insurance.referencedata.constant.APIConstant;
import com.mt.insurance.referencedata.model.VreferenceData;
import com.mt.insurance.referencedata.service.ReferenceDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController()
@RequiredArgsConstructor
@Slf4j
@RequestMapping(APIConstant.REFERENCE_DATA_BASE_PATH)
@Api("Reference data for application to have all the form values")
public class ReferenceDataController {

	@NonNull
	private ReferenceDataService referenceDataService;

	@ApiOperation(value = "Getting all the reference data type for the application based on the type name", response = Iterable.class)
	@GetMapping(APIConstant.REFERENCE_DATA_TYPE)
	public ResponseEntity<Response<List<VreferenceData>>> getReferenceData(
			@RequestHeader("Accept-language") String language, @RequestBody() List<String> referenceDataType) {
		List<VreferenceData> vreferenceData = this.referenceDataService.getReferenceData(language, referenceDataType);
		return new ResponseEntityBuilder<>(vreferenceData, HttpStatus.OK).build();
	}
}
