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
public class Conexion implements Serializable {
    private int distancia;
    Ubicacion ubicacion1, ubicacion2;

    public Conexion(int distancia, Ubicacion ubicacion1, Ubicacion ubicacion2) {
        this.distancia = distancia;
        this.ubicacion1 = ubicacion1;
        this.ubicacion2 = ubicacion2;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Ubicacion getUbicacion1() {
        return ubicacion1;
    }

    public void setUbicacion1(Ubicacion ubicacion1) {
        this.ubicacion1 = ubicacion1;
    }

    public Ubicacion getUbicacion2() {
        return ubicacion2;
    }

    public void setUbicacion2(Ubicacion ubicacion2) {
        this.ubicacion2 = ubicacion2;
    }

    @Override
    public String toString() {
        return ""+distancia;
    }
    
}
