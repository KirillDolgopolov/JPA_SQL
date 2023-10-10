package app;

import java.util.ArrayList;
import java.util.Scanner;
import entities.*;
import gestion.Gestion;


public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		// gestionar floristeria
		Gestion gestion = new Gestion();
		// floristeria a activar
		Floristeria floristeria = gestion.inicialitzarFloristeria();
		
		
		boolean onProgram = true;

		Byte opcion;

		while (onProgram) {

			System.out.println(" Floristeria actiu : " + ((floristeria != null) ? floristeria.getNom() : "cap"));

			System.out.println("-----------------\n");
			System.out.println(" 1.Crear Floristeria."); // obrir floristeria
			System.out.println(" 2.Afegir Arbre.");
			System.out.println(" 3.Afegir Flor.");
			System.out.println(" 4.Afegir Decoració.");
			System.out.println(" 5.Stock");
			System.out.println(" 6.Retirar arbre.");
			System.out.println(" 7.Retirar flor.");
			System.out.println(" 8.Retirar decoració.");
			System.out.println(" 9.Stock Amb Quantitats");
			System.out.println(" 10.Valor Stock");
			System.out.println(" 11.Crear ticket");
			System.out.println(" 12.Mostrar llista de compres antigues.");
			System.out.println(" 13.Diners guanyats");
			System.out.println(" 0.Sortir del programa");
			opcion = sc.nextByte();
			sc.nextLine();
			switch (opcion) {
			case 1:
				// 1.Crear Floristeria.
				floristeria = crearFloristeria(gestion);
				break;
			case 2:
				// 2.Afegir Arbre.
				if (floristeria != null) {
					afegirArbre(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 3:
				// 3.Afegir Flor.
				if (floristeria != null) {
					afegirFlor(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 4:
				// 4.Afegir Decoració.
				if (floristeria != null) {
					afegirDecoracio(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 5:
				// Stock: Imprimeix per pantalla tots els arbres, flors i decoració
				// que té la floristeria.
				// 5.Stock
				if (floristeria != null) {
					imprimirStock(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 6:
				// 6.Retirar arbre.
				if (floristeria != null) {
					retirarArbre(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 7:
				// 7.Retirar flor.
				if (floristeria != null) {
					retirarFlor(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 8:
				// 8.Retirar decoració.
				if (floristeria != null) {
					retirarDecoracio(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 9:
				// Printar per pantalla stock amb quantitats.
				// 9.Stock Amb Quantitats
				if (floristeria != null) {
					imprimirStockQuantitats(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 10:
				// Printar per pantalla valor total de la floristeria.
				// 10.Valor Stock // Valor Compres // ValorVendes
				if (floristeria != null) {
					imprimirValorStock(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 11:
				// Crear tickets de compra amb múltiples objectes.
				// 11.Compra amb múltiples objectes
				if (floristeria != null) {
					crearTicket(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 12:
				// Mostrar una llista de compres antigues.
				// 12.Compres Antigues.
				if (floristeria != null) {
					mostrarTickets(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
			case 13:
				// Visualitzar el total de diners guanyats amb totes les vendes.*/
				// 13.diners guanyats
				// Vendes
				if (floristeria != null) {
					visualitzarTotalTickets(gestion, floristeria);
				} else {
					System.out.println("No hi ha floristeria!!!");
				}
				break;
//			case 14:
//				// 14.Obrir Floristeria.
//				obrirFloristeria();
//				break;
			case 0:
				onProgram = false;
				System.out.println("Fin de programa.");
				break;

			default:
				break;
			}
		}

	}

	private static void afegirArbre(Gestion gestion, Floristeria floristeria) {
		System.out.println(" Alçada arbre ");
		double alcada = sc.nextDouble();
		System.out.println(" Preu arbre: ");
		double preu = sc.nextDouble();
		Arbre arbre = new Arbre(preu, alcada);
		gestion.afegirArbre(arbre, floristeria);

	}

	private static void afegirFlor(Gestion gestion, Floristeria floristeria) {

		System.out.println("Color flor: ");
		String color = sc.nextLine();
		System.out.println("Preu flor: ");
		double preu = sc.nextDouble();
		Flor flor = new Flor(preu, color);
		gestion.afegirFlor(flor, floristeria);

	}

	private static void afegirDecoracio(Gestion gestion, Floristeria floristeria) {
		System.out.println("Material decoracio: ");
		System.out.println("1. Fusta, 2. Plastic");
		Material material = (sc.nextByte() == 1) ? Material.FUSTA : Material.PLASTIC;
		System.out.println(" Preu decoracio: ");
		double preu = sc.nextDouble();
		Decoracio decoracio = new Decoracio(preu, material);
		gestion.afegirDecoracio(decoracio, floristeria);

	}

	private static void visualitzarTotalTickets(Gestion gestion, Floristeria floristeria) {
		gestion.visualitzarTotalTickets(floristeria);

	}

	private static void mostrarTickets(Gestion gestion, Floristeria floristeria) {
		System.out.println(gestion.mostrarTickets());

	}

	private static void crearTicket(Gestion gestion, Floristeria floristeria) {
		Ticket ticket = new Ticket();
		ticket.setFloristeriaId(floristeria.getId());
		ticket.setId(gestion.crearTicket());
		boolean finTicket = false;
		byte opcion;

		while (!finTicket) {
			System.out.println("1. Afegir arbre");
			System.out.println("2. Afegir flor");
			System.out.println("3. Afegir decoracio");
			System.out.println("0. Finalitzar ticket");
			opcion = sc.nextByte();

			switch (opcion) {
			case 1:
				System.out.println("Arbres:");
				System.out.println(gestion.getArbres());
				System.out.println("id del producte a passar al ticket: ");
				Long id = sc.nextLong();
				Arbre arbre = gestion.buscarArbre(id, gestion.getArbres());

				if (arbre != null) {
					gestion.crearLiniaTicket(id, ticket.getId());
					System.out.println("Arbre afegit al ticket");

				} else
					System.out.println("Producte amb aquest ID no trobat");
				break;
			case 2:
				System.out.println("Flors:");
				System.out.println(gestion.getFlors());
				System.out.println("id del producte a passar al ticket: ");
				Long id2 = sc.nextLong();
				Flor flor = gestion.buscarFlor(id2, gestion.getFlors());

				if (flor != null) {
					gestion.crearLiniaTicket(id2, ticket.getId());
					System.out.println("Flor afegida al ticket");

				} else
					System.out.println("Producte amb aquest ID no trobat");
				break;
			case 3:
				System.out.println("Decoracions:");
				System.out.println(gestion.getDecoracions());
				System.out.println("id del producte a passar al ticket: ");
				Long id3 = sc.nextLong();
				Decoracio decoracio = gestion.buscarDecoracio(id3, gestion.getDecoracions());

				if (decoracio != null) {
					gestion.crearLiniaTicket(id3, ticket.getId());
					System.out.println("Decoracio afegida al ticket");

				} else
					System.out.println("Producte amb aquest ID no trobat");
				break;
			case 0:
				finTicket = true;
				break;
			default:
				break;
			}

		}

		System.out.println(ticket.getProductes());
		floristeria.getTickets().add(ticket);
		
	}

	private static void imprimirValorStock(Gestion gestion, Floristeria floristeria) {
		gestion.imprimirStockValor(floristeria);

	}

	private static void imprimirStockQuantitats(Gestion gestion, Floristeria floristeria) {
		gestion.imprimirStockQuantitats(floristeria);

	}

	private static void retirarDecoracio(Gestion gestion, Floristeria floristeria) {
		System.out.println("Decoracions:");
		System.out.println(gestion.getDecoracions());
		System.out.println("id del producte a retirar: ");
		Long id = sc.nextLong();
		Decoracio decoracio = gestion.buscarDecoracio(id, gestion.getDecoracions());

		// buscar by id

		gestion.retirarDecoracio(decoracio, floristeria);
		if (decoracio != null) {
			System.out.println("Producte de decoracio retirat");
		} else
			System.out.println("Producte amb aquest ID no trobat");

	}

	private static void retirarFlor(Gestion gestion, Floristeria floristeria) {
		System.out.println("Flors:");
		System.out.println(gestion.getFlors());
		System.out.println("id del producte a retirar: ");
		Long id = sc.nextLong();
		Flor flor = gestion.buscarFlor(id, gestion.getFlors());

		// buscar by id

		gestion.retirarFlor(flor, floristeria);
		if (flor != null) {
			System.out.println("Flor retirada");
		} else
			System.out.println("Producte amb aquest ID no trobat");

	}

	private static void retirarArbre(Gestion gestion, Floristeria floristeria) {
		System.out.println("Arbres:");
		System.out.println(gestion.getArbres());
		System.out.println("id del producte a retirar: ");
		Long id = sc.nextLong();
		Arbre arbre = gestion.buscarArbre(id, gestion.getArbres());

		// buscar by id

		gestion.retirarArbre(arbre, floristeria);
		if (arbre != null) {
			System.out.println("Arbre retirat");
		} else
			System.out.println("Producte amb aquest ID no trobat");

	}

	private static void imprimirStock(Gestion gestion, Floristeria floristeria) {
		gestion.imprimirStock(floristeria);

	}

	private static Floristeria crearFloristeria(Gestion gestion) {
		System.out.println("Crear Floristeria.\n");
		System.out.println("nom : ");
		String nom = sc.nextLine();
		Long index = null; // generar index
		// Crear i recuperar Floristeria
		return gestion.crearFloristeria(nom);

	}

}
