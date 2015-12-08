package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import demoSongPlayer.Play1Song;
import model.BattleLogic;
import model.Card;
import model.CardCollection;
import model.Continent;
import model.GameLogic;
import model.Player;
import model.PlayerCollection;
import model.Territory;
import typesOfPlayers.EasyAI;
import typesOfPlayers.HardAI;
import typesOfPlayers.MediumAI;

public class GameBoard extends JPanel {

	boolean beginReinforcementPhase, reinforcementPhase, attackPhase, fortifyPhase, javaAttacking, pythonAttacking,
			cAttacking, sqlAttacking, rubyAttacking, gitAttacking, perlAttacking, wilmaAttacking, wilberAttacking,
			millerAttacking, richAttacking, scoobyAttacking, zonaAttacking, mckaleAttacking, papaAttacking,
			dominosAttacking, brooklynsAttacking, pizzahutAttacking, blackjackAttacking, hungryhowiesAttacking,
			pizzaplanetAttacking, tonatiuhAttacking, apolloAttacking, horusAttacking, raAttacking, intiAttacking,
			heliosAttacking, amunAttacking, giantAttacking, scraptopiaAttacking, monisaurusAttacking,
			rawrvilleAttacking, laieggesAttacking, dactilitoAttacking, dirtydanAttacking, toystoryAttacking,
			blackbeardAttacking, crescentcapitalAttacking, newlandofzachAttacking, bloobawlAttacking,
			landofzachAttacking, southscraptopiaAttacking, pythonFortify, cFortify, sqlFortify, perlFortify,
			javaFortify, rubyFortify, gitFortify, giantFortify, horusFortify, wilberFortify, wilmaFortify, zonaFortify,
			richFortify, scoobyFortify, millerFortify, mckaleFortify, papaFortify, dominosFortify, pizzahutFortify,
			toystoryFortify, pizzaplanetFortify, blackjackFortify, hungryhowiesFortify, brooklynFortify, amunFortify,
			apolloFortify, heliosFortify, intiFortify, tonatiuhFortify, rawrFortify, laieggesFortify, dirtydanFortify,
			blackbeardFortify, dactilitoFortify, monisaurusFortify, landofzachFortify, newlandofzachFortify,
			scraptopiaFortify, southscraptopiaFortify, bloobawlFortify, crescentcapitalFortify, raFortify;
	HashMap<JButton, JLabel> myMap;
	ArrayList<Continent> continents;
	ArrayList<Territory> territories;
	BufferedImage map, bottomDisplay, leftDisplay, rightDisplay;
	Player player1, player2, player3, player4, player5, player6, currPlayer;

	JPanel board, boardDisplay, boardInfo;

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

	JButton fortifyButton, endTurnButton, turnInCardsButton;

	OpenNewMenu newgame1;

	GameLogic newGame;

	JLabel playerTag, playerTag2, playerTag3, playerTag4, playerTag5, playerTag6, playerCount, playerCount2,
			playerCount3, playerCount4, playerCount5, playerCount6, turnMarker, gameStatus, neighborsLabel;

	JLabel turnCountLabel;

	private int fortifyCount, unitsFortified;
	private FileInputStream inputStream;
	private ObjectInputStream objectInput;

	Play1Song playsong;
	String john, coin, bass, ass;

	private int turnCount;
	

	Font plyrTagFont;
	Font plyrCountFont;

	public GameBoard() {
		Player tempPlayer = null;

		reinforcementPhase = true;
		attackPhase = false;
		fortifyPhase = false;
		fortifyCount = 0;

		john = "./songs/Johnc.aiff";
		coin = "./songs/coin.aiff";
		bass = "./songs/Bass.aiff";
		ass = "./songs/ass.aiff";

		newgame1 = new OpenNewMenu();
		while (newgame1.isDisplayable()) {
			System.out.print("");

			if (!newgame1.isDisplayable()) {
				System.out.print("");

				startWindow = new StartWindow();

				// current = new Player();
				while (startWindow.isDisplayable()) {
					if (newgame1.isClicked()) {
						startWindow.dispose();

					}
					System.out.print("");

					if (!startWindow.isDisplayable()) {
						System.out.print("");
						this.setSize(1300, 750);
						this.setLocation(0, -5);

						playsong = new Play1Song(john);
						try {
							map = ImageIO.read(new File("./Pictures/mapwithlines1.png"));
							bottomDisplay = ImageIO.read(new File("./Pictures/bottomgui.png"));
							leftDisplay = ImageIO.read(new File("./Pictures/gui2n.png"));
							rightDisplay = ImageIO.read(new File("./Pictures/gui2n.png"));

							JLabel picLabel = new JLabel(new ImageIcon(map));
							JLabel bottomLabel = new JLabel(new ImageIcon(bottomDisplay));
							JLabel leftLabel = new JLabel(new ImageIcon(leftDisplay));
							JLabel rightLabel = new JLabel(new ImageIcon(rightDisplay));

							this.setLayout(new BorderLayout());

							if (!newgame1.isClicked()) {
								startNewGame();
							}
							startWindow.dispose();
							if (newgame1.isClicked()) {
								PlayerCollection tempPlayers = null;
								ArrayList<String> tempCards = null;
								ArrayList<Territory> tempTerritories = null;
								ArrayList<Continent> tempContinents = null;
								boolean reinforcementPhaseImport = true;
								int currentPlayerTurn=0;
								try {
									inputStream = new FileInputStream("savedGame");
									objectInput = new ObjectInputStream(inputStream);
									tempPlayers = (PlayerCollection) objectInput.readObject();
									tempCards = (ArrayList<String>) objectInput.readObject();
									tempTerritories = (ArrayList<Territory>) objectInput.readObject();
									tempContinents = (ArrayList<Continent>) objectInput.readObject();
									tempPlayer = (Player) objectInput.readObject();
									currentPlayerTurn = (Integer) objectInput.readObject();
									reinforcementPhaseImport = (boolean)objectInput.readObject();

									// printPlayersAndTheirTerritories(tempPlayers);
									currPlayer = tempPlayer;

								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									System.out.println("reading did not work");
									e.printStackTrace();
								}
								this.importGameLogic(tempPlayers, tempCards, tempContinents, tempTerritories,
										tempPlayer, reinforcementPhaseImport, currentPlayerTurn);
							}

							System.out.println("NUMBER OF PLAYERS: " + newGame.getNumOfPlayers());

							turnCount = newGame.getNumOfPlayers() * 20;
							playerTags();

							addButtons();
							if (!newgame1.isClicked()) {
								currPlayer = newGame.getPlayerAt(0);
							}
							add(picLabel, BorderLayout.CENTER);
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
		}
		updateLabels();
	}

	private void printPlayersAndTheirTerritories(PlayerCollection tempPlayers) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tempPlayers.getNumOfPlayers(); i++) {
			Player temp = tempPlayers.getPlayer(i);
			System.out.println("PLAYER " + temp.getName());
			for (int j = 0; j < temp.getTerritories().size(); j++) {
				Territory tempT = temp.getTerritories().get(j);
				System.out.println(tempT.getName());
			}
		}
	}

	private void playerTags() {
		int numberOfPlayers;

		numberOfPlayers = newGame.getNumOfPlayers();
		plyrTagFont = new Font("Verdana", Font.BOLD, 18);
		plyrCountFont = new Font("Verdana", Font.BOLD, 9);
		Font gameStatusFont = new Font("Verdana", Font.BOLD, 36);
		Font neighborsFont = new Font("Serif", Font.BOLD, 22);
		int count = 1;
		turnMarker = new JLabel();
		gameStatus = new JLabel();
		neighborsLabel = new JLabel();
		turnCountLabel = new JLabel();
		turnMarker.setText("IT'S YOUR TURN!!!");
		turnMarker.setForeground(Color.white);
		turnMarker.setFont(plyrCountFont);
		turnMarker.setSize(100, 20);
		turnMarker.setLocation(150, 590);
		gameStatus.setText("Deploy");
		gameStatus.setForeground(Color.white);
		gameStatus.setBackground(Color.BLACK);
		gameStatus.setFont(gameStatusFont);
		gameStatus.setSize(300, 50);
		gameStatus.setLocation(1110, 40);

		neighborsLabel.setSize(800, 100);
		neighborsLabel.setFont(neighborsFont);
		neighborsLabel.setLocation(250, 20);
		neighborsLabel.setForeground(Color.WHITE);

		turnCountLabel.setSize(200, 300);
		turnCountLabel.setFont(neighborsFont);
		turnCountLabel.setLocation(40, 300);
		turnCountLabel.setForeground(Color.WHITE);
		turnCountLabel.setText("Turns Left: " + turnCount);

		add(turnCountLabel);
		add(neighborsLabel);
		add(gameStatus);
		add(turnMarker);

		if (numberOfPlayers == 6) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
			playerTag3 = new JLabel(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(Color.orange);
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(Color.orange);
			add(playerCount3);
			playerTag4 = new JLabel(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(Color.red);
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(Color.red);
			add(playerCount4);
			playerTag5 = new JLabel(newGame.getPlayerAt(4).getName());
			playerTag5.setSize(150, 40);
			playerTag5.setLocation(830, 600);
			playerTag5.setFont(plyrTagFont);
			playerTag5.setForeground(Color.pink);
			add(playerTag5);
			playerCount5 = new JLabel("You have " + newGame.getPlayerAt(4).getNumOfArmies() + " units left to place!");
			playerCount5.setSize(200, 40);
			playerCount5.setLocation(800, 620);
			playerCount5.setFont(plyrCountFont);
			playerCount5.setForeground(Color.pink);
			add(playerCount5);
			playerTag6 = new JLabel(newGame.getPlayerAt(5).getName());
			playerTag6.setSize(150, 40);
			playerTag6.setLocation(1000, 600);
			playerTag6.setFont(plyrTagFont);
			playerTag6.setForeground(Color.blue);
			add(playerTag6);
			playerCount6 = new JLabel("You have " + newGame.getPlayerAt(5).getNumOfArmies() + " units left to place!");
			playerCount6.setSize(150, 40);
			playerCount6.setLocation(970, 620);
			playerCount6.setFont(plyrCountFont);
			playerCount6.setForeground(Color.blue);
			add(playerCount6);
		}
		if (numberOfPlayers == 5) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
			playerTag3 = new JLabel(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(Color.orange);
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(Color.orange);
			add(playerCount3);
			playerTag4 = new JLabel(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(Color.red);
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(Color.red);
			add(playerCount4);
			playerTag5 = new JLabel(newGame.getPlayerAt(4).getName());
			playerTag5.setSize(150, 40);
			playerTag5.setLocation(830, 600);
			playerTag5.setFont(plyrTagFont);
			playerTag5.setForeground(Color.pink);
			add(playerTag5);
			playerCount5 = new JLabel("You have " + newGame.getPlayerAt(4).getNumOfArmies() + " units left to place!");
			playerCount5.setSize(200, 40);
			playerCount5.setLocation(800, 620);
			playerCount5.setFont(plyrCountFont);
			playerCount5.setForeground(Color.pink);
			add(playerCount5);
		}
		if (numberOfPlayers == 4) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
			playerTag3 = new JLabel(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(Color.orange);
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(Color.orange);
			add(playerCount3);
			playerTag4 = new JLabel(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(Color.red);
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(Color.red);
			add(playerCount4);
		}
		if (numberOfPlayers == 3) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
			playerTag3 = new JLabel(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(Color.orange);
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(Color.orange);
			add(playerCount3);
		}
		if (numberOfPlayers == 2) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
		}
	}

	public void startOldGame() {
		int numberOfPlayers = newGame.getNumOfPlayers();
		System.out.println(numberOfPlayers);

		if (numberOfPlayers == 6) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);
			player5 = newGame.getPlayerAt(4);
			player6 = newGame.getPlayerAt(5);
		}
		if (numberOfPlayers == 5) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);
			player5 = newGame.getPlayerAt(4);

		}
		if (numberOfPlayers == 4) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);

		}
		if (numberOfPlayers == 3) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);

		}
		if (numberOfPlayers == 2) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);

		}

		newGame.startLoadedGame();
		territories = newGame.getTerritories();
	}

	public void startNewGame() {
		newGame = new GameLogic(startWindow.playerOne, startWindow.playerTwo, startWindow.playerThree,
				startWindow.playerFour, startWindow.playerFive, startWindow.playerSix);
		CardCollection newDeck = new CardCollection();
		newDeck.shuffle();

		if (startWindow.getNumberOfPlayer() == 6) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);
			player5 = newGame.getPlayerAt(4);
			player6 = newGame.getPlayerAt(5);
		}
		if (startWindow.getNumberOfPlayer() == 5) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);
			player5 = newGame.getPlayerAt(4);

		}
		if (startWindow.getNumberOfPlayer() == 4) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);
			player4 = newGame.getPlayerAt(3);

		}
		if (startWindow.getNumberOfPlayer() == 3) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);
			player3 = newGame.getPlayerAt(2);

		}
		if (startWindow.getNumberOfPlayer() == 2) {

			player1 = newGame.getPlayerAt(0);
			player2 = newGame.getPlayerAt(1);

		}

		newGame.startGame();
		territories = newGame.getTerritories();

	}

	public GameLogic getGameLogic() {
		return newGame;
	}

	public void importGameLogic(PlayerCollection newPlayers, ArrayList<String> newCards,
			ArrayList<Continent> newContinets, ArrayList<Territory> newTerritories, Player tempPlayer,
			boolean reinforcemnetPhaseImport, int currentPlayerTurn) {
		newGame = new GameLogic(null, null, null, null, null, null);
		newGame.setPlayerList(newPlayers);
		newGame.setCards(newCards);
		newGame.setTerritory(newTerritories);
		newGame.setContinents(newContinets);
		newGame.setPlayerTurn(currentPlayerTurn);
		System.out.println("current Player" + currPlayer.getName());
		currPlayer = tempPlayer;
		System.out.println("current Player" + currPlayer.getName());

		reinforcementPhase = reinforcemnetPhaseImport;
		newGame.startLoadedGame();
		this.startOldGame();
	}

	public Player getCurrentPlayer() {
		return currPlayer;
	}

	public PlayerCollection getPlayers() {
		return newGame.getPlayerList();
	}

	public ArrayList<String> getCards() {
		return newGame.getCards();
	}

	public ArrayList<Continent> getContinents() {
		return newGame.getContinents();
	}

	public ArrayList<Territory> getTerritories() {
		return newGame.getTerritories();
	}

	public void addButtons() {
		gray = new ImageIcon("./Pictures/circle.png");
		red = new ImageIcon("./Pictures/rcircle.png");
		blue = new ImageIcon("./Pictures/bcircle.png");
		purple = new ImageIcon("./Pictures/pcircle.png");
		orange = new ImageIcon("./Pictures/ocircle.png");
		yellow = new ImageIcon("./Pictures/ycircle.png");
		green = new ImageIcon("./Pictures/gcircle.png");
		Font font = new Font("Serif", Font.BOLD, 20);
		fortifyButton = new JButton();
		endTurnButton = new JButton();
		turnInCardsButton = new JButton();

		turnInCardsButton.setSize(150, 40);
		turnInCardsButton.setText("Card Turnin");
		turnInCardsButton.setLocation(1110, 340);

		fortifyButton.setSize(150, 40);
		fortifyButton.setText("Fortify");
		fortifyButton.setLocation(1110, 400);

		endTurnButton.setSize(150, 40);
		endTurnButton.setText("End Turn");
		endTurnButton.setLocation(1110, 460);

		endTurnButton.setEnabled(false);

		turnInCardsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel icons = new JPanel();
				for(int i=0;i<currPlayer.getCards().size();i++) {
					icons.add(new JLabel(currPlayer.getCardImages().get(i)));
				}
				String message = "";
				Object[] options = { "Turn in", "Return" };

				
				for(int j = 0; j < currPlayer.getCards().size();j++){
				System.out.println(currPlayer.getCards().get(j).getTerritory());
				}
				
				int choice = JOptionPane.showOptionDialog(null, icons , "Current Player's Cards",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				if (choice == 0) {
					if (newGame.turnInCard()) {
						message = "Cards successfully turned in";
					} else {
						message = "Cards cannot be turned in";
					}
					JOptionPane.showMessageDialog(null, message);
				}
			}
		});

		fortifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fortifyCount += 1;
				if (fortifyCount <= 1) {
					attackPhase = false;
					fortifyPhase = true;
					playerCount.setText("Fortify your armies!");
				}
			}
		});

		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fortifyCount = 0;
				fortifyPhase = false;
				attackPhase = true;
				reinforcementPhase = false;
				nextPlayer();
				moveTurnLabel();
			}
		});
		this.add(turnInCardsButton);
		this.add(fortifyButton);
		this.add(endTurnButton);

		if (newGame.getNumOfPlayers() == 6) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(yellow);
					amunSun.setName(newGame.getPlayerAt(0).getName());
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(green);
					richWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(green);
					millerWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(green);
					javaLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(green);
					cLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(green);
					perlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(green);
					gitLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(green);
					dominosPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(green);
					laieggesDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(green);
					toystoryDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(green);
					giantCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(green);
					apolloSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(green);
					raSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(green);
					heliosSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(green);
					intiSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(green);
					horusSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(green);
					tonatiuhSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(green);
					amunSun.setName(newGame.getPlayerAt(1).getName());
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(purple);
					wilmaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(purple);
					zonaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(purple);
					wilberWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(purple);
					richWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(purple);
					millerWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(purple);
					mckaleWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(purple);
					scoobyWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(purple);
					javaLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(purple);
					pythonLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(purple);
					cLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(purple);
					sqlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(purple);
					rubyLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(purple);
					perlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(purple);
					gitLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(purple);
					papajohnsPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(purple);
					dominosPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(purple);
					pizzahutPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(purple);
					blackjackPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(purple);
					hungryhowiesPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(purple);
					brooklynPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(purple);
					pizzaplanetPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(purple);
					rawrvilleDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(purple);
					laieggesDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(purple);
					dactilitoDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(purple);
					dirtydanDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(purple);
					blackbeardDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(purple);
					monisaurusDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(purple);
					toystoryDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(purple);
					scraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(purple);
					landofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(purple);
					giantCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(purple);
					newlandofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(purple);
					southscraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(purple);
					bloobawlCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(purple);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(purple);
					apolloSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(purple);
					raSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(purple);
					heliosSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(purple);
					intiSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(purple);
					horusSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(purple);
					tonatiuhSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(purple);
					amunSun.setName(newGame.getPlayerAt(4).getName());
				}
			}

			for (Territory d : player6.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(blue);
					wilmaWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(blue);
					zonaWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(blue);
					wilberWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(blue);
					richWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(blue);
					millerWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(blue);
					mckaleWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(blue);
					scoobyWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(blue);
					javaLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(blue);
					pythonLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(blue);
					cLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(blue);
					sqlLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(blue);
					rubyLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(blue);
					perlLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(blue);
					gitLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(blue);
					papajohnsPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(blue);
					dominosPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(blue);
					pizzahutPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(blue);
					blackjackPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(blue);
					hungryhowiesPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(blue);
					brooklynPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(blue);
					pizzaplanetPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(blue);
					rawrvilleDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(blue);
					laieggesDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(blue);
					dactilitoDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(blue);
					dirtydanDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(blue);
					blackbeardDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(blue);
					monisaurusDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(blue);
					toystoryDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(blue);
					scraptopiaCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(blue);
					landofzachCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(blue);
					giantCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(blue);
					newlandofzachCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(blue);
					southscraptopiaCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(blue);
					bloobawlCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(blue);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(blue);
					apolloSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(blue);
					raSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(blue);
					heliosSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(blue);
					intiSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(blue);
					horusSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(blue);
					tonatiuhSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(blue);
					amunSun.setName(newGame.getPlayerAt(5).getName());
				}
			}
		}
		if (newGame.getNumOfPlayers() == 5) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(yellow);
					amunSun.setName(newGame.getPlayerAt(0).getName());
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(green);
					richWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(green);
					millerWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(green);
					javaLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(green);
					cLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(green);
					perlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(green);
					gitLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(green);
					dominosPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(green);
					laieggesDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(green);
					toystoryDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(green);
					giantCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(green);
					apolloSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(green);
					raSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(green);
					heliosSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(green);
					intiSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(green);
					horusSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(green);
					tonatiuhSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(green);
					amunSun.setName(newGame.getPlayerAt(1).getName());
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(purple);
					wilmaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(purple);
					zonaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(purple);
					wilberWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(purple);
					richWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(purple);
					millerWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(purple);
					mckaleWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(purple);
					scoobyWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(purple);
					javaLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(purple);
					pythonLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(purple);
					cLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(purple);
					sqlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(purple);
					rubyLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(purple);
					perlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(purple);
					gitLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(purple);
					papajohnsPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(purple);
					dominosPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(purple);
					pizzahutPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(purple);
					blackjackPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(purple);
					hungryhowiesPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(purple);
					brooklynPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(purple);
					pizzaplanetPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(purple);
					rawrvilleDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(purple);
					laieggesDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(purple);
					dactilitoDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(purple);
					dirtydanDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(purple);
					blackbeardDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(purple);
					monisaurusDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(purple);
					toystoryDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(purple);
					scraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(purple);
					landofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(purple);
					giantCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(purple);
					newlandofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(purple);
					southscraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(purple);
					bloobawlCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(purple);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(purple);
					apolloSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(purple);
					raSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(purple);
					heliosSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(purple);
					intiSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(purple);
					horusSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(purple);
					tonatiuhSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(purple);
					amunSun.setName(newGame.getPlayerAt(4).getName());
				}
			}
		}

		if (newGame.getNumOfPlayers() == 4) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(yellow);
					amunSun.setName(newGame.getPlayerAt(0).getName());
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(green);
					richWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(green);
					millerWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(green);
					javaLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(green);
					cLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(green);
					perlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(green);
					gitLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(green);
					dominosPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(green);
					laieggesDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(green);
					toystoryDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(green);
					giantCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(green);
					apolloSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(green);
					raSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(green);
					heliosSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(green);
					intiSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(green);
					horusSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(green);
					tonatiuhSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(green);
					amunSun.setName(newGame.getPlayerAt(1).getName());
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}

		}
		if (newGame.getNumOfPlayers() == 3) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(yellow);
					amunSun.setName(newGame.getPlayerAt(0).getName());
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(green);
					wilmaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(green);
					zonaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(green);
					wilberWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(green);
					richWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(green);
					millerWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(green);
					mckaleWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(green);
					scoobyWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(green);
					javaLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(green);
					pythonLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(green);
					cLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(green);
					sqlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(green);
					rubyLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(green);
					perlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(green);
					gitLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(green);
					papajohnsPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(green);
					dominosPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(green);
					pizzahutPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(green);
					blackjackPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(green);
					hungryhowiesPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(green);
					brooklynPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(green);
					pizzaplanetPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(green);
					rawrvilleDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(green);
					laieggesDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(green);
					dactilitoDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(green);
					dirtydanDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(green);
					blackbeardDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(green);
					monisaurusDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(green);
					toystoryDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(green);
					scraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(green);
					landofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(green);
					giantCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(green);
					newlandofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(green);
					southscraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(green);
					bloobawlCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(green);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(green);
					apolloSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(green);
					raSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(green);
					heliosSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(green);
					intiSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(green);
					horusSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(green);
					tonatiuhSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(green);
					amunSun.setName(newGame.getPlayerAt(1).getName());
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat = new JButton(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage = new JButton(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent = new JButton(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun = new JButton(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun = new JButton(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun = new JButton(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun = new JButton(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun = new JButton(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun = new JButton(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}
		}

		if (!newgame1.isClicked()) {
			nextPlayer();
		}

		javaLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				javaAttacking = false;
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && javaLanguage.getName().equals(currPlayer.getName())) {
						javaUnits += 1;
						territories.get(0).addUnits(1);
						languageLabel1.setText("" + javaUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);
						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (javaLanguage.getName().equals(currPlayer.getName()))) {
					javaUnits += 1;
					territories.get(0).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
					
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((javaLanguage.getName().equals(currPlayer.getName())) && (javaUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						//
						javaAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(0)));

					}
				}
				if (javaAttacking == true && (currPlayer.getName() == javaLanguage.getName())) {
					System.out.println("Java stopped attacking");
					javaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				
				if (pythonAttacking == true && (currPlayer.getName() != javaLanguage.getName())) {
					System.out.println("Java was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(0));
					pythonAttacking = false;
					attackPhase = true;
				}

				if (sqlAttacking == true && (currPlayer.getName() != javaLanguage.getName())) {
					System.out.println("Java was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(0));
					sqlAttacking = false;
					attackPhase = true;
				}
				if (cAttacking == true && (currPlayer.getName() != javaLanguage.getName())) {
					System.out.println("Java was attacked by c");
					gameBoardAttack(territories.get(2), territories.get(0));
					cAttacking = false;
					attackPhase = true;
				}
				if (heliosAttacking == true && (currPlayer.getName() != javaLanguage.getName())) {
					System.out.println("Java was attacked by Horius");
					gameBoardAttack(territories.get(39), territories.get(0));
					heliosAttacking = false;
					attackPhase = true;
				}

				if ((pythonFortify == true) && (currPlayer.getName() == javaLanguage.getName())) {
					territories.get(0).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
				}
				if ((sqlFortify == true) && (currPlayer.getName() == javaLanguage.getName())) {
					territories.get(0).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
				}
				if ((cFortify == true) && (currPlayer.getName() == javaLanguage.getName())) {
					territories.get(0).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					cFortify = false;
				}
				if ((horusFortify == true) && (currPlayer.getName() == javaLanguage.getName())) {
					territories.get(0).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == javaLanguage.getName()) {
						System.out.println("fortify from java!!!");

						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(0)));

						Object[] range = new Object[territories.get(0).getUnits()];
						for (int i = 1; i < territories.get(0).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(0).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						javaFortify = true;
					}
				}
			}

		});

		pythonLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();

				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && pythonLanguage.getName().equals(currPlayer.getName())) {
						pythonUnits += 1;
						territories.get(1).addUnits(1);
						myLabel.setText("" + pythonUnits);
						currPlayer.removeArmies(1);


						playsong = new Play1Song(coin);

						nextPlayer();
					}

					checkIfReinforcementPhaseIsOver();

				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (pythonLanguage.getName().equals(currPlayer.getName()))) {
					pythonUnits += 1;
					territories.get(1).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}

				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((pythonLanguage.getName().equals(currPlayer.getName())) && (pythonUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						//
						pythonAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(1)));

					}
				}
				if (pythonAttacking == true && (currPlayer.getName() == pythonLanguage.getName())) {
					pythonAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if (javaAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked");
					gameBoardAttack(territories.get(0), territories.get(1));
					javaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (sqlAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(1));
					sqlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (cAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked by c");
					gameBoardAttack(territories.get(2), territories.get(1));
					cAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (gitAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked by git");
					gameBoardAttack(territories.get(5), territories.get(1));
					gitAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (perlAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked by perl");
					gameBoardAttack(territories.get(6), territories.get(1));
					perlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((perlFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					perlFortify = false;
					neighborsLabel.setText("");
				}
				if ((gitFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					gitFortify = false;
					neighborsLabel.setText("");
				}
				if ((cFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					cFortify = false;
					neighborsLabel.setText("");
				}
				if ((sqlFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
					neighborsLabel.setText("");
				}
				if ((javaFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					javaFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == pythonLanguage.getName()) {
						System.out.println("fortify from python!!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(1)));
						Object[] range = new Object[territories.get(1).getUnits()];
						for (int i = 1; i < territories.get(1).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(1).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						pythonFortify = true;
					}
				}
			}
		});
		cLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && cLanguage.getName().equals(currPlayer.getName())) {
						cUnits += 1;
						territories.get(2).addUnits(1);
						myLabel.setText("" + cUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (cLanguage.getName().equals(currPlayer.getName()))) {
					cUnits += 1;
					territories.get(2).addUnits(1);
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((cLanguage.getName().equals(currPlayer.getName())) && (cUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						cAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(2)));

					}
				}
				if (cAttacking == true && (currPlayer.getName() == cLanguage.getName())) {
					cAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (javaAttacking == true && (currPlayer.getName() != cLanguage.getName())) {
					System.out.println("C was attacked by java");
					gameBoardAttack(territories.get(0), territories.get(2));
					javaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (sqlAttacking == true && (currPlayer.getName() != cLanguage.getName())) {
					System.out.println("C was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(2));
					sqlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pythonAttacking == true && (currPlayer.getName() != cLanguage.getName())) {
					System.out.println("c was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(2));
					cAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (rubyAttacking == true && (currPlayer.getName() != cLanguage.getName())) {
					System.out.println("c was attacked by ruby");
					gameBoardAttack(territories.get(4), territories.get(2));
					rubyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((pythonFortify == true) && (currPlayer.getName() == cLanguage.getName())) {
					territories.get(2).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
					neighborsLabel.setText("");
				}
				if ((rubyFortify == true) && (currPlayer.getName() == cLanguage.getName())) {
					territories.get(2).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rubyFortify = false;
					neighborsLabel.setText("");
				}
				if ((sqlFortify == true) && (currPlayer.getName() == cLanguage.getName())) {
					territories.get(2).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
					neighborsLabel.setText("");
				}
				if ((javaFortify == true) && (currPlayer.getName() == cLanguage.getName())) {
					territories.get(2).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					javaFortify = false;
					neighborsLabel.setText("");
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == cLanguage.getName()) {
						System.out.println("fortify from c!!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(2)));
						Object[] range = new Object[territories.get(2).getUnits()];
						for (int i = 1; i < territories.get(2).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(2).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						cFortify = true;
					}
				}

			}
		});
		sqlLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();

				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && sqlLanguage.getName().equals(currPlayer.getName())) {
						sqlUnits += 1;
						territories.get(3).addUnits(1);
						myLabel.setText("" + sqlUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (sqlLanguage.getName().equals(currPlayer.getName()))) {
					sqlUnits += 1;
					territories.get(3).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((sqlLanguage.getName().equals(currPlayer.getName())) && (sqlUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						sqlAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(3)));

					}
				}
				if (sqlAttacking == true && (currPlayer.getName() == sqlLanguage.getName())) {
					sqlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if (javaAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by java");
					gameBoardAttack(territories.get(0), territories.get(3));
					javaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pythonAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(3));
					pythonAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (cAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by c");
					gameBoardAttack(territories.get(2), territories.get(3));
					cAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (rubyAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by ruby");
					gameBoardAttack(territories.get(4), territories.get(3));
					rubyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (gitAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by git");
					gameBoardAttack(territories.get(5), territories.get(3));
					gitAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((gitFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					gitFortify = false;
					neighborsLabel.setText("");
				}
				if ((rubyFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rubyFortify = false;
					neighborsLabel.setText("");
				}
				if ((cFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					cFortify = false;
					neighborsLabel.setText("");
				}
				if ((pythonFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
					neighborsLabel.setText("");
				}
				if ((javaFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					javaFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == sqlLanguage.getName()) {
						System.out.println("fortify from sql!!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(3)));
						Object[] range = new Object[territories.get(3).getUnits()];
						for (int i = 1; i < territories.get(3).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(3).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						sqlFortify = true;
					}
				}
			}
		});
		rubyLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();

				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && rubyLanguage.getName().equals(currPlayer.getName())) {
						rubyUnits += 1;
						territories.get(4).addUnits(1);
						myLabel.setText("" + rubyUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (rubyLanguage.getName().equals(currPlayer.getName()))) {
					rubyUnits += 1;
					territories.get(4).addUnits(1);
					
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((rubyLanguage.getName().equals(currPlayer.getName())) && (rubyUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						

						rubyAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(4)));

					}
				}
				if (rubyAttacking == true && (currPlayer.getName() == rubyLanguage.getName())) {
					rubyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (cAttacking == true && (currPlayer.getName() != rubyLanguage.getName())) {
					System.out.println("ruby was attacked by c");
					gameBoardAttack(territories.get(2), territories.get(4));
					cAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (sqlAttacking == true && (currPlayer.getName() != rubyLanguage.getName())) {
					System.out.println("ruby was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(4));
					sqlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (gitAttacking == true && (currPlayer.getName() != rubyLanguage.getName())) {
					System.out.println("ruby was attacked by git");
					gameBoardAttack(territories.get(5), territories.get(4));
					gitAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (giantAttacking == true && (currPlayer.getName() != rubyLanguage.getName())) {
					System.out.println("ruby was attacked by giant");
					gameBoardAttack(territories.get(30), territories.get(4));
					giantAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if ((giantFortify == true) && (currPlayer.getName() == rubyLanguage.getName())) {
					territories.get(4).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
					neighborsLabel.setText("");
				}
				if ((gitFortify == true) && (currPlayer.getName() == rubyLanguage.getName())) {
					territories.get(4).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					gitFortify = false;
					neighborsLabel.setText("");
				}
				if ((sqlFortify == true) && (currPlayer.getName() == rubyLanguage.getName())) {
					territories.get(4).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
					neighborsLabel.setText("");
				}
				if ((cFortify == true) && (currPlayer.getName() == rubyLanguage.getName())) {
					territories.get(4).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					cFortify = false;
					neighborsLabel.setText("");
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == rubyLanguage.getName()) {
						System.out.println("fortify from ruby!!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(4)));
						Object[] range = new Object[territories.get(4).getUnits()];
						for (int i = 1; i < territories.get(4).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(4).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						rubyFortify = true;
					}
				}

			}
		});
		gitLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();

				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && gitLanguage.getName().equals(currPlayer.getName())) {
						gitUnits += 1;
						territories.get(5).addUnits(1);
						myLabel.setText("" + gitUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (gitLanguage.getName().equals(currPlayer.getName()))) {
					gitUnits += 1;
					territories.get(5).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((gitLanguage.getName().equals(currPlayer.getName())) && (gitUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						gitAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("");
						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(5)));

					}
				}
				if (gitAttacking == true && (currPlayer.getName() == gitLanguage.getName())) {
					gitAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pythonAttacking == true && (currPlayer.getName() != gitLanguage.getName())) {
					System.out.println("git was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(5));
					pythonAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (sqlAttacking == true && (currPlayer.getName() != gitLanguage.getName())) {
					System.out.println("git was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(5));
					sqlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (rubyAttacking == true && (currPlayer.getName() != gitLanguage.getName())) {
					System.out.println("git was attacked by ruby");
					gameBoardAttack(territories.get(4), territories.get(5));
					rubyAttacking = false;
					attackPhase = true;
				}
				if (giantAttacking == true && (currPlayer.getName() != gitLanguage.getName())) {
					System.out.println("git was attacked by giant");
					gameBoardAttack(territories.get(30), territories.get(5));
					giantAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (perlAttacking == true && (currPlayer.getName() != gitLanguage.getName())) {
					System.out.println("git was attacked by giant");
					gameBoardAttack(territories.get(6), territories.get(5));
					perlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((perlFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					perlFortify = false;
					neighborsLabel.setText("");
				}
				if ((giantFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
					neighborsLabel.setText("");
				}
				if ((rubyFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rubyFortify = false;
					neighborsLabel.setText("");
				}
				if ((sqlFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
					neighborsLabel.setText("");
				}
				if ((pythonFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == gitLanguage.getName()) {
						System.out.println("fortify from git!!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(5)));
						Object[] range = new Object[territories.get(5).getUnits()];
						for (int i = 1; i < territories.get(5).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(5).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						gitFortify = true;
					}
				}
			}
		});
		perlLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && perlLanguage.getName().equals(currPlayer.getName())) {
						perlUnits += 1;
						territories.get(6).addUnits(1);
						myLabel.setText("" + perlUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}

				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (perlLanguage.getName().equals(currPlayer.getName()))) {
					perlUnits += 1;
					territories.get(6).addUnits(1);
					
			
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((perlLanguage.getName().equals(currPlayer.getName())) && (perlUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						perlAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(6)));

					}
				}
				if (perlAttacking == true && (currPlayer.getName() == perlLanguage.getName())) {
					perlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pythonAttacking == true && (currPlayer.getName() != perlLanguage.getName())) {
					System.out.println("perl was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(6));
					pythonAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (gitAttacking == true && (currPlayer.getName() != perlLanguage.getName())) {
					System.out.println("perl was attacked by git");
					gameBoardAttack(territories.get(5), territories.get(6));
					gitAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if ((gitFortify == true) && (currPlayer.getName() == perlLanguage.getName())) {
					territories.get(6).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					gitFortify = false;
					neighborsLabel.setText("");
				}
				if ((pythonFortify == true) && (currPlayer.getName() == perlLanguage.getName())) {
					territories.get(6).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
					neighborsLabel.setText("");
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == perlLanguage.getName()) {
						System.out.println("fortify from perl!!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(6)));
						Object[] range = new Object[territories.get(6).getUnits()];
						for (int i = 1; i < territories.get(6).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(6).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						perlFortify = true;
					}
				}
			}
		});
		wilberWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && wilberWildcat.getName().equals(currPlayer.getName())) {
						wilberUnits += 1;
						territories.get(14).addUnits(1);
						myLabel.setText("" + wilberUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (wilberWildcat.getName().equals(currPlayer.getName()))) {
					wilberUnits += 1;
					territories.get(14).addUnits(1);
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((wilberWildcat.getName().equals(currPlayer.getName())) && (wilberUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						wilberAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(14)));

					}
				}
				if (wilberAttacking == true && (currPlayer.getName() == wilberWildcat.getName())) {
					wilberAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilmaAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(15), territories.get(14));
					wilmaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (richAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(14));
					richAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (scoobyAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(14));
					scoobyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (papaAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(14));
					papaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dominosAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(14));
					dominosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(14));
					brooklynsAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(14));
					tonatiuhAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
					neighborsLabel.setText("");
				}
				if ((brooklynFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
					neighborsLabel.setText("");
				}
				if ((dominosFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
					neighborsLabel.setText("");
				}
				if ((papaFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
					neighborsLabel.setText("");
				}
				if ((scoobyFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
					neighborsLabel.setText("");
				}
				if ((richFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
					neighborsLabel.setText("");
				}
				if ((wilmaFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					wilmaFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == wilberWildcat.getName()) {
						System.out.println("fortify from wilber!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(14)));
						Object[] range = new Object[territories.get(14).getUnits()];
						for (int i = 1; i < territories.get(14).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(14).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						wilberFortify = true;
					}
				}
			}
		});
		wilmaWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && wilmaWildcat.getName().equals(currPlayer.getName())) {
						wilmaUnits += 1;
						territories.get(15).addUnits(1);
						myLabel.setText("" + wilmaUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (wilmaWildcat.getName().equals(currPlayer.getName()))) {
					wilmaUnits += 1;
					territories.get(15).addUnits(1);
				
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((wilmaWildcat.getName().equals(currPlayer.getName())) && (wilmaUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						wilmaAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(15)));

					}
				}
				if (wilmaAttacking == true && (currPlayer.getName() == wilmaWildcat.getName())) {
					wilmaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilberAttacking == true && (currPlayer.getName() != wilmaWildcat.getName())) {
					System.out.println("wilma was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(15));
					wilberAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (richAttacking == true && (currPlayer.getName() != wilmaWildcat.getName())) {
					System.out.println("wilma was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(15));
					richAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (millerAttacking == true && (currPlayer.getName() != wilmaWildcat.getName())) {
					System.out.println("wilma was attacked by python");
					gameBoardAttack(territories.get(17), territories.get(15));
					millerAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((wilberFortify == true) && (currPlayer.getName() == wilmaWildcat.getName())) {
					territories.get(15).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
					neighborsLabel.setText("");
				}
				if ((richFortify == true) && (currPlayer.getName() == wilmaWildcat.getName())) {
					territories.get(15).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
					neighborsLabel.setText("");
				}
				if ((millerFortify == true) && (currPlayer.getName() == wilmaWildcat.getName())) {
					territories.get(15).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					millerFortify = false;
					neighborsLabel.setText("");
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == wilmaWildcat.getName()) {
						System.out.println("fortify from wilma!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(15)));
						Object[] range = new Object[territories.get(15).getUnits()];
						for (int i = 1; i < territories.get(15).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(15).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						wilmaFortify = true;
					}
				}
			}
		});
		richWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && richWildcat.getName().equals(currPlayer.getName())) {
						richUnits += 1;
						territories.get(16).addUnits(1);
						myLabel.setText("" + richUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (richWildcat.getName().equals(currPlayer.getName()))) {
					richUnits += 1;
					territories.get(16).addUnits(1);
					
				
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				else if (attackPhase == true) {
					if ((richWildcat.getName().equals(currPlayer.getName())) && (richUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						richAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(16)));

					}
				}
				if (richAttacking == true && (currPlayer.getName() == richWildcat.getName())) {
					richAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilberAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(16));
					wilberAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilmaAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(15), territories.get(16));
					wilmaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (millerAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(17), territories.get(16));
					millerAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (scoobyAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(16));
					scoobyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (mckaleAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(19), territories.get(16));
					mckaleAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((wilberFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
					neighborsLabel.setText("");
				}
				if ((wilmaFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilmaFortify = false;
					neighborsLabel.setText("");
				}
				if ((millerFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					millerFortify = false;
					neighborsLabel.setText("");
				}
				if ((scoobyFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
					neighborsLabel.setText("");
				}
				if ((mckaleFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					mckaleFortify = false;
					neighborsLabel.setText("");
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == richWildcat.getName()) {
						System.out.println("fortify from wilber!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(16)));
						Object[] range = new Object[territories.get(16).getUnits()];
						for (int i = 1; i < territories.get(16).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(16).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						richFortify = true;
					}
				}
			}
		});
		millerWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && millerWildcat.getName().equals(currPlayer.getName())) {
						millerUnits += 1;
						territories.get(17).addUnits(1);
						myLabel.setText("" + millerUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (millerWildcat.getName().equals(currPlayer.getName()))) {
					millerUnits += 1;
					territories.get(17).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((millerWildcat.getName().equals(currPlayer.getName())) && (millerUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						millerAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(17)));

					}
				}
				if (millerAttacking == true && (currPlayer.getName() == millerWildcat.getName())) {
					millerAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilmaAttacking == true && (currPlayer.getName() != millerWildcat.getName())) {
					System.out.println("miller was attacked by python");
					gameBoardAttack(territories.get(15), territories.get(17));
					wilmaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (richAttacking == true && (currPlayer.getName() != millerWildcat.getName())) {
					System.out.println("miller was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(17));
					richAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (mckaleAttacking == true && (currPlayer.getName() != millerWildcat.getName())) {
					System.out.println("miller was attacked by python");
					gameBoardAttack(territories.get(19), territories.get(17));
					mckaleAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (scraptopiaAttacking == true && (currPlayer.getName() != millerWildcat.getName())) {
					System.out.println("miller was attacked by python");
					gameBoardAttack(territories.get(28), territories.get(17));
					scraptopiaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((wilmaFortify == true) && (currPlayer.getName() == millerWildcat.getName())) {
					territories.get(17).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilmaFortify = false;
					neighborsLabel.setText("");
				}
				if ((scraptopiaFortify == true) && (currPlayer.getName() == millerWildcat.getName())) {
					territories.get(17).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scraptopiaFortify = false;
					neighborsLabel.setText("");
				}
				if ((mckaleFortify == true) && (currPlayer.getName() == millerWildcat.getName())) {
					territories.get(17).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					mckaleFortify = false;
					neighborsLabel.setText("");
				}
				if ((richFortify == true) && (currPlayer.getName() == millerWildcat.getName())) {
					territories.get(17).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == millerWildcat.getName()) {
						System.out.println("fortify from miller!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(17)));
						Object[] range = new Object[territories.get(17).getUnits()];
						for (int i = 1; i < territories.get(17).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(17).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						millerFortify = true;
					}
				}
			}
		});
		scoobyWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && scoobyWildcat.getName().equals(currPlayer.getName())) {
						scoobyUnits += 1;
						territories.get(18).addUnits(1);
						myLabel.setText("" + scoobyUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (scoobyWildcat.getName().equals(currPlayer.getName()))) {
					scoobyUnits += 1;
					territories.get(18).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((scoobyWildcat.getName().equals(currPlayer.getName())) && (scoobyUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						scoobyAttacking = true;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(18)));

					}
				}
				if (scoobyAttacking == true && (currPlayer.getName() == scoobyWildcat.getName())) {
					scoobyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilberAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(18));
					wilberAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (richAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(18));
					richAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (mckaleAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(19), territories.get(18));
					mckaleAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (zonaAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(20), territories.get(18));
					zonaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (papaAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(18));
					papaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((papaFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
					neighborsLabel.setText("");
				}
				if ((zonaFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					zonaFortify = false;
					neighborsLabel.setText("");
				}
				if ((mckaleFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					mckaleFortify = false;
					neighborsLabel.setText("");
				}
				if ((richFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
					neighborsLabel.setText("");
				}
				if ((wilberFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == scoobyWildcat.getName()) {
						System.out.println("fortify from scooby!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(18)));
						Object[] range = new Object[territories.get(18).getUnits()];
						for (int i = 1; i < territories.get(18).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(18).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						scoobyFortify = true;
					}
				}
			}
		});
		mckaleWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && mckaleWildcat.getName().equals(currPlayer.getName())) {
						mckaleUnits += 1;
						territories.get(19).addUnits(1);
						myLabel.setText("" + mckaleUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}

				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (mckaleWildcat.getName().equals(currPlayer.getName()))) {
					mckaleUnits += 1;
					territories.get(19).addUnits(1);
				
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				}

				else if (attackPhase == true) {
					if ((mckaleWildcat.getName().equals(currPlayer.getName())) && (mckaleUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						mckaleAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(19)));

					}
				}
				if (mckaleAttacking == true && (currPlayer.getName() == mckaleWildcat.getName())) {
					mckaleAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (richAttacking == true && (currPlayer.getName() != mckaleWildcat.getName())) {
					System.out.println("mckale was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(19));
					richAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (millerAttacking == true && (currPlayer.getName() != mckaleWildcat.getName())) {
					System.out.println("mckale was attacked by python");
					gameBoardAttack(territories.get(17), territories.get(19));
					millerAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (scoobyAttacking == true && (currPlayer.getName() != mckaleWildcat.getName())) {
					System.out.println("mckale was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(19));
					scoobyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (zonaAttacking == true && (currPlayer.getName() != mckaleWildcat.getName())) {
					System.out.println("mckale was attacked by python");
					gameBoardAttack(territories.get(20), territories.get(19));
					zonaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((zonaFortify == true) && (currPlayer.getName() == mckaleWildcat.getName())) {
					territories.get(19).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					zonaFortify = false;
					neighborsLabel.setText("");
				}
				if ((scoobyFortify == true) && (currPlayer.getName() == mckaleWildcat.getName())) {
					territories.get(19).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
					neighborsLabel.setText("");
				}
				if ((millerFortify == true) && (currPlayer.getName() == mckaleWildcat.getName())) {
					territories.get(19).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					millerFortify = false;
					neighborsLabel.setText("");
				}
				if ((richFortify == true) && (currPlayer.getName() == mckaleWildcat.getName())) {
					territories.get(19).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == mckaleWildcat.getName()) {
						System.out.println("fortify from miller!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(19)));
						Object[] range = new Object[territories.get(19).getUnits()];
						for (int i = 1; i < territories.get(19).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(19).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						mckaleFortify = true;
					}
				}
			}
		});
		zonaWildcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && zonaWildcat.getName().equals(currPlayer.getName())) {
						zonaUnits += 1;
						territories.get(20).addUnits(1);
						myLabel.setText("" + zonaUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (zonaWildcat.getName().equals(currPlayer.getName()))) {
					zonaUnits += 1;
					territories.get(20).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((zonaWildcat.getName().equals(currPlayer.getName())) && (zonaUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						zonaAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(20)));

					}
				}
				if (zonaAttacking == true && (currPlayer.getName() == zonaWildcat.getName())) {
					zonaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (scoobyAttacking == true && (currPlayer.getName() != zonaWildcat.getName())) {
					System.out.println("zona was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(20));
					scoobyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (mckaleAttacking == true && (currPlayer.getName() != zonaWildcat.getName())) {
					System.out.println("zona was attacked by python");
					gameBoardAttack(territories.get(19), territories.get(20));
					mckaleAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == zonaWildcat.getName()) {
						System.out.println("fortify from zona!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(20)));
						Object[] range = new Object[territories.get(20).getUnits()];
						for (int i = 1; i < territories.get(20).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(20).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						zonaFortify = true;
					}
				}
				if ((mckaleFortify == true) && (currPlayer.getName() == zonaWildcat.getName())) {
					territories.get(20).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					mckaleFortify = false;
					neighborsLabel.setText("");
				}
				if ((scoobyFortify == true) && (currPlayer.getName() == zonaWildcat.getName())) {
					territories.get(20).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
					neighborsLabel.setText("");
				}
			}
		});
		papajohnsPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && papajohnsPizza.getName().equals(currPlayer.getName())) {
						pjUnits += 1;
						territories.get(21).addUnits(1);
						myLabel.setText("" + pjUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (papajohnsPizza.getName().equals(currPlayer.getName()))) {
					pjUnits += 1;
					territories.get(21).addUnits(1);
				
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((papajohnsPizza.getName().equals(currPlayer.getName())) && (pjUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						papaAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(21)));
					}
				}
				if (papaAttacking == true && (currPlayer.getName() == papajohnsPizza.getName())) {
					papaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dominosAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("papajohns was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(21));
					dominosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pizzahutAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("papa was attacked by python");
					gameBoardAttack(territories.get(23), territories.get(21));
					pizzahutAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (blackjackAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("dpapa was attacked by python");
					gameBoardAttack(territories.get(24), territories.get(21));
					blackjackAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilberAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("papa was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(21));
					wilberAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (scoobyAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("papa was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(21));
					scoobyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((scoobyFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
					neighborsLabel.setText("");
				}
				if ((wilberFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
					neighborsLabel.setText("");
				}
				if ((blackjackFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackjackFortify = false;
					neighborsLabel.setText("");
				}
				if ((pizzahutFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzahutFortify = false;
					neighborsLabel.setText("");
				}
				if ((dominosFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == papajohnsPizza.getName()) {
						System.out.println("fortify from papa!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(21)));
						Object[] range = new Object[territories.get(21).getUnits()];
						for (int i = 1; i < territories.get(21).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(21).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						papaFortify = true;
					}
				}
			}
		});
		dominosPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && dominosPizza.getName().equals(currPlayer.getName())) {
						domUnits += 1;
						territories.get(22).addUnits(1);
						myLabel.setText("" + domUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (dominosPizza.getName().equals(currPlayer.getName()))) {
					domUnits += 1;
					territories.get(22).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((dominosPizza.getName().equals(currPlayer.getName())) && (domUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						dominosAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(22)));
					}
				}
				if (dominosAttacking == true && (currPlayer.getName() == dominosPizza.getName())) {
					dominosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (papaAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("dom was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(22));
					papaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pizzahutAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("dom was attacked by python");
					gameBoardAttack(territories.get(23), territories.get(22));
					pizzahutAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (hungryhowiesAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("domy how was attacked by python");
					gameBoardAttack(territories.get(25), territories.get(22));
					hungryhowiesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("dom was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(22));
					brooklynsAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilberAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("dom was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(22));
					wilberAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if ((wilberFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
					neighborsLabel.setText("");
				}
				if ((brooklynFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
					neighborsLabel.setText("");
				}
				if ((hungryhowiesFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					hungryhowiesFortify = false;
					neighborsLabel.setText("");
				}
				if ((pizzahutFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzahutFortify = false;
					neighborsLabel.setText("");
				}
				if ((papaFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
					neighborsLabel.setText("");
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == dominosPizza.getName()) {
						System.out.println("fortify from dominos!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(22)));
						Object[] range = new Object[territories.get(22).getUnits()];
						for (int i = 1; i < territories.get(22).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(22).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						dominosFortify = true;
					}
				}
			}
		});
		pizzahutPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && pizzahutPizza.getName().equals(currPlayer.getName())) {
						phUnits += 1;
						territories.get(23).addUnits(1);
						myLabel.setText("" + phUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (pizzahutPizza.getName().equals(currPlayer.getName()))) {
					phUnits += 1;
					territories.get(23).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((pizzahutPizza.getName().equals(currPlayer.getName())) && (phUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						pizzahutAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(23)));

					}
				}
				if (pizzahutAttacking == true && (currPlayer.getName() == pizzahutPizza.getName())) {
					pizzahutAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (papaAttacking == true && (currPlayer.getName() != pizzahutPizza.getName())) {
					System.out.println("pizzhut was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(23));
					papaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dominosAttacking == true && (currPlayer.getName() != pizzahutPizza.getName())) {
					System.out.println("pizza was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(23));
					dominosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (blackjackAttacking == true && (currPlayer.getName() != pizzahutPizza.getName())) {
					System.out.println("pizzhut was attacked by python");
					gameBoardAttack(territories.get(24), territories.get(23));
					blackjackAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (hungryhowiesAttacking == true && (currPlayer.getName() != pizzahutPizza.getName())) {
					System.out.println("pizzhut was attacked by python");
					gameBoardAttack(territories.get(25), territories.get(23));
					hungryhowiesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if ((hungryhowiesFortify == true) && (currPlayer.getName() == pizzahutPizza.getName())) {
					territories.get(23).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					hungryhowiesFortify = false;
					neighborsLabel.setText("");
				}
				if ((blackjackFortify == true) && (currPlayer.getName() == pizzahutPizza.getName())) {
					territories.get(23).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackjackFortify = false;
					neighborsLabel.setText("");
				}
				if ((dominosFortify == true) && (currPlayer.getName() == pizzahutPizza.getName())) {
					territories.get(23).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
					neighborsLabel.setText("");
				}
				if ((papaFortify == true) && (currPlayer.getName() == pizzahutPizza.getName())) {
					territories.get(23).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == pizzahutPizza.getName()) {
						System.out.println("fortify from hut!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(23)));
						Object[] range = new Object[territories.get(23).getUnits()];
						for (int i = 1; i < territories.get(23).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(23).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						pizzahutFortify = true;
					}
				}
			}
		});
		blackjackPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && blackjackPizza.getName().equals(currPlayer.getName())) {
						bjUnits += 1;
						territories.get(24).addUnits(1);
						myLabel.setText("" + bjUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (blackjackPizza.getName().equals(currPlayer.getName()))) {
					bjUnits += 1;
					territories.get(24).addUnits(1);
				
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((blackjackPizza.getName().equals(currPlayer.getName())) && (bjUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						blackjackAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(24)));

					}
				}
				if (blackjackAttacking == true && (currPlayer.getName() == blackjackPizza.getName())) {
					blackjackAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (papaAttacking == true && (currPlayer.getName() != blackjackPizza.getName())) {
					System.out.println("blackjack was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(24));
					papaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dominosAttacking == true && (currPlayer.getName() != blackjackPizza.getName())) {
					System.out.println("blackjack was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(24));
					dominosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pizzahutAttacking == true && (currPlayer.getName() != blackjackPizza.getName())) {
					System.out.println("blackjack was attacked by python");
					gameBoardAttack(territories.get(23), territories.get(24));
					pizzahutAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((pizzahutFortify == true) && (currPlayer.getName() == blackjackPizza.getName())) {
					territories.get(24).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzahutFortify = false;
					neighborsLabel.setText("");
				}

				if ((dominosFortify == true) && (currPlayer.getName() == blackjackPizza.getName())) {
					territories.get(24).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
					neighborsLabel.setText("");
				}

				if ((papaFortify == true) && (currPlayer.getName() == blackjackPizza.getName())) {
					territories.get(24).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == blackjackPizza.getName()) {
						System.out.println("fortify from blackj!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(24)));
						Object[] range = new Object[territories.get(24).getUnits()];
						for (int i = 1; i < territories.get(24).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(24).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						blackjackFortify = true;
					}
				}
			}
		});
		hungryhowiesPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && hungryhowiesPizza.getName().equals(currPlayer.getName())) {
						hhUnits += 1;
						territories.get(25).addUnits(1);
						myLabel.setText("" + hhUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (hungryhowiesPizza.getName().equals(currPlayer.getName()))) {
					hhUnits += 1;
					territories.get(25).addUnits(1);
				
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((hungryhowiesPizza.getName().equals(currPlayer.getName())) && (hhUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						hungryhowiesAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(25)));
					}
				}if (hungryhowiesAttacking == true && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					hungryhowiesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dominosAttacking == true && (currPlayer.getName() != hungryhowiesPizza.getName())) {
					System.out.println("hungryHowies was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(25));
					dominosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pizzahutAttacking == true && (currPlayer.getName() != hungryhowiesPizza.getName())) {
					System.out.println("hungryHowies was attacked by python");
					gameBoardAttack(territories.get(23), territories.get(25));
					pizzahutAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (blackjackAttacking == true && (currPlayer.getName() != hungryhowiesPizza.getName())) {
					System.out.println("hungryHowies was attacked by python");
					gameBoardAttack(territories.get(24), territories.get(25));
					blackjackAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != hungryhowiesPizza.getName())) {
					System.out.println("hungryHowies was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(25));
					brooklynsAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((brooklynFortify == true) && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					territories.get(25).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
					neighborsLabel.setText("");
				}
				if ((blackjackFortify == true) && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					territories.get(25).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackjackFortify = false;
					neighborsLabel.setText("");
				}
				if ((pizzahutFortify == true) && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					territories.get(25).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzahutFortify = false;
					neighborsLabel.setText("");
				}
				if ((dominosFortify == true) && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					territories.get(25).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == hungryhowiesPizza.getName()) {
						System.out.println("fortify from hungryhowies!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(25)));
						Object[] range = new Object[territories.get(25).getUnits()];
						for (int i = 1; i < territories.get(25).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(25).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						hungryhowiesFortify = true;
					}
				}

			}
		});
		brooklynPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && brooklynPizza.getName().equals(currPlayer.getName())) {
						bUnits += 1;
						territories.get(26).addUnits(1);
						myLabel.setText("" + bUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (brooklynPizza.getName().equals(currPlayer.getName()))) {
					bUnits += 1;
					territories.get(26).addUnits(1);
					
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((brooklynPizza.getName().equals(currPlayer.getName())) && (bUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						brooklynsAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(26)));
					}
				}
				if (brooklynsAttacking == true && (currPlayer.getName() == brooklynPizza.getName())) {
					brooklynsAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dominosAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(26));
					dominosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (hungryhowiesAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(25), territories.get(26));
					hungryhowiesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pizzaplanetAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(27), territories.get(26));
					pizzaplanetAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (wilberAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(26));
					wilberAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(26));
					tonatiuhAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
					neighborsLabel.setText("");
				}
				if ((wilberFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
					neighborsLabel.setText("");
				}
				if ((pizzaplanetFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzaplanetFortify = false;
					neighborsLabel.setText("");
				}
				if ((hungryhowiesFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					hungryhowiesFortify = false;
					neighborsLabel.setText("");
				}
				if ((dominosFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == brooklynPizza.getName()) {
						System.out.println("fortify from brook!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(26)));
						Object[] range = new Object[territories.get(26).getUnits()];
						for (int i = 1; i < territories.get(26).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(26).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						brooklynFortify = true;
					}
				}

			}
		});
		pizzaplanetPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && pizzaplanetPizza.getName().equals(currPlayer.getName())) {
						ppUnits += 1;
						territories.get(27).addUnits(1);
						myLabel.setText("" + ppUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (pizzaplanetPizza.getName().equals(currPlayer.getName()))) {
					ppUnits += 1;
					territories.get(27).addUnits(1);
			
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((pizzaplanetPizza.getName().equals(currPlayer.getName())) && (ppUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						gameBoardAttack(territories.get(1), territories.get(27));
						pizzaplanetAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(27)));
					}
				}
				if (pizzaplanetAttacking == true && (currPlayer.getName() == pizzaplanetPizza.getName())) {
					pizzaplanetAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != pizzaplanetPizza.getName())) {
					System.out.println("pizzaplanet was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(27));
					brooklynsAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (apolloAttacking == true && (currPlayer.getName() != pizzaplanetPizza.getName())) {
					System.out.println("pizzaplanet was attacked by python");
					gameBoardAttack(territories.get(35), territories.get(27));
					apolloAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != pizzaplanetPizza.getName())) {
					System.out.println("pizzaplanet was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(27));
					tonatiuhAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == pizzaplanetPizza.getName())) {
					territories.get(27).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
					neighborsLabel.setText("");
				}
				if ((apolloFortify == true) && (currPlayer.getName() == pizzaplanetPizza.getName())) {
					territories.get(27).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					apolloFortify = false;
					neighborsLabel.setText("");
				}
				if ((brooklynFortify == true) && (currPlayer.getName() == pizzaplanetPizza.getName())) {
					territories.get(27).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == pizzaplanetPizza.getName()) {
						System.out.println("fortify from pizzaplanet!!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(27)));
						Object[] range = new Object[territories.get(27).getUnits()];
						for (int i = 1; i < territories.get(27).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(27).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						pizzaplanetFortify = true;
					}
				}
			}
		});
		apolloSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && apolloSun.getName().equals(currPlayer.getName())) {
						apolloUnits += 1;
						territories.get(35).addUnits(1);
						myLabel.setText("" + apolloUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (apolloSun.getName().equals(currPlayer.getName()))) {
					apolloUnits += 1;
					territories.get(35).addUnits(1);
				
					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((apolloSun.getName().equals(currPlayer.getName())) && (apolloUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						apolloAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(35)));
					}
				}
				if (apolloAttacking == true && (currPlayer.getName() == apolloSun.getName())) {
					apolloAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (raAttacking == true && (currPlayer.getName() != apolloSun.getName())) {
					System.out.println("apollo was attacked by python");
					gameBoardAttack(territories.get(36), territories.get(35));
					raAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != apolloSun.getName())) {
					System.out.println("apollo was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(35));
					tonatiuhAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (amunAttacking == true && (currPlayer.getName() != apolloSun.getName())) {
					System.out.println("apollo was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(35));
					amunAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pizzaplanetAttacking == true && (currPlayer.getName() != apolloSun.getName())) {
					System.out.println("apollo was attacked by python");
					gameBoardAttack(territories.get(27), territories.get(35));
					pizzaplanetAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((pizzaplanetFortify == true) && (currPlayer.getName() == apolloSun.getName())) {
					territories.get(35).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzaplanetFortify = false;
					neighborsLabel.setText("");
				}
				if ((amunFortify == true) && (currPlayer.getName() == apolloSun.getName())) {
					territories.get(35).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
					neighborsLabel.setText("");
				}
				if ((tonatiuhFortify == true) && (currPlayer.getName() == apolloSun.getName())) {
					territories.get(35).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
					neighborsLabel.setText("");
				}
				if ((raFortify == true) && (currPlayer.getName() == apolloSun.getName())) {
					territories.get(35).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					raFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == apolloSun.getName()) {
						System.out.println("fortify from apollo!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(35)));
						Object[] range = new Object[territories.get(35).getUnits()];
						for (int i = 1; i < territories.get(35).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(35).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						apolloFortify = true;
					}
				}
			}
		});

		raSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && raSun.getName().equals(currPlayer.getName())) {
						raUnits += 1;
						territories.get(36).addUnits(1);
						myLabel.setText("" + raUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();
					}

					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (raSun.getName().equals(currPlayer.getName()))) {
					raUnits += 1;
					territories.get(36).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((raSun.getName().equals(currPlayer.getName())) && (raUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						raAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(36)));
					}
				}
				if (raAttacking == true && (currPlayer.getName() == raSun.getName())) {
					raAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (apolloAttacking == true && (currPlayer.getName() != raSun.getName())) {
					System.out.println("ra was attacked by python");
					gameBoardAttack(territories.get(35), territories.get(36));
					apolloAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (heliosAttacking == true && (currPlayer.getName() != raSun.getName())) {
					System.out.println("ra was attacked by python");
					gameBoardAttack(territories.get(37), territories.get(36));
					heliosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (amunAttacking == true && (currPlayer.getName() != raSun.getName())) {
					System.out.println("ra was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(36));
					amunAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((amunFortify == true) && (currPlayer.getName() == raSun.getName())) {
					territories.get(36).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
					neighborsLabel.setText("");
				}
				if ((heliosFortify == true) && (currPlayer.getName() == raSun.getName())) {
					territories.get(36).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					heliosFortify = false;
					neighborsLabel.setText("");
				}
				if ((apolloFortify == true) && (currPlayer.getName() == raSun.getName())) {
					territories.get(36).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					apolloFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {

					if (currPlayer.getName() == raSun.getName()) {
						System.out.println("fortify from ra!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(36)));

						Object[] range = new Object[territories.get(36).getUnits()];
						for (int i = 1; i < territories.get(36).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(36).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						amunFortify = true;
					}
				}
			}
		});

		heliosSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && heliosSun.getName().equals(currPlayer.getName())) {
						heliosUnits += 1;
						territories.get(37).addUnits(1);
						myLabel.setText("" + heliosUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (heliosSun.getName().equals(currPlayer.getName()))) {
					heliosUnits += 1;
					territories.get(37).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((heliosSun.getName().equals(currPlayer.getName())) && (heliosUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						heliosAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(37)));
					}
				}
				if (heliosAttacking == true && (currPlayer.getName() == heliosSun.getName())) {
					heliosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (raAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(36), territories.get(37));
					raAttacking = false;
					attackPhase = true;

					neighborsLabel.setText("");
				}
				if (intiAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(38), territories.get(37));
					intiAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (horusAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(39), territories.get(37));
					horusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (amunAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(37));
					amunAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (javaAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(0), territories.get(37));
					javaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((javaFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					javaFortify = false;
					neighborsLabel.setText("");
				}
				if ((amunFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
					neighborsLabel.setText("");
				}
				if ((horusFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
					neighborsLabel.setText("");
				}
				if ((intiFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					intiFortify = false;
					neighborsLabel.setText("");
				}
				if ((raFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					raFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == heliosSun.getName()) {
						System.out.println("fortify from helios!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(37)));
						Object[] range = new Object[territories.get(37).getUnits()];
						for (int i = 1; i < territories.get(37).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(37).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						heliosFortify = true;
					}
				}
			}
		});
		intiSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && intiSun.getName().equals(currPlayer.getName())) {
						intiUnits += 1;
						territories.get(38).addUnits(1);
						myLabel.setText("" + intiUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (intiSun.getName().equals(currPlayer.getName()))) {
					intiUnits += 1;
					territories.get(38).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((intiSun.getName().equals(currPlayer.getName())) && (intiUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						intiAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(38)));
					}
				}
				if (intiAttacking == true && (currPlayer.getName() == intiSun.getName())) {
					intiAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (heliosAttacking == true && (currPlayer.getName() != intiSun.getName())) {
					System.out.println("inti was attacked by python");
					gameBoardAttack(territories.get(37), territories.get(38));
					heliosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (horusAttacking == true && (currPlayer.getName() != intiSun.getName())) {
					System.out.println("inti was attacked by python");
					gameBoardAttack(territories.get(39), territories.get(38));
					horusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((horusFortify == true) && (currPlayer.getName() == intiSun.getName())) {
					territories.get(38).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
					neighborsLabel.setText("");
				}
				if ((heliosFortify == true) && (currPlayer.getName() == intiSun.getName())) {
					territories.get(38).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					heliosFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == intiSun.getName()) {
						System.out.println("fortify from inti!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(38)));
						Object[] range = new Object[territories.get(38).getUnits()];
						for (int i = 1; i < territories.get(38).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(38).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						intiFortify = true;
					}
				}
			}
		});
		horusSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && horusSun.getName().equals(currPlayer.getName())) {
						horusUnits += 1;
						territories.get(39).addUnits(1);
						myLabel.setText("" + horusUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (horusSun.getName().equals(currPlayer.getName()))) {
					horusUnits += 1;
					territories.get(39).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((horusSun.getName().equals(currPlayer.getName())) && (horusUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						horusAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(39)));
					}
				}
				if (horusAttacking == true && (currPlayer.getName() == horusSun.getName())) {
					horusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (heliosAttacking == true && (currPlayer.getName() != horusSun.getName())) {
					System.out.println("horus was attacked by python");
					gameBoardAttack(territories.get(37), territories.get(39));
					heliosAttacking = false;
					attackPhase = true;

					neighborsLabel.setText("");
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != horusSun.getName())) {
					System.out.println("horus was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(39));
					tonatiuhAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (intiAttacking == true && (currPlayer.getName() != horusSun.getName())) {
					System.out.println("horus was attacked by python");
					gameBoardAttack(territories.get(38), territories.get(39));
					intiAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (amunAttacking == true && (currPlayer.getName() != horusSun.getName())) {
					System.out.println("horus was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(39));
					amunAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((amunFortify == true) && (currPlayer.getName() == horusSun.getName())) {
					territories.get(39).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
					neighborsLabel.setText("");
				}
				if ((intiFortify == true) && (currPlayer.getName() == horusSun.getName())) {
					territories.get(39).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					intiFortify = false;
					neighborsLabel.setText("");
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == horusSun.getName())) {
					territories.get(39).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
					neighborsLabel.setText("");
				}

				if ((heliosFortify == true) && (currPlayer.getName() == horusSun.getName())) {
					territories.get(39).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					heliosFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == horusSun.getName()) {
						System.out.println("fortify from horus!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(39)));
						Object[] range = new Object[territories.get(39).getUnits()];
						for (int i = 1; i < territories.get(39).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(39).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						horusFortify = true;
					}
				}
			}
		});
		tonatiuhSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && tonatiuhSun.getName().equals(currPlayer.getName())) {
						tonatiuhUnits += 1;
						territories.get(40).addUnits(1);
						myLabel.setText("" + tonatiuhUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (tonatiuhSun.getName().equals(currPlayer.getName()))) {
					tonatiuhUnits += 1;
					territories.get(40).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((tonatiuhSun.getName().equals(currPlayer.getName())) && (tonatiuhUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						tonatiuhAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(40)));
					}
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() == tonatiuhSun.getName())) {
					tonatiuhAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (apolloAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(35), territories.get(40));
					apolloAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (horusAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(39), territories.get(40));
					horusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (amunAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(40));
					amunAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(40));
					brooklynsAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (pizzaplanetAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(27), territories.get(40));
					pizzaplanetAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((pizzaplanetFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzaplanetFortify = false;
					neighborsLabel.setText("");
				}
				if ((brooklynFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
					neighborsLabel.setText("");
				}
				if ((amunFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
					neighborsLabel.setText("");
				}
				if ((horusFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
					neighborsLabel.setText("");
				}
				if ((apolloFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					apolloFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == tonatiuhSun.getName()) {
						System.out.println("fortify from ton!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(40)));
						Object[] range = new Object[territories.get(40).getUnits()];
						for (int i = 1; i < territories.get(40).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(40).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						tonatiuhFortify = true;
					}
				}
			}
		});
		amunSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && amunSun.getName().equals(currPlayer.getName())) {
						amunUnits += 1;
						territories.get(41).addUnits(1);
						myLabel.setText("" + amunUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (amunSun.getName().equals(currPlayer.getName()))) {
					amunUnits += 1;
					territories.get(41).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((amunSun.getName().equals(currPlayer.getName())) && (amunUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						amunAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(41)));
					}
				}
				if (amunAttacking == true && (currPlayer.getName() == amunSun.getName())) {
					amunAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (apolloAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(35), territories.get(41));
					apolloAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (raAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(36), territories.get(41));
					raAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (heliosAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(37), territories.get(41));
					heliosAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (horusAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(39), territories.get(41));
					horusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(41));
					tonatiuhAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
					neighborsLabel.setText("");
				}
				if ((horusFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
					neighborsLabel.setText("");
				}
				if ((heliosFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					heliosFortify = false;
					neighborsLabel.setText("");
				}
				if ((raFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					raFortify = false;
					neighborsLabel.setText("");
				}
				if ((apolloFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					apolloFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == amunSun.getName()) {
						System.out.println("fortify from amun!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(41)));
						Object[] range = new Object[territories.get(41).getUnits()];
						for (int i = 1; i < territories.get(41).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(41).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						amunFortify = true;
					}
				}
			}
		});
		rawrvilleDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && rawrvilleDino.getName().equals(currPlayer.getName())) {
						rawrUnits += 1;
						territories.get(7).addUnits(1);
						myLabel.setText("" + rawrUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (rawrvilleDino.getName().equals(currPlayer.getName()))) {
					rawrUnits += 1;
					territories.get(7).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((rawrvilleDino.getName().equals(currPlayer.getName())) && (rawrUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						rawrvilleAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(7)));

					}
				}
				if (rawrvilleAttacking == true && (currPlayer.getName() == rawrvilleDino.getName())) {
					rawrvilleAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (laieggesAttacking == true && (currPlayer.getName() != rawrvilleDino.getName())) {
					System.out.println("rawr was attacked by python");
					gameBoardAttack(territories.get(8), territories.get(7));
					laieggesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != rawrvilleDino.getName())) {
					System.out.println("rawr was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(7));
					dactilitoAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((dactilitoFortify == true) && (currPlayer.getName() == rawrvilleDino.getName())) {
					territories.get(7).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
					neighborsLabel.setText("");
				}
				if ((laieggesFortify == true) && (currPlayer.getName() == rawrvilleDino.getName())) {
					territories.get(7).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					laieggesFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == rawrvilleDino.getName()) {
						System.out.println("fortify from rawr!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(7)));
						Object[] range = new Object[territories.get(7).getUnits()];
						for (int i = 1; i < territories.get(7).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(7).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						rawrFortify = true;
					}
				}
			}
		});
		laieggesDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && laieggesDino.getName().equals(currPlayer.getName())) {
						eggUnits += 1;
						territories.get(8).addUnits(1);
						myLabel.setText("" + eggUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (laieggesDino.getName().equals(currPlayer.getName()))) {
					eggUnits += 1;
					territories.get(8).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((laieggesDino.getName().equals(currPlayer.getName())) && (eggUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						laieggesAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(8)));

					}
				}
				if (laieggesAttacking == true && (currPlayer.getName() == laieggesDino.getName())) {
					laieggesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (rawrvilleAttacking == true && (currPlayer.getName() != laieggesDino.getName())) {
					System.out.println("laiegges was attacked by python");
					gameBoardAttack(territories.get(7), territories.get(8));
					rawrvilleAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != laieggesDino.getName())) {
					System.out.println("laiegges was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(8));
					dactilitoAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != laieggesDino.getName())) {
					System.out.println("laiegges was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(8));
					dirtydanAttacking = false;
					neighborsLabel.setText("");
					attackPhase = true;
				}
				if (crescentcapitalAttacking == true && (currPlayer.getName() != laieggesDino.getName())) {
					System.out.println("laiegges was attacked by python");
					gameBoardAttack(territories.get(34), territories.get(8));
					crescentcapitalAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((crescentcapitalFortify == true) && (currPlayer.getName() == laieggesDino.getName())) {
					territories.get(8).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					crescentcapitalFortify = false;
					neighborsLabel.setText("");
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == laieggesDino.getName())) {
					territories.get(8).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
					neighborsLabel.setText("");
				}
				if ((dactilitoFortify == true) && (currPlayer.getName() == laieggesDino.getName())) {
					territories.get(8).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
					neighborsLabel.setText("");
				}
				if ((rawrFortify == true) && (currPlayer.getName() == laieggesDino.getName())) {
					territories.get(8).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rawrFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == laieggesDino.getName()) {
						System.out.println("fortify from laieeges!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(8)));
						Object[] range = new Object[territories.get(8).getUnits()];
						for (int i = 1; i < territories.get(8).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(8).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						laieggesFortify = true;
					}
				}
			}
		});
		dactilitoDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && dactilitoDino.getName().equals(currPlayer.getName())) {
						dacUnits += 1;
						territories.get(9).addUnits(1);
						myLabel.setText("" + dacUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (dactilitoDino.getName().equals(currPlayer.getName()))) {
					dacUnits += 1;
					territories.get(9).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((dactilitoDino.getName().equals(currPlayer.getName())) && (dacUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						dactilitoAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(9)));

					}
				}
				if (dactilitoAttacking == true && (currPlayer.getName() == dactilitoDino.getName())) {
					dactilitoAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (rawrvilleAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(7), territories.get(9));
					rawrvilleAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (laieggesAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(8), territories.get(9));
					laieggesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(9));
					dirtydanAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (blackbeardAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(11), territories.get(9));
					blackbeardAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (toystoryAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(13), territories.get(9));
					toystoryAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if ((toystoryFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					toystoryFortify = false;
					neighborsLabel.setText("");
				}
				if ((blackbeardFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackbeardFortify = false;
					neighborsLabel.setText("");
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
					neighborsLabel.setText("");
				}
				if ((rawrFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rawrFortify = false;
					neighborsLabel.setText("");
				}
				if ((laieggesFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					laieggesFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == dactilitoDino.getName()) {
						System.out.println("fortify from dac!!");
						neighborsLabel.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(9)));
						Object[] range = new Object[territories.get(9).getUnits()];
						for (int i = 1; i < territories.get(9).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(9).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						dactilitoFortify = true;
					}
				}
			}
		});
		dirtydanDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && dirtydanDino.getName().equals(currPlayer.getName())) {
						danUnits += 1;
						territories.get(10).addUnits(1);
						myLabel.setText("" + danUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (dirtydanDino.getName().equals(currPlayer.getName()))) {
					danUnits += 1;
					territories.get(10).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((dirtydanDino.getName().equals(currPlayer.getName())) && (danUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						dirtydanAttacking = true;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(10)));

					}
				}
				if (dirtydanAttacking == true && (currPlayer.getName() == dirtydanDino.getName())) {
					dirtydanAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (laieggesAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(8), territories.get(10));
					laieggesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(10));
					dactilitoAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (blackbeardAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(11), territories.get(10));
					blackbeardAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (monisaurusAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(12), territories.get(10));
					monisaurusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(10));
					newlandofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (bloobawlAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(33), territories.get(10));
					bloobawlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (crescentcapitalAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(34), territories.get(10));
					crescentcapitalAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((crescentcapitalFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					crescentcapitalFortify = false;
					neighborsLabel.setText("");
				}
				if ((newlandofzachFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
					neighborsLabel.setText("");
				}
				if ((bloobawlFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					bloobawlFortify = false;
					neighborsLabel.setText("");
				}
				if ((monisaurusFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					monisaurusFortify = false;
					neighborsLabel.setText("");
				}
				if ((blackbeardFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackbeardFortify = false;
					neighborsLabel.setText("");
				}
				if ((dactilitoFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
					neighborsLabel.setText("");
				}
				if ((laieggesFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					laieggesFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == dirtydanDino.getName()) {
						System.out.println("fortify from dirty!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(10)));
						Object[] range = new Object[territories.get(10).getUnits()];
						for (int i = 1; i < territories.get(10).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(10).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						dirtydanFortify = true;
					}
				}

			}
		});
		blackbeardDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && blackbeardDino.getName().equals(currPlayer.getName())) {
						bbUnits += 1;
						territories.get(11).addUnits(1);
						myLabel.setText("" + bbUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (blackbeardDino.getName().equals(currPlayer.getName()))) {
					bbUnits += 1;
					territories.get(11).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((blackbeardDino.getName().equals(currPlayer.getName())) && (bbUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						blackbeardAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(11)));

					}
				}
				if (blackbeardAttacking == true && (currPlayer.getName() == blackbeardDino.getName())) {
					blackbeardAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != blackbeardDino.getName())) {
					System.out.println("blackbeard was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(11));
					dactilitoAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != blackbeardDino.getName())) {
					System.out.println("blackbeard was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(11));
					dirtydanAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (monisaurusAttacking == true && (currPlayer.getName() != blackbeardDino.getName())) {
					System.out.println("blackbeard was attacked by python");
					gameBoardAttack(territories.get(12), territories.get(11));
					monisaurusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (toystoryAttacking == true && (currPlayer.getName() != blackbeardDino.getName())) {
					System.out.println("blackbeard was attacked by python");
					gameBoardAttack(territories.get(13), territories.get(11));
					toystoryAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((toystoryFortify == true) && (currPlayer.getName() == blackbeardDino.getName())) {
					territories.get(11).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					toystoryFortify = false;
					neighborsLabel.setText("");
				}
				if ((monisaurusFortify == true) && (currPlayer.getName() == blackbeardDino.getName())) {
					territories.get(11).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					monisaurusFortify = false;
					neighborsLabel.setText("");
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == blackbeardDino.getName())) {
					territories.get(11).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
					neighborsLabel.setText("");
				}
				if ((dactilitoFortify == true) && (currPlayer.getName() == blackbeardDino.getName())) {
					territories.get(11).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == blackbeardDino.getName()) {
						System.out.println("fortify from black!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(11)));
						Object[] range = new Object[territories.get(11).getUnits()];
						for (int i = 1; i < territories.get(11).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(11).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						blackbeardFortify = true;
					}
				}
			}
		});
		monisaurusDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && monisaurusDino.getName().equals(currPlayer.getName())) {
						moniUnits += 1;
						territories.get(12).addUnits(1);
						myLabel.setText("" + moniUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (monisaurusDino.getName().equals(currPlayer.getName()))) {
					moniUnits += 1;
					territories.get(12).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((monisaurusDino.getName().equals(currPlayer.getName())) && (moniUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						monisaurusAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(12)));
					}
				}
				if (monisaurusAttacking == true && (currPlayer.getName() == monisaurusDino.getName())) {
					monisaurusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != monisaurusDino.getName())) {
					System.out.println("moni was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(12));
					dirtydanAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (blackjackAttacking == true && (currPlayer.getName() != monisaurusDino.getName())) {
					System.out.println("moni was attacked by python");
					gameBoardAttack(territories.get(24), territories.get(12));
					blackjackAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (toystoryAttacking == true && (currPlayer.getName() != monisaurusDino.getName())) {
					System.out.println("moni was attacked by python");
					gameBoardAttack(territories.get(13), territories.get(12));
					toystoryAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != monisaurusDino.getName())) {
					System.out.println("moni was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(12));
					newlandofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((newlandofzachFortify == true) && (currPlayer.getName() == monisaurusDino.getName())) {
					territories.get(12).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
					neighborsLabel.setText("");
				}
				if ((toystoryFortify == true) && (currPlayer.getName() == monisaurusDino.getName())) {
					territories.get(12).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					toystoryFortify = false;
					neighborsLabel.setText("");
				}
				if ((blackjackFortify == true) && (currPlayer.getName() == monisaurusDino.getName())) {
					territories.get(12).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackjackFortify = false;
					neighborsLabel.setText("");
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == monisaurusDino.getName())) {
					territories.get(12).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == monisaurusDino.getName()) {
						System.out.println("fortify from moni!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(12)));
						Object[] range = new Object[territories.get(12).getUnits()];
						for (int i = 1; i < territories.get(12).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(12).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						monisaurusFortify = true;
					}
				}
			}
		});
		toystoryDino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && toystoryDino.getName().equals(currPlayer.getName())) {
						tsUnits += 1;
						territories.get(13).addUnits(1);
						myLabel.setText("" + tsUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (toystoryDino.getName().equals(currPlayer.getName()))) {
					tsUnits += 1;
					territories.get(13).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((toystoryDino.getName().equals(currPlayer.getName())) && (tsUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						toystoryAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(13)));
					}
				}
				if (toystoryAttacking == true && (currPlayer.getName() == toystoryDino.getName())) {
					toystoryAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != toystoryDino.getName())) {
					System.out.println("toystory was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(13));
					dactilitoAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (blackbeardAttacking == true && (currPlayer.getName() != toystoryDino.getName())) {
					System.out.println("toystory was attacked by python");
					gameBoardAttack(territories.get(11), territories.get(13));
					blackbeardAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (monisaurusAttacking == true && (currPlayer.getName() != toystoryDino.getName())) {
					System.out.println("toystory was attacked by python");
					gameBoardAttack(territories.get(12), territories.get(13));
					monisaurusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((monisaurusFortify == true) && (currPlayer.getName() == toystoryDino.getName())) {
					territories.get(13).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					monisaurusFortify = false;
					neighborsLabel.setText("");
				}
				if ((blackbeardFortify == true) && (currPlayer.getName() == toystoryDino.getName())) {
					territories.get(13).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackbeardFortify = false;
					neighborsLabel.setText("");
				}
				if ((dactilitoFortify == true) && (currPlayer.getName() == toystoryDino.getName())) {
					territories.get(13).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == toystoryDino.getName()) {
						System.out.println("fortify from toystroy!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(13)));
						Object[] range = new Object[territories.get(13).getUnits()];
						for (int i = 1; i < territories.get(13).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(13).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						toystoryFortify = true;
					}
				}
			}
		});
		scraptopiaCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {

					if (currPlayer.getNumOfArmies() >= 1 && scraptopiaCresent.getName().equals(currPlayer.getName())) {
						scrapUnits += 1;
						territories.get(28).addUnits(1);
						myLabel.setText("" + scrapUnits);

						playsong = new Play1Song(coin);

						currPlayer.removeArmies(1);

						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (scraptopiaCresent.getName().equals(currPlayer.getName()))) {
					scrapUnits += 1;
					territories.get(28).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((scraptopiaCresent.getName().equals(currPlayer.getName())) && (scrapUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						scraptopiaAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(28)));
					}
				}
				if (scraptopiaAttacking == true && (currPlayer.getName() == scraptopiaCresent.getName())) {
					scraptopiaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (landofzachAttacking == true && (currPlayer.getName() != scraptopiaCresent.getName())) {
					System.out.println("scraptopia was attacked by python");
					gameBoardAttack(territories.get(29), territories.get(28));
					scraptopiaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (millerAttacking == true && (currPlayer.getName() != scraptopiaCresent.getName())) {
					System.out.println("scraptopia was attacked by python");
					gameBoardAttack(territories.get(17), territories.get(28));
					millerAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if ((millerFortify == true) && (currPlayer.getName() == scraptopiaCresent.getName())) {
					territories.get(28).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					millerFortify = false;
					neighborsLabel.setText("");
				}
				if ((landofzachFortify == true) && (currPlayer.getName() == scraptopiaCresent.getName())) {
					territories.get(28).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					landofzachFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == scraptopiaCresent.getName()) {
						System.out.println("fortify from scrap!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(28)));
						Object[] range = new Object[territories.get(28).getUnits()];
						for (int i = 1; i < territories.get(28).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(28).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						scraptopiaFortify = true;
					}
				}

			}
		});
		landofzachCresent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {

					if (currPlayer.getNumOfArmies() >= 1 && landofzachCresent.getName().equals(currPlayer.getName())) {
						zachUnits += 1;
						territories.get(29).addUnits(1);
						myLabel.setText("" + zachUnits);
						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (landofzachCresent.getName().equals(currPlayer.getName()))) {
					zachUnits += 1;
					territories.get(29).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((landofzachCresent.getName().equals(currPlayer.getName())) && (zachUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						landofzachAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(29)));
					}
				}
				if (landofzachAttacking == true && (currPlayer.getName() == landofzachCresent.getName())) {
					landofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (scraptopiaAttacking == true && (currPlayer.getName() != landofzachCresent.getName())) {
					System.out.println("landofzach was attacked by python");
					gameBoardAttack(territories.get(28), territories.get(29));
					scraptopiaAttacking = false;
					attackPhase = true;
				}
				if (giantAttacking == true && (currPlayer.getName() != landofzachCresent.getName())) {
					System.out.println("landofzach was attacked by python");
					gameBoardAttack(territories.get(30), territories.get(29));
					giantAttacking = false;
					attackPhase = true;
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != landofzachCresent.getName())) {
					System.out.println("landofzach was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(29));
					newlandofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if ((newlandofzachFortify == true) && (currPlayer.getName() == landofzachCresent.getName())) {
					territories.get(29).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
					neighborsLabel.setText("");
				}
				if ((giantFortify == true) && (currPlayer.getName() == landofzachCresent.getName())) {
					territories.get(29).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
					neighborsLabel.setText("");
				}
				if ((scraptopiaFortify == true) && (currPlayer.getName() == landofzachCresent.getName())) {
					territories.get(29).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scraptopiaFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == landofzachCresent.getName()) {
						System.out.println("fortify from lozach!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(29)));
						Object[] range = new Object[territories.get(29).getUnits()];
						for (int i = 1; i < territories.get(29).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(29).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						landofzachFortify = true;
					}
				}
			}
		});
		giantCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {

					if (currPlayer.getNumOfArmies() >= 1 && giantCresent.getName().equals(currPlayer.getName())) {
						giantUnits += 1;
						territories.get(30).addUnits(1);
						myLabel.setText("" + giantUnits);

						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (giantCresent.getName().equals(currPlayer.getName()))) {
					giantUnits += 1;
					territories.get(30).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((giantCresent.getName().equals(currPlayer.getName())) && (giantUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						giantAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(30)));
					}
				}
				if (giantAttacking == true && (currPlayer.getName() == giantCresent.getName())) {
					giantAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (landofzachAttacking == true && (currPlayer.getName() != giantCresent.getName())) {
					System.out.println("giant was attacked by python");
					gameBoardAttack(territories.get(29), territories.get(30));
					landofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (southscraptopiaAttacking == true && (currPlayer.getName() != giantCresent.getName())) {
					System.out.println("giant was attacked by python");
					gameBoardAttack(territories.get(32), territories.get(30));
					southscraptopiaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (bloobawlAttacking == true && (currPlayer.getName() != giantCresent.getName())) {
					System.out.println("giant was attacked by python");
					gameBoardAttack(territories.get(33), territories.get(30));
					bloobawlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (rubyAttacking == true && (currPlayer.getName() != giantCresent.getName())) {
					System.out.println("giant was attacked by python");
					gameBoardAttack(territories.get(4), territories.get(30));
					rubyAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((rubyFortify == true) && (currPlayer.getName() == giantCresent.getName())) {
					territories.get(30).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rubyFortify = false;
					neighborsLabel.setText("");
				}
				if ((bloobawlFortify == true) && (currPlayer.getName() == giantCresent.getName())) {
					territories.get(30).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					bloobawlFortify = false;
					neighborsLabel.setText("");
				}
				if ((southscraptopiaFortify == true) && (currPlayer.getName() == giantCresent.getName())) {
					territories.get(30).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					southscraptopiaFortify = false;
					neighborsLabel.setText("");
				}
				if ((landofzachFortify == true) && (currPlayer.getName() == giantCresent.getName())) {
					territories.get(30).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					landofzachFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == giantCresent.getName()) {
						System.out.println("fortify from giant!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(30)));
						Object[] range = new Object[territories.get(30).getUnits()];
						for (int i = 1; i < territories.get(30).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(30).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						giantFortify = true;
					}
				}

			}
		});
		newlandofzachCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && newlandofzachCresent.getName().equals(currPlayer.getName())) {
						newzachUnits += 1;
						territories.get(31).addUnits(1);
						myLabel.setText("" + newzachUnits);

						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (newlandofzachCresent.getName().equals(currPlayer.getName()))) {
					newzachUnits += 1;
					territories.get(31).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((newlandofzachCresent.getName().equals(currPlayer.getName())) && (newzachUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						newlandofzachAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(31)));
					}
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() == newlandofzachCresent.getName())) {
					newlandofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (landofzachAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(29), territories.get(31));
					landofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (southscraptopiaAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(32), territories.get(31));
					southscraptopiaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (bloobawlAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(33), territories.get(31));
					bloobawlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(31));
					dirtydanAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (monisaurusAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(12), territories.get(31));
					monisaurusAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((monisaurusFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					monisaurusFortify = false;
					neighborsLabel.setText("");
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
					neighborsLabel.setText("");
				}
				if ((bloobawlFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					bloobawlFortify = false;
					neighborsLabel.setText("");
				}
				if ((southscraptopiaFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					southscraptopiaFortify = false;
					neighborsLabel.setText("");
				}
				if ((landofzachFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					landofzachFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == newlandofzachCresent.getName()) {
						System.out.println("fortify from newland!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(31)));
						Object[] range = new Object[territories.get(31).getUnits()];
						for (int i = 1; i < territories.get(31).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(31).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						newlandofzachFortify = true;
					}
				}
			}
		});
		southscraptopiaCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && southscraptopiaCresent.getName().equals(currPlayer.getName())) {
						southUnits += 1;
						territories.get(32).addUnits(1);
						myLabel.setText("" + southUnits);

						playsong = new Play1Song(coin);

						currPlayer.removeArmies(1);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (southscraptopiaCresent.getName().equals(currPlayer.getName()))) {
					southUnits += 1;
					territories.get(32).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((southscraptopiaCresent.getName().equals(currPlayer.getName())) && (southUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						southscraptopiaAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(32)));
					}
				}
				if (southscraptopiaAttacking == true && (currPlayer.getName() == southscraptopiaCresent.getName())) {
					southscraptopiaAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (giantAttacking == true && (currPlayer.getName() != southscraptopiaCresent.getName())) {
					System.out.println("southscraptopia was attacked by python");
					gameBoardAttack(territories.get(30), territories.get(32));
					giantAttacking = false;
					neighborsLabel.setText("");
					attackPhase = true;
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != southscraptopiaCresent.getName())) {
					System.out.println("southscraptopia was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(32));
					newlandofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((newlandofzachFortify == true) && (currPlayer.getName() == southscraptopiaCresent.getName())) {
					territories.get(32).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
					neighborsLabel.setText("");
				}
				if ((giantFortify == true) && (currPlayer.getName() == southscraptopiaCresent.getName())) {
					territories.get(32).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == southscraptopiaCresent.getName()) {
						System.out.println("fortify from southscrap!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(32)));
						Object[] range = new Object[territories.get(32).getUnits()];
						for (int i = 1; i < territories.get(32).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(32).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						southscraptopiaFortify = true;
					}
				}
			}
		});
		bloobawlCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && bloobawlCresent.getName().equals(currPlayer.getName())) {
						blooUnits += 1;
						territories.get(33).addUnits(1);
						myLabel.setText("" + blooUnits);

						currPlayer.removeArmies(1);
						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (bloobawlCresent.getName().equals(currPlayer.getName()))) {
					blooUnits += 1;
					territories.get(33).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((bloobawlCresent.getName().equals(currPlayer.getName())) && (blooUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						
						bloobawlAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(33)));
					}
				}
				if (bloobawlAttacking == true && (currPlayer.getName() == bloobawlCresent.getName())) {
					bloobawlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (giantAttacking == true && (currPlayer.getName() != bloobawlCresent.getName())) {
					System.out.println("bloobawl was attacked by python");
					gameBoardAttack(territories.get(30), territories.get(33));
					giantAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != bloobawlCresent.getName())) {
					System.out.println("bloobawl was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(33));
					newlandofzachAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (crescentcapitalAttacking == true && (currPlayer.getName() != bloobawlCresent.getName())) {
					System.out.println("bloobawl was attacked by python");
					gameBoardAttack(territories.get(34), territories.get(33));
					crescentcapitalAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != bloobawlCresent.getName())) {
					System.out.println("bloobawl was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(33));
					dirtydanAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == bloobawlCresent.getName())) {
					territories.get(33).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
					neighborsLabel.setText("");
				}
				if ((crescentcapitalFortify == true) && (currPlayer.getName() == bloobawlCresent.getName())) {
					territories.get(33).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					crescentcapitalFortify = false;
					neighborsLabel.setText("");
				}
				if ((newlandofzachFortify == true) && (currPlayer.getName() == bloobawlCresent.getName())) {
					territories.get(33).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
					neighborsLabel.setText("");
				}
				if ((giantFortify == true) && (currPlayer.getName() == bloobawlCresent.getName())) {
					territories.get(33).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
					neighborsLabel.setText("");
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == bloobawlCresent.getName()) {
						System.out.println("fortify from bloo!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(33)));
						Object[] range = new Object[territories.get(33).getUnits()];
						for (int i = 1; i < territories.get(33).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(33).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						bloobawlFortify = true;
					}
				}
			}
		});
		cresentcaptitalCresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);

				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && cresentcaptitalCresent.getName().equals(currPlayer.getName())) {
						capUnits += 1;
						territories.get(34).addUnits(1);
						myLabel.setText("" + capUnits);

						currPlayer.removeArmies(1);

						playsong = new Play1Song(coin);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
				if ((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0)
						&& (cresentcaptitalCresent.getName().equals(currPlayer.getName()))) {
					capUnits += 1;
					territories.get(34).addUnits(1);

					currPlayer.removeArmies(1);
					updateLabels();
					moveTurnLabel();
					if(currPlayer.getNumOfArmies()<1){
						gameStatus.setText("ATTACK!");
					}
				} else if (attackPhase == true) {
					if ((cresentcaptitalCresent.getName().equals(currPlayer.getName())) && (capUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						//
						crescentcapitalAttacking = true;
						attackPhase = false;

						neighborsLabel.setText("You may attack " + newGame.getEnemyTerritories(territories.get(34)));

					}
				}
				if (crescentcapitalAttacking == true && (currPlayer.getName() == cresentcaptitalCresent.getName())) {
					crescentcapitalAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (bloobawlAttacking == true && (currPlayer.getName() != cresentcaptitalCresent.getName())) {
					System.out.println("crescent capital was attacked by python");
					gameBoardAttack(territories.get(33), territories.get(34));
					bloobawlAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (laieggesAttacking == true && (currPlayer.getName() != cresentcaptitalCresent.getName())) {
					System.out.println("crescent capital was attacked by python");
					gameBoardAttack(territories.get(8), territories.get(34));
					laieggesAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != cresentcaptitalCresent.getName())) {
					System.out.println("crescent capital was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(34));
					dirtydanAttacking = false;
					attackPhase = true;
					neighborsLabel.setText("");
				}

				if ((dirtydanFortify == true) && (currPlayer.getName() == cresentcaptitalCresent.getName())) {
					territories.get(34).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
					neighborsLabel.setText("");
				}
				if ((laieggesFortify == true) && (currPlayer.getName() == cresentcaptitalCresent.getName())) {
					territories.get(34).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					laieggesFortify = false;
					neighborsLabel.setText("");
				}
				if ((bloobawlFortify == true) && (currPlayer.getName() == cresentcaptitalCresent.getName())) {
					territories.get(34).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					bloobawlFortify = false;
					neighborsLabel.setText("");
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == cresentcaptitalCresent.getName()) {
						System.out.println("fortify from scrap!!");
						neighborsLabel
								.setText("You may fortify " + newGame.getFriendlyTerritories(territories.get(34)));
						Object[] range = new Object[territories.get(34).getUnits()];
						for (int i = 1; i < territories.get(34).getUnits(); i++) {
							range[i] = i;
						}

						unitsFortified = (int) JOptionPane.showInputDialog(null, "How many units?", "Select Units",
								JOptionPane.PLAIN_MESSAGE, null, range, "Numbers");

						territories.get(34).removeUnits(unitsFortified);
						updateLabels();
						fortifyPhase = false;
						crescentcapitalFortify = true;
					}
				}

			}
		});

		/// ALL OF LAUNGUAGE***
		javaUnits = 1;
		pythonUnits = 1;
		cUnits = 1;
		sqlUnits = 1;
		rubyUnits = 1;
		gitUnits = 1;
		perlUnits = 1;

		languageLabel1 = new JLabel("" + javaUnits);
		languageLabel2 = new JLabel("" + pythonUnits);
		languageLabel3 = new JLabel("" + cUnits);
		languageLabel4 = new JLabel("" + sqlUnits);
		languageLabel5 = new JLabel("" + rubyUnits);
		languageLabel6 = new JLabel("" + gitUnits);
		languageLabel7 = new JLabel("" + perlUnits);

		javaLanguage.setSize(25, 25);
		javaLanguage.setLocation(720, 95);
		javaLanguage.setOpaque(false);
		javaLanguage.setContentAreaFilled(false);
		javaLanguage.setBorderPainted(false);

		languageLabel1.setSize(25, 25);
		languageLabel1.setFont(font);
		languageLabel1.setForeground(Color.BLACK);
		languageLabel1.setLocation(728, 98);
		languageLabel1.setOpaque(false);

		pythonLanguage.setSize(25, 25);
		pythonLanguage.setLocation(840, 80);
		pythonLanguage.setOpaque(false);
		pythonLanguage.setContentAreaFilled(false);
		pythonLanguage.setBorderPainted(false);

		languageLabel2.setSize(25, 25);
		languageLabel2.setFont(font);
		languageLabel2.setForeground(Color.BLACK);
		languageLabel2.setLocation(848, 83);
		languageLabel2.setOpaque(false);

		cLanguage.setSize(25, 25);
		cLanguage.setLocation(725, 140);
		cLanguage.setOpaque(false);
		cLanguage.setContentAreaFilled(false);
		cLanguage.setBorderPainted(false);

		languageLabel3.setSize(25, 25);
		languageLabel3.setFont(font);
		languageLabel3.setForeground(Color.BLACK);
		languageLabel3.setLocation(733, 143);
		languageLabel3.setOpaque(false);

		sqlLanguage.setSize(25, 25);
		sqlLanguage.setLocation(800, 110);
		sqlLanguage.setOpaque(false);
		sqlLanguage.setContentAreaFilled(false);
		sqlLanguage.setBorderPainted(false);

		languageLabel4.setSize(25, 25);
		languageLabel4.setFont(font);
		languageLabel4.setForeground(Color.BLACK);
		languageLabel4.setLocation(808, 113);
		languageLabel4.setOpaque(false);

		rubyLanguage.setSize(25, 25);
		rubyLanguage.setLocation(780, 160);
		rubyLanguage.setOpaque(false);
		rubyLanguage.setContentAreaFilled(false);
		rubyLanguage.setBorderPainted(false);

		languageLabel5.setSize(25, 25);
		languageLabel5.setFont(font);
		languageLabel5.setForeground(Color.BLACK);
		languageLabel5.setLocation(788, 163);
		languageLabel5.setOpaque(false);

		gitLanguage.setSize(25, 25);
		gitLanguage.setLocation(840, 135);
		gitLanguage.setOpaque(false);
		gitLanguage.setContentAreaFilled(false);
		gitLanguage.setBorderPainted(false);

		languageLabel6.setSize(25, 25);
		languageLabel6.setFont(font);
		languageLabel6.setForeground(Color.BLACK);
		languageLabel6.setLocation(848, 138);
		languageLabel6.setOpaque(false);

		perlLanguage.setSize(25, 25);
		perlLanguage.setLocation(890, 125);
		perlLanguage.setOpaque(false);
		perlLanguage.setContentAreaFilled(false);
		perlLanguage.setBorderPainted(false);

		languageLabel7.setSize(25, 25);
		languageLabel7.setFont(font);
		languageLabel7.setForeground(Color.BLACK);
		languageLabel7.setLocation(898, 128);
		languageLabel7.setOpaque(false);

		myMap = new HashMap<JButton, JLabel>();
		myMap.put(perlLanguage, languageLabel7);
		myMap.put(javaLanguage, languageLabel1);
		myMap.put(pythonLanguage, languageLabel2);
		myMap.put(cLanguage, languageLabel3);
		myMap.put(sqlLanguage, languageLabel4);
		myMap.put(rubyLanguage, languageLabel5);
		myMap.put(gitLanguage, languageLabel6);

		// ALL OF WILDCAT***
		wilberUnits = 1;
		wilmaUnits = 1;
		richUnits = 1;
		millerUnits = 1;
		scoobyUnits = 1;
		mckaleUnits = 1;
		zonaUnits = 1;

		wildcatLabel1 = new JLabel("" + wilberUnits);
		wildcatLabel2 = new JLabel("" + wilmaUnits);
		wildcatLabel3 = new JLabel("" + richUnits);
		wildcatLabel4 = new JLabel("" + millerUnits);
		wildcatLabel5 = new JLabel("" + scoobyUnits);
		wildcatLabel6 = new JLabel("" + mckaleUnits);
		wildcatLabel7 = new JLabel("" + zonaUnits);

		wilberWildcat.setSize(25, 25);
		wilberWildcat.setLocation(395, 300);
		wilberWildcat.setOpaque(false);
		wilberWildcat.setContentAreaFilled(false);
		wilberWildcat.setBorderPainted(false);

		wildcatLabel1.setSize(25, 25);
		wildcatLabel1.setFont(font);
		wildcatLabel1.setForeground(Color.BLACK);
		wildcatLabel1.setLocation(403, 303);
		wildcatLabel1.setOpaque(false);

		wilmaWildcat.setSize(25, 25);
		wilmaWildcat.setLocation(460, 285);
		wilmaWildcat.setOpaque(false);
		wilmaWildcat.setContentAreaFilled(false);
		wilmaWildcat.setBorderPainted(false);

		wildcatLabel2.setSize(25, 25);
		wildcatLabel2.setFont(font);
		wildcatLabel2.setForeground(Color.BLACK);
		wildcatLabel2.setLocation(468, 288);
		wildcatLabel2.setOpaque(false);

		richWildcat.setSize(25, 25);
		richWildcat.setLocation(520, 365);
		richWildcat.setOpaque(false);
		richWildcat.setContentAreaFilled(false);
		richWildcat.setBorderPainted(false);

		wildcatLabel3.setSize(25, 25);
		wildcatLabel3.setFont(font);
		wildcatLabel3.setForeground(Color.BLACK);
		wildcatLabel3.setLocation(528, 368);
		wildcatLabel3.setOpaque(false);

		millerWildcat.setSize(25, 25);
		millerWildcat.setLocation(560, 340);
		millerWildcat.setOpaque(false);
		millerWildcat.setContentAreaFilled(false);
		millerWildcat.setBorderPainted(false);

		wildcatLabel4.setSize(25, 25);
		wildcatLabel4.setFont(font);
		wildcatLabel4.setForeground(Color.BLACK);
		wildcatLabel4.setLocation(568, 343);
		wildcatLabel4.setOpaque(false);

		scoobyWildcat.setSize(25, 25);
		scoobyWildcat.setLocation(380, 375);
		scoobyWildcat.setOpaque(false);
		scoobyWildcat.setContentAreaFilled(false);
		scoobyWildcat.setBorderPainted(false);

		wildcatLabel5.setSize(25, 25);
		wildcatLabel5.setFont(font);
		wildcatLabel5.setForeground(Color.BLACK);
		wildcatLabel5.setLocation(388, 378);
		wildcatLabel5.setOpaque(false);

		mckaleWildcat.setSize(25, 25);
		mckaleWildcat.setLocation(450, 370);
		mckaleWildcat.setOpaque(false);
		mckaleWildcat.setContentAreaFilled(false);
		mckaleWildcat.setBorderPainted(false);

		wildcatLabel6.setSize(25, 25);
		wildcatLabel6.setFont(font);
		wildcatLabel6.setForeground(Color.BLACK);
		wildcatLabel6.setLocation(458, 373);
		wildcatLabel6.setOpaque(false);

		zonaWildcat.setSize(25, 25);
		zonaWildcat.setLocation(450, 430);
		zonaWildcat.setOpaque(false);
		zonaWildcat.setContentAreaFilled(false);
		zonaWildcat.setBorderPainted(false);

		wildcatLabel7.setSize(25, 25);
		wildcatLabel7.setFont(font);
		wildcatLabel7.setForeground(Color.BLACK);
		wildcatLabel7.setLocation(458, 433);
		wildcatLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(wilberWildcat, wildcatLabel1);
		myMap.put(wilmaWildcat, wildcatLabel2);
		myMap.put(richWildcat, wildcatLabel3);
		myMap.put(millerWildcat, wildcatLabel4);
		myMap.put(scoobyWildcat, wildcatLabel5);
		myMap.put(mckaleWildcat, wildcatLabel6);
		myMap.put(zonaWildcat, wildcatLabel7);

		// ALL FOR PIZZA***
		pjUnits = 1;
		domUnits = 1;
		phUnits = 1;
		bjUnits = 1;
		hhUnits = 1;
		bUnits = 1;
		ppUnits = 1;

		pizzaLabel1 = new JLabel("" + pjUnits);
		pizzaLabel2 = new JLabel("" + domUnits);
		pizzaLabel3 = new JLabel("" + phUnits);
		pizzaLabel4 = new JLabel("" + bjUnits);
		pizzaLabel5 = new JLabel("" + hhUnits);
		pizzaLabel6 = new JLabel("" + bUnits);
		pizzaLabel7 = new JLabel("" + ppUnits);

		papajohnsPizza.setSize(25, 25);
		papajohnsPizza.setLocation(290, 260);
		papajohnsPizza.setOpaque(false);
		papajohnsPizza.setContentAreaFilled(false);
		papajohnsPizza.setBorderPainted(false);

		pizzaLabel1.setSize(25, 25);
		pizzaLabel1.setFont(font);
		pizzaLabel1.setForeground(Color.BLACK);
		pizzaLabel1.setLocation(298, 263);
		pizzaLabel1.setOpaque(false);

		dominosPizza.setSize(25, 25);
		dominosPizza.setLocation(360, 287);
		dominosPizza.setOpaque(false);
		dominosPizza.setContentAreaFilled(false);
		dominosPizza.setBorderPainted(false);

		pizzaLabel2.setSize(25, 25);
		pizzaLabel2.setFont(font);
		pizzaLabel2.setForeground(Color.BLACK);
		pizzaLabel2.setLocation(368, 290);
		pizzaLabel2.setOpaque(false);

		pizzahutPizza.setSize(25, 25);
		pizzahutPizza.setLocation(320, 248);
		pizzahutPizza.setOpaque(false);
		pizzahutPizza.setContentAreaFilled(false);
		pizzahutPizza.setBorderPainted(false);

		pizzaLabel3.setSize(25, 25);
		pizzaLabel3.setFont(font);
		pizzaLabel3.setForeground(Color.BLACK);
		pizzaLabel3.setLocation(328, 251);
		pizzaLabel3.setOpaque(false);

		blackjackPizza.setSize(25, 25);
		blackjackPizza.setLocation(306, 208);
		blackjackPizza.setOpaque(false);
		blackjackPizza.setContentAreaFilled(false);
		blackjackPizza.setBorderPainted(false);

		pizzaLabel4.setSize(25, 25);
		pizzaLabel4.setFont(font);
		pizzaLabel4.setForeground(Color.BLACK);
		pizzaLabel4.setLocation(315, 211);
		pizzaLabel4.setOpaque(false);

		hungryhowiesPizza.setSize(25, 25);
		hungryhowiesPizza.setLocation(368, 196);
		hungryhowiesPizza.setOpaque(false);
		hungryhowiesPizza.setContentAreaFilled(false);
		hungryhowiesPizza.setBorderPainted(false);

		pizzaLabel5.setSize(25, 25);
		pizzaLabel5.setFont(font);
		pizzaLabel5.setForeground(Color.BLACK);
		pizzaLabel5.setLocation(376, 199);
		pizzaLabel5.setOpaque(false);

		brooklynPizza.setSize(25, 25);
		brooklynPizza.setLocation(398, 224);
		brooklynPizza.setOpaque(false);
		brooklynPizza.setContentAreaFilled(false);
		brooklynPizza.setBorderPainted(false);

		pizzaLabel6.setSize(25, 25);
		pizzaLabel6.setFont(font);
		pizzaLabel6.setForeground(Color.BLACK);
		pizzaLabel6.setLocation(406, 227);
		pizzaLabel6.setOpaque(false);

		pizzaplanetPizza.setSize(25, 25);
		pizzaplanetPizza.setLocation(440, 196);
		pizzaplanetPizza.setOpaque(false);
		pizzaplanetPizza.setContentAreaFilled(false);
		pizzaplanetPizza.setBorderPainted(false);

		pizzaLabel7.setSize(25, 25);
		pizzaLabel7.setFont(font);
		pizzaLabel7.setForeground(Color.BLACK);
		pizzaLabel7.setLocation(448, 199);
		pizzaLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(papajohnsPizza, pizzaLabel1);
		myMap.put(dominosPizza, pizzaLabel2);
		myMap.put(pizzahutPizza, pizzaLabel3);
		myMap.put(blackjackPizza, pizzaLabel4);
		myMap.put(hungryhowiesPizza, pizzaLabel5);
		myMap.put(brooklynPizza, pizzaLabel6);
		myMap.put(pizzaplanetPizza, pizzaLabel7);

		// ALL of SUNN****
		apolloUnits = 1;
		raUnits = 1;
		heliosUnits = 1;
		intiUnits = 1;
		horusUnits = 1;
		tonatiuhUnits = 1;
		amunUnits = 1;

		sunLabel1 = new JLabel("" + apolloUnits);
		sunLabel2 = new JLabel("" + raUnits);
		sunLabel3 = new JLabel("" + heliosUnits);
		sunLabel4 = new JLabel("" + intiUnits);
		sunLabel5 = new JLabel("" + horusUnits);
		sunLabel6 = new JLabel("" + tonatiuhUnits);
		sunLabel7 = new JLabel("" + amunUnits);

		apolloSun.setSize(25, 25);
		apolloSun.setLocation(460, 115);
		apolloSun.setOpaque(false);
		apolloSun.setContentAreaFilled(false);
		apolloSun.setBorderPainted(false);

		sunLabel1.setSize(25, 25);
		sunLabel1.setFont(font);
		sunLabel1.setForeground(Color.BLACK);
		sunLabel1.setLocation(468, 118);
		sunLabel1.setOpaque(false);

		raSun.setSize(25, 25);
		raSun.setLocation(530, 99);
		raSun.setOpaque(false);
		raSun.setContentAreaFilled(false);
		raSun.setBorderPainted(false);

		sunLabel2.setSize(25, 25);
		sunLabel2.setFont(font);
		sunLabel2.setForeground(Color.BLACK);
		sunLabel2.setLocation(538, 102);
		sunLabel2.setOpaque(false);

		heliosSun.setSize(25, 25);
		heliosSun.setLocation(570, 111);
		heliosSun.setOpaque(false);
		heliosSun.setContentAreaFilled(false);
		heliosSun.setBorderPainted(false);

		sunLabel3.setSize(25, 25);
		sunLabel3.setFont(font);
		sunLabel3.setForeground(Color.BLACK);
		sunLabel3.setLocation(578, 114);
		sunLabel3.setOpaque(false);

		intiSun.setSize(25, 25);
		intiSun.setLocation(560, 165);
		intiSun.setOpaque(false);
		intiSun.setContentAreaFilled(false);
		intiSun.setBorderPainted(false);

		sunLabel4.setSize(25, 25);
		sunLabel4.setFont(font);
		sunLabel4.setForeground(Color.BLACK);
		sunLabel4.setLocation(568, 168);
		sunLabel4.setOpaque(false);

		horusSun.setSize(25, 25);
		horusSun.setLocation(530, 215);
		horusSun.setOpaque(false);
		horusSun.setContentAreaFilled(false);
		horusSun.setBorderPainted(false);

		sunLabel5.setSize(25, 25);
		sunLabel5.setFont(font);
		sunLabel5.setForeground(Color.BLACK);
		sunLabel5.setLocation(538, 218);
		sunLabel5.setOpaque(false);

		tonatiuhSun.setSize(25, 25);
		tonatiuhSun.setLocation(495, 200);
		tonatiuhSun.setOpaque(false);
		tonatiuhSun.setContentAreaFilled(false);
		tonatiuhSun.setBorderPainted(false);

		sunLabel6.setSize(25, 25);
		sunLabel6.setFont(font);
		sunLabel6.setForeground(Color.BLACK);
		sunLabel6.setLocation(503, 203);
		sunLabel6.setOpaque(false);

		amunSun.setSize(25, 25);
		amunSun.setLocation(515, 155);
		amunSun.setOpaque(false);
		amunSun.setContentAreaFilled(false);
		amunSun.setBorderPainted(false);

		sunLabel7.setSize(25, 25);
		sunLabel7.setFont(font);
		sunLabel7.setForeground(Color.BLACK);
		sunLabel7.setLocation(523, 158);
		sunLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(apolloSun, sunLabel1);
		myMap.put(raSun, sunLabel2);
		myMap.put(heliosSun, sunLabel3);
		myMap.put(intiSun, sunLabel4);
		myMap.put(horusSun, sunLabel5);
		myMap.put(tonatiuhSun, sunLabel6);
		myMap.put(amunSun, sunLabel7);

		// ALL FOR DINO***
		rawrUnits = 1;
		eggUnits = 1;
		dacUnits = 1;
		danUnits = 1;
		bbUnits = 1;
		moniUnits = 1;
		tsUnits = 1;

		dinoLabel1 = new JLabel("" + rawrUnits);
		dinoLabel2 = new JLabel("" + eggUnits);
		dinoLabel3 = new JLabel("" + dacUnits);
		dinoLabel4 = new JLabel("" + danUnits);
		dinoLabel5 = new JLabel("" + bbUnits);
		dinoLabel6 = new JLabel("" + moniUnits);
		dinoLabel7 = new JLabel("" + tsUnits);

		rawrvilleDino.setSize(25, 25);
		rawrvilleDino.setLocation(960, 214);
		rawrvilleDino.setOpaque(false);
		rawrvilleDino.setContentAreaFilled(false);
		rawrvilleDino.setBorderPainted(false);

		dinoLabel1.setSize(25, 25);
		dinoLabel1.setFont(font);
		dinoLabel1.setForeground(Color.BLACK);
		dinoLabel1.setLocation(968, 217);
		dinoLabel1.setOpaque(false);

		laieggesDino.setSize(25, 25);
		laieggesDino.setLocation(928, 231);
		laieggesDino.setOpaque(false);
		laieggesDino.setContentAreaFilled(false);
		laieggesDino.setBorderPainted(false);

		dinoLabel2.setSize(25, 25);
		dinoLabel2.setFont(font);
		dinoLabel2.setForeground(Color.BLACK);
		dinoLabel2.setLocation(936, 234);
		dinoLabel2.setOpaque(false);

		dactilitoDino.setSize(25, 25);
		dactilitoDino.setLocation(920, 320);
		dactilitoDino.setOpaque(false);
		dactilitoDino.setContentAreaFilled(false);
		dactilitoDino.setBorderPainted(false);

		dinoLabel3.setSize(25, 25);
		dinoLabel3.setFont(font);
		dinoLabel3.setForeground(Color.BLACK);
		dinoLabel3.setLocation(928, 323);
		dinoLabel3.setOpaque(false);

		dirtydanDino.setSize(25, 25);
		dirtydanDino.setLocation(873, 300);
		dirtydanDino.setOpaque(false);
		dirtydanDino.setContentAreaFilled(false);
		dirtydanDino.setBorderPainted(false);

		dinoLabel4.setSize(25, 25);
		dinoLabel4.setFont(font);
		dinoLabel4.setForeground(Color.BLACK);
		dinoLabel4.setLocation(880, 303);
		dinoLabel4.setOpaque(false);

		blackbeardDino.setSize(25, 25);
		blackbeardDino.setLocation(885, 343);
		blackbeardDino.setOpaque(false);
		blackbeardDino.setContentAreaFilled(false);
		blackbeardDino.setBorderPainted(false);

		dinoLabel5.setSize(25, 25);
		dinoLabel5.setFont(font);
		dinoLabel5.setForeground(Color.BLACK);
		dinoLabel5.setLocation(893, 346);
		dinoLabel5.setOpaque(false);

		monisaurusDino.setSize(25, 25);
		monisaurusDino.setLocation(845, 378);
		monisaurusDino.setOpaque(false);
		monisaurusDino.setContentAreaFilled(false);
		monisaurusDino.setBorderPainted(false);

		dinoLabel6.setSize(25, 25);
		dinoLabel6.setFont(font);
		dinoLabel6.setForeground(Color.BLACK);
		dinoLabel6.setLocation(853, 381);
		dinoLabel6.setOpaque(false);

		toystoryDino.setSize(25, 25);
		toystoryDino.setLocation(930, 393);
		toystoryDino.setOpaque(false);
		toystoryDino.setContentAreaFilled(false);
		toystoryDino.setBorderPainted(false);

		dinoLabel7.setSize(25, 25);
		dinoLabel7.setFont(font);
		dinoLabel7.setForeground(Color.BLACK);
		dinoLabel7.setLocation(938, 396);
		dinoLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(rawrvilleDino, dinoLabel1);
		myMap.put(laieggesDino, dinoLabel2);
		myMap.put(dactilitoDino, dinoLabel3);
		myMap.put(dirtydanDino, dinoLabel4);
		myMap.put(blackbeardDino, dinoLabel5);
		myMap.put(monisaurusDino, dinoLabel6);
		myMap.put(toystoryDino, dinoLabel7);

		// ALL CRESENT**
		scrapUnits = 1;
		zachUnits = 1;
		giantUnits = 1;
		newzachUnits = 1;
		southUnits = 1;
		blooUnits = 1;
		capUnits = 1;

		cresentLabel1 = new JLabel("" + scrapUnits);
		cresentLabel2 = new JLabel("" + zachUnits);
		cresentLabel3 = new JLabel("" + giantUnits);
		cresentLabel4 = new JLabel("" + newzachUnits);
		cresentLabel5 = new JLabel("" + southUnits);
		cresentLabel6 = new JLabel("" + blooUnits);
		cresentLabel7 = new JLabel("" + capUnits);

		scraptopiaCresent.setSize(25, 25);
		scraptopiaCresent.setLocation(722, 319);
		scraptopiaCresent.setOpaque(false);
		scraptopiaCresent.setContentAreaFilled(false);
		scraptopiaCresent.setBorderPainted(false);

		cresentLabel1.setSize(25, 25);
		cresentLabel1.setFont(font);
		cresentLabel1.setForeground(Color.BLACK);
		cresentLabel1.setLocation(730, 322);
		cresentLabel1.setOpaque(false);

		landofzachCresent.setSize(25, 25);
		landofzachCresent.setLocation(750, 320);
		landofzachCresent.setOpaque(false);
		landofzachCresent.setContentAreaFilled(false);
		landofzachCresent.setBorderPainted(false);

		cresentLabel2.setSize(25, 25);
		cresentLabel2.setFont(font);
		cresentLabel2.setForeground(Color.BLACK);
		cresentLabel2.setLocation(758, 323);
		cresentLabel2.setOpaque(false);

		giantCresent.setSize(25, 25);
		giantCresent.setLocation(765, 288);
		giantCresent.setOpaque(false);
		giantCresent.setContentAreaFilled(false);
		giantCresent.setBorderPainted(false);

		cresentLabel3.setSize(25, 25);
		cresentLabel3.setFont(font);
		cresentLabel3.setForeground(Color.BLACK);
		cresentLabel3.setLocation(773, 291);
		cresentLabel3.setOpaque(false);

		newlandofzachCresent.setSize(25, 25);
		newlandofzachCresent.setLocation(785, 340);
		newlandofzachCresent.setOpaque(false);
		newlandofzachCresent.setContentAreaFilled(false);
		newlandofzachCresent.setBorderPainted(false);

		cresentLabel4.setSize(25, 25);
		cresentLabel4.setFont(font);
		cresentLabel4.setForeground(Color.BLACK);
		cresentLabel4.setLocation(793, 343);
		cresentLabel4.setOpaque(false);

		southscraptopiaCresent.setSize(25, 25);
		southscraptopiaCresent.setLocation(790, 310);
		southscraptopiaCresent.setOpaque(false);
		southscraptopiaCresent.setContentAreaFilled(false);
		southscraptopiaCresent.setBorderPainted(false);

		cresentLabel5.setSize(25, 25);
		cresentLabel5.setFont(font);
		cresentLabel5.setForeground(Color.BLACK);
		cresentLabel5.setLocation(798, 313);
		cresentLabel5.setOpaque(false);

		bloobawlCresent.setSize(25, 25);
		bloobawlCresent.setLocation(835, 295);
		bloobawlCresent.setOpaque(false);
		bloobawlCresent.setContentAreaFilled(false);
		bloobawlCresent.setBorderPainted(false);

		cresentLabel6.setSize(25, 25);
		cresentLabel6.setFont(font);
		cresentLabel6.setForeground(Color.BLACK);
		cresentLabel6.setLocation(843, 298);
		cresentLabel6.setOpaque(false);

		cresentcaptitalCresent.setSize(25, 25);
		cresentcaptitalCresent.setLocation(861, 275);
		cresentcaptitalCresent.setOpaque(false);
		cresentcaptitalCresent.setContentAreaFilled(false);
		cresentcaptitalCresent.setBorderPainted(false);

		cresentLabel7.setSize(25, 25);
		cresentLabel7.setFont(font);
		cresentLabel7.setForeground(Color.BLACK);
		cresentLabel7.setLocation(869, 278);
		cresentLabel7.setOpaque(false);

		// myMap = new HashMap<JButton, JLabel>();
		myMap.put(scraptopiaCresent, cresentLabel1);
		myMap.put(landofzachCresent, cresentLabel2);
		myMap.put(giantCresent, cresentLabel3);
		myMap.put(newlandofzachCresent, cresentLabel4);
		myMap.put(southscraptopiaCresent, cresentLabel5);
		myMap.put(bloobawlCresent, cresentLabel6);
		myMap.put(cresentcaptitalCresent, cresentLabel7);

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

		// add all lables
		this.add(sunLabel1);
		this.add(sunLabel2);
		this.add(sunLabel3);
		this.add(sunLabel4);
		this.add(sunLabel5);
		this.add(sunLabel6);
		this.add(sunLabel7);

		// add all buttons
		this.add(apolloSun);
		this.add(raSun);
		this.add(heliosSun);
		this.add(intiSun);
		this.add(horusSun);
		this.add(tonatiuhSun);
		this.add(amunSun);

		// add all lables
		this.add(dinoLabel1);
		this.add(dinoLabel2);
		this.add(dinoLabel3);
		this.add(dinoLabel4);
		this.add(dinoLabel5);
		this.add(dinoLabel6);
		this.add(dinoLabel7);

		// add all buttons
		this.add(rawrvilleDino);
		this.add(laieggesDino);
		this.add(dactilitoDino);
		this.add(dirtydanDino);
		this.add(blackbeardDino);
		this.add(monisaurusDino);
		this.add(toystoryDino);

		// add all lables
		this.add(cresentLabel1);
		this.add(cresentLabel2);
		this.add(cresentLabel3);
		this.add(cresentLabel4);
		this.add(cresentLabel5);
		this.add(cresentLabel6);
		this.add(cresentLabel7);

		// add all buttons
		this.add(scraptopiaCresent);
		this.add(landofzachCresent);
		this.add(giantCresent);
		this.add(newlandofzachCresent);
		this.add(southscraptopiaCresent);
		this.add(bloobawlCresent);
		this.add(cresentcaptitalCresent);

	}

	public void moveTurnLabel() {
		if (newGame.getPlayerAt(0) == currPlayer) {
			playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
			turnMarker.setLocation(150, 590);
		} else if (newGame.getPlayerAt(1) == currPlayer) {
			playerCount2.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
			turnMarker.setLocation(320, 590);
		} else if (newGame.getPlayerAt(2) == currPlayer) {
			playerCount3.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
			turnMarker.setLocation(470, 590);
		} else if (newGame.getPlayerAt(3) == currPlayer) {
			playerCount4.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
			turnMarker.setLocation(640, 590);
		} else if (newGame.getPlayerAt(4) == currPlayer) {
			playerCount5.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
			turnMarker.setLocation(810, 590);
		} else if (newGame.getPlayerAt(5) == currPlayer) {
			playerCount6.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
			turnMarker.setLocation(980, 590);
		}
	}

	public int getPlayerTurn()
	{
		return newGame.getPlayerTurn();
	}
	public void nextPlayer() {

		if(turnCount == 0) {
			gameOver();
		}
		Random r = new Random();
		currPlayer = newGame.nextPlayer();

		turnCountLabel.setText("Turns Left: " + turnCount);

		moveTurnLabel();
		if (!reinforcementPhase) {
			turnCount--;
			newGame.addReinforcements();
			gameStatus.setText("Deploy");
			moveTurnLabel();
		}

		System.out.println("Current Player: " + currPlayer.getName());
		System.out.println("AI?: " + currPlayer.isAI());

		if (currPlayer.isAI()) {
			String log = currPlayer.getName() + "'s Turn Log\n\n";
			// initial deploy
			if (reinforcementPhase) {
				log += "-Placed 1 army for initial deployment phase";
				newGame.deployAllArmies();
				moveTurnLabel();
				updateLabels();
			} else {
				// turn in card
				if (newGame.turnInCard()) {
					log += "-Successful card turn in\n";
				} else {
					log += "-Unsuccessful card turn in\n";
				}

				// deploy until empty
				int count = 0;
				while (currPlayer.getNumOfArmies() >= 1) {
					count++;
					newGame.deployAllArmies();
					moveTurnLabel();
					updateLabels();
				}

				log += "-Deployed " + count + " armies in deploy phase\n";

				// attack
				Territory attackingTerritory = currPlayer.getTerritories()
						.get(r.nextInt(currPlayer.getTerritories().size()));
				Territory defendingTerritory = currPlayer.attackTerritory(attackingTerritory,
						attackingTerritory.getNeighbors());

				if (defendingTerritory != null) {

					BattleLogic battleLogic = new BattleLogic(currPlayer, defendingTerritory.getOwner(),
							attackingTerritory, defendingTerritory);

					while (currPlayer.chooseRetreat(attackingTerritory) && attackingTerritory.getUnits() > 1) {
						int attackerDiceNum, defenderDiceNum;
						if (attackingTerritory.getUnits() <= 3) {
							attackerDiceNum = attackingTerritory.getUnits() - 1;
						} else {
							attackerDiceNum = 3;
						}

						if (defendingTerritory.getUnits() <= 2) {
							defenderDiceNum = defendingTerritory.getUnits();
						} else
							defenderDiceNum = 2;

						battleLogic.attackPlayer(attackerDiceNum, defenderDiceNum);
						int[] unitsToLose = battleLogic.subtractArmies();

						log += "-Attacked " + defendingTerritory.getName() + " from " + attackingTerritory.getName()
								+ "\n";

						newGame.attackLogic(attackingTerritory, defendingTerritory, unitsToLose);
						moveTurnLabel();
						updateLabels();
					}
				}

				// fortify
				newGame.fortifyPosition();
				moveTurnLabel();
				updateLabels();
			}
			log += "\nEnd of Log";
			Object[] options = { "Change Difficulty", "Next Turn" };
			int choice = JOptionPane.showOptionDialog(null, log, "AI Turn Over", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

			if (choice == 0) {
				// CHANGE DIFFICULTY
				Object[] diff = { "Easy", "Medium", "Hard"};
				int diffChoice = JOptionPane.showOptionDialog(null, "Choose Difficulty to Change to",
						"Difficulty Change", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, diff,
						diff[0]);
				
				String name = currPlayer.getName();
				Color color = currPlayer.getColor();
				int numOfArmies = currPlayer.getNumOfArmies();
				boolean isAI = currPlayer.isAI();
				ArrayList<Card> cards = currPlayer.getCards();
				ArrayList<Territory> territories = currPlayer.getTerritories();
				PlayerCollection players = newGame.getPlayerList();
				int index = newGame.getIndexOfPlayer();
				
				System.out.println("Started as " + currPlayer.getClass());
				if(diffChoice == 0) {
					currPlayer = new EasyAI(name, color, numOfArmies, isAI);
					currPlayer.setCards(cards);
					currPlayer.setTerritories(territories);

				}
				if(diffChoice == 1) {
					currPlayer = new MediumAI(name, color, numOfArmies, isAI);
					currPlayer.setCards(cards);
					currPlayer.setTerritories(territories);
				}
				if(diffChoice == 2) {
					currPlayer = new HardAI(name, color, numOfArmies, isAI);
					currPlayer.setCards(cards);
					currPlayer.setTerritories(territories);
				}
				players.setPlayerAt(index, currPlayer);
				System.out.println("Now it is " + currPlayer.getClass());
			}

			if (turnCount > 0)
				nextPlayer();
		}
		
		if(currPlayer.getCards().size() == 5) {
			if(newGame.turnInCard()) {
				JOptionPane.showMessageDialog(null, "Number of cards reached 5, automatically turned in");
			}
			else
				JOptionPane.showMessageDialog(null, "Tried to turn in 5 cards but failed for unknown reason");
		}

	}

	public void gameOver() {
		Player winner = null;
		int highestNumOfTerritories = 0;
		for (int i = 0; i < newGame.getNumOfPlayers(); i++) {
			if (highestNumOfTerritories < newGame.getPlayerAt(i).getTerritories().size()) {
				winner = newGame.getPlayerAt(i);
				highestNumOfTerritories = newGame.getPlayerAt(i).getTerritories().size();
			}
		}

		String message = "The Winner Is: " + winner.getName() + "!\n" + "They had " + highestNumOfTerritories + "!"
				+ "\n\nCredits: Nick Larson, Zach Haddad, Esgar Moreno, and Monica Sproul";
		playsong = new Play1Song(ass);
		JOptionPane.showMessageDialog(null, message);

		System.exit(0);
	}

	private void updateLabels() {

		javaUnits = territories.get(0).getUnits();
		pythonUnits = territories.get(1).getUnits();
		cUnits = territories.get(2).getUnits();
		sqlUnits = territories.get(3).getUnits();
		rubyUnits = territories.get(4).getUnits();
		gitUnits = territories.get(5).getUnits();
		perlUnits = territories.get(6).getUnits();
		wilberUnits = territories.get(14).getUnits();
		wilmaUnits = territories.get(15).getUnits();
		richUnits = territories.get(16).getUnits();
		millerUnits = territories.get(17).getUnits();
		scoobyUnits = territories.get(18).getUnits();
		mckaleUnits = territories.get(19).getUnits();
		zonaUnits = territories.get(20).getUnits();
		pjUnits = territories.get(21).getUnits();
		domUnits = territories.get(22).getUnits();
		phUnits = territories.get(23).getUnits();
		bjUnits = territories.get(24).getUnits();
		hhUnits = territories.get(25).getUnits();
		bUnits = territories.get(26).getUnits();
		ppUnits = territories.get(27).getUnits();
		rawrUnits = territories.get(7).getUnits();
		eggUnits = territories.get(8).getUnits();
		dacUnits = territories.get(9).getUnits();
		danUnits = territories.get(10).getUnits();
		bbUnits = territories.get(11).getUnits();
		moniUnits = territories.get(12).getUnits();
		tsUnits = territories.get(13).getUnits();
		scrapUnits = territories.get(28).getUnits();
		zachUnits = territories.get(29).getUnits();
		giantUnits = territories.get(30).getUnits();
		newzachUnits = territories.get(31).getUnits();
		southUnits = territories.get(32).getUnits();
		blooUnits = territories.get(33).getUnits();
		capUnits = territories.get(34).getUnits();
		apolloUnits = territories.get(35).getUnits();
		raUnits = territories.get(36).getUnits();
		heliosUnits = territories.get(37).getUnits();
		intiUnits = territories.get(38).getUnits();
		horusUnits = territories.get(39).getUnits();
		tonatiuhUnits = territories.get(40).getUnits();
		amunUnits = territories.get(41).getUnits();

		updateButtonColors();

		languageLabel1.setText("" + javaUnits);
		languageLabel2.setText("" + pythonUnits);
		languageLabel3.setText("" + cUnits);
		languageLabel4.setText("" + sqlUnits);
		languageLabel5.setText("" + rubyUnits);
		languageLabel6.setText("" + gitUnits);
		languageLabel7.setText("" + perlUnits);
		wildcatLabel1.setText("" + wilberUnits);
		wildcatLabel2.setText("" + wilmaUnits);
		wildcatLabel3.setText("" + richUnits);
		wildcatLabel4.setText("" + millerUnits);
		wildcatLabel5.setText("" + scoobyUnits);
		wildcatLabel6.setText("" + mckaleUnits);
		wildcatLabel7.setText("" + zonaUnits);
		pizzaLabel1.setText("" + pjUnits);
		pizzaLabel2.setText("" + domUnits);
		pizzaLabel3.setText("" + phUnits);
		pizzaLabel4.setText("" + bjUnits);
		pizzaLabel5.setText("" + hhUnits);
		pizzaLabel6.setText("" + bUnits);
		pizzaLabel7.setText("" + ppUnits);
		dinoLabel1.setText("" + rawrUnits);
		dinoLabel2.setText("" + eggUnits);
		dinoLabel3.setText("" + dacUnits);
		dinoLabel4.setText("" + danUnits);
		dinoLabel5.setText("" + bbUnits);
		dinoLabel6.setText("" + moniUnits);
		dinoLabel7.setText("" + tsUnits);
		sunLabel1.setText("" + apolloUnits);
		sunLabel2.setText("" + raUnits);
		sunLabel3.setText("" + heliosUnits);
		sunLabel4.setText("" + intiUnits);
		sunLabel5.setText("" + horusUnits);
		sunLabel6.setText("" + tonatiuhUnits);
		sunLabel7.setText("" + amunUnits);
		cresentLabel1.setText("" + scrapUnits);
		cresentLabel2.setText("" + zachUnits);
		cresentLabel3.setText("" + giantUnits);
		cresentLabel4.setText("" + newzachUnits);
		cresentLabel5.setText("" + southUnits);
		cresentLabel6.setText("" + blooUnits);
		cresentLabel7.setText("" + capUnits);
		moveTurnLabel();
	}

	public void AITurn(int turnPhase) {
		/*
		 * Lots of Run6Bots stuff
		 * 
		 * 0 >>> Deploy | 1 >>> Attack | 2 >>> Fortify
		 */
		Random r = new Random();

		if (turnPhase == 0) {
			newGame.deployAllArmies();
		} else if (turnPhase == 1) {
			Territory attackingTerritory = currPlayer.getTerritories()
					.get(r.nextInt(currPlayer.getTerritories().size()));
			Territory defendingTerritory = currPlayer.attackTerritory(attackingTerritory,
					attackingTerritory.getNeighbors());
			if (defendingTerritory != null) {
				gameBoardAttack(attackingTerritory, defendingTerritory);
				updateLabels();
			}

		} else if (turnPhase == 2) {
			currPlayer.deployArmy();
		}
	}

	private void gameBoardAttack(Territory attackingTerr, Territory defendingTerr) {
		playsong = new Play1Song(bass);/// bass sound?
		if (attackingTerr.getUnits() >= 2) {
			playsong = new Play1Song(bass);// bass sound

			BattleLogic battleLogic = new BattleLogic(attackingTerr.getOwner(), defendingTerr.getOwner(), attackingTerr,
					defendingTerr);
			Random r = new Random();

			// Create the number of dice for each player
			int attackerDiceNum, defenderDiceNum;
			if (attackingTerr.getUnits() <= 3) {
				attackerDiceNum = attackingTerr.getUnits() - 1;
			} else {
				attackerDiceNum = 3;
			}

			if (defendingTerr.getUnits() <= 2) {
				defenderDiceNum = defendingTerr.getUnits();
			} else
				defenderDiceNum = 2;

			// compare the dice
			battleLogic.attackPlayer(attackerDiceNum, defenderDiceNum);
			int[] armiesLost = battleLogic.subtractArmies();
			String attackerName = attackingTerr.getOwner().getName();
			String defenderName = defendingTerr.getOwner().getName();

			// subtract the armies
			newGame.attackLogic(attackingTerr, defendingTerr, armiesLost);
			updateLabels();
			if (!attackingTerr.getOwner().isAI()) {
				// SEND ALL THE INFO TO JOPTIONPANE HERE AND CHECK FOR RETREAT
				String[] options;
				String optionPaneMessage = "Attacker: " + attackerName + "\nDefender: " + defenderName + "\n\n"
						+ "Attacker dice: " + battleLogic.getAttackDice() + "\nDefender dice: "
						+ battleLogic.getDefendDice() + "\n\n" + attackerName + " lost " + armiesLost[0] + " armies."
						+ "\n" + defenderName + " lost " + armiesLost[1] + " armies.";

				if (!defendingTerr.getOwner().getName().equals(defenderName)) {
					optionPaneMessage += ("\n\n" + defenderName + " lost " + defendingTerr.getName() + " to "
							+ attackerName);
					options = new String[1];
					options[0] = "OK";
					JOptionPane.showOptionDialog(null, optionPaneMessage, "Battle Results", JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				} else {
					optionPaneMessage += ("\n\n" + attackingTerr.getName() + " now has " + attackingTerr.getUnits()
							+ "\n" + defendingTerr.getName() + " now has " + defendingTerr.getUnits());
					options = new String[2];
					options[0] = "Retreat?";
					options[1] = "Attack Again!";
					int choice = JOptionPane.showOptionDialog(null, optionPaneMessage, "Battle Results",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

					if (choice == JOptionPane.NO_OPTION) {
						gameBoardAttack(attackingTerr, defendingTerr);
					}
				}
			} else if (!currPlayer.chooseRetreat(attackingTerr)) {
				gameBoardAttack(attackingTerr, defendingTerr);
			}
		} else {
			if (!attackingTerr.getOwner().isAI()) {
				JOptionPane.showMessageDialog(null, "Sorry, you do not have enough armies to attack");
			}
		}
	}
	
	public void updatePlayerLabels() {
		if (newGame.getNumOfPlayers() == 6) {
			playerTag.setText(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount.setText("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2.setText(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2.setText("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
			playerTag3.setText(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(Color.orange);
			add(playerTag3);
			playerCount3.setText("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(Color.orange);
			add(playerCount3);
			playerTag4.setText(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(Color.red);
			add(playerTag4);
			playerCount4.setText("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(Color.red);
			add(playerCount4);
			playerTag5.setText(newGame.getPlayerAt(4).getName());
			playerTag5.setSize(150, 40);
			playerTag5.setLocation(830, 600);
			playerTag5.setFont(plyrTagFont);
			playerTag5.setForeground(Color.pink);
			add(playerTag5);
			playerCount5.setText("You have " + newGame.getPlayerAt(4).getNumOfArmies() + " units left to place!");
			playerCount5.setSize(200, 40);
			playerCount5.setLocation(800, 620);
			playerCount5.setFont(plyrCountFont);
			playerCount5.setForeground(Color.pink);
			add(playerCount5);
			playerTag6.setText(newGame.getPlayerAt(5).getName());
			playerTag6.setSize(150, 40);
			playerTag6.setLocation(1000, 600);
			playerTag6.setFont(plyrTagFont);
			playerTag6.setForeground(Color.blue);
			add(playerTag6);
			playerCount6.setText("You have " + newGame.getPlayerAt(5).getNumOfArmies() + " units left to place!");
			playerCount6.setSize(150, 40);
			playerCount6.setLocation(970, 620);
			playerCount6.setFont(plyrCountFont);
			playerCount6.setForeground(Color.blue);
			add(playerCount6);
		}
		if (newGame.getNumOfPlayers() == 5) {
			playerTag.setText(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount.setText("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2.setText(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2.setText("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
			playerTag3.setText(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(Color.orange);
			add(playerTag3);
			playerCount3.setText("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(Color.orange);
			add(playerCount3);
			playerTag4.setText(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(Color.red);
			add(playerTag4);
			playerCount4.setText("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(Color.red);
			add(playerCount4);
			playerTag5.setText(newGame.getPlayerAt(4).getName());
			playerTag5.setSize(150, 40);
			playerTag5.setLocation(830, 600);
			playerTag5.setFont(plyrTagFont);
			playerTag5.setForeground(Color.pink);
			add(playerTag5);
			playerCount5.setText("You have " + newGame.getPlayerAt(4).getNumOfArmies() + " units left to place!");
			playerCount5.setSize(200, 40);
			playerCount5.setLocation(800, 620);
			playerCount5.setFont(plyrCountFont);
			playerCount5.setForeground(Color.pink);
			add(playerCount5);
		}
		if (newGame.getNumOfPlayers() == 4) {
			playerTag.setText(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount.setText("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2.setText(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2.setText("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
			playerTag3.setText(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(Color.orange);
			add(playerTag3);
			playerCount3.setText("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(Color.orange);
			add(playerCount3);
			playerTag4.setText(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(Color.red);
			add(playerTag4);
			playerCount4.setText("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(Color.red);
			add(playerCount4);
		}
		if (newGame.getNumOfPlayers() == 3) {
			playerTag.setText(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(Color.yellow);
			add(playerTag);
			playerCount.setText("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(Color.yellow);
			add(playerCount);
			playerTag2.setText(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(Color.green);
			add(playerTag2);
			playerCount2.setText("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(Color.green);
			add(playerCount2);
			playerTag3.setText(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(Color.orange);
			add(playerTag3);
			playerCount3.setText("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(Color.orange);
			add(playerCount3);
		}
	}

	private void updateButtonColors() {
		if (newGame.getNumOfPlayers() == 6) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
					wilmaWildcat.setIcon(yellow);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(yellow);
					amunSun.setName(newGame.getPlayerAt(0).getName());
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(1).getName());
					wilmaWildcat.setIcon(green);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(green);
					zonaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(green);
					wilberWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(green);
					richWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(green);
					millerWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(green);
					mckaleWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(green);
					scoobyWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(green);
					javaLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(green);
					pythonLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(green);
					cLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(green);
					sqlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(green);
					rubyLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(green);
					perlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(green);
					gitLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(green);
					papajohnsPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(green);
					dominosPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(green);
					pizzahutPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(green);
					blackjackPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(green);
					hungryhowiesPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(green);
					brooklynPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(green);
					pizzaplanetPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(green);
					rawrvilleDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(green);
					laieggesDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(green);
					dactilitoDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(green);
					dirtydanDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(green);
					blackbeardDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(green);
					monisaurusDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(green);
					toystoryDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(green);
					scraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(green);
					landofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(green);
					giantCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(green);
					newlandofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(green);
					southscraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(green);
					bloobawlCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(green);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(green);
					apolloSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(green);
					raSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(green);
					heliosSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(green);
					intiSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(green);
					horusSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(green);
					tonatiuhSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(green);
					amunSun.setName(newGame.getPlayerAt(1).getName());
				}

			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
					wilmaWildcat.setIcon(orange);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}

			}

			for (Territory d : player4.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
					wilmaWildcat.setIcon(red);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}

			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(4).getName());
					wilmaWildcat.setIcon(purple);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(purple);
					zonaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(purple);
					wilberWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(purple);
					richWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(purple);
					millerWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(purple);
					mckaleWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(purple);
					scoobyWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(purple);
					javaLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(purple);
					pythonLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(purple);
					cLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(purple);
					sqlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(purple);
					rubyLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(purple);
					perlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(purple);
					gitLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(purple);
					papajohnsPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(purple);
					dominosPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(purple);
					pizzahutPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(purple);
					blackjackPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(purple);
					hungryhowiesPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(purple);
					brooklynPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(purple);
					pizzaplanetPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(purple);
					rawrvilleDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(purple);
					laieggesDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(purple);
					dactilitoDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(purple);
					dirtydanDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(purple);
					blackbeardDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(purple);
					monisaurusDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(purple);
					toystoryDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(purple);
					scraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(purple);
					landofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(purple);
					giantCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(purple);
					newlandofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(purple);
					southscraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(purple);
					bloobawlCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(purple);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(purple);
					apolloSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(purple);
					raSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(purple);
					heliosSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(purple);
					intiSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(purple);
					horusSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(purple);
					tonatiuhSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(purple);
					amunSun.setName(newGame.getPlayerAt(4).getName());
				}

			}

			for (Territory d : player6.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(5).getName());
					wilmaWildcat.setIcon(blue);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(blue);
					zonaWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(blue);
					wilberWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(blue);
					richWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(blue);
					millerWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(blue);
					mckaleWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(blue);
					scoobyWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(blue);
					javaLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(blue);
					pythonLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(blue);
					cLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(blue);
					sqlLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(blue);
					rubyLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(blue);
					perlLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(blue);
					gitLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(blue);
					papajohnsPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(blue);
					dominosPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(blue);
					pizzahutPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(blue);
					blackjackPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(blue);
					hungryhowiesPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(blue);
					brooklynPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(blue);
					pizzaplanetPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(blue);
					rawrvilleDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(blue);
					laieggesDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(blue);
					dactilitoDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(blue);
					dirtydanDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(blue);
					blackbeardDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(blue);
					monisaurusDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(blue);
					toystoryDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(blue);
					scraptopiaCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(blue);
					landofzachCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(blue);
					giantCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(blue);
					newlandofzachCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(blue);
					southscraptopiaCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(blue);
					bloobawlCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(blue);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(blue);
					apolloSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(blue);
					raSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(blue);
					heliosSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(blue);
					intiSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(blue);
					horusSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(blue);
					tonatiuhSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(blue);
					amunSun.setName(newGame.getPlayerAt(5).getName());
				}

			}
		}
		if (newGame.getNumOfPlayers() == 5) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
					wilmaWildcat.setIcon(yellow);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(yellow);
					amunSun.setName(newGame.getPlayerAt(0).getName());
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(green);
					wilmaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(green);
					zonaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(green);
					wilberWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(green);
					richWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(green);
					millerWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(green);
					mckaleWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(green);
					scoobyWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(green);
					javaLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(green);
					pythonLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(green);
					cLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(green);
					sqlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(green);
					rubyLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(green);
					perlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(green);
					gitLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(green);
					papajohnsPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(green);
					dominosPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(green);
					pizzahutPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(green);
					blackjackPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(green);
					hungryhowiesPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(green);
					brooklynPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(green);
					pizzaplanetPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(green);
					rawrvilleDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(green);
					laieggesDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(green);
					dactilitoDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(green);
					dirtydanDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(green);
					blackbeardDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(green);
					monisaurusDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(green);
					toystoryDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(green);
					scraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(green);
					landofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(green);
					giantCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(green);
					newlandofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(green);
					southscraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(green);
					bloobawlCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(green);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(green);
					apolloSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(green);
					raSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(green);
					heliosSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(green);
					intiSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(green);
					horusSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(green);
					tonatiuhSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(green);
					amunSun.setName(newGame.getPlayerAt(1).getName());
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
					wilmaWildcat.setIcon(orange);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}

			}

			for (Territory d : player4.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
					wilmaWildcat.setIcon(red);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}

			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(4).getName());
					wilmaWildcat.setIcon(purple);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(purple);
					zonaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(purple);
					wilberWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(purple);
					richWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(purple);
					millerWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(purple);
					mckaleWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(purple);
					scoobyWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(purple);
					javaLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(purple);
					pythonLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(purple);
					cLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(purple);
					sqlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(purple);
					rubyLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(purple);
					perlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(purple);
					gitLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(purple);
					papajohnsPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(purple);
					dominosPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(purple);
					pizzahutPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(purple);
					blackjackPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(purple);
					hungryhowiesPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(purple);
					brooklynPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(purple);
					pizzaplanetPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(purple);
					rawrvilleDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(purple);
					laieggesDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(purple);
					dactilitoDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(purple);
					dirtydanDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(purple);
					blackbeardDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(purple);
					monisaurusDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(purple);
					toystoryDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(purple);
					scraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(purple);
					landofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(purple);
					giantCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(purple);
					newlandofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(purple);
					southscraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(purple);
					bloobawlCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(purple);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(purple);
					apolloSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(purple);
					raSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(purple);
					heliosSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(purple);
					intiSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(purple);
					horusSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(purple);
					tonatiuhSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(purple);
					amunSun.setName(newGame.getPlayerAt(4).getName());
				}

			}
		}
		if (newGame.getNumOfPlayers() == 4) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
					wilmaWildcat.setIcon(yellow);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(yellow);
					amunSun.setName(newGame.getPlayerAt(0).getName());
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(green);
					wilmaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(green);
					zonaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(green);
					wilberWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(green);
					richWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(green);
					millerWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(green);
					mckaleWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(green);
					scoobyWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(green);
					javaLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(green);
					pythonLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(green);
					cLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(green);
					sqlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(green);
					rubyLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(green);
					perlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(green);
					gitLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(green);
					papajohnsPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(green);
					dominosPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(green);
					pizzahutPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(green);
					blackjackPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(green);
					hungryhowiesPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(green);
					brooklynPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(green);
					pizzaplanetPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(green);
					rawrvilleDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(green);
					laieggesDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(green);
					dactilitoDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(green);
					dirtydanDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(green);
					blackbeardDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(green);
					monisaurusDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(green);
					toystoryDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(green);
					scraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(green);
					landofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(green);
					giantCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(green);
					newlandofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(green);
					southscraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(green);
					bloobawlCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(green);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(green);
					apolloSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(green);
					raSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(green);
					heliosSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(green);
					intiSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(green);
					horusSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(green);
					tonatiuhSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(green);
					amunSun.setName(newGame.getPlayerAt(1).getName());
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
					wilmaWildcat.setIcon(orange);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}

			}

			for (Territory d : player4.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
					wilmaWildcat.setIcon(red);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}

			}
		}
		if (newGame.getNumOfPlayers() == 3) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
					wilmaWildcat.setIcon(yellow);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(yellow);
					amunSun.setName(newGame.getPlayerAt(0).getName());
				}

			}

			for (Territory d : player2.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(green);
					wilmaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(green);
					zonaWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(green);
					wilberWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(green);
					richWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(green);
					millerWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(green);
					mckaleWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(green);
					scoobyWildcat.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(green);
					javaLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(green);
					pythonLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(green);
					cLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(green);
					sqlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(green);
					rubyLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(green);
					perlLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(green);
					gitLanguage.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(green);
					papajohnsPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(green);
					dominosPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(green);
					pizzahutPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(green);
					blackjackPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(green);
					hungryhowiesPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(green);
					brooklynPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(green);
					pizzaplanetPizza.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(green);
					rawrvilleDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(green);
					laieggesDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(green);
					dactilitoDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(green);
					dirtydanDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(green);
					blackbeardDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(green);
					monisaurusDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(green);
					toystoryDino.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(green);
					scraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(green);
					landofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(green);
					giantCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(green);
					newlandofzachCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(green);
					southscraptopiaCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(green);
					bloobawlCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(green);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(green);
					apolloSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(green);
					raSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(green);
					heliosSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(green);
					intiSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(green);
					horusSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(green);
					tonatiuhSun.setName(newGame.getPlayerAt(1).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(green);
					amunSun.setName(newGame.getPlayerAt(1).getName());
				}
			}
			for (Territory d : player3.getTerritories()) {
				if (d.getName().equals("Wilma")) {
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
					wilmaWildcat.setIcon(orange);
				}
				if (d.getName().equals("Zona")) {
					zonaWildcat.setIcon(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Wilber")) {
					wilberWildcat.setIcon(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rich")) {
					richWildcat.setIcon(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Miller")) {
					millerWildcat.setIcon(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("McKale")) {
					mckaleWildcat.setIcon(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scooby")) {
					scoobyWildcat.setIcon(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Java")) {
					javaLanguage.setIcon(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Python")) {
					pythonLanguage.setIcon(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("C")) {
					cLanguage.setIcon(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("SQL")) {
					sqlLanguage.setIcon(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ruby")) {
					rubyLanguage.setIcon(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Perl")) {
					perlLanguage.setIcon(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Git")) {
					gitLanguage.setIcon(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Papa Johns")) {
					papajohnsPizza.setIcon(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dominos")) {
					dominosPizza.setIcon(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("PizzaHut")) {
					pizzahutPizza.setIcon(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Black Jack")) {
					blackjackPizza.setIcon(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Hungry Howie's")) {
					hungryhowiesPizza.setIcon(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Brooklyn's")) {
					brooklynPizza.setIcon(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Pizza Planet")) {
					pizzaplanetPizza.setIcon(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Rawrville")) {
					rawrvilleDino.setIcon(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Laiegges")) {
					laieggesDino.setIcon(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dactilito")) {
					dactilitoDino.setIcon(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Dirtydan")) {
					dirtydanDino.setIcon(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("BlackBeard")) {
					blackbeardDino.setIcon(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Monisaurus")) {
					monisaurusDino.setIcon(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("ToyStory")) {
					toystoryDino.setIcon(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Scraptopia")) {
					scraptopiaCresent.setIcon(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Land of Zach")) {
					landofzachCresent.setIcon(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Giant")) {
					giantCresent.setIcon(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("New Land of Zach")) {
					newlandofzachCresent.setIcon(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("South Scraptopia")) {
					southscraptopiaCresent.setIcon(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Bloo Bawl")) {
					bloobawlCresent.setIcon(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Cresent Capital")) {
					cresentcaptitalCresent.setIcon(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Apollo")) {
					apolloSun.setIcon(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Ra")) {
					raSun.setIcon(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Helios")) {
					heliosSun.setIcon(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Inti")) {
					intiSun.setIcon(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Horus")) {
					horusSun.setIcon(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Tonatiuh")) {
					tonatiuhSun.setIcon(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName().equals("Amun")) {
					amunSun.setIcon(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}

			}
		}
	}

	private void checkIfReinforcementPhaseIsOver() {
		int playersDone = 0;
		for (int i = 0; i < newGame.getNumOfPlayers(); i++) {
			if (newGame.getPlayerAt(i).getNumOfArmies() == 0) {
				playersDone++;
			}
		}
		if (playersDone == newGame.getNumOfPlayers()) {
			turnCount--;
			reinforcementPhase = false;
			attackPhase = true;
			newGame.addReinforcements();
			gameStatus.setText("Deploy");
			endTurnButton.setEnabled(true);
			if (newGame.getNumOfPlayers() == 6) {
				playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
				playerCount2.setText("");
				playerCount3.setText("");
				playerCount4.setText("");
				playerCount5.setText("");
				playerCount6.setText("");
			} else if (newGame.getNumOfPlayers() == 5) {
				playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
				playerCount2.setText("");
				playerCount3.setText("");
				playerCount4.setText("");
				playerCount5.setText("");

			} else if (newGame.getNumOfPlayers() == 4) {
				playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
				playerCount2.setText("");
				playerCount3.setText("");
				playerCount4.setText("");

			} else if (newGame.getNumOfPlayers() == 3) {
				playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
				playerCount2.setText("");
				playerCount3.setText("");

			} else if (newGame.getNumOfPlayers() == 2) {
				playerCount.setText("You have " + currPlayer.getNumOfArmies() + " units left to place!");
				playerCount2.setText("");

			}
		}

	}

}