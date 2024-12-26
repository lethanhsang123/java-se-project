package chapter_02_observer_pattern;

import chapter_02_observer_pattern.observer.CurrentConditionsDisplay;
import chapter_02_observer_pattern.subject.WeatherData;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

    }

}
