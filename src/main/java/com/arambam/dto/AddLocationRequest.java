package com.arambam.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.wololo.geojson.Geometry;

@Data
public class AddLocationRequest {

	@NotBlank
	private String name;

	@Valid
	@NotNull
	private Geometry geometry;

}
