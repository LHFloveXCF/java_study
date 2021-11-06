package com.xu.mca.local.greenhouse;

import java.time.Instant;

/**
 * java_study
 */
public class GreenHouseController extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";

    private class LightOb extends Event {
        public LightOb(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String description() {
            return "light is on";
        }
    }

    private class LightOff extends Event{

        public LightOff(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String description() {
            return "light is off";
        }
    }

    private class WaterOn extends Event {

        public WaterOn(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String description() {
            return "water is on";
        }
    }
    private class WaterOff extends Event {

        public WaterOff(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String description() {
            return "water is off";
        }
    }

    private class ThermostatNight extends Event{

        public ThermostatNight(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String description() {
            return "thermostat on night setting";
        }
    }

    private class ThermostatDay extends Event{

        public ThermostatDay(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String description() {
            return "thermostat on day setting";
        }
    }

    private int rings;
    private class Bell extends Event{

        public Bell(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            System.out.println("bing");
            if (--rings > 0) {
                addEvent(new Bell(Instant.now().toEpochMilli() + 3000));
            }
        }

        @Override
        public String description() {
            return "ring bell";
        }
    }

    private class Restart extends Event {

        public Restart(long eventTime) {
            super(eventTime);
        }

        @Override
        public void action() {
            rings = 3;
            long now = Instant.now().toEpochMilli();
            addEvent(new ThermostatNight(now));
            addEvent(new WaterOn(now + 3000));
            addEvent(new WaterOff(now + 8000));

            addEvent(new LightOff(now + 2000));
            addEvent(new LightOb(now + 1000));
            addEvent(new Bell(now + 9000));
            addEvent(new ThermostatDay(now + 10000));
            addEvent(new Restart(now + 20000));
        }

        @Override
        public String description() {
            return "restart system";
        }
    }

    public static void main(String[] args) {
        GreenHouseController gc = new GreenHouseController();
        long now = Instant.now().toEpochMilli();
        gc.addEvent(gc.new Restart(now));
        gc.run();
    }
}
