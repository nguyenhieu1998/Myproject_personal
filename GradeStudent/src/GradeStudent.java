import java.util.ArrayList;
import java.util.Scanner;

public class GradeStudent {
    public static int score;
    public static int max;
    public static int sumOfScore;
    public static int sumOfMax;

    public static void main(String[] args) {
        begin();

        double midTermPoints = midTern();// lấy tổng điểm theo trọng số của hàm midTern
        System.out.println();

        double finalTermPoints = finalTerm();// lấy tổng điểm theo trọng số của hàm finalTerm
        System.out.println();

        double homeworkPoints = homework();// lấy tổng điểm theo trọng số của hàm homework
        System.out.println();
        // sau khi lấy dk tổng điểm theo trọng số của 3 hàm thì cộng tổng điểm 3 hàm này lại
        //rồi chuyền param qua hàm report và hiển thị điểm Overall percentage
        double totalPoints = midTermPoints + finalTermPoints + homeworkPoints;
        report(totalPoints);
    }
    public static void begin(){// Hiển thị thông điệp chào mừng
        System.out.println("This program reads exam/homework scores");
        System.out.print("and reports your overall course grade.");
        System.out.println("\n");
        System.out.println("Midterm: ");
    }
    public static double midTern(){// hiển thị và nhận dữ liệu điểm số cho kì thi giữa kỳ
        int maxScore = 100;
        int weightMidTern;
        int scoreMidTern;
        int shiftAmount;
        String answer;
        double weightedScore = 0;


        Scanner scan = new Scanner(System.in);
        System.out.print("Weight (0-100) = ");
        weightMidTern = scan.nextInt();// nhận dữ điệu trọng số của điểm thi giữa kỳ
        System.out.print("Score earned = ");
        scoreMidTern = scan.nextInt();// nhận dữ liệu là số điểm của người dùng đạt được

        System.out.print("Were scores shifted (1=yes, 2=no)? ");// check xem điểm thi của người dùng có được tăng ko
        answer = scan.next();
        if(answer.equals("1")){// nếu được tăng nhận dữ liệu đầu vào là String 1
            System.out.print("Shift amount = ");// nhận dữ liệu điểm thi đã tăng của ng dùng
            shiftAmount = scan.nextInt();

            int sum = scoreMidTern + shiftAmount;// để lấy được tổng số điểm đã tăng ta lấy điểm thi của ng dung đã đạt đk
            int minTotal = Math.min(sum, maxScore);// sử dụng phương thức Math.min để lấy số điểm tổng ko vượt quá max là 100đ
            System.out.println("Total point = " + minTotal + " / " +maxScore);//hiển thị tổng số điểm tổng số điểm khi đã được tăng

            // thì ta lấy điểm thi đã đạt được + với điểm đã được tăng chia cho số điểm tối đa cho phép là 100 sau đó nhân với trọng số của điểm thi giữa kỳ
            weightedScore = (double)minTotal / maxScore * (double) weightMidTern;
            weightedScore = (double)Math.round(weightedScore*10)/10;
            System.out.println("Weighted score = " + weightedScore + " / " + weightMidTern);
        }
        else if (answer.equals("2")) {// nếu điểm thi của ng dùng ko được tăng thì nhập String "2"
            System.out.println("Total points = " + scoreMidTern + " / " + maxScore);// hiển thị tổng số điểm
            weightedScore = ((double)scoreMidTern / maxScore) * weightMidTern;// hiển thị điểm số đã tính dựa theo trọng số và ko có điểm tăng
            weightedScore = (double)Math.round(weightedScore*10)/10;
            System.out.println("Weighted score = " + weightedScore + " / " + weightMidTern);

        }
        return weightedScore;// rồi trả về số điểm đã tính dựa theo trọng số để lấy dữ liệu này làm tiếp cho hàm report
    }
    public static double finalTerm(){ // hiển thị điểm số cho kỳ thi cuối kỳ
        System.out.println("Final: ");
        int maxScore = 100;
        int weightMidTern;
        int scoreMidTern;
        int shiftAmount;
        String answer;
        double weightedScore = 0;


        Scanner scan = new Scanner(System.in);
        System.out.print("Weight (0-100) = ");
        weightMidTern = scan.nextInt();
        System.out.print("Score earned = ");
        scoreMidTern = scan.nextInt();

        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        answer = scan.next();
        if(answer.equals("1")){
            System.out.print("Shift amount = ");
            shiftAmount = scan.nextInt();

            int sum = scoreMidTern + shiftAmount;
            int minTotal = Math.min(sum, maxScore);
            System.out.println("Total point = " + minTotal + " / " +maxScore);
            weightedScore = (double)minTotal / maxScore * (double) weightMidTern;
            weightedScore = (double)Math.round(weightedScore*10)/10;
            System.out.println("Weighted score = " + weightedScore + " / " + weightMidTern);
        }
        else if (answer.equals("2")) {
            System.out.println("Total points = " + scoreMidTern + " / " + maxScore);
            weightedScore = ((double)scoreMidTern / maxScore) * weightMidTern;
            weightedScore = (double)Math.round(weightedScore*10)/10;

            System.out.println("Weighted score = " + weightedScore + " / " + weightMidTern);

        }
        return weightedScore;
    }

    public static double homework(){ // hiển thị điểm số bài tập về nhà
        int weightHomework;
        int assignments;
        System.out.println("Homework: ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Weight (0-100) = ");// nhận dữ liệu đầu vào cho trọng số điểm bài tập về nhaf
        weightHomework = scan.nextInt();

        System.out.print("Number of Assignments? ");// nhận dữ liệu đầu vào cho tổng số bài tập cần làm
        assignments = scan.nextInt();

        ArrayList<int[]> arrayList = new ArrayList<>(); // khởi tạo 1 Array list
        // list này sẽ lưu các danh sách mảng gồm score và max

        for (int i = 1; i <= assignments;i++) {
            // sử dụng forloop để hiện thì lượng bài tập trùng với tổng số bài tập phải làm của ng dùng nhập vào
            // VD: tổng số bài tập là 3 thì phải hiện các bài tập từ 1-3 để ng dùng nhập dữ liệu đầu vào
            System.out.print("Assignment " + i + " score and max ");
            GradeStudent.score = scan.nextInt();//nhận dữ liệu điểm của SV của bài asm
            GradeStudent.max = scan.nextInt();// nhận dữ liệu điểm tối đa cho phép của bài asm đó

            int[] st = new int[2];// khỏi tạo mảng nhận 2 phần tử của mảng
            st[0] = GradeStudent.score;//phần tử đầu tiên nhận số điểm bài tập mà ng dùng đạt được
            st[1] = GradeStudent.max;// phần tử tiếp theo sẽ nhận số điểm tối đa cho phép của bài tập đó
            arrayList.add(st);//gọi lại lớp ArrayList sử dụng phương thức add để thêm mảng nhận 2 phần từ vào ArrayList
            System.out.println(arrayList.size());
        }

        int attendHomework;// biến lưu số buổi mà sinh viên đã điểm danh
        System.out.print("How many section do you attend? ");
        attendHomework = scan.nextInt();//nhận dữ liệu số buổi học mà sv đã điểm danh

        int maxAttend = 30;
        int sections = attendHomework * 5;//lấy số ngày đã điểm danh * 5

        System.out.println("Section point = " + Math.min(sections,maxAttend) + " / " + maxAttend);

        GradeStudent.sumOfScore = sections;
        GradeStudent.sumOfMax = maxAttend;

        for (int i = 0; i < arrayList.size();i++) {
            GradeStudent.sumOfScore += arrayList.get(i)[0];// tính tổng điểm của các bài asm mà sv đạt được
            GradeStudent.sumOfMax += arrayList.get(i)[1];// tính tổng điểm tối đa cho phép của các bài asm
        }
        int maxScoreAsm = 150;
        System.out.println("Total point = " + Math.min(GradeStudent.sumOfScore,maxScoreAsm) + " / " + Math.min(GradeStudent.sumOfMax,maxScoreAsm));
            double weightedScore = (double)GradeStudent.sumOfScore / (double) GradeStudent.sumOfMax * weightHomework;
            System.out.println("Weighted score = " + (double)Math.round(weightedScore*10)/10 + " / " + weightHomework);
        return weightedScore;// rồi trả về số điểm đã tính dựa theo trọng số để lấy dữ liệu này làm tiếp cho hàm report
    }


    public static void report(double totalPoints){// để tính toán về hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng.
        // sau khi ta đã tính tổng điểm sinh viên đạt được của 3 môn tính theo thang 100
        // ta truyển param vào report để hiện thị ra console
        String comments;

        System.out.println("Overall percentage = " + (double)Math.round(totalPoints*10)/10);

        if(totalPoints >= 85){
            System.out.println("Your grade will be at leasst: 3.0");
        } else if (totalPoints >= 75) {
            System.out.println("Your grade will be at leasst: 2.0");
        } else if (totalPoints >= 60) {
            System.out.println("Your grade will be at leasst: 1.0");
        } else if (totalPoints < 60) {
            System.out.println("Your grade will be at leasst: 0.0");
        }else {
            System.out.println("Your grade will be at leasst: 4.0");
        }

        comments = "Congratulations to you. Successfully completed this exam";
        System.out.println("\n<< " + comments + " >> ");


    }
}
