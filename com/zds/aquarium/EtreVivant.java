package com.zds.aquarium;

public abstract class EtreVivant {
	
	protected final int AGE_MORT = 20;
	protected int age;
	protected int pv;
	protected int pvDonnee;
	protected int pvPerdu;
	protected String id;
		
	public EtreVivant(int age, int pvDonnee, int pvPerdu, String id){
		this.pv = 10;
		this.age = age;
		this.pvDonnee = pvDonnee;
		this.pvPerdu = pvPerdu;
		this.id = id;
	}
	
	public abstract void grandirEnPV();
	public abstract void hookChangerSexe();
	
	public final void grandir(){
		grandirEnPV();
		this.age++;
		if(this.age == 11){
			hookChangerSexe();
		}
	}
	
	public boolean estMort(){
		return this.pv <= 0 || this.age > AGE_MORT;
	}
	
	public String getId(){
		return this.id;
	}
	public int getPV(){
		return this.pv;
	}
	
	public void setPV(int pv){
		this.pv = pv;
	}
	
	
	public void addPV(int pv){
		this.pv += pv;
	}
	
	public void subPV(int pv){
		this.pv -= pv;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getPVDonnee(){
		return this.pvDonnee;
	}
	
	public int getPVPerdu(){
		return this.pvPerdu;
	}
}
