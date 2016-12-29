package be.tvde.innerclasses.static_member_class;

/**
 * Created by tomvde on 27/12/2016.
 */
public class ComputerAccessoryTest {

    public static void main(String[] args) {
        // Create two monitors
        ComputerAccessory.Monitor m17 = new ComputerAccessory.Monitor(17);
        ComputerAccessory.Monitor m19 = new ComputerAccessory.Monitor(19);

        // Create two Keyboards
        ComputerAccessory.Keyboard k122 = new ComputerAccessory.Keyboard(122);
        ComputerAccessory.Keyboard k142 = new ComputerAccessory.Keyboard(142);

        System.out.println(m17);
        System.out.println(m19);
        System.out.println(k122);
        System.out.println(k142);
    }
}
