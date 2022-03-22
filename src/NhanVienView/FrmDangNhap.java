package NhanVienView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class FrmDangNhap extends JFrame {

	private JPanel contentPane;
	ArrayList<TaiKhoan> dstk;
	private JTextField txtTaiKhoan;
	Hashtable<String,String> hashTable;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDangNhap frame = new FrmDangNhap();
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
	public FrmDangNhap() {
		setTitle("Chào mừng bạn đến với phần mềm quản lý nhân viên");
		dstk = (ArrayList<TaiKhoan>) TaiKhoan.getAll();
		//dstk = new ArrayList<TaiKhoan>();
		hashTable = new Hashtable<String,String>();
		for(TaiKhoan tk:dstk) {
			hashTable.put(tk.getTk(),tk.getMk());
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n");
		lblNewLabel.setBounds(73, 60, 74, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_1.setBounds(73, 103, 74, 13);
		contentPane.add(lblNewLabel_1);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(169, 57, 185, 19);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(169, 100, 185, 19);
		contentPane.add(txtMatKhau);

		JButton btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoan dn = new TaiKhoan(txtTaiKhoan.getText(), txtMatKhau.getText());
				//				for (Map.Entry<String, String> e1 : hashTable.entrySet()){
				if(hashTable.containsKey(dn.getTk()) && hashTable.containsValue(dn.getMk())){
					JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công");

					fromNhanVien fnv = new fromNhanVien();
					fnv.setVisible(true);
					return;
				}
				//				}
				JOptionPane.showMessageDialog(rootPane, "Sai tài khoản hoặc mật khẩu");
			}
		});
		btnDangNhap.setBounds(195, 142, 104, 21);
		contentPane.add(btnDangNhap);

		JButton btnDangKy = new JButton("\u0110\u0103ng k\u00FD");
		btnDangKy.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmDangKy fdk = new FrmDangKy();
				fdk.setVisible(true);
				return;
			}
		});
		btnDangKy.setBounds(143, 196, 85, 19);
		contentPane.add(btnDangKy);

		JLabel lblNewLabel_2 = new JLabel("Chưa có tài khoản?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 199, 124, 13);
		contentPane.add(lblNewLabel_2);

		JButton btnQuenMK = new JButton("Quên mật khẩu?");
		btnQuenMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmQuenMatKhau fqmk = new FrmQuenMatKhau();
				fqmk.setVisible(true);
				return;
			}
		});
		btnQuenMK.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnQuenMK.setBounds(304, 199, 153, 21);
		contentPane.add(btnQuenMK);

		JButton btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmDoiMatKhau fdmk = new FrmDoiMatKhau();
				fdmk.setVisible(true);
				return;
			}
		});
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDoiMatKhau.setBounds(10, 234, 158, 21);
		contentPane.add(btnDoiMatKhau);
	}
}
