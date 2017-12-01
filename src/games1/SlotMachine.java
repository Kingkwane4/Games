package games1;

import java.awt.*;

import javax.swing.*;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.text.DecimalFormat;

import java.util.Random;

import java.util.ArrayList;

import javax.swing.border.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class SlotMachine {

	private JButton Money, Spin;

	private JCheckBox cheatBox;

	private JFrame frame;

	private JLabel lblCredits, lblLost, lblMatchThree, lblMatchTwo, lblMoney, lblslot1, lblslot2, lblslot3, lblStatus,
			lblWon;

	private JPanel Reels, pnlslot1, pnlslot2, pnlslot3;

	private JToggleButton tgglSound;

	private JSeparator sepCheats, sepStats, sepStats2, sepStatus;

	private int wallet = 100, boughtCredits = 100, bet = 10, matchThree, matchTwo, win, lost;

	private double earning = 25.0, creditBuyout = 10.0, funds;

	private int slot1 = 7, slot2 = 7, slot3 = 7;

	private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();

	private DecimalFormat df = new DecimalFormat("0.00");

	public SlotMachine(int wallet, int boughtCredits, int bet, double earning, double creditBuyout, int slot1, int slot2,
			int slot3) {

		this.wallet = wallet;

		this.boughtCredits = boughtCredits;

		this.bet = bet;

		this.earning = earning;

		this.creditBuyout = creditBuyout;

		this.slot1 = slot1;

		this.slot2 = slot2;

		this.slot3 = slot3;

		createForm();

		loadImages();

		addFields();

		addButtons();

		layoutFrame();

		layoutReels();

		layoutOther();

	}

	public SlotMachine() {

		createForm();

		loadImages();

		addFields();

		addButtons();

		layoutFrame();

		layoutReels();

		layoutOther();

	}

	// Creates the JFrame and Panels.

	public void createForm() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Slot Machine");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(700,700);

		Reels = new JPanel();
		Reels.setBorder(BorderFactory.createEtchedBorder());

		pnlslot1 = new JPanel();
		pnlslot1.setBackground(new Color(255, 215, 0));
		pnlslot1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

		pnlslot2 = new JPanel();
		pnlslot2.setBackground(new Color(255, 216, 0));
		pnlslot2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

		pnlslot3 = new JPanel();
		pnlslot3.setBackground(new Color(255, 217, 0));
		pnlslot3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

	}

	// add labels to the form

	private void addFields() {

		lblslot1 = new JLabel();

		lblslot2 = new JLabel();

		lblslot3 = new JLabel();

		sepStats = new JSeparator();

		lblMatchTwo = new JLabel();

		lblMatchTwo.setText("Matched two: ");

		lblMatchThree = new JLabel();

		lblMatchThree.setText("Matched three: ");

		lblWon = new JLabel();

		lblWon.setText("Won: ");

		sepStats2 = new JSeparator();

		sepStats2.setOrientation(SwingConstants.VERTICAL);

		lblCredits = new JLabel();

		lblCredits.setText("Wallet: " + wallet);

		lblMoney = new JLabel();

		lblMoney.setText("Money: $" + df.format(funds));

		lblLost = new JLabel();

		lblLost.setText("Lost: ");

		sepStatus = new JSeparator();

		lblStatus = new JLabel();

		lblStatus.setBackground(new Color(255, 255, 255));

		lblStatus.setFont(new Font("Arial", 1, 14));

		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);

		lblStatus.setText("Welcome to SLOTS!!!");

		sepCheats = new JSeparator();

		lblslot1.setIcon(images.get(slot1));

		lblslot2.setIcon(images.get(slot2));

		lblslot3.setIcon(images.get(slot3));

	}

	// add buttons to the form

	private void addButtons() {

		Spin = new JButton();

		Spin.setBackground(new Color(50, 255, 50));

		Spin.setText("Spin");

		Spin.setMaximumSize(new Dimension(200, 50));

		Spin.setMinimumSize(new Dimension(200, 50));

		Spin.addActionListener(new SpinHandler());

		Money = new JButton();

		Money.setBackground(new Color(255, 0, 0));

		Money.setText("Buy Cash");

		Money.setHorizontalTextPosition(SwingConstants.CENTER);

		Money.addActionListener(new BuyCreditsHandler());

		tgglSound = new JToggleButton();

		tgglSound.setSelected(false);

		tgglSound.setText("Sound ON");

		cheatBox = new JCheckBox();

		cheatBox.setText("Always Win");

		cheatBox.setEnabled(false);

	}

	// lays out the frame

	private void layoutFrame() {

		GroupLayout frameLayout = new GroupLayout(frame.getContentPane());

		frame.getContentPane().setLayout(frameLayout);

		frameLayout.setHorizontalGroup(

				frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGap(0, 400, Short.MAX_VALUE));

		frameLayout.setVerticalGroup(

				frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGap(0, 300, Short.MAX_VALUE));

	}

	// lays out the panel and reels

	private void layoutReels() {

		GroupLayout ReelsLayout = new GroupLayout(Reels);

		Reels.setLayout(ReelsLayout);

		ReelsLayout.setHorizontalGroup(

				ReelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(ReelsLayout.createSequentialGroup()

								.addContainerGap()

								.addComponent(pnlslot1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)

								.addGap(18, 18, 18)

								.addComponent(pnlslot2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)

								.addGap(18, 18, 18)

								.addComponent(pnlslot3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)

								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

		ReelsLayout.setVerticalGroup(

				ReelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(ReelsLayout.createSequentialGroup()

								.addContainerGap()

								.addGroup(ReelsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)

										.addComponent(pnlslot2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

										.addComponent(pnlslot1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

										.addComponent(pnlslot3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))

								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

		GroupLayout pnlslot1Layout = new GroupLayout(pnlslot1);

		pnlslot1.setLayout(pnlslot1Layout);

		pnlslot1Layout.setHorizontalGroup(

				pnlslot1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(pnlslot1Layout.createSequentialGroup()

								.addContainerGap()

								.addComponent(lblslot1)

								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

		pnlslot1Layout.setVerticalGroup(

				pnlslot1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(pnlslot1Layout.createSequentialGroup()

								.addContainerGap()

								.addComponent(lblslot1)

								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

		GroupLayout pnlslot2Layout = new GroupLayout(pnlslot2);

		pnlslot2.setLayout(pnlslot2Layout);

		pnlslot2Layout.setHorizontalGroup(

				pnlslot2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(pnlslot2Layout.createSequentialGroup()

								.addContainerGap()

								.addComponent(lblslot2)

								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

		pnlslot2Layout.setVerticalGroup(

				pnlslot2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(pnlslot2Layout.createSequentialGroup()

								.addContainerGap()

								.addComponent(lblslot2)

								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

		GroupLayout pnlslot3Layout = new GroupLayout(pnlslot3);

		pnlslot3.setLayout(pnlslot3Layout);

		pnlslot3Layout.setHorizontalGroup(

				pnlslot3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(pnlslot3Layout.createSequentialGroup()

								.addContainerGap()

								.addComponent(lblslot3)

								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

		pnlslot3Layout.setVerticalGroup(

				pnlslot3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(pnlslot3Layout.createSequentialGroup()

								.addContainerGap()

								.addComponent(lblslot3)

								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

		);

	}

	// lays out the remaining labels, check boxes, progress bars

	private void layoutOther() {

		GroupLayout layout = new GroupLayout(frame.getContentPane());

		frame.getContentPane().setLayout(layout);

		layout.setHorizontalGroup(

				layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(layout.createSequentialGroup()

								.addContainerGap()

								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)

										.addGroup(layout.createSequentialGroup()

												.addGroup(
														layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)

																.addComponent(sepCheats))

																

												.addGap(0, 0, Short.MAX_VALUE))

										.addGroup(layout.createSequentialGroup()

												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)

														.addGroup(layout
																.createParallelGroup(GroupLayout.Alignment.LEADING,
																		false)

																.addGroup(layout.createSequentialGroup()

																		.addComponent(cheatBox)

																		.addGap(18, 18, 18)

																		.addGap(18, 18, 18)

																		.addPreferredGap(ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)

																		.addComponent(tgglSound))

																.addComponent(Spin, GroupLayout.Alignment.TRAILING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

																.addComponent(Reels, GroupLayout.Alignment.TRAILING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

																.addComponent(sepStats, GroupLayout.Alignment.TRAILING)

																.addComponent(lblStatus, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

																.addGroup(layout.createSequentialGroup()

																		.addGroup(layout
																				.createParallelGroup(
																						GroupLayout.Alignment.TRAILING,
																						false)

																				.addComponent(lblMatchTwo,
																						GroupLayout.Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)

																				.addComponent(lblWon,
																						GroupLayout.Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)

																				.addComponent(lblMatchThree,
																						GroupLayout.DEFAULT_SIZE, 149,
																						Short.MAX_VALUE))

																		.addPreferredGap(ComponentPlacement.UNRELATED)

																		.addComponent(sepStats2,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)

																		.addPreferredGap(ComponentPlacement.UNRELATED)

																		.addGroup(layout
																				.createParallelGroup(
																						GroupLayout.Alignment.LEADING,
																						false)

																				.addComponent(lblLost,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)

																				.addComponent(lblCredits,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)

																				.addComponent(lblMoney,
																						GroupLayout.DEFAULT_SIZE, 154,
																						Short.MAX_VALUE))

																		.addGap(0, 0, Short.MAX_VALUE)))

														.addGroup(layout
																.createParallelGroup(GroupLayout.Alignment.TRAILING)

																.addComponent(Money)

																.addComponent(sepStatus, GroupLayout.PREFERRED_SIZE,
																		426, GroupLayout.PREFERRED_SIZE)))

												.addContainerGap())))

		);

		layout.setVerticalGroup(

				layout.createParallelGroup(GroupLayout.Alignment.LEADING)

						.addGroup(layout.createSequentialGroup()

								.addContainerGap()

								.addComponent(Reels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)

								.addPreferredGap(ComponentPlacement.RELATED)

								.addComponent(Spin, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)

								.addPreferredGap(ComponentPlacement.UNRELATED)

								.addComponent(sepStats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)

								.addPreferredGap(ComponentPlacement.UNRELATED)

								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)

										.addGroup(layout.createSequentialGroup()

												.addComponent(lblWon, GroupLayout.PREFERRED_SIZE, 19,
														GroupLayout.PREFERRED_SIZE)

												.addPreferredGap(ComponentPlacement.RELATED)

												.addComponent(lblMatchTwo, GroupLayout.PREFERRED_SIZE, 19,
														GroupLayout.PREFERRED_SIZE)

												.addPreferredGap(ComponentPlacement.RELATED)

												.addComponent(lblMatchThree, GroupLayout.DEFAULT_SIZE, 25,
														Short.MAX_VALUE))

										.addComponent(sepStats2)

										.addGroup(layout.createSequentialGroup()

												.addComponent(lblLost, GroupLayout.PREFERRED_SIZE, 19,
														GroupLayout.PREFERRED_SIZE)

												.addPreferredGap(ComponentPlacement.RELATED)

												.addComponent(lblCredits, GroupLayout.PREFERRED_SIZE, 19,
														GroupLayout.PREFERRED_SIZE)

												.addPreferredGap(ComponentPlacement.RELATED)

												.addComponent(lblMoney, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

										.addComponent(Money, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))

								.addPreferredGap(ComponentPlacement.UNRELATED)

								.addComponent(sepStatus, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)

								.addPreferredGap(ComponentPlacement.UNRELATED)

								.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)

								.addPreferredGap(ComponentPlacement.UNRELATED)

								.addComponent(sepCheats, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)

								.addPreferredGap(ComponentPlacement.RELATED)


								.addPreferredGap(ComponentPlacement.UNRELATED)

								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)

										.addComponent(cheatBox)

										.addComponent(tgglSound))

								.addContainerGap())

		);

		frame.pack();

	}

	// performs action when Buy credits button is clicked

	class BuyCreditsHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			buyCredits();

		}

	}

	// if player has enough funds to buy credits changes button

	public void buyCredits() {

		if (funds >= creditBuyout) {

			funds -= creditBuyout;

			lblMoney.setText("Money: $" + df.format(funds));

			wallet += boughtCredits;

			lblCredits.setText("Wallet: " + wallet);

			lblStatus.setText("+" + boughtCredits + " credits purchased! -$" + df.format(creditBuyout));

		} else {

			lblStatus.setText("Insufficient $ to purchase credits!");

		}

		buyCreditsCheck();

	}

	// if user has enough funds to buy credits changes button color to alert you

	public void buyCreditsCheck() {

		if (funds < bet) {

			Money.setBackground(new java.awt.Color(255, 0, 0));

		} else {

			Money.setBackground(new java.awt.Color(50, 255, 50));

		}

	}

	// performs action when spin button is clicked

	class SpinHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (funds < creditBuyout && wallet < bet) {

				lblStatus.setText("You feeling lucky");

			} else if ((wallet - bet) >= 0) {

				pnlslot1.setBackground(new java.awt.Color(255, 215, 0));

				pnlslot2.setBackground(new java.awt.Color(255, 215, 0));

				pnlslot3.setBackground(new java.awt.Color(255, 215, 0));

				genReelNumbers();

				matchCheck();

			} else {

				lblStatus.setText("Bet is " + bet + " credits, purchase more with $!");

			}

			buyCreditsCheck();

		}

	}

	// generate the 3 reel numbers

	public void genReelNumbers() {

		Random rand = new Random();

		if (cheatBox.isSelected() == true) { // If the Always win cheat mode is enabled.

			int winType = rand.nextInt(4); // generates number between 0-3 to determine the type of win

			slot1 = rand.nextInt(images.size());

			if (winType == 0) { // winType = 0 - Reels 1, 2 and 3 will all match.

				slot2 = slot1;

				slot3 = slot1;

			} else if (winType == 1) { // winType = 1 - Reels 1 and 2 will match.

				slot2 = slot1;

			} else if (winType == 2) { // winType = 2 - Reels 1 and 3 will match.

				slot3 = slot1;

			} else { // winType = 3 - Reels 2 and 3 will match.

				if (slot1 >= 0) {

					slot2 = slot1 + 1;

					slot3 = slot1 + 1;

				}
				if (slot1 == images.size() - 1) {

					slot2 = slot1 - 1;

					slot3 = slot1 - 1;

				}

			}

		} else { // If the Always win cheat mode is disabled play a normal game.

			slot1 = rand.nextInt(images.size());

			slot2 = rand.nextInt(images.size());

			slot3 = rand.nextInt(images.size());

		}

		setReelIcon(slot1, slot2, slot3); // Set the reel image

	}

	// sets the reels icon based on loaded image in images ArrayList

	public void setReelIcon(int ico1, int ico2, int ico3) {

		lblslot1.setIcon(images.get(ico1)); // icon = the ArrayList index = random reel number

		lblslot2.setIcon(images.get(ico2));

		lblslot3.setIcon(images.get(ico3));

	}

	// calculates prize to be awarded

	public double getPrize(double prize) {

		if (slot1 == slot2 && slot2 == slot3) {

			prize *= 100; // if cheating and all are matched return the full pay out x100.

		} else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {

			prize *= 50; // if cheating and two are matched return the pay out x50.

		}

		else {

			prize = 0; // If no win return no prize.

		}

		return prize;

	}

	// Checks for number matches and adjust score depending on result

	public void matchCheck() {

		if (slot1 == slot2 && slot2 == slot3) {

			lblStatus.setText("You matched THREE symbols (" + images.get(slot1).getDescription() + ")! +$"
					+ df.format(getPrize(earning)) + "!");

			lblMatchThree.setText("Matched Three: " + matchThree());

			pnlslot1.setBackground(new java.awt.Color(255, 0, 0)); // Highlights matched icons.

			pnlslot2.setBackground(new java.awt.Color(255, 0, 0));

			pnlslot3.setBackground(new java.awt.Color(255, 0, 0));

		} else if (slot1 == slot2 || slot1 == slot3) {

			lblStatus.setText("You matched TWO symbols (" + images.get(slot1).getDescription() + ")! +$"
					+ df.format(getPrize(earning)) + "!");

			lblMatchTwo.setText("Matched Two: " + matchTwo());

			if (slot1 == slot2) {

				pnlslot1.setBackground(new java.awt.Color(255, 0, 0)); // Highlights matched icons.

				pnlslot2.setBackground(new java.awt.Color(255, 0, 0));

			} else if (slot1 == slot3) {

				pnlslot1.setBackground(new java.awt.Color(255, 0, 0)); // Highlights matched icons.

				pnlslot3.setBackground(new java.awt.Color(255, 0, 0));

			}

		} else if (slot2 == slot3) {

			lblStatus.setText("You matched TWO symbols (" + images.get(slot2).getDescription() + ")! +$"
					+ df.format(getPrize(earning)) + "!");

			lblMatchTwo.setText("Matched Two: " + matchTwo());

			pnlslot2.setBackground(new java.awt.Color(255, 0, 0)); // Highlights matched icons.

			pnlslot3.setBackground(new java.awt.Color(255, 0, 0));

		} else {

			lblStatus.setText("Sorry, you didn't match any symbols. -" + bet + " credits!");

			lblLost.setText("Lost: " + lose());

		}

		lblCredits.setText("Credits: " + (wallet -= bet)); // deduct bet amount from available credits.

		lblMoney.setText("Money: $" + df.format((funds += getPrize(earning)))); // If there is a win add amount to cash
																				// pot.

		lblWon.setText("Wins: " + win()); // increment win amount.

	}

	// sets progress bar equal to the current win count if bar is full it unlocks
	// the cheats



	// loads images to the image ArrayList

	public void loadImages() {

		images.add(createImageIcon("images/Banana.png", "Banana"));

		images.add(createImageIcon("images/Bar.png", "Bar"));

		images.add(createImageIcon("images/Bell.png", "Bell"));

		images.add(createImageIcon("images/Cherry.png", "Cherry"));

		images.add(createImageIcon("images/Clover.png", "Clover"));

		images.add(createImageIcon("images/Diamond.png", "Diamond"));

		images.add(createImageIcon("images/Lemon.png", "Lemon"));

		images.add(createImageIcon("images/Seven.png", "Seven"));

		images.add(createImageIcon("images/Watermelon.png", "Watermelon"));

		/*
		 * ImageIcon img = new ImageIcon("Banana.png"); ImageIcon img1 = new
		 * ImageIcon("Bar.png"); ImageIcon img2 = new ImageIcon("Bell.png"); ImageIcon
		 * img3 = new ImageIcon("Cherry.png"); ImageIcon img4 = new
		 * ImageIcon("Clover.png"); ImageIcon img5 = new ImageIcon("Diamond.png");
		 * ImageIcon img6 = new ImageIcon("Lemon.png"); ImageIcon img7 = new
		 * ImageIcon("Seven.png"); ImageIcon img8 = new ImageIcon("Watermeleon.png");
		 */

	}

	// create a new ImageIcon, unless the Url is not Found

	//

	//

	//

	/*
	 * public class createImageIcon extends Component {
	 * 
	 * BufferedImage img;
	 * 
	 * 
	 * 
	 * public void paint(Graphics g) {
	 * 
	 * g.drawImage(img, 0 , 0, null);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public LoadImageApp(){
	 * 
	 * try {
	 * 
	 * img = ImageIO.read(new File("Banana.png"));
	 * 
	 * }catch (IOException e){
	 * 
	 * 
	 * 
	 * }
	 * 
	 * }
	 * 
	 * public Dimension getPreferredSize(){
	 * 
	 * if (img == null){
	 * 
	 * return new Dimension(100,100);
	 * 
	 * }else{
	 * 
	 * return new Dimension(img.getWidth(null), img.getHeight(null))
	 * 
	 * ;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 */

	public ImageIcon createImageIcon(String path, String description) {

		java.net.URL imgURL = getClass().getResource(path);

		if (imgURL != null) {

			return new ImageIcon(imgURL, description);

		} else {

			System.err.println("Couldn't find file: " + path);

			return null;

		}

	}

	// increments matchThree by 1 and returns value

	public int matchThree() {

		matchThree++;

		return matchThree;

	}

	// increments matchTwo by 1 and return value

	public int matchTwo() {

		matchTwo++;

		return matchTwo;

	}

	// increments lost b 1 and returns value

	public int lose() {

		lost++;

		return lost;

	}

	// increments win by 1, increases progress bar and return value

	public int win() {

		win = matchThree + matchTwo;


		return win;

	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {

				new SlotMachine();

			}

		});

	}

}
