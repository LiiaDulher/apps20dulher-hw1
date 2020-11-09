package ua.edu.ucu.tempseries;

public final class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    TempSummaryStatistics(TemperatureSeriesAnalysis analysis){
        avgTemp = analysis.average();
        devTemp = analysis.deviation();
        minTemp = analysis.min();
        maxTemp = analysis.max();
    }

    public final double getAvgTemp() {
        return avgTemp;
    }

    public final double getDevTemp() {
        return devTemp;
    }

    public final double getMaxTemp() {
        return maxTemp;
    }

    public final double getMinTemp() {
        return minTemp;
    }
}
