package com.example.demo.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "comienzo")
	private Date comienzo;
	
	@Column(name = "fin")
	private Date fin;
	
	
	@ManyToOne
	@JoinColumn(name="num_serie")
	private Equipos equipo;
	
	@ManyToOne
	@JoinColumn(name="dni")
	private Investigadores investigador;

	
	public Reserva(){
		
	}
	
	public Reserva(long id,Equipos equipo, Investigadores inv, Date ini, Date fin) {
		this.comienzo=ini;
		this.fin=fin;
		this.equipo=equipo;
		this.investigador=inv;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	public Investigadores getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigadores investigador) {
		this.investigador = investigador;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", comienzo=" + comienzo + ", fin=" + fin + ", equipo=" + equipo
				+ ", investigador=" + investigador + "]";
	}
}
