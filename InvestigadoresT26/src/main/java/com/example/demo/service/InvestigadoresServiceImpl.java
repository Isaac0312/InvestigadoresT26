package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IInvestigadoresDAO;
import com.example.demo.dto.Investigadores;

@Service
public class InvestigadoresServiceImpl implements IInvestigadoresService {

	@Autowired
	IInvestigadoresDAO iInvestigadoresDAO;
	
	
	@Override
	public List<Investigadores> listarInvestigadores() {
		// TODO Auto-generated method stub
		return iInvestigadoresDAO.findAll();
	}

	@Override
	public Investigadores guardarInvestigador(Investigadores investigador) {
		// TODO Auto-generated method stub
		return iInvestigadoresDAO.save(investigador);
	}

	@Override
	public Investigadores investigador_x_id(String id) {
		// TODO Auto-generated method stub
		return iInvestigadoresDAO.findById(id).get();
	}

	@Override
	public Investigadores actualizarInvestigadores(Investigadores investigador) {
		// TODO Auto-generated method stub
		return iInvestigadoresDAO.save(investigador);
	}

	@Override
	public void eliminarInvestigador(String id) {
		// TODO Auto-generated method stub
		iInvestigadoresDAO.deleteById(id);
		
	}

}