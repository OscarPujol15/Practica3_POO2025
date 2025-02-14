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
	
	public void afegirContenidor(ContenidorBrossa p) {}
	
	public ContenidorBrossa mesRendiment(int tipus) {
		for (int i =0; i<this.numContenidors; i++) {
			if (this.contenidors[i].)) {
				
			}
		}
		
	}
}
