# Bài tập: MC/DC (Modified Condition/Decision Coverage)

**Chương:** Kiểm thử hộp trắng  
Tham chiếu: [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) — mục 5.

**Cấu trúc file:** **PHẦN 1: BÀI TẬP MẪU** (20 bài, lời giải chi tiết) · **PHẦN 2: BÀI TẬP TỰ LUYỆN** (20 bài, đề + gợi ý).

---

## Quy trình chuẩn

Với **một** quyết định boolean có các điều kiện con độc lập:

1. Với mỗi con Ci, tìm **cặp** test: chỉ Ci đổi, **kết quả cả quyết định** đổi, các con khác **giữ nguyên**.  
2. Gộp test trùng → thường **n+1** test (n = số con).  
3. Trình bày **bảng** + **chứng minh** từng Ci.

**Thang độ khó:** Bài **10–20** tăng dần — **AND 3 biến** → **OR 3 biến** → biểu thức **hỗn hợp** (thường **4+** TC).

---

## PHẦN 1: BÀI TẬP MẪU

---

### Bài mẫu 1 — Mức độ: Dễ
**MC/DC trên `(A && B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B.

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 0 |
| 3 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=1; B đổi → D đổi.  

→ **MC/DC đạt** với 3 test.

---
### Bài mẫu 2 — Mức độ: Dễ
**MC/DC trên `(A || B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∨ B (A,B ∈ {0,1}).

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 0 | 1 |
| 2 | 0 | 0 | 0 |
| 3 | 0 | 1 | 1 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=0 cố định; A 1→0; D 1→0.  
- **B:** (2) vs (3): A=0 cố định; B 0→1; D 0→1.  

→ **3 = n+1** test, **MC/DC đạt**.

---
### Bài mẫu 3 — Mức độ: Dễ
**MC/DC trên `(A && B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B.

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 0 |
| 3 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=1; B đổi → D đổi.  

→ **MC/DC đạt** với 3 test.

---
### Bài mẫu 4 — Mức độ: Dễ
**MC/DC trên `(A || B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∨ B (A,B ∈ {0,1}).

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 0 | 1 |
| 2 | 0 | 0 | 0 |
| 3 | 0 | 1 | 1 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=0 cố định; A 1→0; D 1→0.  
- **B:** (2) vs (3): A=0 cố định; B 0→1; D 0→1.  

→ **3 = n+1** test, **MC/DC đạt**.

---
### Bài mẫu 5 — Mức độ: Dễ
**MC/DC trên `(A && B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B.

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 0 |
| 3 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=1; B đổi → D đổi.  

→ **MC/DC đạt** với 3 test.

---
### Bài mẫu 6 — Mức độ: Trung bình
**MC/DC trên `(A || B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∨ B (A,B ∈ {0,1}).

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 0 | 1 |
| 2 | 0 | 0 | 0 |
| 3 | 0 | 1 | 1 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=0 cố định; A 1→0; D 1→0.  
- **B:** (2) vs (3): A=0 cố định; B 0→1; D 0→1.  

→ **3 = n+1** test, **MC/DC đạt**.

---
### Bài mẫu 7 — Mức độ: Trung bình
**MC/DC trên `(A && B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B.

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 0 |
| 3 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=1; B đổi → D đổi.  

→ **MC/DC đạt** với 3 test.

---
### Bài mẫu 8 — Mức độ: Trung bình
**MC/DC trên `(A || B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∨ B (A,B ∈ {0,1}).

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 0 | 1 |
| 2 | 0 | 0 | 0 |
| 3 | 0 | 1 | 1 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=0 cố định; A 1→0; D 1→0.  
- **B:** (2) vs (3): A=0 cố định; B 0→1; D 0→1.  

→ **3 = n+1** test, **MC/DC đạt**.

---
### Bài mẫu 9 — Mức độ: Trung bình
**MC/DC trên `(A && B)`**



**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B.

**Bước 2 – Bảng TC:**

| TC# | A | B | D |
|-----|---|---|---|
| 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 0 |
| 3 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=1; B đổi → D đổi.  

→ **MC/DC đạt** với 3 test.

---
### Bài mẫu 10 — Mức độ: Trung bình · nâng cao (1)
**MC/DC: `(A && B && C)` — 3 biến**


*(Bài 10–14: **AND** ba biến — **n=3** → thường **4 = n+1** test; bước đệm trước OR.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B ∧ C.

**Bước 2 – Bảng TC:**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 1 | 0 |
| 3 | 1 | 0 | 1 | 0 |
| 4 | 1 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=C=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=C=1; B đổi → D đổi.  
- **C:** (1) vs (4): A=B=1; C đổi → D đổi.

**Bước 4 – Kết luận:** **4 TC** đạt **MC/DC**; tiếp theo bài **15–17** (OR — nhiều đường làm **D=1**).

---
### Bài mẫu 11 — Mức độ: Trung bình · nâng cao (2)
**MC/DC: `(A && B && C)` — 3 biến**


*(Bài 10–14: **AND** ba biến — **n=3** → thường **4 = n+1** test; bước đệm trước OR.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B ∧ C.

**Bước 2 – Bảng TC:**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 1 | 0 |
| 3 | 1 | 0 | 1 | 0 |
| 4 | 1 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=C=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=C=1; B đổi → D đổi.  
- **C:** (1) vs (4): A=B=1; C đổi → D đổi.

**Bước 4 – Kết luận:** **4 TC** đạt **MC/DC**; tiếp theo bài **15–17** (OR — nhiều đường làm **D=1**).

---
### Bài mẫu 12 — Mức độ: Khó (mức 1)
**MC/DC: `(A && B && C)` — 3 biến**


*(Bài 10–14: **AND** ba biến — **n=3** → thường **4 = n+1** test; bước đệm trước OR.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B ∧ C.

**Bước 2 – Bảng TC:**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 1 | 0 |
| 3 | 1 | 0 | 1 | 0 |
| 4 | 1 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=C=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=C=1; B đổi → D đổi.  
- **C:** (1) vs (4): A=B=1; C đổi → D đổi.

**Bước 4 – Kết luận:** **4 TC** đạt **MC/DC**; tiếp theo bài **15–17** (OR — nhiều đường làm **D=1**).

---
### Bài mẫu 13 — Mức độ: Khó (mức 2)
**MC/DC: `(A && B && C)` — 3 biến**


*(Bài 10–14: **AND** ba biến — **n=3** → thường **4 = n+1** test; bước đệm trước OR.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B ∧ C.

**Bước 2 – Bảng TC:**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 1 | 0 |
| 3 | 1 | 0 | 1 | 0 |
| 4 | 1 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=C=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=C=1; B đổi → D đổi.  
- **C:** (1) vs (4): A=B=1; C đổi → D đổi.

**Bước 4 – Kết luận:** **4 TC** đạt **MC/DC**; tiếp theo bài **15–17** (OR — nhiều đường làm **D=1**).

---
### Bài mẫu 14 — Mức độ: Khó (mức 3)
**MC/DC: `(A && B && C)` — 3 biến**


*(Bài 10–14: **AND** ba biến — **n=3** → thường **4 = n+1** test; bước đệm trước OR.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∧ B ∧ C.

**Bước 2 – Bảng TC:**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 1 | 0 |
| 3 | 1 | 0 | 1 | 0 |
| 4 | 1 | 1 | 0 | 0 |

**Bước 3 – Chứng minh:**  
- **A:** (1) vs (2): B=C=1; A đổi → D đổi.  
- **B:** (1) vs (3): A=C=1; B đổi → D đổi.  
- **C:** (1) vs (4): A=B=1; C đổi → D đổi.

**Bước 4 – Kết luận:** **4 TC** đạt **MC/DC**; tiếp theo bài **15–17** (OR — nhiều đường làm **D=1**).

---
### Bài mẫu 15 — Mức độ: Khó · phức tạp
**MC/DC: `(A || B || C)` — 3 biến**


*(Bài 15–17: **OR** — chứng minh cặp độc lập quanh hàng **D=0**.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∨ B ∨ C.

**Bước 2 – Bảng TC:**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 0 | 0 | 1 |
| 2 | 0 | 0 | 0 | 0 |
| 3 | 0 | 1 | 0 | 1 |
| 4 | 0 | 0 | 1 | 1 |

**Bước 3 – Chứng minh (mẫu):**  
- **A:** (1) vs (2): B=C=0; chỉ A đổi; D 1→0.  
- **B:** (3) vs (2): A=C=0; chỉ B đổi; D 1→0.  
- **C:** (4) vs (2): A=B=0; chỉ C đổi; D 1→0.

**Bước 4 – Kết luận:** **4 TC**; so sánh với bài **10–14** (AND).

---
### Bài mẫu 16 — Mức độ: Rất khó (mức 1)
**MC/DC: `(A || B || C)` — 3 biến**


*(Bài 15–17: **OR** — chứng minh cặp độc lập quanh hàng **D=0**.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∨ B ∨ C.

**Bước 2 – Bảng TC:**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 0 | 0 | 1 |
| 2 | 0 | 0 | 0 | 0 |
| 3 | 0 | 1 | 0 | 1 |
| 4 | 0 | 0 | 1 | 1 |

**Bước 3 – Chứng minh (mẫu):**  
- **A:** (1) vs (2): B=C=0; chỉ A đổi; D 1→0.  
- **B:** (3) vs (2): A=C=0; chỉ B đổi; D 1→0.  
- **C:** (4) vs (2): A=B=0; chỉ C đổi; D 1→0.

**Bước 4 – Kết luận:** **4 TC**; so sánh với bài **10–14** (AND).

---
### Bài mẫu 17 — Mức độ: Rất khó (mức 2)
**MC/DC: `(A || B || C)` — 3 biến**


*(Bài 15–17: **OR** — chứng minh cặp độc lập quanh hàng **D=0**.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = A ∨ B ∨ C.

**Bước 2 – Bảng TC:**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 0 | 0 | 1 |
| 2 | 0 | 0 | 0 | 0 |
| 3 | 0 | 1 | 0 | 1 |
| 4 | 0 | 0 | 1 | 1 |

**Bước 3 – Chứng minh (mẫu):**  
- **A:** (1) vs (2): B=C=0; chỉ A đổi; D 1→0.  
- **B:** (3) vs (2): A=C=0; chỉ B đổi; D 1→0.  
- **C:** (4) vs (2): A=B=0; chỉ C đổi; D 1→0.

**Bước 4 – Kết luận:** **4 TC**; so sánh với bài **10–14** (AND).

---
### Bài mẫu 18 — Mức độ: Rất khó (mức 3)
**MC/DC: `(A && B) || C` — 3 biến**


*(Bài 18–20: cấu trúc **hỗn hợp** — phải chỉ rõ **atomic** A,B,C.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = (A ∧ B) ∨ C.

**Bước 2 – Gợi ý bảng (sinh viên hoàn thiện & chứng minh):**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 1 | 0 | 1 |
| 2 | 0 | 1 | 0 | 0 |
| 3 | 1 | 0 | 0 | 0 |
| 4 | 0 | 0 | 1 | 1 |
| 5 | 0 | 0 | 0 | 0 |

**Bước 3 – Nhiệm vụ:** Với **mỗi** biến A,B,C, tìm **một cặp** hàng mà chỉ biến đó đổi và **D** đổi (các biến khác **cố định**). Gộp trùng → thường còn **≥4** test.

**Bước 4 – Kết luận:** Đỉnh thang **10–20** — **không** áp dụng máy móc bảng **2 biến**.

---
### Bài mẫu 19 — Mức độ: Cực khó
**MC/DC: `(A && B) || C` — 3 biến**


*(Bài 18–20: cấu trúc **hỗn hợp** — phải chỉ rõ **atomic** A,B,C.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = (A ∧ B) ∨ C.

**Bước 2 – Gợi ý bảng (sinh viên hoàn thiện & chứng minh):**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 1 | 0 | 1 |
| 2 | 0 | 1 | 0 | 0 |
| 3 | 1 | 0 | 0 | 0 |
| 4 | 0 | 0 | 1 | 1 |
| 5 | 0 | 0 | 0 | 0 |

**Bước 3 – Nhiệm vụ:** Với **mỗi** biến A,B,C, tìm **một cặp** hàng mà chỉ biến đó đổi và **D** đổi (các biến khác **cố định**). Gộp trùng → thường còn **≥4** test.

**Bước 4 – Kết luận:** Đỉnh thang **10–20** — **không** áp dụng máy móc bảng **2 biến**.

---
### Bài mẫu 20 — Mức độ: Cực khó · tổng hợp
**MC/DC: `(A && B) || C` — 3 biến**


*(Bài 18–20: cấu trúc **hỗn hợp** — phải chỉ rõ **atomic** A,B,C.)*

**Hướng dẫn giải chi tiết:**

**Bước 1 – Quyết định:** D = (A ∧ B) ∨ C.

**Bước 2 – Gợi ý bảng (sinh viên hoàn thiện & chứng minh):**

| TC# | A | B | C | D |
|-----|---|---|---|---|
| 1 | 1 | 1 | 0 | 1 |
| 2 | 0 | 1 | 0 | 0 |
| 3 | 1 | 0 | 0 | 0 |
| 4 | 0 | 0 | 1 | 1 |
| 5 | 0 | 0 | 0 | 0 |

**Bước 3 – Nhiệm vụ:** Với **mỗi** biến A,B,C, tìm **một cặp** hàng mà chỉ biến đó đổi và **D** đổi (các biến khác **cố định**). Gộp trùng → thường còn **≥4** test.

**Bước 4 – Kết luận:** Đỉnh thang **10–20** — **không** áp dụng máy móc bảng **2 biến**.

---

## PHẦN 2: BÀI TẬP TỰ LUYỆN

---

*20 bài — MC/DC.*

*Chỉ có **đề** và **gợi ý**; làm đủ bảng / chứng minh như **PHẦN 1** khi nộp.*  
**Bài tự luyện #N** dùng **cùng dạng biểu thức** với **Bài mẫu #N** trong PHẦN 1 (1,3,5,7,9: `(X && Y)` · 2,4,6,8: `(X || Y)` · 10–14: `(X && Y && Z)` · 15–17: `(X || Y || Z)` · 18–20: `(X && Y) || Z`).

### Bài 1 — Mức độ: Dễ
**Tự luyện #1**

**Đề bài (chi tiết):**  
MC/DC cho quyết định **`(X && Y)`** — khớp **Bài mẫu 1**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test** (n+1); chứng minh cặp độc lập cho X và Y.


---
### Bài 2 — Mức độ: Dễ
**Tự luyện #2**

**Đề bài (chi tiết):**  
MC/DC cho quyết định **`(X || Y)`** — khớp **Bài mẫu 2**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test**; cặp độc lập thường quanh hàng **D=0**.


---
### Bài 3 — Mức độ: Dễ
**Tự luyện #3**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y)`** — khớp **Bài mẫu 3**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test**.


---
### Bài 4 — Mức độ: Dễ
**Tự luyện #4**

**Đề bài (chi tiết):**  
MC/DC cho **`(X || Y)`** — khớp **Bài mẫu 4**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test**.


---
### Bài 5 — Mức độ: Dễ
**Tự luyện #5**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y)`** — khớp **Bài mẫu 5**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test**.


---
### Bài 6 — Mức độ: Dễ
**Tự luyện #6**

**Đề bài (chi tiết):**  
MC/DC cho **`(X || Y)`** — khớp **Bài mẫu 6**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test**.


---
### Bài 7 — Mức độ: Dễ
**Tự luyện #7**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y)`** — khớp **Bài mẫu 7**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test**.


---
### Bài 8 — Mức độ: Dễ
**Tự luyện #8**

**Đề bài (chi tiết):**  
MC/DC cho **`(X || Y)`** — khớp **Bài mẫu 8**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test**.


---
### Bài 9 — Mức độ: Dễ
**Tự luyện #9**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y)`** — khớp **Bài mẫu 9**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=2 → thường **3 test**.


---
### Bài 10 — Mức độ: Trung bình
**Tự luyện #10**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y && Z)`** — khớp **Bài mẫu 10**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=3 → thường **4 test** (n+1).


---
### Bài 11 — Mức độ: Trung bình
**Tự luyện #11**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y && Z)`** — khớp **Bài mẫu 11**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=3 → thường **4 test**.


---
### Bài 12 — Mức độ: Trung bình
**Tự luyện #12**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y && Z)`** — khớp **Bài mẫu 12**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=3 → thường **4 test**.


---
### Bài 13 — Mức độ: Khó
**Tự luyện #13**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y && Z)`** — khớp **Bài mẫu 13**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=3 → thường **4 test**.


---
### Bài 14 — Mức độ: Khó
**Tự luyện #14**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y && Z)`** — khớp **Bài mẫu 14**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=3 → thường **4 test**.


---
### Bài 15 — Mức độ: Khó
**Tự luyện #15**

**Đề bài (chi tiết):**  
MC/DC cho **`(X || Y || Z)`** — khớp **Bài mẫu 15**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=3 → thường **4 test**; nhiều cặp độc lập quanh **D=0**.


---
### Bài 16 — Mức độ: Rất khó
**Tự luyện #16**

**Đề bài (chi tiết):**  
MC/DC cho **`(X || Y || Z)`** — khớp **Bài mẫu 16**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=3 → thường **4 test**.


---
### Bài 17 — Mức độ: Rất khó
**Tự luyện #17**

**Đề bài (chi tiết):**  
MC/DC cho **`(X || Y || Z)`** — khớp **Bài mẫu 17**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
n=3 → thường **4 test**.


---
### Bài 18 — Mức độ: Rất khó
**Tự luyện #18**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y) || Z`** — khớp **Bài mẫu 18** (chỉ rõ **atomic** X, Y, Z).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Thường **≥4** test sau khi gộp trùng; **không** áp máy bảng 2 biến.


---
### Bài 19 — Mức độ: Cực khó · tổng hợp
**Tự luyện #19**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y) || Z`** — khớp **Bài mẫu 19**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Chứng minh đủ cặp độc lập cho từng atomic.


---
### Bài 20 — Mức độ: Cực khó · tổng hợp
**Tự luyện #20**

**Đề bài (chi tiết):**  
MC/DC cho **`(X && Y) || Z`** — khớp **Bài mẫu 20**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đối chiếu với mẫu 18–19; gộp TC trùng hợp lý.


---

*Tài liệu chỉnh sửa trực tiếp trong file này; có thể bổ sung ví dụ số theo lớp.*
