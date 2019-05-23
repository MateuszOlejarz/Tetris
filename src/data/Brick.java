/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;

/**
 *
 * @author student
 */
public class Brick extends AbstractMatrix {

    public Brick() {
        Random rand = new Random();
        Tetromino[] types = Tetromino.values();
        createBrick(types[rand.nextInt(types.length)]);
        for (int i = 0, rotcnt = rand.nextInt(4); i < rotcnt; i++) {
            rotateRight();
        }
    }

    private void createBrick(Tetromino type) {
        switch (type) {
            case I:
                tab = new int[4][1];
                for (int i = 0, n = getRowCount(); i < n; i++) {
                    tab[i][0] = 1;
                }
                break;
            case J:
                tab = new int[3][2];
                tab[0][1] = 1;
                tab[1][1] = 1;
                tab[2][1] = 1;
                tab[2][0] = 1;
                break;
            case L:
                tab = new int[3][2];
                tab[0][0] = 1;
                tab[1][0] = 1;
                tab[2][0] = 1;
                tab[2][1] = 1;
                break;
            case O:
                tab = new int[][]{{1, 1}, {1, 1}};
                break;
            case S:
                tab = new int[][]{{0, 1, 1}, {1, 1, 0}};
                break;
            case T:
                tab = new int[][]{{1, 1, 1}, {0, 1, 0}};
                break;
            case Z:
                tab = new int[][]{{1, 1, 0}, {0, 1, 1}};
                break;
            default:
                throw new AssertionError();
        }
    }

    public void rotateRight() {
        transpose();
        int newtab[][] = new int[getRowCount()][getColCount()];
        for (int i = 0, n = getRowCount(); i < n; i++) {
            for (int j = 0, m = getColCount(); j < m; j++) {
                newtab[i][j] = tab[i][m - 1 - j];
            }
        }
        tab = newtab;
    }

    public void rotateLeft() {
        transpose();
        int newtab[][] = new int[getRowCount()][getColCount()];
        for (int i = 0, n = getRowCount(); i < n; i++) {
            for (int j = 0, m = getColCount(); j < m; j++) {
                newtab[i][j] = tab[n - 1 - i][j];
            }
        }
        tab = newtab;
    }

    private void transpose() {
        int newtab[][] = new int[getColCount()][getRowCount()];
        for (int i = 0, n = getRowCount(); i < n; i++) {
            for (int j = 0, m = getColCount(); j < m; j++) {
                newtab[j][i] = tab[i][j];
            }
        }
        tab = newtab;
    }
    
    private void getRotatedR(){
        
    }
    private void getRotatedL(){
        
    }
}
