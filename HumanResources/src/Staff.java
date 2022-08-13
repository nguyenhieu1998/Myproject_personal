// sử dụng tính trừu tượng để tạo ra lớp Staff với các thông tin cụ thể liên quan đến đối tượng
//Từ khóa implements được sử dụng bởi các lớp mà kế thừa từ Interface. Interface có thể không bao giờ được kết thừa bởi các lớp.
abstract class Staff implements ICalculator {
//    phương thức private giúp ta ngăn chặn người dùng truy cập vào những mã
//    code mà họ không được phép.
    //các thuộc tính
    private String maNhanVien;
    private String tenNhanVien;
    private int tuoiNhanVien;
    private double heSoluong;
    private String ngayVaoLam;
    private int soNgayNghiPhep;
    private String boPhanLamViec;
    // Constructors
    public Staff(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoluong, String ngayVaoLam, int soNgayNghiPhep, String boPhanLamViec){
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.heSoluong = heSoluong;
        this. ngayVaoLam = ngayVaoLam;
        this.soNgayNghiPhep = soNgayNghiPhep;
        this.boPhanLamViec = boPhanLamViec;
    }
    public abstract double calculateSalary();
    // sử dụng phương pháp getter và setter
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public String getTenNhanVien() {
        return tenNhanVien;
    }
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    public int getTuoiNhanVien() {
        return tuoiNhanVien;
    }
    public void setTuoiNhanVien(int tuoiNhanVien) {
        this.tuoiNhanVien = tuoiNhanVien;
    }
    public double getHeSoluong() {
        return heSoluong;
    }
    public void setHeSoluong(double heSoluong) {
        this.heSoluong = heSoluong;
    }
    public String getNgayVaoLam() {
        return ngayVaoLam;
    }
    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    public int getSoNgayNghiPhep() {
        return soNgayNghiPhep;
    }
    public void setSoNgayNghiPhep(int soNgayNghiPhep) {
        this.soNgayNghiPhep = soNgayNghiPhep;
    }
    public String getBoPhanLamViec() {
        return boPhanLamViec;
    }
    public void setBoPhanLamViec(String boPhanLamViec) {
        this.boPhanLamViec = boPhanLamViec;
    }
    // hàm để hiển thị thông tin của đối tượng
    public abstract void displayInformation();
}