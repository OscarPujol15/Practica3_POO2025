package Sessio3;

public class Vidre extends ContenidorBrossa{
	
	private long reciclat;
	
	public Vidre (String codi, String ubicacio, int any, double TARA) {
		super (codi, ContenidorBrossa.VERD, ubicacio, any, TARA);
		this.reciclat = 0;
	}
	
	public Vidre (String codi, double TARA) {
		this(codi, null, obtenirAnyActual(), TARA );
	}
	
	public String getReciclat() {
		return this.reciclat + " envasos equivalents";
	}
	
	public String toString() {
		 return super.toString() + "Vidre reciclat : " + this.reciclat;
	 }
	
	public void buidat (float pes) {
		long kiloreci = (long) pes - (long) this.TARA;
		this.reciclat += (kiloreci*3);
	}
	

}
