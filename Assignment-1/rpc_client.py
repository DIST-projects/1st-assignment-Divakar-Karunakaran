"""
RPC CLIENT
----------
This client runs on the local machine.
It connects to the AWS-hosted RPC server and
invokes remote procedures.
"""

import xmlrpc.client

# Replace with your EC2 public IP
server = xmlrpc.client.ServerProxy("http://EC2_PUBLIC_IP:8000")

print(server.add_student("CS101", "Arjun", 82))
print("Student Details:", server.get_student("CS101"))
print("Grade:", server.calculate_grade("CS101"))
