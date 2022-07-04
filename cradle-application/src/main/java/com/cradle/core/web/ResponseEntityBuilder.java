package com.cradle.core.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.cradle.core.message.Message;

public class ResponseEntityBuilder<T> {

	private final Response<T> response;

	private HttpStatus httpStatus;

	public ResponseEntityBuilder() {
		this.response = new Response<T>();
	}

	public ResponseEntityBuilder(T result) {
		this.response = new Response<>();
		this.response.setBody(result);
	}

	public ResponseEntityBuilder(T result, HttpStatus httpStatus) {
		this.response = new Response<>();
		this.httpStatus = httpStatus;
		this.response.setBody(result);
	}

	public ResponseStatus getResponseStatus(HttpStatus httpStatus) {
		return ResponseEntityBuilder.isOkayStatus(httpStatus) ? ResponseStatus.ok : ResponseStatus.failure;
	}

	private static boolean isOkayStatus(HttpStatus httpStatus) {
		Series series = Series.resolve(httpStatus.value());
		return series == Series.SUCCESSFUL || series == Series.INFORMATIONAL || series == Series.REDIRECTION;
	}

	public ResponseEntityBuilder<T> messages(List<Message> messages) {
		this.response.setMessages(messages);
		return this;
	}

	public ResponseEntityBuilder<T> message(Message message) {
		this.response.setMessage(message);
		return this;
	}

	public ResponseEntity<Response<T>> build() {
		this.response.setResponseStatus(this.getResponseStatus(httpStatus));
		return new ResponseEntity<>(this.response, httpStatus);
	}

	public ResponseEntity<Response<T>> build(MultiValueMap<String, String> headers) {
		return new ResponseEntity<>(this.response, headers, this.httpStatus);
	}

}
