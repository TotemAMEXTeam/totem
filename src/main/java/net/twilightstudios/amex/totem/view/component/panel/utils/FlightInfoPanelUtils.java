package net.twilightstudios.amex.totem.view.component.panel.utils;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import net.twilightstudios.amex.common.flight.entity.FlightStatus;
import net.twilightstudios.amex.common.weather.entity.Forecast;
import net.twilightstudios.amex.totem.utils.DateUtils;
import net.twilightstudios.amex.totem.view.constants.GenericConstants;
import net.twilightstudios.amex.totem.view.constants.styles.FlightInfoPanelStyles;

public class FlightInfoPanelUtils {

	private static final int MAX_NUM_PREDICTIONS = 3;

	private DateUtils dateUtils;
	
	/**
	 * Método que crea una caja con la información relativa al destino del vuelo, información meteorológia y predicción
	 * @param flightStatus
	 * @param forecast
	 * @param predictions
	 * @return
	 */
	public Box createFlightDestinationInfo(FlightStatus flightStatus, Forecast forecast, List<Forecast> predictions) {
		Box destinationInfo = Box.createHorizontalBox();
		
		String destiny = flightStatus.getDestiny();
		Date departure = flightStatus.getScheduled().getDeparture();
		Date arrival = flightStatus.getScheduled().getArrival();
		String departureDate = dateUtils.dateToddMMMM(departure);
		Box destinationBox = createDestinationInfoBox(destiny, departureDate);
		
		destinationInfo.add(destinationBox);
		destinationInfo.add(Box.createHorizontalStrut(5));
		destinationInfo.add(new JSeparator(SwingConstants.VERTICAL));
		destinationInfo.add(Box.createHorizontalStrut(5));
		
		String departureTime = dateUtils.dateToHHmm(departure);
		String arrivalTime = dateUtils.dateToHHmm(arrival);
		Box scheduleBox = createFlightScheduleBox(departureTime, arrivalTime);
		
		destinationInfo.add(scheduleBox);
		destinationInfo.add(Box.createHorizontalStrut(5));
		destinationInfo.add(new JSeparator(SwingConstants.VERTICAL));
		destinationInfo.add(Box.createHorizontalStrut(5));
		
		String tempreatureValue = String.valueOf(forecast.getTemperature().getActual());
		String status = forecast.getSummary().getDescription();
		Box weatherBox = createDestinationWeatherBox(predictions, tempreatureValue, status);
		
		destinationInfo.add(weatherBox);
		
		return destinationInfo;
	}
	
	/**
	 * Método que crea una caja indicando el número de vuelo y la puerta de embarque
	 * @param fligthNumber
	 * @param boardingGate
	 * @return
	 */
	public Box createBoardingInformation(String fligthNumber, String boardingGate) {
		Box boardingInfo = Box.createHorizontalBox();
		boardingInfo.add(Box.createHorizontalGlue());
		JLabel flightLabel = new JLabel(GenericConstants.FLIGHT_LABEL.toUpperCase());
		flightLabel.setFont(FlightInfoPanelStyles.BOARDING_INFO_LABEL_FONT);
		JLabel flightNumberLabel = new JLabel(fligthNumber);
		flightNumberLabel.setFont(FlightInfoPanelStyles.BOARDING_INFO_FONT);
		
		boardingInfo.add(flightLabel);
		boardingInfo.add(Box.createHorizontalStrut(5));
		boardingInfo.add(flightNumberLabel);
		
		boardingInfo.add(Box.createHorizontalStrut(5));
		boardingInfo.add(new JSeparator(SwingConstants.VERTICAL));
		boardingInfo.add(Box.createHorizontalStrut(5));
		
		JLabel boardingLabel = new JLabel(GenericConstants.BOARDING_LABEL.toUpperCase());
		boardingLabel.setFont(FlightInfoPanelStyles.BOARDING_INFO_LABEL_FONT);
		JLabel boardingGateNumberLabel = new JLabel(boardingGate);
		boardingGateNumberLabel.setFont(FlightInfoPanelStyles.BOARDING_INFO_FONT);
		
		boardingInfo.add(boardingLabel);
		boardingInfo.add(Box.createHorizontalStrut(5));
		boardingInfo.add(boardingGateNumberLabel);
		boardingInfo.add(Box.createHorizontalGlue());
		return boardingInfo;
	}
	
	/**
	 * Método privado que crea una caja con la información de la ciudad de destino y fecha del
	 * vuelo
	 * @param destinyName
	 * @param departureDate
	 * @return
	 */
	private Box createDestinationInfoBox(String destinyName, String departureDate) {
		Box destinationBox = Box.createVerticalBox();
		
		JLabel destinationLabel = new JLabel(GenericConstants.DESTINATION_LABEL);
		destinationLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_LABEL_FONT);
		JLabel destinyNameLabel = new JLabel(destinyName);
		destinyNameLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_FONT);
		JLabel departureDateLabel = new JLabel(departureDate);
		departureDateLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_DATE_FONT);
		
		destinationBox.add(destinationLabel);
		destinationBox.add(destinyNameLabel);
		destinationBox.add(departureDateLabel);
		return destinationBox;
	}
	
	/**
	 * Método privado que crea una caja con las horas previstas de salida y llegada
	 * @param departureTime
	 * @param arrivalTime
	 * @return
	 */
	private Box createFlightScheduleBox(String departureTime, String arrivalTime) {
		Box scheduleBox = Box.createVerticalBox();
		
		JLabel departureLabel = new JLabel(GenericConstants.DEPARTURE_LABEL);
		departureLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_LABEL_FONT);
		JLabel departureTimeLabel = new JLabel(departureTime);
		departureTimeLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_FONT);
		JLabel arrivalLabel = new JLabel(GenericConstants.ARRIVAL_LABEL);
		arrivalLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_LABEL_FONT);
		JLabel arrivalTimeLabel = new JLabel(arrivalTime);
		arrivalTimeLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_FONT);
		
		scheduleBox.add(departureLabel);
		scheduleBox.add(departureTimeLabel);
		scheduleBox.add(arrivalLabel);
		scheduleBox.add(arrivalTimeLabel);
		
		return scheduleBox;
	}
	
	/**
	 * Método que crea una caja con la información el estado meteorológico actual y las predicciones a MAX_NUM_PREDICTIONS días a lo sumo
	 * @param predictions
	 * @param temperatureValue
	 * @param status
	 * @return
	 */
	private Box createDestinationWeatherBox(List<Forecast> predictions, String temperatureValue, String status) {
		
		Box weatherBox = Box.createHorizontalBox();
		
		Box destinationWeatherBox = Box.createVerticalBox();
		
		JLabel weatherLabel = new JLabel(GenericConstants.WEATHER_LABEL);
		weatherLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_LABEL_FONT);
		JLabel temperatureValueLabel = new JLabel(temperatureValue+ "º C");
		temperatureValueLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_TEMPERATURE_FONT);
		JLabel statusLabel = new JLabel(status);
		statusLabel.setFont(FlightInfoPanelStyles.DESTINATION_INFO_LABEL_FONT);
		
		destinationWeatherBox.add(weatherLabel);
		destinationWeatherBox.add(temperatureValueLabel);
		destinationWeatherBox.add(statusLabel);
		
		weatherBox.add(destinationWeatherBox);
		
		Box weatherPredictionBox = Box.createVerticalBox();
		
		for (int i = 0; i < MAX_NUM_PREDICTIONS; i++) {
			Forecast forecast = predictions.get(i);
			if (forecast != null) {
				Box prediction = createPredictionBox(forecast);
				weatherPredictionBox.add(prediction);
			}
		}
		
		weatherBox.add(weatherPredictionBox);
		
		return weatherBox;
		
	}

	/**
	 * Método privado que devuelve una caja con el día de la semana y un icono que representa la
	 * predicción para ese día
	 * @param forecast
	 * @return
	 */
	private Box createPredictionBox(Forecast forecast) {
		Box prediction = Box.createHorizontalBox();
		
		if (forecast.getSummary() != null && forecast.getSummary().getIcon() != null) {
			Image image = null;
			Image scaledImage = null;
			try {
				URL url = new URL(forecast.getSummary().getIcon());
				image = ImageIO.read(url);
				scaledImage = image.getScaledInstance(25, 25, Image.SCALE_FAST);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			JLabel label = new JLabel(dateUtils.dateToOneLetterWeekday(forecast.getTimestamp()));
			JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
			
			prediction.add(label);
			prediction.add(iconLabel);
		}
		return prediction;
	}

	public DateUtils getDateUtils() {
		return dateUtils;
	}

	public void setDateUtils(DateUtils dateUtils) {
		this.dateUtils = dateUtils;
	}

	
}
