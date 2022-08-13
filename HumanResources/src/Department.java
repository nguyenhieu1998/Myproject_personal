// ở file này ta dùng để chứa thông tin chung về bộ phận
public class Department {
    // các thuộc tính chung của bộ phận
    private String maBoPhan;
    private String tenBoPhan;
    private int soluong;
    //Constructors
    public Department(String maBoPhan, String tenBoPhan, int soluong) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soluong = soluong;
    }
    //getter vs setter
    public String getMaBoPhan() {
        return maBoPhan;
    }
    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }
    public String getTenBoPhan() {
        return tenBoPhan;
    }
    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    // sử dụng Phương thức: toString() hiển thị thông tin về bộ phận
    public String toString(){
        return  maBoPhan+ "          |" + tenBoPhan + "         |" + soluong;
    }
}
