package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

class TemperatureSeriesAnalysis {
    private double[] first;
    private int ind;


    public TemperatureSeriesAnalysis() {

    }

    TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.first = temperatureSeries;
        ind = this.first.length;
        for (double i: this.first) {
            if (i<-273) {
                throw new InputMismatchException();
            }
        }

    }

    double average() {
        if (this.first.length == 0) {
            throw new IllegalArgumentException("Input is none!");
        }
        double sum = 0;
        for (int i = 0; i < this.first.length; i++) {
            sum += this.first[i];
        }
        return sum / this.first.length;
    }

    double deviation() {
        if (this.first.length == 0) {
            throw new IllegalArgumentException("Input is none!");
        }
        int devitationSum = 0;
        double mid = this.average();
        for (double i : this.first) {
            devitationSum += Math.pow((i - mid), 2);
        }
        devitationSum /= 5;
        return round(Math.pow(devitationSum, 0.5),2);
    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    double min() {
        if (this.first.length == 0) {
            throw new IllegalArgumentException();
        }
        double minEl = this.first[0];
        for (double i : this.first) {
            if (minEl > i) {
                minEl = i;
            }
        }
        return minEl;
    }

    double max() {
        if (this.first.length == 0) {
            throw new IllegalArgumentException("Input is none!");
        }
        double maxEl = this.first[0];
        for (double i : this.first) {
            if (maxEl < i) {
                maxEl = i;
            }
        }
        return maxEl;
    }

    double findTempClosestToZero() {
        if (this.first.length == 0) {
            throw new IllegalArgumentException("Input is none!");
        }
        double min = this.first[0];
        for (double i : this.first) {
            if (Math.abs(i) < Math.abs(min)) {
                min = i;
            }
        }

        return min;
    }

    double findTempClosestToValue(double tempValue) {
        if (this.first.length == 0) {
            throw new IllegalArgumentException("Input is none!");
        }
        double temp = this.first[0];
        double min = Math.abs(tempValue - temp);
        for (double i : this.first) {
            if (Math.abs(tempValue - i) < min) {
                min = tempValue - i;
                temp = i;
            }
        }
        return temp;
    }


    double[] findTempsLessThen(double tempValue) {
        if (this.first.length == 0) {
            throw new IllegalArgumentException("Input is none!");
        }
        double[] newArray = new double[this.first.length];
        int i = 0;
        for (double number : this.first) {
            if (number < tempValue) {
                newArray[i] = number;
                i++;
            }
        }
        if (i != newArray.length) {
            double[] finalArray = new double[i];
            for (int k = 0; k< i; k++) {
                finalArray[k] = newArray[k];
            }
            return finalArray;

        }
        return newArray;
    }

    double[] findTempsGreaterThen(double tempValue) {
        if (this.first.length == 0) {
            throw new IllegalArgumentException ("Input is none!");
        }
        double[] newArray = new double[this.first.length];
        int p = 0;
        for (double number : this.first) {
            if (number >= tempValue) {
                newArray[p] = number;
                p++;
            }
        }
        if (p != newArray.length) {
            double[] finalArray = new double[p];
            for (int index = 0; index< p; index++) {
                finalArray[index] = newArray[index];
            }
            return finalArray;

        }
        return newArray;
    }

    TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics (average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        int p = 0;
        if (first.length - ind<temps.length){
            double[] newArray = new double[first.length + temps.length- Math.abs(ind-first.length)];
            for (int i = 0; i< ind; i++){
                newArray[i] = first[i];
            }
            for (int i =ind; i<ind+temps.length; i++){
                newArray[i] = temps[p];
                p++;
            }
            this.first = newArray;
            ind = this.first.length;
        }
        return this.first.length;
    }
}

