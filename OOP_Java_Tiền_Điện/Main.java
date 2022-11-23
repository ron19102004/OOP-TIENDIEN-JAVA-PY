package OOP;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void DrawLine() {
        for(int i = 0; i <= 50; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }
    public static void menuTab(int index){
        System.out.println("Xin chào. Đây là hệ thống quản lý tiền điện .");
        if(index <= 0) System.out.println("Hiện tại hệ thống chưa quản lí hộ gia đình nào cả. ");
        else System.out.println("Hiện tại hệ thống đang quản lí " + index + " hộ gia đình.");
        System.out.print("""
        Hãy xem các lựa chọn dưới đây:
        0- Thoát hệ thống.
        1- Nhập thông tin hộ gia đình.
        2- Hiển thị thông tin biên lai.
        ==> Chọn:\s""");
    }
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<Client>();
        try(Scanner input = new Scanner(System.in)){
            int numberClient = 0;
            while (true){
                menuTab(numberClient);
                int selectMenu = input.nextInt();
                DrawLine();
                if (selectMenu == 0) break;
                switch (selectMenu){
                    case 1:
                        System.out.print("Bạn muốn nhập bao nhiêu hộ gia đình: ");
                        int numClient= input.nextInt();
                        numberClient += numClient;
                        for(int index = 0; index < numClient; index++){
                            Client aClient = new Receipt(clients);
                            clients.add(aClient);
                        }
                        break;
                    case 2:
                        if(clients.size() != 0){
                            for(Client cln : clients){
                                cln.showInfo();
                            }
                        } else {
                            System.out.println("Hiện tại chưa có hộ gia đình nào có trong hệ thống. Vui lòng thêm thông tin !!!");
                            DrawLine();
                        }
                        break;
                    default:
                        System.out.println("Sự lựa chọn không hợp lệ. Vui lòng thử lại !!!");
                        DrawLine();
                }
            }
        } catch (InputMismatchException e){
            System.out.println("Error!!! " + e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
