package com.zds.poisson;

import java.util.HashMap;
import java.util.Map;

public class PoissonFactory {
	
	public static Poisson nouveauPoisson(String nom, int age, Race race, Sexe sexe){
		
		Map<String, Property> spec = new HashMap<String, Property>();
		
		switch(race){
		case MEROU:
			spec.put("Race", Race.MEROU);
			spec.put("Sexe", Sexe.MALE);
			spec.put("Reproduction", Reproduction.HERMAPHRODITE_AGE);
			spec.put("Alimentation", Alimentation.CARNIVORE);
			break;
		case THON:
			spec.put("Race", Race.THON);
			spec.put("Sexe", sexe);
			spec.put("Reproduction", Reproduction.MONO_SEX);
			spec.put("Alimentation", Alimentation.CARNIVORE);
			break;
		case POISSON_CLOWN:
			spec.put("Race", Race.POISSON_CLOWN);
			spec.put("Sexe", sexe);
			spec.put("Reproduction", Reproduction.HERMAPHRODITE_OPP);
			spec.put("Alimentation", Alimentation.CARNIVORE);
			break;
		case SOLE:
			spec.put("Race", Race.SOLE);
			spec.put("Sexe", sexe);
			spec.put("Reproduction", Reproduction.HERMAPHRODITE_OPP);
			spec.put("Alimentation", Alimentation.HERBIVORE);
			break;
		case BAR:
			spec.put("Race", Race.BAR);
			spec.put("Sexe", Sexe.MALE);
			spec.put("Reproduction", Reproduction.HERMAPHRODITE_AGE);
			spec.put("Alimentation", Alimentation.HERBIVORE);
			break;
		case CARPE:
			spec.put("Race", Race.CARPE);
			spec.put("Sexe", sexe);
			spec.put("Reproduction", Reproduction.MONO_SEX);
			spec.put("Alimentation", Alimentation.HERBIVORE);
			break;
		default:
			break;
		}
		return new Poisson(nom, new PoissonSpec(spec), age);
	}
}
