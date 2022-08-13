// tạo 1 interface ICalculator chứa công thức tính thương cho class employee và manager
public interface ICalculator {
    //Interface là một kỹ thuật để thu được tính trừu tượng hoàn toàn và đa kế thừa trong Java
    //Interface trong Java cũng biễu diễn mối quan hệ IS-A. Nó không thể được khởi tạo giống như lớp trừu tượng.
    static double getHeSoluong(){
        return getHeSoluong();
    }
    static double soGioLamThem(){
        return soGioLamThem();
    }
    public double calculateSalary();

}
