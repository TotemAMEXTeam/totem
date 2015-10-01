package net.twilightstudios.amex.totem.view.component.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;












import net.twilightstudios.amex.flight.entity.Flight;
import net.twilightstudios.amex.flight.entity.FlightStatus;
import net.twilightstudios.amex.flight.entity.Status;
import net.twilightstudios.amex.totem.view.component.panel.impl.FlightInfoPanel;
import net.twilightstudios.amex.totem.view.component.panel.impl.MainPanel;
import net.twilightstudios.amex.weather.entity.Forecast;
import net.twilightstudios.amex.weather.entity.Precipitation;
import net.twilightstudios.amex.weather.entity.Summary;
import net.twilightstudios.amex.weather.entity.Temperature;
import net.twilightstudios.amex.weather.entity.Wind;

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
		
		Image bgImage;
		Image scaledImage = null;
		try {
			bgImage = ImageIO.read(new URL("http://www.psdgraphics.com/file/fresh-green-background.jpg"));
			scaledImage = bgImage.getScaledInstance(1920, 1080, Image.SCALE_FAST);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainPanel p = new MainPanel(scaledImage);
		
		FlightInfoPanel fInfo = factory.getBean(FlightInfoPanel.class);
		fInfo.setFlightStatus(flightStatus);
		fInfo.setForecast(forecast);
		fInfo.setPredictions(predictions);
		fInfo.initPanel();
		
		p.add(fInfo);
		//p.add(fInfo, BorderLayout.NORTH);
		
		f.add(p, BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
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
		Flight flight = new Flight();
		flightStatus.setFlight(flight);
		flightStatus.getFlight().setDestiny("Roma");
		flightStatus.setDestinyTerminal("Terminal 1");
		flightStatus.setEstimatedDeparture(new Date());
		flightStatus.setEstimatedArrival(new Date());
		flightStatus.getFlight().setFlightNumber("IBE2457");
		flightStatus.getFlight().setOrigin("Madrid");
		flightStatus.setOriginTerminal("Terminal 4");
		flightStatus.getFlight().setScheduledDeparture(new Date());
		flightStatus.setScheduledArrival(new Date());
		flightStatus.setStatus(Status.SCHEDULED);
		return flightStatus;
	}

}
