package NhanVienView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmQuenMatKhau extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoanXM;
	private JTextField txtCauTraLoiXM;
	ArrayList<TaiKhoan> dstk;
	private JPasswordField txtMatKhauQ;
	private JPasswordField txtMatKhauQ2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuenMatKhau frame = new FrmQuenMatKhau();
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
	public FrmQuenMatKhau() {
		dstk = (ArrayList<TaiKhoan>) TaiKhoan.getAll();

		setTitle("Xác minh và đổi mật khẩu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(52, 46, 108, 13);
		contentPane.add(lblNewLabel);

		txtTaiKhoanXM = new JTextField();
		txtTaiKhoanXM.setBounds(170, 43, 148, 19);
		contentPane.add(txtTaiKhoanXM);
		txtTaiKhoanXM.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("C\u00E2u h\u1ECFi b\u1EA3o m\u1EADt");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(52, 97, 108, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("C\u00E2u tr\u1EA3 l\u1EDDi");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_2.setBounds(52, 160, 108, 13);
		contentPane.add(lblNewLabel_2);

		JComboBox cbbCauHoiXM = new JComboBox();
		cbbCauHoiXM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbCauHoiXM.setModel(new DefaultComboBoxModel(new String[] {"C\u1EA7u th\u1EE7 b\u1EA1n y\u00EAu th\u00EDch l\u00E0 g\u00EC?", "M\u00F3n \u0103n b\u1EA1n y\u00EAu th\u00EDch l\u00E0 g\u00EC?", "B\u1ED9 phim b\u1EA1n y\u00EAu th\u00EDch l\u00E0 g\u00EC?", "Con v\u1EADt b\u1EA1n y\u00EAu th\u00EDch l\u00E0 g\u00EC?", "B\u1EA1n th\u00EDch u\u1ED1ng n\u01B0\u1EDBc g\u00EC?", "\u0110\u1ED9i b\u00F3ng b\u1EA1n y\u00EAu th\u00EDch l\u00E0 g\u00EC?"}));
		cbbCauHoiXM.setBounds(170, 93, 222, 21);
		contentPane.add(cbbCauHoiXM);

		txtCauTraLoiXM = new JTextField();
		txtCauTraLoiXM.setBounds(170, 157, 148, 19);
		contentPane.add(txtCauTraLoiXM);
		txtCauTraLoiXM.setColumns(10);

		JButton btnDoiMKQ = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		btnDoiMKQ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDoiMKQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = 0;
				for (TaiKhoan tk:dstk) {
					if(tk.getTk().equals(txtTaiKhoanXM.getText())) {
						check++;
					}
				}

				if(check == 0) {
					JOptionPane.showMessageDialog(rootPane, "Tài khoản không tồn tại");
					return;
				}

				for (int i =0; i < dstk.size(); i++) {
					if (dstk.get(i).getTk().equals(txtTaiKhoanXM.getText()) && dstk.get(i).getCh().equals(cbbCauHoiXM.getSelectedItem().toString()) && dstk.get(i).getCtl().equals(txtCauTraLoiXM.getText())) {
						if (txtMatKhauQ.getText().equals(txtMatKhauQ2.getText())){
							dstk.get(i).setMk(txtMatKhauQ.getText());
							TaiKhoan.updateData(dstk);
							JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công!");
							return;
						} else {
							JOptionPane.showMessageDialog(rootPane, "Mật khẩu nhập không khớp!");
							return;
						}
					}
				}
				JOptionPane.showMessageDialog(rootPane, "Xác minh thất bại!");
			}
		});
		btnDoiMKQ.setBounds(155, 332, 124, 21);
		contentPane.add(btnDoiMKQ);

		JLabel lblNewLabel_3 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_3.setBounds(52, 222, 108, 13);
		contentPane.add(lblNewLabel_3);

		txtMatKhauQ = new JPasswordField();
		txtMatKhauQ.setBounds(170, 219, 148, 19);
		contentPane.add(txtMatKhauQ);

		txtMatKhauQ2 = new JPasswordField();
		txtMatKhauQ2.setBounds(170, 272, 148, 19);
		contentPane.add(txtMatKhauQ2);

		JLabel lblNewLabel_4 = new JLabel("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_4.setBounds(52, 275, 108, 13);
		contentPane.add(lblNewLabel_4);
	}

}
