import java.util.*;

public class RouletteModel {
    private static RouletteModel instance;
    private List<String> rouletteElements; // Список чисел или иконок

    private RouletteModel() {
        rouletteElements = new ArrayList<>();
        // Инициализация элементов рулетки
    }

    public static RouletteModel getInstance() {
        if (instance == null) {
            instance = new RouletteModel();
        }
        return instance;
    }

    // Методы для управления элементами рулетки
}