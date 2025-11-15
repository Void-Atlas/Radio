package ru.netology.qa;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int stationsCount;  // количество станций, задаётся при создании

    public Radio() {
        this.stationsCount = 10; // 10 станций
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public Radio(int stationsCount) { // кол-во станций
        if (stationsCount < 1) {
            this.stationsCount = 10;
        } else {
            this.stationsCount = stationsCount;
        }
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getStationsCount() {
        return stationsCount;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationsCount) {
            this.currentStation = station;
        }
    }

    public void next() { // Следующая станция
        if (currentStation == stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() { // Предыдущая станция
        if (currentStation == 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() { // Громкость +
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() { // Громкость -
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}