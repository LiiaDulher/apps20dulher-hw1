package ua.edu.ucu.tempseries;

import  java.util.InputMismatchException;

public class TemperatureSeries {
    private double[] temperatures = {};
    private int minTemp;
    private int buffer = 0;
    private int size = 0;

    public TemperatureSeries(int minimal) {
        minTemp = minimal;
    }

    public TemperatureSeries(double[] temperatureSeries, int minimal) {
        minTemp = minimal;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < minTemp) {
                throw new InputMismatchException(
                        "Temperature cannot be less then -273.");
            }
        }
        size = temperatureSeries.length;
        temperatures = temperatureSeries;
        buffer = size;
    }

    public boolean empty() {
        return buffer == 0;
    }

    public void add(double x) {
        if (x < minTemp) {
            throw new InputMismatchException(
                    "Temperature cannot be less then -273.");
        }
        if (empty()) {
            buffer = 1;
            temperatures = new double[1];
        } else {
            if (buffer == size) {
                buffer = 2 * buffer;
                double[] temps = temperatures;
                temperatures = new double[buffer];
                for (int i = 0; i < size; i++) {
                    temperatures[i] = temps[i];
                }
            }
        }
        temperatures[size] = x;
        size++;
    }

    public int getSize() {
        return size;
    }

    public double getTemperature(int index) {
        return temperatures[index];
    }

    public double[] getTemperatures() {
        return temperatures;
    }
}
