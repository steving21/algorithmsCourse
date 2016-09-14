package assignment._1.Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Irving Lop on 12/09/2016.
 *
 */
public class Percolation {

    public enum Site {
        BLOCKED(0),
        EMPTY(1),
        FULL(2);

        private int value;

        Site(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private int [][] grid;
    private WeightedQuickUnionUF wQUUF;

    /**
     * create n-by-n grid, with all sites blocked
     * @param n size of the square grid
     */
    public Percolation(int n) {
        if (n <= 0) {
            throw  new IllegalArgumentException("elements must be greater than zero");
        }
        grid = new int[n][n];
        wQUUF = new WeightedQuickUnionUF(n*n+2);
        // Connect virtual nodes on the top and on the bottom
        for (int col = 1; col <= n; col ++) {
            wQUUF.union(0, col);
            wQUUF.union(n*n+1, col + ((n - 1) * n));
        }

    }

    public void open(int row, int column) {
        validate(row, column);
        if (grid[row - 1][column - 1] == Site.BLOCKED.getValue()) {

        }
    }

    private void validate(int ... indexes) {
        for (int index : indexes) {
            if (index <= 0 || index > grid.length) {
                throw new IndexOutOfBoundsException("index must be greater than 0 and less than " + (grid.length + 1)
                        + ". You put " + index);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Percolation percolation = new Percolation(n);
        int index = 0;
        System.out.println("---- " + index + "[" + percolation.wQUUF.find(index) + "]----- ");
        index++;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                System.out.print(index + "[" + percolation.wQUUF.find(index) + "] ");
                index++;
            }
            System.out.println();
        }
        System.out.println("---- " + index + "[" + percolation.wQUUF.find(index) + "]----- ");
    }
}
