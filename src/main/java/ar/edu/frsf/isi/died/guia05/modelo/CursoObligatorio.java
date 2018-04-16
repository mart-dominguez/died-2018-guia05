package ar.edu.frsf.isi.died.guia05.modelo;

import java.util.ArrayList;

import ar.edu.frsf.isi.died.guia05.util.CursosUtils;

public class CursoObligatorio extends Curso{

	private ArrayList<Curso> correlativas;
	
	
	
	public CursoObligatorio() {
		super();
		this.correlativas = new ArrayList<>();
	}


	public CursoObligatorio(int id, String nombre, int creditos,int cupo) {
		super(id, nombre, creditos,cupo);		
		this.correlativas = new ArrayList<>();
	}
	

	@Override
	public void inscribir(Alumno a) throws InscripcionCursoException {
		if(this.correlativas!=null) {
			if(!tieneCorrelativas(a)) throw new InscripcionCursoException("no tiene las correlativas");
		}
		super.inscribir(a);
		a.inscribir(this);
	}

	
	public Boolean tieneCorrelativas(Alumno a) {
		for(Curso c: this.correlativas) {
			if (! a.getAprobados().contains(c)) return false;
		}
		return true;
	}
	
	public void agregarCorrelativa(Curso c) {
		this.correlativas.add(c);
	}
	
}
