package Sessió3;

import java.util.GregorianCalendar;

public abstract class ContenidorBrossa implements Comparable, Pesable {
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

	public ContenidorBrossa(String codi, int color, String ubicacio, int any, double TARA){
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
	
	public String getTipusBrossa(){
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
			return "Error";
		}
	}

	public void retirarViaPublica(){
		if (this.ubicacio!= null){
			this.ubicacio = null;
			this.any = 0;
		}
	}

	public void retirarViaPublica(ContenidorBrossa c []){
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

	public void setUbicacio(String ubicacio){
		if (ubicacio != null){
			this.ubicacio = ubicacio;
		}
		else{
			this.retirarViaPublica();
		}
	}

	public String getEstat(){
		int diferencia = 2025-this.any;
		if (diferencia>5){
			return "Vell";}
		else if (diferencia < 3){
			return "Nou";}
		else{
			return "Semi Nou";}
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

	public int compareTo(Object c){
		ContenidorBrossa r;
		if (! (c instanceof ContenidorBrossa)) {
			return 32;
		}
		r = (ContenidorBrossa) c;
		if (this.codi.compareTo(r.codi)<0) {return -1;}
		else if (this.codi.compareTo(r.codi)>0) {return 1;}
		else {return 0;}
	}


	public String toString () {
		String ubicacions;
		if (this.ubicacio!=null){
			ubicacions = this.ubicacio;
			}
		else{
			ubicacions = "retirat";
			}

		return "Codi: " + this.codi + "Color: " + this.getTipusBrossa() + 
				"Ubicació:" + ubicacions + "l’Ajuntament Tara:" + Math.round((this.TARA*100)/100);
	}	

}
