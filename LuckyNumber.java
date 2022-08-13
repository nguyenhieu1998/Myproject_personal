import java.util.Random;
import java.util.Scanner;

// sử dụng static glabol để tạo ra các biến lưu trữ dữ liệu trò chơi
class Number {
    static double tonglandudoan; // biến lữu trữ tổng số lần dự đoán số
    static Integer minGuess;   // biến lưu trữ số lần dự đoán cuối cùng
    static double everyTurn;    // Số lần dự đoán trung bình mỗi lượt
}

// Tạo 1 lớp cho project là Luckynumber
public class LuckyNumber {

    public static int solandudoan = 0;

    public static void main(String[] args) {
        System.out.println("Tôi đang nghĩ một số trong khoản từ 0 đến 55...");
        play();
        report();
    }
    //tạo hàm play để thực hiện trò chơi
    public static void play(){
        boolean correct = false;
//        int solandudoan = 0;
        Random number = new Random(); // sử dụng hàm Rondom để tạo 1 số ngẫu nghiên cho mỗi lần chơi
        int randomNumber = number.nextInt(56); // setting con số dự đoán nằm trong khoảng 0- 100
//        System.out.println(randomNumber);
        Scanner sc = new Scanner(System.in); // sử hàm Scanner để check con số của người dùng nhập vào
        int inputNumber;

        // sử dụng vòng lặp white để thực hiện trò chơi
        // sau mỗi lần dự đoán sai và có thể dự đoán lại
        while (!correct){
            System.out.print("Bạn đoán? ");
            inputNumber = sc.nextInt();
            LuckyNumber.solandudoan++;
            Number.tonglandudoan++;
            Number.everyTurn++;
            if (inputNumber == randomNumber){
                correct = true;
                System.out.println("chúc mừng bạn đã dự đoán đúng con số may mắn sau " + LuckyNumber.solandudoan +" lần dự đoán");
            } else if(inputNumber > randomNumber){
                System.out.println("số may mắn nhỏ hơn số dự đoán của bạn. ");
            } else if (inputNumber < randomNumber) {
                System.out.println("số may mắn lớn hơn số dự đoán của bạn. ");
            }
        }
    }
    public static void report(){
        Scanner sc = new Scanner(System.in);
        String answer = "";
        int solanchoi = 0;

            do {
                System.out.println("Bạn có muốn chơi tiếp không? ");
                answer = sc.next();
                solanchoi++;

                if (Number.minGuess == null || LuckyNumber.solandudoan < Number.minGuess) {
                    // Tìm giá trị dự đoán nhỏ nhất ở thời điểm hiện tại
                    Number.minGuess = LuckyNumber.solandudoan;
                }

                // tạo điều kiện khi ng dùng muốn chơi tiếp thì viết "yes"
                if(answer.equalsIgnoreCase("yes")) {
                    // Reset giá trị solandudoan
                    LuckyNumber.solandudoan = 0;
                    play();
                    // nếu người dùng muốn dùng lại cuộc chơi thì viết "No"
                } if (answer.equalsIgnoreCase("No")) {
                    // chuyển đổi tonglandudoan vs solanchoi từ kiểu int sang double để hiện số lượi đoán trung bình
                    Number.everyTurn = Number.tonglandudoan / (double)solanchoi;
                    System.out.println("Kết quả tổng quát của trò chơi:");
                    System.out.println("Tổng số lần chơi = " + solanchoi);
                    System.out.println("Tổng số lần dự đoán = " + (int)Number.tonglandudoan);// hiện tại tonglandudoan đang ở kiểu doule
                    // thì chuyển sang kiểu int để hiện tonglandudoan thành 1 số nguyên
                    System.out.println("Số lần dự đoán trung bình mỗi lượt = " + (double)Math.round(Number.everyTurn * 10)/10);
                    // sử dụng Math.round làm tròn 1 số thập phân
                    System.out.println("số lần dự đoán ít nhất = " + Number.minGuess);
                    break;
                }
            } while (answer.equalsIgnoreCase("yes"));

    }
}
