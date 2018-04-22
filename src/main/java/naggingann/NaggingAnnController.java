package naggingann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NaggingAnnController {

	@Autowired
	private MedicationRepository medicationRepository;
	
	@GetMapping("/na-hello-world")
    @ResponseBody
    public String sayHello(@RequestParam(name="name", required=false) String name) {
        return "hello-world";
    }
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewMedication (@RequestParam String name
			, @RequestParam int dosageAmount, @RequestParam int dosageFrequency, @RequestParam String dosageDuration) {

		Medication med = new Medication();
		med.setName(name);
		med.setDosageAmount(dosageAmount);
		med.setDosageFrequency(dosageFrequency);
		med.setDosageDuration(dosageDuration);
		medicationRepository.save(med);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Medication> getAllUsers() {
		// This returns a JSON or XML with the users
		return medicationRepository.findAll();
	}
	
	

}