package head_first_design_pattern.chapter_02_observer_pattern;

import head_first_design_pattern.chapter_02_observer_pattern.observer.CurrentConditionsDisplay;
import head_first_design_pattern.chapter_02_observer_pattern.subject.WeatherData;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

    }

}
