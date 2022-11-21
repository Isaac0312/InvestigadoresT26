package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipos;

public interface IEquiposService {
	public List<Equipos> listarEquipos();
	
	public Equipos guardarEquipo(Equipos equipo);
	
	public Equipos equipo_x_id(String codigo);
	
	public Equipos actualizarEquipo(Equipos equipo);
	
	public void eliminarEquipo(String codigo);
}
