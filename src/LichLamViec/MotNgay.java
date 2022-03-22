package LichLamViec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import NhanVienView.NhanVien;

public class MotNgay implements Serializable {
	private String day;
	private String nv1;
	private String qt1;
	private String tt1;
	private String nv2;
	private String qt2;
	private String tt2;

	public MotNgay() {
		super();
	}

	public MotNgay(String day, String nv1, String qt1, String tt1, String nv2, String qt2, String tt2) {
		super();
		this.day = day;
		this.nv1 = nv1;
		this.qt1 = qt1;
		this.tt1 = tt1;
		this.nv2 = nv2;
		this.qt2 = qt2;
		this.tt2 = tt2;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getNv1() {
		return nv1;
	}

	public void setNv1(String nv1) {
		this.nv1 = nv1;
	}

	public String getQt1() {
		return qt1;
	}

	public void setQt1(String qt1) {
		this.qt1 = qt1;
	}

	public String getTt1() {
		return tt1;
	}

	public void setTt1(String tt1) {
		this.tt1 = tt1;
	}

	public String getNv2() {
		return nv2;
	}

	public void setNv2(String nv2) {
		this.nv2 = nv2;
	}

	public String getQt2() {
		return qt2;
	}

	public void setQt2(String qt2) {
		this.qt2 = qt2;
	}

	public String getTt2() {
		return tt2;
	}

	public void setTt2(String tt2) {
		this.tt2 = tt2;
	}

	public static void updateData(List<MotNgay> listLich) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("lich.dat"));
			for (MotNgay l: listLich) {
				oos.writeObject(l);
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
	
	public static List<MotNgay> getAll(){
		ObjectInputStream ois = null;
		MotNgay l = null;
		List<MotNgay> list = new ArrayList<>();
		try {
			ois = new ObjectInputStream(new FileInputStream("lich.dat"));
			Object obj = null;
			try {
				while((obj = ois.readObject())!=null) {
					l = (MotNgay) obj;
					list.add(l);
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
}