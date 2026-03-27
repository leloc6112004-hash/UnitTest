# Bài tập: Độ phủ câu lệnh (Statement coverage — C0)

**Chương:** Kiểm thử hộp trắng  
Tham chiếu: [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) — mục 2.

**Cấu trúc file:** **PHẦN 1: BÀI TẬP MẪU** (20 bài, lời giải chi tiết) · **PHẦN 2: BÀI TẬP TỰ LUYỆN** (20 bài, đề + gợi ý).

---

## Quy trình chuẩn (ôn tập)

1. Vẽ / liệt kê **CFG**, đánh số **nút** (mỗi khối tuần tự có thể gộp).  
2. Liệt kê **mọi câu lệnh / nút** cần phủ.  
3. Thiết kế **test case** sao cho mỗi nút **ít nhất một** đường đi qua.  
4. Lập **bảng phủ C0** (nút × TC).  
5. Ghi **kết luận**: số TC tối thiểu, có nhánh không khả thi hay không.

**Lưu ý:** C0 **không** đảm bảo phủ cả nhánh **F** của mọi `if` → xem [02-Do-phu-nhanh.md](02-Do-phu-nhanh.md).

---

**Thang độ khó:** Bài mẫu **1–9**: nền tảng (**Dễ** → **Trung bình**) — **cùng dạng** mã, chủ yếu **đổi ngưỡng số** nên độ khó gần tương đương. Bài mẫu **10–20**: **độ khó và độ phức tạp cấu trúc mã tăng dần** (Trung bình nâng cao → **Cực khó · tổng hợp**): nhiều nhánh lồng nhau, `elif` chuỗi, `while` + `if`, v.v.

## PHẦN 1: BÀI TẬP MẪU

---

### Bài mẫu 1 — Mức độ: Dễ
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f1(x):  // x là số nguyên
    r = 0
    if x < 0:
        return -1
    elif x > 6:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<0?` —(T)→ `return -1` → End  
—(F)→ `D2: x>6?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | -1 | -1 | D1=T → return -1 |
| T2 | 7 | 2 | D1=F, D2=T → return 2 |
| T3 | 3 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `-1` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 2 — Mức độ: Dễ
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f2(x):  // x là số nguyên
    r = 0
    if x < 1:
        return -1
    elif x > 7:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<1?` —(T)→ `return -1` → End  
—(F)→ `D2: x>7?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | 0 | -1 | D1=T → return -1 |
| T2 | 8 | 2 | D1=F, D2=T → return 2 |
| T3 | 4 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `0` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 3 — Mức độ: Dễ
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f3(x):  // x là số nguyên
    r = 0
    if x < 2:
        return -1
    elif x > 8:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<2?` —(T)→ `return -1` → End  
—(F)→ `D2: x>8?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | 1 | -1 | D1=T → return -1 |
| T2 | 9 | 2 | D1=F, D2=T → return 2 |
| T3 | 5 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `1` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 4 — Mức độ: Dễ
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f4(x):  // x là số nguyên
    r = 0
    if x < -1:
        return -1
    elif x > 9:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<-1?` —(T)→ `return -1` → End  
—(F)→ `D2: x>9?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | -2 | -1 | D1=T → return -1 |
| T2 | 10 | 2 | D1=F, D2=T → return 2 |
| T3 | 4 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `-2` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 5 — Mức độ: Dễ
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f5(x):  // x là số nguyên
    r = 0
    if x < 0:
        return -1
    elif x > 10:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<0?` —(T)→ `return -1` → End  
—(F)→ `D2: x>10?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | -1 | -1 | D1=T → return -1 |
| T2 | 11 | 2 | D1=F, D2=T → return 2 |
| T3 | 5 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `-1` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 6 — Mức độ: Trung bình
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f6(x):  // x là số nguyên
    r = 0
    if x < 1:
        return -1
    elif x > 5:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<1?` —(T)→ `return -1` → End  
—(F)→ `D2: x>5?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | 0 | -1 | D1=T → return -1 |
| T2 | 6 | 2 | D1=F, D2=T → return 2 |
| T3 | 3 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `0` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 7 — Mức độ: Trung bình
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f7(x):  // x là số nguyên
    r = 0
    if x < 2:
        return -1
    elif x > 6:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<2?` —(T)→ `return -1` → End  
—(F)→ `D2: x>6?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | 1 | -1 | D1=T → return -1 |
| T2 | 7 | 2 | D1=F, D2=T → return 2 |
| T3 | 4 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `1` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 8 — Mức độ: Trung bình
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f8(x):  // x là số nguyên
    r = 0
    if x < -1:
        return -1
    elif x > 7:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<-1?` —(T)→ `return -1` → End  
—(F)→ `D2: x>7?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | -2 | -1 | D1=T → return -1 |
| T2 | 8 | 2 | D1=F, D2=T → return 2 |
| T3 | 3 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `-2` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 9 — Mức độ: Trung bình
**Hàm phân nhánh ba đường (C0)**



**Đề bài (chi tiết):**

```text
function f9(x):  // x là số nguyên
    r = 0
    if x < 0:
        return -1
    elif x > 8:
        return 2
    else:
        r = 1
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG (mô tả nút):**  
`S` → gán `r=0` → `D1: x<0?` —(T)→ `return -1` → End  
—(F)→ `D2: x>8?` —(T)→ `return 2` → End  
—(F)→ `r=1` → `return r` → End  

**Bước 2 – Tập nút / khối lệnh cần phủ C0:** khối gán `r=0`, điều kiện D1 (cả hai nhánh đi ra có cạnh), thân `return -1`, D2 và hai nhánh, khối `r=1`, `return r`.

**Bước 3 – Test case tối thiểu (ví dụ):**

| TC | x | Kỳ vọng | Đường đi (tóm tắt) |
|----|---|---------|---------------------|
| T1 | -1 | -1 | D1=T → return -1 |
| T2 | 9 | 2 | D1=F, D2=T → return 2 |
| T3 | 4 | 1 | D1=F, D2=F → r=1 → return |

*(Nếu `-1` trùng miền với nhánh khác do trùng số, đổi x một đơn vị cho đúng nhánh.)*

**Bước 4 – Bảng phủ C0 (✓ = đi qua):**

| Khối / lệnh | T1 | T2 | T3 |
|-------------|----|----|-----|
| r=0 | ✓ | ✓ | ✓ |
| D1 (nhánh) | ✓ | ✓ | ✓ |
| return -1 | ✓ | | |
| D2 (nhánh) | | ✓ | ✓ |
| return 2 | | ✓ | |
| r=1 | | | ✓ |
| return r | | | ✓ |

**Bước 5 – Kết luận:** **3 TC** đủ **100% C0** (giả sử mọi nhánh khả thi). So sánh với **C1** ở file 02.

---
### Bài mẫu 10 — Mức độ: Trung bình · nâng cao (1)
**C0: if lồng + cập nhật có điều kiện**


*(Bài 10–12: tăng số khối lệnh và nhánh lồng so với bài 1–9.)*

**Đề bài (chi tiết):**

```text
function f10(x, y):  // nguyên
    r = 0
    if x < 0:
        r = -1
    else:
        if y > 2:
            r = 2
        else:
            r = 3
    if r >= 0:
        r = r + 7
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG:** `x<0`; lồng `y>2`; khối `r>=0` (T/F).

**Bước 2 – Test C0:**

| TC | x | y | Kỳ vọng |
|----|---|---|---------|
| T1 | -1 | 0 | -1 |
| T2 | 2 | 4 | 9 |
| T3 | 2 | 0 | 10 |

**Bước 3 – Bảng phủ:** ✓ mọi gán, mọi nhánh `if` khả thi, `return`.

**Kết luận:** **3 TC** tối thiểu cho cấu trúc này.

---
### Bài mẫu 11 — Mức độ: Trung bình · nâng cao (2)
**C0: if lồng + cập nhật có điều kiện**


*(Bài 10–12: tăng số khối lệnh và nhánh lồng so với bài 1–9.)*

**Đề bài (chi tiết):**

```text
function f11(x, y):  // nguyên
    r = 0
    if x < 0:
        r = -1
    else:
        if y > 3:
            r = 2
        else:
            r = 3
    if r >= 0:
        r = r + 8
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG:** `x<0`; lồng `y>3`; khối `r>=0` (T/F).

**Bước 2 – Test C0:**

| TC | x | y | Kỳ vọng |
|----|---|---|---------|
| T1 | -1 | 0 | -1 |
| T2 | 2 | 5 | 10 |
| T3 | 2 | 0 | 11 |

**Bước 3 – Bảng phủ:** ✓ mọi gán, mọi nhánh `if` khả thi, `return`.

**Kết luận:** **3 TC** tối thiểu cho cấu trúc này.

---
### Bài mẫu 12 — Mức độ: Khó (mức 1)
**C0: if lồng + cập nhật có điều kiện**


*(Bài 10–12: tăng số khối lệnh và nhánh lồng so với bài 1–9.)*

**Đề bài (chi tiết):**

```text
function f12(x, y):  // nguyên
    r = 0
    if x < 0:
        r = -1
    else:
        if y > 1:
            r = 2
        else:
            r = 3
    if r >= 0:
        r = r + 5
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG:** `x<0`; lồng `y>1`; khối `r>=0` (T/F).

**Bước 2 – Test C0:**

| TC | x | y | Kỳ vọng |
|----|---|---|---------|
| T1 | -1 | 0 | -1 |
| T2 | 2 | 3 | 7 |
| T3 | 2 | 0 | 8 |

**Bước 3 – Bảng phủ:** ✓ mọi gán, mọi nhánh `if` khả thi, `return`.

**Kết luận:** **3 TC** tối thiểu cho cấu trúc này.

---
### Bài mẫu 13 — Mức độ: Khó (mức 2)
**C0: chuỗi elif — bốn đường return**


*(Bài 13–15: bốn nhánh loại trừ — nhiều điểm thoát.)*

**Đề bài (chi tiết):**

```text
function f13(x):
    if x < 0:
        return -10
    elif x < 6:
        return 0
    elif x < 13:
        return 10
    else:
        return 20
```

**Hướng dẫn giải chi tiết:**

**Test C0 (mỗi `return` chạy ít nhất 1 lần):**

| TC | x | Kỳ vọng |
|----|---|---------|
| T1 | -1 | -10 |
| T2 | 1 | 0 |
| T3 | 7 | 10 |
| T4 | 14 | 20 |

**Kết luận:** **4 TC** — độ phức tạp **cao hơn** bài 1–9.

---
### Bài mẫu 14 — Mức độ: Khó (mức 3)
**C0: chuỗi elif — bốn đường return**


*(Bài 13–15: bốn nhánh loại trừ — nhiều điểm thoát.)*

**Đề bài (chi tiết):**

```text
function f14(x):
    if x < 0:
        return -10
    elif x < 5:
        return 0
    elif x < 14:
        return 10
    else:
        return 20
```

**Hướng dẫn giải chi tiết:**

**Test C0 (mỗi `return` chạy ít nhất 1 lần):**

| TC | x | Kỳ vọng |
|----|---|---------|
| T1 | -1 | -10 |
| T2 | 1 | 0 |
| T3 | 6 | 10 |
| T4 | 15 | 20 |

**Kết luận:** **4 TC** — độ phức tạp **cao hơn** bài 1–9.

---
### Bài mẫu 15 — Mức độ: Khó · phức tạp
**C0: chuỗi elif — bốn đường return**


*(Bài 13–15: bốn nhánh loại trừ — nhiều điểm thoát.)*

**Đề bài (chi tiết):**

```text
function f15(x):
    if x < 0:
        return -10
    elif x < 6:
        return 0
    elif x < 12:
        return 10
    else:
        return 20
```

**Hướng dẫn giải chi tiết:**

**Test C0 (mỗi `return` chạy ít nhất 1 lần):**

| TC | x | Kỳ vọng |
|----|---|---------|
| T1 | -1 | -10 |
| T2 | 1 | 0 |
| T3 | 7 | 10 |
| T4 | 13 | 20 |

**Kết luận:** **4 TC** — độ phức tạp **cao hơn** bài 1–9.

---
### Bài mẫu 16 — Mức độ: Rất khó (mức 1)
**C0: while + if trong thân**


*(Bài 16–17: vòng lặp + một `if` — nhiều nút hơn bài 1–9.)*

**Đề bài (chi tiết):**

```text
function f16(n):  // n nguyên ≥ 0
    j = 0
    s = 0
    while j < n:
        if (j % 2) == 0:
            s = s + j
        j = j + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**C0:** `n=0` (không vào thân); `n` đủ lớn để phủ **cả** nhánh `if` T và F trong vòng (chọn `n ≥ 2` và kiểm tra j chẵn/lẻ).

**Kết luận:** Tối thiểu **2–3 TC** tùy yêu cầu phủ đủ **mọi** lệnh trong thân vòng.

---
### Bài mẫu 17 — Mức độ: Rất khó (mức 2)
**C0: while + if trong thân**


*(Bài 16–17: vòng lặp + một `if` — nhiều nút hơn bài 1–9.)*

**Đề bài (chi tiết):**

```text
function f17(n):  // n nguyên ≥ 0
    j = 0
    s = 0
    while j < n:
        if (j % 2) == 1:
            s = s + j
        j = j + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**C0:** `n=0` (không vào thân); `n` đủ lớn để phủ **cả** nhánh `if` T và F trong vòng (chọn `n ≥ 2` và kiểm tra j chẵn/lẻ).

**Kết luận:** Tối thiểu **2–3 TC** tùy yêu cầu phủ đủ **mọi** lệnh trong thân vòng.

---
### Bài mẫu 18 — Mức độ: Rất khó (mức 3)
**C0: while + if/else trong thân**


*(Bài 18: thêm **else** trong thân vòng — khác bài 16/17; nhiều **khối lệnh** hơn.)*

**Đề bài (chi tiết):**

```text
function f18(n):  // n nguyên ≥ 0
    j = 0
    s = 0
    while j < n:
        if (j % 3) == 0:
            s = s + j
        else:
            s = s + 1
        j = j + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**C0:** `n=0` (không vào thân); `n ≥ 3` để có cả j chia hết cho 3 và không; phủ nhánh **then**, **else**, và lệnh `j = j + 1`.

**Kết luận:** Tối thiểu **2–3 TC** (thường cần **≥2** lần vào vòng để thấy đủ nhánh **if/else**).

---
### Bài mẫu 19 — Mức độ: Cực khó
**C0: while + lồng + break (cực khó)**


*(Bài 19–20: nhiều lớp điều khiển — đỉnh thang khó trong file 01.)*

**Đề bài (chi tiết):**

```text
function f19(n, k):  // n,k nguyên
    idx = 0
    found = 0
    while idx < n:
        if idx == k:
            found = 1
            if (idx % 2) == 0:
                break
        else:
            if idx > k + 2:
                break
        idx = idx + 1
    return found * 10 + idx
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Hướng dẫn:** Vẽ **CFG đầy đủ** (while có cạnh quay lại + thoát; hai `break`; nhánh lồng).  
**Bước 2 – Nhiệm vụ:** Thiết kế **≥ 5 TC** `(n,k)` để mọi **câu lệnh khả thi** đều được đi qua (sinh viên hoàn thiện bảng phủ ✓).

**Kết luận:** Dạng **tổng hợp C0** — không tối thiểu hóa bằng mắt nếu chưa có CFG.

---
### Bài mẫu 20 — Mức độ: Cực khó · tổng hợp
**C0: while + lồng + break (cực khó)**


*(Bài 19–20: nhiều lớp điều khiển — đỉnh thang khó trong file 01.)*

**Đề bài (chi tiết):**

```text
function f20(n, k):  // n,k nguyên
    idx = 0
    found = 0
    while idx < n:
        if idx == k:
            found = 1
            if (idx % 2) == 0:
                break
        else:
            if idx > k + 2:
                break
        idx = idx + 1
    return found * 10 + idx
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Hướng dẫn:** Vẽ **CFG đầy đủ** (while có cạnh quay lại + thoát; hai `break`; nhánh lồng).  
**Bước 2 – Nhiệm vụ:** Thiết kế **≥ 5 TC** `(n,k)` để mọi **câu lệnh khả thi** đều được đi qua (sinh viên hoàn thiện bảng phủ ✓).

**Kết luận:** Dạng **tổng hợp C0** — không tối thiểu hóa bằng mắt nếu chưa có CFG.

---

## PHẦN 2: BÀI TẬP TỰ LUYỆN

---

*20 bài — độ phủ câu lệnh (C0).*

*Chỉ có **đề** và **gợi ý**; làm đủ bảng CFG / TC / phủ như **PHẦN 1** khi nộp.*  
*Thang **khớp PHẦN 1:** **1–9** = một `if` / `elif` / `else` kiểu **ba nhánh** như `f1…f9`; **10–20** = cấu trúc nâng dần như bài mẫu **10–20**.*

### Bài 1 — Mức độ: Dễ
**Tự luyện #1**

**Đề bài (chi tiết):**  
`function u1(x)` — **ba nhánh** `if` / `elif` / `else` (hai nhánh `return` sớm, một nhánh gán `r` rồi `return r`), giống **ý tưởng** bài mẫu **1–9**. Tự chọn **ngưỡng** so sánh khác mẫu.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
CFG; tối thiểu **3 TC** C0; bảng phủ ✓.


---
### Bài 2 — Mức độ: Dễ
**Tự luyện #2**

**Đề bài (chi tiết):**  
`function u2(x)` — cùng **dạng** bài **1** (ba nhánh tuyến tính), **đổi** ngưỡng số.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đừng để TC trùng nhánh do trùng miền.


---
### Bài 3 — Mức độ: Dễ
**Tự luyện #3**

**Đề bài (chi tiết):**  
`function u3(x)` — ba nhánh `if` / `elif` / `else`, ngưỡng khác bài 1–2.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Liệt kê đủ **khối lệnh** (kể `r=0`).


---
### Bài 4 — Mức độ: Dễ
**Tự luyện #4**

**Đề bài (chi tiết):**  
`function u4(x)` — ba nhánh; thử **điều kiện** dạng `x < a`, `x > b` với `a < b` hợp lệ.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Kiểm tra nhánh **else** có chạy được.


---
### Bài 5 — Mức độ: Dễ
**Tự luyện #5**

**Đề bài (chi tiết):**  
`function u5(x)` — ba nhánh; **một** nhánh trả về hằng âm, một trả về hằng dương lớn.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
C0 ≠ C1 — chỉ cần mọi **lệnh** được qua.


---
### Bài 6 — Mức độ: Dễ
**Tự luyện #6**

**Đề bài (chi tiết):**  
`function u6(x)` — ba nhánh; khác bài 4–5 về **ngưỡng**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ghi **kết luận** số TC tối thiểu.


---
### Bài 7 — Mức độ: Dễ
**Tự luyện #7**

**Đề bài (chi tiết):**  
`function u7(x)` — ba nhánh (nền tảng).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
So sánh với **file 02** (C1) nếu ôn song song.


---
### Bài 8 — Mức độ: Dễ
**Tự luyện #8**

**Đề bài (chi tiết):**  
`function u8(x)` — ba nhánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Nhánh **không khả thi** (nếu có) ghi rõ.


---
### Bài 9 — Mức độ: Dễ
**Tự luyện #9**

**Đề bài (chi tiết):**  
`function u9(x)` — ba nhánh; **cuối** nhóm nền **1–9**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Chuẩn bị sang **10–12** (hai biến + lồng).


---
### Bài 10 — Mức độ: Trung bình
**Tự luyện #10**

**Đề bài (chi tiết):**  
`function u10(x, y)` — **if lồng** + cập nhật `r` có điều kiện (kiểu bài mẫu **10–12**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
≥ **3 TC**; phủ cả nhánh `r >= 0` (hoặc tương đương).


---
### Bài 11 — Mức độ: Trung bình
**Tự luyện #11**

**Đề bài (chi tiết):**  
`function u11(x, y)` — if lồng + điều kiện phụ trên `r` (như mẫu **10–12**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Vẽ CFG có **3** mức rẽ chính.


---
### Bài 12 — Mức độ: Trung bình
**Tự luyện #12**

**Đề bài (chi tiết):**  
`function u12(x, y)` — if lồng; **hết nhóm 10–12**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đếm **nút** trước khi chốt TC.


---
### Bài 13 — Mức độ: Khó
**Tự luyện #13**

**Đề bài (chi tiết):**  
`function u13(x)` — **chuỗi elif** **bốn** nhánh, **bốn** `return` (kiểu mẫu **13–15**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**4 TC** tối thiểu (mỗi `return` một lần).


---
### Bài 14 — Mức độ: Khó
**Tự luyện #14**

**Đề bài (chi tiết):**  
`function u14(x)` — elif bốn nhánh; **đổi** các ngưỡng so sánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Thứ tự `elif` phải **loại trừ** đúng.


---
### Bài 15 — Mức độ: Khó
**Tự luyện #15**

**Đề bài (chi tiết):**  
`function u15(x)` — elif bốn nhánh; **cuối** nhóm **13–15**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đối chiếu với C1 file 02 (cùng dạng).


---
### Bài 16 — Mức độ: Rất khó
**Tự luyện #16**

**Đề bài (chi tiết):**  
`function u16(n)` — `while j < n` + **một** `if` trong thân (kiểu mẫu **16–17**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
`n = 0` và `n ≥ 2` để phủ nhánh **if** T/F trong vòng.


---
### Bài 17 — Mức độ: Rất khó
**Tự luyện #17**

**Đề bài (chi tiết):**  
`function u17(n)` — `while` + `if` với điều kiện **khác** bài 16 (vd. `% 2` hoặc so sánh `j` với hằng).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ghi rõ TC nào vào vòng **bao nhiêu** lần.


---
### Bài 18 — Mức độ: Rất khó
**Tự luyện #18**

**Đề bài (chi tiết):**  
`function u18(n)` — `while` + **`if` / `else`** trong thân (kiểu mẫu **18**: nhiều khối hơn **16–17**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Cần `n` đủ lớn để thấy **cả** nhánh then và else.


---
### Bài 19 — Mức độ: Cực khó · tổng hợp
**Tự luyện #19**

**Đề bài (chi tiết):**  
`function u19(n, k)` — `while` + **lồng** + **`break`** (kiểu mẫu **19–20**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
≥ **5 TC**; CFG có cạnh **thoát sớm**.


---
### Bài 20 — Mức độ: Cực khó · tổng hợp
**Tự luyện #20**

**Đề bài (chi tiết):**  
`function u20(n, k)` — cùng **độ khó** bài **19**, **đổi** điều kiện lồng / `break` (vẫn một hàm hai tham số).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Tổng hợp C0 — **đỉnh** file 01.


---

*Tài liệu chỉnh sửa trực tiếp trong file này; có thể bổ sung ví dụ số theo lớp.*
