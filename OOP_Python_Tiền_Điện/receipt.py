from client import Client

class Receipt(Client):
    def __init__(self, listCustomers):
        super().enterInfo(listCustomers)
        self.enterElectricIndex()
    def getMoneyToBePaid(self):
        return self.moneyToBePaid
    def setOldIndex(self,oldIndex):
        self.oldIndex = oldIndex
    def setNewIndex(self,newIndex):
        self.newIndex = newIndex
    def enterElectricIndex(self):
        while True:
            oldIndex = int(input("Nhập chỉ số đầu: "))
            newIndex = int(input("Nhập chỉ số cuối:"))
            if oldIndex < 0 or newIndex < 0: 
                super().drawLine()
                print("Chỉ số không hợp lệ")
                super().drawLine()
            else:
                if oldIndex < newIndex:
                    self.setOldIndex(oldIndex)
                    self.setNewIndex(newIndex)
                    break
                else:
                    super().drawLine()
                    print("Lỗi chỉ số đầu lớn hơn chỉ số cuối !!!")
                    super().drawLine()
        self.moneyToBePaid= (self.newIndex - self.oldIndex) * 750
    def showInfo(self):
        super().drawLine()
        super().showInfo();
        print(f"Chỉ số đầu: {self.oldIndex}")
        print(f"Chỉ số cuối: {self.newIndex}")
        print(f"->Số tiền trả: {self.moneyToBePaid} VNĐ")
        super().drawLine()
    

