package kodlama.io.Kodlama.io.Devs.business.concrates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgramingLanguagesService;
import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgramingTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.CreateProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.RemoveProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.UpdateProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.languagesResponses.GetByIdProgramingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technologyResponses.GetAllProgramingTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technologyResponses.GetByIdProgramingTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgramingTechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingLanguage;
import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingTechnology;

public class ProgramingTechnologyManager implements ProgramingTechnologyService {

	private ProgramingTechnologyRepository programingTechnologyRepository;
	private ProgramingLanguagesService programingLanguagesService;
	
	public ProgramingTechnologyManager (ProgramingTechnologyRepository programingTechnologyRepository,ProgramingLanguagesService programingLanguagesService) {
		this.programingTechnologyRepository = programingTechnologyRepository;
		this.programingLanguagesService = programingLanguagesService;
	}

	@Override
	public void add(CreateProgramingTechnologyRequest createProgramingTechnologyRequest) throws Exception {
		
		ProgramingTechnology programingTechnology = new ProgramingTechnology();
		ProgramingLanguage programingLanguage = new ProgramingLanguage();
		GetByIdProgramingLanguageResponse getByIdProgramingLanguageResponse = programingLanguagesService
				.getById(createProgramingTechnologyRequest.getProgramingLanguageId());

		programingLanguage.setId(getByIdProgramingLanguageResponse.getId());
		programingLanguage.setName(getByIdProgramingLanguageResponse.getName());
	

		programingTechnology.setName(createProgramingTechnologyRequest.getName());
		programingTechnology.setProgramingLanguage(programingLanguage);

		programingTechnologyRepository.save(programingTechnology);
		
	}
	@Override
	public List<GetAllProgramingTechnologyResponse> getAll() {
		List<ProgramingTechnology> programingTechnologies = programingTechnologyRepository.findAll();
		List<GetAllProgramingTechnologyResponse> programingTechnologyResponses = new ArrayList<>();

		for (ProgramingTechnology programingTechnology : programingTechnologies) {
			GetAllProgramingTechnologyResponse responseItem = new GetAllProgramingTechnologyResponse();
			responseItem.setId(programingTechnology.getId());
			responseItem.setName(programingTechnology.getName());
			programingTechnologyResponses.add(responseItem);
		}
		return programingTechnologyResponses;
	}


	@Override
	public void remove(RemoveProgramingTechnologyRequest removeProgramingTechnologyRequest) {
		programingTechnologyRepository.deleteById(removeProgramingTechnologyRequest.getId());

		
	}

	@Override
	public void update(UpdateProgramingTechnologyRequest updateProgramingTechnologyRequest) throws Exception {
		ProgramingTechnology programingTechnology = new ProgramingTechnology();
		ProgramingLanguage programingLanguage = new ProgramingLanguage();
		GetByIdProgramingLanguageResponse getByIdProgramingLanguageResponse = programingLanguagesService
				.getById(updateProgramingTechnologyRequest.getProgramingLanguageId());

		programingLanguage.setId(getByIdProgramingLanguageResponse.getId());
		programingLanguage.setName(getByIdProgramingLanguageResponse.getName());

		programingTechnology.setName(updateProgramingTechnologyRequest.getName());
		programingTechnology.setId(updateProgramingTechnologyRequest.getId());
		programingTechnology.setProgramingLanguage(programingLanguage);

		programingTechnologyRepository.save(programingTechnology);
		
	}

	@Override
	public GetByIdProgramingTechnologyResponse getById(int id) {
		ProgramingTechnology programingTechnology = programingTechnologyRepository.getReferenceById(id);
		GetByIdProgramingTechnologyResponse responseItem = new GetByIdProgramingTechnologyResponse();

		responseItem.setId(programingTechnology.getId());
		responseItem.setName(programingTechnology.getName());

		return responseItem;
	}	
	
}
