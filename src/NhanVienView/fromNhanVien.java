package NhanVienView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import LichLamViec.MotNgay;
import dijkstra.algo.Edge;
import dijkstra.algo.PathFinder;
import dijkstra.algo.Vert;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class fromNhanVien extends JFrame {

	private JPanel contentPane;
	ArrayList<NhanVien> dsnv;
	ArrayList<MotNgay> dsl;
	private JTextField txtTim;
	private JTable table;
	private JTable tblThongTin;
	private JTextField txtTen;
	private JTextField txtHo;
	private JTextField txtMaNv;
	private JTextField txtSdt;
	private JTextField txtNgaySinh;
	private JTextField txtMaCv;
	private JTextField txtEmail;
	private JTextField txtLuong;
	private JTextField txtMaQl;
	private JTable tbLich;
	private JTextField txtDay;
	private JTextField txtNV1;
	private JTextField txtQuanT1;
	private JTextField txtTinhTrang1;
	private JTextField txtNV2;
	private JTextField txtQuanT2;
	private JTextField txtTinhTrang2;
	/**
	 * Launch the application.
	 */
	private static class ChayChu extends Thread {
		private StringBuilder sb = new StringBuilder("Quản lý nhân viên                                                                                                                                                                                                                                  ");
		private Object ob;

		public ChayChu(Object ob) {
			this.ob = ob;
		}

		@Override
		public void run() {
			while(ob!=null) {
				sb.insert(0,sb.substring(sb.length()-1));
				sb.delete(sb.length()-1,sb.length());
				if (ob instanceof JFrame)
					((JFrame) ob).setTitle(sb.toString());
				if (ob instanceof JTextField)
					((JTextField) ob).setText(sb.toString());
				if (ob instanceof JButton)
					((JButton) ob).setText(sb.toString());
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fromNhanVien frame = new fromNhanVien();
					ChayChu cc = new ChayChu(frame);
					cc.start();
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
	public fromNhanVien() {
		dsnv = (ArrayList<NhanVien>) NhanVien.getAll();
		dsl = (ArrayList<MotNgay>) MotNgay.getAll();
		//dsl = new ArrayList<>();
		Vert v1 = new Vert("Quận 1");
		Vert v2 = new Vert("Quận 2");
		Vert v3 = new Vert("Quận 3");
		Vert v4 = new Vert("Quận 4");
		Vert v5 = new Vert("Quận 5");
		Vert v6 = new Vert("Quận 6");
		Vert v7 = new Vert("Quận 7");
		Vert v8 = new Vert("Quận 8");
		Vert v9 = new Vert("Quận 9");
		Vert v10 = new Vert("Quận 10");

		v1.addNeighbour(new Edge(3, v1, v5));
		v1.addNeighbour(new Edge(5, v1, v2));
		v1.addNeighbour(new Edge(4, v1, v4));
		v1.addNeighbour(new Edge(7, v1, v3));

		v2.addNeighbour(new Edge(5, v2, v1));
		v2.addNeighbour(new Edge(4, v2, v7));
		v2.addNeighbour(new Edge(6, v2, v9));
		v2.addNeighbour(new Edge(6, v2, v4));

		v3.addNeighbour(new Edge(7, v3, v1));
		v3.addNeighbour(new Edge(4, v3, v10));

		v4.addNeighbour(new Edge(4, v4, v1));
		v4.addNeighbour(new Edge(2, v4, v7));
		v4.addNeighbour(new Edge(6, v4, v2));
		v4.addNeighbour(new Edge(6, v4, v8));
		v4.addNeighbour(new Edge(3, v4, v5));

		v5.addNeighbour(new Edge(3, v5, v1));
		v5.addNeighbour(new Edge(3, v5, v4));
		v5.addNeighbour(new Edge(4, v5, v6));
		v5.addNeighbour(new Edge(8, v5, v8));

		v6.addNeighbour(new Edge(4, v6, v5));
		v6.addNeighbour(new Edge(1, v6, v8));

		v7.addNeighbour(new Edge(4, v7, v2));
		v7.addNeighbour(new Edge(2, v7, v4));
		v7.addNeighbour(new Edge(9, v7, v8));

		v8.addNeighbour(new Edge(6, v8, v4));
		v8.addNeighbour(new Edge(8, v8, v5));
		v8.addNeighbour(new Edge(9, v8, v7));
		v8.addNeighbour(new Edge(1, v8, v6));

		v9.addNeighbour(new Edge(6, v9, v2));

		v10.addNeighbour(new Edge(2, v10, v5));
		v10.addNeighbour(new Edge(4, v10, v3));

		setTitle("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1273, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1239, 693);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Thông tin nhân viên", null, panel, null);
		panel.setLayout(null);

		JLabel lblThngTinNhn = new JLabel("Thông tin nhân viên");
		lblThngTinNhn.setBounds(366, 23, 418, 45);
		lblThngTinNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinNhn.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblThngTinNhn);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 216, 1214, 388);
		panel.add(scrollPane_1);

		tblThongTin = new JTable();
		tblThongTin.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD", "T\u00EAn", "Ng\u00E0y sinh", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "M\u00E3 c\u00F4ng vi\u1EC7c", "L\u01B0\u01A1ng", "M\u00E3 qu\u1EA3n l\u00FD"
				}
				));
		scrollPane_1.setViewportView(tblThongTin);

		JLabel lblNewLabel_9 = new JLabel("Xem thông tin nhân viên tăng dần theo");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 165, 301, 21);
		panel.add(lblNewLabel_9);

		JComboBox cbbSapXepTang = new JComboBox();
		cbbSapXepTang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtmtt = (DefaultTableModel) tblThongTin.getModel();
				dtmtt.setRowCount(0);

				int key = cbbSapXepTang.getSelectedIndex();
				switch (key) {
				case 1: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o1.getManv())  - Integer.parseInt(o2.getManv());
						}
					});
				}
				break;
				case 2: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1 , NhanVien o2) {
							return o1.getTen().compareTo(o2.getTen());
						}
					});
				}
				break;
				case 3: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o1.getNgaysinh())  - Integer.parseInt(o2.getNgaysinh());
						}
					});
				}
				break;
				case 4: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return o1.getMacv().compareTo(o2.getMacv());
						}
					});
				}
				break;
				case 5: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o1.getLuong())  - Integer.parseInt(o2.getLuong());
						}
					});
				}
				break;
				case 6: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return o1.getMaql().compareTo(o2.getMaql());
						}
					});
				}
				break;
				}
				for(NhanVien nv:dsnv)
					dtmtt.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
			}
		});
		cbbSapXepTang.setModel(new DefaultComboBoxModel(new String[] {"Chọn", "Mã nhân viên", "Tên", "Năm sinh", "Mã công việc", "Lương", "Mã quản lý"}));
		cbbSapXepTang.setBounds(287, 167, 110, 21);
		panel.add(cbbSapXepTang);

		JLabel lblNewLabel_9_1 = new JLabel("Xem thông tin nhân viên giảm dần theo");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1.setBounds(837, 165, 301, 21);
		panel.add(lblNewLabel_9_1);

		JComboBox cbbSapXepGiam = new JComboBox();
		cbbSapXepGiam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtmtt = (DefaultTableModel) tblThongTin.getModel();
				dtmtt.setRowCount(0);
				int key = cbbSapXepTang.getSelectedIndex();
				switch (key) {
				case 1: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o2.getManv())  - Integer.parseInt(o1.getManv());
						}
					});
				}
				break;
				case 2: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return o2.getTen().compareTo(o1.getTen());
						}
					});
				}
				break;
				case 3: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o2.getNgaysinh())  - Integer.parseInt(o1.getNgaysinh());
						}
					});
				}
				break;
				case 4: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return o2.getMacv().compareTo(o1.getMacv());
						}
					});
				}
				break;
				case 5: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o2.getLuong())  - Integer.parseInt(o1.getLuong());
						}
					});
				}
				break;
				case 6: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return o2.getMaql().compareTo(o1.getMaql());
						}
					});
				}
				break;
				}
				for(NhanVien nv:dsnv)
					dtmtt.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
			}
		});
		cbbSapXepGiam.setModel(new DefaultComboBoxModel(new String[] {"Chọn", "Mã nhân viên", "Tên", "Năm sinh", "Mã công việc", "Lương", "Mã quản lý"}));
		cbbSapXepGiam.setBounds(1114, 167, 110, 21);
		panel.add(cbbSapXepGiam);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Chức năng", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tìm theo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 86, 72, 13);
		panel_2.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã nhân viên", "Tên", "Năm sinh", "Mã công việc", "Lương", "Mã quản lý"}));
		comboBox.setBounds(77, 84, 120, 21);
		panel_2.add(comboBox);

		txtTim = new JTextField();
		txtTim.setBounds(207, 85, 120, 19);
		panel_2.add(txtTim);
		txtTim.setColumns(10);

		JButton btnTim = new JButton("Xem");
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);	

				String tim = txtTim.getText();
				int x = comboBox.getSelectedIndex();
				switch (x) {
				case 0: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o1.getManv())  - Integer.parseInt(o2.getManv());
						}
					});

					NhanVien nm = new NhanVien();
					int n = dsnv.size();
					int result = nm.binarySearch(dsnv, 0, n-1, tim);
					if (result != -1) {
						dtm.addRow(new String[] {dsnv.get(result).getManv(), dsnv.get(result).getHo(), dsnv.get(result).getTen(),dsnv.get(result).getNgaysinh(),
								dsnv.get(result).getEmail(), dsnv.get(result).getSdt(), dsnv.get(result).getMacv(),dsnv.get(result).getLuong(), dsnv.get(result).getMaql()});
					}	
					break;
				}
				case 1: // Tìm kiếm tuần tự theo tên
				{ 
					for(NhanVien nv:dsnv)
						if(nv.getTen().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}	
					break;
				}
				case 2: //Tìm kiếm tuần tự theo năm sinh
				{
					for(NhanVien nv:dsnv)
						if(nv.getNgaysinh().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}	
					break;
				}
				case 3: //Tìm kiếm tuần tự theo mã công việc
				{
					for(NhanVien nv:dsnv)
						if(nv.getMacv().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}		
					break;
				}
				case 4: //Tìm kiếm tuần tự theo lương
				{
					for(NhanVien nv:dsnv)
						if(nv.getLuong().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}	
					break;
				}
				case 5: //Tìm kiếm tuần tự theo mã quản lý
				{
					for(NhanVien nv:dsnv)
						if(nv.getMaql().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}		
					break;
				}
				}
			}
		});
		btnTim.setBounds(337, 84, 85, 21);
		panel_2.add(btnTim);

		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(473, 21, 80, 23);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("Năm sinh");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(473, 86, 80, 13);
		panel_2.add(lblNewLabel_3_1);

		JLabel lblNewLabel_6_1 = new JLabel("Mã công việc");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(473, 141, 80, 13);
		panel_2.add(lblNewLabel_6_1);

		JLabel lblNewLabel_2_1 = new JLabel("Họ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(776, 18, 52, 29);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_10_1 = new JLabel("Tên");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10_1.setBounds(991, 26, 45, 13);
		panel_2.add(lblNewLabel_10_1);

		JLabel lblNewLabel_4_1 = new JLabel("Email");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(776, 86, 45, 13);
		panel_2.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("Số điện thoại");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(991, 81, 103, 23);
		panel_2.add(lblNewLabel_5_1);

		JLabel lblNewLabel_7_1 = new JLabel("Lương");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7_1.setBounds(776, 136, 45, 23);
		panel_2.add(lblNewLabel_7_1);

		JLabel lblNewLabel_8_1 = new JLabel("Mã quản lý");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8_1.setBounds(991, 136, 80, 23);
		panel_2.add(lblNewLabel_8_1);

		txtTen = new JTextField();
		txtTen.setBounds(1104, 23, 120, 19);
		panel_2.add(txtTen);
		txtTen.setColumns(10);

		txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(838, 23, 120, 19);
		panel_2.add(txtHo);

		txtMaNv = new JTextField();
		txtMaNv.setColumns(10);
		txtMaNv.setBounds(588, 23, 120, 19);
		panel_2.add(txtMaNv);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(1104, 83, 120, 19);
		panel_2.add(txtSdt);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(588, 83, 120, 19);
		panel_2.add(txtNgaySinh);

		txtMaCv = new JTextField();
		txtMaCv.setColumns(10);
		txtMaCv.setBounds(588, 138, 120, 19);
		panel_2.add(txtMaCv);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(838, 83, 120, 19);
		panel_2.add(txtEmail);

		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(838, 138, 120, 19);
		panel_2.add(txtLuong);

		txtMaQl = new JTextField();
		txtMaQl.setColumns(10);
		txtMaQl.setBounds(1104, 138, 120, 19);
		panel_2.add(txtMaQl);

		JButton btnThem = new JButton("Thêm nhân viên");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String manv, ho, ten, email, sdt, macv, luong, maql;
				String ngaysinh;

				manv = txtMaNv.getText();
				ho = txtHo.getText();
				ten = txtTen.getText();
				ngaysinh = txtNgaySinh.getText();
				email = txtEmail.getText();
				sdt = txtSdt.getText();
				macv = txtMaCv.getText();
				luong = txtLuong.getText();
				maql = txtMaQl.getText();

				if(manv.isBlank() || ho.isBlank() || ten.isBlank() || ngaysinh.isBlank() || email.isBlank() || sdt.isBlank() || macv.isBlank() || luong.isBlank() || maql.isBlank()) {
					JOptionPane.showMessageDialog(rootPane, "Hãy nhập thông tin nhân viên đầy đủ!");
					txtMaNv.grabFocus();
					return;	
				} 

				for (int i = 0; i < dsnv.size(); i++) {
					if(manv.equals(dsnv.get(i).getManv())){
						JOptionPane.showMessageDialog(rootPane, "Mã nhân viên bị trùng!");
						return;
					}
				}

				for (int i = 0; i < dsnv.size(); i++) {
					if(email.equals(dsnv.get(i).getEmail())){
						JOptionPane.showMessageDialog(rootPane, "Email bị trùng!");
						return;
					}
				}

				for (int i = 0; i < dsnv.size(); i++) {
					if(sdt.equals(dsnv.get(i).getSdt())){
						JOptionPane.showMessageDialog(rootPane, "Số điện thoại bị trùng!");
						return;
					}
				}

				Pattern pattern = Pattern.compile("\\d*");
				Matcher matchermnv = pattern.matcher(manv);
				Matcher matcherns = pattern.matcher(ngaysinh);
				Matcher matchersdt = pattern.matcher(sdt);
				Matcher matcherluong = pattern.matcher(luong);
				Matcher matchermql = pattern.matcher(maql);
				if (!matchermnv.matches()){
					JOptionPane.showMessageDialog(rootPane, "Mã nhân viên chỉ nhận số!");
					return;
				}

				if (!matcherns.matches()) {
					JOptionPane.showMessageDialog(rootPane, "Năm sinh chỉ nhận số!");
					return;
				}

				if (!matchersdt.matches()) {
					JOptionPane.showMessageDialog(rootPane, "Số điện thoại chỉ nhận số!");
					return;
				}

				if (sdt.length() > 11 || sdt.length() < 10) {
					JOptionPane.showMessageDialog(rootPane, "Số điện thoại chỉ nhận 10 - 11 số!");
					return;
				}

				if (!matcherluong.matches()) {
					JOptionPane.showMessageDialog(rootPane, "Lương chỉ nhận số!");
					return;
				}

				if (!matchermql.matches()) {
					JOptionPane.showMessageDialog(rootPane, "Mã quản lý chỉ nhận số!");
					return;
				}

				Pattern pattern2 = Pattern.compile(".*\\d.*");
				Matcher matcherho = pattern2.matcher(ho);
				Matcher matcherten = pattern2.matcher(ten);

				if (matcherho.matches()){
					JOptionPane.showMessageDialog(rootPane,"Họ nhân viên không nhận số!");
					return;
				}

				if (matcherten.matches()){
					JOptionPane.showMessageDialog(rootPane,"Tên nhân viên không nhận số!");
					return;
				}

				NhanVien nv = new NhanVien(manv, ho, ten, ngaysinh, email,sdt,macv,luong,maql);
				dsnv.add(nv);
				NhanVien.updateData(dsnv);
				JOptionPane.showMessageDialog(rootPane, "Thêm sinh viên thành công!");

			}
		});
		btnThem.setBounds(588, 188, 153, 21);
		panel_2.add(btnThem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 1214, 426);
		panel_2.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();

				txtMaNv.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 0)));
				txtHo.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 1)));
				txtTen.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 2)));
				txtNgaySinh.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 3)));
				txtEmail.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 4)));
				txtSdt.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 5)));
				txtMaCv.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 6)));
				txtLuong.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 7)));
				txtMaQl.setText(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 8)));
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD ", "T\u00EAn", "Ng\u00E0y sinh", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "M\u00E3 c\u00F4ng vi\u1EC7c", "L\u01B0\u01A1ng", "M\u00E3 qu\u1EA3n l\u00FD"
				}
				));
		scrollPane.setViewportView(table);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();

				// Ghi lại thông tin của liên hệ sau khi người dùng cập nhật
				for (int i = 0; i < dsnv.size(); i++) {
					if (dsnv.get(i).getManv().equals(txtMaNv.getText())) {
						dsnv.get(i).setHo(txtHo.getText());
						dsnv.get(i).setTen(txtTen.getText());
						dsnv.get(i).setNgaysinh(txtNgaySinh.getText());
						dsnv.get(i).setEmail(txtEmail.getText());
						dsnv.get(i).setSdt(txtSdt.getText());
						dsnv.get(i).setMacv(txtMaCv.getText());
						dsnv.get(i).setLuong(txtLuong.getText());
						dsnv.get(i).setMaql(txtMaQl.getText());
					}
				}

				NhanVien.updateData(dsnv);

				// hiển thị lại nội dung đã cập nhật lên dòng trên table
				dtm.setValueAt(txtMaNv.getText(), table.getSelectedRow(), 0);
				dtm.setValueAt(txtHo.getText(), table.getSelectedRow(), 1);
				dtm.setValueAt(txtTen.getText(), table.getSelectedRow(), 2);
				dtm.setValueAt(txtNgaySinh.getText(), table.getSelectedRow(), 3);
				dtm.setValueAt(txtEmail.getText(), table.getSelectedRow(), 4);
				dtm.setValueAt(txtSdt.getText(), table.getSelectedRow(), 5);
				dtm.setValueAt(txtMaCv.getText(), table.getSelectedRow(), 6);
				dtm.setValueAt(txtLuong.getText(), table.getSelectedRow(), 7);
				dtm.setValueAt(txtMaQl.getText(), table.getSelectedRow(), 8);
			}
		});
		btnCapNhat.setBounds(776, 188, 112, 21);
		panel_2.add(btnCapNhat);

		JButton btnReSet = new JButton("Reset");
		btnReSet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaNv.setText("");
				txtHo.setText("");
				txtTen.setText("");
				txtNgaySinh.setText("");
				txtEmail.setText("");
				txtSdt.setText("");
				txtMaCv.setText("");
				txtLuong.setText("");
				txtMaQl.setText("");
			}
		});
		btnReSet.setBounds(1041, 188, 85, 21);
		panel_2.add(btnReSet);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				// Xác nhận thông tin xóa, nếu chọn đồng ý xóa
				int reply = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa nhân viên " + txtMaNv.getText() + " - " + txtHo.getText() + " " + txtTen.getText() + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					for (int i = 0; i < dsnv.size(); i++) {
						if (dsnv.get(i).getManv().equals(txtMaNv.getText())) {
							dsnv.remove(i);
						}
					}
					NhanVien.updateData(dsnv);
					// xóa dòng đã chọn trên table
					dtm.removeRow(table.getSelectedRow());
					// xóa nội dung trên các điều khiển để người dùng tiếp tục thao tác
					txtMaNv.setText("");
					txtHo.setText("");
					txtTen.setText("");
					txtNgaySinh.setText("");
					txtEmail.setText("");
					txtSdt.setText("");
					txtMaCv.setText("");
					txtLuong.setText("");
					txtMaQl.setText("");
				}
			}
		});
		btnXoa.setBounds(924, 188, 85, 21);
		panel_2.add(btnXoa);

		JLabel lblNewLabel_1 = new JLabel("Tìm nhân viên có lương");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 131, 168, 29);
		panel_2.add(lblNewLabel_1);

		JComboBox cbxLuong = new JComboBox();
		cbxLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbxLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				int x = cbxLuong.getSelectedIndex();
				switch (x) {
				case 1: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o2.getLuong())  - Integer.parseInt(o1.getLuong());
						}
					});

					for(NhanVien nv:dsnv)
						if(nv.getLuong().equals(dsnv.get(0).getLuong())) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}	
					break;
				}
				case 2: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o1.getLuong())  - Integer.parseInt(o2.getLuong());
						}
					});

					for(NhanVien nv:dsnv)
						if(nv.getLuong().equals(dsnv.get(0).getLuong())) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}	
					break;
				}
				}
			}
		});
		cbxLuong.setModel(new DefaultComboBoxModel(new String[] {"Chọn", "Cao nhất", "Thấp nhất"}));
		cbxLuong.setBounds(197, 137, 111, 21);
		panel_2.add(cbxLuong);

		JLabel lblNewLabel_1_2 = new JLabel("Tìm nhân viên có tuổi");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 180, 168, 29);
		panel_2.add(lblNewLabel_1_2);

		JComboBox cbxTuoi = new JComboBox();
		cbxTuoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbxTuoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);	
				int x = cbxTuoi.getSelectedIndex();
				switch (x) {
				case 1: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o1.getNgaysinh())  - Integer.parseInt(o2.getNgaysinh());
						}
					});

					for(NhanVien nv:dsnv)
						if(nv.getNgaysinh().equals(dsnv.get(0).getNgaysinh())) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}
						else
							break;
					break;
				}
				case 2: {
					Collections.sort(dsnv, new Comparator<NhanVien>() {
						@Override
						public int compare(NhanVien o1, NhanVien o2) {
							return Integer.parseInt(o2.getNgaysinh())  - Integer.parseInt(o1.getNgaysinh());
						}
					});

					for(NhanVien nv:dsnv)
						if(nv.getNgaysinh().equals(dsnv.get(0).getNgaysinh())) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}
						else
							break;
					break;
				}
				}
			}
		});
		cbxTuoi.setModel(new DefaultComboBoxModel(new String[] {"Chọn", "Lớn nhất", "Nhỏ nhất"}));
		cbxTuoi.setBounds(197, 188, 111, 21);
		panel_2.add(cbxTuoi);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Lịch làm việc", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 166, 787, 490);
		panel_1.add(scrollPane_2);

		tbLich = new JTable();
		tbLich.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modellich = (DefaultTableModel) tbLich.getModel();

				txtDay.setText(String.valueOf(modellich.getValueAt(tbLich.getSelectedRow(), 0)));
				txtNV1.setText(String.valueOf(modellich.getValueAt(tbLich.getSelectedRow(), 1)));
				txtQuanT1.setText(String.valueOf(modellich.getValueAt(tbLich.getSelectedRow(), 2)));
				txtTinhTrang1.setText(String.valueOf(modellich.getValueAt(tbLich.getSelectedRow(), 3)));
				txtNV2.setText(String.valueOf(modellich.getValueAt(tbLich.getSelectedRow(), 4)));
				txtQuanT2.setText(String.valueOf(modellich.getValueAt(tbLich.getSelectedRow(), 5)));
				txtTinhTrang2.setText(String.valueOf(modellich.getValueAt(tbLich.getSelectedRow(), 6)));
			}
		});
		scrollPane_2.setViewportView(tbLich);
		tbLich.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Th\u00E1ng/ng\u00E0y/n\u0103m", "Bu\u1ED5i s\u00E1ng", "Qu\u1EADn", "T\u00ECnh tr\u1EA1ng", "Bu\u1ED5i chi\u1EC1u", "Qu\u1EADn ", "T\u00ECnh tr\u1EA1ng"
			}
		));
		tbLich.getColumnModel().getColumn(0).setPreferredWidth(95);

		JLabel lblNewLabel_2 = new JLabel("Lịch làm việc");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(299, 21, 566, 70);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tìm đường từ công ty (quận 1) đến");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 117, 236, 28);
		panel_1.add(lblNewLabel_3);

		JComboBox cbbDiemDen = new JComboBox();
		cbbDiemDen.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbbDiemDen.setModel(new DefaultComboBoxModel(new String[] {"Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9", "Quận 10"}));
		cbbDiemDen.setBounds(256, 122, 88, 21);
		panel_1.add(cbbDiemDen);

		JButton btnTimDuong = new JButton("Tìm đường");
		btnTimDuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimDuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PathFinder shortestPath = new PathFinder();
				shortestPath.ShortestP(v1);
				int d = cbbDiemDen.getSelectedIndex();
				switch(d) {
				case 0:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v1) + "\nKhoảng cách tối thiểu: " + v1.getDist() + " km");
					break;
				}
				case 1:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v2) + "\nKhoảng cách tối thiểu: " + v2.getDist() + " km");
					break;
				}
				case 2:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v3) + "\nKhoảng cách tối thiểu: " + v3.getDist() + " km");
					break;
				}
				case 3:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v4) + "\nKhoảng cách tối thiểu: " + v4.getDist() + " km");
					break;
				}
				case 4:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v5) + "\nKhoảng cách tối thiểu: " + v5.getDist() + " km");
					break;
				}
				case 5:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v6) + "\nKhoảng cách tối thiểu: " + v6.getDist() + " km");
					break;
				}
				case 6:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v7) + "\nKhoảng cách tối thiểu: " + v7.getDist() + " km");
					break;
				}
				case 7:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v8) + "\nKhoảng cách tối thiểu: " + v8.getDist() + " km");
					break;
				}
				case 8:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v9) + "\nKhoảng cách tối thiểu: " + v9.getDist() + " km");
					break;
				}
				case 9:{
					JOptionPane.showMessageDialog(rootPane, "Đường đi ngắn nhất: " + shortestPath.getShortestP(v10) + "\nKhoảng cách tối thiểu: " + v10.getDist() + " km");
					break;
				}
				}
			}
		});
		btnTimDuong.setBounds(354, 122, 106, 21);
		panel_1.add(btnTimDuong);

		JLabel lblNewLabel_5 = new JLabel("Tháng/ngày/năm");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(807, 166, 111, 20);
		panel_1.add(lblNewLabel_5);

		txtDay = new JTextField();
		txtDay.setBounds(928, 166, 165, 19);
		panel_1.add(txtDay);
		txtDay.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Buổi sáng");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(807, 215, 111, 21);
		panel_1.add(lblNewLabel_6);

		txtNV1 = new JTextField();
		txtNV1.setToolTipText("Nhập mã nhân viên\r\n");
		txtNV1.setBounds(928, 216, 165, 19);
		panel_1.add(txtNV1);
		txtNV1.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Quận");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(807, 268, 111, 13);
		panel_1.add(lblNewLabel_7);

		txtQuanT1 = new JTextField();
		txtQuanT1.setToolTipText("Điền số từ 1-10 (Quận 1 - Quận 10)");
		txtQuanT1.setBounds(928, 265, 165, 19);
		panel_1.add(txtQuanT1);
		txtQuanT1.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Tình trạng");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(807, 309, 111, 13);
		panel_1.add(lblNewLabel_8);

		JLabel lblNewLabel_10 = new JLabel("Buổi chiều");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(807, 352, 111, 13);
		panel_1.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Quận");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(807, 404, 111, 13);
		panel_1.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Tình trạng");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(807, 457, 111, 13);
		panel_1.add(lblNewLabel_12);

		txtTinhTrang1 = new JTextField();
		txtTinhTrang1.setBounds(928, 306, 165, 19);
		panel_1.add(txtTinhTrang1);
		txtTinhTrang1.setColumns(10);

		txtNV2 = new JTextField();
		txtNV2.setToolTipText("Nhập mã nhân viên");
		txtNV2.setColumns(10);
		txtNV2.setBounds(928, 352, 165, 19);
		panel_1.add(txtNV2);

		txtQuanT2 = new JTextField();
		txtQuanT2.setToolTipText("Điền số từ 1-10 (Quận 1 - Quận 10)");
		txtQuanT2.setColumns(10);
		txtQuanT2.setBounds(928, 401, 165, 19);
		panel_1.add(txtQuanT2);

		txtTinhTrang2 = new JTextField();
		txtTinhTrang2.setColumns(10);
		txtTinhTrang2.setBounds(928, 454, 165, 19);
		panel_1.add(txtTinhTrang2);

		JButton btnThemLich = new JButton("Thêm");
		btnThemLich.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemLich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tbLich.getModel();
				String day, nv1, q1,tt1, nv2,q2,tt2;

				nv1 = txtNV1.getText();
				q1 = txtQuanT1.getText();
				tt1 = txtTinhTrang1.getText();
				nv2 = txtNV2.getText();
				q2 = txtQuanT2.getText();
				tt2 = txtTinhTrang2.getText();
				day = txtDay.getText();

				if(nv1.isBlank() || q1.isBlank() || tt1.isBlank() || nv2.isBlank() || q2.isBlank() || tt2.isBlank() || day.isBlank())
				{
					JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ các dữ liệu!");
					txtDay.grabFocus();
					return;
				}
				
				if(!(day.matches("(0[1-9]|[12])\\/(0?[1-9]|[12]\\d|3[01])\\/(\\d{2}|\\d{4})\\b"))) {
					JOptionPane.showMessageDialog(rootPane, "Nhập tháng/ngày/năm theo cấu trúc (MM/dd/yyyy) (01/29/2021)");
					return;
				}
				
				if(!(q1.matches("[1-9]0?")) || !(q2.matches("[1-9]0?"))) {
					JOptionPane.showMessageDialog(rootPane, "Quận nhập số từ 1 - 10 (Quận 1 - Quận 10)");
					return;
				}

				if(!(tt1.contains("Trống")) && !(tt1.contains("Hoàn thành")) && !(tt1.contains("Chưa hoàn thành")) || !(tt2.contains("Trống")) && !(tt2.contains("Hoàn thành")) & !(tt2.contains("Chưa hoàn thành"))) {
					JOptionPane.showMessageDialog(rootPane, "Nhập tình trạng một trong (Trống, Hoàn thành, Chưa hoàn thành)");
					return;
				}
				
				int check1 = 0, check2 = 0;
				for (NhanVien nv:dsnv) {
					if(nv.getManv().contains(nv1)) {
						check1++;
					}
					if(nv.getManv().contains(nv2)) {
						check2++;
					}
				}
				
				if(check1 == 0 || check2 == 0) {
					JOptionPane.showMessageDialog(rootPane, "Mã số nhân viên không tồn tại");
					return;
				}
				
				
				MotNgay lich = new MotNgay(day,nv1, q1, tt1, nv2, q2,tt1);
				dsl.add(lich);
				MotNgay.updateData(dsl);
				model.addRow(new Object[] {lich.getDay(),lich.getNv1(),lich.getQt1(),lich.getTt1(),lich.getNv2(),lich.getQt2(), lich.getTt2()}); 
				JOptionPane.showMessageDialog(rootPane, "Thêm lịch thành công!");
			}
		});
		btnThemLich.setBounds(962, 507, 85, 21);
		panel_1.add(btnThemLich);
		
		JButton btnXemLich = new JButton("Xem lịch làm việc");
		btnXemLich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modellich = (DefaultTableModel) tbLich.getModel();
				modellich.setRowCount(0);
				Collections.sort(dsl, new Comparator<MotNgay>() {
					@Override
					public int compare(MotNgay l1, MotNgay l2) {
						return l1.getDay().compareTo(l2.getDay());
					}
				});
				for (MotNgay l:dsl) {
					modellich.addRow(new Object[] {l.getDay(),l.getNv1(), l.getQt1(), l.getTt1(),l.getNv2(), l.getQt2(), l.getTt2()});
				}
			}
		});
		btnXemLich.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXemLich.setBounds(644, 123, 153, 21);
		panel_1.add(btnXemLich);
		
		JButton btnCapNhatLich = new JButton("Cập nhật");
		btnCapNhatLich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modellich = (DefaultTableModel) tbLich.getModel();

				// Ghi lại thông tin của liên hệ sau khi người dùng cập nhật
				for (int i = 0; i <  dsl.size(); i++) {
					if (dsl.get(i).getDay().equals(txtDay.getText())) {
						dsl.get(i).setNv1(txtNV1.getText());
						dsl.get(i).setQt1(txtQuanT1.getText());
						dsl.get(i).setTt1(txtTinhTrang1.getText());
						dsl.get(i).setNv2(txtNV2.getText());
						dsl.get(i).setQt2(txtQuanT2.getText());
						dsl.get(i).setTt2(txtTinhTrang2.getText());
					}
				}

				MotNgay.updateData(dsl);

				// hiển thị lại nội dung đã cập nhật lên dòng trên table
				modellich.setValueAt(txtDay.getText(), tbLich.getSelectedRow(), 0);
				modellich.setValueAt(txtNV1.getText(), tbLich.getSelectedRow(), 1);
				modellich.setValueAt(txtQuanT1.getText(), tbLich.getSelectedRow(), 2);
				modellich.setValueAt(txtTinhTrang1.getText(), tbLich.getSelectedRow(), 3);
				modellich.setValueAt(txtNV2.getText(), tbLich.getSelectedRow(), 4);
				modellich.setValueAt(txtQuanT2.getText(), tbLich.getSelectedRow(), 5);
				modellich.setValueAt(txtTinhTrang2.getText(), tbLich.getSelectedRow(), 6);
			}
		});
		btnCapNhatLich.setBounds(833, 544, 85, 21);
		panel_1.add(btnCapNhatLich);
		
		JButton btnXoaLich = new JButton("Xóa");
		btnXoaLich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modellich = (DefaultTableModel) tbLich.getModel();
				// Xác nhận thông tin xóa, nếu chọn đồng ý xóa
				int reply = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn ngày " + txtDay.getText() + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					for (int i = 0; i <  dsl.size(); i++) {
						if (dsl.get(i).getDay().equals(txtDay.getText())) {
							dsl.remove(i);
						}
					}
					MotNgay.updateData(dsl);
					// xóa dòng đã chọn trên table
					modellich.removeRow(tbLich.getSelectedRow());
					// xóa nội dung trên các điều khiển để người dùng tiếp tục thao tác
					txtNV1.setText("");
					txtQuanT1.setText("");
					txtTinhTrang1.setText("");
					txtNV2.setText("");
					txtQuanT2.setText("");
					txtTinhTrang2.setText("");
					txtDay.setText("");
				}
			}
		});
		btnXoaLich.setBounds(962, 544, 85, 21);
		panel_1.add(btnXoaLich);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNV1.setText("");
				txtQuanT1.setText("");
				txtTinhTrang1.setText("");
				txtNV2.setText("");
				txtQuanT2.setText("");
				txtTinhTrang2.setText("");
				txtDay.setText("");
			}
		});
		btnXoaTrang.setBounds(1073, 544, 106, 21);
		panel_1.add(btnXoaTrang);
	}
}
