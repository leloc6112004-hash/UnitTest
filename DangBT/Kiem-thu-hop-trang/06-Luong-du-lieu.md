# Bài tập: Kiểm thử luồng dữ liệu (Data flow)

**Chương:** Kiểm thử hộp trắng  
Tham chiếu: [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) — mục 7.

**Cấu trúc file:** **PHẦN 1: BÀI TẬP MẪU** (20 bài, lời giải chi tiết) · **PHẦN 2: BÀI TẬP TỰ LUYỆN** (20 bài, đề + gợi ý).

---

## Quy trình chuẩn

1. Đánh **def / use** (c-use, p-use) cho biến quan tâm.  
2. Liệt kê cặp **def→use** **def-clear** (theo đề).  
3. Thiết kế TC cho **all-defs** hoặc **all-uses**.

**Thang độ khó:** Bài **10–20** tăng dần — **một biến** nhiều **def** + vòng lặp (10–15); **16–20** thêm **hàm con** / tham số (luồng qua lời gọi).

---

## PHẦN 1: BÀI TẬP MẪU

---

### Bài mẫu 1 — Mức độ: Dễ
**def / use biến `s`**



**Đề bài (chi tiết):**

```text
function df1():
    s = 0              // def1
    if input() > 1:
        s = s + 1  // use(s) rồi def2
    else:
        s = s - 1  // use rồi def3
    return s           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `s±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 2 — Mức độ: Dễ
**def / use biến `acc`**



**Đề bài (chi tiết):**

```text
function df2():
    acc = 0              // def1
    if input() > 2:
        acc = acc + 1  // use(acc) rồi def2
    else:
        acc = acc - 1  // use rồi def3
    return acc           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `acc±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 3 — Mức độ: Dễ
**def / use biến `v`**



**Đề bài (chi tiết):**

```text
function df3():
    v = 0              // def1
    if input() > 3:
        v = v + 1  // use(v) rồi def2
    else:
        v = v - 1  // use rồi def3
    return v           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `v±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 4 — Mức độ: Dễ
**def / use biến `sum`**



**Đề bài (chi tiết):**

```text
function df4():
    sum = 0              // def1
    if input() > 4:
        sum = sum + 1  // use(sum) rồi def2
    else:
        sum = sum - 1  // use rồi def3
    return sum           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `sum±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 5 — Mức độ: Dễ
**def / use biến `r`**



**Đề bài (chi tiết):**

```text
function df5():
    r = 0              // def1
    if input() > 0:
        r = r + 1  // use(r) rồi def2
    else:
        r = r - 1  // use rồi def3
    return r           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `r±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 6 — Mức độ: Trung bình
**def / use biến `w`**



**Đề bài (chi tiết):**

```text
function df6():
    w = 0              // def1
    if input() > 1:
        w = w + 1  // use(w) rồi def2
    else:
        w = w - 1  // use rồi def3
    return w           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `w±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 7 — Mức độ: Trung bình
**def / use biến `z`**



**Đề bài (chi tiết):**

```text
function df7():
    z = 0              // def1
    if input() > 2:
        z = z + 1  // use(z) rồi def2
    else:
        z = z - 1  // use rồi def3
    return z           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `z±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 8 — Mức độ: Trung bình
**def / use biến `t`**



**Đề bài (chi tiết):**

```text
function df8():
    t = 0              // def1
    if input() > 3:
        t = t + 1  // use(t) rồi def2
    else:
        t = t - 1  // use rồi def3
    return t           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `t±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 9 — Mức độ: Trung bình
**def / use biến `s`**



**Đề bài (chi tiết):**

```text
function df9():
    s = 0              // def1
    if input() > 4:
        s = s + 1  // use(s) rồi def2
    else:
        s = s - 1  // use rồi def3
    return s           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – def:** dòng gán đầu (def1); trong then (def2); trong else (def3).  
**Bước 2 – use:** trong biểu thức gán (+/−); **p-use** tại `if`; **c-use** khi tính `s±1`; **c-use** tại `return`.

**Bước 3 – All-defs (ví dụ):**  
- TC1: điều kiện **T** → def1 → use → def2 → return (def2→use return).  
- TC2: điều kiện **F** → def1 → use → def3 → return.

**Bước 4 – Bảng cặp def→use (def-clear đơn giản):**

| Cặp | TC1 | TC2 |
|-----|-----|-----|
| def1 → p-use(if) | ✓ | ✓ |
| def1 → c-use (+/-) | ✓ | ✓ |
| def2 → return | ✓ | |
| def3 → return | | ✓ |

**Bước 5 – Kết luận:** **2 TC** tối thiểu để mỗi **nhánh if** chạy và mỗi **def cuối** trước return được dùng.

---
### Bài mẫu 10 — Mức độ: Trung bình · nâng cao (1)
**Data flow: `acc` xuyên suốt if + while**


*(Bài 10–15: nhiều **def** và **c-use** / **p-use** trên cùng biến.)*

**Đề bài (chi tiết):**

```text
function df10(seed):  // seed nguyên
    acc = seed           // def1
    if acc > 2:
        acc = acc * 2    // use acc, def2
    else:
        acc = acc - 1    // use, def3
    while acc < 20:
        if acc % 2 == 0:
            acc = acc + 3   // use, def4
        else:
            acc = acc + 1   // use, def5
    return acc           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:**  
- Liệt kê **mọi def** của `acc` và **use** tương ứng (p-use tại `if` / `while`; c-use trong biểu thức).  
- **All-defs / all-uses** (theo yêu cầu lớp): tối thiểu **≥3 TC** để các def “sâu” (def4/def5) xuất hiện.

**Bước 2 – Kết luận:** Khó hơn bài **1–9** (một `if` đơn).

---
### Bài mẫu 11 — Mức độ: Trung bình · nâng cao (2)
**Data flow: `acc` xuyên suốt if + while**


*(Bài 10–15: nhiều **def** và **c-use** / **p-use** trên cùng biến.)*

**Đề bài (chi tiết):**

```text
function df11(seed):  // seed nguyên
    acc = seed           // def1
    if acc > 3:
        acc = acc * 2    // use acc, def2
    else:
        acc = acc - 1    // use, def3
    while acc < 20:
        if acc % 2 == 0:
            acc = acc + 3   // use, def4
        else:
            acc = acc + 1   // use, def5
    return acc           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:**  
- Liệt kê **mọi def** của `acc` và **use** tương ứng (p-use tại `if` / `while`; c-use trong biểu thức).  
- **All-defs / all-uses** (theo yêu cầu lớp): tối thiểu **≥3 TC** để các def “sâu” (def4/def5) xuất hiện.

**Bước 2 – Kết luận:** Khó hơn bài **1–9** (một `if` đơn).

---
### Bài mẫu 12 — Mức độ: Khó (mức 1)
**Data flow: `acc` xuyên suốt if + while**


*(Bài 10–15: nhiều **def** và **c-use** / **p-use** trên cùng biến.)*

**Đề bài (chi tiết):**

```text
function df12(seed):  // seed nguyên
    acc = seed           // def1
    if acc > 0:
        acc = acc * 2    // use acc, def2
    else:
        acc = acc - 1    // use, def3
    while acc < 20:
        if acc % 2 == 0:
            acc = acc + 3   // use, def4
        else:
            acc = acc + 1   // use, def5
    return acc           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:**  
- Liệt kê **mọi def** của `acc` và **use** tương ứng (p-use tại `if` / `while`; c-use trong biểu thức).  
- **All-defs / all-uses** (theo yêu cầu lớp): tối thiểu **≥3 TC** để các def “sâu” (def4/def5) xuất hiện.

**Bước 2 – Kết luận:** Khó hơn bài **1–9** (một `if` đơn).

---
### Bài mẫu 13 — Mức độ: Khó (mức 2)
**Data flow: `acc` xuyên suốt if + while**


*(Bài 10–15: nhiều **def** và **c-use** / **p-use** trên cùng biến.)*

**Đề bài (chi tiết):**

```text
function df13(seed):  // seed nguyên
    acc = seed           // def1
    if acc > 1:
        acc = acc * 2    // use acc, def2
    else:
        acc = acc - 1    // use, def3
    while acc < 20:
        if acc % 2 == 0:
            acc = acc + 3   // use, def4
        else:
            acc = acc + 1   // use, def5
    return acc           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:**  
- Liệt kê **mọi def** của `acc` và **use** tương ứng (p-use tại `if` / `while`; c-use trong biểu thức).  
- **All-defs / all-uses** (theo yêu cầu lớp): tối thiểu **≥3 TC** để các def “sâu” (def4/def5) xuất hiện.

**Bước 2 – Kết luận:** Khó hơn bài **1–9** (một `if` đơn).

---
### Bài mẫu 14 — Mức độ: Khó (mức 3)
**Data flow: `acc` xuyên suốt if + while**


*(Bài 10–15: nhiều **def** và **c-use** / **p-use** trên cùng biến.)*

**Đề bài (chi tiết):**

```text
function df14(seed):  // seed nguyên
    acc = seed           // def1
    if acc > 2:
        acc = acc * 2    // use acc, def2
    else:
        acc = acc - 1    // use, def3
    while acc < 20:
        if acc % 2 == 0:
            acc = acc + 3   // use, def4
        else:
            acc = acc + 1   // use, def5
    return acc           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:**  
- Liệt kê **mọi def** của `acc` và **use** tương ứng (p-use tại `if` / `while`; c-use trong biểu thức).  
- **All-defs / all-uses** (theo yêu cầu lớp): tối thiểu **≥3 TC** để các def “sâu” (def4/def5) xuất hiện.

**Bước 2 – Kết luận:** Khó hơn bài **1–9** (một `if` đơn).

---
### Bài mẫu 15 — Mức độ: Khó · phức tạp
**Data flow: `acc` xuyên suốt if + while**


*(Bài 10–15: nhiều **def** và **c-use** / **p-use** trên cùng biến.)*

**Đề bài (chi tiết):**

```text
function df15(seed):  // seed nguyên
    acc = seed           // def1
    if acc > 3:
        acc = acc * 2    // use acc, def2
    else:
        acc = acc - 1    // use, def3
    while acc < 20:
        if acc % 2 == 0:
            acc = acc + 3   // use, def4
        else:
            acc = acc + 1   // use, def5
    return acc           // use cuối
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:**  
- Liệt kê **mọi def** của `acc` và **use** tương ứng (p-use tại `if` / `while`; c-use trong biểu thức).  
- **All-defs / all-uses** (theo yêu cầu lớp): tối thiểu **≥3 TC** để các def “sâu” (def4/def5) xuất hiện.

**Bước 2 – Kết luận:** Khó hơn bài **1–9** (một `if` đơn).

---
### Bài mẫu 16 — Mức độ: Rất khó (mức 1)
**Data flow: tham số & hàm con**


*(Bài 16–20: **def/use** trên tham số và qua lời gọi — cần đồ thị luồng.)*

**Đề bài (chi tiết):**

```text
function helper16(u, v):
    t = u + v        // def t; use u,v (c-use)
    if t < 0:
        t = t + 10   // def2
    return t         // use t

function df16(a):
    b = a - 0     // def b; use a
    c = helper16(b, 2)   // use b; c nhận return (def c)
    if c > 5:
        c = c - 1    // use/def c
    return c
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:** Chọn **một** biến (`t` hoặc `c`) làm trọng tâm; liệt kê **cặp def→use** def-clear; thiết kế **≥4 TC** cho **all-defs** hoặc **all-uses** (ghi rõ tiêu chí).

**Bước 2 – Kết luận:** Tổng hợp **data flow** — bài **16–20** khó dần so với **10–15**.

---
### Bài mẫu 17 — Mức độ: Rất khó (mức 2)
**Data flow: tham số & hàm con**


*(Bài 16–20: **def/use** trên tham số và qua lời gọi — cần đồ thị luồng.)*

**Đề bài (chi tiết):**

```text
function helper17(u, v):
    t = u + v        // def t; use u,v (c-use)
    if t < 0:
        t = t + 10   // def2
    return t         // use t

function df17(a):
    b = a - 1     // def b; use a
    c = helper17(b, 2)   // use b; c nhận return (def c)
    if c > 5:
        c = c - 1    // use/def c
    return c
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:** Chọn **một** biến (`t` hoặc `c`) làm trọng tâm; liệt kê **cặp def→use** def-clear; thiết kế **≥4 TC** cho **all-defs** hoặc **all-uses** (ghi rõ tiêu chí).

**Bước 2 – Kết luận:** Tổng hợp **data flow** — bài **16–20** khó dần so với **10–15**.

---
### Bài mẫu 18 — Mức độ: Rất khó (mức 3)
**Data flow: tham số & hàm con**


*(Bài 16–20: **def/use** trên tham số và qua lời gọi — cần đồ thị luồng.)*

**Đề bài (chi tiết):**

```text
function helper18(u, v):
    t = u + v        // def t; use u,v (c-use)
    if t < 0:
        t = t + 10   // def2
    return t         // use t

function df18(a):
    b = a - 2     // def b; use a
    c = helper18(b, 2)   // use b; c nhận return (def c)
    if c > 5:
        c = c - 1    // use/def c
    return c
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:** Chọn **một** biến (`t` hoặc `c`) làm trọng tâm; liệt kê **cặp def→use** def-clear; thiết kế **≥4 TC** cho **all-defs** hoặc **all-uses** (ghi rõ tiêu chí).

**Bước 2 – Kết luận:** Tổng hợp **data flow** — bài **16–20** khó dần so với **10–15**.

---
### Bài mẫu 19 — Mức độ: Cực khó
**Data flow: tham số & hàm con**


*(Bài 16–20: **def/use** trên tham số và qua lời gọi — cần đồ thị luồng.)*

**Đề bài (chi tiết):**

```text
function helper19(u, v):
    t = u + v        // def t; use u,v (c-use)
    if t < 0:
        t = t + 10   // def2
    return t         // use t

function df19(a):
    b = a - 3     // def b; use a
    c = helper19(b, 2)   // use b; c nhận return (def c)
    if c > 5:
        c = c - 1    // use/def c
    return c
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:** Chọn **một** biến (`t` hoặc `c`) làm trọng tâm; liệt kê **cặp def→use** def-clear; thiết kế **≥4 TC** cho **all-defs** hoặc **all-uses** (ghi rõ tiêu chí).

**Bước 2 – Kết luận:** Tổng hợp **data flow** — bài **16–20** khó dần so với **10–15**.

---
### Bài mẫu 20 — Mức độ: Cực khó · tổng hợp
**Data flow: tham số & hàm con**


*(Bài 16–20: **def/use** trên tham số và qua lời gọi — cần đồ thị luồng.)*

**Đề bài (chi tiết):**

```text
function helper20(u, v):
    t = u + v        // def t; use u,v (c-use)
    if t < 0:
        t = t + 10   // def2
    return t         // use t

function df20(a):
    b = a - 0     // def b; use a
    c = helper20(b, 2)   // use b; c nhận return (def c)
    if c > 5:
        c = c - 1    // use/def c
    return c
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:** Chọn **một** biến (`t` hoặc `c`) làm trọng tâm; liệt kê **cặp def→use** def-clear; thiết kế **≥4 TC** cho **all-defs** hoặc **all-uses** (ghi rõ tiêu chí).

**Bước 2 – Kết luận:** Tổng hợp **data flow** — bài **16–20** khó dần so với **10–15**.

---

## PHẦN 2: BÀI TẬP TỰ LUYỆN

---

*20 bài — luồng dữ liệu.*

*Chỉ có **đề** và **gợi ý**; làm đủ bảng CFG / TC / phủ như **PHẦN 1** khi nộp.*  
*Thang **khớp PHẦN 1:** **1–9** = **một** biến quan tâm qua `if/else` đơn (như `t`,`s`,…); **10–15** = **một** biến qua `if` + `while` + `if` trong vòng (kiểu `acc`); **16–20** = **hàm con** + tham số / biến trung gian (kiểu `helper` + `c`).*

### Bài 1 — Mức độ: Dễ
**Tự luyện #1**

**Đề bài (chi tiết):**  
Chọn **một** tên biến; viết mã giả **if** / **else** gán biến đó rồi **return** — **all-defs** hoặc **all-uses** (như mẫu **1–9**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
def-clear; đánh dấu **p-use** / **c-use**.


---
### Bài 2 — Mức độ: Dễ
**Tự luyện #2**

**Đề bài (chi tiết):**  
Cùng dạng bài **1** — **đổi** tên biến / điều kiện.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Bảng cặp def→use.


---
### Bài 3 — Mức độ: Dễ
**Tự luyện #3**

**Đề bài (chi tiết):**  
Một biến, **hai nhánh** gán khác nhau trước `return`.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Tối thiểu **2 TC** thường đủ all-defs đơn giản.


---
### Bài 4 — Mức độ: Dễ
**Tự luyện #4**

**Đề bài (chi tiết):**  
Một biến — thêm **use** trong biểu thức `if`.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ghi rõ **p-use** tại điều kiện.


---
### Bài 5 — Mức độ: Dễ
**Tự luyện #5**

**Đề bài (chi tiết):**  
Một biến — **đổi** thứ tự def/use so với bài 4.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Kiểm tra **def-clear** theo đề.


---
### Bài 6 — Mức độ: Dễ
**Tự luyện #6**

**Đề bài (chi tiết):**  
Một biến — ôn **all-uses**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
So [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) mục 7.


---
### Bài 7 — Mức độ: Dễ
**Tự luyện #7**

**Đề bài (chi tiết):**  
Một biến — kết hợp **c-use** trong phép gán và **p-use**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Liệt kê **đủ** cặp (def→use).


---
### Bài 8 — Mức độ: Dễ
**Tự luyện #8**

**Đề bài (chi tiết):**  
Một biến — biến thể **khác** bài 1–7.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Chuẩn bị **vòng lặp** (bài 10+).


---
### Bài 9 — Mức độ: Dễ
**Tự luyện #9**

**Đề bài (chi tiết):**  
Một biến — **cuối** nhóm **1–9**; tóm tắt 1 trang.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đối chiếu mẫu PHẦN 1 tương ứng số bài.


---
### Bài 10 — Mức độ: Trung bình
**Tự luyện #10**

**Đề bài (chi tiết):**  
Biến `acc` (hoặc tên khác): `if` / `else` gán, rồi **`while`** với **`if` chẵn/lẻ** trong thân — như mẫu **10–15**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**≥3 TC**; nhiều **def** trung gian; chọn **all-defs** hoặc **all-uses**.


---
### Bài 11 — Mức độ: Trung bình
**Tự luyện #11**

**Đề bài (chi tiết):**  
`acc` + `while` — **đổi** điều kiện vòng / điều kiện trong.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Vẽ CFG có vòng lặp.


---
### Bài 12 — Mức độ: Trung bình
**Tự luyện #12**

**Đề bài (chi tiết):**  
Cùng dạng **10–15** — hoàn thiện bảng cặp.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
def-clear xuyên vòng.


---
### Bài 13 — Mức độ: Khó
**Tự luyện #13**

**Đề bài (chi tiết):**  
`acc` + `while` — biến thể **khác** 10–12.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Một **def** “sâu” trong vòng phải có TC.


---
### Bài 14 — Mức độ: Khó
**Tự luyện #14**

**Đề bài (chi tiết):**  
`acc` + `while` + `if` — **đổi** ngưỡng so sánh.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đếm **def** trên cùng một biến.


---
### Bài 15 — Mức độ: Khó
**Tự luyện #15**

**Đề bài (chi tiết):**  
`acc` + `while` — **hết** nhóm **10–15**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Kết luận tiêu chí (all-defs / all-uses).


---
### Bài 16 — Mức độ: Rất khó
**Tự luyện #16**

**Đề bài (chi tiết):**  
`helper(u,v)` + `df(a)` — luồng **qua lời gọi** (như mẫu **16–20**); chọn biến `t` hoặc `c` làm trọng tâm.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**≥4 TC**; cặp def→use **def-clear**.


---
### Bài 17 — Mức độ: Rất khó
**Tự luyện #17**

**Đề bài (chi tiết):**  
Hai hàm — **đổi** tham số / điều kiện trong `helper`.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**c-use** / **p-use** trên tham số.


---
### Bài 18 — Mức độ: Rất khó
**Tự luyện #18**

**Đề bài (chi tiết):**  
Hàm con — thêm **nhánh** trong `helper`.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đồ thị luồng qua **call**.


---
### Bài 19 — Mức độ: Cực khó · tổng hợp
**Tự luyện #19**

**Đề bài (chi tiết):**  
Hàm con — **đổi** chỗ **def** / **use** giữa caller / callee.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ghi rõ tiêu chí nộp (all-defs hay all-uses).


---
### Bài 20 — Mức độ: Cực khó · tổng hợp
**Tự luyện #20**

**Đề bài (chi tiết):**  
**Tổng hợp** — tự thiết kế `helper` + caller (≥**12** dòng mã giả), **≥4 TC**, hoàn chỉnh bảng data flow — **đỉnh** file 06.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Liên hệ **07** (module lớn) nếu ôn thi.


---

*Tài liệu chỉnh sửa trực tiếp trong file này; có thể bổ sung ví dụ số theo lớp.*
