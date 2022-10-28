package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingLanguage;

public interface ProgramingLanguagesService {

	List<ProgramingLanguage> getAll();

	void add(ProgramingLanguage programingLanguage);

	void delete(int id);

	void update(ProgramingLanguage programingLanguage);

	ProgramingLanguage getById(int id);

}
