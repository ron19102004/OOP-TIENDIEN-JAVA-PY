package OOP;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    private String fullNameOfClient,electricMeterCode,apartmentNumber;

    public void enterInfo(ArrayList<Client> cln){
        Scanner input = new Scanner(System.in);
        int isError = 0;
        while (true) {
            System.out.print("Tên chủ hộ : ");
            String name = input.nextLine().trim().toUpperCase();
            if(!name.isBlank()&&!this.isNumeric(name)&&this.isNotSpecialSymbols(name)){
                this.fullNameOfClient = name;
                break;
            } else {
                if (isError==4){
                    throw new InputMismatchException("Error !!! Lỗi nhập số hoặc ký tự đặc biệt vào tên. Vui lòng chạy lại hệ thống.");
                }
                isError++;
                DrawLine();
                if (isError==4) {
                    System.out.println("Tên sinh viên không hợp lệ. Vui lòng nhập lại lần cuối.");
                } else {
                    System.out.println("Tên sinh viên không hợp lệ. Vui lòng nhập lại.");
                }
                DrawLine();
            }
        }
        while(true){
            System.out.print("Số nhà: ");
            String apartNum = input.nextLine().trim();
            if(!apartNum.isBlank()&&this.isNotSpecialSymbols(apartNum))
            {
                boolean checkAN = true;
                for(Client cl : cln){
                    if(Objects.equals(cl.getApartmentNumber(), apartNum)){
                        System.out.println("Số nhà đã tồn tại. Vui lòng kiểm tra lại");
                        checkAN = false;
                    }
                }
                if(checkAN){
                    this.apartmentNumber = apartNum;
                    break;
                }
            } else {
                if (isError==6){
                    throw new InputMismatchException("Error !!! Lỗi nhập số nhà. Vui lòng chạy lại hệ thống.");
                }
                isError++;
                DrawLine();
                if (isError==6) {
                    System.out.println("Số nhà không hợp lệ. Vui lòng nhập lại lần cuối.");
                } else {
                    System.out.println("Số nhà không hợp lệ. Vui lòng nhập lại.");
                }
                DrawLine();
            }
        }
        while(true){
            System.out.print("Mã số công tơ: ");
            String EMC = input.nextLine().trim();
            if(!EMC.isBlank()&&this.isNotSpecialSymbols(EMC)){
                boolean checkEMC = true;
                for(Client cl : cln){
                    if(Objects.equals(cl.getElectricMeterCode(), EMC)){
                        System.out.println("Mã số công tơ đã tồn tại. Vui lòng kiểm tra lại");
                        checkEMC = false;
                    }
                }
                if(checkEMC){
                    this.electricMeterCode = EMC;
                    break;
                }
            } else {
                if (isError==6){
                    throw new InputMismatchException("Error !!! Lỗi nhập mã số công tơ. Vui lòng chạy lại hệ thống.");
                }
                isError++;
                DrawLine();
                if (isError==6) {
                    System.out.println("Mã số công tơ không hợp lệ. Vui lòng nhập lại lần cuối.");
                } else {
                    System.out.println("Mã số công tơ không hợp lệ. Vui lòng nhập lại.");
                }
                DrawLine();
            }
        }
    }
    public String getApartmentNumber(){
        return this.apartmentNumber;
    }
    public String getElectricMeterCode(){
        return this.electricMeterCode;
    }
    public void showInfo(){
        System.out.println("Tên chủ hộ: " + this.fullNameOfClient);
        System.out.println("Số nhà: " + this.apartmentNumber);
        System.out.println("Mã số công tơ điện: " + this.electricMeterCode);
    }
    public  void DrawLine() {
        for(int i = 0; i <= 50; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }
    public  boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public  boolean isNotSpecialSymbols(String str){
        return !str.matches("\\p{Punct}");
    }
}
