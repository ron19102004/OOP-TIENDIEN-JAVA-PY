import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Receipt extends Client {
    private int oldIndex, newIndex, moneyToBePaid ;
    public Receipt(ArrayList<Client> clients){
        this.enterInfo(clients);
    }
    public void enterInfo(ArrayList<Client> cn){
        Scanner input = new Scanner(System.in);
        super.enterInfo(cn);
        int error = 0;
        while(true){
            System.out.print("Nhập chỉ số điện cũ: ");
            String oldIndex = input.nextLine().trim();
            if(!oldIndex.isBlank()&&super.isNumeric(oldIndex)){
                this.oldIndex = Integer.parseInt(oldIndex);
                break;
            } else {
                System.out.println("Dữ liệu nhập vào không hợp lệ !!! Vui lòng nhập lại.");
                if (error == 2){
                    System.out.println("Có vẻ đã có lỗi nhập liệu tại đây.Hệ thống sẽ được đóng.");
                    throw new InputMismatchException("Oops, lỗi nhập dữ liệu.");
                }
                error++;
                DrawLine();
            }
        }
        while(true){
            System.out.print("Nhập chỉ số điện mới: ");
            String newIndex = input.nextLine().trim();
            if(!newIndex.isBlank()&&super.isNumeric(newIndex)){
                if(Integer.parseInt(newIndex) >= this.oldIndex){
                    this.newIndex = Integer.parseInt(newIndex);
                    break;
                } else  {
                    DrawLine();
                    System.out.println("Chỉ số điện mới không hợp lệ. Vui lòng nhập lại");
                    DrawLine();
                }
            } else {
                System.out.println("Dữ liệu nhập vào không hợp lệ !!! Vui lòng nhập lại.");
                if (error == 4){
                    System.out.println("Có vẻ đã có lỗi nhập liệu tại đây.Hệ thống sẽ được đóng.");
                    throw new InputMismatchException("Oops, lỗi nhập dữ liệu.");
                }
                error++;
                DrawLine();
            }
        }
        this.moneyToBePaid = (newIndex - oldIndex) * 750;
        DrawLine();
    }
    public void showInfo(){
        super.showInfo();
        System.out.println("Chỉ số điện đầu: " + this.oldIndex + "| Chỉ số điện cuối: " + this.newIndex);
        System.out.println("Tiền điện phải trả: " + this.moneyToBePaid + "$");
        DrawLine();
    }

}
