package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class SelenideRepository {

  @Test
  void shouldFindSelenideRepository(){
    // открыть страницу github.com
    open("https://github.com");
    // ввести в поле поиска selenide и нажать Enter
    $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
    // нажимаем на линк от первого результата поиска
    $$("ul.repo-list li").first().$("a").click();
    // check: в заголовке встрачается selenide/selenide
    $("#repository-container-header").shouldHave(text("selenide / selenide"));
  }

  @Test
  void shouldFindSoftAssertions(){
    // Откройте страницу Selenide в Github
    open("https://github.com");
    $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
    $$("ul.repo-list li").first().$("a").click();
    $("#repository-container-header").shouldHave(text("selenide / selenide"));

    // Перейдите в раздел Wiki проекта
    $("#wiki-tab").click();

    // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
    $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
    //$("[data-filterable-for=wiki-pages-filter]").$(".details-reset").shouldHave(text("SoftAssertions"));

    // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    $(byText("SoftAssertions")).click();
    $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
  }
}
