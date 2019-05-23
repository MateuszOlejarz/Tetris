/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.Brick;
import data.MyMatrix;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MatrixPanel;

/**
 *
 * @author student
 */
public class WDol extends Thread {

    private Brick brick;
    private MyMatrix matrix;
    private MatrixPanel panel;
    private MyKeyListener listener;

    public void setBrick(Brick brick) {
        this.brick = brick;
    }

    public void setMatrix(MyMatrix matrix) {
        this.matrix = matrix;
    }

    public void setPanel(MatrixPanel panel) {
        this.panel = panel;
    }

    public void setListener(MyKeyListener listener) {
        this.listener = listener;
    }

    
    @Override
    public void run() {
        super.run();
        System.out.println("Wątek działa");
        while (matrix.isEmptyRow(4)){
            brick=new Brick();
            listener.setBrick(brick);
            Game.row = 4-brick.getRowCount();
            Game.col = ((matrix.getColCount()-brick.getColCount())/2);
            while(true){
            matrix.placeBrick(Game.row, Game.col, brick);
            panel.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(WDol.class.getName()).log(Level.SEVERE, null, ex);
            }
            matrix.clearBrick(Game.row, Game.col, brick);
            if (matrix.canPlaceBrick(Game.row + 1, Game.col, brick)) {
                Game.row++;
            } else {
                matrix.placeBrick(Game.row, Game.col, brick);
                panel.repaint();    // w zasadzie nie powinien być potrzebny
                break;
            }
        }
        }
    }
}
