package miumg.edu.gt.Project3.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Person")
public class RestPerson {

	@GetMapping("/Create")
    public String prueba() {
        return "Persona creada con exito";
    }
}
