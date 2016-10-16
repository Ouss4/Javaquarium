package com.zds.poisson;

public enum Race implements Property{
	MEROU("Merou"),
	THON("Thon"),
	POISSON_CLOWN("Poisson-Clown"),
	SOLE("Sole"),
	BAR("Bar"),
	CARPE("Carpe");
	
	private String name;
	
	Race(String name){
		this.name = name;
	}
	
	@Override
	public String getValue(){
		return this.name;
	}
}
