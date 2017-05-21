package at.crosspi.rest;

public interface Query {

	String BASE_URL = "https://crosspi.at/xpi/feed/list.json&apikey=";
	String API_KEY = "394c86968bb0c69ff0fe1f482de52829";
	
	String QUESTION_MARK = "?";
	String AND = "&";
	
	String toStringRepresentation(String apiKey);
	
	
}
