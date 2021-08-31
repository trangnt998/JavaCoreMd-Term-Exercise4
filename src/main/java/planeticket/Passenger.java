package planeticket;

import java.util.Scanner;

public class Passenger {
    private String hoTen;
    private boolean gioiTinh;
    private int tuoi;
    private Ticket[] danhSachVe;

    public Passenger() {

    }

    public Passenger(String hoTen, boolean gioiTinh, int tuoi, Ticket[] danhSachVe) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.danhSachVe = danhSachVe;
    }

    public void input() {//Nhập thông tin hành khách từ console
        Scanner sc = new Scanner(System.in);

        System.out.print("Họ tên: ");
        this.hoTen = sc.nextLine();

        System.out.print("Giới tính (Nam = true, Nữ = false): ");
        this.gioiTinh = sc.nextBoolean();

        System.out.print("Tuổi: ");
        this.tuoi = sc.nextInt();
        if (this.tuoi < 0) {
            System.out.println("Tuổi không đúng!");
        }

        System.out.print("Số vé cần mua: ");
        int numberOfTicket = sc.nextInt();
        Ticket[] tickets = new Ticket[numberOfTicket];
        if (numberOfTicket > 0) {
            for (int i = 0; i < numberOfTicket; i++) {
                tickets[i] = new Ticket();
                tickets[i].input();
            }
        }
        this.danhSachVe = tickets;
    }

    public String toString() {//Xuất thông tin
        if (tuoi >= 0) {
            String infoPassenger = "";
            infoPassenger += "Họ tên: " + hoTen + "\nGiới tính: " + gioiTinh + "\nTuổi: " + tuoi;
            for (int i = 0; i < this.danhSachVe.length; i++) {
                infoPassenger += "\nThông tin vé " + (i + 1) + ":\n" + this.danhSachVe[i].toString();
            }
            return infoPassenger;
        }
        return "Tuổi không đúng!";
    }

    public int tinhTongTien() {//trả về tổng số tiền phải trả của hành khách ứng với số vé đã mua
        if (tuoi >= 0) {
            int ammount = 0;
            for (int i = 0; i < this.danhSachVe.length; i++) {
                ammount += this.danhSachVe[i].getGiaVe();
            }
            return ammount;
        }
        return -1;
    }

}
