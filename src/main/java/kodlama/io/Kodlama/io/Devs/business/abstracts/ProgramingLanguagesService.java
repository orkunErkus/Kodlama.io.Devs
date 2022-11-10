package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.CreateProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.GetAllProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.RemoveProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.UpdateProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.CreateProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.languagesResponses.GetAllProgramingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.languagesResponses.GetByIdProgramingLanguageResponse;


public interface ProgramingLanguagesService {

	List<GetAllProgramingLanguagesResponse> getAll();

	void add(CreateProgramingLanguageRequest createProgramingLanguageRequest)throws Exception;

	void remove(RemoveProgramingLanguageRequest	removeProgramingLanguageRequest);

	void update(UpdateProgramingLanguageRequest	updateProgramingLanguageRequest)throws Exception;

	GetByIdProgramingLanguageResponse getById(int id)throws Exception;

}
