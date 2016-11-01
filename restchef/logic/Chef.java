package restchef.logic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Chef {
	
	public Chef() {}
	
	public Chef(String name, String email) {
		setName(name);
		setEmail(email);
	}
	
	//private static int idCounter = 0; 
	
	@XmlElement private String name;
	@XmlElement private String email;
	
	//private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	    public String toString() {
	        return new StringBuffer("name:").append(this.name)
	        		.append("email:")
	        		.append(this.email).toString();
	    }

	
	/*
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = idCounter++;
	}
	*/
}
