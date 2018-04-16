package ar.edu.frsf.isi.died.guia05.modelo;

public class CupoNoDisponibleException extends InscripcionCursoException {

	public CupoNoDisponibleException(int cupo) {
		super("El cupo máximo de "+cupo+" alunos ya a sido alcanzado");
	}
}
