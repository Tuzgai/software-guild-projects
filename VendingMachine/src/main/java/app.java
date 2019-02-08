
import com.sg.vendingmachine.controller.VendingMachineController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Stuart
 */
public class app {

    public static void main(String[] args) {
        /*try {
            VendingMachineDao dao = new VendingMachineDaoFileImpl();
            VendingMachineService service = new VendingMachineServiceImpl(dao);
            VendingMachineView view = new VendingMachineView();
            VendingMachineController controller = new VendingMachineController(view, service);
            controller.run();
        } catch (VendingMachineDaoException e) {
            System.out.println("Error: could not open inventory file. Please check that the file exists and try again.");
        }*/

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller
                = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }

}
