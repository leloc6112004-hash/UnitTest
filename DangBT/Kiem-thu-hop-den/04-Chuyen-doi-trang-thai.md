# Bài tập: Chuyển đổi trạng thái (State Transition)

**Chương: Kiểm thử hộp đen**  
**Cấu trúc:** 2 phần — **Bài tập mẫu** (20 bài) và **Bài tập tự luyện** (20 bài).

---

## Quy trình chuẩn — Chuyển đổi trạng thái

Làm bài theo **5 bước** sau (xem thêm *HUONG-DAN-CHUNG.md*):

1. **Liệt kê tất cả trạng thái** — Từ đặc tả, đặt tên rõ (Nháp, Chờ duyệt, Đã duyệt, …).
2. **Liệt kê sự kiện** — Sự kiện nào làm đổi trạng thái? (Gửi, Duyệt, Hủy, …).
3. **Vẽ lược đồ trạng thái** — Mỗi cung: Trạng thái nguồn --[Sự kiện]--> Trạng thái đích.
4. **Lập bảng chuyển (tùy chọn)** — Hàng = trạng thái hiện tại, cột = sự kiện, ô = trạng thái kế.
5. **Thiết kế test case** — Mỗi cung hợp lệ ≥ 1 TC; thêm TC không hợp lệ (sự kiện không cho phép).

**Lưu ý:** TC ghi rõ: Điều kiện ban đầu → Thao tác (sự kiện) → Kỳ vọng (trạng thái mới / thông báo).

---

## PHẦN 1: BÀI TẬP MẪU

### Bài mẫu 1

**Đề bài:** Hệ thống **tin nhắn**: tin mới → Chưa đọc; mở đọc → Đã đọc; có thể chuyển lại Chưa đọc; xóa → Thùng rác; trong 24h có thể phục hồi; sau 24h xóa vĩnh viễn. Vẽ lược đồ chuyển đổi trạng thái và viết test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**
- Chưa đọc (Unread)
- Đã đọc (Read)
- Thùng rác (Trash) – có thể phục hồi
- Đã xóa vĩnh viễn (Deleted)

**Bước 2 – Sự kiện & chuyển trạng thái:**
- Mở tin → Unread → Read
- Đánh dấu chưa đọc → Read → Unread
- Xóa → Unread/Read → Trash
- Phục hồi (trong 24h) → Trash → Unread (hoặc Read, tùy đặc tả)
- Hết 24h / Xóa vĩnh viễn → Trash → Deleted

**Bước 3 – Lược đồ (dạng text):**
```
[Unread] --Mở tin--> [Read]
[Read] --Đánh dấu chưa đọc--> [Unread]
[Unread] --Xóa--> [Trash]
[Read] --Xóa--> [Trash]
[Trash] --Phục hồi (<24h)--> [Unread]
[Trash] --Sau 24h/Xóa vĩnh viễn--> [Deleted]
```

**Bước 4 – Test case (mỗi cạnh chuyển trạng thái):**
- TC1: Tin mới → Mở → Đã đọc.
- TC2: Đã đọc → Đánh dấu chưa đọc → Chưa đọc.
- TC3: Chưa đọc → Xóa → Thùng rác.
- TC4: Thùng rác → Phục hồi (<24h) → Chưa đọc.
- TC5: Thùng rác → Sau 24h → Đã xóa (không phục hồi được).
- TC6 (invalid): Ở Thùng rác sau 24h, bấm Phục hồi → vẫn Deleted hoặc thông báo lỗi.

---

### Bài mẫu 2

**Đề bài:** **Đơn hàng**: Mới → Xác nhận → Đang giao → Đã giao; có thể Hủy từ Mới hoặc Xác nhận. Vẽ lược đồ và thiết kế test case.

**Hướng dẫn giải:**

- **Trạng thái:** Mới, Xác nhận, Đang giao, Đã giao, Đã hủy.  
- **Sự kiện:** Xác nhận đơn, Bắt đầu giao, Hoàn thành giao, Hủy đơn.  
- **Chuyển:** Mới → (Xác nhận) → Xác nhận; Mới → (Hủy) → Đã hủy; Xác nhận → (Bắt đầu giao) → Đang giao; Xác nhận → (Hủy) → Đã hủy; Đang giao → (Hoàn thành) → Đã giao.  
- Test case: mỗi cung một TC; thêm TC không hợp lệ (ví dụ Hủy khi Đang giao nếu không cho phép).

---

### Bài mẫu 3

**Đề bài:** **Bài viết**: Soạn thảo → Gửi (Draft) → Trong 15 phút có thể Sửa/Xóa hoặc Publish; sau 15 phút tự Xuất bản; sau khi Xuất bản không sửa/xóa (phải qua admin). Vẽ lược đồ và test case.

**Hướng dẫn giải:**

- **Trạng thái:** Draft (vừa gửi, trong 15 phút), Published (đã xuất bản), Edited (admin đã sửa, vẫn Published).  
- **Sự kiện:** Thời gian 15 phút; Publish; Sửa/Xóa (trong 15 phút); Admin sửa.  
- **Chuyển:** Draft --(15 phút)--> Published; Draft --(Publish)--> Published; Draft --(Sửa)--> Draft; Draft --(Xóa)--> (xóa hẳn); Published --(Admin sửa)--> Published/Edited.  
- Test case: từng chuyển trạng thái; chuyển không hợp lệ (Sửa khi đã Published bởi user).

---

### Bài mẫu 4

**Đề bài:** **Notification**: UNSEEN → mở danh sách → SEEN; click vào thông báo → OPENED. Vẽ lược đồ và test case.

**Hướng dẫn giải:**

- Trạng thái: UNSEEN, SEEN, OPENED.  
- Sự kiện: Mở Notification, Click thông báo.  
- UNSEEN → (Mở list) → SEEN; SEEN → (Click) → OPENED. (Có thể UNSEEN → (Click) → OPENED nếu cho phép.)  
- Test case: UNSEEN→SEEN; SEEN→OPENED; UNSEEN→OPENED (nếu có).

---

### Bài mẫu 5

**Đề bài:** **Tài khoản ngân hàng**: Tạo → Chờ kích hoạt → Kích hoạt → Đang dùng; có thể Khóa; Khóa → Mở khóa. Vẽ lược đồ và test case.

**Hướng dẫn giải:**

- Trạng thái: Tạo, Chờ kích hoạt, Kích hoạt, Đang dùng, Khóa.  
- Sự kiện: Gửi OTP/xác thực, Đăng nhập, Khóa, Mở khóa.  
- Test case: mỗi cung; đăng nhập khi Khóa (từ chối).

---

### Bài mẫu 6

**Đề bài:** **Bug tracking**: Open → In Progress / Wont Fix; In Progress → Testing / Wont Fix; Wont Fix → Closed / Open; Testing → Closed / Open; Closed → Open (tái mở). Vẽ bảng trạng thái và test case.

**Hướng dẫn giải:**

- Giống ví dụ trong slide: O, IP, WF, T, C.  
- Bảng: hàng = trạng thái hiện tại, cột = sự kiện, ô = trạng thái kế.  
- Test case: mỗi ô hợp lệ một TC; vài TC không hợp lệ (sự kiện không áp dụng cho trạng thái hiện tại).

---

### Bài mẫu 7

**Đề bài:** **Vé xe buýt**: Chưa kích hoạt → (Lên xe, quẹt thẻ) → Đã kích hoạt; Đã kích hoạt không quẹt lại trong 60 phút. Vẽ lược đồ và test case.

**Hướng dẫn giải:**

- Trạng thái: Chưa kích hoạt, Đã kích hoạt (trong 60 phút), Hết hạn.  
- Sự kiện: Quẹt thẻ, Hết 60 phút.  
- Test case: Quẹt lần đầu; Quẹt lần 2 trong 60 phút (từ chối hoặc cho tùy đặc tả); Sau 60 phút quẹt lại.

---

### Bài mẫu 8

**Đề bài:** **Phiếu nghỉ**: Nháp → Gửi duyệt → Trưởng phòng duyệt/Không duyệt; Duyệt → HR xác nhận; Không duyệt → Nháp. Vẽ lược đồ và test case.

**Hướng dẫn giải:**

- Trạng thái: Nháp, Chờ TP, Chờ HR, Đã duyệt, Từ chối.  
- Sự kiện: Gửi, TP duyệt, TP từ chối, HR xác nhận.  
- Test case: từng đường đi từ Nháp đến Đã duyệt và Từ chối.

---

### Bài mẫu 9

**Đề bài:** **Sản phẩm trong kho**: Nhập kho → Tồn; Xuất bán → Đang giao; Đang giao → Đã bán hoặc Hoàn trả; Hoàn trả → Tồn. Vẽ lược đồ và test case.

**Hướng dẫn giải:**

- Trạng thái: Tồn, Đang giao, Đã bán, Hoàn trả (có thể coi Hoàn trả → Tồn).  
- Test case: mỗi chuyển trạng thái; xuất khi tồn = 0 (từ chối).

---

### Bài mẫu 10

**Đề bài:** **Kỳ thi trực tuyến**: Đăng ký → Chờ mở; Mở → Đang làm; Nộp bài → Chờ chấm; Chấm xong → Có kết quả. Hủy đăng ký trước khi mở. Vẽ lược đồ và test case.

**Hướng dẫn giải:**

- Trạng thái: Đăng ký, Chờ mở, Đang làm, Đã nộp, Có kết quả, Đã hủy.  
- Sự kiện: Mở kỳ thi, Bắt đầu làm, Nộp bài, Chấm xong, Hủy.  
- Test case: đường đi chuẩn; Hủy khi Chờ mở; không cho Nộp bài khi chưa đến giờ.

---

### Bài mẫu 11   
**Trạng thái ghế xe buýt**

**Đề bài (chi tiết):**  
Ghế xe buýt có ba trạng thái: **Trống**, **Đã đặt**, **Đã bán**. **Trống** → (Đặt chỗ) → **Đã đặt**. **Đã đặt** → (Thanh toán) → **Đã bán** hoặc (Hủy) → **Trống**. **Đã bán** không hủy được. Hãy vẽ **lược đồ chuyển trạng thái** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Trống, Đã đặt, Đã bán.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Đặt chỗ: Trống → Đã đặt.  
- Thanh toán: Đã đặt → Đã bán.  
- Hủy: Đã đặt → Trống. Đã bán không có chuyển khi Hủy (từ chối).

**Bước 3 – Lược đồ (dạng text):**
```
[Trống] --Đặt chỗ--> [Đã đặt]
[Đã đặt] --Thanh toán--> [Đã bán]
[Đã đặt] --Hủy--> [Trống]
(Đã bán --Hủy--> từ chối / không chuyển)
```

**Bước 4 – Test case (mỗi cung chuyển trạng thái):**  
- TC1: Trống → Đặt chỗ → Đã đặt.  
- TC2: Đã đặt → Thanh toán → Đã bán.  
- TC3: Đã đặt → Hủy → Trống.  
- TC4 (invalid): Đã bán → Hủy → Từ chối hoặc không có chuyển.

---

### Bài mẫu 12 — Trung bình · Thực tế  
**Phiếu khám bệnh (bệnh viện)**

**Đề bài (chi tiết):**  
Phiếu khám: **Tạo mới** → (Đến quầy) → **Chờ khám**; **Chờ khám** → (Bác sĩ gọi) → **Đang khám**; **Đang khám** → (Kết thúc) → **Đã khám** (có thể in đơn thuốc). **Hủy** được khi Tạo mới hoặc Chờ khám → **Đã hủy**. Hãy vẽ **lược đồ** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Tạo mới, Chờ khám, Đang khám, Đã khám, Đã hủy.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Đến quầy: Tạo mới → Chờ khám.  
- Bác sĩ gọi: Chờ khám → Đang khám.  
- Kết thúc: Đang khám → Đã khám.  
- Hủy: Tạo mới / Chờ khám → Đã hủy. (Đang khám không hủy nếu không cho phép.)

**Bước 3 – Lược đồ (dạng text):**
```
[Tạo mới] --Đến quầy--> [Chờ khám]
[Tạo mới] --Hủy--> [Đã hủy]
[Chờ khám] --Bác sĩ gọi--> [Đang khám]
[Chờ khám] --Hủy--> [Đã hủy]
[Đang khám] --Kết thúc--> [Đã khám]
```

**Bước 4 – Test case:**  
- TC1: Tạo mới → Đến quầy → Chờ khám.  
- TC2: Chờ khám → Bác sĩ gọi → Đang khám.  
- TC3: Đang khám → Kết thúc → Đã khám.  
- TC4: Tạo mới → Hủy → Đã hủy.  
- TC5: Chờ khám → Hủy → Đã hủy.  
- TC6 (invalid): Đang khám → Hủy → Từ chối (nếu không cho phép).

---

### Bài mẫu 13 — Trung bình · Phức tạp  
**Đơn hàng thương mại điện tử (đầy đủ luồng)**

**Đề bài (chi tiết):**  
Đơn hàng: **Chờ xác nhận** → (Xác nhận) → **Đang chuẩn bị** hoặc (Hủy) → **Đã hủy**; **Đang chuẩn bị** → (Giao shipper) → **Đang giao**; **Đang giao** → (Nhận hàng) → **Đã giao** hoặc (Trả hàng) → **Đang trả**; **Đang trả** → (Xác nhận) → **Đã hủy/hoàn**. Hãy vẽ **lược đồ** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Chờ xác nhận, Đang chuẩn bị, Đang giao, Đã giao, Đã hủy, Đang trả.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Xác nhận: Chờ xác nhận → Đang chuẩn bị.  
- Hủy: Chờ xác nhận → Đã hủy.  
- Giao shipper: Đang chuẩn bị → Đang giao.  
- Nhận hàng: Đang giao → Đã giao.  
- Trả hàng: Đang giao → Đang trả.  
- Xác nhận trả: Đang trả → Đã hủy/hoàn.

**Bước 3 – Lược đồ (dạng text):**
```
[Chờ XN] --Xác nhận--> [Đang chuẩn bị]
[Chờ XN] --Hủy--> [Đã hủy]
[Đang chuẩn bị] --Giao shipper--> [Đang giao]
[Đang giao] --Nhận hàng--> [Đã giao]
[Đang giao] --Trả hàng--> [Đang trả]
[Đang trả] --Xác nhận--> [Đã hủy/hoàn]
```

**Bước 4 – Test case:**  
- TC1 (đường chuẩn): Chờ XN → Xác nhận → Chuẩn bị → Giao shipper → Đang giao → Nhận hàng → Đã giao.  
- TC2 (hủy): Chờ XN → Hủy → Đã hủy.  
- TC3 (trả hàng): Đang giao → Trả hàng → Đang trả → Xác nhận → Đã hủy/hoàn.  
- TC4 (invalid): Đang giao → Hủy (từ chối nếu không cho phép).

---

### Bài mẫu 14 — Trung bình · Thực tế  
**Tài liệu nội bộ (nháp → duyệt → xuất bản)**

**Đề bài (chi tiết):**  
Tài liệu: **Nháp** → (Gửi duyệt) → **Chờ duyệt**; **Chờ duyệt** → (Duyệt) → **Đã duyệt** hoặc (Từ chối) → **Nháp**; **Đã duyệt** → (Xuất bản) → **Đã xuất bản**. **Thu hồi** chỉ khi Đã xuất bản (về Nháp hoặc Ẩn). Hãy vẽ **lược đồ** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Nháp, Chờ duyệt, Đã duyệt, Đã xuất bản.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Gửi duyệt: Nháp → Chờ duyệt.  
- Duyệt: Chờ duyệt → Đã duyệt.  
- Từ chối: Chờ duyệt → Nháp.  
- Xuất bản: Đã duyệt → Đã xuất bản.  
- Thu hồi: Đã xuất bản → Nháp (hoặc Ẩn).

**Bước 3 – Lược đồ (dạng text):**
```
[Nháp] --Gửi duyệt--> [Chờ duyệt]
[Chờ duyệt] --Duyệt--> [Đã duyệt]
[Chờ duyệt] --Từ chối--> [Nháp]
[Đã duyệt] --Xuất bản--> [Đã xuất bản]
[Đã xuất bản] --Thu hồi--> [Nháp]
```

**Bước 4 – Test case:**  
- TC1: Nháp → Gửi duyệt → Chờ duyệt.  
- TC2: Chờ duyệt → Từ chối → Nháp.  
- TC3: Chờ duyệt → Duyệt → Đã duyệt.  
- TC4: Đã duyệt → Xuất bản → Đã xuất bản.  
- TC5: Đã xuất bản → Thu hồi → Nháp (hoặc Ẩn).

---

### Bài mẫu 15 — Khó · Thực tế  
**Hợp đồng lao động (soạn thảo → ký → hiệu lực → chấm dứt)**

**Đề bài (chi tiết):**  
Hợp đồng: **Soạn thảo** → (Gửi ký) → **Chờ ký**; **Chờ ký** → (Bên kia ký) → **Đã ký** hoặc (Hết hạn ký) → **Hết hạn**; **Đã ký** → (Đến ngày hiệu lực) → **Hiệu lực**; **Hiệu lực** → (Kết thúc) → **Chấm dứt**. Hãy vẽ **lược đồ** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Soạn thảo, Chờ ký, Đã ký, Hiệu lực, Chấm dứt, Hết hạn.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Gửi ký: Soạn thảo → Chờ ký.  
- Ký: Chờ ký → Đã ký.  
- Hết hạn ký: Chờ ký → Hết hạn.  
- Đến ngày hiệu lực: Đã ký → Hiệu lực.  
- Kết thúc: Hiệu lực → Chấm dứt.

**Bước 3 – Lược đồ (dạng text):**
```
[Soạn thảo] --Gửi ký--> [Chờ ký]
[Chờ ký] --Ký--> [Đã ký]
[Chờ ký] --Hết hạn ký--> [Hết hạn]
[Đã ký] --Đến ngày hiệu lực--> [Hiệu lực]
[Hiệu lực] --Kết thúc--> [Chấm dứt]
```

**Bước 4 – Test case:**  
- TC1: Soạn thảo → Gửi ký → Chờ ký.  
- TC2: Chờ ký → Ký → Đã ký.  
- TC3: Chờ ký → Hết hạn ký → Hết hạn.  
- TC4: Đã ký → Đến ngày hiệu lực → Hiệu lực.  
- TC5: Hiệu lực → Kết thúc → Chấm dứt.

---

### Bài mẫu 16 — Khó · Phức tạp  
**Vé máy bay (đặt → thanh toán → đổi/hủy)**

**Đề bài (chi tiết):**  
Vé: **Đặt chỗ** → (Thanh toán) → **Đã xuất vé**; **Đặt chỗ** → (Hết hạn) → **Hết hạn**; **Đã xuất vé** → (Đổi chuyến/ngày) → **Đã đổi** (vé mới); **Đã xuất vé** → (Hủy) → **Đã hủy** (hoàn tiền theo chính sách). Hãy vẽ **lược đồ** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Đặt chỗ, Đã xuất vé, Hết hạn, Đã đổi, Đã hủy.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Thanh toán: Đặt chỗ → Đã xuất vé.  
- Hết hạn: Đặt chỗ → Hết hạn.  
- Đổi: Đã xuất vé → Đã đổi.  
- Hủy: Đã xuất vé → Đã hủy. (Đặt chỗ có thể cho hủy đặt tùy đặc tả.)

**Bước 3 – Lược đồ (dạng text):**
```
[Đặt chỗ] --Thanh toán--> [Đã xuất vé]
[Đặt chỗ] --Hết hạn--> [Hết hạn]
[Đã xuất vé] --Đổi--> [Đã đổi]
[Đã xuất vé] --Hủy--> [Đã hủy]
```

**Bước 4 – Test case:**  
- TC1: Đặt chỗ → Thanh toán → Đã xuất vé.  
- TC2: Đặt chỗ → Hết hạn → Hết hạn.  
- TC3: Đã xuất vé → Đổi → Đã đổi.  
- TC4: Đã xuất vé → Hủy → Đã hủy.  
- TC5 (nếu có): Đặt chỗ → Hủy đặt → (hủy đặt chỗ).

---

### Bài mẫu 17 — Trung bình · Thực tế  
**Thẻ thành viên phòng gym (đăng ký → kích hoạt → khóa)**

**Đề bài (chi tiết):**  
Thẻ: **Đăng ký** → (Thanh toán) → **Chờ kích hoạt**; **Chờ kích hoạt** → (Kích hoạt lần đầu) → **Đang hoạt động**; **Đang hoạt động** → (Hết hạn) → **Hết hạn** hoặc (Khóa) → **Khóa**; **Khóa** → (Gia hạn/Mở khóa) → **Đang hoạt động**. Hãy vẽ **lược đồ** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Đăng ký, Chờ kích hoạt, Đang hoạt động, Hết hạn, Khóa.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Thanh toán: Đăng ký → Chờ kích hoạt.  
- Kích hoạt: Chờ kích hoạt → Đang hoạt động.  
- Hết hạn: Đang hoạt động → Hết hạn.  
- Khóa: Đang hoạt động → Khóa.  
- Gia hạn/Mở khóa: Khóa → Đang hoạt động.

**Bước 3 – Lược đồ (dạng text):**
```
[Đăng ký] --Thanh toán--> [Chờ kích hoạt]
[Chờ kích hoạt] --Kích hoạt--> [Đang hoạt động]
[Đang hoạt động] --Hết hạn--> [Hết hạn]
[Đang hoạt động] --Khóa--> [Khóa]
[Khóa] --Gia hạn/Mở khóa--> [Đang hoạt động]
```

**Bước 4 – Test case:**  
- TC1: Đăng ký → Thanh toán → Chờ kích hoạt.  
- TC2: Chờ kích hoạt → Kích hoạt → Đang hoạt động.  
- TC3: Đang hoạt động → Hết hạn → Hết hạn.  
- TC4: Đang hoạt động → Khóa → Khóa.  
- TC5: Khóa → Gia hạn → Đang hoạt động.

---

### Bài mẫu 18 — Khó · Thực tế  
**Yêu cầu hỗ trợ (ticket) IT**

**Đề bài (chi tiết):**  
Ticket: **Mới** → (Phân công) → **Đang xử lý**; **Đang xử lý** → (Giải quyết) → **Đã giải quyết** hoặc (Chuyển) → **Chờ bộ phận khác**; **Đã giải quyết** → (Khách xác nhận) → **Đóng** hoặc (Chưa ổn) → **Đang xử lý**; **Chờ bộ phận khác** → (Phản hồi) → **Đang xử lý**. Hãy vẽ **lược đồ** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Mới, Đang xử lý, Chờ bộ phận khác, Đã giải quyết, Đóng.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Phân công: Mới → Đang xử lý.  
- Giải quyết: Đang xử lý → Đã giải quyết.  
- Chuyển: Đang xử lý → Chờ bộ phận khác.  
- Khách xác nhận: Đã giải quyết → Đóng.  
- Chưa ổn: Đã giải quyết → Đang xử lý.  
- Phản hồi: Chờ bộ phận khác → Đang xử lý.

**Bước 3 – Lược đồ (dạng text):**
```
[Mới] --Phân công--> [Đang xử lý]
[Đang xử lý] --Giải quyết--> [Đã giải quyết]
[Đang xử lý] --Chuyển--> [Chờ bộ phận khác]
[Đã giải quyết] --Khách xác nhận--> [Đóng]
[Đã giải quyết] --Chưa ổn--> [Đang xử lý]
[Chờ bộ phận khác] --Phản hồi--> [Đang xử lý]
```

**Bước 4 – Test case:**  
- TC1: Mới → Phân công → Đang xử lý.  
- TC2: Đang xử lý → Giải quyết → Đã giải quyết.  
- TC3: Đã giải quyết → Khách xác nhận → Đóng.  
- TC4: Đã giải quyết → Chưa ổn → Đang xử lý.  
- TC5: Đang xử lý → Chuyển → Chờ bộ phận khác.  
- TC6: Chờ bộ phận khác → Phản hồi → Đang xử lý.

---

### Bài mẫu 19 — Khó · Phức tạp  
**Kỳ thi trực tuyến (đăng ký → mở → làm → nộp → chấm)**

**Đề bài (chi tiết):**  
Kỳ thi: **Đăng ký** → (Mở cửa) → **Có thể làm**; **Có thể làm** → (Bắt đầu làm) → **Đang làm**; **Đang làm** → (Nộp bài) → **Đã nộp**; **Đã nộp** → (Chấm xong) → **Có kết quả**. **Hủy đăng ký** trước khi mở → **Đã hủy**. **Đang làm** quá giờ → tự động nộp → **Đã nộp**. Hãy vẽ **lược đồ** và thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Đăng ký, Có thể làm, Đang làm, Đã nộp, Có kết quả, Đã hủy.

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Mở cửa: Đăng ký → Có thể làm.  
- Bắt đầu: Có thể làm → Đang làm.  
- Nộp bài: Đang làm → Đã nộp.  
- Hết giờ (tự động): Đang làm → Đã nộp.  
- Chấm xong: Đã nộp → Có kết quả.  
- Hủy: Đăng ký → Đã hủy.

**Bước 3 – Lược đồ (dạng text):**
```
[Đăng ký] --Mở cửa--> [Có thể làm]
[Đăng ký] --Hủy--> [Đã hủy]
[Có thể làm] --Bắt đầu--> [Đang làm]
[Đang làm] --Nộp bài/Hết giờ--> [Đã nộp]
[Đã nộp] --Chấm xong--> [Có kết quả]
```

**Bước 4 – Test case:**  
- TC1: Đăng ký → Mở cửa → Có thể làm.  
- TC2: Có thể làm → Bắt đầu → Đang làm.  
- TC3: Đang làm → Nộp bài → Đã nộp.  
- TC4: Đã nộp → Chấm xong → Có kết quả.  
- TC5: Đăng ký → Hủy → Đã hủy.  
- TC6: Đang làm → Hết giờ (tự động nộp) → Đã nộp.

---

### Bài mẫu 20 — Khó · Thực tế  
**Sản phẩm trong kho (nhập → tồn → đặt → xuất / trả)**

**Đề bài (chi tiết):**  
Sản phẩm: **Nhập kho** → **Tồn**; **Tồn** → (Đặt mua) → **Đã đặt**; **Tồn** → (Xuất) → **Đã xuất**; **Đã xuất** có thể (Trả hàng) → **Tồn**. **Tồn** → (Hết hạn) → **Hủy**. Hãy vẽ **lược đồ** và thiết kế test case. (Invalid: Xuất khi số lượng = 0.)

**Hướng dẫn giải:**

**Bước 1 – Liệt kê trạng thái:**  
Tồn, Đã đặt, Đã xuất, Hủy (hoặc Hết hạn).

**Bước 2 – Sự kiện & chuyển trạng thái:**  
- Đặt: Tồn → Đã đặt.  
- Xuất: Tồn → Đã xuất.  
- Trả hàng: Đã xuất → Tồn.  
- Hết hạn: Tồn → Hủy.

**Bước 3 – Lược đồ (dạng text):**
```
[Tồn] --Đặt mua--> [Đã đặt]
[Tồn] --Xuất--> [Đã xuất]
[Tồn] --Hết hạn--> [Hủy]
[Đã xuất] --Trả hàng--> [Tồn]
```

**Bước 4 – Test case:**  
- TC1: Tồn → Xuất → Đã xuất.  
- TC2: Đã xuất → Trả hàng → Tồn.  
- TC3: Tồn → Đặt mua → Đã đặt.  
- TC4: Tồn → Hết hạn → Hủy.  
- TC5 (invalid): Số lượng = 0 → Xuất → Từ chối.

---



## PHẦN 2: BÀI TẬP TỰ LUYỆN

### Bài 1
**ATM**: Đọc thẻ → Nhập PIN → Chọn giao dịch → Thực hiện → Kết thúc; có thể Cancel ở từng bước; PIN sai 3 lần giữ thẻ. Vẽ lược đồ và thiết kế test case.

### Bài 2
**Đơn đặt món**: Đặt → Xác nhận → Đang nấu → Sẵn sàng → Đã giao; có thể Hủy khi Đặt hoặc Xác nhận. Vẽ lược đồ và test case.

### Bài 3
**Tài liệu nội bộ**: Nháp → Gửi phê duyệt → Đã duyệt / Từ chối; Từ chối → Nháp; Đã duyệt có thể Thu hồi (về Nháp). Vẽ lược đồ và test case.

### Bài 4
**Thẻ thành viên**: Đăng ký → Chờ duyệt → Kích hoạt / Từ chối; Kích hoạt có thể Khóa; Khóa có thể Mở lại. Vẽ lược đồ và test case.

### Bài 5
**Bảo hành**: Yêu cầu → Tiếp nhận → Đang sửa → Hoàn thành / Không sửa được; Khách nhận máy hoặc từ chối nhận. Vẽ lược đồ và test case.

### Bài 6
**Phiếu đặt bàn**: Tạo → Chờ nhà hàng xác nhận → Đã xác nhận / Hết chỗ; Đã xác nhận → Khách đến / Khách hủy. Vẽ lược đồ và test case.

### Bài 7
**File upload**: Chọn file → Đang tải → Thành công / Lỗi; Thành công → Có thể Xóa hoặc Thay thế. Vẽ lược đồ và test case.

### Bài 8
**Gia hạn hợp đồng**: Sắp hết hạn (30 ngày) → Nhắc gia hạn; Gửi yêu cầu → Chờ duyệt → Gia hạn / Từ chối; Hết hạn → Khóa dịch vụ. Vẽ lược đồ và test case.

### Bài 9
**Bình luận**: Gửi → Chờ kiểm duyệt (nếu có) → Hiển thị / Ẩn; Hiển thị có thể Chỉnh sửa (trong 5 phút) hoặc Xóa. Vẽ lược đồ và test case.

### Bài 10
**Mã OTP**: Gửi yêu cầu → Mã đã gửi; Nhập đúng → Xác thực thành công; Nhập sai 5 lần → Khóa 15 phút; Mã hết hạn (3 phút) → Phải gửi lại. Vẽ lược đồ và test case.

---

### Bài 11 
**Trạng thái bàn ăn** nhà hàng: Trống → (Đặt) → Đã đặt → (Khách đến) → Đang dùng → (Thanh toán) → Trống. Vẽ lược đồ và test case.

### Bài 12 — Trung bình · Thực tế
**Đơn xin nghỉ**: Nháp → Gửi → Chờ duyệt → (Duyệt/Từ chối) → Đã duyệt/Đã từ chối. Có thể Rút khi Chờ duyệt. Vẽ lược đồ và test case.

### Bài 13 — Trung bình · Phức tạp
**Phiếu mượn thiết bị**: Tạo → Chờ duyệt → Đã duyệt → Nhận thiết bị → Đang mượn → Trả → Hoàn thành. Có thể Từ chối khi Chờ duyệt; Hủy khi Đang mượn (trả sớm). Vẽ lược đồ và test case.

### Bài 14 — Trung bình · Thực tế
**Trạng thái thanh toán**: Chờ thanh toán → (Thanh toán thành công) → Đã thanh toán; Chờ → (Hết hạn) → Hết hạn. Vẽ lược đồ và test case.

### Bài 15 — Khó · Thực tế
**Hồ sơ tuyển dụng**: Nộp → Sàng lọc → Phỏng vấn → Offer → Ký → Nhận việc. Có thể Rớt ở Sàng lọc/Phỏng vấn; Từ chối Offer. Vẽ lược đồ và test case.

### Bài 16 — Khó · Phức tạp
**Gói cước di động**: Đăng ký → Kích hoạt → Đang dùng → (Hết hạn/Giải thể) → Hết hạn/Giải thể; Đang dùng có thể Nâng cấp/Hạ cấp (đổi gói). Vẽ lược đồ và test case.

### Bài 17 — Trung bình · Thực tế
**Trạng thái phòng khách sạn** (Trống → Đặt → Ở → Dọn → Trống). Có Hủy đặt, No-show. Vẽ lược đồ và test case.

### Bài 18 — Khó · Thực tế
**Bảo hành sản phẩm**: Yêu cầu → Tiếp nhận → Đang sửa → (Xong/Không sửa được) → Chờ lấy/Trả lại; Khách lấy máy. Vẽ lược đồ và test case.

### Bài 19 — Khó · Phức tạp
**Khóa học trực tuyến**: Đăng ký → Mở → Đang học → Hoàn thành (đủ bài) / Hết hạn. Có thể Tạm dừng (đóng băng thời hạn). Vẽ lược đồ và test case.

### Bài 20 — Khó · Thực tế
**Đấu thầu**: Đăng ký tham gia → Nộp hồ sơ dự thầu → Chờ mở thầu → Trúng/Không trúng → Ký hợp đồng (nếu trúng). Vẽ lược đồ và test case.

---

*Hết phần Chuyển đổi trạng thái.*
