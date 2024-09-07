import javax.swing.*;
public class RouletteApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RouletteModel model = new RouletteModel();
            RouletteView view = new RouletteView();
            new RouletteController(model, view);

            JFrame frame = new JFrame("Рулетка");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(view);
            frame.pack();
            frame.setVisible(true);
        });
    }
}