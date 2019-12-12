package concessionario.core;

public class Dipendente {

	 private Integer cid;
	 private String nome;
	 private String cognome;
	private Boolean amministratore;
	
	public Dipendente(Integer cid, String nome, String cognome, Boolean amministratore) {
		this.cid = cid;
		this.nome = nome;
		this.cognome = cognome;
		this.amministratore= amministratore;
	}
	
	public Integer getCid() {
		return cid;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String toString() {
		return this.getCid() + ". " + this.getNome() + " " + this.getCognome();
	}

	public Boolean getAmministratore() {
		return amministratore;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setAmministratore(Boolean amministratore) {
		this.amministratore = amministratore;
	}
	
}
