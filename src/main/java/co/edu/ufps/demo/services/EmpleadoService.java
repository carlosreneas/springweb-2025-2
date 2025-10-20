package co.edu.ufps.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.demo.models.Dependencia;
import co.edu.ufps.demo.models.Empleado;
import co.edu.ufps.demo.repositories.DependenciaRepository;
import co.edu.ufps.demo.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	DependenciaRepository dependenciaRepository;
	
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}
	
	
	public Empleado saveEmpleado(Empleado empleado) {
		
		Empleado e = empleadoRepository.save(empleado);
		return e;
		
	}
	
	
	public Empleado updateEmpleado(Integer id, Empleado empleadoParam) {
		
		Empleado empleadoActual = empleadoRepository.findById(id).orElse(null);
		
		//empleadoActual.setDocumento(empleadoParam.getDocumento());
		BeanUtils.copyProperties(empleadoParam, empleadoActual);
		
		empleadoRepository.save(empleadoActual);
		return empleadoActual;
		
	}
	
	public Empleado getEmpleado(Integer id) {
				
		return empleadoRepository.findById(id).orElse(null);
	}
	
	public Empleado deleteEmpleado(Integer id) {
		
		Empleado empleado = empleadoRepository.findById(id).orElse(null);

		empleadoRepository.deleteById(id);
		
		return empleado;
				
	}


	public Empleado addDependencia(Integer id, Integer dependenciaParam) {
		
		Empleado empleado = empleadoRepository.findById(id).orElse(null);
		
		Dependencia dependencia = dependenciaRepository.findById(dependenciaParam).orElse(null);
		
		Dependencia dependenciaBuscada = empleado.searchDependencia(dependencia);
		
		if(dependenciaBuscada!=null){
			return null;
		} else {
			empleado.addDependencia(dependencia);
			// TODO Auto-generated method stub
			empleadoRepository.save(empleado);
			return empleado;
		}
	}


	public Empleado removeDependencia(Integer id, Integer dependenciaParam) {
		// TODO Auto-generated method stub
		Empleado empleado = empleadoRepository.findById(id).orElse(null);
		
		Dependencia dependencia = dependenciaRepository.findById(dependenciaParam).orElse(null);
		
		Dependencia dependenciaBuscada = empleado.searchDependencia(dependencia);
		
		if(dependenciaBuscada!=null){
			empleado.removeDependencia(dependenciaBuscada);
			// TODO Auto-generated method stub
			empleadoRepository.save(empleado);
			return empleado;
		}
		
		return null;
	}
	
	

}
