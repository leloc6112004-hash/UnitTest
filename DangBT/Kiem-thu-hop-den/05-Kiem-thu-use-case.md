# Bài tập: Kiểm thử dựa trên lược đồ Use Case

**Chương: Kiểm thử hộp đen**  
**Cấu trúc:** 2 phần — **Bài tập mẫu** (20 bài) và **Bài tập tự luyện** (20 bài).

---

## Quy trình chuẩn — Kiểm thử Use Case

Làm bài theo **4 bước** sau (xem thêm *HUONG-DAN-CHUNG.md*):

1. **Đọc đặc tả use case** — Tách: Tiền điều kiện, Luồng chính (main), Luồng thay thế (alternative), Luồng ngoại lệ (exception).
2. **Test case cho luồng chính** — Ít nhất 1 TC: thực hiện đủ bước main → kết quả thành công.
3. **Test case cho từng luồng thay thế / ngoại lệ** — Mỗi nhánh ≥ 1 TC; tạo điều kiện để đi vào nhánh đó.
4. **Test biên (nếu cần)** — Kết hợp EP/BVA cho đầu vào trong use case.

**Lưu ý:** TC ghi rõ: Luồng | Điều kiện/Dữ liệu | Thao tác | Kỳ vọng (output, trạng thái).

---

## PHẦN 1: BÀI TẬP MẪU

### Bài mẫu 1

**Đề bài:** Use case **Đăng nhập**: Tiền điều kiện – hệ thống mở. Luồng chính: (1) User nhập username, password; (2) Hệ thống kiểm tra; (3) Nếu đúng → vào trang chủ. Luồng thay thế 3a: Sai mật khẩu → thông báo, quay lại bước 1. Luồng ngoại lệ 3b: Tài khoản bị khóa → thông báo. Thiết kế test case từ use case này.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính (happy path):**
- TC01 – Đăng nhập thành công: Nhập username + password hợp lệ → Kỳ vọng: chuyển vào trang chủ.

**Bước 2 – Test case cho luồng thay thế:**
- TC02 – Sai mật khẩu: Username đúng, password sai → Kỳ vọng: thông báo lỗi, ở lại màn hình đăng nhập, có thể nhập lại.
- TC03 – Sai username: Username không tồn tại → Kỳ vọng: thông báo (username/password sai, không tiết lộ “sai username” nếu bảo mật).

**Bước 3 – Test case cho luồng ngoại lệ:**
- TC04 – Tài khoản khóa: Username + password đúng nhưng tài khoản bị khóa → Kỳ vọng: thông báo tài khoản bị khóa, không vào hệ thống.

**Bước 4 – Biên và đặc biệt:**
- TC05 – Để trống username hoặc password → thông báo nhập đủ.
- TC06 – Ký tự đặc biệt, SQL injection trong username/password → xử lý an toàn, không lỗi.

---

### Bài mẫu 2

**Đề bài:** Use case **Đặt mượn sách** (thư viện): Luồng chính: (1) Đọc giả đăng nhập; (2) Tìm sách; (3) Chọn “Mượn”; (4) Hệ thống kiểm tra (chưa vượt 5 quyển/lần, đã trả đủ); (5) Xác nhận mượn. Thay thế 4a: Đã mượn 5 quyển → thông báo. 4b: Còn sách chưa trả → thông báo. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** Đăng nhập → Tìm sách có sẵn → Mượn; đã trả hết, đang mượn < 5 → Kỳ vọng: mượn thành công.
- **TC02 (4a):** Đã mượn đủ 5 quyển → Mượn thêm → Kỳ vọng: thông báo không được mượn thêm.
- **TC03 (4b):** Còn sách quá hạn chưa trả → Mượn → Kỳ vọng: thông báo trả sách trước.
- **TC04:** Sách hết bản → Bấm Mượn → Thông báo hết sách hoặc đặt trước (tùy đặc tả).
- **TC05:** Chưa đăng nhập → Truy cập trực tiếp trang mượn → Chuyển về đăng nhập.

---

### Bài mẫu 3

**Đề bài:** Use case **Thanh toán giỏ hàng**: Luồng chính: Chọn địa chỉ, phương thức thanh toán (COD/Chuyển khoản/Ví), Xác nhận → Tạo đơn. Thay thế: Hết hàng một món → thông báo, cập nhật giỏ. Ngoại lệ: Ví không đủ số dư → thông báo. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** Giỏ có hàng, địa chỉ và PT thanh toán hợp lệ → Thanh toán → Đơn tạo, giỏ trống (hoặc theo đặc tả).
- **TC02 (Thay thế):** Một món trong giỏ vừa hết hàng → Thanh toán → Thông báo, giỏ cập nhật (bỏ món hoặc giảm số lượng).
- **TC03 (Ngoại lệ):** Chọn Ví, số dư < tổng đơn → Xác nhận → Thông báo không đủ số dư, không tạo đơn.
- **TC04:** Giỏ trống → Bấm Thanh toán → Thông báo hoặc chặn.
- **TC05:** Chọn COD → Đơn tạo thành công; Chọn Chuyển khoản → Hiển thị thông tin chuyển khoản, đơn trạng thái “Chờ thanh toán”.

---

### Bài mẫu 4

**Đề bài:** Use case **Đăng ký tài khoản**: Luồng chính: Nhập email, mật khẩu, xác nhận mật khẩu, bấm Đăng ký → Gửi email kích hoạt. User bấm link → Kích hoạt xong. Thay thế: Email đã tồn tại → thông báo. Mật khẩu không khớp → thông báo. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** Email mới, mật khẩu hợp lệ, khớp xác nhận → Đăng ký → Email gửi; bấm link → Tài khoản kích hoạt.
- **TC02:** Email đã đăng ký → Thông báo “Email đã được sử dụng”.
- **TC03:** Mật khẩu ≠ Xác nhận mật khẩu → Thông báo, không gửi email.
- **TC04:** Mật khẩu không đủ mạnh (theo quy định) → Thông báo.
- **TC05:** Link kích hoạt hết hạn hoặc đã dùng → Thông báo, có thể gửi lại link.

---

### Bài mẫu 5

**Đề bài:** Use case **Đặt phòng khách sạn**: Luồng chính: Chọn ngày đến/đi, loại phòng, số khách → Kiểm tra phòng trống → Hiển thị giá → Xác nhận → Đặt cọc → Tạo đặt phòng. Thay thế: Không còn phòng → Gợi ý ngày/loại phòng khác. Ngoại lệ: Thanh toán cọc thất bại → Giữ đặt phòng 15 phút, sau đó hủy. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** Ngày đến/đi hợp lệ, có phòng, số khách OK → Đặt → Cọc thành công → Có mã đặt phòng.
- **TC02 (Thay thế):** Không còn phòng cho ngày đã chọn → Thông báo + gợi ý.
- **TC03 (Ngoại lệ):** Sau bước “Xác nhận”, thanh toán cọc lỗi → Thông báo; sau 15 phút không thanh toán → Đặt phòng tự hủy (hoặc trạng thái “Hết hạn”).
- **TC04:** Ngày đi ≤ ngày đến → Thông báo không hợp lệ.
- **TC05:** Số khách vượt sức chứa phòng → Cảnh báo hoặc từ chối.

---

### Bài mẫu 6

**Đề bài:** Use case **Nộp bài tập** (LMS): Luồng chính: Vào bài tập → Đính kèm file / nhập nội dung → Nộp trước hạn → Thành công. Thay thế: Nộp sau hạn → Chấp nhận nhưng đánh dấu trễ (hoặc từ chối tùy quy định). Ngoại lệ: File vượt dung lượng → Thông báo. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** File đúng định dạng, dung lượng OK, trước hạn → Nộp thành công.
- **TC02 (Thay thế):** Sau hạn nộp → Nộp được nhưng đánh dấu “Trễ” hoặc bị từ chối.
- **TC03 (Ngoại lệ):** File > dung lượng tối đa → Thông báo, không upload.
- **TC04:** Định dạng file không cho phép → Thông báo.
- **TC05:** Đã nộp rồi, nộp lại (nếu cho phép) → Ghi đè hoặc phiên bản mới; nếu không cho phép → Thông báo.

---

### Bài mẫu 7

**Đề bài:** Use case **Yêu cầu hoàn tiền**: Luồng chính: Chọn đơn trong 7 ngày, chưa dùng, bấm Hoàn tiền → Nhập lý do → Gửi → Duyệt (tự động hoặc thủ công) → Hoàn tiền. Thay thế: Quá 7 ngày → Chỉ đổi hàng. Ngoại lệ: Đơn đã dùng → Từ chối. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** Đơn trong 7 ngày, chưa dùng → Yêu cầu hoàn tiền → Duyệt → Hoàn tiền thành công.
- **TC02 (Thay thế):** Đơn quá 7 ngày → Chỉ hiển thị “Đổi hàng” hoặc từ chối hoàn tiền.
- **TC03 (Ngoại lệ):** Đơn đã đánh dấu “Đã sử dụng” → Không cho hoàn tiền hoặc thông báo từ chối.
- **TC04:** Đơn không thuộc user hiện tại → Không thấy / không gửi được.
- **TC05:** Đơn đã hoàn tiền rồi → Không gửi yêu cầu lại.

---

### Bài mẫu 8

**Đề bài:** Use case **Tạo báo cáo**: Luồng chính: Chọn kỳ báo cáo, loại báo cáo → Xem trước → Xuất (PDF/Excel). Thay thế: Không có dữ liệu kỳ đó → Thông báo. Ngoại lệ: Lỗi server → Thông báo, ghi log. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** Kỳ có dữ liệu, chọn loại báo cáo → Xem trước OK → Xuất PDF/Excel thành công.
- **TC02 (Thay thế):** Kỳ không có dữ liệu → Xem trước / Xuất → Thông báo “Không có dữ liệu”.
- **TC03 (Ngoại lệ):** Giả lập lỗi server khi xuất → Thông báo lỗi, không crash.
- **TC04:** Quyền user không được xem loại báo cáo đó → Ẩn hoặc từ chối.
- **TC05:** Kỳ báo cáo ở tương lai (nếu không hợp lệ) → Thông báo hoặc chặn.

---

### Bài mẫu 9

**Đề bài:** Use case **Đổi mật khẩu** (đã đăng nhập): Luồng chính: Nhập mật khẩu hiện tại, mật khẩu mới, xác nhận mật khẩu mới → Xác nhận → Đổi xong, đăng xuất (hoặc giữ phiên). Thay thế: Mật khẩu hiện tại sai → Thông báo. Ngoại lệ: Mật khẩu mới trùng mật khẩu cũ → Thông báo. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** Mật khẩu hiện tại đúng, mật khẩu mới hợp lệ và khớp → Đổi thành công.
- **TC02 (Thay thế):** Mật khẩu hiện tại sai → Thông báo, không đổi.
- **TC03 (Ngoại lệ):** Mật khẩu mới = mật khẩu hiện tại → Thông báo “Phải khác mật khẩu cũ”.
- **TC04:** Mật khẩu mới không đủ mạnh → Thông báo.
- **TC05:** Mật khẩu mới ≠ Xác nhận → Thông báo.

---

### Bài mẫu 10

**Đề bài:** Use case **Gửi tin nhắn nội bộ**: Luồng chính: Chọn người nhận, nhập nội dung (1–1000 ký tự) → Gửi → Tin vào hộp thư người nhận. Thay thế: Người nhận đã chặn user → Thông báo. Ngoại lệ: Nội dung rỗng hoặc > 1000 ký tự → Thông báo. Thiết kế test case.

**Hướng dẫn giải:**

- **TC01 (Main):** Người nhận hợp lệ, nội dung 1–1000 ký tự → Gửi thành công, tin xuất hiện ở hộp người nhận.
- **TC02 (Thay thế):** Người nhận đã chặn user gửi → Thông báo “Không thể gửi”.
- **TC03 (Ngoại lệ):** Nội dung rỗng → Thông báo, không gửi.
- **TC04 (Ngoại lệ):** Nội dung > 1000 ký tự → Thông báo hoặc cắt, tùy đặc tả.
- **TC05:** Gửi cho nhiều người (nếu có) → Tất cả đều nhận được.

---

### Bài mẫu 11   
**Use case Tìm kiếm sản phẩm**

**Đề bài (chi tiết):**  
- **Luồng chính:** User nhập từ khóa → Bấm Tìm → Hiển thị danh sách kết quả.  
- **Luồng thay thế:** Không có kết quả → Thông báo "Không tìm thấy".  
- **Luồng ngoại lệ:** Từ khóa rỗng → Không gửi request hoặc thông báo.  

Hãy thiết kế test case từ use case này.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính (happy path):**  
- **TC01 (Main):** Nhập "áo thun" → Bấm Tìm → Có kết quả → Hiển thị danh sách.

**Bước 2 – Test case cho luồng thay thế:**  
- **TC02 (Thay thế):** Nhập "xyzkkhôngtồntại" → Không có kết quả → Thông báo "Không tìm thấy".

**Bước 3 – Test case cho luồng ngoại lệ:**  
- **TC03 (Ngoại lệ):** Để trống, bấm Tìm → Thông báo hoặc không gửi request.

**Bước 4 – Biên và đặc biệt:**  
- **TC04:** Từ khóa có ký tự đặc biệt (%, <, >) → Xử lý an toàn, không lỗi.  
- **TC05:** Từ khóa rất dài (500 ký tự) → Giới hạn hoặc cắt, không crash.

---

### Bài mẫu 12 — Trung bình · Thực tế  
**Use case Đặt bàn nhà hàng**

**Đề bài (chi tiết):**  
- **Luồng chính:** Chọn ngày, giờ, số khách → Kiểm tra bàn trống → Xác nhận → Tạo đặt bàn, có mã.  
- **Luồng thay thế:** Không còn bàn → Gợi ý giờ/ngày khác.  
- **Luồng ngoại lệ:** Số khách vượt sức chứa bàn lớn nhất → Thông báo hoặc chặn.  

Hãy thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** Ngày/giờ có bàn, số khách 4 → Đặt thành công, có mã đặt bàn.

**Bước 2 – Test case cho luồng thay thế:**  
- **TC02 (Thay thế):** Ngày/giờ hết bàn → Thông báo + gợi ý giờ/ngày khác.

**Bước 3 – Test case cho luồng ngoại lệ:**  
- **TC03 (Ngoại lệ):** Số khách 50 (vượt bàn lớn nhất 20) → Thông báo hoặc chặn.

**Bước 4 – Biên và đặc biệt:**  
- **TC04:** Ngày trong quá khứ → Không chọn được hoặc thông báo.  
- **TC05:** Giờ ngoài giờ mở cửa → Không chọn được hoặc thông báo.

---

### Bài mẫu 13 — Trung bình · Phức tạp  
**Use case Rút tiền ATM (đa bước + ngoại lệ)**

**Đề bài (chi tiết):**  
- **Luồng chính:** Đưa thẻ → Nhập PIN → Chọn Rút tiền → Nhập số tiền → Máy trả tiền → In biên lai (tùy chọn) → Lấy thẻ. Thay thế: Số dư không đủ → Thông báo. PIN sai 3 lần → Giữ thẻ. Ngoại lệ: Số tiền vượt hạn mức/lần → Thông báo. Thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** PIN đúng, số tiền ≤ số dư và ≤ hạn mức → Rút thành công, trừ tiền, in biên lai (nếu chọn).
- **TC02 (Thay thế):** Số tiền > số dư → Thông báo "Số dư không đủ".
- **TC03 (Thay thế):** PIN sai lần 1, 2 → Thông báo; lần 3 → Giữ thẻ.
- **TC04 (Ngoại lệ):** Số tiền > hạn mức/lần → Thông báo.
- **TC05:** Bấm Hủy ở bước Nhập số tiền → Trở về menu, không trừ tiền.

---

### Bài mẫu 14 — Trung bình · Thực tế  
**Use case Đổi/trả hàng (trong 7 ngày, còn tem)**

**Đề bài (chi tiết):**  
- **Luồng chính:** Chọn đơn trong 7 ngày, chưa dùng, còn tem → Chọn Đổi/Trả → Nhập lý do → Gửi → Duyệt → Hoàn tiền/Đổi hàng. Thay thế: Quá 7 ngày → Chỉ đổi hàng (không hoàn tiền) hoặc từ chối. Ngoại lệ: Đơn đã đánh dấu "Đã sử dụng" → Từ chối. Thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** Đơn trong 7 ngày, chưa dùng, còn tem → Yêu cầu trả → Duyệt → Hoàn tiền.
- **TC02 (Thay thế):** Đơn quá 7 ngày → Chỉ hiển thị "Đổi hàng" hoặc từ chối hoàn tiền.
- **TC03 (Ngoại lệ):** Đơn đã "Đã sử dụng" → Từ chối.
- **TC04:** Đơn không thuộc user → Không thấy hoặc không gửi được.
- **TC05:** Đơn đã hoàn tiền rồi → Không gửi yêu cầu lại.

---

### Bài mẫu 15 — Khó · Thực tế  
**Use case Phê duyệt đơn vay (nhiều cấp)**

**Đề bài (chi tiết):**  
- **Luồng chính:** Khách gửi đơn vay → Nhân viên kiểm tra hồ sơ → (Đủ điều kiện) Chuyển trưởng phòng → Trưởng phòng duyệt/Không duyệt → (Duyệt) Chuyển giám đốc → Giám đốc duyệt/Không duyệt → Ký hợp đồng. Thay thế: Hồ sơ thiếu → Yêu cầu bổ sung. Ngoại lệ: Số tiền vượt thẩm quyền → Chuyển cấp cao hơn. Thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** Hồ sơ đủ, trưởng phòng duyệt, giám đốc duyệt → Hợp đồng ký.
- **TC02 (Thay thế):** Hồ sơ thiếu → Thông báo bổ sung, đơn ở trạng thái "Chờ bổ sung".
- **TC03 (Thay thế):** Trưởng phòng không duyệt → Đơn từ chối, thông báo khách.
- **TC04 (Ngoại lệ):** Số tiền vượt thẩm quyền TP → Tự chuyển lên GĐ.
- **TC05:** Khách hủy đơn khi đang "Chờ duyệt" → Đơn đóng, không xử lý tiếp.

---

### Bài mẫu 16 — Khó · Phức tạp  
**Use case Đăng ký thi (nhiều điều kiện + thanh toán)**

**Đề bài (chi tiết):**  
- **Luồng chính:** Chọn kỳ thi → Kiểm tra điều kiện (tuổi, bằng cấp trước) → Điền form → Upload ảnh, CMND → Thanh toán → Nhận mã dự thi. Thay thế: Không đủ điều kiện → Thông báo từng mục. Thanh toán thất bại → Giữ form 24h, nhắc thanh toán. Ngoại lệ: Kỳ thi hết chỗ → Thông báo. Thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** Đủ điều kiện, form đúng, thanh toán thành công → Mã dự thi, email xác nhận.
- **TC02 (Thay thế):** Thiếu bằng cấp trước → Thông báo "Chưa đủ điều kiện: bằng cấp".
- **TC03 (Thay thế):** Thanh toán lỗi → Thông báo, form vẫn lưu; sau 24h nhắc.
- **TC04 (Ngoại lệ):** Kỳ thi đã đủ chỗ → "Hết chỗ", không cho thanh toán.
- **TC05:** Upload file không phải ảnh/CMND → Thông báo định dạng.

---

### Bài mẫu 17 — Trung bình · Thực tế  
**Use case Gửi phản hồi/liên hệ**

**Đề bài (chi tiết):**  
- **Luồng chính:** Nhập họ tên, email, nội dung (bắt buộc, 10–500 ký tự) → Gửi → Thông báo "Đã gửi". Thay thế: Nội dung < 10 ký tự → Thông báo. Ngoại lệ: Email không đúng định dạng → Thông báo. Thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** Họ tên, email hợp lệ, nội dung 50 ký tự → Gửi thành công, thông báo.
- **TC02 (Thay thế):** Nội dung 5 ký tự → "Tối thiểu 10 ký tự".
- **TC03 (Ngoại lệ):** Email "abc" (không @) → Thông báo định dạng email.
- **TC04:** Nội dung 501 ký tự → Cắt hoặc thông báo giới hạn.
- **TC05:** Rỗng họ tên hoặc email → Không gửi, highlight trường lỗi.

---

### Bài mẫu 18 — Khó · Thực tế  
**Use case Đặt lịch tiêm vắc xin**

**Đề bài (chi tiết):**  
- **Luồng chính:** Chọn loại vắc xin, cơ sở y tế, ngày/giờ → Kiểm tra còn slot → Nhập thông tin cá nhân → Xác nhận → Mã đặt lịch. Thay thế: Hết slot → Gợi ý ngày/giờ khác. Ngoại lệ: Chưa đủ tuổi/đủ mũi trước (theo loại vắc xin) → Thông báo. Thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** Loại vắc xin có slot, thông tin đủ, đủ điều kiện tuổi/mũi → Đặt thành công, mã đặt lịch.
- **TC02 (Thay thế):** Ngày đã chọn hết slot → "Hết chỗ", gợi ý ngày khác.
- **TC03 (Ngoại lệ):** Loại vắc xin yêu cầu 18+, user nhập tuổi 15 → Thông báo không đủ tuổi.
- **TC04:** Trùng lịch đã đặt trước đó (cùng user, cùng ngày) → Cảnh báo hoặc chặn.
- **TC05:** Chọn ngày trong quá khứ → Không chọn được hoặc thông báo.

---

### Bài mẫu 19 — Khó · Phức tạp  
**Use case Nộp báo cáo định kỳ (có deadline + đính kèm)**

**Đề bài (chi tiết):**  
- **Luồng chính:** Chọn kỳ báo cáo → Điền form, đính kèm file (bắt buộc, PDF, max 10MB) → Nộp trước deadline → Thành công. Thay thế: Nộp sau deadline → Chấp nhận nhưng đánh dấu "Nộp trễ". Ngoại lệ: File > 10MB hoặc không PDF → Thông báo. Thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** Kỳ có deadline còn hạn, file PDF 5MB, form đủ → Nộp thành công.
- **TC02 (Thay thế):** Nộp sau deadline → Nộp được, trạng thái "Nộp trễ".
- **TC03 (Ngoại lệ):** File 15MB → "Vượt dung lượng 10MB".
- **TC04 (Ngoại lệ):** File .docx → "Chỉ chấp nhận PDF".
- **TC05:** Đã nộp rồi cho kỳ đó → Không cho nộp lại hoặc cho nộp đè (tùy đặc tả).

---

### Bài mẫu 20 — Khó · Thực tế  
**Use case Yêu cầu cấp chứng nhận (sau khi hoàn thành khóa)**

**Đề bài (chi tiết):**  
- **Luồng chính:** User đã hoàn thành khóa (≥80% bài, điểm TB ≥5) → Vào "Chứng nhận" → Chọn giao hàng (in sẵn / gửi PDF) → (Nếu in) Nhập địa chỉ, thanh toán phí in → Xác nhận → Nhận chứng nhận. Thay thế: Chưa đủ điều kiện → Thông báo "Chưa hoàn thành khóa". Ngoại lệ: Hết phí in → Thông báo, chỉ gửi PDF. Thiết kế test case.

**Hướng dẫn giải:**

**Bước 1 – Test case cho luồng chính:**  
- **TC01 (Main):** Đủ điều kiện, chọn in, địa chỉ hợp lệ, thanh toán OK → Xác nhận gửi chứng nhận bản cứng.
- **TC02 (Thay thế):** Chưa đủ 80% hoặc điểm TB < 5 → "Chưa đủ điều kiện cấp chứng nhận".
- **TC03 (Ngoại lệ):** Chọn in nhưng không thanh toán phí (bỏ dở) → Chỉ gửi PDF hoặc nhắc thanh toán.
- **TC04:** Chọn chỉ PDF → Gửi email PDF ngay, không thu phí.
- **TC05:** User chưa đăng nhập / chưa học khóa này → Không thấy nút "Chứng nhận" hoặc chuyển đăng nhập.

---



## PHẦN 2: BÀI TẬP TỰ LUYỆN

### Bài 1
Use case **Quên mật khẩu**: Nhập email → Gửi link đặt lại → User bấm link → Nhập mật khẩu mới → Hoàn tất. Viết đặc tả ngắn (luồng chính, thay thế, ngoại lệ) và thiết kế test case.

### Bài 2
Use case **Thêm sản phẩm vào giỏ**: Chọn sản phẩm, số lượng, bấm Thêm. Nếu đã có trong giỏ thì cộng dồn. Thiết kế test case (main, hết hàng, số lượng tối đa, chưa đăng nhập nếu có).

### Bài 3
Use case **Hủy đơn hàng**: Chỉ hủy khi trạng thái “Chờ xác nhận”; sau khi hủy hoàn tiền/voucher (nếu đã thanh toán). Thiết kế test case.

### Bài 4
Use case **Đặt lịch hẹn**: Chọn ngày, giờ, dịch vụ → Kiểm tra trống → Xác nhận. Trùng lịch thì gợi ý giờ khác. Thiết kế test case.

### Bài 5
Use case **Bình luận bài viết**: Nhập nội dung (tối đa 500 ký tự) → Gửi. Kiểm duyệt (nếu có). Thiết kế test case (main, rỗng, quá dài, từ nhạy cảm, chưa đăng nhập).

### Bài 6
Use case **Xuất hóa đơn**: Chọn đơn đã thanh toán → Xuất PDF. Chưa thanh toán thì không xuất. Thiết kế test case.

### Bài 7
Use case **Khóa tài khoản** (admin): Admin chọn user, nhập lý do → Khóa. User đó không đăng nhập được. Thiết kế test case (quyền admin, user không tồn tại, user đã khóa).

### Bài 8
Use case **Gia hạn gói dịch vụ**: Chọn gói, thanh toán trước ngày hết hạn → Gia hạn. Đã hết hạn thì phải kích hoạt lại (luồng khác). Thiết kế test case.

### Bài 9
Use case **Chấm điểm bài nộp** (giảng viên): Mở bài nộp → Nhập điểm, nhận xét → Lưu. Chỉ chấm trong thời gian cho phép. Thiết kế test case.

### Bài 10
Use case **Xóa tài khoản**: User yêu cầu xóa → Nhập mật khẩu xác nhận → Gửi OTP → Xóa (soft delete). Thiết kế test case (main, sai mật khẩu, sai OTP, đã hủy yêu cầu).

---

### Bài 11 
Use case **Xem lịch sử đơn hàng**: Đăng nhập → Vào "Đơn hàng" → Xem danh sách, lọc theo trạng thái. Thiết kế test case (có đơn/không có đơn, lọc, phân trang).

### Bài 12 — Trung bình · Thực tế
Use case **Đổi điểm thưởng lấy quà**: Chọn quà (đủ điểm) → Xác nhận → Trừ điểm, tạo đơn quà. Thiết kế test case (đủ điểm, thiếu điểm, quà hết, chưa đăng nhập).

### Bài 13 — Trung bình · Phức tạp
Use case **Đăng ký sự kiện**: Chọn sự kiện (còn slot) → Điền form → (Có phí) Thanh toán → Xác nhận tham gia. Thiết kế test case (miễn phí, có phí, hết slot, hủy đăng ký).

### Bài 14 — Trung bình · Thực tế
Use case **Báo lỗi đường dây (điện/nước)**: Chọn khu vực, mô tả, ảnh (tùy chọn) → Gửi → Nhận mã báo cáo. Thiết kế test case (main, thiếu mô tả, ảnh quá lớn).

### Bài 15 — Khó · Thực tế
Use case **Xin cấp lại bằng lái**: Đủ điều kiện (mất/hết hạn), nộp hồ sơ, ảnh, thanh toán → Nhận lịch hẹn. Thiết kế test case (đủ/không đủ điều kiện, hồ sơ thiếu, thanh toán lỗi).

### Bài 16 — Khó · Phức tạp
Use case **Tạo khóa học (giảng viên)**: Nhập thông tin, giá, bài học, thời hạn mở/đóng → Duyệt (nếu có) → Xuất bản. Thiết kế test case (duyệt qua/từ chối, giá 0, thời hạn sai).

### Bài 17 — Trung bình · Thực tế
Use case **Hủy gói dịch vụ**: Chọn gói đang dùng → Xác nhận hủy → (Cuối kỳ) Ngừng gia hạn hoặc (Ngay) Chấm dứt theo chính sách. Thiết kế test case.

### Bài 18 — Khó · Thực tế
Use case **Đăng ký hiến máu**: Kiểm tra điều kiện (tuổi, cân nặng, sức khỏe) → Chọn địa điểm, ngày → Xác nhận. Thiết kế test case (đủ/không đủ điều kiện, hết chỗ).

### Bài 19 — Khó · Phức tạp
Use case **Duyệt bài đăng (moderator)**: Xem bài chờ duyệt → Duyệt / Từ chối / Yêu cầu sửa. Bài từ chối có lý do; Yêu cầu sửa gửi lại cho tác giả. Thiết kế test case.

### Bài 20 — Khó · Thực tế
Use case **Đặt chỗ giữ xe máy**: Chọn bãi, ngày/giờ vào-ra (ước tính) → Xem giá → Thanh toán → Mã QR vào bãi. Thiết kế test case (bãi đầy, giờ không hợp lệ, thanh toán lỗi).

---

*Hết phần Kiểm thử Use Case.*
