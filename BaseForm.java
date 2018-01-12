package finalProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public abstract class BaseForm implements ActionListener{
	protected JFrame jfrm;
	protected JFileChooser jfc;
	protected JLabel lbl;
	public BaseForm()
	{
		//Basic Setup
		jfrm = new JFrame();
		jfrm.setSize(300, 300);
		jfrm.setLocationRelativeTo(null);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLayout(new FlowLayout());
		jfrm.setTitle("Sumaiya's Final Project");	
		
		
		//Setup menus
		JMenuBar jmb = new JMenuBar();
		
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiOpen = new JMenuItem("Open");
		jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiExport = new JMenuItem("Export");
		jmiExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiQuit = new JMenuItem("Quit");
		jmiQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		jmiOpen.addActionListener(this);
		jmiExport.addActionListener(this);
		jmiQuit.addActionListener(this);
		jmFile.add(jmiOpen);
		
		jfc = new JFileChooser();
		
		
		jmiOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent eve){
				int result = jfc.showOpenDialog(null);				
			}
		});
		
		jmFile.add(jmiExport);
		jmFile.add(jmiQuit);
		jmb.add(jmFile);
		
		JMenu jmHelp = new JMenu("Help");
		JMenuItem jmiAbout = new JMenuItem("About");
		jmiAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));	
		jmiAbout.addActionListener(this);
		jmHelp.add(jmiAbout);
		
		jmb.add(jmHelp);
		jfrm.setJMenuBar(jmb);
	
		
		jfrm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
//			case "Open":
//				HandleFileOpenEvent();
//			break;
			case "Export":
				// ??? How do you export file?
				HandleFileExportEvent();
			case "Quit":
				System.exit(0);
			break;
			case "About":
				HandleAboutEvent();
			break;
		}
	}

	// The below codes will
	
	protected void HandleAboutEvent()
	{
		JOptionPane.showMessageDialog(this.jfrm, "This application will import and export student data from the CUNY System");
	}
	
	protected void HandleFileOpenEvent(){
		jfc = new JFileChooser();
		jfc.setDialogTitle("Choose the text file to read: ");
		int result = jfc.showOpenDialog(null); 
	}

	abstract protected void HandleFileExportEvent(); // Should this be an abstract method?
	
	// The below codes will
	
	
/*	public void PopulateDataFromSelectedRowInTable()
	{
		//int rowIndex = this.myReferencedTable.convertRowIndexToModel(this.myReferencedTable.getSelectedRow());
		int currentRowInGUI = this.myReferencedTable.getSelectedRow();
		if(currentRowInGUI >= 0)
		{
			this.txtRowID.setText(this.myReferencedTable.getValueAt
					(currentRowInGUI, 0).toString());
			this.txtFirstName.setText(this.myReferencedTable.getValueAt
					(currentRowInGUI, 1).toString());
			this.LastName.setText(this.myReferencedTable.getValueAt
					(currentRowInGUI, 2).toString());
			this.CunyID.setText(this.myReferencedTable.getValueAt
					(currentRowInGUI, 3).toString());
			this.GPA.setText(this.myReferencedTable.getValueAt
					(currentRowInGUI, 4).toString());
			this.VenusLogin.setText(this.myReferencedTable.getValueAt
					(currentRowInGUI, 5).toString());
		}
		else
		{
			System.out.println("No row selected in JTable");
		}
	}
*/
	
	

}