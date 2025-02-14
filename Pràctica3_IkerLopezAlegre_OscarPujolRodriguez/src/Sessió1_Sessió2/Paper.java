package Sessió1_Sessió2;

public class Paper extends ContenidorBrossa {

	private float reciclat;
	
	public Paper (String codi, String ubicacio, int any, double TARA) {
		super (codi, ContenidorBrossa.MARRO, ubicacio, any, TARA);
		this.reciclat = 0;
	}
	
	public Paper (String codi, double TARA) {
		this(codi, null, obtenirAnyActual(), TARA );
	}
	
	public String getReciclat() {
		return this.reciclat + " quilograms";
	}
	
	public String toString() {
		 return super.toString() + "Paper reciclat : " + this.reciclat;
	 }
	
	public void buidat (float pes) {
		float kiloreci = (float) pes - (float) this.TARA;
		kiloreci = kiloreci*(float)0.95;
		this.reciclat += kiloreci;
	}
}
