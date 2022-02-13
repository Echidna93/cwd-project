import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * deer models a deer moving around in the "landscape"
 * use overlay
 */
public class Deer extends JButton {
    public ImageIcon image;

    Deer(ImageIcon image) {
        this.image = image;
        // setBackground(Color.RED);
    }

    ImageIcon getImage() {
        return image;
    }
}