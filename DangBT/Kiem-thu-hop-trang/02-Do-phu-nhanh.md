# Bài tập: Độ phủ nhánh / quyết định (Branch coverage — C1)

**Chương:** Kiểm thử hộp trắng  
Tham chiếu: [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) — mục 3.

**Cấu trúc file:** **PHẦN 1: BÀI TẬP MẪU** (20 bài, lời giải chi tiết) · **PHẦN 2: BÀI TẬP TỰ LUYỆN** (20 bài, đề + gợi ý).

---

## Quy trình chuẩn

1. Liệt kê **mọi quyết định** (`if`, `while`, …).  
2. Với mỗi quyết định, cần **cạnh True** và **cạnh False** đều được thực thi.  
3. Lập **bảng phủ nhánh** (✓/✗).  
4. Ghi nhánh **không khả thi** nếu có.

**Mối quan hệ:** Thường **C1 ⇒ C0** (nếu mỗi nhánh có lệnh).

**Thang độ khó:** Bài **1–9** nền tảng (cùng dạng, đổi ngưỡng) · Bài **10–20** **tăng dần** (nhiều quyết định / `elif` dài / lồng trong vòng lặp).

---

## PHẦN 1: BÀI TẬP MẪU

---

### Bài mẫu 1 — Mức độ: Dễ
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g1(x):
    if x < 1:
        return "L"
    elif x <= 9:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 1` (T/F)  
- **D2:** `x <= 9` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | 0 | T | — | L |
| T2 | 1 | F | T | M |
| T3 | 9 | F | T | M |
| T4 | 10 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 2 — Mức độ: Dễ
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g2(x):
    if x < 2:
        return "L"
    elif x <= 10:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 2` (T/F)  
- **D2:** `x <= 10` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | 1 | T | — | L |
| T2 | 2 | F | T | M |
| T3 | 10 | F | T | M |
| T4 | 11 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 3 — Mức độ: Dễ
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g3(x):
    if x < 0:
        return "L"
    elif x <= 11:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 0` (T/F)  
- **D2:** `x <= 11` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | -1 | T | — | L |
| T2 | 0 | F | T | M |
| T3 | 11 | F | T | M |
| T4 | 12 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 4 — Mức độ: Dễ
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g4(x):
    if x < 1:
        return "L"
    elif x <= 12:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 1` (T/F)  
- **D2:** `x <= 12` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | 0 | T | — | L |
| T2 | 1 | F | T | M |
| T3 | 12 | F | T | M |
| T4 | 13 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 5 — Mức độ: Dễ
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g5(x):
    if x < 2:
        return "L"
    elif x <= 8:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 2` (T/F)  
- **D2:** `x <= 8` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | 1 | T | — | L |
| T2 | 2 | F | T | M |
| T3 | 8 | F | T | M |
| T4 | 9 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 6 — Mức độ: Trung bình
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g6(x):
    if x < 0:
        return "L"
    elif x <= 9:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 0` (T/F)  
- **D2:** `x <= 9` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | -1 | T | — | L |
| T2 | 0 | F | T | M |
| T3 | 9 | F | T | M |
| T4 | 10 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 7 — Mức độ: Trung bình
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g7(x):
    if x < 1:
        return "L"
    elif x <= 10:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 1` (T/F)  
- **D2:** `x <= 10` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | 0 | T | — | L |
| T2 | 1 | F | T | M |
| T3 | 10 | F | T | M |
| T4 | 11 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 8 — Mức độ: Trung bình
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g8(x):
    if x < 2:
        return "L"
    elif x <= 11:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 2` (T/F)  
- **D2:** `x <= 11` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | 1 | T | — | L |
| T2 | 2 | F | T | M |
| T3 | 11 | F | T | M |
| T4 | 12 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 9 — Mức độ: Trung bình
**Phủ nhánh if / elif / else**



**Đề bài (chi tiết):**

```text
function g9(x):
    if x < 0:
        return "L"
    elif x <= 12:
        return "M"
    else:
        return "H"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:**  
- **D1:** `x < 0` (T/F)  
- **D2:** `x <= 12` **chỉ khi D1=F** (T/F)

**Bước 2 – Test cho C1 (mỗi cạnh T/F khả thi):**

| TC | x | D1 | D2 | Kết quả |
|----|---|----|----|---------|
| T1 | -1 | T | — | L |
| T2 | 0 | F | T | M |
| T3 | 12 | F | T | M |
| T4 | 13 | F | F | H |

**Bước 3 – Bảng phủ nhánh:**

| Cạnh | T1 | T2 | T3 | T4 |
|------|----|----|----|-----|
| D1→T | ✓ | | | |
| D1→F | | ✓ | ✓ | ✓ |
| D2→T | | ✓ | ✓ | |
| D2→F | | | | ✓ |

**Bước 4 – Kết luận:** **4 TC** đủ **C1** cho cấu trúc if / elif / else này.

---
### Bài mẫu 10 — Mức độ: Trung bình · nâng cao (1)
**C1: bốn nhánh elif — đủ mọi cạnh**


*(Bài 10–13: mỗi nhánh elif là một phần của **cùng** chuỗi quyết định.)*

**Đề bài (chi tiết):**

```text
function g10(x):
    if x < -5:
        return "A"
    elif x < 3:
        return "B"
    elif x < 9:
        return "C"
    else:
        return "D"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân tích C1:** Với mỗi điều kiện trong chuỗi, cần **T** và **F** khả thi (theo ngữ cảnh đến được). **4 TC** như bài C0 tương ứng thường đủ **C1** (mỗi return một lần + phủ cạnh vào/ra mỗi điều kiện).

**Bước 2 – Kết luận:** So sánh số quyết định với bài mẫu **1–9**.

---
### Bài mẫu 11 — Mức độ: Trung bình · nâng cao (2)
**C1: bốn nhánh elif — đủ mọi cạnh**


*(Bài 10–13: mỗi nhánh elif là một phần của **cùng** chuỗi quyết định.)*

**Đề bài (chi tiết):**

```text
function g11(x):
    if x < -5:
        return "A"
    elif x < 4:
        return "B"
    elif x < 10:
        return "C"
    else:
        return "D"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân tích C1:** Với mỗi điều kiện trong chuỗi, cần **T** và **F** khả thi (theo ngữ cảnh đến được). **4 TC** như bài C0 tương ứng thường đủ **C1** (mỗi return một lần + phủ cạnh vào/ra mỗi điều kiện).

**Bước 2 – Kết luận:** So sánh số quyết định với bài mẫu **1–9**.

---
### Bài mẫu 12 — Mức độ: Khó (mức 1)
**C1: bốn nhánh elif — đủ mọi cạnh**


*(Bài 10–13: mỗi nhánh elif là một phần của **cùng** chuỗi quyết định.)*

**Đề bài (chi tiết):**

```text
function g12(x):
    if x < -5:
        return "A"
    elif x < 2:
        return "B"
    elif x < 9:
        return "C"
    else:
        return "D"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân tích C1:** Với mỗi điều kiện trong chuỗi, cần **T** và **F** khả thi (theo ngữ cảnh đến được). **4 TC** như bài C0 tương ứng thường đủ **C1** (mỗi return một lần + phủ cạnh vào/ra mỗi điều kiện).

**Bước 2 – Kết luận:** So sánh số quyết định với bài mẫu **1–9**.

---
### Bài mẫu 13 — Mức độ: Khó (mức 2)
**C1: bốn nhánh elif — đủ mọi cạnh**


*(Bài 10–13: mỗi nhánh elif là một phần của **cùng** chuỗi quyết định.)*

**Đề bài (chi tiết):**

```text
function g13(x):
    if x < -5:
        return "A"
    elif x < 3:
        return "B"
    elif x < 10:
        return "C"
    else:
        return "D"
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân tích C1:** Với mỗi điều kiện trong chuỗi, cần **T** và **F** khả thi (theo ngữ cảnh đến được). **4 TC** như bài C0 tương ứng thường đủ **C1** (mỗi return một lần + phủ cạnh vào/ra mỗi điều kiện).

**Bước 2 – Kết luận:** So sánh số quyết định với bài mẫu **1–9**.

---
### Bài mẫu 14 — Mức độ: Khó (mức 3)
**C1: hai if độc lập nối tiếp**


*(Bài 14–17: **hai** quyết định độc lập → 4 tổ hợp T/T, T/F, F/T, F/F.)*  
**Lưu ý:** Khác bài 10–13 (một chuỗi elif), đây là **hai `if` riêng** — dễ **bỏ sót** một cạnh nếu không lập đủ **bốn** TC.

**Đề bài (chi tiết):**

```text
function g14(a, b):
    s = ""
    if a > 3:
        s = s + "A"
    if b < 6:
        s = s + "B"
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Bảng C1 (mỗi `if` có T và F):**

| TC | a | b | D1(a>3) | D2(b<6) | s |
|----|---|---|-----------|-------------|---|
| T1 | 2 | 8 | F | F | "" |
| T2 | 8 | 8 | T | F | "A" |
| T3 | 2 | 3 | F | T | "B" |
| T4 | 8 | 3 | T | T | "AB" |

**Bước 2 – Kết luận:** **4 TC** tối thiểu cho **C1** hai `if` độc lập.

---
### Bài mẫu 15 — Mức độ: Khó · phức tạp
**C1: hai if độc lập nối tiếp**


*(Bài 14–17: **hai** quyết định độc lập → 4 tổ hợp T/T, T/F, F/T, F/F.)*  
**Lưu ý:** Khác bài 10–13 (một chuỗi elif), đây là **hai `if` riêng** — dễ **bỏ sót** một cạnh nếu không lập đủ **bốn** TC.

**Đề bài (chi tiết):**

```text
function g15(a, b):
    s = ""
    if a > 4:
        s = s + "A"
    if b < 7:
        s = s + "B"
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Bảng C1 (mỗi `if` có T và F):**

| TC | a | b | D1(a>4) | D2(b<7) | s |
|----|---|---|-----------|-------------|---|
| T1 | 3 | 9 | F | F | "" |
| T2 | 9 | 9 | T | F | "A" |
| T3 | 3 | 4 | F | T | "B" |
| T4 | 9 | 4 | T | T | "AB" |

**Bước 2 – Kết luận:** **4 TC** tối thiểu cho **C1** hai `if` độc lập.

---
### Bài mẫu 16 — Mức độ: Rất khó (mức 1)
**C1: hai if độc lập nối tiếp**


*(Bài 14–17: **hai** quyết định độc lập → 4 tổ hợp T/T, T/F, F/T, F/F.)*  
**Lưu ý:** Khác bài 10–13 (một chuỗi elif), đây là **hai `if` riêng** — dễ **bỏ sót** một cạnh nếu không lập đủ **bốn** TC.

**Đề bài (chi tiết):**

```text
function g16(a, b):
    s = ""
    if a > 1:
        s = s + "A"
    if b < 4:
        s = s + "B"
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Bảng C1 (mỗi `if` có T và F):**

| TC | a | b | D1(a>1) | D2(b<4) | s |
|----|---|---|-----------|-------------|---|
| T1 | 0 | 6 | F | F | "" |
| T2 | 6 | 6 | T | F | "A" |
| T3 | 0 | 1 | F | T | "B" |
| T4 | 6 | 1 | T | T | "AB" |

**Bước 2 – Kết luận:** **4 TC** tối thiểu cho **C1** hai `if` độc lập.

---
### Bài mẫu 17 — Mức độ: Rất khó (mức 2)
**C1: hai if độc lập nối tiếp**


*(Bài 14–17: **hai** quyết định độc lập → 4 tổ hợp T/T, T/F, F/T, F/F.)*  
**Lưu ý:** Khác bài 10–13 (một chuỗi elif), đây là **hai `if` riêng** — dễ **bỏ sót** một cạnh nếu không lập đủ **bốn** TC.

**Đề bài (chi tiết):**

```text
function g17(a, b):
    s = ""
    if a > 2:
        s = s + "A"
    if b < 5:
        s = s + "B"
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Bảng C1 (mỗi `if` có T và F):**

| TC | a | b | D1(a>2) | D2(b<5) | s |
|----|---|---|-----------|-------------|---|
| T1 | 1 | 7 | F | F | "" |
| T2 | 7 | 7 | T | F | "A" |
| T3 | 1 | 2 | F | T | "B" |
| T4 | 7 | 2 | T | T | "AB" |

**Bước 2 – Kết luận:** **4 TC** tối thiểu cho **C1** hai `if` độc lập.

---
### Bài mẫu 18 — Mức độ: Rất khó (mức 3)
**C1: while + if — nhánh vòng và nhánh trong**


*(Bài 18–20: đỉnh file 02 — C1 cho `j<n` **và** điều kiện trong thân.)*

**Đề bài (chi tiết):**

```text
function g18(n):
    j = 0
    c = 0
    while j < n:
        if j != 0:
            c = c + 1
        j = j + 1
    return c
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân tích C1:**  
- `j < n`: cần **vào vòng** và **thoát** (F).  
- `j != 0`: trong ít nhất một lần lặp **T** và **F**.

**Bước 2 – Gợi ý TC:** `n=0`; `n` nhỏ (1,2,3) để lần lượt j bằng/khác **0**.

**Bước 3 – Kết luận:** **≥ 3 TC**; vẽ CFG trước khi chốt.

---
### Bài mẫu 19 — Mức độ: Cực khó
**C1: while + if — nhánh vòng và nhánh trong**


*(Bài 18–20: đỉnh file 02 — C1 cho `j<n` **và** điều kiện trong thân.)*

**Đề bài (chi tiết):**

```text
function g19(n):
    j = 0
    c = 0
    while j < n:
        if j != 1:
            c = c + 1
        j = j + 1
    return c
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân tích C1:**  
- `j < n`: cần **vào vòng** và **thoát** (F).  
- `j != 1`: trong ít nhất một lần lặp **T** và **F**.

**Bước 2 – Gợi ý TC:** `n=0`; `n` nhỏ (1,2,3) để lần lượt j bằng/khác **1**.

**Bước 3 – Kết luận:** **≥ 3 TC**; vẽ CFG trước khi chốt.

---
### Bài mẫu 20 — Mức độ: Cực khó · tổng hợp
**C1: while + if — nhánh vòng và nhánh trong**


*(Bài 18–20: đỉnh file 02 — C1 cho `j<n` **và** điều kiện trong thân.)*

**Đề bài (chi tiết):**

```text
function g20(n):
    j = 0
    c = 0
    while j < n:
        if j != 2:
            c = c + 1
        j = j + 1
    return c
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Phân tích C1:**  
- `j < n`: cần **vào vòng** và **thoát** (F).  
- `j != 2`: trong ít nhất một lần lặp **T** và **F**.

**Bước 2 – Gợi ý TC:** `n=0`; `n` nhỏ (1,2,3) để lần lượt j bằng/khác **2**.

**Bước 3 – Kết luận:** **≥ 3 TC**; vẽ CFG trước khi chốt.

---

## PHẦN 2: BÀI TẬP TỰ LUYỆN

---

*20 bài — độ phủ nhánh / quyết định (C1).*

*Chỉ có **đề** và **gợi ý**; làm đủ bảng CFG / TC / phủ như **PHẦN 1** khi nộp.*  
*Thang **khớp PHẦN 1:** **1–9** = `if` / `elif` / `else` **ba nhánh**; **10–13** = bốn nhánh elif; **14–17** = hai `if` độc lập; **18–20** = `while` + `if` trong thân.*

### Bài 1 — Mức độ: Dễ
**Tự luyện #1**

**Đề bài (chi tiết):**  
`function g1(x)` — **C1** cho `if` / `elif` / `else` **ba nhánh** (như mẫu **1–9**). Tự chọn ngưỡng.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**4 TC**; bảng cạnh D1, D2; mỗi cạnh T/F **khả thi** đều có ✓.


---
### Bài 2 — Mức độ: Dễ
**Tự luyện #2**

**Đề bài (chi tiết):**  
`function g2(x)` — ba nhánh; **đổi** ngưỡng so với bài 1.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Kiểm tra **D2** chỉ đánh giá khi D1=F.


---
### Bài 3 — Mức độ: Dễ
**Tự luyện #3**

**Đề bài (chi tiết):**  
`function g3(x)` — ba nhánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
So sánh với **C0** file 01 cùng dạng.


---
### Bài 4 — Mức độ: Dễ
**Tự luyện #4**

**Đề bài (chi tiết):**  
`function g4(x)` — ba nhánh; điều kiện dạng so sánh **số**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ghi **kết luận** đủ **4** TC hay giảm được không (thường **không** với elif).


---
### Bài 5 — Mức độ: Dễ
**Tự luyện #5**

**Đề bài (chi tiết):**  
`function g5(x)` — ba nhánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Nhánh **không khả thi** → ghi *unreachable*.


---
### Bài 6 — Mức độ: Dễ
**Tự luyện #6**

**Đề bài (chi tiết):**  
`function g6(x)` — ba nhánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Dùng **bảng** TC × cạnh.


---
### Bài 7 — Mức độ: Dễ
**Tự luyện #7**

**Đề bài (chi tiết):**  
`function g7(x)` — ba nhánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Short-circuit **không** có trong elif tuần tự — đừng nhầm với `&&`.


---
### Bài 8 — Mức độ: Dễ
**Tự luyện #8**

**Đề bài (chi tiết):**  
`function g8(x)` — ba nhánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Chuẩn bị sang **10–13** (bốn nhánh).


---
### Bài 9 — Mức độ: Dễ
**Tự luyện #9**

**Đề bài (chi tiết):**  
`function g9(x)` — ba nhánh; **cuối** nhóm **1–9**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ôn lại định nghĩa **C1** trong [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md).


---
### Bài 10 — Mức độ: Trung bình
**Tự luyện #10**

**Đề bài (chi tiết):**  
`function g10(x)` — **bốn nhánh** `if` / `elif` / `elif` / `else`, **bốn** `return` (như mẫu **10–13**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**4 TC** tối thiểu; mỗi điều kiện trong chuỗi cần T/F **trong ngữ cảnh**.


---
### Bài 11 — Mức độ: Trung bình
**Tự luyện #11**

**Đề bài (chi tiết):**  
`function g11(x)` — bốn nhánh elif; **đổi** ngưỡng.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Thứ tự so sánh phải **không** chồng lấn sai.


---
### Bài 12 — Mức độ: Trung bình
**Tự luyện #12**

**Đề bài (chi tiết):**  
`function g12(x)` — bốn nhánh elif.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đối chiếu bài mẫu **C0** file 01 (cùng hình).


---
### Bài 13 — Mức độ: Khó
**Tự luyện #13**

**Đề bài (chi tiết):**  
`function g13(x)` — bốn nhánh elif; **hết** nhóm **10–13**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Bảng phủ nhánh đủ **8** cạnh (4 điều kiện × T/F) nếu liệt kê chi tiết.


---
### Bài 14 — Mức độ: Khó
**Tự luyện #14**

**Đề bài (chi tiết):**  
`function g14(a, b)` — **hai `if`** độc lập nối tiếp (như mẫu **14–17**); biến chuỗi hoặc số tùy chọn.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**4 tổ hợp** T/T, T/F, F/T, F/F — **4 TC** tối thiểu.


---
### Bài 15 — Mức độ: Khó
**Tự luyện #15**

**Đề bài (chi tiết):**  
`function g15(a, b)` — hai `if` độc lập; **đổi** điều kiện.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Dễ **bỏ sót** một cạnh — lập bảng trước.


---
### Bài 16 — Mức độ: Rất khó
**Tự luyện #16**

**Đề bài (chi tiết):**  
`function g16(a, b)` — hai `if` độc lập.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Không nhầm với **một** biểu thức `&&` một chỗ.


---
### Bài 17 — Mức độ: Rất khó
**Tự luyện #17**

**Đề bài (chi tiết):**  
`function g17(a, b)` — hai `if` độc lập; **hết** nhóm **14–17**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
So sánh với **MC/DC** (file 04) nếu gộp thành một quyết định — **khác** bài tập C1.


---
### Bài 18 — Mức độ: Rất khó
**Tự luyện #18**

**Đề bài (chi tiết):**  
`function g18(n)` — vòng `while j < n` + `if` trong thân (dùng biến **`idx`** hoặc `j` cho chỉ số; **không** dùng `i` nếu dễ nhầm số bài). **C1** cho điều kiện vòng **và** `if` trong.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
`n=0`; `n` nhỏ để có lần lặp với `if` T và F.


---
### Bài 19 — Mức độ: Cực khó · tổng hợp
**Tự luyện #19**

**Đề bài (chi tiết):**  
`function g19(n)` — `while` + `if` với điều kiện **khác** bài 18 (vd. so `j` với hằng).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Cần **≥3 TC** thường gặp.


---
### Bài 20 — Mức độ: Cực khó · tổng hợp
**Tự luyện #20**

**Đề bài (chi tiết):**  
`function g20(n)` — `while` + `if`; **đỉnh** file 02 — hoàn thiện bảng C1 đầy đủ.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Vẽ CFG trước; ghi **kết luận** số TC.


---

*Tài liệu chỉnh sửa trực tiếp trong file này; có thể bổ sung ví dụ số theo lớp.*
