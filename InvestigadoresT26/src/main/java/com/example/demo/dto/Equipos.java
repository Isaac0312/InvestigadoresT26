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
@Table(name="equipos")
public class Equipos {

	
	@Id
	private String num_serie;
	
	@Column(name = "nombre")
	private String nombre;
	
	
	@OneToMany
	@JoinColumn(name="num_serie")
	private List<Reserva> reserva;
	
	@ManyToOne
	@JoinColumn(name="codigo")
	private Facultad facultad;

	
	public Equipos(){
		
	}
	
	public Equipos(String nombre, List<Reserva> reserva, Facultad facultad, String num_serie) {
		this.nombre=nombre;
		this.num_serie=num_serie;
		this.facultad=facultad;
		this.reserva=reserva;
	}

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Equipos [num_serie=" + num_serie + ", nombre=" + nombre + ", reserva=" + reserva + ", facultad="
				+ facultad + "]";
	}
}