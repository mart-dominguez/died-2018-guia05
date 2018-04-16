package ar.edu.frsf.isi.died.guia05.modelo;

public class InscripcionCursoException extends Exception{

	public InscripcionCursoException(String msg) {
		super(msg);
	}
	
	public InscripcionCursoException() {
		super("Hubo un problema al inscribir al curso");
	}
}
