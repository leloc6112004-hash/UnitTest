# Bài tập: Tổng hợp — Kết hợp các kỹ thuật kiểm thử hộp đen

**Chương: Kiểm thử hộp đen**  
**Cấu trúc:** 2 phần — **Bài tập mẫu** (20 bài: **10 bước làm bài bắt buộc** ở đầu file + mục **0. Trình tự thực hiện** + kết quả **A–F**) và **Bài tập tự luyện** (20 bài, đề + gợi ý; vẫn phải làm đủ 10 bước khi nộp).

**Điều kiện:** Nên đã làm quen **01–06** và đọc *[HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md)*.

---

## Quy trình chuẩn — Bài tập tổng hợp

Mỗi bài là **một kịch bản nghiệp vụ**; bạn phải **chủ động gắn kỹ thuật** với từng phần đặc tả (không gộp chung một bảng cho mọi thứ).

| Thứ tự | Kỹ thuật | Việc cần nộp (tối thiểu) |
|--------|-----------|---------------------------|
| 1 | **Use case** | Tóm tắt **Main / Alternative / Exception**; ít nhất **1 TC main**, mỗi nhánh alt/exception **≥ 1 TC** (cột: Luồng \| Điều kiện \| Thao tác \| Kỳ vọng). |
| 2 | **Chuyển trạng thái** | Liệt kê **trạng thái**, **sự kiện**; vẽ hoặc mô tả **cung** hợp lệ; **≥ 1 TC invalid** (sự kiện sai trạng thái). |
| 3 | **Bảng quyết định** | Chọn **một nhóm điều kiện** rõ ràng (2–4 điều kiện); lập bảng (hoặc rút gọn); **mỗi cột quan trọng → TC**. |
| 4 | **EP** | Phân vùng **valid/invalid** cho **các ô nhập / tham số** chính; mỗi phân vùng **≥ 1 giá trị đại diện**. |
| 5 | **BVA** | Với **mỗi khoảng số hoặc độ dài** có min–max: **min−1, min, max, max+1** (và giá trị trong khoảng nếu dùng 3-value). |
| 6 | **Kinh nghiệm** | **Đoán lỗi / thăm dò:** **≥ 3** TC bổ sung (song song, timeout, ký tự đặc biệt, quyền, v.v.) — ghi rõ *vì sao* bổ sung ngoài bảng chính thức. |

**Lưu ý:** Nếu đặc tả **không có** đủ trạng thái (chỉ xử lý một phát), vẫn phải **nêu rõ** “không áp dụng state machine” hoặc mô tả **trạng thái tối thiểu** (ví dụ: Chưa gửi / Đã gửi).

### Quy trình từng bước (bắt buộc — khi làm bài và khi nộp bài thi)

**Không được chỉ liệt kê TC rời:** phải **trình bày theo thứ tự các bước dưới đây**; sau đó mới điền các bảng A–F (hoặc ghi chú “Kết quả Bước X → mục …”).

1. **Đọc và trích xuất đặc tả** — Gạch chân: actor, tiền điều kiện; mọi **đầu vào** (ô nhập, tham số); **ràng buộc** (khoảng, định dạng); **đầu ra / hành động** hệ thống; có **trạng thái** và **sự kiện** chuyển trạng thái không; có **điều kiện kết hợp** (nhiều cờ T/F) không. *Kết quả: một đoạn “Tóm tắt đặc tả đã trích” hoặc chính đề bài đã đánh dấu.*

2. **Thiết kế theo Use case (luồng)** — Tách rõ **Main**, **Alternative**, **Exception**; ghi **bước** chính (1→2→3…) và **điều kiện** vào từng nhánh. *Kết quả: bảng/khối “Tóm tắt UC” (sẽ đặt ở mục **E**).*

3. **Lập test case từ Use case** — Từ Bước 2: với **Main** ít nhất **1 TC**; mỗi **Alt/Exc** ít nhất **1 TC**; cột **Luồng | Điều kiện | Thao tác | Kỳ vọng**. *Kết quả: bảng UC-xx (mục **E**).*

4. **Mô hình hóa chuyển trạng thái** — Liệt kê **tập trạng thái**; **sự kiện**; lập **bảng chuyển** (TT hiện tại + Sự kiện → TT kế); đánh dấu **invalid**; thiết kế **≥1 TC** cho cung không hợp lệ. *Kết quả: mục **D**.*

5. **Lập bảng quyết định** — Chọn **2–4 điều kiện** (C1, C2, …); điền **đầy đủ quy tắc** (cột); **rút gọn** nếu được; **mỗi quy tắc** (hoặc nhóm tương đương) **ánh xạ ≥1 TC** `DT-xx`. *Kết quả: mục **C**.*

6. **Phân vùng tương đương (EP)** — Với **từng** đầu vào đã liệt ở Bước 1: liệt kê **phân vùng valid/invalid**; **mỗi phân vùng** chọn **≥1 giá trị đại diện**; gán mã `EP-…` nếu cần. *Kết quả: mục **A**.*

7. **Phân tích giá trị biên (BVA)** — Với **mỗi khoảng** số hoặc độ dài có **min/max**: chọn **min−1, min, max, max+1** (và điểm trong khoảng nếu dùng 3-value); ghi **kỳ vọng** từng TC `BVA-…`. *Kết quả: mục **B**.*

8. **Đối chiếu và thống nhất mã TC** — Kiểm tra: không bỏ sót phân vùng EP; không thiếu quy tắc DT; TC state bao phủ cung quan trọng; UC khớp đặc tả. Đặt tên mã **nhất quán** (`UC-`, `ST-`, `DT-`, `BVA-`, `EG-`).

9. **Bổ sung kiểm thử kinh nghiệm** — Liệt kê **≥3** tình huống **ngoài** EP/BVA/DT (đua tranh, thời gian, bảo mật, nhập liệu lạ…); mỗi cái → **1 TC** `EG-xx` có **Thao tác** và **Kỳ vọng** và **Lý do bổ sung**. *Kết quả: mục **F**.*

10. **Kiểm tra bài nộp** — Có đủ **6 kỹ thuật**; kỳ vọng **cụ thể** (không chỉ ghi “lỗi”); có **≥1 ST invalid** (nếu có state); có **≥3 EG**; (nếu yêu cầu) ma trận traceability.

---

## PHẦN 1: BÀI TẬP MẪU

**Chuẩn trình bày khi nộp bài / thi (gợi ý):**

- Đánh **mã test case** nhất quán: `UC-…` (use case), `ST-…` (chuyển trạng thái), `DT-…` (bảng quyết định), `EP-…` / `BVA-…` (theo phân vùng/biên), `EG-…` (kinh nghiệm).
- Mỗi bảng ghi rõ **điều kiện đầu vào** và **kết quả mong đợi**; tránh mô tả mơ hồ (“lỗi” → nên “hệ thống từ chối, hiển thị thông báo X, không gửi bếp”).
- Có thể kèm **ma trận traceability** (1 dòng: Mã TC ↔ Mục đặc tả / Quy tắc nghiệp vụ).

Dưới đây là **lời giải mẫu chi tiết** theo đúng cấu trúc trên.

**Ánh xạ mục trong mỗi bài mẫu:** **A** — Phân vùng tương đương (EP) · **B** — Giá trị biên (BVA) · **C** — Bảng quyết định · **D** — Chuyển trạng thái · **E** — Use case · **F** — Kinh nghiệm (đoán lỗi / thăm dò).

**Cách dùng:** Mỗi bài mẫu có mục **0. Trình tự thực hiện** — đó là **các bước làm bài** (không chỉ danh sách TC). Các mục **A–F** là **kết quả** sau khi đã đi hết các bước trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. *(Thứ tự A–E khác bảng “Quy trình chuẩn” đầu file là cố ý: trên giấy thường gom dữ liệu → quy tắc → luồng; các Bước 1–10 vẫn là chuẩn thao tác.)*

**Chuẩn cột (khớp Bước 3 và 9 ở đầu file):** **E** — `Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi`. **F** — `Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung`.

---

### Bài mẫu 1 — Mức độ: Trung bình  
**Ứng dụng đặt món (nhà hàng)**

**Đặc tả nghiệp vụ (đề bài):** Khách chọn món, nhập **số lượng** (số nguyên **1–20**/món). Tổng **số món** trong giỏ **≤ 50**. Thanh toán / xác nhận gửi bếp chỉ khi **giỏ không rỗng**. **Giảm giá:** nếu **tổng tiền ≥ 300.000đ** và có **mã VIP hợp lệ** (trùng danh sách hệ thống, không phân biệt hoa thường — *giả định bổ sung cho có thể kiểm thử*) → áp dụng **giảm 10%** trên tổng tiền; các trường hợp còn lại → **không** giảm. **Trạng thái đơn:** **Nháp** → **Đã gửi bếp** (sau sự kiện “Gửi bếp”) → **Hoàn thành**; có thể **Hủy** khi đơn đang **Nháp**; **không** hủy được khi đã **Đã gửi bếp**.

**Yêu cầu:** Thiết kế bộ kiểm thử hộp đen kết hợp **EP, BVA, bảng quyết định, chuyển trạng thái, use case, kinh nghiệm**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Ghi rõ đầu vào: SL từng món (1–20, nguyên), tổng món trong giỏ (≤50), điều kiện giỏ không rỗng khi gửi/thanh toán; điều kiện giảm giá (tổng tiền ≥300k + VIP hợp lệ); các trạng thái đơn (Nháp, Đã gửi bếp, Hoàn thành, Đã hủy) và điều kiện hủy.
2. **Use case (luồng):** Tách Main (thêm món → nhập VIP tùy chọn → gửi bếp → hoàn thành), Alt (hủy khi Nháp), Exc (SL sai, vượt 50 món, giỏ rỗng, hủy khi đã gửi bếp).
3. **TC từ UC:** Lập bảng `UC-xx` với Luồng, Điều kiện, Thao tác, Kỳ vọng → **mục E**.
4. **Chuyển trạng thái:** Liệt kê TT, sự kiện, bảng chuyển hợp lệ + cung invalid (hủy từ Đã gửi) → **`ST-xx` trong mục D**.
5. **Bảng quyết định:** C1 (≥300k), C2 (VIP hợp lệ), 4 quy tắc, ánh xạ `DT-xx` → **mục C**.
6. **EP:** Phân vùng cho SL, tổng món, VIP → **mục A**.
7. **BVA:** Biên SL [1,20], biên tổng món [1,50], biên tổng tiền 299.999 / 300.000 / 300.001 với VIP → **mục B**.
8. **Đối chiếu:** Đảm bảo mỗi PV có đại diện; quy tắc DT có TC; UC khớp state.
9. **Kinh nghiệm:** ≥3 TC `EG-xx` (tab song song, timeout, nhập lạ…) → **mục F**.
10. **Kiểm tra nộp:** Đủ 6 kỹ thuật, kỳ vọng cụ thể, có `ST-INV` và ≥3 `EG`.

#### A. Phân vùng tương đương (EP)

**A.1. Số lượng mỗi món (số nguyên)**

| Mã PV | Phân vùng | Loại | Giá trị đại diện (ví dụ) |
|-------|-----------|------|---------------------------|
| EP-SL-1 | 1 ≤ SL ≤ 20 | Valid | 1, 10, 20 |
| EP-SL-2 | SL ≤ 0 | Invalid | 0, −2 |
| EP-SL-3 | SL > 20 | Invalid | 21, 100 |
| EP-SL-4 | Không phải số nguyên | Invalid | 2.5, `"2a"` |
| EP-SL-5 | Rỗng / null | Invalid | `""`, null |

**A.2. Tổng số món trong giỏ**

| Mã PV | Phân vùng | Loại | Giá trị đại diện |
|-------|-----------|------|------------------|
| EP-TG-1 | 1 ≤ tổng món ≤ 50 | Valid | 1, 25, 50 |
| EP-TG-2 | Tổng món > 50 | Invalid | 51 |
| EP-TG-3 | Giỏ rỗng (0 món) | Invalid* | 0 món khi gửi bếp/thanh toán |

\*Theo đặc tả: không cho thanh toán/gửi khi rỗng.

**A.3. Mã VIP (theo giả định: có trong hệ thống hoặc không)**

| Mã PV | Phân vùng | Loại | Ví dụ |
|-------|-----------|------|--------|
| EP-VIP-1 | Mã tồn tại, đúng định dạng | Valid | `VIP2025` |
| EP-VIP-2 | Mã không tồn tại | Invalid | `NOPE` |
| EP-VIP-3 | Rỗng | Invalid | `""` |

#### B. Phân tích giá trị biên (BVA)

**B.1. Số lượng một món (khoảng [1, 20])**

| Mã TC | Biến | Giá trị | Kỳ vọng |
|-------|------|---------|--------|
| BVA-SL-01 | SL | 0 | Từ chối, không thêm vào giỏ |
| BVA-SL-02 | SL | 1 | Chấp nhận |
| BVA-SL-03 | SL | 2 | Chấp nhận (cận dưới +1) |
| BVA-SL-04 | SL | 19 | Chấp nhận (cận trên −1) |
| BVA-SL-05 | SL | 20 | Chấp nhận |
| BVA-SL-06 | SL | 21 | Từ chối |

**B.2. Tổng số món trong giỏ (khoảng hợp lệ [1, 50])**

| Mã TC | Giá trị | Kỳ vọng |
|-------|---------|--------|
| BVA-TG-01 | Tổng = 50, thêm 1 món hợp lệ làm vượt 50 | Từ chối thao tác thêm |
| BVA-TG-02 | Tổng = 49, thêm 1 món (SL=1) → 50 | Chấp nhận |

**B.3. Tổng tiền so với ngưỡng giảm 300.000đ (kết hợp VIP hợp lệ)**

| Mã TC | Tổng tiền | VIP hợp lệ | Kỳ vọng giảm giá |
|-------|-----------|------------|------------------|
| BVA-₫-01 | 299.999 | Có | Không giảm |
| BVA-₫-02 | 300.000 | Có | Giảm 10% |
| BVA-₫-03 | 300.001 | Có | Giảm 10% |
| BVA-₫-04 | 300.000 | Không / sai mã | Không giảm |

#### C. Bảng quyết định (áp dụng giảm giá 10%)

**Điều kiện:**  
- **C1:** Tổng tiền ≥ 300.000đ (T/F)  
- **C2:** Mã VIP hợp lệ (T/F)  

**Hành động:** **A1:** Áp dụng giảm 10% **A2:** Không giảm giá VIP

| Quy tắc | C1 | C2 | Hành động |
|---------|----|----|-----------|
| R1 | T | T | A1 |
| R2 | T | F | A2 |
| R3 | F | T | A2 |
| R4 | F | F | A2 |

**Ánh xạ test case:**

| Mã TC | Quy tắc | Dữ liệu thử (tóm tắt) |
|-------|---------|------------------------|
| DT-01 | R1 | Tổng 300.000đ + mã VIP đúng |
| DT-02 | R2 | Tổng 400.000đ + mã sai |
| DT-03 | R3 | Tổng 200.000đ + mã đúng |
| DT-04 | R4 | Tổng 100.000đ + không nhập VIP |

#### D. Chuyển trạng thái

**D.1. Tập trạng thái:** `Nháp (Draft)`, `Đã gửi bếp (Sent)`, `Hoàn thành (Done)`, `Đã hủy (Cancelled)`.

**D.2. Sự kiện:** `Gửi bếp`, `Hoàn thành đơn`, `Hủy đơn`.

**D.3. Bảng chuyển (hợp lệ / không hợp lệ)**

| Trạng thái hiện tại | Sự kiện | Trạng thái kế tiếp | Hợp lệ |
|---------------------|---------|---------------------|--------|
| Nháp | Gửi bếp | Đã gửi bếp | Có (nếu giỏ không rỗng, dữ liệu hợp lệ) |
| Nháp | Hủy đơn | Đã hủy | Có |
| Đã gửi bếp | Hoàn thành đơn | Hoàn thành | Có |
| Đã gửi bếp | Hủy đơn | — | **Không** |
| Hoàn thành | *mọi* | — | Không đổi / từ chối |
| Đã hủy | *mọi* | — | Không đổi / từ chối |

**D.4. Test case chuyển trạng thái**

| Mã TC | TT đầu | Sự kiện | Điều kiện kèm | Kỳ vọng |
|-------|--------|---------|----------------|--------|
| ST-01 | Nháp | Gửi bếp | Giỏ có món | → Đã gửi bếp |
| ST-02 | Nháp | Hủy đơn | — | → Đã hủy |
| ST-03 | Đã gửi bếp | Hoàn thành đơn | — | → Hoàn thành |
| ST-INV-01 | Đã gửi bếp | Hủy đơn | — | Không đổi TT; báo không được hủy |

#### E. Test case theo Use case

**Tóm tắt use case**

| Thành phần | Nội dung |
|------------|----------|
| **Actor** | Khách hàng |
| **Tiền điều kiện** | Ứng dụng mở, nhà hàng nhận đơn |
| **Luồng chính (Main)** | 1) Thêm món + SL hợp lệ → 2) (Tuỳ chọn) nhập VIP → 3) Gửi bếp → 4) Hoàn thành đơn |
| **Luồng thay thế (Alt)** | A1: Hủy đơn khi đang Nháp |
| **Ngoại lệ (Exc)** | E1: SL không hợp lệ; E2: Vượt 50 món; E3: Gửi bếp khi giỏ rỗng; E4: Hủy khi đã gửi bếp |

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|---------------------|------------------------|------------------|
| UC-M-01 | Main | Giỏ ≥1 món, SL ∈ [1,20], tổng món ≤ 50 | Thêm món → Gửi bếp → Hoàn thành | Đơn Hoàn thành; bếp nhận đơn |
| UC-A-01 | Alt | Đơn Nháp, có món | Hủy đơn | Trạng thái Đã hủy; không gửi bếp |
| UC-E-01 | Exc | SL = 0 | Thêm món | Từ chối; không tăng giỏ |
| UC-E-02 | Exc | Đang có 50 món, thêm món làm >50 | Thêm | Từ chối / báo vượt giới hạn |
| UC-E-03 | Exc | Giỏ rỗng | Gửi bếp | Từ chối; thông báo giỏ trống |
| UC-E-04 | Exc | Đã gửi bếp | Hủy đơn | Từ chối (khớp ST-INV-01) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Hai phiên (tab) cùng sửa giỏ | Mở 2 tab, cùng thêm món gần ngưỡng 50 món | Không âm số lượng; không vượt 50; dữ liệu nhất quán hoặc báo xung đột | EP/BVA không mô tả đua tranh |
| EG-02 | Gửi bếp khi mạng timeout | Ngắt mạng sau khi bấm Gửi bếp | Không mất đơn sai trạng thái; có thể thử lại hoặc rollback rõ ràng | Hành vi lỗi mạng |
| EG-03 | Số lượng có số 0 đứng đầu | Nhập `"02"` (nếu ô nhập chuỗi) | Parser thống nhất: 2 hoặc từ chối rõ ràng | Dễ sai khi ép kiểu |
| EG-04 | Mã VIP có khoảng trắng Unicode | Nhập `VIP2025` bọc ký tự không nhìn thấy | Trim hoặc từ chối có thông báo | Lỗi thực tế nhập liệu |

---

### Bài mẫu 2 — Mức độ: Trung bình  
**Đăng ký khóa học trực tuyến**

**Đặc tả nghiệp vụ:** Tuổi **18–65** (số nguyên). **Học phí:** **Trước deadline** và **mã ref hợp lệ** → **giảm 15%**; **chỉ đúng một** trong hai → **giảm 5%**; **không** thỏa điều kiện nào → **0%**. Trạng thái hồ sơ: **Chưa nộp** → **Chờ duyệt** (sau **Nộp**) → **Đã duyệt** / **Từ chối**. **Sửa hồ sơ** chỉ khi **Chưa nộp**.

**Yêu cầu:** Bộ kiểm thử tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Tuổi 18–65; giảm phí theo (trước deadline ∧ ref), (một trong hai), (không); trạng thái hồ sơ; chỉ sửa khi Chưa nộp.
2. **Use case:** Main (điền → nộp → duyệt); Alt (từ chối có lý do); Exc (tuổi sai, email trùng, thiếu file).
3. **TC UC** → **mục E**.
4. **State:** Chưa nộp / Chờ duyệt / Đã duyệt / Từ chối; invalid: sửa hoặc nộp lại khi Chờ duyệt → **mục D**.
5. **Bảng QĐ:** C1 deadline, C2 ref → 4 mức % → `DT-xx` → **mục C**.
6. **EP:** Tuổi, email, ref → **mục A**.
7. **BVA:** Tuổi 17,18,19,64,65,66 → **mục B**.
8. **Đối chiếu** mã TC, phủ phân vùng.
9. **EG:** deadline/múi giờ, ref dùng lặp, double-submit → **mục F**.
10. **Kiểm tra nộp** đủ 6 kỹ thuật.

#### A. Phân vùng tương đương (EP)

| Mã PV | Phân vùng (tuổi) | Loại | Ví dụ |
|-------|------------------|------|--------|
| EP-T-1 | 18 ≤ tuổi ≤ 65, nguyên | Valid | 18, 30, 65 |
| EP-T-2 | Tuổi < 18 | Invalid | 17, 0 |
| EP-T-3 | Tuổi > 65 | Invalid | 66 |
| EP-T-4 | Không phải số nguyên | Invalid | 20.5, `"ab"` |

| Mã PV | Phân vùng (email) | Loại | Ví dụ |
|-------|-------------------|------|--------|
| EP-E-1 | Đúng định dạng, chưa trùng | Valid | `a@b.com` |
| EP-E-2 | Sai định dạng | Invalid | `khongemail` |
| EP-E-3 | Trùng email đã đăng ký khóa | Invalid | email đã tồn tại |

| Mã PV | Mã ref | Loại |
|-------|--------|------|
| EP-R-1 | Hợp lệ, dùng được | Valid |
| EP-R-2 | Không tồn tại / hết hạn | Invalid |
| EP-R-3 | Để trống | Không có ref (dùng trong bảng QĐ) |

#### B. Phân tích giá trị biên (BVA) — tuổi [18, 65]

| Mã TC | Giá trị tuổi | Kỳ vọng |
|-------|--------------|--------|
| BVA-T-01 | 17 | Từ chối |
| BVA-T-02 | 18 | Chấp nhận |
| BVA-T-03 | 19 | Chấp nhận |
| BVA-T-04 | 64 | Chấp nhận |
| BVA-T-05 | 65 | Chấp nhận |
| BVA-T-06 | 66 | Từ chối |

#### C. Bảng quyết định — mức giảm học phí

**C1:** Đăng ký **trước** deadline (T/F) **C2:** **Có** mã ref **hợp lệ** (T/F)

| Quy tắc | C1 | C2 | Mức giảm |
|---------|----|----|----------|
| R1 | T | T | 15% |
| R2 | T | F | 5% |
| R3 | F | T | 5% |
| R4 | F | F | 0% |

| Mã TC | Quy tắc | Tóm tắt dữ liệu |
|-------|---------|------------------|
| DT-01 | R1 | Ngày nộp < deadline + ref đúng |
| DT-02 | R2 | Trước deadline, không ref |
| DT-03 | R3 | Sau deadline, ref đúng |
| DT-04 | R4 | Sau deadline, không ref |

#### D. Chuyển trạng thái

**Trạng thái:** Chưa nộp (Draft) · Chờ duyệt (Pending) · Đã duyệt (Approved) · Từ chối (Rejected)

| TT hiện tại | Sự kiện | TT kế | Hợp lệ |
|--------------|---------|-------|--------|
| Chưa nộp | Nộp hồ sơ | Chờ duyệt | Có (đủ điều kiện) |
| Chưa nộp | Sửa hồ sơ | Chưa nộp | Có |
| Chờ duyệt | Duyệt | Đã duyệt | Có |
| Chờ duyệt | Từ chối | Từ chối | Có |
| Chờ duyệt | Sửa hồ sơ | — | **Không** |
| Chờ duyệt | Nộp lại | — | **Không** |

| Mã TC | TT đầu | Sự kiện | Kỳ vọng |
|-------|--------|---------|--------|
| ST-01 | Chưa nộp | Nộp | → Chờ duyệt |
| ST-02 | Chờ duyệt | Duyệt | → Đã duyệt |
| ST-INV-01 | Chờ duyệt | Sửa hồ sơ | Từ chối; TT không đổi |

#### E. Test case theo Use case

| Thành phần | Nội dung |
|------------|----------|
| **Main** | Điền form hợp lệ → Nộp → Quản trị Duyệt → Đã duyệt |
| **Alt** | Từ chối kèm lý do |
| **Exc** | Tuổi sai; email trùng; thiếu file bắt buộc |

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Tuổi, email hợp lệ | Nộp → Duyệt | Đã duyệt |
| UC-A-01 | Alt | Hồ sơ Chờ duyệt | Từ chối + lý do | Từ chối; lý do lưu |
| UC-E-01 | Exc | Tuổi 17 | Nộp | Không cho nộp / báo lỗi |
| UC-E-02 | Exc | Email trùng | Nộp | Báo email đã dùng |
| UC-E-03 | Exc | Thiếu file minh chứng | Nộp | Báo thiếu hồ sơ |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Giờ server quanh deadline | So sánh mốc deadline / múi giờ | Trước/sau deadline thống nhất | Biên thời gian |
| EG-02 | Ref dùng lặp | 2 tài khoản cùng ref | Lần 2 không hưởng ref / báo lỗi | Gian lận giới thiệu |
| EG-03 | Double-click Nộp | Bấm Nộp 2 lần | Một bản ghi Chờ duyệt | Trùng submit |

---

### Bài mẫu 3 — Mức độ: Trung bình  
**Rút tiền ATM**

**Đặc tả nghiệp vụ:** Số tiền rút là **bội số 50.000đ**; **một lần** trong khoảng **50.000–5.000.000đ**; **hạn mức rút trong ngày** (tổng các lần) **≤ 15.000.000đ** (*giả định: đã trừ các lần rút trước trong ngày*). Thẻ **Hoạt động** mới giao dịch được; thẻ **Khóa** thì mọi giao dịch bị từ chối. **Trạng thái phiên:** **Chờ thẻ** → **Nhập PIN** → **Chọn giao dịch** → **Nhập số tiền** → **Phát tiền** → **Kết thúc**. **Sai PIN 3 lần** → thẻ chuyển **Khóa** / kết thúc phiên an toàn.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Bội 50k; 50k–5M/lần; hạn mức ngày 15M; thẻ Hoạt động/Khóa; phiên ATM; sai PIN 3 lần khóa thẻ.
2. **Use case:** Main rút thành công; Alt in BL; Exc sai PIN, hết tiền ATM, vượt hạn mức, không bội 50k.
3. **TC UC** → **mục E**.
4. **State:** Chuỗi bước phiên + khóa thẻ; invalid: bỏ bước → **mục D**.
5. **Bảng QĐ:** C1 thẻ, C2 số dư, C3 hạn mức, C4 số tiền hợp lệ → `DT-xx` → **mục C**.
6. **EP:** Số tiền, PIN, thẻ → **mục A**.
7. **BVA:** 49.999 / 50k / 5M / 5.000.001; hạn mức ngày → **mục B**.
8. **Đối chiếu** quy tắc ưu tiên từ chối.
9. **EG:** hai ATM, hủy giữa chừng, rút thẻ sớm → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Phân vùng (số tiền một lần) | Loại | Ví dụ |
|-------|-----------------------------|------|--------|
| EP-A-1 | 50k ≤ tiền ≤ 5M và chia hết 50k | Valid | 50.000, 1.000.000 |
| EP-A-2 | < 50.000 | Invalid | 10.000 |
| EP-A-3 | > 5.000.000 | Invalid | 5.050.000 |
| EP-A-4 | Không chia hết 50.000 | Invalid | 100.001 |
| EP-A-5 | Ký tự / rỗng | Invalid | `"abc"`, `""` |

| Mã PV | Hạn mức ngày (tổng đã rút + lần này) | Loại |
|-------|--------------------------------------|------|
| EP-H-1 | Tổng sau giao dịch ≤ 15.000.000 | Valid |
| EP-H-2 | Tổng sau giao dịch > 15.000.000 | Invalid |

| Mã PV | Thẻ | Loại |
|-------|-----|------|
| EP-C-1 | Hoạt động | Valid |
| EP-C-2 | Khóa | Invalid |

| Mã PV | PIN | Loại |
|-------|-----|------|
| EP-P-1 | Đúng | Valid |
| EP-P-2 | Sai (lần 1–2) | Invalid nhưng còn thử |
| EP-P-3 | Sai lần 3 | Khóa thẻ |

#### B. Phân tích giá trị biên (BVA)

**B.1. Một lần rút [50.000 ; 5.000.000] (bội 50k)**

| Mã TC | Số tiền (đ) | Kỳ vọng |
|-------|-------------|--------|
| BVA-A-01 | 49.999 | Từ chối (dưới min / không bội) |
| BVA-A-02 | 50.000 | Chấp nhận (nếu đủ điều kiện khác) |
| BVA-A-03 | 100.000 | Chấp nhận (trong khoảng) |
| BVA-A-04 | 5.000.000 | Chấp nhận |
| BVA-A-05 | 5.000.001 | Từ chối |

**B.2. Hạn mức ngày (ví dụ đã rút 10.000.000đ trong ngày; mỗi lần rút phải là bội 50.000đ)**

| Mã TC | Lần này (bội 50k) | Tổng sau | Kỳ vọng |
|-------|-------------------|----------|--------|
| BVA-H-01 | 4.950.000 | 14.950.000 | Chấp nhận (dưới 15M) |
| BVA-H-02 | 5.000.000 | 15.000.000 | Chấp nhận (đúng hạn mức) |
| BVA-H-03 | 5.050.000 | 15.050.000 | Từ chối (vượt 15M/ngày) |

*(Không dùng 4.999.999đ cho lần rút vì **không** là bội 50.000đ — sẽ bị từ chối theo quy tắc số tiền một lần, không phản ánh đúng biên **hạn mức ngày**.)*

#### C. Bảng quyết định — có phát tiền hay không (một lần rút)

**C1:** Thẻ **Hoạt động** (T/F) **C2:** **Đủ số dư** tài khoản (T/F) **C3:** **Trong hạn mức ngày** (T/F) **C4:** Số tiền **hợp lệ** (bội 50k, trong [50k,5M]) (T/F)

| Quy tắc | C1 | C2 | C3 | C4 | Phát tiền |
|---------|----|----|----|----|-----------|
| R1 | T | T | T | T | Có |
| R2 | F | * | * | * | Không |
| R3 | T | F | * | * | Không |
| R4 | T | T | F | * | Không |
| R5 | T | T | T | F | Không |

| Mã TC | Quy tắc | Ghi chú dữ liệu |
|-------|---------|-----------------|
| DT-01 | R1 | Happy path |
| DT-02 | R2 | Thẻ khóa |
| DT-03 | R3 | Số dư < số yêu cầu |
| DT-04 | R4 | Vượt 15M/ngày |
| DT-05 | R5 | 49.999đ hoặc không bội 50k |

*(Có thể rút gọn các cột trùng kết quả bằng ký hiệu “−” trong bài thi nếu giảng viên cho phép.)*

#### D. Chuyển trạng thái (phiên ATM)

**Trạng thái:** Chờ thẻ · Nhập PIN · Chọn GD · Nhập số tiền · Phát tiền · Kết thúc · (Thẻ khóa sau 3 PIN sai)

| TT hiện tại | Sự kiện | TT kế | Điều kiện |
|-------------|---------|-------|-----------|
| Chờ thẻ | Quẹt thẻ hợp lệ | Nhập PIN | Thẻ hoạt động |
| Nhập PIN | PIN đúng | Chọn GD | — |
| Nhập PIN | PIN sai (lần <3) | Nhập PIN | — |
| Nhập PIN | PIN sai lần 3 | Thẻ khóa / Kết thúc | — |
| Chọn GD | Chọn Rút tiền | Nhập số tiền | — |
| Nhập số tiền | Xác nhận hợp lệ | Phát tiền | Đủ điều kiện |
| Phát tiền | Hoàn tất | Kết thúc | — |

| Mã TC | TT đầu | Sự kiện | Kỳ vọng |
|-------|--------|---------|--------|
| ST-01 | Chờ thẻ | Quẹt thẻ | → Nhập PIN |
| ST-02 | Nhập PIN | PIN đúng | → Chọn GD |
| ST-03 | Chọn GD | Chọn Rút | → Nhập số tiền |
| ST-INV-01 | Chờ thẻ | Nhập số tiền (bỏ qua bước) | Không cho / không có màn nhập |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Thẻ OK, đủ tiền, trong hạn | Rút 1.000.000đ | Phát đủ tiền, biên lai (nếu có) |
| UC-A-01 | Alt | Sau khi rút thành công | Chọn In / Không in BL | Đúng lựa chọn |
| UC-E-01 | Exc | PIN sai | Nhập sai 1–2 lần | Thông báo, cho thử lại |
| UC-E-02 | Exc | PIN sai 3 lần | — | Khóa thẻ / kết thúc |
| UC-E-03 | Exc | ATM hết tiền | Rút hợp lệ | Từ chối, không trừ tài khoản (theo policy) |
| UC-E-04 | Exc | Số tiền không bội 50k | Xác nhận | Từ chối |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Hai ATM cùng lúc | Rút gần hết số dư đồng thời | Không âm số dư; một giao dịch fail rõ ràng | Đua tranh |
| EG-02 | Hủy khi đang Phát tiền | Bấm Hủy / rút thẻ | Không mất tiền / rollback an toàn | Gián đoạn vật lý |
| EG-03 | Rút thẻ trước khi phát xong | Rút thẻ giữa chừng | Không đếm tiền sai; log lỗi | Lỗi thao tác user |

---

### Bài mẫu 4 — Mức độ: Trung bình · Thực tế  
**Đặt lịch khám bệnh**

**Đặc tả nghiệp vụ:** Chỉ cho đặt lịch trong **30 ngày kể từ hôm nay** (ngày 0 = hôm nay, ngày 30 = mốc cuối — *làm rõ theo quy ước hệ thống*). Mỗi **ca** tối đa **10 bệnh nhân**. **Mức ưu tiên xếp hàng:** có **BHYT** và **lần đầu** tại phòng khám → **Cao**; chỉ **BHYT** → **Trung bình**; còn lại → **Thường**. **Trạng thái lịch:** **Đặt** → **Đã xác nhận** (đã gửi SMS) → **Đã khám** / **Vắng** / **Hủy**; **hủy trước 24h** so với giờ khám → được **hoàn** (theo policy).

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Ngày khám trong 30 ngày; tối đa 10 BN/ca; ưu tiên theo BHYT & lần đầu; TT lịch; hủy/hoàn theo 24h.
2. **Use case:** Main đặt + xác nhận; Alt đổi lịch; Exc quá khứ, ca đầy, hủy muộn.
3. **TC UC** → **mục E**.
4. **State:** Đặt → Đã xác nhận → Đã khám/Vắng/Hủy; invalid hủy sau đã khám → **mục D**.
5. **Bảng QĐ:** BHYT × lần đầu → mức ưu tiên → `DT-xx` → **mục C**.
6. **EP:** Ngày, ca, slot → **mục A**.
7. **BVA:** Ngày 0/30/31; 9/10/11 BN trong ca → **mục B**.
8. **Đối chiếu.**
9. **EG:** múi giờ, double booking → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Ngày khám (so với hôm nay) | Loại | Ví dụ |
|-------|----------------------------|------|--------|
| EP-D-1 | 0–30 ngày (*theo quy ước đề*) | Valid | Hôm nay, +15, +30 |
| EP-D-2 | < 0 (quá khứ) | Invalid | Hôm qua |
| EP-D-3 | > 30 | Invalid | +31 |

\*Nếu đặc tả gốc là **“30 ngày tới”** không tính hôm nay, cần **đổi** phân vùng (ví dụ chỉ +1…+30) và **BVA** tương ứng — bảng trên bám theo cách đọc **“từ hôm nay đến +30 ngày”** đã ghi trong đề bài.

| Mã PV | Ca / slot | Loại |
|-------|-----------|------|
| EP-S-1 | Ca tồn tại, còn chỗ | Valid |
| EP-S-2 | Ca không tồn tại | Invalid |
| EP-S-3 | Ca đủ 10 BN | Invalid (đặt thêm) |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Mô tả | Kỳ vọng |
|-------|-------|--------|
| BVA-D-01 | Ngày = hôm nay − 1 | Từ chối |
| BVA-D-02 | Ngày = hôm nay | Chấp nhận (nếu còn chỗ) |
| BVA-D-03 | Ngày = hôm nay + 30 | Chấp nhận |
| BVA-D-04 | Ngày = hôm nay + 31 | Từ chối |
| BVA-C-01 | Đang có 9 BN trong ca, thêm 1 | Chấp nhận → 10 |
| BVA-C-02 | Đang 10 BN, thêm 1 | Từ chối |

#### C. Bảng quyết định — mức ưu tiên

**C1:** Có **BHYT** (T/F) **C2:** **Lần đầu** khám tại PK (T/F)

| Quy tắc | C1 | C2 | Ưu tiên |
|---------|----|----|---------|
| R1 | T | T | Cao |
| R2 | T | F | Trung bình |
| R3 | F | T | Thường |
| R4 | F | F | Thường |

| Mã TC | Quy tắc | Kiểm tra |
|-------|---------|-----------|
| DT-01 | R1 | BHYT + lần đầu |
| DT-02 | R2 | BHYT, không lần đầu |
| DT-03 | R3 | Không BHYT, lần đầu |
| DT-04 | R4 | Không BHYT, không lần đầu |

#### D. Chuyển trạng thái

| TT hiện tại | Sự kiện | TT kế | Hợp lệ |
|-------------|---------|-------|--------|
| Đặt | Gửi xác nhận (SMS OK) | Đã xác nhận | Có |
| Đã xác nhận | Đến khám | Đã khám | Có |
| Đã xác nhận | Không đến (no-show) | Vắng | Có |
| Đã xác nhận | Hủy (≥24h trước giờ khám) | Hủy | Có + hoàn |
| Đã khám | Hủy | — | **Không** |

| Mã TC | TT đầu | Sự kiện | Kỳ vọng |
|-------|--------|---------|--------|
| ST-01 | Đặt | Xác nhận | Đã xác nhận |
| ST-02 | Đã xác nhận | Hủy đúng hạn | Hủy + hoàn |
| ST-INV-01 | Đã khám | Hủy lịch | Từ chối |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Ngày hợp lệ, còn chỗ | Đặt → Nhận SMS | Đã xác nhận |
| UC-A-01 | Alt | Đã xác nhận | Đổi sang ca khác còn chỗ | Cập nhật lịch mới |
| UC-E-01 | Exc | Ca đầy | Đặt | Từ chối |
| UC-E-02 | Exc | Hủy <24h trước giờ khám | Hủy | Không hoàn / phí (theo policy) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Đổi múi giờ / DST | Đặt lịch ngày +30 khi server đổi TZ | Ngày “+30” không lệch 1 ngày so với quy ước | Biên lịch |
| EG-02 | Hai thiết bị đặt cùng slot cuối | Hai phiên cùng bấm Đặt khi ca còn 1 chỗ | Một người thành công, một báo hết chỗ | Race |
| EG-03 | SMS trễ / không đến | Mở tra cứu / Yêu cầu gửi lại SMS | Có cơ chế tra cứu hoặc gửi lại; trạng thái lịch nhất quán | Tin cậy xác nhận |

---

### Bài mẫu 5 — Mức độ: Khó  
**Duyệt đơn xin nghỉ phép (nội bộ)**

**Đặc tả nghiệp vụ:** Tổng phép (tính theo **ngày**, cho phép **0.5**) nằm trong **\[1, 15\]**. Nếu **> 5 ngày** (theo tổng) → cần **Trưởng phòng (TP) duyệt trước**, sau đó **Giám đốc (GD)** duyệt; nếu **≤ 5** → chỉ **TP**. Nếu **cùng ngày nghỉ**, tỷ lệ nhân sự phòng đã có phép **≥ 30%** → **từ chối tự động** (không vào vòng duyệt). **Trạng thái đơn:** **Nháp** → **Chờ TP** → **Chờ GD** (nếu >5 ngày và TP đã duyệt) → **Đã duyệt** / **Từ chối**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật** (EP/BVA có **0.5**).


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Tổng ngày nghỉ [1,15] bước 0.5; duyệt TP vs TP+GD khi >5; auto reject ≥30% trùng lịch; TT đơn.
2. **Use case:** Nộp đơn, duyệt cấp, từ chối, auto reject.
3. **TC UC** → **mục E**.
4. **State:** Nháp → Chờ TP → Chờ GD → Đã duyệt/Từ chối; invalid GD trước TP → **mục D**.
5. **Bảng QĐ:** trùng 30%, >5 ngày, đủ chữ ký → **mục C**.
6. **EP:** Tổng ngày, trùng lịch → **mục A**.
7. **BVA:** 5, 5.5, 6, 15, 16… → **mục B**.
8. **Đối chiếu** thứ tự ưu tiên nghiệp vụ.
9. **EG:** nghỉ qua năm, % nhân sự đổi → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Tổng ngày nghỉ | Loại | Ví dụ |
|-------|----------------|------|--------|
| EP-N-1 | 1 ≤ N ≤ 15, bước 0.5 | Valid | 1, 2.5, 15 |
| EP-N-2 | N < 1 | Invalid | 0 |
| EP-N-3 | N > 15 | Invalid | 15.5, 16 |
| EP-N-4 | Sai bước (không phải bội 0.5) | Invalid | 2.3 (*nếu đặc tả chỉ 0.5*) |

| Mã PV | Trùng lịch 30% | Loại |
|-------|----------------|------|
| EP-L-1 | < 30% nhân sự nghỉ cùng ngày | Cho phép xét duyệt |
| EP-L-2 | ≥ 30% | Từ chối tự động |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Tổng ngày | Kỳ vọng |
|-------|-----------|--------|
| BVA-N-01 | 0.5 | Từ chối (<1) hoặc theo đặc tả tối thiểu |
| BVA-N-02 | 1 | Chấp nhận; chỉ TP |
| BVA-N-03 | 4.5 | Chấp nhận; chỉ TP |
| BVA-N-04 | 5 | Chấp nhận; chỉ TP |
| BVA-N-05 | 5.5 | Chấp nhận; cần TP+GD |
| BVA-N-06 | 15 | Chấp nhận |
| BVA-N-07 | 15.5 / 16 | Từ chối |

#### C. Bảng quyết định — kết quả xử lý đơn

**C1:** Trùng lịch **≥30%** (T/F) **C2:** **>5** ngày (T/F) **C3:** **TP duyệt** (T/F) **C4:** **GD duyệt** (T/F) — chỉ áp dụng khi C2=T

| R | C1 | C2 | C3 | C4 | Kết quả |
|---|----|----|----|----|---------|
| R1 | T | * | * | * | Từ chối tự động |
| R2 | F | F | T | — | Đã duyệt (chỉ TP) |
| R3 | F | T | T | T | Đã duyệt (TP+GD) |
| R4 | F | T | T | F | Chờ GD |
| R5 | F | T | F | * | Chờ TP / Từ chối |

| Mã TC | Quy tắc | Ý nghĩa kiểm thử |
|-------|---------|------------------|
| DT-01 | R1 | Auto reject |
| DT-02 | R2 | ≤5 ngày, TP đồng ý |
| DT-03 | R4 | >5, TP xong, chờ GD |
| DT-04 | R3 | >5, cả hai duyệt |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế | Ghi chú |
|----|---------|-------|---------|
| Nháp | Gửi đơn | Chờ TP | Nếu không auto reject |
| Chờ TP | TP duyệt, ≤5 ngày | Đã duyệt | — |
| Chờ TP | TP duyệt, >5 ngày | Chờ GD | — |
| Chờ TP | TP từ chối | Từ chối | Không sang GD |
| Chờ GD | GD duyệt | Đã duyệt | — |
| Chờ GD | GD từ chối | Từ chối | — |

| Mã TC | Kỳ vọng invalid |
|-------|-----------------|
| ST-INV-01 | GD duyệt khi chưa qua TP → từ chối |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Tổng 3 ngày, trùng lịch dưới 30% | Nộp đơn → TP duyệt | Đã duyệt (chỉ TP) |
| UC-A-01 | Alt | Tổng trên 5 ngày, TP đã duyệt | GD duyệt | Đã duyệt (TP+GD) |
| UC-E-01 | Exc | Cùng ngày nghỉ, ≥30% nhân sự phòng đã có phép | Nộp đơn | Từ chối tự động, không vào vòng duyệt |
| UC-E-02 | Exc | TP từ chối khi Chờ TP | TP từ chối | Từ chối; không chuyển Chờ GD |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Nghỉ qua năm | Nộp đơn có khoảng nghỉ cắt qua 31/12 | Đếm ngày nghỉ thống nhất (lịch vs ngày làm việc) theo đặc tả | Biên lịch |
| EG-02 | % nhân sự thay đổi sau khi mở đơn | Mở đơn Nháp, chờ rồi nộp khi % đã đổi | Quy tắc 30% áp dụng theo mốc thời điểm đúng (theo đề) | Đồng bộ quy tắc 30% |
| EG-03 | Nộp cuối giờ thứ 6 | Nộp sát 17:59 / đầu thứ 7 | SLA duyệt / cutoff rõ ràng | Biên thời gian nộp |

---

### Bài mẫu 6 — Mức độ: Dễ · Thực tế  
**Mượn sách thư viện (mở rộng)**

**Đặc tả nghiệp vụ:** Mỗi độc giả **tối đa 5** quyển **đang mượn**. Mỗi **lần** mượn thêm **1–3** quyển. Nếu có **bất kỳ** quyển **quá hạn** → **không** cho mượn thêm. **Phiên:** **Đăng nhập** → **Tìm kiếm** → **Xác nhận mượn** → **Thành công**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Đang mượn ≤5; mỗi lần 1–3 quyển; quá hạn cấm mượn; phiên ĐN → Tìm → Xác nhận → Thành công.
2. **Use case:** Mượn thành công; từ chối quá hạn/vượt số/sách hết.
3. **TC UC** → **mục E**.
4. **State:** Chuỗi phiên; invalid xác nhận khi chưa ĐN → **mục D**.
5. **Bảng QĐ:** quá hạn × tổng sau mượn × SL lần mượn → **mục C**.
6. **EP:** Số đang mượn, SL lần này → **mục A**.
7. **BVA:** 4+1=5 OK, 4+2>5, SL 0/1/3/4 → **mục B**.
8. **Đối chiếu.**
9. **EG:** hai thiết bị, sách vừa hết → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Đang mượn (quyển) | Lần mượn thêm | Quá hạn | Kết luận |
|-------|-------------------|---------------|---------|----------|
| EP-1 | 0–4 | 1–3 | Không | Có thể cho mượn (nếu sách còn) |
| EP-2 | 5 | * | Không | Không cho mượn thêm |
| EP-3 | * | * | Có | Không cho mượn |
| EP-4 | 3 | 3 (tổng 6) | Không | Vượt max 5 → không cho |
| EP-5 | * | 0 hoặc >3 | Không | SL lần mượn không hợp lệ |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Đang mượn | Mượn thêm | Tổng | Kỳ vọng |
|-------|-----------|-----------|------|--------|
| BVA-01 | 4 | 1 | 5 | Chấp nhận |
| BVA-02 | 4 | 2 | 6 | Từ chối |
| BVA-03 | 0 | 1 | 1 | Chấp nhận |
| BVA-04 | 0 | 0 | 0 | Từ chối (ngoài 1–3) |
| BVA-05 | 0 | 4 | — | Từ chối |

#### C. Bảng quyết định — cho mượn thêm

**C1:** Quá hạn (T/F) **C2:** **Tổng sách sau khi mượn** = đang mượn + SL lần này **≤ 5** (T/F) **C3:** SL lần mượn ∈ \[1,3\] (T/F)

| C1 | C2 | C3 | Cho mượn |
|----|----|----|----------|
| T | * | * | Không |
| F | T | T | Có |
| F | F | * | Không |
| F | * | F | Không |

| Mã TC | Tổ hợp | Kiểm tra |
|-------|--------|-----------|
| DT-01 | F,T,T | Happy path |
| DT-02 | T,* ,* | Có quá hạn |
| DT-03 | F,F,* | Đã 5 quyển, mượn thêm 1 |

#### D. Chuyển trạng thái (phiên mượn)

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Đăng nhập | Vào tìm kiếm | Tìm kiếm |
| Tìm kiếm | Chọn sách + Xác nhận | Xác nhận mượn |
| Xác nhận mượn | Hệ thống OK | Thành công |

| Mã TC | Invalid |
|-------|---------|
| ST-INV-01 | Xác nhận mượn khi chưa đăng nhập → từ chối |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Đang mượn + SL lần này ≤ 5, không quá hạn, sách còn | Đăng nhập → Tìm → Xác nhận mượn 2 quyển | Thành công; cập nhật số đang mượn |
| UC-E-01 | Exc | Có sách quá hạn | Xác nhận mượn thêm | Từ chối; thông báo quá hạn |
| UC-E-02 | Exc | Sách hết bản | Chọn sách + Xác nhận | Không mượn được; thông báo hết |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Hai người mượn cùng quyển cuối | Hai phiên cùng Xác nhận | Một thành công, một báo hết / khóa tồn kho | Race |
| EG-02 | Refresh sau mượn | F5 sau Thành công, bấm Gửi lại | Không tạo bản ghi mượn trùng | Trùng giao dịch |
| EG-03 | Phiên timeout | Chờ quá hạn phiên rồi Xác nhận | Yêu cầu đăng nhập lại / từ chối | Bảo mật / trạng thái |

---

### Bài mẫu 7 — Mức độ: Trung bình  
**Vé xem phim online**

**Đặc tả nghiệp vụ:** Suất chiếu **tối đa 200 ghế**. Mỗi giao dịch mua **1–8 vé**. **Giá vé:** **Cuối tuần** **hoặc** **3D** → **+15%** giá gốc; **cả hai** → **+30%** (cộng dồn). **Trạng thái chỗ:** **Chưa thanh toán** (chọn ghế) → **Đã giữ chỗ** (15 phút) → **Đã thanh toán** hoặc **Hết hạn giữ chỗ** (giải phóng ghế).

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** ≤200 ghế; 1–8 vé; giá +15% cuối tuần hoặc 3D, +30% cả hai; giữ chỗ 15 phút.
2. **Use case:** Mua vé; hết hạn giữ chỗ; không đủ ghế.
3. **TC UC** → **mục E**.
4. **State:** Chưa TT → Giữ chỗ → Đã TT / Hết hạn → **mục D**.
5. **Bảng QĐ:** cuối tuần × 3D → hệ số giá → **mục C**.
6. **EP:** Số vé, ghế trống → **mục A**.
7. **BVA:** 0,1,8,9 vé; ghế còn 1 mà đặt 2 → **mục B**.
8. **Đối chiếu.**
9. **EG:** lùi giờ, countdown, hai tab → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Số vé / giao dịch | Loại |
|-------|-------------------|------|
| EP-V-1 | 1–8 | Valid |
| EP-V-2 | 0 hoặc >8 | Invalid |
| EP-G-1 | Số vé ≤ ghế trống | Valid |
| EP-G-2 | Số vé > ghế trống | Invalid |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Số vé | Kỳ vọng |
|-------|-------|--------|
| BVA-01 | 0 | Từ chối |
| BVA-02 | 1 | Chấp nhận |
| BVA-03 | 8 | Chấp nhận |
| BVA-04 | 9 | Từ chối |
| BVA-05 | Ghế trống 1, đặt 2 | Từ chối |

#### C. Bảng quyết định — hệ số giá

**C1:** Cuối tuần (T/F) **C2:** Suất 3D (T/F)

| C1 | C2 | Hệ số |
|----|----|-------|
| F | F | 0% |
| T | F | +15% |
| F | T | +15% |
| T | T | +30% |

| Mã TC | Quy tắc | Kiểm tra giá |
|-------|---------|--------------|
| DT-01–04 | 4 dòng trên | So sánh với giá gốc |

#### D. Chuyển trạng thái (giữ chỗ)

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Chưa TT | Giữ chỗ thành công | Đã giữ chỗ (timer 15’) |
| Đã giữ chỗ | Thanh toán OK | Đã thanh toán |
| Đã giữ chỗ | Hết 15’ | Hết hạn → ghế mở lại |

| Mã TC | Invalid |
|-------|---------|
| ST-INV-01 | Thanh toán khi đã Hết hạn giữ chỗ |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Suất còn ghế, 1–8 vé, trong hạn giữ chỗ | Chọn ghế → Giữ chỗ → Thanh toán | Đã thanh toán; vé hợp lệ; giá đúng bảng QĐ |
| UC-A-01 | Alt | Đang giữ chỗ, còn thời gian | Hủy giữ chỗ | Ghế được giải phóng; quay Chưa thanh toán |
| UC-E-01 | Exc | Đã hết 15’ giữ chỗ | Bấm Thanh toán | Từ chối; yêu cầu chọn ghế lại (khớp ST-INV-01) |
| UC-E-02 | Exc | Số vé lớn hơn ghế trống | Giữ chỗ | Từ chối / báo không đủ ghế |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Lùi đồng hồ client | Chỉnh giờ máy, chờ hết timer | Server từ chối thanh toán khi đã hết hạn thật | Timer gian lận |
| EG-02 | Countdown = 0 vẫn Pay | Bấm Pay tại T+0 | Từ chối hoặc theo quy ước đóng biên | Biên thời gian |
| EG-03 | Hai tab cùng ghế | Hai tab cùng giữ chỗ một ghế | Một phiên giữ được, một thất bại | Trùng ghế |

---

### Bài mẫu 8 — Mức độ: Trung bình · Thực tế  
**Gửi bưu kiện**

**Đặc tả nghiệp vụ:** Khối lượng **0,1–30 kg**, **một chữ số thập phân**. **Cước:** **< 2 kg** → **cấp 1**; **2–10 kg** → **cấp 2**; **>10–30 kg** → **cấp 3**. **COD > 5.000.000đ** → **bắt buộc** xác minh **CMND**. **Trạng thái vận đơn:** **Tiếp nhận** → **Đang vận chuyển** → **Phát thành công** / **Hoàn trả**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** kg 0.1–30 một thập phân; bậc cước; COD>5M bắt buộc CMND; TT vận đơn.
2. **Use case:** Tạo đơn hợp lệ; từ chối kg/COD.
3. **TC UC** → **mục E**.
4. **State:** Tiếp nhận → Đang VC → Phát/Hoàn → **mục D**.
5. **Bảng QĐ:** COD>5M × đã CMND → **mục C**.
6. **EP:** kg, định dạng → **mục A**.
7. **BVA:** 0.09,0.1,2,10,30,30.1 → **mục B**.
8. **Đối chiếu.**
9. **EG:** locale dấu thập phân, đơn vị → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Khối lượng | Loại |
|-------|------------|------|
| EP-K-1 | 0,1–30, đúng 1 thập phân | Valid |
| EP-K-2 | < 0,1 hoặc > 30 | Invalid |
| EP-K-3 | Hai chữ số thập phân | Invalid |
| EP-K-4 | Không phải số | Invalid |

| Mã PV | COD | Xác minh CMND |
|-------|-----|----------------|
| EP-C-1 | ≤ 5.000.000 | Không bắt buộc |
| EP-C-2 | > 5.000.000 | Bắt buộc |

#### B. Phân tích giá trị biên (BVA) — kg

| Mã TC | kg | Mức cước / Kỳ vọng |
|-------|-----|---------------------|
| BVA-01 | 0,09 | Dưới min → từ chối |
| BVA-02 | 0,1 | Cấp 1 |
| BVA-03 | 1,9 | Cấp 1 |
| BVA-04 | 2,0 | Cấp 2 (biên dưới) |
| BVA-05 | 10,0 | Cấp 2 (biên trên) |
| BVA-06 | 10,1 | Cấp 3 |
| BVA-07 | 30,0 | Cấp 3 |
| BVA-08 | 30,1 | Từ chối |

#### C. Bảng quyết định — xác minh CMND

**C1:** COD **>** 5.000.000đ (T/F) **C2:** Đã có **CMND hợp lệ** (T/F)

| C1 | C2 | Gửi hàng / Tiếp nhận |
|----|----|----------------------|
| T | T | Tiếp nhận bình thường |
| T | F | Yêu cầu xác minh / từ chối |
| F | * | Không bắt buộc CMND |

| Mã TC | Mô tả |
|-------|--------|
| DT-01 | COD 5.000.001, chưa CMND → chặn |
| DT-02 | COD 4.999.999 → không bắt buộc |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Tiếp nhận | Bàn giao điểm trung chuyển | Đang VC |
| Đang VC | Phát cho người nhận | Phát thành công |
| Đang VC | Không phát được | Hoàn trả |

| ST-INV-01 | Ghi **Phát thành công** khi vận đơn chưa ở trạng thái **Đang vận chuyển** → từ chối / không đổi TT |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | kg hợp lệ, COD/CMND thỏa bảng QĐ | Tạo đơn → Tiếp nhận | Có mã vận đơn; TT Tiếp nhận |
| UC-E-01 | Exc | COD trên 5.000.000đ, chưa xác minh CMND | Nộp đơn | Không tiếp nhận / yêu cầu CMND (khớp DT) |
| UC-E-02 | Exc | kg = 30,1 (vượt max) | Nhập khối lượng | Từ chối (ngoài khoảng 0,1–30 kg) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Làm tròn khối lượng | Nhập 0,05 kg | Hệ thống từ chối hoặc làm tròn thống nhất 0,1 theo policy | Làm tròn nghiệp vụ |
| EG-02 | Locale dấu thập phân | Nhập `1.5` vs `1,5` | Parse thống nhất một chuẩn | Nhập liệu |
| EG-03 | Sai đơn vị | Nhập `10 lb` thay vì kg | Từ chối hoặc đổi đơn vị có cảnh báo | Sai đơn vị |

---

### Bài mẫu 9 — Mức độ: Khó  
**Đăng ký tài khoản + xác minh email**

**Đặc tả nghiệp vụ:** Mật khẩu **8–32 ký tự**, có **≥1 chữ hoa, ≥1 chữ số, ≥1 ký tự đặc biệt**. Email **đơn giản hợp lệ** (có `@` và domain). **Trạng thái:** **Chưa kích hoạt** → **Đang chờ OTP** → **Hoạt động**; **sai OTP 5 lần** → **Khóa**. Link/OTP **hết hạn sau 24h**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** MK 8–32 + charset; email; OTP; 5 lần sai khóa; hạn 24h; TT tài khoản.
2. **Use case:** Đăng ký → OTP → kích hoạt; hết hạn; khóa.
3. **TC UC** → **mục E**.
4. **State:** Chưa KH → Chờ OTP → Hoạt động/Khóa → **mục D**.
5. **Bảng QĐ:** OTP đúng × trong 24h × số lần sai → **mục C**.
6. **EP:** MK, email → **mục A**.
7. **BVA:** độ dài 7,8,32,33 → **mục B**.
8. **Đối chiếu.**
9. **EG:** replay OTP, paste space → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Mật khẩu | Loại |
|-------|----------|------|
| EP-P-1 | Độ dài 8–32 + đủ 3 loại ký tự | Valid |
| EP-P-2 | Thiếu chữ hoa / số / đặc biệt | Invalid |
| EP-P-3 | Độ dài sai | Invalid |

| Mã PV | Email | Loại |
|-------|-------|------|
| EP-E-1 | Có @ + domain | Valid |
| EP-E-2 | Thiếu @ hoặc domain | Invalid |

#### B. Phân tích giá trị biên (BVA) — độ dài MK

| Mã TC | Độ dài | Đủ charset | Kỳ vọng |
|-------|--------|------------|--------|
| BVA-01 | 7 | Có | Từ chối |
| BVA-02 | 8 | Có | Chấp nhận |
| BVA-03 | 9 | Có | Chấp nhận |
| BVA-04 | 32 | Có | Chấp nhận |
| BVA-05 | 33 | Có | Từ chối |
| BVA-06 | 10 | Thiếu số | Từ chối (EP) |

#### C. Bảng quyết định — kích hoạt tài khoản

**C1:** OTP **đúng** (T/F) **C2:** Trong **24h** (T/F) **C3:** Số lần sai **< 5** (T/F)

| C1 | C2 | C3 | Kết quả |
|----|----|----|---------|
| T | T | T | Hoạt động |
| F | T | T | Thử lại OTP |
| * | F | * | Hết hạn, yêu cầu gửi lại |
| * | * | F | Khóa |

| Mã TC | Dòng | Kiểm tra |
|-------|------|----------|
| DT-01 | Hàng 1 | Kích hoạt OK |
| DT-02 | Hàng 4 | 5 lần sai |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Chưa kích hoạt | Gửi OTP | Đang chờ OTP |
| Đang chờ OTP | OTP đúng, còn hạn | Hoạt động |
| Đang chờ OTP | Sai OTP lần 5 | Khóa |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | MK/email hợp lệ, OTP đúng, trong 24h, chưa sai 5 lần | Đăng ký → Gửi OTP → Nhập OTP đúng | Trạng thái Hoạt động |
| UC-E-01 | Exc | OTP đúng nhưng quá 24h | Nhập OTP | Không kích hoạt; yêu cầu gửi lại (khớp DT) |
| UC-E-02 | Exc | Sai OTP lần 5 | Nhập OTP sai lần thứ 5 | Trạng thái Khóa |
| UC-E-03 | Exc | MK thiếu chữ hoa | Đăng ký | Từ chối; báo không đủ quy tắc MK |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Replay OTP | Gửi OTP mới nhưng nhập mã cũ còn hạn | Từ chối / một lần dùng | Replay |
| EG-02 | MK có space | Paste `" Abc1!x "` | Trim hoặc từ chối có thông báo | Chuẩn hóa input |
| EG-03 | OTP từ HTML email | Copy OTP kèm ký tự ẩn | Từ chối hoặc chấp nhận sau sanitize thống nhất | Ký tự ẩn |

---

### Bài mẫu 10 — Mức độ: Khó · Phức tạp  
**Vay tiêu dùng online**

**Đặc tả nghiệp vụ:** Thu nhập **≥ 5.000.000đ/tháng**; khoản vay **10–200 triệu**; kỳ hạn **6–36 tháng**. **CIC xấu** **hoặc** **nợ quá hạn tại app** → **từ chối tự động** (ưu tiên trước điểm nội bộ). **Điểm nội bộ ≥ 650** → vào **Chờ duyệt người**; **< 650** → **từ chối tự động**. **Trạng thái:** **Nháp** → **Chờ kiểm tra tự động** → **Từ chối tự động** / **Chờ duyệt người** → **Đã giải ngân** / **Từ chối**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Thu nhập, số tiền vay, kỳ hạn; CIC/quá hạn; điểm ≥650; TT đơn.
2. **Use case:** Nộp → tự động → duyệt tay → giải ngân/từ chối.
3. **TC UC** → **mục E**.
4. **State:** Nháp → Chờ KT → Từ chối auto / Chờ người → **mục D**.
5. **Bảng QĐ:** CIC × quá hạn × điểm → **mục C** (ưu tiên từ chối sớm).
6. **EP:** các ngưỡng → **mục A**.
7. **BVA:** 4.999.999/5M, 9.99M/10M, 200M, kỳ 5/6/36/37 → **mục B**.
8. **Đối chiếu.**
9. **EG:** hai đơn song song → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Thu nhập / Số tiền vay / Kỳ hạn | Loại |
|-------|-----------------------------------|------|
| EP-1 | Thu nhập ≥ 5M | Valid |
| EP-2 | Thu nhập < 5M | Invalid |
| EP-3 | Vay ∈ \[10M, 200M\] | Valid |
| EP-4 | Vay ngoài khoảng | Invalid |
| EP-5 | Kỳ ∈ \[6, 36\] tháng | Valid |
| EP-6 | CIC tốt / xấu | Phân nhánh |
| EP-7 | Quá hạn / không | Phân nhánh |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Biến | Giá trị | Kỳ vọng |
|-------|------|---------|--------|
| BVA-01 | Thu nhập | 4.999.999 | Từ chối |
| BVA-02 | Thu nhập | 5.000.000 | Tiếp tục xét |
| BVA-03 | Vay | 9.999.999 | Từ chối |
| BVA-04 | Vay | 10.000.000 | Hợp lệ |
| BVA-05 | Vay | 200.000.000 | Hợp lệ |
| BVA-06 | Vay | 200.000.001 | Từ chối |
| BVA-07 | Kỳ | 5 tháng | Từ chối |
| BVA-08 | Kỳ | 6, 36 | Biên hợp lệ |
| BVA-09 | Kỳ | 37 | Từ chối |

#### C. Bảng quyết định — luồng tự động (rút gọn)

**C1:** CIC **không xấu** (T/F) **C2:** **Không** quá hạn app (T/F) **C3:** Điểm **≥ 650** (T/F)

| C1 | C2 | C3 | Kết quả |
|----|----|----|---------|
| F | * | * | Từ chối tự động |
| T | F | * | Từ chối tự động |
| T | T | F | Từ chối tự động |
| T | T | T | Chờ duyệt người |

| Mã TC | Dòng | Ý nghĩa |
|-------|------|---------|
| DT-01 | 1 | CIC xấu |
| DT-02 | 4 | Đủ điều kiện sang duyệt tay |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Nháp | Nộp đơn | Chờ KT tự động |
| Chờ KT | Rule fail | Từ chối tự động |
| Chờ KT | Rule pass | Chờ duyệt người |
| Chờ duyệt | Duyệt | Đã giải ngân / Từ chối |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Thu nhập, số vay, kỳ hạn hợp lệ; CIC tốt; không quá hạn app; điểm ≥ 650 | Nộp đơn → Chờ KT → Chờ duyệt người → Duyệt | Đã giải ngân (theo policy sau duyệt) |
| UC-A-01 | Alt | Đã từ chối tự động / từ chối người | Bổ sung hồ sơ, nộp lại (nếu đề cho phép) | Theo policy hệ thống |
| UC-E-01 | Exc | CIC xấu | Nộp đơn | Từ chối tự động ngay (không xét điểm) |
| UC-E-02 | Exc | Quá hạn tại app | Nộp đơn | Từ chối tự động |
| UC-E-03 | Exc | Điểm nội bộ dưới 650, các điều kiện khác OK | Nộp đơn | Từ chối tự động |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Hai đơn vay song song | Hai phiên nộp cùng lúc gần hạn mức | Một đơn pass, một fail rõ ràng / không vượt hạn | Trùng hạn mức |
| EG-02 | Sửa thu nhập sau nộp | Mở form sửa khi đơn đã Chờ KT | Không cho sửa hoặc audit log đầy đủ | Toàn vẹn dữ liệu |
| EG-03 | Làm tròn triệu VNĐ | Nhập thu nhập sát ngưỡng 5.000.000đ | Quy tắc làm tròn thống nhất với BVA | Biên số tiền |

---

### Bài mẫu 11 — Mức độ: Trung bình  
**Đổi/trả hàng TMĐT**

**Đặc tả nghiệp vụ:** Yêu cầu đổi/trả trong **7 ngày** kể từ **nhận hàng**; sản phẩm **còn nguyên seal**. **Tỷ lệ hoàn:** **VIP** và **lỗi do shop** → **100%**; chỉ **VIP** (không lỗi shop) → **80%**; **khách thường** và **lỗi shop** → **100%**; **còn lại** (thường, không lỗi shop) → **70%**. **Trạng thái:** **Khởi tạo** → **Chờ duyệt** → **Đang thu hàng** → **Hoàn tất** / **Từ chối**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** 7 ngày, seal; % hoàn theo VIP×lỗi shop; TT yêu cầu.
2. **Use case:** Đổi trả thành công; quá hạn; từ chối.
3. **TC UC** → **mục E**.
4. **State:** Khởi tạo → Chờ duyệt → Thu hàng → Hoàn tất/Từ chối → **mục D**.
5. **Bảng QĐ:** VIP × lỗi shop → % → **mục C**.
6. **EP:** ngày, seal → **mục A**.
7. **BVA:** ngày 6,7,8 → **mục B**.
8. **Đối chiếu.**
9. **EG:** múi giờ nhận hàng → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Số ngày từ nhận hàng | Seal | Loại |
|-------|---------------------|------|------|
| EP-1 | 1–7 | Còn | Có thể xét |
| EP-2 | >7 | * | Quá hạn |
| EP-3 | * | Mở seal | Theo policy (thường từ chối / giảm %) |

\*Nếu đề ghi **“7 ngày kể từ nhận hàng”** theo **lịch** (tính cả ngày nhận), cần **đổi** phân vùng/BVA cho khớp quy ước đó; bảng trên bám cách đếm **ngày thứ 1…7** sau nhận hàng (ngày 7 còn hạn, ngày 8 quá hạn).

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Ngày thứ | Kỳ vọng |
|-------|----------|--------|
| BVA-01 | 6 | Còn trong hạn |
| BVA-02 | 7 | Biên trên hợp lệ |
| BVA-03 | 8 | Quá hạn |

#### C. Bảng quyết định — % hoàn tiền

**C1:** VIP (T/F) **C2:** Lỗi shop (T/F)

| C1 | C2 | % hoàn |
|----|----|--------|
| T | T | 100% |
| T | F | 80% |
| F | T | 100% |
| F | F | 70% |

| Mã TC | Quy tắc | Kiểm tra |
|-------|---------|-----------|
| DT-01–04 | 4 dòng | So khớp % |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Khởi tạo | Gửi YC | Chờ duyệt |
| Chờ duyệt | Duyệt | Đang thu hàng |
| Chờ duyệt | Từ chối (policy / quá hạn / seal) | Từ chối |
| Đang thu hàng | Nhận hàng về kho | Hoàn tất |

| ST-INV-01 | Duyệt khi chưa Khởi tạo / dữ liệu rỗng |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Trong 7 ngày, seal còn, VIP×lỗi shop theo từng TC | Gửi YC → Duyệt → Thu hàng về kho | Hoàn tất; % hoàn khớp bảng QĐ |
| UC-E-01 | Exc | Ngày thứ 8 (quá hạn) | Gửi / xét duyệt | Từ chối |
| UC-A-01 | Alt | Chờ duyệt, policy không đạt | Từ chối yêu cầu | Trạng thái Từ chối; kết thúc luồng |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Múi giờ nhận hàng | Đặt mốc nhận hàng gần 0h UTC | Ngày 1…7 tính thống nhất theo server | Biên “ngày nhận” |
| EG-02 | Ảnh seal giả mạo | Tải ảnh đã chỉnh sửa | Từ chối / yêu cầu xác minh thêm | Gian lận |
| EG-03 | Hoàn tiền trùng lần 2 | Gọi API hoàn 2 lần cùng mã giao dịch | Một lần thành công, lần sau idempotent | Idempotency |

---

### Bài mẫu 12 — Mức độ: Trung bình · Thực tế  
**Bãi đỗ xe thông minh**

**Đặc tả nghiệp vụ:** Biển số **8–11 ký tự** (bộ quy tắc nội bộ). **Phí gửi:** **< 2 giờ** **miễn phí**; **2–5 giờ** **20.000đ**; **> 5 giờ** **50.000đ/ngày** (*làm tròn giờ theo quy định bãi*). **Chỗ đỗ:** **Trống** → **Đã vào** → **Đã ra** hoặc **Quá hạn thanh toán**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Biển 8–11 ký tự; phí theo <2h, 2–5h, >5h; TT chỗ.
2. **Use case:** Vào–ra; thanh toán.
3. **TC UC** → **mục E**.
4. **State:** Trống → Đã vào → Đã ra/Quá hạn TT → **mục D**.
5. **Bảng QĐ:** khung giờ (3 mức) → **mục C**.
6. **EP:** biển số → **mục A**.
7. **BVA:** 1h59,2h,5h,5h01 → **mục B**.
8. **Đối chiếu.**
9. **EG:** trùng biển, quẹt 2 lần → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Biển số (độ dài) | Loại |
|-------|------------------|------|
| EP-B-1 | 8–11 ký tự, charset hợp lệ | Valid |
| EP-B-2 | <8 hoặc >11 | Invalid |
| EP-B-3 | Đúng độ dài nhưng ký tự lạ | Invalid |

#### B. Phân tích giá trị biên (BVA) — thời gian gửi (giờ)

| Mã TC | Thời lượng | Phí |
|-------|-------------|-----|
| BVA-01 | 1h59 | 0đ (giả định <2h) |
| BVA-02 | 2h00 | 20k |
| BVA-03 | 2h01 | 20k |
| BVA-04 | 5h00 | 20k |
| BVA-05 | 5h01 | 50k (theo ngày / bậc) |

\*Giả định khoảng **2–5 giờ** là **đóng** cận trên tại **5h00** (tức **2h ≤ t ≤ 5h**); **>5 giờ** từ **5h01**. Nếu đặc tả dùng **làm tròn lên** theo giờ, phải **đổi** BVA cho khớp quy tắc làm tròn.

#### C. Bảng quyết định — mức phí (theo khung giờ)

**C1:** t **< 2h** **C2:** **2h ≤ t ≤ 5h** **C3:** **t > 5h** (chỉ một điều đúng tại một thời điểm)

| C1 | C2 | C3 | Phí |
|----|----|----|-----|
| T | F | F | 0đ |
| F | T | F | 20k |
| F | F | T | 50k/ngày |

| Mã TC | Khung | Kiểm tra |
|-------|-------|-----------|
| DT-01–03 | 3 nhánh | Khớp bảng |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Trống | Xe vào (quẹt hợp lệ) | Đã vào |
| Đã vào | Thanh toán + Ra | Đã ra |
| Đã vào | Quá hạn thanh toán (policy) | Quá hạn TT |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Biển hợp lệ, gửi dưới 2h | Quẹt vào → Ra sau 1h → Thanh toán | Phí 0đ |
| UC-E-01 | Exc | Có phí nhưng chưa thanh toán | Ra / quẹt ra | Chặn ra hoặc chuyển Quá hạn TT (theo policy) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Hai xe cùng biển | OCR đọc trùng biển | Một xe được gán đúng; cảnh báo trùng | Trùng OCR |
| EG-02 | Quẹt vào 2 lần | Quẹt liên tiếp tại barrier | Một phiên Đã vào; lần 2 từ chối hoặc gộp đúng | Double entry |
| EG-03 | Đồng hồ sai | Chỉnh giờ thiết bị | Phí tính theo giờ server / audit | Phí sai |

---

### Bài mẫu 13 — Mức độ: Khó · Thực tế  
**Đặt phòng khách sạn**

**Đặc tả nghiệp vụ:** Check-in **từ 14:00**, check-out **trước 12:00** (ngày trả). Số đêm **1–14**. Đặt theo **loại phòng** còn trống (**Đơn/Đôi/Suite**). **Cuối tuần** → **+20%** giá cơ bản. **Trẻ:** **<6** không phụ thu; **6–12** **+200k/đêm**; **>12** tính như **người lớn**. **Trạng thái:** **Giữ chỗ** → **Đã cọc** → **Đã xác nhận** → **Đã nhận phòng** → **Đã trả** / **Hủy**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Check-in 14h, out 12h; 1–14 đêm; loại phòng; cuối tuần +20%; phụ trẻ theo tuổi; TT đặt.
2. **Use case:** Đặt, đổi phòng, hủy.
3. **TC UC** → **mục E**.
4. **State:** Giữ chỗ → Cọc → Xác nhận → Nhận → Trả/Hủy → **mục D**.
5. **Bảng QĐ:** nhóm tuổi trẻ × (có thể × cuối tuần) → **mục C**.
6. **EP:** đêm, loại phòng → **mục A**.
7. **BVA:** 0/1/14/15 đêm; check-in 13:59/14:00; check-out quanh 12:00; tuổi trẻ 5/6/12/13 → **mục B**.
8. **Đối chiếu.**
9. **EG:** 29/2, múi giờ → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Số đêm | Loại phòng | Trẻ (tuổi) | Loại |
|-------|--------|------------|------------|------|
| EP-1 | 1–14 | Còn phòng | Mọi nhóm | Valid / tính giá |
| EP-2 | 0 hoặc >14 | * | * | Invalid |
| EP-3 | * | Hết phòng | * | Invalid |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Biến | Giá trị | Kỳ vọng |
|-------|------|---------|--------|
| BVA-01 | Đêm | 0 | Từ chối |
| BVA-02 | Đêm | 1, 14 | Hợp lệ |
| BVA-03 | Đêm | 15 | Từ chối |
| BVA-04 | Giờ vào | 13:59 | Theo policy (sớm) |
| BVA-05 | Giờ vào | 14:00 | Check-in đúng quy định |
| BVA-06 | Giờ ra (ngày trả) | 11:59 | Trước 12:00 → hợp lệ (checkout) |
| BVA-07 | Giờ ra | 12:00 | Biên “trước 12:00” (*theo quy ước đóng/mở cận*) |
| BVA-08 | Tuổi trẻ | 5 / 6 / 12 / 13 | <6 miễn; 6–12 +200k; >12 như NL |

\*Với **“check-out trước 12:00”**, cần thống nhất **11:59 vs 12:00** (thường 12:00 là **phải ra** hoặc **phụ thu** — ghi đúng theo đề).

#### C. Bảng quyết định — phụ thu trẻ (một đêm)

**C1:** Tuổi **<6** **C2:** **6–12** **C3:** **>12** (mutually exclusive)

| C1 | C2 | C3 | Phụ thu |
|----|----|----|---------|
| T | F | F | 0 |
| F | T | F | +200k |
| F | F | T | Tính NL |

**Kết hợp cuối tuần:** nhân hệ số +20% trên giá phòng (bài thi có thể tách bảng giá riêng).

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Giữ chỗ | Cọc thành công | Đã cọc |
| Đã cọc | Xác nhận | Đã xác nhận |
| Đã xác nhận | Check-in | Đã nhận phòng |
| Đã nhận phòng | Check-out | Đã trả |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | 2 đêm, phòng còn, trẻ 8 tuổi | Đặt → Cọc → Xác nhận | Giá = phòng × đêm + phụ trẻ (+20% cuối tuần nếu có) |
| UC-A-01 | Alt | Đã cọc | Đổi sang Suite còn phòng | Theo policy đổi phòng (phụ thu/chênh lệch) |
| UC-E-01 | Exc | 0 đêm hoặc 15 đêm | Đặt | Từ chối (ngoài 1–14) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | 29/2 năm nhuận | Chọn khoảng nghỉ chứa 29/2 | Số đêm/giá tính đúng | Biên lịch |
| EG-02 | Múi giờ | Đặt từ múi giờ khác, check-in 14:00 local | Thời điểm check-in thống nhất local | Check-in giờ local |
| EG-03 | Hủy sát free-cancel | Hủy sát mốc policy | Hoàn/chặn đúng policy | Policy hoàn tiền |

---

### Bài mẫu 14 — Mức độ: Trung bình  
**Chấm công nhân viên**

**Đặc tả nghiệp vụ:** **Vào ca** trong **6:00–10:00**; **Ra ca** trong **16:00–22:00** (cùng ngày làm việc). **Đi muộn:** sau **8:30** quá **15 phút** → **trừ điểm chấm công**. **OT:** **Ra sau 18:00** và có **duyệt OT** → **có phụ cấp**; **không duyệt** → **không** tính phụ cấp OT. **Trạng thái ca:** **Chưa vào** → **Đang làm** → **Đã ra**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Khung vào/ra; muộn >15’ sau 8:30; OT sau 18h + duyệt; TT ca.
2. **Use case:** Chấm vào–ra; trừ điểm muộn; phụ cấp OT.
3. **TC UC** → **mục E**.
4. **State:** Chưa vào → Đang làm → Đã ra; invalid ra khi chưa vào → **mục D**.
5. **Bảng QĐ:** ra sau 18h × OT duyệt → **mục C**.
6. **EP:** khung giờ → **mục A**.
7. **BVA:** 8:30+14’/+16’; 17:59/18:01 với OT; khung ra 15:59/16:00/22:00/22:01 → **mục B**.
8. **Đối chiếu.**
9. **EG:** quên chấm ra → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Giờ vào | Giờ ra | Loại |
|-------|---------|--------|------|
| EP-1 | Trong [6:00–10:00] | Trong [16:00–22:00] | Valid (cơ bản) |
| EP-2 | Ngoài khung vào | * | Invalid |
| EP-3 | * | Ngoài khung ra | Invalid |

| Mã PV | Muộn (so 8:30 + 15’) | Loại |
|-------|---------------------|------|
| EP-M-1 | ≤ 15 phút sau 8:30 | Không trừ điểm |
| EP-M-2 | > 15 phút sau 8:30 | Trừ điểm |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Giờ vào | Kỳ vọng |
|-------|---------|--------|
| BVA-01 | 5:59 | Từ chối / ngoài khung |
| BVA-02 | 6:00 | Chấp nhận |
| BVA-03 | 8:30 + 14’ | Không trừ điểm |
| BVA-04 | 8:30 + 16’ | Trừ điểm |

| Mã TC | Giờ ra | OT duyệt | Phụ cấp |
|-------|--------|----------|---------|
| BVA-05 | 17:59 | T | Không (chưa sau 18:00) |
| BVA-06 | 18:01 | T | Có |
| BVA-07 | 18:01 | F | Không |

| Mã TC | Giờ ra (khung 16:00–22:00) | Kỳ vọng |
|-------|----------------------------|--------|
| BVA-08 | 15:59 | Ngoài khung ra |
| BVA-09 | 16:00 | Biên dưới hợp lệ |
| BVA-10 | 22:00 | Biên trên (*theo quy ước [16:00,22:00] đóng/mở*) |
| BVA-11 | 22:01 | Ngoài khung ra |

#### C. Bảng quyết định — phụ cấp OT

**C1:** Ra sau **18:00** (T/F) **C2:** **OT được duyệt** (T/F)

| C1 | C2 | Phụ cấp OT |
|----|----|------------|
| T | T | Có |
| T | F | Không |
| F | * | Không |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Chưa vào | Chấm vào hợp lệ | Đang làm |
| Đang làm | Chấm ra hợp lệ | Đã ra |

| ST-INV-01 | Chấm ra khi Chưa vào |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Vào 8:00, ra 17:00 trong khung | Chấm vào → Chấm ra | Không trừ điểm muộn; không phụ cấp OT |
| UC-A-01 | Alt | Ra sau 18:00, có duyệt OT | Chấm ra | Có phụ cấp OT |
| UC-E-01 | Exc | Vào 5:59 (ngoài khung vào) | Chấm vào | Từ chối / không ghi nhận |
| UC-E-02 | Exc | Chấm ra khi Chưa vào | Chấm ra | Từ chối (ST-INV-01) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Quên chấm ra | Chỉ có Chấm vào trong ngày | Cảnh báo ca treo / nhắc bổ sung | Ca treo |
| EG-02 | Sửa giờ máy | Lùi đồng hồ trước khi chấm | Ghi nhận theo giờ server hoặc từ chối | Gian lận |
| EG-03 | Ca qua đêm | Chấm vào 22:00 ngày 1, ra 06:00 ngày 2 | Quy ước ngày làm việc rõ ràng | Quy ước ngày |

---

### Bài mẫu 15 — Mức độ: Khó  
**Hệ thống vé máy bay (đơn giản hóa)**

**Đặc tả nghiệp vụ:** **1–9** hành khách / PNR. **Xách tay:** **Eco** tối đa **7 kg**; **Biz** tối đa **10 kg**. **Ký gửi thêm:** **0–3 kiện**, mỗi kiện **≤23 kg**. **Giá:** phụ thuộc **còn chỗ** và **bay trong <7 ngày** (phụ phí sát ngày theo bảng). **Trạng thái:** **Đang chọn** → **Giữ chỗ** → **Đã thanh toán** → **Đã xuất vé** / **Hủy**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** 1–9 HK; xách tay Eco/Biz; ký gửi 0–3 kiện ≤23kg; giá theo chỗ & <7 ngày; TT đặt.
2. **Use case:** Đặt vé; HL sai; hết chỗ.
3. **TC UC** → **mục E**.
4. **State:** Đang chọn → Giữ chỗ → Đã TT → Xuất vé → **mục D**.
5. **Bảng QĐ:** hạng × sát ngày × còn chỗ → **mục C**.
6. **EP:** HK, kg, kiện → **mục A**.
7. **BVA:** biên kg theo hạng; 3/4 kiện → **mục B**.
8. **Đối chiếu.**
9. **EG:** đổi hạng, trùng CMND → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Số HK | Loại |
|-------|-------|------|
| EP-H-1 | 1–9 | Valid |
| EP-H-2 | 0 hoặc ≥10 | Invalid |

| Mã PV | Hạng | kg xách tay | Loại |
|-------|------|-------------|------|
| EP-X-1 | Eco | ≤7 | Valid |
| EP-X-2 | Eco | >7 | Invalid |
| EP-X-3 | Biz | ≤10 | Valid |
| EP-X-4 | Biz | >10 | Invalid |

| Mã PV | Số kiện ký gửi | kg/kiện |
|-------|----------------|---------|
| EP-K-1 | 0–3 | ≤23 |
| EP-K-2 | >3 | Invalid |
| EP-K-3 | * | >23 Invalid |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Ngữ cảnh | Giá trị | Kỳ vọng |
|-------|----------|---------|--------|
| BVA-01 | Eco xách tay | 6.9 / 7 / 7.1 kg | Chấp nhận / Biên / Từ chối |
| BVA-02 | Biz xách tay | 9.9 / 10 / 10.1 kg | Tương tự |
| BVA-03 | Kiện ký gửi | 3 kiện OK; 4 kiện | Từ chối |
| BVA-04 | HK | 0 / 1 / 9 / 10 | Biên số lượng |

#### C. Bảng quyết định — phụ phí (ví dụ)

**C1:** **Còn chỗ** (T/F) **C2:** **<7 ngày** đến giờ bay (T/F)

| C1 | C2 | Hành động giá |
|----|----|----------------|
| T | F | Giá chuẩn |
| T | T | Giá + phụ phí sát ngày |
| F | * | Không bán / vào danh sách chờ |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Đang chọn | Giữ chỗ | Giữ chỗ |
| Giữ chỗ | Thanh toán | Đã thanh toán |
| Đã thanh toán | Xuất vé | Đã xuất vé |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | 2 HK Eco, xách tay ≤7 kg, kiện ký gửi hợp lệ, còn chỗ | Giữ chỗ → Thanh toán → Xuất vé | Đã xuất vé |
| UC-E-01 | Exc | Eco 8 kg xách tay | Check-in / khai báo HL | Từ chối hoặc phụ phí (theo đề; mẫu: từ chối) |
| UC-E-02 | Exc | Hết chỗ, bay trong 7 ngày | Đặt | Vào chờ / không bán (khớp bảng QĐ) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Đổi hạng sau chọn ghế | Eco → Biz sau khi giữ chỗ | Giá và hành lý đồng bộ | Đồng bộ giá & HL |
| EG-02 | Trùng CMND | 2 HK cùng số giấy tờ | Từ chối một bản ghi | Gian lận |
| EG-03 | Giữ chỗ hết hạn | Không TT trong TTL | Ghế trả lại kho | Ghế trả lại |

---

### Bài mẫu 16 — Mức độ: Trung bình · Phức tạp  
**Cấp quyền truy cập tài liệu**

**Đặc tả nghiệp vụ:** **Vai trò:** **Admin**, **Trưởng nhóm**, **Thành viên**. **Mức mật tài liệu:** **Công khai**, **Nội bộ**, **Mật**. **Quy tắc xem:** **Admin** → mọi mức; **Trưởng nhóm** → **Công khai + Nội bộ** của **nhóm mình**; **Thành viên** → **Công khai** và **Nội bộ** **chỉ khi được gán trực tiếp** (không xem **Mật** trừ khi có quy đặc biệt — *bài này: Thành viên không xem Mật*). **Trạng thái tài liệu:** **Nháp** → **Đã xuất bản** → **Thu hồi**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Vai trò × mức mật × gán trực tiếp; TT tài liệu.
2. **Use case:** Xem/sửa/thu hồi theo quyền.
3. **TC UC** → **mục E**.
4. **State:** Nháp → Đã XB → Thu hồi → **mục D**.
5. **Bảng QĐ:** vai trò × mức mật × gán → **mục C**.
6. **EP:** tổ hợp quyền → **mục A**.
7. **BVA:** ID tài liệu (nếu có giới hạn) → **mục B**.
8. **Đối chiếu.**
9. **EG:** IDOR, cache quyền → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Vai trò | Mức mật | Gán trực tiếp | Xem được? |
|-------|---------|---------|---------------|-----------|
| EP-1 | Admin | Bất kỳ | * | Có |
| EP-2 | Trưởng nhóm | Công khai/Nội bộ, cùng nhóm | * | Có |
| EP-2b | Trưởng nhóm | Nội bộ **nhóm khác** | * | Không (không thuộc “của nhóm mình”) |
| EP-3 | Trưởng nhóm | Mật | * | Không |
| EP-4 | Thành viên | Công khai | * | Có |
| EP-5 | Thành viên | Nội bộ | Có | Có |
| EP-6 | Thành viên | Nội bộ | Không | Không |
| EP-7 | Thành viên | Mật | * | Không |

#### B. Phân tích giá trị biên (BVA)

*Bài quyền thường không có biên số; có thể nêu **BVA trên độ dài ID** hoặc **số lượng tài liệu gán** nếu đặc tả có giới hạn — ví dụ tối đa 100 bản ghi/trang.*

| Mã TC | Ngữ cảnh | Kỳ vọng |
|-------|----------|--------|
| BVA-01 | ID tài liệu = min/max hợp lệ | Tra cứu đúng |
| BVA-02 | ID không tồn tại | 404 / không có quyền |

#### C. Bảng quyết định — được phép XEM

**C1:** Vai trò ∈ {Admin, TN, TV} **C2:** Mức mật ∈ {CK, NB, Mật} **C3:** Gán trực tiếp (T/F) — chỉ ý nghĩa với TV + NB

*(Khi thi có thể rút gọn còn 6–8 cột đại diện thay vì liệt kê hết tổ hợp.)*

| Mã TC | Tổ hợp (rút gọn) | Kết quả |
|-------|------------------|--------|
| DT-01 | Admin + Mật | Cho xem |
| DT-02 | TN + NB + cùng nhóm | Cho xem |
| DT-02b | TN + NB + **không** cùng nhóm | Từ chối |
| DT-03 | TV + Mật | Từ chối |
| DT-04 | TV + NB + không gán | Từ chối |

#### D. Chuyển trạng thái (tài liệu)

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Nháp | Xuất bản (đủ quyền) | Đã xuất bản |
| Đã xuất bản | Thu hồi | Thu hồi |

| ST-INV-01 | Xuất bản khi không đủ quyền |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Admin, tài liệu Mật | Mở xem | Thành công (200/nội dung) |
| UC-E-01 | Exc | Thành viên, NB, chưa gán trực tiếp | GET tài liệu | 403 / từ chối |
| UC-E-02 | Exc | Trưởng nhóm, NB nhóm khác | GET tài liệu | 403 (khớp EP-2b) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | IDOR | Đổi `doc_id` trên URL sang tài liệu người khác | 403 / không lộ nội dung | IDOR |
| EG-02 | Hạ quyền giữa phiên | Admin → TV trong cùng phiên, F5 | Quyền mới áp dụng ngay hoặc buộc đăng nhập lại | Cache quyền |
| EG-03 | Link cũ sau thu hồi | Mở URL đã lưu | 404/403; không đọc được nội dung | Lộ tài liệu |

---

### Bài mẫu 17 — Mức độ: Khó · Thực tế  
**Đấu giá trực tuyến**

**Đặc tả nghiệp vụ:** **Bước giá tối thiểu 10.000đ**. Mỗi lượt đặt phải **≥ giá hiện tại + 10.000đ**. **Phiên:** **Chưa mở** → **Đang diễn ra** → **Đã đóng** / **Hủy**. Chỉ **Đang diễn ra** nhận đặt giá hợp lệ. **Gia hạn:** có đặt trong **2 phút cuối** → kéo dài thêm **5 phút** (*mô tả hành vi — cần TC theo thời gian*).

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Bước giá 10k; chỉ khi phiên mở; gia hạn 2’ cuối +5’.
2. **Use case:** Đặt hợp lệ; đặt sai thời điểm/số tiền.
3. **TC UC** → **mục E**.
4. **State:** Chưa mở → Đang → Đóng/Hủy → **mục D**.
5. **Bảng QĐ:** phiên mở × giá hợp lệ → **mục C**.
6. **EP:** mức giá đặt → **mục A**.
7. **BVA:** hiện tại+9999/+10000; thời điểm gia hạn → **mục B**.
8. **Đối chiếu.**
9. **EG:** hai request đồng thời → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Giá đặt so với hiện tại | Loại |
|-------|------------------------|------|
| EP-1 | ≥ hiện tại + 10.000 | Valid (khi phiên mở) |
| EP-2 | = hiện tại + 9.999 | Invalid |
| EP-3 | < hiện tại | Invalid |

#### B. Phân tích giá trị biên (BVA)

Giả sử **giá hiện tại = 100.000đ**.

| Mã TC | Giá đặt | Kỳ vọng |
|-------|---------|--------|
| BVA-01 | 109.999 | Từ chối |
| BVA-02 | 110.000 | Chấp nhận |
| BVA-03 | 110.001 | Chấp nhận |

| Mã TC | Thời điểm đặt (so deadline) | Kỳ vọng gia hạn |
|-------|------------------------------|-----------------|
| BVA-04 | 2’01” trước kết thúc | Không gia hạn (theo ngưỡng 2’) |
| BVA-05 | 1’59” trước kết thúc | Gia hạn +5’ |

\*“**Trong 2 phút cuối**” = thời gian còn lại **≤ 120 giây** hay **< 120 giây** phụ thuộc đề; biên **đúng 2’00”** còn lại cần **1 TC** xác nhận theo đặc tả (gia hạn hay không).

#### C. Bảng quyết định — chấp nhận đặt giá

**C1:** Phiên **Đang diễn ra** (T/F) **C2:** Giá **hợp lệ** (T/F)

| C1 | C2 | Kết quả |
|----|----|---------|
| T | T | Ghi nhận giá mới |
| T | F | Từ chối |
| F | * | Từ chối |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Chưa mở | Đến giờ mở | Đang diễn ra |
| Đang diễn ra | Hết giờ (không gia hạn) | Đã đóng |
| Đang diễn ra | Hủy phiên | Hủy |

| ST-INV-01 | Đặt giá khi Chưa mở hoặc Đã đóng |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Phiên Đang diễn ra, giá ≥ hiện tại + 10k | Gửi lượt đặt | Ghi nhận giá mới |
| UC-E-01 | Exc | Phiên đã đóng / Chưa mở | Đặt giá | Từ chối |
| UC-E-02 | Exc | Giá = hiện tại + 9.999đ | Đặt | Từ chối |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Hai request cùng ms | Hai POST cùng lúc | Một thắng, một fail có thông báo | Đua tranh giá |
| EG-02 | Spam gia hạn | Nhiều đặt trong 2 phút cuối | Gia hạn có giới hạn / chống lạm dụng | Spam gia hạn |
| EG-03 | Clock skew | Client lệch giờ so server | Trạng thái phiên theo server | Sai trạng thái phiên |

---

### Bài mẫu 18 — Mức độ: Trung bình  
**Ứng dụng gói cước di động**

**Đặc tả nghiệp vụ:** Data **trong gói 0–50 GB/tháng**. **Vượt gói:** mỗi **1 GB** (hoặc phần làm tròn theo quy định) **+10.000đ**. **Đổi gói:** chỉ khi thuê bao **Hoạt động** và **không nợ cước**. **Trạng thái:** **Chờ kích hoạt** → **Hoạt động** → **Tạm khóa** (nợ) → **Hủy**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Gói 0–50GB; ngoài gói bậc thang; đổi gói khi hoạt động & không nợ; TT thuê bao.
2. **Use case:** Dùng data; đổi gói; khóa nợ.
3. **TC UC** → **mục E**.
4. **State:** Chờ KH → Hoạt động → Tạm khóa → Hủy → **mục D**.
5. **Bảng QĐ:** hoạt động × không nợ → đổi gói → **mục C**.
6. **EP:** data, gói → **mục A**.
7. **BVA:** 49.9/50/50.1 GB; đổi gói khi Chờ KH / Tạm khóa → **mục B**.
8. **Đối chiếu.**
9. **EG:** reset chu kỳ → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Data đã dùng trong tháng | Loại |
|-------|--------------------------|------|
| EP-D-1 | 0–50 GB | Trong gói |
| EP-D-2 | >50 GB | Phát sinh ngoài gói |
| EP-D-3 | <0 | Invalid |

| Mã PV | Đổi gói | Loại |
|-------|---------|------|
| EP-C-1 | Hoạt động + không nợ | Được phép |
| EP-C-2 | Nợ hoặc không hoạt động | Không đổi |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Data (GB) | Kỳ vọng tính cước |
|-------|-----------|-------------------|
| BVA-01 | 49.9 | Trong gói |
| BVA-02 | 50.0 | Biên gói |
| BVA-03 | 50.1 | Bắt đầu phát sinh (theo bậc) |

| Mã TC | Đổi gói (TT + nợ) | Kỳ vọng |
|-------|-------------------|--------|
| BVA-04 | Chờ kích hoạt + không nợ | Từ chối (chưa Hoạt động) |
| BVA-05 | Hoạt động + đang nợ (Tạm khóa) | Từ chối |

#### C. Bảng quyết định — đổi gói

**C1:** TT **Hoạt động** (T/F) **C2:** **Không nợ** (T/F)

| C1 | C2 | Đổi gói |
|----|----|---------|
| T | T | Cho phép |
| T | F | Từ chối |
| F | * | Từ chối |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Chờ kích hoạt | Kích hoạt | Hoạt động |
| Hoạt động | Nợ quá hạn | Tạm khóa |
| Tạm khóa | Thanh toán đủ | Hoạt động |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | Hoạt động, không nợ | Đổi gói | Thành công |
| UC-E-01 | Exc | Tạm khóa (nợ) | Đổi gói | Từ chối |
| UC-E-02 | Exc | Chờ kích hoạt | Đổi gói | Từ chối |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Reset đầu tháng | Dùng data sát 0h tháng mới | Bộ đếm reset đúng một mốc | Billing |
| EG-02 | Làm tròn GB | Dùng 50,01 GB | Phụ phí bậc thang đúng policy | Bậc thang |
| EG-03 | Đổi gói giữa chu kỳ | Đổi giữa tháng | Proration / cảnh báo rõ | Proration |

---

### Bài mẫu 19 — Mức độ: Khó · Phức tạp  
**Pipeline xử lý đơn hàng B2B**

**Đặc tả nghiệp vụ:** Đơn **≥ 100.000.000đ** cần **chữ ký Giám đốc** và **Kế toán trưởng**; **< 100 triệu** chỉ cần **Giám đốc**. **Xác nhận giao** chỉ khi **đủ tồn kho** và **công nợ khách ≤ hạn mức**. **Trạng thái:** **Nháp** → **Chờ duyệt** → **Đã duyệt** → **Đang giao** → **Hoàn tất** / **Hủy**. **Sửa đơn** chỉ khi **Nháp**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**.


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** ≥100M cần 2 chữ ký; tồn kho; công nợ ≤ hạn mức; TT đơn; sửa chỉ Nháp.
2. **Use case:** Duyệt, xác nhận giao, hủy.
3. **TC UC** → **mục E**.
4. **State:** Nháp → Chờ duyệt → Đã duyệt → Đang giao → **mục D**.
5. **Bảng QĐ:** chữ ký × tồn × công nợ → **mục C**.
6. **EP:** giá trị đơn, tồn, nợ → **mục A**.
7. **BVA:** 99.999.999/100M; nợ tại hạn mức; tồn đủ/thiếu → **mục B**.
8. **Đối chiếu.**
9. **EG:** ký song song, rollback → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Giá trị đơn | Chữ ký cần |
|-------|-------------|------------|
| EP-V-1 | < 100M | GD |
| EP-V-2 | ≥ 100M | GD + KTT |
| EP-T-1 | Tồn đủ | OK giao |
| EP-T-2 | Tồn thiếu | Không xác nhận giao |
| EP-N-1 | Công nợ ≤ hạn mức | OK |
| EP-N-2 | Công nợ > hạn mức | Không xác nhận |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Giá trị đơn (đ) | Chữ ký |
|-------|-----------------|--------|
| BVA-01 | 99.999.999 | Chỉ GD |
| BVA-02 | 100.000.000 | GD + KTT |

| Mã TC | Công nợ vs hạn mức | Xác nhận giao |
|-------|-------------------|----------------|
| BVA-03 | = hạn mức | Theo rule đủ tồn |
| BVA-04 | = hạn mức + 1đ | Từ chối |

| Mã TC | Tồn kho | Xác nhận giao (giả sử đủ ký & trong hạn nợ) |
|-------|---------|---------------------------------------------|
| BVA-05 | Thiếu 1 đơn vị | Không |
| BVA-06 | Đủ đúng biên | Có |

#### C. Bảng quyết định — xác nhận giao (rút gọn)

**C1:** Đủ chữ ký theo giá trị đơn (T/F) **C2:** Tồn đủ (T/F) **C3:** Công nợ ≤ hạn mức (T/F)

| C1 | C2 | C3 | Xác nhận giao |
|----|----|----|----------------|
| T | T | T | Có |
| * | F | * | Không |
| * | * | F | Không |
| F | * | * | Không |

| Mã TC | Mô tả |
|-------|--------|
| DT-01 | Đủ 3 điều kiện |
| DT-02 | Thiếu KTT khi ≥100M |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Nháp | Gửi duyệt | Chờ duyệt |
| Chờ duyệt | Đủ duyệt | Đã duyệt |
| Đã duyệt | Xác nhận giao | Đang giao |

| ST-INV-01 | Sửa đơn khi không phải Nháp |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | 80M, chỉ cần GD, đủ tồn, công nợ trong hạn | Đủ ký → Xác nhận giao | Đang giao |
| UC-E-01 | Exc | 100M thiếu chữ ký KTT | Gửi duyệt / xác nhận giao | Không đạt điều kiện ký; không giao |
| UC-E-02 | Exc | Thiếu tồn | Xác nhận giao | Từ chối (C2 sai trong bảng QĐ) |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Ký song song | Hai chữ ký POST đồng thời | Một phiên bản trạng thái nhất quán | Trùng state |
| EG-02 | Hủy khi Đang giao | Hủy đơn | Rollback tồn / policy rõ | Rollback tồn |
| EG-03 | Sửa giá sau ký | PATCH đơn sau khi đã ký | Từ chối hoặc yêu cầu ký lại | Toàn vẹn |

---

### Bài mẫu 20 — Mức độ: Khó · Thực tế  
**Hệ thống xếp hàng ưu tiên bệnh viện**

**Đặc tả nghiệp vụ:** **Thứ tự ưu tiên:** **Đỏ (cấp cứu)** > **Vàng** > **Xanh**. **Cùng mức:** **FIFO**. **Trẻ < 5 tuổi:** **nâng 1 bậc** (Vàng→Đỏ, Xanh→Vàng) nhưng **không vượt** mức Đỏ nếu đã Đỏ. **Phòng đóng:** chỉ **tiếp Đỏ**; các mức khác **từ chối vào hàng** (hoặc chuyển cơ sở — *bài này: từ chối*). **Trạng thái phiếu:** **Chờ** → **Đang khám** → **Hoàn thành** / **Bỏ qua**.

**Yêu cầu:** Tổng hợp đủ **6 kỹ thuật**; **bảng quyết định ≥ 3 điều kiện.**


#### 0. Trình tự thực hiện (bắt buộc)

*Thực hiện **tuần tự**; tương ứng **10 bước** trong mục **Quy trình từng bước (bắt buộc)** ở đầu file. Dưới đây là **áp dụng cụ thể** cho kịch bản này — sau đó mới xem bảng A–F là kết quả từng bước.*

1. **Trích đặc tả:** Đỏ>Vàng>Xanh; FIFO; trẻ <5 nâng bậc; phòng đóng chỉ Đỏ; TT phiếu.
2. **Use case:** Tiếp nhận; từ chối khi đóng phòng; khẩn cấp.
3. **TC UC** → **mục E**.
4. **State:** Chờ → Đang khám → Hoàn thành/Bỏ qua → **mục D**.
5. **Bảng QĐ:** ≥3 ĐK (mức sau điều chỉnh × vàng × phòng mở — theo đề) → **mục C**.
6. **EP:** mức màu, tuổi, phòng → **mục A**.
7. **BVA:** tuổi 4 vs 5 (và tuổi đủ 5 đúng ngày sinh nếu đề yêu cầu) → **mục B**.
8. **Đối chiếu** logic nâng bậc.
9. **EG:** cùng timestamp, sửa tay hàng chờ → **mục F**.
10. **Kiểm tra nộp.**

#### A. Phân vùng tương đương (EP)

| Mã PV | Mức ban đầu | Tuổi | Mức sau điều chỉnh |
|-------|-------------|------|---------------------|
| EP-1 | Xanh | ≥5 | Xanh |
| EP-2 | Xanh | <5 | Vàng |
| EP-3 | Vàng | <5 | Đỏ |
| EP-4 | Đỏ | * | Đỏ |

| Mã PV | Phòng | Mức sau điều chỉnh | Được vào hàng? |
|-------|-------|---------------------|----------------|
| EP-P-1 | Mở | Bất kỳ hợp lệ | Có |
| EP-P-2 | Đóng | Không phải Đỏ | Không |
| EP-P-3 | Đóng | Đỏ | Có |

#### B. Phân tích giá trị biên (BVA)

| Mã TC | Tuổi | Kỳ vọng nâng bậc |
|-------|------|------------------|
| BVA-01 | 4 | Áp dụng quy tắc trẻ dưới 5 (nâng bậc) |
| BVA-02 | 5 | Không nâng (không còn “dưới 5”) |

\*Nếu hệ thống tính tuổi theo **ngày sinh đủ năm**, bổ sung TC: **4 tuổi 11 tháng** vs **vừa đủ 5** — biên thực tế hay gặp trong thi.

#### C. Bảng quyết định — có được tiếp nhận vào hàng không

**C1:** Mức sau điều chỉnh là **Đỏ** (T/F) **C2:** Mức sau điều chỉnh là **Vàng** (T/F) **C3:** **Phòng mở** (T/F)  

*(Logic nghiệp vụ có thể rút gọn, nhưng bảng trên thể hiện đủ **3 điều kiện** theo yêu cầu đề.)*

| C1 | C2 | C3 | Tiếp nhận |
|----|----|----|-----------|
| T | * | T | Có |
| T | * | F | Có (cấp cứu khi đóng phòng) |
| F | T | T | Có |
| F | T | F | Không |
| F | F | T | Có (Xanh, phòng mở) |
| F | F | F | Không |

| Mã TC | Tổ hợp | Kiểm tra |
|-------|--------|-----------|
| DT-01 | Đỏ + phòng đóng | Vẫn tiếp |
| DT-02 | Xanh + phòng đóng | Không tiếp |
| DT-03 | Vàng + phòng mở | Tiếp |

#### D. Chuyển trạng thái

| TT | Sự kiện | TT kế |
|----|---------|-------|
| Chờ | Gọi vào khám | Đang khám |
| Đang khám | Kết thúc khám | Hoàn thành |
| Chờ | Bỏ qua / vắng | Bỏ qua |

#### E. Test case theo Use case

| Mã TC | Luồng | Điều kiện | Thao tác | Kết quả mong đợi |
|-------|-------|-----------|----------|------------------|
| UC-M-01 | Main | BN Xanh, 4 tuổi, phòng mở | Tiếp nhận vào hàng | Mức sau điều chỉnh Vàng; FIFO trong cùng mức |
| UC-E-01 | Exc | BN Xanh (sau điều chỉnh vẫn Xanh), phòng đóng | Tiếp nhận | Từ chối vào hàng |
| UC-E-02 | Exc | BN Đỏ, phòng đóng | Tiếp nhận | Vẫn tiếp nhận (khớp bảng QĐ) |
| UC-A-01 | Alt | Hai BN cùng mức sau điều chỉnh | Tiếp nhận lần lượt | Thứ tự FIFO |

#### F. Kiểm thử dựa trên kinh nghiệm (bổ sung)

| Mã TC | Tình huống | Thao tác | Kỳ vọng | Lý do bổ sung |
|-------|------------|----------|--------|----------------|
| EG-01 | Cùng timestamp | Hai BN cùng mức, cùng giờ tiếp nhận | FIFO ổn định (ví dụ theo STT hệ thống) | Thứ tự khi trùng thời điểm |
| EG-02 | Sửa tay DB | Đổi `order` trong bảng hàng chờ | Phát hiện / không cho sửa trái phép | Phá FIFO |
| EG-03 | Sai tuổi | Nhập 4 thay vì 5 | Sai mức ưu tiên; cần validate | Nhập liệu |

---

## PHẦN 2: BÀI TẬP TỰ LUYỆN

Làm đủ **checklist 6 kỹ thuật** như **Quy trình chuẩn** ở đầu file. **Bắt buộc** trình bày **đủ 10 bước** trong mục **Quy trình từng bước (bắt buộc)** — có thể viết gọn từng bước bằng gạch đầu dòng, sau đó mới đến các bảng EP/BVA/DT/ST/UC/EG; **không** chỉ nộp danh sách TC rời. Dưới đây chỉ có **đề + gợi ý**.

### Bài 1 — Dễ  
**Gửi form liên hệ:** Họ tên 2–50 ký tự; email hợp lệ; nội dung 10–1000 ký tự; chống spam: tick “Tôi không phải robot”.  
**Gợi ý:** EP/BVA độ dài; UC (gửi thành công / thiếu trường); state tối thiểu (Soạn → Đã gửi); 3 TC đoán lỗi (double submit, XSS trong nội dung).

### Bài 2 — Dễ  
**Máy bán nước:** Tiền mặt 5k, 10k, 20k; giá 15k/lần; trả lại tiền thừa; hết hàng thì từ chối.  
**Gợi ý:** Bảng QĐ tổ hợp tiền; state Idle / Nhận tiền / Phát hàng; BVA số lon còn 0,1.

### Bài 3 — Trung bình  
**Thuê xe tự lái:** Tuổi lái ≥ 21; GPLX hạng B trở lên; đặt cọc 5.000.000đ; hủy trước 48h hoàn 100% cọc.  
**Gợi ý:** DT hoàn cọc theo thời gian hủy; state đơn thuê; BVA 20 tuổi 364 ngày vs 21.

### Bài 4 — Trung bình  
**Đăng ký thi chứng chỉ:** Chỉ mở trong **khung giờ đăng ký**; **500 suất**; mỗi CMND **1 lần**/đợt.  
**Gợi ý:** EP trùng CMND; state Chờ mở / Mở / Hết suất; đoán lỗi race condition.

### Bài 5 — Trung bình  
**Tính học bổng:** Điểm TB **≥ 8.0** và **hạnh kiểm Khá trở lên** và **không nợ học phí** → học bổng **100%**; chỉ đủ 2/3 điều → **50%**; khác → **0**.  
**Gợi ý:** Bảng QĐ đủ 8 cột rồi rút gọn; BVA điểm 7.95 / 8.0.

### Bài 6 — Trung bình · Thực tế  
**Giao đồ ăn:** Bán kính **5 km**; phí ship cố định / theo km nếu vượt; nhà hàng **Đóng/Mở**.  
**Gợi ý:** BVA khoảng cách 4.9, 5.0, 5.1 km; UC hủy đơn bởi shipper.

### Bài 7 — Trung bình  
**Hệ thống phiếu nhập kho:** SL nhập **1–10.000**; mã SKU phải tồn tại; **Chờ nhập** → **Đã khóa** → **Hoàn tất**.  
**Gợi ý:** Không sửa sau Đã khóa; EP SKU không tồn tại.

### Bài 8 — Khó  
**Đấu thầu điện tử:** Nộp hồ sơ trước **deadline**; **≥ 3 nhà thầu** mới mở thầu; **mã hóa file** đến giờ mới giải.  
**Gợi ý:** State phien thầu; DT số nhà thầu hợp lệ; đoán lỗi chỉnh giờ server.

### Bài 9 — Khó  
**Tích điểm đổi quà:** Điểm **≥ giá quà**; hạn **điểm không quá 24 tháng**; quà **còn tồn**.  
**Gợi ý:** Bảng QĐ điểm × hạn × tồn; BVA điểm = giá quà −1 / = / +1.

### Bài 10 — Khó  
**Cấp phép xây dựng (đơn giản hóa):** Diện tích **≤ 500m²** xử lý **cấp huyện**; **>500** **cấp tỉnh**; có **quy hoạch treo** → **từ chối** mọi cấp.  
**Gợi ý:** Thứ tự ưu tiên quy hoạch treo trong bảng QĐ; BVA 499, 500, 501.

### Bài 11 — Trung bình · Thực tế  
**Chuyển tiền ví điện tử:** Số tiền **10.000–50.000.000đ**; phí **1%** tối thiểu **2.000đ**; ví đích phải **đã xác minh**.  
**Gợi ý:** BVA số tiền làm tròn phí; UC sai số ví đích.

### Bài 12 — Trung bình · Phức tạp  
**Đặt tour du lịch:** **≥ 8 người** giảm **8%/người** tối đa **40%**; **trẻ <12** giảm thêm **10%** trên giá người đó.  
**Gợi ý:** Chia EP người lớn/trẻ; kiểm tra trần giảm 40%; state giữ chỗ.

### Bài 13 — Khó · Thực tế  
**Hệ thống cấp cứu 115:** Ưu tiên cuộc gọi **có địa vị GPS** và **mô tả đúng template**; **spam** → hạ mức.  
**Gợi ý:** DT hoặc bảng quy tắc ưu tiên; đoán lỗi flood cuộc gọi.

### Bài 14 — Trung bình  
**Khoá học MOOC:** Bài quiz **3 lần làm** tối đa; điểm **≥ 50** qua; **<50** lần 3 → **học lại chương**.  
**Gợi ý:** State tiến độ học; BVA điểm 49,50,51.

### Bài 15 — Khó  
**Sàn NFT (giả lập):** Giá sàn **≥ giá đặt tối thiểu**; **phí sàn 2.5%**; ví **đủ ETH** mới list được.  
**Gợi ý:** EP số thập phân crypto; đoán lỗi rounding.

### Bài 16 — Khó · Phức tạp  
**Quản lý ca trực y tá:** Mỗi ca **tối đa 8 người**; **≥ 1 người** có **chứng chỉ ICU** trên ca **Hồi sức**.  
**Gợi ý:** Bảng QĐ đủ nhân sự × chứng chỉ; invalid swap ca vi phạm.

### Bài 17 — Trung bình · Thực tế  
**Thuê phòng coworking:** Gói giờ **1–12h**; **cuối tuần** phụ phí; **check-in QR** bắt buộc.  
**Gợi ý:** UC quên QR; state phòng Trống / Đang dùng.

### Bài 18 — Khó  
**Tuyển dụng đa vòng:** Điểm test **≥ 70** mới phỏng vấn; **Pass PV** + **background check OK** mới offer.  
**Gợi ý:** State ứng viên; DT các cờ pass/fail.

### Bài 19 — Khó · Thực tế  
**IoT khóa cửa thông minh:** Mã PIN **6 số**; **5 lần sai** khóa **15 phút**; **mở từ xa** chỉ khi **online**.  
**Gợi ý:** BVA PIN; state khóa; đoán lỗi replay Bluetooth.

### Bài 20 — Khó · Tổng hợp nâng cao  
**Mô tả tự do:** Chọn **một ứng dụng bạn dùng hằng ngày**, tự viết đặc tả **1 trang** (luồng + ràng buộc + trạng thái), sau đó áp dụng **đủ 6 kỹ thuật** và **đánh số tham chiếu** (EP-01, BVA-02, …) trong bảng test tổng.  
**Gợi ý:** Đây là bài kiểm tra “đi thẳng” vào thực tế; nộp kèm **ma trận traceability** kỹ thuật → yêu cầu nghiệp vụ.

---

**Kết thúc file 07.** Đối chiếu từng kỹ thuật chi tiết tại *[HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md)* và bài mẫu trong **01–06** khi cần làm sâu từng phần.
