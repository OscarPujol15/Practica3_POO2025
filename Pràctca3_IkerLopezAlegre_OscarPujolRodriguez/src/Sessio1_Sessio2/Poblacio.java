package Sessio1_Sessio2;

import java.util.Arrays;


public class Poblacio {
	private String nom;
	private ContenidorBrossa contenidor[];
	private int numContenidors;
	private int numContenidorsCarrer;
	private final int INCREMENT;

	public Poblacio(String nom, int components , int increment) {
		this.nom = nom;
		this.contenidor = new ContenidorBrossa[components];
		this.INCREMENT = increment;
		this.numContenidors = 0;
		this.numContenidorsCarrer=0;
	}

	public String getNom() {return this.nom;}
	public int getNumContenidors() {return this.numContenidors;}
	public int getNumContenidorsCarrer() {return this.numContenidorsCarrer;}

	public ContenidorBrossa getContenidor(int quin) {
		if (quin>this.numContenidors || quin<0) {
			return null;
		}
		else {
			return this.contenidor[quin];
		}
	}


	private void augmentarContenidor () {
		if (this.numContenidors >= contenidor.length) {
			ContenidorBrossa[] contenidor2 = new ContenidorBrossa[this.INCREMENT];
			for (int i =0; i<numContenidors; i++) {
				contenidor2[i] = contenidor[i];
			}
			contenidor2 = contenidor;
		}
	}

	public void afegirContenidor(ContenidorBrossa p) {
		for (int i =0 ; i<this.numContenidors ;i++) {
			if (p.compareTo(this.contenidor[i]) == 0) {
				return;
			}
			if (p.compareTo(this.contenidor[i]) >0){ 
				augmentarContenidor();
				for (int j = this.numContenidors; j>i; j--) {
					this.contenidor[j+1] = this.contenidor[j];
				}

				this.numContenidors++;
				if (p.getUbicacio()!=(null)) {
					this.numContenidorsCarrer++;
					return;
				}
			}
			this.contenidor [this.numContenidors] = p;
			this.numContenidors++;
			if (p.getUbicacio()!=(null)) {
				this.numContenidorsCarrer++;
			}
		} 
	}

	public void afegirContenidor(String codi, int color, String ubicacio, int any, float tara) {
		ContenidorBrossa p;
		switch (color){
		case 0:
			p =  new Plastic (codi, ubicacio, any, tara);
			afegirContenidor(p);
		case 1:
			p =  new Organic (codi, ubicacio, any, tara);
			afegirContenidor(p);
		case 2:
			p =  new Rebuig (codi, ubicacio, any, tara);
			afegirContenidor(p);
		case 3:
			p =  new Paper (codi, ubicacio, any, tara);
			afegirContenidor(p);
		case 4:
			p =  new Vidre (codi, ubicacio, any, tara);
			afegirContenidor(p);
		default: 
			return;
		} 
	}

	public void afegirContenidor(ContenidorBrossa[] p) {
		for (int i =0; i<p.length; i++) {
			afegirContenidor(p[i]);
		}
		return;
	}

	public String hiEs(String codi) {
		int posicio = cercaDicotomica(contenidor, 0, numContenidors, codi);
		if (posicio != -1) {
			return contenidor[posicio].getTipusBrossa(); 
		}
		else {
			return "No hi és";
		}

	}

	public static int cercaDicotomica(ContenidorBrossa[] vector, int esquerra, int dreta, String buscat) { 
		if (dreta >= esquerra) {
			int mig = esquerra + (dreta - esquerra) / 2;
			if (vector[mig].equals(buscat)) {	
				return mig; 
			}
			if (vector[mig].compareTo(buscat) > 0) {
				return cercaDicotomica(vector, esquerra, mig - 1, buscat);
			}
			return cercaDicotomica(vector, mig + 1, dreta, buscat);
		}
		return -1;
	}
	
	public static int cercaDicotomica(ContenidorBrossa[] vector, int esquerra, int dreta, ContenidorBrossa c) { 
		if (dreta >= esquerra) {
			int mig = esquerra + (dreta - esquerra) / 2;
			if (vector[mig].equals(c)) {	
				return mig; 
			}
			if (vector[mig].compareTo(c) > 0) {
				return cercaDicotomica(vector, esquerra, mig - 1, c);
			}
			return cercaDicotomica(vector, mig + 1, dreta, c);
		}
		return -1;
	}

	public String numContenidorsPerUbicacio() {
		int on;
		String [] adresa = new String [this.numContenidors];
		int []quants = new int [this.numContenidors];
		int cont=0;
		for (int i = 0; i<this.numContenidors; i++) {
			on = trobar(contenidor[i].getUbicacio(), adresa, cont);
			if (on == -1) {
				adresa[cont] = contenidor[i].getUbicacio();
				quants[i] = 1;
			}
			else {
				quants[on]++;
			}
		}
		return crear(adresa, quants, cont);
	}

	private static int trobar(String carrer, String[]adresa, int quants) {
		for (int i =0; i<quants; i++) {
			if (adresa[i].equals(carrer)) {
				return i; 
			}
		}
		return -1;
	}

	private static String crear(String[] adresa, int[] quants, int quantes) {
		String resultat = " ";
		for (int i=0; i<quantes; i++) {
			resultat += "Al carrer" + adresa[i] + "hi ha" +quants[i]+ "contenidors - ";
		}
		return resultat;
	}
	

	public void eliminarContenidor(ContenidorBrossa c) {
		int idx = cercaDicotomica(contenidor, 0, numContenidors-1, c);
		if(idx == -1) {
			return;
		}
		contenidor[idx] = null;
		for(int i = idx; i<numContenidors-1; i++) {
			contenidor[i] = contenidor[i+1];
		}
		numContenidors--;
	}

	public ContenidorBrossa mesRendiment(int tipus) {
		String reci ="";
		int major = 0;
		int conversio;
		ContenidorBrossa c = null;
		for (int i =0; i<this.numContenidors; i++) {
			switch (tipus){
			case 0:
				reci = ((Plastic) contenidor[i]).getReciclat().replaceFirst(" quilograms", "");
				conversio = Integer.parseInt(reci);
				if (contenidor[i] instanceof Plastic && major<conversio) {
					major = conversio;
					c = contenidor[i];
					
				}
			case 1:
				reci = ((Organic) contenidor[i]).getReciclat().replaceFirst(" quilograms", "");
				conversio = Integer.parseInt(reci);
				if (contenidor[i] instanceof Organic && major<conversio) {
					major = conversio;
					c = contenidor[i];
				}
			case 2:
				reci = ((Rebuig) contenidor[i]).getReciclat().replaceFirst(" quilograms", "");
				conversio = Integer.parseInt(reci);
				if (contenidor[i] instanceof Rebuig && major<conversio) {
					major = conversio;
					c = contenidor[i];
				}
			case 3:
				reci = ((Paper) contenidor[i]).getReciclat().replaceFirst(" quilograms", "");
				conversio = Integer.parseInt(reci);
				if (contenidor[i] instanceof Paper && major<conversio) {
					major = conversio;
					c = contenidor[i];
				}
			case 4:
				reci = ((Vidre) contenidor[i]).getReciclat().replaceFirst(" quilograms", "");
				conversio = Integer.parseInt(reci);
				if (contenidor[i] instanceof Vidre && major<conversio) {
					major = conversio;
					c = contenidor[i];
				}

			} 

		}return c;
	}

	public String toString() {
		String resultat = "";
		for (int i = this.numContenidors; i < 0; i--) {
			resultat += contenidor[i].toString() + " /n ";
		}
		return resultat;
	}

	public Poblacio PoblaciomesCarrer(Poblacio c) {
		if (c.getNumContenidorsCarrer()> this.numContenidorsCarrer) {
			return c;
		}
		else{
			return this;
		}
	}
	
	public boolean equals(Poblacio p) {
		String aquesta = this.numContenidorsPerUbicacio();
		String[] a = new String[numContenidors];
		String iguals1 = "";
		String iguals2 = "";
		
		a = aquesta.split("-");
		String[] pa = new String[numContenidors];
		pa = aquesta.split("-");
		
		Arrays.sort(a);
		Arrays.sort(pa);
		
		for(int i = 0; i<a.length; i++) {
			iguals1 += a[i];
			iguals2 += pa[i];
		}
		
		if(iguals1.compareTo(iguals2) == 0) {
			return true;
		}
		
		return false;
	}

}
