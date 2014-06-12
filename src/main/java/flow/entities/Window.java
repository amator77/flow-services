package flow.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Window  extends AbstractEntity {
	
	@Column(name="name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 			
}
