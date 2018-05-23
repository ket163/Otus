package pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ToolsPage extends MainPage {

    public ToolsPage clickIdeaMatrix() {
        $x("//*[@id='item-matrix']").click();
        return page(IdeaMatrix.class);
    }
}
