package com.zds.poisson;

import java.util.Random;

import com.zds.aquarium.EtreVivant;

public class Poisson extends EtreVivant{

	private PoissonSpec spec;
	private final int PV_POISSON_PERDU_PAR_TOUR = 1;
	private static final int PV_DONNEE = 5;
	private static final int PV_PERDU = 4;
	
	public Poisson(String nom, PoissonSpec spec, int age){
		super(age, PV_DONNEE, PV_PERDU, nom);
		this.spec = spec;
	}
	
	public PoissonSpec getSpec(){
		return this.spec;
	}
	
	public void setSpec(PoissonSpec spec){
		this.spec = spec;
	}
	
	public Property getProperty(String name){
		return this.spec.getProperty(name);
	}
	
	public void setProperty(String name, Property value){
		this.spec.setProperty(name, value);
	}
	
	public boolean memeProp(String property, Poisson autre){
		return this.getProperty(property).equals(autre.getProperty(property));
	}
	
	public boolean aFaim(){
		return this.pv <= 5;
	}
	
	public boolean manger(EtreVivant ev) {
		// Si l'etre vivant est mort ne rien faire.
		// Si c'est de la même race, ne mange pas.
		// Si c'est le même poisson, il a forcement la même race.
		if( (ev instanceof Poisson && this.memeProp("Race", (Poisson)ev)) || (this.estMort())|| (ev.estMort()) ){
			return false;
		}
		else{
			ev.subPV(ev.getPVPerdu());
			this.addPV(ev.getPVDonnee());
			
			return true;
		}
	}

	public Poisson reproduire(Poisson autre) {
		
		if(this == autre){
			return null;
		}
		
		if(this.estMort() || autre.estMort()){
			return null;
		}
		
		if(!this.memeProp("Race", autre)){
			return null;
		}
		
		if(this.memeProp("Sexe", autre)){
			if(this.getProperty("Reproduction").equals(Reproduction.HERMAPHRODITE_OPP)){
				this.changerSexe();
			}
			else {
				return null;
			}
		}
		
		Random r = new Random();
		Poisson nouveauPoisson = PoissonFactory.nouveauPoisson(this.getId() + autre.getId(), 0,
					(Race)this.getProperty("Race"), r.nextBoolean() ? Sexe.MALE : Sexe.FEMELLE);
			
		return nouveauPoisson;
	}
	
	private void changerSexe(){
		if(this.getProperty("Sexe").equals(Sexe.FEMELLE)){
			this.setProperty("Sexe", Sexe.MALE);
		}
		else{
			this.setProperty("Sexe", Sexe.FEMELLE);
		}
	}
	
	@Override
	public void hookChangerSexe(){
		if(this.getProperty("Reproduction").equals(Reproduction.HERMAPHRODITE_AGE)){
			System.out.println(this.getId() + " a " + this.getAge() + " il va changer de sexe");
			this.changerSexe();
		}
	}
	@Override
	public void grandirEnPV() {
		this.subPV(PV_POISSON_PERDU_PAR_TOUR);
	}
}
