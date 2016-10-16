package com.zds.poisson;

public enum Alimentation implements Property{
	CARNIVORE("Carnivore"),
	HERBIVORE("Herbivore");
	
	private String name;
	
	Alimentation(String name){
		this.name = name;
	}

	@Override
	public String getValue() {
		return this.name;
	}
}
