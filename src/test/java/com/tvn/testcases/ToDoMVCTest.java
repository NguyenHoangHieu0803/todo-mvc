package com.tvn.testcases;


import com.tvn.base.TestBase;
import com.tvn.common.Browser;
import com.tvn.pages.ToDoMVCPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToDoMVCTest extends TestBase {
    ToDoMVCPage toDoMVCPage;
    @BeforeClass
    void setUp () {
        Browser.openBrowser("chrome");
        toDoMVCPage = new ToDoMVCPage();
        toDoMVCPage.open();
    }

    @Test
    void verifyUserAbleToCreateNewTask () {
        String taskName = "task 1";
        int itemLeftBefore = toDoMVCPage.getItemLeft();
        toDoMVCPage.createTask(taskName);
        int itemLeftAfter = toDoMVCPage.getItemLeft();

        Assert.assertEquals(itemLeftAfter-itemLeftBefore,1);

        toDoMVCPage.filterTask("All");
        Assert.assertTrue(toDoMVCPage.isTaskDisplayed(taskName));

        toDoMVCPage.filterTask("Active");
        Assert.assertTrue(toDoMVCPage.isTaskDisplayed(taskName));

        toDoMVCPage.filterTask("Completed");
        Assert.assertFalse(toDoMVCPage.isTaskDisplayed(taskName));

    }

    @Test
    void verifyUserIsAbleToCheckOnComplete () {
        String taskName = "task 1";
        toDoMVCPage.filterTask("All");
        toDoMVCPage.createTask(taskName);

        int itemLeftBefore = toDoMVCPage.getItemLeft();
        toDoMVCPage.markComplete(taskName);

        int itemLeftAfter = toDoMVCPage.getItemLeft();
        Assert.assertEquals(itemLeftBefore-itemLeftAfter,1);

        toDoMVCPage.filterTask("All");
        Assert.assertTrue(toDoMVCPage.isTaskDisplayed(taskName));

        toDoMVCPage.filterTask("Completed");
        Assert.assertTrue(toDoMVCPage.isTaskDisplayed(taskName));

    }

    @Test
    void verifyUserAbleDeleteTask() {
        String taskName = "task 1";
        toDoMVCPage.filterTask("All");
        toDoMVCPage.createTask(taskName);

        int itemLeftBefore = toDoMVCPage.getItemLeft();
        toDoMVCPage.markComplete(taskName);

        toDoMVCPage.deleteComplete(taskName);

        int itemLeftAfter = toDoMVCPage.getItemLeft();
        Assert.assertEquals(itemLeftBefore-itemLeftAfter,1);
    }

    @Test
    void verifyUserAbleToChangeTaskName () {
        String taskName = "task 1";
        toDoMVCPage.filterTask("All");
        toDoMVCPage.createTask(taskName);
        int itemLeftBefore = toDoMVCPage.getItemLeft();

        Assert.assertTrue(toDoMVCPage.isTaskDisplayed(taskName));

        toDoMVCPage.updateTaskName(taskName,"task 2");
        Assert.assertTrue(toDoMVCPage.isTaskDisplayed("task 2"));

        int itemLeftAfter = toDoMVCPage.getItemLeft();
        Assert.assertEquals(itemLeftBefore,itemLeftAfter);
    }

    @AfterClass
    void tearDown() {
        Browser.closeBrowser();
    }
}
