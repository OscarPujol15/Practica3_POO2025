package Sessió1_Sessió2;

public class Rebuig extends ContenidorBrossa{
	private float reciclat;
	
	public Rebuig (String codi, String ubicacio, int any, double TARA) {
		super (codi, ContenidorBrossa.MARRO, ubicacio, any, TARA);
		this.reciclat = 0;
	}
	
	public Rebuig (String codi, double TARA) {
		this(codi, null, obtenirAnyActual(), TARA );
	}
	
	public String getReciclat() {
		return this.reciclat + " tones";
	}
	
	public String toString() {
		 return super.toString() + "Rebuig reciclat : " + this.reciclat;
	 }
	
	public void buidat (float pes) {
		float kiloreci = (float) pes - (float) this.TARA;
		kiloreci = kiloreci*(float)0.75;
		kiloreci = kiloreci/1000;
		this.reciclat += kiloreci;
	}
}

