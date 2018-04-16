package ar.edu.frsf.isi.died.guia05.util;

import java.util.ArrayList;
import java.util.Collections;
import ar.edu.frsf.isi.died.guia05.modelo.Curso;


public class CursosUtils {

	public static boolean pertenece(Curso c,ArrayList<Curso> listaCursos) {
		Collections.sort(listaCursos, new ComparadorCursoId());
		return Collections.binarySearch(listaCursos, c,new ComparadorCursoId())>=0;
	}
}
