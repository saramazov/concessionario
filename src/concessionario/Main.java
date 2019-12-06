package concessionario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

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
	
	static Scanner input = new Scanner(System.in);
	static Integer cid = 0;
	static DriverInterface<Veicolo> driverV = new DriverMemoryVeicolo("prova.csv");
	static DriverInterface<Dipendente> driverD = new DriverMemoryDipendente("prova2.csv");
	static TableVeicolo tableV = new TableVeicolo(driverV);
	static TableDipendente tableD = new TableDipendente(driverD);
	
	static Veicolo v = new Auto(null, null, null, null, null, null, null);
	

	//static Dipendente d = new Dipendente(null, null, null, null);
	


	public static void main(String[] args) {
		Dipendente d = new Dipendente(221,"Luca","Mosciatti",false); 
		tableD.update(d);
		//System.out.println(tableV.get("NV867FD").getTarga());
		System.out.println(d.getCid());
		//System.out.println(tableD.get(221).getCid());
		//Collection<Dipendente> dipi =  tableD.get();
		//for(Dipendente di:dipi) {
			//System.out.println(di.toString());
		//}
		tableV.update(new Auto("NV867FD","autobianchi","34","porpora","diesel",1.0,2));
		
		
		// table.delete("c");
		// table2.delete(123);

		// table.insert(new Auto("d", "fiat", "panda", "diesel", "giallo", 200.50, 3));
		// table2.insert(new Dipendente(123, "luha", "rossi", false));

		

		System.out.println("******BENVENUTO NELLA NOSTRA CONCESSIONARIA !!!! ******");
		System.out.println("Sei un cliente o un Dipendente?\n1. Cliente\n2.Dipendente");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			cliente();
			break;
		case 2:

			
			descrivi();

			break;
		default:
			System.out.println("Scelta errata: la preghiamo di inserire una delle due scelte possibili !");
		}
	}

	public static void descrivi() {
		
		System.out.println("Inserisci CID: ");
	
		cid = input.nextInt();
		Dipendente dip;
		dip = tableD.get(cid);
		
		if (dip.getAmministratore()) {
			String uscita = "n";
			while(uscita.equals("n") || uscita.equals("N")) {
			System.out.println("Benvenuto "+dip.getNome()+ " "+dip.getCognome()+":\nSei un amministratore !");
			System.out.println("\n1. Visualizza Veicoli\n2.Visualizza Dipendenti\n3.Modifica Veicoli\n4.Modifica Personale");
			int scelta=0;
			scelta = input.nextInt();
			switch(scelta) {
			case 1:
				Collection <Veicolo>veicoli =tableV.get();
				for(Veicolo v:veicoli) {
					v.descrivi();
				}
				break;
			case 2: 
				Collection <Dipendente>dipendenti=tableD.get();
				for(Dipendente d:dipendenti) {
					if(d.getAmministratore() == false) System.out.println(d.toString());
				}
				
				break;
			case 3: 
				modificaVeicoli();
				break;
			case 4:
				modificaPersonale();
				break;
				default: 
					System.out.println("SELEZIONA UNA DELLE 4 POSSIBILITA'");
					break;
			}
			
			System.out.println("Vuoi uscire dal menu? [Y/N]");
			uscita = input.next();
			}
			
		}
		
	}

		public static void modificaVeicoli() {
			String uscita = "n";
			while(uscita.equals("n") || uscita.equals("N")) {
			System.out.println("\n1.Inserisci nuovo veicolo\n2.Elimina veicolo (venduto)");
			int scelta = 0;
			scelta = input.nextInt();
			switch (scelta) {
			case 1:
				System.out.println("Che tipo di veicolo vuoi inserire?");
				String choice = input.next();
				switch (choice) {
				case "auto":
					System.out.println("Inserisci Targa: ");
					String targa = input.next();
					System.out.println("Inserisci produttore: ");
					String produttore = input.next();
					System.out.println("Inserisci modello: ");
					String modello = input.next();
					System.out.println("Inserisci alimentazione: ");
					String alimentazione = input.next();
					System.out.println("Inserisci colore: ");
					String colore = input.next();
					System.out.println("Inserisci prezzo: ");
					Double prezzo = input.nextDouble();
					System.out.println("Inserisci numero portiere: ");
					Integer numeroPorte = input.nextInt();
					tableV.insert(new Auto(targa,produttore,modello,alimentazione,colore,prezzo,numeroPorte));
					break;
				case "Auto":
					System.out.println("Inserisci Targa: ");
					targa = input.next();
					System.out.println("Inserisci produttore: ");
					produttore = input.next();
					System.out.println("Inserisci modello: ");
					modello = input.next();
					System.out.println("Inserisci alimentazione: ");
					alimentazione = input.next();
					System.out.println("Inserisci colore: ");
					colore = input.next();
					System.out.println("Inserisci prezzo: ");
					prezzo = input.nextDouble();
					System.out.println("Inserisci numero portiere: ");
					numeroPorte = input.nextInt();
					tableV.insert(new Auto(targa,produttore,modello,alimentazione,colore,prezzo,numeroPorte));
					break;
				case "moto":
					System.out.println("Inserisci Targa: ");
					targa = input.next();
					System.out.println("Inserisci produttore: ");
					produttore = input.next();
					System.out.println("Inserisci modello: ");
					modello = input.next();
					System.out.println("Inserisci alimentazione: ");
					alimentazione = input.next();
					System.out.println("Inserisci colore: ");
					colore = input.next();
					System.out.println("Inserisci prezzo: ");
					prezzo = input.nextDouble();
					System.out.println("Inserisci altezza sedile: ");
					Double altezzaSedile = input.nextDouble();
					tableV.insert(new Moto(targa,produttore,modello,alimentazione,colore,prezzo,altezzaSedile));
					break;
				case "Moto":
					System.out.println("Inserisci Targa: ");
					targa = input.next();
					System.out.println("Inserisci produttore: ");
					produttore = input.next();
					System.out.println("Inserisci modello: ");
					modello = input.next();
					System.out.println("Inserisci alimentazione: ");
					alimentazione = input.next();
					System.out.println("Inserisci colore: ");
					colore = input.next();
					System.out.println("Inserisci prezzo: ");
					prezzo = input.nextDouble();
					System.out.println("Inserisci numero portiere: ");
					altezzaSedile= input.nextDouble();
					tableV.insert(new Moto(targa,produttore,modello,alimentazione,colore,prezzo,altezzaSedile));
					break;
					default: System.out.println("SELEZIONA UNA DELLE 2 POSSIBILITA'");
				}
				
				break;
			case 2:
				System.out.println("Inserisci la targa del veicolo che vuoi eliminare: ");
				String targa = input.next();
				Boolean finder = tableV.delete(targa);
				if (finder == false) {
					System.out.println("Il veicolo non esiste!");
				}
				else System.out.println("Il veicolo è stato eliminato!");
				break;
				default:
					System.out.println("SELEZIONA UNA DELLE 4 POSSIBILITA'");
					break;
			}
			
			System.out.println("Hai finito di modificare veicoli? [Y/N]");
			uscita = input.next();
			
			}
}
		
		public static void modificaPersonale() {
			System.out.println("\n1.Inserisci nuovo dipendente\n2.Elimina dipendente\n3.Aggiorna Dipendenti");
			int scelta = 0;
			scelta = input.nextInt();
			switch (scelta) {
			case 1:	System.out.println("Inserisci CID: ");
				Integer cid = input.nextInt();
				System.out.println("Inserisci nome: ");
				String nome = input.next();
				System.out.println("Inserisci cognome: ");
				String cognome = input.next();
				System.out.println("Inserisci grado (amministratore/dipendente): ");
				String grado = input.next();
				Boolean b = false;
				if(grado.equals("amministratore") || grado.equals("Amministratore")) b = true;
				tableD.insert(new Dipendente(cid,nome,cognome,b));
				break;
			case 2:	System.out.println("Inserisci il CID del dipendente che vuoi eliminare: ");
					cid = input.nextInt();
					Boolean finder = tableD.delete(cid);
					if (finder == false) {
						System.out.println("Il dipendente non esiste!");
					}
				break;
			case 3: update();
			break;
				default:
					System.out.println("SELEZIONA UNA DELLE 4 POSSIBILITA'");
					break;
			
		}
			
			
				
			
}
		public static void update() {
			String nome = null;
			String cognome = null;
			Boolean degree = null;
			String grado = null;
			String choice;
			Boolean b = false;
			System.out.println("Inserisci il Cid del dipendente che vuoi modificare");
			Integer cid =input.nextInt();
			Dipendente dip;
			
			do {
			System.out.println("Cosa desideri modificare? (nome/cognome/grado)\nPer uscire digitare esci ");
			choice = input.next();
			switch (choice) {
			case ("nome"): System.out.println("Inserisci il nuovo nome: ");
			nome = input.next();
			break;
			case ("cognome"): System.out.println("Inserisci il nuovo cognome: ");
			cognome = input.next();
			break;
			case ("grado"):System.out.println("Inserisci il nuovo grado: ");
			grado = input.next();
			if(grado.equals("amministratore") || grado.equals("Amministratore")) b = true;
			break;
			default: System.out.println("SELEZIONA UNA DELLE POSSIBILITA'");
			break;			
			}
				
			}while (!choice.equals("esci"));
					
			tableD.update(new Dipendente(cid,nome,cognome,b));

			
		}
		
		public static void cliente() {
			System.out.println("1. Visualizza veicoli");
			int choice = 0;
			choice = input.nextInt();
			switch (choice) {
			case 1:
				Collection <Veicolo>veicoli =tableV.get();
				for(Veicolo v:veicoli) {
					v.descrivi();
				}
				break;
				default:
					System.out.println("SCEGLI UNA DELLE SELEZIONI POSSIBILI !!!");
					break;
			}
			
		}
		
}
