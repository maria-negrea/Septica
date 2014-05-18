package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.septica.Client;

/*import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;
*/
import net.miginfocom.swing.MigLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainSeptica extends JFrame {

	private JPanel contentPane;
	private List<ImageIcon> cards;
	private MyLabel lblTopPlayerCard;
	private MyLabel lblLeftPlayerCard;
	private MyLabel lblRightPlayerCard;
	private MyLabel lblCurrentPlayerCard;
	private MyLabel lblFirstCard;
	private MyLabel lblSecondCard;
	private MyLabel lblThirdCard;
	private MyLabel lblFourthCard;
	private JPanel panelCards;
	private Client client;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSeptica frame = new MainSeptica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void initializeCard(MyLabel card,String description)
	{
		switch(description)
		{
			case "7R":
			{
				card.imageIcon.setImage((cards.get(0)).getImage());
				break;
				
			}
			case "7T":
			{
				card.imageIcon.setImage((cards.get(1)).getImage());
				break;
				
			}
			case "7IN":
			{
				card.imageIcon.setImage((cards.get(2)).getImage());
				break;
				
			}
			case "7IR":
			{
				card.imageIcon.setImage((cards.get(3)).getImage());
				break;
				
			}
			case "8R":
			{
				card.imageIcon.setImage((cards.get(4)).getImage());
				break;
				
			}
			case "8T":
			{
				card.imageIcon.setImage((cards.get(5)).getImage());
				break;
				
			}
			case "8IN":
			{
				card.imageIcon.setImage((cards.get(6)).getImage());
				break;
				
			}
			case "8IR":
			{
				card.imageIcon.setImage((cards.get(7)).getImage());
				break;
				
			}
			case "9R":
			{
				card.imageIcon.setImage((cards.get(8)).getImage());
				break;
				
			}
			case "9T":
			{
				card.imageIcon.setImage((cards.get(9)).getImage());
				break;
				
			}
			case "9IN":
			{
				card.imageIcon.setImage((cards.get(10)).getImage());
				break;
				
			}
			case "9IR":
			{
				card.imageIcon.setImage((cards.get(11)).getImage());
				break;
				
			}
			case "10R":
			{
				card.imageIcon.setImage((cards.get(12)).getImage());
				break;
				
			}
			case "10T":
			{
				card.imageIcon.setImage((cards.get(13)).getImage());
				break;
				
			}
			case "10IN":
			{
				card.imageIcon.setImage((cards.get(14)).getImage());
				break;
				
			}
			case "10IR":
			{
				card.imageIcon.setImage((cards.get(15)).getImage());
				break;
				
			}
			case "11R":
			{
				card.imageIcon.setImage((cards.get(16)).getImage());
				break;
				
			}
			case "11T":
			{
				card.imageIcon.setImage((cards.get(17)).getImage());
				break;
				
			}
			case "11IN":
			{
				card.imageIcon.setImage((cards.get(18)).getImage());
				break;
				
			}
			case "11IR":
			{
				card.imageIcon.setImage((cards.get(19)).getImage());
				break;
				
			}
			case "12R":
			{
				card.imageIcon.setImage((cards.get(20)).getImage());
				break;
				
			}
			case "12T":
			{
				card.imageIcon.setImage((cards.get(21)).getImage());
				break;
				
			}
			case "12IN":
			{
				card.imageIcon.setImage((cards.get(22)).getImage());
				break;
				
			}
			case "12IR":
			{
				card.imageIcon.setImage((cards.get(23)).getImage());
				break;
				
			}
			case "13R":
			{
				card.imageIcon.setImage((cards.get(24)).getImage());
				break;
				
			}
			case "13T":
			{
				card.imageIcon.setImage((cards.get(25)).getImage());
				break;
				
			}
			case "13IN":
			{
				card.imageIcon.setImage((cards.get(26)).getImage());
				break;
				
			}
			case "13IR":
			{
				card.imageIcon.setImage((cards.get(27)).getImage());
				break;
				
			}
			case "14R":
			{
				card.imageIcon.setImage((cards.get(28)).getImage());
				break;
				
			}
			case "14T":
			{
				card.imageIcon.setImage((cards.get(29)).getImage());
				break;
				
			}
			case "14IN":
			{
				card.imageIcon.setImage((cards.get(30)).getImage());
				break;
				
			}
			case "14IR":
			{
				card.imageIcon.setImage((cards.get(31)).getImage());
				break;
				
			}
		}
		revalidate();
		repaint();
	}
	
	public void initializeCurrentPlayerCards(List<String> cardsDescriptions)
	{
		initializeCard(lblFirstCard, cardsDescriptions.get(0));
		initializeCard(lblSecondCard, cardsDescriptions.get(1));
		initializeCard(lblThirdCard, cardsDescriptions.get(2));
		initializeCard(lblFourthCard, cardsDescriptions.get(3));
	}
	
	
	public String getCardDescription(ImageIcon card)
	{
		int index=cards.indexOf(card);
		switch(index)
		{
			case 0:
			{
				return "7R";
			}
			case 1:
			{
				return "7T";
			}
			case 2:
			{
				return "7IN";
			}
			case 3:
			{
				return "7IR";
			}
			case 4:
			{
				return "8R";
			}
			case 5:
			{
				return "8T";
			}
			case 6:
			{
				return "8IN";
			}
			case 7:
			{
				return "8IR";
			}
			case 8:
			{
				return "9R";
			}
			case 9:
			{
				return "9T";
			}
			case 10:
			{
				return "9IN";
			}
			case 11:
			{
				return "9IR";
			}
			case 12:
			{
				return "10R";
			}
			case 13:
			{
				return "10T";
			}
			case 14:
			{
				return "10IN";
			}
			case 15:
			{
				return "10IR";
			}
			case 16:
			{
				return "11R";
			}
			case 17:
			{
				return "11T";
			}
			case 18:
			{
				return "11IN";
			}
			case 19:
			{
				return "11IR";
			}
			case 20:
			{
				return "12R";
			}
			case 21:
			{
				return "12T";
			}
			case 22:
			{
				return "12IN";
			}
			case 23:
			{
				return "12IR";
			}
			case 24:
			{
				return "13R";
			}
			case 25:
			{
				return "13T";
			}
			case 26:
			{
				return "13IN";
			}
			case 27:
			{
				return "13IR";
			}
			case 28:
			{
				return "14R";
			}
			case 29:
			{
				return "14T";
			}
			case 30:
			{
				return "14IN";
			}
			case 31:
			{
				return "14IR";
			}
		}
		return null;
	}
	
	public void chosenCard(String description)
	{
		/*client.send(description);*/
	}
	
	public void getPlayersChoices(String description, String playerPosition)
	{
		
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public MainSeptica() {

		setForeground(new Color(0, 0, 0));
		setTitle("SEPTICA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainSeptica.class.getResource("/Images/Septica.png")));
		setSize(new Dimension(629, 458));
		setBackground(new Color(0, 128, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.disabledForeground"), null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		cards=new ArrayList<ImageIcon>();
		initializeCards(cards);
		
		initializePanelUp();
		initializePanelDown();
		initializePanelLeft();
		initializePanelRight();
		initializePanelCenter();	
		
		lblFirstCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String description=getCardDescription(lblFirstCard.imageIcon);
				initializeCard(lblCurrentPlayerCard, description);
				/*lblFirstCard.isVisible()=false;*/
				lblFirstCard.setVisible(false);
				chosenCard(description);
				revalidate();
				repaint();
				
			}
		});
		
		lblSecondCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String description=getCardDescription(lblSecondCard.imageIcon);
				initializeCard(lblCurrentPlayerCard, description);
				lblSecondCard.setVisible(false);
				chosenCard(description);
				revalidate();
				repaint();
				
			}
		});
		
		lblThirdCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String description=getCardDescription(lblThirdCard.imageIcon);
				initializeCard(lblCurrentPlayerCard, description);
				lblThirdCard.setVisible(false);
				chosenCard(description);
				revalidate();
				repaint();
				
			}
		});
		
		lblFourthCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String description=getCardDescription(lblFourthCard.imageIcon);
				initializeCard(lblCurrentPlayerCard, description);
				lblFourthCard.setVisible(false);
				chosenCard(description);
				revalidate();
				repaint();
				
			}
		});
	}
	
	public void initializePanelUp()
	{
		JPanel panelUp = new JPanel();
		panelUp.setBackground(new Color(153, 204, 153));
		contentPane.add(panelUp, BorderLayout.NORTH);
		panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		MyLabel label = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeck.jpg")));
		label.setPreferredSize(new Dimension(35, 49));
		panelUp.add(label);
		
		MyLabel label1 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeck.jpg")));
		label1.setPreferredSize(new Dimension(35, 49));
		panelUp.add(label1);
		
		MyLabel label2 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeck.jpg")));
		label2.setPreferredSize(new Dimension(35, 49));
		panelUp.add(label2);
		
		MyLabel label3 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeck.jpg")));
		label3.setPreferredSize(new Dimension(35, 49));
		panelUp.add(label3);
	}
	
	public void initializePanelDown()
	{
		JPanel panelDown = new JPanel();
		panelDown.setBorder(null);
		panelDown.setPreferredSize(new Dimension(10, 150));
		panelDown.setBackground(new Color(153, 204, 153));
		contentPane.add(panelDown, BorderLayout.SOUTH);
		
		JPanel panelCards = new JPanel();
		panelCards.setBackground(new Color(51, 153, 102));
		panelCards.setBorder(new LineBorder(new Color(0, 0, 51), 4));
		panelDown.add(panelCards);
		
		lblFirstCard = new MyLabel(cards.get(24));
		initializeCard(lblFirstCard, "8R");
		lblFirstCard.setPreferredSize(new Dimension(75,99));
		panelCards.add(lblFirstCard);
		
		lblSecondCard = new MyLabel(cards.get(5));
		initializeCard(lblSecondCard, "8T");
		lblSecondCard.setPreferredSize(new Dimension(75,99));
		panelCards.add(lblSecondCard);
		
		lblThirdCard = new MyLabel(cards.get(26));
		initializeCard(lblThirdCard, "8IN");
		lblThirdCard.setPreferredSize(new Dimension(75,99));
		panelCards.add(lblThirdCard);
		
		lblFourthCard = new MyLabel(cards.get(27));
		initializeCard(lblFourthCard, "8IR");
		lblFourthCard.setPreferredSize(new Dimension(75,99));
		panelCards.add(lblFourthCard);
	}
	
	public void initializePanelLeft()
	{
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(153, 204, 153));
		panelLeft.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelLeft.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelLeft.setPreferredSize(new Dimension(100, 10));
		contentPane.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new MigLayout("", "[grow,center]", "[grow,center][grow,center][grow,center][35px,grow,center][35px,grow,center][35px,grow,center][35px,grow,center][grow,center][grow,center][grow,center]"));
		
		MyLabel label_1 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated2.jpg")));
		label_1.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label_1, "cell 0 3");
		
		MyLabel label_2 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated2.jpg")));
		label_2.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label_2, "cell 0 4");
		
		MyLabel label_3 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated2.jpg")));
		label_3.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label_3, "cell 0 5");
		
		MyLabel label_4 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated2.jpg")));
		label_4.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label_4, "cell 0 6");
	}
	
	public void initializePanelRight()
	{
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(153, 204, 153));
		panelRight.setPreferredSize(new Dimension(100, 10));
		contentPane.add(panelRight, BorderLayout.EAST);
		panelRight.setLayout(new MigLayout("", "[grow,center]", "[grow,center][grow,center][grow,center][grow,center][grow,center][grow,center][grow,center][grow,center][grow,center][grow,center]"));
		
		MyLabel label_5 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated2.jpg")));
		label_5.setPreferredSize(new Dimension(49,35));
		panelRight.add(label_5, "cell 0 3");
		
		MyLabel label_6 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated2.jpg")));
		label_6.setPreferredSize(new Dimension(49,35));
		panelRight.add(label_6, "cell 0 4");
		
		MyLabel label_7 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated2.jpg")));
		label_7.setPreferredSize(new Dimension(49,35));
		panelRight.add(label_7, "cell 0 5");
		
		MyLabel label_8 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated2.jpg")));
		label_8.setPreferredSize(new Dimension(49,35));
		panelRight.add(label_8, "cell 0 6");
	}
	
	public void initializePanelCenter()
	{
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new MatteBorder(3, 2, 1, 3, (Color) new Color(51, 51, 51)));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 51));
		panelCenter.add(panel, BorderLayout.NORTH);
		
		lblTopPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")));
		lblTopPlayerCard.setPreferredSize(new Dimension(50,70));
		panel.add(lblTopPlayerCard);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 51));
		panel_1.setPreferredSize(new Dimension(75, 10));
		panelCenter.add(panel_1, BorderLayout.WEST);
		
		lblLeftPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")));
		lblLeftPlayerCard.setPreferredSize(new Dimension(50,70));
		panel_1.add(lblLeftPlayerCard);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(51, 0, 51), new Color(102, 204, 102), new Color(51, 204, 153), new Color(0, 51, 0)));
		panel_2.setBackground(new Color(51, 153, 102));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		panelCenter.add(panel_2, BorderLayout.CENTER);
		MyLabel lblDeck=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		lblDeck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblFirstCard.setIcon(cards.get(0));
				lblSecondCard.setIcon(cards.get(1));
				lblThirdCard.setIcon(cards.get(2));
				lblFourthCard.setIcon(cards.get(3));
			}
		});
		lblDeck.setPreferredSize(new Dimension(70,50));
		panel_2.add(lblDeck);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 102, 51));
		panel_3.setPreferredSize(new Dimension(75, 10));
		panelCenter.add(panel_3, BorderLayout.EAST);
		
		lblRightPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")));
		lblRightPlayerCard.setPreferredSize(new Dimension(50,70));
		panel_3.add(lblRightPlayerCard);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 102, 51));
		panelCenter.add(panel_4, BorderLayout.SOUTH);		

		lblCurrentPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")));		
		lblCurrentPlayerCard.setPreferredSize(new Dimension(50,70));
		panel_4.add(lblCurrentPlayerCard);
	}

	public void initializeCards(List<ImageIcon> cards)
	{
		
		addImageIconToList("/Images/7Colt.jpg", cards);
		addImageIconToList("/Images/7Trefla.jpg", cards);
		addImageIconToList("/Images/7InimaNeagra.jpg", cards);
		addImageIconToList("/Images/7InimaRosie.jpg", cards);		
		addImageIconToList("/Images/8Colt.jpg", cards);
		addImageIconToList("/Images/8Trefla.jpg", cards);
		addImageIconToList("/Images/8InimaNeagra.jpg", cards);
		addImageIconToList("/Images/8InimaRosie.jpg", cards);		
		addImageIconToList("/Images/9Colt.jpg", cards);
		addImageIconToList("/Images/9Trefla.jpg", cards);
		addImageIconToList("/Images/9InimaNeagra.jpg", cards);
		addImageIconToList("/Images/9InimaRosie.jpg", cards);		
		addImageIconToList("/Images/10Colt.jpg", cards);
		addImageIconToList("/Images/10Trefla.jpg", cards);
		addImageIconToList("/Images/10InimaNeagra.jpg", cards);
		addImageIconToList("/Images/10InimaRosie.jpg", cards);	
		addImageIconToList("/Images/AsColt.jpg", cards);
		addImageIconToList("/Images/AsTrefla.jpg", cards);
		addImageIconToList("/Images/AsInimaNeagra.jpg", cards);
		addImageIconToList("/Images/AsInimaRosie.jpg", cards);		
		addImageIconToList("/Images/JColt.jpg", cards);
		addImageIconToList("/Images/JTrefla.jpg", cards);
		addImageIconToList("/Images/JInimaNeagra.jpg", cards);
		addImageIconToList("/Images/JInimaRosie.jpg", cards);		
		addImageIconToList("/Images/QColt.jpg", cards);
		addImageIconToList("/Images/QTrefla.jpg", cards);
		addImageIconToList("/Images/QInimaNeagra.jpg", cards);
		addImageIconToList("/Images/QInimaRosie.jpg", cards);		
		addImageIconToList("/Images/KColt.jpg", cards);
		addImageIconToList("/Images/KTrefla.jpg", cards);
		addImageIconToList("/Images/KInimaNeagra.jpg", cards);
		addImageIconToList("/Images/KInimaRosie.jpg", cards);
		
	}
	
	public void addImageIconToList(String path, List<ImageIcon> cards)
	{
		ImageIcon img=new ImageIcon(MainSeptica.class.getResource(path));
		cards.add(img);
	}
	
}
