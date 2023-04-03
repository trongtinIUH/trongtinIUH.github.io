package nghienCuu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class NhanVien extends JFrame {
	private JLabel lblEmployeeID, lblho, lblname, lblage, lblsex, lblsalary;
	private JTextField txtMaNV, txtHo, txtTen, txtTuoi,txtSex, txtSalary, txtSearch;
	private JPanel pnCenter;
	private JRadioButton radNam, radNu;
	private JButton btnSearch, btnAdd, btnClear, btnDelete, btnSave, btnSua; 
	private DefaultTableModel model;
	private JTable table;
	public NhanVien() {
		super("^-^");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createGUI();
		createTable();
	}

	private void createGUI() {
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN ");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		pnNorth.add(lblTitle);
		add(pnNorth, BorderLayout.NORTH);
	
		pnCenter = new JPanel();
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		pnCenter.add(b);
		pnCenter.add(Box.createVerticalStrut(10));
		lblEmployeeID = new JLabel("Mã nhân viên:");
		b1.add(lblEmployeeID);
		b1.add(txtMaNV = new JTextField(20));
		
		lblho = new JLabel("Họ:");
		lblho.setPreferredSize(lblEmployeeID.getPreferredSize());
		b2.add(lblho);
		b2.add(txtHo = new JTextField(20));
		b2.add(lblname = new JLabel("Tên nhân viên:"));
		b2.add(txtTen =  new JTextField(40));
		
		lblage = new JLabel("Tuổi:");
		lblage.setPreferredSize(lblEmployeeID.getPreferredSize());
		b3.add(lblage);
		b3.add(txtTuoi = new JTextField(20));
		b3.add(lblsex = new JLabel("Phái:"));
		radNam = new JRadioButton("Nam", true);
		radNu = new JRadioButton("Nu");
		ButtonGroup grpSex = new ButtonGroup();
		grpSex.add(radNam);
		grpSex.add(radNu);
		b3.add(radNam);
		b3.add(radNu);
		
		lblsalary = new JLabel("Tiền lương:");
		lblsalary.setPreferredSize(lblEmployeeID.getPreferredSize());
		b4.add(lblsalary);
		b4.add(txtSalary = new JTextField(20));
		createTable();
		add(pnCenter, BorderLayout.CENTER);
		
		JSplitPane split;
		add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT), BorderLayout.SOUTH);
		split.setResizeWeight(0.5);
		
		JPanel pnSearch = new JPanel();
		JLabel lblSearch = new JLabel("Nhập mã số cần tìm");
		txtSearch = new JTextField(10);
		btnSearch = new JButton("Tìm");
		pnSearch.add(lblSearch);
		pnSearch.add(btnSearch);
		split.add(pnSearch);
		
		JPanel pnChucNang = new JPanel();
		btnAdd = new JButton("Thêm");
		btnDelete = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnClear = new JButton("Xóa trắng");
		btnSave = new JButton("Lưu");
		pnChucNang.add(btnAdd);
		pnChucNang.add(btnDelete);
		pnChucNang.add(btnSua);
		pnChucNang.add(btnClear);
		pnChucNang.add(btnSave);
		split.add(pnChucNang);
	}
	
	public void createTable() {
		JPanel pnTable = new JPanel();
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phái");
		model.addColumn("Tuổi");
		model.addColumn("Tiền lương");
		TableColumn sexCol = table.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		sexCol.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn col = new TableColumn();
		col.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(650, 250));
		pnCenter.add(sp);
		pnCenter.add(pnTable);
	}
	
	public static void main(String[] args) {
		new NhanVien().setVisible(true);
	}
}
