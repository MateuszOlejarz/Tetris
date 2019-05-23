/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.MyMatrix;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class MatrixPanel extends JPanel {

    private MyMatrix matrix;

    public MatrixPanel(MyMatrix matrix) {
        this.matrix = matrix;
    }

    public MyMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(MyMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int size = 30;
        for (int i = 4, n = matrix.getRowCount(); i < n; i++) {
            for (int j = 0, m = matrix.getColCount(); j < m; j++) {              
                if (matrix.getElement(i, j) == 1) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j*size, i*size, size, size);
                g.setColor(Color.BLACK);
                g.drawRect(j*size, i*size, size, size);
            }
        }
    }

}
