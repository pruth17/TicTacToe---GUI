/**
 * This class handles the playing of the game with easy and difficult mode
 * @author Pruthvi Punwar
 * @author Tri Do
 * @author Yuxiao Zheng
 */
import javax.swing.*;
import java.awt.*;

public class Mode extends JFrame {
    private JButton easyBtn;
    private JButton hardBtn;
    private JButton backBtn;

    private final Game game;

    /**
     * Initializes all the components.
     *
     * @param game Game object
     */
    public Mode(Game game) {
        this.game = game;
        easyBtn = new JButton("Easy");
        hardBtn = new JButton("Hard");
        backBtn = new JButton("Back");

        levelPanel();
        handleBackEvent();
        handleEasyEvent();
        handleHardEvent();
    }

    /**
     * A helper function setting the mode level panel.
     *
     * @return the level panel.
     */
    private void levelPanel() {
        JLabel levelTitle = new JLabel("Difficulties");
        levelTitle.setFont(new Font("Verdana", 1, 40));

        JPanel levelPanel = new JPanel();
        levelPanel.setLayout(new GridBagLayout());
        levelPanel.setPreferredSize(new Dimension(340, 340));
        GridBagConstraints gridConstraints = new GridBagConstraints();

        // space label
        gridBagConstraints(1, 2, 0, 0, gridConstraints);
        levelPanel.add(levelTitle, gridConstraints);

        // easy button
        gridBagConstraints(1, 0.1, 0, 1, gridConstraints);
        levelPanel.add(easyBtn, gridConstraints);

        // hard button
        gridBagConstraints(1, 0.1, 0, 2, gridConstraints);
        levelPanel.add(hardBtn, gridConstraints);

        // back button
        gridBagConstraints(1, 0.1, 0, 3, gridConstraints);
        levelPanel.add(backBtn, gridConstraints);
        add(levelPanel);
    }

    /**
     * A helper function handling the easy button.
     */
    private void handleEasyEvent() {
        easyBtn.addActionListener(e -> {
            this.setVisible(false);
            game.setState("easy");
        });
    }

    /**
     * A helper function handling the hard button.
     */
    private void handleHardEvent() {
        hardBtn.addActionListener(e -> {
            this.setVisible(false);
            game.setState("hard");
        });
    }

    /**
     * A helper function handling the back button.
     */
    private void handleBackEvent() {
        backBtn.addActionListener(e -> {
            this.setVisible(false);
            game.setState("menu");
        });
    }


    /**
     * A helper function setting the configuration for gridBagConstraints.
     *
     * @param weightx            weight x for gridBagConstraints.
     * @param weighty            weight y for gridBagConstraints.
     * @param gridx              grid x for gridBagConstraints.
     * @param gridy              grid y for gridBagConstraints.
     * @param gridBagConstraints gridBagConstraints input.
     */
    private void gridBagConstraints(double weightx, double weighty, int gridx, int gridy, GridBagConstraints gridBagConstraints) {
        gridBagConstraints.weightx = weightx;
        gridBagConstraints.weighty = weighty;
        gridBagConstraints.gridx = gridx;
        gridBagConstraints.gridy = gridy;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
    }
}