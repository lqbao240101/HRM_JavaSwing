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
		private StringBuilder sb = new StringBuilder("Qu???n l?? nh??n vi??n                                                                                                                                                                                                                                  ");
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
		Vert v1 = new Vert("Qu???n 1");
		Vert v2 = new Vert("Qu???n 2");
		Vert v3 = new Vert("Qu???n 3");
		Vert v4 = new Vert("Qu???n 4");
		Vert v5 = new Vert("Qu???n 5");
		Vert v6 = new Vert("Qu???n 6");
		Vert v7 = new Vert("Qu???n 7");
		Vert v8 = new Vert("Qu???n 8");
		Vert v9 = new Vert("Qu???n 9");
		Vert v10 = new Vert("Qu???n 10");

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
		tabbedPane.addTab("Th??ng tin nh??n vi??n", null, panel, null);
		panel.setLayout(null);

		JLabel lblThngTinNhn = new JLabel("Th??ng tin nh??n vi??n");
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

		JLabel lblNewLabel_9 = new JLabel("Xem th??ng tin nh??n vi??n t??ng d???n theo");
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
		cbbSapXepTang.setModel(new DefaultComboBoxModel(new String[] {"Ch???n", "M?? nh??n vi??n", "T??n", "N??m sinh", "M?? c??ng vi???c", "L????ng", "M?? qu???n l??"}));
		cbbSapXepTang.setBounds(287, 167, 110, 21);
		panel.add(cbbSapXepTang);

		JLabel lblNewLabel_9_1 = new JLabel("Xem th??ng tin nh??n vi??n gi???m d???n theo");
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
		cbbSapXepGiam.setModel(new DefaultComboBoxModel(new String[] {"Ch???n", "M?? nh??n vi??n", "T??n", "N??m sinh", "M?? c??ng vi???c", "L????ng", "M?? qu???n l??"}));
		cbbSapXepGiam.setBounds(1114, 167, 110, 21);
		panel.add(cbbSapXepGiam);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ch???c n??ng", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("T??m theo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 86, 72, 13);
		panel_2.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M?? nh??n vi??n", "T??n", "N??m sinh", "M?? c??ng vi???c", "L????ng", "M?? qu???n l??"}));
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
				case 1: // T??m ki???m tu???n t??? theo t??n
				{ 
					for(NhanVien nv:dsnv)
						if(nv.getTen().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}	
					break;
				}
				case 2: //T??m ki???m tu???n t??? theo n??m sinh
				{
					for(NhanVien nv:dsnv)
						if(nv.getNgaysinh().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}	
					break;
				}
				case 3: //T??m ki???m tu???n t??? theo m?? c??ng vi???c
				{
					for(NhanVien nv:dsnv)
						if(nv.getMacv().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}		
					break;
				}
				case 4: //T??m ki???m tu???n t??? theo l????ng
				{
					for(NhanVien nv:dsnv)
						if(nv.getLuong().contains(tim)) {
							dtm.addRow(new String[] {nv.getManv(), nv.getHo(), nv.getTen(), nv.getNgaysinh(), nv.getEmail(), nv.getSdt(), nv.getMacv(), nv.getLuong(), nv.getMaql()});
						}	
					break;
				}
				case 5: //T??m ki???m tu???n t??? theo m?? qu???n l??
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

		JLabel lblNewLabel_1_1 = new JLabel("M?? nh??n vi??n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(473, 21, 80, 23);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("N??m sinh");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(473, 86, 80, 13);
		panel_2.add(lblNewLabel_3_1);

		JLabel lblNewLabel_6_1 = new JLabel("M?? c??ng vi???c");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(473, 141, 80, 13);
		panel_2.add(lblNewLabel_6_1);

		JLabel lblNewLabel_2_1 = new JLabel("H???");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(776, 18, 52, 29);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_10_1 = new JLabel("T??n");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10_1.setBounds(991, 26, 45, 13);
		panel_2.add(lblNewLabel_10_1);

		JLabel lblNewLabel_4_1 = new JLabel("Email");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(776, 86, 45, 13);
		panel_2.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("S??? ??i???n tho???i");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(991, 81, 103, 23);
		panel_2.add(lblNewLabel_5_1);

		JLabel lblNewLabel_7_1 = new JLabel("L????ng");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7_1.setBounds(776, 136, 45, 23);
		panel_2.add(lblNewLabel_7_1);

		JLabel lblNewLabel_8_1 = new JLabel("M?? qu???n l??");
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

		JButton btnThem = new JButton("Th??m nh??n vi??n");
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
					JOptionPane.showMessageDialog(rootPane, "H??y nh???p th??ng tin nh??n vi??n ?????y ?????!");
					txtMaNv.grabFocus();
					return;	
				} 

				for (int i = 0; i < dsnv.size(); i++) {
					if(manv.equals(dsnv.get(i).getManv())){
						JOptionPane.showMessageDialog(rootPane, "M?? nh??n vi??n b??? tr??ng!");
						return;
					}
				}

				for (int i = 0; i < dsnv.size(); i++) {
					if(email.equals(dsnv.get(i).getEmail())){
						JOptionPane.showMessageDialog(rootPane, "Email b??? tr??ng!");
						return;
					}
				}

				for (int i = 0; i < dsnv.size(); i++) {
					if(sdt.equals(dsnv.get(i).getSdt())){
						JOptionPane.showMessageDialog(rootPane, "S??? ??i???n tho???i b??? tr??ng!");
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
					JOptionPane.showMessageDialog(rootPane, "M?? nh??n vi??n ch??? nh???n s???!");
					return;
				}

				if (!matcherns.matches()) {
					JOptionPane.showMessageDialog(rootPane, "N??m sinh ch??? nh???n s???!");
					return;
				}

				if (!matchersdt.matches()) {
					JOptionPane.showMessageDialog(rootPane, "S??? ??i???n tho???i ch??? nh???n s???!");
					return;
				}

				if (sdt.length() > 11 || sdt.length() < 10) {
					JOptionPane.showMessageDialog(rootPane, "S??? ??i???n tho???i ch??? nh???n 10 - 11 s???!");
					return;
				}

				if (!matcherluong.matches()) {
					JOptionPane.showMessageDialog(rootPane, "L????ng ch??? nh???n s???!");
					return;
				}

				if (!matchermql.matches()) {
					JOptionPane.showMessageDialog(rootPane, "M?? qu???n l?? ch??? nh???n s???!");
					return;
				}

				Pattern pattern2 = Pattern.compile(".*\\d.*");
				Matcher matcherho = pattern2.matcher(ho);
				Matcher matcherten = pattern2.matcher(ten);

				if (matcherho.matches()){
					JOptionPane.showMessageDialog(rootPane,"H??? nh??n vi??n kh??ng nh???n s???!");
					return;
				}

				if (matcherten.matches()){
					JOptionPane.showMessageDialog(rootPane,"T??n nh??n vi??n kh??ng nh???n s???!");
					return;
				}

				NhanVien nv = new NhanVien(manv, ho, ten, ngaysinh, email,sdt,macv,luong,maql);
				dsnv.add(nv);
				NhanVien.updateData(dsnv);
				JOptionPane.showMessageDialog(rootPane, "Th??m sinh vi??n th??nh c??ng!");

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

		JButton btnCapNhat = new JButton("C???p nh???t");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();

				// Ghi l???i th??ng tin c???a li??n h??? sau khi ng?????i d??ng c???p nh???t
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

				// hi???n th??? l???i n???i dung ???? c???p nh???t l??n d??ng tr??n table
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

		JButton btnXoa = new JButton("X??a");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				// X??c nh???n th??ng tin x??a, n???u ch???n ?????ng ?? x??a
				int reply = JOptionPane.showConfirmDialog(rootPane, "B???n c?? mu???n x??a nh??n vi??n " + txtMaNv.getText() + " - " + txtHo.getText() + " " + txtTen.getText() + "?", "X??c nh???n", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					for (int i = 0; i < dsnv.size(); i++) {
						if (dsnv.get(i).getManv().equals(txtMaNv.getText())) {
							dsnv.remove(i);
						}
					}
					NhanVien.updateData(dsnv);
					// x??a d??ng ???? ch???n tr??n table
					dtm.removeRow(table.getSelectedRow());
					// x??a n???i dung tr??n c??c ??i???u khi???n ????? ng?????i d??ng ti???p t???c thao t??c
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

		JLabel lblNewLabel_1 = new JLabel("T??m nh??n vi??n c?? l????ng");
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
		cbxLuong.setModel(new DefaultComboBoxModel(new String[] {"Ch???n", "Cao nh???t", "Th???p nh???t"}));
		cbxLuong.setBounds(197, 137, 111, 21);
		panel_2.add(cbxLuong);

		JLabel lblNewLabel_1_2 = new JLabel("T??m nh??n vi??n c?? tu???i");
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
		cbxTuoi.setModel(new DefaultComboBoxModel(new String[] {"Ch???n", "L???n nh???t", "Nh??? nh???t"}));
		cbxTuoi.setBounds(197, 188, 111, 21);
		panel_2.add(cbxTuoi);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("L???ch l??m vi???c", null, panel_1, null);
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

		JLabel lblNewLabel_2 = new JLabel("L???ch l??m vi???c");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(299, 21, 566, 70);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("T??m ???????ng t??? c??ng ty (qu???n 1) ?????n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 117, 236, 28);
		panel_1.add(lblNewLabel_3);

		JComboBox cbbDiemDen = new JComboBox();
		cbbDiemDen.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbbDiemDen.setModel(new DefaultComboBoxModel(new String[] {"Qu???n 1", "Qu???n 2", "Qu???n 3", "Qu???n 4", "Qu???n 5", "Qu???n 6", "Qu???n 7", "Qu???n 8", "Qu???n 9", "Qu???n 10"}));
		cbbDiemDen.setBounds(256, 122, 88, 21);
		panel_1.add(cbbDiemDen);

		JButton btnTimDuong = new JButton("T??m ???????ng");
		btnTimDuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimDuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PathFinder shortestPath = new PathFinder();
				shortestPath.ShortestP(v1);
				int d = cbbDiemDen.getSelectedIndex();
				switch(d) {
				case 0:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v1) + "\nKho???ng c??ch t???i thi???u: " + v1.getDist() + " km");
					break;
				}
				case 1:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v2) + "\nKho???ng c??ch t???i thi???u: " + v2.getDist() + " km");
					break;
				}
				case 2:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v3) + "\nKho???ng c??ch t???i thi???u: " + v3.getDist() + " km");
					break;
				}
				case 3:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v4) + "\nKho???ng c??ch t???i thi???u: " + v4.getDist() + " km");
					break;
				}
				case 4:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v5) + "\nKho???ng c??ch t???i thi???u: " + v5.getDist() + " km");
					break;
				}
				case 5:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v6) + "\nKho???ng c??ch t???i thi???u: " + v6.getDist() + " km");
					break;
				}
				case 6:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v7) + "\nKho???ng c??ch t???i thi???u: " + v7.getDist() + " km");
					break;
				}
				case 7:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v8) + "\nKho???ng c??ch t???i thi???u: " + v8.getDist() + " km");
					break;
				}
				case 8:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v9) + "\nKho???ng c??ch t???i thi???u: " + v9.getDist() + " km");
					break;
				}
				case 9:{
					JOptionPane.showMessageDialog(rootPane, "???????ng ??i ng???n nh???t: " + shortestPath.getShortestP(v10) + "\nKho???ng c??ch t???i thi???u: " + v10.getDist() + " km");
					break;
				}
				}
			}
		});
		btnTimDuong.setBounds(354, 122, 106, 21);
		panel_1.add(btnTimDuong);

		JLabel lblNewLabel_5 = new JLabel("Th??ng/ng??y/n??m");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(807, 166, 111, 20);
		panel_1.add(lblNewLabel_5);

		txtDay = new JTextField();
		txtDay.setBounds(928, 166, 165, 19);
		panel_1.add(txtDay);
		txtDay.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Bu???i s??ng");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(807, 215, 111, 21);
		panel_1.add(lblNewLabel_6);

		txtNV1 = new JTextField();
		txtNV1.setToolTipText("Nh???p m?? nh??n vi??n\r\n");
		txtNV1.setBounds(928, 216, 165, 19);
		panel_1.add(txtNV1);
		txtNV1.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Qu???n");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(807, 268, 111, 13);
		panel_1.add(lblNewLabel_7);

		txtQuanT1 = new JTextField();
		txtQuanT1.setToolTipText("??i???n s??? t??? 1-10 (Qu???n 1 - Qu???n 10)");
		txtQuanT1.setBounds(928, 265, 165, 19);
		panel_1.add(txtQuanT1);
		txtQuanT1.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("T??nh tr???ng");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(807, 309, 111, 13);
		panel_1.add(lblNewLabel_8);

		JLabel lblNewLabel_10 = new JLabel("Bu???i chi???u");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(807, 352, 111, 13);
		panel_1.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Qu???n");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(807, 404, 111, 13);
		panel_1.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("T??nh tr???ng");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(807, 457, 111, 13);
		panel_1.add(lblNewLabel_12);

		txtTinhTrang1 = new JTextField();
		txtTinhTrang1.setBounds(928, 306, 165, 19);
		panel_1.add(txtTinhTrang1);
		txtTinhTrang1.setColumns(10);

		txtNV2 = new JTextField();
		txtNV2.setToolTipText("Nh???p m?? nh??n vi??n");
		txtNV2.setColumns(10);
		txtNV2.setBounds(928, 352, 165, 19);
		panel_1.add(txtNV2);

		txtQuanT2 = new JTextField();
		txtQuanT2.setToolTipText("??i???n s??? t??? 1-10 (Qu???n 1 - Qu???n 10)");
		txtQuanT2.setColumns(10);
		txtQuanT2.setBounds(928, 401, 165, 19);
		panel_1.add(txtQuanT2);

		txtTinhTrang2 = new JTextField();
		txtTinhTrang2.setColumns(10);
		txtTinhTrang2.setBounds(928, 454, 165, 19);
		panel_1.add(txtTinhTrang2);

		JButton btnThemLich = new JButton("Th??m");
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
					JOptionPane.showMessageDialog(rootPane, "H??y nh???p ?????y ????? c??c d??? li???u!");
					txtDay.grabFocus();
					return;
				}
				
				if(!(day.matches("(0[1-9]|[12])\\/(0?[1-9]|[12]\\d|3[01])\\/(\\d{2}|\\d{4})\\b"))) {
					JOptionPane.showMessageDialog(rootPane, "Nh???p th??ng/ng??y/n??m theo c???u tr??c (MM/dd/yyyy) (01/29/2021)");
					return;
				}
				
				if(!(q1.matches("[1-9]0?")) || !(q2.matches("[1-9]0?"))) {
					JOptionPane.showMessageDialog(rootPane, "Qu???n nh???p s??? t??? 1 - 10 (Qu???n 1 - Qu???n 10)");
					return;
				}

				if(!(tt1.contains("Tr???ng")) && !(tt1.contains("Ho??n th??nh")) && !(tt1.contains("Ch??a ho??n th??nh")) || !(tt2.contains("Tr???ng")) && !(tt2.contains("Ho??n th??nh")) & !(tt2.contains("Ch??a ho??n th??nh"))) {
					JOptionPane.showMessageDialog(rootPane, "Nh???p t??nh tr???ng m???t trong (Tr???ng, Ho??n th??nh, Ch??a ho??n th??nh)");
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
					JOptionPane.showMessageDialog(rootPane, "M?? s??? nh??n vi??n kh??ng t???n t???i");
					return;
				}
				
				
				MotNgay lich = new MotNgay(day,nv1, q1, tt1, nv2, q2,tt1);
				dsl.add(lich);
				MotNgay.updateData(dsl);
				model.addRow(new Object[] {lich.getDay(),lich.getNv1(),lich.getQt1(),lich.getTt1(),lich.getNv2(),lich.getQt2(), lich.getTt2()}); 
				JOptionPane.showMessageDialog(rootPane, "Th??m l???ch th??nh c??ng!");
			}
		});
		btnThemLich.setBounds(962, 507, 85, 21);
		panel_1.add(btnThemLich);
		
		JButton btnXemLich = new JButton("Xem l???ch l??m vi???c");
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
		
		JButton btnCapNhatLich = new JButton("C???p nh???t");
		btnCapNhatLich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modellich = (DefaultTableModel) tbLich.getModel();

				// Ghi l???i th??ng tin c???a li??n h??? sau khi ng?????i d??ng c???p nh???t
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

				// hi???n th??? l???i n???i dung ???? c???p nh???t l??n d??ng tr??n table
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
		
		JButton btnXoaLich = new JButton("X??a");
		btnXoaLich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modellich = (DefaultTableModel) tbLich.getModel();
				// X??c nh???n th??ng tin x??a, n???u ch???n ?????ng ?? x??a
				int reply = JOptionPane.showConfirmDialog(rootPane, "B???n c?? mu???n ng??y " + txtDay.getText() + "?", "X??c nh???n", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					for (int i = 0; i <  dsl.size(); i++) {
						if (dsl.get(i).getDay().equals(txtDay.getText())) {
							dsl.remove(i);
						}
					}
					MotNgay.updateData(dsl);
					// x??a d??ng ???? ch???n tr??n table
					modellich.removeRow(tbLich.getSelectedRow());
					// x??a n???i dung tr??n c??c ??i???u khi???n ????? ng?????i d??ng ti???p t???c thao t??c
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
		
		JButton btnXoaTrang = new JButton("X??a tr???ng");
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
