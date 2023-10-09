package entities;

public abstract class Producte {
	
	//private static Long index=0L;
	private Long id;
	private double preu;
	private Long floristeriaId;
	private boolean enStock;
	
	/*public static Long getIndex() {
		return index++;
	}*/
	
	public Producte(double preu) {
		//id = getIndex();
		this.preu = preu;
	}

	public Producte() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public Long getFloristeriaId() {
		return floristeriaId;
	}

	public void setFloristeriaId(Long floristeriaId) {
		this.floristeriaId = floristeriaId;
	}

	public boolean isEnStock() {
		return enStock;
	}

	public void setEnStock(boolean enStock) {
		this.enStock = enStock;
	}

	
	


}
