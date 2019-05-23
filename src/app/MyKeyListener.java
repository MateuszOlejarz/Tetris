/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.Brick;
import data.MyMatrix;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.MatrixPanel;

/**
 *
 * @author student
 */
public class MyKeyListener implements KeyListener{

    private Brick brick;
    private MyMatrix matrix;
    private MatrixPanel panel;

    public void setBrick(Brick brick) {
        this.brick = brick;
    }

    public void setMatrix(MyMatrix matrix) {
        this.matrix = matrix;
    }

    public void setPanel(MatrixPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        matrix.clearBrick(Game.row, Game.col, brick);
        int newcol = Game.col;
        if (e.getKeyCode() == 37) {
            newcol--;
        }else if (e.getKeyCode() == 39) {
            newcol++;
        }
        if (matrix.canPlaceBrick(Game.row, newcol, brick)) {
            Game.col = newcol;
        }
        matrix.placeBrick(Game.row, Game.col, brick);
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
