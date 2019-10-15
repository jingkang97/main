package seedu.hustler;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import seedu.hustler.game.achievement.AchievementList;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane{
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private TextArea console;
    @FXML
    private PrintStream ps;

    @FXML
    private Button task;

    @FXML
    private Button taskCompletionMode;

    @FXML
    private Button achievement;

    @FXML
    private Button statistics;

    @FXML
    private Button avatar;

    @FXML
    private Button shop;

    @FXML
    private Button arena;

    @FXML
    private Button settings;

    @FXML
    private ImageView menu;

    @FXML
    private ImageView timer;

    @FXML
    private ImageView trophy;

    @FXML
    private ImageView spiderGraph;

    @FXML
    private ImageView profile;

    @FXML
    private ImageView trolley;

    @FXML
    private ImageView swords;

    @FXML
    private ImageView gear;

    @FXML
    private AnchorPane rootPane;

    private Hustler hustler;

    @FXML
    private FlowPane flowPane = new FlowPane();

    @FXML
    private ScrollPane scrollPANEE;
    /**
     * Initializes essential components to run Hustler.
     * @throws IOException if text area could not be found.
     */
    @FXML
    public void initialize() throws IOException {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        ps = new PrintStream(new Console(console));
        System.setOut(ps);
        System.setErr(ps);
        Hustler.initialize();
    }

    public void setHustler(Hustler h) {
        hustler = h;
    }

    /**
     * Changes printing stream to text area in GUI.
     */
    public class Console extends OutputStream {
        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) {
            appendText(String.valueOf((char)b));
        }
    }

    /**
     * Handles operations after each user's input.
     */
    @FXML
    public void handleUserInput() {
        String input = userInput.getText();
        //Hustler.run(input);


        String token[] = input.split(" ");

        if(input.equals("achievement")) {
            achievementAction();
        } else if(token[0].equals("/add") || input.equals("list")) {
            taskAction();
        } else if(input.equals("bye")) {
            Hustler.run("bye");
        }

        userInput.clear();
    }

    @FXML
    public void taskAction() {

        Hustler.run(userInput.getText());
        ColorAdjust color = new ColorAdjust();
        color.setContrast(0.35);
        color.setHue(-0.21);
        color.setBrightness(0.09);
        color.setSaturation(1.0);
        menu.setEffect(color);
        timer.setEffect(null);
        trophy.setEffect(null);
        spiderGraph.setEffect(null);
        profile.setEffect(null);
        trolley.setEffect(null);
        swords.setEffect(null);
        gear.setEffect(null);

        task.setStyle("-fx-background-color:#243342");
        taskCompletionMode.setStyle("-fx-background-color:#34495E");
        achievement.setStyle("-fx-background-color:#34495E");
        statistics.setStyle("-fx-background-color:#34495E");
        avatar.setStyle("-fx-background-color:#34495E");
        shop.setStyle("-fx-background-color:#34495E");
        arena.setStyle("-fx-background-color:#34495E");
        settings.setStyle("-fx-background-color:#34495E");

        task.textFillProperty().setValue(Paint.valueOf("#ffffff"));
        taskCompletionMode.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        achievement.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        statistics.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        avatar.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        shop.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        arena.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        settings.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
    }

    @FXML
    public void taskCompletionModeAction() {

        console.clear();

        ColorAdjust color = new ColorAdjust();
        color.setContrast(0.35);
        color.setHue(-0.21);
        color.setBrightness(0.09);
        color.setSaturation(1.0);

        menu.setEffect(null);
        timer.setEffect(color);
        trophy.setEffect(null);
        spiderGraph.setEffect(null);
        profile.setEffect(null);
        trolley.setEffect(null);
        swords.setEffect(null);
        gear.setEffect(null);

        task.setStyle("-fx-background-color:#34495E");
        taskCompletionMode.setStyle("-fx-background-color:#243342");
        achievement.setStyle("-fx-background-color:#34495E");
        statistics.setStyle("-fx-background-color:#34495E");
        avatar.setStyle("-fx-background-color:#34495E");
        shop.setStyle("-fx-background-color:#34495E");
        arena.setStyle("-fx-background-color:#34495E");
        settings.setStyle("-fx-background-color:#34495E");

        task.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        taskCompletionMode.textFillProperty().setValue(Paint.valueOf("#ffffff"));
        achievement.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        statistics.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        avatar.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        shop.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        arena.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        settings.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
    }

    @FXML
    public void achievementAction() {

        flowPane.getChildren().clear();
        Hustler.run("achievement");

        flowPane.setVgap(10);

        for(int i = 0; i < AchievementList.achievementList.size(); i += 1) {
            if(!AchievementList.achievementList.get(i).checkLock()) {
                StackPane stackPane = new StackPane();
                Rectangle rect = new Rectangle();
                Text text = new Text(AchievementList.achievementList.get(i).toString());
                text.setFont(Font.font("Gill Sans", 20));
                text.setFill(Color.WHITE);
                rect.setOpacity(0.3);
                rect.setHeight(50);
                rect.widthProperty().bind(scrollPANEE.widthProperty());
                rect.setArcHeight(30.0);
                rect.setArcWidth(30.0);
                rect.setStyle("#ffffff");
                stackPane.setAlignment(text,Pos.CENTER);
                stackPane.getChildren().addAll(rect, text);
                flowPane.getChildren().add(stackPane);
            }
        }

        for(int i = 0; i < AchievementList.achievementList.size(); i += 1) {
            if(AchievementList.achievementList.get(i).checkLock()) {
                StackPane stackPane = new StackPane();
                Rectangle rect = new Rectangle();
                Text text = new Text(AchievementList.achievementList.get(i).toString());
                text.setFont(Font.font("Gill Sans", 20));
                text.setStyle("-fx-fill: white");
                text.setOpacity(0.3);
                rect.setOpacity(0.3);
                rect.setHeight(50);
                rect.widthProperty().bind(scrollPANEE.widthProperty());
                rect.setArcHeight(30.0);
                rect.setArcWidth(30.0);
                rect.setStyle("#ffffff");
                stackPane.setAlignment(text, Pos.CENTER);
                stackPane.getChildren().addAll(rect,text);
                flowPane.getChildren().add(stackPane);
            }
        }

        scrollPANEE.setContent(flowPane);
        ColorAdjust color = new ColorAdjust();
        color.setContrast(0.35);
        color.setHue(-0.21);
        color.setBrightness(0.09);
        color.setSaturation(1.0);

        menu.setEffect(null);
        timer.setEffect(null);
        trophy.setEffect(color);
        spiderGraph.setEffect(null);
        profile.setEffect(null);
        trolley.setEffect(null);
        swords.setEffect(null);
        gear.setEffect(null);

        task.setStyle("-fx-background-color:#34495E");
        taskCompletionMode.setStyle("-fx-background-color:#34495E");
        achievement.setStyle("-fx-background-color:#243342");
        statistics.setStyle("-fx-background-color:#34495E");
        avatar.setStyle("-fx-background-color:#34495E");
        shop.setStyle("-fx-background-color:#34495E");
        arena.setStyle("-fx-background-color:#34495E");
        settings.setStyle("-fx-background-color:#34495E");

        task.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        taskCompletionMode.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        achievement.textFillProperty().setValue(Paint.valueOf("#ffffff"));
        statistics.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        avatar.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        shop.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        arena.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        settings.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
    }

    @FXML
    public void statisticsAction() {

        ColorAdjust color = new ColorAdjust();
        color.setContrast(0.35);
        color.setHue(-0.21);
        color.setBrightness(0.09);
        color.setSaturation(1.0);

        menu.setEffect(null);
        timer.setEffect(null);
        trophy.setEffect(null);
        spiderGraph.setEffect(color);
        profile.setEffect(null);
        trolley.setEffect(null);
        swords.setEffect(null);
        gear.setEffect(null);

        task.setStyle("-fx-background-color:#34495E");
        taskCompletionMode.setStyle("-fx-background-color:#34495E");
        achievement.setStyle("-fx-background-color:#34495E");
        statistics.setStyle("-fx-background-color:#243342");
        avatar.setStyle("-fx-background-color:#34495E");
        shop.setStyle("-fx-background-color:#34495E");
        arena.setStyle("-fx-background-color:#34495E");
        settings.setStyle("-fx-background-color:#34495E");

        task.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        taskCompletionMode.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        achievement.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        statistics.textFillProperty().setValue(Paint.valueOf("#ffffff"));
        avatar.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        shop.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        arena.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        settings.textFillProperty().setValue(Paint.valueOf("#95a5a6"));

    }

    @FXML
    public void avatarAction() {

        ColorAdjust color = new ColorAdjust();
        color.setContrast(0.35);
        color.setHue(-0.21);
        color.setBrightness(0.09);
        color.setSaturation(1.0);

        menu.setEffect(null);
        timer.setEffect(null);
        trophy.setEffect(null);
        spiderGraph.setEffect(null);
        profile.setEffect(color);
        trolley.setEffect(null);
        swords.setEffect(null);
        gear.setEffect(null);

        task.setStyle("-fx-background-color:#34495E");
        taskCompletionMode.setStyle("-fx-background-color:#34495E");
        achievement.setStyle("-fx-background-color:#34495E");
        statistics.setStyle("-fx-background-color:#34495E");
        avatar.setStyle("-fx-background-color:#243342");
        shop.setStyle("-fx-background-color:#34495E");
        arena.setStyle("-fx-background-color:#34495E");
        settings.setStyle("-fx-background-color:#34495E");

        task.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        taskCompletionMode.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        achievement.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        statistics.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        avatar.textFillProperty().setValue(Paint.valueOf("#ffffff"));
        shop.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        arena.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        settings.textFillProperty().setValue(Paint.valueOf("#95a5a6"));

    }

    @FXML
    public void shopAction() {

        ColorAdjust color = new ColorAdjust();
        color.setContrast(0.35);
        color.setHue(-0.21);
        color.setBrightness(0.09);
        color.setSaturation(1.0);

        menu.setEffect(null);
        timer.setEffect(null);
        trophy.setEffect(null);
        spiderGraph.setEffect(null);
        profile.setEffect(null);
        trolley.setEffect(color);
        swords.setEffect(null);
        gear.setEffect(null);

        task.setStyle("-fx-background-color:#34495E");
        taskCompletionMode.setStyle("-fx-background-color:#34495E");
        achievement.setStyle("-fx-background-color:#34495E");
        statistics.setStyle("-fx-background-color:#34495E");
        avatar.setStyle("-fx-background-color:#34495E");
        shop.setStyle("-fx-background-color:#243342");
        arena.setStyle("-fx-background-color:#34495E");
        settings.setStyle("-fx-background-color:#34495E");

        task.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        taskCompletionMode.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        achievement.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        statistics.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        avatar.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        shop.textFillProperty().setValue(Paint.valueOf("#ffffff"));
        arena.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        settings.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
    }

    @FXML
    public void arenaAction() {

        ColorAdjust color = new ColorAdjust();
        color.setContrast(0.35);
        color.setHue(-0.21);
        color.setBrightness(0.09);
        color.setSaturation(1.0);

        menu.setEffect(null);
        timer.setEffect(null);
        trophy.setEffect(null);
        spiderGraph.setEffect(null);
        profile.setEffect(null);
        trolley.setEffect(null);
        swords.setEffect(color);
        gear.setEffect(null);

        task.setStyle("-fx-background-color:#34495E");
        taskCompletionMode.setStyle("-fx-background-color:#34495E");
        achievement.setStyle("-fx-background-color:#34495E");
        statistics.setStyle("-fx-background-color:#34495E");
        avatar.setStyle("-fx-background-color:#34495E");
        shop.setStyle("-fx-background-color:#34495E");
        arena.setStyle("-fx-background-color:#243342");
        settings.setStyle("-fx-background-color:#34495E");

        achievement.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        task.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        taskCompletionMode.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        statistics.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        avatar.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        shop.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        arena.textFillProperty().setValue(Paint.valueOf("#ffffff"));
        settings.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
    }

    @FXML
    public void settingsAction() {

        ColorAdjust color = new ColorAdjust();
        color.setContrast(0.35);
        color.setHue(-0.21);
        color.setBrightness(0.09);
        color.setSaturation(1.0);

        menu.setEffect(null);
        timer.setEffect(null);
        trophy.setEffect(null);
        spiderGraph.setEffect(null);
        profile.setEffect(null);
        trolley.setEffect(null);
        swords.setEffect(null);
        gear.setEffect(color);


        task.setStyle("-fx-background-color:#34495E");
        taskCompletionMode.setStyle("-fx-background-color:#34495E");
        achievement.setStyle("-fx-background-color:#34495E");
        statistics.setStyle("-fx-background-color:#34495E");
        avatar.setStyle("-fx-background-color:#34495E");
        shop.setStyle("-fx-background-color:#34495E");
        arena.setStyle("-fx-background-color:#34495E");
        settings.setStyle("-fx-background-color:#243342");

        achievement.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        task.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        taskCompletionMode.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        statistics.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        avatar.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        shop.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        arena.textFillProperty().setValue(Paint.valueOf("#95a5a6"));
        settings.textFillProperty().setValue(Paint.valueOf("#ffffff"));
    }



}