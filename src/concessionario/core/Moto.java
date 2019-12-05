package concessionario.core;

public class Moto extends Veicolo {
	public Moto(String targa, String produttore, String modello, String alimentazione, String colore, Double prezzo,Double altezzaSedile) {
		super(targa, produttore, modello, alimentazione, colore, prezzo);
		this.altezzaSedile=altezzaSedile;
		
		// TODO Auto-generated constructor stub
	}

	private Double altezzaSedile;

	@Override
	public void descrivi() {
		// TODO Auto-generated method stub
		
	}

	public Double getAltezzaSedile() {
		return altezzaSedile;
	}
	

}
