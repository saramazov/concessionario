package concessionario.database;

import java.util.Collection;

public interface TableInterface<K, V> {
	
	public Boolean insert(V v);
	
	public Collection<V> get();
	
	public V get(K k);
	
	public void update(V v);
	
	public Boolean delete(K k);
	
	public void setDriver(DriverInterface<V> d);

}
