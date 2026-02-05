"""
RPC SERVER
----------
This server runs on AWS EC2.
It exposes student-related procedures that can be
invoked remotely by a client using XML-RPC.
"""

from xmlrpc.server import SimpleXMLRPCServer

class StudentService:
    """
    This class defines remote procedures.
    Each public method can be called by a remote client.
    """

    def __init__(self):
        # Dictionary to store student data in memory
        self.students = {}

    def add_student(self, reg_no, name, marks):
        """
        Adds a student record to the server.
        """
        self.students[reg_no] = {
            "name": name,
            "marks": marks
        }
        return "Student added successfully"

    def get_student(self, reg_no):
        """
        Returns student details for a given registration number.
        """
        if reg_no not in self.students:
            return "Student not found"
        return self.students[reg_no]

    def calculate_grade(self, reg_no):
        """
        Calculates grade based on marks.
        """
        if reg_no not in self.students:
            return "Student not found"

        marks = self.students[reg_no]["marks"]

        if marks >= 90:
            return "A"
        elif marks >= 75:
            return "B"
        elif marks >= 60:
            return "C"
        else:
            return "Fail"


# Create RPC server
# 0.0.0.0 allows access from outside the EC2 machine
server = SimpleXMLRPCServer(("0.0.0.0", 8000), allow_none=True)

# Register all methods of StudentService as remote procedures
server.register_instance(StudentService())

print("RPC Student Service running on port 8000...")

# Keep server running indefinitely
server.serve_forever()
