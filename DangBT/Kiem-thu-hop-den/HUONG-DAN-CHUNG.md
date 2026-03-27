# Hướng dẫn chung — Cách làm chuẩn bài tập Kiểm thử hộp đen

Tài liệu này mô tả **quy trình chuẩn** và **cách làm từng dạng bài** để bạn làm bài **đúng, đủ, dễ hiểu**.

---

## 1. Phân vùng tương đương (Equivalence Partitioning)

### Mục đích
Giảm số test case bằng cách gộp các giá trị đầu vào thành **các lớp tương đương**: mọi giá trị trong cùng một lớp được xử lý giống nhau bởi hệ thống.

### Quy trình chuẩn (4 bước)

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | **Đọc kỹ đặc tả** — Xác định đầu vào (input), khoảng giá trị, ràng buộc, kiểu dữ liệu. | Gạch chân: số nguyên / thập phân, min–max, định dạng (độ dài, ký tự cho phép). |
| **2** | **Liệt kê phân vùng hợp lệ (valid)** — Mỗi khoảng/điều kiện cho kết quả khác nhau = 1 phân vùng. | Ví dụ: điểm [0,5) và [5,10] → 2 phân vùng valid. |
| **3** | **Liệt kê phân vùng không hợp lệ (invalid)** — Ngoài đặc tả: ngoài khoảng, sai kiểu, rỗng, null. | Luôn nghĩ: “Đầu vào sai có những dạng nào?” (âm, quá lớn, chữ, rỗng, …). |
| **4** | **Thiết kế test case** — Mỗi phân vùng chọn **ít nhất 1 giá trị đại diện**; ghi rõ Đầu vào và Kỳ vọng. | Valid: giá trị trong khoảng. Invalid: mỗi loại lỗi 1 test (0, âm, rỗng, sai định dạng, …). |

### Bảng phân vùng chuẩn
- Cột: **#** | **Phân vùng** (mô tả) | **Loại** (Valid/Invalid) | **Ví dụ giá trị**.
- Test case: **TC** | **Đầu vào** | **Kỳ vọng** (hợp lệ / lỗi / kết quả cụ thể).

### Lưu ý
- **Valid và invalid đều phải có** — Không chỉ test đúng đặc tả, phải test cả đầu vào sai.
- **Mỗi phân vùng ít nhất 1 test case** — Để phủ hết các lớp.

---

## 2. Phân tích giá trị biên (Boundary Value Analysis)

### Mục đích
Tập trung test **các giá trị tại biên** (min, min−1, max, max+1) vì lỗi thường xảy ra ở biên.

### Quy trình chuẩn (4 bước)

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | **Xác định biên** — Từ đặc tả, tìm min và max hợp lệ (có thể nhiều khoảng → nhiều cặp biên). | Ví dụ: 1–99 → biên 1 và 99; 0–5 kg, 5–20 kg → biên 0, 5, 20. |
| **2** | **Chọn giá trị theo BVA** — Với mỗi biên: **min−1, min, min+1** (hoặc **max−1, max, max+1**). | 2-value: min−1, min, max, max+1. 3-value: thêm giá trị trong khoảng (ví dụ trung bình). |
| **3** | **Liệt kê test case** — Mỗi giá trị = 1 test case; ghi rõ Đầu vào và Kỳ vọng (chấp nhận / từ chối). | Với khoảng [1, 99]: 0, 1, 2, 98, 99, 100 (+ có thể 50). |
| **4** | **Kết hợp EP nếu nhiều đầu vào** — Áp dụng BVA cho từng biến; có thể kết hợp bộ (min, min), (min, max), … | Tránh bỏ sót biên khi có nhiều trường (tuổi, số tiền, ngày, …). |

### Bảng test case chuẩn
- **TC** | **Giá trị đầu vào** (tại biên / cận biên) | **Kỳ vọng** (Valid / Invalid, kết quả cụ thể).

### Lưu ý
- **Biên trên và biên dưới đều cần test** — Cả min−1, min và max, max+1.
- **Nhiều khoảng → nhiều cặp biên** — Ví dụ phí ship theo kg: biên 0, 5, 20, 50.

---

## 3. Bảng quyết định (Decision Table)

### Mục đích
Thiết kế test case khi có **nhiều điều kiện** (T/F hoặc nhiều giá trị) kết hợp với nhau → mỗi **tổ hợp** (cột quy tắc) cho một **hành động/kết quả**.

### Quy trình chuẩn (5 bước)

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | **Liệt kê tất cả điều kiện (C1, C2, …)** — Mỗi điều kiện là T/F hoặc vài giá trị rời rạc. | Ví dụ: Đủ tuổi? (T/F). Có MST? (T/F). Đơn ≥ 500k? (T/F). |
| **2** | **Liệt kê hành động / kết quả** — Ứng với mỗi tổ hợp điều kiện, hệ thống làm gì? | Ví dụ: Xuất VAT / Không xuất; Duyệt / Từ chối (lý do). |
| **3** | **Lập bảng đầy đủ** — Mỗi cột = 1 quy tắc (1 tổ hợp điều kiện); điền T/F (hoặc giá trị) và hành động tương ứng. | n điều kiện T/F → tối đa 2^n cột; điền từng cột theo đặc tả. |
| **4** | **Rút gọn bảng (nếu được)** — Các cột cùng hành động, chỉ khác 1 điều kiện → gộp, điều kiện đó ghi “−”. | Giảm số test case, tránh trùng lặp. |
| **5** | **Chuyển mỗi cột (quy tắc) thành test case** — Chọn bộ giá trị cụ thể thỏa tổ hợp điều kiện; ghi Đầu vào và Kỳ vọng. | Nếu điều kiện không chỉ T/F (ví dụ 3 loại thẻ) → dùng EP/BVA để chọn giá trị đại diện. |

### Cấu trúc bảng chuẩn
- **Phần trên:** C1, C2, … (mỗi hàng 1 điều kiện; mỗi cột 1 quy tắc: T/F hoặc giá trị).
- **Phần dưới:** Hành động / Kết quả (mỗi cột 1 ô: hành động tương ứng).

### Lưu ý
- **Thứ tự điều kiện** có thể tùy chọn; **thứ tự hành động** nên theo logic nghiệp vụ.
- **Rút gọn** giúp ít test case hơn nhưng vẫn phủ đủ các tổ hợp quan trọng.

---

## 4. Chuyển đổi trạng thái (State Transition)

### Mục đích
Test hệ thống có **nhiều trạng thái** và **chuyển trạng thái** theo sự kiện (event) — đảm bảo mỗi chuyển hợp lệ và không hợp lệ đều được kiểm tra.

### Quy trình chuẩn (5 bước)

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | **Liệt kê tất cả trạng thái** — Từ đặc tả, đặt tên rõ (ví dụ: Nháp, Chờ duyệt, Đã duyệt, Đã hủy). | Dùng danh từ ngắn, nhất quán (tiếng Anh hoặc Việt). |
| **2** | **Liệt kê sự kiện** — Sự kiện nào làm đổi trạng thái? (Gửi, Duyệt, Hủy, …). | Mỗi sự kiện gắn với điều kiện (ví dụ: “Trong 15 phút”). |
| **3** | **Vẽ lược đồ trạng thái** — Mỗi cung: Trạng thái nguồn --[Sự kiện]--> Trạng thái đích. | Có thể vẽ tay hoặc dùng ký hiệu text: [A] --E1--> [B]. |
| **4** | **Lập bảng chuyển trạng thái (tùy chọn)** — Hàng = trạng thái hiện tại, cột = sự kiện, ô = trạng thái kế tiếp (hoặc “invalid”). | Giúp không bỏ sót cung. |
| **5** | **Thiết kế test case** — Mỗi **cung hợp lệ** = ít nhất 1 test case (chuỗi: trạng thái đầu → sự kiện → trạng thái cuối). Thêm test case **không hợp lệ** (sự kiện không cho phép ở trạng thái hiện tại). | TC: Điều kiện ban đầu → Thao tác (sự kiện) → Kỳ vọng (trạng thái mới / thông báo). |

### Lưu ý
- **Trạng thái đầu** (initial) và **trạng thái kết thúc** (final) nên được ghi rõ.
- Test cả **đường hợp invalid** (ví dụ: Hủy khi đã Đóng).

---

## 5. Kiểm thử dựa trên Use Case

### Mục đích
Thiết kế test case từ **luồng chính**, **luồng thay thế** và **luồng ngoại lệ** của use case — đảm bảo phủ đủ kịch bản thành công và thất bại.

### Quy trình chuẩn (4 bước)

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | **Đọc đặc tả use case** — Tách rõ: Tiền điều kiện, Luồng chính (main), Luồng thay thế (alternative), Luồng ngoại lệ (exception). | Main = “happy path”; Thay thế = nhánh khác vẫn hợp lệ; Ngoại lệ = lỗi, từ chối. |
| **2** | **Test case cho luồng chính** — Ít nhất 1 TC: thực hiện đủ các bước main, điều kiện thỏa → kết quả thành công. | Ghi rõ: Bước thực hiện, Dữ liệu đầu vào, Kỳ vọng (output, trạng thái hệ thống). |
| **3** | **Test case cho từng luồng thay thế / ngoại lệ** — Mỗi nhánh thay thế hoặc ngoại lệ = ít nhất 1 TC; tạo điều kiện để đi vào nhánh đó. | Ví dụ: Sai mật khẩu, Hết hàng, Quá hạn, Thiếu quyền. |
| **4** | **Test biên và đặc biệt (nếu cần)** — Kết hợp EP/BVA cho đầu vào trong use case (số tiền, ngày, độ dài, …). | Đảm bảo không chỉ “đúng 1 lần” mà còn biên (min, max, rỗng, sai định dạng). |

### Cấu trúc test case chuẩn
- **TC id** | **Luồng** (Main / Alt 3a / Exception 3b) | **Điều kiện / Dữ liệu** | **Thao tác** | **Kỳ vọng**.

### Lưu ý
- **Post-condition** sau mỗi luồng nên được kiểm tra (trạng thái DB, thông báo, chuyển trang).
- **Actor** và **quyền** — Test cả user không đủ quyền (nếu use case có nhắc).

---

## 6. Kiểm thử dựa trên kinh nghiệm (Đoán lỗi & Thăm dò)

### Mục đích
- **Đoán lỗi (Error guessing):** Bổ sung test case cho các tình huống **dễ sai** mà kỹ thuật chính thức (EP, BVA, DT) có thể bỏ sót.
- **Thăm dò (Exploratory):** Khám phá hệ thống theo **charter** (mục tiêu), vừa làm vừa thiết kế test, ghi lại lỗi và hành vi.

### Quy trình chuẩn — Đoán lỗi

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | **Áp dụng xong EP/BVA/DT** — Đảm bảo đã có bộ test case “chính thức” trước. | Đoán lỗi dùng để **bổ sung**, không thay thế. |
| **2** | **Liệt kê điểm dễ lỗi** — Từ kinh nghiệm: copy-paste khoảng trắng, đồng thời (2 tab), timeout, overflow, ký tự đặc biệt, SQL/XSS, session, … | Hỏi: “Dev thường sai chỗ nào? Đặc tả hay thiếu gì?” |
| **3** | **Mỗi điểm → 1 (hoặc vài) test case** — Đầu vào / Thao tác cụ thể, Kỳ vọng (xử lý đúng hoặc thông báo an toàn). | Ghi rõ: Test case bổ sung so với bộ chính thức. |

### Quy trình chuẩn — Kiểm thử thăm dò

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | **Định nghĩa charter** — Mục tiêu rõ trong 1 câu (ví dụ: “Kiểm tra bộ lọc và phân trang cùng lúc”). | Charter = phạm vi + mục tiêu (không cần test case chi tiết trước). |
| **2** | **Thực hiện trong timebox** — Vừa thao tác vừa quan sát; ghi lại lỗi, hành vi lạ, câu hỏi. | Không cần script cố định; có thể đi lệch nếu phát hiện hướng mới. |
| **3** | **Ghi chú và báo cáo** — Lỗi tìm được, bước tái hiện, gợi ý test case sau này. | Charter xong → tóm tắt: Đã làm gì, tìm gì, đề xuất test case nào. |

### Lưu ý
- **Đoán lỗi** dùng tốt nhất **sau** khi đã có test chính thức.
- **Thăm dò** phù hợp khi đặc tả thiếu, cần làm quen nhanh với hệ thống.

---

## Bảng tóm tắt: Khi nào dùng kỹ thuật nào

| Tình huống | Kỹ thuật gợi ý |
|------------|-----------------|
| Đầu vào là khoảng giá trị (số, ngày, độ dài) | EP + BVA |
| Nhiều điều kiện T/F kết hợp (quy tắc nghiệp vụ) | Bảng quyết định |
| Hệ thống có trạng thái, chuyển theo sự kiện | Chuyển đổi trạng thái |
| Có đặc tả use case (luồng chính/thay thế/ngoại lệ) | Use case testing |
| Đã test chính thức, cần bắt thêm lỗi “góc khuất” | Đoán lỗi |
| Đặc tả thiếu, cần khám phá nhanh | Kiểm thử thăm dò |

---

**Cách dùng tài liệu này:** Đọc **Quy trình chuẩn** của từng kỹ thuật trước khi làm bài; khi làm bài mẫu, đối chiếu từng bước với quy trình để nắm **cách làm chuẩn**. Sau đó áp dụng đúng 4–5 bước khi làm bài tự luyện.
