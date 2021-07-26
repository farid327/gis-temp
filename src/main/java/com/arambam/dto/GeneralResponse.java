package com.arambam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GeneralResponse {
	protected boolean success;

	protected String message;

	public GeneralResponse(boolean success) {
		this.success = success;
	}
}
