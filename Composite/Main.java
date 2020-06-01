package exemplo_composite;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		District Viseu = new District("Viseu");
		
		Place Vouzela = new Locality("Vouzela");
		Viseu.add(Vouzela);
		Viseu.add(new Locality("Rio de Janeiro"));
		District Lisboa = new District("Lisboa");
		Lisboa.add(new Locality("Aveiro"));
		Viseu.add(Lisboa);
		
		Viseu.getPrecipitationSummary();
	}
}
