package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Facultad;

public interface IFacultadService {
	public List<Facultad> listarFacultad();
	
	public Facultad guardarFacultad(Facultad facultad);
	
	public Facultad facultad_x_id(Long id);
	
	public Facultad actualizarFacultad(Facultad facultad);
	
	public void eliminarFacultad(Long id);
}