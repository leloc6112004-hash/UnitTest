# Bài tập: Kiểm thử dựa trên kinh nghiệm

**Chương: Kiểm thử hộp đen**  
**Cấu trúc:** 2 phần — **Bài tập mẫu** (20 bài) và **Bài tập tự luyện** (20 bài). Gồm Đoán lỗi và Kiểm thử thăm dò.

---

## Quy trình chuẩn — Đoán lỗi & Thăm dò

**Đoán lỗi (Error guessing)** — dùng **sau** EP/BVA/DT (xem *HUONG-DAN-CHUNG.md*):

1. Đã có bộ test chính thức.
2. Liệt kê điểm dễ lỗi (copy-paste, đồng thời, timeout, overflow, ký tự đặc biệt, bảo mật, …).
3. Mỗi điểm → 1 hoặc vài test case (Đầu vào / Thao tác / Kỳ vọng).

**Thăm dò (Exploratory)** — 3 bước: (1) Định nghĩa charter (mục tiêu 1 câu); (2) Thực hiện trong timebox, ghi lỗi và hành vi; (3) Ghi chú, đề xuất test case.

**Lưu ý:** Đoán lỗi = bổ sung; Thăm dò = khi đặc tả thiếu, cần khám phá nhanh.

---

## PHẦN 1: BÀI TẬP MẪU

### Bài mẫu 1

**Đề bài (chi tiết):** Sau khi dùng phân vùng tương đương và BVA cho form **Đăng nhập**, hãy dùng **đoán lỗi** đề xuất thêm ít nhất 5 test case có thể bỏ sót.

**Hướng dẫn giải:**

Dựa trên kinh nghiệm các lỗi thường gặp ở form đăng nhập:

1. **Copy-paste khoảng trắng:** Username/password có khoảng trắng đầu hoặc cuối → hệ thống trim hay so khớp nguyên? → Test: "  user  ", "pass  ".
2. **Phân biệt hoa thường:** "User" và "user" có được coi là một tài khoản không? → Test nhập khác kiểu chữ.
3. **SQL injection:** Username = `' OR '1'='1` hoặc `admin'--` → Kiểm tra không bị inject, thông báo lỗi an toàn.
4. **XSS:** Nhập `<script>alert(1)</script>` vào username/password → Không hiển thị thực thi script trên trang lỗi.
5. **Đăng nhập đồng thời:** Hai tab cùng đăng nhập một tài khoản → Phiên có bị đá hay không, có thông báo hay không.
6. **Session sau khi đăng xuất:** Đăng xuất rồi bấm Back → Trang có còn dữ liệu nhạy cảm không, có bắt đăng nhập lại không.
7. **Sai nhiều lần:** Sai mật khẩu 10–20 lần → Có khóa tài khoản/captcha không, thông báo có rõ không.

Chọn ít nhất 5 ý trên, viết thành test case (Đầu vào / Thao tác / Kỳ vọng).

---

### Bài mẫu 2

**Đề bài (chi tiết):** Cho tính năng **Upload file** (ảnh, tối đa 5MB). Ngoài test theo EP/BVA, hãy dùng **đoán lỗi** đề xuất test case bổ sung.

**Hướng dẫn giải:**

1. **Đổi đuôi file:** File .exe đổi thành .jpg → Hệ thống kiểm tra nội dung (magic number) hay chỉ đuôi? → Upload file độc hại.
2. **File 0 byte:** Upload file rỗng → Chấp nhận hay từ chối, có thông báo không.
3. **Tên file đặc biệt:** Tên có ký tự `../`, `\0`, rất dài (260 ký tự), chỉ toàn khoảng trắng → Lưu an toàn, không path traversal.
4. **Hai file cùng tên:** Upload hai file trùng tên trong một request (nếu cho phép nhiều file) → Ghi đè hay lưu riêng, không lỗi.
5. **File ảnh nhưng header sai:** Sửa vài byte đầu file ảnh → Có validate header không.
6. **Upload khi hết dung lượng ổ:** (Khó test, có thể bỏ) Hoặc upload file đúng 5MB nhiều lần → Giới hạn dung lượng user có được kiểm tra không.

Chọn ít nhất 5, viết test case.

---

### Bài mẫu 3

**Đề bài (chi tiết):** **Kiểm thử thăm dò** cho màn hình **Danh sách đơn hàng** (có bộ lọc, tìm kiếm, phân trang). Lập 3 **charter** (mục tiêu thăm dò) và mô tả ngắn cách thực hiện.

**Hướng dẫn giải:**

**Charter 1 – Bộ lọc và tìm kiếm kết hợp:**  
Mục tiêu: Xem bộ lọc (trạng thái, ngày, khoảng tiền) kết hợp với ô tìm kiếm có cho kết quả đúng và không conflict không.  
Cách: Thử lọc theo “Đã giao” + tìm mã đơn “ABC”; đổi thứ tự (tìm trước, lọc sau); xóa từng bước và xem danh sách cập nhật đúng không. Ghi lại lỗi/khó hiểu.

**Charter 2 – Phân trang và dữ liệu:**  
Mục tiêu: Phân trang đúng khi thêm/sửa/xóa đơn; không duplicate hoặc thiếu bản ghi.  
Cách: Ở trang 2, mở một đơn rồi đổi trạng thái; quay lại danh sách xem trang 2 còn đúng không. Xóa đơn ở trang 1, xem trang 2 có nhảy không. Ghi lại hành vi bất thường.

**Charter 3 – Dữ liệu biên và rỗng:**  
Mục tiêu: Không có đơn nào; có 1 đơn; rất nhiều đơn; tìm kiếm không ra kết quả.  
Cách: Tạo tài khoản mới chưa có đơn; tìm mã không tồn tại; (nếu có) nhập 1000 đơn. Quan sát giao diện, thông báo, hiệu năng.

---

### Bài mẫu 4

**Đề bài (chi tiết):** Form **Đăng ký** có: email, mật khẩu, xác nhận mật khẩu, họ tên, số ĐT. Dùng **đoán lỗi** liệt kê 5 điểm dễ lỗi và test case tương ứng.

**Hướng dẫn giải:**

1. **Email trùng:** Đăng ký email đã có → Thông báo rõ “Email đã được sử dụng”, không leak thông tin user cũ.
2. **Xác nhận mật khẩu:** Nhập mật khẩu có khoảng trắng, xác nhận giống hệt (copy-paste) → Có trim thì cả hai đều trim, đăng ký thành công.
3. **Số ĐT:** Nhập +84..., 084..., 84... (bỏ 0) → Chuẩn hóa thống nhất; lưu đúng định dạng.
4. **Họ tên:** Chỉ nhập khoảng trắng; ký tự đặc biệt; tên rất dài (200 ký tự) → Validate, cắt hoặc từ chối, không crash.
5. **Submit nhiều lần:** Bấm “Đăng ký” nhiều lần nhanh → Chỉ tạo 1 tài khoản, nút disable hoặc chặn trùng request.

Viết 5 test case tương ứng.

---

### Bài mẫu 5

**Đề bài (chi tiết):** **Đoán lỗi** cho chức năng **Đổi mật khẩu** (cần mật khẩu hiện tại, mật khẩu mới, xác nhận mật khẩu mới). Đề xuất 5 test case dựa trên kinh nghiệm.

**Hướng dẫn giải:**

1. **Mật khẩu mới = mật khẩu hiện tại:** Hệ thống thường cấm → Thông báo rõ.
2. **Sao chép mật khẩu hiện tại vào ô “Mật khẩu mới”:** Một số form không so sánh với “hiện tại” → Chấp nhận nhầm → Nên từ chối.
3. **Đổi mật khẩu ở hai thiết bị:** Tab A đổi xong, tab B (phiên cũ) đổi tiếp → Phiên cũ nên hết hiệu lực hoặc yêu cầu mật khẩu mới.
4. **Ký tự đặc biệt/Unicode:** Mật khẩu mới có emoji, ký tự Unicode → Lưu đúng, đăng nhập lại được.
5. **Copy từ password manager:** Paste mật khẩu có thêm ký tự ẩn (zero-width) → So sánh có chuẩn không, không lỗi.

Viết 5 test case.

---

### Bài mẫu 6

**Đề bài (chi tiết):** **Kiểm thử thăm dò** cho luồng **Mua hàng** (chọn SP → Giỏ → Thanh toán → Hoàn tất). Lập 2 charter: một cho “đường vui” (happy path), một cho “đường lỗi và quay lại”.

**Hướng dẫn giải:**

**Charter 1 – Happy path và biến thể:**  
Mục tiêu: Mua 1 sản phẩm, nhiều sản phẩm, 1 SP số lượng > 1; đổi địa chỉ/ship; đổi mã giảm giá. Xem mỗi bước tính tiền, tổng đơn, phí ship có đúng không.  
Cách: Thực hiện từng biến thể, ghi lại từng bước, chụp màn hình nếu cần. Ghi lỗi tính toán hoặc hiển thị sai.

**Charter 2 – Lỗi và quay lại:**  
Mục tiêu: Ở bước Thanh toán, quay lại Giỏ sửa/xóa SP; hết hàng giữa chừng; thanh toán thất bại rồi thử lại.  
Cách: Giả lập hết hàng (nếu có), thẻ sai số; quay lại sửa giỏ rồi thanh toán lại. Kiểm tra giỏ, tổng tiền, trạng thái đơn không bị sai.

---

### Bài mẫu 7

**Đề bài (chi tiết):** **Đoán lỗi** cho ô **Số tiền** chuyển khoản: giới hạn 1–100 triệu. Đề xuất 5 test case ngoài EP/BVA.

**Hướng dẫn giải:**

1. **Số âm:** -1, -1000000 → Từ chối, không chấp nhận.
2. **Số thập phân:** 1.5 (triệu?) → Làm tròn hay từ chối; thông báo rõ.
3. **Ký tự:** "1abc", " 1000000 " → Validate, không crash.
4. **Số rất lớn:** 999999999999 → Overflow hoặc từ chối, thông báo.
5. **Copy-paste từ Excel:** Số có dấu phẩy (1,000,000) hoặc định dạng ngàn → Parse đúng hoặc từ chối rõ ràng.

Viết 5 test case.

---

### Bài mẫu 8

**Đề bài (chi tiết):** **Kiểm thử thăm dò** cho **Trang chủ** (nhiều widget: banner, sản phẩm hot, tin tức, đăng nhập). Lập 1 charter tập trung vào “tương tác giữa các vùng” và 1 charter “phiên và quyền”.

**Hướng dẫn giải:**

**Charter – Tương tác giữa các vùng:**  
Mục tiêu: Click vào banner/sản phẩm/tin có đúng link không; scroll xuống rồi quay lại trên, dữ liệu có reload sai không; resize trình duyệt, layout có vỡ không.  
Cách: Click lần lượt, kiểm tra URL và nội dung; scroll nhanh/chậm; đổi kích thước cửa sổ. Ghi lỗi link, hiển thị, responsive.

**Charter – Phiên và quyền:**  
Mục tiêu: Chưa đăng nhập / Đã đăng nhập / Đăng xuất; nội dung “chỉ thành viên” có ẩn/hiện đúng không.  
Cách: Đăng nhập, xem trang chủ; đăng xuất (hoặc xóa cookie); refresh, điều hướng. Ghi chỗ còn lộ thông tin hoặc nút không đúng quyền.

---

### Bài mẫu 9

**Đề bài (chi tiết):** **Đoán lỗi** cho **API đăng nhập** (POST username, password). Đề xuất 5 test case (không cần EP/BVA chi tiết).

**Hướng dẫn giải:**

1. **Thiếu body / thiếu field:** POST rỗng; chỉ gửi username → 400, thông báo lỗi rõ.
2. **Content-Type sai:** Gửi JSON nhưng header `application/x-www-form-urlencoded` → 400 hoặc 415.
3. **SQL injection trong JSON:** `{"username":"admin'--","password":"x"}` → Không đăng nhập được, không lỗi 500.
4. **Password quá dài:** Chuỗi 10.000 ký tự → Giới hạn hoặc từ chối, không crash.
5. **Unicode/encoding:** Username "user_日本語" → Xử lý UTF-8 đúng, không lỗi.

Viết 5 test case (Request / Kỳ vọng Response).

---

### Bài mẫu 10

**Đề bài (chi tiết):** Khi nào nên dùng **Đoán lỗi** và khi nào nên dùng **Kiểm thử thăm dò**? Cho 2 tình huống dự án và chọn kỹ thuật phù hợp, giải thích ngắn.

**Hướng dẫn giải:**

- **Đoán lỗi:** Dùng **sau** khi đã áp dụng kỹ thuật chính thức (EP, BVA, DT, …) để bổ sung test case tại những chỗ dễ sai (input đặc biệt, bảo mật, đồng thời, biên). Phù hợp khi đặc tả tương đối rõ, cần phủ thêm “góc khuất”.
- **Kiểm thử thăm dò:** Dùng khi đặc tả **thiếu/không rõ**, hoặc cần **làm quen nhanh** với hệ thống, hoặc **thời gian ít** mà vẫn cần tìm lỗi. Thiết kế và thực thi song song, dùng charter để định hướng.

**Tình huống 1:** Dự án mới, tài liệu sơ sài, cần nhanh biết “hệ thống làm được gì, hỏng chỗ nào” → **Ưu tiên kiểm thử thăm dò** (charter theo tính năng chính).
**Tình huống 2:** Form quan trọng đã test EP/BVA đủ, sắp release, cần bắt lỗi bảo mật và input lạ → **Ưu tiên đoán lỗi** (SQL injection, XSS, biên, phiên).

---

### Bài mẫu 11   
**Đoán lỗi cho ô Số điện thoại**

**Đề bài (chi tiết):**  
Sau khi đã test EP/BVA cho ô **số điện thoại** (10 số, bắt đầu 0), hãy dùng **đoán lỗi** đề xuất thêm ít nhất 5 test case bổ sung (Đầu vào / Thao tác / Kỳ vọng).

**Hướng dẫn giải:**

1. **Copy-paste có khoảng trắng:** "0912 345 678" hoặc " 0912345678 " → Hệ thống trim hay từ chối? Test trim hoặc báo lỗi.
2. **Số bắt đầu +84:** "+84912345678" (format quốc tế) → Chấp nhận hay báo "Chỉ nhập 10 số"?
3. **Số trùng với user khác:** Nhập SĐT đã gắn tài khoản khác khi đăng ký → Thông báo "Số đã được sử dụng".
4. **Paste từ Excel (định dạng số):** Số thành 912345678 (mất số 0 đầu) → Validate đúng 10 số, bắt đầu 0.
5. **Unicode/số đặc biệt:** Số có ký tự Unicode giống số (chữ số Ả Rập, v.v.) → Chỉ chấp nhận 0–9 ASCII.

Viết 5 test case: Đầu vào / Thao tác / Kỳ vọng.

---

### Bài mẫu 12 — Trung bình · Thực tế  
**Đoán lỗi cho chức năng Thanh toán ví**

**Đề bài (chi tiết):**  
Thanh toán bằng **ví nội bộ** (số dư trừ khi thanh toán). Ngoài test chính thức (EP/BVA/DT), hãy dùng **đoán lỗi** đề xuất 5 test case bổ sung (Đầu vào / Thao tác / Kỳ vọng).

**Hướng dẫn giải:**

1. **Hai giao dịch đồng thời:** Cùng lúc trừ tiền (ví dụ 2 tab thanh toán) → Số dư chỉ trừ 1 lần, giao dịch thứ 2 báo không đủ số dư hoặc khóa.
2. **Số tiền đúng bằng số dư:** Ví 100k, thanh toán 100k → Trừ đúng, số dư = 0 (không lỗi làm tròn).
3. **Hủy đơn sau khi đã trừ ví:** Đơn "Đang xử lý" bị hủy → Hoàn tiền vào ví đúng số tiền.
4. **Timeout khi đang xử lý:** Mạng chậm, user refresh/đóng trang sau khi bấm Thanh toán → Trạng thái đơn và số dư nhất quán (không trừ 2 lần).
5. **Số âm / 0:** Nếu có ô nhập số tiền nạp/ví → Nhập -1, 0 → Từ chối.

Viết 5 test case.

---

### Bài mẫu 13 — Trung bình · Phức tạp  
**Charter thăm dò: Màn hình Danh sách + Bộ lọc + Xuất Excel**

**Đề bài (chi tiết):** **Kiểm thử thăm dò** cho màn hình có **danh sách có phân trang**, **bộ lọc** (ngày, trạng thái, từ khóa), và nút **Xuất Excel**. Lập 2 charter và mô tả ngắn cách thực hiện.

**Hướng dẫn giải:**

**Charter 1 – Bộ lọc và kết quả:**  
Mục tiêu: Kiểm tra lọc theo từng trường và kết hợp nhiều trường cho đúng kết quả; xóa từng bộ lọc thì danh sách cập nhật đúng.  
Cách: Chọn lọc "Tháng 1/2024" → Xem số bản ghi; thêm lọc "Trạng thái: Đã duyệt"; đổi "Tháng 2" → Kiểm tra danh sách thay đổi; xóa lọc trạng thái → Chỉ còn lọc tháng. Ghi lỗi (sai số liệu, lọc không áp dụng).

**Charter 2 – Xuất Excel và phân trang:**  
Mục tiêu: Xuất Excel đúng dữ liệu đang xem (trang hiện tại vs toàn bộ); không bị giới hạn số dòng sai.  
Cách: Ở trang 1, xuất Excel → Mở file, đối chiếu với 10 dòng trên màn hình. Chuyển trang 2, xuất → Đối chiếu. Lọc "Trạng thái A", xuất → File chỉ chứa bản ghi trạng thái A. Ghi lỗi (thiếu cột, sai encoding, số dòng).

---

### Bài mẫu 14 — Trung bình · Thực tế  
**Đoán lỗi cho Form đăng ký hội viên (nhiều trường)**

**Đề bài (chi tiết):** Form có: Họ tên, Email, SĐT, Ngày sinh, Địa chỉ. **Đoán lỗi** đề xuất 5 điểm dễ lỗi và test case.

**Hướng dẫn giải:**

1. **Họ tên chỉ có khoảng trắng hoặc ký tự đặc biệt:** "   ", "@@@" → Validate, từ chối hoặc trim.
2. **Email trùng:** Đăng ký email đã có → "Email đã được sử dụng", không leak thông tin.
3. **Ngày sinh tương lai:** Chọn năm 2030 → Từ chối hoặc cảnh báo.
4. **Địa chỉ quá dài (500+ ký tự):** Cắt hoặc giới hạn, không crash, lưu đủ hoặc báo lỗi.
5. **Submit nhiều lần nhanh:** Double-click "Đăng ký" → Chỉ tạo 1 hồ sơ, nút disable hoặc chặn trùng.

Viết 5 test case.

---

### Bài mẫu 15 — Khó · Thực tế  
**Đoán lỗi cho API tra cứu đơn hàng (GET)**

**Đề bài (chi tiết):** API GET `/orders/{id}` trả thông tin đơn. **Đoán lỗi** đề xuất 5 test case (không cần EP/BVA chi tiết).

**Hướng dẫn giải:**

1. **id không tồn tại:** GET `/orders/999999` → 404, không lộ cấu trúc DB.
2. **id thuộc user khác:** Token user A, GET đơn của user B → 403 hoặc 404.
3. **id không phải số:** GET `/orders/abc` hoặc `/orders/1;DROP TABLE` → 400, không SQL injection.
4. **id âm / 0:** GET `/orders/-1`, `/orders/0` → 400 hoặc 404.
5. **Thiếu token / token hết hạn:** Không gửi Authorization hoặc token sai → 401.

Viết 5 test case (Request / Kỳ vọng Response).

---

### Bài mẫu 16 — Khó · Phức tạp  
**Charter thăm dò: Luồng Mua hàng từ Giỏ → Thanh toán → Đơn hàng**

**Đề bài (chi tiết):** Lập 2 charter: một cho **luồng vui** (nhiều SP, nhiều hình thức thanh toán); một cho **luồng lỗi và rollback** (hết hàng giữa chừng, thanh toán thất bại, hủy đơn).

**Hướng dẫn giải:**

**Charter 1 – Luồng vui và biến thể:**  
Mục tiêu: Mua 1 SP, nhiều SP, 1 SP số lượng > 1; đổi địa chỉ, mã giảm giá; thanh toán COD vs Ví vs Thẻ. Mỗi bước tổng tiền, phí ship, giảm giá đúng.  
Cách: Thực hiện từng biến thể, ghi từng bước, chụp màn hình. Ghi lỗi tính toán, hiển thị sai.

**Charter 2 – Lỗi và rollback:**  
Mục tiêu: Trong giỏ có SP vừa hết hàng; thanh toán ví thất bại rồi chuyển COD; hủy đơn sau khi đặt. Kiểm tra giỏ, số dư ví, trạng thái đơn nhất quán.  
Cách: Tạo tình huống hết hàng (hoặc mock), thanh toán thất bại, hủy đơn. Kiểm tra không trừ tiền 2 lần, giỏ cập nhật đúng.

---

### Bài mẫu 17 — Trung bình · Thực tế  
**Đoán lỗi cho Chức năng Gửi OTP**

**Đề bài (chi tiết):** Gửi OTP qua SMS/Email để xác thực. **Đoán lỗi** đề xuất 5 test case.

**Hướng dẫn giải:**

1. **Gửi OTP liên tục (spam):** Bấm "Gửi lại" 10 lần trong 1 phút → Giới hạn (ví dụ 1 lần/60s), không gửi tràn.
2. **SĐT/Email không tồn tại:** Nhập SĐT chưa đăng ký → Thông báo "Không tìm thấy" hoặc "Đã gửi" (không tiết lộ có tồn tại hay không, tùy bảo mật).
3. **OTP hết hạn:** Đợi quá 3 phút (hoặc thời hạn quy định) rồi nhập OTP → "Mã hết hạn", có nút "Gửi lại".
4. **Nhập sai OTP 5 lần:** Khóa 15 phút hoặc yêu cầu gửi lại OTP mới.
5. **Copy-paste OTP có khoảng trắng:** " 123456 " → Trim và chấp nhận nếu đúng.

Viết 5 test case.

---

### Bài mẫu 18 — Khó · Thực tế  
**Charter thăm dò: Trang Admin (quản lý user + phân quyền)**

**Đề bài (chi tiết):** Trang admin: **Danh sách user**, **Tìm kiếm**, **Khóa/Mở user**, **Phân quyền**. Lập 1 charter "Phân quyền và truy cập" và 1 "Tìm kiếm và thao tác hàng loạt".

**Hướng dẫn giải:**

**Charter – Phân quyền và truy cập:**  
Mục tiêu: User không phải admin không vào được; Admin đăng xuất rồi bấm Back không thấy dữ liệu nhạy cảm; Đổi quyền user (từ Member sang Admin) thì user đó thấy menu mới sau khi đăng nhập lại.  
Cách: Đăng nhập user thường, truy cập URL admin → 403/redirect. Đăng nhập admin, đổi quyền user A, đăng nhập user A → Kiểm tra menu. Ghi lỗi phân quyền.

**Charter – Tìm kiếm và thao tác hàng loạt:**  
Mục tiêu: Tìm user theo email/tên; chọn nhiều user → Khóa hàng loạt; bỏ chọn, chọn lại; kiểm tra danh sách cập nhật đúng.  
Cách: Tìm "nguyen", chọn 3 user, Khóa → 3 user chuyển trạng thái Khóa; Tìm "trần", chọn 1, Mở khóa. Ghi lỗi (khóa sai user, tìm không ra).

---

### Bài mẫu 19 — Khó · Phức tạp  
**Đoán lỗi cho Báo cáo động (chọn kỳ, loại, xuất PDF/Excel)**

**Đề bài (chi tiết):** Chức năng **báo cáo**: Chọn kỳ (tháng/năm), loại báo cáo, bấm Xem/Xuất PDF/Excel. **Đoán lỗi** đề xuất 5 test case.

**Hướng dẫn giải:**

1. **Kỳ chưa có dữ liệu:** Chọn tháng tương lai hoặc kỳ mới → "Không có dữ liệu" hoặc báo cáo rỗng, không lỗi 500.
2. **Xuất Excel khi > 100.000 dòng:** Giới hạn hoặc chia trang, không treo, không file hỏng.
3. **Ký tự đặc biệt trong tên chi nhánh:** Tên có &, <, > → PDF/Excel không vỡ, không XSS.
4. **Hai tab cùng xuất PDF:** User mở 2 tab, cùng lúc bấm Xuất PDF → Cả hai đều nhận file đúng hoặc có queue.
5. **Đổi kỳ khi đang tạo PDF:** Đang tạo PDF cho tháng 1, đổi sang tháng 2 trước khi tải xong → File tải về thuộc kỳ nào (nhất quán).

Viết 5 test case.

---

### Bài mẫu 20 — Khó · Thực tế  
**Khi nào dùng Đoán lỗi vs Thăm dò (2 tình huống dự án)**

**Đề bài (chi tiết):** Cho 2 tình huống: (1) Dự án legacy, đặc tả thiếu, cần nhanh đánh giá chất lượng; (2) Module thanh toán mới, đã test EP/BVA/DT đủ, sắp release. Chọn kỹ thuật phù hợp (Đoán lỗi / Kiểm thử thăm dò) và giải thích ngắn.

**Hướng dẫn giải:**

- **Tình huống 1 – Legacy, đặc tả thiếu:**  
  **Ưu tiên Kiểm thử thăm dò.** Lý do: Đặc tả không đủ để viết test case chính thức; cần làm quen nhanh với hệ thống, khám phá chức năng và tìm lỗi theo charter (theo tính năng, luồng). Kết quả: Danh sách lỗi + ghi chú hành vi hệ thống để bổ sung đặc tả/test case sau.

- **Tình huống 2 – Module thanh toán, đã test đủ, sắp release:**  
  **Ưu tiên Đoán lỗi.** Lý do: Đã có bộ test EP/BVA/DT; cần bắt thêm lỗi tại "góc khuất": giao dịch đồng thời, timeout, rollback, số âm, overflow, bảo mật (replay, token). Đoán lỗi bổ sung test case cho các tình huống dễ sai mà test chính thức chưa phủ.

---



## PHẦN 2: BÀI TẬP TỰ LUYỆN

### Bài 1
Cho form **Tìm kiếm** (ô tìm, bộ lọc theo danh mục, khoảng giá). Dùng **đoán lỗi** đề xuất 5 test case bổ sung sau EP/BVA.

### Bài 2
**Kiểm thử thăm dò** cho màn hình **Chi tiết sản phẩm** (ảnh, giá, mô tả, nút Thêm giỏ, đánh giá). Lập 2 charter và mô tả ngắn cách thực hiện.

### Bài 3
Chức năng **Gửi email** (quên mật khẩu / xác thực). Dùng **đoán lỗi** đề xuất 5 test case (email không tồn tại, spam, link hết hạn, …).

### Bài 4
**Kiểm thử thăm dò** cho **Danh sách user** (admin): lọc, tìm, sắp xếp, khóa/mở user. Lập 1 charter cho “thao tác hàng loạt” và 1 cho “quyền và phân quyền”.

### Bài 5
Ô nhập **Ngày sinh** (date picker). **Đoán lỗi** đề xuất 5 test case (ngày không hợp lệ, tương lai, năm nhuận, định dạng khác nhau, …).

### Bài 6
Luồng **Đặt vé xem phim**: chọn suất, ghế, thanh toán. Lập 2 charter thăm dò: một cho “ghế và đồng thời”, một cho “hủy và hoàn tiền”.

### Bài 7
**Đoán lỗi** cho **Đăng xuất**: đăng xuất nhiều tab; đăng xuất rồi bấm Back; link cũ sau khi đăng xuất. Đề xuất 5 test case.

### Bài 8
**Kiểm thử thăm dò** cho **Trang cá nhân** (xem/sửa thông tin, đổi ảnh đại diện, đổi mật khẩu). Lập 1 charter “sửa thông tin và validate” và 1 “ảnh đại diện (kích thước, định dạng)”.

### Bài 9
Chức năng **In hóa đơn** (PDF). **Đoán lỗi** đề xuất 5 test case (đơn rất dài, ký tự đặc biệt trong tên SP, font Unicode, in hai lần liên tiếp, …).

### Bài 10
So sánh **Đoán lỗi** và **Kiểm thử thăm dò**: điểm giống, khác; mỗi kỹ thuật cho 1 ví dụ tình huống dự án phù hợp (mô tả ngắn).

---

### Bài 11 
Sau EP/BVA cho ô **Mật khẩu** (8–32 ký tự), **đoán lỗi** đề xuất 5 test case (copy-paste, khoảng trắng, Unicode, 2 tab đổi mật khẩu cùng lúc, …).

### Bài 12 — Trung bình · Thực tế
**Đoán lỗi** cho chức năng **In phiếu thu/chi** (PDF): số tiền rất lớn, ký tự đặc biệt trong "Diễn giải", in 2 lần liên tiếp.

### Bài 13 — Trung bình · Phức tạp
**Charter thăm dò** cho màn hình **Báo cáo doanh thu** (chọn kỳ, so sánh kỳ, biểu đồ + bảng). Lập 2 charter: một cho "Dữ liệu và biểu đồ", một cho "Xuất và in".

### Bài 14 — Trung bình · Thực tế
**Đoán lỗi** cho **Đặt lại mật khẩu qua email**: link hết hạn, link đã dùng, email không tồn tại, spam "Gửi lại link".

### Bài 15 — Khó · Thực tế
**Đoán lỗi** cho **API tạo đơn hàng** (POST): thiếu field bắt buộc, số lượng âm, product_id không tồn tại, trùng request (idempotency).

### Bài 16 — Khó · Phức tạp
**Charter thăm dò** cho **Ứng dụng mobile** đăng nhập + xem thông tin + push notification. Lập 2 charter: một cho "Đăng nhập và phiên", một cho "Notification khi app background/foreground".

### Bài 17 — Trung bình · Thực tế
**Đoán lỗi** cho **Chọn ngày/giờ** (date/time picker): ngày quá khứ, giờ ngoài khung, múi giờ, DST (nếu có).

### Bài 18 — Khó · Thực tế
**Charter thăm dò** cho **Form nhiều bước** (wizard): đi tới/lùi, bỏ dở giữa chừng, refresh trang, đổi dữ liệu bước trước khi đã sang bước sau.

### Bài 19 — Khó · Phức tạp
**Đoán lỗi** cho **Tính năng đồng bộ dữ liệu** (sync): mất mạng giữa chừng, xung đột phiên bản, dữ liệu rất lớn.

### Bài 20 — Khó · Thực tế
So sánh **Error guessing** và **Exploratory testing** bằng bảng (Mục đích / Khi nào dùng / Ai thực hiện / Đầu ra). Cho 1 ví dụ dự án phù hợp với từng kỹ thuật.

---

*Hết phần Kiểm thử dựa trên kinh nghiệm.*
