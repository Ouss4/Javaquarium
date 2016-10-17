package com.zds.poisson;

import java.util.HashMap;
import java.util.Map;

public class PoissonProperty {

	private Map<String, Property> properties;
	
	public PoissonProperty(Map<String, Property> properties){
		if(properties == null){
			this.properties  = new HashMap<String, Property>();
		}
		else{
			this.properties  = new HashMap<String, Property>(properties);
		}
	}
	
	public Property getProperty(String name){
		return this.properties.get(name);
	}
	
	public void setProperty(String name, Property value){
		this.properties.put(name, value);
	}
}
