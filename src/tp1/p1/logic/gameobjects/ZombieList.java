package tp1.p1.logic.gameobjects;

public class ZombieList extends ObjectList{
    Zombie[] zombies;
    public ZombieList(int remainingZombies){
        zombies = new Zombie[remainingZombies];
    }

    @Override
    public boolean add(int col, int row) {
        return false;
    }

    @Override
    public boolean remove(int col, int row) {
        return false;
    }

    @Override
    public Object get(int col, int row) {

        return null;
    }
}
