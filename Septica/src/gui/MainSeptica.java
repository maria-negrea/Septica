package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Label;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.ComponentOrientation;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class MainSeptica extends JFrame {

	private JPanel contentPane;

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
		
		JPanel panelDown = new JPanel();
		panelDown.setBorder(null);
		panelDown.setPreferredSize(new Dimension(10, 150));
		panelDown.setBackground(new Color(153, 204, 153));
		contentPane.add(panelDown, BorderLayout.SOUTH);
		
		JPanel panelCards = new JPanel();
		panelCards.setBackground(new Color(51, 153, 102));
		panelCards.setBorder(new LineBorder(new Color(0, 0, 51), 4));
		panelDown.add(panelCards);
		
		JLabel lblFirstCard = new JLabel("");
		lblFirstCard.setIcon(new ImageIcon(MainSeptica.class.getResource("/Images/9Colt.jpg")));
		panelCards.add(lblFirstCard);
		
		JLabel lblSecondCard = new JLabel("");
		lblSecondCard.setIcon(new ImageIcon(MainSeptica.class.getResource("/Images/8InimaNeagra.jpg")));
		panelCards.add(lblSecondCard);
		
		JLabel lblThirdCard = new JLabel("");
		lblThirdCard.setIcon(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaRosie.jpg")));
		panelCards.add(lblThirdCard);
		
		JLabel lblFourthCard = new JLabel("");
		lblFourthCard.setIcon(new ImageIcon(MainSeptica.class.getResource("/Images/8InimaRosie.jpg")));
		panelCards.add(lblFourthCard);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(153, 204, 153));
		panelLeft.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelLeft.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelLeft.setPreferredSize(new Dimension(100, 10));
		contentPane.add(panelLeft, BorderLayout.WEST);
		FlowLayout fl_panelLeft = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelLeft.setLayout(fl_panelLeft);
		
		MyLabel label4 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		label4.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		label4.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label4);
		
		MyLabel label5 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		label5.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label5);
		
		MyLabel label6 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		label6.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label6);
		
		MyLabel label7 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		label7.setPreferredSize(new Dimension(49, 35));
		panelLeft.add(label7);
		panelLeft.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{label4, label5, label6, label7}));
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(153, 204, 153));
		panelRight.setPreferredSize(new Dimension(100, 10));
		contentPane.add(panelRight, BorderLayout.EAST);
		
		MyLabel label8 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		label8.setPreferredSize(new Dimension(49, 35));
		panelRight.add(label8);
		
		MyLabel label9 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		label9.setPreferredSize(new Dimension(49, 35));
		panelRight.add(label9);
		
		MyLabel label10 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		label10.setPreferredSize(new Dimension(49, 35));
		panelRight.add(label10);
		
		MyLabel label11 = new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/imagesDeckRotated.jpg")));
		label11.setPreferredSize(new Dimension(49, 35));
		panelRight.add(label11);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new MatteBorder(3, 2, 1, 3, (Color) new Color(51, 51, 51)));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 51));
		panelCenter.add(panel, BorderLayout.NORTH);
		
		MyLabel lblTopPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")));
		lblTopPlayerCard.setPreferredSize(new Dimension(50,70));
		panel.add(lblTopPlayerCard);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 51));
		panel_1.setPreferredSize(new Dimension(75, 10));
		panelCenter.add(panel_1, BorderLayout.WEST);
		
		MyLabel lblLeftPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")));
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
		lblDeck.setPreferredSize(new Dimension(70,50));
		panel_2.add(lblDeck);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 102, 51));
		panel_3.setPreferredSize(new Dimension(75, 10));
		panelCenter.add(panel_3, BorderLayout.EAST);
		
		MyLabel lblRightPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")));
		lblRightPlayerCard.setBackground(new Color(0, 102, 51));
		lblRightPlayerCard.setPreferredSize(new Dimension(50,70));
		panel_3.add(lblRightPlayerCard);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 102, 51));
		panelCenter.add(panel_4, BorderLayout.SOUTH);
		

		MyLabel lblCurrentPlayerCard=new MyLabel(new ImageIcon(MainSeptica.class.getResource("/Images/10InimaNeagra.jpg")));
		lblCurrentPlayerCard.setPreferredSize(new Dimension(50,70));
		panel_4.add(lblCurrentPlayerCard);
		
		
		
		
		
		
	}
}
