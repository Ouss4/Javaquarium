package com.zds.aquarium;

public abstract class EtreVivant {
	
	protected int age;
	protected int pv;
	protected int pvDonnee;
	protected int pvPerdu;
	protected String id;
	
	public EtreVivant(){
		age = 0;
		pv = 10;
	}
	
	public EtreVivant(int age, int pvDonnee, int pvPerdu, String id){
		this();
		this.age = age;
		this.pvDonnee = pvDonnee;
		this.pvPerdu = pvPerdu;
		this.id = id;
	}
	
	public abstract void grandirEnPV();
	
	public final void grandir(){
		grandirEnPV();
		this.age++;
	}
	
	public boolean estMort(){
		return this.pv <= 0 || this.age > 20;
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
