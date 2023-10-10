package entities;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private Long id;
	private Long floristeriaId;
	
	private List<Producte> productes;
		
	public Ticket() {
		productes = new ArrayList<Producte>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Producte> getProductes() {
		return productes;
	}

	public double getTotalTicket() {
		double total=0;
		for(Producte p: productes)
		total+=p.getPreu();
		return total;
	}
	
	public Long getFloristeriaId() {
		return floristeriaId;
	}

	public void setFloristeriaId(Long floristeriaId) {
		this.floristeriaId = floristeriaId;
	}

	@Override
	public String toString() {
		return id + "\n";
	}

	

}
