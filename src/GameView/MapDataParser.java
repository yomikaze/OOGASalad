package GameView;

import java.util.ArrayList;
import java.util.List;

import engine.gridobject.GridObject;
import engine.gridobject.person.Player;
import authoring.GridObjectData;
import authoring.MapData;
import authoring.TileData;

/**
 * Class used to parse an instance of MapData into the GridObjects and Tile
 * images that MapData contains.
 * 
 * @author Brandon
 * 
 */
public class MapDataParser {

	private List<GridObject> myGridObjectList;
	private List<String> myTileImageList;
	private MapData myMap;

	protected MapDataParser(MapData map, Player p) {
		myMap = map;
		myGridObjectList = new ArrayList<GridObject>();
		myTileImageList = new ArrayList<String>();
		parseMap(p);
	}

	protected List<GridObject> getGridObjectList() {
		return myGridObjectList;
	}

	protected List<String> getTileImageList() {
		return myTileImageList;
	}

	/**
	 * Parses myMap into a list of GridObjects and sets position of GridObjects,
	 * GridObjects are created using their String ID using Reflection. Also,
	 * adds images for each tile to a list.
	 * 
	 * @param p
	 *            Player
	 */
	private void parseMap(Player p) {
		List<GridObjectData> currData = new ArrayList<GridObjectData>();
		for (int i = 0; i < myMap.getMapLength(); i++) {
			for (int j = 0; j < myMap.getMapWidth(); j++) {
				TileData currTile = myMap.getTileData(i, j);
				currData = currTile.getGridObjectDatas();

				for (GridObjectData data : currData) {
					GridObject gridobject = null;

					// List<Object> myList = data.getArguments();
					// System.out.println(myList);

					try {
						gridobject = (GridObject) Class.forName(data.getID())
								.getConstructor(List.class)
								.newInstance(data.getArguments());
					} catch (Exception e) {
						e.printStackTrace();
					}

					if (gridobject != null) {
						gridobject.setPosition(i, j);
						myGridObjectList.add(gridobject);
					}
				}

				myTileImageList.add(currTile.getImageName());
			}
		}
	}
}
