package appBackend;

import com.leapmotion.leap.Controller;
import machineLearning.MListener;

public class Creator {

    public static void main(String[] args) {
        
          MListener listener = new MListener();
        
        Controller controller = new Controller();
        System.out.println("adding listener!!!!!!!!!!!!!!!!!!!!!");
        controller.addListener(listener);
        System.out.println("done ma firend");
        
        //start chromeController Thread
        ChromeController chrome = new ChromeController();
        chrome.start();

        DesktopMain.startUI(args);

    }

}
