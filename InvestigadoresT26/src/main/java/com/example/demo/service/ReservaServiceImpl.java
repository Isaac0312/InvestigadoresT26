package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	IReservaDAO iReservaDAO;
	
	
	@Override
	public List<Reserva> listarReserva() {
		// TODO Auto-generated method stub
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return iReservaDAO.save(reserva);
	}

	@Override
	public Reserva reserva_x_id(Long id) {
		// TODO Auto-generated method stub
		return iReservaDAO.findById(id).get();
	}

	@Override
	public Reserva actualizarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return iReservaDAO.save(reserva);
	}

	@Override
	public void eliminarReserva(Long id) {
		// TODO Auto-generated method stub
		iReservaDAO.deleteById(id);
		
	}

}