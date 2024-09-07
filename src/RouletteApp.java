import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class RouletteApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RouletteModel model = new RouletteModel();
                RouletteView view = new RouletteView();
                new RouletteController(model, view);

                JFrame frame = new JFrame("Рулетка");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(view);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}