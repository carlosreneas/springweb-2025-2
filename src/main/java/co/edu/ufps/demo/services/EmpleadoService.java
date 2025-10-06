package co.edu.ufps.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.demo.models.Empleado;
import co.edu.ufps.demo.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}
	
	
	public Empleado getEmpleado(Integer id) {
				
		return empleadoRepository.findById(id).orElse(null);
	}
	
	

}
