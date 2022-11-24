from receipt import Receipt


def menu():
    print(f"""
    Chào Mừng Bạn Đến Hệ Thống Quản Lý Tiền Điện
    0- Thoát hệ thống
    1- Nhập thông tin khách hàng
    2- Hiển thị tất cả thông tin cách hàng
    """)


listCustomers = []
while True:
    menu()
    select = input("Vui lòng nhập lựa chọn: ")
    if str(select).isdigit():
        select = int(select)
        if select == 0:
            break
        elif select == 1:
            clt = Receipt(listCustomers)
            listCustomers.append(clt)
        elif select == 2:
            if len(listCustomers) != 0:
                for item in listCustomers:
                    item.showInfo()
            else:
                print("Hệ thống chưa quản lý khách hàng nào. Vui lòng thêm khách hàng")
        else:
            print("Lựa chọn không hợp lệ")
    else:
        print("Vui lòng nhập số !!!")
