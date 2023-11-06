import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author lqtam
 */
public class HUD extends JFrame {
    /**
     *
     */
    protected Board bigBoard;
    /**
     *
     */
    protected Board[] subBoards;
    /**
     *
     */
    protected int curr;
    /**
     *
     */
    protected String player;

    /**
     * Creates new form HUD
     */
    public HUD() {
        this.bigBoard = new Board();
        this.subBoards = new Board[9];
        for (int i = 0; i < 9; i++) {
            this.subBoards[i] = new Board();
        }
        // this.curr = 4;
        this.player = "X";
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Background = new JPanel();
        Title = new JLabel();
        Board = new JPanel();
        Subboard = new JLayeredPane[9];
        SubBack = new JPanel[9];
        Positions = new JButton[9][9];
        BoardWinner = new JLayeredPane[9];
        Winner = new JLabel[9];
        Turns = new JPanel();
        TurnIndicator = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(600, 600));

        Background.setBackground(new Color(0, 0, 0));
        Background.setForeground(new Color(255, 255, 255));
        Background.setFont(new Font("Times New Roman", 3, 48)); // NOI18N

        Title.setBackground(new Color(0, 0, 0));
        Title.setFont(new Font("Times New Roman", 3, 36)); // NOI18N
        Title.setForeground(new Color(255, 255, 255));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setText("Ultimate Tic-Tac-Toe");
        Title.setHorizontalTextPosition(SwingConstants.CENTER);

        Board.setBackground(new Color(255, 255, 255));
        Board.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        Board.setPreferredSize(new Dimension(426, 426));
        Board.setLayout(new GridLayout(3, 3, 8, 8));

        for (int i = 0; i < 9; i++) {
            final int boardIndex = i;
            Subboard[boardIndex] = new JLayeredPane();
            Subboard[boardIndex].setBackground(new Color(0, 0, 0));
            Subboard[boardIndex].setForeground(new Color(255, 255, 255));
            Subboard[boardIndex].setPreferredSize(new Dimension(124, 124));

            SubBack[boardIndex] = new JPanel();
            SubBack[boardIndex].setBackground(new Color(0, 0, 0));
            SubBack[boardIndex].setForeground(new Color(255, 255, 255));
            SubBack[boardIndex].setFont(new Font("Tahoma", 1, 12)); // NOI18N
            SubBack[boardIndex].setPreferredSize(new Dimension(124, 124));
            SubBack[boardIndex].setLayout(new GridLayout(3, 3, 4, 4));

            for (int j = 0; j < 9; j++) {
                final int pos = j;
                Positions[boardIndex][pos] = new JButton(" ");
                Positions[boardIndex][pos].setBackground(new Color(255, 255, 255));
                Positions[boardIndex][pos].setFont(new Font("Tahoma", 1, 12)); // NOI18N
                Positions[boardIndex][pos].setHorizontalTextPosition(SwingConstants.CENTER);
                Positions[boardIndex][pos].addActionListener((ActionEvent evt) -> {
                    PositionsActionPerformed(boardIndex, pos, evt);
                });
                SubBack[boardIndex].add(Positions[boardIndex][pos]);
            }
            BoardWinner[boardIndex] = new JLayeredPane();
            BoardWinner[boardIndex].setPreferredSize(new Dimension(124, 124));

            Winner[boardIndex] = new JLabel(" ");
            Winner[boardIndex].setFont(new Font("Tahoma", 1, 48)); // NOI18N
            Winner[boardIndex].setForeground(new Color(255, 255, 255));
            Winner[boardIndex].setHorizontalAlignment(SwingConstants.CENTER);
            Winner[boardIndex].setLabelFor(BoardWinner[boardIndex]);
            Winner[boardIndex].setHorizontalTextPosition(SwingConstants.CENTER);
            Winner[boardIndex].setPreferredSize(new Dimension(124, 124));

            BoardWinner[boardIndex].setLayer(Winner[boardIndex], JLayeredPane.DEFAULT_LAYER);
            
            GroupLayout BoardWinnerLayout = new GroupLayout(BoardWinner[boardIndex]);
            BoardWinner[boardIndex].setLayout(BoardWinnerLayout);
            BoardWinnerLayout.setHorizontalGroup(
                BoardWinnerLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(BoardWinnerLayout.createSequentialGroup()
                    .addComponent(Winner[boardIndex], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            BoardWinnerLayout.setVerticalGroup(
                BoardWinnerLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(Winner[boardIndex], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            
            Subboard[boardIndex].setLayer(SubBack[boardIndex], JLayeredPane.DEFAULT_LAYER);
            Subboard[boardIndex].setLayer(BoardWinner[boardIndex], JLayeredPane.DEFAULT_LAYER);
            
            GroupLayout SubboardLayout = new GroupLayout(Subboard[boardIndex]);
            Subboard[boardIndex].setLayout(SubboardLayout);
            SubboardLayout.setHorizontalGroup(
                SubboardLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(SubboardLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(BoardWinner[boardIndex], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(SubboardLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(SubboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SubBack[boardIndex], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
            
            SubboardLayout.setVerticalGroup(
                SubboardLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(SubboardLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(BoardWinner[boardIndex], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(SubboardLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(SubboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SubBack[boardIndex], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()))
            );

            Board.add(Subboard[boardIndex]);
        }

        Turns.setBackground(new java.awt.Color(0, 0, 0));
        Turns.setForeground(new java.awt.Color(255, 255, 255));

        TurnIndicator.setBackground(new java.awt.Color(0, 0, 0));
        TurnIndicator.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        TurnIndicator.setForeground(new java.awt.Color(255, 255, 255));
        TurnIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TurnIndicator.setLabelFor(Turns);
        TurnIndicator.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TurnIndicator.setPreferredSize(new java.awt.Dimension(414, 70));

        javax.swing.GroupLayout TurnsLayout = new javax.swing.GroupLayout(Turns);
        Turns.setLayout(TurnsLayout);
        TurnsLayout.setHorizontalGroup(
            TurnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TurnsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TurnIndicator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        TurnsLayout.setVerticalGroup(
            TurnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TurnsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TurnIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout BackgroundLayout = new GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(Title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(Board, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Turns, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(Turns, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(Board, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Background, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Background, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void PositionsActionPerformed(int curr, int pos, ActionEvent evt) {                                          
        // TODO add your handling code here:
		// makes a move in subBoard[curr]
        while (true) {
            if (subBoards[curr].validMove(pos)) {
                subBoards[curr].move(pos, player);
                Positions[curr][pos].setText(player);
                break;
            }
        }

    	//check to see if the board that was just played in reached an end state and play to the corresponding bigBoard cell
    	//will glitch if checkWin ever returns something outside of 0-3
        if (subBoards[curr].checkWin() == 3) {
            bigBoard.move(curr, "-");
            for (int i = 0; i < 9; i++) {
                Positions[curr][i].setEnabled(false);
                Positions[curr][i].setVisible(false);
            }
            Winner[curr].setText("-");
        } else if (subBoards[curr].checkWin() != 0) {
            bigBoard.move(curr, player);
            for (int i = 0; i < 9; i++) {
                Positions[curr][i].setEnabled(false);
                Positions[curr][i].setVisible(false);
            }
            Winner[curr].setText(player);
        }

    	//changes parameters for next turn
        if (player.equals("X")) {
            player = "O";
        } else {
            player = "X";
        }
        curr = pos;

        if (!bigBoard.validMove(curr)) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Positions[i][j].setBackground(new Color(255, 255, 255));
                    Positions[i][j].setEnabled(true);
                }
            }
            for (int i = 0; i < 9; i++) {
                Positions[curr][i].setBackground(new Color(127, 127, 127));
                Positions[curr][i].setEnabled(false);
            }
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Positions[i][j].setBackground(new Color(127, 127, 127));
                    Positions[i][j].setEnabled(false);
                }
            }
            for (int i = 0; i < 9; i++) {
                Positions[curr][i].setBackground(new Color(255, 255, 255));
                Positions[curr][i].setEnabled(true);
            }
        }

        TurnIndicator.setText(player + "'s turn");

        // show the winner
        switch (bigBoard.checkWin()) {
            case 1:
                JOptionPane.showMessageDialog(this, "X WINS! GAME OVER YEAH!!!");
                System.exit(0);
            case 2:
                JOptionPane.showMessageDialog(this, "O WINS! GAME OVER YEAH!!!");
                System.exit(0);
            case 3:
                JOptionPane.showMessageDialog(this, "NO WINNER! GAME OVER YEAH!!!");
                System.exit(0);
        }
    }                                                                                  

    // Variables declaration - do not modify                     
    protected JPanel Background;
    protected JPanel Board;
    protected JLayeredPane[] BoardWinner;
    protected JButton[][] Positions;
    protected JPanel[] SubBack;
    protected JLayeredPane[] Subboard;
    protected JLabel Title;
    protected JLabel TurnIndicator;
    protected JPanel Turns;
    protected JLabel[] Winner;
    // End of variables declaration                   
}
