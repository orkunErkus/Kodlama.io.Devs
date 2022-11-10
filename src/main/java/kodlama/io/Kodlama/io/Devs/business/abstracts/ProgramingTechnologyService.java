package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.CreateProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.RemoveProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.UpdateProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technologyResponses.GetAllProgramingTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technologyResponses.GetByIdProgramingTechnologyResponse;

public interface ProgramingTechnologyService {
	
	List<GetAllProgramingTechnologyResponse> getAll();

	void add(CreateProgramingTechnologyRequest createProgramingTechnologyRequest)throws Exception;

	void remove(RemoveProgramingTechnologyRequest removeProgramingTechnologyRequest);

	void update(UpdateProgramingTechnologyRequest updateProgramingTechnologyRequest)throws Exception;

	GetByIdProgramingTechnologyResponse getById(int id);
}
