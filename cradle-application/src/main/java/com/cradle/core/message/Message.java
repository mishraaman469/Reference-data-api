package com.cradle.core.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	private MessageType type;

	private String code;

	private String key;

	private String text;

	private String locale;

}
