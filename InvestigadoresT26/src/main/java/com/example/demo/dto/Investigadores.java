package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")
public class Investigadores {

	
	@Id
	private String dni;
	
	@Column(name = "nomapels")
	private String nomapels;
	
	
	@OneToMany
	@JoinColumn(name="dni")
	private List<Reserva> reserva;
	
	@ManyToOne
	@JoinColumn(name="codigo")
	private Facultad facultad;

	
	public Investigadores(){
		
	}
	
	public Investigadores(String nomapels, List<Reserva> reserva, Facultad facultad, String dni) {
		this.nomapels=nomapels;
		this.dni=dni;
		this.facultad=facultad;
		this.reserva=reserva;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@Override
	public String toString() {
		return "Investigadores [dni=" + dni + ", nomapels=" + nomapels + ", reserva=" + reserva + ", facultad="
				+ facultad + "]";
	}

	
}
