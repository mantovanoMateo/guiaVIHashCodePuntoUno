package Models;

import java.util.Objects;
import java.util.Random;

public class Persona {
    private String nombre;
    private Integer edad;
    private String dni;
    private final char sexo;
    private Double peso;//en kg
    private Double altura;//en metros

    public Persona() {
        this.dni=generaDNI();
        this.sexo='H';
    }

    public Persona(String nombre, Integer edad, char sexo) {
        this.dni=generaDNI();
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona(String nombre, Integer edad, char sexo, Double peso, Double altura) {
        comprobarSexo(sexo);
        this.nombre = nombre;
        this.edad = edad;
        this.dni = generaDNI();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Integer calcularIMC(){
        double resultado=0.0;
        resultado=(this.peso/(Math.pow(this.altura,2)));
        Integer devuelve=0;
        if(resultado<20){
            devuelve=-1;
        }else if(resultado>25){
            devuelve=1;
        }
        return devuelve;
    }

    public Boolean esMayorDeEdad(){
        Boolean mayor=false;
        if(edad>18){
            mayor=true;
        }
        return mayor;
    }

    private char comprobarSexo(char sexo){
        if(sexo!='M' && sexo!='H') sexo = 'M';
        return sexo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    private String generaDNI(){
            String dni="";
            Long x;
            Random random=new Random();
            x=random.nextLong(15000000,60000000);
            dni=x.toString();
        System.out.println(dni+" -> dni generado");
            return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return dni.equals(persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
