package isi.died.guia04.ejercicio06;

/**
 * Considere una grilla de NxN en la que algunas casillas están ocupadas. 
 * Dos casillas ocupadas pertenecen al mismo grupo si comparten un lado común. 
 * Ejemplo:
 * [ A A A - - - ]
 * [ - A A - - Y ]
 * [ A A - B - - ]
 * [ - - - B - - ]
 * [ - - - B B - ]
 * [ Z - - - - - ]
 *  
 *  int tamanio(1,1) debe retornar 6.   
 * @author mdominguez
 *
 */
public class Tablero {

	int[][] tablero;
	
	public int rodean(int x, int y) {
		boolean[][] aux = new boolean[tablero.length][tablero[0].length];
		return rodean(x,y,aux);
	}
	
	public int rodean(int x,int y,boolean[][] auxTablero) {
		if(x==-1 || x>=auxTablero.length || y==-1 || y>=auxTablero.length || auxTablero[x][y] || this.tablero[x][y]==0) return 0;
		else {
			auxTablero[x][y]=true;
			return 1+rodean(x+1,y,auxTablero)+rodean(x-1,y,auxTablero)+rodean(x,y+1,auxTablero)+rodean(x,y-1,auxTablero);
		}
	}
	
	public Tablero() {
		tablero= new int[6][6];
		tablero[0][0]=5;
		tablero[0][1]=5;
		tablero[0][2]=5;
		tablero[1][1]=5;
		tablero[1][2]=5;
		tablero[2][0]=5;
		tablero[2][1]=5;

		tablero[2][3]=5;		
		tablero[3][3]=5;		
		tablero[4][3]=5;		
		tablero[4][4]=5;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero t = new Tablero();
		System.out.println("RODEAN : "+t.rodean(1, 0));
	}
	
	
}
