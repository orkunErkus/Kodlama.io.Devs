package kodlama.io.Kodlama.io.Devs.dataAccess.concrades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concrades.ProgramingLanguage;

@Repository
public class InMemoryProgramingLanguageRepository implements ProgramingLanguageRepository{

	List<ProgramingLanguage> programinglanguages;
	
	
	public InMemoryProgramingLanguageRepository(List<ProgramingLanguage> programinglanguages) {
		programinglanguages = new ArrayList<ProgramingLanguage>();
		programinglanguages.add(new ProgramingLanguage(1,"C#"));
		programinglanguages.add(new ProgramingLanguage(2,"JAVA"));
		programinglanguages.add(new ProgramingLanguage(3,"PYTHON"));
	}
	
	
	@Override
	public List<ProgramingLanguage> getAll() {
	
		return programinglanguages;
	}

	@Override
	public ProgramingLanguage getById(int id) {
		for (ProgramingLanguage programingLanguage : programinglanguages) {
			if (programingLanguage.getId()== id) {
				return programingLanguage;
				
			}
			System.out.println("Kayıt Listelendi");
		}
		return null;
	}

	@Override
	public void delete(int id) {
		ProgramingLanguage programingLanguageToDelete = this.getById(id);
		this.programinglanguages.remove(programingLanguageToDelete);
		System.out.println("Kayıt Başarıyla Silindi" );	
	
	}

	@Override
	public void update(ProgramingLanguage programinglanguage) {
		ProgramingLanguage programingLanguageToUpdate =this.getById(programinglanguage.getId());
		programinglanguages.set(programingLanguageToUpdate.getId()-1,programinglanguage);
		System.out.println("Kayıt Başarıyla Güncellendi" );	
	}


	@Override
	public void add(ProgramingLanguage programinglanguage) {
		this.programinglanguages.add(programinglanguage);
		System.out.println("İşlem Başarıyla Kaydedildi" );	
	}


	
	
}
