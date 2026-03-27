# Bài tập Kiểm thử hộp trắng

Tài liệu bài tập cho **chương Kiểm thử hộp trắng** (white-box / structural testing), môn Kiểm thử phần mềm.

## Hướng dẫn làm bài chuẩn — Đọc trước

**Cách làm chuẩn, toàn diện, dễ hiểu:** Đọc file **[HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md)** trước khi làm bài.

File đó gồm:

- **Quy trình chuẩn** từng tiêu chí phủ (C0, C1, điều kiện / C/D, MC/DC, V(G) & basis path, data flow) và **bài tập tổng hợp** (file 07).
- **Từng bước** cần làm, **bảng / cấu trúc** trình bày test case và phủ, **lưu ý** tránh sai sót.
- **Bảng tóm tắt** độ mạnh tiêu chí và **khi nào dùng** kỹ thuật nào.

Mỗi file bài tập (01–07) có thêm mục **Quy trình chuẩn** ngay đầu file — tóm tắt các bước cho đúng dạng đó; làm bài nên bám theo các bước này. File **07** là quy trình **kết hợp nhiều tiêu chí** trên cùng một module.

**Quy mô:** Mỗi file **01–07** có **PHẦN 1: BÀI TẬP MẪU** (20 bài, lời giải chi tiết) và **PHẦN 2: BÀI TẬP TỰ LUYỆN** (20 bài: đề + gợi ý, cùng nhãn **Đề bài (chi tiết)**, **Yêu cầu**, **Gợi ý giải** như bộ hộp đen). *Nội dung chỉnh sửa trực tiếp trong từng file `.md` (không bắt buộc công cụ sinh tự động).*

## Cấu trúc — Đủ các dạng hộp trắng thường gặp

Mỗi file gồm **2 phần** (cùng tên gọi với [Bai-tap-Kiem-thu-hop-den](../Bai-tap-Kiem-thu-hop-den/)):

- **PHẦN 1: BÀI TẬP MẪU:** lời giải chi tiết (mã giả, CFG / bảng phủ, test case, kết luận); mỗi bài có **Hướng dẫn giải chi tiết** theo **Bước 1 –**, **Bước 2 –**, …
- **PHẦN 2: BÀI TẬP TỰ LUYỆN:** đề + gợi ý (tự làm đủ bảng khi nộp).

| File | Nội dung |
|------|----------|
| `01-Do-phu-cau-lenh.md` | **Độ phủ câu lệnh** (Statement coverage — C0) |
| `02-Do-phu-nhanh.md` | **Độ phủ nhánh / quyết định** (Branch / Decision coverage — C1) |
| `03-Do-phu-dieu-kien.md` | **Độ phủ điều kiện** và **độ phủ điều kiện–quyết định** (Condition, Condition/Decision) |
| `04-MCDC.md` | **MC/DC** (Modified Condition/Decision Coverage) |
| `05-Duong-co-so-cyclomatic.md` | **Độ phức tạp Cyclomatic** V(G) và **kiểm thử đường cơ sở** (Basis path) |
| `06-Luong-du-lieu.md` | **Kiểm thử luồng dữ liệu** (def–use, all-defs / all-uses đơn giản hóa) |
| `07-Tong-hop-ky-thuat-hop-trang.md` | **Tổng hợp** — một module áp dụng lần lượt nhiều tiêu chí |

## Phạm vi kiến thức

- **Giả định:** Đồ thị luồng điều khiển (**CFG**) từ mã giả / ngôn ngữ C-like; không bắt buộc công cụ đo phủ tự động khi làm trên giấy.
- **Từ dễ đến khó:** Bài được gắn **Mức độ** trong từng file; có bài nhiều điều kiện ghép và vòng lặp để luyện **basis path** và **MC/DC**.
- **File 07** luyện **đủ chuỗi tiêu chí** trên cùng một đoạn mã (từ C0 tới data flow).

## Cách sử dụng

1. **Đọc hướng dẫn chung** — [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) để nắm **quy trình chuẩn** từng tiêu chí.
2. **Học lý thuyết** trên slide môn (kiểm thử hộp trắng / cấu trúc).
3. **Làm bài mẫu** (Phần 1): đọc **Quy trình chuẩn** ở đầu file, làm từng bước đúng thứ tự, đối chiếu **Hướng dẫn giải chi tiết** trong từng bài mẫu.
4. **Tự làm bài rèn luyện** (Phần 2): làm theo **Đề bài (chi tiết)** và **Yêu cầu**, sau đó đối chiếu với bài mẫu **cùng số bài / cùng thang** trong Phần 1.
5. Sau khi làm **01 → 06**, dùng **[07-Tong-hop-ky-thuat-hop-trang.md](07-Tong-hop-ky-thuat-hop-trang.md)** để luyện **một lần qua nhiều tiêu chí**; có thể ôn từng phần ở các file trước theo yêu cầu từng bài.

## Bài tập hộp đen (song song)

Thư mục **[Bai-tap-Kiem-thu-hop-den](../Bai-tap-Kiem-thu-hop-den/)** — cùng một đặc tả có thể thiết kế test **hộp đen** (đầu vào–đầu ra) và **hộp trắng** (phủ cấu trúc mã). Hai bộ dùng **cùng khung Phần 1 / Phần 2** và **cách trình bày bài** (mức độ, đề bài, yêu cầu, gợi ý giải).

## Tham chiếu

- Slide môn học (kiểm thử hộp trắng / cấu trúc) — bám theo giáo trình lớp bạn.
