import java.util.Random;

public class Die {

    private int value;
    private int sides;

    public Die(int numSides)
    {
        sides = numSides;
        roll();
    }

    public void roll()
    {
        Random random = new Random();
        value = random.nextInt(6) + 1;
    }

    public void setSides(int numSides)
    {
        sides = numSides;
    }

    public void setValue(int numValue)
    {
        value = numValue;
    }

    public int getValue()
    {
        return value;
    }

    public int getSides()
    {
        return sides;
    }
}
