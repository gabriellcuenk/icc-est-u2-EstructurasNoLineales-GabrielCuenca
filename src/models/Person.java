package models;

public class Person implements Comparable<Person>{
    private String nombre;
    private int edad;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Person(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Nombre=" + nombre + ", edad=" + edad;
    }
    @Override
    public int compareTo(Person otra) {
       int compAge = Integer.compare(this.edad, otra.getEdad());

       if(compAge !=0)
        return compAge;

       return this.nombre.compareTo(otra.getNombre());
    }

}
