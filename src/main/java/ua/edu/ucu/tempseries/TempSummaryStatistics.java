package ua.edu.ucu.tempseries;

class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    TempSummaryStatistics(double avgTemp, double devTemp, double minTemp, double maxTemp){
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

}
