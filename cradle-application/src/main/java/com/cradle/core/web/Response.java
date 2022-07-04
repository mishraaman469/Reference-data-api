package com.cradle.core.web;

import java.util.Arrays;
import java.util.List;

import com.cradle.core.message.Message;

import lombok.Data;

@Data
public class Response<T> {

	private T body;

	private ResponseStatus responseStatus;

	private List<Message> messages;

	public void setMessage(Message message) {
		this.messages = Arrays.asList(message);
	}

}
