package com.tvn.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import static com.tvn.common.Browser.captureScreenShot;

public class TestBase {
    @AfterMethod(alwaysRun = true)
    protected void tearDown(ITestResult testResult){
        String tcName=testResult.getMethod().getMethodName();
        if(!testResult.isSuccess()){
            captureScreenShot(tcName);
        }
    }
}