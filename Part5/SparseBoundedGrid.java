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

/**
 * A <code>BoundedGrid</code> is a rectangular grid with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundedGrid<E> extends AbstractGrid<E> {
    class OccupantInCol {
        private Object occupant;
        private int col;
        public OccupantInCol (Object obj, int colNum) {
            occupant = obj;
            col = colNum;
        }
        public Object getOccupant() {
            return occupant;
        }
        public int getCol() {
            return col;
        }
        public void setObj(Object obj) {
            occupant = obj;
        }
    }
    // the array storing the grid elements
    private ArrayList<LinkedList<OccupantInCol>> occupantArray; 
    private int numCols;
    private int numRows;

    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    public SparseBoundedGrid(int rows, int cols) {
        if (rows <= 0) {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("cols <= 0");
        }
        numCols = cols;
        numRows = rows;
        occupantArray = new ArrayList<LinkedList<OccupantInCol>>();
        for (int i = 0; i < rows; i++) {
            occupantArray.add(new LinkedList<OccupantInCol>());
        }
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public boolean isValid(Location loc) {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }

    public ArrayList<Location> getOccupiedLocations() {
        ArrayList<Location> theLocations = new ArrayList<Location>();
        // Look at all grid locations.
        for (int r = 0; r < getNumRows(); r++) {
            //visit the arraylist and innitial the linkedlist
            LinkedList<OccupantInCol> list = occupantArray.get(r);
            if (list != null) {
               for (OccupantInCol occ : list) {
                   Location loc = new Location(r, occ.getCol());
                   if (get(loc) != null) {
                       theLocations.add(new Location(r, occ.getCol()));
                   }
               } 
            }
        }
        return theLocations;
    }

    public E get(Location loc) {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        int r = loc.getRow();
        LinkedList<OccupantInCol> list = occupantArray.get(r);
        if (list != null) {
            for (OccupantInCol occ : list) {
                if (loc.getCol() == occ.getCol()) {
                    return (E) occ.getOccupant();
                }
            }
        }
        return null;
    }

    public E put(Location loc, E obj) {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }
        // Add the object to the grid.
        int cou = 0;
        LinkedList<OccupantInCol> list = occupantArray.get(loc.getRow());
        E oldOccupant = get(loc);
        for (OccupantInCol occ : list) {
            if (occ.getCol() == loc.getCol()) {
                occ.setObj(obj);
                cou = 1;
                break;
            }
        }
            if (cou == 0) {
                occupantArray.get(loc.getRow()).add(new OccupantInCol(obj, loc.getCol()));
            }
        return oldOccupant;
    }

    public E remove(Location loc) {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc + " is not valid");
        }
        // Remove the object from the grid.
        E r = get(loc);
        if (r == null) {
            return null;
        }
        LinkedList<OccupantInCol> list = occupantArray.get(loc.getRow());
        int count = 0;
        for (OccupantInCol occ : list) {
            if (occ.getCol() == loc.getCol()) {
                list.remove(count);
                break;
            }
            count++;          
        }
        return r;
    }
}
