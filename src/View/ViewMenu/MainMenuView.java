package View.ViewMenu;

//import Model.ModelGame.Obstacle;
import Controller.ControllerGame.CarController;
import Controller.ControllerGame.CarGameController;
import Controller.ControllerMenu.HighScoreController;
import Controller.ControllerMenu.InstructionsController;
//import Model.ModelGame.Obstacle;
import javax.swing.*;
import java.awt.*;
import View.Game.*;

public class MainMenuView extends ImageFactory {

    private JFrame jFrame;
    private JPanel mainMenuPanel;
    private JButton highScoreButton, instructionsButton, startButton;

    public MainMenuView() {
        this.init();
        jFrame.setVisible(true);
    }

    ;
    
    private void init() {
        jFrame = new JFrame();
        jFrame.setTitle("Racing UTC");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        mainMenuPanel = createImagePanel("Image/NenCar_01.png", 0, 0, 640, 700);

        JLabel titleLabel = new JLabel("Racing 2D");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(250, 30, 160, 30);

        startButton = createButton("Bắt đầu", "Image/Button_01.png", 262, 100, 116, 40);
        highScoreButton = createButton("Điểm cao", "Image/Button_01.png", 262, 180, 116, 40);
        instructionsButton = createButton("Hướng dẫn", "Image/Button_01.png", 262, 260, 116, 40);

        mainMenuPanel.add(titleLabel);
        mainMenuPanel.add(startButton);
        mainMenuPanel.add(highScoreButton);
        mainMenuPanel.add(instructionsButton);
        jFrame.add(mainMenuPanel);
    }

    public void showGame() {
        jFrame.dispose();
        CarGameView view = new CarGameView();
        CarController carController = new CarController(view);
        CarGameController carGame = new CarGameController(view);
        view.startGame();
        view.setVisible(true);
    }

    //gọi giao diện điểm cao
    public void showHighScoreView() {
        jFrame.dispose();
        HighScoreView highview = new HighScoreView();
        //tạo controller điểm cao để xử lý các sự kiện trong giao diện điểm cao
        HighScoreController highScoreController = new HighScoreController(highview);
        highview.setVisible(true);
    }

    //gọi giao diện hướng dẫn
    public void showInstrctionsView() {
        jFrame.dispose();
        InstructionsView instructionsView = new InstructionsView();
        InstructionsController instructionsController = new InstructionsController(instructionsView);
        instructionsView.setVisible(true);
    }

    public JButton getHighScoreButton() {
        return highScoreButton;
    }

    public void setHighScoreButton(JButton highScoreButton) {
        this.highScoreButton = highScoreButton;
    }

    public JButton getInstructionsButton() {
        return instructionsButton;
    }

    public void setInstructionsButton(JButton instructionsButton) {
        this.instructionsButton = instructionsButton;
    }

    //gọi giao diện menu
    public void showMainMenu() {
        jFrame.setVisible(true);
    }

    public JPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public void dispose() {
        jFrame.dispose();
    }

}
