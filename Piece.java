
/**
 * <p> Piece represents an abstract piece which all other pieces inherit from
 * 
 * @uathor Alexander Jack 
 * 
 */
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Piece extends JButton {

    public int[] coord = new int[2];
    // numMoves field to hold the number of times a piece has moved
    public int numMoves, rank;
    public String color;
    // isSelected decides whether or not user has selected given piece
    public boolean isSelected = false;
    public boolean isAttacking = false;
    // image will hold png of the piece image
    public ImageIcon image;

    // default constructor
    public Piece() {
    }

    public Piece(int[] vector, String color, ImageIcon image, int rank) {
        this.coord = vector;
        this.numMoves = 0;
        this.color = color;
        this.image = image;
        this.rank = rank;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

    }

    /*
     * Moves the piece
     */
    void move(Square currentPosition, Square selectedPosition) {
        if (isLegalMove(currentPosition.getCoord(), selectedPosition.getCoord())) {
            this.coord = selectedPosition.getCoord();
        }
    }

    boolean isLegalMove(int[] startPosition, int[] endPosition) {
        return true;
    }

    void setIsSelected(boolean clicked) {
        this.isSelected = clicked;
    }

    boolean getIsSelected() {
        return isSelected;
    }

    /*
     * returns the number of times a piece has moved
     */
    int getNumMoves() {
        return numMoves;
    }

    /*
     * increments the number of times that a piece has moved
     */
    void incNumMoves() {
        numMoves += 1;
    }

    boolean getIsAttacking() {
        return this.isAttacking;
    }

    void setIsAttacking(boolean isAttackingSquare) {
        this.isAttacking = isAttackingSquare;
    }

    /*
     * returns imageicon representation of the piece
     */
    ImageIcon getImage() {
        return image;
    }
}