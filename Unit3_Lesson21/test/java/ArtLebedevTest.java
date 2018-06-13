import org.apache.log4j.BasicConfigurator;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.IdeaMatrix;
import pages.MainPage;
import pages.ToolsPage;
import pages.utils.PrepareClass;
import pages.utils.TestListener;

import java.io.UnsupportedEncodingException;

@Listeners(TestListener.class)
public class ArtLebedevTest extends PrepareClass {


    MainPage mainPage = new MainPage();
    ToolsPage toolsPage = new ToolsPage();
    IdeaMatrix ideaMatrix = new IdeaMatrix();


    @Test
    public void artLebedevTest() throws UnsupportedEncodingException {

        mainPage.openMainPage();
        mainPage.switchToTools();
        toolsPage.clickIdeaMatrix();
        ideaMatrix.typeArequest();
        ideaMatrix.makeArequest();
        ideaMatrix.checkArequestResults();

    }

}
