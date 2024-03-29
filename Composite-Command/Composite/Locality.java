package exemplo_composite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Locality extends Place {
	private String cityName;
	private String locationKey;

	// Criação da classe Locality onde é definido o nome da Locality e é guardada a
	// locationKey para chamadas à API futuras
	public Locality(String cityName) throws IOException, ParseException {
		this.cityName = cityName;

		locationKey = getUrl(
				"http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey=ZUFvZd5mUT5kZuQB9W8gqxARTPGUfk71&language=pt-pt&q="
						+ cityName).get("Key").toString();

	}

	// Obtém o tempo atual desta localidade singular
	@Override
	public void getWeather() throws IOException, ParseException {
		System.out.println("Tempo atual da localidade singular " + cityName + ":");
		System.out.print(getUrl("http://dataservice.accuweather.com/currentconditions/v1/" + locationKey
				+ "?apikey=ZUFvZd5mUT5kZuQB9W8gqxARTPGUfk71&language=pt-pt").get("WeatherText").toString()+"\n");

	}

	// Obtém a temperatura atual desta localidade singular
	@Override
	public void getTemperature() throws IOException, ParseException {
		System.out.println("Temperatura atual da localidade singular " + cityName + ":");
		System.out.print(((JSONObject) ((JSONObject) getUrl("http://dataservice.accuweather.com/currentconditions/v1/"
				+ locationKey + "?apikey=ZUFvZd5mUT5kZuQB9W8gqxARTPGUfk71&language=pt-pt").get("Temperature"))
						.get("Metric")).get("Value").toString()
				+ "ºC\n");

	}

	// Obtém o sumário da preciptação das últimas 24 horas desta localidade singular
	@Override
	public void getPrecipitationSummary() throws IOException, ParseException {
		JSONObject precipitation = (JSONObject) getUrl("http://dataservice.accuweather.com/currentconditions/v1/"
				+ locationKey + "?apikey=ZUFvZd5mUT5kZuQB9W8gqxARTPGUfk71&language=pt-pt&details=true&details=true")
						.get("PrecipitationSummary");
		System.out.println("Resumo da precipitação da localidade singular " + cityName + ":");
		System.out.println("   Atual - "
				+ ((JSONObject) ((JSONObject) precipitation.get("Precipitation")).get("Metric")).get("Value").toString()
				+ "mm");
		System.out.println("   Última hora - "
				+ ((JSONObject) ((JSONObject) precipitation.get("PastHour")).get("Metric")).get("Value").toString()
				+ "mm");
		System.out.println("   Últimas 3 horas - "
				+ ((JSONObject) ((JSONObject) precipitation.get("Past3Hours")).get("Metric")).get("Value").toString()
				+ "mm");
		System.out.println("   Últimas 6 horas - "
				+ ((JSONObject) ((JSONObject) precipitation.get("Past6Hours")).get("Metric")).get("Value").toString()
				+ "mm");
		System.out.println("   Últimas 9 horas - "
				+ ((JSONObject) ((JSONObject) precipitation.get("Past9Hours")).get("Metric")).get("Value").toString()
				+ "mm");
		System.out.println("   Últimas 12 horas - "
				+ ((JSONObject) ((JSONObject) precipitation.get("Past12Hours")).get("Metric")).get("Value").toString()
				+ "mm");
		System.out.println("   Últimas 18 horas - "
				+ ((JSONObject) ((JSONObject) precipitation.get("Past18Hours")).get("Metric")).get("Value").toString()
				+ "mm");
		System.out.println("   Últimas 24 horas - "
				+ ((JSONObject) ((JSONObject) precipitation.get("Past24Hours")).get("Metric")).get("Value").toString()
				+ "mm");
	}

	// Função que faz os pedidos à API, consoante o url lhe introduzido
	public JSONObject getUrl(String url) throws IOException, ParseException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET"); // Método necessário pela API

		int responseCode = con.getResponseCode();

		// Verificar se a resposta tem o código 200. Se sim é válida e a resposta é lida
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder content = new StringBuilder();
			String line;
			while (null != (line = in.readLine())) {
				content.append(line);
			}
			in.close();

			// Como a resposta vem em JSON, vou ter de fazer o parse dela. Para isso foi
			// utilizada a livraria JSON.simple
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(content.toString());

			// locationKey desta localização para ser utilizada nas chamadas à API futuras
			return (JSONObject) jsonArray.get(0);
		} else {
			System.err.print("Erro ao chamar a API");
			System.exit(0);
		}

		return null;

	}

}
