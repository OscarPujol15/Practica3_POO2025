package Sesso1_Sessio2;

public class Organic extends ContenidorBrossa{
	
	private float reciclat;
	
	public Organic (String codi, String ubicacio, int any, double TARA) {
		super (codi, ContenidorBrossa.MARRO, ubicacio, any, TARA);
		this.reciclat = 0;
	}
	
	public Organic (String codi, double TARA) {
		this(codi, null, obtenirAnyActual(), TARA );
	}
	
	public String getReciclat() {
		return this.reciclat + "tones";
	}
	
	 public String toString() {
		 return super.toString() + "Organic reciclat : " + this.reciclat;
	 }
	 
		public void buidat (float pes) {
			float kiloreci = (float) pes - (float) this.TARA;
			kiloreci = kiloreci*(float)0.90;
			kiloreci = kiloreci/1000;
			this.reciclat += kiloreci;
		}
}
