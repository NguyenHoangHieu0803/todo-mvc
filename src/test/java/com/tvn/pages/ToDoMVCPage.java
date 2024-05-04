package com.tvn.pages;

import com.tvn.common.Browser;
import org.openqa.selenium.*;

import static com.tvn.common.Browser.*;

public class ToDoMVCPage {

    public void open() {
        Browser.visit("https://todomvc.com/examples/vue/dist/#/");
    }

    public void createTask (String name) {
        Browser.fill(By.className("new-todo"),String.format("%s\n",name));
    }

    public int getItemLeft () {
        if (getElement(By.cssSelector(".todo-count strong")).isDisplayed()) {
            return Integer.parseInt(Browser.getText(By.cssSelector(".todo-count strong")));
        } else return 0;
    }

    public void markComplete (String name) {
        click(By.xpath(String.format("//label[.='%s']/../input",name)));
    }

    public void deleteComplete (String name) {
        hover(By.xpath(String.format("//label[.='%s']",name)));
        click(By.xpath(String.format("//label[.='%s']/../button",name)));
    }

    public void filterTask (String byStatus) {
        if(getElement(By.xpath(String.format("//a[.='%s']",byStatus))).isDisplayed()){
            click(By.xpath(String.format("//a[.='%s']",byStatus)));
        }
    }
    public boolean isTaskDisplayed (String name) {
        return Browser.isDisplayed(By.xpath(String.format("//label[.='%s']",name)));
    }

    public void updateTaskName(String oldName, String newName) {
        doubleClick(By.xpath(String.format("//label[.='%s']",oldName)));
        WebElement editTaskNameTextBox = getElement(By.cssSelector(".todo-list")).findElement(By.cssSelector("input.edit"));
        executeScript("arguments[0].value = ''",editTaskNameTextBox);
        editTaskNameTextBox.sendKeys(newName+ Keys.ENTER);
    }
}