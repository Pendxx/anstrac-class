import java.util.List;

public abstract class Animal
{
    private boolean alive;
    private Location location;

    public Animal(Location location)
    {
        this.alive = true;
        this.location = location;
    }

    abstract public void act(List<Animal> newAnimals);

    public boolean isAlive()
    {
        return alive;
    }

    public void setDead()
    {
        alive = false;
        location = null;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location newLocation)
    {
        this.location = newLocation;
    }
}
