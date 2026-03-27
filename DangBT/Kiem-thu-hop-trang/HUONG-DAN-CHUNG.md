# Hướng dẫn chung — Cách làm chuẩn bài tập Kiểm thử hộp trắng

Tài liệu này mô tả **quy trình chuẩn** và **cách làm từng dạng bài** (tiêu chí phủ — coverage) để bạn làm bài **đúng, đủ, dễ hiểu**, cùng phong cách trình bày với bộ **Bài tập hộp đen** (Phần 1 / Phần 2, bảng bước, gợi ý).

---

## 1. Khái niệm chung

- **Kiểm thử hộp trắng:** Thiết kế test dựa trên **cấu trúc bên trong** (mã nguồn, nhánh, điều kiện, luồng dữ liệu).
- **CFG (Control Flow Graph):** Đỉnh = khối lệnh / câu lệnh; cung = luồng điều khiển. Điều kiện `if / while` tạo **nhánh** (true / false).
- **Test case (ở đây):** Bộ giá trị đầu vào (và trạng thái) để khi **chạy chương trình**, đường thực thi đi qua các **câu lệnh / nhánh / điều kiện** cần phủ.

**Quy ước làm bài trên giấy**

1. Vẽ (hoặc liệt kê) **CFG** / đánh số **nút nhánh**.
2. Ghi **tập test case** T = {t₁, t₂, …}.
3. Với mỗi tiêu chí, đánh dấu phần tử nào được **phủ** (✓) và **còn thiếu** (✗).
4. So sánh **độ mạnh** tiêu chí: thường **Statement ≤ Branch ≤ …** (xem bảng cuối).

---

## 2. Độ phủ câu lệnh (Statement coverage — C0)

### Mục đích
Mọi **câu lệnh** (hoặc khối) ít nhất **chạy qua một lần**.

### Quy trình chuẩn

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | Xác định tập **câu lệnh** (hoặc nút CFG) cần phủ. | Gộp khối tuần tự liền nhau thành một nút nếu GV cho phép — nhất quán suốt bài. |
| **2** | Liệt kê **đường đi** có thể qua từng câu lệnh. | Vẽ CFG trước — dễ thấy nhánh `return` sớm hoặc `else` bị bỏ quên. |
| **3** | Thiết kế **ít test case** để mỗi câu lệnh ít nhất một đường đi qua. | Một TC có thể phủ nhiều lệnh; ghi **đường đi** ngắn trong bảng TC. |
| **4** | Kiểm tra **nhánh else / khối lỗi** — dễ bỏ sót nếu chỉ test “đường vui”. | C0 **không** bắt buộc phủ cả nhánh **F** của mọi `if` — so sánh với **C1** (file 02). |

### Lưu ý
- **C0 không đảm bảo** đã test cả nhánh **false** của mọi `if`.
- Một test có thể phủ **nhiều** câu lệnh.

---

## 3. Độ phủ nhánh / quyết định (Branch / Decision coverage — C1)

### Mục đích
Với **mỗi quyết định** (điều kiện điều khiển nhánh), cả nhánh **đúng (T)** và **sai (F)** đều phải được **thực thi ít nhất một lần**.

### Quy trình chuẩn

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | Liệt kê **mọi điều kiện** tạo rẽ nhánh (`if`, `while`, `for`, `?:`, `switch` — có thể rút gọn). | Đánh số D1, D2, … trên CFG cho khớp bảng TC. |
| **2** | Với mỗi điều kiện, cần **2 hướng**: T và F (trừ khi không thể đạt — ghi rõ *không khả thi*). | Vòng lặp: cạnh **vào / lặp / thoát** cần phủ đủ theo đề. |
| **3** | Thiết kế test case sao cho mỗi cạnh CFG có hướng ra được đi qua. | Ghi rõ **Kỳ vọng** + tóm tắt đường (vd. D1=F, D2=T). |

### Lưu ý
- **C1 mạnh hơn C0** (trong hầu hết trường hợp).
- Với `if (A && B)` một lần: có thể C1 đạt mà **chưa** thử mọi tổ hợp **A, B** riêng lẻ → cần tiêu chí **điều kiện** / **MC/DC**.

---

## 4. Độ phủ điều kiện (Condition coverage)

### Mục đích
Với **mỗi điều kiện con** (boolean) trong một biểu thức phức, mỗi điều kiện con phải lấy cả giá trị **true** và **false** (có thể ở **các test khác nhau**).

### Ví dụ
`if (a > 0 && b < 0)` có 2 điều kiện con: `(a>0)`, `(b<0)`.

### Quy trình chuẩn

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | **Phân rã** biểu thức điều kiện thành các **điều kiện nguyên tử** (atomic). | Tách `&&`, `||`, ngoặc — mỗi so sánh boolean là một atomic. |
| **2** | Với mỗi atomic, cần **T** và **F** trong toàn bộ tập test. | Có thể **hai TC khác nhau** mới đủ T và F cho cùng một atomic. |
| **3** | Ghi rõ từng test: giá trị `a, b, …` và kết quả từng atomic. | Với **C/D**, thêm cột: quyết định cả `if` đã lấy cả then và else chưa. |

### Độ phủ điều kiện–quyết định (Condition/Decision — C/D)
- Yêu cầu **đồng thời**: (1) **Decision coverage** trên toàn `if (…)` (cả nhánh then/else), và (2) **Condition coverage** trên các điều kiện con.

---

## 5. MC/DC (Modified Condition/Decision Coverage)

### Mục đích
Với **mỗi điều kiện con** trong một **quyết định**, tồn tại **cặp test** sao cho:
- Kết quả **toàn quyết định** (true/false của cả `if`) **đổi**;
- Chỉ **một** điều kiện con **đổi**; các điều kiện con khác **giữ nguyên**.

→ Chứng minh mỗi điều kiện con **ảnh hưởng độc lập** tới kết quả quyết định (trong ngữ cảnh đó).

### Quy trình chuẩn (tóm tắt)

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | Xác định **một quyết định** có n điều kiện con độc lập. | Chỉ phân tích **một** `if (…)` hoặc một biểu thức quyết định mỗi lần trình bày MC/DC. |
| **2** | Với **mỗi** điều kiện con Cᵢ, tìm **2 bộ** giá trị các biến: chỉ Cᵢ đổi, kết quả quyết định đổi. | Ghi **cặp** hàng trong bảng chân trị; các biến khác **cố định**. |
| **3** | Gộp tối thiểu hóa số test (thường **n+1** test cho n điều kiện trong nhiều bài đơn giản). | Biểu thức **hỗn hợp** có thể cần **≥ n+1** sau khi gộp — không copy máy bảng 2 biến. |

### Lưu ý
- MC/DC **mạnh**, bắt buộc trong một số chuẩn **an toàn** (hàng không, y tế).
- Không nhầm với **bảng chân trị đầy đủ** 2ⁿ (MC/DC không yêu cầu mọi tổ hợp).

---

## 6. Cyclomatic complexity V(G) & Basis path testing

### Độ phức tạp Cyclomatic (McCabe)

- **V(G) = E − N + 2P** (E = số cung, N = số đỉnh, P = số thành phần liên thông, thường P=1).
- Hoặc: **V(G) = số vùng** (kể cả vùng bên ngoài) trên đồ thị phẳng.
- Hoặc: **V(G) = D + 1** với D = số **điểm quyết định** (nhánh).

### Kiểm thử đường cơ sở (Basis path)

- Chọn **V(G) đường đi độc lập** (theo tập vector độc lập trên không gian nhánh — trong lớp thường dạy **liệt kê đường** từ cây quyết định).
- Mục tiêu: tập đường **cơ sở** phủ **mọi nhánh** trong nhiều cấu trúc đơn giản (cần cẩn trọng với **vòng lặp** và **đường không tới được**).

### Quy trình chuẩn

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | Vẽ CFG, tính **V(G)**. | Thống nhất công thức **D+1** hoặc **E−N+2** theo lớp; ghi rõ P. |
| **2** | Chọn **đường 1** (thường “đường vui” hoặc đường ngắn nhất). | Liệt kê đường bằng chuỗi nhánh (T/F) hoặc nút đi qua. |
| **3** | Lần lượt **lật một nhánh** so với đường trước để có đường mới độc lập, cho đến đủ **V(G)** đường (hoặc theo hướng dẫn giảng viên). | Vòng lặp: cần TC **0 lần**, **1 lần**, **nhiều lần** tùy CFG. |
| **4** | Gán **đầu vào** để mỗi đường thực sự **khả thi**. | Đường không tới được — ghi *không khả thi* và loại khỏi tập kiểm thử. |

---

## 7. Kiểm thử luồng dữ liệu (Data flow testing)

### Khái niệm
- **def:** Điểm gán giá trị cho biến (định nghĩa / ghi).
- **use:** Điểm đọc giá trị (dùng trong biểu thức, điều kiện, tham số).
- **c-use / p-use:** Dùng trong tính toán vs. dùng trong **điều kiện** (predicate).

### Tiêu chí đơn giản (phổ biến trong bài tập)
- **All-defs:** Mỗi **def** ít nhất được **use** một lần (theo một đường def-clear).
- **All-uses:** Mỗi cặp **(def, use)** trên đường def-clear được phủ.

### Quy trình chuẩn

| Bước | Việc cần làm | Gợi ý |
|------|----------------|--------|
| **1** | Đánh dấu **def / use** cho biến quan trọng trên CFG. | Chọn **1–2 biến** theo đề — không cần đánh mọi biến cục bộ. |
| **2** | Liệt kê cặp **(def → use)** hợp lệ (không có ghi đè trung gian nếu đề yêu cầu *def-clear*). | **p-use** (trong điều kiện) và **c-use** (trong tính toán) ghi rõ loại. |
| **3** | Thiết kế test để mỗi cặp (hoặc mỗi def) được thực thi. | Một TC có thể phủ nhiều cặp — ghi trong bảng tổng hợp. |

---

## 8. Bảng tóm tắt — Độ mạnh & Khi nào dùng

| Tiêu chí | Ý chính | Thường dùng khi |
|----------|---------|------------------|
| **Statement (C0)** | Mọi lệnh chạy qua | Nhanh, phát hiện “code chết”; **yếu** với nhánh. |
| **Branch / Decision (C1)** | Mọi nhánh T/F | Chuẩn tối thiểu phổ biến trong công nghiệp. |
| **Condition** | Mọi điều kiện con T/F | Biểu thức `&& \|\|` phức tạp. |
| **C/D** | C1 + Condition | Cần cả nhánh ngoài và biến bên trong. |
| **MC/DC** | Ảnh hưởng độc lập từng con | Phần mềm **an toàn cao**, logic điều khiển quan trọng. |
| **Basis path + V(G)** | Tập đường cơ sở | Module có **vòng lặp / nhiều nhánh lồng nhau**. |
| **Data flow** | def–use | Lỗi **chưa khởi tạo**, gán sai, dùng sau khi ghi đè. |

**Thứ tự độ mạnh (ý tưởng):**  
Statement ≤ Branch ≤ … ; MC/DC và Data flow **không luôn** so sánh tuyến tính với nhau — tùy mã.

---

## 9. Nộp bài gợi ý

- **CFG** (hình hoặc bảng cạnh).
- **Bảng phủ:** hàng = câu lệnh / nhánh / điều kiện; cột = TC1, TC2, …
- **Bảng test case:** Đầu vào | Kỳ vọng (đường đi / giá trị trả về).
- Ghi **nhánh không khả thi** (unreachable) nếu có.

---

**Cách dùng tài liệu này:** Đọc **Quy trình chuẩn** của từng tiêu chí trước khi làm bài; khi làm **PHẦN 1: BÀI TẬP MẪU**, đối chiếu từng **Bước** trong **Hướng dẫn giải chi tiết** với bảng ở đây. Khi làm **PHẦN 2: BÀI TẬP TỰ LUYỆN**, áp dụng đúng **Đề bài (chi tiết)** và **Yêu cầu** rồi tự kiểm tra bằng **Gợi ý giải** — cùng thói quen với bộ bài **hộp đen**.

*Tài liệu này bổ trợ các file 01–07 trong cùng thư mục.*
