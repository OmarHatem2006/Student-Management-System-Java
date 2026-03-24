🎓 Student Management System - نظام إدارة الطلاب

📝 Project Overview | نبذة عن المشروع

This is a comprehensive Java-based desktop application designed for Burj Al-Arab Technological University. It allows administrators to manage student records, academic subjects, and automatic GPA calculations through a user-friendly Graphical User Interface (GUI).

هذا المشروع عبارة عن تطبيق مكتبي متكامل بلغة الجافا مصمم لجامعة برج العرب التكنولوجية. يتيح النظام للمسؤولين إدارة بيانات الطلاب، المواد الدراسية، وحساب المعدلات التراكمية تلقائياً من خلال واجهة رسومية سهلة الاستخدام.


📺 Project Demo | عرض تجربة المشروع

You can watch a full demonstration of the system and its features through the link below:

يمكنك مشاهدة عرض كامل للنظام والمميزات من خلال الرابط التالي:

👉 https://drive.google.com/file/d/1rRK2NCUy9ADIIdikI4YmUq5itI-oYJhS/view?usp=sharing


🚀 Key Features | المميزات الأساسية

The system supports all "Big Team" requirements:

يدعم النظام جميع متطلبات "الفريق الكبير" وتشمل:

- Student Management: Add, search, update, and remove students.
- (إدارة الطلاب: إضافة، بحث، تحديث، وحذف الطلاب).
- Subject Handling: Assign subjects to students and remove them if needed.
- (إدارة المواد: إضافة المواد الدراسية للطلاب وحذفها عند الحاجة).
- GPA Calculation: Automatic calculation based on credit hours formula.
- (حساب المعدل التراكمي تلقائياً بناءً على عدد الساعات المعتمدة).
- Academic Insights: Identify the student with the Highest GPA.
- (تحديد الطالب صاحب أعلى معدل تراكمي في النظام).
- Grade Conversion: Convert numeric grades to letter grades (A, B, C, D, F).
- (تحويل الدرجات الرقمية إلى تقديرات حرفية).
- Input Validation: Guard against invalid grades (>100 or <0) and empty names.
- (حماية ضد الإدخالات الخاطئة مثل الدرجات خارج النطاق أو الأسماء الفارغة).
- Unique ID Enforcement: Prevents duplicate student IDs.
- (منع تكرار معرفات الطلاب).

🛠️ Technical Stack | التقنيات المستخدمة

- Language: Java (JDK 8 or higher).
- GUI Library: Java Swing / AWT.
- Data Structure: ArrayList for dynamic data management.
- Architecture: Object-Oriented Programming (OOP) with 4 main classes.


📂 Project Structure | هيكل المشروع

The project is organized into separate files for better maintainability:

تم تنظيم المشروع في ملفات منفصلة لسهولة التعديل:

- Main.java: Visual interface and user interaction
    - (الواجهة الرسومية وتفاعل المستخدم).
- Student.java: Holds student info and GPA logic
    - (معلومات الطالب وحساب المعدل).
- Subject.java: Represents academic courses and grades
    - (تمثيل المواد الدراسية والدرجات).
- StudentManagementSystem.java: Backend logic for managing the student list
    - (المنطق الخلفي لإدارة قائمة الطلاب).

🧮 GPA Formula | معادلة الحساب

The system follows the official academic formula provided in the requirements:

النظام يتبع المعادلة الأكاديمية الرسمية المذكورة في المتطلبات:

$$ GPA = \frac{\sum (Grade \times CreditHours)}{\sum CreditHours} $$


🔧 How to Run | كيفية التشغيل

1. Ensure you have Java JDK 8+ installed.
2. Compile the project: `javac *.java`
3. Run the application: `java GUI2.Main`

👥 Team Infinity | فريق إنفينيتي

- University: Burj Al-Arab Technological University.
- Department: Information Technology.
- Course: Java Programming.
- Supervised by: Dr. Radwa Rady & Dr. Ghada Fathy. 
