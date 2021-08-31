package planeticket;

import java.util.Scanner;

public class App {
    /**
     * Nhập vào 1 danh sách n hành khách (n nhập từ bàn phím).
     * Hiển thị danh sách hành khách và số tiền phải trả tương ứng của mỗi khách hàng.
     * Sắp xếp danh sách hành khách theo chiều giảm dần của Tổng tiền.
     * Hiển thị lại danh sách hành khách và số tiền phải trả tương ứng của mỗi khách hàng.
     */

    public static Passenger[] inputListPassenger(int n) {//Nhập danh sách khách hàng
        Passenger[] passengers = new Passenger[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Hành khách: " + (i + 1));
            passengers[i] = new Passenger();
            passengers[i].input();
        }
        return passengers;
    }

    public static void displayListPassengerWithAmmount(Passenger[] passengers) {//Hiển thị danh sách hành khách và số tiền phải trả tương ứng của mỗi khách hàng.
        for (int i = 0; i < passengers.length; i++) {
            System.out.println(passengers[i].toString());
            System.out.println("---------> Tổng số tiền phải trả: " + passengers[i].tinhTongTien());
        }
    }

    public static void sortByAmmountAsc(Passenger[] passengers) {//Sắp xếp danh sách hành khách theo chiều giảm dần của Tổng tiền.
        Passenger[] listPassenger = passengers.clone();
        for (int i = 0; i < listPassenger.length - 1; i++) {
            for (int j = i + 1; j < listPassenger.length; j++) {
                Passenger tmp = listPassenger[i];
                if (listPassenger[j].tinhTongTien() > listPassenger[i].tinhTongTien()) {
                    listPassenger[i] = listPassenger[j];
                    listPassenger[j] = tmp;
                }
            }
        }

        for (int i = 0; i < listPassenger.length; i++) {
            System.out.println("=======" + (i + 1) + "==========");
            System.out.println(listPassenger[i].toString());
        }
    }

    public static void main(String[] args) {
        System.out.print("Nhập số lượng hành khách: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Passenger[] passengers = inputListPassenger(n);

        System.out.println("====================================\n" +
                "Danh sách hành khách và số tiền phải trả:");
        displayListPassengerWithAmmount(passengers);

        System.out.println("=====================================\n" +
                "Danh sách hành khách sắp xếp theo chiều giảm dần của tổng tiền: ");
        sortByAmmountAsc(passengers);

        System.out.println("=====================================\n" +
                "Hiển thị lại danh sách hành khách và số tiền phải trả: ");
        displayListPassengerWithAmmount(passengers);


    }
}
