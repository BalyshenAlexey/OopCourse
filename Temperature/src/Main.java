import ru.academits.balyshen.temperature.controller.Controller;
import ru.academits.balyshen.temperature.model.TemperatureModel;
import ru.academits.balyshen.temperature.view.SwingView;
import ru.academits.balyshen.temperature.view.View;

public class Main {
    public static void main(String[] args) {
        TemperatureModel model = new TemperatureModel();

        Controller controller = new Controller(model);
        View view = new SwingView(controller);
        controller.setView(view);

        view.start();
    }
}
