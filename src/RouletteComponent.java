import javax.swing.*;
import java.awt.*;

public class RouletteComponent extends JComponent {
    private int wheelPosition; // Положение колеса рулетки

    public RouletteComponent() {
        // Инициализация компонента
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Отрисовка колеса рулетки с учетом положения
    }

    public void updateWheelPosition(int position) {
        wheelPosition = position;
        repaint();
    }
}