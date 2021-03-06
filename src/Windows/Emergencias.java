/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Classes.Complejo_Hospitalario;
import Classes.Conexion;
import Classes.Hilo;
import Classes.Ubicacion;
import static Windows.MainWindow.ambulancias;
import static Windows.MainWindow.complejos;
import static Windows.MainWindow.grafo;
import static Windows.MainWindow.paramedicos;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.UndirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Memo
 */
public class Emergencias extends javax.swing.JFrame {

    /**
     * Creates new form Emergencias
     */
    public Emergencias() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cb_comp = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cb_rank = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ubicacion con la Emergencia: ");

        jLabel2.setText("Grado de la Emergencia: ");

        cb_rank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));

        jButton1.setText("Ejecutar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(cb_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_rank, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_rank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Ubicacion ubicacion = (Ubicacion) cb_comp.getSelectedItem();
        DijkstraShortestPath<Ubicacion, Conexion> dij1;

        Transformer<Conexion, Integer> wtTransformer1 = new Transformer<Conexion, Integer>() {
            public Integer transform(Conexion link) {
                return link.getDistancia();
            }
        };
        dij1 = new DijkstraShortestPath(grafo, wtTransformer1);
        ArrayList checking = new ArrayList();
        for (int i = 0; i < complejos.size(); i++) {
            if (complejos.get(i) instanceof Complejo_Hospitalario) {
                List<Conexion> l = dij1.getPath(ubicacion, complejos.get(i));
                checking.add(l);
            }
        }
        int smallest = 999999;
        for (int i = 0; i < checking.size(); i++) {
            if (smallest > ((List)checking.get(i)).size()) {
                smallest = ((List)checking.get(i)).size();
            }
        }
        List<Conexion> ll =  null ;
        for (int i = 0; i < checking.size(); i++) {
            if (smallest == ((List)checking.get(i)).size()) {
                ll = (List<Conexion>) checking.get(i);
            }
        }
        UndirectedSparseMultigraph grafo = new UndirectedSparseMultigraph<Ubicacion, Conexion>();
        for (int i = 0; i < ll.size(); i++) {
            grafo.addEdge(ll.get(i), ll.get(i).getUbicacion1(), ll.get(i).getUbicacion2(), EdgeType.UNDIRECTED);
        }

        Layout<Integer, String> layout = new CircleLayout(grafo);
        layout.setSize(new Dimension(550, 550));
        BasicVisualizationServer<Integer, String> visualization = new BasicVisualizationServer<Integer, String>(layout);
        visualization.setPreferredSize(new Dimension(600, 600));
        visualization.getRenderContext().setLabelOffset(20);
        visualization.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        visualization.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        JFrame frame = new JFrame("Mas Corto");
        frame.getContentPane().add(visualization);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        new Thread(new Hilo(paramedicos,ambulancias)).start();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Emergencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emergencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emergencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emergencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emergencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox cb_comp;
    private javax.swing.JComboBox cb_rank;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
