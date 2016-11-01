package restchef.logic;

import restchef.database.DatabaseManager;

public class LogicContainer {
	
	private static Logic logic = new Logic(new DatabaseManager());

	public static Logic getLogic() {
		return logic;
	}

	public static void setLogic(Logic logic) {
		LogicContainer.logic = logic;
	}
}
