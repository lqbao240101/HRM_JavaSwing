package NhanVienView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TaiKhoan implements Serializable{
	private String tk;
	private String mk;
	private String manv;
	private String ch;
	private String ctl;
	private String email;
	private String sdt;

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String tk, String mk) {
		super();
		this.tk = tk;
		this.mk = mk;
	}
	
	public TaiKhoan(String tk, String mk, String manv, String ch, String ctl, String email, String sdt) {
		super();
		this.tk = tk;
		this.mk = mk;
		this.manv = manv;
		this.ch = ch;
		this.ctl = ctl;
		this.email = email;
		this.sdt = sdt;
	}

	public String getTk() {
		return tk;
	}

	public void setTk(String tk) {
		this.tk = tk;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public String getCtl() {
		return ctl;
	}

	public void setCtl(String ctl) {
		this.ctl = ctl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public static void updateData(List<TaiKhoan> listTK) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("tk.dat"));
			for (TaiKhoan nv: listTK) {
				oos.writeObject(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (oos != null) {
				try {
					oos.close();
				} catch(IOException ex) {
				}
			}
		}
	}

	public static List<TaiKhoan> getAll(){
		ObjectInputStream ois = null;
		TaiKhoan tk = null;
		List<TaiKhoan> list = new ArrayList<>();
		try {
			ois = new ObjectInputStream(new FileInputStream("tk.dat"));
			Object obj = null;
			try {
				while((obj = ois.readObject())!=null) {
					tk = (TaiKhoan) obj;
					list.add(tk);
				}
			} catch(Exception e) {
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list; 
	}	
}