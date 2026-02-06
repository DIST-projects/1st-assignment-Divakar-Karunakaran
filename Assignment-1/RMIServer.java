import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI Server.
 * Creates the registry and binds the remote object.
 */
public class RMIServer {

    public static void main(String[] args) {
        try {
            StudentService service = new StudentServiceImpl();

            // Start RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object with a name
            registry.rebind("StudentService", service);

            System.out.println("RMI Student Service running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
