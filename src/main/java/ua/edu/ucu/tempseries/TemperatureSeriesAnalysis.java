package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private static final int MIN_TEMPERATURE = -273;
    private static final double DELTA = 0.00001;
    private TemperatureSeries temperatures;

    public TemperatureSeriesAnalysis() {
        temperatures = new TemperatureSeries(MIN_TEMPERATURE);
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        temperatures = new TemperatureSeries(temperatureSeries,
                MIN_TEMPERATURE);
    }

    public double average() {
        if (temperatures.empty()) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double averageTemp = 0;
        for (int i = 0; i < temperatures.getSize(); i++) {
            averageTemp += temperatures.getTemperature(i);
        }
        return averageTemp/temperatures.getSize();
    }

    public double deviation() {
        double averageTemp = average();
        double tempDeviation = 0;
        for (int i = 0; i < temperatures.getSize(); i++) {
            double curTempDiff = temperatures.getTemperature(i) - averageTemp;
            tempDeviation += curTempDiff * curTempDiff;
        }
        return Math.sqrt(tempDeviation/temperatures.getSize());
    }

    private double expected(int expected) {
        if (temperatures.empty()) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double temperature = temperatures.getTemperature(0);
        for (int i = 1; i < temperatures.getSize(); i++) {
            if (compare(temperatures.getTemperature(i), temperature)
                    == expected) {
                temperature = temperatures.getTemperature(i);
            }
        }
        return temperature;
    }

    private int compare(double x, double y) {
        if (x < y) {
            return 1;
        } else if (x > y) {
            return -1;
        } else {
            return 0;
        }
    }

    public double min() {
        return expected(1);
    }

    public double max() {
        return expected(-1);
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatures.empty()) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double currTemp = temperatures.getTemperature(0);
        for (int i = 1; i < temperatures.getSize(); i++) {
            double curDiff = Math.abs(currTemp - tempValue);
            double newDiff = Math.abs(temperatures.getTemperature(i)
                    - tempValue);
            if (Math.abs(curDiff - newDiff) < DELTA) {
                currTemp = Math.max(temperatures.getTemperature(i), currTemp);
            } else if (curDiff > newDiff) {
                currTemp = temperatures.getTemperature(i);
            }
        }
        return currTemp;
    }

    private double[] sortTempsByValue(double tempValue, int expected) {
        if (temperatures.empty()) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        TemperatureSeries valueTemps = new TemperatureSeries(MIN_TEMPERATURE);
        for (int i = 0; i < temperatures.getSize(); i++) {
            if (Math.abs(temperatures.getTemperature(i)-tempValue) < DELTA
                    && expected == -1) {
                valueTemps.add(temperatures.getTemperature(i));
            } else if (compare(temperatures.getTemperature(i), tempValue)
                    == expected) {
                valueTemps.add(temperatures.getTemperature(i));
            }
        }
        return valueTemps.getTemperatures();
    }

    public double[] findTempsLessThen(double tempValue) {
        return sortTempsByValue(tempValue, 1);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return sortTempsByValue(tempValue, -1);
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatures.empty()) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        for (int i = 0; i < temps.length; i++) {
            try {
                temperatures.add(temps[i]);
            } catch (InputMismatchException ignored) { }
        }
        return temperatures.getSize();
    }
}
