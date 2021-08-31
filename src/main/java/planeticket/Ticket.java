package planeticket;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Ticket {
    private String tenChuyen;
    private LocalDateTime ngayBay;
    private int giaVe;

    public Ticket() {
    }

    public Ticket(String tenChuyen, LocalDateTime ngayBay, int giaVe) {
        this.tenChuyen = tenChuyen;
        this.ngayBay = ngayBay;
        this.giaVe = giaVe;
    }


    public void input() {//Nhập thông tin vé từ console
        Scanner sc = new Scanner(System.in);

        System.out.print("Tên chuyến bay: ");
        this.tenChuyen = sc.nextLine();

        System.out.println("Thời gian bay: ");
        System.out.print("Ngày: ");
        int day = sc.nextInt();
        System.out.print("Tháng: ");
        int month = sc.nextInt();
        System.out.print("Năm: ");
        int year = sc.nextInt();
        System.out.print("Giờ: ");
        int hour = sc.nextInt();
        System.out.print("Phút: ");
        int minute = sc.nextInt();
        System.out.print("Giây: ");
        int second = sc.nextInt();

        this.ngayBay = LocalDateTime.of(year, month, day, hour, minute, second);

        System.out.print("Giá vé: ");
        this.giaVe = sc.nextInt();
        if (this.giaVe < 0) {
            System.out.println("Nhập sai giá vé!");
        }
    }

    public String toString() {//Xuất thông tin vé thành chuỗi (toString)
        if (giaVe >= 0) {
            String infoTicket = "";
            infoTicket += "Chuyến bay: " + tenChuyen + "\nNgày bay: " + ngayBay + "\nGiá vé: " + giaVe;
            return infoTicket;
        }
        return "Giá vé sai!";
    }

    public int getGiaVe() {//trả về giá vé
        if (giaVe >= 0) {
            return giaVe;
        }
        return -1;
    }

}
