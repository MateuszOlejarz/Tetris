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
public class MyMatrix extends AbstractMatrix {

    public MyMatrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Złe wymiary macierzy!!!");
        }
        tab = new int[rows][cols];
    }

    /**
     * Losuje do tablicy elementy 0 albo 1.
     */
    public void randomElements() {
        randomElements(0, 1);
        /*for (int i = 0, n = getRowCount(); i < n; i++) {
         for (int j = 0, m = getColCount(); j < m; j++) {
         tab[i][j] = Math.random() < 0.5 ? 0 : 1;
         }
         }*/
    }

    /**
     * Losuje do tablicy elementy od from do to.
     *
     * @param from
     * @param to
     */
    public void randomElements(int from, int to) {
        Random rand = new Random();
        for (int i = 0, n = getRowCount(); i < n; i++) {
            for (int j = 0, m = getColCount(); j < m; j++) {
                tab[i][j] = (rand.nextInt(Integer.MAX_VALUE)) % (to - from + 1) + from;
                // tab[i][j] = from + rand.nextInt(to - from +1);
            }
        }
    }

    public void randomTetris(int rows) {
        if (rows < 0 || rows >= getRowCount()) {
            throw new IllegalArgumentException("Zły index wiersza!!!");
        }
        int idx;
        while (rows > 0) {
            idx = getRowCount() - rows;
            do {
                randomRow(idx);
            } while (isEmptyRow(idx) || isFullRow(idx));
            rows--;
        }
    }

    public boolean isEmptyRow(int row) {
        if (row < 0 || row >= getRowCount()) {
            throw new IllegalArgumentException("Zły index wiersza!!!");
        }
        for (int j = 0, m = getColCount(); j < m; j++) {
            if (tab[row][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isFullRow(int row) {
        if (row < 0 || row >= getRowCount()) {
            throw new IllegalArgumentException("Zły index wiersza!!!");
        }
        for (int j = 0, m = getColCount(); j < m; j++) {
            if (tab[row][j] == 0) {
                return false;
            }
        }
        return true;
    }

    private void randomRow(int row, int from, int to) {
        if (row < 0 || row >= getRowCount()) {
            throw new IllegalArgumentException("Zły index wiersza!!!");
        }
        Random rand = new Random();
        for (int j = 0, m = getColCount(); j < m; j++) {
            tab[row][j] = from + rand.nextInt(to - from + 1);
        }
    }

    private void randomRow(int row) {
        if (row < 0 || row >= getRowCount()) {
            throw new IllegalArgumentException("Zły index wiersza!!!");
        }
        randomRow(row, 0, 1);
    }

    public void placeBrick(int row, int col, Brick br) {
        placeBrickAsValue(row, col, br, 1);
    }

    public void clearBrick(int row, int col, Brick br) {
        placeBrickAsValue(row, col, br, 0);
    }

    private void placeBrickAsValue(int row, int col, Brick br, int val) {
        if (br == null) {
            throw new NullPointerException("Nie ma klocka do użycia!!!");
        }
        if (row < 0 || row + br.getRowCount() > getRowCount()) {
            throw new IllegalArgumentException("Zły index wiersza!!!");
        }
        if (col < 0 || col + br.getColCount() > getColCount()) {
            throw new IllegalArgumentException("Zły index kolumny!!!");
        }
        for (int i = 0, n = br.getRowCount(); i < n; i++) {
            for (int j = 0, m = br.getColCount(); j < m; j++) {
                if (br.getElement(i, j) == 1) {
                    tab[row + i][col + j] = val;
                }
            }
        }
    }

    public boolean canPlaceBrick(int row, int col, Brick br) {
        if (row < 0 || row + br.getRowCount() > getRowCount()) {
            return false;
        }
        if (col < 0 || col + br.getColCount() > getColCount()) {
            return false;
        }
        for (int i = 0; i < br.getRowCount(); i++) {
            for (int j = 0; j < br.getColCount(); j++) {
                if (br.getElement(i, j) + getElement(row + i, col + j) > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
