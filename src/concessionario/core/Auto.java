package concessionario.core;

public class Auto extends Veicolo {
	public Auto(String targa, String produttore, String modello, String alimentazione, String colore, Double prezzo,
			Integer numeroPorte) {
		super(targa, produttore, modello, alimentazione, colore, prezzo);
		this.numeroPorte = numeroPorte;
	}

	private Integer numeroPorte;
	


	@Override
	public void descrivi() {
		// TODO Auto-generated method stub
		
	}

	public Integer getNumeroPorte() {
		return numeroPorte;
	}


}
