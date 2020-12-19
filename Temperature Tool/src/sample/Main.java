package sample;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init"); // Initialize your application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("start");    // Starts an application
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        VBox root = loader.load();
        MenuBar menubar = createMenu();
        root.getChildren().add(0,menubar);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }
    private MenuBar createMenu(){
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("New Menu item Clicked.");
                //newProject();
            }
        });
        SeparatorMenuItem s = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(actionEvent -> { Platform.exit(); System.exit(0);});
        fileMenu.getItems().addAll(newMenuItem,s,quitMenuItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aboutApp();
            }
        });
        helpMenu.getItems().addAll(aboutApp);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Application");
        alert.setHeaderText("You need to know!");
        alert.setContentText("idwiedieonoknce eono oe owneonwo oejon o oe oe o oej");

        ButtonType yesBtn = new ButtonType("OK");
        ButtonType noBtn = new ButtonType("NO");
        alert.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickedBtn = alert.showAndWait();
        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }

    @Override
    public void stop() throws Exception {

        System.out.println("stop"); // Called when application is stopped and is about to shut down
        super.stop();
    }
}
