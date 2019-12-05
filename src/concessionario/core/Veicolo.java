package concessionario.core;

public abstract class Veicolo {
	
	
	private String targa;
	private String produttore;
	private String modello;
	private String alimentazione;
	private String colore;
	private Double prezzo;
	
	public Veicolo(String targa, String produttore, String modello, String alimentazione, String colore,
			Double prezzo) {
		this.targa = targa;
		this.produttore = produttore;
		this.modello = modello;
		this.alimentazione = alimentazione;
		this.colore = colore;
		this.prezzo = prezzo;
	}

	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public String getTarga() {
		return targa;
	}
	public String getProduttore() {
		return produttore;
	}
	public String getModello() {
		return modello;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public String getColore() {
		return colore;
	}
	

	
	public abstract void descrivi();

	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public void setColore(String colore) {
		this.colore = colore;
	} 
		
	
	
}
