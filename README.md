# TODO MVC Project

## Setup
- [ ] setup JDK-21
- [ ] setup maven
- [ ] open project with intelliJ
- [ ] install chorme browser
- [ ] install firefox browser
## How to run
```shell
$ mvn clean test
```
## How to write
### project structure
- base
  - [TestBase.java](src%2Ftest%2Fjava%2Fcom%2Ftvn%2Fbase%2FTestBase.java)
- common
  - [Browser.java](src%2Ftest%2Fjava%2Fcom%2Ftvn%2Fcommon%2FBrowser.java)
- pages
  - [ToDoMVCPage.java](src%2Ftest%2Fjava%2Fcom%2Ftvn%2Fpages%2FToDoMVCPage.java)
- testcases
  - [ToDoMVCTest.java](src%2Ftest%2Fjava%2Fcom%2Ftvn%2Ftestcases%2FToDoMVCTest.java)
### test plan
- [todomvc-testplan.xml](todomvc-testplan.xml)