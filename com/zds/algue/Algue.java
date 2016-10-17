package com.zds.algue;

import com.zds.aquarium.EtreVivant;

public class Algue extends EtreVivant{
	
	private final int PV_ALGUE_PAR_TOUR = 1;
	private static final int PV_DONNEE = 3;
	private static final int PV_PERDU = 2;
	
	public Algue(int age, String id){
		super(age, PV_DONNEE, PV_PERDU, id);
	}
	
	public Algue reproduire() {
		
		if(this.estMort()){
			return null;
		}
		else if(this.getAge() >= 10){
			
			Algue nouveauAlgue = new Algue(this.getAge() / 2, this.getId() + "A");
			nouveauAlgue.setPV(this.getPV() / 2);
			this.setPV(this.getPV() / 2);
			return nouveauAlgue;
		}
		else {
			return null;
		}
	}
	
	@Override
	public void grandirEnPV() {
		this.addPV(PV_ALGUE_PAR_TOUR);
	}

}
