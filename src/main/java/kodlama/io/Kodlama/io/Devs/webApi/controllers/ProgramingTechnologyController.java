package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgramingTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.CreateProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.RemoveProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technologyRequests.UpdateProgramingTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technologyResponses.GetAllProgramingTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technologyResponses.GetByIdProgramingTechnologyResponse;

@RestController
@RequestMapping("api/technologies")
public class ProgramingTechnologyController {
	
    private ProgramingTechnologyService programingTechnologyService;

    @Autowired
    public ProgramingTechnologyController(ProgramingTechnologyService programingTechnologyService) {
        this.programingTechnologyService = programingTechnologyService;
    }

    @PostMapping("/add")
    public void add(CreateProgramingTechnologyRequest createProgramingTechnologyRequest) throws Exception {
    	programingTechnologyService.add(createProgramingTechnologyRequest);
    }

    @PutMapping("update")
    public void update(UpdateProgramingTechnologyRequest updateProgramingTechnologyRequest) throws Exception {
    	programingTechnologyService.update(updateProgramingTechnologyRequest);
    }

    @DeleteMapping("/remove")
    public void remove(RemoveProgramingTechnologyRequest removeProgramingTechnologyRequest) {
    	programingTechnologyService.remove(removeProgramingTechnologyRequest);
    }

    @GetMapping("/getall")
    List<GetAllProgramingTechnologyResponse> getAll() {
        return programingTechnologyService.getAll();
    }

    @GetMapping("getbyid")
    GetByIdProgramingTechnologyResponse getByIdProgramingTechnologyResponse(int id) {
        return programingTechnologyService.getById(id);
    }

}
