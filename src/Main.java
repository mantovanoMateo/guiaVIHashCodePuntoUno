import Models.Persona;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("Punto 1: Progama de personas y calculo de su IMC");
        Scanner entrada=new Scanner(System.in);
        Integer edad=0;
        String nombre="";
        char sexo=' ';
        Double peso=0.0;
        Double altura=0.0;
        ArrayList<String> deneis=new ArrayList<>();
        int i=0;
        Persona pe=null;
        
        System.out.println("Por favor ingrese el nombre:");
        nombre=entrada.nextLine();
        System.out.println("Por favor ingrese la edad de la persona");
        edad=entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese el sexo");
        sexo=entrada.nextLine().charAt(0);
        System.out.println("Ingrese le peso");
        peso=entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Ingrese la altura");
        altura=entrada.nextDouble();
        entrada.nextLine();

        Persona persona1=new Persona(nombre,edad,sexo,peso,altura);
        deneis.add(persona1.getDni());
        Persona persona2=new Persona(nombre,edad,sexo);
        persona2.setAltura(1.90);
        persona2.setPeso(90.0);
        deneis.add(persona2.getDni());
        Persona persona3=new Persona();
        persona3.setPeso(60.0);
        persona3.setAltura(1.9);
        deneis.add(persona3.getDni());

        HashMap<String,Persona> hashMap=new HashMap<String,Persona>();

        hashMap.put(persona1.getDni(),persona1);
        hashMap.put(persona2.getDni(),persona2);
        hashMap.put(persona3.getDni(),persona3);

        while(i<deneis.size()){
            pe=(Persona) hashMap.get(deneis.get(i));
            if(pe.calcularIMC()<0){
                System.out.println("Usted esta por debajo de su peso ideal");
            } else if (pe.calcularIMC()>0) {
                System.out.println("Usted esta por encima de su peso ideal");
            }else {
                System.out.println("Usted se encuentra en su peso ideal");
            }
            i++;
        }

    }
}