import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class square will hold each individual cell on the chess board
public class Square extends JButton implements ActionListener {
    protected int[] coord = new int[2];
    // protected String color;
    protected String id;
    protected boolean isOccupied = false;
    boolean isSelected = false;

    Square() {
        this.id = null;
    }

    Square(int[] vector, String id) {
        this.coord = vector;
        // this.color = color;
        this.id = id;
        addActionListener(this);
    }
    // setcolor called for initialization of board

    /*
     * void setColor() {
     * if (color == "GREEN") {
     * setBackground(Color.GREEN);
     * } else {
     * setBackground(Color.BLUE);
     * }
     * }
     */

    // returns coordinate array
    int[] getCoord() {
        return this.coord;
    }

    // setIsOcuppied, sets flag if imageicon (piece) is present on square
    void setIsOccupied(boolean isCurrentlyOccupied) {
        System.out.println("here is set is occupied method : " + isCurrentlyOccupied);
        isOccupied = isCurrentlyOccupied;
    }

    // getIsOccupied, grabs returns the isOccupied flag
    boolean getIsOccupied() {
        return this.isOccupied;
    }

    void setIsSelected(boolean selection) {
        this.isSelected = selection;
    }

    boolean getIsSelected() {
        return this.isSelected;
    }

    /**
     * Getter method that returns the unique id of square, corresponds to id of
     * chessboard square
     * 
     * @author Alexander Jack
     * 
     * @return id
     */
    String getId() {
        return this.id;
    }

    // onclick button displays its id
    @Override
    public void actionPerformed(final ActionEvent e) {
        setIsSelected(true);
    }

}