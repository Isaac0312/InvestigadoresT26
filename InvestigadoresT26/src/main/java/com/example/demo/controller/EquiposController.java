package com.example.demo.controller;
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
import com.example.demo.dto.Equipos;
import com.example.demo.service.EquiposServiceImpl;

@RestController
@RequestMapping("/api")
public class EquiposController {
	
	@Autowired
	EquiposServiceImpl equiposServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipos> listarEquipos(){
		return equiposServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipos salvarEquipo(@RequestBody Equipos equipo) {
		
		return equiposServiceImpl.guardarEquipo(equipo);
	}
	
	@GetMapping("/equipos/{codigo}")
	public Equipos equipo_x_ID(@PathVariable(name="codigo") String codigo) {
		
		Equipos equipo_x_id= new Equipos();
		
		equipo_x_id=equiposServiceImpl.equipo_x_id(codigo);
		
		System.out.println("Equipo XID: "+equipo_x_id);
		
		return equipo_x_id;
	}
	
	@PutMapping("/equipos/{codigo}")
	public Equipos actualizarEquipos(@PathVariable(name="codigo")String codigo,@RequestBody Equipos equipo) {
		
		Equipos equipos_seleccionado= new Equipos();
		Equipos equipos_actualizado= new Equipos();
		
		equipos_seleccionado= equiposServiceImpl.equipo_x_id(codigo);
		
		equipos_seleccionado.setFacultad(equipo.getFacultad());
		equipos_seleccionado.setNombre(equipo.getNombre());
		equipos_seleccionado.setNum_serie(equipo.getNum_serie());
		
		
		equipos_actualizado = equiposServiceImpl.actualizarEquipo(equipos_seleccionado);
		
		System.out.println("El equipo actualizado es: "+ equipos_actualizado);
		
		return equipos_actualizado;
	}
	
	@DeleteMapping("/equipos/{codigo}")
	public void eliminarEquipo(@PathVariable(name="codigo")String codigo) {
		equiposServiceImpl.eliminarEquipo(codigo);
	}
	
	
}