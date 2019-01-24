class student:
    def __init__(self, id=0, name="Default", surname="Default", year=1, grades=[]):
        self.id = id
        self.name = name
        self.surname = surname
        self.year = year
        self.grades = grades
    
    def show_details(self):
        print("ID: {}\nName: {}\nSurname: {}\nYear: {}\nGrades: {}".format(self.id, self.name, self.surname, self.year, self.grades))

def menu():
    choice = "0"
    while(choice != "5" and choice != "Exit"):
        choice = input("1) Add student\n2) Display students\n3) Search student\n4) Delete student\n5) Exit\n")
        try:
            my_dict[choice]()
        except KeyError:
            if(choice != "5" and choice != "Exit"):
                print("Incorrect input!")

def add_student():
    s_id = int(input("Student id: "))
    s_name = input("Student name: ")
    s_sur = input("Student surname: ")
    s_year = int(input("Student year: "))
    s_grades = []
    for i in range(0, 12):
        s_grades.append(float(input("Input grade {}: ".format(i+1))))
    students.append(student(s_id, s_name, s_sur, s_year, s_grades))
    

def display_student():
    for i in students:
        i.show_details()

def search_student():
    search_id = int(input("Student id to search: "))
    for i in students:
        if i.id == search_id:
            i.show_details()
            return
    print("Student not found!")

def delete_student():
    index = int(input("Which student to delete? "))
    if index-1 in range(0, len(students)):
        del students[index-1]
  
my_dict = {
    "1" : add_student,
    "2" : display_student,
    "3" : search_student,
    "4" : delete_student
}

students = []

menu()
