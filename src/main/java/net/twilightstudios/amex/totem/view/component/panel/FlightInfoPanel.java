package net.twilightstudios.amex.totem.view.component.panel;

import java.awt.Component;
import java.util.List;

import javax.swing.Box;

import net.twilightstudios.amex.flight.entity.FlightStatus;
import net.twilightstudios.amex.totem.view.component.panel.utils.FlightInfoPanelUtils;
import net.twilightstudios.amex.weather.entity.Forecast;

@SuppressWarnings("serial")
public class FlightInfoPanel extends SectionPanel {

	private Box main;
	
	private FlightStatus flightStatus;
	private Forecast forecast;
	private List<Forecast> predictions;
	
	private FlightInfoPanelUtils flightInfoPanelUtils;
	
	public FlightInfoPanel(Component parent) {
		super(parent);
	}
	
	/**
	 * Inicia el panel de información de vuelo
	 */
	@Override
	public void initPanel() {
		main = Box.createVerticalBox();
		Box boardingInfo = flightInfoPanelUtils.createBoardingInformation(flightStatus.getFlight().getFlightNumber(), flightStatus.getBoardingGate());
		main.add(boardingInfo);
		
		main.add(Box.createVerticalStrut(5));
		
		Box destinationInfo = flightInfoPanelUtils.createFlightDestinationInfo(flightStatus, forecast, predictions);
		main.add(destinationInfo);
		
		this.add(main);
	}
	
	public FlightStatus getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	public List<Forecast> getPredictions() {
		return predictions;
	}

	public void setPredictions(List<Forecast> predictions) {
		this.predictions = predictions;
	}

	public FlightInfoPanelUtils getFlightInfoPanelUtils() {
		return flightInfoPanelUtils;
	}

	public void setFlightInfoPanelUtils(FlightInfoPanelUtils flightInfoPanelUtils) {
		this.flightInfoPanelUtils = flightInfoPanelUtils;
	}
}
