package letcode.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import letcode.baseclass.com.BaseClass;

public class HookClass {

    @Before
    public void browserLaunch() {
        BaseClass.launchBrowser();
//        BaseClass.loadURL("https://letcode.in/");
//      BaseClass.loadURL("https://www.cheapair.com/");
        System.out.println("Browser launched");
    }

    @After
    public void quitBrowser() {
        BaseClass.quitBrowser();
        System.out.println("Browser closed");
    }
}
