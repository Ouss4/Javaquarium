package com.zds.aquarium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.zds.algue.Algue;
import com.zds.poisson.Alimentation;
import com.zds.poisson.Poisson;

public class Aquarium {
	
	private List<Poisson> listPoisson = new ArrayList<Poisson>();
	private List<Algue> listAlgue = new ArrayList<Algue>();
	
	static int tourId = 0;
	
	public void ajouterPoisson(Poisson poisson){
		listPoisson.add(poisson);
	}
	
	public void ajouterAlgue(Algue algue){
		listAlgue.add(algue);
	}
	
	public void supprimerPoisson(Poisson poisson){
		listPoisson.remove(poisson);
	}
	
	public void supprimerAlgue(Algue algue){
		listAlgue.remove(algue);
	}
	
	public int getNumPoissons(){
		return listPoisson.size();
	}
	
	public int getNumAlgues(){
		return listAlgue.size();
	}
	
	public void tour(){
		System.out.println("Tour N°" + (++tourId));
		System.out.println("L'Aquarium a " + getNumPoissons() + " poissons et " +
							getNumAlgues() + " algues");
		
		grandir(listAlgue);
		grandir(listPoisson);
		
		reproductionAlgue();
		reproductionPoisson();
		
		nourirPoisson();
		
		enleverMorts(listPoisson);
		enleverMorts(listAlgue);
		
		System.out.println("Maintenant l'aquarium a " + getNumPoissons() + " poissons et " + getNumAlgues() + " algues");
	}
	
	private void grandir(List<? extends EtreVivant> l){
		for(EtreVivant ev : l){
			ev.grandir();
			System.out.println(ev.getId() + " : " + ev.getPV() + "pv" + ", " + ev.getAge() + "age");
		}
	}
	
	private void reproductionAlgue(){
		List<Algue> nouveauAlgues = new ArrayList<Algue>();
		
		for(Algue a : listAlgue){
			Algue nouveauAlgue = null;
			nouveauAlgue = a.reproduire();
			if(nouveauAlgue != null){
				nouveauAlgues.add(nouveauAlgue);
				System.out.println("Nouveau Algue est née");
			}
		}
		
		if(!nouveauAlgues.isEmpty()){
			this.listAlgue.addAll(nouveauAlgues);
		}
	}
	
	private void reproductionPoisson(){
		List<Poisson> nouveauPoissons = new ArrayList<Poisson>();
		
		for(Poisson p : listPoisson){
			if(!p.aFaim()){
				Random r = new Random();
				int x = r.nextInt(listPoisson.size());
				
				Poisson nouveauPoisson = null;
				nouveauPoisson = p.reproduire(listPoisson.get(x));
				if(nouveauPoisson != null){
					nouveauPoissons.add(nouveauPoisson);
					System.out.println("Nouveau poisson est née");
				}
			}
		}
		
		if(!nouveauPoissons.isEmpty()){
			this.listPoisson.addAll(nouveauPoissons);
		}
	}
	
	private void nourirPoisson(){
		for(Poisson p : listPoisson){
			if(p.aFaim()){
				if(p.getProperty("Alimentation").equals(Alimentation.CARNIVORE)){
					nourir(p, listPoisson);
				}
				else{
					nourir(p, listAlgue);
				}
			}
		}
	}
	
	private void nourir(Poisson p, List<? extends EtreVivant> l){
		Random r = new Random();
		int x = r.nextInt(l.size());
		
		
		if(p.manger(l.get(x))){
			System.out.println(p.getId() + " mange " + l.get(x).getId());
		}
		
		if(l.get(x).estMort()){
			System.out.println(l.get(x).getId() + " a " + l.get(x).getPV() + " PV il va mourir... RIP.");
		}
	}
	
	private void enleverMorts(List<? extends EtreVivant> l){
		for(Iterator<? extends EtreVivant> it = l.iterator(); it.hasNext(); ){
			EtreVivant ev = it.next();
			if(ev.estMort()){
				System.out.println(ev.getId() + " est mort.");
				it.remove();
			}
		}
	}
}
