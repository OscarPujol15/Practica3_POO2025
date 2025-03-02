package Sessio3;

import java.util.Random;

public class Prova2 {
	
	private static final String[] NOMS_POBLACIONS = {
			"Barcelona", "Girona", "Lleida", "Tarragona", "Reus", 
			"Sabadell", "Terrassa", "Mataró", "Manresa", "Vic"
	};

	private static final String[] NOMS_CARRERS = {
			"Major", "Catalunya", "Sant Joan", "Nou", "Mercè",
			"Rambla", "Diagonal", "Muntaner", "Balmes", "Gran Via"
	};

	private static final String[] CODIS_CONTENIDORS = {
			"AA-0001", "BB-0002", "CC-0003", "DD-0004", "EE-0005",
			"FF-0006", "GG-0007", "HH-0008", "II-0009", "JJ-0010"
	};

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("=== PROVES ALEATÒRIES ===\n");

		// Crear població aleatòria
		Poblacio poblacio = new Poblacio(NOMS_POBLACIONS[random.nextInt(NOMS_POBLACIONS.length)],random.nextInt(900000) + 100000, 10);

		// Afegir contenidors aleatoris
		for (int i = 0; i < 5; i++) {
			String codi = CODIS_CONTENIDORS[random.nextInt(CODIS_CONTENIDORS.length)];
			String carrer = NOMS_CARRERS[random.nextInt(NOMS_CARRERS.length)];
			int capacitat = random.nextInt(150) + 50;

			try {
				switch (random.nextInt(3)) {
				case 0:
					poblacio.afegirContenidor(new Vidre(codi, carrer, capacitat, 1505));
					break;
				case 1:
					poblacio.afegirContenidor(new Paper(codi, carrer, capacitat, 1505));
					break;
				case 2:
					poblacio.afegirContenidor(new Plastic(codi, carrer, capacitat, 1505));
					break;
				}
			} catch (Exception e) {
				System.out.println("Error en crear contenidor: " + e);
			}
		}

		// Mostrar llistats ordenats
		System.out.println("\nLLISTATS ORDENATS:");
		System.out.println("\nPer Reciclatge:");
		poblacio.toString();

	}

}
