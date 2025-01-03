package head_first_design_pattern.chapter_02_observer_pattern.observer;

import head_first_design_pattern.chapter_02_observer_pattern.DisplayElement;
import head_first_design_pattern.chapter_02_observer_pattern.subject.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + this.temperature
                + "F degrees and " + this.humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.display();
    }
}
