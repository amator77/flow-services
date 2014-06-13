package flow.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Entity
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Window  extends AbstractEntity {
	
	@Getter @Setter @Column(name="name")
	private String name;
	
	@Getter @Setter
	private String test;
	
}
