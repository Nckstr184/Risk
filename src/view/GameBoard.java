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

import model.CardCollection;
import model.Continent;
import model.GameLogic;
import model.Player;
import model.Territory;

public class GameBoard extends JPanel {

	HashMap<JButton, JLabel> myMap;
	ArrayList<Continent> continents;
	ArrayList<Territory> territories;
	BufferedImage map, bottomDisplay, leftDisplay, rightDisplay;
	Player player1, player2, player3, player4, player5, player6;

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
	JButton wilberWildcat, wilmaWildcat, richWildcat, millerWildcat, scoobyWildcat, mckaleWildcat, zonaWildcat;
	JLabel wildcatLabel1, wildcatLabel2, wildcatLabel3, wildcatLabel4, wildcatLabel5, wildcatLabel6, wildcatLabel7;
	int wilberUnits, wilmaUnits, richUnits, millerUnits, scoobyUnits, mckaleUnits, zonaUnits;

	JButton papajohnsPizza, dominosPizza, pizzahutPizza, blackjackPizza, hungryhowiesPizza, brooklynPizza,
			pizzaplanetPizza;
	JLabel pizzaLabel1, pizzaLabel2, pizzaLabel3, pizzaLabel4, pizzaLabel5, pizzaLabel6, pizzaLabel7;
	int pjUnits, domUnits, phUnits, bjUnits, hhUnits, bUnits, ppUnits;

	JButton rawrvilleDino, laieggesDino, dactilitoDino, dirtydanDino, blackbeardDino, monisaurusDino, toystoryDino;
	JLabel dinoLabel1, dinoLabel2, dinoLabel3, dinoLabel4, dinoLabel5, dinoLabel6, dinoLabel7;
	int rawrUnits, eggUnits, dacUnits, danUnits, bbUnits, moniUnits, tsUnits;

	JButton scraptopiaCresent, landofzachCresent, giantCresent, newlandofzachCresent, southscraptopiaCresent,
			bloobawlCresent, cresentcaptitalCresent;
	JLabel cresentLabel1, cresentLabel2, cresentLabel3, cresentLabel4, cresentLabel5, cresentLabel6, cresentLabel7;
	int scrapUnits, zachUnits, giantUnits, newzachUnits, southUnits, blooUnits, capUnits;

	JButton apolloSun, raSun, heliosSun, intiSun, horusSun, tonatiuhSun, amunSun;
	JLabel sunLabel1, sunLabel2, sunLabel3, sunLabel4, sunLabel5, sunLabel6, sunLabel7;
	int apolloUnits, raUnits, heliosUnits, intiUnits, horusUnits, tonatiuhUnits, amunUnits;

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
					map = ImageIO.read(new File("./Pictures/map1.png"));
					bottomDisplay = ImageIO.read(new File("./Pictures/gui1.png"));
					leftDisplay = ImageIO.read(new File("./Pictures/gui2.png"));
					rightDisplay = ImageIO.read(new File("./Pictures/gui2.png"));

					JLabel picLabel = new JLabel(new ImageIcon(map));
					JLabel bottomLabel = new JLabel(new ImageIcon(bottomDisplay));
					JLabel leftLabel = new JLabel(new ImageIcon(leftDisplay));
					JLabel rightLabel = new JLabel(new ImageIcon(rightDisplay));
					System.out.println("NUMBER OF PLAYERS: " + startWindow.getNumberOfPlayer());
					playerTags();
					this.setLayout(new BorderLayout());
					startNewGame();
					addButtons();

					add(picLabel, BorderLayout.NORTH);
					add(leftLabel, BorderLayout.WEST);
					add(rightLabel, BorderLayout.EAST);

					add(bottomLabel, BorderLayout.SOUTH);

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

	private void startNewGame() {
		GameLogic newGame = new GameLogic();
		CardCollection newDeck = new CardCollection();
		newDeck.shuffle();

		if (startWindow.getNumberOfPlayer() == 6) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);
			newGame.addPlayers(startWindow.playerThree);
			newGame.addPlayers(startWindow.playerFour);
			newGame.addPlayers(startWindow.playerFive);
			newGame.addPlayers(startWindow.playerSix);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);
			player5 = newGame.getPlayerAt(4);
			player6 = newGame.getPlayerAt(5);
		}
		if (startWindow.getNumberOfPlayer() == 5) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);
			newGame.addPlayers(startWindow.playerThree);
			newGame.addPlayers(startWindow.playerFour);
			newGame.addPlayers(startWindow.playerFive);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);
			player5 = newGame.getPlayerAt(4);

		}
		if (startWindow.getNumberOfPlayer() == 4) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);
			newGame.addPlayers(startWindow.playerThree);
			newGame.addPlayers(startWindow.playerFour);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);

		}
		if (startWindow.getNumberOfPlayer() == 3) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);
			newGame.addPlayers(startWindow.playerThree);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);

		}
		if (startWindow.getNumberOfPlayer() == 2) {
			newGame.addPlayers(startWindow.playerOne);
			newGame.addPlayers(startWindow.playerTwo);

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);

		}

		newGame.startGame();

		// newGame.startGame();

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

		/// ALL OF LAUNGUAGE***
		javaUnits = 0;
		pythonUnits = 0;
		cUnits = 0;
		sqlUnits = 0;
		rubyUnits = 0;
		gitUnits = 0;
		perlUnits = 0;

		for (Territory d : player1.getTerritories()) {
			if (d.getname() == "Wilma") {
				wilmaWildcat = new JButton(yellow);
			}
			if (d.getname() == "Zona") {
				zonaWildcat = new JButton(yellow);
			}
			if (d.getname() == "Wilber") {
				wilberWildcat = new JButton(yellow);
			}
			if (d.getname() == "Rich") {
				richWildcat = new JButton(yellow);
			}
			if (d.getname() == "Miller") {
				millerWildcat = new JButton(yellow);
			}
			if (d.getname() == "McKale") {
				mckaleWildcat = new JButton(yellow);
			}
			if (d.getname() == "Scooby") {
				scoobyWildcat = new JButton(yellow);
			}
			if (d.getname() == "Java") {
				javaLanguage = new JButton(yellow);
			}
			if (d.getname() == "Python") {
				pythonLanguage = new JButton(yellow);
			}
			if (d.getname() == "C") {
				cLanguage = new JButton(yellow);
			}
			if (d.getname() == "SQL") {
				sqlLanguage = new JButton(yellow);
			}
			if (d.getname() == "Ruby") {
				rubyLanguage = new JButton(yellow);
			}
			if (d.getname() == "Perl") {
				perlLanguage = new JButton(yellow);
			}
			if (d.getname() == "Git") {
				gitLanguage = new JButton(yellow);
			}
			if (d.getname() == "Papa Johns") {
				papajohnsPizza = new JButton(yellow);
			}
			if (d.getname() == "Dominos") {
				dominosPizza = new JButton(yellow);
			}
			if (d.getname() == "PizzaHut") {
				pizzahutPizza = new JButton(yellow);
			}
			if (d.getname() == "Black Jack") {
				blackjackPizza = new JButton(yellow);
			}
			if (d.getname() == "Hungry Howie's") {
				hungryhowiesPizza = new JButton(yellow);
			}
			if (d.getname() == "Brooklyn's") {
				brooklynPizza = new JButton(yellow);
			}
			if (d.getname() == "Pizza Planet") {
				pizzaplanetPizza = new JButton(yellow);
			}

		}

		for (Territory d : player2.getTerritories()) {
			if (d.getname() == "Wilma") {
				wilmaWildcat = new JButton(green);
			}
			if (d.getname() == "Zona") {
				zonaWildcat = new JButton(green);
			}
			if (d.getname() == "Wilber") {
				wilberWildcat = new JButton(green);
			}
			if (d.getname() == "Rich") {
				richWildcat = new JButton(green);
			}
			if (d.getname() == "Miller") {
				millerWildcat = new JButton(green);
			}
			if (d.getname() == "McKale") {
				mckaleWildcat = new JButton(green);
			}
			if (d.getname() == "Scooby") {
				scoobyWildcat = new JButton(green);
			}
			if (d.getname() == "Java") {
				javaLanguage = new JButton(green);
			}
			if (d.getname() == "Python") {
				pythonLanguage = new JButton(green);
			}
			if (d.getname() == "C") {
				cLanguage = new JButton(green);
			}
			if (d.getname() == "SQL") {
				sqlLanguage = new JButton(green);
			}
			if (d.getname() == "Ruby") {
				rubyLanguage = new JButton(green);
			}
			if (d.getname() == "Perl") {
				perlLanguage = new JButton(green);
			}
			if (d.getname() == "Git") {
				gitLanguage = new JButton(green);
			}
			if (d.getname() == "Papa Johns") {
				papajohnsPizza = new JButton(green);
			}
			if (d.getname() == "Dominos") {
				dominosPizza = new JButton(green);
			}
			if (d.getname() == "PizzaHut") {
				pizzahutPizza = new JButton(green);
			}
			if (d.getname() == "Black Jack") {
				blackjackPizza = new JButton(green);
			}
			if (d.getname() == "Hungry Howie's") {
				hungryhowiesPizza = new JButton(green);
			}
			if (d.getname() == "Brooklyn's") {
				brooklynPizza = new JButton(green);
			}
			if (d.getname() == "Pizza Planet") {
				pizzaplanetPizza = new JButton(green);
			}

		}

		for (Territory d : player3.getTerritories()) {
			if (d.getname() == "Wilma") {
				wilmaWildcat = new JButton(orange);
			}
			if (d.getname() == "Zona") {
				zonaWildcat = new JButton(orange);
			}
			if (d.getname() == "Wilber") {
				wilberWildcat = new JButton(orange);
			}
			if (d.getname() == "Rich") {
				richWildcat = new JButton(orange);
			}
			if (d.getname() == "Miller") {
				millerWildcat = new JButton(orange);
			}
			if (d.getname() == "McKale") {
				mckaleWildcat = new JButton(orange);
			}
			if (d.getname() == "Scooby") {
				scoobyWildcat = new JButton(orange);
			}
			if (d.getname() == "Java") {
				javaLanguage = new JButton(orange);
			}
			if (d.getname() == "Python") {
				pythonLanguage = new JButton(orange);
			}
			if (d.getname() == "C") {
				cLanguage = new JButton(orange);
			}
			if (d.getname() == "SQL") {
				sqlLanguage = new JButton(orange);
			}
			if (d.getname() == "Ruby") {
				rubyLanguage = new JButton(orange);
			}
			if (d.getname() == "Perl") {
				perlLanguage = new JButton(orange);
			}
			if (d.getname() == "Git") {
				gitLanguage = new JButton(orange);
			}
			if (d.getname() == "Papa Johns") {
				papajohnsPizza = new JButton(orange);
			}
			if (d.getname() == "Dominos") {
				dominosPizza = new JButton(orange);
			}
			if (d.getname() == "PizzaHut") {
				pizzahutPizza = new JButton(orange);
			}
			if (d.getname() == "Black Jack") {
				blackjackPizza = new JButton(orange);
			}
			if (d.getname() == "Hungry Howie's") {
				hungryhowiesPizza = new JButton(orange);
			}
			if (d.getname() == "Brooklyn's") {
				brooklynPizza = new JButton(orange);
			}
			if (d.getname() == "Pizza Planet") {
				pizzaplanetPizza = new JButton(orange);
			}

		}
		for (Territory d : player4.getTerritories()) {
			if (d.getname() == "Wilma") {
				wilmaWildcat = new JButton(red);
			}
			if (d.getname() == "Zona") {
				zonaWildcat = new JButton(red);
			}
			if (d.getname() == "Wilber") {
				wilberWildcat = new JButton(red);
			}
			if (d.getname() == "Rich") {
				richWildcat = new JButton(red);
			}
			if (d.getname() == "Miller") {
				millerWildcat = new JButton(red);
			}
			if (d.getname() == "McKale") {
				mckaleWildcat = new JButton(red);
			}
			if (d.getname() == "Scooby") {
				scoobyWildcat = new JButton(red);
			}
			if (d.getname() == "Java") {
				javaLanguage = new JButton(red);
			}
			if (d.getname() == "Python") {
				pythonLanguage = new JButton(red);
			}
			if (d.getname() == "C") {
				cLanguage = new JButton(red);
			}
			if (d.getname() == "SQL") {
				sqlLanguage = new JButton(red);
			}
			if (d.getname() == "Ruby") {
				rubyLanguage = new JButton(red);
			}
			if (d.getname() == "Perl") {
				perlLanguage = new JButton(red);
			}
			if (d.getname() == "Git") {
				gitLanguage = new JButton(red);
			}
			if (d.getname() == "Papa Johns") {
				papajohnsPizza = new JButton(red);
			}
			if (d.getname() == "Dominos") {
				dominosPizza = new JButton(red);
			}
			if (d.getname() == "PizzaHut") {
				pizzahutPizza = new JButton(red);
			}
			if (d.getname() == "Black Jack") {
				blackjackPizza = new JButton(red);
			}
			if (d.getname() == "Hungry Howie's") {
				hungryhowiesPizza = new JButton(red);
			}
			if (d.getname() == "Brooklyn's") {
				brooklynPizza = new JButton(red);
			}
			if (d.getname() == "Pizza Planet") {
				pizzaplanetPizza = new JButton(red);
			}

		}
		for (Territory d : player5.getTerritories()) {
			if (d.getname() == "Wilma") {
				wilmaWildcat = new JButton(purple);
			}
			if (d.getname() == "Zona") {
				zonaWildcat = new JButton(purple);
			}
			if (d.getname() == "Wilber") {
				wilberWildcat = new JButton(purple);
			}
			if (d.getname() == "Rich") {
				richWildcat = new JButton(purple);
			}
			if (d.getname() == "Miller") {
				millerWildcat = new JButton(purple);
			}
			if (d.getname() == "McKale") {
				mckaleWildcat = new JButton(purple);
			}
			if (d.getname() == "Scooby") {
				scoobyWildcat = new JButton(purple);
			}
			if (d.getname() == "Java") {
				javaLanguage = new JButton(purple);
			}
			if (d.getname() == "Python") {
				pythonLanguage = new JButton(purple);
			}
			if (d.getname() == "C") {
				cLanguage = new JButton(purple);
			}
			if (d.getname() == "SQL") {
				sqlLanguage = new JButton(purple);
			}
			if (d.getname() == "Ruby") {
				rubyLanguage = new JButton(purple);
			}
			if (d.getname() == "Perl") {
				perlLanguage = new JButton(purple);
			}
			if (d.getname() == "Git") {
				gitLanguage = new JButton(purple);
			}
			if (d.getname() == "Papa Johns") {
				papajohnsPizza = new JButton(purple);
			}
			if (d.getname() == "Dominos") {
				dominosPizza = new JButton(purple);
			}
			if (d.getname() == "PizzaHut") {
				pizzahutPizza = new JButton(purple);
			}
			if (d.getname() == "Black Jack") {
				blackjackPizza = new JButton(purple);
			}
			if (d.getname() == "Hungry Howie's") {
				hungryhowiesPizza = new JButton(purple);
			}
			if (d.getname() == "Brooklyn's") {
				brooklynPizza = new JButton(purple);
			}
			if (d.getname() == "Pizza Planet") {
				pizzaplanetPizza = new JButton(purple);
			}

		}
		for (Territory d : player6.getTerritories()) {
			if (d.getname() == "Wilma") {
				wilmaWildcat = new JButton(blue);
			}
			if (d.getname() == "Zona") {
				zonaWildcat = new JButton(blue);
			}
			if (d.getname() == "Wilber") {
				wilberWildcat = new JButton(blue);
			}
			if (d.getname() == "Rich") {
				richWildcat = new JButton(blue);
			}
			if (d.getname() == "Miller") {
				millerWildcat = new JButton(blue);
			}
			if (d.getname() == "McKale") {
				mckaleWildcat = new JButton(blue);
			}
			if (d.getname() == "Scooby") {
				scoobyWildcat = new JButton(blue);
			}
			if (d.getname() == "Java") {
				javaLanguage = new JButton(blue);
			}
			if (d.getname() == "Python") {
				pythonLanguage = new JButton(blue);
			}
			if (d.getname() == "C") {
				cLanguage = new JButton(blue);
			}
			if (d.getname() == "SQL") {
				sqlLanguage = new JButton(blue);
			}
			if (d.getname() == "Ruby") {
				rubyLanguage = new JButton(blue);
			}
			if (d.getname() == "Perl") {
				perlLanguage = new JButton(blue);
			}
			if (d.getname() == "Git") {
				gitLanguage = new JButton(blue);
			}
			if (d.getname() == "Papa Johns") {
				papajohnsPizza = new JButton(blue);
			}
			if (d.getname() == "Dominos") {
				dominosPizza = new JButton(blue);
			}
			if (d.getname() == "PizzaHut") {
				pizzahutPizza = new JButton(blue);
			}
			if (d.getname() == "Black Jack") {
				blackjackPizza = new JButton(blue);
			}
			if (d.getname() == "Hungry Howie's") {
				hungryhowiesPizza = new JButton(blue);
			}
			if (d.getname() == "Brooklyn's") {
				brooklynPizza = new JButton(blue);
			}
			if (d.getname() == "Pizza Planet") {
				pizzaplanetPizza = new JButton(blue);
			}

		}

		languageLabel1 = new JLabel("" + javaUnits);
		languageLabel2 = new JLabel("" + pythonUnits);
		languageLabel3 = new JLabel("" + cUnits);
		languageLabel4 = new JLabel("" + sqlUnits);
		languageLabel5 = new JLabel("" + rubyUnits);
		languageLabel6 = new JLabel("" + gitUnits);
		languageLabel7 = new JLabel("" + perlUnits);

		javaLanguage.addActionListener(new buttonListener());
		pythonLanguage.addActionListener(new buttonListener());
		cLanguage.addActionListener(new buttonListener());
		sqlLanguage.addActionListener(new buttonListener());
		rubyLanguage.addActionListener(new buttonListener());
		gitLanguage.addActionListener(new buttonListener());
		perlLanguage.addActionListener(new buttonListener());

		javaLanguage.setSize(25, 25);
		javaLanguage.setLocation(720, 100);
		javaLanguage.setOpaque(false);
		javaLanguage.setContentAreaFilled(false);
		javaLanguage.setBorderPainted(false);

		languageLabel1.setSize(25, 25);
		languageLabel1.setFont(font);
		languageLabel1.setForeground(Color.WHITE);
		languageLabel1.setLocation(728, 103);
		languageLabel1.setOpaque(false);

		pythonLanguage.setSize(25, 25);
		pythonLanguage.setLocation(840, 85);
		pythonLanguage.setOpaque(false);
		pythonLanguage.setContentAreaFilled(false);
		pythonLanguage.setBorderPainted(false);

		languageLabel2.setSize(25, 25);
		languageLabel2.setFont(font);
		languageLabel2.setForeground(Color.WHITE);
		languageLabel2.setLocation(848, 88);
		languageLabel2.setOpaque(false);

		cLanguage.setSize(25, 25);
		cLanguage.setLocation(725, 145);
		cLanguage.setOpaque(false);
		cLanguage.setContentAreaFilled(false);
		cLanguage.setBorderPainted(false);

		languageLabel3.setSize(25, 25);
		languageLabel3.setFont(font);
		languageLabel3.setForeground(Color.WHITE);
		languageLabel3.setLocation(733, 148);
		languageLabel3.setOpaque(false);

		sqlLanguage.setSize(25, 25);
		sqlLanguage.setLocation(800, 110);
		sqlLanguage.setOpaque(false);
		sqlLanguage.setContentAreaFilled(false);
		sqlLanguage.setBorderPainted(false);

		languageLabel4.setSize(25, 25);
		languageLabel4.setFont(font);
		languageLabel4.setForeground(Color.WHITE);
		languageLabel4.setLocation(808, 113);
		languageLabel4.setOpaque(false);

		rubyLanguage.setSize(25, 25);
		rubyLanguage.setLocation(780, 165);
		rubyLanguage.setOpaque(false);
		rubyLanguage.setContentAreaFilled(false);
		rubyLanguage.setBorderPainted(false);

		languageLabel5.setSize(25, 25);
		languageLabel5.setFont(font);
		languageLabel5.setForeground(Color.WHITE);
		languageLabel5.setLocation(788, 168);
		languageLabel5.setOpaque(false);

		gitLanguage.setSize(25, 25);
		gitLanguage.setLocation(840, 140);
		gitLanguage.setOpaque(false);
		gitLanguage.setContentAreaFilled(false);
		gitLanguage.setBorderPainted(false);

		languageLabel6.setSize(25, 25);
		languageLabel6.setFont(font);
		languageLabel6.setForeground(Color.WHITE);
		languageLabel6.setLocation(848, 143);
		languageLabel6.setOpaque(false);

		perlLanguage.setSize(25, 25);
		perlLanguage.setLocation(890, 130);
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
		languageLabel7.setLocation(898, 133);
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

		// ALL OF WILDCAT***
		wilberUnits = 0;
		wilmaUnits = 0;
		richUnits = 0;
		millerUnits = 0;
		scoobyUnits = 0;
		mckaleUnits = 0;
		zonaUnits = 0;

		wildcatLabel1 = new JLabel("" + wilberUnits);
		wildcatLabel2 = new JLabel("" + wilmaUnits);
		wildcatLabel3 = new JLabel("" + richUnits);
		wildcatLabel4 = new JLabel("" + millerUnits);
		wildcatLabel5 = new JLabel("" + scoobyUnits);
		wildcatLabel6 = new JLabel("" + mckaleUnits);
		wildcatLabel7 = new JLabel("" + zonaUnits);

		wilberWildcat.addActionListener(new buttonListener());
		wilmaWildcat.addActionListener(new buttonListener());
		richWildcat.addActionListener(new buttonListener());
		millerWildcat.addActionListener(new buttonListener());
		scoobyWildcat.addActionListener(new buttonListener());
		mckaleWildcat.addActionListener(new buttonListener());
		zonaWildcat.addActionListener(new buttonListener());

		wilberWildcat.setSize(25, 25);
		wilberWildcat.setLocation(395, 305);
		wilberWildcat.setOpaque(false);
		wilberWildcat.setContentAreaFilled(false);
		wilberWildcat.setBorderPainted(false);

		wildcatLabel1.setSize(25, 25);
		wildcatLabel1.setFont(font);
		wildcatLabel1.setForeground(Color.WHITE);
		wildcatLabel1.setLocation(403, 308);
		wildcatLabel1.setOpaque(false);

		wilmaWildcat.setSize(25, 25);
		wilmaWildcat.setLocation(460, 300);
		wilmaWildcat.setOpaque(false);
		wilmaWildcat.setContentAreaFilled(false);
		wilmaWildcat.setBorderPainted(false);

		wildcatLabel2.setSize(25, 25);
		wildcatLabel2.setFont(font);
		wildcatLabel2.setForeground(Color.WHITE);
		wildcatLabel2.setLocation(468, 303);
		wildcatLabel2.setOpaque(false);

		richWildcat.setSize(25, 25);
		richWildcat.setLocation(520, 370);
		richWildcat.setOpaque(false);
		richWildcat.setContentAreaFilled(false);
		richWildcat.setBorderPainted(false);

		wildcatLabel3.setSize(25, 25);
		wildcatLabel3.setFont(font);
		wildcatLabel3.setForeground(Color.WHITE);
		wildcatLabel3.setLocation(528, 373);
		wildcatLabel3.setOpaque(false);

		millerWildcat.setSize(25, 25);
		millerWildcat.setLocation(560, 345);
		millerWildcat.setOpaque(false);
		millerWildcat.setContentAreaFilled(false);
		millerWildcat.setBorderPainted(false);

		wildcatLabel4.setSize(25, 25);
		wildcatLabel4.setFont(font);
		wildcatLabel4.setForeground(Color.WHITE);
		wildcatLabel4.setLocation(568, 348);
		wildcatLabel4.setOpaque(false);

		scoobyWildcat.setSize(25, 25);
		scoobyWildcat.setLocation(380, 380);
		scoobyWildcat.setOpaque(false);
		scoobyWildcat.setContentAreaFilled(false);
		scoobyWildcat.setBorderPainted(false);

		wildcatLabel5.setSize(25, 25);
		wildcatLabel5.setFont(font);
		wildcatLabel5.setForeground(Color.WHITE);
		wildcatLabel5.setLocation(388, 383);
		wildcatLabel5.setOpaque(false);

		mckaleWildcat.setSize(25, 25);
		mckaleWildcat.setLocation(450, 380);
		mckaleWildcat.setOpaque(false);
		mckaleWildcat.setContentAreaFilled(false);
		mckaleWildcat.setBorderPainted(false);

		wildcatLabel6.setSize(25, 25);
		wildcatLabel6.setFont(font);
		wildcatLabel6.setForeground(Color.WHITE);
		wildcatLabel6.setLocation(458, 383);
		wildcatLabel6.setOpaque(false);

		zonaWildcat.setSize(25, 25);
		zonaWildcat.setLocation(450, 435);
		zonaWildcat.setOpaque(false);
		zonaWildcat.setContentAreaFilled(false);
		zonaWildcat.setBorderPainted(false);

		myMap = new HashMap<JButton, JLabel>();
		myMap.put(wilberWildcat, wildcatLabel1);
		myMap.put(wilmaWildcat, wildcatLabel2);
		myMap.put(richWildcat, wildcatLabel3);
		myMap.put(millerWildcat, wildcatLabel4);
		myMap.put(scoobyWildcat, wildcatLabel5);
		myMap.put(mckaleWildcat, wildcatLabel6);
		myMap.put(zonaWildcat, wildcatLabel7);

		wildcatLabel7.setSize(25, 25);
		wildcatLabel7.setFont(font);
		wildcatLabel7.setForeground(Color.WHITE);
		wildcatLabel7.setLocation(458, 438);
		wildcatLabel7.setOpaque(false);

		// add all lables
		this.add(wildcatLabel1);
		this.add(wildcatLabel2);
		this.add(wildcatLabel3);
		this.add(wildcatLabel4);
		this.add(wildcatLabel5);
		this.add(wildcatLabel6);
		this.add(wildcatLabel7);

		// add all buttons
		this.add(wilberWildcat);
		this.add(wilmaWildcat);
		this.add(richWildcat);
		this.add(millerWildcat);
		this.add(scoobyWildcat);
		this.add(mckaleWildcat);
		this.add(zonaWildcat);

		// ALL FOR PIZZA***
		pjUnits = 0;
		domUnits = 0;
		phUnits = 0;
		bjUnits = 0;
		hhUnits = 0;
		bUnits = 0;
		ppUnits = 0;

		pizzaLabel1 = new JLabel("" + pjUnits);
		pizzaLabel2 = new JLabel("" + domUnits);
		pizzaLabel3 = new JLabel("" + phUnits);
		pizzaLabel4 = new JLabel("" + bjUnits);
		pizzaLabel5 = new JLabel("" + hhUnits);
		pizzaLabel6 = new JLabel("" + bUnits);
		pizzaLabel7 = new JLabel("" + ppUnits);

		papajohnsPizza.addActionListener(new buttonListener());
		dominosPizza.addActionListener(new buttonListener());
		pizzahutPizza.addActionListener(new buttonListener());
		blackjackPizza.addActionListener(new buttonListener());
		hungryhowiesPizza.addActionListener(new buttonListener());
		brooklynPizza.addActionListener(new buttonListener());
		pizzaplanetPizza.addActionListener(new buttonListener());

		papajohnsPizza.setSize(25, 25);
		papajohnsPizza.setLocation(290, 265);
		papajohnsPizza.setOpaque(false);
		papajohnsPizza.setContentAreaFilled(false);
		papajohnsPizza.setBorderPainted(false);

		pizzaLabel1.setSize(25, 25);
		pizzaLabel1.setFont(font);
		pizzaLabel1.setForeground(Color.WHITE);
		pizzaLabel1.setLocation(298, 268);
		pizzaLabel1.setOpaque(false);

		dominosPizza.setSize(25, 25);
		dominosPizza.setLocation(360, 297);
		dominosPizza.setOpaque(false);
		dominosPizza.setContentAreaFilled(false);
		dominosPizza.setBorderPainted(false);

		pizzaLabel2.setSize(25, 25);
		pizzaLabel2.setFont(font);
		pizzaLabel2.setForeground(Color.WHITE);
		pizzaLabel2.setLocation(368, 300);
		pizzaLabel2.setOpaque(false);

		pizzahutPizza.setSize(25, 25);
		pizzahutPizza.setLocation(320, 263);
		pizzahutPizza.setOpaque(false);
		pizzahutPizza.setContentAreaFilled(false);
		pizzahutPizza.setBorderPainted(false);

		pizzaLabel3.setSize(25, 25);
		pizzaLabel3.setFont(font);
		pizzaLabel3.setForeground(Color.WHITE);
		pizzaLabel3.setLocation(328, 266);
		pizzaLabel3.setOpaque(false);

		blackjackPizza.setSize(25, 25);
		blackjackPizza.setLocation(306, 218);
		blackjackPizza.setOpaque(false);
		blackjackPizza.setContentAreaFilled(false);
		blackjackPizza.setBorderPainted(false);

		pizzaLabel4.setSize(25, 25);
		pizzaLabel4.setFont(font);
		pizzaLabel4.setForeground(Color.WHITE);
		pizzaLabel4.setLocation(315, 221);
		pizzaLabel4.setOpaque(false);

		hungryhowiesPizza.setSize(25, 25);
		hungryhowiesPizza.setLocation(368, 211);
		hungryhowiesPizza.setOpaque(false);
		hungryhowiesPizza.setContentAreaFilled(false);
		hungryhowiesPizza.setBorderPainted(false);

		pizzaLabel5.setSize(25, 25);
		pizzaLabel5.setFont(font);
		pizzaLabel5.setForeground(Color.WHITE);
		pizzaLabel5.setLocation(376, 214);
		pizzaLabel5.setOpaque(false);

		brooklynPizza.setSize(25, 25);
		brooklynPizza.setLocation(398, 234);
		brooklynPizza.setOpaque(false);
		brooklynPizza.setContentAreaFilled(false);
		brooklynPizza.setBorderPainted(false);

		pizzaLabel6.setSize(25, 25);
		pizzaLabel6.setFont(font);
		pizzaLabel6.setForeground(Color.WHITE);
		pizzaLabel6.setLocation(406, 237);
		pizzaLabel6.setOpaque(false);

		pizzaplanetPizza.setSize(25, 25);
		pizzaplanetPizza.setLocation(440, 201);
		pizzaplanetPizza.setOpaque(false);
		pizzaplanetPizza.setContentAreaFilled(false);
		pizzaplanetPizza.setBorderPainted(false);

		myMap = new HashMap<JButton, JLabel>();
		myMap.put(papajohnsPizza, pizzaLabel1);
		myMap.put(dominosPizza, pizzaLabel2);
		myMap.put(pizzahutPizza, pizzaLabel3);
		myMap.put(blackjackPizza, pizzaLabel4);
		myMap.put(hungryhowiesPizza, pizzaLabel5);
		myMap.put(brooklynPizza, pizzaLabel6);
		myMap.put(pizzaplanetPizza, pizzaLabel7);

		pizzaLabel7.setSize(25, 25);
		pizzaLabel7.setFont(font);
		pizzaLabel7.setForeground(Color.WHITE);
		pizzaLabel7.setLocation(448, 204);
		pizzaLabel7.setOpaque(false);

		// add all lables
		this.add(pizzaLabel1);
		this.add(pizzaLabel2);
		this.add(pizzaLabel3);
		this.add(pizzaLabel4);
		this.add(pizzaLabel5);
		this.add(pizzaLabel6);
		this.add(pizzaLabel7);

		// add all buttons
		this.add(papajohnsPizza);
		this.add(dominosPizza);
		this.add(pizzahutPizza);
		this.add(blackjackPizza);
		this.add(hungryhowiesPizza);
		this.add(brooklynPizza);
		this.add(pizzaplanetPizza);

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
				i = Integer.parseInt(curr);

				if (i < 20) {
					myLabel.setText("" + (i + 1));
				}

			}

		}

	}

}
