import java.util.List;
import java.util.Random;

public class Rabbit extends Animal
{
    private static final int MAX_AGE = 40;
    private static final double BREEDING_PROBABILITY = 0.12;
    private static final int MAX_LITTER_SIZE = 4;
    
    private int age;
    private Field field;
    private Random rand = new Random();

    public Rabbit(boolean randomAge, Field field, Location location)
    {
        super(location);
        this.field = field;
        age = 0;
        if(randomAge) {
            age = rand.nextInt(MAX_AGE);
        }
    }

    @Override
    public void act(List<Animal> newAnimals)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newAnimals);
        }
    }

    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            setDead();
        }
    }

    private void giveBirth(List<Animal> newAnimals)
    {
        if(rand.nextDouble() <= BREEDING_PROBABILITY) {
            int births = rand.nextInt(MAX_LITTER_SIZE) + 1;
            for(int b = 0; b < births; b++) {
                Rabbit newRabbit = new Rabbit(false, field, getLocation());
                newAnimals.add(newRabbit);
            }
        }
    }
}
