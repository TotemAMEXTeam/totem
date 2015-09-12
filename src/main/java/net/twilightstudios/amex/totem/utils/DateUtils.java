package net.twilightstudios.amex.totem.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que contiene metodos para conversión de fechas
 * @author Nelly
 *
 */
public class DateUtils {

	private static DateFormat ddMMMM_df = new SimpleDateFormat("dd MMMM");
	
	private static DateFormat HHmm_df = new SimpleDateFormat("HH:mm");
	
	private static DateFormat weekday_df = new SimpleDateFormat("EEE");
	
	/**
	 * Convierte un objeto de tipo Date a String en formato día y mes (ej.: "12 Julio")
	 * @param date
	 * @return
	 */
	public String dateToddMMMM(Date date) {
		return ddMMMM_df.format(date);
	}
	
	/**
	 * Convierte un objeto de tipo Date a String en formato hora y minutos (ej.: "19:35")
	 * @param date
	 * @return
	 */
	public String dateToHHmm(Date date) {
		return HHmm_df.format(date);
	}

	/**
	 * Recupera el día de la semana a partir de un objeto Date. Sólo devuelve el primer caracter
	 * @param date
	 * @return
	 */
	public String dateToOneLetterWeekday(Date date) {
		
		String weekday = weekday_df.format(date);
		if ("mié".equals(weekday)) {
			return "X";
		}
		return weekday.toUpperCase().substring(0, 1);
	}

}
