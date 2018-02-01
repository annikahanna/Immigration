package main;

import checkPassenger.CheckPassengerDiplomat;
import checkPassenger.CheckPassengerEU;
import checkPassenger.CheckPassengerNonEU;
import listener.QueueController;
import random.MersenneTwisterFast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Application {


    public static void main(String[] args) {
        Timer timer = new Timer();
        MersenneTwisterFast randomizer = new MersenneTwisterFast();
        ArrayList<Passenger> queue = new ArrayList<>();
        CheckPassengerDiplomat checkPassengerDiplomat = new CheckPassengerDiplomat();
        CheckPassengerNonEU checkPassengerNonEU = new CheckPassengerNonEU(checkPassengerDiplomat);
        CheckPassengerEU checkPassengerEU = new CheckPassengerEU(checkPassengerNonEU);
        QueueController queueController = new QueueController();

        int i = 0;

        Passenger newPassenger = new Passenger("EU", String.valueOf(randomizer.nextLong()));
        queue.add(newPassenger);

        while (i < 10000) {
            timer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            int rand = randomizer.nextInt(0, 2);
                            if (rand == 0) {
                                Passenger newPassenger = new Passenger("diplomat", String.valueOf(randomizer.nextLong()));
                                queue.add(newPassenger);
                            } else if (rand == 1) {
                                Passenger newPassenger = new Passenger("EU", String.valueOf(randomizer.nextLong()));
                                queue.add(newPassenger);
                            } else {
                                Passenger newPassenger = new Passenger("nonEU", String.valueOf(randomizer.nextLong()));
                                queue.add(newPassenger);
                            }

                        }
                    }, 0000, 2000
            );


            if (queue.size() >= 5) {
                ArrayList<Passenger> queueTerminal4 = new ArrayList<>();
                queueTerminal4.add(queue.get(0));
                queueTerminal4.add(queue.get(1));
                queueTerminal4.add(queue.get(2));
                if (queue.size() > 0) {
                    queue.remove(queueTerminal4.get(0));
                } else {
                    queue.remove(queueTerminal4.get(0));
                    newPassenger = new Passenger("EU", String.valueOf(randomizer.nextLong()));
                    queue.add(newPassenger);
                }
                if (queue.size() > 0) {
                    queue.remove(queueTerminal4.get(1));
                } else {
                    queue.remove(queueTerminal4.get(1));
                    newPassenger = new Passenger("EU", String.valueOf(randomizer.nextLong()));
                    queue.add(newPassenger);
                }
                if (queue.size() > 0) {
                    queue.remove(queueTerminal4.get(2));
                } else {
                    queue.remove(queueTerminal4.get(2));
                    newPassenger = new Passenger("EU", String.valueOf(randomizer.nextLong()));
                    queue.add(newPassenger);
                }
                queueController.alarm(queueTerminal4);
            }

            if (queue.size() == 0) {
                System.out.println("Wait for Passengers");
            } else {
                checkPassengerEU.check(queue.get(0));
                queue.remove(0);
            }
        }

        i++;


    }
}

