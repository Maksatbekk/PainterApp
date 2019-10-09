package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class Controller {

        private enum PenSize {
            SMALL(2),
            MEDIUM(4),
            LARGE(6);

            private final int radius;

            PenSize(int radius) {
                this.radius = radius;
            } // constructor

            public int getRadius() {
                return radius;
            }
        }

        @FXML
        private TitledPane DrawMenu;

        @FXML
        private RadioButton blackRadioButton;

        @FXML
        private ToggleGroup colorToggleGroup;

        @FXML
        private RadioButton redRadioButton;

        @FXML
        private RadioButton greenRadioButton;

        @FXML
        private RadioButton blueRadioButton;

        @FXML
        private TitledPane penSize;

        @FXML
        private RadioButton smallRadioButton;

        @FXML
        private ToggleGroup sizeToggleGroup;

        @FXML
        private RadioButton mediumRadioButton;

        @FXML
        private RadioButton largeRadioButton;

        @FXML
        private Button undoRadioButton;

        @FXML
        private Button clearRadioButton;

        @FXML
        private Pane drawingAreaPane;

        private PenSize radius = PenSize.MEDIUM;

        private Paint brushColor = Color.BLACK;

        public void initialize() {
            blackRadioButton.setUserData(Color.BLACK);
            redRadioButton.setUserData(Color.RED);
            greenRadioButton.setUserData(Color.GREEN);
            blueRadioButton.setUserData(Color.BLUE);
            smallRadioButton.setUserData(PenSize.SMALL);
            mediumRadioButton.setUserData(PenSize.MEDIUM);
            largeRadioButton.setUserData(PenSize.LARGE);
        }
        @FXML
        private void drawingAreaMouseDragged(MouseEvent e) {
            Circle newCircle = new Circle(e.getX(), e.getY(),
                    radius.getRadius(), brushColor);
            drawingAreaPane.getChildren().add(newCircle);
            }
        @FXML
        private void colorRadioButtonSelected(ActionEvent event) {
            // user data for each color RadioButton is the corresponding Color
            brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
            }

        @FXML
        private void sizeRadioButtonSelected(ActionEvent event) {
            // user data for each size RadioButton is the corresponding PenSize
            radius =
                    (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
            }
        @FXML
        private void undoButtonPressed(ActionEvent event) {
            int count = drawingAreaPane.getChildren().size();

            // if there are any shapes remove the last one added
            if (count > 0) {
                drawingAreaPane.getChildren().remove(count - 1);
                }
            }

        @FXML
        private void clearButtonPressed(ActionEvent event) {
            drawingAreaPane.getChildren().clear(); // clear the canvas
            }

        @FXML
        void buttonPressed(MouseEvent event) {
        }
}

