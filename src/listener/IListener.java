package listener;

import main.Passenger;

import java.util.ArrayList;

public interface IListener {
   void openTerminal(ArrayList<Passenger> queue);
}
