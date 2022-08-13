import java.util.ArrayList;
import java.util.List;
//ta sử dụng tính kế thừa để làm phần hiển thị thông tin của nhân viên thông thường
// file Employee sẽ kế thừa file Staff
public class Employee extends Staff {
    private double soGioLamThem;
//    Sử dụng từ khóa super để tham chiếu trực tiếp đến biến instance của lớp cha gần nhất
    //Constructors
    // ở file employee ta sẽ thêm 1 thuộc tính mới là số giờ làm thêm cho nhân viên thường
    public Employee(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoluong, String ngayVaoLam, int soNgayNghiPhep , String boPhanLamViec, double soGioLamThem) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoluong, ngayVaoLam, soNgayNghiPhep, boPhanLamViec);
        this.soGioLamThem = soGioLamThem;
    }
    // Getter vs setter
    public double getSoGioLamThem() {
        return soGioLamThem;
    }
    public void setSoGioLamThem(double soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }
    @Override
    public void displayInformation() {// hiển thị thông tin nhân viên
    }
    public double calculateSalary(){// phương thức trả về lương nv thường
        return getHeSoluong() * 3000000 + getSoGioLamThem() * 200000;
    }
}


