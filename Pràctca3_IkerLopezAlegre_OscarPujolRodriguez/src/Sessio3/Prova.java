package Sessio3;

import java.util.Random;

public class Prova {
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

	public static void main(String[] args){

		main1();
		mainAleatori();

	}



	private static void main1() {
		System.out.println("=== PROVES DE GESTIÓ D'ERRORS I POLIMORFISME ===\n");

		// 1. Proves de creació d'objectes amb valors incorrectes
		provarCreacioObjectes();

		// 2. Proves de mètodes amb paràmetres incorrectes
		provarMetodesParametres();

		// 3. Proves de polimorfisme i interfícies
		provarPolimorfisme();



	}
	private static void provarCreacioObjectes() {
		System.out.println("1. PROVES DE CREACIÓ D'OBJECTES");

		try {
			Poblacio p = new Poblacio("", -100, 10);
		} catch (IllegalArgumentException e) {
			System.out.println("OK: Detectat components negatius: " + e);
		}

		try {
			ContenidorBrossa cv = new Vidre("XX-INVALID", "", -50, 10);
		} catch (IllegalArgumentException e) {
			System.out.println("OK: Detectat codi incorrecte: " + e);
		}
	}

	private static void provarMetodesParametres() {
		System.out.println("\n2. PROVES DE MÈTODES AMB PARÀMETRES INCORRECTES");

		try {
			Poblacio p = new Poblacio("Barcelona", 1000, 10);
			p.afegirContenidor(new Vidre(null, "", -50, 10));
		} catch (NullPointerException e) {
			System.out.println("OK: Detectat contenidor null: " + e);
		} catch(IllegalArgumentException e) {
			System.out.println("OK: Detectat valor negatiu " + e);
		}
	}

	private static void provarPolimorfisme() {
		System.out.println("\n3. PROVES DE POLIMORFISME I INTERFÍCIES");

		ContenidorBrossa c1 = new Vidre("AA-0001", 3505);
		ContenidorBrossa c2 = new Paper("BB-0002", 2505);
		ContenidorBrossa c3 = new Plastic("CC-0003", "Major", 2024, 1505);

		System.out.println("\nMostrant toString() dels contenidors:");
		System.out.println("\nContenidor 1:");
		System.out.println(c1.toString());
		System.out.println("\nContenidor 2:");
		System.out.println(c2.toString());
		System.out.println("\nContenidor 3:");
		System.out.println(c3.toString());

		System.out.println("\nAra executem les proves aleatòries...\n");
	}


	public static void mainAleatori(){
		Random random = new Random();
		System.out.println("=== PROVES ALEATÒRIES ===\n");

		Poblacio[] poblacions = new Poblacio[5];

		for (int i = 0; i < poblacions.length; i++) {
			String nomPoblacio = NOMS_POBLACIONS[random.nextInt(NOMS_POBLACIONS.length)];
			poblacions[i] = new Poblacio(nomPoblacio, random.nextInt(900000) + 100000, 10);

			for (int j = 0; j < 5; j++) {
				String codi = CODIS_CONTENIDORS[random.nextInt(CODIS_CONTENIDORS.length)];
				String carrer = NOMS_CARRERS[random.nextInt(NOMS_CARRERS.length)];
				int capacitat = random.nextInt(150);
				int tara = random.nextInt(4500);

				try {
					ContenidorBrossa contenidor = null;

					int tipus = random.nextInt(5);
					switch (tipus) {
					case 0:
						contenidor = new Vidre(codi, carrer, 2024, tara);
					case 1:
						contenidor = new Paper(codi, carrer, 2024, tara);
					case 2:
						contenidor = new Plastic(codi, carrer, 2024, tara);
					case 3:
						contenidor = new Organic(codi, carrer, 2024, tara);
					case 4:
						contenidor = new Rebuig(codi, carrer, 2024, tara);
					}

					poblacions[i].afegirContenidor(contenidor);
				} catch (IllegalArgumentException e) {
					System.out.println("Error en crear contenidor: " + e);
				}
			}
		}

		System.out.println("\nLLISTATS ORDENATS:");

		System.out.println("\nOrdenat per reciclatge (ascendent):");
		Poblacio.llistatOrdenatAscendent(poblacions);

		System.out.println("\nOrdenat per reciclatge (descendent):");
		Poblacio.llistatOrdenatDescendent(poblacions);
	}
}
