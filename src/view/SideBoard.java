package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBoard extends JPanel {

	BufferedImage sideBoard;

	public SideBoard() {
		this.setSize(400, 550);
		this.setLocation(-10, -125);

		try {
			sideBoard = ImageIO.read(new File("./Pictures/gui2n.png"));
			JLabel picLabel = new JLabel(new ImageIcon(sideBoard));
			add(picLabel);

			picLabel.setSize(400, 550);
			picLabel.setLocation(0, 100);
			this.setLayout(null);

		} catch (IOException e) {
			System.out.println("ERROR with map");
			e.printStackTrace();
		}

	}

}
