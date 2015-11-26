package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Continent;

public class GameBoard extends JPanel {

	HashMap<JButton, JLabel> myMap;
	ArrayList<Continent> Continents;
	BufferedImage map, bottomDisplay, leftDisplay, rightDisplay;

	JPanel board, boardDisplay, boardInfo;
	JButton ter1;

	JFrame temp;
	JTextField bottomField;

	int javaUnits, pythonUnits, cUnits, sqlUnits, rubyUnits, gitUnits, perlUnits;// number
																					// on
																					// the
																					// circLanguagee
																					// for
																					// language
	JButton javaLanguage, pythonLanguage, cLanguage, sqlLanguage, rubyLanguage, gitLanguage, perlLanguage;// circLanguagee
																											// button
																											// for
																											// language
	JLabel languageLabel1, languageLabel2, languageLabel3, languageLabel4, languageLabel5, languageLabel6,
			languageLabel7;// number for language

	ImageIcon gray, red, blue, purple, orange, yellow, green;
	JLabel picLanguageabel;
	StartWindow startWindow;

	public GameBoard() {

		startWindow = new StartWindow();
		while (startWindow.isDisplayable()) {
			System.out.print("");

			if (!startWindow.isDisplayable()) {
				System.out.print("");
				this.setSize(1300, 750);
				this.setLocation(0, -5);

				try {
					map = ImageIO.read(new File("./Pictures/map.png"));
					bottomDisplay = ImageIO.read(new File("./Pictures/gui1.png"));
					leftDisplay = ImageIO.read(new File("./Pictures/gui2.png"));
					rightDisplay = ImageIO.read(new File("./Pictures/gui2.png"));

					JLabel picLabel = new JLabel(new ImageIcon(map));
					JLabel bottomLabel = new JLabel(new ImageIcon(bottomDisplay));
					JLabel leftLabel = new JLabel(new ImageIcon(leftDisplay));
					JLabel rightLabel = new JLabel(new ImageIcon(rightDisplay));

					playerTags();
					
					addButtons();

					add(picLabel, BorderLayout.NORTH);
					add(leftLabel, BorderLayout.WEST);
					add(rightLabel, BorderLayout.EAST);

					add(bottomLabel, BorderLayout.SOUTH);
					System.out.println("NUMBER OF PLAYERS: " + startWindow.getNumberOfPlayer());

				} catch (IOException e) {
					System.out.println("ERROR with map");
					e.printStackTrace();
				}

			}

		}
	}

	private void playerTags() {
		int numberOfPlayers;
		JLabel playerTag;
		numberOfPlayers = startWindow.getNumberOfPlayer();
		Font font = new Font("Verdana", Font.BOLD, 18);
		int count = 1;
		for (int i = 0; i < numberOfPlayers; i++) {
			playerTag = new JLabel("" + startWindow.getPlayerName(i));
			playerTag.setSize(150, 40);
			playerTag.setLocation(170 * count, 600);
			playerTag.setFont(font);
			playerTag.setForeground(startWindow.getPlayerColor(i));
			add(playerTag);
			// add(playerTag, BorderLayout.SOUTH);
			count++;
		}

	}

	private void addButtons() {
		gray = new ImageIcon("./Pictures/circle.png");
		red = new ImageIcon("./Pictures/rcircle.png");
		blue = new ImageIcon("./Pictures/bcircle.png");
		purple = new ImageIcon("./Pictures/pcircle.png");
		orange = new ImageIcon("./Pictures/ocircle.png");
		yellow = new ImageIcon("./Pictures/ycircle.png");
		green = new ImageIcon("./Pictures/gcircle.png");
		Font font = new Font("Serif", Font.BOLD, 20);

		javaUnits = 0;
		pythonUnits = 0;
		cUnits = 0;
		sqlUnits = 0;
		rubyUnits = 0;
		gitUnits = 0;
		perlUnits = 0;

		languageLabel1 = new JLabel("" + javaUnits);
		languageLabel2 = new JLabel("" + pythonUnits);
		languageLabel3 = new JLabel("" + cUnits);
		languageLabel4 = new JLabel("" + sqlUnits);
		languageLabel5 = new JLabel("" + rubyUnits);
		languageLabel6 = new JLabel("" + gitUnits);
		languageLabel7 = new JLabel("" + perlUnits);

		javaLanguage = new JButton(gray);
		pythonLanguage = new JButton(gray);
		cLanguage = new JButton(gray);
		sqlLanguage = new JButton(gray);
		rubyLanguage = new JButton(gray);
		gitLanguage = new JButton(gray);
		perlLanguage = new JButton(gray);

		javaLanguage.addActionListener(new buttonListener());
		pythonLanguage.addActionListener(new buttonListener());
		cLanguage.addActionListener(new buttonListener());
		sqlLanguage.addActionListener(new buttonListener());
		rubyLanguage.addActionListener(new buttonListener());
		gitLanguage.addActionListener(new buttonListener());
		perlLanguage.addActionListener(new buttonListener());

		javaLanguage.setSize(25, 25);
		javaLanguage.setLocation(520, 100);
		javaLanguage.setOpaque(false);
		javaLanguage.setContentAreaFilled(false);
		javaLanguage.setBorderPainted(false);

		languageLabel1.setSize(25, 25);
		languageLabel1.setFont(font);
		languageLabel1.setForeground(Color.WHITE);
		languageLabel1.setLocation(528, 103);
		languageLabel1.setOpaque(false);

		pythonLanguage.setSize(25, 25);
		pythonLanguage.setLocation(640, 85);
		pythonLanguage.setOpaque(false);
		pythonLanguage.setContentAreaFilled(false);
		pythonLanguage.setBorderPainted(false);

		languageLabel2.setSize(25, 25);
		languageLabel2.setFont(font);
		languageLabel2.setForeground(Color.WHITE);
		languageLabel2.setLocation(648, 88);
		languageLabel2.setOpaque(false);

		cLanguage.setSize(25, 25);
		cLanguage.setLocation(535, 145);
		cLanguage.setOpaque(false);
		cLanguage.setContentAreaFilled(false);
		cLanguage.setBorderPainted(false);

		languageLabel3.setSize(25, 25);
		languageLabel3.setFont(font);
		languageLabel3.setForeground(Color.WHITE);
		languageLabel3.setLocation(543, 148);
		languageLabel3.setOpaque(false);

		sqlLanguage.setSize(25, 25);
		sqlLanguage.setLocation(600, 110);
		sqlLanguage.setOpaque(false);
		sqlLanguage.setContentAreaFilled(false);
		sqlLanguage.setBorderPainted(false);

		languageLabel4.setSize(25, 25);
		languageLabel4.setFont(font);
		languageLabel4.setForeground(Color.WHITE);
		languageLabel4.setLocation(608, 113);
		languageLabel4.setOpaque(false);

		rubyLanguage.setSize(25, 25);
		rubyLanguage.setLocation(600, 165);
		rubyLanguage.setOpaque(false);
		rubyLanguage.setContentAreaFilled(false);
		rubyLanguage.setBorderPainted(false);

		languageLabel5.setSize(25, 25);
		languageLabel5.setFont(font);
		languageLabel5.setForeground(Color.WHITE);
		languageLabel5.setLocation(608, 168);
		languageLabel5.setOpaque(false);

		gitLanguage.setSize(25, 25);
		gitLanguage.setLocation(640, 140);
		gitLanguage.setOpaque(false);
		gitLanguage.setContentAreaFilled(false);
		gitLanguage.setBorderPainted(false);

		languageLabel6.setSize(25, 25);
		languageLabel6.setFont(font);
		languageLabel6.setForeground(Color.WHITE);
		languageLabel6.setLocation(648, 143);
		languageLabel6.setOpaque(false);

		perlLanguage.setSize(25, 25);
		perlLanguage.setLocation(690, 130);
		perlLanguage.setOpaque(false);
		perlLanguage.setContentAreaFilled(false);
		perlLanguage.setBorderPainted(false);

		myMap = new HashMap<JButton, JLabel>();
		myMap.put(perlLanguage, languageLabel7);
		myMap.put(javaLanguage, languageLabel1);
		myMap.put(pythonLanguage, languageLabel2);
		myMap.put(cLanguage, languageLabel3);
		myMap.put(sqlLanguage, languageLabel4);
		myMap.put(rubyLanguage, languageLabel5);
		myMap.put(gitLanguage, languageLabel6);

		languageLabel7.setSize(25, 25);
		languageLabel7.setFont(font);
		languageLabel7.setForeground(Color.WHITE);
		languageLabel7.setLocation(698, 133);
		languageLabel7.setOpaque(false);

		// add all lables
		this.add(languageLabel1);
		this.add(languageLabel2);
		this.add(languageLabel3);
		this.add(languageLabel4);
		this.add(languageLabel5);
		this.add(languageLabel6);
		this.add(languageLabel7);

		// add all buttons
		this.add(javaLanguage);
		this.add(pythonLanguage);
		this.add(cLanguage);
		this.add(sqlLanguage);
		this.add(rubyLanguage);
		this.add(gitLanguage);
		this.add(perlLanguage);
	}

	private void setGuiNotVisible() {
		this.setVisible(false);
	}

	private class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton myButton = (JButton) e.getSource();

			JLabel myLabel = myMap.get(myButton);
			myButton.setIcon(red);
			if (myLabel != null) {
				System.out.println("got label");
				String curr = myLabel.getText();

				Integer i = new Integer(10);

				i = Integer.getInteger(curr);
				// i = i + 1;
				// int myint = i.intValue() + 1;
				; // System.out.println("Curr: " + curr);
					// myLabel.setText(i.toString());

				i = Integer.parseInt(curr);
				// i = i + 1;
				// int myint = i.intValue() + 1;
				// System.out.println("Curr: " + curr);
				// myLabel.setText(i.toString());

				if (i < 20) {
					myLabel.setText("" + (i + 1));
				}

			}

		}

	}

}
