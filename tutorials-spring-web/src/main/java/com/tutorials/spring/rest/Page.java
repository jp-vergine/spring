package com.tutorials.spring.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {

    private String name;
    private String about;
    private String phone;
    private String website;

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

	@Override
	public String toString() {
		return "Page [name=" + name + ", about=" + about + ", phone=" + phone
				+ ", website=" + website + "]";
	}

    
}
