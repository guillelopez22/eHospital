/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Memo
 */
public class Complejo_Hospitalario  extends Ubicacion implements Serializable{
   private String direccion;
   private int capacidad_paramedicos;
   private int capacidad_ambulancias;
   private String rank;
   private ArrayList<Paramedico> paramedicos = new ArrayList();
   private ArrayList<Ambulancia> ambulancias = new ArrayList();

    public Complejo_Hospitalario(String nombre, String direccion, int capacidad_paramedicos, int capacidad_ambulancias, String rank) {
        super(nombre);
        this.direccion = direccion;
        this.capacidad_paramedicos = capacidad_paramedicos;
        this.capacidad_ambulancias = capacidad_ambulancias;
        this.rank = rank;
    }

    

    public ArrayList<Paramedico> getParamedicos() {
        return paramedicos;
    }

    public void setParamedicos(Paramedico paramedico) {
        this.paramedicos.add(paramedico);
    }

    public ArrayList<Ambulancia> getAmbulancia() {
        return ambulancias;
    }

    public void setAmbulancia(Ambulancia ambulancia) {
        this.ambulancias.add(ambulancia);
    }
    
    
    public void montarAmbulancia(){
        int cont = 0;
        while(cont < capacidad_paramedicos){
            
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad_paramedicos() {
        return capacidad_paramedicos;
    }

    public void setCapacidad_paramedicos(int capacidad_paramedicos) {
        this.capacidad_paramedicos = capacidad_paramedicos;
    }

    public int getCapacidad_ambulancias() {
        return capacidad_ambulancias;
    }

    public void setCapacidad_ambulancias(int capacidad_ambulancias) {
        this.capacidad_ambulancias = capacidad_ambulancias;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return nombre;
    }
   
   
}
