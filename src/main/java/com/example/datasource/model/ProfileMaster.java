package com.example.datasource.model;

import org.springframework.data.annotation.Id;

import lombok.Builder;

@Builder
public class ProfileMaster {

	@Id
	private String id;
	private String about;
	private String technical_competancy;
	private String current_practice_manager;
	private String current_practice_manager_email;
	private int experience_in_months;
}
