package com.zds.aquarium;

import java.io.IOException;

import com.zds.algue.Algue;
import com.zds.poisson.PoissonFactory;
import com.zds.poisson.Race;
import com.zds.poisson.Sexe;

public class Simulateur {
	
	public static void main(String[] args){
		
		Aquarium aquarium = new Aquarium();
		initAquarium(aquarium);
		
		while(true){
			aquarium.tour();
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void initAquarium(Aquarium aq){
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("M1M", 2, Race.MEROU, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("M2M", 2, Race.MEROU, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("M3M", 2, Race.MEROU, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("PC1F", 2, Race.POISSON_CLOWN, Sexe.FEMELLE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("T1M", 2, Race.THON, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("T2M", 3, Race.THON, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("S1F", 6, Race.SOLE, Sexe.FEMELLE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("B1M", 3, Race.BAR, Sexe.MALE));
		
		aq.ajouterAlgue(new Algue(2, "A1"));
		aq.ajouterAlgue(new Algue(3, "A2"));
		aq.ajouterAlgue(new Algue(4, "A3"));
		aq.ajouterAlgue(new Algue(5, "A4"));
	}

}
