/*
 * To change this license headeraux.add( choose License Headers in Project Properties.
 * To change this template fileaux.add( choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.guia05.dyv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mdominguez
 */
public class Ejercicio01 {
    
    private static Integer[] datosx;
    
    public static void crear(Integer n){
        datosx=new Integer[n];
        Random r = new Random();
        for(int i =0;i<n;i++){
            datosx[i]=r.nextInt(1000);
        }
    }

    public static List<Integer> crear(){
        List<Integer> aux= new ArrayList<>();
        aux.add(15);
        aux.add(23);
        aux.add(18);
        aux.add(22);
        aux.add(23);
        aux.add(12);
        aux.add(74);
        aux.add(98);
        aux.add(23);
        aux.add(10);
        aux.add(66);
        aux.add(2);
        aux.add(35);
        aux.add(87);
        aux.add(23);
        aux.add(23);
        aux.add(23);
        aux.add(23);
        return aux;
    }

    
    public Integer mediana(List<Integer> arr){
        Integer buscar = arr.size()/2;
        return mediana(arr,buscar);
    }
    
    public Integer mediana(List<Integer> arr,Integer kesimo){
        System.out.println("array:"+arr.toString());
        Integer base = arr.get(0);
        List<Integer> auxIguales = new ArrayList<>();
        List<Integer> auxMenores = new ArrayList<>();
        List<Integer> auxMayores = new ArrayList<>();
        for(Integer elem:arr){
            if(elem==base){
                auxIguales.add(elem);
            }else{
                if(elem<base){
                    auxMenores.add(elem);
                }else{
                    auxMayores.add(elem);
                }
            }
        }
        System.out.println("kesimo:"+kesimo);
        System.out.println("base:"+base);
        System.out.println("menores:"+auxMenores.toString());
        System.out.println("iguales:"+auxIguales.toString());
        System.out.println("mayores:"+auxMayores.toString());

        if(auxMenores.size()>kesimo){
            return mediana(auxMenores,kesimo);
        }
        if(auxIguales.size()>kesimo-auxMenores.size()){
            return auxIguales.get(0);
        }
        if(auxMayores.size()>=kesimo){
            return mediana(auxMayores,kesimo-auxMenores.size()-auxIguales.size());
        }
        return 0;
    }

    
    public static void main(String[] args){
        Ejercicio01 ej1 = new Ejercicio01();
        List<Integer> test = crear();
        
        System.out.println(ej1.mediana(test));
        Collections.sort(test);
        System.out.println(test);
        
    }
}
