package org.openjfx;

import java.util.ArrayList;
import java.util.List;

public class TriangleModel {
    public interface Observer {
        void modelChanged(double base, double height);
    }

    private double base;
    private double height;
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void setBase(double base) {
        this.base = base;
        notifyObservers();
    }

    public void setHeight(double height) {
        this.height = height;
        notifyObservers();
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double getHypotenuse() {
        return Math.sqrt(base * base + height * height);
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.modelChanged(base, height);
        }
    }
}
