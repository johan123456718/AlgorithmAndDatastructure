/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift4;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Johan Challita Tidaa
 */
public class Airport {

    private static class Plane {

        private int requestStart;
        private int startTime;
        private boolean landed; //false = lift, true = land

        public Plane(int requestStart, boolean landed) {
            this.requestStart = requestStart;
            this.landed = landed;
            this.startTime = 0;
        }

        public int getRequestStart() {
            return requestStart;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int sTime) {
            this.startTime = sTime;
        }

        public boolean isLanding() {
            return landed;
        }

    }
    private Queue<Plane> landingQueue, liftingQueue;
    private int maximalWaitTimeLifting;
    private int maximalWaitTimeLanding;
    private int totalWaitTimeLifting;
    private int totalWaitTimeLand;
    private int nrOfLanded;
    private int nrOfLifts;
    private int waitTime;
    private boolean landZoneFull;

    public Airport() {
        this.landingQueue = new LinkedList<>();
        this.liftingQueue = new LinkedList<>();
        this.maximalWaitTimeLifting = 0;
        this.maximalWaitTimeLanding = 0;
        this.totalWaitTimeLifting = 0;
        this.totalWaitTimeLand = 0;
        this.waitTime = 0;
        this.nrOfLanded = 0;
        this.nrOfLifts = 0;
        this.landZoneFull = false;
    }

    public void simulation() {
        Plane plane = null;
        for (int i = 0; i < 5256000; i += 5) {
            if ((int) (Math.random() * 100) < 5) {
                Plane liftingPlane = new Plane(i, false);
                liftingQueue.offer(liftingPlane);
            }
            if ((int) (Math.random() * 100) < 5) {
                Plane landingPlane = new Plane(i, true);
                landingQueue.offer(landingPlane);
            }

            if (landZoneFull == true && plane != null) {
                if (i - plane.getStartTime() == 20) {
                    if (plane.isLanding()) {
                        nrOfLanded++;
                        this.waitTime = plane.getStartTime() - plane.getRequestStart();
                        totalWaitTimeLand = totalWaitTimeLand + waitTime;

                        if (maximalWaitTimeLanding < waitTime) {
                            maximalWaitTimeLanding = waitTime;
                        }
                        landZoneFull = false;
                    } else {
                        nrOfLifts++;
                        this.waitTime = plane.getStartTime() - plane.getRequestStart();
                        totalWaitTimeLifting = totalWaitTimeLifting + waitTime;
                        if (maximalWaitTimeLifting < waitTime) {
                            maximalWaitTimeLifting = waitTime;
                        }
                        landZoneFull = false;
                    }
                }
            }

            if (landZoneFull == false) {
                if (landingQueue.peek() != null) {
                    plane = landingQueue.poll();
                    plane.setStartTime(i);
                    landZoneFull = true;
                } else if (liftingQueue.peek() != null) {
                    plane = liftingQueue.poll();
                    plane.setStartTime(i);
                    landZoneFull = true;
                }
            }
        }
        displayStatistics();
    }

    public void displayStatistics() {
        double averageWaitTimeLifting;
        double averageWaitTimeLanding;

        averageWaitTimeLifting = (double) totalWaitTimeLifting / nrOfLifts;
        averageWaitTimeLanding = (double) totalWaitTimeLand / nrOfLanded;

        System.out.println("Average lift time: " + averageWaitTimeLifting);
        System.out.println("Average land time: " + averageWaitTimeLanding);
        System.out.println();
        System.out.println("Maximal waitTime lifting: " + maximalWaitTimeLifting);

        System.out.println("Maximal WaitTime landing: " + maximalWaitTimeLanding);
    }

}
