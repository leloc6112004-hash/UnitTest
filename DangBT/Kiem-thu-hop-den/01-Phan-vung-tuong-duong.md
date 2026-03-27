# Bài tập: Phân vùng tương đương (Equivalence Partitioning)

**Chương: Kiểm thử hộp đen**  
**Cấu trúc:** 2 phần — **Bài tập mẫu** (20 bài, có hướng dẫn giải chi tiết) và **Bài tập tự luyện** (20 bài, có đề và gợi ý).

---

## Quy trình chuẩn — Phân vùng tương đương

Làm bài theo **4 bước** sau (xem thêm *HUONG-DAN-CHUNG.md*):

1. **Đọc kỹ đặc tả** — Xác định đầu vào, khoảng giá trị, ràng buộc, kiểu dữ liệu.
2. **Liệt kê phân vùng hợp lệ (valid)** — Mỗi khoảng/điều kiện cho kết quả khác nhau = 1 phân vùng.
3. **Liệt kê phân vùng không hợp lệ (invalid)** — Ngoài khoảng, sai kiểu, rỗng, null.
4. **Thiết kế test case** — Mỗi phân vùng chọn **ít nhất 1 giá trị đại diện**; bảng có cột: TC | Đầu vào | Kỳ vọng.

**Lưu ý:** Luôn có cả valid và invalid; mỗi phân vùng phải được phủ ít nhất 1 lần.

---

## PHẦN 1: BÀI TẬP MẪU

---

### Bài mẫu 1 — Mức độ: Dễ  
**Số lượng sản phẩm trong giỏ hàng**

**Đề bài (chi tiết):**  
Trong form nhập **số lượng sản phẩm** khi thêm vào giỏ hàng, hệ thống yêu cầu:
- Giá trị phải là **số nguyên dương**.
- Số lượng **tối đa 99** (từ 1 đến 99).
- Nếu nhập ngoài khoảng hoặc không đúng kiểu dữ liệu, hệ thống báo lỗi và không thêm vào giỏ.

Hãy dùng kỹ thuật **phân vùng tương đương** để:
1. Liệt kê các phân vùng (valid và invalid).
2. Thiết kế bộ test case tối thiểu để phủ hết các phân vùng.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Theo đặc tả, chỉ có một khoảng hợp lệ: số nguyên từ **1 đến 99**. Mọi giá trị trong khoảng này đều được xử lý giống nhau (cho phép thêm vào giỏ).

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- Số nguyên **≤ 0** (0, số âm).
- Số nguyên **> 99**.
- **Số thập phân** (ví dụ 5.5) vì yêu cầu số nguyên.
- **Không phải số**: rỗng, ký tự chữ, ký tự đặc biệt.

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ giá trị |
|---|-----------|------|----------------|
| 1 | 1 ≤ số lượng ≤ 99 (số nguyên) | Valid | 1, 50, 99 |
| 2 | Số lượng ≤ 0 | Invalid | 0, -1 |
| 3 | Số lượng > 99 | Invalid | 100, 999 |
| 4 | Số thập phân | Invalid | 10.5, 3.2 |
| 5 | Rỗng / không phải số | Invalid | "", "abc", "12a" |

**Bước 4 – Test case tối thiểu (mỗi phân vùng ít nhất 1 giá trị đại diện):**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | 50 | Hợp lệ, thêm vào giỏ |
| 2 | 0 | Lỗi / Invalid |
| 3 | 100 | Lỗi / Invalid |
| 4 | 25.5 | Lỗi / Invalid |
| 5 | "" (rỗng) | Lỗi / Invalid |

---

### Bài mẫu 2 — Mức độ: Dễ  
**Mã khuyến mãi**

**Đề bài (chi tiết):**  
Ô nhập **mã khuyến mãi** trong form thanh toán có quy tắc:
- Mã **đúng 8 ký tự**.
- Chỉ chấp nhận **chữ in hoa** từ A đến Z (không có số, không dấu, không khoảng trắng).
- Ví dụ mã hợp lệ: `ABCD1234` không được (có số); `PROMO202` không được; `GIFTCARD` được.

Hãy phân tích phân vùng tương đương và thiết kế test case tối thiểu cho ô nhập mã khuyến mãi.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng hợp lệ:**  
Một phân vùng: chuỗi **đúng 8 ký tự**, **toàn bộ là chữ in hoa A–Z**.

**Bước 2 – Phân vùng không hợp lệ:**  
- Độ dài **khác 8** (ít hơn hoặc nhiều hơn).
- Có **chữ thường** (a–z).
- Có **số** (0–9) hoặc **ký tự đặc biệt**.
- **Rỗng** hoặc null.

**Bước 3 – Bảng phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Đúng 8 ký tự, toàn A–Z | Valid | "GIFTCARD", "ABCDEFGH" |
| 2 | Độ dài ≠ 8 | Invalid | "ABC", "ABCDEFGHIJ" |
| 3 | Có chữ thường | Invalid | "GiftCard" |
| 4 | Có số / ký tự đặc biệt | Invalid | "GIFT1234", "GIFT-CARD" |
| 5 | Rỗng | Invalid | "" |

**Bước 4 – Test case:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | "GIFTCARD" | Hợp lệ |
| 2 | "PROMO" | Lỗi (độ dài < 8) |
| 3 | "giftcard" | Lỗi (chữ thường) |
| 4 | "GIFT1234" | Lỗi (có số) |
| 5 | "" | Lỗi (rỗng) |

---

### Bài mẫu 3 — Mức độ: Dễ  
**Giảm giá theo loại thẻ thành viên**

**Đề bài (chi tiết):**  
Hệ thống tính **giảm giá** theo **loại thẻ thành viên** (chọn một trong bốn loại):
- **Khách thường:** 0% giảm.
- **Thành viên Bạc:** 5% giảm.
- **Thành viên Vàng:** 10% giảm.
- **Thành viên Kim cương:** 15% giảm.

Chỉ có đúng bốn loại trên; mỗi loại ứng với một mức giảm cố định. Nếu không chọn hoặc chọn giá trị không tồn tại thì không áp dụng giảm giá và có thể báo lỗi.

Dùng **phân vùng tương đương** thiết kế test case cho chức năng chọn loại thẻ và áp dụng giảm giá.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng hợp lệ:**  
Mỗi loại thẻ là **một phân vùng valid** vì đầu ra (mức giảm) khác nhau: Khách thường, Bạc, Vàng, Kim cương → 4 phân vùng valid.

**Bước 2 – Phân vùng không hợp lệ:**  
- Giá trị **không thuộc** bốn loại trên (ví dụ "Platinum", mã sai).
- **Null / rỗng** (không chọn).

**Bước 3 – Bảng phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Khách thường | Valid | "THUONG" |
| 2 | Thành viên Bạc | Valid | "BAC" |
| 3 | Thành viên Vàng | Valid | "VANG" |
| 4 | Thành viên Kim cương | Valid | "KIMCUONG" |
| 5 | Không thuộc 4 loại / null / rỗng | Invalid | "PLATINUM", "", null |

**Bước 4 – Test case:**

| TC | Đầu vào (loại thẻ) | Kỳ vọng |
|----|--------------------|--------|
| 1 | Khách thường | 0% giảm |
| 2 | Bạc | 5% giảm |
| 3 | Vàng | 10% giảm |
| 4 | Kim cương | 15% giảm |
| 5 | "" hoặc giá trị sai | Lỗi / không giảm |

---

### Bài mẫu 4 — Mức độ: Dễ  
**Ô nhập tuổi trong form đăng ký**

**Đề bài (chi tiết):**  
Trong form đăng ký tài khoản, ô **tuổi** có ràng buộc:
- Chỉ chấp nhận **số nguyên**.
- Tuổi **từ 18 đến 65** (18 ≤ tuổi ≤ 65) mới được đăng ký.
- Ngoài khoảng này hoặc không đúng kiểu dữ liệu thì báo lỗi và không cho gửi form.

Hãy dùng **phân vùng tương đương** thiết kế test case cho ô tuổi.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng hợp lệ:**  
Một khoảng: **18 ≤ tuổi ≤ 65**, số nguyên. Mọi giá trị trong khoảng đều được xử lý giống nhau (cho phép đăng ký).

**Bước 2 – Phân vùng không hợp lệ:**  
- Tuổi **< 18** (ví dụ 0, 17).
- Tuổi **> 65** (66, 100).
- **Không phải số nguyên** (25.5, 30.1).
- **Không phải số**: rỗng, ký tự.

**Bước 3 – Bảng phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | 18 ≤ tuổi ≤ 65 (số nguyên) | Valid | 18, 25, 65 |
| 2 | Tuổi < 18 | Invalid | 0, 17 |
| 3 | Tuổi > 65 | Invalid | 66, 100 |
| 4 | Không phải số nguyên | Invalid | 25.5, 30.1 |
| 5 | Rỗng / ký tự | Invalid | "", "abc" |

**Bước 4 – Test case:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | 25 | Hợp lệ |
| 2 | 17 | Lỗi |
| 3 | 66 | Lỗi |
| 4 | 25.5 | Lỗi |
| 5 | "" | Lỗi |

---

### Bài mẫu 5 — Mức độ: Trung bình  
**Điểm môn học (đạt / không đạt)**

**Đề bài (chi tiết):**  
Chương trình xếp loại **điểm môn học** theo thang 10, **làm tròn 1 chữ số thập phân**:
- **Điểm < 5:** Không đạt.
- **Điểm ≥ 5:** Đạt.

Điểm hợp lệ nằm trong đoạn [0, 10]. Nếu nhập ngoài [0, 10] hoặc không phải số thì báo lỗi.

Hãy phân tích phân vùng tương đương và thiết kế test case tối thiểu cho ô nhập điểm.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng hợp lệ:**  
Theo đặc tả có hai khoảng xử lý khác nhau: [0, 5) → không đạt; [5, 10] → đạt. Nên có **2 phân vùng valid**.

**Bước 2 – Phân vùng không hợp lệ:**  
- Điểm **< 0**; điểm **> 10**.
- Không phải số / rỗng (tùy đặc tả có thể gộp hoặc tách).

**Bước 3 – Bảng phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | 0 ≤ điểm < 5 | Valid | 0, 2.5, 4.9 |
| 2 | 5 ≤ điểm ≤ 10 | Valid | 5.0, 7.5, 10.0 |
| 3 | Điểm < 0 | Invalid | -0.1, -5 |
| 4 | Điểm > 10 | Invalid | 10.1, 15 |
| 5 | Không phải số / rỗng | Invalid | "", "abc" |

**Bước 4 – Test case:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | 4.5 | Không đạt |
| 2 | 6.0 | Đạt |
| 3 | -0.1 | Lỗi |
| 4 | 10.1 | Lỗi |
| 5 | "" | Lỗi |

---

### Bài mẫu 6 — Mức độ: Trung bình  
**Xếp loại học lực THPT theo điểm trung bình**

**Đề bài (chi tiết):**  
Chương trình xếp loại **học lực** THPT theo **điểm trung bình (ĐTB)**, làm tròn 1 chữ số thập phân. Quy định:
- **0 ≤ ĐTB < 5:** Yếu  
- **5 ≤ ĐTB < 7:** Trung bình  
- **7 ≤ ĐTB < 8:** Khá  
- **8 ≤ ĐTB < 9:** Giỏi  
- **9 ≤ ĐTB ≤ 10:** Xuất sắc  

ĐTB ngoài [0, 10] hoặc không phải số thì hệ thống báo lỗi. Hãy phân tích các phân vùng tương đương và thiết kế tối thiểu các test case để phủ hết phân vùng.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Theo đặc tả có **5 khoảng** xử lý khác nhau: [0, 5), [5, 7), [7, 8), [8, 9), [9, 10] → 5 phân vùng valid.

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- **ĐTB < 0** (ví dụ -0.1, -5).  
- **ĐTB > 10** (10.1, 15).

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ giá trị |
|---|-----------|------|----------------|
| 1 | ĐTB < 0 | Invalid | -0.1, -5 |
| 2 | 0 ≤ ĐTB < 5 | Valid | 2.5, 4.9 |
| 3 | 5 ≤ ĐTB < 7 | Valid | 5.0, 6.5 |
| 4 | 7 ≤ ĐTB < 8 | Valid | 7.0, 7.5 |
| 5 | 8 ≤ ĐTB < 9 | Valid | 8.0, 8.5 |
| 6 | 9 ≤ ĐTB ≤ 10 | Valid | 9.0, 10.0 |
| 7 | ĐTB > 10 | Invalid | 10.1, 12 |

**Bước 4 – Test case (mỗi phân vùng ít nhất 1 giá trị đại diện):**

| TC | ĐTB | Kỳ vọng |
|----|-----|--------|
| 1 | -0.1 | Lỗi / Invalid |
| 2 | 4.5 | Yếu |
| 3 | 6.0 | Trung bình |
| 4 | 7.5 | Khá |
| 5 | 8.5 | Giỏi |
| 6 | 9.5 | Xuất sắc |
| 7 | 10.1 | Lỗi / Invalid |

---

### Bài mẫu 7 — Mức độ: Trung bình  
**Phí vận chuyển theo khối lượng đơn hàng**

**Đề bài (chi tiết):**  
Hệ thống tính **phí vận chuyển** theo **khối lượng đơn hàng** (đơn vị: kg), quy định:
- **0 < khối lượng ≤ 5 kg:** 30.000 VNĐ  
- **5 < khối lượng ≤ 20 kg:** 50.000 VNĐ  
- **20 < khối lượng ≤ 50 kg:** 80.000 VNĐ  
- **Khối lượng > 50 kg:** Không hỗ trợ vận chuyển (báo lỗi hoặc thông báo không vận chuyển).  
- **Khối lượng ≤ 0:** Không hợp lệ (báo lỗi).

Đầu vào là số (có thể thập phân). Hãy dùng **phân vùng tương đương** thiết kế test case cho chức năng tính phí vận chuyển.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng hợp lệ:**  
Ba khoảng ứng với ba mức phí: (0, 5], (5, 20], (20, 50] → 3 phân vùng valid.

**Bước 2 – Phân vùng không hợp lệ:**  
- **Khối lượng ≤ 0** (0, số âm).  
- **Khối lượng > 50** (không vận chuyển).

**Bước 3 – Bảng phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Khối lượng ≤ 0 | Invalid | -1, 0 |
| 2 | 0 < khối lượng ≤ 5 | Valid | 1, 3, 5 |
| 3 | 5 < khối lượng ≤ 20 | Valid | 10, 15, 20 |
| 4 | 20 < khối lượng ≤ 50 | Valid | 25, 35, 50 |
| 5 | Khối lượng > 50 | Invalid | 50.1, 60 |

**Bước 4 – Test case:**

| TC | Khối lượng (kg) | Kỳ vọng |
|----|-----------------|--------|
| 1 | -1 | Lỗi |
| 2 | 3 | 30.000 VNĐ |
| 3 | 10 | 50.000 VNĐ |
| 4 | 35 | 80.000 VNĐ |
| 5 | 60 | Không vận chuyển / Lỗi |

---

### Bài mẫu 8 — Mức độ: Trung bình  
**Phí bảo hiểm theo độ tuổi**

**Đề bài (chi tiết):**  
Công ty bảo hiểm tính **phí bảo hiểm** theo **độ tuổi** (số nguyên, tuổi hiện tại):
- **18–30 tuổi:** 100.000 VNĐ/tháng  
- **31–45 tuổi:** 150.000 VNĐ/tháng  
- **46–60 tuổi:** 200.000 VNĐ/tháng  
- **Tuổi < 18 hoặc > 60:** Không bán bảo hiểm (báo lỗi).

Hãy dùng **phân vùng tương đương** thiết kế test case cho ô nhập tuổi khi tính phí.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng hợp lệ:**  
Ba khoảng tuổi ứng với ba mức phí: [18, 30], [31, 45], [46, 60] → 3 phân vùng valid.

**Bước 2 – Phân vùng không hợp lệ:**  
- **Tuổi < 18**; **tuổi > 60**.  
- Có thể bổ sung: không phải số nguyên, rỗng (tùy đặc tả).

**Bước 3 – Bảng phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Tuổi < 18 | Invalid | 0, 17 |
| 2 | 18 ≤ tuổi ≤ 30 | Valid | 18, 25, 30 |
| 3 | 31 ≤ tuổi ≤ 45 | Valid | 31, 40, 45 |
| 4 | 46 ≤ tuổi ≤ 60 | Valid | 46, 50, 60 |
| 5 | Tuổi > 60 | Invalid | 61, 100 |

**Bước 4 – Test case:**

| TC | Tuổi | Kỳ vọng |
|----|------|--------|
| 1 | 17 | Lỗi / Không bán |
| 2 | 25 | 100.000 VNĐ |
| 3 | 40 | 150.000 VNĐ |
| 4 | 55 | 200.000 VNĐ |
| 5 | 65 | Lỗi / Không bán |

---

### Bài mẫu 9 — Mức độ: Trung bình  
**Kiểm tra năm nhuận**

**Đề bài (chi tiết):**  
Phần mềm kiểm tra **năm nhuận**: người dùng nhập **năm** (số nguyên dương). Quy tắc năm nhuận:
- Chia hết cho **4** và **không** chia hết cho **100** → Năm nhuận.  
- Hoặc chia hết cho **400** → Năm nhuận.  
- Các trường hợp còn lại (số nguyên dương) → Không nhuận.  
- Năm ≤ 0 hoặc không phải số nguyên → Đầu vào không hợp lệ (báo lỗi).

Hãy phân tích **phân vùng tương đương** và thiết kế test case tối thiểu.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng hợp lệ (theo kết quả xử lý):**  
- **Năm nhuận** (ví dụ 2024, 2000).  
- **Năm không nhuận** (2023, 1900).

**Bước 2 – Phân vùng không hợp lệ:**  
- **Năm ≤ 0** (-1, 0).  
- **Không phải số / không phải số nguyên** (rỗng, "abc", 2024.5).

**Bước 3 – Bảng phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Năm nhuận (chia 4, không chia 100; hoặc chia 400) | Valid | 2024, 2000 |
| 2 | Năm không nhuận | Valid | 2023, 1900 |
| 3 | Năm ≤ 0 | Invalid | -1, 0 |
| 4 | Không phải số / không nguyên | Invalid | "", "abc", 2024.5 |

**Bước 4 – Test case:**

| TC | Năm | Kỳ vọng |
|----|-----|--------|
| 1 | 2024 | Năm nhuận |
| 2 | 2023 | Không nhuận |
| 3 | 0 | Lỗi |
| 4 | "abc" | Lỗi |

---

### Bài mẫu 10 — Mức độ: Khó  
**Số điện thoại Việt Nam**

**Đề bài (chi tiết):**  
Ô nhập **số điện thoại** Việt Nam trong form liên hệ có quy định:
- **Đúng 10 chữ số.**  
- **Bắt đầu bằng 0** (ví dụ 09..., 08..., 03...).  
- Chỉ chứa **chữ số** (0–9), không có khoảng trắng hay ký tự khác.  
- Ví dụ hợp lệ: `0912345678`.  
- Rỗng, sai độ dài, không bắt đầu 0, hoặc có ký tự không phải số → báo lỗi.

Hãy phân tích **phân vùng tương đương** và thiết kế test case tối thiểu cho ô nhập số điện thoại.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng hợp lệ:**  
Một phân vùng: chuỗi **đúng 10 ký tự**, **bắt đầu bằng 0**, **toàn chữ số** (0–9).

**Bước 2 – Phân vùng không hợp lệ:**  
- **Độ dài < 10** (ví dụ "091234567").  
- **Độ dài > 10** ("09123456789").  
- **Không bắt đầu bằng 0** ("9123456789").  
- **Có ký tự không phải số** ("091234567a", "09 123 4567").  
- **Rỗng**.

**Bước 3 – Bảng phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Đúng 10 chữ số, bắt đầu 0 | Valid | "0912345678" |
| 2 | Độ dài < 10 | Invalid | "091234567" |
| 3 | Độ dài > 10 | Invalid | "09123456789" |
| 4 | Không bắt đầu 0 | Invalid | "9123456789" |
| 5 | Có ký tự không phải số | Invalid | "091234567a" |
| 6 | Rỗng | Invalid | "" |

**Bước 4 – Test case:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | "0912345678" | Hợp lệ |
| 2 | "091234567" | Lỗi |
| 3 | "09123456789" | Lỗi |
| 4 | "9123456789" | Lỗi |
| 5 | "091234567a" | Lỗi |
| 6 | "" | Lỗi |

---

### Bài mẫu 11 — Mức độ: Dễ · Thực tế  
**Số lượng khách trong đặt bàn nhà hàng**

**Đề bài (chi tiết):**  
Nhà hàng cho phép đặt bàn với **số khách** trong khoảng:
- Giá trị là **số nguyên**.
- **Từ 1 đến 20** khách (1 ≤ số khách ≤ 20).
- Ngoài khoảng hoặc không đúng kiểu dữ liệu thì báo lỗi và không cho đặt bàn.

Hãy dùng **phân vùng tương đương** thiết kế test case cho ô nhập số khách.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Theo đặc tả, một khoảng hợp lệ: số nguyên từ **1 đến 20**. Mọi giá trị trong khoảng này đều được xử lý giống nhau (cho phép đặt bàn).

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- Số nguyên **≤ 0** (0, số âm).
- Số nguyên **> 20**.
- **Số thập phân** (ví dụ 5.5).
- **Không phải số**: rỗng, ký tự.

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ giá trị |
|---|-----------|------|----------------|
| 1 | 1 ≤ số khách ≤ 20 (số nguyên) | Valid | 1, 10, 20 |
| 2 | Số khách ≤ 0 | Invalid | 0, -1 |
| 3 | Số khách > 20 | Invalid | 21, 50 |
| 4 | Số thập phân | Invalid | 5.5, 10.2 |
| 5 | Rỗng / không phải số | Invalid | "", "abc" |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | 10 | Hợp lệ, cho đặt bàn |
| 2 | 0 | Lỗi / Invalid |
| 3 | 21 | Lỗi / Invalid |
| 4 | 5.5 | Lỗi / Invalid |
| 5 | "" (rỗng) | Lỗi / Invalid |

---

### Bài mẫu 12 — Mức độ: Trung bình · Thực tế  
**Mã số bảo hiểm y tế (BHYT)**

**Đề bài (chi tiết):**  
Ô nhập **mã BHYT** (bảo hiểm y tế) có quy định:
- **10 ký tự** hoặc **15 ký tự** (hai format khác nhau).
- **Bắt đầu bằng 2 chữ số** (mã đơn vị), phần còn lại là **chữ số** (0–9).
- Ví dụ hợp lệ: `0101234567` (10 ký tự), `010123456789012` (15 ký tự).
- Sai độ dài, có chữ cái, không bắt đầu 2 số, rỗng → báo lỗi.

Hãy dùng **phân vùng tương đương** thiết kế test case cho ô nhập mã BHYT.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Hai format khác nhau nên **hai phân vùng valid**: đúng 10 chữ số (bắt đầu 2 số); đúng 15 chữ số (bắt đầu 2 số).

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- Độ dài **khác 10 và 15** (ví dụ 8, 12, 16 ký tự).
- **Có ký tự không phải số** (chữ cái, ký tự đặc biệt).
- **Không bắt đầu bằng 2 chữ số** (nếu có thể tách).
- **Rỗng** hoặc null.

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Đúng 10 chữ số, bắt đầu 2 số | Valid | "0101234567" |
| 2 | Đúng 15 chữ số, bắt đầu 2 số | Valid | "010123456789012" |
| 3 | Độ dài khác 10 và 15 | Invalid | "01234", "0101234567890123" |
| 4 | Có ký tự không phải số | Invalid | "01abc34567" |
| 5 | Rỗng | Invalid | "" |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | "0101234567" | Hợp lệ (10 ký tự) |
| 2 | "010123456789012" | Hợp lệ (15 ký tự) |
| 3 | "01234" | Lỗi (độ dài) |
| 4 | "01abc34567" | Lỗi (có chữ) |
| 5 | "" | Lỗi (rỗng) |

---

### Bài mẫu 13 — Mức độ: Trung bình · Phức tạp  
**Hạng thẻ máy bay (Economy / Business / First)**

**Đề bài (chi tiết):**  
Hệ thống tính **phí đổi hạng** vé máy bay theo **hạng hiện tại** và **hạng đích**. Chỉ có 3 hạng: **E** (Economy), **B** (Business), **F** (First).
- Đổi **nâng hạng** (E→B, E→F, B→F): có phí khác nhau tùy cặp.
- Đổi **hạ hạng** (B→E, F→E, F→B) hoặc **cùng hạng** (E→E, B→B, F→F): phí = 0 hoặc báo lỗi tùy quy định.
- Giá trị không thuộc {E, B, F} hoặc null → lỗi.

Hãy dùng **phân vùng tương đương** cho **cặp (hạng hiện tại, hạng đích)** và thiết kế test case.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Mỗi **nhóm** xử lý giống nhau là một phân vùng: (1) Nâng hạng E→B, E→F, B→F; (2) Hạ hạng (nếu hỗ trợ); (3) Cùng hạng. Có thể tách từng cặp nếu phí khác nhau → nhiều phân vùng valid.

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- **Hạng không thuộc {E, B, F}** (ví dụ "X", "Economy" sai format).
- **Null / rỗng** (không chọn).

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ (hiện tại, đích) |
|---|-----------|------|-------------------------|
| 1 | Nâng hạng (E→B, E→F, B→F) | Valid | (E, B), (E, F), (B, F) |
| 2 | Hạ hạng / Cùng hạng | Valid | (B, E), (F, E), (E, E) |
| 3 | Không thuộc {E,B,F} / null | Invalid | ("X", B), (E, null) |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào (hạng hiện tại, hạng đích) | Kỳ vọng |
|----|-------------------------------------|--------|
| 1 | (E, B) | Phí nâng hạng E→B |
| 2 | (E, F) | Phí nâng hạng E→F |
| 3 | (B, E) | Phí = 0 hoặc thông báo |
| 4 | (E, E) | Phí = 0 hoặc thông báo |
| 5 | ("X", B) | Lỗi / Invalid |

---

### Bài mẫu 14 — Mức độ: Trung bình · Thực tế  
**Số ngày nghỉ phép năm (HR)**

**Đề bài (chi tiết):**  
Công ty quy định **số ngày nghỉ phép** được hưởng trong năm theo **thâm niên** (số năm làm việc):
- **Dưới 1 năm**: 0 ngày nghỉ phép.
- **Từ 1 đến 5 năm**: 12 ngày.
- **Trên 5 năm**: 15 ngày.
- Thâm niên nhập vào là **số năm** (số nguyên hoặc thập phân làm tròn). Số năm < 0, không phải số, rỗng → báo lỗi.

Hãy dùng **phân vùng tương đương** thiết kế test case cho ô nhập **số năm thâm niên**.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Ba khoảng cho ba mức nghỉ phép khác nhau: **[0, 1)** → 0 ngày; **[1, 5]** → 12 ngày; **(5, +∞)** → 15 ngày. → **3 phân vùng valid**.

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- **Số năm < 0** (âm).
- **Không phải số** (ký tự, rỗng).

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | 0 ≤ thâm niên < 1 | Valid | 0, 0.5, 0.9 |
| 2 | 1 ≤ thâm niên ≤ 5 | Valid | 1, 3, 5 |
| 3 | Thâm niên > 5 | Valid | 6, 10 |
| 4 | Thâm niên < 0 | Invalid | -1, -0.1 |
| 5 | Không phải số / rỗng | Invalid | "", "abc" |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào (số năm) | Kỳ vọng |
|----|------------------|--------|
| 1 | 0.5 | 0 ngày nghỉ phép |
| 2 | 3 | 12 ngày |
| 3 | 6 | 15 ngày |
| 4 | -1 | Lỗi / Invalid |
| 5 | "" | Lỗi / Invalid |

---

### Bài mẫu 15 — Mức độ: Khó · Thực tế  
**Mã số thuế cá nhân (MST cá nhân)**

**Đề bài (chi tiết):**  
Ô nhập **mã số thuế cá nhân** có quy định:
- **10 chữ số** (format cũ) hoặc **13 chữ số** (format mới: 10 số đầu như MST doanh nghiệp, 3 số cuối là mã chi nhánh).
- Chỉ chấp nhận **chữ số** (0–9).
- Ví dụ hợp lệ: `0123456789`, `0123456789012`. Sai độ dài, có chữ cái hoặc ký tự khác, rỗng → báo lỗi.

Hãy dùng **phân vùng tương đương** thiết kế test case cho ô MST cá nhân.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Hai format độ dài khác nhau → **hai phân vùng valid**: đúng 10 chữ số; đúng 13 chữ số.

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- Độ dài **khác 10 và 13** (ví dụ 9, 11, 12 ký tự).
- **Có ký tự không phải số** (chữ, ký tự đặc biệt).
- **Rỗng** hoặc null.

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Đúng 10 chữ số | Valid | "0123456789" |
| 2 | Đúng 13 chữ số | Valid | "0123456789012" |
| 3 | Độ dài khác 10 và 13 | Invalid | "01234", "012345678901" |
| 4 | Có ký tự không phải số | Invalid | "0123456789a" |
| 5 | Rỗng | Invalid | "" |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | "0123456789" | Hợp lệ (10 số) |
| 2 | "0123456789012" | Hợp lệ (13 số) |
| 3 | "01234" | Lỗi (độ dài) |
| 4 | "0123456789a" | Lỗi (có chữ) |
| 5 | "" | Lỗi (rỗng) |

---

### Bài mẫu 16 — Mức độ: Khó · Phức tạp  
**Điểm IELTS (Listening, Reading, Writing, Speaking)**

**Đề bài (chi tiết):**  
Mỗi kỹ năng IELTS (Listening, Reading, Writing, Speaking) nhận **điểm từ 0 đến 9**, **bước 0.5** (0; 0.5; 1; …; 9). Điểm overall = trung bình 4 kỹ năng làm tròn 0.5.
- Ô nhập **một điểm kỹ năng** (ví dụ Listening): hợp lệ khi giá trị ∈ [0, 9] và là **bội của 0.5**.
- Ngoài [0, 9], không phải bội 0.5, không phải số, rỗng → báo lỗi.

Hãy dùng **phân vùng tương đương** thiết kế test case cho **một ô điểm kỹ năng** (ví dụ Listening).

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**
Một phân vùng: giá trị trong **[0, 9]** và là **bội của 0.5** (0, 0.5, 1, …, 9). Mọi giá trị này đều được chấp nhận giống nhau.

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**
- **< 0** (âm).
- **> 9** (ví dụ 9.5 nếu hệ thống không chấp nhận).
- **Trong [0, 9] nhưng không phải bội 0.5** (ví dụ 5.3, 7.2).
- **Không phải số** / rỗng.

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | 0 ≤ điểm ≤ 9, bội 0.5 | Valid | 0, 6.5, 9 |
| 2 | Điểm < 0 | Invalid | -0.5, -1 |
| 3 | Điểm > 9 | Invalid | 9.5, 10 |
| 4 | Trong [0,9] nhưng không bội 0.5 | Invalid | 5.3, 7.2 |
| 5 | Không phải số / rỗng | Invalid | "", "abc" |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | 6.5 | Hợp lệ |
| 2 | -0.5 | Lỗi / Invalid |
| 3 | 9.5 | Lỗi (nếu không chấp nhận > 9) |
| 4 | 5.3 | Lỗi (không bội 0.5) |
| 5 | "" | Lỗi / Invalid |

---

### Bài mẫu 17 — Mức độ: Khó · Thực tế  
**Mã vùng điện thoại cố định (VN)**

**Đề bài (chi tiết):**  
Ô nhập **mã vùng** điện thoại cố định Việt Nam:
- **2 chữ số** (ví dụ 08 HCM, 04 Hà Nội) hoặc **3 chữ số** (một số tỉnh thành).
- Chỉ chấp nhận **chữ số** (0–9). Ví dụ hợp lệ: `08`, `024`.
- Độ dài khác 2 và 3, có chữ cái hoặc ký tự khác, rỗng → báo lỗi. (Hệ thống có thể kiểm tra thêm theo danh sách mã vùng thực tế.)

Hãy dùng **phân vùng tương đương** thiết kế test case cho ô mã vùng.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Hai độ dài khác nhau → **hai phân vùng valid**: đúng 2 chữ số; đúng 3 chữ số.

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- Độ dài **1** ký tự hoặc **4 trở lên**.
- **Có chữ cái** hoặc ký tự không phải số.
- **Rỗng**.

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | Đúng 2 chữ số | Valid | "08", "04" |
| 2 | Đúng 3 chữ số | Valid | "024", "028" |
| 3 | Độ dài 1 hoặc ≥ 4 | Invalid | "8", "0812" |
| 4 | Có ký tự không phải số | Invalid | "0a", "08x" |
| 5 | Rỗng | Invalid | "" |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào | Kỳ vọng |
|----|---------|--------|
| 1 | "08" | Hợp lệ (2 số) |
| 2 | "024" | Hợp lệ (3 số) |
| 3 | "8" | Lỗi (độ dài) |
| 4 | "0812" | Lỗi (độ dài) |
| 5 | "0a" | Lỗi (có chữ) |
| 6 | "" | Lỗi (rỗng) |

---

### Bài mẫu 18 — Mức độ: Trung bình · Phức tạp  
**Loại file upload (ảnh: jpg/png/gif, tối đa 5MB)**

**Đề bài (chi tiết):**  
Chức năng **upload ảnh** có quy định:
- **Định dạng**: chỉ chấp nhận **jpg**, **png**, **gif**.
- **Kích thước**: tối đa **5MB**.
- File không đúng định dạng, vượt 5MB, file rỗng (0 byte), hoặc không chọn file → báo lỗi tương ứng.

Hãy dùng **phân vùng tương đương** cho **đầu vào file** (định dạng + kích thước) và thiết kế test case.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Một phân vùng (hoặc ba nếu xử lý khác nhau từng loại): **định dạng jpg/png/gif** VÀ **kích thước ≤ 5MB**.

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- **Định dạng khác** (pdf, exe, doc, …).
- **Kích thước > 5MB** (đúng định dạng nhưng quá lớn).
- **File rỗng** (0 byte).
- **Không chọn file** (bỏ trống).

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ |
|---|-----------|------|--------|
| 1 | jpg/png/gif và size ≤ 5MB | Valid | ảnh.jpg 2MB, ảnh.png 4MB |
| 2 | Định dạng khác | Invalid | file.pdf, file.exe |
| 3 | Đúng định dạng nhưng size > 5MB | Invalid | ảnh.jpg 6MB |
| 4 | File 0 byte | Invalid | file rỗng |
| 5 | Không chọn file | Invalid | (bỏ trống) |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào (file) | Kỳ vọng |
|----|----------------|--------|
| 1 | ảnh.jpg, 2MB | Hợp lệ, upload thành công |
| 2 | file.pdf | Lỗi (định dạng không hỗ trợ) |
| 3 | ảnh.jpg, 6MB | Lỗi (vượt dung lượng) |
| 4 | File 0 byte (đuôi .jpg) | Lỗi (file rỗng) |
| 5 | Không chọn file | Lỗi (chưa chọn file) |

---

### Bài mẫu 19 — Mức độ: Khó · Thực tế  
**Khoảng thời gian đặt lịch (giờ bắt đầu, giờ kết thúc)**

**Đề bài (chi tiết):**  
Form **đặt phòng họp** có hai trường: **giờ bắt đầu** và **giờ kết thúc**.
- Cả hai trong khung **8:00–18:00**, **bước 30 phút** (8:00, 8:30, 9:00, …, 18:00).
- **Giờ kết thúc phải sau giờ bắt đầu** (không bằng, không trước).
- Giờ ngoài khung, không đúng bước 30 phút, giờ kết thúc ≤ giờ bắt đầu, rỗng → báo lỗi tương ứng.

Hãy dùng **phân vùng tương đương** cho **cặp (giờ bắt đầu, giờ kết thúc)** và thiết kế test case.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Xác định phân vùng hợp lệ (valid):**  
Một phân vùng: **cả hai** trong [8:00, 18:00], **đúng bước 30 phút**, và **giờ kết thúc > giờ bắt đầu**.

**Bước 2 – Xác định phân vùng không hợp lệ (invalid):**  
- **Giờ bắt đầu** ngoài khung hoặc không đúng bước (ví dụ 7:45, 19:00).
- **Giờ kết thúc** ngoài khung hoặc không đúng bước.
- **Giờ kết thúc ≤ giờ bắt đầu** (thứ tự sai).
- **Rỗng** một hoặc cả hai trường.

**Bước 3 – Liệt kê phân vùng:**

| # | Phân vùng | Loại | Ví dụ (bắt đầu, kết thúc) |
|---|-----------|------|----------------------------|
| 1 | Cả hai trong [8:00,18:00], bước 30 phút, kết thúc > bắt đầu | Valid | (9:00, 10:30) |
| 2 | Giờ bắt đầu invalid | Invalid | (7:30, 10:00); (19:00, 10:00) |
| 3 | Giờ kết thúc invalid | Invalid | (9:00, 18:30) |
| 4 | Giờ kết thúc ≤ giờ bắt đầu | Invalid | (10:00, 10:00); (11:00, 9:00) |
| 5 | Rỗng | Invalid | (rỗng, 10:00); (9:00, rỗng) |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào (giờ bắt đầu, giờ kết thúc) | Kỳ vọng |
|----|-------------------------------------|--------|
| 1 | (9:00, 10:30) | Hợp lệ |
| 2 | (7:30, 10:00) | Lỗi (giờ bắt đầu ngoài khung) |
| 3 | (10:00, 10:00) | Lỗi (kết thúc = bắt đầu) |
| 4 | (11:00, 9:00) | Lỗi (kết thúc trước bắt đầu) |
| 5 | (rỗng, 10:00) | Lỗi (thiếu giờ bắt đầu) |

---

### Bài mẫu 20 — Mức độ: Khó · Phức tạp + Thực tế  
**Phiếu đánh giá (1–5 sao + bình luận tùy chọn)**

**Đề bài (chi tiết):**  
Form **đánh giá** có hai trường:
- **Số sao** (bắt buộc): **1 đến 5**, số nguyên. Giá trị khác (0, 6, thập phân, rỗng) → lỗi.
- **Bình luận** (tùy chọn): nếu nhập thì **5–500 ký tự**. Rỗng được phép; nếu có nội dung thì < 5 ký tự hoặc > 500 ký tự → lỗi.

Hãy dùng **phân vùng tương đương** cho **số sao** và cho **bình luận** (xét riêng từng trường), và thiết kế test case.

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân vùng cho số sao (valid / invalid):**  
- **Valid:** 1, 2, 3, 4, 5 (một phân vùng hoặc năm nếu xử lý khác nhau).  
- **Invalid:** 0, 6, thập phân, không phải số, rỗng.

**Bước 2 – Phân vùng cho bình luận (valid / invalid):**  
- **Valid:** rỗng (tùy chọn); 5–500 ký tự.  
- **Invalid:** 1–4 ký tự (nếu nhập); > 500 ký tự.

**Bước 3 – Liệt kê phân vùng (gộp hai trường):**

| # | Phân vùng (số sao / bình luận) | Loại | Ví dụ |
|---|--------------------------------|------|--------|
| 1 | Số sao 1–5, bình luận rỗng | Valid | (5, rỗng) |
| 2 | Số sao 1–5, bình luận 5–500 ký tự | Valid | (3, "Rất tốt...") |
| 3 | Số sao invalid (0, 6, rỗng, …) | Invalid | (0, rỗng); (6, rỗng) |
| 4 | Số sao valid, bình luận 1–4 ký tự | Invalid | (5, "Tốt") |
| 5 | Số sao valid, bình luận > 500 ký tự | Invalid | (5, chuỗi 501 ký tự) |

**Bước 4 – Test case tối thiểu:**

| TC | Đầu vào (số sao, bình luận) | Kỳ vọng |
|----|-----------------------------|--------|
| 1 | (5, rỗng) | Hợp lệ |
| 2 | (3, "Sản phẩm tốt, giao hàng nhanh.") | Hợp lệ |
| 3 | (0, rỗng) | Lỗi (số sao invalid) |
| 4 | (5, "Tốt") | Lỗi (bình luận < 5 ký tự) |
| 5 | (5, chuỗi 501 ký tự) | Lỗi (bình luận > 500 ký tự) |

---



## PHẦN 2: BÀI TẬP TỰ LUYỆN

---

### Bài 1 — Mức độ: Dễ  
**Mã bưu điện (zip code)**

**Đề bài (chi tiết):**  
Ô nhập **mã bưu điện** (zip code) Việt Nam: **đúng 6 chữ số**, chỉ chứa ký tự 0–9, không có khoảng trắng hay ký tự khác. Ví dụ hợp lệ: `700000`, `100000`. Sai độ dài, có chữ cái hoặc ký tự đặc biệt, rỗng → báo lỗi.

**Yêu cầu:** Phân tích phân vùng tương đương và thiết kế test case tối thiểu.

**Gợi ý giải:**  
- Valid: đúng 6 chữ số.  
- Invalid: độ dài ≠ 6; có ký tự không phải số; rỗng.  
→ Ít nhất 4 phân vùng, 4 test case (ví dụ: "700000", "70000", "70a000", "").

---

### Bài 2 — Mức độ: Dễ  
**Điểm môn học (thang 10, đạt/không đạt)**

**Đề bài (chi tiết):**  
Ô nhập **điểm** môn học: thang 10, làm tròn 1 chữ số thập phân. **Điểm < 5** là không đạt, **điểm ≥ 5** là đạt. Điểm hợp lệ trong [0, 10]. Ngoài [0, 10] hoặc không phải số → lỗi.

**Yêu cầu:** Phân vùng tương đương và test case cho ô điểm.

**Gợi ý giải:**  
- Valid: [0, 5); [5, 10]. Invalid: < 0; > 10; không phải số/rỗng.  
→ 5 phân vùng, 5 test case.

---

### Bài 3 — Mức độ: Trung bình  
**Số CMND/CCCD**

**Đề bài (chi tiết):**  
Ô nhập **số CMND/CCCD**: chỉ chấp nhận **9 chữ số** (CMND cũ) **hoặc 12 chữ số** (CCCD mới), toàn bộ là chữ số 0–9. Ví dụ: `001234567` (9 số), `001234567890` (12 số). Độ dài khác 9 và 12, có chữ cái, rỗng → lỗi.

**Yêu cầu:** Phân vùng tương đương và thiết kế test case.

**Gợi ý giải:**  
- Valid: 9 chữ số; 12 chữ số. Invalid: độ dài khác 9 và 12; có ký tự không phải số; rỗng.  
→ Ít nhất 4–5 phân vùng.

---

### Bài 4 — Mức độ: Trung bình  
**Mã số thuế doanh nghiệp**

**Đề bài (chi tiết):**  
Ô nhập **mã số thuế** doanh nghiệp: **10 chữ số** hoặc **13 chữ số**, chỉ chứa 0–9. Ví dụ: `0123456789`, `0123456789012`. Độ dài khác 10 và 13, có chữ cái hoặc ký tự khác, rỗng → báo lỗi.

**Yêu cầu:** Phân vùng tương đương và thiết kế test case.

**Gợi ý giải:**  
- Valid: 10 chữ số; 13 chữ số. Invalid: độ dài khác 10 và 13; có ký tự không phải số; rỗng.  
→ Ít nhất 4–5 phân vùng.

---

### Bài 5 — Mức độ: Trung bình  
**Tên đăng nhập**

**Đề bài (chi tiết):**  
Ô **tên đăng nhập**: **3–30 ký tự**, không chứa **khoảng trắng**. Cho phép chữ cái, số, dấu gạch dưới (_). Ví dụ hợp lệ: `user_01`, `abc`. Độ dài < 3, > 30, có khoảng trắng, rỗng → lỗi.

**Yêu cầu:** Phân vùng tương đương và test case cho ô tên đăng nhập.

**Gợi ý giải:**  
- Valid: 3–30 ký tự, không khoảng trắng. Invalid: < 3 ký tự; > 30 ký tự; có khoảng trắng; rỗng (và có thể: ký tự đặc biệt không cho phép).  
→ 5–6 phân vùng.

---

### Bài 6 — Mức độ: Trung bình  
**Mật khẩu đăng ký (nhiều điều kiện)**

**Đề bài (chi tiết):**  
Chức năng đăng ký: **mật khẩu** phải thỏa **tất cả** các điều kiện: có ít nhất một **chữ hoa**, một **chữ thường**, một **số**, một **ký tự đặc biệt** (ví dụ @, #, $), và **độ dài tối thiểu 8** ký tự. Thiếu bất kỳ điều kiện nào hoặc rỗng → báo lỗi tương ứng.

**Yêu cầu:** Dùng EP thiết kế test case cho ô mật khẩu (mỗi phân vùng có thể là: hợp lệ; thiếu chữ hoa; thiếu chữ thường; thiếu số; thiếu ký tự đặc biệt; độ dài < 8; rỗng).

**Gợi ý giải:**  
- Valid: thỏa tất cả điều kiện.  
- Invalid: thiếu chữ hoa; thiếu chữ thường; thiếu số; thiếu ký tự đặc biệt; độ dài < 8; rỗng.  
→ 7 phân vùng, 7 test case.

---

### Bài 7 — Mức độ: Trung bình  
**Mã đơn hàng (format cố định)**

**Đề bài (chi tiết):**  
Ô nhập **mã đơn hàng**: định dạng **ORD-XXXX**, trong đó **X** là **4 chữ số** (từ 0000 đến 9999). Ví dụ hợp lệ: `ORD-0001`, `ORD-1234`. Sai tiền tố (không phải ORD-), sai độ dài phần số (không đúng 4 chữ số), có chữ cái trong phần số, rỗng → báo lỗi.

**Yêu cầu:** Phân vùng tương đương và thiết kế test case cho ô mã đơn hàng.

**Gợi ý giải:**  
- Valid: đúng format ORD-XXXX (4 chữ số).  
- Invalid: sai tiền tố; phần số không đúng 4 chữ số; có ký tự không hợp lệ; rỗng.  
→ 5 phân vùng trở lên.

---

### Bài 8 — Mức độ: Khó  
**Kiểm tra ngày tháng hợp lệ**

**Đề bài (chi tiết):**  
Chương trình kiểm tra **ngày tháng** nhập vào (năm, tháng, ngày) có hợp lệ hay không (ví dụ 31/02 không hợp lệ, 29/02/2024 hợp lệ vì 2024 nhuận). Cần xét: tháng 1–12, ngày theo từng tháng (28–31 tùy tháng và năm nhuận), năm > 0.

**Yêu cầu:** Phân tích phân vùng tương đương cho **từng đầu vào** (năm, tháng, ngày) và/hoặc cho **bộ (năm, tháng, ngày)**; thiết kế test case.

**Gợi ý giải:**  
- Có thể tách: phân vùng cho **năm** (≤0, >0, nhuận/không nhuận); cho **tháng** (1–12, ngoài khoảng); cho **ngày** (1–28/29/30/31 tùy tháng). Hoặc gộp các bộ (năm, tháng, ngày) thành các lớp tương đương: hợp lệ tháng 31 ngày, 30 ngày, 28/29 ngày; không hợp lệ tháng; không hợp lệ ngày; không hợp lệ năm.  
→ Nhiều phân vùng, nên chọn đại diện cho từng lớp.

---

### Bài 9 — Mức độ: Khó  
**Giảm giá theo tháng và giá trị hóa đơn**

**Đề bài (chi tiết):**  
Siêu thị giảm **50%** cho hóa đơn **trong tháng 2** có **giá trị từ 500.000 VNĐ trở lên**. Các trường hợp khác không giảm (hoặc áp dụng chính sách khác). Đầu vào: tháng (1–12), giá trị hóa đơn (số tiền ≥ 0).

**Yêu cầu:** Dùng **phân vùng tương đương** (và **biên giá trị BVA** nếu cần) để thiết kế test case cho **số tiền được giảm** (hoặc cho việc áp dụng/không áp dụng giảm 50%).

**Gợi ý giải:**  
- Phân vùng theo **tháng**: tháng 2 vs không phải tháng 2.  
- Phân vùng theo **số tiền**: < 500.000; ≥ 500.000.  
- Kết hợp: (tháng 2, ≥ 500k) → giảm 50%; các tổ hợp còn lại → không giảm 50%. Có thể dùng BVA cho biên 500.000 và tháng 1/2/3.  
→ Ít nhất 3–4 phân vùng cho kết quả (giảm 50% / không giảm), hoặc tách theo từng đầu vào rồi kết hợp.

---

### Bài 10 — Mức độ: Khó  
**Ô nhập email**

**Đề bài (chi tiết):**  
Trường **email**: định dạng **xxx@yyy.zzz** (có phần trước @, phần domain, có ít nhất một dấu chấm trong domain), **độ dài tối đa 100** ký tự. Ví dụ hợp lệ: `user@domain.com`. Thiếu @, thiếu phần sau @, nhiều hơn một @, không có dấu chấm trong domain, độ dài > 100, rỗng → báo lỗi.

**Yêu cầu:** Dùng EP thiết kế test case cho ô email.

**Gợi ý giải:**  
- Valid: đúng định dạng, ≤ 100 ký tự.  
- Invalid: thiếu @; thiếu phần sau @; nhiều hơn 1 @; không có dấu chấm trong domain; độ dài > 100; rỗng.  
→ 6–7 phân vùng, 6–7 test case.

---

### Bài 11 
Ô **số phòng** khách sạn: 3 chữ số (101–999). Phân vùng tương đương và test case.

### Bài 12 — Trung bình · Thực tế
**Mã hàng** trong kho: format **SP-XXXX** (X là 4 chữ số). Phân vùng và test case.

### Bài 13 — Trung bình
**Số giờ làm thêm** trong tháng: 0–100, số thập phân 1 chữ số. Phân vùng và test case.

### Bài 14 — Trung bình · Thực tế
**Mã đặt chỗ** máy bay: 6 ký tự (chữ và số), in hoa. Phân vùng và test case.

### Bài 15 — Khó
**Tọa độ** (vĩ độ, kinh độ): vĩ độ -90 đến 90, kinh độ -180 đến 180, số thập phân. Phân vùng cho từng trường.

### Bài 16 — Khó · Thực tế
**Mã bệnh nhân**: BNN-YYMM-XXX (YY năm, MM tháng, XXX số thứ 1–999). Phân vùng và test case.

### Bài 17 — Khó · Phức tạp
**Giá sản phẩm** (VNĐ): số nguyên dương, chia hết cho 1000 (làm tròn nghìn). Phân vùng và test case.

### Bài 18 — Trung bình · Thực tế
**Số lượng tồn kho** nhập thêm: số nguyên ≥ 0, tối đa 99999. Phân vùng và test case.

### Bài 19 — Khó · Thực tế
**Mã lớp học**: 2 chữ cái + 4 số (ví dụ CN001). Phân vùng và test case.

### Bài 20 — Khó · Phức tạp
**Điểm chuẩn đầu vào** theo từng ngành: mỗi ngành một khoảng điểm [a, b], thang 30. Phân vùng cho ô **điểm** khi chọn một ngành cố định.

---

*Hết phần Phân vùng tương đương.*
