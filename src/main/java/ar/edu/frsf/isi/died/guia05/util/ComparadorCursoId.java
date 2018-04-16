package ar.edu.frsf.isi.died.guia05.util;

import java.util.Comparator;

import ar.edu.frsf.isi.died.guia05.modelo.Curso;

public class ComparadorCursoId implements Comparator<Curso> {

	@Override
	public int compare(Curso o1, Curso o2) {
		return o1.getId()-o2.getId(); 
	}

}
