package com.arambam.dto;

import lombok.Data;

@Data
public class SearchLocationResponse extends GeneralResponse {

	private boolean exists;

	public SearchLocationResponse(boolean exists) {
		super(true, null);
		this.exists = exists;
	}
}
