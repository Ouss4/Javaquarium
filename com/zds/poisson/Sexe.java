package com.zds.poisson;

public enum Sexe implements Property{
	MALE("Male"),
	FEMELLE("Femelle");
	
	private String name;
	
	Sexe(String name){
		this.name = name;
	}
	
	@Override
	public String getValue(){
		return this.name;
	}
}
