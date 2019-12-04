package concessionario.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DriverMemoryImplementation<V> implements DriverInterface {

	private List<V> db;
	
	public DriverMemoryImplementation() {
		this.db = new ArrayList<>();
	}
	
	@Override
	public Boolean write(Collection v) {
		this.db = new ArrayList<>();
		return this.db.addAll(v);
	}

	@Override
	public Collection<V> read() {
		return this.db;
	}

}
