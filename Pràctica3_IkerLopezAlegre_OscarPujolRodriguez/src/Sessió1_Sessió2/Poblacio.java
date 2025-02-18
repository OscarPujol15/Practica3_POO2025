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

	public void afegirContenidor(ContenidorBrossa p) {
		if (this.numContenidors >= contenidor.length) {
			ContenidorBrossa[] contenidor2 = new ContenidorBrossa[this.INCREMENT];
			for (int i =0; i<numContenidors; i++) {
				contenidor2[i] = contenidor[i];
			}
			contenidor2 = contenidor;
		}

		int i = 0;
		for (int j = this.numContenidors ; i<this.numContenidors || i == j ; i++, j--) {
			if (p.codi.compareTo(codi.this.contenidor[i]) >0 || p.codi.compareTo(codi.this.contenidor[i]) == 0){ // Error que no sabem. necessitem get?
				this.contenidor [j+1] = this.contenidor[j];
			}
		}
		this.contenidor [i] = p;
		this.numContenidors++;
		if (p.getUbicacio()!=(null)) {
			this.numContenidorsCarrer++;
		}
	}

	public void afegirContenidor(String codi, int color, String ubicacio, int any, float tara) {
		ContenidorBrossa p; 
		p = new ContenidorBrossa(codi,color, ubicacio, any, tara); // Error que no sabem.
		this.afegirContenidor(p);
	}

	public void afegirContenidor(ContenidorBrossa[] p) {
		for (int i =0; i<p.length; i++) {
			this.afegirContenidor(p[i]); // Assumeixo que l'enunciat es refereix a aquest metode.
		}
	}

	public String hiEs(String codi) {
		int posicio = cercaDicotomica(contenidor, numContenidors, 0, codi);
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
			if (codi.vector[mig].equals(buscat)) {	// Igual que l'error d'abans, codi no es visible
				return mig; 
			}
			if (codi.vector[mig].compareTo(buscat) > 0) {
				return cercaDicotomica(vector, esquerra, mig - 1, buscat);
			}
			return cercaDicotomica(vector, mig + 1, dreta, buscat);
		}
		return -1;
	}

	public String numContenidorsPerUbicacio() {
		int cont=0;
		String resultat ="";
		String adresa [] = new String [contenidor.length];
		int quants [] = new int [contenidor.length];
		for (int i = 0; i<this.numContenidors; i++) {
			adresa[i] = contenidor[i].getUbicacio();
		}
		for (int i = 0; i<this.numContenidors; i++) {
			i=trobar(contenidor[i].getUbicacio(),adresa, quants.length);
			for (int j = i; j<this.numContenidors; j++) {
				if (adresa[i].equals(adresa[j])) { 
					cont++;
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
		i = cercaDicotomica(contenidor, 0, this.numContenidors, c.codi){
			contenidor[i] = contenidor[i+1];
			i++;
		}
	}

	public ContenidorBrossa mesRendiment(int tipus) {
		int major=0;
		int quin =0; 
		for (int i =0; i<this.numContenidors; i++) {
			if (tipus == contenidor[i].color && contenidor[i].getRecilcat()>major) {
				quin = i; 
				major = contenidor[i].getRecilcat();
				
				
			}
		}
	}
}
