import java.util.Random;

public class RouletteModel {
    private int numberCount = 10;

    public void setNumberCount(int count) {
        this.numberCount = count;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public int spin() {
        Random random = new Random();
        return random.nextInt(numberCount) + 1;
    }
}