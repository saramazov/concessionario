package concessionario.database;

import java.util.Collection;
import concessionario.core.Dipendente;
public class TableDipendente implements TableInterface<Integer, Dipendente> {

	private DriverInterface<Dipendente> driver;
	
	public TableDipendente(DriverInterface<Dipendente> driver) {
		this.driver = driver;
	}
	
	@Override
	public Boolean insert(Dipendente v) {
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente : dipendenti) {
			if(dipendente.getCid() == v.getCid()) {
				return false;
			}
		}
		dipendenti.add(v);
		return driver.write(dipendenti);
	}

	@Override
	public Collection<Dipendente> get() {
		return driver.read();
	}

	@Override
	public Dipendente get(Integer k) {   //si potrebbe controllare che non ritorni null (eccezione?)
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente : dipendenti) {
			if(dipendente.getCid() == k) {
				return dipendente;
			}
		}
		
		return null;
	}

	@Override
	public void update(Dipendente d) { //promozione ad amministratore?
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente:dipendenti) {
			if(dipendente.getCid() == d.getCid()) {
				dipendente.setNome(d.getNome());
				dipendente.setCognome(d.getCognome());
				dipendente.setAmministratore(d.getAmministratore());
			}
		}
		driver.write(dipendenti);
	}

	@Override
	public Boolean delete(Integer k) {
		Collection<Dipendente> dipendenti = driver.read();
		for(Dipendente dipendente : dipendenti) {
			if(dipendente.getCid() == k) {
				dipendenti.remove(dipendente);
			}
		}
		return driver.write(dipendenti);
	}

	@Override
	public void setDriver(DriverInterface<Dipendente> d) {
		this.driver = d;
	}

}
