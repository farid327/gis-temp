package com.arambam.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SearchLocationRequest {

	@NotBlank
	private String name;

	@NotNull
	private Double lat;

	@NotNull
	private Double lon;

}
