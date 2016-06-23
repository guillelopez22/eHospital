/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author Memo
 */
public class Paramedico implements Serializable{
    private String complete_name;
    private int edad;
    private String identidad;
    private String rank;
    private Complejo_Hospitalario complejo;

    public Paramedico(String complete_name, int edad, String identidad, String rank, Complejo_Hospitalario complejo) {
        this.complete_name = complete_name;
        this.edad = edad;
        this.identidad = identidad;
        this.rank = rank;
        this.complejo = complejo;
    }

    public String getComplete_name() {
        return complete_name;
    }

    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Complejo_Hospitalario getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo_Hospitalario complejo) {
        this.complejo = complejo;
    }

    @Override
    public String toString() {
        return complete_name;
    }
    
    
    
    
    
}
