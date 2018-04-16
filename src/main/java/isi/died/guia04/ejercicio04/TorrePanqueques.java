package isi.died.guia04.ejercicio04;

import java.util.Arrays;

public class TorrePanqueques {

	private int[] torre;
	
	public int tamanio() {
		return torre.length;
	}
	
	public void darVuelta(Integer n) {
		int[] aux=new int[torre.length];
		if(n<=torre.length) {
			int indiceAux = n;
			for(int i:this.torre) {
				if(indiceAux>0) {
					aux[indiceAux-1]=i;
					indiceAux--;
				}
				else aux[n++]=i;
			}
		}
		System.out.println(Arrays.toString(aux));
		this.torre = aux;
	}
	
	public int findMax(int hasta) {
		int max = this.torre[0];
		int indice = 0;
		for(int i = 1;i<hasta;i++) {
			if(this.torre[i]>max) {
				max = this.torre[i];
				indice = i;
			}
		}
		return indice+1;
	}
	
	public void ordenar() {
		ordenar(this.torre.length);
	}

	public void print() {
		System.out.println(Arrays.toString(this.torre));
	}
	public void ordenar(int hasta) {
		System.out.println("ORDERNAR HASTA "+hasta);
		if(hasta==0) {
			System.out.println(Arrays.toString(this.torre));
			return;
		}
		int max = findMax(hasta);
		print();
		System.out.println("MAX "+max);
		darVuelta(max);
		System.out.println("vuelta max");
		print();
		darVuelta(hasta);
		System.out.println("vuelta hasta");
		print();
		ordenar(hasta-1);
	}
	
	public TorrePanqueques() {
		
	}
	
	public TorrePanqueques(int[] torre) {
		this.torre = torre;
	}
	// 4 2 8 5 6 7 --> darVuelta(3) --> 8 2 4 5 6 7
	
	public static void main(String[] args) {
		int[] x ={24,2,8,15,6,37};
		TorrePanqueques t1 = new TorrePanqueques(x);
//		int j = t1.findMax(5);
//		System.out.println(j);
//		j = t1.findMax(6);
//		System.out.println(j);
//		t1.darVuelta(0);
//		t1.darVuelta(1);
//		t1.darVuelta(2);
//		t1.darVuelta(3);
//		t1.darVuelta(4);
//		t1.darVuelta(5);
//		t1.darVuelta(6);
//		t1.darVuelta(7);
		t1.ordenar();
	}

}
