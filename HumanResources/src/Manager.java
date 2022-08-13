// ở file Manager ta cũng sử dụng tính kế thừa từ lớp cha là Staff
public class Manager extends Staff{
    // thêm 1 thuộc tính mới cho nhân viên quản lý
    private String chucDanh;
//Constructors
    public Manager(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoluong, String ngayVaoLam, int soNgayNghiPhep, String boPhanLamViec, String chucDanh) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoluong, ngayVaoLam, soNgayNghiPhep, boPhanLamViec);
        this.chucDanh = chucDanh;
    }
    // getter vs setter
    public String getChucDanh() {
        return chucDanh;
    }
    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }
    @Override
    public double calculateSalary() {// phương thức trả về lương nv quản lý
        double luongTrachNhiem = 0;
        if (chucDanh.equals("Business Leader")) luongTrachNhiem = 8000000;
        else if (chucDanh.equals("Project Leader")) luongTrachNhiem = 5000000;
        else if (chucDanh.equals("Technical Leader")) luongTrachNhiem = 6000000;

        return (getHeSoluong() * 5000000) + luongTrachNhiem;
    }
    @Override
    public void displayInformation() {// hiển thị thông tin nhân viên quản lý

    }
}
