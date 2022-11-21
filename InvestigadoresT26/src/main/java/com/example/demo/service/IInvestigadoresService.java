package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigadores;

public interface IInvestigadoresService {
	public List<Investigadores> listarInvestigadores();
	
	public Investigadores guardarInvestigador(Investigadores investigador);
	
	public Investigadores investigador_x_id(String id);
	
	public Investigadores actualizarInvestigadores(Investigadores investigador);
	
	public void eliminarInvestigador(String id);
}