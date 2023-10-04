package entities;

public class Decoracio extends Producte {
	private Material material;

	public Decoracio() {
		
	}

	public Decoracio(double preu, Material material) {
		super(preu);
		this.material = material;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return getId() +"\t" +  getPreu()+"\t" + material;
	}

}
