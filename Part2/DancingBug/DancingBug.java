/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
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
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug {
    private int steps;
    private int[] dance;

    /**
     * Write a class DancingBug that "dances" by making different turns
     * before each move. The DancingBug constructor has an integer array
     * as parameter. The integer entries in the array represent how many
     * times the bug turns before it moves. For example, an array entry of
     * 5 represents a turn of 225 degrees (recall one turn is 45 degrees).
     * When a dancing bug acts, it should turn the number of times given
     * by the current array entry, then act like a Bug. In the next move,
     * it should use the next entry in the array. After carrying out the
     * last turn in the array, it should start again with the initial 
     * array value so that the dancing bug continually repeats 
     * the same turning pattern.
     * The DancingBugRunner class should create an array and 
     * pass it as aparameter to the DancingBug constructor.
     */
    public DancingBug(int[] array) {
        steps = 0;
        if (array == null) {
        dance = new int[0];
        } else {
        dance = (int[]) array.clone();
        }
    }

    /**
     * Moves to the next location of the square.
     */
    public void act() {
        if (steps == dance.length) {
            steps = 0;
        } else {
            for (int i = 0; i < dance[steps]; i++) {
                turn();
            }
            steps++;
            if (canMove()) {
                move();
            } else {
                turn();
            }
        }
    }
}
