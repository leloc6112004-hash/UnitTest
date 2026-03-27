# Bài tập: Độ phủ điều kiện & Condition/Decision (C/D)

**Chương:** Kiểm thử hộp trắng  
Tham chiếu: [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) — mục 4.

**Cấu trúc file:** **PHẦN 1: BÀI TẬP MẪU** (20 bài, lời giải chi tiết) · **PHẦN 2: BÀI TẬP TỰ LUYỆN** (20 bài, đề + gợi ý).

---

## Quy trình chuẩn

1. **Phân rã** điều kiện thành **atomic** C1, C2, …  
2. **Condition coverage:** mỗi atomic có **T** và **F** (có thể ở TC khác nhau).  
3. **C/D:** thêm **Decision** — cả biểu thức điều kiện **true** và **false**.  
4. Bảng TC × atomic × whole decision.

**Thang độ khó:** Bài **10–20** tăng dần — từ **3 điều kiện** / kết hợp `&&` `||` phức tạp hơn.

---

## PHẦN 1: BÀI TẬP MẪU

---

### Bài mẫu 1 — Mức độ: Dễ
**Điều kiện ghép `||` (C/D)**



**Đề bài (chi tiết):**

```text
function h1(a, b):
    if (a == 1) || (b == 0):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `(a==1)`, C2 ≡ `(b==0)`. **W** ≡ C1 ∨ C2.

**Bước 2 – Test C/D:**

| TC | a | b | C1 | C2 | W | out |
|----|---|---|----|----|---|-----|
| T1 | 0 | 1 | F | F | F | 0 |
| T2 | 1 | 1 | T | F | T | 1 |
| T3 | 0 | 0 | F | T | T | 1 |

**Bước 3 – Chứng minh:** Whole có F (T1) và T (T2,T3); mỗi atomic có đủ T và F.

**Bước 4 – Kết luận:** **3 TC** đạt **C/D** cho `||`.

---
### Bài mẫu 2 — Mức độ: Dễ
**So sánh số `(x>p) && (y<q)` (C/D)**



**Đề bài (chi tiết):**

```text
function h2(x, y):  // x,y nguyên
    if (x > 3) && (y < 5):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `x>3`, C2 ≡ `y<5`.

**Bước 2 – Test C/D (ví dụ):**

| TC | x | y | C1 | C2 | W |
|----|---|---|----|----|---|
| T1 | 5 | 4 | T | T | T |
| T2 | 2 | 4 | F | — | F |
| T3 | 5 | 7 | T | F | F |

**Bước 3 – Kết luận:** **3 TC** đạt **C/D**; nhớ **short-circuit** khi ghi lại đường thực thi.

---
### Bài mẫu 3 — Mức độ: Dễ
**Điều kiện ghép `&&` (C/D)**



**Đề bài (chi tiết):**

```text
function h3(a, b):  // a,b boolean 0/1
    if (a == 1) && (b == 1):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `(a==1)`, C2 ≡ `(b==1)`. **Whole decision** W ≡ C1 ∧ C2.

**Bước 2 – Test đạt Condition + Decision:**

| TC | a | b | C1 | C2 | W | out |
|----|---|---|----|----|---|-----|
| T1 | 1 | 1 | T | T | T | 1 |
| T2 | 0 | 1 | F | — | F | 0 |
| T3 | 1 | 0 | T | F | F | 0 |

**Bước 3 – Chứng minh C/D:**  
- **Decision W:** có T (T1) và F (T2,T3).  
- **C1:** T tại T1,T3; F tại T2.  
- **C2:** T tại T1,T2; F tại T3.

**Bước 4 – Kết luận:** **3 TC** đạt **C/D** cho biểu thức `&&` hai điều kiện.

---
### Bài mẫu 4 — Mức độ: Dễ
**Điều kiện ghép `||` (C/D)**



**Đề bài (chi tiết):**

```text
function h4(a, b):
    if (a == 0) || (b == 0):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `(a==0)`, C2 ≡ `(b==0)`. **W** ≡ C1 ∨ C2.

**Bước 2 – Test C/D:**

| TC | a | b | C1 | C2 | W | out |
|----|---|---|----|----|---|-----|
| T1 | 1 | 1 | F | F | F | 0 |
| T2 | 0 | 1 | T | F | T | 1 |
| T3 | 1 | 0 | F | T | T | 1 |

**Bước 3 – Chứng minh:** Whole có F (T1) và T (T2,T3); mỗi atomic có đủ T và F.

**Bước 4 – Kết luận:** **3 TC** đạt **C/D** cho `||`.

---
### Bài mẫu 5 — Mức độ: Dễ
**So sánh số `(x>p) && (y<q)` (C/D)**



**Đề bài (chi tiết):**

```text
function h5(x, y):  // x,y nguyên
    if (x > 2) && (y < 5):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `x>2`, C2 ≡ `y<5`.

**Bước 2 – Test C/D (ví dụ):**

| TC | x | y | C1 | C2 | W |
|----|---|---|----|----|---|
| T1 | 4 | 4 | T | T | T |
| T2 | 1 | 4 | F | — | F |
| T3 | 4 | 7 | T | F | F |

**Bước 3 – Kết luận:** **3 TC** đạt **C/D**; nhớ **short-circuit** khi ghi lại đường thực thi.

---
### Bài mẫu 6 — Mức độ: Trung bình
**Điều kiện ghép `&&` (C/D)**



**Đề bài (chi tiết):**

```text
function h6(a, b):  // a,b boolean 0/1
    if (a == 0) && (b == 1):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `(a==0)`, C2 ≡ `(b==1)`. **Whole decision** W ≡ C1 ∧ C2.

**Bước 2 – Test đạt Condition + Decision:**

| TC | a | b | C1 | C2 | W | out |
|----|---|---|----|----|---|-----|
| T1 | 0 | 1 | T | T | T | 1 |
| T2 | 1 | 1 | F | — | F | 0 |
| T3 | 0 | 0 | T | F | F | 0 |

**Bước 3 – Chứng minh C/D:**  
- **Decision W:** có T (T1) và F (T2,T3).  
- **C1:** T tại T1,T3; F tại T2.  
- **C2:** T tại T1,T2; F tại T3.

**Bước 4 – Kết luận:** **3 TC** đạt **C/D** cho biểu thức `&&` hai điều kiện.

---
### Bài mẫu 7 — Mức độ: Trung bình
**Điều kiện ghép `||` (C/D)**



**Đề bài (chi tiết):**

```text
function h7(a, b):
    if (a == 1) || (b == 1):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `(a==1)`, C2 ≡ `(b==1)`. **W** ≡ C1 ∨ C2.

**Bước 2 – Test C/D:**

| TC | a | b | C1 | C2 | W | out |
|----|---|---|----|----|---|-----|
| T1 | 0 | 0 | F | F | F | 0 |
| T2 | 1 | 0 | T | F | T | 1 |
| T3 | 0 | 1 | F | T | T | 1 |

**Bước 3 – Chứng minh:** Whole có F (T1) và T (T2,T3); mỗi atomic có đủ T và F.

**Bước 4 – Kết luận:** **3 TC** đạt **C/D** cho `||`.

---
### Bài mẫu 8 — Mức độ: Trung bình
**So sánh số `(x>p) && (y<q)` (C/D)**



**Đề bài (chi tiết):**

```text
function h8(x, y):  // x,y nguyên
    if (x > 1) && (y < 5):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `x>1`, C2 ≡ `y<5`.

**Bước 2 – Test C/D (ví dụ):**

| TC | x | y | C1 | C2 | W |
|----|---|---|----|----|---|
| T1 | 3 | 4 | T | T | T |
| T2 | 0 | 4 | F | — | F |
| T3 | 3 | 7 | T | F | F |

**Bước 3 – Kết luận:** **3 TC** đạt **C/D**; nhớ **short-circuit** khi ghi lại đường thực thi.

---
### Bài mẫu 9 — Mức độ: Trung bình
**Điều kiện ghép `&&` (C/D)**



**Đề bài (chi tiết):**

```text
function h9(a, b):  // a,b boolean 0/1
    if (a == 1) && (b == 0):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1 ≡ `(a==1)`, C2 ≡ `(b==0)`. **Whole decision** W ≡ C1 ∧ C2.

**Bước 2 – Test đạt Condition + Decision:**

| TC | a | b | C1 | C2 | W | out |
|----|---|---|----|----|---|-----|
| T1 | 1 | 0 | T | T | T | 1 |
| T2 | 0 | 0 | F | — | F | 0 |
| T3 | 1 | 1 | T | F | F | 0 |

**Bước 3 – Chứng minh C/D:**  
- **Decision W:** có T (T1) và F (T2,T3).  
- **C1:** T tại T1,T3; F tại T2.  
- **C2:** T tại T1,T2; F tại T3.

**Bước 4 – Kết luận:** **3 TC** đạt **C/D** cho biểu thức `&&` hai điều kiện.

---
### Bài mẫu 10 — Mức độ: Trung bình · nâng cao (1)
**C/D: ba điều kiện `&&`**


*(Bài 10–13: **3 atomic** trong một quyết định.)*

**Đề bài (chi tiết):**

```text
function h10(a, b, c):  // 0/1
    if (a == 1) && (b == 1) && (c == 1):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1≡(a==1), C2≡(b==1), C3≡(c==1). **W** ≡ C1∧C2∧C3.

**Bước 2 – Test C/D (4 TC):**

| TC | a | b | c | W |
|----|---|---|---|---|
| T1 | 1 | 1 | 1 | T |
| T2 | 0 | 1 | 1 | F |
| T3 | 1 | 0 | 1 | F |
| T4 | 1 | 1 | 0 | F |

**Bước 3 – Chứng minh:** Whole có T/F; mỗi atomic có T (T1 và các hàng khác) và F (một hàng riêng).

**Bước 4 – Kết luận:** **4 TC** — phức tạp hơn bài **1–9** (2 atomic).

---
### Bài mẫu 11 — Mức độ: Trung bình · nâng cao (2)
**C/D: ba điều kiện `&&`**


*(Bài 10–13: **3 atomic** trong một quyết định.)*

**Đề bài (chi tiết):**

```text
function h11(a, b, c):  // 0/1
    if (a == 1) && (b == 1) && (c == 1):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1≡(a==1), C2≡(b==1), C3≡(c==1). **W** ≡ C1∧C2∧C3.

**Bước 2 – Test C/D (4 TC):**

| TC | a | b | c | W |
|----|---|---|---|---|
| T1 | 1 | 1 | 1 | T |
| T2 | 0 | 1 | 1 | F |
| T3 | 1 | 0 | 1 | F |
| T4 | 1 | 1 | 0 | F |

**Bước 3 – Chứng minh:** Whole có T/F; mỗi atomic có T (T1 và các hàng khác) và F (một hàng riêng).

**Bước 4 – Kết luận:** **4 TC** — phức tạp hơn bài **1–9** (2 atomic).

---
### Bài mẫu 12 — Mức độ: Khó (mức 1)
**C/D: ba điều kiện `&&`**


*(Bài 10–13: **3 atomic** trong một quyết định.)*

**Đề bài (chi tiết):**

```text
function h12(a, b, c):  // 0/1
    if (a == 1) && (b == 1) && (c == 1):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1≡(a==1), C2≡(b==1), C3≡(c==1). **W** ≡ C1∧C2∧C3.

**Bước 2 – Test C/D (4 TC):**

| TC | a | b | c | W |
|----|---|---|---|---|
| T1 | 1 | 1 | 1 | T |
| T2 | 0 | 1 | 1 | F |
| T3 | 1 | 0 | 1 | F |
| T4 | 1 | 1 | 0 | F |

**Bước 3 – Chứng minh:** Whole có T/F; mỗi atomic có T (T1 và các hàng khác) và F (một hàng riêng).

**Bước 4 – Kết luận:** **4 TC** — phức tạp hơn bài **1–9** (2 atomic).

---
### Bài mẫu 13 — Mức độ: Khó (mức 2)
**C/D: ba điều kiện `&&`**


*(Bài 10–13: **3 atomic** trong một quyết định.)*

**Đề bài (chi tiết):**

```text
function h13(a, b, c):  // 0/1
    if (a == 1) && (b == 1) && (c == 1):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** C1≡(a==1), C2≡(b==1), C3≡(c==1). **W** ≡ C1∧C2∧C3.

**Bước 2 – Test C/D (4 TC):**

| TC | a | b | c | W |
|----|---|---|---|---|
| T1 | 1 | 1 | 1 | T |
| T2 | 0 | 1 | 1 | F |
| T3 | 1 | 0 | 1 | F |
| T4 | 1 | 1 | 0 | F |

**Bước 3 – Chứng minh:** Whole có T/F; mỗi atomic có T (T1 và các hàng khác) và F (một hàng riêng).

**Bước 4 – Kết luận:** **4 TC** — phức tạp hơn bài **1–9** (2 atomic).

---
### Bài mẫu 14 — Mức độ: Khó (mức 3)
**C/D: `||` kết hợp `&&`**


*(Bài 14–17: ngoặc — phân rã atomic cẩn thận.)*

**Đề bài (chi tiết):**

```text
function h14(x, y, z):  // nguyên
    if (x > 0) || ((y < 0) && (z == 0)):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** A≡`x>0`, B≡`y<0`, C≡`z==0`. **W** ≡ A ∨ (B ∧ C).

**Bước 2 – Gợi ý TC:** chọn bộ `(x,y,z)` để: chỉ A true; A false và B∧C true; toàn false; … — hoàn thiện bảng **C/D** (≥ **4 TC**).

**Bước 3 – Kết luận:** Thang **10–20** tăng độ khó **cấu trúc điều kiện**.

---
### Bài mẫu 15 — Mức độ: Khó · phức tạp
**C/D: `||` kết hợp `&&`**


*(Bài 14–17: ngoặc — phân rã atomic cẩn thận.)*

**Đề bài (chi tiết):**

```text
function h15(x, y, z):  // nguyên
    if (x > 0) || ((y < 0) && (z == 0)):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** A≡`x>0`, B≡`y<0`, C≡`z==0`. **W** ≡ A ∨ (B ∧ C).

**Bước 2 – Gợi ý TC:** chọn bộ `(x,y,z)` để: chỉ A true; A false và B∧C true; toàn false; … — hoàn thiện bảng **C/D** (≥ **4 TC**).

**Bước 3 – Kết luận:** Thang **10–20** tăng độ khó **cấu trúc điều kiện**.

---
### Bài mẫu 16 — Mức độ: Rất khó (mức 1)
**C/D: `||` kết hợp `&&`**


*(Bài 14–17: ngoặc — phân rã atomic cẩn thận.)*

**Đề bài (chi tiết):**

```text
function h16(x, y, z):  // nguyên
    if (x > 0) || ((y < 0) && (z == 0)):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** A≡`x>0`, B≡`y<0`, C≡`z==0`. **W** ≡ A ∨ (B ∧ C).

**Bước 2 – Gợi ý TC:** chọn bộ `(x,y,z)` để: chỉ A true; A false và B∧C true; toàn false; … — hoàn thiện bảng **C/D** (≥ **4 TC**).

**Bước 3 – Kết luận:** Thang **10–20** tăng độ khó **cấu trúc điều kiện**.

---
### Bài mẫu 17 — Mức độ: Rất khó (mức 2)
**C/D: `||` kết hợp `&&`**


*(Bài 14–17: ngoặc — phân rã atomic cẩn thận.)*

**Đề bài (chi tiết):**

```text
function h17(x, y, z):  // nguyên
    if (x > 0) || ((y < 0) && (z == 0)):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Atomic:** A≡`x>0`, B≡`y<0`, C≡`z==0`. **W** ≡ A ∨ (B ∧ C).

**Bước 2 – Gợi ý TC:** chọn bộ `(x,y,z)` để: chỉ A true; A false và B∧C true; toàn false; … — hoàn thiện bảng **C/D** (≥ **4 TC**).

**Bước 3 – Kết luận:** Thang **10–20** tăng độ khó **cấu trúc điều kiện**.

---
### Bài mẫu 18 — Mức độ: Rất khó (mức 3)
**C/D: hai cụm con `(A∧B)∨(C∧D)`**


*(Bài 18–20: đỉnh file 03 — nhiều atomic, cần bảng truth có hệ thống.)*

**Đề bài (chi tiết):**

```text
function h18(p, q, r, s):  // boolean 0/1
    if (p == 1 && q == 1) || (r == 1 && s == 0):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:** Liệt kê **ít nhất 5–6 TC** đạt **C/D** (whole T/F + mỗi atomic T/F); sinh viên **không** được bỏ sót nhánh short-circuit.

**Bước 2 – Kết luận:** Dùng **bảng truth** hoặc **rút gọn** theo quy tắc đề bài.

---
### Bài mẫu 19 — Mức độ: Cực khó
**C/D: hai cụm con `(A∧B)∨(C∧D)`**


*(Bài 18–20: đỉnh file 03 — nhiều atomic, cần bảng truth có hệ thống.)*

**Đề bài (chi tiết):**

```text
function h19(p, q, r, s):  // boolean 0/1
    if (p == 1 && q == 1) || (r == 1 && s == 0):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:** Liệt kê **ít nhất 5–6 TC** đạt **C/D** (whole T/F + mỗi atomic T/F); sinh viên **không** được bỏ sót nhánh short-circuit.

**Bước 2 – Kết luận:** Dùng **bảng truth** hoặc **rút gọn** theo quy tắc đề bài.

---
### Bài mẫu 20 — Mức độ: Cực khó · tổng hợp
**C/D: hai cụm con `(A∧B)∨(C∧D)`**


*(Bài 18–20: đỉnh file 03 — nhiều atomic, cần bảng truth có hệ thống.)*

**Đề bài (chi tiết):**

```text
function h20(p, q, r, s):  // boolean 0/1
    if (p == 1 && q == 1) || (r == 1 && s == 0):
        return 1
    else:
        return 0
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Nhiệm vụ:** Liệt kê **ít nhất 5–6 TC** đạt **C/D** (whole T/F + mỗi atomic T/F); sinh viên **không** được bỏ sót nhánh short-circuit.

**Bước 2 – Kết luận:** Dùng **bảng truth** hoặc **rút gọn** theo quy tắc đề bài.

---

## PHẦN 2: BÀI TẬP TỰ LUYỆN

---

*20 bài — điều kiện và C/D.*

*Chỉ có **đề** và **gợi ý**; làm đủ bảng CFG / TC / phủ như **PHẦN 1** khi nộp.*  
*Thang **khớp PHẦN 1:** **1–9** = **2 atomic** (`&&` hoặc `||` hoặc so sánh); **10–13** = **3×`&&`**; **14–17** = `||` kết hợp `&&` trong ngoặc; **18–20** = `(A∧B)∨(C∧D)`.*

### Bài 1 — Mức độ: Dễ
**Tự luyện #1**

**Đề bài (chi tiết):**  
`if (A || B)` với A, B boolean 0/1 — **C/D** (nhóm **||** như mẫu lẻ **1,4,7**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**3 TC**; whole T/F; mỗi atomic T/F; short-circuit.


---
### Bài 2 — Mức độ: Dễ
**Tự luyện #2**

**Đề bài (chi tiết):**  
`if (x > p) && (y < q)` — **C/D** (nhóm so sánh **2,5,8**); tự chọn `p`, `q`.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ghi `—` khi atomic không đánh giá do short-circuit.


---
### Bài 3 — Mức độ: Dễ
**Tự luyện #3**

**Đề bài (chi tiết):**  
`if (A && B)` hai biến boolean — **C/D** (nhóm **&&** như mẫu **3,6,9**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**3 TC** tối thiểu thường đủ.


---
### Bài 4 — Mức độ: Dễ
**Tự luyện #4**

**Đề bài (chi tiết):**  
`if (A || B)` — đổi “cảm giác” A,B (vd. `a==0`, `b==0`).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Chứng minh **decision** và **condition** coverage.


---
### Bài 5 — Mức độ: Dễ
**Tự luyện #5**

**Đề bài (chi tiết):**  
`(x > p) && (y < q)` — **đổi** `p`, `q` so với bài 2.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Bảng TC × C1_atomic × C2_atomic × W.


---
### Bài 6 — Mức độ: Dễ
**Tự luyện #6**

**Đề bài (chi tiết):**  
`if (A && B)` — đổi nghĩa A,B (vd. `a==0 && b==1`).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**Không** nhầm **C/D** với **MC/DC** (file 04).


---
### Bài 7 — Mức độ: Dễ
**Tự luyện #7**

**Đề bài (chi tiết):**  
Một trong ba dạng: **`||` / `&&` / so sánh** — **tự chọn** và ghi rõ đề.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ôn **phân rã atomic**.


---
### Bài 8 — Mức độ: Dễ
**Tự luyện #8**

**Đề bài (chi tiết):**  
Lặp một dạng **2 atomic** (sinh viên chọn `&&` hoặc `||`) — hoàn thiện bảng đẹp.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Chuẩn bị **3 atomic** (bài 10+).


---
### Bài 9 — Mức độ: Dễ
**Tự luyện #9**

**Đề bài (chi tiết):**  
**2 atomic**; **cuối** nhóm **1–9** — tổng hợp lời giải 1 trang.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
So khớp với checklist mẫu PHẦN 1.


---
### Bài 10 — Mức độ: Trung bình
**Tự luyện #10**

**Đề bài (chi tiết):**  
`if (a==1) && (b==1) && (c==1)` — **3 atomic**, **C/D** (như mẫu **10–13**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**4 TC**; mỗi atomic có T và F.


---
### Bài 11 — Mức độ: Trung bình
**Tự luyện #11**

**Đề bài (chi tiết):**  
Ba `&&` boolean — **đổi** cách viết (vd. `x>0 && y>0 && z>0`).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Whole decision T và F đều có.


---
### Bài 12 — Mức độ: Trung bình
**Tự luyện #12**

**Đề bài (chi tiết):**  
Ba `&&` — biến thể khác bài 10–11.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Kiểm tra short-circuit từng bước.


---
### Bài 13 — Mức độ: Khó
**Tự luyện #13**

**Đề bài (chi tiết):**  
Ba `&&` — **hết** nhóm **10–13**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
So sánh số TC với bài **14–17**.


---
### Bài 14 — Mức độ: Khó
**Tự luyện #14**

**Đề bài (chi tiết):**  
`if (x > 0) || ((y < 0) && (z == 0))` — **C/D** (như mẫu **14–17**); có thể đổi hằng.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Phân rã **A**, **B∧C**; **≥4 TC**; ngoặc quan trọng.


---
### Bài 15 — Mức độ: Khó
**Tự luyện #15**

**Đề bài (chi tiết):**  
Cùng **cấu trúc** bài 14 — **đổi** điều kiện (vẫn `||` + cụm `&&`).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Bảng truth có hệ thống.


---
### Bài 16 — Mức độ: Rất khó
**Tự luyện #16**

**Đề bài (chi tiết):**  
`||` + `&&` lồng — đề tự đặt tương đương độ khó mẫu.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ghi rõ thứ tự ưu tiên toán tử.


---
### Bài 17 — Mức độ: Rất khó
**Tự luyện #17**

**Đề bài (chi tiết):**  
`||` + `&&` — **hết** nhóm **14–17**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đối chiếu **04-MCDC.md** nếu gộp thành một quyết định — tiêu chí khác **C/D**.


---
### Bài 18 — Mức độ: Rất khó
**Tự luyện #18**

**Đề bài (chi tiết):**  
`if (p==1 && q==1) || (r==1 && s==0)` — **C/D** (như mẫu **18–20**).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
**≥5–6 TC**; bốn atomic + whole.


---
### Bài 19 — Mức độ: Cực khó · tổng hợp
**Tự luyện #19**

**Đề bài (chi tiết):**  
Hai cụm `(∧)∨(∧)` — **đổi** literal / biến (vẫn 4 atomic).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Không bỏ sót nhánh short-circuit.


---
### Bài 20 — Mức độ: Cực khó · tổng hợp
**Tự luyện #20**

**Đề bài (chi tiết):**  
Biểu thức **4 atomic** dạng **hỗn hợp** — **đỉnh** file 03; tự hoàn thiện bảng và chứng minh C/D.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Dùng truth table hoặc rút gọn có kiểm chứng.


---

*Tài liệu chỉnh sửa trực tiếp trong file này; có thể bổ sung ví dụ số theo lớp.*
