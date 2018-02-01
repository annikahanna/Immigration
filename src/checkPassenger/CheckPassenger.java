package checkPassenger;

import main.Passenger;

public class CheckPassenger {
    private CheckPassenger successor;

    public void check(Passenger passenger) {
        if (getSuccessor() != null)
            getSuccessor().check(passenger);
        else
            System.out.println("Passenger can't check in");
    }

    public boolean canHandlePassenger(Passenger passenger, String type) {
        if (passenger.getType().equals(type)) {
            return true;
        }
        return false;
    }

    public CheckPassenger getSuccessor() {
        return successor;
    }

    public void setSuccessor(CheckPassenger successor) {
        this.successor = successor;
    }
}


