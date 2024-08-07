package utils;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

/*
Inputter: là 1 cái khuôn
nhưng anh k thích dùng inputter để đúc ra object
mà anh dùng Inputter để lưu những hàm tiện ích hỗ trợ cho việc nhập


nhưng trong java thì lại k có Hàm
 */
public class Inputter {

    //props
    public static Scanner sc = new Scanner(System.in);
    //những method hỗ trợ việc nhập

    //1.method ép ng dùng nhập số nguyên chuẩn
    public static int getAnInteger(String inpMsg, String errMsg) {
        System.out.println(inpMsg);//hiển thị lời mời
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //2.method ép ng dùng nhập số nguyên chuẩn nhưng trong khoảng
    public static int getAnInteger(String inpMsg, String errMsg,
            int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {//dành cho người vô tri
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        System.out.println(inpMsg);//hiển thị lời mời
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //3.method ép ng dùng nhập số thực chuẩn
    public static double getADouble(String inpMsg, String errMsg) {
        System.out.println(inpMsg);//hiển thị lời mời
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //4.method ép ng dùng nhập số thực chuẩn nhưng trong khoảng
    public static double getADouble(String inpMsg, String errMsg,
            double lowerBound, double upperBound) {
        if (lowerBound > upperBound) {//dành cho người vô tri
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        System.out.println(inpMsg);//hiển thị lời mời
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }

    //5. Hàm nhập chuỗi cấm để trống
    public static String getString(String inpMsg, String errMsg) {
        System.out.println(inpMsg);//mời nhập
        while (true) {
            try {
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println(errMsg);//câu chửi
            }
        }
    }

    //6. Hàm nhập chuỗi cấm để trống và phải giống regex
    public static String getString(String inpMsg, String errMsg, String regex) {
        System.out.println(inpMsg);//mời nhập
        while (true) {
            try {
                String str = sc.nextLine();
                if(str.matches(regex)){
                    return str;
                }
                if (str.isEmpty() || !str.matches(regex)) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println(errMsg);//câu chửi
            }
        }
    }

    public static LocalDate getDate(String inpMsg, String errMsg) {

        System.out.println(inpMsg);
        while (true) {
            try {
                LocalDate date = LocalDate.parse(Inputter.getString("yyyy-mm-dd", errMsg, "^\\d{4}-\\d{2}-\\d{2}$"));

                return date;
            } catch (DateTimeException e) {
                System.err.println("Invalid date: " + e);
            }
        }

    }

}

//(hàm nhập ngày tháng năm): homework
//f("nhap ngay thang na nhe:" , "ngu", "DD-MM-YYYY", "YYYY-MM-DD");
//compareDate
