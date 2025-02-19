package Sessió1_Sessió2;

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
		for (int i = this.numContenidors ; i<this.numContenidors ;i++) {
			if (p.compareTo(this.contenidor[i]) == 0) {
				return;
			}
			if (p.compareTo(this.contenidor[i]) >0){ 
				augmentarContenidor();
				this.contenidor
				this.numContenidors++;
				if (p.getUbicacio()!=(null)) {
					this.numContenidorsCarrer++;
					return;
				}
			}
		}
		this.contenidor [this.numContenidors] = p;
		this.numContenidors++;
		if (p.getUbicacio()!=(null)) {
			this.numContenidorsCarrer++;
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
			this.afegirContenidor(codi,color,ubicacio,any,tara); // Assumeixo que l'enunciat es refereix a aquest metode.
		}
	}

	public String hiEs(String codi) {
		int posicio = cercaDicotomica(contenidor, 0, numContenidors, codi);
		if (posicio != -1) {
			return contenidor[posicio].getTipusBrossa(); // S'ha de fer un switch per saber el color o es el tipus brossa.
		}
		else {
			return "No hi és";
		}

	}

	public static int cercaDicotomica(ContenidorBrossa[] vector, int esquerra, int dreta, String buscat) { // S'ha de tenir com ha metode complementari?
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

	public String numContenidorsPerUbicacio() {
		int on;
		String [] adresa = new String [this.numContenidors];
		int []quants = new int [this.numContenidors];
		for (int k=0; k<this.numContenidors; k++) {
			quants[k] = 1;
			adresa[k] = contenidor[k].getUbicacio();
		}
		
		for (int i = 0; i<this.numContenidors; i++) {
			on = trobar(contenidor[i].getUbicacio(), adresa, this.numContenidors);
				for (int j = 0; j<this.numContenidors-1; j++) {
					if (adresa[on].equals(adresa[j])) {
						quants[i]++;
						
				}
			}
		}
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
		int i = 0; 
		i = cercaDicotomica(contenidor, 0, this.numContenidors, c){
			contenidor[i] = contenidor[i+1];
			i++;
		}
	}

	public ContenidorBrossa mesRendiment(int tipus) {
		int major=0;
		int quin =0; 
		for (int i =0; i<this.numContenidors; i++) {
			
			switch (tipus){
			case 0:
				if (contenidor[i] instanceof Plastic && major< contenidor[i].getReciclat()) {
				
				}
			case 1:
				
			case 2:
			
			case 3:
				
			case 4:
				
			default: 
				return;
			} 


			}
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
	
}


