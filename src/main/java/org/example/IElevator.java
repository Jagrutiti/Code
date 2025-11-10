package org.example;

public interface IElevator {
    boolean requestUp(int floor);
    boolean requestDown(int floor);
    boolean goToFloor(int floor);
    int getCurrentFloor();
    String getDirection();
}

//We’re designing a simple elevator controller for a 10-floor building (floors 1–10).
//
//        🎯 Requirements
//        1.Elevator starts at floor 1.
//        2.Users can request:
//        		•	requestUp(int floor) — someone at that floor wants to go up.
//        		•   requestDown(int floor) — someone at that floor wants to go down.
//        3.Inside the elevator:
//        		•goToFloor(int floor) — user presses a button to go to that floor.
//        4.Invalid floors (below 1 or above 10) must be ignored.
//        5.Elevator should move in logical order:
//        		•If going up → serve all higher floors in order.
//        		•If going down → serve all lower floors in order.
//        6.Return current floor after each move.
//        7.Elevator must be reusable — handle multiple requests.