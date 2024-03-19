package QLHSJAVA;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("C:\\Users\\Administrator\\eclipse-workspace\\QLHS\\src\\QLHSJAVA\\students_input.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Administrator\\eclipse-workspace\\QLHS\\src\\QLHSJAVA\\students_output.txt"))) {

            // Đọc số lượng học sinh từ dòng đầu tiên
            if (scanner.hasNextLine()) {
                int numStudents = Integer.parseInt(scanner.nextLine().trim());
                System.out.println("Số học sinh: " + numStudents);
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) { // Kiểm tra xem dòng có đúng 5 phần hay không
                    String maSinhVien = parts[0].trim();
                    String hoTen = parts[1].trim();
                    String gioiTinh = parts[2].trim();
                    double diemPython = Double.parseDouble(parts[3].trim());
                    double diemJava = Double.parseDouble(parts[4].trim());

                    Student student = new Student(maSinhVien, hoTen, gioiTinh, diemPython, diemJava);
                    students.add(student);
                } else {
                    System.out.println("Dòng không đúng định dạng: " + line);
                }
            }

            // Sắp xếp học viên theo điểm trung bình giảm dần
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return Double.compare(s2.getDiemTB(), s1.getDiemTB());
                }
            });

            // In danh sách học viên và ghi vào file
            for (Student student : students) {
                writer.println(student);
                System.out.println(student);
            } writer.close();

         // Hiển thị thông tin những bạn đã đậu
            System.out.println("Thông tin những bạn đã đậu:");
            for (Student student : students) {
                if (student.getKetQua().equals("Đậu")) {
                    System.out.println(student);
                }
            }

            // Hiển thị thông tin những bạn đã trượt
            System.out.println("Thông tin những bạn đã trượt:");
            for (Student student : students) {
                if (student.getKetQua().equals("Trượt")) {
                    System.out.println(student);
                }
            }

            // Nhập vào họ tên học viên cần tìm
            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Nhập họ tên học viên cần tìm: ");
            String searchName = inputScanner.nextLine();

            // Tìm kiếm học viên theo họ tên
            boolean found = false;
            for (Student student : students) {
                if (student.getHoTen().equalsIgnoreCase(searchName)) {
                    System.out.println("Học viên được tìm thấy: " + student);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy học viên có họ tên: " + searchName);
            }

            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
