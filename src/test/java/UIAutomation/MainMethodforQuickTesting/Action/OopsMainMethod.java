package UIAutomation.MainMethodforQuickTesting.Action;

import java.io.IOException;

public class OopsMainMethod
{
    public static void main(String[] args) throws IOException {
        AbstractImplementation Abs=new AbstractImplementation();
        Abs.launchBrowser("Chrome");
        Abs.getURL("https://opensource-demo.orangehrmlive.com/");
    }
}
