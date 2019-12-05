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
		return this.cid + ". " + this.nome + " " + this.cognome;
	}

	public Boolean getAmministratore() {
		return amministratore;
	}
	
}
