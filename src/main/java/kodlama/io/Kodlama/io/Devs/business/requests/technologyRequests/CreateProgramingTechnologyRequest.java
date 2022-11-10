package kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgramingTechnologyRequest {

	private int programingLanguageId;
	private String name;
}
