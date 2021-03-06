/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import app.Game;
import app.MyKeyListener;
import app.WDol;
import data.Brick;
import data.MyMatrix;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class MainFrame extends javax.swing.JFrame {

    MyMatrix matrix;
    MyKeyListener keyListener;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        matrix = new MyMatrix(15, 8);
        this.setFocusable(true);      
        keyListener = new MyKeyListener();
        this.addKeyListener(keyListener);
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

        jPanel1 = new MatrixPanel(matrix);
        jbRandom = new javax.swing.JButton();
        jbTetris = new javax.swing.JButton();
        jbPutBrick = new javax.swing.JButton();
        jbClearBrick = new javax.swing.JButton();
        jbStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jbRandom.setText("Losuj");
        jbRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRandomActionPerformed(evt);
            }
        });

        jbTetris.setText("Tetris");
        jbTetris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTetrisActionPerformed(evt);
            }
        });

        jbPutBrick.setText("Umieść klocek");
        jbPutBrick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPutBrickActionPerformed(evt);
            }
        });

        jbClearBrick.setText("Kasuj klocek");
        jbClearBrick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearBrickActionPerformed(evt);
            }
        });

        jbStart.setText("Start");
        jbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRandom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbTetris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPutBrick, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jbClearBrick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbRandom)
                .addGap(18, 18, 18)
                .addComponent(jbTetris)
                .addGap(18, 18, 18)
                .addComponent(jbPutBrick)
                .addGap(18, 18, 18)
                .addComponent(jbClearBrick)
                .addGap(18, 18, 18)
                .addComponent(jbStart)
                .addContainerGap(419, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRandomActionPerformed
        matrix.randomElements();
        jPanel1.repaint();
    }//GEN-LAST:event_jbRandomActionPerformed

    private void jbTetrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTetrisActionPerformed
        matrix.randomTetris(7);
        jPanel1.repaint();
    }//GEN-LAST:event_jbTetrisActionPerformed

    private void jbPutBrickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPutBrickActionPerformed
        br = new Brick();
        try {
            matrix.placeBrick(14, 4, br);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Błąd:\n" + e.getMessage());
        }
        jPanel1.repaint();
    }//GEN-LAST:event_jbPutBrickActionPerformed

    private Brick br;

    private void jbClearBrickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearBrickActionPerformed
        matrix.clearBrick(13, 4, br);
        jPanel1.repaint();
    }//GEN-LAST:event_jbClearBrickActionPerformed

    private void jbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStartActionPerformed
        WDol wd = new WDol();
        wd.setMatrix(matrix);
        wd.setPanel((MatrixPanel) jPanel1);
        keyListener.setMatrix(matrix);
        keyListener.setPanel((MatrixPanel) jPanel1);
        wd.setListener(keyListener);
        wd.start();
        this.requestFocus();
    }//GEN-LAST:event_jbStartActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbClearBrick;
    private javax.swing.JButton jbPutBrick;
    private javax.swing.JButton jbRandom;
    private javax.swing.JButton jbStart;
    private javax.swing.JButton jbTetris;
    // End of variables declaration//GEN-END:variables
}
