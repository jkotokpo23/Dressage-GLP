package engine.process;

import config.GameConfiguration;
import engine.map.Map;

/**
 * Build the Map.
 */
public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static PetManager buildInitMobile(Map map) {
		PetManager manager = new PetManager(map);

		return manager;
	}


}