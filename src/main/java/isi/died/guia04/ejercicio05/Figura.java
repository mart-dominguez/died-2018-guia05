package isi.died.guia04.ejercicio05;

public class Figura {
	private int largoLado;
	private Punto centro;

	public int getLargoLado() {
		return largoLado;
	}

	public void setLargoLado(int largoLado) {
		this.largoLado = largoLado;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public int rodean(Punto p) {
		return rodean(p, this.centro, this.largoLado);
	}

	private int rodean(Punto p, Punto centro, int lado) {
		int dentro = 0;
		if (p.getX() <= centro.getX() + lado / 2
				&& p.getX() >= centro.getX() - lado / 2
				&& p.getY() <= centro.getY() + lado / 2
				&& p.getY() >= centro.getY() - lado / 2)
			dentro = 1;
		if (lado <= 2) // caso base
			return dentro;
		// caso recursivo
		return dentro
				+ rodean(p, new Punto(centro.getX() + lado / 2, centro.getY()
						+ lado / 2), lado / 2)
				+ rodean(p, new Punto(centro.getX() + lado / 2, centro.getY()
						- lado / 2), lado / 2)
				+ rodean(p, new Punto(centro.getX() - lado / 2, centro.getY()
						+ lado / 2), lado / 2)
				+ rodean(p, new Punto(centro.getX() - lado / 2, centro.getY()
						- lado / 2), lado / 2);
	}
	
	public static void main(String[] args) {
		Figura f = new Figura();
		f.setCentro(new Punto(50, 50));
		f.setLargoLado(32);
		System.out.println("al punto (50,50) lo rodean: "+f.rodean(new Punto(50,50))+" cuadrados");
		System.out.println("al punto (33,33) lo rodean: "+f.rodean(new Punto(33,33))+" cuadrados");

	}
}
