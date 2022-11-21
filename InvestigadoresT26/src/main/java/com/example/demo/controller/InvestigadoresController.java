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
import com.example.demo.dto.Investigadores;
import com.example.demo.service.InvestigadoresServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadoresController {
	
	@Autowired
	InvestigadoresServiceImpl investigadoresServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigadores> listarInvestigadores(){
		return investigadoresServiceImpl.listarInvestigadores();
	}
	
	@PostMapping("/investigadores")
	public Investigadores salvarInvestigador(@RequestBody Investigadores investigador) {
		
		return investigadoresServiceImpl.guardarInvestigador(investigador);
	}
	
	@GetMapping("/investigadores/{codigo}")
	public Investigadores investigador_x_ID(@PathVariable(name="codigo") String codigo) {
		
		Investigadores investigador_x_id= new Investigadores();
		
		investigador_x_id=investigadoresServiceImpl.investigador_x_id(codigo);
		
		System.out.println("Cajero XID: "+investigador_x_id);
		
		return investigador_x_id;
	}
	
	@PutMapping("/investigadores/{codigo}")
	public Investigadores actualizarCajero(@PathVariable(name="codigo")String codigo,@RequestBody Investigadores investigador) {
		
		Investigadores investigador_seleccionado= new Investigadores();
		Investigadores investigador_actualizado= new Investigadores();
		
		investigador_seleccionado= investigadoresServiceImpl.investigador_x_id(codigo);
		
		investigador_seleccionado.setNomapels(investigador.getNomapels());
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		
		
		investigador_actualizado = investigadoresServiceImpl.actualizarInvestigadores(investigador_seleccionado);
		
		System.out.println("El investigador actualizado es: "+ investigador_actualizado);
		
		return investigador_actualizado;
	}
	
	@DeleteMapping("/investigadores/{codigo}")
	public void eliminarInvestigador(@PathVariable(name="codigo")String codigo) {
		investigadoresServiceImpl.eliminarInvestigador(codigo);
	}
	
	
}

