package com.invictus.squirrelchat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField txtName;
	private JTextField txtIP;
	private JTextField txtPort;

	private JLabel lblPort;
	private JLabel lblIpDesc;
	private JLabel lblPortDesc;
	private JLabel lblTitle;
	private JLabel lblIp;
	private JLabel lblName;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(370, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Title Label
		lblTitle = new JLabel("Squirrel Chat");
		Image squirrel= getScaledImage(new ImageIcon(this.getClass().getResource("/squirrel.png")).getImage(),30,30);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(110, 22, 182, 28);
		lblTitle.setIcon(new ImageIcon(squirrel));
		contentPane.add(lblTitle);
		
		// First Name field and its label
		txtName = new JTextField();
		txtName.setBounds(103, 103, 164, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setLabelFor(txtName);
		lblName.setBounds(103, 83, 60, 17);
		contentPane.add(lblName);
		
		// IP Address field and its label
		txtIP = new JTextField();
		txtIP.setColumns(10);
		txtIP.setBounds(103, 174, 164, 30);
		contentPane.add(txtIP);
		
		lblIp = new JLabel("IP Address : ");
		lblIp.setLabelFor(txtIP);
		lblIp.setBounds(103, 154, 104, 17);
		contentPane.add(lblIp);
		
		// Label Below IP Address field
		lblIpDesc = new JLabel("e.g. 192.168.0.2");
		lblIpDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpDesc.setBounds(125, 210, 120, 17);
		contentPane.add(lblIpDesc);
		
		// Port field and its label
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(103, 247, 164, 30);
		contentPane.add(txtPort);
		
		lblPort = new JLabel("Port :");
		lblPort.setBounds(103, 227, 104, 17);
		lblPort.setLabelFor(txtPort);
		contentPane.add(lblPort);
		
		// Label below Port Field
		lblPortDesc = new JLabel("e.g. 1921");
		lblPortDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortDesc.setBounds(125, 286, 120, 17);
		contentPane.add(lblPortDesc);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtName.getText();
				String address=txtIP.getText();
				int port=Integer.parseInt(txtPort.getText());
				login(name,address,port);
			}
		});
		btnLogin.setBounds(132, 331, 105, 27);
		contentPane.add(btnLogin);
	}
	private void login(String name,String Address,int port){
		dispose();
		new ClientWindow(name,Address,port);
	}
	
	public Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
}
