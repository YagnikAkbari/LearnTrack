# LearnTrack — Pending Tasks (Guide vs Current Code)

I compared [PROJECT_GUIDE.md](file:///c:/Users/Tech/Downloads/LearnTrack/PROJECT_GUIDE.md) against every file in your codebase. Here's what's **missing or incomplete**:

---

## Section A — Environment Setup & JVM Understanding (10 marks)

| Item | Status | What to do |
|------|--------|------------|
| `Setup_Instructions.md` | ✅ Has content | — |
| `JVM_Basics.md` | ❌ Empty | Write JDK vs JRE vs JVM explanation, bytecode, "Write Once Run Anywhere" |

---

## Section B — Package Structure & Basics (10 marks)

| Item | Status | What to do |
|------|--------|------------|
| Package structure | ⚠️ Slightly off | Guide says `entity`, `util` — you have `entities`, `utils`. Not a blocker, but be aware |
| `IdGenerator.java` | ❌ Empty class | Move the static ID counter logic here (guide wants centralized `getNextStudentId()`, `getNextCourseId()` etc.) instead of each entity having its own counter |
| `AppConstants.java` | ❌ Empty | Add any app-level constants (e.g., max name length, menu text) |
| `MenuOptions.java` | ❌ Empty | Define menu option constants (see Section D) |
| `InvalidInputException.java` | ❌ Empty | Implement it — same pattern as `EntityNotFoundException` |

---

## Section C — Core OOP Implementation (40 marks)

### C1. Entities & Encapsulation (15 marks)

| Item | Status | What to do |
|------|--------|------------|
| Private fields + getters/setters | ⚠️ Partial | `Student` is missing getters for `batch` and `active` |
| **Default constructors** | ❌ Missing | Guide requires **default + parameterized** constructors on all entities |
| **Constructor overloading** | ❌ Missing | Add at least one overloaded constructor per entity to demonstrate the concept |

### C2. Inheritance & Polymorphism (10 marks)

| Item | Status | What to do |
|------|--------|------------|
| `Person` base class | ✅ Done | — |
| `Student extends Person` | ✅ Done | — |
| `Trainer extends Person` | ✅ Exists (optional) | — |
| `super` keyword usage | ✅ Done | — |
| **Method overriding** (`getDisplayName()`) | ❌ Missing | Add a `getDisplayName()` in `Person` and override it in `Student` (and optionally `Trainer`) |

### C3. Static, Methods, Utility (15 marks)

| Item | Status | What to do |
|------|--------|------------|
| Centralized `IdGenerator` | ❌ Empty | Move all static ID counters into `IdGenerator` with static methods |
| **Method overloading** | ❌ Missing | Demonstrate method overloading somewhere (e.g., overloaded `addStudent` in service, or overloaded search in repository) |

---

## Section D — Application Logic & Menu UI (25 marks) 🔴 Biggest Gap

| Item | Status | What to do |
|------|--------|------------|
| **Menu-driven console (Scanner)** | ❌ Missing | `Main.java` currently hardcodes demo data. Guide requires an **interactive menu loop** using `Scanner` with `while` + `switch` |
| Search student by ID | ❌ Missing | Add menu option to search by ID |
| Handle invalid input | ❌ Missing | Catch `InputMismatchException` for non-integer menu input, show "option not found" for invalid choices |
| `MenuOptions.java` | ❌ Empty | Store menu option constants here |
| Keep Main.java thin | ⚠️ | Main should only do input/output + call service methods — no business logic |

### Expected menu structure (from the guide):

```
===== LearnTrack Menu =====
1. Student Management
2. Course Management
3. Enrollment Management
4. Exit

--- Student Management ---
1. Add Student
2. View All Students
3. Search by ID
4. Deactivate Student
5. Back

--- Course Management ---
1. Add Course
2. View Courses
3. Activate/Deactivate Course
4. Back

--- Enrollment Management ---
1. Enroll Student
2. View Enrollments
3. Update Status (Completed/Cancelled)
4. Back
```

---

## Section E — Exception Handling (10 marks)

| Item | Status | What to do |
|------|--------|------------|
| `EntityNotFoundException` | ✅ Done | — |
| `InvalidInputException` | ❌ Empty file | Implement it (same pattern) |
| Handle wrong inputs in menu | ❌ | Catch `InputMismatchException`, show user-friendly messages |

---

## Section F — Documentation & Clean Code (5 marks)

| Item | Status | What to do |
|------|--------|------------|
| `README.md` | ❌ Empty | Write project overview + compile/run steps |
| `Design_Notes.md` | ❌ Empty | Explain: why ArrayList, where static is used, where inheritance is used |
| `JVM_Basics.md` | ❌ Empty | Explained above in Section A |

---

## Priority Summary

| Priority | Task | Marks |
|----------|------|-------|
| 🔴 High | Interactive menu-driven console with Scanner (while loop + switch) | 25 |
| 🔴 High | Default constructors + constructor overloading on entities | 15 |
| 🟡 Medium | Centralize `IdGenerator` + demonstrate method overloading | 15 |
| 🟡 Medium | Add `getDisplayName()` override for polymorphism demo | 10 |
| 🟡 Medium | Fill `InvalidInputException`, `MenuOptions`, `AppConstants` | 10 |
| 🟢 Low | Write `README.md`, `Design_Notes.md`, `JVM_Basics.md` | 5+10 |
