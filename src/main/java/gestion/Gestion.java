package gestion;

import java.util.ArrayList;
import java.util.List;

import entities.Arbre;
import entities.Decoracio;
import entities.Flor;
import entities.Floristeria;
import entities.Producte;
import entities.Ticket;
import persistenciaSQL.GestioFichero;

public class Gestion implements IGestion {

	public Floristeria crearFloristeria(Long id, String nom) {
		Floristeria floristeria = new Floristeria(id, nom);
		GestioFichero.writeFloristeria(floristeria);
		return floristeria;
	}

	public void retirarArbre(Arbre arbre, Floristeria floristeria) {
		floristeria.getArbres().remove(arbre);
		GestioFichero.writeFloristeria(floristeria);

	}

	public void retirarFlor(Flor flor, Floristeria floristeria) {
		floristeria.getFlors().remove(flor);
		GestioFichero.writeFloristeria(floristeria);

	}

	public void retirarDecoracio(Decoracio decoracio, Floristeria floristeria) {
		floristeria.getDecoracions().remove(decoracio);
		GestioFichero.writeFloristeria(floristeria);

	}

	public Decoracio buscarDecoracio(Long id, List<Decoracio> listDeProducte) {
		Decoracio producto = null;
		int contador = 0;
		while (producto == null && contador < listDeProducte.size()) {
			if ((listDeProducte.get(contador)).getId() == id) {
				producto = listDeProducte.get(contador);
			}
			contador++;
		}

		return producto;
	}

	public Flor buscarFlor(Long id, List<Flor> listDeProducte) {
		Flor producto = null;
		int contador = 0;
		while (producto == null && contador < listDeProducte.size()) {
			if ((listDeProducte.get(contador)).getId() == id) {
				producto = listDeProducte.get(contador);
			}
			contador++;
		}

		return producto;
	}

	public Arbre buscarArbre(Long id, List<Arbre> listDeProducte) {
		Arbre producto = null;
		int contador = 0;
		while (producto == null && contador < listDeProducte.size()) {
			if ((listDeProducte.get(contador)).getId() == id) {
				producto = listDeProducte.get(contador);
			}
			contador++;
		}

		return producto;
	}

	public void afegirProducte(Producte producte, Ticket ticket, Floristeria floristeria) {
		ticket.getProductes().add(producte);
		System.out.println("El producte " + producte.toString() + " se ha añadido");
		GestioFichero.writeFloristeria(floristeria);
	}

	public void afegirArbre(Arbre arbol, Floristeria floristeria) {
		floristeria.getArbres().add(arbol);
		System.out.println("El arbol " + arbol.toString() + " se ha añadido");
		GestioFichero.writeFloristeria(floristeria);
	}

	public void afegirFlor(Flor flor, Floristeria floristeria) {
		floristeria.getFlors().add(flor);
		System.out.println("La flor " + flor.toString() + " se ha añadido");
		GestioFichero.writeFloristeria(floristeria);
	}

	public void afegirDecoracio(Decoracio decoracio, Floristeria floristeria) {
		floristeria.getDecoracions().add(decoracio);
		System.out.println("La decoració " + decoracio.toString() + " se ha añadido");
		GestioFichero.writeFloristeria(floristeria);

	}

	public void imprimirStock(Floristeria floristeria) {
		System.out.println("Productes:");
		System.out.println("----------");
		System.out.println("Arbres:");
		System.out.println(floristeria.getArbres());
		System.out.println("Flors:");
		System.out.println(floristeria.getFlors());
		System.out.println("Decoracions:");
		System.out.println(floristeria.getDecoracions());

	}

	public void imprimirStockQuantitats(Floristeria floristeria) {
		System.out.println("Productes amb Quantitats:");
		System.out.println("----------");
		System.out.print("Arbres: ");
		System.out.println(floristeria.getArbres().size());
		System.out.print("Flors: ");
		System.out.println(floristeria.getFlors().size());
		System.out.print("Decoracions: ");
		System.out.println(floristeria.getDecoracions().size());

	}

	public void imprimirStockValor(Floristeria floristeria) {
		System.out.print("Valor Total Productes de la floristeria : " + floristeria.getNom());
		System.out.println(
				floristeria.getValorArbres() + floristeria.getValorFlors() + floristeria.getValorDecoracions());

	}

	// public void crearTicket() {
	// return null;
	// }

	public void mostrarTickets(Floristeria floristeria) {
		for (Ticket ticket : floristeria.getTickets()) {
			System.out.println(ticket.getProductes());
		}

	}

	public void visualitzarTotalTickets(Floristeria floristeria) {
		double totalTickets = 0;

		for (Ticket ticket : floristeria.getTickets()) {
			totalTickets += ticket.getTotalTicket();
		}

		System.out.println(totalTickets);

	}

	public Floristeria inicialitzarFloristeria() {
		
		return GestioFichero.readFloristeria();
	}
}
