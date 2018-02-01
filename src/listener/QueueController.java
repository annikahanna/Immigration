package listener;

import main.Passenger;

import java.util.ArrayList;

public class QueueController {
    IListener listener = new TerminalEasyPass();

    public void alarm(ArrayList<Passenger> queue){
        listener.openTerminal(queue);
    }
}
