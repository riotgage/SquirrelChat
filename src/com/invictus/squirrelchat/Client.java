package com.invictus.squirrelchat;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String name,address;
	int port;
	private JTextField txtmsg;
	private JTextArea txtHistory;
	public Client(String name,String address,int port) {
		setTitle("SquirrrelChat");
		this.address=address;
		this.name=name;
		this.port=port;
		createWindow();
		console("Attempting a connection to "+ address+ ":"+port+", user: "+name);
	}
	
	private void createWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(910, 570);
		Dimension minDim=new Dimension(400, 500);
		setMinimumSize(minDim);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{30,807,60,13};
		gbl_contentPane.rowHeights = new int[]{45,475,50};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtHistory = new JTextArea();
		txtHistory.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		contentPane.add(txtHistory, gbc_textArea);
		
		txtmsg = new JTextField();
		GridBagConstraints gbc_txtmsg = new GridBagConstraints();
		gbc_txtmsg.insets = new Insets(0, 0, 0, 5);
		gbc_txtmsg.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmsg.gridx = 1;
		gbc_txtmsg.gridy = 2;
		contentPane.add(txtmsg, gbc_txtmsg);
		txtmsg.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridwidth = 2;
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		contentPane.add(btnSend, gbc_btnSend);
		setVisible(true);
		txtmsg.requestFocusInWindow();
	}
	
	public void console(String message){
		txtHistory.append(message+"\n\r");
	}
}
