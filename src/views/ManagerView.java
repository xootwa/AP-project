package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

public class ManagerView extends JFrame {

	private JPanel contentPane;
	private JPanel toolBarPanel;
	private JTable table;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerView frame = new ManagerView();
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
	public ManagerView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerView.class.getResource("/resources/drink.png")));
		setTitle("AP-Project v0.0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aEvent) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmExit.setIcon(new ImageIcon(ManagerView.class.getResource("/resources/exit.png")));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				About abt = new About();
				
				JOptionPane.showMessageDialog(ManagerView.this, abt.getEditorPane(),"About AP-Project", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mntmAbout.setIcon(new ImageIcon(ManagerView.class.getResource("/resources/about.png")));
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		toolBarPanel = new JPanel();
		toolBarPanel.setBackground(new Color(139, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBarPanel, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBarPanel, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
		);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(139, 0, 0));
		GroupLayout gl_toolBarPanel = new GroupLayout(toolBarPanel);
		gl_toolBarPanel.setHorizontalGroup(
			gl_toolBarPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toolBarPanel.createSequentialGroup()
					.addGap(129)
					.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
					.addGap(178))
		);
		gl_toolBarPanel.setVerticalGroup(
			gl_toolBarPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_toolBarPanel.createSequentialGroup()
					.addGap(6)
					.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnAddDrink = new JButton("Add Drink ");
		btnAddDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				AddDrinkView newDrink = new AddDrinkView();
				newDrink.show();
			}
		});
		btnAddDrink.setIcon(new ImageIcon(ManagerView.class.getResource("/resources/add_drink.png")));
		toolBar.add(btnAddDrink);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(139, 0, 0));
		separator.setBackground(new Color(139, 0, 0));
		toolBar.add(separator);
		
		JButton btnRemoveDrink = new JButton("Remove Drink");
		btnRemoveDrink.setIcon(new ImageIcon(ManagerView.class.getResource("/resources/rem_drink.png")));
		toolBar.add(btnRemoveDrink);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(139, 0, 0));
		separator_1.setForeground(new Color(139, 0, 0));
		toolBar.add(separator_1);
		
		JButton btnModifyDrink = new JButton("Modify Drink ");
		btnModifyDrink.setIcon(new ImageIcon(ManagerView.class.getResource("/resources/mod_drink.png")));
		toolBar.add(btnModifyDrink);
		toolBarPanel.setLayout(gl_toolBarPanel);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
