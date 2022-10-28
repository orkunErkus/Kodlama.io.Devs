package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgramingLanguagesService;
import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingLanguage;

@RestController
@RequestMapping("/api/programinglanguages")
public class ProgramingLanguagesController {

	private ProgramingLanguagesService languagesService;

	@Autowired
	public ProgramingLanguagesController(ProgramingLanguagesService languagesService) {
		this.languagesService = languagesService;
	}

	@GetMapping("/getall")
	public List<ProgramingLanguage> getAll() {
		return languagesService.getAll();

	}

	@PostMapping("/add")
	public void add(ProgramingLanguage programingLanguage) {
		languagesService.add(programingLanguage);
	}

	@PostMapping("/update")
	public void update(ProgramingLanguage programingLanguage) {
		languagesService.update(programingLanguage);
	}
	@DeleteMapping("/delete")
	public void delete(int id) {
		languagesService.delete(id);	
	}
	@GetMapping("/getbyid/")
	public ProgramingLanguage getById(int id) {
		return this.languagesService.getById(id);
	}
}
