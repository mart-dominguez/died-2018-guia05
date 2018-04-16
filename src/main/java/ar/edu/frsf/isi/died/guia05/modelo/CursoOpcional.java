package ar.edu.frsf.isi.died.guia05.modelo;

import java.util.ArrayList;

public class CursoOpcional extends Curso{

	private Integer creditosRequeridos;

	
	
	public CursoOpcional() {
		super();
	}


	public CursoOpcional(int id, String nombre, int creditos,int cupo,int requeidos) {
		super(id, nombre, creditos,cupo);		
		this.creditosRequeridos= requeidos;
	}

	
	@Override
	public void inscribir(Alumno a) throws InscripcionCursoException {
		if(a.creditos()>=this.creditosRequeridos) super.inscribir(a);
		else throw new CreditosInsuficientesException(this.creditosRequeridos, a.creditos());
	}
}
