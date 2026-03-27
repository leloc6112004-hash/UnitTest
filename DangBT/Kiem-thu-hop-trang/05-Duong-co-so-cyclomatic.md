# Bài tập: Cyclomatic complexity V(G) & Kiểm thử đường cơ sở

**Chương:** Kiểm thử hộp trắng  
Tham chiếu: [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) — mục 6.

**Cấu trúc file:** **PHẦN 1: BÀI TẬP MẪU** (20 bài, lời giải chi tiết) · **PHẦN 2: BÀI TẬP TỰ LUYỆN** (20 bài, đề + gợi ý).

---

## Quy trình chuẩn

1. Vẽ **CFG**.  
2. Tính **V(G)** (D+1 hoặc E−N+2 — **thống nhất với slide lớp**).  
3. Chọn **V(G) đường** basis path (lật nhánh dần).  
4. Gán **đầu vào** khả thi cho từng đường.

**Thang độ khó:** Bài **10–20** tăng dần — **V(G)** cao hơn (nhiều `if` nối tiếp / lồng sâu / vòng + nhánh).

---

## PHẦN 1: BÀI TẬP MẪU

---

### Bài mẫu 1 — Mức độ: Dễ
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v1(a, b):
    s = 0
    if a > 1:
        s = s + 1
    if b < 3:
        s = s + 10
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Hai `if` nối tiếp (độc lập):** **D = 2** quyết định → **V(G) = 3**.  
**Bước 2 – V(G) = D + 1 = 3** (một entry/exit, hai nút rẽ).  
**Bước 3 – Bảng đường / TC gợi ý (4 tổ hợp a,b):**

| Đường | a | b | D1(a>1) | D2(b<3) | s |
|-------|---|---|-----------|-------------|---|
| p1 | 0 | 6 | F | F | 0 |
| p2 | 6 | 6 | T | F | 1 |
| p3 | 0 | 1 | F | T | 10 |

**Bước 4 – Đường thứ 4 (D1=T, D2=T):** `a=6`, `b=1` → s=11.  
→ **4 đường** tương ứng **đủ basis** khi liệt kê độc lập theo slide (hoặc **3 đường** nếu giảng viên dùng V(G)=3 chỉ yêu cầu 3 path đại diện — **thống nhất slide**).

---
### Bài mẫu 2 — Mức độ: Dễ
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v2(x):
    s = 0
    if x < 3:
        if x < 0:
            s = -1
        else:
            s = 1
    else:
        s = 2
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – if lồng:** Quyết định ngoài `x<3`, trong then có `x<0` → **V(G)=3** (D+1 với D=2 điểm rẽ).  
**Bước 2 – Test tối thiểu theo nhánh:**

| TC | x | Đường | s |
|----|---|--------|---|
| T1 | -1 | ngoài T, trong T | -1 |
| T2 | 0 | ngoài T, trong F | 1 |
| T3 | 6 | ngoài F | 2 |

---
### Bài mẫu 3 — Mức độ: Dễ
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v3(n):
    i = 0
    s = 0
    while i < n:
        if i == 0:
            s = s + 2
        i = i + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while + if trong thân:** Đếm **điểm quyết định** trên CFG (1 vòng `i<n`, 1 `i==0`) → thường **V(G)=4** (theo cách vẽ có **3** vùng + ngoài hoặc **D+1** với D=3).  
**Bước 2 – Gợi ý:** Vẽ CFG có: kiểm tra vòng, thân vòng (gồm if), tăng i, quay lại.  
**Bước 3 – Test:** `n=0` (không vào thân), `n=1`… để lần lượt **vào if** true/false trong vòng.

**Bước 4 – Kết luận:** **V(G)** phụ thuộc cách **gộp nút**; sinh viên **phải** vẽ CFG và đếm **E, N** hoặc **D+1** thống nhất với lớp.

---
### Bài mẫu 4 — Mức độ: Dễ
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v4(x):
    s = 0
    if x < 4:
        s = 1
    else:
        s = 2
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG / V(G):** 1 quyết định `x<4` → **D = 1** → **V(G)=2**.  
**Bước 2 – Basis path (theo nghĩa lớp):** thực tế với **1 if** chỉ có **2** đường rời: T và F (thường lấy 2 đường độc lập + đường nền).  
**Bước 3 – Test:** `x=3` (T), `x=7` (F).  
**Bước 4 – Bảng basis path (2 đường):**

| Đường | Điều kiện | x (ví dụ) | s |
|-------|-----------|-----------|---|
| p1 | nhánh T | 3 | 1 |
| p2 | nhánh F | 7 | 2 |

---
### Bài mẫu 5 — Mức độ: Dễ
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v5(a, b):
    s = 0
    if a > 5:
        s = s + 1
    if b < 7:
        s = s + 10
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Hai `if` nối tiếp (độc lập):** **D = 2** quyết định → **V(G) = 3**.  
**Bước 2 – V(G) = D + 1 = 3** (một entry/exit, hai nút rẽ).  
**Bước 3 – Bảng đường / TC gợi ý (4 tổ hợp a,b):**

| Đường | a | b | D1(a>5) | D2(b<7) | s |
|-------|---|---|-----------|-------------|---|
| p1 | 4 | 10 | F | F | 0 |
| p2 | 10 | 10 | T | F | 1 |
| p3 | 4 | 5 | F | T | 10 |

**Bước 4 – Đường thứ 4 (D1=T, D2=T):** `a=10`, `b=5` → s=11.  
→ **4 đường** tương ứng **đủ basis** khi liệt kê độc lập theo slide (hoặc **3 đường** nếu giảng viên dùng V(G)=3 chỉ yêu cầu 3 path đại diện — **thống nhất slide**).

---
### Bài mẫu 6 — Mức độ: Trung bình
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v6(x):
    s = 0
    if x < 7:
        if x < 0:
            s = -1
        else:
            s = 1
    else:
        s = 2
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – if lồng:** Quyết định ngoài `x<7`, trong then có `x<0` → **V(G)=3** (D+1 với D=2 điểm rẽ).  
**Bước 2 – Test tối thiểu theo nhánh:**

| TC | x | Đường | s |
|----|---|--------|---|
| T1 | -1 | ngoài T, trong T | -1 |
| T2 | 0 | ngoài T, trong F | 1 |
| T3 | 10 | ngoài F | 2 |

---
### Bài mẫu 7 — Mức độ: Trung bình
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v7(n):
    i = 0
    s = 0
    while i < n:
        if i == 0:
            s = s + 2
        i = i + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while + if trong thân:** Đếm **điểm quyết định** trên CFG (1 vòng `i<n`, 1 `i==0`) → thường **V(G)=4** (theo cách vẽ có **3** vùng + ngoài hoặc **D+1** với D=3).  
**Bước 2 – Gợi ý:** Vẽ CFG có: kiểm tra vòng, thân vòng (gồm if), tăng i, quay lại.  
**Bước 3 – Test:** `n=0` (không vào thân), `n=1`… để lần lượt **vào if** true/false trong vòng.

**Bước 4 – Kết luận:** **V(G)** phụ thuộc cách **gộp nút**; sinh viên **phải** vẽ CFG và đếm **E, N** hoặc **D+1** thống nhất với lớp.

---
### Bài mẫu 8 — Mức độ: Trung bình
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v8(x):
    s = 0
    if x < 1:
        s = 1
    else:
        s = 2
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – CFG / V(G):** 1 quyết định `x<1` → **D = 1** → **V(G)=2**.  
**Bước 2 – Basis path (theo nghĩa lớp):** thực tế với **1 if** chỉ có **2** đường rời: T và F (thường lấy 2 đường độc lập + đường nền).  
**Bước 3 – Test:** `x=0` (T), `x=4` (F).  
**Bước 4 – Bảng basis path (2 đường):**

| Đường | Điều kiện | x (ví dụ) | s |
|-------|-----------|-----------|---|
| p1 | nhánh T | 0 | 1 |
| p2 | nhánh F | 4 | 2 |

---
### Bài mẫu 9 — Mức độ: Trung bình
**Cyclomatic / đường cơ sở**



**Đề bài (chi tiết):**

```text
function v9(a, b):
    s = 0
    if a > 2:
        s = s + 1
    if b < 4:
        s = s + 10
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Hai `if` nối tiếp (độc lập):** **D = 2** quyết định → **V(G) = 3**.  
**Bước 2 – V(G) = D + 1 = 3** (một entry/exit, hai nút rẽ).  
**Bước 3 – Bảng đường / TC gợi ý (4 tổ hợp a,b):**

| Đường | a | b | D1(a>2) | D2(b<4) | s |
|-------|---|---|-----------|-------------|---|
| p1 | 1 | 7 | F | F | 0 |
| p2 | 7 | 7 | T | F | 1 |
| p3 | 1 | 2 | F | T | 10 |

**Bước 4 – Đường thứ 4 (D1=T, D2=T):** `a=7`, `b=2` → s=11.  
→ **4 đường** tương ứng **đủ basis** khi liệt kê độc lập theo slide (hoặc **3 đường** nếu giảng viên dùng V(G)=3 chỉ yêu cầu 3 path đại diện — **thống nhất slide**).

---
### Bài mẫu 10 — Mức độ: Trung bình · nâng cao (1)
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v10(x, y):
    s = 0
    if x < 2:
        if y > 0:
            s = 1
        else:
            s = 2
    else:
        if y == 0:
            s = 3
        else:
            s = 4
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – if lồng hai tầng (hai cấp):** trên CFG thường **4** điểm rẽ → **V(G)** hay gặp **5** (D+1) hoặc theo cách đếm **E−N+2** — **thống nhất slide**.  
**Bước 2 – TC gợi ý:** **≥4 TC** `(x,y)` để đi qua **mỗi nhánh lá** (s ∈ {1,2,3,4}).  
**Bước 3 – Basis path:** liệt kê **V(G)** đường độc lập; ghi rõ điều kiện từng tầng.

---
### Bài mẫu 11 — Mức độ: Trung bình · nâng cao (2)
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v11(x, y):
    s = 0
    if x < 3:
        if y > 0:
            s = 1
        else:
            s = 2
    else:
        if y == 0:
            s = 3
        else:
            s = 4
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – if lồng hai tầng (hai cấp):** trên CFG thường **4** điểm rẽ → **V(G)** hay gặp **5** (D+1) hoặc theo cách đếm **E−N+2** — **thống nhất slide**.  
**Bước 2 – TC gợi ý:** **≥4 TC** `(x,y)` để đi qua **mỗi nhánh lá** (s ∈ {1,2,3,4}).  
**Bước 3 – Basis path:** liệt kê **V(G)** đường độc lập; ghi rõ điều kiện từng tầng.

---
### Bài mẫu 12 — Mức độ: Khó (mức 1)
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v12(x, y):
    s = 0
    if x < 4:
        if y > 0:
            s = 1
        else:
            s = 2
    else:
        if y == 0:
            s = 3
        else:
            s = 4
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – if lồng hai tầng (hai cấp):** trên CFG thường **4** điểm rẽ → **V(G)** hay gặp **5** (D+1) hoặc theo cách đếm **E−N+2** — **thống nhất slide**.  
**Bước 2 – TC gợi ý:** **≥4 TC** `(x,y)` để đi qua **mỗi nhánh lá** (s ∈ {1,2,3,4}).  
**Bước 3 – Basis path:** liệt kê **V(G)** đường độc lập; ghi rõ điều kiện từng tầng.

---
### Bài mẫu 13 — Mức độ: Khó (mức 2)
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v13(x, y):
    s = 0
    if x < 5:
        if y > 0:
            s = 1
        else:
            s = 2
    else:
        if y == 0:
            s = 3
        else:
            s = 4
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – if lồng hai tầng (hai cấp):** trên CFG thường **4** điểm rẽ → **V(G)** hay gặp **5** (D+1) hoặc theo cách đếm **E−N+2** — **thống nhất slide**.  
**Bước 2 – TC gợi ý:** **≥4 TC** `(x,y)` để đi qua **mỗi nhánh lá** (s ∈ {1,2,3,4}).  
**Bước 3 – Basis path:** liệt kê **V(G)** đường độc lập; ghi rõ điều kiện từng tầng.

---
### Bài mẫu 14 — Mức độ: Khó (mức 3)
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v14(n, k):
    idx = 0
    s = 0
    while idx < n:
        if idx != k:
            s = s + 1
        else:
            s = s + 10
        idx = idx + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while + if/else trong thân:** đếm **điều kiện vòng** và **if** → **V(G)** thường **4–5**.  
**Bước 2 – Gợi ý TC:** `n=0`; `n` nhỏ với `k` **trong** / **ngoài** phạ vi `0..n-1`; lặp nhiều lần để cả nhánh **!=** và **==**.  
**Bước 3 – Basis path:** phải có đường **0 lần lặp**, **có lặp không vào else**, **có lặp vào else**.

---
### Bài mẫu 15 — Mức độ: Khó · phức tạp
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v15(n, k):
    idx = 0
    s = 0
    while idx < n:
        if idx != k:
            s = s + 1
        else:
            s = s + 10
        idx = idx + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while + if/else trong thân:** đếm **điều kiện vòng** và **if** → **V(G)** thường **4–5**.  
**Bước 2 – Gợi ý TC:** `n=0`; `n` nhỏ với `k` **trong** / **ngoài** phạ vi `0..n-1`; lặp nhiều lần để cả nhánh **!=** và **==**.  
**Bước 3 – Basis path:** phải có đường **0 lần lặp**, **có lặp không vào else**, **có lặp vào else**.

---
### Bài mẫu 16 — Mức độ: Rất khó (mức 1)
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v16(n, k):
    idx = 0
    s = 0
    while idx < n:
        if idx != k:
            s = s + 1
        else:
            s = s + 10
        idx = idx + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while + if/else trong thân:** đếm **điều kiện vòng** và **if** → **V(G)** thường **4–5**.  
**Bước 2 – Gợi ý TC:** `n=0`; `n` nhỏ với `k` **trong** / **ngoài** phạ vi `0..n-1`; lặp nhiều lần để cả nhánh **!=** và **==**.  
**Bước 3 – Basis path:** phải có đường **0 lần lặp**, **có lặp không vào else**, **có lặp vào else**.

---
### Bài mẫu 17 — Mức độ: Rất khó (mức 2)
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v17(n, k):
    idx = 0
    s = 0
    while idx < n:
        if idx != k:
            s = s + 1
        else:
            s = s + 10
        idx = idx + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while + if/else trong thân:** đếm **điều kiện vòng** và **if** → **V(G)** thường **4–5**.  
**Bước 2 – Gợi ý TC:** `n=0`; `n` nhỏ với `k` **trong** / **ngoài** phạ vi `0..n-1`; lặp nhiều lần để cả nhánh **!=** và **==**.  
**Bước 3 – Basis path:** phải có đường **0 lần lặp**, **có lặp không vào else**, **có lặp vào else**.

---
### Bài mẫu 18 — Mức độ: Rất khó (mức 3)
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v18(m, cap):
    outer = 0
    s = 0
    while outer < m:
        j = 0
        while j < cap and s < 50:
            if (outer + j) % 3 == 0:
                s = s + 2
            j = j + 1
            if s > 40:
                break
        outer = outer + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while lồng + if + break:** CFG lớn — **bắt buộc vẽ hình**.  
**Bước 2 – V(G):** đếm mọi **điểm rẽ** (điều kiện vòng ngoài/trong, if, break, cạnh quay lại).  
**Bước 3 – Nhiệm vụ:** **≥5 basis path** hoặc đúng **V(G)** theo lớp; gán `(m,cap)` minh họa từng đường.  
**Bước 4 – Kết luận:** Bài **18–20** — tổng hợp **V(G)** khó nhất trong file 05.

---
### Bài mẫu 19 — Mức độ: Cực khó
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v19(m, cap):
    outer = 0
    s = 0
    while outer < m:
        j = 0
        while j < cap and s < 50:
            if (outer + j) % 3 == 0:
                s = s + 2
            j = j + 1
            if s > 40:
                break
        outer = outer + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while lồng + if + break:** CFG lớn — **bắt buộc vẽ hình**.  
**Bước 2 – V(G):** đếm mọi **điểm rẽ** (điều kiện vòng ngoài/trong, if, break, cạnh quay lại).  
**Bước 3 – Nhiệm vụ:** **≥5 basis path** hoặc đúng **V(G)** theo lớp; gán `(m,cap)` minh họa từng đường.  
**Bước 4 – Kết luận:** Bài **18–20** — tổng hợp **V(G)** khó nhất trong file 05.

---
### Bài mẫu 20 — Mức độ: Cực khó · tổng hợp
**Cyclomatic / đường cơ sở (nâng cao)**



**Đề bài (chi tiết):**

```text
function v20(m, cap):
    outer = 0
    s = 0
    while outer < m:
        j = 0
        while j < cap and s < 50:
            if (outer + j) % 3 == 0:
                s = s + 2
            j = j + 1
            if s > 40:
                break
        outer = outer + 1
    return s
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – while lồng + if + break:** CFG lớn — **bắt buộc vẽ hình**.  
**Bước 2 – V(G):** đếm mọi **điểm rẽ** (điều kiện vòng ngoài/trong, if, break, cạnh quay lại).  
**Bước 3 – Nhiệm vụ:** **≥5 basis path** hoặc đúng **V(G)** theo lớp; gán `(m,cap)` minh họa từng đường.  
**Bước 4 – Kết luận:** Bài **18–20** — tổng hợp **V(G)** khó nhất trong file 05.

---

## PHẦN 2: BÀI TẬP TỰ LUYỆN

---

*20 bài — V(G) và đường cơ sở.*

*Chỉ có **đề** và **gợi ý**; làm đủ bảng CFG / TC / phủ như **PHẦN 1** khi nộp.*  
*Thang **khớp PHẦN 1** (theo **số bài mẫu**): **1,4,8** — một `if`; **2,5,9** — hai `if` nối tiếp; **3,7** — `while` + `if` trong thân; **6** — `if` lồng; **10–13** — `if` lồng hai tầng `(x,y)`; **14–17** — `while` + `if/else` + `idx`; **18–20** — `while` lồng + `break`.*

### Bài 1 — Mức độ: Dễ
**Tự luyện #1**

**Đề bài (chi tiết):**  
Viết mã giả **một** `if` / `else` trên tham số (cùng ý `v1`, `v4`, `v8`); tính **V(G)** và **basis path**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Thường **V(G)=2**; **2** đường cơ sở.


---
### Bài 2 — Mức độ: Dễ
**Tự luyện #2**

**Đề bài (chi tiết):**  
**Hai** `if` **độc lập** nối tiếp (như `v2`, `v5`, `v9`).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**V(G)=3**; **4** tổ hợp đầu vào gợi ý.


---
### Bài 3 — Mức độ: Dễ
**Tự luyện #3**

**Đề bài (chi tiết):**  
`while idx < n` + **một** `if` trong thân (như `v3`).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**V(G)** thường **4**; có TC `n=0` và `n` đủ lớn để nhánh `if` T/F trong vòng.


---
### Bài 4 — Mức độ: Dễ
**Tự luyện #4**

**Đề bài (chi tiết):**  
Một `if` — **đổi** điều kiện so sánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Thống nhất **D+1** với slide lớp.


---
### Bài 5 — Mức độ: Dễ
**Tự luyện #5**

**Đề bài (chi tiết):**  
Hai `if` nối tiếp — **đổi** hằng so sánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Liệt kê **đủ** basis path trước khi gán TC.


---
### Bài 6 — Mức độ: Dễ
**Tự luyện #6**

**Đề bài (chi tiết):**  
`if` **lồng** một cấp trên tham số đơn (như `v6`); **đổi** ngưỡng ngoài/trong.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**V(G)=3**; **3** TC theo nhánh; vẽ CFG trước.


---
### Bài 7 — Mức độ: Dễ
**Tự luyện #7**

**Đề bài (chi tiết):**  
`while` + `if` trong thân (như `v7`); **đổi** điều kiện trong vòng.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**V(G)** thường **4**; so **E−N+2** với **D+1** nếu lớp dạy cả hai.


---
### Bài 8 — Mức độ: Dễ
**Tự luyện #8**

**Đề bài (chi tiết):**  
Một `if` / `else` (như `v8`); **đổi** ngưỡng.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**V(G)=2**; chuẩn bị nhóm **10–13** (if lồng trên `(x,y)`).


---
### Bài 9 — Mức độ: Dễ
**Tự luyện #9**

**Đề bài (chi tiết):**  
Hai `if` nối tiếp (như `v9`); **đổi** hằng so sánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**V(G)=3**; **4** tổ hợp `(a,b)`; **cuối** nhóm **1–9**.


---
### Bài 10 — Mức độ: Trung bình
**Tự luyện #10**

**Đề bài (chi tiết):**  
`function` hai tham số — **if lồng hai tầng** (như mẫu **10–13**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**≥4 TC**; **4** nhánh lá.


---
### Bài 11 — Mức độ: Trung bình
**Tự luyện #11**

**Đề bài (chi tiết):**  
If lồng hai tầng — **đổi** điều kiện.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Basis path theo **V(G)** đã đếm.


---
### Bài 12 — Mức độ: Trung bình
**Tự luyện #12**

**Đề bài (chi tiết):**  
If lồng hai tầng — hết nhóm **10–13**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đếm **điểm rẽ** kỹ.


---
### Bài 13 — Mức độ: Khó
**Tự luyện #13**

**Đề bài (chi tiết):**  
If lồng hai tầng — biến thể **khác** 10–12.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
So sánh với **C0** / **C1** nếu cùng hình.


---
### Bài 14 — Mức độ: Khó
**Tự luyện #14**

**Đề bài (chi tiết):**  
`while idx < n` + `if idx != k` / `else` (như mẫu **14–17**); dùng **`idx`** làm chỉ số vòng.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
`k` trong / ngoài `0..n-1`; basis có **0** lần lặp.


---
### Bài 15 — Mức độ: Khó
**Tự luyện #15**

**Đề bài (chi tiết):**  
`while` + `if/else` trong thân — **đổi** logic cập nhật `s`.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**V(G)** **4–5**.


---
### Bài 16 — Mức độ: Rất khó
**Tự luyện #16**

**Đề bài (chi tiết):**  
Cùng dạng bài **14–15** — hoàn thiện bảng path.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Gán `(n,k)` minh họa từng đường.


---
### Bài 17 — Mức độ: Rất khó
**Tự luyện #17**

**Đề bài (chi tiết):**  
`while` + `if/else` — **hết** nhóm **14–17**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Kiểm tra đường **không khả thi**.


---
### Bài 18 — Mức độ: Rất khó
**Tự luyện #18**

**Đề bài (chi tiết):**  
`while outer < m` lồng `while j < cap && …` + `if` + `break` (như mẫu **18–20**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**≥5 basis path** hoặc đúng **V(G)**; CFG **bắt buộc**.


---
### Bài 19 — Mức độ: Cực khó · tổng hợp
**Tự luyện #19**

**Đề bài (chi tiết):**  
While lồng + break — **đổi** điều kiện trong / điều kiện `break`.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đếm mọi **rẽ** kể **break**.


---
### Bài 20 — Mức độ: Cực khó · tổng hợp
**Tự luyện #20**

**Đề bài (chi tiết):**  
While lồng + break — **đỉnh** file 05; tự viết đề đầy đủ rồi chấm **V(G)** + basis.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Tổng hợp với **07** nếu ôn thi.


---

*Tài liệu chỉnh sửa trực tiếp trong file này; có thể bổ sung ví dụ số theo lớp.*
