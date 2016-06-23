/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Memo
 */
public class Ambulancia implements Serializable{
    private String numero_placa;
    private int año;
    private int max_speed;
    private Complejo_Hospitalario complejo;
    private ArrayList<Paramedico> paramedicos = new ArrayList();

    public Ambulancia(String numero_placa, int año, int max_speed, Complejo_Hospitalario complejo) {
        this.numero_placa = numero_placa;
        this.año = año;
        this.max_speed = max_speed;
        this.complejo = complejo;
    }

    public void setParamedicos(Paramedico paramedicos) {
        this.paramedicos.add(paramedicos);
    }

    
    public ArrayList<Paramedico> getParamedicos() {
        return paramedicos;
    }

    public void addParamedico(Paramedico paramedico) {
        paramedicos.add(paramedico);
    }
    

    public String getNumero_placa() {
        return numero_placa;
    }

    public void setNumero_placa(String numero_placa) {
        this.numero_placa = numero_placa;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public Complejo_Hospitalario getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo_Hospitalario complejo) {
        this.complejo = complejo;
    }

    @Override
    public String toString() {
        return "" + numero_placa;
    }
    
    
}
