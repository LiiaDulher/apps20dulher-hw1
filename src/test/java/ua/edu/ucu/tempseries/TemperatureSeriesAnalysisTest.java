package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.testng.annotations.Test;
import org.junit.Ignore;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    // testing constructors

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testBasicConstructor() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.average();
    }

    @Test(expectedExceptions = InputMismatchException.class)
    public void testParametrisedConstructor() {
        double[] temperatureSeries = {1, -2, -283.0, 4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    // testing average

    @Test
    public void testAverageWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testAverageWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.average();


        assertEquals(expResult, actualResult, 0.00001);
    }

    // Testing deviation()

    @Test
    public void testDeviationWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 3.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 4.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);

    }

    // testing min()

    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);

    }

    // testing max()

    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);

    }

    // testing findTempClosestToZero()

    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test
    public void testFindTempClosestToZeroWithSameDif() {
        double[] temperatureSeries = {3.0, -1.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    // testing findTempClosestToValue()

    @Test
    public void testFindTempClosestToValueWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(10.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempClosestToValue(10.0);
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(-1.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(4.0);

        assertEquals(expResult, actualResult, 0.00001);

    }

    // testing findTempsLessThen()

    @Test
    public void testFindTempsLessThenWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempsLessThen(2.0);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5.0, 1.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        double[] actualResult = seriesAnalysis.findTempsLessThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);

    }

    // testing findTempsGreaterThen()

    @Test
    public void testFindTempsGreaterThenWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempsGreaterThen(2.0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, 5.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, 3.0, 3.0, 3.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);

    }

    // testing summaryStatistics()

    @Test
    public void testSummaryStatisticsWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expAvgTemp = -1.0;
        double expDevTemp = 0.0;
        double expMinTemp = -1.0;
        double expMaxTemp = -1.0;

        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        assertEquals(expAvgTemp, actualResult.getAvgTemp(), 0.00001);
        assertEquals(expDevTemp, actualResult.getDevTemp(), 0.00001);
        assertEquals(expMinTemp, actualResult.getMinTemp(), 0.00001);
        assertEquals(expMaxTemp, actualResult.getMaxTemp(), 0.00001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 3.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expAvgTemp = 1.0;
        double expDevTemp = 4.0;
        double expMinTemp = -5.0;
        double expMaxTemp = 3.0;

        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        assertEquals(expAvgTemp, actualResult.getAvgTemp(), 0.00001);
        assertEquals(expDevTemp, actualResult.getDevTemp(), 0.00001);
        assertEquals(expMinTemp, actualResult.getMinTemp(), 0.00001);
        assertEquals(expMaxTemp, actualResult.getMaxTemp(), 0.00001);
    }

    @Test
    public void testSummaryStatisticsWithSameTemp() {
        double[] temperatureSeries = {3.0, 3.0, 3.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expAvgTemp = 3.0;
        double expDevTemp = 0.0;
        double expMinTemp = 3.0;
        double expMaxTemp = 3.0;

        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();


        assertEquals(expAvgTemp, actualResult.getAvgTemp(), 0.00001);
        assertEquals(expDevTemp, actualResult.getDevTemp(), 0.00001);
        assertEquals(expMinTemp, actualResult.getMinTemp(), 0.00001);
        assertEquals(expMaxTemp, actualResult.getMaxTemp(), 0.00001);
    }

    // testing addTemps()

    @Test
    public void testAddTempsToEmptySeries() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        double[] temperatureSeries = {-1.0, 2.0, 5.7};
        int expResult = 3;

        int actualResult = seriesAnalysis.addTemps(temperatureSeries);

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddTempsToSeries() {
        double[] temperatureSeries = {3.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 5;
        double[] newTemperatures = {2.3, 0.0, 3.4};

        int actualResult = seriesAnalysis.addTemps(newTemperatures);

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddTempsWithWrongValue() {
        double[] temperatureSeries = {3.0, -5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 5;
        double[] newTemperatures = {2.3, 0.0, -276, 3.4};

        int actualResult = seriesAnalysis.addTemps(newTemperatures);

        assertEquals(expResult, actualResult);
    }
}
