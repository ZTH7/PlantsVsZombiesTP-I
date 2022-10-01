package tp1.p1.logic.gameobjects;

public class SunflowerList extends PlantsList{

    @Override
    public boolean add(int col, int row) {
        Sunflower sunflower = new Sunflower();
        
        
        this.list[size] = sunflower;
        this.size++;

        return false;
    }

}
