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
public class Complejo  extends Ubicacion implements Serializable{
    private String rank_emergency;

    public Complejo(String nombre) {
        super(nombre);
    }

    

    

    public String getRank_emergency() {
        return rank_emergency;
    }

    public void setRank_emergency(String rank_emergency) {
        this.rank_emergency = rank_emergency;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
