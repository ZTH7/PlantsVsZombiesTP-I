package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;

public class GameObjectContainer {

	private List<GameObject> gameObjects;

	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	// TODO add your code here
	public void add(GameObject obj) {
		gameObjects.add(obj);
		obj.onEnter();
	}
	
	public boolean remove(int col, int row) {
		for(GameObject obj : gameObjects) {
			if(obj.isInPosition(col, row)) {
				obj.onExit();
				gameObjects.remove(obj);
				return true;
			}
		}
		return false;
	}
	
	public boolean remove(GameObject obj) {
		obj.onExit();
		return gameObjects.remove(obj);
	}
	
	public GameObject get(int col, int row) {
		for(GameObject obj : gameObjects) {
			if(obj.isInPosition(col, row)) return obj;
		}
		return null;
	}
	
	public void update() {
		int size = gameObjects.size();
		for(int i = 0; i < size; i++) {
			gameObjects.get(i).update();
		}
		
		for(int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).kill();
		}
	}
}
