package finalProject;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyNewJrame extends BaseForm {

	
	protected JLabel lblOutput;
	protected JTable tblData;
	protected JTextField txtSearch;
	protected JComboBox comboList;
	protected JButton btnAdd;
	protected JButton btnDelete;
	protected JButton exportData;
	protected DefaultTableModel tblModel;
	protected JScrollPane scrollPane;
	
	public MyNewJFrame()
	{
		//super();
		this.jfrm.setSize(600, 500);
		lblOutput = new JLabel();
		lblOutput.setText("Search By:");
		this.jfrm.add(lblOutput);
		
		// Adding JScroll Pane here - add it to jframe not the jtable
		scrollPane = new JScrollPane();
		jfrm.add(scrollPane);
		
		String[] choice = {"Row ID", "First Name", "Last Name", "CUNY ID", "GPA", "Venus Login"};
		comboList = new JComboBox<String>(choice);
		this.jfrm.add(comboList);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(20);
		this.jfrm.add(txtSearch);
		
		btnAdd = new JButton("Add");
		this.jfrm.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		this.jfrm.add(btnDelete);
		
		tblData = new JTable();
		JScrollPane jspData = new JScrollPane(tblData);
		
		//This is where you can manipulate data
		tblModel = (DefaultTableModel)tblData.getModel();
		tblModel.addColumn("Row ID");
		tblModel.addColumn("First Name");
		tblModel.addColumn("Last Name");
		tblModel.addColumn("CUNY ID");
		tblModel.addColumn("GPA");
		tblModel.addColumn("Venus Login");
		
		// how to import data ? tblModel.addRow(new Object[]{"12345678","John Doe"});
		
		exportData = new JButton("Export Data");
		exportData.setSize(15,15);
		this.jfrm.add(exportData, BorderLayout.SOUTH);
		
		// The above code I am trying to put 'Export' button below the JTable but that is not working
		
		this.jfrm.add(jspData);
		this.jfrm.setVisible(true);
	}
	@Override
	protected void HandleAboutEvent()
	{
		 JOptionPane.showMessageDialog(this.jfrm, "This application was developed to open and export CUNY student academic information ");
	}
	@Override
    protected void HandleFileOpenEvent() 
	{
		// Open file from computer here
		
	}
	
	protected void HandleFileExportEvent() 
	{
		// TODO Auto-generated method stub
		
	}
}
