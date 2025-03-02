package Sessio3;

import java.util.GregorianCalendar;

public abstract class ContenidorBrossa implements Comparable{
	public final static int GROC = 0;
	public final static int MARRO = 1;
	public final static int GRIS = 2;
	public final static int BLAU = 3;
	public final static int VERD = 4;

	private String codi; 
	private int color; 
	private String ubicacio;
	private int any; 
	protected final double TARA; 

	public ContenidorBrossa(String codi, int color, String ubicacio, int any, double TARA) throws IllegalArgumentException, NullPointerException{
		if (color!=ContenidorBrossa.GROC && color!=ContenidorBrossa.MARRO && color!=ContenidorBrossa.GRIS &&
				color!=ContenidorBrossa.BLAU &&color!=ContenidorBrossa.VERD) {throw new IllegalArgumentException("Valors Incorrectes");}
		if (any != 0 && (any < 1000 || any > 9999)) {throw new IllegalArgumentException("Valors Incorrectes");}
		if (codi == null) {throw new NullPointerException("Valor null");}
		if (TARA<0) {throw new IllegalArgumentException("Valor incorrecte");}
		this.codi = codi;
		this.color = color; 
		this.ubicacio = ubicacio;
		this.any = any;
		this.TARA = TARA;
	}

	public ContenidorBrossa (String codi, int color, int any, double TARA){
		this(codi, color,"null", any, TARA);}

	public ContenidorBrossa (String codi, int color, String ubicacio, int TARA){
		this (codi, color, ubicacio, obtenirAnyActual(), TARA);}

	public static int obtenirAnyActual() {
		GregorianCalendar avui = new GregorianCalendar();
		int anyActual = avui.get(1);
		return anyActual;
	}
	
	public String getTipusBrossa()throws IllegalArgumentException{
		switch (this.color){
		case 0:
			return "Plastic";
		case 1:
			return "Organic";
		case 2:
			return "Rebuig";
		case 3:
			return "Paper";
		case 4:
			return "Vidre";
		default: 
			throw new IllegalArgumentException("Valor Incorrecte");
		}
	}

	public void retirarViaPublica()throws ExceptionContenidorBrossa{
		try {
			if (this.ubicacio!= null){
				this.ubicacio = null;
				this.any = 0;
			}
			else {
				throw new ExceptionContenidorBrossa("Error al retirar");
			}
		} catch(ExceptionContenidorBrossa e) {
			System.out.println("El contenidor ja està a l'ajuntament.");
		}
	}

	public void retirarViaPublica(ContenidorBrossa c [])throws ExceptionContenidorBrossa{
		for (int i= 0; i<c.length; i++){
			c[i].retirarViaPublica();
			c = null;
		}
	}

	public String getUbicacio(){ 
		if (this.ubicacio != null){
			return this.ubicacio;}
		else{
			return "Magatzem";
		}
	}

	public void setUbicacio(String ubicacio)throws ExceptionContenidorBrossa{
		if (ubicacio != null){
			this.ubicacio = ubicacio;
			this.any = obtenirAnyActual();
		}
		else{
			this.retirarViaPublica();
		}
	}

	public String getEstat()throws IllegalArgumentException{
		int diferencia = obtenirAnyActual()-this.any;
		if (diferencia>5){return "Vell";}
		else if (diferencia < 3 && diferencia> -1){return "Nou";}
		else if (diferencia<0) {throw new IllegalArgumentException("Valor Incorrecte d'any");}
		else{return "Semi Nou";}
	}

	public abstract void buidat (float pes);

	public boolean equals(Object c){
		if (this.compareTo(c)>0 || this.compareTo(c)<0){
			return false;
		}
		else{
			return true;
		}
	}

	public int compareTo(Object c) throws ClassCastException{
		ContenidorBrossa r;
		if (! (c instanceof ContenidorBrossa)) {
			throw new ClassCastException("L'objecte no pertany a la classe ContenidorBrossa");
		}
		r = (ContenidorBrossa) c;
		return this.codi.compareTo(r.codi);
	}


	public String toString () {
		String ubicacions;
		if (this.ubicacio!=null){
			ubicacions = this.ubicacio;
			}
		else{
			ubicacions = " retirat ";
			}

		return "Codi: " + this.codi + " Color: " + this.getTipusBrossa() + 
				" Ubicació: " + ubicacions + " l’Ajuntament Tara: " + Math.round((this.TARA*100)/100);
	}	

}