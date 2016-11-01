package restchef.logic;

import org.json.simple.JSONObject;

import com.ibm.json.java.JSONArray;

import restchef.database.DatabaseManager;
import restchef.datastructures.linkedlist.List;
import restchef.datastructures.linkedlist.Node;
import restchef.json.JsonChef;
import restchef.json.JsonStatus;

public class Logic {
	
	public Logic(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	private DatabaseManager databaseManager;
	
	public JSONObject createChef(String jsonChef) {
		if(databaseManager.searchChefName(JsonChef.decodeName(jsonChef))) {
			return JsonStatus.encode("invalid name");
		}
		else if(databaseManager.searchChefEmail(JsonChef.decodeEmail(jsonChef))) {
			return JsonStatus.encode("invalid mail");	
		}
		else {
			//crear chef
			return JsonStatus.encode("chef created");
		}
	}
	

	public JSONObject getChef(String chefName) {
		if(databaseManager.searchChefName(chefName)) {
			return JsonChef.encodeChef(databaseManager.getChef(chefName));
		}
		else {
			return JsonStatus.encode("chef not found");
		}
	}
	
	public JSONObject postMessage(String jsonMessage) {
		return null;
	}
	
	public DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	private List<String> list = new List<>();
	
	public JSONArray encodeList() {
		Node<String> pointer = list.getHead();
		JSONArray jsonArray = new JSONArray();
		while(pointer != null) {
			jsonArray.add(pointer.getData());
			pointer = pointer.getNextNode();
		}
		return jsonArray;
	}
	
	public boolean deleteChef(String chef) {
		boolean exist = list.exist(chef);
		if (exist) {
			list.delete(chef);
		}
		return exist;
	}
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
