
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class table1 {
	JFrame f;
	JTable t;
	public static void mian(String[] arg)
	{
		table1 t1=new table1();
	}
	table1()
	{
		f = new JFrame();
		f.setTitle("JTable Example");
		String[][] data = {
	            { "Kundan Kumar Jha", "4031", "CSE" },
	            { "Anand Jha", "6014", "IT" }
	        };
		String[] columnNames = { "Name", "Roll Number", "Department" };
		t = new JTable(data,columnNames);
		t.setBounds(30, 40, 200, 300);
		 
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(t);
        f.add(sp);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
		
	}
}

