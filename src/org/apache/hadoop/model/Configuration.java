package org.apache.hadoop.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "configuration")
public class Configuration {

	public Configuration() {
		super();
	}

	private List<Property> kvs = new ArrayList<Property>();

	@Override
	public String toString() {
		return "Configuration [kvs=" + kvs + "]";
	}

	@XmlElement(name = "property")
	public List<Property> getKvs() {
		return kvs;
	}
	public void setKvs(List<Property> kvs) {
		this.kvs = kvs;
	}

}
