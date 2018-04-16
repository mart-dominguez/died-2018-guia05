/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.guia05.dyv;

/**
 *
 * @author mdominguez
 */
public class Ejercicio02 {
    // suponer un arreglo ordenado
    // dado un numero, buscar el piso: el mayor número menor al piso.
    
    
    public Integer  piso(Integer[] arr,Integer piso){
        return piso(arr,piso,0,arr.length-1);
    }
    
    public Integer piso(Integer[] arr,Integer piso,Integer inicio,Integer fin){
        if(inicio>fin) return -1;
        if(piso>=arr[fin]) return arr[fin];
        
        int medio = (fin+inicio)/2;
        
        
        if(medio>0 && arr[medio-1]<=piso && piso <arr[medio]) return arr[medio-1];
        
        
        if(arr[medio]<piso) {
            return piso(arr,piso,medio+1,fin);
        }else{ 
            return piso(arr,piso,inicio,medio-1);
        }               
        
    }
    
        
    public static void main(String[] args){
        Ejercicio02 ej2 = new Ejercicio02();
        Integer[] test = {2,2,3,5,6,8,12,45,67,89,112};
        System.out.println("PISO: "+ej2.piso(test,4 ));
        System.out.println("PISO: "+ej2.piso(test,50 ));
        System.out.println("PISO: "+ej2.piso(test,90 ));
        System.out.println("PISO: "+ej2.piso(test,1));
        System.out.println("PISO: "+ej2.piso(test,120 ));
        
    }
}
