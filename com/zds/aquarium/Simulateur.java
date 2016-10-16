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
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("Merou1Male", 2, Race.MEROU, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("Merou1Femelle", 2, Race.MEROU, Sexe.FEMELLE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("Merou2Male", 2, Race.MEROU, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("PoissonClown1Femelle", 2, Race.POISSON_CLOWN, Sexe.FEMELLE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("Thon1Male", 2, Race.THON, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("Thon2Male", 3, Race.THON, Sexe.MALE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("Sole1Male", 6, Race.SOLE, Sexe.FEMELLE));
		
		aq.ajouterPoisson(PoissonFactory.nouveauPoisson("Bar1Male", 3, Race.BAR, Sexe.MALE));
		
		aq.ajouterAlgue(new Algue(2, "Algue1"));
		aq.ajouterAlgue(new Algue(3, "Algue2"));
		aq.ajouterAlgue(new Algue(4, "Algue3"));
		aq.ajouterAlgue(new Algue(5, "Algue4"));
	}

}
