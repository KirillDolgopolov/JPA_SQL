package gestion;

import java.util.List;

import entities.Arbre;
import entities.Decoracio;
import entities.Flor;
import entities.Floristeria;
import entities.LiniaTicket;

public interface IGestion {

	Floristeria crearFloristeria(String nom);

	void retirarArbre(Arbre arbre, Floristeria floristeria);

	void retirarFlor(Flor flor, Floristeria floristeria);

	void retirarDecoracio(Decoracio decoracio, Floristeria floristeria);

	void afegirArbre(Arbre arbol, Floristeria floristeria);

	void afegirFlor(Flor flor, Floristeria floristeria);

	void afegirDecoracio(Decoracio decoracio, Floristeria floristeria);

	void imprimirStock(Floristeria floristeria);

	void imprimirStockQuantitats(Floristeria floristeria);

	void imprimirStockValor(Floristeria floristeria);

	Long crearTicket();

	List<LiniaTicket> mostrarTickets();

	void visualitzarTotalTickets(Floristeria floristeria);
	
	void crearLiniaTicket(Long producteId, Long ticketId);

}
