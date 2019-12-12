package concessionario.database;

public interface CSVSerializer<E> {
	public String toCSV();
	
	public E fromCSV(String s);
}
