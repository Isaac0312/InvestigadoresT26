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
@Table(name="facultad")
public class Facultad {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@Column(name = "nombre")
	private String nombre;
	
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Equipos>equipo;
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Investigadores>investigadores;
	

	
	public Facultad(){
		
	}
	
	public Facultad(String nombre, List<Investigadores> inv, List<Equipos> equ, int codigo) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.investigadores=inv;
		this.equipo=equ;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Equipos> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipos> equipo) {
		this.equipo = equipo;
	}

	public List<Investigadores> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigadores> investigadores) {
		this.investigadores = investigadores;
	}

	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + ", equipo=" + equipo + ", investigadores="
				+ investigadores + "]";
	}
	
}