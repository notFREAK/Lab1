import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RouletteModel {
    private int numberCount = 10;
    private int currentNumber;

    public void setNumberCount(int count) {
        this.numberCount = count;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public int spin() {
        Random random = new Random();
        currentNumber = random.nextInt(numberCount) + 1;
        return currentNumber;
    }
}