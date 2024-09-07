import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class RouletteController {
    private RouletteModel model;
    private RouletteView view;

    public RouletteController(RouletteModel model, RouletteView view) {
        this.model = model;
        this.view = view;

        view.getSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setNumberCount(view.getSlider().getValue());
                view.getRouletteComponent().updateNumbers(model.getNumberCount());
                view.getRouletteComponent().repaint();
            }
        });

        view.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = model.spin();
                view.setSpin();
                view.getRouletteComponent().startSpin(result);
                view.getRouletteComponent().setOnSpinEnd(new Runnable() {
                    @Override
                    public void run() {
                        view.setResult(result);
                    }
                });
            }
        });
    }
}