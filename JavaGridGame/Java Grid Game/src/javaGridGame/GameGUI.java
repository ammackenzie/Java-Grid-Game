package javaGridGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.TextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import java.awt.Component;

public class GameGUI extends JFrame {

	private Game theGame = new Game(); //single game reference
	private SaveGame save= new SaveGame(); //single save and load class reference
	private JPanel contentPane;
	private JButton btnStartGame;
	private JButton btnNextTurn;
	private JTextPane notificationPane;
	private JButton btnNewGame;
	private JButton btnSwitchMood;
	private JLabel lblOgreMood;
	private JTextPane moodPane;
	private JButton btnSaveGame;
	private JButton btnLoadGame;
	private TextArea displayPane;
	private JTextPane turnCountPane;
	private JLabel lblTurnCount;
	private JLabel lblOgre;
	private JTextPane txtpnOg;
	private JLabel lblTurnCount_1_1;
	private JTextPane txtpnOg_1;
	private JLabel lblSnake;
	private JTextPane txtpnOg_2;
	private JLabel lblDonkey;
	private JLabel lblTurnCount_1_1_1;
	private JButton btnBiggerSwamp;
	private JButton btnSmallerSwamp;
	private JLabel lblResizeSwamp;
	private JLabel lblwindowCanBe;
	private JLabel lblDonkey_1;
	private JTextPane txtpnOg_2_1;
	private JLabel lblDonkey_1_1;
	private JTextPane txtpnOg_2_1_1;
	private JLabel lblGetOutOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI frame = new GameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public GameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 627);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 51));
		contentPane.setForeground(new Color(51, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(getBtnSwitchMood(), GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getLblOgreMood())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getMoodPane(), GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(getLblTurnCount_1_1_1(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(getLblTurnCount_1_1(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(getLblOgre(), GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
										.addGap(28)
										.addComponent(getTxtpnOg(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getLblDonkey_1(), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getTxtpnOg_2_1(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(getLblDonkey_1_1(), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getTxtpnOg_2_1_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(getLblSnake(), GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(getTxtpnOg_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(getLblDonkey(), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(getTxtpnOg_2(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(getLblGetOutOf(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(getDisplayPane(), Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 384, Short.MAX_VALUE)
						.addComponent(getNotificationPane(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getBtnSaveGame(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
							.addComponent(getBtnLoadGame(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(getLblTurnCount(), GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getTurnCountPane(), GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(getLblResizeSwamp(), GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addComponent(getBtnNewGame(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(getBtnNextTurn(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addComponent(getBtnStartGame(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(getLblwindowCanBe()))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(getBtnBiggerSwamp(), GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getBtnSmallerSwamp(), GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addGap(12))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(getLblGetOutOf(), GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getBtnStartGame(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(getBtnNextTurn(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(getLblTurnCount(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(37)
									.addComponent(getTurnCountPane(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(getBtnNewGame(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addComponent(getLblResizeSwamp(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getLblwindowCanBe(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getBtnSwitchMood(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(getMoodPane(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblOgreMood(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(getLblTurnCount_1_1(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(getTxtpnOg(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblOgre(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addComponent(getLblTurnCount_1_1_1(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(getLblSnake(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(getTxtpnOg_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(getTxtpnOg_2(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblDonkey(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(getTxtpnOg_2_1(), GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblDonkey_1(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getDisplayPane(), GroupLayout.PREFERRED_SIZE, 366, Short.MAX_VALUE)
							.addGap(13)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(getLblDonkey_1_1(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(getTxtpnOg_2_1_1(), GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(getBtnBiggerSwamp(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(getBtnSmallerSwamp(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getNotificationPane(), GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(getBtnSaveGame(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(getBtnLoadGame(), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))))
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void updateAll() {
		//update all displays
		getDisplayPane().setText(theGame.boardToString());
		getNotificationPane().setText(theGame.getNotification());
		getMoodPane().setText(theGame.getMood());
		getTurnCountPane().setText("" + theGame.getTurnCount());
	}
	
	
	//components and event listeners
	private JButton getBtnStartGame() {
		if (btnStartGame == null) {
			btnStartGame = new JButton("Start Game!");
			btnStartGame.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			btnStartGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAll();
				}
			});
			btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return btnStartGame;
	}
	private JButton getBtnNextTurn() {
		if (btnNextTurn == null) {
			btnNextTurn = new JButton("Next Turn!");
			btnNextTurn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			btnNextTurn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theGame.nextTurn();
					updateAll();
				}
			});
			btnNextTurn.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return btnNextTurn;
	}
	private JTextPane getNotificationPane() {
		if (notificationPane == null) {
			notificationPane = new JTextPane();
			notificationPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			notificationPane.setEditable(false);
			notificationPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return notificationPane;
	}
	private JButton getBtnNewGame() {
		if (btnNewGame == null) {
			btnNewGame = new JButton("New Game!");
			btnNewGame.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			btnNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theGame.resetGame();
					updateAll();
				}
			});
			btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return btnNewGame;
	}
	private JButton getBtnSwitchMood() {
		if (btnSwitchMood == null) {
			btnSwitchMood = new JButton("Switch Mood!");
			btnSwitchMood.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(153, 153, 0)));
			btnSwitchMood.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theGame.switchMood();
					updateAll();
				}
			});
			btnSwitchMood.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return btnSwitchMood;
	}
	private JLabel getLblOgreMood() {
		if (lblOgreMood == null) {
			lblOgreMood = new JLabel("Ogre Mood:");
			lblOgreMood.setForeground(new Color(245, 245, 220));
			lblOgreMood.setHorizontalAlignment(SwingConstants.LEFT);
			lblOgreMood.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblOgreMood;
	}
	private JTextPane getMoodPane() {
		if (moodPane == null) {
			moodPane = new JTextPane();
			moodPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			moodPane.setEditable(false);
			moodPane.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return moodPane;
	}
	private JButton getBtnSaveGame() {
		if (btnSaveGame == null) {
			btnSaveGame = new JButton("Save Game");
			btnSaveGame.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			btnSaveGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					save.savedGame = theGame;
					save.serialize();
				}
			});
			btnSaveGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return btnSaveGame;
	}
	private JButton getBtnLoadGame() {
		if (btnLoadGame == null) {
			btnLoadGame = new JButton("Load Game");
			btnLoadGame.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			btnLoadGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					save.deserialize();
					theGame = save.loadedGame;
					updateAll();
				}
			});
			btnLoadGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return btnLoadGame;
	}
	private TextArea getDisplayPane() {
		if (displayPane == null) {
			displayPane = new TextArea();
			displayPane.setMaximumSize(new Dimension(32787, 32767));
			displayPane.setFont(new Font("Arial", Font.BOLD, 34));
			displayPane.setForeground(Color.WHITE);
			displayPane.setBackground(Color.BLACK);
			displayPane.setEditable(false);
		}
		return displayPane;
	}
	private JTextPane getTurnCountPane() {
		if (turnCountPane == null) {
			turnCountPane = new JTextPane();
			turnCountPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			turnCountPane.setEditable(false);
			turnCountPane.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return turnCountPane;
	}
	private JLabel getLblTurnCount() {
		if (lblTurnCount == null) {
			lblTurnCount = new JLabel("Turn:");
			lblTurnCount.setForeground(new Color(245, 245, 220));
			lblTurnCount.setHorizontalAlignment(SwingConstants.CENTER);
			lblTurnCount.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblTurnCount;
	}
	private JLabel getLblOgre() {
		if (lblOgre == null) {
			lblOgre = new JLabel("Ogre:");
			lblOgre.setForeground(new Color(255, 255, 255));
			lblOgre.setHorizontalAlignment(SwingConstants.LEFT);
			lblOgre.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblOgre;
	}
	private JTextPane getTxtpnOg() {
		if (txtpnOg == null) {
			txtpnOg = new JTextPane();
			txtpnOg.setForeground(Color.WHITE);
			txtpnOg.setSelectedTextColor(Color.WHITE);
			txtpnOg.setBackground(Color.BLACK);
			txtpnOg.setEditable(false);
			txtpnOg.setText("(0)");
			txtpnOg.setFont(new Font("Arial", Font.BOLD, 30));
		}
		return txtpnOg;
	}
	private JLabel getLblTurnCount_1_1() {
		if (lblTurnCount_1_1 == null) {
			lblTurnCount_1_1 = new JLabel("Game Guide:");
			lblTurnCount_1_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 153, 0)));
			lblTurnCount_1_1.setForeground(new Color(245, 245, 220));
			lblTurnCount_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblTurnCount_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblTurnCount_1_1;
	}
	private JTextPane getTxtpnOg_1() {
		if (txtpnOg_1 == null) {
			txtpnOg_1 = new JTextPane();
			txtpnOg_1.setForeground(Color.WHITE);
			txtpnOg_1.setBackground(Color.BLACK);
			txtpnOg_1.setEditable(false);
			txtpnOg_1.setText("S");
			txtpnOg_1.setFont(new Font("Arial", Font.BOLD, 30));
		}
		return txtpnOg_1;
	}
	private JLabel getLblSnake() {
		if (lblSnake == null) {
			lblSnake = new JLabel("Snake:");
			lblSnake.setHorizontalAlignment(SwingConstants.LEFT);
			lblSnake.setForeground(Color.WHITE);
			lblSnake.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblSnake;
	}
	private JTextPane getTxtpnOg_2() {
		if (txtpnOg_2 == null) {
			txtpnOg_2 = new JTextPane();
			txtpnOg_2.setBackground(Color.BLACK);
			txtpnOg_2.setForeground(Color.WHITE);
			txtpnOg_2.setEditable(false);
			txtpnOg_2.setText("D");
			txtpnOg_2.setFont(new Font("Arial", Font.BOLD, 30));
		}
		return txtpnOg_2;
	}
	private JLabel getLblDonkey() {
		if (lblDonkey == null) {
			lblDonkey = new JLabel("Donkey:");
			lblDonkey.setHorizontalAlignment(SwingConstants.LEFT);
			lblDonkey.setForeground(Color.WHITE);
			lblDonkey.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblDonkey;
	}
	private JLabel getLblTurnCount_1_1_1() {
		if (lblTurnCount_1_1_1 == null) {
			lblTurnCount_1_1_1 = new JLabel("Enemies:");
			lblTurnCount_1_1_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 153, 0)));
			lblTurnCount_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblTurnCount_1_1_1.setForeground(new Color(245, 245, 220));
			lblTurnCount_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblTurnCount_1_1_1;
	}
	private JButton getBtnBiggerSwamp() {
		if (btnBiggerSwamp == null) {
			btnBiggerSwamp = new JButton("Go Bigger!");
			btnBiggerSwamp.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			btnBiggerSwamp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theGame.incrementSwampSize();
					updateAll();
				}
			});
			btnBiggerSwamp.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return btnBiggerSwamp;
	}
	private JButton getBtnSmallerSwamp() {
		if (btnSmallerSwamp == null) {
			btnSmallerSwamp = new JButton("Go Smaller!");
			btnSmallerSwamp.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 153, 0)));
			btnSmallerSwamp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theGame.decrementSwampSize();
					updateAll();
				}
			});
			btnSmallerSwamp.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return btnSmallerSwamp;
	}
	private JLabel getLblResizeSwamp() {
		if (lblResizeSwamp == null) {
			lblResizeSwamp = new JLabel("Resize Swamp!");
			lblResizeSwamp.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 153, 0)));
			lblResizeSwamp.setHorizontalAlignment(SwingConstants.CENTER);
			lblResizeSwamp.setForeground(new Color(245, 245, 220));
			lblResizeSwamp.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblResizeSwamp;
	}
	private JLabel getLblwindowCanBe() {
		if (lblwindowCanBe == null) {
			lblwindowCanBe = new JLabel("(window can be resized)");
			lblwindowCanBe.setHorizontalAlignment(SwingConstants.LEFT);
			lblwindowCanBe.setForeground(new Color(245, 245, 220));
			lblwindowCanBe.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblwindowCanBe;
	}
	private JLabel getLblDonkey_1() {
		if (lblDonkey_1 == null) {
			lblDonkey_1 = new JLabel("Parrot:");
			lblDonkey_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblDonkey_1.setForeground(Color.WHITE);
			lblDonkey_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblDonkey_1;
	}
	private JTextPane getTxtpnOg_2_1() {
		if (txtpnOg_2_1 == null) {
			txtpnOg_2_1 = new JTextPane();
			txtpnOg_2_1.setForeground(Color.WHITE);
			txtpnOg_2_1.setBackground(Color.BLACK);
			txtpnOg_2_1.setText("P");
			txtpnOg_2_1.setFont(new Font("Arial", Font.BOLD, 30));
			txtpnOg_2_1.setEditable(false);
		}
		return txtpnOg_2_1;
	}
	private JLabel getLblDonkey_1_1() {
		if (lblDonkey_1_1 == null) {
			lblDonkey_1_1 = new JLabel("Multiple:");
			lblDonkey_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblDonkey_1_1.setForeground(Color.WHITE);
			lblDonkey_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblDonkey_1_1;
	}
	private JTextPane getTxtpnOg_2_1_1() {
		if (txtpnOg_2_1_1 == null) {
			txtpnOg_2_1_1 = new JTextPane();
			txtpnOg_2_1_1.setBackground(Color.BLACK);
			txtpnOg_2_1_1.setCaretColor(Color.BLACK);
			txtpnOg_2_1_1.setForeground(Color.WHITE);
			txtpnOg_2_1_1.setText("M");
			txtpnOg_2_1_1.setFont(new Font("Arial", Font.BOLD, 30));
			txtpnOg_2_1_1.setEditable(false);
		}
		return txtpnOg_2_1_1;
	}
	private JLabel getLblGetOutOf() {
		if (lblGetOutOf == null) {
			lblGetOutOf = new JLabel("Get Out of My Swamp!");
			lblGetOutOf.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
			lblGetOutOf.setOpaque(true);
			lblGetOutOf.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblGetOutOf.setHorizontalAlignment(SwingConstants.CENTER);
			lblGetOutOf.setBackground(new Color(102, 153, 0));
			lblGetOutOf.setForeground(Color.WHITE);
		}
		return lblGetOutOf;
	}
}//end of class
