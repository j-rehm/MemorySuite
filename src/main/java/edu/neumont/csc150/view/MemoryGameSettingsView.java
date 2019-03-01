package edu.neumont.csc150.view;

import edu.neumont.csc150.controller.MemoryGameController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MemoryGameSettingsView {

    public VBox vbox;
    public HBox settings;
    public HBox dificulty;
    public Button livesSettings;
    public Button timerSettings;
    public Button gridSizeSettings;
    public Label topLabel;
    public HBox bottomPart;
    public Button startGameBtn;
    public Button returnBtn;
    public Button easy;
    public Button Medium;
    public Button hard;

    private int gridSize = 6;
    private double timer = 2;
    private int lives = 5;
    private MemoryGameController controller;
    private ViewNavigator viewNavigator;

    public void registerController(MemoryGameController controller){
        this.controller = controller;
    }

    void init(ViewNavigator viewNavigator) {
        vbox.setSpacing(30);
        vbox.setPadding(new Insets(20, 0, 0, 0));
        settings.setSpacing(20);
        dificulty.setSpacing(30);
        bottomPart.setSpacing(320);
        bottomPart.setPadding(new Insets(80, 20, 0, 20));
        registerViewNavigator(viewNavigator);
    }

    public void returnBtn() throws Exception {
        viewNavigator.showMainMenu();
    }
    public void startGame() throws IOException {
        controller.setGridSize(gridSize);
        controller.setLives(lives);
        controller.setTimer(timer);
        viewNavigator.showMemoryGame();
    }

    public void gridSizeClicked() {
        int maxNumberAllowed = 8, minimunNumberAllowed = 4;
        if (gridSize == maxNumberAllowed) {
            gridSize = minimunNumberAllowed;
        } else {
            gridSize += 1;
        }
        gridSizeSettings.setText("Grid Size: " + gridSize);
    }

    public void livesClicked() {
        int maxNumberAllowed = 15;
        int minNumberAllowed = 1;

        if (lives == maxNumberAllowed) {
            lives = minNumberAllowed;
        } else {
            lives += 1;
        }

        if (lives > 1) {
            livesSettings.setText(lives + " lives");
        } else {
            livesSettings.setText(lives + " life");
        }
    }

    public void onTimeCliked() {
        double maxNumberAllowed = 10;
        double minNumberAllowed = 0.2;
        if (timer == maxNumberAllowed) {
            timer = minNumberAllowed;
        } else {
            timer += 1;
        }

        if (timer > 1) {
            timerSettings.setText("View Time: " + timer + " seconds");
        } else {
            timerSettings.setText("View Time: " + timer + " second");
        }
    }

    public void onEasyClicked() {
        gridSize = 4;
        timer = 5;
        lives = 10;
        gridSizeSettings.setText("Grid Size: 4");
        timerSettings.setText("View Time: 5 seconds");
        livesSettings.setText("10 lives");
    }

    public void onMediumClicked() {
        gridSize = 6;
        timer = 2;
        lives = 5;
        gridSizeSettings.setText("Grid Size: 6");
        timerSettings.setText("View Time: 2 seconds");
        livesSettings.setText("5 lives");
    }

    public void onHardClicked() {
        gridSize = 8;
        timer = 1;
        lives = 3;
        gridSizeSettings.setText("Grid Size: 8");
        timerSettings.setText("View Time: 1 seconds");
        livesSettings.setText("3 lives");
    }

    public int getGridSize() {
        return gridSize;
    }

    public double getTimer() {
        return timer;
    }

    public int getLives() {
        return lives;
    }

    public void onLoad() {

    }

    public void onExit() throws IOException {
        viewNavigator.showMainMenu();
    }

    public void onAbout() {

    }

    private void registerViewNavigator(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
    }
}