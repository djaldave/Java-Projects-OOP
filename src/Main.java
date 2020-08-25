import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;


public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	Connection conn = null;
	PreparedStatement pst = null, pst1;
	ResultSet rs = null;
	private JTextField Quando123;
	private JTextField pdnTxt;
	private JTextField ctgTxt;
	private JTextField pdidTxt;
	private JTextField pdnaTxt;
	private JTextField qTxt;
	private JTextField pTxt;
	private JTable table_1;
	private JTextArea txTxt;
	private JTable table_2;
	private JTable table_3;
	private String clicked;
	private JTable table_4;
	private JTable table_5;
	Calendar cal = new GregorianCalendar();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private JTable table_6;
	private JTable table_7;
	private JTextField cTxt;
	private JTable table_8;
	private JTextField locaTxt;
	private JTable table_9;
	private JTable table_10;
	static  int  minus ;
	private JFrame frame;
	JPanel pane;
	JDateChooser dateChooser;
	Random rand = new Random();
	int n = rand.nextInt(99999);
	
	
	JTextField location;
	JTextField c_productCategory;
	JTextField d_Quantity;
	JTextField e_Price;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		dateFormat.setTimeZone(cal.getTimeZone());
//		String uniqueID = UUID.randomUUID().toString();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		settings();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 918, 606);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel HeaderPanel = new JPanel();
		HeaderPanel.setBounds(10, 11, 898, 58);
		panel.add(HeaderPanel);
		HeaderPanel.setLayout(null);
		
		JLabel lblStoreManagementSystem = new JLabel("Store Management System");
		lblStoreManagementSystem.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 25));
		lblStoreManagementSystem.setBounds(10, 11, 878, 36);
		HeaderPanel.add(lblStoreManagementSystem);
		
		JPanel BodyPanel = new JPanel();
		BodyPanel.setBounds(10, 69, 898, 526);
		panel.add(BodyPanel);
		BodyPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 898, 526);
		BodyPanel.add(tabbedPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Inventory", null, layeredPane_1, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(364, 11, 519, 487);
		layeredPane_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 246, 499, 230);
		panel_3.add(scrollPane_2);
		
		table_3 = new JTable();
		table_3.setFillsViewportHeight(true);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane_2.setViewportView(table_3);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table_3, popupMenu);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO
				singleDialogInformation(table_3);
			}
		});
		popupMenu.add(mntmUpdate);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		popupMenu.add(mntmDelete);
		
		
		
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 499, 182);
		panel_3.add(scrollPane_3);
		
		table_2 = new JTable();
		table_2.setSurrendersFocusOnKeystroke(true);
		table_2.setColumnSelectionAllowed(true);
		table_2.setCellSelectionEnabled(true);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showselectedItem(table_2, table_3);
			}
		});
		scrollPane_3.setViewportView(table_2);
		selectMenu(table_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(10, 11, 344, 487);
		layeredPane_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(10, 11, 324, 152);
		panel_2.add(scrollPane_10);
		
		table_1 = new JTable();
		scrollPane_10.setViewportView(table_1);
		updateTable(table_1);
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(10, 185, 324, 286);
		panel_2.add(panel_4);
		
		JLabel label_1 = new JLabel("Product Name");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setBounds(10, 11, 94, 24);
		panel_4.add(label_1);
		
		pdnTxt = new JTextField();
		pdnTxt.setColumns(10);
		pdnTxt.setBounds(114, 11, 169, 24);
		panel_4.add(pdnTxt);
		
		JLabel label_2 = new JLabel("Category");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setBounds(10, 46, 94, 24);
		panel_4.add(label_2);
		
		ctgTxt = new JTextField();
		ctgTxt.setColumns(10);
		ctgTxt.setBounds(114, 46, 169, 24);
		panel_4.add(ctgTxt);
		
		JLabel label_3 = new JLabel("Description");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setBounds(10, 81, 94, 24);
		panel_4.add(label_3);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(114, 80, 169, 105);
		panel_4.add(scrollPane_11);
		
		txTxt = new JTextArea();
		scrollPane_11.setViewportView(txTxt);
		
		JButton button = new JButton("Add Product");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pdnTxt.getText().equals("") &&
				ctgTxt.getText().equals("") &&
				txTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill All Fields");
				}else {
				
				try {
					String sql  = "INSERT INTO inventory(product_name,category,description,status) VALUES (?,?,?,0)";
					pst = conn.prepareStatement(sql);pst.setString(1,pdnTxt.getText()); pst.setString(2,ctgTxt.getText()); pst.setString(3,txTxt.getText());
					 pst.execute();
					 int i = JOptionPane.showConfirmDialog(null, "Successfully Added","",JOptionPane.CLOSED_OPTION);
					 if(i==0) { pdnTxt.setText("");ctgTxt.setText("");txTxt.setText("");
					 updateTable(table_1);
					 updateTable(table_4);
					 
					 }
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				}
			
			}
		});
		button.setBounds(80, 203, 203, 36);
		panel_4.add(button);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Receive", null, layeredPane, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 873, 476);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(321, 11, 542, 454);
		panel_1.add(scrollPane_9);
		
		table_5 = new JTable();
		table_5.setSurrendersFocusOnKeystroke(true);
		scrollPane_9.setViewportView(table_5);
		 updateReceive(table_5);
		
		JPanel qtxt = new JPanel();
		qtxt.setLayout(null);
		qtxt.setBounds(10, 213, 301, 252);
		panel_1.add(qtxt);
		
		pdidTxt = new JTextField();
		pdidTxt.setEditable(false);
		pdidTxt.setColumns(10);
		pdidTxt.setBounds(120, 11, 119, 27);
		qtxt.add(pdidTxt);
		
		pdnaTxt = new JTextField();
		pdnaTxt.setEditable(false);
		pdnaTxt.setColumns(10);
		pdnaTxt.setBounds(120, 49, 119, 27);
		qtxt.add(pdnaTxt);
		
		JLabel label = new JLabel("product name");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(10, 49, 100, 27);
		qtxt.add(label);
		
		JLabel label_4 = new JLabel("product Id");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setBounds(10, 11, 100, 27);
		qtxt.add(label_4);
		
		JLabel label_5 = new JLabel("Quantity");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setBounds(10, 118, 100, 27);
		qtxt.add(label_5);
		
		JLabel label_6 = new JLabel("Price ");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setBounds(10, 151, 100, 27);
		qtxt.add(label_6);
		
		qTxt = new JTextField();
		qTxt.setColumns(10);
		qTxt.setBounds(120, 121, 119, 20);
		qtxt.add(qTxt);
		
		pTxt = new JTextField();
		pTxt.setColumns(10);
		pTxt.setBounds(120, 154, 119, 20);
		qtxt.add(pTxt);
		
		JButton button_1 = 	new JButton("Receive");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				pdidTxt
//				pdnaTxt
				if(qTxt.getText().equals("") &&
				pTxt.getText().equals("") && cTxt.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Please Fill All Fields");
				}else {
					try {
						
						System.out.println(dateFormat.format(cal.getTime()));
						String sql  = "INSERT INTO receive(quantity,price,category,product_name,date_in,location) VALUES (?,?,?,?,'"+dateFormat.format(cal.getTime())+"','"+locaTxt.getText()+"')";
						String sql1  = "INSERT INTO temp(quantity,price,category,product_name,date_in,location) VALUES (?,?,?,?,'"+dateFormat.format(cal.getTime())+"','"+locaTxt.getText()+"')";
						pst = conn.prepareStatement(sql);pst.setString(1,qTxt.getText()); pst.setString(2,pTxt.getText()); pst.setString(3,cTxt.getText()); pst.setString(4,pdnaTxt.getText());
						pst1 = conn.prepareStatement(sql1);pst1.setString(1,qTxt.getText()); pst1.setString(2,pTxt.getText()); pst1.setString(3,cTxt.getText()); pst1.setString(4,pdnaTxt.getText());
						 pst.execute();
						 pst1.execute();
						 sql ="update inventory set status= 1 where product_id='"+pdidTxt.getText()+"'";
						 pst = conn.prepareStatement(sql);
						 pst.execute();
						 int i = JOptionPane.showConfirmDialog(null, "Successfully Added","",JOptionPane.CLOSED_OPTION);
						 if(i==0) {
							 pdidTxt.setText("");
							 pdnaTxt.setText("");
							 qTxt.setText("");
							 pTxt.setText("");
							 
							 updateTable(table_1);
							 updateTable(table_4);
							 updateReceive(table_5);
							 selectMenu(table_2);
							 selectMenu(table_6);
						 }
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		button_1.setBounds(126, 214, 113, 27);
		qtxt.add(button_1);
		
		cTxt = new JTextField();
		cTxt.setEditable(false);
		cTxt.setColumns(10);
		cTxt.setBounds(120, 87, 119, 27);
		qtxt.add(cTxt);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCategory.setBounds(10, 87, 100, 27);
		qtxt.add(lblCategory);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocation.setBounds(10, 182, 100, 27);
		qtxt.add(lblLocation);
		
		locaTxt = new JTextField();
		locaTxt.setColumns(10);
		locaTxt.setBounds(120, 185, 119, 20);
		qtxt.add(locaTxt);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel_5.setBounds(10, 11, 301, 191);
		panel_1.add(panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 301, 191);
		panel_5.add(scrollPane);
		
		table_4 = new JTable();
		updateTable(table_4);
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getDataFromTable(table_4);
			}
		});
		scrollPane.setViewportView(table_4);
		
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Withdrawal", null, layeredPane_2, null);
		
		Quando123 = new JTextField();
		Quando123.setBounds(405, 362, 119, 25);
		layeredPane_2.add(Quando123);
		Quando123.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQuantity.setBounds(308, 362, 87, 25);
		layeredPane_2.add(lblQuantity);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addToCartBtnActionPerformed(arg0, table_8,table_7);
			}
		});
		btnAddToCart.setBounds(540, 362, 152, 25);
		layeredPane_2.add(btnAddToCart);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				x(evt,table_8);
			}
		});
		btnConfirm.setBounds(540, 434, 152, 31);
		layeredPane_2.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "", JOptionPane.YES_NO_OPTION);
				if(i==0) {
					try {
						 String temp = "", temp1 ="";
						 String sql= "select quantity as 'Quantity', receive_id 'Id' from receive" ;
						 pst = conn.prepareStatement(sql);
				            rs = pst.executeQuery();
				            if(rs.next()) {
				            	
				            	temp = rs.getString("Quantity");
				            	temp1 = rs.getString("id");
				            	
				            }
				            int rowsCount  = table_8.getRowCount();
				            for(i =0;i < rowsCount; i++){
				            	
				            	 sql = "update receive set quantity='"+temp+"'"+"where receive_id='"+temp1+"'";
						            System.out.println(sql);
					            	 pst = conn.prepareStatement(sql);
						 	            pst.execute();
				            }
				            System.out.println("no");
							DefaultTableModel dm = (DefaultTableModel)table_8.getModel();
				            dm.getDataVector().removeAllElements();
				            dm.fireTableDataChanged();
				            DefaultTableModel dm1 = (DefaultTableModel)table_7.getModel();
				            dm1.getDataVector().removeAllElements();
				            dm1.fireTableDataChanged(); 
				            updateTable(table_1);
							 updateTable(table_4);
							 updateReceive(table_5);
							 selectMenu(table_2);
							 selectMenu(table_6);
					 }catch(Exception e) {
						 JOptionPane.showMessageDialog(null, e.getMessage());
					 }
				}
			}
		});
		btnCancel.setBounds(378, 434, 152, 31);
		layeredPane_2.add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(0, 190, 893, 2);
		layeredPane_2.add(separator);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel_7.setBounds(10, 11, 873, 168);
		layeredPane_2.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 11, 171, 146);
		panel_7.add(scrollPane_4);
		
		table_6 = new JTable();
		table_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showselectedItem(table_6, table_7);
			}
		});
		scrollPane_4.setViewportView(table_6);
		selectMenu(table_6);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(191, 11, 672, 146);
		panel_7.add(scrollPane_5);
		
		table_7 = new JTable();
		
		scrollPane_5.setViewportView(table_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_8.setBounds(10, 203, 873, 148);
		layeredPane_2.add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(10, 11, 853, 126);
		panel_8.add(scrollPane_8);
		
		table_8 = new JTable();
		table_8.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Product Name", "Quantity", "Price", "Category", "Date in"
			}
		));
		scrollPane_8.setViewportView(table_8);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				removeBtnActionPerformed(evt, table_8);
			}
		});
		btnDelete.setBounds(201, 434, 152, 31);
		layeredPane_2.add(btnDelete);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab("Sales Report", null, layeredPane_3, null);
		layeredPane_3.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(249, 11, 127, 25);
		layeredPane_3.add(dateChooser);
		
		JLabel lblStart = new JLabel("Start: ");
		lblStart.setBounds(169, 11, 70, 25);
		lblStart.setHorizontalAlignment(SwingConstants.TRAILING);
		layeredPane_3.add(lblStart);
		
		JLabel lblEnd = new JLabel("End: ");
		lblEnd.setBounds(447, 11, 70, 25);
		lblEnd.setHorizontalAlignment(SwingConstants.TRAILING);
		layeredPane_3.add(lblEnd);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(527, 11, 127, 25);
		layeredPane_3.add(dateChooser_1);
		
		JButton btnList = new JButton("List");
		btnList.setBounds(383, 47, 104, 25);
		layeredPane_3.add(btnList);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(0, 0, 0)));
		panel_6.setBounds(10, 114, 242, 373);
		layeredPane_3.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 222, 351);
		panel_6.add(scrollPane_1);
		
		table_9 = new JTable();
		scrollPane_1.setViewportView(table_9);
		selectSales(table_9);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(0, 0, 0)));
		panel_9.setBounds(264, 115, 619, 372);
		layeredPane_3.add(panel_9);
		panel_9.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 11, 599, 350);
		panel_9.add(scrollPane_6);
		
		table_10 = new JTable();
		scrollPane_6.setViewportView(table_10);
		
		
		
		// add mmethods
	}
	void settings() {
		conn = ConnectionToDatabase.connectToDb();
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
//		setUndecorated(true);
	}
	void updateTable(JTable table){
        try{
          String sql = "select product_id as 'id',Product_name as 'Prod Name', Category, Description from inventory where status !=1";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            ((JTable) table).getTableHeader().setReorderingAllowed(false);
            (table).setFocusable(false);
            ((JTable) table).setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
	void getDataFromTable(JTable table) {
		String a , ai, aii;
		int row = ((JTable) table).getSelectedRow();
        a = (((JTable) table).getModel().getValueAt(row, 0).toString());
        ai = (((JTable) table).getModel().getValueAt(row, 1).toString());
        aii = (((JTable) table).getModel().getValueAt(row, 2).toString());
        pdidTxt.setText(a);
        pdnaTxt.setText(ai);
        cTxt.setText(aii);
       
	}
	void updateReceive(JTable table) {
		 try{
	          String sql = "select receive_id as 'Id', Product_name as 'Prod Name', quantity as 'Quantity', price as 'Price', category as 'Category', date_in 'Date in' from receive";
	            pst = conn.prepareStatement(sql);
	            rs = pst.executeQuery();
	            ((JTable) table).getTableHeader().setReorderingAllowed(false);
	            (table).setFocusable(false);
	            ((JTable) table).setModel(DbUtils.resultSetToTableModel(rs));
	        }catch(Exception e){
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }
	}
	void selectMenu(JTable table) {
		try {	
			
	        String sql = "SELECT product_name as 'Product Name' FROM receive GROUP BY product_name";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			((JTable) table).getTableHeader().setReorderingAllowed(false);
            ((JTable) table).setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
      
	}
	void showselectedItem(JTable table, JTable table1) {
		try{
			String clicked = "";
			((JTable) table).setFillsViewportHeight(true);
			((JTable) table).getTableHeader().setReorderingAllowed(false);
			 int row1 = ((JTable) table).getSelectedRow();
	            clicked = (((JTable) table).getModel().getValueAt(row1, 0).toString());
	            String sql = "select receive_id as 'Id', Product_name as 'Prod Name', quantity as 'Quantity', price as 'Price', category as 'Category', date_in 'Date in' from receive where product_name='"+clicked+"'";
	            pst = conn.prepareStatement(sql);
	            rs = pst.executeQuery();
	            ((JTable) table1).getTableHeader().setReorderingAllowed(false);
	            ((Component) table1).setFocusable(false);
	            ((JTable) table1).setModel(DbUtils.resultSetToTableModel(rs));
	        }catch(Exception e){
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }
		
		
	}
	void addToCartBtnActionPerformed(ActionEvent evt, Object cartTable, Object table) {
		if(Quando123.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter Quantity");
		}else {
			
			String clicked ="", temp = null,temp1 = null,temp2 = null,temp3 = null,temp4 = null,temp5 = null;
			int temp11, temp21;
			 String clicked1 ="";
			 String clicked3 ="";
			 String clicked4 ="";
			 String temp0 = null;
			int row = ((JTable) table).getSelectedRow();
	        clicked = (((JTable) table).getModel().getValueAt(row, 0).toString());
	        clicked1 = (((JTable) table).getModel().getValueAt(row, 1).toString());
	        clicked3 = (((JTable) table).getModel().getValueAt(row, 3).toString());
	        clicked4 = (((JTable) table).getModel().getValueAt(row, 4).toString());
	        String clicked5 = (((JTable) table).getModel().getValueAt(row, 5).toString());
	        String sql = "select receive_id as 'Id', Product_name as 'Prod Name', quantity as 'Quantity', price as 'Price', category as 'Category', date_in 'Date in' from temp where receive_id='"+clicked+"'";
	       try {
	    	   pst = conn.prepareStatement(sql);
	            rs = pst.executeQuery();
	            System.out.println(rs);
	            if(rs.next()) {
	            	temp = rs.getString("Quantity");
	            }
	            System.out.println(temp);
	            temp11 = Integer.parseInt(temp);
	            temp21= Integer.parseInt(Quando123.getText());
	           
	            
	           
	            if(temp21 < temp11 && temp21 > 0) {
	            	minus = temp11 - temp21;
	            	 sql = "update temp set quantity='"+minus+"'"+"where receive_id='"+clicked+"'";
	 	            pst = conn.prepareStatement(sql);
	 	            pst.execute();
	 	            
	 	            sql = "select receive_id as 'Id', Product_name as 'Prod Name', quantity as 'Quantity', price as 'Price', category as 'Category', date_in 'Date in' from temp where receive_id='"+clicked+"'";
	 	           pst = conn.prepareStatement(sql);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	temp0 = rs.getString("Id");
		            	temp1 = rs.getString("Prod Name");
		            	temp2 = rs.getString("quantity");
		            	temp3 = rs.getString("Price");
		            	temp4 = rs.getString("category");
		            	temp5 = rs.getString("Date in");
		            }
	 	        	TableModel model =((JTable) cartTable).getModel();
	    	        ((DefaultTableModel) model).addRow(new Object[]{temp0,temp1,temp2,temp3,temp4,temp5});
	            }else {
//	            	Stock not available
	            	JOptionPane.showMessageDialog(null, "out of stock or invaild input");
	            	Quando123.setText("");
	            }
	    	   
	       }catch(Exception e) {
	    	   JOptionPane.showMessageDialog(null, e.getMessage()+"ytyt");
	       }
		}
	}
	void x(ActionEvent evt, JTable table) {
		int i = JOptionPane.showConfirmDialog(null, "Confirm?");
		if(i==0 &&	!Quando123.getText().trim().equals("")) {
			try {
				
				 int rowsCount  = table.getRowCount();
				 String sql;
				 String rar= (2019+""+n);
		            for(i =0;i < rowsCount; i++){
		            	sql  = "INSERT INTO sales_report(transact_id,product_id,product_name,quantity,price,category,Date_in,date_out) VALUES (?,?,?,?,?,?,'"+dateFormat.format(cal.getTime())+"','"+dateFormat.format(cal.getTime())+"')";
		            	pst = conn.prepareStatement(sql);
		            	pst.setString(1,rar); pst.setString(2,table.getValueAt(i, 0).toString()); pst.setString(3,table.getValueAt(i, 1).toString()); pst.setString(4,table.getValueAt(i, 2).toString());
		            	pst.setString(5,table.getValueAt(i, 3).toString()); pst.setString(6,table.getValueAt(i, 4).toString());
		            	pst.execute();
		            	 sql = "update receive set quantity='"+minus+"'"+"where receive_id='"+table.getValueAt(i, 0).toString()+"'";
				            System.out.println(sql);
			            	 pst = conn.prepareStatement(sql);
				 	            pst.execute();
		            }
		            DefaultTableModel dm = (DefaultTableModel)table.getModel();
		            dm.getDataVector().removeAllElements();
		            dm.fireTableDataChanged();
		            DefaultTableModel dm1 = (DefaultTableModel)table_7.getModel();
		            dm1.getDataVector().removeAllElements();
		            dm1.fireTableDataChanged(); 
		            updateTable(table_1);
					 updateTable(table_4);
					 updateReceive(table_5);
					 selectMenu(table_2);
					 selectMenu(table_6);
		            minus=0;
		            
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}else if(i==1) {
			
			 try {
				 String temp = "", temp1 ="";
				 String sql= "select quantity as 'Quantity', receive_id 'Id' from receive" ;
				 pst = conn.prepareStatement(sql);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	
		            	temp = rs.getString("Quantity");
		            	temp1 = rs.getString("id");
		            	
		            }
		            int rowsCount  = table.getRowCount();
		            for(i =0;i < rowsCount; i++){
		            	
		            	 sql = "update receive set quantity='"+temp+"'"+"where receive_id='"+temp1+"'";
				            System.out.println(sql);
			            	 pst = conn.prepareStatement(sql);
				 	            pst.execute();
		            }
		            System.out.println("no");
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
		            dm.getDataVector().removeAllElements();
		            dm.fireTableDataChanged();
		            DefaultTableModel dm1 = (DefaultTableModel)table_7.getModel();
		            dm1.getDataVector().removeAllElements();
		            dm1.fireTableDataChanged(); 
		            updateTable(table_1);
					 updateTable(table_4);
					 updateReceive(table_5);
					 selectMenu(table_2);
					 selectMenu(table_6);
			 }catch(Exception e) {
				 JOptionPane.showMessageDialog(null, e.getMessage());
			 }
		}
	}
	void removeBtnActionPerformed(ActionEvent evt, JTable table) {
      try {
    	  DefaultTableModel model = (DefaultTableModel)table.getModel();
          if (table.getSelectedRow() != -1) {
              model.removeRow(table.getSelectedRow());
          }else {
        	  JOptionPane.showMessageDialog(null,"Select A row");
          }
      }catch(Exception e) {
    	  JOptionPane.showMessageDialog(null,"Select A row");
      }
  }
/*	void addPopup(JTable table_32, JPopupMenu popupMenu) {
		table_32.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger())
		        {
		            JTable source = (JTable)e.getSource();
		            int row = source.rowAtPoint( e.getPoint() );
		            int column = source.columnAtPoint( e.getPoint() );
		            

		            if (! source.isRowSelected(row)) {
		                source.changeSelection(row, column, false, false);
		            }
		            popupMenu.show(e.getComponent(), e.getX(), e.getY());
		            
		            String clickedd = "";
		            int row1 = ((JTable) table_32).getSelectedRow();
		            clickedd = (((JTable) table_32).getModel().getValueAt(row1, 0).toString());
		            System.out.println(clickedd);
		        }
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				 	System.out.println("ok1");
				 
			}
		});
	} 
	*/
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				String clickedd = "";
				if (e.isPopupTrigger())
		        {
		            JTable source = (JTable)e.getSource();
		            int row = source.rowAtPoint( e.getPoint() );
		            int column = source.columnAtPoint( e.getPoint() );
		            

		            if (! source.isRowSelected(row)) {
		                source.changeSelection(row, column, false, false);
		            }
		            popup.show(e.getComponent(), e.getX(), e.getY());
		            
		            int row1 = ((JTable) component).getSelectedRow();
		            clickedd = (((JTable) component).getModel().getValueAt(row1, 0).toString());
		            System.out.println(clickedd);
		        }
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 	System.out.println("ok1");
				 
			}
		});
	}
	void singleDialogInformation(JTable table) {
		pane = new JPanel() {
        	public Dimension getPreferredSize() {
        	    return new Dimension(300, 150);
        	  }

        	
        };
        pane.setLayout(new GridLayout(0, 2, 2, 2));
        dateChooser = new JDateChooser();
//        String date = "2020-10-10";
//        java.util.Date date2;
//		try {
//			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//			dateChooser.setDate(date2);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
        location = new JTextField(10);
        c_productCategory = new JTextField(10);
        d_Quantity = new JTextField(10);
        e_Price = new JTextField(10);
        JTextArea txtArea = new JTextArea();
        java.util.Date date2 = null;
        String tmpLocation = null, tmpPCategory = null,tmpQuantity = null, tmpPrice = null,tmpExpiryDate = null, description = null;
        Calendar calobj = Calendar.getInstance();
        
        int row = ((JTable) table).getSelectedRow();
        clicked = (((JTable) table).getModel().getValueAt(row, 0).toString());
        String sql;
//        try {
//        	sql = "SELECT products.product_id as 'Product Id', "
//              		+ "products.location_id as 'Location' , product_category.category as 'Product Category',"
//              		+ "quantity as 'Quantity',price_per_unit as 'Price', expiry_date as 'Expiry Date',products.description as 'Description' "
//              		+ "FROM products, product_category, location "
//              		+ "where "
//              		+ "products.product_category = product_category.productcategory_id and product_id ='"+clicked+"'";
//        	pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//        	if(rs.next()) {
//            	tmpLocation = rs.getString("Location");
//            	tmpPCategory = rs.getString("Product Category");
//            	tmpQuantity = rs.getString("Quantity");
//            	tmpPrice = rs.getString("Price");
//            	tmpExpiryDate = rs.getString("Expiry Date");
//            	description = rs.getString("Description");
//            }
//        }catch(Exception e) {
//        	 JOptionPane.showMessageDialog(null, e.getMessage());
//        }
       
        pane.add(new JLabel("location"));
        pane.add(location);
        
        pane.add(new JLabel("Product Category"));
        pane.add(c_productCategory);
        
        pane.add(new JLabel("Quantity"));
        pane.add(d_Quantity);
        
        pane.add(new JLabel("Price"));
        pane.add(e_Price);
        
        pane.add(new JLabel("Date in"));
        pane.add(dateChooser);
        
        pane.add(new JLabel("Description"));
        pane.add(txtArea);
        
//        try {
//        	date2 = new SimpleDateFormat("yyyy-MM-dd").parse(tmpExpiryDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        location.setText(tmpLocation);
        c_productCategory.setText(tmpPCategory);
        d_Quantity.setText(tmpQuantity);
        e_Price.setText(tmpPrice);
        dateChooser.setDate(date2);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int option = JOptionPane.showConfirmDialog(frame, pane, "Please fill all the fields", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//        if (option == JOptionPane.YES_OPTION) {
//        	      sql = "update products set location_id='"+location.getText()+"',"
//        	      		+ "quantity='"+d_Quantity.getText()+"',"
//        	      				+ "price_per_unit='"+e_Price.getText()+"',"
//        	      						+ "expiry_date='"+df.format(dateChooser.getDate())+"',"
//        	      								+ "description='"+txtArea.getText()+"' where product_id="+clicked;
//        	try {
//        		pst = conn.prepareStatement(sql);
//                pst.execute();
//        	}catch(Exception e) {
//        		JOptionPane.showMessageDialog(null, e.getMessage());
//        	}
//            pane = new JPanel();
//            pane.setLayout((LayoutManager) new BoxLayout(pane, BoxLayout.PAGE_AXIS));
//            System.out.println(clicked);
//            pane.add(new JLabel("Successfully Added"));
//            updateTable(table_1);
//			 updateTable(table_4);
//			 updateReceive(table_5);
//			 selectMenu(table_2);
//			 selectMenu(table_6);
//            clicked= "";
//            JOptionPane.showMessageDialog(frame, pane);
//        }
   }
	void selectSales(JTable table) {
		try {	
			
	        String sql = "SELECT transact_id as 'Transaction', date_in as 'date in' FROM sales_report GROUP BY transact_id";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			((JTable) table).getTableHeader().setReorderingAllowed(false);
            ((JTable) table).setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
      
	}
}
