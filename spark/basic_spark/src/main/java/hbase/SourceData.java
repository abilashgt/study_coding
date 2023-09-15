package hbase;

import java.io.Serializable;

public class SourceData implements Serializable{

	//private String id;
	private String name;
	//private double voltageA;
	//private long totalCount = 1;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SourceData{" +
				"name='" + name + '\'' +
				'}';
	}
}
