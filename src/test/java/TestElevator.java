import org.example.Elevator;
import org.junit.Test;

import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class TestElevator {

    @Test
    public void testGoToFloor() {
        Elevator elevator = new Elevator(0, 10);
        elevator.requestUp(3);
        assertEquals(elevator.getCurrStatus(), "currFloor= 0 currDir= UP");
        boolean result = elevator.goToFloor(5);
        assertEquals(elevator.getCurrStatus(), "currFloor= 5 currDir= DOWN");
    }

    @Test
    public void testDataInUpAndDownSets() {
        Elevator elevator = new Elevator(5, 10);
        elevator.requestDown(3);
        assertEquals(elevator.getDownSet(), new TreeSet<>(List.of(3)));
        elevator.requestUp(8);
        assertEquals(elevator.getUpSet(), new TreeSet<>(List.of(8)));
        elevator.requestDown(1);
        assertEquals(elevator.getDownSet(), new TreeSet<>(List.of(1,3)));
    }

    @Test
    public void testGoToFloorScenario1() {
        Elevator elevator = new Elevator(5, 10);
        elevator.requestUp(5);
        assertEquals(elevator.getCurrStatus(), "currFloor= 5 currDir= UP");
        elevator.goToFloor(6);
        assertEquals(elevator.getCurrStatus(), "currFloor= 6 currDir= DOWN");
        elevator.requestDown(3);
        assertEquals(elevator.getCurrStatus(), "currFloor= 6 currDir= DOWN");
        elevator.goToFloor(2);
        assertEquals(elevator.getCurrStatus(), "currFloor= 2 currDir= DOWN");
        elevator.goToFloor(6 );
        assertEquals(elevator.getCurrStatus(), "currFloor= 6 currDir= DOWN");
    }

    @Test
    public void testGoToFloorScenario2() {
        Elevator elevator = new Elevator(3, 10);
        elevator.goToFloor(11);
        assertEquals(elevator.getCurrStatus(), "currFloor= 3 currDir= null");
        elevator.goToFloor(16);
        assertEquals(elevator.getCurrStatus(), "currFloor= 3 currDir= null");
    }
}
