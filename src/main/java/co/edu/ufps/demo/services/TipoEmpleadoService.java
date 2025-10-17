package co.edu.ufps.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.demo.models.TipoEmpleado;
import co.edu.ufps.demo.repositories.TipoEmpleadoRepository;

@Service
public class TipoEmpleadoService {
	
	@Autowired
	TipoEmpleadoRepository tipoEmpleadoRepository;
	
	public List<TipoEmpleado> getAllTipoEmpleados() {
		return tipoEmpleadoRepository.findAll();
	}
	
	
	public TipoEmpleado saveTipoEmpleado(TipoEmpleado tipoEmpleado) {
		
		TipoEmpleado e = tipoEmpleadoRepository.save(tipoEmpleado);
		return e;
		
	}
	
	
	public TipoEmpleado updateTipoEmpleado(Integer id, TipoEmpleado tipoEmpleadoParam) {
		
		TipoEmpleado tipoEmpleadoActual = tipoEmpleadoRepository.findById(id).orElse(null);
		
		//empleadoActual.setDocumento(empleadoParam.getDocumento());
		BeanUtils.copyProperties(tipoEmpleadoParam, tipoEmpleadoActual);
		
		tipoEmpleadoRepository.save(tipoEmpleadoActual);
		return tipoEmpleadoActual;
		
	}
	
	public TipoEmpleado getTipoEmpleado(Integer id) {
				
		return tipoEmpleadoRepository.findById(id).orElse(null);
	}
	
	public TipoEmpleado deleteTipoEmpleado(Integer id) {
		
		TipoEmpleado tipoEmpleado = tipoEmpleadoRepository.findById(id).orElse(null);

		tipoEmpleadoRepository.deleteById(id);
		
		return tipoEmpleado;
				
	}
	
	

}
