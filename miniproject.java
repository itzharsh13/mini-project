// Rock Paper scissor Game

package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class miniproject extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorButton;
    private JLabel resultLabel, opponentChoiceLabel;
    private String[] choices = {"rock", "paper", "scissor"};

    public miniproject() {
        setTitle("Rock Paper Scissors Game");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorButton = new JButton("Scissor");


        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorButton.addActionListener(this);
        resultLabel = new JLabel("Make your choice!");
        opponentChoiceLabel = new JLabel("");

        add(rockButton);
        add(paperButton);
        add(scissorButton);
        add(resultLabel);
        add(opponentChoiceLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = "";
        if (e.getSource() == rockButton) {
            yourChoice = "rock";
        } else if (e.getSource() == paperButton) {
            yourChoice = "paper";
        } else if (e.getSource() == scissorButton) {
            yourChoice = "scissor";
        }

        String opponentChoice = choices[(int) (Math.random() * 3)];
        opponentChoiceLabel.setText("Opponent's choice: " + opponentChoice);

        String result;
        if (yourChoice.equals(opponentChoice)) {
            result = "It's a tie!";
        } else if ((yourChoice.equals("paper") && opponentChoice.equals("rock")) ||
                (yourChoice.equals("scissor") && opponentChoice.equals("paper")) ||
                (yourChoice.equals("rock") && opponentChoice.equals("scissor"))) {
            result = "Wow! You win!";
        } else {
            result = "You lose the game.";
        }

        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        new miniproject();
    }
}
