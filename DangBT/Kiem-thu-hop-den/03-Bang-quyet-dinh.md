# Bài tập: Bảng quyết định (Decision Table)

**Chương: Kiểm thử hộp đen**  
**Cấu trúc:** 2 phần — **Bài tập mẫu** (20 bài) và **Bài tập tự luyện** (20 bài).

---

## Quy trình chuẩn — Bảng quyết định

Làm bài theo **5 bước** sau (xem thêm *HUONG-DAN-CHUNG.md*):

1. **Liệt kê tất cả điều kiện (C1, C2, …)** — Mỗi điều kiện T/F hoặc vài giá trị rời rạc.
2. **Liệt kê hành động / kết quả** — Ứng với mỗi tổ hợp điều kiện, hệ thống làm gì?
3. **Lập bảng đầy đủ** — Mỗi cột = 1 quy tắc (1 tổ hợp T/F); điền hành động tương ứng.
4. **Rút gọn bảng** — Các cột cùng hành động, chỉ khác 1 điều kiện → gộp, điều kiện đó ghi “−”.
5. **Chuyển mỗi cột thành test case** — Chọn bộ giá trị cụ thể; ghi Đầu vào và Kỳ vọng.

**Lưu ý:** n điều kiện T/F → tối đa 2^n quy tắc; rút gọn để giảm số TC nhưng vẫn phủ đủ.

---

## PHẦN 1: BÀI TẬP MẪU

### Bài mẫu 1

**Đề bài:** Chương trình nhận 3 cạnh a, b, c và xác định có phải **tam giác cân** không. Dùng bảng quyết định thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**
- C1: a, b, c có tạo thành tam giác hợp lệ không? (T/F)
- C2: Có đúng 2 cạnh bằng nhau không? (T/F)

**Bước 2 – Hành động / Kết quả:**
- Không phải tam giác
- Tam giác nhưng không cân
- Tam giác cân

**Bước 3 – Bảng quyết định (rút gọn):**

| Điều kiện / Hành động | R1 | R2 | R3 | R4 |
|------------------------|----|----|----|-----|
| C1: Là tam giác? | F | T | T | T |
| C2: Đúng 2 cạnh bằng nhau? | - | F | T | T* |
| **Không phải tam giác** | X | | | |
| **Tam giác, không cân** | | X | | |
| **Tam giác cân** | | | X | X |

*(R4 có thể bỏ nếu “2 cạnh bằng nhau” chỉ có một cách; giữ nếu có nhiều cách thể hiện.)*

**Bước 4 – Test case từ các quy tắc:**
- TC1 (R1): a=1, b=2, c=10 → không phải tam giác.
- TC2 (R2): a=3, b=4, c=5 → tam giác thường.
- TC3 (R3): a=5, b=5, c=8 → tam giác cân.

---

### Bài mẫu 2

**Đề bài:** **Đăng nhập**: username và password. Mỗi ô có 3 giá trị: Rỗng (B), Hợp lệ (V), Không hợp lệ (I). Xây dựng bảng quyết định và chuyển thành test case.

**Hướng dẫn giải:**

- **Điều kiện:** Username (B / I / V), Password (B / I / V).  
- **Hành động:** Thông báo lỗi (M1: thiếu username, M2: thiếu password, M3: username sai, M4: password sai); Chuyển trang (Login / Home).  
- **Số tổ hợp:** 3×3 = 9. Điền từng cột (B,B)→M1; (B,I),(B,V)→M1; (I,B),(I,I),(I,V)→M3; (V,B)→M2; (V,I)→M4; (V,V)→Home.  
- **Rút gọn:** Các cột cùng hành động, chỉ khác 1 điều kiện → gộp, điều kiện đó ghi “-”.  
- **Test case:** Mỗi cột (sau rút gọn) = 1 hoặc vài test case với giá trị cụ thể (B/I/V).

---

### Bài mẫu 3

**Đề bài:** **Xét học bổng**: không rớt môn; ĐTB ≥ 7.0; môn 4 ≤ điểm < 5 được coi qua nếu ĐTB ≥ 7.5. Bảng quyết định + BVA cho đầu vào điểm.

**Hướng dẫn giải:**

- **Điều kiện:** C1: Có môn nào < 4? (T/F); C2: Có môn nào trong [4, 5) mà ĐTB < 7.5? (T/F); C3: ĐTB ≥ 7.0? (T/F).  
- **Hành động:** Có học bổng / Không học bổng.  
- Lập bảng với 2^3 = 8 quy tắc (hoặc rút gọn theo logic nghiệp vụ).  
- Test case: kết hợp bảng với BVA (điểm 3.9, 4.0, 4.9, 5.0; ĐTB 6.9, 7.0, 7.4, 7.5).

---

### Bài mẫu 4

**Đề bài:** Thư viện: mượn tối đa **500 quyển/năm**, tối đa **5 quyển/lần**, phải **trả hết** mới mượn tiếp. Bảng quyết định + BVA cho “được mượn không” và “mượn tối đa bao nhiêu”.

**Hướng dẫn giải:**

- **Điều kiện:** C1: Đã trả hết sách chưa? (T/F); C2: Số quyển đã mượn trong năm < 500? (T/F); C3: Số quyển yêu cầu lần này ≤ 5? (T/F).  
- **Hành động:** Cho mượn (và số quyển tối đa); Từ chối (lý do: chưa trả / vượt năm / vượt 5 quyển/lần).  
- Bảng 8 cột (2^3), điền kết quả từng tổ hợp.  
- BVA: 499/500/501 quyển trong năm; 4/5/6 quyển mỗi lần.

---

### Bài mẫu 5

**Đề bài:** **Khuyến mãi** mua điện thoại ≥ 20tr (20/11–31/12): tặng quà; khách cũ: ≤ 1 năm giảm 2tr, 1–2 năm giảm 1tr. Bảng quyết định + BVA.

**Hướng dẫn giải:**

- **Điều kiện:** C1: Mua trong đợt? (T/F); C2: Giá ≥ 20tr? (T/F); C3: Khách cũ? (T/F); C4: Thời gian dùng cũ (≤1 năm / (1,2] năm / >2 năm).  
- **Hành động:** Tặng quà (Có/Không); Giảm 0 / 1tr / 2tr.  
- Lập bảng (có thể rút gọn). BVA: giá 19.9tr, 20tr; thời gian 364 ngày, 365 ngày, 366 ngày; 729, 730, 731 ngày.

---

### Bài mẫu 6

**Đề bài:** **Đăng ký hội viên**: tuổi 18–65; quốc tịch VN hoặc có thẻ tạm trú. Bảng quyết định.

**Hướng dẫn giải:**

- C1: 18 ≤ tuổi ≤ 65? (T/F). C2: Quốc tịch VN hoặc có thẻ tạm trú? (T/F).  
- Hành động: Chấp nhận đăng ký / Từ chối (tuổi / hộ khẩu).  
- 4 quy tắc → 4 test case.

---

### Bài mẫu 7

**Đề bài:** **Phí bảo hiểm**: dưới 30 tuổi + không hút thuốc: 100k; dưới 30 + hút thuốc: 150k; từ 30 trở lên + không hút thuốc: 200k; từ 30 + hút thuốc: 250k. Bảng quyết định.

**Hướng dẫn giải:**

- C1: Tuổi < 30? (T/F). C2: Hút thuốc? (T/F).  
- 4 tổ hợp → 4 cột, mỗi cột 1 mức phí. Test case: (25, không), (25, có), (35, không), (35, có).

---

### Bài mẫu 8

**Đề bài:** **Giao hàng**: đơn ≥ 500k miễn phí ship; thành viên Vàng/Kim cương luôn miễn phí. Bảng quyết định.

**Hướng dẫn giải:**

- C1: Đơn ≥ 500k? (T/F). C2: Thành viên Vàng hoặc Kim cương? (T/F).  
- Hành động: Thu phí ship / Miễn phí ship.  
- 4 quy tắc; có thể gộp: miễn phí khi (đơn ≥ 500k) HOẶC (thành viên cao cấp).

---

### Bài mẫu 9

**Đề bài:** **Đổi trả**: trong 7 ngày, còn tem, không dùng. Bảng quyết định.

**Hướng dẫn giải:**

- C1: Trong 7 ngày? (T/F). C2: Còn tem? (T/F). C3: Chưa sử dụng? (T/F).  
- Hành động: Cho đổi trả / Từ chối. Chỉ khi C1=T, C2=T, C3=T mới cho đổi.  
- 8 quy tắc, rút gọn theo nhóm từ chối.

---

### Bài mẫu 10

**Đề bài:** **Xét tốt nghiệp**: đủ tín chỉ; ĐTB ≥ 5.0; không nợ học phí. Bảng quyết định.

**Hướng dẫn giải:**

- C1: Đủ tín chỉ? (T/F). C2: ĐTB ≥ 5? (T/F). C3: Không nợ học phí? (T/F).  
- Hành động: Đủ điều kiện tốt nghiệp / Không đủ (ghi rõ lý do).  
- 8 quy tắc → 8 test case (hoặc rút gọn).

---

### Bài mẫu 11   
**Cấp thẻ ưu đãi siêu thị**

**Đề bài (chi tiết):**  
Siêu thị cấp thẻ ưu đãi khi: **khách mới** (chưa từng có thẻ) HOẶC **khách cũ nhưng thẻ đã hết hạn**. Nếu khách cũ và thẻ còn hạn thì **từ chối** cấp thẻ mới. Hãy dùng **bảng quyết định** thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Khách mới? (T/F) — chưa từng có thẻ.  
- C2: (Nếu khách cũ) Thẻ cũ đã hết hạn? (T/F). Với khách mới, C2 không áp dụng (ghi “−”).

**Bước 2 – Hành động / Kết quả:**  
- Cấp thẻ ưu đãi.  
- Từ chối cấp thẻ (đang có thẻ còn hạn).

**Bước 3 – Bảng quyết định (rút gọn):**

| Điều kiện / Hành động | R1 | R2 | R3 |
|------------------------|----|----|-----|
| C1: Khách mới? | T | F | F |
| C2: Thẻ cũ hết hạn? | − | T | F |
| **Cấp thẻ** | X | X | |
| **Từ chối** | | | X |

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): Khách mới → Cấp thẻ.  
- TC2 (R2): Khách cũ, thẻ hết hạn → Cấp thẻ.  
- TC3 (R3): Khách cũ, thẻ còn hạn → Từ chối.

---

### Bài mẫu 12 — Trung bình · Thực tế  
**Phê duyệt đơn vay (ngân hàng)**

**Đề bài (chi tiết):**  
Đơn vay được **duyệt** khi thỏa cả ba: **Thu nhập ≥ 10tr**, **Không nợ xấu**, **Tuổi 22–55**. Thiếu bất kỳ điều kiện nào thì **từ chối** và ghi rõ lý do (thu nhập / nợ xấu / tuổi). Hãy lập **bảng quyết định** và chuyển thành test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Thu nhập ≥ 10tr? (T/F).  
- C2: Không nợ xấu? (T/F).  
- C3: Tuổi 22–55? (T/F).

**Bước 2 – Hành động / Kết quả:**  
- Duyệt đơn.  
- Từ chối (lý do: thu nhập / nợ xấu / tuổi — ưu tiên lý do đầu tiên sai).

**Bước 3 – Bảng quyết định (8 quy tắc, ví dụ rút gọn):**

| Điều kiện / Hành động | R1 | R2 | R3 | R4 | R5…R8 |
|------------------------|----|----|-----|-----|--------|
| C1: Thu nhập ≥ 10tr? | T | F | T | T | … |
| C2: Không nợ xấu? | T | − | F | T | … |
| C3: Tuổi 22–55? | T | − | − | F | … |
| **Duyệt** | X | | | | |
| **Từ chối (thu nhập)** | | X | | | |
| **Từ chối (nợ xấu)** | | | X | | |
| **Từ chối (tuổi)** | | | | X | … |

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): Thu nhập 15tr, không nợ xấu, 30 tuổi → Duyệt.  
- TC2: Thu nhập 5tr, không nợ xấu, 30 tuổi → Từ chối (thu nhập).  
- TC3: Thu nhập 12tr, có nợ xấu, 30 tuổi → Từ chối (nợ xấu).  
- TC4: Thu nhập 12tr, không nợ xấu, 20 tuổi → Từ chối (tuổi).

---

### Bài mẫu 13 — Trung bình · Phức tạp  
**Tính phí bảo hiểm ô tô (tuổi + loại xe + khu vực)**

**Đề bài (chi tiết):**  
Phí bảo hiểm cơ sở **1.000.000**. **Tuổi tài xế < 25**: cộng 20%; **Loại xe thể thao**: cộng 15%; **Khu vực nội thành**: cộng 10%. Các mức cộng dồn. Hãy lập **bảng quyết định** cho **có/không** từng yếu tố và tính phí cuối, rồi thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Tuổi tài xế < 25? (T/F).  
- C2: Xe thể thao? (T/F).  
- C3: Khu vực nội thành? (T/F).

**Bước 2 – Hành động / Kết quả:**  
Phí = 1.000.000 × (1 + 0.2 nếu C1) × (1 + 0.15 nếu C2) × (1 + 0.1 nếu C3). Mỗi tổ hợp (C1,C2,C3) cho một mức phí.

**Bước 3 – Bảng quyết định (ví dụ 4 trong 8 quy tắc):**

| Điều kiện / Phí (VNĐ) | R1 | R2 | R3 | R4 |
|------------------------|----|----|-----|-----|
| C1: Tuổi < 25? | F | T | T | T |
| C2: Xe thể thao? | F | F | T | T |
| C3: Nội thành? | F | F | F | T |
| **Phí** | 1.000.000 | 1.200.000 | 1.380.000 | 1.518.000 |

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): 30 tuổi, xe sedan, ngoại thành → 1.000.000.  
- TC2 (R2): 22 tuổi, xe sedan, ngoại thành → 1.200.000.  
- TC3 (R4): 22 tuổi, xe thể thao, nội thành → 1.518.000.

---

### Bài mẫu 14 — Trung bình · Thực tế  
**Xuất hóa đơn VAT (có MST + đơn ≥ 200k)**

**Đề bài (chi tiết):**  
Chỉ **xuất hóa đơn VAT** khi: **Có mã số thuế** VÀ **Tổng đơn ≥ 200.000**. Thiếu một trong hai thì không xuất VAT (hoặc chỉ xuất hóa đơn thường). Hãy lập **bảng quyết định** và test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Có mã số thuế? (T/F).  
- C2: Tổng đơn ≥ 200.000? (T/F).

**Bước 2 – Hành động / Kết quả:**  
- Xuất hóa đơn VAT.  
- Không xuất VAT (hoặc xuất hóa đơn thường).

**Bước 3 – Bảng quyết định:**

| Điều kiện / Hành động | R1 | R2 | R3 | R4 |
|------------------------|----|----|-----|-----|
| C1: Có MST? | T | T | F | F |
| C2: Đơn ≥ 200k? | T | F | T | F |
| **Xuất VAT** | X | | | |
| **Không xuất VAT** | | X | X | X |

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): Có MST, đơn 250.000 → Xuất VAT.  
- TC2 (R2): Có MST, đơn 150.000 → Không VAT.  
- TC3 (R3): Không MST, đơn 250.000 → Không VAT.  
- TC4 (R4): Không MST, đơn 150.000 → Không VAT.

---

### Bài mẫu 15 — Khó · Thực tế  
**Điều kiện miễn phí ship (đơn hàng + thẻ + mã giảm giá)**

**Đề bài (chi tiết):**  
**Miễn phí ship** khi: **Đơn ≥ 500k** HOẶC **Thành viên Vàng/Kim cương** HOẶC **Có mã Freeship**. Trường hợp còn lại thu phí **30.000đ**. Hãy lập **bảng quyết định** và test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Đơn ≥ 500k? (T/F).  
- C2: Thẻ Vàng/Kim cương? (T/F).  
- C3: Có mã Freeship? (T/F).

**Bước 2 – Hành động / Kết quả:**  
- Miễn phí ship.  
- Thu phí 30.000đ. (Miễn phí khi ít nhất một trong C1, C2, C3 = T.)

**Bước 3 – Bảng quyết định (rút gọn):**

| Điều kiện / Hành động | R1 | R2 |
|------------------------|----|-----|
| C1: Đơn ≥ 500k? | F | T (hoặc C2/C3 = T) |
| C2: Thẻ Vàng/Kim cương? | F | − |
| C3: Có mã Freeship? | F | − |
| **Thu phí 30k** | X | |
| **Miễn phí ship** | | X |

*(R2 đại diện cho mọi tổ hợp có ít nhất 1 điều kiện T.)*

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): Đơn 300k, không thẻ VIP, không mã → Thu 30k.  
- TC2: Đơn 600k, không thẻ, không mã → Miễn phí.  
- TC3: Đơn 300k, thẻ Vàng, không mã → Miễn phí.  
- TC4: Đơn 300k, không thẻ, có mã Freeship → Miễn phí.

---

### Bài mẫu 16 — Khó · Phức tạp  
**Xét học bổng (không rớt môn + ĐTB + hoạt động ngoại khóa)**

**Đề bài (chi tiết):**  
Điều kiện xét học bổng: **Không có môn nào < 5**; **ĐTB ≥ 7.5**; **Có ít nhất 1 hoạt động ngoại khóa** trong học kỳ. **Thỏa cả 3** → Học bổng 100%; **đúng 2** → 50%; **1 hoặc 0** → 0%. Hãy lập **bảng quyết định** và test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Không có môn nào < 5? (T/F).  
- C2: ĐTB ≥ 7.5? (T/F).  
- C3: Có hoạt động ngoại khóa? (T/F).

**Bước 2 – Hành động / Kết quả:**  
- Học bổng 100% (3 điều kiện T).  
- Học bổng 50% (đúng 2 điều kiện T).  
- Học bổng 0% (1 hoặc 0 điều kiện T).

**Bước 3 – Bảng quyết định (theo số điều kiện T):**

| Điều kiện / Hành động | R1 | R2 | R3 |
|------------------------|----|----|-----|
| C1 / C2 / C3 (số T) | 3T | 2T | 1T hoặc 0T |
| **Học bổng 100%** | X | | |
| **Học bổng 50%** | | X | |
| **Học bổng 0%** | | | X |

**Bước 4 – Test case từ các quy tắc:**  
- TC1: Không môn < 5, ĐTB 8.0, có HĐ NK → 100%.  
- TC2: Không môn < 5, ĐTB 8.0, không HĐ NK → 50%.  
- TC3: Có môn 4, ĐTB 7.0, có HĐ NK → 0%.  
- TC4: (F,F,F) → 0%.

---

### Bài mẫu 17 — Trung bình · Thực tế  
**Cho phép vào cửa hàng (giờ mở cửa + thẻ thành viên)**

**Đề bài (chi tiết):**  
Cửa hàng mở **9h–21h**. **Trong giờ**: mọi người vào được. **Ngoài giờ**: chỉ **thẻ VIP** mới vào được (cửa phụ). Ngoài giờ và không có thẻ VIP → không vào. Hãy lập **bảng quyết định** và test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Trong giờ mở cửa (9h–21h)? (T/F).  
- C2: Có thẻ VIP? (T/F).

**Bước 2 – Hành động / Kết quả:**  
- Cho vào (cửa chính hoặc cửa phụ).  
- Từ chối vào.

**Bước 3 – Bảng quyết định:**

| Điều kiện / Hành động | R1 | R2 | R3 |
|------------------------|----|----|-----|
| C1: Trong giờ? | T | F | F |
| C2: Thẻ VIP? | − | T | F |
| **Cho vào** | X | X | |
| **Từ chối** | | | X |

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): 14h, không thẻ VIP → Vào được (trong giờ).  
- TC2 (R2): 22h, có thẻ VIP → Vào cửa phụ.  
- TC3 (R3): 22h, không thẻ VIP → Từ chối.

---

### Bài mẫu 18 — Khó · Thực tế  
**Hủy đơn đặt phòng (thời gian + đã thanh toán)**

**Đề bài (chi tiết):**  
**Trước 24h** so với check-in: hủy miễn phí, **hoàn 100%**. **24h–2h** trước check-in: **hoàn 50%**. **Sau 2h** trước check-in: **không hoàn**. **Chưa thanh toán** thì chỉ hủy đặt chỗ, không hoàn tiền. Hãy lập **bảng quyết định** (và BVA thời gian nếu cần) và test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Đã thanh toán? (T/F).  
- C2: Thời gian trước check-in? (>24h / 24h–2h / <2h) — 3 giá trị.

**Bước 2 – Hành động / Kết quả:**  
- Hoàn 100%; Hoàn 50%; Hoàn 0%; Chỉ hủy (không hoàn).

**Bước 3 – Bảng quyết định (rút gọn):**

| Điều kiện / Hành động | R1 | R2 | R3 | R4 |
|------------------------|----|----|-----|-----|
| C1: Đã thanh toán? | F | T | T | T |
| C2: Thời gian | − | >24h | 24h–2h | <2h |
| **Chỉ hủy (không hoàn)** | X | | | |
| **Hoàn 100%** | | X | | |
| **Hoàn 50%** | | | X | |
| **Hoàn 0%** | | | | X |

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): Chưa thanh toán, hủy trước 48h → Chỉ hủy, không hoàn.  
- TC2 (R2): Đã thanh toán, hủy trước 48h → Hoàn 100%.  
- TC3 (R3): Đã thanh toán, hủy trước 12h → Hoàn 50%.  
- TC4 (R4): Đã thanh toán, hủy trước 1h → Hoàn 0%.

---

### Bài mẫu 19 — Khó · Phức tạp  
**Tự động gia hạn gói (đã bật auto + đủ số dư + trước ngày hết hạn)**

**Đề bài (chi tiết):**  
Hệ thống **tự động gia hạn** gói khi thỏa cả ba: **Đã bật auto-renew** VÀ **Số dư ví ≥ giá gói** VÀ **Trong vòng 3 ngày trước ngày hết hạn**. Thiếu bất kỳ điều kiện nào thì **không gia hạn** và gửi thông báo nhắc. Hãy lập **bảng quyết định** và test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Đã bật auto-renew? (T/F).  
- C2: Số dư ví ≥ giá gói? (T/F).  
- C3: Trong 3 ngày trước hết hạn? (T/F).

**Bước 2 – Hành động / Kết quả:**  
- Gia hạn gói.  
- Không gia hạn (gửi thông báo nhắc).

**Bước 3 – Bảng quyết định (8 quy tắc, chỉ R1 thỏa cả 3):**

| Điều kiện / Hành động | R1 | R2…R8 |
|------------------------|----|--------|
| C1: Bật auto? | T | Có ít nhất 1 F |
| C2: Đủ số dư? | T | |
| C3: Trong 3 ngày? | T | |
| **Gia hạn** | X | |
| **Không gia hạn (nhắc)** | | X |

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): Bật auto, đủ số dư, còn 2 ngày → Gia hạn.  
- TC2: Tắt auto, đủ số dư, còn 2 ngày → Không gia hạn, nhắc.  
- TC3: Bật auto, thiếu số dư, còn 2 ngày → Không gia hạn, nhắc.  
- TC4: Bật auto, đủ số dư, còn 5 ngày → Không gia hạn, nhắc.

---

### Bài mẫu 20 — Khó · Thực tế  
**Ưu tiên xử lý sự cố (mức độ + khách VIP)**

**Đề bài (chi tiết):**  
**Mức độ sự cố:** Cao / Trung bình / Thấp. **Khách VIP** (đang dùng gói cao cấp) luôn được **ưu tiên cao nhất**. Không VIP thì ưu tiên theo mức độ: Cao → Cao, TB → TB, Thấp → Thấp. Kết quả: Thứ tự xử lý (Cao nhất / Cao / TB / Thấp). Hãy lập **bảng quyết định** và test case.

**Hướng dẫn giải:**

**Bước 1 – Điều kiện (đầu vào logic):**  
- C1: Khách VIP? (T/F).  
- C2: Mức độ sự cố? (Cao / TB / Thấp). Khi C1 = T, C2 có thể bỏ qua (ưu tiên cao nhất).

**Bước 2 – Hành động / Kết quả:**  
- Ưu tiên Cao nhất; Cao; TB; Thấp.

**Bước 3 – Bảng quyết định (rút gọn):**

| Điều kiện / Hành động | R1 | R2 | R3 | R4 |
|------------------------|----|----|-----|-----|
| C1: VIP? | T | F | F | F |
| C2: Mức độ | − | Cao | TB | Thấp |
| **Ưu tiên Cao nhất** | X | | | |
| **Ưu tiên Cao** | | X | | |
| **Ưu tiên TB** | | | X | |
| **Ưu tiên Thấp** | | | | X |

**Bước 4 – Test case từ các quy tắc:**  
- TC1 (R1): Khách VIP, sự cố Thấp → Ưu tiên Cao nhất.  
- TC2 (R2): Không VIP, sự cố Cao → Ưu tiên Cao.  
- TC3 (R3): Không VIP, sự cố TB → Ưu tiên TB.  
- TC4 (R4): Không VIP, sự cố Thấp → Ưu tiên Thấp.

---



## PHẦN 2: BÀI TẬP TỰ LUYỆN

### Bài 1
Chương trình nhận 3 cạnh và xác định **tam giác vuông**. Bảng quyết định + test case.

### Bài 2
**Đặt phòng khách sạn**: có phòng trống, ngày đến ≤ ngày đi, số khách ≤ sức chứa. Bảng quyết định.

### Bài 3
**Vay tiêu dùng**: 18–60 tuổi, thu nhập ≥ 5tr, không nợ xấu. Bảng quyết định + BVA (tuổi, thu nhập).

### Bài 4
**Giảm giá**: Thành viên Vàng + đơn ≥ 1tr: 10%; Thành viên Bạc + đơn ≥ 2tr: 5%; còn lại 0%. Bảng quyết định.

### Bài 5
**Cấp thẻ parking**: Nhân viên full-time HOẶC (part-time và đã làm ≥ 6 tháng). Bảng quyết định.

### Bài 6
**Xuất hóa đơn VAT**: Có mã số thuế và đơn ≥ 200k. Bảng quyết định.

### Bài 7
**Kích hoạt SIM**: CMND hợp lệ + ảnh chân dung + không nằm trong blacklist. Bảng quyết định.

### Bài 8
**Hủy vé máy bay**: Trước 24h: hoàn 90%; 24h–2h: hoàn 50%; sau 2h: không hoàn. Bảng quyết định (và BVA thời gian).

### Bài 9
**Phê duyệt đơn nghỉ**: Số ngày ≤ 3: trưởng phòng; 4–7: giám đốc; > 7: giám đốc + HR. Bảng quyết định.

### Bài 10
**Tính lương thử việc**: Có hợp đồng + đủ ngày công + không vi phạm nội quy. Bảng quyết định.

---

### Bài 11 
**Vào bãi xe**: Có thẻ tháng HOẶC mua vé ngày. Bảng quyết định.

### Bài 12 — Trung bình · Thực tế
**Chấp nhận thanh toán**: Thẻ nội địa HOẶC thẻ quốc tế; số dư đủ. Bảng quyết định (loại thẻ × đủ/không đủ).

### Bài 13 — Trung bình · Phức tạp
**Tính lương thưởng**: Đạt KPI (T/F) + Không vi phạm (T/F) + Thâm niên ≥ 2 năm (T/F). Thưởng 20% khi đủ 3; 10% khi đủ 2; 0% còn lại. Bảng quyết định.

### Bài 14 — Trung bình · Thực tế
**Giao hàng nhanh**: Đơn ≥ 500k VÀ trong bán kính 5km → giao trong 2h; ngược lại giao tiêu chuẩn. Bảng quyết định.

### Bài 15 — Khó · Thực tế
**Phê duyệt nghỉ không lương**: Số ngày ≤ 3: trưởng phòng; 4–7: giám đốc + HR; > 7: giám đốc + HR + ban lãnh đạo. Bảng quyết định (và BVA số ngày).

### Bài 16 — Khó · Phức tạp
**Áp dụng mã giảm**: Mã còn hiệu lực (T/F) + Đơn đủ điều kiện (T/F) + Chưa dùng mã này (T/F). Chỉ khi 3T mới áp dụng. Bảng quyết định.

### Bài 17 — Trung bình · Thực tế
**Đăng ký thi lái xe**: Đủ tuổi (18+) + Đủ hồ sơ + Không đang bị cấm thi. Bảng quyết định.

### Bài 18 — Khó · Thực tế
**Bảo hành sản phẩm**: Còn trong bảo hành (T/F) + Còn tem (T/F) + Lỗi thuộc bảo hành (T/F). Đủ 3 → Bảo hành; thiếu → Từ chối (ghi lý do). Bảng quyết định.

### Bài 19 — Khó · Phức tạp
**Tính phí đổi/trả vé**: Trước 7 ngày: miễn phí; 7–1 ngày: 20% giá vé; trong ngày: 50%; sau giờ khởi hành: không đổi/trả. Bảng quyết định + BVA thời gian.

### Bài 20 — Khó · Thực tế
**Cấp chứng nhận hoàn thành khóa học**: Hoàn thành ≥ 80% bài học + Điểm TB ≥ 5 + Không vi phạm (gian lận). Bảng quyết định.

---

*Hết phần Bảng quyết định.*
