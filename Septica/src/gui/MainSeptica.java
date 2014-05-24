package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
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





import designPatterns.ObserverSeptica;
/*import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;
*/
import net.miginfocom.swing.MigLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class MainSeptica extends JFrame {
	
	public static class MyLabel extends JLabel implements ObserverSeptica {
		
		private String id;	
	 	public ImageIcon imageIcon;
	 	private String description;
	 	public static boolean cardsEnabled;
	 	
	    public MyLabel(ImageIcon icon, String id)
	    {
	        super();
	        this.imageIcon = icon;
	        this.id=id;
	    }

	    public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	    
	    public void setImageIcon(ImageIcon icon)
	    {
	    	this.imageIcon=icon;
	    }
	    
	    public ImageIcon getImageIcon()
	    {
	    	return this.imageIcon;
	    }
	    
	    public MyLabel()
	    {
	    	super();
	    }
	    
	    @Override
	    public void paintComponent(Graphics g)
	    {
	        super.paintComponent(g);
	        g.drawImage(imageIcon.getImage(),0,0,getWidth(),getHeight(),this);
	    }
	    
	    public void setIcon(ImageIcon icon)
	    {
	    	this.imageIcon=icon;
	    	revalidate();
	    	repaint();
	    }

		@Override
		public void setId(String id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return this.id;
		}


		@Override
		public void update(String mesaj, int state) {
			// TODO Auto-generated method stub
			if(state==0)
			{
				System.out.println("update"+mesaj);
				int index=getIndexByDescription(mesaj);
				imageIcon.setImage(cards.get(index).getImage());
				setDescription(mesaj);
				cardsEnabled=false;
				
			}
			if(state==1)
			{
				cardsEnabled=true;
			}
			if(state==2)
			{
				this.setVisible(false);
			}
			if(state==3)
			{
				System.out.println("Finally"+mesaj);
				int index=getIndexByDescription(mesaj);
				imageIcon.setImage(cards.get(index).getImage());
				setDescription(mesaj);
				this.setVisible(true);
				System.out.println("card down----------------------");
			}
			revalidate();
			repaint();
			
		}
	}

	private JPanel contentPane;
	private static List<ImageIcon> cards;
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
	private JPanel panelDown;
	
	
public MainSeptica() {
	
		setResizable(false);
		
		cards=new ArrayList<ImageIcon>();
		initializeCards(cards);		

		setForeground(new Color(0, 0, 0));
		setTitle("SEPTICA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				MainSeptica.class.getResource("/Images/Septica.png")));
		setSize(new Dimension(629, 458));
		setBackground(new Color(0, 128, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowClosing(java.awt.event.WindowEvent evt) {
		    	client.send("close");
		    }
		});
		
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, UIManager
				.getColor("Button.disabledForeground"), null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblFirstCard=new MyLabel(this.cards.get(32),"playerCard");
		lblSecondCard=new MyLabel(this.cards.get(33),"playerCard");
		lblThirdCard=new MyLabel(this.cards.get(34),"playerCard");
		lblFourthCard=new MyLabel(this.cards.get(35),"playerCard");
		
		initializePanelUp();
		initializePanelDown();
		initializePanelLeft();
		initializePanelRight();
		initializePanelCenter();
		
		
		lblFirstCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MyLabel.cardsEnabled)
				{
					String description=lblFirstCard.getDescription();
					lblFirstCard.setVisible(false);
					/*lblCurrentPlayerCard.update(description, 0);*/
					chosenCard(description);
				}		
			
			}
		});
		
		lblSecondCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(MyLabel.cardsEnabled)
				{
					String description=lblSecondCard.getDescription();
					lblSecondCard.setVisible(false);
					/*lblCurrentPlayerCard.update(description, 0);*/
					chosenCard(description);
				}
				
				
			}
		});
		
		lblThirdCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(MyLabel.cardsEnabled)
				{
					String description=lblThirdCard.getDescription();
					lblThirdCard.setVisible(false);
					/*lblCurrentPlayerCard.update(description, 0);*/
					chosenCard(description);
				}
				
				
			}
		});
		
		lblFourthCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(MyLabel.cardsEnabled)
				{
					String description=lblFourthCard.getDescription();
					lblFourthCard.setVisible(false);
					/*lblCurrentPlayerCard.update(description, 0);*/
					chosenCard(description);
				}
				
				
			}
		});
		
		
	}

	/**
	 * Launch the application.
	 */
	
	
	
	/*public static void main(String[] args) {
		
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
					frame.runClient();
	}*/
	
	public void runClient() {
		
		client=new Client(2);
		client.addObserver(lblFirstCard);
		client.addObserver(lblSecondCard);
		client.addObserver(lblThirdCard);
		client.addObserver(lblFourthCard);
		client.addObserver(lblCurrentPlayerCard);
		client.addObserver(lblTopPlayerCard);
		client.addObserver(lblLeftPlayerCard);
		client.addObserver(lblRightPlayerCard);
		client.run();
		
		
	}
	public void initializeCard(MyLabel card,String description)
	{
		switch(description)
		{
			case "7-R":
			{
				card.imageIcon.setImage((cards.get(0)).getImage());
				break;
				
			}
			case "7-T":
			{
				card.imageIcon.setImage((cards.get(1)).getImage());
				break;
				
			}
			case "7-IN":
			{
				card.imageIcon.setImage((cards.get(2)).getImage());
				break;
				
			}
			case "7-IR":
			{
				card.imageIcon.setImage((cards.get(3)).getImage());
				break;
				
			}
			case "8-R":
			{
				card.imageIcon.setImage((cards.get(4)).getImage());
				break;
				
			}
			case "8-T":
			{
				card.imageIcon.setImage((cards.get(5)).getImage());
				break;
				
			}
			case "8-IN":
			{
				card.imageIcon.setImage((cards.get(6)).getImage());
				break;
				
			}
			case "8-IR":
			{
				card.imageIcon.setImage((cards.get(7)).getImage());
				break;
				
			}
			case "9-R":
			{
				card.imageIcon.setImage((cards.get(8)).getImage());
				break;
				
			}
			case "9-T":
			{
				card.imageIcon.setImage((cards.get(9)).getImage());
				break;
				
			}
			case "9-IN":
			{
				card.imageIcon.setImage((cards.get(10)).getImage());
				break;
				
			}
			case "9-IR":
			{
				card.imageIcon.setImage((cards.get(11)).getImage());
				break;
				
			}
			case "10-R":
			{
				card.imageIcon.setImage((cards.get(12)).getImage());
				break;
				
			}
			case "10-T":
			{
				card.imageIcon.setImage((cards.get(13)).getImage());
				break;
				
			}
			case "10-IN":
			{
				card.imageIcon.setImage((cards.get(14)).getImage());
				break;
				
			}
			case "10-IR":
			{
				card.imageIcon.setImage((cards.get(15)).getImage());
				break;
				
			}
			case "11-R":
			{
				card.imageIcon.setImage((cards.get(16)).getImage());
				break;
				
			}
			case "11-T":
			{
				card.imageIcon.setImage((cards.get(17)).getImage());
				break;
				
			}
			case "11-IN":
			{
				card.imageIcon.setImage((cards.get(18)).getImage());
				break;
				
			}
			case "11-IR":
			{
				card.imageIcon.setImage((cards.get(19)).getImage());
				break;
				
			}
			case "12-R":
			{
				card.imageIcon.setImage((cards.get(20)).getImage());
				break;
				
			}
			case "12-T":
			{
				card.imageIcon.setImage((cards.get(21)).getImage());
				break;
				
			}
			case "12-IN":
			{
				card.imageIcon.setImage((cards.get(22)).getImage());
				break;
				
			}
			case "12-IR":
			{
				card.imageIcon.setImage((cards.get(23)).getImage());
				break;
				
			}
			case "13-R":
			{
				card.imageIcon.setImage((cards.get(24)).getImage());
				break;
				
			}
			case "13-T":
			{
				card.imageIcon.setImage((cards.get(25)).getImage());
				break;
				
			}
			case "13-IN":
			{
				card.imageIcon.setImage((cards.get(26)).getImage());
				break;
				
			}
			case "13-IR":
			{
				card.imageIcon.setImage((cards.get(27)).getImage());
				break;
				
			}
			case "14-R":
			{
				card.imageIcon.setImage((cards.get(28)).getImage());
				break;
				
			}
			case "14-T":
			{
				card.imageIcon.setImage((cards.get(29)).getImage());
				break;
				
			}
			case "14-IN":
			{
				card.imageIcon.setImage((cards.get(30)).getImage());
				break;
				
			}
			case "14-IR":
			{
				card.imageIcon.setImage((cards.get(31)).getImage());
				break;
				
			}
		}
		revalidate();
		repaint();
	}	
	
	
		
	
	public void chosenCard(String description)
	{
		client.send(description);
	}

	/**
	 * Create the frame.
	 */
	
	public static  int getIndexByDescription(String description)
	{
		switch (description) {
		case "7-R": {
			return 0;

		}
		case "7-T": {
			return 1;

		}
		case "7-IN": {
			return 2;

		}
		case "7-IR": {
			return 3;

		}
		case "8-R": {
			return 4;

		}
		case "8-T": {
			return 5;

		}
		case "8-IN": {
			return 6;

		}
		case "8-IR": {
			return 7;

		}
		case "9-R": {
			return 8;

		}
		case "9-T": {
			return 9;

		}
		case "9-IN": {
			return 10;

		}
		case "9-IR": {
			return 11;

		}
		case "10-R": {
			return 12;

		}
		case "10-T": {
			return 13;

		}
		case "10-IN": {
			return 14;

		}
		case "10-IR": {
			return 15;

		}
		case "11-R": {
			return 16;

		}
		case "11-T": {
			return 17;

		}
		case "11-IN": {
			return 18;

		}
		case "11-IR": {
			return 19;

		}
		case "12-R": {
			return 20;

		}
		case "12-T": {
			return 21;

		}
		case "12-IN": {
			return 22;

		}
		case "12-IR": {
			return 23;

		}
		case "13-R": {
			return 24;

		}
		case "13-T": {
			return 25;

		}
		case "13-IN": {
			return 26;

		}
		case "13-IR": {
			return 27;

		}
		case "14-R": {
			return 28;

		}
		case "14-T": {
			return 29;

		}
		case "14-IN": {
			return 30;

		}
		case "14-IR": {
			return 31;

		}
	}
		return -1;
	}
	
	
	/*public void initializeCard(MyLabel card,String description)
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
	}*/	

	
	/*public static  int getIndexByDescription(String description)
	{
		switch (description) {
		case "7R": {
			return 0;

		}
		case "7T": {
			return 1;

		}
		case "7IN": {
			return 2;

		}
		case "7IR": {
			return 3;

		}
		case "8R": {
			return 4;

		}
		case "8T": {
			return 5;

		}
		case "8IN": {
			return 6;

		}
		case "8IR": {
			return 7;

		}
		case "9R": {
			return 8;

		}
		case "9T": {
			return 9;

		}
		case "9IN": {
			return 10;

		}
		case "9IR": {
			return 11;

		}
		case "10R": {
			return 12;

		}
		case "10T": {
			return 13;

		}
		case "10IN": {
			return 14;

		}
		case "10IR": {
			return 15;

		}
		case "11R": {
			return 16;

		}
		case "11T": {
			return 17;

		}
		case "11IN": {
			return 18;

		}
		case "11IR": {
			return 19;

		}
		case "12R": {
			return 20;

		}
		case "12T": {
			return 21;

		}
		case "12IN": {
			return 22;

		}
		case "12IR": {
			return 23;

		}
		case "13R": {
			return 24;

		}
		case "13T": {
			return 25;

		}
		case "13IN": {
			return 26;

		}
		case "13IR": {
			return 27;

		}
		case "14R": {
			return 28;

		}
		case "14T": {
			return 29;

		}
		case "14IN": {
			return 30;

		}
		case "14IR": {
			return 31;

		}
	}
		return -1;
	}*/

	
	public void initializePanelUp()
	{
		JPanel panelUp = new JPanel();
		panelUp.setBackground(new Color(153, 204, 153));
		contentPane.add(panelUp, BorderLayout.NORTH);
		panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		MyLabel label = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeck.jpg")),"");
		label.setPreferredSize(new Dimension(35, 49));
		panelUp.add(label);

		MyLabel label1 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeck.jpg")),"");
		label1.setPreferredSize(new Dimension(35, 49));
		panelUp.add(label1);

		MyLabel label2 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeck.jpg")),"");
		label2.setPreferredSize(new Dimension(35, 49));
		panelUp.add(label2);

		MyLabel label3 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeck.jpg")),"");
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
		panelDown.setLayout(new MigLayout("fill"));
		
		JPanel panelCards = new JPanel();
		panelCards.setBackground(new Color(51, 153, 102));
		panelCards.setBorder(new LineBorder(new Color(0, 0, 51), 4));
		panelDown.add(panelCards);
		
		lblFirstCard.setPreferredSize(new Dimension(75,99));
		panelCards.add(lblFirstCard);
		
		lblSecondCard.setPreferredSize(new Dimension(75,99));
		panelCards.add(lblSecondCard);
		
		lblThirdCard.setPreferredSize(new Dimension(75,99));
		panelCards.add(lblThirdCard);
		
		lblFourthCard.setPreferredSize(new Dimension(75,99));
		panelCards.add(lblFourthCard);
		panelCards.setLayout(new MigLayout("", "[]", "[]"));
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
		panelLeft
				.setLayout(new MigLayout(
						"",
						"[grow,center]",
						"[grow,center][grow,center][grow,center][35px,grow,center][35px,grow,center][35px,grow,center][35px,grow,center][grow,center][grow,center][grow,center]"));

		MyLabel label_1 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
		label_1.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label_1, "cell 0 3");

		MyLabel label_2 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
		label_2.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label_2, "cell 0 4");

		MyLabel label_3 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
		label_3.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label_3, "cell 0 5");

		MyLabel label_4 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
		label_4.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label_4, "cell 0 6");
	}
	
	public void initializePanelRight()
	{
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(153, 204, 153));
		panelRight.setPreferredSize(new Dimension(100, 10));
		contentPane.add(panelRight, BorderLayout.EAST);
		panelRight
				.setLayout(new MigLayout(
						"",
						"[grow,center]",
						"[grow,center][grow,center][grow,center][grow,center][grow,center][grow,center][grow,center][grow,center][grow,center][grow,center]"));

		MyLabel label_5 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
		label_5.setPreferredSize(new Dimension(49, 35));
		panelRight.add(label_5, "cell 0 3");

		MyLabel label_6 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
		label_6.setPreferredSize(new Dimension(49, 35));
		panelRight.add(label_6, "cell 0 4");

		MyLabel label_7 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
		label_7.setPreferredSize(new Dimension(49, 35));
		panelRight.add(label_7, "cell 0 5");

		MyLabel label_8 = new MyLabel(new ImageIcon(
				MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
		label_8.setPreferredSize(new Dimension(49, 35));
		panelRight.add(label_8, "cell 0 6");
	}
	
	public void initializePanelCenter()
	{
		JPanel panelCenter = new JPanel();
		panelCenter.setSize(new Dimension(0, 250));
		panelCenter.setBorder(new MatteBorder(3, 2, 1, 3, (Color) new Color(51, 51, 51)));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(8, 80));
		panel.setBackground(new Color(0, 102, 51));
		panelCenter.add(panel, BorderLayout.NORTH);
		
		lblTopPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")),"cardDownTop");
		lblTopPlayerCard.setPreferredSize(new Dimension(50,70));
		panel.setLayout(new MigLayout("fill"));
		panel.add(lblTopPlayerCard,"center");
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 51));
		panel_1.setPreferredSize(new Dimension(75, 10));
		panelCenter.add(panel_1, BorderLayout.WEST);
		
		lblLeftPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")),"cardDownLeft");
		lblLeftPlayerCard.setPreferredSize(new Dimension(50,70));
		panel_1.add(lblLeftPlayerCard);
		
		JPanel panel_2 = new JPanel();
		panel_2.setSize(new Dimension(100, 50));
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(51, 0, 51), new Color(102, 204, 102), new Color(51, 204, 153), new Color(0, 51, 0)));
		panel_2.setBackground(new Color(51, 153, 102));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		panelCenter.add(panel_2, BorderLayout.CENTER);
		MyLabel lblDeck=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")),"");
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
		panel_2.setLayout(new MigLayout("fill"));
		panel_2.add(lblDeck,"center");
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 102, 51));
		panel_3.setPreferredSize(new Dimension(75, 10));
		panelCenter.add(panel_3, BorderLayout.EAST);
		
		lblRightPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")),"cardDownRight");
		lblRightPlayerCard.setPreferredSize(new Dimension(50,70));
		panel_3.add(lblRightPlayerCard);
		
		JPanel panel_4 = new JPanel();
		panel_4.setSize(new Dimension(0, 80));
		panel_4.setBackground(new Color(0, 102, 51));
		panelCenter.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new MigLayout("fill"));

		lblCurrentPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")),"cardDownCurrent");		
		lblCurrentPlayerCard.setPreferredSize(new Dimension(50,70));
		panel_4.add(lblCurrentPlayerCard,"center");
		
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
		addImageIconToList("/Images/imagesDeck.jpg", cards);
		addImageIconToList("/Images/icon.jpg", cards);
		addImageIconToList("/Images/Septica.png", cards);
		addImageIconToList("/Images/imagesDeckRotated.jpg", cards);
		
	}
	
	public void addImageIconToList(String path, List<ImageIcon> cards)
	{
		ImageIcon img=new ImageIcon(MainSeptica.class.getResource(path));
		cards.add(img);
	}
	
}
