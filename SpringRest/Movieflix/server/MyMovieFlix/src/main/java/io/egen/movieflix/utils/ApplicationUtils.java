package io.egen.movieflix.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class ApplicationUtils {

	public Date convertStringToDate(String dateString) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = format.parse(dateString);
		return date;
	}

	public String convertDateToString(Date date) throws ParseException {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(date);
		return s;
	}

	public Date convertStringToDate(String dateString, String format) throws ParseException {
		DateFormat f = new SimpleDateFormat(format, Locale.ENGLISH);
		Date date = f.parse(dateString);
		return date;
	}

}
