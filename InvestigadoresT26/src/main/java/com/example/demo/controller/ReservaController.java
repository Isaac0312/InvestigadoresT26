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
import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reserva")
	public List<Reserva> listarReservas(){
		return reservaServiceImpl.listarReserva();
	}
	
	@PostMapping("/reserva")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reserva/{codigo}")
	public Reserva reserva_x_ID(@PathVariable(name="codigo") Long codigo) {
		
		Reserva reserva_x_id= new Reserva();
		
		reserva_x_id=reservaServiceImpl.reserva_x_id(codigo);
		
		System.out.println("Reserva XID: "+reserva_x_id);
		
		return reserva_x_id;
	}
	
	@PutMapping("/reserva/{codigo}")
	public Reserva actualizarFacultad(@PathVariable(name="codigo")Long codigo,@RequestBody Reserva reserva) {
		
		Reserva reserva_seleccionado= new Reserva();
		Reserva reserva_actualizado= new Reserva();
		
		reserva_seleccionado= reservaServiceImpl.reserva_x_id(codigo);
		
		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setFin(reserva.getFin());
		reserva_seleccionado.setEquipo(reserva.getEquipo());
		reserva_seleccionado.setInvestigador(reserva.getInvestigador());
		
		
		reserva_actualizado = reservaServiceImpl.actualizarReserva(reserva_seleccionado);
		
		System.out.println("La reserva actualizada es: "+ reserva_actualizado);
		
		return reserva_actualizado;
	}
	
	@DeleteMapping("/reserva/{codigo}")
	public void eliminarReserva(@PathVariable(name="codigo")Long codigo) {
		reservaServiceImpl.eliminarReserva(codigo);
	}
	
	
}
