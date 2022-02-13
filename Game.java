
/**
 * <p>Represents the mechanics of the game
 *  
 * @author Alexander Jack
*/
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Game {
    static ArrayList<Square> initBoard() {
        final String[] letters = new String[] { "a", "b", "c", "d", "e", "f", "g", "h" };
        ArrayList<Square> squares = new ArrayList<Square>();
        int k;
        for (int i = 49; i >= 1; i--) {
            k = 0;
            for (int j = 1; j < 50; j++) {
                int rand = Utils.returnRandom();
                if (rand == 0) {
                    Forest square = new Forest(Utils.pointsToVector(i, j), "" + i + "," + j);
                    squares.add(square);
                } else {
                    Water square = new Water(Utils.pointsToVector(i, j), "" + i + "," + j);
                    squares.add(square);
                }
                // add latest square to squares list
                k++;
            }
        }
        return squares;
    }

    /**
     * Matches a square to exisiting list of squares by ID
     * 
     * @param squares (required) squares ArrayList of Square objects
     * @param id      (required) id of square to match
     * 
     *                <p>
     *                note that returns default square of id null if square id
     *                happens to not be found in the list
     * 
     * @author Alexander Jack
     * 
     */
    static Square getSquareById(ArrayList<Square> squares, String id) {
        for (Square square : squares) {
            if (id.equals(square.getId()))
                return square;
        }
        return new Square();
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Square> squares = initBoard();
        JFrame frame = new JFrame();
        String path = Paths.get(".").normalize().toAbsolutePath().toString() + "\\imgs\\";
        frame.setLayout(new BorderLayout());
        Board board = new Board();
        SidePanel sidePanel = new SidePanel();
        JPanel cl = new JPanel(new CardLayout());
        frame.add(cl);
        cl.add(board);
        cl.add(sidePanel);
        MenuBar menuBar = new MenuBar(board, sidePanel);
        frame.setJMenuBar(menuBar);
        for (Square square : squares) {
            // square.setColor();
            board.add(square);
        }
        Deer deer = new Deer(new ImageIcon(path + "\\deer.png"));
        // squares.get(0).add(deer);
        // squares.get(0).setIcon(deer.getImage());
        frame.setVisible(true);
        frame.setSize(450, 450);
        /*
         * Deer deer = new Deer();
         * squares.get(0).add(deer);
         */
        for (Square sqr : squares) {
            sqr.add(deer);
            sqr.setIcon(deer.getImage());
            sqr.revalidate();
            Thread.sleep(1000);
            sqr.setIcon(null);
            //
            // repaint();
        }
    }
}