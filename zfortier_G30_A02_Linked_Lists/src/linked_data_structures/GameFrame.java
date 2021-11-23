package linked_data_structures;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class GameFrame extends JFrame implements ActionListener{

	Game game = new Game();
	GetWords words = new GetWords();
	ScoreBoard sb = new ScoreBoard();
	
	
	private JPanel contentPane;
	private JMenu GameMenu;
	private JTextArea testArea;
	private JMenuItem startGameMenuItem;
	private JTextField textLetter;
	private JLabel lblAddLetter;
	private JButton btnGuess;
	ImageIcon img0 = new ImageIcon("images/stick0.png");
	ImageIcon img1 = new ImageIcon("images/stick1.png");
	ImageIcon img2 = new ImageIcon("images/stick2.png");
	ImageIcon img3 = new ImageIcon("images/stick3.png");
	ImageIcon img4 = new ImageIcon("images/stick4.png");
	ImageIcon img5 = new ImageIcon("images/stick5.png");
	ImageIcon img6 = new ImageIcon("images/stick6.png");
	private JLabel imgLabel;
	private JMenuItem hintMenuItem;
	private JMenuItem quitMenuItem;
	private JMenuItem rulesMenuItem;
	private JMenuItem scoreboardMenuItem;
	private JTextField usernameTextField;
	private JButton btnLogin;
	private JLabel playerLabel;
	private JLabel addPlayerLabel;
	private JTextField addPlayerTextField;
	private JButton btnAddPlayer;
	private JMenuItem MakeUserMenuItem;
	private JTextArea scoreBoardTextArea;
	private JLabel lblScoreBoard;
	private JLabel lblinfo;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public GameFrame() {
		setForeground(Color.GRAY);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 505);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.PINK);
		setJMenuBar(menuBar);
		
		GameMenu = new JMenu("Game Menu");
		GameMenu.setBorder(new MatteBorder(0, 0, 0, 5, (Color) new Color(255, 255, 255)));
		GameMenu.setBackground(new Color(255, 192, 203));
		menuBar.add(GameMenu);
		
		startGameMenuItem = new JMenuItem("Start Game");
		GameMenu.add(startGameMenuItem);
		
		MakeUserMenuItem = new JMenuItem("Make Account");
		GameMenu.add(MakeUserMenuItem);
		
		hintMenuItem = new JMenuItem("Get Hint");
		GameMenu.add(hintMenuItem);
		
		scoreboardMenuItem = new JMenuItem("Scoreboard(Test)");
		GameMenu.add(scoreboardMenuItem);
		
		
		rulesMenuItem = new JMenuItem("Rules");
		GameMenu.add(rulesMenuItem);
		
		quitMenuItem = new JMenuItem("Quit Game");
		GameMenu.add(quitMenuItem);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		testArea = new JTextArea();
		testArea.setEditable(false);
		testArea.setForeground(Color.PINK);
		testArea.setFont(new Font("SansSerif", Font.BOLD, 13));
		testArea.setBounds(10, 79, 260, 132);
		contentPane.add(testArea);
		testArea.setColumns(10);
		testArea.setText("");
		testArea.append("To start a new game Click [Game Menu] \nand then Click [Start Game]");
		testArea.append("\n\n Good Luck and Have Fun!");
		
		textLetter = new JTextField();
		textLetter.setBounds(165, 222, 115, 32);
		contentPane.add(textLetter);
		textLetter.setColumns(10);
		
		lblAddLetter = new JLabel("Enter Your Letter :");
		lblAddLetter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddLetter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddLetter.setLabelFor(textLetter);
		lblAddLetter.setForeground(new Color(255, 250, 250));
		lblAddLetter.setBounds(10, 220, 144, 32);
		contentPane.add(lblAddLetter);
		
		btnGuess = new JButton("Guess");
		btnGuess.setBackground(Color.PINK);
		btnGuess.setBounds(290, 227, 82, 23);
		contentPane.add(btnGuess);
		
		imgLabel = new JLabel("");
		imgLabel.setBackground(Color.LIGHT_GRAY);
		imgLabel.setBounds(289, 55, 145, 156);
		contentPane.add(imgLabel);
		
		playerLabel = new JLabel("User Name: ");
		playerLabel.setForeground(Color.WHITE);
		playerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		playerLabel.setBounds(10, 11, 79, 23);
		contentPane.add(playerLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(99, 6, 192, 32);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.PINK);
		btnLogin.setBounds(321, 11, 89, 23);
		contentPane.add(btnLogin);
		
		addPlayerLabel = new JLabel("User Name: ");
		addPlayerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		addPlayerLabel.setForeground(Color.WHITE);
		addPlayerLabel.setBounds(10, 45, 79, 24);
		contentPane.add(addPlayerLabel);
		
		addPlayerTextField = new JTextField();
		addPlayerTextField.setBounds(99, 45, 121, 26);
		contentPane.add(addPlayerTextField);
		addPlayerTextField.setColumns(10);
		
		btnAddPlayer = new JButton("GO");
		btnAddPlayer.setBackground(Color.PINK);
		btnAddPlayer.setBounds(230, 49, 54, 23);
		contentPane.add(btnAddPlayer);
		
		btnGuess.addActionListener(this);
		btnLogin.addActionListener(this);
		btnAddPlayer.addActionListener(this);
		MakeUserMenuItem.addActionListener(this);
		startGameMenuItem.addActionListener(this);
		hintMenuItem.addActionListener(this);
		quitMenuItem.addActionListener(this);
		rulesMenuItem.addActionListener(this);
		scoreboardMenuItem.addActionListener(this); 
		
		
		btnGuess.setVisible(false);
		textLetter.setVisible(false);
		lblAddLetter.setVisible(false);
		
		btnLogin.setVisible(false);
		playerLabel.setVisible(false);
		usernameTextField.setVisible(false);
		
		btnAddPlayer.setVisible(false);
		addPlayerLabel.setVisible(false);
		addPlayerTextField.setVisible(false);
		
		imgLabel.setIcon(img6);
		
		scoreBoardTextArea = new JTextArea();
		scoreBoardTextArea.setEditable(false);
		scoreBoardTextArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		scoreBoardTextArea.setForeground(Color.WHITE);
		scoreBoardTextArea.setBorder(new LineBorder(new Color(255, 175, 175)));
		scoreBoardTextArea.setBackground(Color.LIGHT_GRAY);
		//scoreBoardTextArea.setBounds(10, 322, 424, 90);
		//contentPane.add(scoreBoardTextArea);
		JScrollPane scroll = new JScrollPane(scoreBoardTextArea);
		contentPane.add(scroll);
		scroll.setBounds(10, 322, 424, 90);
		
		
		
		
		
		
		lblScoreBoard = new JLabel("ScoreBoard");
		lblScoreBoard.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblScoreBoard.setForeground(Color.WHITE);
		lblScoreBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreBoard.setBounds(141, 290, 165, 32);
		contentPane.add(lblScoreBoard);
		
		lblinfo = new JLabel("Serialization Not working to full extent Make players per run Scorboard Works");
		lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblinfo.setForeground(Color.WHITE);
		lblinfo.setBounds(10, 423, 424, 17);
		contentPane.add(lblinfo);
		
		
		hintMenuItem.setEnabled(false);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == startGameMenuItem) {
			
			btnLogin.setVisible(true);
			playerLabel.setVisible(true);
			usernameTextField.setVisible(true);	
			
//			try {
//				sb.deserializable();
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			
		}
		
		if(e.getSource() == btnLogin) {
			
			
			
			if(usernameTextField.getText().equals("")) {
				
				JOptionPane.showMessageDialog(this, "Please enter a User Name");
				
			}
			
			else if(sb.checkUser(usernameTextField.getText()) == true) {
				
				JOptionPane.showMessageDialog(this, "This user dosent exist please make an account");
				
			}
			
			
			
			else {
		
		game.setPlayerName(sb.findPlayer(usernameTextField.getText()).getName());
		game.setGamesPlayed((sb.findPlayer(usernameTextField.getText()).getGamesPlayed()) + 1);
		game.setGamesWon(sb.findPlayer(usernameTextField.getText()).getGamesWon());
		
			
		hintMenuItem.setEnabled(true);
		startGameMenuItem.setEnabled(false);
		MakeUserMenuItem.setEnabled(false);
			
		btnLogin.setVisible(false);
		playerLabel.setVisible(false);
		usernameTextField.setVisible(false);
		
		btnGuess.setVisible(true);
		textLetter.setVisible(true);
		lblAddLetter.setVisible(true);	
			
		game.resetGuessedLetters();
		game.resetGuesses();
		game.resetFailedGuesses();
		game.resetWordLine();
		game.resetWordLetters();
		
		words.resetWords();
		words.makeList();
		game.setWord(words.pickWord());
		
		testArea.setText("");
		game.makeWordLine();
		game.fillWordLine();
		testArea.append(" " + game.toString(game.wordLine));
		imgLabel.setIcon(img0);
		
		
			}//else
		
		}//------------------startGameMenuItem
		
		else if(e.getSource() == btnGuess) {
			
			if(textLetter.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please enter a letter");
			}
			else {
			
			char guess;
			guess = Character.toLowerCase(textLetter.getText().charAt(0));
			
			if((guess != 'a') && (guess != 'b') && (guess != 'c') && (guess != 'd') && (guess != 'e') && (guess != 'f') && (guess != 'g') && (guess != 'h') && (guess != 'i') && (guess != 'j') && (guess != 'k') && (guess != 'l') && (guess != 'm') && (guess != 'n') && (guess != 'o') && (guess != 'p') && (guess != 'q') && (guess != 'r') && (guess != 's') && (guess != 't') && (guess != 'u') && (guess != 'v') && (guess != 'w') && (guess != 'x') && (guess != 'y') && (guess != 'z')) {
				JOptionPane.showMessageDialog(this, "You can only enter letters");	
			}
			
			else if(game.checkGuessedLetter(guess) == true) {
				JOptionPane.showMessageDialog(this, "You cant enter the same letter 2 times");
			}
			
			else {
			
			game.checkAnswer(guess);
			game.numberOfGuesses(guess);
			game.addGuessedLetters(guess);
			game.failedGuesses(guess); 
			 
			testArea.setText("");
			
			testArea.append("\n");
			testArea.append(game.toString(game.wordLine));
			testArea.append("\n\n");
			testArea.append("Your number guesses left: "+ (6 - (game.getNumberOfGuesses())));
			testArea.append("\n\n");
			testArea.append("Failed Letters: " + game.toString(game.failedLetters));
			
			
			textLetter.setText("");
			
			if(game.getNumberOfGuesses() == 6) {
				
				MakeUserMenuItem.setEnabled(true);
				startGameMenuItem.setEnabled(true);
				hintMenuItem.setEnabled(false);
				btnGuess.setVisible(false);
				textLetter.setVisible(false);
				lblAddLetter.setVisible(false);
				
				JOptionPane.showMessageDialog(this, "You Ran out of Guesses, Better Luck Next Time!", "New Game", JOptionPane.PLAIN_MESSAGE);
				testArea.setText("");
				testArea.append("To start a new game Click [Game Menu] and then [Start Game]");
				testArea.append("\n\n Good Luck and Have Fun!");
				
				sb.updateInfo(game.getPlayerName(), game.getGamesPlayed(), game.getGamesWon());
				//sb.serializable();//                                                                     <--------------------------------------------------------------------------------------
			}
			
			if(game.checkWin() == true) {
				
				game.updatePlayerWins();
				
				MakeUserMenuItem.setEnabled(true);
				startGameMenuItem.setEnabled(true);
				hintMenuItem.setEnabled(false);
				btnGuess.setVisible(false);
				textLetter.setVisible(false);
				lblAddLetter.setVisible(false);
				
				JOptionPane.showMessageDialog(this, "Congrats YOU WON!", "New Game", JOptionPane.PLAIN_MESSAGE);
				testArea.setText("");
				testArea.append("To start a new game Click [Game Menu] \nand then Click [Start Game]");
				testArea.append("\n\n Good Luck and Have Fun!");
				
				sb.updateInfo(game.getPlayerName(), game.getGamesPlayed(), game.getGamesWon());
				//sb.serializable();//                                                                <--------------------------------------------------------------------------------------
			}
			 
			if(game.getNumberOfGuesses() == 1) {
				imgLabel.setIcon(img1);
			}
			if(game.getNumberOfGuesses() == 2) {
				imgLabel.setIcon(img2);
			}
			if(game.getNumberOfGuesses() == 3) {
				imgLabel.setIcon(img3);
			}
			if(game.getNumberOfGuesses() == 4) {
				imgLabel.setIcon(img4);
			}
			if(game.getNumberOfGuesses() == 5) {
				imgLabel.setIcon(img5);
			}
			if(game.getNumberOfGuesses() == 6) {
				imgLabel.setIcon(img6);
			}
			
			}//big else
			
			}//bigger else
			
		}//------------------------btnGuess
		
		else if(e.getSource() == hintMenuItem) {
			
			if(game.getNumberOfGuesses() == 5) {
				JOptionPane.showMessageDialog(this, "You cant get a hint when you only have one guess remaining");
			}
			
			else {
			
			game.getHint();
			
			testArea.setText("");
			testArea.append("\n");
			testArea.append(game.toString(game.wordLine));
			testArea.append("\n\n");
			testArea.append("Your number guesses left: "+ (6 - (game.getNumberOfGuesses())));
			testArea.append("\n\n");
			testArea.append("Failed Letters: " + game.toString(game.failedLetters));
			
			
			if(game.getNumberOfGuesses() == 6) {
				
				MakeUserMenuItem.setEnabled(true);
				startGameMenuItem.setEnabled(true);
				hintMenuItem.setEnabled(false);
				btnGuess.setVisible(false);
				textLetter.setVisible(false);
				lblAddLetter.setVisible(false);
				
				JOptionPane.showMessageDialog(this, "You Ran out of Guesses, Better Luck Next Time!", "New Game", JOptionPane.PLAIN_MESSAGE);
				testArea.setText("");
				testArea.append("To start a new game Click [Game Menu] and then [Start Game]");
				testArea.append("\n\n Good Luck and Have Fun!");
				
				sb.updateInfo(game.getPlayerName(), game.getGamesPlayed(), game.getGamesWon());
				//sb.serializable();//                                                                  <--------------------------------------------------------------------------------------
			}
			
			if(game.checkWin() == true) {
				
				game.updatePlayerWins();
				
				MakeUserMenuItem.setEnabled(true);
				startGameMenuItem.setEnabled(true);
				hintMenuItem.setEnabled(false);
				btnGuess.setVisible(false);
				textLetter.setVisible(false);
				lblAddLetter.setVisible(false);
				
				JOptionPane.showMessageDialog(this, "Congrats YOU WON!", "New Game", JOptionPane.PLAIN_MESSAGE);
				testArea.setText("");
				testArea.append("To start a new game Click [Game Menu] \nand then Click [Start Game]");
				testArea.append("\n\n Good Luck and Have Fun!");
				
				sb.updateInfo(game.getPlayerName(), game.getGamesPlayed(), game.getGamesWon());
				//sb.serializable();//                                                                 <--------------------------------------------------------------------------------------
			}
			 
			if(game.getNumberOfGuesses() == 1) {
				imgLabel.setIcon(img1);
			}
			if(game.getNumberOfGuesses() == 2) {
				imgLabel.setIcon(img2);
			}
			if(game.getNumberOfGuesses() == 3) {
				imgLabel.setIcon(img3);
			}
			if(game.getNumberOfGuesses() == 4) {
				imgLabel.setIcon(img4);
			}
			if(game.getNumberOfGuesses() == 5) {
				imgLabel.setIcon(img5);
			}
			if(game.getNumberOfGuesses() == 6) {
				imgLabel.setIcon(img6);
			}
			}//else
		}//------------------------btnHint
		else if(e.getSource() == quitMenuItem) {
			System.exit(0);
		}
		else if(e.getSource() == rulesMenuItem) {
			JOptionPane.showMessageDialog(this, "You have 6 guesses total \n You cant get a hint on your last guess \n only alphabet is allowed \n cant enter the same letter 2 times");
		}
		else if(e.getSource() == scoreboardMenuItem) {
			
			if(sb.playerList.getLength() < 2) {
				JOptionPane.showMessageDialog(this, "A scoreboard compares, have atleast 2 players created before checking scoreboard");
			}
			else {
			
			scoreBoardTextArea.setText("This is the scoreboard \nFirst column is name Second column is games played Third column is games won \n\n");
			
			
			for(int l = 0; l < sb.playerList.getLength(); l++) {
				
			scoreBoardTextArea.append("name: " + sb.playerList.getElementAt(l).getName() + " Games Played: " + sb.playerList.getElementAt(l).getGamesPlayed() + " Games Won: " + sb.playerList.getElementAt(l).getGamesWon() + "\n");
			 }
			}
			
		}
		else if(e.getSource() == MakeUserMenuItem) {
			
			btnLogin.setVisible(false);
			playerLabel.setVisible(false);
			usernameTextField.setVisible(false);
			
			btnAddPlayer.setVisible(true);
			addPlayerLabel.setVisible(true);
			addPlayerTextField.setVisible(true);	
			
			testArea.setText("Make a Username that dosent \nalready exist \nA message will pop up if your name \nis taken\nAfter making your account \nClick on [Start new Game]\nThen login and play");
			
		}
		else if(e.getSource() == btnAddPlayer) {
			
			
			if(addPlayerTextField.getText().equals("")) {
				
				JOptionPane.showMessageDialog(this, "Please enter a User Name");
				
			}
			
			else if(sb.checkUser(addPlayerTextField.getText()) == false) {
				
				JOptionPane.showMessageDialog(this, "User Name already taken please choose another one");
				
			}
			
			else {
			
			sb.addNewUser(addPlayerTextField.getText());	
			addPlayerTextField.setText("");
			
			btnAddPlayer.setVisible(false);
			addPlayerLabel.setVisible(false);
			addPlayerTextField.setVisible(false);
			testArea.setText("");
			testArea.append("To start a new game Click [Game Menu] \nand then Click [Start Game]");
			testArea.append("\n\n Good Luck and Have Fun!");
			}
			
			
			
			
		}
	}//action performed
}//frame
