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

import model.BattleLogic;
import model.CardCollection;
import model.Continent;
import model.GameLogic;
import model.Player;
import model.PlayerCollection;
import model.Territory;

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
			playerCount3, playerCount4, playerCount5, playerCount6, turnMarker, gameStatus;

	private int fortifyCount, unitsFortified;
	private FileInputStream inputStream;
	private ObjectInputStream objectInput;

	public GameBoard() {

		reinforcementPhase = true;
		attackPhase = false;
		fortifyPhase = false;
		fortifyCount = 0;

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

						try {
							map = ImageIO.read(new File("./Pictures/mapwithlines.png"));

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
								Player tempPlayer = null;
								boolean reinforcementPhaseImport = true;
								try {
									inputStream = new FileInputStream("savedGame");
									objectInput = new ObjectInputStream(inputStream);
									tempPlayers = (PlayerCollection) objectInput.readObject();
									tempCards = (ArrayList<String>) objectInput.readObject();
									tempTerritories = (ArrayList<Territory>) objectInput.readObject();
									tempContinents = (ArrayList<Continent>) objectInput.readObject();
									tempPlayer = (Player) objectInput.readObject();
									reinforcementPhaseImport = (boolean) objectInput.readObject();

								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									System.out.println("reading did not work");
									e.printStackTrace();
								}
								this.importGameLogic(tempPlayers, tempCards, tempContinents, tempTerritories,
										tempPlayer, reinforcementPhaseImport);
							}

							System.out.println("NUMBER OF PLAYERS: " + newGame.getNumOfPlayers());

							playerTags();
							addButtons();

							currPlayer = newGame.getPlayerAt(0);

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

	}

	private void playerTags() {
		int numberOfPlayers;

		numberOfPlayers = newGame.getNumOfPlayers();
		Font plyrTagFont = new Font("Verdana", Font.BOLD, 18);
		Font plyrCountFont = new Font("Verdana", Font.BOLD, 9);
		Font gameStatusFont = new Font("Verdana", Font.BOLD, 36);
		int count = 1;
		turnMarker = new JLabel();
		gameStatus = new JLabel();
		turnMarker.setText("IT'S YOUR TURN!!!");
		turnMarker.setForeground(Color.white);
		turnMarker.setFont(plyrCountFont);
		turnMarker.setSize(100, 20);
		turnMarker.setLocation(150, 590);
		gameStatus.setText("Deploy");
		gameStatus.setForeground(Color.white);
		gameStatus.setBackground(Color.BLACK);
		gameStatus.setFont(gameStatusFont);
		gameStatus.setSize(200, 50);
		gameStatus.setLocation(1110, 40);

		add(gameStatus);
		add(turnMarker);

		if (numberOfPlayers == 6) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
			playerTag3 = new JLabel(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(startWindow.getPlayerColor(2));
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(startWindow.getPlayerColor(2));
			add(playerCount3);
			playerTag4 = new JLabel(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(startWindow.getPlayerColor(3));
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(startWindow.getPlayerColor(3));
			add(playerCount4);
			playerTag5 = new JLabel(newGame.getPlayerAt(4).getName());
			playerTag5.setSize(150, 40);
			playerTag5.setLocation(830, 600);
			playerTag5.setFont(plyrTagFont);
			playerTag5.setForeground(startWindow.getPlayerColor(4));
			add(playerTag5);
			playerCount5 = new JLabel("You have " + newGame.getPlayerAt(4).getNumOfArmies() + " units left to place!");
			playerCount5.setSize(200, 40);
			playerCount5.setLocation(800, 620);
			playerCount5.setFont(plyrCountFont);
			playerCount5.setForeground(startWindow.getPlayerColor(4));
			add(playerCount5);
			playerTag6 = new JLabel(newGame.getPlayerAt(5).getName());
			playerTag6.setSize(150, 40);
			playerTag6.setLocation(1000, 600);
			playerTag6.setFont(plyrTagFont);
			playerTag6.setForeground(startWindow.getPlayerColor(5));
			add(playerTag6);
			playerCount6 = new JLabel("You have " + newGame.getPlayerAt(5).getNumOfArmies() + " units left to place!");
			playerCount6.setSize(150, 40);
			playerCount6.setLocation(970, 620);
			playerCount6.setFont(plyrCountFont);
			playerCount6.setForeground(startWindow.getPlayerColor(5));
			add(playerCount6);
		}
		if (numberOfPlayers == 5) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
			playerTag3 = new JLabel(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(startWindow.getPlayerColor(2));
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(startWindow.getPlayerColor(2));
			add(playerCount3);
			playerTag4 = new JLabel(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(startWindow.getPlayerColor(3));
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(startWindow.getPlayerColor(3));
			add(playerCount4);
			playerTag5 = new JLabel(newGame.getPlayerAt(4).getName());
			playerTag5.setSize(150, 40);
			playerTag5.setLocation(830, 600);
			playerTag5.setFont(plyrTagFont);
			playerTag5.setForeground(startWindow.getPlayerColor(4));
			add(playerTag5);
			playerCount5 = new JLabel("You have " + newGame.getPlayerAt(4).getNumOfArmies() + " units left to place!");
			playerCount5.setSize(200, 40);
			playerCount5.setLocation(800, 620);
			playerCount5.setFont(plyrCountFont);
			playerCount5.setForeground(startWindow.getPlayerColor(4));
			add(playerCount5);
		}
		if (numberOfPlayers == 4) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
			playerTag3 = new JLabel(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(startWindow.getPlayerColor(2));
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(startWindow.getPlayerColor(2));
			add(playerCount3);
			playerTag4 = new JLabel(newGame.getPlayerAt(3).getName());
			playerTag4.setSize(150, 40);
			playerTag4.setLocation(660, 600);
			playerTag4.setFont(plyrTagFont);
			playerTag4.setForeground(startWindow.getPlayerColor(3));
			add(playerTag4);
			playerCount4 = new JLabel("You have " + newGame.getPlayerAt(3).getNumOfArmies() + " units left to place!");
			playerCount4.setSize(200, 40);
			playerCount4.setLocation(630, 620);
			playerCount4.setFont(plyrCountFont);
			playerCount4.setForeground(startWindow.getPlayerColor(3));
			add(playerCount4);
		}
		if (numberOfPlayers == 3) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
			playerTag3 = new JLabel(newGame.getPlayerAt(2).getName());
			playerTag3.setSize(150, 40);
			playerTag3.setLocation(490, 600);
			playerTag3.setFont(plyrTagFont);
			playerTag3.setForeground(startWindow.getPlayerColor(2));
			add(playerTag3);
			playerCount3 = new JLabel("You have " + newGame.getPlayerAt(2).getNumOfArmies() + " units left to place!");
			playerCount3.setSize(200, 40);
			playerCount3.setLocation(460, 620);
			playerCount3.setFont(plyrCountFont);
			playerCount3.setForeground(startWindow.getPlayerColor(2));
			add(playerCount3);
		}
		if (numberOfPlayers == 2) {
			playerTag = new JLabel(newGame.getPlayerAt(0).getName());
			playerTag.setSize(150, 40);
			playerTag.setLocation(170, 600);
			playerTag.setFont(plyrTagFont);
			playerTag.setForeground(startWindow.getPlayerColor(0));
			add(playerTag);
			playerCount = new JLabel("You have " + newGame.getPlayerAt(0).getNumOfArmies() + " units left to place!");
			playerCount.setSize(200, 40);
			playerCount.setLocation(130, 620);
			playerCount.setFont(plyrCountFont);
			playerCount.setForeground(startWindow.getPlayerColor(0));
			add(playerCount);
			playerTag2 = new JLabel(newGame.getPlayerAt(1).getName());
			playerTag2.setSize(150, 40);
			playerTag2.setLocation(340, 600);
			playerTag2.setFont(plyrTagFont);
			playerTag2.setForeground(startWindow.getPlayerColor(1));
			add(playerTag2);
			playerCount2 = new JLabel("You have " + newGame.getPlayerAt(1).getNumOfArmies() + " units left to place!");
			playerCount2.setSize(200, 40);
			playerCount2.setLocation(290, 620);
			playerCount2.setFont(plyrCountFont);
			playerCount2.setForeground(startWindow.getPlayerColor(1));
			add(playerCount2);
		}
	}

	public void startOldGame() {
		int numberOfPlayers = newGame.getNumOfPlayers();
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
			boolean reinforcemnetPhaseImport) {
		newGame = new GameLogic(null, null, null, null, null, null);
		newGame.setPlayerList(newPlayers);
		newGame.setCards(newCards);
		newGame.setTerritory(newTerritories);
		newGame.setContinents(newContinets);
		currPlayer = tempPlayer;
		reinforcementPhase = reinforcemnetPhaseImport;
		newGame.startLoadedGame();
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

		turnInCardsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "";
				Object[] options = { "Turn in", "Return" };
				int choice = JOptionPane.showOptionDialog(null, currPlayer.getCards(), "Current Player's Cards",
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

		if (startWindow.getNumberOfPlayer() == 6) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(purple);
					wilmaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(purple);
					zonaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(purple);
					wilberWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(purple);
					richWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(purple);
					millerWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(purple);
					mckaleWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(purple);
					scoobyWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(purple);
					javaLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(purple);
					pythonLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(purple);
					cLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(purple);
					sqlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(purple);
					rubyLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(purple);
					perlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(purple);
					gitLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(purple);
					papajohnsPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(purple);
					dominosPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(purple);
					pizzahutPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(purple);
					blackjackPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(purple);
					hungryhowiesPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(purple);
					brooklynPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(purple);
					pizzaplanetPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(purple);
					rawrvilleDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(purple);
					laieggesDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(purple);
					dactilitoDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(purple);
					dirtydanDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(purple);
					blackbeardDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(purple);
					monisaurusDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(purple);
					toystoryDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(purple);
					scraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(purple);
					landofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(purple);
					giantCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(purple);
					newlandofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(purple);
					southscraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(purple);
					bloobawlCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(purple);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(purple);
					apolloSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(purple);
					raSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(purple);
					heliosSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(purple);
					intiSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(purple);
					horusSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(purple);
					tonatiuhSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(purple);
					amunSun.setName(newGame.getPlayerAt(4).getName());
				}
			}

			for (Territory d : player6.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(blue);
					wilmaWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(blue);
					zonaWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(blue);
					wilberWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(blue);
					richWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(blue);
					millerWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(blue);
					mckaleWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(blue);
					scoobyWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(blue);
					javaLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(blue);
					pythonLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(blue);
					cLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(blue);
					sqlLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(blue);
					rubyLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(blue);
					perlLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(blue);
					gitLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(blue);
					papajohnsPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(blue);
					dominosPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(blue);
					pizzahutPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(blue);
					blackjackPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(blue);
					hungryhowiesPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(blue);
					brooklynPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(blue);
					pizzaplanetPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(blue);
					rawrvilleDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(blue);
					laieggesDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(blue);
					dactilitoDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(blue);
					dirtydanDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(blue);
					blackbeardDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(blue);
					monisaurusDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(blue);
					toystoryDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(blue);
					scraptopiaCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(blue);
					landofzachCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(blue);
					giantCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(blue);
					newlandofzachCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(blue);
					southscraptopiaCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(blue);
					bloobawlCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(blue);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(blue);
					apolloSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(blue);
					raSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(blue);
					heliosSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(blue);
					intiSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(blue);
					horusSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(blue);
					tonatiuhSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(blue);
					amunSun.setName(newGame.getPlayerAt(5).getName());
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 5) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(purple);
					wilmaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(purple);
					zonaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(purple);
					wilberWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(purple);
					richWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(purple);
					millerWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(purple);
					mckaleWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(purple);
					scoobyWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(purple);
					javaLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(purple);
					pythonLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(purple);
					cLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(purple);
					sqlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(purple);
					rubyLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(purple);
					perlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(purple);
					gitLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(purple);
					papajohnsPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(purple);
					dominosPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(purple);
					pizzahutPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(purple);
					blackjackPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(purple);
					hungryhowiesPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(purple);
					brooklynPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(purple);
					pizzaplanetPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(purple);
					rawrvilleDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(purple);
					laieggesDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(purple);
					dactilitoDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(purple);
					dirtydanDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(purple);
					blackbeardDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(purple);
					monisaurusDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(purple);
					toystoryDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(purple);
					scraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(purple);
					landofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(purple);
					giantCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(purple);
					newlandofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(purple);
					southscraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(purple);
					bloobawlCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(purple);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(purple);
					apolloSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(purple);
					raSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(purple);
					heliosSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(purple);
					intiSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(purple);
					horusSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(purple);
					tonatiuhSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(purple);
					amunSun.setName(newGame.getPlayerAt(4).getName());
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 4) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}

		}
		if (startWindow.getNumberOfPlayer() == 3) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Amun") {
					amunSun = new JButton(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 2) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat = new JButton(yellow);
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat = new JButton(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat = new JButton(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat = new JButton(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat = new JButton(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat = new JButton(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat = new JButton(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage = new JButton(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage = new JButton(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage = new JButton(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage = new JButton(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage = new JButton(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage = new JButton(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage = new JButton(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza = new JButton(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza = new JButton(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza = new JButton(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza = new JButton(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza = new JButton(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza = new JButton(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza = new JButton(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino = new JButton(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino = new JButton(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino = new JButton(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino = new JButton(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino = new JButton(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino = new JButton(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino = new JButton(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent = new JButton(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent = new JButton(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent = new JButton(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent = new JButton(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent = new JButton(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent = new JButton(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent = new JButton(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun = new JButton(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun = new JButton(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun = new JButton(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun = new JButton(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun = new JButton(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun = new JButton(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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

		}
		nextPlayer();

		javaLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				javaAttacking = false;
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && javaLanguage.getName() == currPlayer.getName()) {
						javaUnits += 1;
						territories.get(0).addUnits(1);
						languageLabel1.setText("" + javaUnits);
						currPlayer.removeArmies(1);
						
						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((javaLanguage.getName() == currPlayer.getName()) && (javaUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						javaAttacking = true;
						attackPhase = false;

					}
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
				if (horusAttacking == true && (currPlayer.getName() != javaLanguage.getName())) {
					System.out.println("Java was attacked by Horius");
					gameBoardAttack(territories.get(39), territories.get(0));
					horusAttacking = false;
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
					if (currPlayer.getNumOfArmies() >= 1 && pythonLanguage.getName() == currPlayer.getName()) {
						pythonUnits += 1;
						territories.get(1).addUnits(1);
						myLabel.setText("" + pythonUnits);
						currPlayer.removeArmies(1);
						
						nextPlayer();
					}

					checkIfReinforcementPhaseIsOver();

				}

				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((pythonLanguage.getName() == currPlayer.getName()) && (pythonUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						pythonAttacking = true;
						attackPhase = false;

					}
				}

				if (javaAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked");
					gameBoardAttack(territories.get(0), territories.get(1));
					javaAttacking = false;
					attackPhase = true;
				}
				if (sqlAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(1));
					sqlAttacking = false;
					attackPhase = true;
				}
				if (cAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked by c");
					gameBoardAttack(territories.get(2), territories.get(1));
					cAttacking = false;
					attackPhase = true;
				}
				if (gitAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked by git");
					gameBoardAttack(territories.get(5), territories.get(1));
					gitAttacking = false;
					attackPhase = true;
				}
				if (perlAttacking == true && (currPlayer.getName() != pythonLanguage.getName())) {
					System.out.println("Python was attacked by perl");
					gameBoardAttack(territories.get(6), territories.get(1));
					perlAttacking = false;
					attackPhase = true;
				}

				if ((perlFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					perlFortify = false;
				}
				if ((gitFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					gitFortify = false;
				}
				if ((cFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					cFortify = false;
				}
				if ((sqlFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
				}
				if ((javaFortify == true) && (currPlayer.getName() == pythonLanguage.getName())) {
					territories.get(1).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					javaFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == pythonLanguage.getName()) {
						System.out.println("fortify from python!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && cLanguage.getName() == currPlayer.getName()) {
						cUnits += 1;
						territories.get(2).addUnits(1);
						myLabel.setText("" + cUnits);
						currPlayer.removeArmies(1);
						
						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((cLanguage.getName() == currPlayer.getName()) && (cUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						cAttacking = true;
						attackPhase = false;

					}
				}

				if (javaAttacking == true && (currPlayer.getName() != cLanguage.getName())) {
					System.out.println("C was attacked by java");
					gameBoardAttack(territories.get(0), territories.get(2));
					javaAttacking = false;
					attackPhase = true;
				}
				if (sqlAttacking == true && (currPlayer.getName() != cLanguage.getName())) {
					System.out.println("C was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(2));
					sqlAttacking = false;
					attackPhase = true;
				}
				if (pythonAttacking == true && (currPlayer.getName() != cLanguage.getName())) {
					System.out.println("c was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(2));
					cAttacking = false;
					attackPhase = true;
				}
				if (rubyAttacking == true && (currPlayer.getName() != cLanguage.getName())) {
					System.out.println("c was attacked by ruby");
					gameBoardAttack(territories.get(4), territories.get(2));
					rubyAttacking = false;
					attackPhase = true;
				}

				if ((pythonFortify == true) && (currPlayer.getName() == cLanguage.getName())) {
					territories.get(2).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
				}
				if ((rubyFortify == true) && (currPlayer.getName() == cLanguage.getName())) {
					territories.get(2).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rubyFortify = false;
				}
				if ((sqlFortify == true) && (currPlayer.getName() == cLanguage.getName())) {
					territories.get(2).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
				}
				if ((javaFortify == true) && (currPlayer.getName() == cLanguage.getName())) {
					territories.get(2).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					javaFortify = false;
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == cLanguage.getName()) {
						System.out.println("fortify from c!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && sqlLanguage.getName() == currPlayer.getName()) {
						sqlUnits += 1;
						territories.get(3).addUnits(1);
						myLabel.setText("" + sqlUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((sqlLanguage.getName() == currPlayer.getName()) && (sqlUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						sqlAttacking = true;
						attackPhase = false;

					}
				}

				if (javaAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by java");
					gameBoardAttack(territories.get(0), territories.get(3));
					javaAttacking = false;
					attackPhase = true;
				}
				if (pythonAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(3));
					pythonAttacking = false;
					attackPhase = true;
				}
				if (cAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by c");
					gameBoardAttack(territories.get(2), territories.get(3));
					cAttacking = false;
					attackPhase = true;
				}
				if (rubyAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by ruby");
					gameBoardAttack(territories.get(4), territories.get(3));
					rubyAttacking = false;
					attackPhase = true;
				}
				if (gitAttacking == true && (currPlayer.getName() != sqlLanguage.getName())) {
					System.out.println("SQl was attacked by git");
					gameBoardAttack(territories.get(5), territories.get(3));
					gitAttacking = false;
					attackPhase = true;
				}

				if ((gitFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					gitFortify = false;
				}
				if ((rubyFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rubyFortify = false;
				}
				if ((cFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					cFortify = false;
				}
				if ((pythonFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
				}
				if ((javaFortify == true) && (currPlayer.getName() == sqlLanguage.getName())) {
					territories.get(3).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					javaFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == sqlLanguage.getName()) {
						System.out.println("fortify from sql!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && rubyLanguage.getName() == currPlayer.getName()) {
						rubyUnits += 1;
						territories.get(4).addUnits(1);
						myLabel.setText("" + rubyUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((rubyLanguage.getName() == currPlayer.getName()) && (rubyUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");

						rubyAttacking = true;
						attackPhase = false;
					}
				}
				if (cAttacking == true && (currPlayer.getName() != rubyLanguage.getName())) {
					System.out.println("ruby was attacked by c");
					gameBoardAttack(territories.get(2), territories.get(4));
					cAttacking = false;
					attackPhase = true;
				}
				if (sqlAttacking == true && (currPlayer.getName() != rubyLanguage.getName())) {
					System.out.println("ruby was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(4));
					sqlAttacking = false;
					attackPhase = true;
				}
				if (gitAttacking == true && (currPlayer.getName() != rubyLanguage.getName())) {
					System.out.println("ruby was attacked by git");
					gameBoardAttack(territories.get(5), territories.get(4));
					gitAttacking = false;
					attackPhase = true;
				}
				if (giantAttacking == true && (currPlayer.getName() != rubyLanguage.getName())) {
					System.out.println("ruby was attacked by giant");
					gameBoardAttack(territories.get(30), territories.get(4));
					giantAttacking = false;
					attackPhase = true;
				}
				if ((giantFortify == true) && (currPlayer.getName() == rubyLanguage.getName())) {
					territories.get(4).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
				}
				if ((gitFortify == true) && (currPlayer.getName() == rubyLanguage.getName())) {
					territories.get(4).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					gitFortify = false;
				}
				if ((sqlFortify == true) && (currPlayer.getName() == rubyLanguage.getName())) {
					territories.get(4).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
				}
				if ((cFortify == true) && (currPlayer.getName() == rubyLanguage.getName())) {
					territories.get(4).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					cFortify = false;
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == rubyLanguage.getName()) {
						System.out.println("fortify from ruby!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && gitLanguage.getName() == currPlayer.getName()) {
						gitUnits += 1;
						territories.get(5).addUnits(1);
						myLabel.setText("" + gitUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((gitLanguage.getName() == currPlayer.getName()) && (gitUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						gitAttacking = true;
						attackPhase = false;
					}
				}
				if (pythonAttacking == true && (currPlayer.getName() != gitLanguage.getName())) {
					System.out.println("git was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(5));
					pythonAttacking = false;
					attackPhase = true;
				}
				if (sqlAttacking == true && (currPlayer.getName() != gitLanguage.getName())) {
					System.out.println("git was attacked by sql");
					gameBoardAttack(territories.get(3), territories.get(5));
					sqlAttacking = false;
					attackPhase = true;
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
				}
				if (perlAttacking == true && (currPlayer.getName() != gitLanguage.getName())) {
					System.out.println("git was attacked by giant");
					gameBoardAttack(territories.get(6), territories.get(5));
					perlAttacking = false;
					attackPhase = true;
				}

				if ((perlFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					perlFortify = false;
				}
				if ((giantFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
				}
				if ((rubyFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rubyFortify = false;
				}
				if ((sqlFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					sqlFortify = false;
				}
				if ((pythonFortify == true) && (currPlayer.getName() == gitLanguage.getName())) {
					territories.get(5).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == gitLanguage.getName()) {
						System.out.println("fortify from git!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && perlLanguage.getName() == currPlayer.getName()) {
						perlUnits += 1;
						territories.get(6).addUnits(1);
						myLabel.setText("" + perlUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((perlLanguage.getName() == currPlayer.getName()) && (perlUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						perlAttacking = true;
						attackPhase = false;
					}
				}
				if (pythonAttacking == true && (currPlayer.getName() != perlLanguage.getName())) {
					System.out.println("perl was attacked by python");
					gameBoardAttack(territories.get(1), territories.get(6));
					pythonAttacking = false;
					attackPhase = true;
				}
				if (gitAttacking == true && (currPlayer.getName() != perlLanguage.getName())) {
					System.out.println("perl was attacked by git");
					gameBoardAttack(territories.get(5), territories.get(6));
					gitAttacking = false;
					attackPhase = true;
				}
				if ((gitFortify == true) && (currPlayer.getName() == perlLanguage.getName())) {
					territories.get(6).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					gitFortify = false;
				}
				if ((pythonFortify == true) && (currPlayer.getName() == perlLanguage.getName())) {
					territories.get(6).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pythonFortify = false;
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == perlLanguage.getName()) {
						System.out.println("fortify from perl!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && wilberWildcat.getName() == currPlayer.getName()) {
						wilberUnits += 1;
						territories.get(14).addUnits(1);
						myLabel.setText("" + wilberUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((wilberWildcat.getName() == currPlayer.getName()) && (wilberUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						wilberAttacking = true;
						attackPhase = false;
					}
				}
				if (wilmaAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(15), territories.get(14));
					wilmaAttacking = false;
					attackPhase = true;
				}
				if (richAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(14));
					richAttacking = false;
					attackPhase = true;
				}
				if (scoobyAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(14));
					scoobyAttacking = false;
					attackPhase = true;
				}
				if (papaAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(14));
					papaAttacking = false;
					attackPhase = true;
				}
				if (dominosAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(14));
					dominosAttacking = false;
					attackPhase = true;
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(14));
					brooklynsAttacking = false;
					attackPhase = true;
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != wilberWildcat.getName())) {
					System.out.println("wilber was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(14));
					tonatiuhAttacking = false;
					attackPhase = true;
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
				}
				if ((brooklynFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
				}
				if ((dominosFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
				}
				if ((papaFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
				}
				if ((scoobyFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
				}
				if ((richFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
				}
				if ((wilmaFortify == true) && (currPlayer.getName() == wilberWildcat.getName())) {
					territories.get(14).addUnits(unitsFortified);
					updateLabels();
					wilmaFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == wilberWildcat.getName()) {
						System.out.println("fortify from wilber!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && wilmaWildcat.getName() == currPlayer.getName()) {
						wilmaUnits += 1;
						territories.get(15).addUnits(1);
						myLabel.setText("" + wilmaUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((wilmaWildcat.getName() == currPlayer.getName()) && (wilmaUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						wilmaAttacking = true;
						attackPhase = false;
					}
				}
				if (wilberAttacking == true && (currPlayer.getName() != wilmaWildcat.getName())) {
					System.out.println("wilma was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(15));
					wilberAttacking = false;
					attackPhase = true;
				}
				if (richAttacking == true && (currPlayer.getName() != wilmaWildcat.getName())) {
					System.out.println("wilma was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(15));
					richAttacking = false;
					attackPhase = true;
				}
				if (millerAttacking == true && (currPlayer.getName() != wilmaWildcat.getName())) {
					System.out.println("wilma was attacked by python");
					gameBoardAttack(territories.get(17), territories.get(15));
					millerAttacking = false;
					attackPhase = true;
				}

				if ((wilberFortify == true) && (currPlayer.getName() == wilmaWildcat.getName())) {
					territories.get(15).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
				}
				if ((richFortify == true) && (currPlayer.getName() == wilmaWildcat.getName())) {
					territories.get(15).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
				}
				if ((millerFortify == true) && (currPlayer.getName() == wilmaWildcat.getName())) {
					territories.get(15).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					millerFortify = false;
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == wilmaWildcat.getName()) {
						System.out.println("fortify from wilma!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && richWildcat.getName() == currPlayer.getName()) {
						richUnits += 1;
						territories.get(16).addUnits(1);
						myLabel.setText("" + richUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				///////////////////////////////// Start Attack
				///////////////////////////////// Phase//////////////////////////////////////////
				if (attackPhase == true) {
					if ((richWildcat.getName() == currPlayer.getName()) && (richUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						richAttacking = true;
						attackPhase = false;
					}
				}
				if (wilberAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(16));
					wilberAttacking = false;
					attackPhase = true;
				}
				if (wilmaAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(15), territories.get(16));
					wilmaAttacking = false;
					attackPhase = true;
				}
				if (millerAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(17), territories.get(16));
					millerAttacking = false;
					attackPhase = true;
				}
				if (scoobyAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(16));
					scoobyAttacking = false;
					attackPhase = true;
				}
				if (mckaleAttacking == true && (currPlayer.getName() != richWildcat.getName())) {
					System.out.println("rich was attacked by python");
					gameBoardAttack(territories.get(19), territories.get(16));
					mckaleAttacking = false;
					attackPhase = true;
				}

				if ((wilberFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
				}
				if ((wilmaFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilmaFortify = false;
				}
				if ((millerFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					millerFortify = false;
				}
				if ((scoobyFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
				}
				if ((mckaleFortify == true) && (currPlayer.getName() == richWildcat.getName())) {
					territories.get(16).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					mckaleFortify = false;
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == richWildcat.getName()) {
						System.out.println("fortify from wilber!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && millerWildcat.getName() == currPlayer.getName()) {
						millerUnits += 1;
						territories.get(17).addUnits(1);
						myLabel.setText("" + millerUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((millerWildcat.getName() == currPlayer.getName()) && (millerUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						millerAttacking = true;
						attackPhase = false;
					}
				}
				if (wilmaAttacking == true && (currPlayer.getName() != millerWildcat.getName())) {
					System.out.println("miller was attacked by python");
					gameBoardAttack(territories.get(15), territories.get(17));
					wilmaAttacking = false;
					attackPhase = true;
				}
				if (richAttacking == true && (currPlayer.getName() != millerWildcat.getName())) {
					System.out.println("miller was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(17));
					richAttacking = false;
					attackPhase = true;
				}
				if (mckaleAttacking == true && (currPlayer.getName() != millerWildcat.getName())) {
					System.out.println("miller was attacked by python");
					gameBoardAttack(territories.get(19), territories.get(17));
					mckaleAttacking = false;
					attackPhase = true;
				}
				if (scraptopiaAttacking == true && (currPlayer.getName() != millerWildcat.getName())) {
					System.out.println("miller was attacked by python");
					gameBoardAttack(territories.get(28), territories.get(17));
					scraptopiaAttacking = false;
					attackPhase = true;
				}

				if ((wilmaFortify == true) && (currPlayer.getName() == millerWildcat.getName())) {
					territories.get(17).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilmaFortify = false;
				}
				if ((scraptopiaFortify == true) && (currPlayer.getName() == millerWildcat.getName())) {
					territories.get(17).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scraptopiaFortify = false;
				}
				if ((mckaleFortify == true) && (currPlayer.getName() == millerWildcat.getName())) {
					territories.get(17).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					mckaleFortify = false;
				}
				if ((richFortify == true) && (currPlayer.getName() == millerWildcat.getName())) {
					territories.get(17).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == millerWildcat.getName()) {
						System.out.println("fortify from miller!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && scoobyWildcat.getName() == currPlayer.getName()) {
						scoobyUnits += 1;
						territories.get(18).addUnits(1);
						myLabel.setText("" + scoobyUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((scoobyWildcat.getName() == currPlayer.getName()) && (scoobyUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						scoobyAttacking = true;
						attackPhase = false;
					}
				}
				if (wilberAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(18));
					wilberAttacking = false;
					attackPhase = true;
				}
				if (richAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(18));
					richAttacking = false;
					attackPhase = true;
				}
				if (mckaleAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(19), territories.get(18));
					mckaleAttacking = false;
					attackPhase = true;
				}
				if (zonaAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(20), territories.get(18));
					zonaAttacking = false;
					attackPhase = true;
				}
				if (papaAttacking == true && (currPlayer.getName() != scoobyWildcat.getName())) {
					System.out.println("scooby was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(18));
					papaAttacking = false;
					attackPhase = true;
				}

				if ((papaFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
				}
				if ((zonaFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					zonaFortify = false;
				}
				if ((mckaleFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					mckaleFortify = false;
				}
				if ((richFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
				}
				if ((wilberFortify == true) && (currPlayer.getName() == scoobyWildcat.getName())) {
					territories.get(18).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == scoobyWildcat.getName()) {
						System.out.println("fortify from scooby!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && mckaleWildcat.getName() == currPlayer.getName()) {
						mckaleUnits += 1;
						territories.get(19).addUnits(1);
						myLabel.setText("" + mckaleUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((mckaleWildcat.getName() == currPlayer.getName()) && (mckaleUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						mckaleAttacking = true;
						attackPhase = false;
					}
				}
				if (richAttacking == true && (currPlayer.getName() != mckaleWildcat.getName())) {
					System.out.println("mckale was attacked by python");
					gameBoardAttack(territories.get(16), territories.get(19));
					richAttacking = false;
					attackPhase = true;
				}
				if (millerAttacking == true && (currPlayer.getName() != mckaleWildcat.getName())) {
					System.out.println("mckale was attacked by python");
					gameBoardAttack(territories.get(17), territories.get(19));
					millerAttacking = false;
					attackPhase = true;
				}
				if (scoobyAttacking == true && (currPlayer.getName() != mckaleWildcat.getName())) {
					System.out.println("mckale was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(19));
					scoobyAttacking = false;
					attackPhase = true;
				}
				if (zonaAttacking == true && (currPlayer.getName() != mckaleWildcat.getName())) {
					System.out.println("mckale was attacked by python");
					gameBoardAttack(territories.get(20), territories.get(19));
					zonaAttacking = false;
					attackPhase = true;
				}

				if ((zonaFortify == true) && (currPlayer.getName() == mckaleWildcat.getName())) {
					territories.get(19).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					zonaFortify = false;
				}
				if ((scoobyFortify == true) && (currPlayer.getName() == mckaleWildcat.getName())) {
					territories.get(19).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
				}
				if ((millerFortify == true) && (currPlayer.getName() == mckaleWildcat.getName())) {
					territories.get(19).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					millerFortify = false;
				}
				if ((richFortify == true) && (currPlayer.getName() == mckaleWildcat.getName())) {
					territories.get(19).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					richFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == mckaleWildcat.getName()) {
						System.out.println("fortify from miller!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && zonaWildcat.getName() == currPlayer.getName()) {
						zonaUnits += 1;
						territories.get(20).addUnits(1);
						myLabel.setText("" + zonaUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((zonaWildcat.getName() == currPlayer.getName()) && (zonaUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						zonaAttacking = true;
						attackPhase = false;
					}
				}
				if (scoobyAttacking == true && (currPlayer.getName() != zonaWildcat.getName())) {
					System.out.println("zona was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(20));
					scoobyAttacking = false;
					attackPhase = true;
				}
				if (mckaleAttacking == true && (currPlayer.getName() != zonaWildcat.getName())) {
					System.out.println("zona was attacked by python");
					gameBoardAttack(territories.get(19), territories.get(20));
					mckaleAttacking = false;
					attackPhase = true;
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == zonaWildcat.getName()) {
						System.out.println("fortify from zona!!!");
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
				}
				if ((scoobyFortify == true) && (currPlayer.getName() == zonaWildcat.getName())) {
					territories.get(20).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
				}
			}
		});
		papajohnsPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton myButton = (JButton) e.getSource();
				JLabel myLabel = myMap.get(myButton);
				if (reinforcementPhase == true) {
					if (currPlayer.getNumOfArmies() >= 1 && papajohnsPizza.getName() == currPlayer.getName()) {
						pjUnits += 1;
						territories.get(21).addUnits(1);
						myLabel.setText("" + pjUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((papajohnsPizza.getName() == currPlayer.getName()) && (pjUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						papaAttacking = true;
						attackPhase = false;
					}
				}
				if (dominosAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("papajohns was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(21));
					dominosAttacking = false;
					attackPhase = true;
				}
				if (pizzahutAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("papa was attacked by python");
					gameBoardAttack(territories.get(23), territories.get(21));
					pizzahutAttacking = false;
					attackPhase = true;
				}
				if (blackjackAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("dpapa was attacked by python");
					gameBoardAttack(territories.get(24), territories.get(21));
					blackjackAttacking = false;
					attackPhase = true;
				}
				if (wilberAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("papa was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(21));
					wilberAttacking = false;
					attackPhase = true;
				}
				if (scoobyAttacking == true && (currPlayer.getName() != papajohnsPizza.getName())) {
					System.out.println("papa was attacked by python");
					gameBoardAttack(territories.get(18), territories.get(21));
					scoobyAttacking = false;
					attackPhase = true;
				}

				if ((scoobyFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scoobyFortify = false;
				}
				if ((wilberFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
				}
				if ((blackjackFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackjackFortify = false;
				}
				if ((pizzahutFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzahutFortify = false;
				}
				if ((dominosFortify == true) && (currPlayer.getName() == papajohnsPizza.getName())) {
					territories.get(21).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == papajohnsPizza.getName()) {
						System.out.println("fortify from papa!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && dominosPizza.getName() == currPlayer.getName()) {
						domUnits += 1;
						territories.get(22).addUnits(1);
						myLabel.setText("" + domUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((dominosPizza.getName() == currPlayer.getName()) && (domUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						dominosAttacking = true;
						attackPhase = false;
					}
				}
				if (papaAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("dom was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(22));
					papaAttacking = false;
					attackPhase = true;
				}
				if (pizzahutAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("dom was attacked by python");
					gameBoardAttack(territories.get(23), territories.get(22));
					pizzahutAttacking = false;
					attackPhase = true;
				}
				if (hungryhowiesAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("domy how was attacked by python");
					gameBoardAttack(territories.get(25), territories.get(22));
					hungryhowiesAttacking = false;
					attackPhase = true;
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("dom was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(22));
					brooklynsAttacking = false;
					attackPhase = true;
				}
				if (wilberAttacking == true && (currPlayer.getName() != dominosPizza.getName())) {
					System.out.println("dom was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(22));
					wilberAttacking = false;
					attackPhase = true;
				}
				if ((wilberFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
				}
				if ((brooklynFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
				}
				if ((hungryhowiesFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					hungryhowiesFortify = false;
				}
				if ((pizzahutFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzahutFortify = false;
				}
				if ((papaFortify == true) && (currPlayer.getName() == dominosPizza.getName())) {
					territories.get(22).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == dominosPizza.getName()) {
						System.out.println("fortify from dominos!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && pizzahutPizza.getName() == currPlayer.getName()) {
						phUnits += 1;
						territories.get(23).addUnits(1);
						myLabel.setText("" + phUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((pizzahutPizza.getName() == currPlayer.getName()) && (phUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						pizzahutAttacking = true;
						attackPhase = false;
					}
				}
				if (papaAttacking == true && (currPlayer.getName() != pizzahutPizza.getName())) {
					System.out.println("pizzhut was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(23));
					papaAttacking = false;
					attackPhase = true;
				}
				if (dominosAttacking == true && (currPlayer.getName() != pizzahutPizza.getName())) {
					System.out.println("pizza was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(23));
					dominosAttacking = false;
					attackPhase = true;
				}
				if (blackjackAttacking == true && (currPlayer.getName() != pizzahutPizza.getName())) {
					System.out.println("pizzhut was attacked by python");
					gameBoardAttack(territories.get(24), territories.get(23));
					blackjackAttacking = false;
					attackPhase = true;
				}
				if (hungryhowiesAttacking == true && (currPlayer.getName() != pizzahutPizza.getName())) {
					System.out.println("pizzhut was attacked by python");
					gameBoardAttack(territories.get(25), territories.get(23));
					hungryhowiesAttacking = false;
					attackPhase = true;
				}
				if ((hungryhowiesFortify == true) && (currPlayer.getName() == pizzahutPizza.getName())) {
					territories.get(23).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					hungryhowiesFortify = false;
				}
				if ((blackjackFortify == true) && (currPlayer.getName() == pizzahutPizza.getName())) {
					territories.get(23).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackjackFortify = false;
				}
				if ((dominosFortify == true) && (currPlayer.getName() == pizzahutPizza.getName())) {
					territories.get(23).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
				}
				if ((papaFortify == true) && (currPlayer.getName() == pizzahutPizza.getName())) {
					territories.get(23).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == pizzahutPizza.getName()) {
						System.out.println("fortify from hut!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && blackjackPizza.getName() == currPlayer.getName()) {
						bjUnits += 1;
						territories.get(24).addUnits(1);
						myLabel.setText("" + bjUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((blackjackPizza.getName() == currPlayer.getName()) && (bjUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						blackjackAttacking = true;
						attackPhase = false;
					}
				}
				if (papaAttacking == true && (currPlayer.getName() != blackjackPizza.getName())) {
					System.out.println("blackjack was attacked by python");
					gameBoardAttack(territories.get(21), territories.get(24));
					papaAttacking = false;
					attackPhase = true;
				}
				if (dominosAttacking == true && (currPlayer.getName() != blackjackPizza.getName())) {
					System.out.println("blackjack was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(24));
					dominosAttacking = false;
					attackPhase = true;
				}
				if (pizzahutAttacking == true && (currPlayer.getName() != blackjackPizza.getName())) {
					System.out.println("blackjack was attacked by python");
					gameBoardAttack(territories.get(23), territories.get(24));
					pizzahutAttacking = false;
					attackPhase = true;
				}

				if ((pizzahutFortify == true) && (currPlayer.getName() == blackjackPizza.getName())) {
					territories.get(24).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzahutFortify = false;
				}

				if ((dominosFortify == true) && (currPlayer.getName() == blackjackPizza.getName())) {
					territories.get(24).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
				}

				if ((papaFortify == true) && (currPlayer.getName() == blackjackPizza.getName())) {
					territories.get(24).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					papaFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == blackjackPizza.getName()) {
						System.out.println("fortify from blackj!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && hungryhowiesPizza.getName() == currPlayer.getName()) {
						hhUnits += 1;
						territories.get(25).addUnits(1);
						myLabel.setText("" + hhUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((hungryhowiesPizza.getName() == currPlayer.getName()) && (hhUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						hungryhowiesAttacking = true;
						attackPhase = false;
					}
				}
				if (dominosAttacking == true && (currPlayer.getName() != hungryhowiesPizza.getName())) {
					System.out.println("hungryHowies was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(25));
					dominosAttacking = false;
					attackPhase = true;
				}
				if (pizzahutAttacking == true && (currPlayer.getName() != hungryhowiesPizza.getName())) {
					System.out.println("hungryHowies was attacked by python");
					gameBoardAttack(territories.get(23), territories.get(25));
					pizzahutAttacking = false;
					attackPhase = true;
				}
				if (blackjackAttacking == true && (currPlayer.getName() != hungryhowiesPizza.getName())) {
					System.out.println("hungryHowies was attacked by python");
					gameBoardAttack(territories.get(24), territories.get(25));
					blackjackAttacking = false;
					attackPhase = true;
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != hungryhowiesPizza.getName())) {
					System.out.println("hungryHowies was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(25));
					brooklynsAttacking = false;
					attackPhase = true;
				}

				if ((brooklynFortify == true) && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					territories.get(25).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
				}
				if ((blackjackFortify == true) && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					territories.get(25).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackjackFortify = false;
				}
				if ((pizzahutFortify == true) && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					territories.get(25).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzahutFortify = false;
				}
				if ((dominosFortify == true) && (currPlayer.getName() == hungryhowiesPizza.getName())) {
					territories.get(25).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == hungryhowiesPizza.getName()) {
						System.out.println("fortify from hungryhowies!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && brooklynPizza.getName() == currPlayer.getName()) {
						bUnits += 1;
						territories.get(26).addUnits(1);
						myLabel.setText("" + bUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((brooklynPizza.getName() == currPlayer.getName()) && (bUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						brooklynsAttacking = true;
						attackPhase = false;
					}
				}
				if (dominosAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(22), territories.get(26));
					dominosAttacking = false;
					attackPhase = true;
				}
				if (hungryhowiesAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(25), territories.get(26));
					hungryhowiesAttacking = false;
					attackPhase = true;
				}
				if (pizzaplanetAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(27), territories.get(26));
					pizzaplanetAttacking = false;
					attackPhase = true;
				}
				if (wilberAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(14), territories.get(26));
					wilberAttacking = false;
					attackPhase = true;
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != brooklynPizza.getName())) {
					System.out.println("brookl was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(26));
					tonatiuhAttacking = false;
					attackPhase = true;
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
				}
				if ((wilberFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					wilberFortify = false;
				}
				if ((pizzaplanetFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzaplanetFortify = false;
				}
				if ((hungryhowiesFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					hungryhowiesFortify = false;
				}
				if ((dominosFortify == true) && (currPlayer.getName() == brooklynPizza.getName())) {
					territories.get(26).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dominosFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == brooklynPizza.getName()) {
						System.out.println("fortify from brook!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && pizzaplanetPizza.getName() == currPlayer.getName()) {
						ppUnits += 1;
						territories.get(27).addUnits(1);
						myLabel.setText("" + ppUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if (attackPhase == true) {
					if ((pizzaplanetPizza.getName() == currPlayer.getName()) && (ppUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						gameBoardAttack(territories.get(1), territories.get(27));
						pizzaplanetAttacking = true;
						attackPhase = false;
					}
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != pizzaplanetPizza.getName())) {
					System.out.println("pizzaplanet was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(27));
					brooklynsAttacking = false;
					attackPhase = true;
				}
				if (apolloAttacking == true && (currPlayer.getName() != pizzaplanetPizza.getName())) {
					System.out.println("pizzaplanet was attacked by python");
					gameBoardAttack(territories.get(35), territories.get(27));
					apolloAttacking = false;
					attackPhase = true;
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != pizzaplanetPizza.getName())) {
					System.out.println("pizzaplanet was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(27));
					tonatiuhAttacking = false;
					attackPhase = true;
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == pizzaplanetPizza.getName())) {
					territories.get(27).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
				}
				if ((apolloFortify == true) && (currPlayer.getName() == pizzaplanetPizza.getName())) {
					territories.get(27).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					apolloFortify = false;
				}
				if ((brooklynFortify == true) && (currPlayer.getName() == pizzaplanetPizza.getName())) {
					territories.get(27).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == pizzaplanetPizza.getName()) {
						System.out.println("fortify from pizzaplanet!!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && apolloSun.getName() == currPlayer.getName()) {
						apolloUnits += 1;
						territories.get(35).addUnits(1);
						myLabel.setText("" + apolloUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(apolloSun.getName() == currPlayer.getName())){
					apolloUnits +=1;
					territories.get(35).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((apolloSun.getName() == currPlayer.getName()) && (apolloUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						apolloAttacking = true;
						attackPhase = false;
					}
				}
				if (raAttacking == true && (currPlayer.getName() != apolloSun.getName())) {
					System.out.println("apollo was attacked by python");
					gameBoardAttack(territories.get(36), territories.get(35));
					raAttacking = false;
					attackPhase = true;
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != apolloSun.getName())) {
					System.out.println("apollo was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(35));
					tonatiuhAttacking = false;
					attackPhase = true;
				}
				if (amunAttacking == true && (currPlayer.getName() != apolloSun.getName())) {
					System.out.println("apollo was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(35));
					amunAttacking = false;
					attackPhase = true;
				}
				if (pizzaplanetAttacking == true && (currPlayer.getName() != apolloSun.getName())) {
					System.out.println("apollo was attacked by python");
					gameBoardAttack(territories.get(27), territories.get(35));
					pizzaplanetAttacking = false;
					attackPhase = true;
				}

				if ((pizzaplanetFortify == true) && (currPlayer.getName() == apolloSun.getName())) {
					territories.get(35).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzaplanetFortify = false;
				}
				if ((amunFortify == true) && (currPlayer.getName() == apolloSun.getName())) {
					territories.get(35).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
				}
				if ((tonatiuhFortify == true) && (currPlayer.getName() == apolloSun.getName())) {
					territories.get(35).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
				}
				if ((raFortify == true) && (currPlayer.getName() == apolloSun.getName())) {
					territories.get(35).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					raFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == apolloSun.getName()) {
						System.out.println("fortify from apollo!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && raSun.getName() == currPlayer.getName()) {
						raUnits += 1;
						territories.get(36).addUnits(1);
						myLabel.setText("" + raUnits);
						currPlayer.removeArmies(1);
						
						nextPlayer();
					}

					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(raSun.getName() == currPlayer.getName())){
					raUnits +=1;
					territories.get(36).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((raSun.getName() == currPlayer.getName()) && (raUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						raAttacking = true;
						attackPhase = false;
					}
				}
				if (apolloAttacking == true && (currPlayer.getName() != raSun.getName())) {
					System.out.println("ra was attacked by python");
					gameBoardAttack(territories.get(35), territories.get(36));
					apolloAttacking = false;
					attackPhase = true;
				}
				if (heliosAttacking == true && (currPlayer.getName() != raSun.getName())) {
					System.out.println("ra was attacked by python");
					gameBoardAttack(territories.get(37), territories.get(36));
					heliosAttacking = false;
					attackPhase = true;
				}
				if (amunAttacking == true && (currPlayer.getName() != raSun.getName())) {
					System.out.println("ra was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(36));
					amunAttacking = false;
					attackPhase = true;
				}

				if ((amunFortify == true) && (currPlayer.getName() == raSun.getName())) {
					territories.get(36).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
				}
				if ((heliosFortify == true) && (currPlayer.getName() == raSun.getName())) {
					territories.get(36).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					heliosFortify = false;
				}
				if ((apolloFortify == true) && (currPlayer.getName() == raSun.getName())) {
					territories.get(36).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					apolloFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == amunSun.getName()) {
						System.out.println("fortify from amun!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && heliosSun.getName() == currPlayer.getName()) {
						heliosUnits += 1;
						territories.get(37).addUnits(1);
						myLabel.setText("" + heliosUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(heliosSun.getName() == currPlayer.getName())){
					heliosUnits +=1;
					territories.get(37).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((heliosSun.getName() == currPlayer.getName()) && (heliosUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						heliosAttacking = true;
						attackPhase = false;
					}
				}
				if (raAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(36), territories.get(37));
					raAttacking = false;
					attackPhase = true;
				}
				if (intiAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(38), territories.get(37));
					intiAttacking = false;
					attackPhase = true;
				}
				if (horusAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(39), territories.get(37));
					horusAttacking = false;
					attackPhase = true;
				}
				if (amunAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(37));
					amunAttacking = false;
					attackPhase = true;
				}
				if (javaAttacking == true && (currPlayer.getName() != heliosSun.getName())) {
					System.out.println("helios was attacked by python");
					gameBoardAttack(territories.get(0), territories.get(37));
					javaAttacking = false;
					attackPhase = true;
				}

				if ((javaFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					javaFortify = false;
				}
				if ((amunFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
				}
				if ((horusFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
				}
				if ((intiFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					intiFortify = false;
				}
				if ((raFortify == true) && (currPlayer.getName() == heliosSun.getName())) {
					territories.get(37).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					raFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == heliosSun.getName()) {
						System.out.println("fortify from helios!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && intiSun.getName() == currPlayer.getName()) {
						intiUnits += 1;
						territories.get(38).addUnits(1);
						myLabel.setText("" + intiUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(intiSun.getName() == currPlayer.getName())){
					intiUnits +=1;
					territories.get(38).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((intiSun.getName() == currPlayer.getName()) && (intiUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						intiAttacking = true;
						attackPhase = false;
					}
				}
				if (heliosAttacking == true && (currPlayer.getName() != intiSun.getName())) {
					System.out.println("inti was attacked by python");
					gameBoardAttack(territories.get(37), territories.get(38));
					heliosAttacking = false;
					attackPhase = true;
				}
				if (horusAttacking == true && (currPlayer.getName() != intiSun.getName())) {
					System.out.println("inti was attacked by python");
					gameBoardAttack(territories.get(39), territories.get(38));
					horusAttacking = false;
					attackPhase = true;
				}

				if ((horusFortify == true) && (currPlayer.getName() == intiSun.getName())) {
					territories.get(38).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
				}
				if ((heliosFortify == true) && (currPlayer.getName() == intiSun.getName())) {
					territories.get(38).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					heliosFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == intiSun.getName()) {
						System.out.println("fortify from inti!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && horusSun.getName() == currPlayer.getName()) {
						horusUnits += 1;
						territories.get(39).addUnits(1);
						myLabel.setText("" + horusUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(horusSun.getName() == currPlayer.getName())){
					horusUnits +=1;
					territories.get(39).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((horusSun.getName() == currPlayer.getName()) && (horusUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						horusAttacking = true;
						attackPhase = false;
					}
				}
				if (heliosAttacking == true && (currPlayer.getName() != horusSun.getName())) {
					System.out.println("horus was attacked by python");
					gameBoardAttack(territories.get(37), territories.get(39));
					heliosAttacking = false;
					attackPhase = true;
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != horusSun.getName())) {
					System.out.println("horus was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(39));
					tonatiuhAttacking = false;
					attackPhase = true;
				}
				if (intiAttacking == true && (currPlayer.getName() != horusSun.getName())) {
					System.out.println("horus was attacked by python");
					gameBoardAttack(territories.get(38), territories.get(39));
					intiAttacking = false;
					attackPhase = true;
				}
				if (amunAttacking == true && (currPlayer.getName() != horusSun.getName())) {
					System.out.println("horus was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(39));
					amunAttacking = false;
					attackPhase = true;
				}

				if ((amunFortify == true) && (currPlayer.getName() == horusSun.getName())) {
					territories.get(39).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
				}
				if ((intiFortify == true) && (currPlayer.getName() == horusSun.getName())) {
					territories.get(39).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					intiFortify = false;
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == horusSun.getName())) {
					territories.get(39).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
				}

				if ((heliosFortify == true) && (currPlayer.getName() == horusSun.getName())) {
					territories.get(39).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					heliosFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == horusSun.getName()) {
						System.out.println("fortify from horus!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && tonatiuhSun.getName() == currPlayer.getName()) {
						tonatiuhUnits += 1;
						territories.get(40).addUnits(1);
						myLabel.setText("" + tonatiuhUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(tonatiuhSun.getName() == currPlayer.getName())){
					tonatiuhUnits +=1;
					territories.get(40).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((tonatiuhSun.getName() == currPlayer.getName()) && (tonatiuhUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						tonatiuhAttacking = true;
						attackPhase = false;
					}
				}
				if (apolloAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(35), territories.get(40));
					apolloAttacking = false;
					attackPhase = true;
				}
				if (horusAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(39), territories.get(40));
					horusAttacking = false;
					attackPhase = true;
				}
				if (amunAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(41), territories.get(40));
					amunAttacking = false;
					attackPhase = true;
				}
				if (brooklynsAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(26), territories.get(40));
					brooklynsAttacking = false;
					attackPhase = true;
				}
				if (pizzaplanetAttacking == true && (currPlayer.getName() != tonatiuhSun.getName())) {
					System.out.println("tonatiuh was attacked by python");
					gameBoardAttack(territories.get(27), territories.get(40));
					pizzaplanetAttacking = false;
					attackPhase = true;
				}

				if ((pizzaplanetFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					pizzaplanetFortify = false;
				}
				if ((brooklynFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					brooklynFortify = false;
				}
				if ((amunFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					amunFortify = false;
				}
				if ((horusFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
				}
				if ((apolloFortify == true) && (currPlayer.getName() == tonatiuhSun.getName())) {
					territories.get(40).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					apolloFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == tonatiuhSun.getName()) {
						System.out.println("fortify from ton!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && amunSun.getName() == currPlayer.getName()) {
						amunUnits += 1;
						territories.get(41).addUnits(1);
						myLabel.setText("" + amunUnits);
						currPlayer.removeArmies(1);
						
						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(amunSun.getName() == currPlayer.getName())){
					amunUnits +=1;
					territories.get(41).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((amunSun.getName() == currPlayer.getName()) && (amunUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						amunAttacking = true;
						attackPhase = false;
					}
				}
				if (apolloAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(35), territories.get(41));
					apolloAttacking = false;
					attackPhase = true;
				}
				if (raAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(36), territories.get(41));
					raAttacking = false;
					attackPhase = true;
				}
				if (heliosAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(37), territories.get(41));
					heliosAttacking = false;
					attackPhase = true;
				}
				if (horusAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(39), territories.get(41));
					horusAttacking = false;
					attackPhase = true;
				}
				if (tonatiuhAttacking == true && (currPlayer.getName() != amunSun.getName())) {
					System.out.println("amun was attacked by python");
					gameBoardAttack(territories.get(40), territories.get(41));
					tonatiuhAttacking = false;
					attackPhase = true;
				}

				if ((tonatiuhFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					tonatiuhFortify = false;
				}
				if ((horusFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					horusFortify = false;
				}
				if ((heliosFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					heliosFortify = false;
				}
				if ((raFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					raFortify = false;
				}
				if ((apolloFortify == true) && (currPlayer.getName() == amunSun.getName())) {
					territories.get(41).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					apolloFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == amunSun.getName()) {
						System.out.println("fortify from amun!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && rawrvilleDino.getName() == currPlayer.getName()) {
						rawrUnits += 1;
						territories.get(7).addUnits(1);
						myLabel.setText("" + rawrUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(rawrvilleDino.getName() == currPlayer.getName())){
					rawrUnits +=1;
					territories.get(7).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((rawrvilleDino.getName() == currPlayer.getName()) && (rawrUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						rawrvilleAttacking = true;
						attackPhase = false;
					}
				}
				if (laieggesAttacking == true && (currPlayer.getName() != rawrvilleDino.getName())) {
					System.out.println("rawr was attacked by python");
					gameBoardAttack(territories.get(8), territories.get(7));
					laieggesAttacking = false;
					attackPhase = true;
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != rawrvilleDino.getName())) {
					System.out.println("rawr was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(7));
					dactilitoAttacking = false;
					attackPhase = true;
				}

				if ((dactilitoFortify == true) && (currPlayer.getName() == rawrvilleDino.getName())) {
					territories.get(7).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
				}
				if ((laieggesFortify == true) && (currPlayer.getName() == rawrvilleDino.getName())) {
					territories.get(7).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					laieggesFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == rawrvilleDino.getName()) {
						System.out.println("fortify from rawr!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && laieggesDino.getName() == currPlayer.getName()) {
						eggUnits += 1;
						territories.get(8).addUnits(1);
						myLabel.setText("" + eggUnits);
						currPlayer.removeArmies(1);
						
						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(laieggesDino.getName() == currPlayer.getName())){
					eggUnits +=1;
					territories.get(8).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((laieggesDino.getName() == currPlayer.getName()) && (eggUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						laieggesAttacking = true;
						attackPhase = false;
					}
				}
				if (rawrvilleAttacking == true && (currPlayer.getName() != laieggesDino.getName())) {
					System.out.println("laiegges was attacked by python");
					gameBoardAttack(territories.get(7), territories.get(8));
					rawrvilleAttacking = false;
					attackPhase = true;
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != laieggesDino.getName())) {
					System.out.println("laiegges was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(8));
					dactilitoAttacking = false;
					attackPhase = true;
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != laieggesDino.getName())) {
					System.out.println("laiegges was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(8));
					dirtydanAttacking = false;
					attackPhase = true;
				}
				if (crescentcapitalAttacking == true && (currPlayer.getName() != laieggesDino.getName())) {
					System.out.println("laiegges was attacked by python");
					gameBoardAttack(territories.get(34), territories.get(8));
					crescentcapitalAttacking = false;
					attackPhase = true;
				}

				if ((crescentcapitalFortify == true) && (currPlayer.getName() == laieggesDino.getName())) {
					territories.get(8).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					crescentcapitalFortify = false;
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == laieggesDino.getName())) {
					territories.get(8).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
				}
				if ((dactilitoFortify == true) && (currPlayer.getName() == laieggesDino.getName())) {
					territories.get(8).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
				}
				if ((rawrFortify == true) && (currPlayer.getName() == laieggesDino.getName())) {
					territories.get(8).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rawrFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == laieggesDino.getName()) {
						System.out.println("fortify from laieeges!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && dactilitoDino.getName() == currPlayer.getName()) {
						dacUnits += 1;
						territories.get(9).addUnits(1);
						myLabel.setText("" + dacUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(dactilitoDino.getName() == currPlayer.getName())){
					dacUnits +=1;
					territories.get(9).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((dactilitoDino.getName() == currPlayer.getName()) && (dacUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						dactilitoAttacking = true;
						attackPhase = false;
					}
				}
				if (rawrvilleAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(7), territories.get(9));
					rawrvilleAttacking = false;
					attackPhase = true;
				}
				if (laieggesAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(8), territories.get(9));
					laieggesAttacking = false;
					attackPhase = true;
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(9));
					dirtydanAttacking = false;
					attackPhase = true;
				}
				if (blackbeardAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(11), territories.get(9));
					blackbeardAttacking = false;
					attackPhase = true;
				}
				if (toystoryAttacking == true && (currPlayer.getName() != dactilitoDino.getName())) {
					System.out.println("dactilito was attacked by python");
					gameBoardAttack(territories.get(13), territories.get(9));
					toystoryAttacking = false;
					attackPhase = true;
				}
				if ((toystoryFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					toystoryFortify = false;
				}
				if ((blackbeardFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackbeardFortify = false;
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
				}
				if ((rawrFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rawrFortify = false;
				}
				if ((laieggesFortify == true) && (currPlayer.getName() == dactilitoDino.getName())) {
					territories.get(9).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					laieggesFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == dactilitoDino.getName()) {
						System.out.println("fortify from dac!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && dirtydanDino.getName() == currPlayer.getName()) {
						danUnits += 1;
						territories.get(10).addUnits(1);
						myLabel.setText("" + danUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(dirtydanDino.getName() == currPlayer.getName())){
					danUnits +=1;
					territories.get(10).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((dirtydanDino.getName() == currPlayer.getName()) && (danUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						dirtydanAttacking = true;
						attackPhase = false;
					}
				}
				if (laieggesAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(8), territories.get(10));
					laieggesAttacking = false;
					attackPhase = true;
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(10));
					dactilitoAttacking = false;
					attackPhase = true;
				}
				if (blackbeardAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(11), territories.get(10));
					blackbeardAttacking = false;
					attackPhase = true;
				}
				if (monisaurusAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(12), territories.get(10));
					monisaurusAttacking = false;
					attackPhase = true;
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(10));
					newlandofzachAttacking = false;
					attackPhase = true;
				}
				if (bloobawlAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(33), territories.get(10));
					bloobawlAttacking = false;
					attackPhase = true;
				}
				if (crescentcapitalAttacking == true && (currPlayer.getName() != dirtydanDino.getName())) {
					System.out.println("dirty dan was attacked by python");
					gameBoardAttack(territories.get(34), territories.get(10));
					crescentcapitalAttacking = false;
					attackPhase = true;
				}

				if ((crescentcapitalFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					crescentcapitalFortify = false;
				}
				if ((newlandofzachFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
				}
				if ((bloobawlFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					bloobawlFortify = false;
				}
				if ((monisaurusFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					monisaurusFortify = false;
				}
				if ((blackbeardFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackbeardFortify = false;
				}
				if ((dactilitoFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
				}
				if ((laieggesFortify == true) && (currPlayer.getName() == dirtydanDino.getName())) {
					territories.get(10).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					laieggesFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == dirtydanDino.getName()) {
						System.out.println("fortify from dirty!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && blackbeardDino.getName() == currPlayer.getName()) {
						bbUnits += 1;
						territories.get(11).addUnits(1);
						myLabel.setText("" + bbUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(blackbeardDino.getName() == currPlayer.getName())){
					bbUnits +=1;
					territories.get(11).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((blackbeardDino.getName() == currPlayer.getName()) && (bbUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						blackbeardAttacking = true;
						attackPhase = false;
					}
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != blackbeardDino.getName())) {
					System.out.println("blackbeard was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(11));
					dactilitoAttacking = false;
					attackPhase = true;
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != blackbeardDino.getName())) {
					System.out.println("blackbeard was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(11));
					dirtydanAttacking = false;
					attackPhase = true;
				}
				if (monisaurusAttacking == true && (currPlayer.getName() != blackbeardDino.getName())) {
					System.out.println("blackbeard was attacked by python");
					gameBoardAttack(territories.get(12), territories.get(11));
					monisaurusAttacking = false;
					attackPhase = true;
				}
				if (toystoryAttacking == true && (currPlayer.getName() != blackbeardDino.getName())) {
					System.out.println("blackbeard was attacked by python");
					gameBoardAttack(territories.get(13), territories.get(11));
					toystoryAttacking = false;
					attackPhase = true;
				}

				if ((toystoryFortify == true) && (currPlayer.getName() == blackbeardDino.getName())) {
					territories.get(11).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					toystoryFortify = false;
				}
				if ((monisaurusFortify == true) && (currPlayer.getName() == blackbeardDino.getName())) {
					territories.get(11).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					monisaurusFortify = false;
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == blackbeardDino.getName())) {
					territories.get(11).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
				}
				if ((dactilitoFortify == true) && (currPlayer.getName() == blackbeardDino.getName())) {
					territories.get(11).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == blackbeardDino.getName()) {
						System.out.println("fortify from black!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && monisaurusDino.getName() == currPlayer.getName()) {
						moniUnits += 1;
						territories.get(12).addUnits(1);
						myLabel.setText("" + moniUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(monisaurusDino.getName() == currPlayer.getName())){
					moniUnits +=1;
					territories.get(12).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((monisaurusDino.getName() == currPlayer.getName()) && (moniUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						monisaurusAttacking = true;
						attackPhase = false;
					}
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != monisaurusDino.getName())) {
					System.out.println("moni was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(12));
					dirtydanAttacking = false;
					attackPhase = true;
				}
				if (blackjackAttacking == true && (currPlayer.getName() != monisaurusDino.getName())) {
					System.out.println("moni was attacked by python");
					gameBoardAttack(territories.get(24), territories.get(12));
					blackjackAttacking = false;
					attackPhase = true;
				}
				if (toystoryAttacking == true && (currPlayer.getName() != monisaurusDino.getName())) {
					System.out.println("moni was attacked by python");
					gameBoardAttack(territories.get(13), territories.get(12));
					toystoryAttacking = false;
					attackPhase = true;
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != monisaurusDino.getName())) {
					System.out.println("moni was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(12));
					newlandofzachAttacking = false;
					attackPhase = true;
				}

				if ((newlandofzachFortify == true) && (currPlayer.getName() == monisaurusDino.getName())) {
					territories.get(12).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
				}
				if ((toystoryFortify == true) && (currPlayer.getName() == monisaurusDino.getName())) {
					territories.get(12).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					toystoryFortify = false;
				}
				if ((blackjackFortify == true) && (currPlayer.getName() == monisaurusDino.getName())) {
					territories.get(12).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackjackFortify = false;
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == monisaurusDino.getName())) {
					territories.get(12).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == monisaurusDino.getName()) {
						System.out.println("fortify from moni!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && toystoryDino.getName() == currPlayer.getName()) {
						tsUnits += 1;
						territories.get(13).addUnits(1);
						myLabel.setText("" + tsUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(toystoryDino.getName() == currPlayer.getName())){
					tsUnits +=1;
					territories.get(13).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((toystoryDino.getName() == currPlayer.getName()) && (tsUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						toystoryAttacking = true;
						attackPhase = false;
					}
				}
				if (dactilitoAttacking == true && (currPlayer.getName() != toystoryDino.getName())) {
					System.out.println("toystory was attacked by python");
					gameBoardAttack(territories.get(9), territories.get(13));
					dactilitoAttacking = false;
					attackPhase = true;
				}
				if (blackbeardAttacking == true && (currPlayer.getName() != toystoryDino.getName())) {
					System.out.println("toystory was attacked by python");
					gameBoardAttack(territories.get(11), territories.get(13));
					blackbeardAttacking = false;
					attackPhase = true;
				}
				if (monisaurusAttacking == true && (currPlayer.getName() != toystoryDino.getName())) {
					System.out.println("toystory was attacked by python");
					gameBoardAttack(territories.get(12), territories.get(13));
					monisaurusAttacking = false;
					attackPhase = true;
				}

				if ((monisaurusFortify == true) && (currPlayer.getName() == toystoryDino.getName())) {
					territories.get(13).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					monisaurusFortify = false;
				}
				if ((blackbeardFortify == true) && (currPlayer.getName() == toystoryDino.getName())) {
					territories.get(13).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					blackbeardFortify = false;
				}
				if ((dactilitoFortify == true) && (currPlayer.getName() == toystoryDino.getName())) {
					territories.get(13).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dactilitoFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == toystoryDino.getName()) {
						System.out.println("fortify from toystroy!!");
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

					if (currPlayer.getNumOfArmies() >= 1 && scraptopiaCresent.getName() == currPlayer.getName()) {
						scrapUnits += 1;
						territories.get(28).addUnits(1);
						myLabel.setText("" + scrapUnits);

						currPlayer.removeArmies(1);
						

						nextPlayer();

					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(scraptopiaCresent.getName() == currPlayer.getName())){
					scrapUnits +=1;
					territories.get(28).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((scraptopiaCresent.getName() == currPlayer.getName()) && (scrapUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						scraptopiaAttacking = true;
						attackPhase = false;
					}
				}
				if (landofzachAttacking == true && (currPlayer.getName() != scraptopiaCresent.getName())) {
					System.out.println("scraptopia was attacked by python");
					gameBoardAttack(territories.get(29), territories.get(28));
					scraptopiaAttacking = false;
					attackPhase = true;
				}
				if (millerAttacking == true && (currPlayer.getName() != scraptopiaCresent.getName())) {
					System.out.println("scraptopia was attacked by python");
					gameBoardAttack(territories.get(17), territories.get(28));
					millerAttacking = false;
					attackPhase = true;
				}
				if ((millerFortify == true) && (currPlayer.getName() == scraptopiaCresent.getName())) {
					territories.get(28).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					millerFortify = false;
				}
				if ((landofzachFortify == true) && (currPlayer.getName() == scraptopiaCresent.getName())) {
					territories.get(28).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					landofzachFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == scraptopiaCresent.getName()) {
						System.out.println("fortify from scrap!!");
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

					if (currPlayer.getNumOfArmies() >= 1 && landofzachCresent.getName() == currPlayer.getName()) {
						zachUnits += 1;
						territories.get(29).addUnits(1);
						myLabel.setText("" + zachUnits);
						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(landofzachCresent.getName() == currPlayer.getName())){
					zachUnits +=1;
					territories.get(29).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((landofzachCresent.getName() == currPlayer.getName()) && (zachUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						landofzachAttacking = true;
						attackPhase = false;
					}
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
				}
				if ((newlandofzachFortify == true) && (currPlayer.getName() == landofzachCresent.getName())) {
					territories.get(29).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
				}
				if ((giantFortify == true) && (currPlayer.getName() == landofzachCresent.getName())) {
					territories.get(29).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
				}
				if ((scraptopiaFortify == true) && (currPlayer.getName() == landofzachCresent.getName())) {
					territories.get(29).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					scraptopiaFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == landofzachCresent.getName()) {
						System.out.println("fortify from lozach!!");
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

					if (currPlayer.getNumOfArmies() >= 1 && giantCresent.getName() == currPlayer.getName()) {
						giantUnits += 1;
						territories.get(30).addUnits(1);
						myLabel.setText("" + giantUnits);

						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(giantCresent.getName() == currPlayer.getName())){
					giantUnits +=1;
					territories.get(30).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((giantCresent.getName() == currPlayer.getName()) && (giantUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						giantAttacking = true;
						attackPhase = false;
					}
				}
				if (landofzachAttacking == true && (currPlayer.getName() != giantCresent.getName())) {
					System.out.println("giant was attacked by python");
					gameBoardAttack(territories.get(29), territories.get(30));
					landofzachAttacking = false;
					attackPhase = true;
				}
				if (southscraptopiaAttacking == true && (currPlayer.getName() != giantCresent.getName())) {
					System.out.println("giant was attacked by python");
					gameBoardAttack(territories.get(32), territories.get(30));
					southscraptopiaAttacking = false;
					attackPhase = true;
				}
				if (bloobawlAttacking == true && (currPlayer.getName() != giantCresent.getName())) {
					System.out.println("giant was attacked by python");
					gameBoardAttack(territories.get(33), territories.get(30));
					bloobawlAttacking = false;
					attackPhase = true;
				}
				if (rubyAttacking == true && (currPlayer.getName() != giantCresent.getName())) {
					System.out.println("giant was attacked by python");
					gameBoardAttack(territories.get(4), territories.get(30));
					rubyAttacking = false;
					attackPhase = true;
				}

				if ((rubyFortify == true) && (currPlayer.getName() == giantCresent.getName())) {
					territories.get(30).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					rubyFortify = false;
				}
				if ((bloobawlFortify == true) && (currPlayer.getName() == giantCresent.getName())) {
					territories.get(30).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					bloobawlFortify = false;
				}
				if ((southscraptopiaFortify == true) && (currPlayer.getName() == giantCresent.getName())) {
					territories.get(30).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					southscraptopiaFortify = false;
				}
				if ((landofzachFortify == true) && (currPlayer.getName() == giantCresent.getName())) {
					territories.get(30).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					landofzachFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == giantCresent.getName()) {
						System.out.println("fortify from giant!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && newlandofzachCresent.getName() == currPlayer.getName()) {
						newzachUnits += 1;
						territories.get(31).addUnits(1);
						myLabel.setText("" + newzachUnits);

						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();
				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(newlandofzachCresent.getName() == currPlayer.getName())){
					newzachUnits +=1;
					territories.get(31).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((newlandofzachCresent.getName() == currPlayer.getName()) && (newzachUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						newlandofzachAttacking = true;
						attackPhase = false;
					}
				}
				if (landofzachAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(29), territories.get(31));
					landofzachAttacking = false;
					attackPhase = true;
				}
				if (southscraptopiaAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(32), territories.get(31));
					southscraptopiaAttacking = false;
					attackPhase = true;
				}
				if (bloobawlAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(33), territories.get(31));
					bloobawlAttacking = false;
					attackPhase = true;
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(31));
					dirtydanAttacking = false;
					attackPhase = true;
				}
				if (monisaurusAttacking == true && (currPlayer.getName() != newlandofzachCresent.getName())) {
					System.out.println("new land of zach was attacked by python");
					gameBoardAttack(territories.get(12), territories.get(31));
					monisaurusAttacking = false;
					attackPhase = true;
				}

				if ((monisaurusFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					monisaurusFortify = false;
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
				}
				if ((bloobawlFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					bloobawlFortify = false;
				}
				if ((southscraptopiaFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					southscraptopiaFortify = false;
				}
				if ((landofzachFortify == true) && (currPlayer.getName() == newlandofzachCresent.getName())) {
					territories.get(31).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					landofzachFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == newlandofzachCresent.getName()) {
						System.out.println("fortify from newland!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && southscraptopiaCresent.getName() == currPlayer.getName()) {
						southUnits += 1;
						territories.get(32).addUnits(1);
						myLabel.setText("" + southUnits);

						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(southscraptopiaCresent.getName() == currPlayer.getName())){
					southUnits +=1;
					territories.get(32).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((southscraptopiaCresent.getName() == currPlayer.getName()) && (southUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						southscraptopiaAttacking = true;
						attackPhase = false;
					}
				}
				if (giantAttacking == true && (currPlayer.getName() != southscraptopiaCresent.getName())) {
					System.out.println("southscraptopia was attacked by python");
					gameBoardAttack(territories.get(30), territories.get(32));
					giantAttacking = false;
					attackPhase = true;
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != southscraptopiaCresent.getName())) {
					System.out.println("southscraptopia was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(32));
					newlandofzachAttacking = false;
					attackPhase = true;
				}

				if ((newlandofzachFortify == true) && (currPlayer.getName() == southscraptopiaCresent.getName())) {
					territories.get(32).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
				}
				if ((giantFortify == true) && (currPlayer.getName() == southscraptopiaCresent.getName())) {
					territories.get(32).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == southscraptopiaCresent.getName()) {
						System.out.println("fortify from southscrap!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && bloobawlCresent.getName() == currPlayer.getName()) {
						blooUnits += 1;
						territories.get(33).addUnits(1);
						myLabel.setText("" + blooUnits);

						currPlayer.removeArmies(1);
						

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(bloobawlCresent.getName() == currPlayer.getName())){
					blooUnits +=1;
					territories.get(33).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((bloobawlCresent.getName() == currPlayer.getName()) && (blooUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						bloobawlAttacking = true;
						attackPhase = false;
					}
				}
				if (giantAttacking == true && (currPlayer.getName() != bloobawlCresent.getName())) {
					System.out.println("bloobawl was attacked by python");
					gameBoardAttack(territories.get(30), territories.get(33));
					giantAttacking = false;
					attackPhase = true;
				}
				if (newlandofzachAttacking == true && (currPlayer.getName() != bloobawlCresent.getName())) {
					System.out.println("bloobawl was attacked by python");
					gameBoardAttack(territories.get(31), territories.get(33));
					newlandofzachAttacking = false;
					attackPhase = true;
				}
				if (crescentcapitalAttacking == true && (currPlayer.getName() != bloobawlCresent.getName())) {
					System.out.println("bloobawl was attacked by python");
					gameBoardAttack(territories.get(34), territories.get(33));
					crescentcapitalAttacking = false;
					attackPhase = true;
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != bloobawlCresent.getName())) {
					System.out.println("bloobawl was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(33));
					dirtydanAttacking = false;
					attackPhase = true;
				}
				if ((dirtydanFortify == true) && (currPlayer.getName() == bloobawlCresent.getName())) {
					territories.get(33).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
				}
				if ((crescentcapitalFortify == true) && (currPlayer.getName() == bloobawlCresent.getName())) {
					territories.get(33).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					crescentcapitalFortify = false;
				}
				if ((newlandofzachFortify == true) && (currPlayer.getName() == bloobawlCresent.getName())) {
					territories.get(33).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					newlandofzachFortify = false;
				}
				if ((giantFortify == true) && (currPlayer.getName() == bloobawlCresent.getName())) {
					territories.get(33).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					giantFortify = false;
				}
				if (fortifyPhase == true) {
					if (currPlayer.getName() == bloobawlCresent.getName()) {
						System.out.println("fortify from bloo!!");
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
					if (currPlayer.getNumOfArmies() >= 1 && cresentcaptitalCresent.getName() == currPlayer.getName()) {
						capUnits += 1;
						territories.get(34).addUnits(1);
						myLabel.setText("" + capUnits);

						currPlayer.removeArmies(1);

						nextPlayer();

						// ADD SETTERS AND GETTERS FOR BUTTON COLORS (OWNERS)
					}
					checkIfReinforcementPhaseIsOver();

				}
				if((reinforcementPhase == false) && (currPlayer.getNumOfArmies() > 0) &&(cresentcaptitalCresent.getName() == currPlayer.getName())){
					capUnits +=1;
					territories.get(34).addUnits(1);
					updateLabels();
					currPlayer.removeArmies(1);			
				}
				if (attackPhase == true) {
					if ((cresentcaptitalCresent.getName() == currPlayer.getName()) && (capUnits >= 2)) {
						System.out.println("ATTACK PHASE");
						playerCount.setText("Choose Territory to attack");
						crescentcapitalAttacking = true;
						attackPhase = false;
					}
				}
				if (bloobawlAttacking == true && (currPlayer.getName() != cresentcaptitalCresent.getName())) {
					System.out.println("crescent capital was attacked by python");
					gameBoardAttack(territories.get(33), territories.get(34));
					bloobawlAttacking = false;
					attackPhase = true;
				}
				if (laieggesAttacking == true && (currPlayer.getName() != cresentcaptitalCresent.getName())) {
					System.out.println("crescent capital was attacked by python");
					gameBoardAttack(territories.get(8), territories.get(34));
					laieggesAttacking = false;
					attackPhase = true;
				}
				if (dirtydanAttacking == true && (currPlayer.getName() != cresentcaptitalCresent.getName())) {
					System.out.println("crescent capital was attacked by python");
					gameBoardAttack(territories.get(10), territories.get(34));
					dirtydanAttacking = false;
					attackPhase = true;
				}

				if ((dirtydanFortify == true) && (currPlayer.getName() == cresentcaptitalCresent.getName())) {
					territories.get(34).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					dirtydanFortify = false;
				}
				if ((laieggesFortify == true) && (currPlayer.getName() == cresentcaptitalCresent.getName())) {
					territories.get(34).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					laieggesFortify = false;
				}
				if ((bloobawlFortify == true) && (currPlayer.getName() == cresentcaptitalCresent.getName())) {
					territories.get(34).addUnits(unitsFortified);
					updateLabels();
					playerCount.setText("Your turn has ended!");
					bloobawlFortify = false;
				}

				if (fortifyPhase == true) {
					if (currPlayer.getName() == cresentcaptitalCresent.getName()) {
						System.out.println("fortify from scrap!!");
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

	public void nextPlayer() {

		currPlayer = newGame.nextPlayer();

		moveTurnLabel();
		newGame.addReinforcements();
		System.out.println("Current Player: " + currPlayer.getName());
		System.out.println("AI?: " + currPlayer.isAI());

		if (currPlayer.isAI()) {
			System.out.println("Detecting AI");
			if (!reinforcementPhase) {
				System.out.println("Not in reinforcement phase");
				newGame.turnInCard();
				AITurn(0);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateLabels();

				AITurn(1);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateLabels();

				AITurn(2);
				updateLabels();
			} else {
				System.out.println("In reinforcement phase");
				AITurn(0);
				updateLabels();
			}
			nextPlayer();
		}

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
		if (attackingTerr.getUnits() >= 2) {
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
				JOptionPane.showConfirmDialog(null, "Sorry, you do not have enough armies to attack",
						"Not Strong Enough", 1);
			}
		}
	}

	private void updateButtonColors() {
		if (startWindow.getNumberOfPlayer() == 6) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
					wilmaWildcat.setIcon(yellow);
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(purple);
					wilmaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(purple);
					zonaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(purple);
					wilberWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(purple);
					richWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(purple);
					millerWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(purple);
					mckaleWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(purple);
					scoobyWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(purple);
					javaLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(purple);
					pythonLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(purple);
					cLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(purple);
					sqlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(purple);
					rubyLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(purple);
					perlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(purple);
					gitLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(purple);
					papajohnsPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(purple);
					dominosPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(purple);
					pizzahutPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(purple);
					blackjackPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(purple);
					hungryhowiesPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(purple);
					brooklynPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(purple);
					pizzaplanetPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(purple);
					rawrvilleDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(purple);
					laieggesDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(purple);
					dactilitoDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(purple);
					dirtydanDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(purple);
					blackbeardDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(purple);
					monisaurusDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(purple);
					toystoryDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(purple);
					scraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(purple);
					landofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(purple);
					giantCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(purple);
					newlandofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(purple);
					southscraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(purple);
					bloobawlCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(purple);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(purple);
					apolloSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(purple);
					raSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(purple);
					heliosSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(purple);
					intiSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(purple);
					horusSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(purple);
					tonatiuhSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(purple);
					amunSun.setName(newGame.getPlayerAt(4).getName());
				}
			}

			for (Territory d : player6.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(blue);
					wilmaWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(blue);
					zonaWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(blue);
					wilberWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(blue);
					richWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(blue);
					millerWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(blue);
					mckaleWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(blue);
					scoobyWildcat.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(blue);
					javaLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(blue);
					pythonLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(blue);
					cLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(blue);
					sqlLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(blue);
					rubyLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(blue);
					perlLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(blue);
					gitLanguage.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(blue);
					papajohnsPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(blue);
					dominosPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(blue);
					pizzahutPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(blue);
					blackjackPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(blue);
					hungryhowiesPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(blue);
					brooklynPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(blue);
					pizzaplanetPizza.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(blue);
					rawrvilleDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(blue);
					laieggesDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(blue);
					dactilitoDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(blue);
					dirtydanDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(blue);
					blackbeardDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(blue);
					monisaurusDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(blue);
					toystoryDino.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(blue);
					scraptopiaCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(blue);
					landofzachCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(blue);
					giantCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(blue);
					newlandofzachCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(blue);
					southscraptopiaCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(blue);
					bloobawlCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(blue);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(blue);
					apolloSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(blue);
					raSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(blue);
					heliosSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(blue);
					intiSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(blue);
					horusSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(blue);
					tonatiuhSun.setName(newGame.getPlayerAt(5).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(blue);
					amunSun.setName(newGame.getPlayerAt(5).getName());
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 5) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
					wilmaWildcat.setIcon(yellow);
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}

			for (Territory d : player5.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(purple);
					wilmaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(purple);
					zonaWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(purple);
					wilberWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(purple);
					richWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(purple);
					millerWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(purple);
					mckaleWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(purple);
					scoobyWildcat.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(purple);
					javaLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(purple);
					pythonLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(purple);
					cLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(purple);
					sqlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(purple);
					rubyLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(purple);
					perlLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(purple);
					gitLanguage.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(purple);
					papajohnsPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(purple);
					dominosPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(purple);
					pizzahutPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(purple);
					blackjackPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(purple);
					hungryhowiesPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(purple);
					brooklynPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(purple);
					pizzaplanetPizza.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(purple);
					rawrvilleDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(purple);
					laieggesDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(purple);
					dactilitoDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(purple);
					dirtydanDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(purple);
					blackbeardDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(purple);
					monisaurusDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(purple);
					toystoryDino.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(purple);
					scraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(purple);
					landofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(purple);
					giantCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(purple);
					newlandofzachCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(purple);
					southscraptopiaCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(purple);
					bloobawlCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(purple);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(purple);
					apolloSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(purple);
					raSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(purple);
					heliosSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(purple);
					intiSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(purple);
					horusSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(purple);
					tonatiuhSun.setName(newGame.getPlayerAt(4).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(purple);
					amunSun.setName(newGame.getPlayerAt(4).getName());
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 4) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
					wilmaWildcat.setIcon(yellow);
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(orange);
					amunSun.setName(newGame.getPlayerAt(2).getName());
				}
			}

			for (Territory d : player4.getTerritories()) {

				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(red);
					wilmaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(red);
					zonaWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(red);
					wilberWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(red);
					richWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(red);
					millerWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(red);
					mckaleWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(red);
					scoobyWildcat.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(red);
					javaLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(red);
					pythonLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(red);
					cLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(red);
					sqlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(red);
					rubyLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(red);
					perlLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(red);
					gitLanguage.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(red);
					papajohnsPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(red);
					dominosPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(red);
					pizzahutPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(red);
					blackjackPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(red);
					hungryhowiesPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(red);
					brooklynPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(red);
					pizzaplanetPizza.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(red);
					rawrvilleDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(red);
					laieggesDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(red);
					dactilitoDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(red);
					dirtydanDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(red);
					blackbeardDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(red);
					monisaurusDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(red);
					toystoryDino.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(red);
					scraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(red);
					landofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(red);
					giantCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(red);
					newlandofzachCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(red);
					southscraptopiaCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(red);
					bloobawlCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(red);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(red);
					apolloSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(red);
					raSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(red);
					heliosSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(red);
					intiSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(red);
					horusSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(red);
					tonatiuhSun.setName(newGame.getPlayerAt(3).getName());
				}
				if (d.getName() == "Amun") {
					amunSun.setIcon(red);
					amunSun.setName(newGame.getPlayerAt(3).getName());
				}
			}
		}
		if (startWindow.getNumberOfPlayer() == 3) {
			for (Territory d : player1.getTerritories()) {
				if (d.getName() == "Wilma") {
					wilmaWildcat.setName(newGame.getPlayerAt(0).getName());
					wilmaWildcat.setIcon(yellow);
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(yellow);
					zonaWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(yellow);
					wilberWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(yellow);
					richWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(yellow);
					millerWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(yellow);
					mckaleWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(yellow);
					scoobyWildcat.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(yellow);
					javaLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(yellow);
					pythonLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(yellow);
					cLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(yellow);
					sqlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(yellow);
					rubyLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(yellow);
					perlLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(yellow);
					gitLanguage.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(yellow);
					papajohnsPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(yellow);
					dominosPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(yellow);
					pizzahutPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(yellow);
					blackjackPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(yellow);
					hungryhowiesPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(yellow);
					brooklynPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(yellow);
					pizzaplanetPizza.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(yellow);
					rawrvilleDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(yellow);
					laieggesDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(yellow);
					dactilitoDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(yellow);
					dirtydanDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(yellow);
					blackbeardDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(yellow);
					monisaurusDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(yellow);
					toystoryDino.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(yellow);
					scraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(yellow);
					landofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(yellow);
					giantCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(yellow);
					newlandofzachCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(yellow);
					southscraptopiaCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(yellow);
					bloobawlCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(yellow);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(yellow);
					apolloSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(yellow);
					raSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(yellow);
					heliosSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(yellow);
					intiSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(yellow);
					horusSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(yellow);
					tonatiuhSun.setName(newGame.getPlayerAt(0).getName());
				}
				if (d.getName() == "Amun") {
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
				if (d.getName() == "Wilma") {
					wilmaWildcat.setIcon(orange);
					wilmaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Zona") {
					zonaWildcat.setIcon(orange);
					zonaWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Wilber") {
					wilberWildcat.setIcon(orange);
					wilberWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rich") {
					richWildcat.setIcon(orange);
					richWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Miller") {
					millerWildcat.setIcon(orange);
					millerWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "McKale") {
					mckaleWildcat.setIcon(orange);
					mckaleWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scooby") {
					scoobyWildcat.setIcon(orange);
					scoobyWildcat.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Java") {
					javaLanguage.setIcon(orange);
					javaLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Python") {
					pythonLanguage.setIcon(orange);
					pythonLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "C") {
					cLanguage.setIcon(orange);
					cLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "SQL") {
					sqlLanguage.setIcon(orange);
					sqlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ruby") {
					rubyLanguage.setIcon(orange);
					rubyLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Perl") {
					perlLanguage.setIcon(orange);
					perlLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Git") {
					gitLanguage.setIcon(orange);
					gitLanguage.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Papa Johns") {
					papajohnsPizza.setIcon(orange);
					papajohnsPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dominos") {
					dominosPizza.setIcon(orange);
					dominosPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "PizzaHut") {
					pizzahutPizza.setIcon(orange);
					pizzahutPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Black Jack") {
					blackjackPizza.setIcon(orange);
					blackjackPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Hungry Howie's") {
					hungryhowiesPizza.setIcon(orange);
					hungryhowiesPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Brooklyn's") {
					brooklynPizza.setIcon(orange);
					brooklynPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Pizza Planet") {
					pizzaplanetPizza.setIcon(orange);
					pizzaplanetPizza.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Rawrville") {
					rawrvilleDino.setIcon(orange);
					rawrvilleDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Laiegges") {
					laieggesDino.setIcon(orange);
					laieggesDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dactilito") {
					dactilitoDino.setIcon(orange);
					dactilitoDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Dirtydan") {
					dirtydanDino.setIcon(orange);
					dirtydanDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "BlackBeard") {
					blackbeardDino.setIcon(orange);
					blackbeardDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Monisaurus") {
					monisaurusDino.setIcon(orange);
					monisaurusDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "ToyStory") {
					toystoryDino.setIcon(orange);
					toystoryDino.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Scraptopia") {
					scraptopiaCresent.setIcon(orange);
					scraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Land of Zach") {
					landofzachCresent.setIcon(orange);
					landofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Giant") {
					giantCresent.setIcon(orange);
					giantCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "New Land of Zach") {
					newlandofzachCresent.setIcon(orange);
					newlandofzachCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "South Scraptopia") {
					southscraptopiaCresent.setIcon(orange);
					southscraptopiaCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Bloo Bawl") {
					bloobawlCresent.setIcon(orange);
					bloobawlCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Cresent Capital") {
					cresentcaptitalCresent.setIcon(orange);
					cresentcaptitalCresent.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Apollo") {
					apolloSun.setIcon(orange);
					apolloSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Ra") {
					raSun.setIcon(orange);
					raSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Helios") {
					heliosSun.setIcon(orange);
					heliosSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Inti") {
					intiSun.setIcon(orange);
					intiSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Horus") {
					horusSun.setIcon(orange);
					horusSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Tonatiuh") {
					tonatiuhSun.setIcon(orange);
					tonatiuhSun.setName(newGame.getPlayerAt(2).getName());
				}
				if (d.getName() == "Amun") {
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
			reinforcementPhase = false;
			attackPhase = true;
			gameStatus.setText("Attack");
			if (newGame.getNumOfPlayers() == 6) {
				playerCount.setText("Select Territory to attack from");
				playerCount2.setText("");
				playerCount3.setText("");
				playerCount4.setText("");
				playerCount5.setText("");
				playerCount6.setText("");
			} else if (newGame.getNumOfPlayers() == 5) {
				playerCount.setText("Select Territory to attack from");
				playerCount2.setText("");
				playerCount3.setText("");
				playerCount4.setText("");
				playerCount5.setText("");

			} else if (newGame.getNumOfPlayers() == 4) {
				playerCount.setText("Select Territory to attack from");
				playerCount2.setText("");
				playerCount3.setText("");
				playerCount4.setText("");

			} else if (newGame.getNumOfPlayers() == 3) {
				playerCount.setText("Select Territory to attack from");
				playerCount2.setText("");
				playerCount3.setText("");

			} else if (newGame.getNumOfPlayers() == 2) {
				playerCount.setText("Select Territory to attack from");
				playerCount2.setText("");

			}
		}

	}

}