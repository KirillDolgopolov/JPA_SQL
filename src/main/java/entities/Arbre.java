package entities;

public class Arbre extends Producte{
	private double alcada;

	public Arbre() {
		
	}

	public Arbre(double preu, double alcada) {
		super(preu);
		this.alcada = alcada;
		
		
	}

	public double getAlcada() {
		return alcada;
	}

	public void setAlcada(double alcada) {
		this.alcada = alcada;
	}

	@Override
	public String toString() {
		return getId() +"\t" +  getPreu()+"\t" + alcada;
	}

	

	

	

	
	
}
