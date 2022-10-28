package kodlama.io.Kodlama.io.Devs.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgramingLanguagesService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingLanguage;

@Service
public class ProgramingLanguageManager implements ProgramingLanguagesService{

	private ProgramingLanguageRepository languageRepository;
	
	@Autowired
	public ProgramingLanguageManager(ProgramingLanguageRepository languageRepository) {
			this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgramingLanguage> getAll() {
			return languageRepository.getAll();
	}

	@Override
	public void add(ProgramingLanguage programingLanguage) {
		for (ProgramingLanguage pl : this.getAll()) {
			if (pl.getName().equals
				   (programingLanguage.getName()) ||
					programingLanguage.getName().isEmpty() ||
					programingLanguage.getName().isBlank()) {
				return;
			}
		}
			this.languageRepository.add(programingLanguage);
	}

	@Override
	public void delete(int id) {
		this.languageRepository.delete(id);
		
	}

	@Override
	public void update(ProgramingLanguage programingLanguage) {
		this.languageRepository.update(programingLanguage);
		
	}

	@Override
	public ProgramingLanguage getById(int id) {
		return this.languageRepository.getById(id);
		}

}
