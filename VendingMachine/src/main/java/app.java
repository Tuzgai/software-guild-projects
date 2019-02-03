
import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.service.VendingMachineServiceImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author Stuart
 */
public class app {
    public static void main(String[] args) {
        try {
            VendingMachineDao dao = new VendingMachineDaoFileImpl();
            VendingMachineService service = new VendingMachineServiceImpl(dao);
            VendingMachineView view = new VendingMachineView();
            VendingMachineController controller = new VendingMachineController(view, service);
            controller.run();
        } catch (VendingMachineDaoException e) {
            System.out.println("Error: could not open inventory file. Please check that the file exists and try again.");
        }
    }

}
