package tp1.p1.logic.gameobjects;

public class ZombieList{
    public Zombie[] zombies;
    public int size = 0;
    
    
    public ZombieList(int remainingZombies){
        zombies = new Zombie[remainingZombies];
    }

}
