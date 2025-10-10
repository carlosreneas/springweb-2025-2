package co.edu.ufps.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.demo.models.Empleado;
import co.edu.ufps.demo.services.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping()
	public List<Empleado> getAllEmpleados() {
		
		return empleadoService.getAllEmpleados();
		
	}
	
	@GetMapping("/{id}")
	public Empleado getEmpleado(@PathVariable("id") Integer id) {

		return empleadoService.getEmpleado(id);
		
	}
	
	@PostMapping
	public Empleado postEmpleado(@RequestBody Empleado empleado) {

		return empleadoService.saveEmpleado(empleado);
		
	}
	
	@PutMapping("/{id}")
	public Empleado putEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {

		return empleadoService.updateEmpleado(id, empleado);
		
	}
	
	@DeleteMapping("/{id}")
	public Empleado deleteEmpleado(@PathVariable("id") Integer id) {
		
		return empleadoService.deleteEmpleado(id);
		
	}

}
