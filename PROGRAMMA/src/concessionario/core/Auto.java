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
		System.out.println(
				this.getTarga() + "-" + this.getProduttore() + "-" + this.getModello() + "-" + this.getAlimentazione()
						+ "-" + this.getColore() + "-" + this.getPrezzo() + " € -" + this.getNumeroPorte());

	}

	public Integer getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}


}
