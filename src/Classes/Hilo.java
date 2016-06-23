/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Windows.Paramedicos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Memo
 */
public class Hilo implements Runnable{

    
    int tiempo;
    ArrayList<Paramedico> paramedico;
    ArrayList<Ambulancia> ambulancias;
    Ambulancia ambulancia;
    int i=1;

    public Hilo(ArrayList<Paramedico> paramedicos,Ambulancia ambulancia) {
        this.tiempo = ambulancia.getMax_speed();
        this.paramedico = paramedicos;
    }

    @Override
    public void run() {
        System.out.println(tiempo+"tiempo");
        System.out.println(i+"conatdasd");
        while (i != tiempo) {
            //bara.setValue(i);
            //bara.repaint();
            i++;
            System.out.println(i+"cakasda");
            try {
                
                Thread.sleep(this.tiempo);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            if(i==tiempo){
                //bara.setValue(100);
                JOptionPane.showMessageDialog(null,"Se atendio la emergencia!!!");
                //bara.setValue(0);
                break;
            }
        }
    }

}
    

