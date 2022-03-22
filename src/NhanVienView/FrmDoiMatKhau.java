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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmDoiMatKhau extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoanDoi;
	private JPasswordField txtMatKhauCu;
	private JPasswordField txtMatKhauMoi;
	private JPasswordField txtMatKhauMoi2;
	private JButton btnDoiMatKhau;
	ArrayList<TaiKhoan> dstk;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDoiMatKhau frame = new FrmDoiMatKhau();
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
	public FrmDoiMatKhau() {
		dstk = (ArrayList<TaiKhoan>) TaiKhoan.getAll();
		
		setTitle("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(65, 25, 159, 13);
		contentPane.add(lblNewLabel);
		
		txtTaiKhoanDoi = new JTextField();
		txtTaiKhoanDoi.setBounds(234, 22, 137, 19);
		contentPane.add(txtTaiKhoanDoi);
		txtTaiKhoanDoi.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u c\u0169");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(65, 66, 159, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(65, 109, 159, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(65, 152, 159, 13);
		contentPane.add(lblNewLabel_3);
		
		txtMatKhauCu = new JPasswordField();
		txtMatKhauCu.setBounds(234, 63, 137, 19);
		contentPane.add(txtMatKhauCu);
		
		txtMatKhauMoi = new JPasswordField();
		txtMatKhauMoi.setBounds(234, 106, 137, 19);
		contentPane.add(txtMatKhauMoi);
		
		txtMatKhauMoi2 = new JPasswordField();
		txtMatKhauMoi2.setBounds(234, 149, 137, 19);
		contentPane.add(txtMatKhauMoi2);
		
		btnDoiMatKhau = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = 0;
				for (TaiKhoan tk:dstk) {
					if(tk.getTk().equals(txtTaiKhoanDoi.getText())) {
						check++;
					}
				}

				if(check == 0) {
					JOptionPane.showMessageDialog(rootPane, "Tài khoản không tồn tại");
					return;
				}
				
				for (int i =0; i < dstk.size(); i++) {
					if (dstk.get(i).getTk().equals(txtTaiKhoanDoi.getText())){
						if (dstk.get(i).getMk().equals(txtMatKhauCu.getText())) {
							if(txtMatKhauMoi.getText().equals(txtMatKhauMoi2.getText())) {
								dstk.get(i).setMk(txtMatKhauMoi.getText());
								TaiKhoan.updateData(dstk);
								JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công!");
								return;
							} else {
								JOptionPane.showMessageDialog(rootPane, "Mật khẩu nhập không khớp!");
								return;
							}
						} else {
							JOptionPane.showMessageDialog(rootPane, "Sai mật khẩu cũ");
							return;
						}
					}
				}
				JOptionPane.showMessageDialog(rootPane, "Xác minh thất bại!");
			}
		});
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDoiMatKhau.setBounds(157, 205, 117, 28);
		contentPane.add(btnDoiMatKhau);
	}

}
