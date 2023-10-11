package gestion;

import java.util.ArrayList;
import java.util.List;

import entities.Arbre;
import entities.Decoracio;
import entities.Flor;
import entities.Floristeria;
import entities.LiniaTicket;
import entities.Producte;
import entities.Ticket;
import persistenciaSQL.Persistencia;
//import persistenciaSQL.GestioFichero;

public class Gestion implements IGestion {

	public Floristeria crearFloristeria(String nom) {
		Floristeria floristeria = new Floristeria(nom);
		Persistencia.saveFloristeria(nom);
		return floristeria;
	}

	public void retirarArbre(Arbre arbre, Floristeria floristeria) {
		if (arbre == null) {
			System.out.println("Arbre no trobat");
		} else {
			Persistencia.deleteArbre(arbre);
		}
	}

	public void retirarFlor(Flor flor, Floristeria floristeria) {
		if (flor == null) {
			System.out.println("Flor no trobada");
		} else {
			Persistencia.deleteFlor(flor);
		}
	}

	public void retirarDecoracio(Decoracio decoracio, Floristeria floristeria) {
		if (decoracio == null) {
			System.out.println("Decoracio no trobada");
		} else {
			Persistencia.deleteDecoracio(decoracio);
		}
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
		// GestioFichero.writeFloristeria(floristeria);
	}

	public void afegirArbre(Arbre arbol, Floristeria floristeria) {
		floristeria.getArbres().add(arbol);
		System.out.println("El arbol " + arbol.toString() + " se ha añadido");
		Persistencia.saveArbre(arbol);

	}

	public void afegirFlor(Flor flor, Floristeria floristeria) {
		floristeria.getFlors().add(flor);
		System.out.println("La flor " + flor.toString() + " se ha añadido");
		Persistencia.saveFlor(flor);
	}

	public void afegirDecoracio(Decoracio decoracio, Floristeria floristeria) {
		floristeria.getDecoracions().add(decoracio);
		System.out.println("La decoració " + decoracio.toString() + " se ha añadido");
		Persistencia.saveDecoracio(decoracio);

	}

	public void imprimirStock(Floristeria floristeria) {
		System.out.println("Productes:");
		System.out.println("----------");
		System.out.println("Arbres:");
		System.out.println(Persistencia.getArbres());
		System.out.println("Flors:");
		System.out.println(Persistencia.getFlors());
		System.out.println("Decoracions:");
		System.out.println(Persistencia.getDecoracions());

	}

	public static List<Arbre> getArbres() {

		return Persistencia.getArbres();

	}

	public static List<Flor> getFlors() {

		return Persistencia.getFlors();

	}

	public static List<Decoracio> getDecoracions() {

		return Persistencia.getDecoracions();

	}

	public void imprimirStockQuantitats(Floristeria floristeria) {
		System.out.println("Productes amb Quantitats:");
		System.out.println("----------");
		System.out.print("Arbres: ");
		// System.out.println(Persistencia.getArbres().size());
		System.out.println(Persistencia.getStockQuantitatsArbres());
		System.out.print("Flors: ");
		// System.out.println(Persistencia.getFlors().size());
		System.out.println(Persistencia.getStockQuantitatsFlors());
		System.out.print("Decoracions: ");
		// System.out.println(Persistencia.getDecoracions().size());
		System.out.println(Persistencia.getStockQuantitatsDecoracions());

	}

	public void imprimirStockValor(Floristeria floristeria) {
		System.out.println("Valor Total Productes de la floristeria : " + floristeria.getNom());
		System.out.println(Persistencia.getStockValor());
	}

	public Long crearTicket() {
		return Persistencia.saveTicket();
	}

	public List<LiniaTicket> mostrarTickets() {

		return Persistencia.getLiniesTickets();
	}

	public void visualitzarTotalTickets(Floristeria floristeria) {

		System.out.println(Persistencia.getDinersGuanyats());

	}

	public Floristeria inicialitzarFloristeria() {

		return new Floristeria("floristeria1");
	}

	public void crearLiniaTicket(Long producteId, Long ticketId) {

		Persistencia.saveLiniaTicket(producteId, ticketId);

	}
}
