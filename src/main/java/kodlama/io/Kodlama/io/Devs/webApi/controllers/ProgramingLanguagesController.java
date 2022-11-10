package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgramingLanguagesService;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.CreateProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.RemoveProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequests.UpdateProgramingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.languagesResponses.GetAllProgramingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.languagesResponses.GetByIdProgramingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingLanguage;

@RestController
@RequestMapping("/api/programinglanguages")
public class ProgramingLanguagesController {

	private ProgramingLanguagesService programingLanguagesService;

	@Autowired
	public ProgramingLanguagesController(ProgramingLanguagesService programingLanguagesService) {
		this.programingLanguagesService = programingLanguagesService;
	}

	@GetMapping("/getall")
	public List<GetAllProgramingLanguagesResponse> getAll() {
		return programingLanguagesService.getAll();

	}

	@PostMapping("/add")
	public void add(CreateProgramingLanguageRequest createProgramingLanguageRequest) throws Exception {
		programingLanguagesService.add(createProgramingLanguageRequest);
	}

	@PostMapping("/update")
	public void update(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) throws Exception {
		programingLanguagesService.update(updateProgramingLanguageRequest);
	}
	@DeleteMapping("/remove")
	public void remove(RemoveProgramingLanguageRequest removeProgramingLanguageRequest) {
		programingLanguagesService.remove(removeProgramingLanguageRequest);	
	}
	@GetMapping("/getbyid/")
	public GetByIdProgramingLanguageResponse getByIdProgramingLanguageResponse(int id) throws Exception {
		return this.programingLanguagesService.getById(id);
	}
}
