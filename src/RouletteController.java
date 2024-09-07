class RouletteController {

    public RouletteController(RouletteModel model, RouletteView view) {

        view.getSlider().addChangeListener(e -> {
            model.setNumberCount(view.getSlider().getValue());
            view.getRouletteComponent().updateNumbers(model.getNumberCount());
            view.getRouletteComponent().repaint();
        });

        view.getStartButton().addActionListener(e -> {
            int result = model.spin();
            view.setSpin();
            view.getRouletteComponent().startSpin(result);
            view.getRouletteComponent().setOnSpinEnd(() -> view.setResult(result));
        });
    }
}