package kodlama.io.Kodlama.io.Devs.entities.concrades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "programingTechnology")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgramingTechnology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;	
	
	@ManyToOne()
	@JoinColumn(name = "programingLanguageId")
	private ProgramingLanguage programingLanguage;
	
}
