package kodlama.io.Kodlama.io.Devs.business.concrates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgramingLanguagesService;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.CreateProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.GetAllProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.RemoveProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.UpdateProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.languagesResponses.GetAllProgramingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.languagesResponses.GetByIdProgramingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingLanguage;

@Service
public class ProgramingLanguageManager implements ProgramingLanguagesService {

	private ProgramingLanguageRepository programingLanguageRepository;

	@Autowired
	public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository) {
		this.programingLanguageRepository = programingLanguageRepository;
	}

	@Override
	public List<GetAllProgramingLanguagesResponse> getAll() {
		List<ProgramingLanguage> programinglanguages = programingLanguageRepository.findAll();
		List<GetAllProgramingLanguagesResponse> programingLanguageResponses = new ArrayList<GetAllProgramingLanguagesResponse>();

		for (ProgramingLanguage programingLanguage : programinglanguages) {
			GetAllProgramingLanguagesResponse programingLanguagesResponseItem = new GetAllProgramingLanguagesResponse();
			programingLanguagesResponseItem.setId(programingLanguage.getId());
			programingLanguagesResponseItem.setName(programingLanguage.getName());

			programingLanguageResponses.add(programingLanguagesResponseItem);
		}
		return programingLanguageResponses;
	}

	@Override
	public void add(CreateProgramingLanguageRequest createProgramingLanguageRequest) {
		List<ProgramingLanguage> programingLanguages = programingLanguageRepository.findAll();
		
		for (ProgramingLanguage programingLanguage : programingLanguages) {
			if (createProgramingLanguageRequest.getName().equals(programingLanguage.getName())) {
				System.out.println("Ad Tekrarlanamaz : " + createProgramingLanguageRequest.getName());
				return;
			}
		}
		if (createProgramingLanguageRequest.getName().equals("")) {
			System.out.println("Adınız Boş Geçilemez.");
		}

		ProgramingLanguage programingLanguage = new ProgramingLanguage();
		programingLanguage.setName(createProgramingLanguageRequest.getName());

		this.programingLanguageRepository.save(programingLanguage);

	}

	@Override
	public void remove(RemoveProgramingLanguageRequest removeProgramingLanguageRequest) {
		programingLanguageRepository.deleteById(removeProgramingLanguageRequest.getId());

	}

	@Override
	public void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) {
		ProgramingLanguage programingLanguage = new ProgramingLanguage();
		programingLanguage.setId(updateProgramingLanguageRequest.getId());
		programingLanguage.setName(updateProgramingLanguageRequest.getName());
		programingLanguageRepository.save(programingLanguage);

	}

	@Override
	public GetByIdProgramingLanguageResponse getById(int id) {
		ProgramingLanguage programingLanguage = programingLanguageRepository.getReferenceById(id);
		GetByIdProgramingLanguageResponse languageResponse = new GetByIdProgramingLanguageResponse();

		languageResponse.setId(programingLanguage.getId());
		languageResponse.setName(programingLanguage.getName());

		return languageResponse;
	
	}


}
