package Sessio3;

public class Plastic extends ContenidorBrossa {

	private float reciclat;
	
	public Plastic (String codi, String ubicacio, int any, double TARA) {
		super (codi, ContenidorBrossa.GROC, ubicacio, any, TARA);
		this.reciclat = 0;
	}
	
	public Plastic (String codi, double TARA) {
		this(codi, null, obtenirAnyActual(), TARA );
	}
	
	public String getReciclat() {
		return this.reciclat + " quilograms";
	}
	
	public String toString() {
		 return super.toString() + "Plastic reciclat : " + this.reciclat;
	 }
	
	public void buidat (float pes) {
		float kiloreci = (float) pes - (float) this.TARA;
		kiloreci = kiloreci*(float)0.80;
		this.reciclat += kiloreci;
	}
	
	public double getPes (int sistema) throws IllegalArgumentException{
			switch (sistema) {
			case 10:
				return (double) this.reciclat;
			case 12:
				return (double) this.reciclat*Pesable.LLIURA;
			default: 
				throw new IllegalArgumentException("Valor incorrecte" + sistema);
			}
	}
}
