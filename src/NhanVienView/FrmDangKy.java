package NhanVienView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmDangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoanDK;
	private JPasswordField txtMatKhauDK;
	private JPasswordField txtMatKhauDK2;
	private JTextField txtMaNvDK;
	private JTextField txtCauTraLoi;
	private JTextField txtEmailDK;
	private JTextField txtSdtDK;
	private JTextField txtMaXacMinh;
	ArrayList<TaiKhoan> dstk;
	ArrayList<NhanVien> dsnv;
 	Hashtable<String,String> hashTable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDangKy frame = new FrmDangKy();
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
	public FrmDangKy() {
		dsnv = (ArrayList<NhanVien>) NhanVien.getAll();
		//dstk = new ArrayList<TaiKhoan>();
		dstk = (ArrayList<TaiKhoan>) TaiKhoan.getAll();
		hashTable = new Hashtable<String,String>();
		for(TaiKhoan tk:dstk) {
			hashTable.put(tk.getTk(),tk.getMk());
		}
		
		setTitle("\u0110\u0103ng k\u00FD t\u00E0i kho\u1EA3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(60, 13, 145, 13);
		contentPane.add(lblNewLabel);
		
		txtTaiKhoanDK = new JTextField();
		txtTaiKhoanDK.setBounds(215, 10, 150, 19);
		contentPane.add(txtTaiKhoanDK);
		txtTaiKhoanDK.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(60, 60, 145, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(60, 108, 145, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn \u0111\u0103ng k\u00FD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(60, 156, 145, 13);
		contentPane.add(lblNewLabel_3);
		
		txtMatKhauDK = new JPasswordField();
		txtMatKhauDK.setBounds(215, 57, 150, 19);
		contentPane.add(txtMatKhauDK);
		
		txtMatKhauDK2 = new JPasswordField();
		txtMatKhauDK2.setBounds(215, 105, 150, 19);
		contentPane.add(txtMatKhauDK2);
		
		JLabel lblNewLabel_4 = new JLabel("C\u00E2u h\u1ECFi b\u1EA3o m\u1EADt");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(60, 202, 145, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("C\u00E2u tr\u1EA3 l\u1EDDi");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(60, 246, 145, 13);
		contentPane.add(lblNewLabel_5);
		
		txtMaNvDK = new JTextField();
		txtMaNvDK.setBounds(215, 153, 150, 19);
		contentPane.add(txtMaNvDK);
		txtMaNvDK.setColumns(10);
		
		txtCauTraLoi = new JTextField();
		txtCauTraLoi.setBounds(215, 243, 150, 19);
		contentPane.add(txtCauTraLoi);
		txtCauTraLoi.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(60, 290, 145, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(60, 339, 145, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("M\u00E3 x\u00E1c minh");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(60, 431, 145, 13);
		contentPane.add(lblNewLabel_8);
		
		txtEmailDK = new JTextField();
		txtEmailDK.setBounds(215, 288, 150, 19);
		contentPane.add(txtEmailDK);
		txtEmailDK.setColumns(10);
		
		txtSdtDK = new JTextField();
		txtSdtDK.setBounds(215, 337, 150, 19);
		contentPane.add(txtSdtDK);
		txtSdtDK.setColumns(10);
		
		JLabel lblXacMinh = new JLabel("");
		lblXacMinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblXacMinh.setFont(new Font("Papyrus", Font.PLAIN, 32));
		Random rd = new Random();
		int r = rd.nextInt(((9999-1000)+1)+1000);
		lblXacMinh.setText(String.valueOf(r));
		lblXacMinh.setBounds(215, 366, 150, 51);
		contentPane.add(lblXacMinh);
		
		JComboBox cbbCauHoi = new JComboBox();
		cbbCauHoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbCauHoi.setModel(new DefaultComboBoxModel(new String[] {"Cầu thủ bạn yêu thích là gì?", "Món ăn bạn yêu thích là gì?", "Bộ phim bạn yêu thích là gì?", "Con vật bạn yêu thích là gì?", "Bạn thích uống nước gì?", "Đội bóng bạn yêu thích là gì?"}));
		cbbCauHoi.setBounds(215, 194, 189, 28);
		contentPane.add(cbbCauHoi);
		
		JButton btnFrmDangKy = new JButton("\u0110\u0103ng k\u00FD");
		btnFrmDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTaiKhoanDK.getText().isBlank() || txtMatKhauDK.getText().isBlank() || txtMatKhauDK2.getText().isBlank() || txtCauTraLoi.getText().isBlank() || txtMaNvDK.getText().isBlank() || txtEmailDK.getText().isBlank() || txtSdtDK.getText().isBlank()) {
					JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ thông tin tài khoản cần đăng ký!");
					txtTaiKhoanDK.grabFocus();
					return;	
				} 
				
				if(!(txtMatKhauDK.getText().equals(txtMatKhauDK2.getText()))) {
					JOptionPane.showMessageDialog(rootPane, "Mật khẩu nhập không khớp!");
					return;
				}
				
				int check = 0;
				for (NhanVien nv:dsnv) {
					if(nv.getManv().equals(txtMaNvDK.getText())) {
						check++;
					}
				}
				
				if(check == 0) {
					JOptionPane.showMessageDialog(rootPane, "Mã số nhân viên không tồn tại");
					return;
				}
				
				TaiKhoan dk = new TaiKhoan(txtTaiKhoanDK.getText(), txtMatKhauDK.getText(), txtMaNvDK.getText() ,cbbCauHoi.getSelectedItem().toString(), txtCauTraLoi.getText(), txtEmailDK.getText(), txtSdtDK.getText());
		
				for (Map.Entry<String, String> e1 : hashTable.entrySet()){
					if(hashTable.containsKey(dk.getTk())) {
						JOptionPane.showMessageDialog(rootPane, "Tài khoản bị trùng");
						return;
					}
				}
				
				for(TaiKhoan tk:dstk) {
					if (tk.getManv().equals(txtMaNvDK.getText())){
						JOptionPane.showMessageDialog(rootPane, "Mã nhân viên đã được dùng đăng ký!");
						return;
					}
				}
				
				if(!(txtMaXacMinh.getText().equals(lblXacMinh.getText()))){
					JOptionPane.showMessageDialog(rootPane, "Mã xác minh không trùng khớp!");
					return;
				}
				
				hashTable.put(dk.getTk(), dk.getMk());
				dstk.add(dk);
				JOptionPane.showMessageDialog(rootPane, "Thêm tài khoản thành công!");
				TaiKhoan.updateData(dstk);
			}
		});
		btnFrmDangKy.setBounds(147, 476, 131, 28);
		contentPane.add(btnFrmDangKy);
		
		JButton btnLamMoiMa = new JButton("");
		btnLamMoiMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rd = new Random();
				int r = rd.nextInt(((9999-1000)+1)+1000);
				lblXacMinh.setText(String.valueOf(r));
			}
		});
		btnLamMoiMa.setBounds(375, 392, 33, 28);
		ImageIcon icon = new ImageIcon("D:////hinh2muiten.jpg");
		icon.setImage(icon.getImage().getScaledInstance(btnLamMoiMa.getWidth(), btnLamMoiMa.getHeight(),Image.SCALE_DEFAULT));
		btnLamMoiMa.setIcon(icon);
		contentPane.add(btnLamMoiMa);
		
		txtMaXacMinh = new JTextField();
		txtMaXacMinh.setBounds(215, 429, 150, 19);
		contentPane.add(txtMaXacMinh);
		txtMaXacMinh.setColumns(10);
	}
}
