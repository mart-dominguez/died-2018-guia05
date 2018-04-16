package ar.edu.frsf.isi.died.guia05.modelo;

public class CreditosInsuficientesException extends InscripcionCursoException {

	public CreditosInsuficientesException(int requeridos,int obtenidos) {
		super("Se requieren "+requeridos+" creditos y ha obtenido " +obtenidos+" creditos");
	}
}
