package ua.edu.ucu.tempseries;

import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;

import static java.lang.Math.*;

public class TemperatureSeriesAnalysis {

    private TemperatureSeries temperatures;
    private final int minTemperature=-273;

    public TemperatureSeriesAnalysis() {
        temperatures = new TemperatureSeries(minTemperature);
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        temperatures = new TemperatureSeries(temperatureSeries, minTemperature);
    }

    public double average() {
        if (temperatures.empty()){
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double averageTemp = 0;
        for (int i=0; i < temperatures.getSize(); i++) {
            averageTemp += temperatures.getTemperature(i);
        }
        return averageTemp/temperatures.getSize();
    }

    public double deviation() {
        double averageTemp = average();
        double tempDeviation = 0;
        for (int i=0; i < temperatures.getSize(); i++){
            tempDeviation += pow(temperatures.getTemperature(i)-averageTemp, 2);
        }
        return sqrt(tempDeviation/temperatures.getSize());
    }

    private double expected(int expected) {
        if (temperatures.empty()){
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double temperature = temperatures.getTemperature(0);
        for (int i=1; i < temperatures.getSize(); i++) {
            if (compare(temperatures.getTemperature(i), temperature) == expected){
                temperature = temperatures.getTemperature(i);
            }
        }
        return temperature;
    }

    private int compare(double x, double y) {
        if (x < y){
            return 1;
        }else if (x >y){
            return -1;
        }else{
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
        if (temperatures.empty()){
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double currentTemp = temperatures.getTemperature(0);
        for(int i=1; i<temperatures.getSize(); i++) {
            double curDifference = abs(currentTemp-tempValue);
            double newDifference = abs(temperatures.getTemperature(i)-tempValue);
            if (abs(curDifference - newDifference) < 0.00001){
                currentTemp = Math.max(temperatures.getTemperature(i), currentTemp);
            }else if (curDifference > newDifference){
                currentTemp = temperatures.getTemperature(i);
            }
        }
        return currentTemp;
    }

    private double[] sortTempsByValue(double tempValue, int expected) {
        if (temperatures.empty()){
            throw new IllegalArgumentException("Temperature series is empty");
        }
        TemperatureSeries valueTemps = new TemperatureSeries(-273);
        for (int i=0; i<temperatures.getSize(); i++) {
            if (abs(temperatures.getTemperature(i)-tempValue) < 0.00001 && expected==-1){
                valueTemps.add(temperatures.getTemperature(i));
            }else if (compare(temperatures.getTemperature(i), tempValue) == expected){
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
        if (temperatures.empty()){
            throw new IllegalArgumentException("Temperature series is empty");
        }
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        for (int i=0; i<temps.length; i++) {
            try{
                temperatures.add(temps[i]);
            }catch(InputMismatchException ignored) {}
        }
        return temperatures.getSize();
    }
}
