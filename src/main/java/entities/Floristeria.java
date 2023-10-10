package entities;

import java.util.ArrayList;
import java.util.List;

public class Floristeria  {
	private Long id;
	private String nom;
	
	private List<Arbre> arbres;
	private List<Flor> flors;
	private List<Decoracio> decoracions;
	private List<Ticket> tickets;

	public Floristeria(String nom) {
		this.nom = nom;
		this.arbres = new ArrayList<Arbre>();
		this.flors = new ArrayList<Flor>();
		this.decoracions = new ArrayList<Decoracio>();
		this.tickets = new ArrayList<Ticket>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Arbre> getArbres() {
		return arbres;
	}

	public List<Flor> getFlors() {
		return flors;
	}

	public List<Decoracio> getDecoracions() {
		return decoracions;
	}

	public List<Ticket> getTickets(){
		return tickets;
	}
	
	public double getValorArbres() {
		double total = 0;
		for (Arbre arbre : arbres) {
			total += arbre.getPreu();
		}
		return total;
	}

	public double getValorFlors() {
		double total = 0;
		for (Flor flor : flors) {
			total += flor.getPreu();
		}
		return total;
	}

	public double getValorDecoracions() {
		double total = 0;
		for (Producte decoracio : decoracions) {
			total += decoracio.getPreu();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Floristeria [id=" + id + ", nom=" + nom + "]";
	}

}
