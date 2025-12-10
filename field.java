import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Field
{
    private int depth, width;
    private List<Animal> animals;

    public Field(int depth, int width)
    {
        this.depth = depth;
        this.width = width;
        this.animals = new ArrayList<>();
    }
    
    public void setAnimals(List<Animal> animals)
    {
        this.animals = animals;
    }

    public List<Animal> getAnimalsAt(Location location)
    {
        List<Animal> found = new ArrayList<>();
        for(Animal a : animals) {
            if(a.isAlive() && a.getLocation().getRow() == location.getRow() 
               && a.getLocation().getCol() == location.getCol()) {
                found.add(a);
            }
        }
        return found;
    }
    
    public int getDepth()
    {
        return depth;
    }
    
    public int getWidth()
    {
        return width;
    }
}
