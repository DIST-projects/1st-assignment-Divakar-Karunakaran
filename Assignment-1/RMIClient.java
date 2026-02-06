import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

/**
 * RMI Client.
 * Looks up the remote object and invokes methods.
 */
public class RMIClient {

    public static void main(String[] args) {
        try {
            // Replace with EC2 public IP
            Registry registry =
                LocateRegistry.getRegistry("EC2_PUBLIC_IP", 1099);

            // Lookup remote object
            StudentService service =
                (StudentService) registry.lookup("StudentService");

            System.out.println(
                service.addStudent("CS101", "Arjun", 82)
            );

            Map<String, Object> student =
                service.getStudent("CS101");

            System.out.println("Student Details: " + student);
            System.out.println(
                "Grade: " + service.calculateGrade("CS101")
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
