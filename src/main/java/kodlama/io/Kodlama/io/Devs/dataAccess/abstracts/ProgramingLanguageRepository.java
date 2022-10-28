package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingLanguage;

public interface ProgramingLanguageRepository {

	
	List<ProgramingLanguage> getAll();
	
	ProgramingLanguage getById(int id);
	
	public void add(ProgramingLanguage programingLanguage);
	
	public void delete(int id);
	
	public void update(ProgramingLanguage programingLanguage);
	
	
}
