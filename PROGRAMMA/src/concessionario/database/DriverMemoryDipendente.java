package concessionario.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import concessionario.core.Dipendente;

public class DriverMemoryDipendente implements DriverInterface<Dipendente> {

	private BufferedReader reader;
	private BufferedWriter writer;
	private String principale;
	
	public DriverMemoryDipendente(String file ) {
		this.principale = file;
	}
	
	@Override
	public Collection<Dipendente> read() {
		
		String line;
		Collection<Dipendente> list = new ArrayList<Dipendente>();
		try {
			reader = new BufferedReader(new FileReader(this.principale));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			line = reader.readLine();
			while(line != null) {
				String[] lineSplit = line.trim().split(";");
				Dipendente dip = new Dipendente(Integer.parseInt(lineSplit[0]),lineSplit[1],lineSplit[2],Boolean.parseBoolean(lineSplit[3]));
				list.add(dip);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return list;
	}
	
	@Override
	public Boolean write(Collection<Dipendente> v) {
		
		try {
			//Collection<Dipendente> list = new ArrayList<Dipendente>();
			//list = read();
			writer = new BufferedWriter(new FileWriter(this.principale));
			
			/*for(Dipendente dip:list) {
				writer.write(dip.getCid()+";");
				writer.write(dip.getNome()+";");
				writer.write(dip.getCognome()+";");
				writer.newLine();
			}*/
			
			for(Dipendente dip:v) {
				writer.write(dip.getCid()+";");
				writer.write(dip.getNome()+";");
				writer.write(dip.getCognome()+";");
				writer.write(dip.getAmministratore().toString());
				writer.newLine();
			}
			writer.close();
		} catch(IOException e) {
			return false;
		}
		
		return true;
	}
	
}
