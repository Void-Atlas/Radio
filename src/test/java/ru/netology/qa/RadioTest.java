package ru.netology.qa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    // Конструкторы
    @Test
    void shouldCreateDefaultRadioWith10Stations() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationsCount());
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldCreateRadioWithCustomStations() {
        Radio radio = new Radio(20);
        assertEquals(20, radio.getStationsCount());
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotAllowZeroOrNegativeStations() {
        Radio radio = new Radio(0);
        assertEquals(10, radio.getStationsCount());

        radio = new Radio(-5);
        assertEquals(10, radio.getStationsCount());
    }

    // Станции
    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(14);
        assertEquals(14, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationBelowZero() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveMax() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());

        radio.setCurrentStation(10);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveCustomMax() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(4);
        assertEquals(4, radio.getCurrentStation());

        radio.setCurrentStation(5);
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldGoNext() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldWrapToZeroOnNextFromMax() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldWrapToZeroOnNextFromCustomMax() {
        Radio radio = new Radio(7);
        radio.setCurrentStation(6);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoPrev() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(3);
        radio.prev();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void shouldWrapToMaxOnPrevFromZero() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldWrapToCustomMaxOnPrevFromZero() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    // Громкость
    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseAbove100() {
        Radio radio = new Radio();
        for (int i = 0; i < 150; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseBelow0() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseBelow0AfterManyClicks() {
        Radio radio = new Radio();
        for (int i = 0; i < 10; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
    }
}