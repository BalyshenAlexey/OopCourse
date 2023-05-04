import ru.academits.balyshen.temperature.controller.Controller;
import ru.academits.balyshen.temperature.controller.TemperatureController;
import ru.academits.balyshen.temperature.model.Model;
import ru.academits.balyshen.temperature.model.TemperatureModel;
import ru.academits.balyshen.temperature.view.SwingView;
import ru.academits.balyshen.temperature.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new TemperatureModel();
        Controller controller = new TemperatureController(model);
        View view = new SwingView(controller);
        controller.setView(view);

        view.start();
    }
}
