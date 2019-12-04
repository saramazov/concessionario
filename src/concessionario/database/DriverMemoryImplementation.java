package concessionario.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DriverMemoryImplementation<V> implements DriverInterface {

	private BufferedReader reader;
	private BufferedWriter writer;
	private File input;
	private File output;
	
	public DriverMemoryImplementation(File principale, File backup) {
		this.input = principale;
		this.output = backup;

		try {
			reader = new BufferedReader(new FileReader(principale));
			writer = new BufferedWriter(new FileWriter(backup));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Collection<V> read() {
		String next;
		List<V> list = new ArrayList<V>();
		do {
			next =reader.readLine();
			if (next!=null) {
				String c = (String) next;
				writer.write(c);
				writer.newLine();
		}
		}while (next!=null);

		
		return newDb;
	}
	
	@Override
	public Boolean write(Collection v) {
		this.db = new ArrayList<>();
		return this.db.addAll(v);
	}

	

	
	/*int a;
	try {
		BufferedReader reader = new BufferedReader(new FileReader(input));
		BufferedWriter writer = new BufferedWriter(new FileWriter("input"));
	do {
		next =reader.readLine();
		//a = reader.read();
		if (next!=null) {
			String c = (String) next;
			writer.write(c);
			writer.newLine();
	}
	}while (next!=null);
	
	reader.close();
	writer.close();
	}
	catch (IOException e) {
		System.out.println("ERRORE di I/O");
		System.out.println(e);
	}*/
	
}
