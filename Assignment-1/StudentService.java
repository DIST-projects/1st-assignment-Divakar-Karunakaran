import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * Remote interface.
 * Declares methods that can be invoked remotely.
 */
public interface StudentService extends Remote {

    String addStudent(String regNo, String name, int marks)
            throws RemoteException;

    Map<String, Object> getStudent(String regNo)
            throws RemoteException;

    String calculateGrade(String regNo)
            throws RemoteException;
}
