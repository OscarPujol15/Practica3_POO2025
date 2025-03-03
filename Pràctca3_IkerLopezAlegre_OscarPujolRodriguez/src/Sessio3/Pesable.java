package Sessio3;

public interface Pesable {
	public static final int SISTEMA_METRIC = 10;
	
	public static final int SISTEMA_ANGLOSAXO= 12;

	public static final double LLIURA = 0.45359237;
	
	public double getPes (int sistema) throws IllegalArgumentException; 
}