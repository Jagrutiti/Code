package org.example;

import java.util.*;

public class Elevator implements IElevator {
    private int currentFloor = 0;
    private int totalFloors = 0;
    private TreeSet<Integer>  up = new TreeSet<>();
    private TreeSet<Integer> down = new TreeSet<>();
    private DIRECTIONS currDirection;  // mutable variable

    private enum DIRECTIONS {
        UP,
        DOWN
    }

    public Elevator(int initialFloor, int totalFloors) {
        this.totalFloors = totalFloors;
        this.currentFloor = initialFloor;
    }

    @Override
    public boolean requestUp(int floor) {
        if(currDirection == null || down.isEmpty() || floor > currentFloor) {
            currDirection = DIRECTIONS.UP;
        }
        return addFloor(floor);
    }

    @Override
    public boolean requestDown(int floor) {
        if(currDirection == null || up.isEmpty() || floor < currentFloor) {
            currDirection = DIRECTIONS.DOWN;
        }
        return addFloor(floor);
    }

    @Override
    public boolean goToFloor(int floor) {
        boolean isFloorAdded = addFloor(floor);

        if(!isFloorAdded) {
            return false;
        }

        while(!up.isEmpty() && currDirection == DIRECTIONS.UP) {
            currentFloor = up.pollFirst();
            System.out.println(getCurrStatus());

        }

        updateDirection();

        while(!down.isEmpty() && currDirection == DIRECTIONS.DOWN) {
            currentFloor = down.pollLast();
            System.out.println(getCurrStatus());

        }
        return true;
    }

    @Override
    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public String getDirection() {
        return String.valueOf(currDirection);
    }

    private boolean addFloor(int floor) {
        if(!isValidFloor(floor)) {
            return false;
        }
        if(currDirection == DIRECTIONS.UP && floor > currentFloor){
            up.add(floor);
        }
        else {
            down.add(floor);
        }

        return true;
    }

    private boolean isValidFloor(int floor) {
        return floor != currentFloor && floor >= 0 && floor <= totalFloors;
    }

    public String getCurrStatus() {
        return String.format("currFloor= %s currDir= %s", currentFloor, currDirection);
    }

    public void updateDirection() {
        if(up.isEmpty()) {
            currDirection = DIRECTIONS.DOWN;
        }
        else {
            currDirection = DIRECTIONS.UP;
        }
    }

    public TreeSet<Integer> getDownSet() {
        return down;
    }

    public TreeSet<Integer> getUpSet() {
        return up;
    }

}
