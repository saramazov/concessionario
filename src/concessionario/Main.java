package concessionario;

import java.util.ArrayList;
import java.util.Collection;

import concessionario.core.Auto;
import concessionario.core.Dipendente;
import concessionario.core.Moto;
import concessionario.core.Veicolo;
import concessionario.database.DriverInterface;
import concessionario.database.DriverMemoryDipendente;
import concessionario.database.DriverMemoryVeicolo;

public class Main {

	public static void main(String[] args) {
		/*Collection<Dipendente> list = new ArrayList<Dipendente>();
		DriverInterface<Dipendente> driver = new DriverMemoryDipendente("prova.csv");
		list = driver.read();
		for(Dipendente dip:list) {
			System.out.println(dip.getCid()+" "+dip.getNome()+" "+dip.getCognome());
		}
		
		Collection<Dipendente> v = new ArrayList<Dipendente>();
		
		
		v.add(new Dipendente(1111,"cioa","dsdsd"));

		driver.write(v);
		list = driver.read();*/
		Collection<Veicolo> list = new ArrayList<Veicolo>();
		DriverInterface<Veicolo> driver = new DriverMemoryVeicolo("prova.csv");
		list = driver.read();
		for(Veicolo veicolo:list) {
			
			System.out.print(veicolo.getTarga()+" "+veicolo.getProduttore()+" "+veicolo.getModello()+" "+veicolo.getAlimentazione()+" "+veicolo.getColore()+" "+veicolo.getPrezzo()+" ");
			if(veicolo instanceof Auto) System.out.println(((Auto) veicolo).getNumeroPorte());
			else if(veicolo instanceof Moto) System.out.println(((Moto) veicolo).getAltezzaSedile());
		}
		
		Collection<Veicolo> v = new ArrayList<Veicolo>();
		
		
		v.add(new Auto("a", "bmw", "serie1", "benzina", "blu", 2345.67788, 4));

		driver.write(v);
		list = driver.read();
		
		
	
	}

}
