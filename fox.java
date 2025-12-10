import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class Fox extends Animal
{
    private static final int MAX_AGE = 150;
    private static final double BREEDING_PROBABILITY = 0.08;
    private static final int MAX_LITTER_SIZE = 2;
    private static final int RABBIT_FOOD_VALUE = 9;
    
    private int age;
    private int foodLevel;
    private Field field;
    private Random rand = new Random();

    public Fox(boolean randomAge, Field field, Location location)
    {
        super(location);
        this.field = field;
        age = 0;
        if(randomAge) {
            age = rand.nextInt(MAX_AGE);
            foodLevel = rand.nextInt(RABBIT_FOOD_VALUE);
        }
        else {
            foodLevel = RABBIT_FOOD_VALUE;
        }
    }

    @Override
    public void act(List<Animal> newAnimals)
    {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            findFood();
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
    
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }

    private void findFood()
    {
        List<Animal> animalsAtLocation = field.getAnimalsAt(getLocation());
        
        Iterator<Animal> it = animalsAtLocation.iterator();
        while(it.hasNext()) {
            Animal animal = it.next();
            if(animal instanceof Rabbit && animal.isAlive()) {
                animal.setDead();
                foodLevel = RABBIT_FOOD_VALUE;
                return;
            }
        }
    }

    private void giveBirth(List<Animal> newAnimals)
    {
        if(rand.nextDouble() <= BREEDING_PROBABILITY) {
            int births = rand.nextInt(MAX_LITTER_SIZE) + 1;
            for(int b = 0; b < births; b++) {
                Fox newFox = new Fox(false, field, getLocation());
                newAnimals.add(newFox);
            }
        }
    }
}
