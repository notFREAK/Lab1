import javax.swing.*;

public class RouletteApp {
    public static void main(String[] args) {
        RouletteModel model = RouletteModel.getInstance();
        RouletteView view = new RouletteView(model);
        RouletteController controller = new RouletteController(model, view);

        JFrame frame = new JFrame("Рулетка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Запуск игры
        controller.startGame();
    }
}