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

import co.edu.ufps.demo.models.TipoEmpleado;
import co.edu.ufps.demo.services.TipoEmpleadoService;
import co.edu.ufps.demo.utils.ApiResponse;

@RestController
@RequestMapping("/tipo_empleados")
public class TipoEmpleadoController {
	
	@Autowired
	TipoEmpleadoService tipoEmpleadoService;
	
	@GetMapping()
	public ApiResponse<List<TipoEmpleado>> getAllTipoEmpleados() {
		List<TipoEmpleado> tipoEmpleados = tipoEmpleadoService.getAllTipoEmpleados();
	    return new ApiResponse<>("success", "Lista de tipoEmpleados obtenida correctamente", tipoEmpleados);	
	}
	
	@GetMapping("/{id}")
	public ApiResponse<TipoEmpleado> getTipoEmpleado(@PathVariable("id") Integer id) {

		TipoEmpleado tipoEmpleado = tipoEmpleadoService.getTipoEmpleado(id);
		
		if (tipoEmpleado == null) {
	        return new ApiResponse<>("error", "TipoEmpleado no encontrado", null);
	    }
	    return new ApiResponse<>("success", "TipoEmpleado encontrado", tipoEmpleado);
		
	}
	
	@PostMapping
	public TipoEmpleado postTipoEmpleado(@RequestBody TipoEmpleado tipoEmpleado) {

		return tipoEmpleadoService.saveTipoEmpleado(tipoEmpleado);
		
	}
	
	@PutMapping("/{id}")
	public TipoEmpleado putTipoEmpleado(@PathVariable("id") Integer id, @RequestBody TipoEmpleado tipoEmpleado) {

		return tipoEmpleadoService.updateTipoEmpleado(id, tipoEmpleado);
		
	}
	
	@DeleteMapping("/{id}")
	public TipoEmpleado deleteTipoEmpleado(@PathVariable("id") Integer id) {
		
		return tipoEmpleadoService.deleteTipoEmpleado(id);
		
	}

}
