package restchef.json;

import org.json.simple.JSONObject;

import restchef.constants.Constants;

public class JsonStatus implements Constants {
	
	@SuppressWarnings("unchecked")
	public static JSONObject encode(String status) {
		JSONObject json = new JSONObject();
		json.put(STATUS, status);
		return json;
	}
}
