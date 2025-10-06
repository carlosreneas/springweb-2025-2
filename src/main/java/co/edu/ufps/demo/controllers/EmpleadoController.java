package co.edu.ufps.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@GetMapping()
	public String getAllEmpleados() {
		
		return "All Empleados";
		
	}

}
