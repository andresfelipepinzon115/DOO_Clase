package co.edu.uco.tiendachepito.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/paises")
public class PaisController {
	
	@GetMapping
	public List<PaisDTO> listar() {
		
		
	}
	

}
