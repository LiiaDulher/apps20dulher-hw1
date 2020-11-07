package ua.edu.ucu.tempseries;

public final class TempSummaryStatistics {
    public final double avgTemp;
    public final double devTemp;
    public final double minTemp;
    public final double maxTemp;

    TempSummaryStatistics(TemperatureSeriesAnalysis analysis){
        avgTemp = analysis.average();
        devTemp = analysis.deviation();
        minTemp = analysis.min();
        maxTemp = analysis.max();
    }
}
