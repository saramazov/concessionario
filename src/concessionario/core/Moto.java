package concessionario.core;

public class Moto extends Veicolo {
	public Moto(String targa, String produttore, String modello, String alimentazione, String colore, Double prezzo,Double altezzaSedile) {
		super(targa, produttore, modello, alimentazione, colore, prezzo);
		this.altezzaSedile=altezzaSedile;
	}

	private Double altezzaSedile;

	@Override
	public void descrivi() {
		System.out.println(
				this.getTarga() + "-" + this.getProduttore() + "-" + this.getModello() + "-" + this.getAlimentazione()
						+ "-" + this.getColore() + "-" + this.getPrezzo() + " � -" + this.getAltezzaSedile()+"m");
	}

	public Double getAltezzaSedile() {
		return altezzaSedile;
	}

	public void setAltezzaSedile(Double altezzaSedile) {
		this.altezzaSedile = altezzaSedile;
	}
	

}
