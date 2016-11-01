package restchef.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import restchef.constants.Constants;
import restchef.logic.Chef;

public class JsonChef implements Constants {
	
	@SuppressWarnings("unchecked")
	public static JSONObject encodeChef(Chef chef) {
		JSONObject json = new JSONObject();
		json.put(STATUS, "chef found");
		json.put(NAME, chef.getName());
		json.put(EMAIL, chef.getEmail());
		return json;
	}
	
	public static String decodeName(String jsonString) {
		JSONParser parser = new JSONParser();
		String name = null;
		try {         
			Object obj = parser.parse(jsonString);       
			JSONObject jsonObject = (JSONObject) obj;  
			name = (String)jsonObject.get(NAME);   
		} catch (ParseException e) {  
			e.printStackTrace();  
		}  
		return name;	
	}
	
	public static String decodeEmail(String jsonString) {
		JSONParser parser = new JSONParser();
		String email = null;
		try {         
			Object obj = parser.parse(jsonString);       
			JSONObject jsonObject = (JSONObject) obj;  
			email = (String)jsonObject.get(EMAIL);   
		} catch (ParseException e) {  
			e.printStackTrace();  
		}  
		return email;	
	}

}
