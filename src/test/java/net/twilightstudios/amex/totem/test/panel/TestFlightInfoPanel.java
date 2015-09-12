package net.twilightstudios.amex.totem.test.panel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.twilightstudios.amex.common.flight.entity.FlightDate;
import net.twilightstudios.amex.common.flight.entity.FlightStatus;
import net.twilightstudios.amex.common.flight.entity.Status;
import net.twilightstudios.amex.common.weather.entity.Forecast;
import net.twilightstudios.amex.common.weather.entity.Precipitation;
import net.twilightstudios.amex.common.weather.entity.Summary;
import net.twilightstudios.amex.common.weather.entity.Temperature;
import net.twilightstudios.amex.common.weather.entity.Wind;
import net.twilightstudios.amex.totem.view.component.panel.FlightInfoPanel;

public class TestFlightInfoPanel {
	
	private static BeanFactory factory;

	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
		FlightStatus flightStatus = getFlightStatusMock();
		Forecast forecast = getForecastMock();
		List<Forecast> predictions = new ArrayList<Forecast>();
		predictions.add(getForecastMock());
		predictions.add(getForecastMock());
		predictions.add(getForecastMock());
		
		factory = new ClassPathXmlApplicationContext("testAppContext.xml");
		JFrame f = (JFrame) factory.getBean("frame");
		f.setLayout(new BorderLayout());
		FlightInfoPanel panel = factory.getBean(FlightInfoPanel.class);
		panel.setFlightStatus(flightStatus);
		panel.setForecast(forecast);
		panel.setPredictions(predictions);
		panel.initPanel();
		f.add(panel, BorderLayout.CENTER);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
    }

	private static Forecast getForecastMock() {
		Forecast forecast = new Forecast();
		forecast.setCity("Roma");
		forecast.setCloudiness(0);
		forecast.setHumidity(0);
		Precipitation precipitation = new Precipitation();
		precipitation.setRain(0);
		precipitation.setSnow(0);
		forecast.setPrecipitation(precipitation);
		forecast.setPressure(0);
		Summary summary = new Summary();
		summary.setDescription("Despejado");
		summary.setIcon("http://cdn.flaticon.com/png/256/53565.png");
		forecast.setSummary(summary);
		Temperature temperature = new Temperature();
		temperature.setActual(32);
		temperature.setMax(41);
		temperature.setMin(-12);
		forecast.setTemperature(temperature);
		forecast.setTimestamp(new Date());
		Wind wind = new Wind();
		wind.setHeading(2.1);
		wind.setSpeed(12.2);
		forecast.setWind(wind);
		return forecast;
	}

	private static FlightStatus getFlightStatusMock() {
		FlightStatus flightStatus = new FlightStatus();
		flightStatus.setBoardingGate("A32");
		flightStatus.setCheckInCounter("322");
		flightStatus.setDestiny("Roma");
		flightStatus.setDestinyTerminal("Terminal 1");
		FlightDate estimated = new FlightDate();
		estimated.setArrival(new Date());
		estimated.setDeparture(new Date());
		flightStatus.setEstimated(estimated);
		flightStatus.setFlightNumber("IBE2457");
		flightStatus.setOrigin("Madrid");
		flightStatus.setOriginTerminal("Terminal 4");
		FlightDate scheduled = new FlightDate();
		scheduled.setArrival(new Date());
		scheduled.setDeparture(new Date());
		flightStatus.setScheduled(scheduled);
		flightStatus.setStatus(Status.SCHEDULED);
		return flightStatus;
	}

}
