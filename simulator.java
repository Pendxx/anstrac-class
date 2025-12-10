import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Simulator
{
    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_DEPTH = 50;
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;

    private List<Animal> animals;
    private Field field;
    private int step;

    public Simulator()
    {
        animals = new ArrayList<>();
        field = new Field(DEFAULT_DEPTH, DEFAULT_WIDTH);
        field.setAnimals(animals);
        step = 0;
        populate();
    }

    public void simulateOneStep()
    {
        step++;
        System.out.println("--- Langkah: " + step + " ---");
        
        List<Animal> newAnimals = new ArrayList<>();
        
        for(Iterator<Animal> it = animals.iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            animal.act(newAnimals);
            
            if(! animal.isAlive()) {
                it.remove();
            }
        }
        
        animals.addAll(newAnimals);
        tampilkanStatistik();
    }
    
    public void runLongSimulation(int n) {
        for(int i=0; i<n; i++) {
            simulateOneStep();
        }
    }

    private void populate()
    {
        Random rand = new Random();
        animals.clear();
        
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    animals.add(fox);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    animals.add(rabbit);
                }
            }
        }
    }
    
    private void tampilkanStatistik() {
        int foxCount = 0;
        int rabbitCount = 0;
        
        for(Animal a : animals) {
            if(a instanceof Fox) foxCount++;
            else if(a instanceof Rabbit) rabbitCount++;
        }
        
        System.out.println("Populasi -> Fox: " + foxCount + ", Rabbit: " + rabbitCount);
    }
}
