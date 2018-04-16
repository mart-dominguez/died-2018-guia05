package ar.edu.frsf.isi.died.guia05.modelo;

import java.util.ArrayList;

public class Alumno {
	
	private Integer id;
	private String nombre;

	private ArrayList<Curso> inscriptos;
	private ArrayList<Curso> aprobados;
	
	
	public Alumno() {
		this.inscriptos = new ArrayList<>();
		this.aprobados = new ArrayList<>();
	}
	
	public Alumno(Integer id,String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;
	}
	
	public void inscribir(Curso c) {
		this.inscriptos.add(c);
	}
	
	public void aprobar(Curso c) {
		this.aprobados.add(c);
	}

	public ArrayList<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(ArrayList<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	public ArrayList<Curso> getInscriptos() {
		return inscriptos;
	}
	
	public Integer creditos() {
		Integer creditos = 0;
		for(Curso c:aprobados) {
			creditos += c.getCreditos();
		}
		return creditos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Alumno)) return false;
		else {
			Alumno alu = (Alumno) obj;
			return this.id.equals(alu.id) && this.nombre.equals(alu.nombre);
		}
	}

}
