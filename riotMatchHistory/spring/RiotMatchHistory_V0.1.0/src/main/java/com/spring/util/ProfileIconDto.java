package com.spring.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileIconDto {
	public String type;
	public String version;
	public Map<String, ProfileIcon> data = new HashMap<>();
}
