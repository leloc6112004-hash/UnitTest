# Bài tập: Tổng hợp kỹ thuật kiểm thử hộp trắng

**Chương:** Kiểm thử hộp trắng — **kết hợp** nhiều tiêu chí.

Tham chiếu: [HUONG-DAN-CHUNG.md](HUONG-DAN-CHUNG.md) và file **01–06**.

**Cấu trúc file:** **PHẦN 1: BÀI TẬP MẪU** (20 bài: mã + checklist C0→Data flow, lời giải chi tiết) · **PHẦN 2: BÀI TẬP TỰ LUYỆN** (20 bài, đề + gợi ý).

---

## Quy trình tổng hợp (bắt buộc khi làm mỗi bài)

1. Đọc mã — ghi **đầu vào / đầu ra**.  
2. **CFG** + **V(G)**.  
3. **C0** → **C1** → **C/D** (nếu có `&&` `||`) → **MC/DC** (nếu đề yêu cầu trên 1 quyết định) → **Basis path** → **Data flow** (1–2 biến).  
4. **Một bảng tổng** TC × tiêu chí đã đạt.  
5. **Kết luận** tiêu chí mạnh nhất.

**Thang độ khó:** Bài **10–20** tăng dần — mã dài hơn, nhiều lớp điều kiện + (từ bài 16) thêm **vòng lặp** / **cờ** nghiệp vụ.

---

## PHẦN 1: BÀI TẬP MẪU

---

### Bài mẫu 1 — Mức độ: Dễ
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module1(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 49) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 41):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=49 and not late)` và `(vip and score>=41)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 49 / 41):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 54 | 0 | 0 | PASS |
| T3 | 42 | 0 | 1 | PASS_VIP |
| T4 | 39 | 0 | 0 | FAIL |
| T5 | 51 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #1 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 2 — Mức độ: Dễ
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module2(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 50) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 42):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=50 and not late)` và `(vip and score>=42)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 50 / 42):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 55 | 0 | 0 | PASS |
| T3 | 43 | 0 | 1 | PASS_VIP |
| T4 | 40 | 0 | 0 | FAIL |
| T5 | 52 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #2 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 3 — Mức độ: Dễ
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module3(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 51) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 43):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=51 and not late)` và `(vip and score>=43)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 51 / 43):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 56 | 0 | 0 | PASS |
| T3 | 44 | 0 | 1 | PASS_VIP |
| T4 | 41 | 0 | 0 | FAIL |
| T5 | 53 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #3 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 4 — Mức độ: Dễ
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module4(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 52) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 44):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=52 and not late)` và `(vip and score>=44)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 52 / 44):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 57 | 0 | 0 | PASS |
| T3 | 45 | 0 | 1 | PASS_VIP |
| T4 | 42 | 0 | 0 | FAIL |
| T5 | 54 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #4 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 5 — Mức độ: Dễ
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module5(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 48) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 40):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=48 and not late)` và `(vip and score>=40)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 48 / 40):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 53 | 0 | 0 | PASS |
| T3 | 41 | 0 | 1 | PASS_VIP |
| T4 | 38 | 0 | 0 | FAIL |
| T5 | 50 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #5 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 6 — Mức độ: Trung bình
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module6(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 49) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 41):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=49 and not late)` và `(vip and score>=41)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 49 / 41):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 54 | 0 | 0 | PASS |
| T3 | 42 | 0 | 1 | PASS_VIP |
| T4 | 39 | 0 | 0 | FAIL |
| T5 | 51 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #6 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 7 — Mức độ: Trung bình
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module7(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 50) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 42):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=50 and not late)` và `(vip and score>=42)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 50 / 42):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 55 | 0 | 0 | PASS |
| T3 | 43 | 0 | 1 | PASS_VIP |
| T4 | 40 | 0 | 0 | FAIL |
| T5 | 52 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #7 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 8 — Mức độ: Trung bình
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module8(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 51) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 43):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=51 and not late)` và `(vip and score>=43)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 51 / 43):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 56 | 0 | 0 | PASS |
| T3 | 44 | 0 | 1 | PASS_VIP |
| T4 | 41 | 0 | 0 | FAIL |
| T5 | 53 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #8 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 9 — Mức độ: Trung bình
**Module tổng hợp**



**Đề bài (chi tiết):**

```text
function module9(score, late, vip):
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 52) and (not late)
    if ok:
        r = "PASS"
    elif vip and (score >= 44):
        r = "PASS_VIP"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1–8 – Checklist lời giải (sinh viên điền chi tiết):**

| Bước | Việc làm | Ghi chú |
|------|----------|---------|
| 1 | Vẽ CFG | Tách `or`, toán tử **và** (`&&` / `and`), `elif`; **late** là boolean |
| 2 | V(G) | Đếm D+1 trên CFG đầy đủ |
| 3 | C0 / C1 | Bảng nút / nhánh (kể `return "ERR"` sớm) |
| 4 | C/D | Trên `(score>=52 and not late)` và `(vip and score>=44)` |
| 5 | MC/DC | Chọn **một** biểu thức (vd. `ok` — `and` / phép **và**) — 3 test n+1 |
| 6 | Basis path | Liệt kê **V(G)** đường; gán `(score,late,vip)` |
| 7 | Data flow | Biến `ok` hoặc `r`: def / c-use return |
| 8 | Bảng TC tổng | Cột: TC, đầu vào, kỳ vọng, C0,C1,… |

**Bước 9 – Test mẫu (điều chỉnh theo ngưỡng 52 / 44):**

| TC | score | late | vip | Kỳ vọng |
|----|-------|------|-----|---------|
| T1 | -1 | 0 | 0 | ERR |
| T2 | 57 | 0 | 0 | PASS |
| T3 | 45 | 0 | 1 | PASS_VIP |
| T4 | 42 | 0 | 0 | FAIL |
| T5 | 54 | 1 | 0 | FAIL (late → ok false) |

**Bước 10 – Kết luận:** Hoàn thiện **bảng phủ** cho từng tiêu chí; bài #9 khác bài khác ở **ngưỡng điểm** → **đừng copy kết quả** giữa các số bài.

---
### Bài mẫu 10 — Mức độ: Trung bình · nâng cao (1)
**Module tổng hợp (thêm điều kiện phụ)**


*(Bài 10–15: thêm **retry** — nhiều **return** và điều kiện **and** (`&&`) hơn bài 1–9.)*

**Đề bài (chi tiết):**

```text
function module10(score, late, vip, retry):  // retry nguyên ≥0
    if score < 0 or score > 100:
        return "ERR"
    if retry < 0 or retry > 3:
        return "ERR_RETRY"
    ok = (score >= 48) and (not late) and (retry <= 2)
    if ok:
        r = "PASS"
    elif vip and (score >= 40) and (retry >= 1):
        r = "PASS_VIP"
    elif (score >= 35) and (retry == 0):
        r = "WARN_RETRY"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** Giữ **8 bước** như bài 1–9; **bổ sung:**  
- C/D cho `(retry<=2)`, `(retry>=1)`, `(retry==0)` trong từng nhánh khả thi.  
- **≥6 TC** trong bảng tổng (ERR, ERR_RETRY, PASS, PASS_VIP, WARN_RETRY, FAIL, …).

**Bước 2 – Kết luận:** **V(G)** và số nhánh **tăng** so với module ba tham số.

---
### Bài mẫu 11 — Mức độ: Trung bình · nâng cao (2)
**Module tổng hợp (thêm điều kiện phụ)**


*(Bài 10–15: thêm **retry** — nhiều **return** và điều kiện **and** (`&&`) hơn bài 1–9.)*

**Đề bài (chi tiết):**

```text
function module11(score, late, vip, retry):  // retry nguyên ≥0
    if score < 0 or score > 100:
        return "ERR"
    if retry < 0 or retry > 3:
        return "ERR_RETRY"
    ok = (score >= 49) and (not late) and (retry <= 2)
    if ok:
        r = "PASS"
    elif vip and (score >= 41) and (retry >= 1):
        r = "PASS_VIP"
    elif (score >= 36) and (retry == 0):
        r = "WARN_RETRY"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** Giữ **8 bước** như bài 1–9; **bổ sung:**  
- C/D cho `(retry<=2)`, `(retry>=1)`, `(retry==0)` trong từng nhánh khả thi.  
- **≥6 TC** trong bảng tổng (ERR, ERR_RETRY, PASS, PASS_VIP, WARN_RETRY, FAIL, …).

**Bước 2 – Kết luận:** **V(G)** và số nhánh **tăng** so với module ba tham số.

---
### Bài mẫu 12 — Mức độ: Khó (mức 1)
**Module tổng hợp (thêm điều kiện phụ)**


*(Bài 10–15: thêm **retry** — nhiều **return** và điều kiện **and** (`&&`) hơn bài 1–9.)*

**Đề bài (chi tiết):**

```text
function module12(score, late, vip, retry):  // retry nguyên ≥0
    if score < 0 or score > 100:
        return "ERR"
    if retry < 0 or retry > 3:
        return "ERR_RETRY"
    ok = (score >= 50) and (not late) and (retry <= 2)
    if ok:
        r = "PASS"
    elif vip and (score >= 42) and (retry >= 1):
        r = "PASS_VIP"
    elif (score >= 37) and (retry == 0):
        r = "WARN_RETRY"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** Giữ **8 bước** như bài 1–9; **bổ sung:**  
- C/D cho `(retry<=2)`, `(retry>=1)`, `(retry==0)` trong từng nhánh khả thi.  
- **≥6 TC** trong bảng tổng (ERR, ERR_RETRY, PASS, PASS_VIP, WARN_RETRY, FAIL, …).

**Bước 2 – Kết luận:** **V(G)** và số nhánh **tăng** so với module ba tham số.

---
### Bài mẫu 13 — Mức độ: Khó (mức 2)
**Module tổng hợp (thêm điều kiện phụ)**


*(Bài 10–15: thêm **retry** — nhiều **return** và điều kiện **and** (`&&`) hơn bài 1–9.)*

**Đề bài (chi tiết):**

```text
function module13(score, late, vip, retry):  // retry nguyên ≥0
    if score < 0 or score > 100:
        return "ERR"
    if retry < 0 or retry > 3:
        return "ERR_RETRY"
    ok = (score >= 51) and (not late) and (retry <= 2)
    if ok:
        r = "PASS"
    elif vip and (score >= 43) and (retry >= 1):
        r = "PASS_VIP"
    elif (score >= 38) and (retry == 0):
        r = "WARN_RETRY"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** Giữ **8 bước** như bài 1–9; **bổ sung:**  
- C/D cho `(retry<=2)`, `(retry>=1)`, `(retry==0)` trong từng nhánh khả thi.  
- **≥6 TC** trong bảng tổng (ERR, ERR_RETRY, PASS, PASS_VIP, WARN_RETRY, FAIL, …).

**Bước 2 – Kết luận:** **V(G)** và số nhánh **tăng** so với module ba tham số.

---
### Bài mẫu 14 — Mức độ: Khó (mức 3)
**Module tổng hợp (thêm điều kiện phụ)**


*(Bài 10–15: thêm **retry** — nhiều **return** và điều kiện **and** (`&&`) hơn bài 1–9.)*

**Đề bài (chi tiết):**

```text
function module14(score, late, vip, retry):  // retry nguyên ≥0
    if score < 0 or score > 100:
        return "ERR"
    if retry < 0 or retry > 3:
        return "ERR_RETRY"
    ok = (score >= 52) and (not late) and (retry <= 2)
    if ok:
        r = "PASS"
    elif vip and (score >= 44) and (retry >= 1):
        r = "PASS_VIP"
    elif (score >= 39) and (retry == 0):
        r = "WARN_RETRY"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** Giữ **8 bước** như bài 1–9; **bổ sung:**  
- C/D cho `(retry<=2)`, `(retry>=1)`, `(retry==0)` trong từng nhánh khả thi.  
- **≥6 TC** trong bảng tổng (ERR, ERR_RETRY, PASS, PASS_VIP, WARN_RETRY, FAIL, …).

**Bước 2 – Kết luận:** **V(G)** và số nhánh **tăng** so với module ba tham số.

---
### Bài mẫu 15 — Mức độ: Khó · phức tạp
**Module tổng hợp (thêm điều kiện phụ)**


*(Bài 10–15: thêm **retry** — nhiều **return** và điều kiện **and** (`&&`) hơn bài 1–9.)*

**Đề bài (chi tiết):**

```text
function module15(score, late, vip, retry):  // retry nguyên ≥0
    if score < 0 or score > 100:
        return "ERR"
    if retry < 0 or retry > 3:
        return "ERR_RETRY"
    ok = (score >= 48) and (not late) and (retry <= 2)
    if ok:
        r = "PASS"
    elif vip and (score >= 40) and (retry >= 1):
        r = "PASS_VIP"
    elif (score >= 35) and (retry == 0):
        r = "WARN_RETRY"
    else:
        r = "FAIL"
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** Giữ **8 bước** như bài 1–9; **bổ sung:**  
- C/D cho `(retry<=2)`, `(retry>=1)`, `(retry==0)` trong từng nhánh khả thi.  
- **≥6 TC** trong bảng tổng (ERR, ERR_RETRY, PASS, PASS_VIP, WARN_RETRY, FAIL, …).

**Bước 2 – Kết luận:** **V(G)** và số nhánh **tăng** so với module ba tham số.

---
### Bài mẫu 16 — Mức độ: Rất khó (mức 1)
**Module tổng hợp (vòng lặp + cờ)**


*(Bài 16–20: **while** nhỏ + **break** — checklist đầy đủ nhất.)*

**Đề bài (chi tiết):**

```text
function module16(score, late, vip, maxStep):  // maxStep nguyên 1..5
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 49) and (not late)
    r = "INIT"
    step = 0
    while step < maxStep:
        if ok:
            r = "PASS"
            break
        elif vip and (score >= 41):
            r = "PASS_VIP"
            break
        else:
            r = "FAIL"
        step = step + 1
        if step >= 2 and score < 36:
            r = "ABORT"
            break
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** CFG có **while**, **break**, **elif**; **V(G)** cao — sinh viên **phải vẽ**.  
**Data flow:** `r`, `step`, `ok`. **MC/DC:** chọn **một** trong `ok` hoặc `(vip and score>=…)`.  
**Bảng TC tổng:** **≥7** dòng (ERR; không vào while; vào while thoát nhánh 1/2/3; ABORT; …).

**Bước 2 – Kết luận:** Đỉnh thang **10–20** file 07 — **tổng hợp** mọi kỹ thuất trước đó.

---
### Bài mẫu 17 — Mức độ: Rất khó (mức 2)
**Module tổng hợp (vòng lặp + cờ)**


*(Bài 16–20: **while** nhỏ + **break** — checklist đầy đủ nhất.)*

**Đề bài (chi tiết):**

```text
function module17(score, late, vip, maxStep):  // maxStep nguyên 1..5
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 50) and (not late)
    r = "INIT"
    step = 0
    while step < maxStep:
        if ok:
            r = "PASS"
            break
        elif vip and (score >= 42):
            r = "PASS_VIP"
            break
        else:
            r = "FAIL"
        step = step + 1
        if step >= 2 and score < 37:
            r = "ABORT"
            break
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** CFG có **while**, **break**, **elif**; **V(G)** cao — sinh viên **phải vẽ**.  
**Data flow:** `r`, `step`, `ok`. **MC/DC:** chọn **một** trong `ok` hoặc `(vip and score>=…)`.  
**Bảng TC tổng:** **≥7** dòng (ERR; không vào while; vào while thoát nhánh 1/2/3; ABORT; …).

**Bước 2 – Kết luận:** Đỉnh thang **10–20** file 07 — **tổng hợp** mọi kỹ thuất trước đó.

---
### Bài mẫu 18 — Mức độ: Rất khó (mức 3)
**Module tổng hợp (vòng lặp + cờ)**


*(Bài 16–20: **while** nhỏ + **break** — checklist đầy đủ nhất.)*

**Đề bài (chi tiết):**

```text
function module18(score, late, vip, maxStep):  // maxStep nguyên 1..5
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 51) and (not late)
    r = "INIT"
    step = 0
    while step < maxStep:
        if ok:
            r = "PASS"
            break
        elif vip and (score >= 43):
            r = "PASS_VIP"
            break
        else:
            r = "FAIL"
        step = step + 1
        if step >= 2 and score < 38:
            r = "ABORT"
            break
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** CFG có **while**, **break**, **elif**; **V(G)** cao — sinh viên **phải vẽ**.  
**Data flow:** `r`, `step`, `ok`. **MC/DC:** chọn **một** trong `ok` hoặc `(vip and score>=…)`.  
**Bảng TC tổng:** **≥7** dòng (ERR; không vào while; vào while thoát nhánh 1/2/3; ABORT; …).

**Bước 2 – Kết luận:** Đỉnh thang **10–20** file 07 — **tổng hợp** mọi kỹ thuất trước đó.

---
### Bài mẫu 19 — Mức độ: Cực khó
**Module tổng hợp (vòng lặp + cờ)**


*(Bài 16–20: **while** nhỏ + **break** — checklist đầy đủ nhất.)*

**Đề bài (chi tiết):**

```text
function module19(score, late, vip, maxStep):  // maxStep nguyên 1..5
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 52) and (not late)
    r = "INIT"
    step = 0
    while step < maxStep:
        if ok:
            r = "PASS"
            break
        elif vip and (score >= 44):
            r = "PASS_VIP"
            break
        else:
            r = "FAIL"
        step = step + 1
        if step >= 2 and score < 39:
            r = "ABORT"
            break
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** CFG có **while**, **break**, **elif**; **V(G)** cao — sinh viên **phải vẽ**.  
**Data flow:** `r`, `step`, `ok`. **MC/DC:** chọn **một** trong `ok` hoặc `(vip and score>=…)`.  
**Bảng TC tổng:** **≥7** dòng (ERR; không vào while; vào while thoát nhánh 1/2/3; ABORT; …).

**Bước 2 – Kết luận:** Đỉnh thang **10–20** file 07 — **tổng hợp** mọi kỹ thuất trước đó.

---
### Bài mẫu 20 — Mức độ: Cực khó · tổng hợp
**Module tổng hợp (vòng lặp + cờ)**


*(Bài 16–20: **while** nhỏ + **break** — checklist đầy đủ nhất.)*

**Đề bài (chi tiết):**

```text
function module20(score, late, vip, maxStep):  // maxStep nguyên 1..5
    if score < 0 or score > 100:
        return "ERR"
    ok = (score >= 48) and (not late)
    r = "INIT"
    step = 0
    while step < maxStep:
        if ok:
            r = "PASS"
            break
        elif vip and (score >= 40):
            r = "PASS_VIP"
            break
        else:
            r = "FAIL"
        step = step + 1
        if step >= 2 and score < 35:
            r = "ABORT"
            break
    return r
```

**Hướng dẫn giải chi tiết:**

**Bước 1 – Checklist:** CFG có **while**, **break**, **elif**; **V(G)** cao — sinh viên **phải vẽ**.  
**Data flow:** `r`, `step`, `ok`. **MC/DC:** chọn **một** trong `ok` hoặc `(vip and score>=…)`.  
**Bảng TC tổng:** **≥7** dòng (ERR; không vào while; vào while thoát nhánh 1/2/3; ABORT; …).

**Bước 2 – Kết luận:** Đỉnh thang **10–20** file 07 — **tổng hợp** mọi kỹ thuất trước đó.

---

## PHẦN 2: BÀI TẬP TỰ LUYỆN

---

*20 bài — tổng hợp nhiều tiêu chí.*

*Chỉ có **đề** và **gợi ý**; làm đủ **8 bước** (CFG → bảng TC tổng) như **PHẦN 1** khi nộp.*  
**Thang khớp PHẦN 1:** **Bài tự luyện #N** dùng **cùng khung cấu trúc** với **Bài mẫu #N** — chỉ đổi **ngữ cảnh** (đăng nhập / đơn hàng / học phần / …) và **ngưỡng số** hợp lệ; **không** copy nguyên xi chữ kết quả giữa hai số bài.

- **1–9:** module **`(score, late, vip)`**, **không** vòng lặp; kiểm tra miền `score`, `ok = (score >= …) and (not late)`, `if ok` / `elif vip and …` / `else`; **≈10–16 dòng**.  
- **10–15:** thêm **`retry`** (nguyên), `ERR_RETRY`, `ok` có thêm điều kiện **`retry`**, nhánh **`WARN_RETRY`** khi `retry == 0` (như mẫu 10–15).  
- **16–20:** thêm **`maxStep`** (hoặc tương đương), **`while`** + **`break`** / **`ABORT`** (như mẫu 16–20).

### Bài 1 — Mức độ: Dễ
**Tự luyện #1**

**Đề bài (chi tiết):**  
Viết mã giả **ba tham số** `(score, late, vip)` — **không** lặp — khớp **cấu trúc Bài mẫu 1**; nghiệp vụ tự chọn (vd. đạt môn / voucher).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
C/D trên `(score>=…) and (not late)` và `(vip and score>=…)`; MC/DC chọn **một** biểu thức (vd. `ok`) — **3 test**; bảng tổng **≥5** TC.


---
### Bài 2 — Mức độ: Dễ
**Tự luyện #2**

**Đề bài (chi tiết):**  
Cùng khung **Bài mẫu 2** (ba tham số, không lặp); đổi ngưỡng và tên chuỗi trả về cho đúng miền.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Giữ `and` / `not late` trong mã giả giống mẫu; data flow `ok` hoặc `r`.


---
### Bài 3 — Mức độ: Dễ
**Tự luyện #3**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 3** — module chấm điểm / phân loại (tự đặt ngưỡng nguyên).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Basis path: liệt kê đủ nhánh có `return "ERR"` sớm.


---
### Bài 4 — Mức độ: Dễ
**Tự luyện #4**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 4** — cùng dạng rẽ nhánh `if` / `elif` / `else` sau kiểm tra miền.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Một bảng TC tổng: cột tiêu chí C0, C1, C/D, … (đánh dấu đạt).


---
### Bài 5 — Mức độ: Dễ
**Tự luyện #5**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 5** — ví dụ nghiệp vụ khác bài 1–4 (vd. ưu tiên hạng khách).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
V(G) đếm trên CFG có tách `or` ở điều kiện đầu.


---
### Bài 6 — Mức độ: Dễ
**Tự luyện #6**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 6**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đừng lẫn `late` với số điểm — `late` là boolean.


---
### Bài 7 — Mức độ: Dễ
**Tự luyện #7**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 7**; có thể đổi `PASS_VIP` thành nhãn khác nhưng **cùng vai trò** nhánh VIP.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
MC/DC: nếu chọn biểu thức `vip and (score>=…)` thì bảng 3 cặp độc lập cho `vip` và `score>=…` trong ngữ cảnh nhánh đó.


---
### Bài 8 — Mức độ: Dễ
**Tự luyện #8**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 8**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
So sánh nhanh độ phức tạp CFG với bài 7 (cùng “xương sống”, khác ngưỡng).


---
### Bài 9 — Mức độ: Dễ
**Tự luyện #9**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 9** — **đỉnh** nhóm không lặp: kiểm tra lại đủ checklist trước khi sang nhóm **retry**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Chuẩn bị sẵn **≥5** TC phủ ERR, PASS, PASS_VIP, FAIL, late.


---
### Bài 10 — Mức độ: Trung bình
**Tự luyện #10**

**Đề bài (chi tiết):**  
Thêm tham số **`retry`** — khớp **Bài mẫu 10** (`ERR_RETRY`, `WARN_RETRY`, điều kiện `retry` trong `ok` và `elif`).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Bảng tổng **≥6** dòng; C/D cho từng điều kiện con liên quan `retry` còn **khả thi** sau ràng buộc trước đó.


---
### Bài 11 — Mức độ: Trung bình
**Tự luyện #11**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 11** — cùng “khung retry”, ngưỡng `score` / VIP / WARN khác bài 10.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
V(G) > bài 1–9; liệt kê basis path đủ số theo công thức.


---
### Bài 12 — Mức độ: Trung bình
**Tự luyện #12**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 12**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Kiểm tra nhánh `retry` ngoài miền cho `ERR_RETRY` trước khi vào logic chính.


---
### Bài 13 — Mức độ: Khó
**Tự luyện #13**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 13**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Data flow: thêm biến phụ nếu cần (vd. cờ tạm) — ghi rõ def / c-use.


---
### Bài 14 — Mức độ: Khó
**Tự luyện #14**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 14**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Ưu tiên MC/DC trên `ok` (**3 điều kiện con** với `retry`) như mẫu 10–14; nếu GV cho phép gọn, có thể chọn **một** quyết định **2 con** khác (vd. `vip and (score>=…)`) và ghi rõ phạm vi.


---
### Bài 15 — Mức độ: Khó
**Tự luyện #15**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 15** — **đỉnh** nhóm retry; rà soát lại toàn bộ nhánh có thể tới `FAIL`.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Đối chiếu checklist với bài mẫu 15 (không bỏ bước 8).


---
### Bài 16 — Mức độ: Rất khó
**Tự luyện #16**

**Đề bài (chi tiết):**  
Thêm **`maxStep`** (1..5), vòng **`while`** và **`break`** — khớp **Bài mẫu 16** (logic bước / thoát sớm).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
CFG phải thể hiện vòng lặp; TC gồm: không vào while; vào while thoát nhánh 1/2/3; vòng lặp nhiều bước nếu cần.


---
### Bài 17 — Mức độ: Rất khó
**Tự luyện #17**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 17** — tinh chỉnh điều kiện trong thân while (vd. ngưỡng `score` khác 16).

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Basis path: đường có `break` tách biệt đường hết `maxStep`.


---
### Bài 18 — Mức độ: Rất khó
**Tự luyện #18**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 18** — có thể thêm nhánh **`ABORT`** hoặc điều kiện dừng gấp như mẫu.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Bảng TC tổng **≥7** dòng nếu có nhiều kết cục (ERR, PASS, …, ABORT).


---
### Bài 19 — Mức độ: Cực khó · tổng hợp
**Tự luyện #19**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 19**.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
MC/DC trên một điều kiện trong loop (vd. `ok`) hoặc trên `vip and …` — ghi rõ phạm vi.


---
### Bài 20 — Mức độ: Cực khó · tổng hợp
**Tự luyện #20**

**Đề bài (chi tiết):**  
Khớp **Bài mẫu 20** — **đỉnh** file: đủ while, break, elif, nhiều kết cục; tự kiểm tra lại toàn bộ tiêu chí từ 01→06.

**Yêu cầu:** Làm đủ các bước trong **Quy trình chuẩn** đầu file và trình bày như **PHẦN 1** (CFG / bảng phủ / test case / kết luận — tùy kỹ thuật của file).

**Gợi ý giải:**  
Kết luận cuối bài: tiêu chí nào “mạnh nhất” đã áp dụng và vì sao.


---

*Tài liệu chỉnh sửa trực tiếp trong file này; có thể bổ sung ví dụ số theo lớp.*
