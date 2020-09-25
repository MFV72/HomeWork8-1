package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {

    // maxTemperature, minTemperature, CurrentTemperature, Expected
    @ParameterizedTest
    @CsvSource(
            value = {"'25','10','24','25'",
                     "'25','10','25','25'",
            }, delimiter = ','
    )
    void shouldIncreaseCurrentTemperature(int maxTemperature, int minTemperature, int currentTemperature, int expected) {
        Conditioner conditioner = new Conditioner();
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.increaseCurrentTemperature();
        int actual = conditioner.getCurrentTemperature();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {   "'25','10','15','14'",
                        "'25','10','10','10'",
            }, delimiter = ','
    )
    void shouldDecreaseCurrentTemperature(int maxTemperature, int minTemperature, int currentTemperature, int expected) {

        Conditioner conditioner = new Conditioner();
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.decreaseCurrentTemperature();
        int actual = conditioner.getCurrentTemperature();
        assertEquals(expected, actual);
    }
}