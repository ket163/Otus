package pages;


import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage  {

    public MainPage openMainPage() {
        open("https://www.artlebedev.ru/");
        return page(MainPage.class);
    }


    public MainPage switchToTools() {
       $x("//a[contains(@href,'tools')]").click();
        return page(ToolsPage.class);
    }
}
