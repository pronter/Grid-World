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
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;
/**
Create a class BlusterCritter that extends Critter. A BlusterCritter looks at all of the neighbors within two steps of its current location. (For a BlusterCritter not near an edge, this includes 24 locations). It counts the number of critters in those locations. If there are fewer than c critters, the BlusterCritter's color gets brighter (color values increase). If there are c or more critters, the BlusterCritter's color darkens (color values decrease). Here, c is a value that indicates the courage of the critter. It should be set in the constructor.
 */
public class BlusterCritter extends Critter {
    private int cc;
    private static final int CH = 5;
    private static final int GR = 128;
    private static final int MA = 255;
    public BlusterCritter(Color bccolor, int c) {
        setColor(bccolor);
        cc =  c;
    }
    /* get all of the neighbors within two steps of its current location */
    public ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();
        for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ ) {
            for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++) {
                Location tempLoc = new Location(r,c);
                if(getGrid().isValid(tempLoc)) {
                    Actor a = getGrid().get(tempLoc);
                    if(a != null && a != this) {
                        actors.add(a);
                    }
                }
            }
        }
        return actors;
    }
    /* Count all of the neighbors within two steps of its current location */
    /* If there are fewer than c critters, the BlusterCritter's color gets brighter (color values increase).*/
    /* If there are c or more critters, the BlusterCritter's color darkens (color values decrease).*/
    public void processActors(ArrayList<Actor> actors) {
        int count = 0;
        for (Actor a: actors) {
            if (a instanceof Critter) {
                count++;
            }
        }
        /* make the color-value have a initial value */
        int red = 0;
        int green = 0;
        int blue = 0;
        if (count < cc) {
        /* make a size of color-value and set their values in two cases */
            if (red > 0 && red < MA && green > 0 && green < MA && blue > 0 && blue < MA) {
                red = GR + (cc - count)*CH;
                green = GR + (cc - count)*CH;
                blue = GR + (cc- count)*CH;
            }
        } else {
            if (red > 0 && red < MA && green > 0 && green < MA && blue > 0 && blue < MA) {
                red = GR - (count - cc)*CH;
                green = GR - (count - cc)*CH;
                blue= GR - (count - cc)*CH;
            }
        }
        setColor(new Color(red, green, blue));
    }


    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc) {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}
