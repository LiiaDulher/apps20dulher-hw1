package ua.edu.ucu.tempseries;

import java.lang.IllegalArgumentException;

import static java.lang.Math.*;

public class TemperatureSeriesAnalysis {

    private TemperatureSeries temperatures;

    public TemperatureSeriesAnalysis() {
        temperatures = new TemperatureSeries(-273);
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        temperatures = new TemperatureSeries(temperatureSeries, -273);
    }

    public double average() {
        if (temperatures.empty()){
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double averageTemp = 0;
        for (int i=1; i < temperatures.getSize(); i++){
            averageTemp += temperatures.getTemperature(i);
        }
        return averageTemp/temperatures.getSize();
    }

    public double deviation() {
        double averageTemp = average();
        double tempDeviation = 0;
        for (int i=1; i < temperatures.getSize(); i++){
            tempDeviation += pow(temperatures.getTemperature(i)-averageTemp, 2);
        }
        return sqrt(tempDeviation/temperatures.getSize());
    }

    private double expected(int expected){
        if (temperatures.empty()){
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double temperature = temperatures.getTemperature(0);
        for (int i=1; i < temperatures.getSize(); i++){
            if (compare(temperatures.getTemperature(i), temperature) == expected){
                temperature = temperatures.getTemperature(i);
            }
        }
        return temperature;
    }

    private int compare(double x, double y){
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
        for(int i=1; i<temperatures.getSize(); i++){
            double curDifference = abs(currentTemp-tempValue);
            double newDifference = abs(temperatures.getTemperature(i)-tempValue);
            if (abs(curDifference - newDifference) < 0.00001){
                currentTemp = Math.max(temperatures.getTemperature(i), tempValue);
            }else if (curDifference > newDifference){
                currentTemp = temperatures.getTemperature(i);
            }
        }
        return currentTemp;
    }

    private double[] sortTempsByValue(double tempValue, int result){
        if (temperatures.empty()){
            throw new IllegalArgumentException("Temperature series is empty");
        }
        TemperatureSeries lessTemps = new TemperatureSeries(-273);
        TemperatureSeries greaterTemps = new TemperatureSeries(-273);
        for (int i=0; i<temperatures.getSize(); i++){
            if (temperatures.getTemperature(i) < tempValue){
                lessTemps.add(temperatures.getTemperature(i));
            }else{
                greaterTemps.add(temperatures.getTemperature(i));
            }
        }
        if (result > 0){
            return lessTemps.getTemperatures();
        }else{
            return greaterTemps.getTemperatures();
        }
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

    // TODO: check
    public int addTemps(double... temps) {
        for (int i=0; i<temps.length; i++){
            temperatures.add(temps[i]);
        }
        return temperatures.getSize();
    }
}
