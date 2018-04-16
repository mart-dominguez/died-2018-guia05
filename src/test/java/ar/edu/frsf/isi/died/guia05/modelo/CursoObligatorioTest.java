package ar.edu.frsf.isi.died.guia05.modelo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class CursoObligatorioTest  {
	
	
	private ArrayList<Alumno> alumnos;
	private CursoObligatorio c1 ;
	private CursoObligatorio c2;
	
	@Before
	public void iniciarDatos() {
		alumnos = new ArrayList<>();
		alumnos.add(new Alumno(1,"alumno 1"));
		alumnos.add(new Alumno(2,"alumno 2"));
		alumnos.add(new Alumno(3,"alumno 3"));		
		alumnos.add(new Alumno(4,"alumno 4"));
		c1 = new CursoObligatorio(1,"Curso 1",4,3);
		c2 = new CursoObligatorio(2,"Curso 2",3,3);
		c2.agregarCorrelativa(c1);
	}
	
	@Test
	public void testInscribir3Alumnos() throws InscripcionCursoException {
		Integer lugares = c1.plazasDisponibles();
		assertEquals(lugares, Integer.valueOf(3));
		c1.inscribir(this.alumnos.get(0));
		lugares = c1.plazasDisponibles();
		assertEquals(lugares, Integer.valueOf(2));
		c1.inscribir(this.alumnos.get(1));
		lugares = c1.plazasDisponibles();
		assertEquals(lugares, Integer.valueOf(1));
		c1.inscribir(this.alumnos.get(2));
		lugares = c1.plazasDisponibles();
		assertEquals(lugares, Integer.valueOf(0));				
	}

	@Test(expected=CupoNoDisponibleException.class)
	public void testNoInscribeSinCupo() throws InscripcionCursoException{
		Integer lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(3),lugares );
		c1.inscribir(this.alumnos.get(0));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(2),lugares );
		c1.inscribir(this.alumnos.get(1));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(1),lugares );
		c1.inscribir(this.alumnos.get(2));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(0),lugares );
		c1.inscribir(this.alumnos.get(3));
	}

	@Test
	public void testAprobarGeneraCupo() throws InscripcionCursoException{
		Integer lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(3),lugares );
		c1.inscribir(this.alumnos.get(0));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(2),lugares );
		c1.inscribir(this.alumnos.get(1));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(1),lugares );
		c1.inscribir(this.alumnos.get(2));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(0),lugares );
		
		c1.aprobar(this.alumnos.get(0));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(1),lugares );
		
		c1.inscribir(this.alumnos.get(3));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(0),lugares );
	}
	
	@Test
	public void testInscribirTieneCorrelativas() throws InscripcionCursoException {
		c1.inscribir(this.alumnos.get(0));
		c1.aprobar(this.alumnos.get(0));
		assertTrue(this.alumnos.get(0).getAprobados().contains(c1));
		
		c1.inscribir(this.alumnos.get(0));
		Integer lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(2),lugares );		
	}
	
	@Test(expected=InscripcionCursoException.class)
	public void testInscribirSinCorrelativas() throws InscripcionCursoException {
		c1.inscribir(this.alumnos.get(0));
		c2.inscribir(this.alumnos.get(0));
	}

	@Test
	public void testEqualsObject() {
		assertFalse(c1.equals(c2));
		
		c1.setNombre(c2.getNombre());
		assertFalse(c1.equals(c2));
		
		c1.setId(c2.getId());
		assertEquals(c1,c2);
	}

	@Test
	public void testAprobar() throws InscripcionCursoException {
		c1.inscribir(this.alumnos.get(0));
		Integer lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(2),lugares );

		c1.aprobar(this.alumnos.get(0));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(1),Integer.valueOf(this.alumnos.get(0).getAprobados().size()));
		assertTrue(this.alumnos.get(0).getAprobados().contains(c1));
		assertEquals(Integer.valueOf(3),lugares );		
		
		c1.aprobar(this.alumnos.get(1));
		lugares = c1.plazasDisponibles();
		assertEquals(Integer.valueOf(3),lugares );		
		assertEquals(Integer.valueOf(0),Integer.valueOf(this.alumnos.get(1).getAprobados().size()));
		assertFalse(this.alumnos.get(1).getAprobados().contains(c1));
	}

}
