package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class IdeaMatrix extends ToolsPage {

    public IdeaMatrix typeArequest() {
        $x("//*[@class='input']").setValue("Автоматизатор");
        return page(IdeaMatrix.class);
    }

    public IdeaMatrix makeArequest() {
        $x("//*[@class='button blue-button']").click();
        return page(IdeaMatrix.class);
    }

    public void checkArequestResults() throws UnsupportedEncodingException {

        String URL = url();
        String urlDecode = java.net.URLDecoder.decode(URL, "UTF-8");

        Assert.assertTrue(urlDecode.contains("Автоматизатор"));
        $x("//*[@class='als-columns text-double-margin']")
                .shouldHave(Condition.visible , text("Автоматизатор"));
        $$(By.xpath("//*[@class='als-columns text-double-margin']"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));

    }
}
