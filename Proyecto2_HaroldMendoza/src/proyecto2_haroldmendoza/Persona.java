/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_haroldmendoza;

/**
 *
 * @author Harold Mendoza
 */
public class Persona {
    protected String puesto;
    protected String nombre;
    protected double salario;

    public Persona(String puesto, String nombre, double salario) {
        this.puesto = puesto;
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return  puesto + "," + nombre + "," + salario;
    }
    
    
}
