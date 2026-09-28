# 🏨 Hệ thống Quản lý Khách sạn (Hotel Management System)

Ứng dụng console viết bằng **Java** để quản lý các nghiệp vụ cơ bản của một khách sạn: phòng, khách hàng, đặt phòng, hoá đơn và báo cáo doanh thu. Dự án được xây dựng nhằm áp dụng các nguyên lý **Lập trình Hướng đối tượng (OOP)**.

---

## 📋 Mục lục

- [Tính năng](#-tính-năng)
- [Công nghệ sử dụng](#-công-nghệ-sử-dụng)
- [Cấu trúc thư mục](#-cấu-trúc-thư-mục)
- [Kiến trúc chương trình](#-kiến-trúc-chương-trình)
- [Áp dụng OOP](#-áp-dụng-oop)
- [Cài đặt và chạy](#-cài-đặt-và-chạy)
- [Hướng dẫn sử dụng](#-hướng-dẫn-sử-dụng)
- [Hạn chế và hướng phát triển](#-hạn-chế-và-hướng-phát-triển)

---

## ✨ Tính năng

| Chức năng | Mô tả |
|---|---|
| **Quản lý phòng** | Thêm, xem, tìm, sửa, xoá phòng. Hỗ trợ 2 loại phòng: *Phòng tiêu chuẩn* và *Phòng Suite* |
| **Quản lý khách hàng** | Thêm, xem, tìm, sửa, xoá khách hàng. Đánh dấu khách hàng VIP |
| **Quản lý đặt phòng** | Tạo đơn đặt phòng gắn với khách hàng và phòng, ngày nhận/trả phòng, trạng thái, tổng tiền |
| **Quản lý hoá đơn** | Lập hoá đơn từ đơn đặt phòng, xem, tìm, xoá hoá đơn |
| **Báo cáo** | Báo cáo tổng doanh thu và thống kê danh sách đặt phòng |

**Cách tính giá phòng:**

- **Phòng tiêu chuẩn (`StandardRoom`)**: giá cuối = giá gốc − 10% giảm giá mùa thấp điểm.
- **Phòng Suite (`SuiteRoom`)**: giá cuối = giá gốc + phí dịch vụ thêm (có thể có bồn Jacuzzi).
- Giá tiền được hiển thị theo định dạng tiền Việt Nam (VNĐ).

---

## 🛠 Công nghệ sử dụng

- **Ngôn ngữ:** Java (JDK 17 trở lên, dự án phát triển trên OpenJDK 26)
- **IDE:** IntelliJ IDEA
- **Thư viện:** chỉ dùng thư viện chuẩn của Java (`java.util`, `java.time`, `java.io`, `java.text`)

---

## 📁 Cấu trúc thư mục

```
Hotel/
├── data/                         # File dữ liệu
│   ├── rooms.txt
│   ├── bookings.csv
│   └── invoices.csv
└── src/com/hotel/
    ├── Main.java                 # Điểm khởi chạy, menu chính
    ├── Menu/                     # Giao diện console cho từng chức năng
    │   ├── RoomMenu.java
    │   ├── CustomerMenu.java
    │   ├── BookingMenu.java
    │   ├── InvoiceMenu.java
    │   └── ReportMenu.java
    ├── model/                    # Các lớp đối tượng
    │   ├── Room.java             # Lớp trừu tượng
    │   ├── StandardRoom.java
    │   ├── SuiteRoom.java
    │   ├── Customer.java
    │   ├── Booking.java
    │   ├── Invoice.java
    │   ├── Service.java
    │   ├── IDiscountable.java    # Interface giảm giá
    │   └── IRefundable.java      # Interface hoàn tiền
    ├── service/                  # Xử lý nghiệp vụ
    │   ├── RoomService.java
    │   ├── CustomerService.java
    │   ├── BookingService.java
    │   ├── InvoiceService.java
    │   └── ReportService.java
    ├── repository/               # Lưu trữ và truy xuất dữ liệu
    │   ├── GenericRepository.java
    │   ├── RoomRepository.java
    │   ├── CustomerRepository.java
    │   ├── BookingRepository.java
    │   └── InvoiceRepository.java
    ├── exception/                # Ngoại lệ tự định nghĩa
    │   ├── BaseHotelException.java
    │   ├── RoomNotFoundException.java
    │   ├── DuplicateRoomException.java
    │   ├── CustomerNotFoundException.java
    │   └── ...
    └── util/                     # Tiện ích
        ├── PriceUtil.java        # Định dạng tiền VNĐ
        ├── DateUtil.java         # Xử lý ngày tháng
        └── FileUtil.java         # Đọc/ghi file
```

---

## 🏗 Kiến trúc chương trình

Chương trình được chia thành các tầng, mỗi tầng chỉ làm việc với tầng ngay bên dưới:

```
Menu  ──►  Service  ──►  Repository  ──►  Dữ liệu
(giao diện)  (nghiệp vụ)   (lưu trữ)
```

- **Menu**: nhận dữ liệu người dùng nhập và hiển thị kết quả.
- **Service**: kiểm tra và xử lý nghiệp vụ, ném ngoại lệ khi dữ liệu không hợp lệ (ví dụ trùng mã phòng, không tìm thấy khách hàng).
- **Repository**: thêm, sửa, xoá, tìm kiếm dữ liệu thông qua interface chung `GenericRepository<T>`.

---

## 🧩 Áp dụng OOP

| Nguyên lý | Thể hiện trong dự án |
|---|---|
| **Đóng gói (Encapsulation)** | Thuộc tính khai báo `private`/`protected`, truy cập qua getter/setter |
| **Kế thừa (Inheritance)** | `StandardRoom` và `SuiteRoom` kế thừa lớp `Room`; các ngoại lệ kế thừa `BaseHotelException` |
| **Đa hình (Polymorphism)** | Phương thức `calculatePrice()` cho kết quả khác nhau tuỳ loại phòng |
| **Trừu tượng (Abstraction)** | Lớp trừu tượng `Room`; các interface `IDiscountable`, `IRefundable`, `GenericRepository<T>` |
| **Generic** | `GenericRepository<T>` dùng chung cho mọi loại đối tượng |
| **Xử lý ngoại lệ** | Hệ thống ngoại lệ riêng: `RoomNotFoundException`, `DuplicateRoomException`, `CustomerNotFoundException`, ... |

---

## 🚀 Cài đặt và chạy

### Yêu cầu

- Đã cài **JDK 17** trở lên. Kiểm tra bằng lệnh:
  ```bash
  java -version
  ```

### Cách 1: Chạy bằng IntelliJ IDEA

1. Tải mã nguồn về:
   ```bash
   git clone https://github.com/khanhdoan369-arch/Hotel.git
   ```
2. Mở IntelliJ, chọn **File → Open** và chọn thư mục `Hotel`.
3. Nếu IntelliJ báo thiếu SDK, vào **File → Project Structure → Project** và chọn JDK đã cài.
4. Mở file `src/com/hotel/Main.java` và bấm nút ▶ **Run**.

### Cách 2: Chạy bằng dòng lệnh

Tại thư mục gốc của dự án:

```bash
# Biên dịch
javac -encoding UTF-8 -d out $(find src -name "*.java")

# Chạy
java -cp out com.hotel.Main
```

Trên **Windows (PowerShell)**:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out com.hotel.Main
```

---

## 📖 Hướng dẫn sử dụng

Khi chạy, chương trình hiển thị menu chính:

```
========== HOTEL MANAGEMENT ==========
1. Room Management
2. Customer Management
3. Booking Management
4. Invoice Management
5. Report
0. Exit
Choose:
```

Nhập số tương ứng để vào từng chức năng. Thứ tự thao tác nên làm:

1. **Thêm phòng** (menu 1): nhập mã phòng, số phòng, giá gốc và chọn loại phòng.
2. **Thêm khách hàng** (menu 2): nhập mã khách, họ tên, số điện thoại, số CCCD, VIP hay không.
3. **Tạo đơn đặt phòng** (menu 3): nhập mã khách hàng và mã phòng đã tạo ở trên, ngày nhận/trả phòng theo định dạng `yyyy-MM-dd` (ví dụ `2026-10-01`).
4. **Lập hoá đơn** (menu 4): nhập mã đơn đặt phòng để tạo hoá đơn.
5. **Xem báo cáo** (menu 5): xem tổng doanh thu và danh sách đặt phòng.

> ⚠️ Khi chọn menu, chỉ nhập **số**. Nhập chữ sẽ làm chương trình dừng.

---

## 🔧 Hạn chế và hướng phát triển

**Hạn chế hiện tại:**

- Dữ liệu được lưu trong bộ nhớ (`HashMap`), nên sẽ **mất khi tắt chương trình**. Các file trong thư mục `data/` chưa được đọc/ghi.
- Tổng tiền đặt phòng đang nhập tay, chưa tự tính theo số đêm ở.
- Chưa kiểm tra phòng đã có người đặt trùng ngày hay chưa.

**Hướng phát triển:**

- Lưu và tải dữ liệu từ file trong thư mục `data/` bằng `FileUtil`.
- Tự tính tiền phòng theo số đêm và áp dụng ưu đãi cho khách VIP.
- Thêm dịch vụ đi kèm (ăn uống, giặt ủi, ...) vào hoá đơn.
- Chức năng huỷ đặt phòng và hoàn tiền dựa trên `IRefundable`.
- Chuyển sang giao diện đồ hoạ (JavaFX/Swing) hoặc kết nối cơ sở dữ liệu (MySQL).

---

## 👤 Tác giả

Dự án cá nhân của **Đoàn Việt Khánh** – GitHub: [khanhdoan369-arch](https://github.com/khanhdoan369-arch)
