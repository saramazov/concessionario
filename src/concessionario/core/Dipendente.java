package concessionario.core;

public class Dipendente {

	private Integer cid;
	private String nome;
	private String cognome;
	
	public Dipendente(Integer cid, String nome, String cognome) {
		this.cid = cid;
		this.nome = nome;
		this.cognome = cognome;
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
	
}
