package component;

import org.openqa.selenium.By;

public class Locator {

    public By element ;
    public By parent ;

    public Locator(By element, By parent) {
        this.element = element;
        this.parent = parent;
    }

}
