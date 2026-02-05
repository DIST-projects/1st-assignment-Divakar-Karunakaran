import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements the remote interface.
 * This object lives on the server.
 */
public class StudentServiceImpl
        extends UnicastRemoteObject
        implements StudentService {

    private Map<String, Map<String, Object>> students;

    protected StudentServiceImpl() throws RemoteException {
        super();
        students = new HashMap<>();
    }

    public String addStudent(String regNo, String name, int marks) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("marks", marks);
        students.put(regNo, data);
        return "Student added successfully";
    }

    public Map<String, Object> getStudent(String regNo) {
        return students.getOrDefault(regNo, null);
    }

    public String calculateGrade(String regNo) {
        if (!students.containsKey(regNo))
            return "Student not found";

        int marks = (int) students.get(regNo).get("marks");

        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else return "Fail";
    }
}
