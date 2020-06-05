package exemplo_composite;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

abstract class Place {
	protected String cityName;
	private String locationKey;

	public abstract void getWeather() throws IOException, ParseException;
	
	public abstract void getTemperature() throws IOException, ParseException;
	
	public abstract void getPrecipitationSummary() throws IOException, ParseException;

	public abstract JSONObject getUrl(String url) throws IOException, ParseException;

}
