package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquiposDAO;
import com.example.demo.dto.Equipos;

@Service
public class EquiposServiceImpl implements IEquiposService {

	@Autowired
	IEquiposDAO iEquiposDAO;
	
	
	@Override
	public List<Equipos> listarEquipos() {
		// TODO Auto-generated method stub
		return iEquiposDAO.findAll();
	}

	@Override
	public Equipos guardarEquipo(Equipos equipo) {
		// TODO Auto-generated method stub
		return iEquiposDAO.save(equipo);
	}

	@Override
	public Equipos equipo_x_id(String id) {
		// TODO Auto-generated method stub
		return iEquiposDAO.findById(id).get();
	}

	@Override
	public Equipos actualizarEquipo(Equipos equipo) {
		// TODO Auto-generated method stub
		return iEquiposDAO.save(equipo);
	}

	@Override
	public void eliminarEquipo(String id) {
		// TODO Auto-generated method stub
		iEquiposDAO.deleteById(id);
		
	}

}
