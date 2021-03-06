/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Alyce Brady
 * @author APCS Development Committee
 * @author Cay Horstmann
 */
import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 * A <code>BoundedGrid</code> is a rectangular grid with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class UnboundedGrid2<E> extends AbstractGrid<E> {
    // the array storing the grid elements
    private Object[][] occupantArray; 
    private int ini = 16;
    public UnboundedGrid2() {
        occupantArray = new Object[ini][ini];
    }

    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    /*public UnboundedGrid2(int rows, int cols) {
        if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
        occupantArray = new Object[rows][cols];
    }
    */

    public int getNumRows() {
        return -1;
    }

    public int getNumCols() {
        return -1;
    }

    public boolean isValid(Location loc) {
        return 0 <= loc.getRow() && 0 <= loc.getCol();
    }

    public ArrayList<Location> getOccupiedLocations() {
        ArrayList<Location> a = new ArrayList<Location>();
        // Look at all grid locations.
        for (int r = 0; r < ini; r++) {
            for (int c = 0; c < ini; c++) {
                // If there's an object at this location, put it in the array.
                Location loc = new Location(r, c);
                if (get(loc) != null) {
                    a.add(loc);
                }
            }
        }
        return a;
    }

    public E get(Location loc) {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (loc.getRow() >= ini || loc.getCol() >= ini) {
            return null;
        }
        return (E) occupantArray[loc.getRow()][loc.getCol()];
    }

    public E put(Location loc, E obj) {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }
        if (loc.getRow() >= ini || loc.getCol() >= ini) {
            int size = ini;
            while (loc.getRow() >= size || loc.getCol() >= size) {
                size = size * 2;
            }s
            Object[][]temp = new Object[size][size];
            for (int row = 0; row < ini; row++) {
                for (int col = 0; col < ini; col++) {
                    temp[row][col] = occupantArray[row][col];
                }
            }
            occupantArray = temp;
            ini = size;
        }
        // Add the object to the grid.
        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }

    public E remove(Location loc) {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (loc.getRow() >= ini || loc.getCol() >= ini) {
            return null;
        }       
        // Remove the object from the grid.
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }
}
