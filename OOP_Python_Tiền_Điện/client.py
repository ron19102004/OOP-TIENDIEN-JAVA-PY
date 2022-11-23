class Client:

    def setFullNameOfClient(self,fullNameOfClient):
        self.fullNameOfClient= fullNameOfClient.upper()
    def setElectricMeterCode(self,electricMeterCode):
        self.electricMeterCode=electricMeterCode
    def setApartmentNumber(self,apartmentNumber):
        self.apartmentNumber = apartmentNumber
    def getFullNameOfClient(self):
        return self.fullNameOfClient
    def getElectricMeterCode(self):
        return self.electricMeterCode
    def getApartmentNumber(self):
        return self.apartmentNumber
    def enterInfo(self,listCustomers):
        self.setFullNameOfClient(str(input("Nhập tên khách hàng:")))
        if len(listCustomers) != 0 :
            while True:
                check = False
                aptNum = int(input("Nhập số nhà:"))
                for item in listCustomers:
                    if aptNum == int(item.getApartmentNumber()):
                         check = True
                         self.drawLine()
                         print("Số nhà đã tồn tại vui lòng nhập lại.")
                         self.drawLine()
                if(check==False):
                    self.setApartmentNumber(aptNum)
                    break
            while True:
                check = False
                electMC = int(input("Nhập số công tơ điện: "))
                for item in listCustomers:
                    if electMC == int(item.getElectricMeterCode()):
                        check = True
                        self.drawLine()
                        print("Số công tơ điện đã tồn tại vui lòng nhập lại")
                        self.drawLine()
                if(check == False):
                    self.setElectricMeterCode(electMC)
                    break
        else :
            self.setApartmentNumber(int(input("Nhập số nhà: ")))
            self.setElectricMeterCode(int(input("Nhập số công tơ điện: ")))
    def showInfo(self):
       print(f"Tên: {self.getFullNameOfClient()}")
       print(f"Số nhà: {self.getApartmentNumber()}")
       print(f"Số công tơ điện: {self.getElectricMeterCode()}")
    def drawLine(self):
        print("-----------------------------------------------------------------------")
    