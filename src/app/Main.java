/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.Brick;
import data.MyMatrix;
import view.MainFrame;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyMatrix matrix = new MyMatrix(6, 12);
        System.out.println(">>>Pusta");
        System.out.println(matrix);
        
        matrix.randomElements();
        System.out.println(">>>Losowa 0 1");
        System.out.println(matrix);
        
        matrix.randomElements(2, 10);
        System.out.println(">>>Losowa 2 10");
        System.out.println(matrix);
        
        Brick br = null;
        for (int i = 0; i < 100; i++) {
            br = new Brick();
            System.out.println(br);
        }
        
//        for (int i = 0; i < 10; i++) {
//            System.out.println(new Brick());
//        }
        br.rotateRight();
        System.out.println(br);
        br.rotateLeft();
        System.out.println(br);
        
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
    
}
