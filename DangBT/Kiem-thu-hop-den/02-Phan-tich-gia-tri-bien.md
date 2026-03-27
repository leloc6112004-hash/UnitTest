# Bài tập: Phân tích giá trị biên (Boundary Value Analysis)

**Chương: Kiểm thử hộp đen**  
**Cấu trúc:** 2 phần — **Bài tập mẫu** (20 bài) và **Bài tập tự luyện** (20 bài).

---

## Quy trình chuẩn — Phân tích giá trị biên

Làm bài theo **4 bước** sau (xem thêm *HUONG-DAN-CHUNG.md*):

1. **Xác định biên** — Từ đặc tả, tìm min và max hợp lệ (nhiều khoảng → nhiều cặp biên).
2. **Chọn giá trị theo BVA** — Với mỗi biên: **min−1, min, min+1** và **max−1, max, max+1** (2-value hoặc 3-value).
3. **Liệt kê test case** — Mỗi giá trị = 1 TC; ghi rõ Đầu vào và Kỳ vọng (chấp nhận / từ chối).
4. **Nhiều đầu vào** — Áp dụng BVA cho từng biến; có thể kết hợp bộ (min, min), (max, max), …

**Lưu ý:** Biên trên và biên dưới đều cần test; nhiều khoảng thì mỗi khoảng có cặp biên riêng.

---

## PHẦN 1: BÀI TẬP MẪU

### Bài mẫu 1

**Đề bài:** Ngân hàng ABC: chuyển khoản tối đa **10 triệu/ngày**, tối thiểu **1 triệu/lần**. Dùng BVA thiết kế test case cho **số tiền một lần chuyển** (giả sử tài khoản đủ tiền).

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
- Biên dưới hợp lệ: 1.000.000  
- Biên trên hợp lệ: 10.000.000  

**Bước 2 – Chọn giá trị theo BVA (2-value hoặc 3-value):**

- **2-value (min, min-1, max, max+1):**  
  min-1 = 999.999, min = 1.000.000, max = 10.000.000, max+1 = 10.000.001  
- **3-value:** thêm giá trị trong vùng (ví dụ 5.000.000).

**Bước 3 – Test case:**

| TC | Số tiền (VNĐ) | Kỳ vọng |
|----|----------------|--------|
| 1 | 999.999 | Từ chối (dưới tối thiểu) |
| 2 | 1.000.000 | Chấp nhận |
| 3 | 5.000.000 | Chấp nhận (trong khoảng) |
| 4 | 10.000.000 | Chấp nhận |
| 5 | 10.000.001 | Từ chối (vượt tối đa) |

*(Nếu có giới hạn theo ngày, cần thêm test tổng tiền chuyển trong ngày.)*

---

### Bài mẫu 2

**Đề bài:** Ô **tuổi** chấp nhận 18–65. Dùng BVA thiết kế test case.

**Hướng dẫn giải:**

- Biên: 18 (min), 65 (max).  
- Giá trị: 17, 18, 19 (cận dưới); 64, 65, 66 (cận trên); 40 (trong khoảng).

**Test case:** 17 (invalid), 18 (valid), 19 (valid), 40 (valid), 64 (valid), 65 (valid), 66 (invalid).

---

### Bài mẫu 3

**Đề bài:** **Phí vận chuyển**: 0–5 kg → 30k; 5–20 kg → 50k; 20–50 kg → 80k; > 50 kg không nhận. Áp dụng BVA cho **khối lượng (kg)**.

**Hướng dẫn giải:**

- Các biên: 0, 5, 20, 50.  
- Với mỗi biên chọn: giá trị ngay dưới, đúng biên, ngay trên (nếu có nghĩa).  
- Ví dụ: -0.1, 0, 0.1; 4.9, 5, 5.1; 19.9, 20, 20.1; 49.9, 50, 50.1.  
- Rút gọn: mỗi đoạn lấy min, min-1 (hoặc max, max+1) tùy quy ước (0, 5, 20, 50 và các cận).

**Test case gợi ý:** 0, 0.1, 4.9, 5, 5.1, 19.9, 20, 20.1, 49.9, 50, 50.1 (kèm kỳ vọng phí / từ chối).

---

### Bài mẫu 4

**Đề bài:** **Username** 4–20 ký tự. BVA cho độ dài username.

**Hướng dẫn giải:**

- Biên độ dài: 4 và 20.  
- Giá trị: độ dài 3, 4, 5 (cận dưới); 19, 20, 21 (cận trên).  
- Test case: chuỗi có length = 3, 4, 5, 19, 20, 21 (ví dụ "abc", "abcd", "abcde", ...).

---

### Bài mẫu 5

**Đề bài:** **Điểm** môn học: 0–10, làm tròn 1 chữ số thập phân; < 5 là không đạt. BVA cho ô điểm.

**Hướng dẫn giải:**

- Biên hợp lệ: 0 và 10; biên “qua môn”: 5.  
- Giá trị: -0.1, 0, 0.1; 4.9, 5.0, 5.1; 9.9, 10.0, 10.1.  
- Test case: mỗi giá trị trên + kỳ vọng (invalid/valid, đạt/không đạt).

---

### Bài mẫu 6

**Đề bài:** **Số lượng** mua: tối thiểu 1, tối đa 99. BVA thiết kế test case.

**Hướng dẫn giải:**

- Biên: 1 và 99.  
- Test case: 0, 1, 2; 98, 99, 100 (và có thể 50 trong khoảng).

---

### Bài mẫu 7

**Đề bài:** **Mã PIN** 4 chữ số (0000–9999). BVA cho độ dài và/hoặc giá trị số.

**Hướng dẫn giải:**

- Độ dài: 3, 4, 5 ký tự.  
- Hoặc giá trị biên: 0000, 0001, 9998, 9999.  
- Kết hợp: 3 ký tự, 4 ký tự (0000, 9999), 5 ký tự.

---

### Bài mẫu 8

**Đề bài:** **Thời gian** đặt chỗ: từ 8:00 đến 22:00, bước 30 phút. BVA cho giờ (và phút).

**Hướng dẫn giải:**

- Biên: 8:00 và 22:00.  
- Giá trị: 7:30, 8:00, 8:30; 21:30, 22:00, 22:30.  
- Test case: mỗi giá trị + kỳ vọng (hợp lệ / không hợp lệ).

---

### Bài mẫu 9

**Đề bài:** **Giảm giá** theo tổng đơn: 0–500k không giảm; 500k–2tr giảm 5%; 2tr–5tr giảm 10%; > 5tr giảm 15%. BVA cho **tổng đơn (VNĐ)**.

**Hướng dẫn giải:**

- Biên: 0, 500.000, 2.000.000, 5.000.000.  
- Với mỗi biên: giá trị dưới, đúng, trên (ví dụ 499.999, 500.000, 500.001; 1.999.999, 2.000.000, 2.000.001; 4.999.999, 5.000.000, 5.000.001).  
- Thêm 0 và giá trị âm (nếu có) cho biên dưới.

---

### Bài mẫu 10

**Đề bài:** **Số lần đăng nhập sai** tối đa 5, sau đó khóa 15 phút. BVA cho số lần sai.

**Hướng dẫn giải:**

- Biên: 5 lần (khóa).  
- Test case: 4 lần sai (chưa khóa), 5 lần sai (khóa), 6 lần sai (đã khóa). Có thể thêm 0, 1 (chưa khóa).

---

### Bài mẫu 11   
**Số khách đặt bàn nhà hàng (1–20)**

**Đề bài (chi tiết):**  
Nhà hàng cho phép đặt bàn với **số khách** từ **1 đến 20** (số nguyên). Ngoài khoảng [1, 20] hoặc không đúng kiểu thì báo lỗi. Hãy dùng **BVA** thiết kế test case cho ô nhập số khách.

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
- Biên dưới hợp lệ: **1**  
- Biên trên hợp lệ: **20**

**Bước 2 – Chọn giá trị theo BVA (2-value hoặc 3-value):**  
- min−1 = **0**, min = **1**, min+1 = **2**  
- max−1 = **19**, max = **20**, max+1 = **21**  
- Trong khoảng (tùy chọn): **10**

**Bước 3 – Test case:**

| TC | Đầu vào (số khách) | Kỳ vọng |
|----|---------------------|--------|
| 1 | 0 | Từ chối (dưới tối thiểu) |
| 2 | 1 | Chấp nhận |
| 3 | 2 | Chấp nhận |
| 4 | 10 | Chấp nhận (trong khoảng) |
| 5 | 19 | Chấp nhận |
| 6 | 20 | Chấp nhận |
| 7 | 21 | Từ chối (vượt tối đa) |

---

### Bài mẫu 12 — Trung bình · Thực tế  
**Phí ship theo khoảng đơn (0 / 500k / 2tr / 5tr)**

**Đề bài (chi tiết):**  
Phí vận chuyển tính theo **tổng đơn hàng (VNĐ)**:
- **0 – 500k**: 30.000đ ship  
- **500k – 2tr**: 20.000đ  
- **2tr – 5tr**: 10.000đ  
- **≥ 5tr**: miễn phí  

Hãy dùng **BVA** thiết kế test case cho ô **tổng đơn**.

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
Các biên giữa các khoảng: **0**, **500.000**, **2.000.000**, **5.000.000**.

**Bước 2 – Chọn giá trị theo BVA:**  
Với mỗi biên: giá trị ngay dưới, đúng biên, ngay trên (ví dụ 499.999, 500.000, 500.001; 1.999.999, 2.000.000, 2.000.001; 4.999.999, 5.000.000, 5.000.001). Thêm 0 và số âm nếu cho nhập.

**Bước 3 – Test case (ví dụ):**

| TC | Tổng đơn (VNĐ) | Kỳ vọng (phí ship) |
|----|----------------|----------------------|
| 1 | 0 | 30.000đ |
| 2 | 499.999 | 30.000đ |
| 3 | 500.000 | 20.000đ |
| 4 | 500.001 | 20.000đ |
| 5 | 1.999.999 | 20.000đ |
| 6 | 2.000.000 | 10.000đ |
| 7 | 4.999.999 | 10.000đ |
| 8 | 5.000.000 | Miễn phí |
| 9 | 5.000.001 | Miễn phí |

---

### Bài mẫu 13 — Trung bình · Phức tạp  
**Điểm xếp loại (0–5 Yếu, 5–7 TB, 7–8 Khá, 8–9 Giỏi, 9–10 Xuất sắc)**

**Đề bài (chi tiết):**  
Ô **điểm** môn học: thang 10, **1 chữ số thập phân**. Xếp loại: 0–5 Yếu, 5–7 TB, 7–8 Khá, 8–9 Giỏi, 9–10 Xuất sắc. Ngoài [0, 10] hoặc không đúng định dạng → lỗi. Hãy dùng **BVA** thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
Biên giữa các mức: **0**, **5**, **7**, **8**, **9**, **10**. Thêm biên invalid: < 0, > 10.

**Bước 2 – Chọn giá trị theo BVA:**  
Mỗi biên: giá trị dưới, đúng, trên (ví dụ 4.9, 5.0, 5.1; 6.9, 7.0, 7.1; 7.9, 8.0, 8.1; 8.9, 9.0, 9.1; 9.9, 10.0, 10.1). Thêm -0.1, 10.1 cho invalid.

**Bước 3 – Test case (ví dụ):**

| TC | Đầu vào (điểm) | Kỳ vọng (xếp loại / lỗi) |
|----|----------------|---------------------------|
| 1 | -0.1 | Lỗi (ngoài khoảng) |
| 2 | 0 | Yếu |
| 3 | 4.9 | Yếu |
| 4 | 5.0 | TB |
| 5 | 6.9 | TB |
| 6 | 7.0 | Khá |
| 7 | 8.0 | Giỏi |
| 8 | 9.0 | Xuất sắc |
| 9 | 10.0 | Xuất sắc |
| 10 | 10.1 | Lỗi (ngoài khoảng) |

---

### Bài mẫu 14 — Trung bình · Thực tế  
**Số ngày nghỉ phép (0 / 12 / 15 theo thâm niên)**

**Đề bài (chi tiết):**  
Số ngày nghỉ phép theo **thâm niên** (số năm làm việc): **< 1 năm** → 0 ngày; **1–5 năm** → 12 ngày; **> 5 năm** → 15 ngày. Ô nhập **số năm thâm niên** (số thực). Hãy dùng **BVA** thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
Biên giữa các mức: **1** (0 ngày ↔ 12 ngày), **5** (12 ngày ↔ 15 ngày). Thêm 0 và có thể âm (invalid).

**Bước 2 – Chọn giá trị theo BVA:**  
0.9, 1.0, 1.1; 4.9, 5.0, 5.1; thêm 0; nếu có: -0.1 (lỗi).

**Bước 3 – Test case:**

| TC | Đầu vào (số năm) | Kỳ vọng (số ngày nghỉ) |
|----|------------------|-------------------------|
| 1 | 0 | 0 ngày |
| 2 | 0.9 | 0 ngày |
| 3 | 1.0 | 12 ngày |
| 4 | 1.1 | 12 ngày |
| 5 | 4.9 | 12 ngày |
| 6 | 5.0 | 12 ngày |
| 7 | 5.1 | 15 ngày |
| 8 | 6 | 15 ngày |
| 9 | -0.1 | Lỗi (nếu không chấp nhận âm) |

---

### Bài mẫu 15 — Khó · Thực tế  
**Hạn mức vay (50tr–500tr, bước 10tr)**

**Đề bài (chi tiết):**  
Khách chọn **số tiền vay** trong khoảng **50 triệu – 500 triệu** VNĐ, **bước 10 triệu**. Ngoài khoảng hoặc không đúng bước → báo lỗi. Hãy dùng **BVA** thiết kế test case cho ô số tiền vay.

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
- Biên dưới hợp lệ: **50.000.000**  
- Biên trên hợp lệ: **500.000.000**

**Bước 2 – Chọn giá trị theo BVA:**  
- min−1 = 40.000.000 (hoặc 49.000.000), min = 50.000.000, min+1 = 60.000.000  
- max−1 = 490.000.000, max = 500.000.000, max+1 = 510.000.000 (nếu cho nhập)

**Bước 3 – Test case:**

| TC | Số tiền vay (VNĐ) | Kỳ vọng |
|----|-------------------|--------|
| 1 | 49.000.000 | Từ chối (dưới tối thiểu) |
| 2 | 50.000.000 | Chấp nhận |
| 3 | 60.000.000 | Chấp nhận |
| 4 | 490.000.000 | Chấp nhận |
| 5 | 500.000.000 | Chấp nhận |
| 6 | 510.000.000 | Từ chối (vượt tối đa, nếu cho nhập) |

---

### Bài mẫu 16 — Khó · Phức tạp  
**Hai biên phụ thuộc: số lượng × đơn giá (tổng tối đa 100tr)**

**Đề bài (chi tiết):**  
- **Số lượng** mua: 1–100. **Đơn giá** mỗi sản phẩm: 10.000 – 1.000.000 VNĐ.  
- **Tổng tiền** (số lượng × đơn giá) không được vượt **100.000.000**.  
Hãy dùng **BVA** cho **số lượng** (giữ đơn giá cố định), cho **đơn giá** (giữ số lượng cố định), và có thể thêm test **tổng tiền** tại biên 100tr.

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
- Số lượng: min = **1**, max = **100**.  
- Đơn giá: min = **10.000**, max = **1.000.000**.  
- Tổng tiền: max = **100.000.000**.

**Bước 2 – Chọn giá trị theo BVA:**  
- Số lượng: 0, 1, 2; 99, 100, 101.  
- Đơn giá: 9.999, 10.000, 10.001; 999.999, 1.000.000, 1.000.001.  
- Tổng: 99.999.999, 100.000.000, 100.000.001 (bằng cách chọn bộ số lượng × đơn giá).

**Bước 3 – Test case (ví dụ):**

| TC | Số lượng | Đơn giá (VNĐ) | Tổng | Kỳ vọng |
|----|----------|---------------|------|--------|
| 1 | 0 | 500.000 | 0 | Từ chối (số lượng) |
| 2 | 1 | 500.000 | 500.000 | Chấp nhận |
| 3 | 100 | 500.000 | 50.000.000 | Chấp nhận |
| 4 | 101 | 500.000 | — | Từ chối (số lượng) |
| 5 | 50 | 9.999 | 499.950 | Chấp nhận |
| 6 | 50 | 1.000.000 | 50.000.000 | Chấp nhận |
| 7 | 100 | 1.000.000 | 100.000.000 | Chấp nhận (đúng biên) |
| 8 | 101 | 1.000.000 | 101.000.000 | Từ chối (vượt tổng) |

---

### Bài mẫu 17 — Trung bình · Thực tế  
**Thời gian đặt lịch (8:00–18:00, bước 15 phút)**

**Đề bài (chi tiết):**  
Form đặt lịch: **giờ** trong khung **8:00 – 18:00**, **bước 15 phút** (8:00, 8:15, 8:30, …, 18:00). Ngoài khung hoặc không đúng bước → báo lỗi. Hãy dùng **BVA** thiết kế test case cho ô giờ (và phút nếu tách trường).

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
- Biên dưới: **8:00**  
- Biên trên: **18:00**

**Bước 2 – Chọn giá trị theo BVA:**  
7:45, 8:00, 8:15; 17:45, 18:00, 18:15 (hoặc 17:45, 18:00, 18:15 tùy quy ước 18:00 có thuộc khung hay không).

**Bước 3 – Test case:**

| TC | Đầu vào (giờ) | Kỳ vọng |
|----|---------------|--------|
| 1 | 7:45 | Từ chối (trước 8:00) |
| 2 | 8:00 | Chấp nhận |
| 3 | 8:15 | Chấp nhận |
| 4 | 12:00 | Chấp nhận (trong khoảng) |
| 5 | 17:45 | Chấp nhận |
| 6 | 18:00 | Chấp nhận |
| 7 | 18:15 | Từ chối (sau 18:00) |

---

### Bài mẫu 18 — Khó · Thực tế  
**Tuổi trẻ em (0–11) giảm giá 50%, 12–17 giảm 20%**

**Đề bài (chi tiết):**  
Giá vé có **giảm theo tuổi**: **0–11** tuổi giảm 50%; **12–17** tuổi giảm 20%; từ 18 trở lên không giảm. Ô nhập **tuổi** (số nguyên). Hãy dùng **BVA** thiết kế test case cho ô tuổi khi tính giá vé.

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
Biên giữa các mức: **0**, **12**, **18** (hoặc 17 tùy quy ước). Invalid: tuổi âm, quá lớn (nếu có giới hạn).

**Bước 2 – Chọn giá trị theo BVA:**  
-1, 0, 1; 11, 12, 13; 17, 18, 19.

**Bước 3 – Test case:**

| TC | Đầu vào (tuổi) | Kỳ vọng (mức giảm) |
|----|----------------|---------------------|
| 1 | -1 | Lỗi (tuổi không hợp lệ) |
| 2 | 0 | Giảm 50% |
| 3 | 11 | Giảm 50% |
| 4 | 12 | Giảm 20% |
| 5 | 13 | Giảm 20% |
| 6 | 17 | Giảm 20% |
| 7 | 18 | Không giảm |
| 8 | 19 | Không giảm |

---

### Bài mẫu 19 — Khó · Phức tạp  
**Số lần rút tiền trong tháng (tối đa 10 lần, mỗi lần 5–50tr)**

**Đề bài (chi tiết):**  
Trong tháng, khách được rút tối đa **10 lần**; mỗi lần **từ 5 triệu đến 50 triệu** VNĐ. BVA cho **số lần rút** (0, 1, …, 10, 11) và cho **số tiền một lần** (5tr, 50tr). Có thể kết hợp test: lần thứ 10 với 50tr (OK); lần thứ 11 (từ chối).

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
- Số lần: min = 0 (hoặc 1), max = **10** (lần thứ 11 = invalid).  
- Số tiền/lần: min = **5.000.000**, max = **50.000.000**.

**Bước 2 – Chọn giá trị theo BVA:**  
- Số lần: 0, 1, 9, 10, 11.  
- Số tiền: 4.999.999, 5.000.000, 5.000.001; 49.999.999, 50.000.000, 50.000.001.

**Bước 3 – Test case (ví dụ):**

| TC | Số lần rút (trong tháng) | Số tiền 1 lần (VNĐ) | Kỳ vọng |
|----|---------------------------|----------------------|--------|
| 1 | 0 | 10.000.000 | Không cho rút (0 lần) hoặc tùy đặc tả |
| 2 | 1 | 4.999.999 | Từ chối (dưới 5tr) |
| 3 | 1 | 5.000.000 | Chấp nhận |
| 4 | 10 | 50.000.000 | Chấp nhận (đúng biên) |
| 5 | 11 | 5.000.000 | Từ chối (vượt 10 lần/tháng) |
| 6 | 1 | 50.000.001 | Từ chối (vượt 50tr/lần) |

---

### Bài mẫu 20 — Khó · Thực tế  
**Độ dài nội dung bài viết (10–5000 ký tự)**

**Đề bài (chi tiết):**  
Ô **nội dung bài viết** chấp nhận **từ 10 đến 5000 ký tự**. Dưới 10 hoặc trên 5000 → báo lỗi. Hãy dùng **BVA** thiết kế test case cho **độ dài** nội dung.

**Hướng dẫn giải:**

**Bước 1 – Xác định biên:**  
- Biên dưới: **10** ký tự.  
- Biên trên: **5000** ký tự.

**Bước 2 – Chọn giá trị theo BVA:**  
9, 10, 11; 4999, 5000, 5001. Có thể thêm 0 (rỗng) và giá trị trong khoảng (ví dụ 2550).

**Bước 3 – Test case:**

| TC | Độ dài (số ký tự) | Kỳ vọng |
|----|-------------------|--------|
| 1 | 0 (rỗng) | Từ chối (dưới tối thiểu) |
| 2 | 9 | Từ chối |
| 3 | 10 | Chấp nhận |
| 4 | 11 | Chấp nhận |
| 5 | 2550 | Chấp nhận (trong khoảng) |
| 6 | 4999 | Chấp nhận |
| 7 | 5000 | Chấp nhận |
| 8 | 5001 | Từ chối (vượt tối đa) |

---



## PHẦN 2: BÀI TẬP TỰ LUYỆN

### Bài 1
Ô **năm sinh**: 1900–năm hiện tại. Dùng BVA thiết kế test case cho ô năm sinh.

### Bài 2
**Số trang** in: tối thiểu 1, tối đa 999. BVA cho số trang.

### Bài 3
**Mật khẩu** độ dài 8–32 ký tự. BVA cho độ dài mật khẩu.

### Bài 4
**Phí giao dịch** theo số tiền: 0–1tr: 5k; 1tr–10tr: 10k; 10tr–50tr: 20k; > 50tr: không hỗ trợ. BVA cho số tiền giao dịch.

### Bài 5
**Tháng** nhập vào: 1–12. BVA cho trường tháng.

### Bài 6
**Độ dài tên file** tối đa 255 ký tự. BVA cho độ dài tên file.

### Bài 7
**Số ký tự** bình luận: tối thiểu 1, tối đa 500. BVA thiết kế test case.

### Bài 8
**Hạn mức rút ATM**: 1–20 triệu/lần. BVA cho số tiền rút một lần.

### Bài 9
**Nhiệt độ** điều hòa: 16–30°C, bước 1°C. BVA cho giá trị nhiệt độ.

### Bài 10
**Số ngày thuê** xe: tối thiểu 1, tối đa 30 ngày. BVA cho số ngày thuê.

---

### Bài 11 
**Số phòng** khách sạn: 101–999. BVA cho số phòng.

### Bài 12 — Trung bình
**Phần trăm giảm giá** nhập tay: 0–100 (số nguyên). BVA thiết kế test case.

### Bài 13 — Trung bình · Thực tế
**Số ngày trả trễ** sách thư viện (0–30, quá 30 bị phạt nặng). BVA cho số ngày.

### Bài 14 — Trung bình · Phức tạp
**Điểm TOEIC** (0–990, bước 5). BVA cho điểm (biên 450, 990 nếu có mức thưởng).

### Bài 15 — Khó · Thực tế
**Số tiền đặt cọc** đặt phòng: 20%–100% tổng tiền, bước 10%. BVA cho % (và có thể tổng tiền cố định).

### Bài 16 — Khó
**Hai biên:** **Số lượng tồn** (0–9999) và **số lượng đặt** (1–100). Đặt không được vượt tồn. BVA cho cả hai trường.

### Bài 17 — Trung bình · Thực tế
**Số tháng đóng bảo hiểm** (1–60 tháng). BVA cho số tháng.

### Bài 18 — Khó · Thực tế
**Năm kinh nghiệm** (0–40) cho hồ sơ xin việc. BVA cho ô năm kinh nghiệm.

### Bài 19 — Khó · Phức tạp
**Khoảng nhiệt độ** (min, max): mỗi giá trị 15–35°C, min ≤ max. BVA cho min và max (và test min > max).

### Bài 20 — Khó · Thực tế
**Số serial sản phẩm**: đúng 12 ký tự (chữ và số). BVA cho **độ dài** chuỗi (11, 12, 13).

---

*Hết phần Phân tích giá trị biên.*
