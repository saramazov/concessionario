package concessionario.database;

import java.util.Collection;

import concessionario.core.Auto;
import concessionario.core.Moto;
import concessionario.core.Veicolo;

public class TableVeicolo implements TableInterface<String, Veicolo> {

	private DriverInterface<Veicolo> driver;
	
	public TableVeicolo(DriverInterface<Veicolo> driver) {
		this.driver = driver;
	}
	
	@Override
	public Boolean insert(Veicolo v) {
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli) {
			if(veicolo.getTarga() == v.getTarga()) {
				return false;
			}
		}
		veicoli.add(v);
		return driver.write(veicoli);
	}

	@Override
	public Collection<Veicolo> get() {
		return driver.read();
	}

	@Override
	public Veicolo get(String k) throws NullPointerException {   //si potrebbe controllare che non ritorni null (eccezione?)
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo : veicoli) {
			if(veicolo.getTarga().equals(k)) {
				return veicolo;
			}
		}
		
		throw new NullPointerException();
	}

	@Override
	public void update(Veicolo v) { //promozione ad amministratore?
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veicolo:veicoli) {
			if(veicolo.getTarga().equals(v.getTarga())) {
				veicolo.setAlimentazione(v.getAlimentazione());
				veicolo.setColore(v.getColore());
				veicolo.setModello(v.getModello());
				veicolo.setProduttore(v.getProduttore());
				veicolo.setPrezzo(v.getPrezzo());
				if(veicolo instanceof Auto) ((Auto) veicolo).setNumeroPorte(((Auto) v).getNumeroPorte());
				else if(veicolo instanceof Moto) ((Moto) veicolo).setAltezzaSedile(((Moto) v).getAltezzaSedile());
			}
		}
		driver.write(veicoli);
	}

	@Override
	public Boolean delete(String k) {
		Collection<Veicolo> veicoli = driver.read();
		for(int i=veicoli.size()-1; i>=0; i--) {
			if(((Veicolo) veicoli.toArray()[i]).getTarga().equals(k)) {
				veicoli.remove(((Veicolo) veicoli.toArray()[i]));
			}
		}
		return driver.write(veicoli);
	}

	@Override
	public void setDriver(DriverInterface<Veicolo> d) {
		this.driver = d;
	}

}
