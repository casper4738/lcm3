/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
package lcm.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author casper
 */
public class IPanelIshihara extends JPanel {

    private BufferedImage bufferedImage;
    private final DecimalFormat format;
    private final String[] type;

    public IPanelIshihara() {
        format = new DecimalFormat("#00");
        type = new String[38];

        for (int i = 0; i < 25; i++) {
            type[i] = "number";
        }
        for (int i = 25; i < 38; i++) {
            type[i] = "line";
        }

        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream("/lcm/plate/Ishihara Plate " + format.format(1) + "-38.png"));
        } catch (IOException ex) {
        }
    }

    public String[] getType() {
        return type;
    }

    public void setPlate(int i) {
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream("/lcm/plate/Ishihara Plate " + format.format(i + 1) + "-38.png"));
            repaint();
        } catch (IOException ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
    }

}
