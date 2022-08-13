import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HumanResources {
    public static int menu;
    public static List<Staff> list = new ArrayList<>();
    public static void main(String[] args){
        // thêm các đối tượng vào danh sách nhân viên hiện có để hiển thị chức năng 1
        Employee a1 = new Employee("E001", "Phong Tuyết Hoa", 28, 3.2, "10/10/2010", 10, "Hành chính nhân sự", 4.0);
        Employee a2 = new Employee("E002", "Nguyen trong Hieu", 24, 2.2, "09/10/2019", 7, "Hành chính nhân sự", 3.0);
        Employee a3 = new Employee("E003", "Nguyen trung Kien", 26, 2.2, "20/10/2018", 5, "Marketing", 3.0);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        // bộ phận quản lý
        Manager b1 = new Manager("M001", "Nguyễn Văn An", 25, 2.5, "11/11/2017", 5, "Công nghệ thông tin", "Project Leader");
        Manager b2 = new Manager("M002", "Tạ Văn Lục", 32, 4.5, "01/11/2016", 1, "Công nghệ thông tin", "Technical Leader");
        Manager b3 = new Manager("M003", "Nguyen minh Hieu", 33, 4.5, "01/11/2015", 1, "Marketing", "Business leader");
        list.add(b1);
        list.add(b2);
        list.add(b3);
        Scanner sc = new Scanner(System.in);
        // sử dụng vòng lặp do…while để cho phép người dùng chọn lại chức năng
        do {
            // hiển thị các chức năng để ng dùng có thể lựa chọn
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty. ");
        System.out.println("2. Hiển thị các bộ phận trong công ty. ");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận. ");
        System.out.println("4. Thêm nhân viên mới vào công ty. ");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên. ");
        System.out.println("6. Hiển thị bảng lương của các nhân viên toàn công ty. ");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần. ");
        System.out.println("0. Thoát chương trình.");
            System.out.print("Lựa chọn của bạn: ");
            menu = sc.nextInt();
 //Hiển thị danh sách nhân viên hiện có trong công ty.
            if (menu == 1) {
                System.out.printf("%-6s%15s%10s%10s%15s%17s%10s%36s%10s\n", "Mã nhân viên", "|Tên nhân viên", "|Tuổi", "|HS lương", "|Ngày vào làm", "|Ngày nghỉ phép", "|Bộ phận", "|Số giờ làm thêm/Chức vụ", "|Lương");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                for (Staff a : list) {
                    if(a instanceof Employee) {
                        Employee employee = (Employee)a;
                        System.out.printf("%-6s%25s%4s%7s%18s%7s%33s%5s%31.10s\n", employee.getMaNhanVien(), "|" + employee.getTenNhanVien(), "|" + employee.getTuoiNhanVien(), "|" + employee.getHeSoluong(), "|" + employee.getNgayVaoLam(), "|" + employee.getSoNgayNghiPhep(), "|" + employee.getBoPhanLamViec(), "|" + employee.getSoGioLamThem(), "|" + String.format("%,d", (int)employee.calculateSalary()));
                    } else if(a instanceof  Manager) {
                        Manager manager = (Manager)a;
                        System.out.printf("%-6s%25s%4s%7s%18s%6s%35s%7s%15s\n", manager.getMaNhanVien(), "|" + manager.getTenNhanVien(), "|" + manager.getTuoiNhanVien(), "|" + manager.getHeSoluong(), "|" + manager.getNgayVaoLam(), "|" + manager.getSoNgayNghiPhep(), "|" + manager.getBoPhanLamViec(), "|" + manager.getChucDanh(), "|" + String.format("%,d", (int)manager.calculateSalary()));
                    }
                }
            }
// Hiển thị các bộ phận trong công ty.
            // với chức năng 2
            // sử dụng phương pháp Stream.filter.conunt để hiển thị số lượng nhân viên đang có trong 1 bộ phận
            // và dùng phương thức toString để hiển thị các thông tin cần thiết
            else if (menu == 2) {
                List<Department> listDep = new ArrayList<>();
                long count1 = list.stream().filter(e -> e.getBoPhanLamViec().startsWith("Hành chính nhân sự")).count();
                long count2 = list.stream().filter(e -> e.getBoPhanLamViec().startsWith("Công nghệ thông tin")).count();
                long count3 = list.stream().filter(e -> e.getBoPhanLamViec().startsWith("Marketing")).count();
                System.out.printf("%6s%15s%20s\n", "Mã bộ Phận", "| Tên Bộ Phận", "| Số lượng");
                    Department d1 = new Department("MKT", "Marketing", (int)count3);
                    Department d2 = new Department("IT", "Công nghệ thông tin", (int)count2);
                    Department d3 = new Department("HC", "Hành chính nhân sự", (int)count1);
                    listDep.add(d1);
                    listDep.add(d2);
                    listDep.add(d3);
                    for (Department d : listDep) {
                        System.out.println(d.toString());
                    }
            }
//Hiển thị các nhân viên theo từng bộ phận:
            // với chức năng 3
            // sử dụng PP Stream.map để lấy key: là tên bộ phận và value là thông tin nhân viên ở trong bộ phận đó
            // sử dụng foreach để hiển thị 1 arrayList
            else if (menu == 3) {
                Map<String, List<Staff>> listStaffs = list
                      .stream()
                      .collect(Collectors.groupingBy(staff -> staff.getBoPhanLamViec()));
                for(Map.Entry<String,List<Staff>> entry : listStaffs.entrySet()){
                    System.out.println(entry.getKey());
                    System.out.println("----------------------");
                    System.out.printf("%-6s%15s%10s%10s%15s%17s%10s%36s%10s\n", "Mã nhân viên", "|Tên nhân viên", "|Tuổi", "|HS lương", "|Ngày vào làm", "|Ngày nghỉ phép", "|Bộ phận", "|Số giờ làm thêm/Chức vụ", "|Lương");
                    for (Staff staffs : entry.getValue()){
                        if(staffs instanceof  Manager) {
                            Manager manager = (Manager)staffs;
                            System.out.printf("%-6s%25s%4s%7s%18s%6s%35s%7s%15s\n", manager.getMaNhanVien(), "|" + manager.getTenNhanVien(), "|" + manager.getTuoiNhanVien(), "|" + manager.getHeSoluong(), "|" + manager.getNgayVaoLam(), "|" + manager.getSoNgayNghiPhep(), "|" + manager.getBoPhanLamViec(), "|" + manager.getChucDanh(), "|" + String.format("%,d", (int)manager.calculateSalary()));
                        } else if(staffs instanceof Employee) {
                            Employee employee = (Employee)staffs;
                            System.out.printf("%-6s%25s%4s%7s%18s%7s%33s%5s%31.10s\n", employee.getMaNhanVien(), "|" + employee.getTenNhanVien(), "|" + employee.getTuoiNhanVien(), "|" + employee.getHeSoluong(), "|" + employee.getNgayVaoLam(), "|" + employee.getSoNgayNghiPhep(), "|" + employee.getBoPhanLamViec(), "|" + employee.getSoGioLamThem(), "|" + String.format("%,d", (int)employee.calculateSalary()));
                        }
                    }
                }
            }
// Phần thêm nhân viên thường và quản lý
            // với chức năng 4
            // ta cần lấy dữ liệu đầu vào của ng dùng liên quan đến thông tin của nhân viên mới và thêm nó vào
            // danh sách nhiên viên sẵn có
             else if(menu == 4) {
                int luaChon;
                String nhapMaNhanVien;
                String nhapTenNhanVien;
                int nhapTuoi;
                double nhapHsLuong;
                String nhapNgayVaoLam;
                int nhapSoNgayNghiPhep;
                String chonBoPhan;
                String nhapChucDanh;

                System.out.println("1.Thêm nhân viên thông thường");
                System.out.println("2.Thêm nhân viên quản lý(có thêm chức vụ)");
                System.out.print("Bạn lựa chọn: ");
                luaChon = sc.nextInt();
                // chia ra làm 2 lựa chọn
                // lựa chọn 1 là ng dùng thêm 1 nhân viên bình thường
                if(luaChon == 1) {
                    System.out.print("Nhập mã nhân viên: ");
                    nhapMaNhanVien = sc.next();
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("Nhập tên nhân vien: ");
                    nhapTenNhanVien = sc1.nextLine();
                    System.out.print("Nhập tuổi nhân viên: ");
                    nhapTuoi = sc.nextInt();
                    System.out.print("Nhập hệ số lương của nhân viên: ");
                    nhapHsLuong = sc.nextDouble();
                    System.out.print("Nhập ngày vào làm của nhân viên: ");
                    nhapNgayVaoLam = sc.next();
                    System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
                    nhapSoNgayNghiPhep = sc.nextInt();
                    System.out.println("1. HC - Hành chính nhân sự");
                    System.out.println("2. IT - Công nghệ thông tin");
                    System.out.println("3. MKT - Marketing");
                    System.out.print("Bạn chọn bộ phận: ");
                    chonBoPhan = sc.next();
                    if(chonBoPhan.equals("1")){
                        String boPhan1 = "Hành chính nhân sự";
                        int soGioLamThem;
                        System.out.print("Nhập số giờ làm thêm: ");
                        soGioLamThem = sc.nextInt();
                        Employee employees = new Employee(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong,nhapNgayVaoLam,nhapSoNgayNghiPhep,boPhan1, soGioLamThem);
                        list.add(employees);
                    } else if (chonBoPhan.equals("2")) {
                        String boPhan2 = "Công nghệ thông tin";
                        int soGioLamThem;
                        System.out.print("Nhập số giờ làm thêm: ");
                        soGioLamThem = sc.nextInt();
                        Employee employees = new Employee(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong,nhapNgayVaoLam,nhapSoNgayNghiPhep,boPhan2, soGioLamThem);
                        list.add(employees);
                    } else if (chonBoPhan.equals("3")) {
                        String boPhan3 = "Marketing";
                        int soGioLamThem;
                        System.out.print("Nhập số giờ làm thêm: ");
                        soGioLamThem = sc.nextInt();
                        Employee employees = new Employee(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong,nhapNgayVaoLam,nhapSoNgayNghiPhep,boPhan3, soGioLamThem);
                        list.add(employees);
                    }
                // lựa chọn cho phép ng dùng thêm thông tin 1 nhân viên có chức vụ từ quản lý trở lên
                } else if (luaChon == 2) {
                    System.out.print("Nhập mã nhân viên: ");
                    nhapMaNhanVien = sc.next();
                    System.out.print("Nhập tên nhân vien: ");
                    Scanner sc1 = new Scanner(System.in);
                    nhapTenNhanVien = sc1.nextLine();
                    System.out.print("Nhập tuổi nhân viên: ");
                    nhapTuoi = sc.nextInt();
                    System.out.print("Nhập hệ số lương của nhân viên: ");
                    nhapHsLuong = sc.nextDouble();
                    System.out.print("Nhập ngày vào làm của nhân viên: ");
                    nhapNgayVaoLam = sc.next();
                    System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
                    nhapSoNgayNghiPhep = sc.nextInt();
                    System.out.println("1. HC - Hành chính nhân sự");
                    System.out.println("2. IT - Công nghệ thông tin");
                    System.out.println("3. MKT - Marketing");
                    System.out.print("Bạn chọn bộ phận: ");
                    chonBoPhan = sc.next();
                    if(chonBoPhan.equals("1")){
                        String boPhan1 = "Hành chính nhân sự";
                        System.out.println("Chức danh: ");
                        System.out.println("1. Business leader");
                        System.out.println("2. Project Leader");
                        System.out.println("3. Technical Leader");
                        System.out.print("Nhập chức danh: ");
                        nhapChucDanh = sc.next();
                        if(nhapChucDanh.equals("1")) {
                            String chucDanh = "Business leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan1, chucDanh);
                            list.add(managers);
                        } else if (nhapChucDanh.equals("2")) {
                            String chucDanh = "Project Leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan1, chucDanh);
                            list.add(managers);
                        } else if (nhapChucDanh.equals("3")) {
                            String chucDanh = "Technical Leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan1, chucDanh);
                            list.add(managers);
                        }
                    } else if (chonBoPhan.equals("2")) {
                        String boPhan2 = "Công nghệ thông tin";
                        System.out.println("Chức danh: ");
                        System.out.println("1. Business leader");
                        System.out.println("2. Project Leader");
                        System.out.println("3. Technical Leader");
                        System.out.print("Nhập chức danh: ");
                        nhapChucDanh = sc.next();
                        if(nhapChucDanh.equals("1")) {
                            String chucDanh = "Business leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan2, chucDanh);
                            list.add(managers);
                        } else if (nhapChucDanh.equals("2")) {
                            String chucDanh = "Project Leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan2, chucDanh);
                            list.add(managers);
                        } else if (nhapChucDanh.equals("3")) {
                            String chucDanh = "Technical Leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan2, chucDanh);
                            list.add(managers);
                        }
                    } else if (chonBoPhan.equals("3")) {
                        String boPhan3 = "Marketing";
                        System.out.println("Chức danh: ");
                        System.out.println("1. Business leader");
                        System.out.println("2. Project Leader");
                        System.out.println("3. Technical Leader");
                        System.out.print("Nhập chức danh: ");
                        nhapChucDanh = sc.next();
                        if(nhapChucDanh.equals("1")) {
                            String chucDanh = "Business leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan3, chucDanh);
                            list.add(managers);
                        } else if (nhapChucDanh.equals("2")) {
                            String chucDanh = "Project Leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan3, chucDanh);
                            list.add(managers);
                        } else if (nhapChucDanh.equals("3")) {
                            String chucDanh = "Technical Leader";
                            Manager managers = new Manager(nhapMaNhanVien, nhapTenNhanVien, nhapTuoi, nhapHsLuong, nhapNgayVaoLam, nhapSoNgayNghiPhep, boPhan3, chucDanh);
                            list.add(managers);
                        }
                    }
                }
            }
// Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
            // với chức năng số 5
             if(menu == 5) {
                 System.out.println("1. Tìm tên nhân viên: ");
                 System.out.println("2. Tìm nhân viên bằng mã nhân viên: ");
                 System.out.print("Bạn chon: ");
                 String chon = sc.next();
                 // trường hợp 1 nếu ng dùng muốn tìm thông tin của 1 nhân viên bằng cách là tìm họ và tên của nhân viên đó
                 // ta sử dụng stream.filter để lọc dữ liệu sao cho tên ng dùng nhập vào trùng hớp với tên nhân viên đang có trong danh sách
                 if (chon.equals("1")) {
                     System.out.println("Tên nhân viên cần tìm");
                     Scanner sc2 = new Scanner(System.in);
                     String tenNv = sc2.nextLine();
                     List<Staff> sreachTen = list.stream()
                             .filter(x -> x.getTenNhanVien().equalsIgnoreCase(tenNv))
                             .collect(Collectors.toList());
                     for (Staff sreach : sreachTen) {
                         if (sreach instanceof Employee) {
                             Employee employee = (Employee) sreach;
                             System.out.printf("%-6s%15s%10s%10s%15s%17s%10s%36s%10s\n", "Mã nhân viên", "|Tên nhân viên", "|Tuổi", "|HS lương", "|Ngày vào làm", "|Ngày nghỉ phép", "|Bộ phận", "|Số giờ làm thêm/Chức vụ", "|Lương");
                             System.out.printf("%-6s%25s%4s%7s%18s%7s%33s%5s%31.10s\n", employee.getMaNhanVien(), "|" + employee.getTenNhanVien(), "|" + employee.getTuoiNhanVien(), "|" + employee.getHeSoluong(), "|" + employee.getNgayVaoLam(), "|" + employee.getSoNgayNghiPhep(), "|" + employee.getBoPhanLamViec(), "|" + employee.getSoGioLamThem(), "|" + String.format("%,d", (int) employee.calculateSalary()));
                         } else if (sreach instanceof Manager) {
                             Manager manager = (Manager) sreach;
                             System.out.printf("%-6s%15s%10s%10s%15s%17s%10s%36s%10s\n", "Mã nhân viên", "|Tên nhân viên", "|Tuổi", "|HS lương", "|Ngày vào làm", "|Ngày nghỉ phép", "|Bộ phận", "|Số giờ làm thêm/Chức vụ", "|Lương");
                             System.out.printf("%-6s%25s%4s%7s%18s%6s%35s%7s%15s\n", manager.getMaNhanVien(), "|" + manager.getTenNhanVien(), "|" + manager.getTuoiNhanVien(), "|" + manager.getHeSoluong(), "|" + manager.getNgayVaoLam(), "|" + manager.getSoNgayNghiPhep(), "|" + manager.getBoPhanLamViec(), "|" + manager.getChucDanh(), "|" + String.format("%,d", (int) manager.calculateSalary()));
                         }
                     }
                     // trường hợp 2 là ng dùng có thể tìm nhân viên thông qua cách là sử dụng bằng mã của nhân viên đó
                     // ta sử dụng stream.filter để lọc dữ liệu sao cho mã Nv ng dùng nhập vào trùng hớp với mã nhân viên hiện có trong danh sách
                 }else if(chon.equals("2")){
                     System.out.println("Mã nhân viên cần tìm: ");
                     Scanner sc3 = new Scanner(System.in);
                     String maNv = sc3.next();
                     List<Staff> sreachMa = list.stream()
                             .filter(x -> x.getMaNhanVien().equalsIgnoreCase(maNv))
                             .collect(Collectors.toList());
                     for (Staff sreach : sreachMa) {
                         if (sreach instanceof Employee) {
                             Employee employee = (Employee) sreach;
                             System.out.printf("%-6s%15s%10s%10s%15s%17s%10s%36s%10s\n", "Mã nhân viên", "|Tên nhân viên", "|Tuổi", "|HS lương", "|Ngày vào làm", "|Ngày nghỉ phép", "|Bộ phận", "|Số giờ làm thêm/Chức vụ", "|Lương");
                             System.out.printf("%-6s%25s%4s%7s%18s%7s%33s%5s%31.10s\n", employee.getMaNhanVien(), "|" + employee.getTenNhanVien(), "|" + employee.getTuoiNhanVien(), "|" + employee.getHeSoluong(), "|" + employee.getNgayVaoLam(), "|" + employee.getSoNgayNghiPhep(), "|" + employee.getBoPhanLamViec(), "|" + employee.getSoGioLamThem(), "|" + String.format("%,d", (int) employee.calculateSalary()));
                         } else if (sreach instanceof Manager) {
                             Manager manager = (Manager) sreach;
                             System.out.printf("%-6s%15s%10s%10s%15s%17s%10s%36s%10s\n", "Mã nhân viên", "|Tên nhân viên", "|Tuổi", "|HS lương", "|Ngày vào làm", "|Ngày nghỉ phép", "|Bộ phận", "|Số giờ làm thêm/Chức vụ", "|Lương");
                             System.out.printf("%-6s%25s%4s%7s%18s%6s%35s%7s%15s\n", manager.getMaNhanVien(), "|" + manager.getTenNhanVien(), "|" + manager.getTuoiNhanVien(), "|" + manager.getHeSoluong(), "|" + manager.getNgayVaoLam(), "|" + manager.getSoNgayNghiPhep(), "|" + manager.getBoPhanLamViec(), "|" + manager.getChucDanh(), "|" + String.format("%,d", (int) manager.calculateSalary()));
                         }
                     }
                 }
             }
 // Hiển thị bảng lương của nhân viên theo thứ tự giảm dần
            // với chức năng số 6
            // ta sử dụng phương thức Stream.sorted.reversed để hiện thị bảng lương theo thứ tự giảm dần(từ lớn đến nhỏ)
            // của các đối tượng có trong list
             if (menu == 6){
                 System.out.printf("%-6s%15s%10s%10s%15s%17s%10s%36s%10s\n", "Mã nhân viên", "|Tên nhân viên", "|Tuổi", "|HS lương", "|Ngày vào làm", "|Ngày nghỉ phép", "|Bộ phận", "|Số giờ làm thêm/Chức vụ", "|Lương");
                 List<Staff> decrease = list.stream()
                         .sorted(Comparator.comparing(Staff::calculateSalary)
                                 .reversed()).collect(Collectors.toList());
                 for (Staff find : decrease){
                     if(find instanceof Employee) {
                         Employee employee = (Employee)find;
                         System.out.printf("%-6s%25s%4s%7s%18s%7s%33s%5s%31.10s\n", employee.getMaNhanVien(), "|" + employee.getTenNhanVien(), "|" + employee.getTuoiNhanVien(), "|" + employee.getHeSoluong(), "|" + employee.getNgayVaoLam(), "|" + employee.getSoNgayNghiPhep(), "|" + employee.getBoPhanLamViec(), "|" + employee.getSoGioLamThem(), "|" + String.format("%,d", (int)employee.calculateSalary()));
                     } else if(find instanceof  Manager) {
                         Manager manager = (Manager)find;
                         System.out.printf("%-6s%25s%4s%7s%18s%6s%35s%7s%15s\n", manager.getMaNhanVien(), "|" + manager.getTenNhanVien(), "|" + manager.getTuoiNhanVien(), "|" + manager.getHeSoluong(), "|" + manager.getNgayVaoLam(), "|" + manager.getSoNgayNghiPhep(), "|" + manager.getBoPhanLamViec(), "|" + manager.getChucDanh(), "|" + String.format("%,d", (int)manager.calculateSalary()));
                     }
                 }
             }
//Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
            // với chức năng 7
            // ta sử dụng Stream.sorted để hiển thị số lương tăng dần(từ nhỏ đến lớn) của các đối tượng có trong list
             if(menu == 7){
                 System.out.printf("%-6s%15s%10s%10s%15s%17s%10s%36s%10s\n", "Mã nhân viên", "|Tên nhân viên", "|Tuổi", "|HS lương", "|Ngày vào làm", "|Ngày nghỉ phép", "|Bộ phận", "|Số giờ làm thêm/Chức vụ", "|Lương");
                 List<Staff> sortedList = list.stream()
                         .sorted(Comparator.comparing(person -> person.calculateSalary()))
                         .collect(Collectors.toList());
                 for (Staff find : sortedList){
                     if(find instanceof Employee) {
                         Employee employee = (Employee)find;
                         System.out.printf("%-6s%25s%4s%7s%18s%7s%33s%5s%31.10s\n", employee.getMaNhanVien(), "|" + employee.getTenNhanVien(), "|" + employee.getTuoiNhanVien(), "|" + employee.getHeSoluong(), "|" + employee.getNgayVaoLam(), "|" + employee.getSoNgayNghiPhep(), "|" + employee.getBoPhanLamViec(), "|" + employee.getSoGioLamThem(), "|" + String.format("%,d", (int)employee.calculateSalary()));
                     } else if(find instanceof  Manager) {
                         Manager manager = (Manager)find;
                         System.out.printf("%-6s%25s%4s%7s%18s%6s%35s%7s%15s\n", manager.getMaNhanVien(), "|" + manager.getTenNhanVien(), "|" + manager.getTuoiNhanVien(), "|" + manager.getHeSoluong(), "|" + manager.getNgayVaoLam(), "|" + manager.getSoNgayNghiPhep(), "|" + manager.getBoPhanLamViec(), "|" + manager.getChucDanh(), "|" + String.format("%,d", (int)manager.calculateSalary()));
                     }
                 }
             }
        }while (menu >= 1);
    }

}
