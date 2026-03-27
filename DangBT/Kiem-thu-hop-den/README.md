# Bài tập Kiểm thử hộp đen

Tài liệu bài tập cho **chương Kiểm thử hộp đen**, môn Kiểm thử phần mềm.

## Hướng dẫn làm bài chuẩn — Đọc trước

📌 **Cách làm chuẩn, toàn diện, dễ hiểu:** Đọc file **[HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md)** trước khi làm bài.

File đó gồm:
- **Quy trình chuẩn** từng kỹ thuật (EP, BVA, Bảng quyết định, Chuyển trạng thái, Use case, Kinh nghiệm) và **bài tập tổng hợp** (file 07).
- **Từng bước** cần làm, **bảng/cấu trúc** test case chuẩn, **lưu ý** tránh sai sót.
- **Bảng tóm tắt** khi nào dùng kỹ thuật nào.

Mỗi file bài tập (01–07) có thêm mục **Quy trình chuẩn** ngay đầu file — tóm tắt các bước cho đúng dạng đó; làm bài nên bám theo các bước này. File **07** là quy trình **kết hợp tất cả kỹ thuật** trong một kịch bản.

## Cấu trúc

Mỗi dạng bài gồm **2 phần**:
- **PHẦN 1 – Bài tập mẫu:** 20 bài có hướng dẫn giải chi tiết.
- **PHẦN 2 – Bài tập tự luyện:** 20 bài (đề + gợi ý) để tự làm.

| File | Nội dung |
|------|----------|
| `01-Phan-vung-tuong-duong.md` | Phân vùng tương đương (Equivalence Partitioning) |
| `02-Phan-tich-gia-tri-bien.md` | Phân tích giá trị biên (Boundary Value Analysis) |
| `03-Bang-quyet-dinh.md` | Bảng quyết định (Decision Table) |
| `04-Chuyen-doi-trang-thai.md` | Chuyển đổi trạng thái (State Transition) |
| `05-Kiem-thu-use-case.md` | Kiểm thử dựa trên lược đồ Use Case |
| `06-Kiem-thu-dua-tren-kinh-nghiem.md` | Kiểm thử dựa trên kinh nghiệm (Đoán lỗi, Thăm dò) |
| `07-Tong-hop-ky-thuat-hop-den.md` | **Tổng hợp** — một kịch bản áp dụng đủ EP, BVA, Bảng QĐ, State, Use case, Kinh nghiệm |

## Phạm vi kiến thức

- **Từ dễ đến khó:** Bài được gắn mức Dễ / Trung bình / Khó (trong từng file).
- **Bài phức tạp:** Nhiều điều kiện, nhiều đầu vào, kết hợp EP + BVA hoặc bảng quyết định + BVA; **file 07** luyện **đủ 6 kỹ thuật** trên cùng một đặc tả.
- **Gắn thực tế:** Tình huống ngân hàng, bệnh viện, giáo dục, thương mại điện tử, nhà hàng, bảo hiểm, hàng không, v.v.

## Cách sử dụng

1. **Đọc hướng dẫn chung** — [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) để nắm **quy trình chuẩn** từng kỹ thuật.
2. **Học lý thuyết** trên slide chính (ví dụ `02-Kiem-thu-hop-den.pdf`).
3. **Làm bài mẫu** (Phần 1): đọc **Quy trình chuẩn** ở đầu file, làm từng bước đúng thứ tự, đối chiếu với hướng dẫn giải.
4. **Tự làm bài rèn luyện** (Phần 2): áp dụng đúng 4–5 bước quy trình, sau đó đối chiếu với bài mẫu cùng dạng.
5. Sau khi làm 01–06, dùng **[07-Tong-hop-ky-thuat-hop-den.md](07-Tong-hop-ky-thuat-hop-den.md)** để luyện **một lần đủ 6 kỹ thuật**; có thể kết hợp từng phần (EP + BVA, …) ở các file trước đó theo yêu cầu từng bài.

## Tham chiếu

- Slide: `02-Kiem-thu-hop-den.pdf` (ThS. Dương Hữu Thành – Khoa CNTT, ĐH Mở Tp.HCM).

## Bài tập hộp trắng (song song)

- Thư mục **[Bai-tap-Kiem-thu-hop-trang](../Bai-tap-Kiem-thu-hop-trang/)** — độ phủ câu lệnh, nhánh, điều kiện, MC/DC, cyclomatic / basis path, luồng dữ liệu, tổng hợp.
