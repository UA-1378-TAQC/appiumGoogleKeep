package com.coffeecart.ui.modal;

import com.coffeecart.ui.Base;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BaseModal extends Base {
    @Getter
    protected WebElement rootElement;

    public BaseModal(WebDriver driver, WebElement rootElement){
        super(driver);
        this.rootElement = rootElement;
        PageFactory.initElements(new DefaultElementLocatorFactory(rootElement), this);
    }
}


