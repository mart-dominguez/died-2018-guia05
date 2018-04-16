package ar.edu.frsf.isi.died.guia05.modelo;

import java.util.ArrayList;

public abstract class Curso {

	private int cupo;
	private int id;
    private String nombre;
    private int creditos;
    private ArrayList<Alumno> alumnos;
    
    public Curso() {
    	this.alumnos = new ArrayList<>();
    }
    
    public Curso(int id,String nombre,int creditos,int cupo) {
    	this();
    	this.cupo=cupo;
    	this.id = id;
    	this.nombre = nombre;
    	this.creditos = creditos;
    }
    
    public void inscribir(Alumno a) throws InscripcionCursoException{
    	if(this.alumnos.size()==this.cupo) throw new CupoNoDisponibleException(this.alumnos.size());
    	this.alumnos.add(a);
    }
    
    @Override
    public boolean equals(Object obj) {    
    	if (! (obj instanceof Curso) ) return false;
    	else {
    		Curso aux = (Curso) obj;
    		return this.id==aux.id && this.nombre.equalsIgnoreCase(aux.nombre);
    	}
    }
    
    public final void aprobar(Alumno a) {
    	if(this.alumnos.remove(a)) a.aprobar(this);
    }
    
    public Integer plazasDisponibles() {
    	return this.cupo-this.alumnos.size();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    
}
