import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class RouletteView extends JPanel {
    private JLabel label = new JLabel("Рулетка не запущена");
    private JSlider slider = new JSlider(2, 50, 10); // Слайдер от 2 до 50
    private JButton startButton = new JButton("Запустить рулетку");
    private RouletteComponent rouletteComponent;

    public RouletteView() {
        setLayout(new BorderLayout());

        rouletteComponent = new RouletteComponent();
        add(rouletteComponent, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(new JLabel("Числа на рулетке:"));
        controlPanel.add(slider);

        controlPanel.add(startButton);
        add(controlPanel, BorderLayout.SOUTH);

        JPanel resultPanel = new JPanel();
        resultPanel.add(label);
        add(resultPanel, BorderLayout.NORTH);
    }

    public JSlider getSlider() {
        return slider;
    }

    public JButton getStartButton() {
        return startButton;
    }
    public void setSpin() {
        label.setText("Рулетка вращается");
    }
    public void setResult(int result) {
        label.setText("Выпало число: " + result);
    }

    public RouletteComponent getRouletteWheel() {
        return rouletteComponent;
    }
}