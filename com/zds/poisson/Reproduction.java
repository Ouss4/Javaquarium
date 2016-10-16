package com.zds.poisson;

public enum Reproduction implements Property{
	MONO_SEX("Mono-Sexué"),
	HERMAPHRODITE_AGE("Hermaphrodite avec l'age"),
	HERMAPHRODITE_OPP("Hermaphrodite oppertuniste");
	
	private String name;
	
	Reproduction(String name){
		this.name = name;
	}
	
	@Override
	public String getValue(){
		return this.name;
	}
}
