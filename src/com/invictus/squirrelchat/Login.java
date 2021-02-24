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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtIP;
	private JLabel lblPort;
	private JTextField txtPort;
	private JLabel lblIpDesc;
	private JLabel lblPortDesc;
	private JLabel lblTitle;

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
		
		txtName = new JTextField();
		txtName.setBounds(103, 103, 164, 27);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtIP = new JTextField();
		txtIP.setColumns(10);
		txtIP.setBounds(103, 174, 164, 27);
		contentPane.add(txtIP);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setLabelFor(txtName);
		lblName.setBounds(103, 83, 60, 17);
		contentPane.add(lblName);
		
		JLabel lblIp = new JLabel("IP Address : ");
		lblIp.setLabelFor(txtIP);
		lblIp.setBounds(103, 154, 104, 17);
		contentPane.add(lblIp);
		
		lblPort = new JLabel("Port :");
		lblPort.setBounds(103, 227, 104, 17);
		contentPane.add(lblPort);
		
		txtPort = new JTextField();
		lblPort.setLabelFor(txtPort);
		txtPort.setColumns(10);
		txtPort.setBounds(103, 247, 164, 27);
		contentPane.add(txtPort);
		
		lblIpDesc = new JLabel("e.g. 192.168.0.2");
		lblIpDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpDesc.setBounds(125, 200, 120, 17);
		contentPane.add(lblIpDesc);
		
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
		
		lblPortDesc = new JLabel("e.g. 1921");
		lblPortDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortDesc.setBounds(125, 276, 120, 17);
		contentPane.add(lblPortDesc);
		
		lblTitle = new JLabel("SquirrelChat");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(110, 22, 150, 28);
		contentPane.add(lblTitle);
	}
	private void login(String name,String Address,int port){
		dispose();
		new Client(name,Address,port);
	}
}
