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

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class SpiralBugRunner {
    private static final int SIX = 6;
    private static final int THREE = 3;
    private static final int ONE = 1;
    private static final int FIVE = 5;
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        SpiralBug alice = new SpiralBug(THREE);
        alice.setColor(Color.ORANGE);
        SpiralBug bob = new SpiralBug(THREE);
        world.add(new Location(ONE, ONE), alice);
        world.add(new Location(FIVE, FIVE), bob);
        world.show();
    }
}
