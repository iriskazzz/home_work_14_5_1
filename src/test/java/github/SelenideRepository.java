package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class SelenideRepository {

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

    // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    $(byText("SoftAssertions")).click();
    $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
  }
}
