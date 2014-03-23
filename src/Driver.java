import java.awt.EventQueue;

import javax.swing.UIManager;

import view.LoginView;
import view.*;


public class Driver {
	
	//launch application

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ManagerView frame = new ManagerView();
					LoginView frame = new LoginView();
					frame.setVisible(true);
                                        ManagerView mv = new ManagerView();
                                        mv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
