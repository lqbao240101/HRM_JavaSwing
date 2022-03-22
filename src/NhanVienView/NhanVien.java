package NhanVienView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NhanVien implements Serializable {
	private static final String DefaultTableModel = null;
	private String manv;
	private String ho;
	private String ten;
	private String ngaysinh;
	private String email;
	private String sdt;
	private String macv;
	private String luong;
	private String maql;
	JTable tbl = new JTable();
	public NhanVien() {
		super();
	}

	public NhanVien(String manv, String ho, String ten, String ngaysinh, String email, String sdt, String macv, String luong, String maql) {
		super();
		this.manv = manv;
		this.ho = ho;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.email = email;
		this.sdt = sdt;
		this.macv = macv;
		this.luong = luong;
		this.maql = maql;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}


	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
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

	public String getMacv() {
		return macv;
	}

	public void setMacv(String macv) {
		this.macv = macv;
	}

	public String getLuong() {
		return luong;
	}

	public void setLuong(String luong) {
		this.luong = luong;
	}

	public String getMaql() {
		return maql;
	}

	public void setMaql(String maql) {
		this.maql = maql;
	}

	public static void updateData(List<NhanVien> listNV) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
			for (NhanVien nv: listNV) {
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

	public static List<NhanVien> getAll(){
		ObjectInputStream ois = null;
		NhanVien nv = null;
		List<NhanVien> list = new ArrayList<>();
		try {
			ois = new ObjectInputStream(new FileInputStream("data.dat"));
			Object obj = null;
			try {
				while((obj = ois.readObject())!=null) {
					nv = (NhanVien) obj;
					list.add(nv);
				}
			}catch(Exception e){

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

	 int binarySearch(List<NhanVien> arr, int l, int r, String x)  {
	        if (r >= l) {
	            int mid = l + (r - l) / 2;
	 
	            // If the element is present at the
	            // middle itself
	            if (arr.get(mid).getManv().equals(x))
	                return mid;
	 
	            // If element is smaller than mid, then
	            // it can only be present in left subarray
	            if (arr.get(mid).getManv().compareTo(x) == 1)
	                return binarySearch(arr, l, mid - 1, x);
	 
	            // Else the element can only be present
	            // in right subarray
	            return binarySearch(arr, mid + 1, r, x);
	        }
	 
	        // We reach here when element is not present
	        // in array
	        return -1;
	    }
	
}
