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
public class Ejercicio03 {
    // dado un arreglo ordenado ascendentemente se le aplica 1 rotación cuando el último elemento pasa a ser el primero.
    // Implementar un método que reciba un arreglo rotado y determine cuantas rotaciones se le aplicaron
    
     public Integer  rotaciones(Integer[] arr){
        return rotaciones(arr,0,arr.length-1);
    }
    
    public Integer rotaciones(Integer[] arr,Integer inicio,Integer fin){
        if(inicio>fin) return 0;
       
        int medio = (fin+inicio)/2;
        
        if(medio>inicio && arr[medio]<arr[medio-1]) return medio;
        if(medio<fin && arr[medio+1]<arr[medio]) return medio+1;
        
        if(arr[medio]<arr[fin]) return rotaciones(arr,inicio,medio-1);
        else return rotaciones(arr,medio+1,fin);
        
    }
    
        
    public static void main(String[] args){
        Ejercicio03 ej3 = new Ejercicio03();
        Integer[] test1 = {22,34,35,12,14,16,18};
        Integer[] test2 = {2,4,6,8,10};
        Integer[] test3 = {25,27,2,4,6,8,10};
        Integer[] test4 = {2,1};
        Integer[] test5 = {7,2,5};
        Integer[] test6 = {3};
        System.out.println(ej3.rotaciones(test1));
        System.out.println(ej3.rotaciones(test2));
        System.out.println(ej3.rotaciones(test3));
        System.out.println(ej3.rotaciones(test4));
        System.out.println(ej3.rotaciones(test5));
        System.out.println(ej3.rotaciones(test6));
        
    }
    
}
