import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class RouletteComponent extends JPanel {
    private int currentAngle = 0;
    private int targetAngle = 360;
    private Timer timer;
    private int numberCount = 10;
    private int[] numbers;
    private Runnable onSpinEnd;
    public RouletteComponent() {
        setPreferredSize(new Dimension(300, 300));
        updateNumbers(numberCount);
    }

    // Обновление чисел на рулетке в зависимости от количества
    public void updateNumbers(int numberCount) {
        this.numberCount = numberCount;
        numbers = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = i + 1;
        }
    }

    public void setOnSpinEnd(Runnable onSpinEnd) {
        this.onSpinEnd = onSpinEnd;
    }
    // Начало вращения рулетки
    public void startSpin(int targetNumber) {// Обновляем количество чисел
        updateNumbers(numberCount);
        targetAngle = 360 - (int) ((targetNumber - 1 ) / (double) (numberCount) * 360); // Вычисляем целевой угол
        timer = new Timer(10, new ActionListener() {
            Random rand = new Random();
            int round = 360*(1 + rand.nextInt(5)) + currentAngle;
            int time = 1;
            int speed = 10;
            int exp = round / speed +  time;

            @Override
            public void actionPerformed(ActionEvent e) {
                currentAngle = (currentAngle + speed) % 360;
                speed = Math.max(1, round / (time + exp)); // Плавное замедление
                time += 10;
                repaint();

                if (speed == 1 && Math.abs(currentAngle - targetAngle) < 2) {
                    ((Timer) e.getSource()).stop();
                    // Вызов callback после остановки рулетки
                    if (onSpinEnd != null) {
                        onSpinEnd.run();
                    }
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int radius = Math.min(getWidth(), getHeight()) / 2 - 30;  // Радиус круга
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Рисуем круг рулетки
        g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Рисуем стрелку для указания выпавшего числа
        g2d.setColor(Color.RED);
        g2d.fillPolygon(new int[]{centerX, centerX - 5, centerX + 5},
                new int[]{centerY - radius, centerY - radius - 10, centerY - radius - 10}, 3);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(0.5F));
        // Рисуем числа на круге
        double angleStep = 360.0 / numberCount;  // Шаг между числами по окружности

        for (int i = 0; i < numberCount; i++) {
            double angle = Math.toRadians(currentAngle + (i) * angleStep - 90);  // Угол для каждого числа
            int textX = (int) (centerX + (radius * 0.9) * Math.cos(angle));
            int textY = (int) (centerY + (radius * 0.9) * Math.sin(angle));

            g2d.drawLine( centerX, centerY,
                    (int) (centerX + radius * Math.cos(Math.toRadians(currentAngle + (i) * angleStep - (90+angleStep/2) ))),
                    (int) (centerY + radius * Math.sin(Math.toRadians(currentAngle + (i) * angleStep - (90+angleStep/2) ))));
            g2d.drawString(String.valueOf(numbers[i]), textX - 5, textY + 5);  // Рисуем число с небольшим смещением для центрирования
        }
    }
}