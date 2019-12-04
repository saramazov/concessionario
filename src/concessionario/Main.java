package concessionario;

import concessionario.core.Dipendente;
import concessionario.database.DriverInterface;
import concessionario.database.DriverMemoryImplementation;
import concessionario.database.TableDipendenteImplementation;
import concessionario.database.TableInterface;

public class Main {

	public static void main(String[] args) {
		DriverInterface<Dipendente> driver = new DriverMemoryImplementation();
		TableInterface<Integer, Dipendente> tabellaDipendente = new TableDipendenteImplementation(driver);
		
		tabellaDipendente.insert(new Dipendente(1, "Mario", "Rossi"));
		tabellaDipendente.insert(new Dipendente(10, "Mario", "Rossi"));
		tabellaDipendente.insert(new Dipendente(2, "Mario", "Rossi"));
		
		for(Dipendente d : tabellaDipendente.get()) {
			System.out.println(d);
		}
	}

}
