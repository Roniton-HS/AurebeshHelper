package roniton.abh;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.fulib.fx.FulibFxApp;
import roniton.abh.dagger.DaggerMainComponent;
import roniton.abh.dagger.MainComponent;

import javax.imageio.ImageIO;
import java.awt.*;

public class App extends FulibFxApp {
    private final MainComponent component;

    public App() {
        super();
        this.component = DaggerMainComponent.builder().mainApp(this).build();
    }

    @Override
    public void start(Stage primaryStage){
        super.start(primaryStage);
        registerRoutes(component.routes());
        primaryStage.getScene().getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        primaryStage.setWidth(500);
        primaryStage.setHeight(700);
        primaryStage.setResizable(false);
        show("/menu");

        //Todo: set icons
        //setAppIcon(primaryStage);
        //setTaskbarIcon();
    }

    private void setAppIcon(Stage stage) {
        final Image image = new Image(App.class.getResource("path").toString());
        stage.getIcons().add(image);
    }

    private void setTaskbarIcon() {
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }

        try {
            final Taskbar taskbar = Taskbar.getTaskbar();
            final java.awt.Image image = ImageIO.read(App.class.getResource("path"));
            taskbar.setIconImage(image);
        } catch (Exception ignored) {
        }
    }
}
