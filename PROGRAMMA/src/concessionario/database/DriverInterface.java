package concessionario.database;

import java.util.Collection;

public interface DriverInterface<V> {
	
	public Boolean write(Collection<V> v);
	
	public Collection<V> read();
	
}
