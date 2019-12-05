package concessionario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import concessionario.core.Auto;
import concessionario.core.Dipendente;
import concessionario.core.Moto;
import concessionario.core.Veicolo;
import concessionario.database.DriverInterface;
import concessionario.database.DriverMemoryDipendente;
import concessionario.database.DriverMemoryVeicolo;
import concessionario.database.TableDipendente;
import concessionario.database.TableVeicolo;

public class Main {

	public static void main(String[] args) {
		DriverInterface<Veicolo> driver = new DriverMemoryVeicolo("prova.csv");
		DriverInterface<Dipendente> driver2 = new DriverMemoryDipendente("prova2.csv");
		TableVeicolo table = new TableVeicolo(driver);
		TableDipendente table2 = new TableDipendente(driver2);
		
		//table.delete("c");
		//table2.delete(123);
		
		//table.insert(new Auto("d", "fiat", "panda", "diesel", "giallo", 200.50, 3));
		//table2.insert(new Dipendente(123, "luha", "rossi", false));
		
		Veicolo v = new Auto("d", "fiat", "punto", "diesel", "giallo", 200.50, 12);
		table.update(v);
		
		Dipendente d = new Dipendente(123, "Leo", "Mos", true);
		table2.update(d);
		
	
	}

}
