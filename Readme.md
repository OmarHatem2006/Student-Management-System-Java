# 🎓 Student Management System - نظام إدارة الطلاب

## 📝 Project Overview | نبذة عن المشروع

This is a comprehensive Java-based desktop application designed for Tech University. 
It allows administrators to manage student records, academic subjects, and automatic GPA calculations through a user-friendly Graphical User Interface (GUI).

هذا المشروع عبارة عن تطبيق مكتبي متكامل بلغة الجافا مصمم لـ جامعة برج العرب التكنولوجية. يتيح النظام للمسؤولين إدارة بيانات الطلاب، المواد الدراسية، وحساب المعدلات التراكمية تلقائياً من خلال واجهة رسومية سهلة الاستخدام.

---

## 🚀 Key Features | المميزات الأساسية

- Student Management: Add, search, update, and remove students.
  - إدارة الطلاب: إضافة، بحث، تحديث، وحذف الطلاب.
- Subject Handling: Assign subjects to students and remove them if needed.
  - إدارة المواد: إضافة المواد الدراسية للطلاب وحذفها عند الحاجة.
- GPA Calculation: Automatic calculation based on credit hours formula.
  - حساب المعدل التراكمي تلقائياً بناءً على عدد الساعات المعتمدة.
- Academic Insights: Identify the student with the highest GPA.
  - تحديد الطالب صاحب أعلى معدل تراكمي في النظام.
- Grade Conversion: Convert numeric grades to letter grades (A, B, C, D, F).
  - تحويل الدرجات الرقمية إلى تقديرات حرفية.
- Input Validation: Guard against invalid grades (>100 or <0) and empty names.
  - حماية ضد الإدخالات الخاطئة مثل الدرجات خارج النطاق أو الأسماء الفارغة.

---

## 🛠️ Technical Stack | التقنيات المستخدمة

- Language: Java (JDK 8 or higher)
- GUI Library: Java Swing / AWT
- Data Structure: `ArrayList` for dynamic data management
- Architecture: Object-Oriented Programming (OOP) with 4 main classes

---

## 📂 Project Structure | هيكل المشروع

- `Student.java`: Holds student info and GPA logic.
  - يخزن بيانات الطالب ومنطق حساب المعدل.
- `Subject.java`: Represents academic courses and grades.
  - يمثل المواد الدراسية والتقديرات.
- `StudentManagementSystem.java`: Backend logic for managing the student list.
  - المنطق الخلفي لإدارة قائمة الطلاب.
- `StudentGUI.java`: Visual interface and user interaction.
  - واجهة المستخدم وتفاعل الأزرار.

---

## 🧮 GPA Formula | معادلة الحساب

The system follows the official academic formula:

GPA = (sum of grade * credit hours) / (sum of credit hours)

النظام يتبع المعادلة الأكاديمية الرسمية:

$$GPA = \frac{\sum (Grade \times CreditHours)}{\sum CreditHours}$$

---

### 📺 Project Demo | عرض تجربة المشروع
You can watch the full demonstration of the system here:
يمكنك مشاهدة عرض كامل للنظام من هنا:

👉 [Watch Video | مشاهدة الفيديو]([https://drive.google.com/file/d/1rRK2NCUy9ADIIdikI4YmUq5itI-oYJhS/view?usp=sharing])

## 👥 Team Infinity | فريق إنفينيتي

- University: Burj Al-Arab Technological University
- Department: Information Technology
- Course: Java Programming
- Supervised by: Dr. Radwa Rady & Dr. Ghada Fathy
