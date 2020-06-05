package exemplo_composite;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		District Lisboa = new District("Lisboa");
		District Aveiro = new District("Aveiro");
		
		District Amadora = new District("Amadora");
		Amadora.add(new Locality("Reboleira"));
		Amadora.add(new Locality("Alfragide"));
		Lisboa.add(Amadora);
		Lisboa.add(new Locality("Sintra"));
		
		
		Aveiro.add(new Locality("Albergaria"));
		Aveiro.add(new Locality("Murtosa"));
		
		Lisboa.getWeather();
		Lisboa.getTemperature();
		Lisboa.getPrecipitationSummary();
		
		Aveiro.getWeather();
		Aveiro.getTemperature();
		Aveiro.getPrecipitationSummary();
		
	}
}
