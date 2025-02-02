package Controller.ControllerGame;

import Controller.ControllerMenu.MainMenuController;
import View.Game.CarGameView;
import View.Game.PauseGameView;
import View.ViewMenu.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nguye
 */
public class PauseGameController {

    private PauseGameView pauseView;
    private CarGameView view;

    public PauseGameController(PauseGameView pauseView, CarGameView view) {
        this.pauseView = pauseView;
        this.view = view;
        pauseView.getjButton_Home().addActionListener(new HomeButtonListener());
        pauseView.getjButton_PlayAgain().addActionListener(new PlayAgainListener());
        pauseView.getjButton_Resume().addActionListener(new ResumeButtonListener());
    }

    private class PlayAgainListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pauseView.dispose();
            CarGameView gameView = new CarGameView();
            CarController carController = new CarController(gameView);
        }

    }

    private class HomeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pauseView.dispose();
            MainMenuView mainMenuView = new MainMenuView();
            MainMenuController mainMenuController =  new MainMenuController(mainMenuView);
            mainMenuView.showMainMenu();
        }

    }

    private class ResumeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pauseView.dispose();
            view.resumeGame();
            //new CarController(view);
            
        }

    }
}
