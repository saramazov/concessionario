package concessionario.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import concessionario.core.Auto;
import concessionario.core.Moto;
import concessionario.core.Veicolo;

public class DriverMemoryVeicolo implements DriverInterface<Veicolo> {

	private BufferedReader reader;
	private BufferedWriter writer;
	private String principale;
	
	public DriverMemoryVeicolo(String file ) {
		this.principale = file;
	}
	
	@Override
	public Collection<Veicolo> read() {
		
		String line;
		Collection<Veicolo> list = new ArrayList<Veicolo>();
		try {
			reader = new BufferedReader(new FileReader(this.principale));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			line = reader.readLine();
			while(line != null) {
				String[] lineSplit = line.trim().split(";");
				Veicolo veicolo;
				if(lineSplit[0].equals("Auto")) {
					veicolo = new Auto(lineSplit[1],lineSplit[2],lineSplit[3],lineSplit[4],lineSplit[5],Double.parseDouble(lineSplit[6]),Integer.parseInt(lineSplit[7]));
					list.add(veicolo);
				} else if(lineSplit[0].equals("Moto")) {
					veicolo = new Moto(lineSplit[1],lineSplit[2],lineSplit[3],lineSplit[4],lineSplit[5],Double.parseDouble(lineSplit[6]),Double.parseDouble(lineSplit[7]));
					
					list.add(veicolo);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return list;
	}
	
	@Override
	public Boolean write(Collection<Veicolo> v) {
		
		try {
			//Collection<Veicolo> list = new ArrayList<Veicolo>();
			//list = read();
			writer = new BufferedWriter(new FileWriter(this.principale));
			
			/*for(Veicolo veicolo:list) {
				if(veicolo instanceof Auto) writer.write("Auto;");
				else if(veicolo instanceof Moto) writer.write("Moto;");
				writer.write(veicolo.getTarga()+";");
				writer.write(veicolo.getProduttore()+";");
				writer.write(veicolo.getModello()+";");
				writer.write(veicolo.getAlimentazione()+";");
				writer.write(veicolo.getColore()+";");
				writer.write(veicolo.getPrezzo()+";");
				if(veicolo instanceof Auto) writer.write(((Auto) veicolo).getNumeroPorte()+";");
				else if(veicolo instanceof Moto) writer.write(((Moto) veicolo).getAltezzaSedile()+";");
				writer.newLine();
			}*/
			
			for(Veicolo veicolo:v) {
				if(veicolo instanceof Auto) writer.write("Auto;");
				else if(veicolo instanceof Moto) writer.write("Moto;");
				writer.write(veicolo.getTarga()+";");
				writer.write(veicolo.getProduttore()+";");
				writer.write(veicolo.getModello()+";");
				writer.write(veicolo.getAlimentazione()+";");
				writer.write(veicolo.getColore()+";");
				writer.write(veicolo.getPrezzo()+";");
				if(veicolo instanceof Auto) writer.write(((Auto) veicolo).getNumeroPorte()+";");
				else if(veicolo instanceof Moto) writer.write(((Moto) veicolo).getAltezzaSedile()+";");
				writer.newLine();
				
			}
			writer.close();
		} catch(IOException e) {
			return false;
		}
		
		return true;
	}
	
}
