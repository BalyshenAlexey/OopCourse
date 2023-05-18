import ru.academits.balyshen.temperature.controller.Controller;
import ru.academits.balyshen.temperature.controller.TemperatureController;
import ru.academits.balyshen.temperature.model.Model;
import ru.academits.balyshen.temperature.model.TemperatureModel;
import ru.academits.balyshen.temperature.scales.CelsiusScale;
import ru.academits.balyshen.temperature.scales.FahrenheitScale;
import ru.academits.balyshen.temperature.scales.KelvinScale;
import ru.academits.balyshen.temperature.scales.TemperatureScale;
import ru.academits.balyshen.temperature.view.SwingView;
import ru.academits.balyshen.temperature.view.View;

public class Main {
    public static void main(String[] args) {
        TemperatureScale[] scales = {new CelsiusScale(), new FahrenheitScale(), new KelvinScale()};

        Model model = new TemperatureModel(scales);
        Controller controller = new TemperatureController(model);
        View view = new SwingView(controller);

        view.start();
    }
}
