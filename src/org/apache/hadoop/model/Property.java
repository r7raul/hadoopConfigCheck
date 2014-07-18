package org.apache.hadoop.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "property")
public class Property {
	
	
	public Property() {
		super();
	}
	
	public Property(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	private String name;
	private String value;
	
	@XmlElement(name="name") 
	public String getName() {
		return name;
	}
	@XmlElement(name="value") 
	public String getValue() {
		return value;
	}
	//@XmlElement(name="name") 
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Property [name=" + name + ", value=" + value + "]"+System.getProperty("line.separator");
	}
	
}
