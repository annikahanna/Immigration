package terminal;

import main.Passenger;

public interface ITerminal {
    void checkInPassenger(Passenger passenger);
    String getType();
}
