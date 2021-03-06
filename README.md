## Summary
This repo is meant to act as a demo for the functionality and usability of the [BuzzFuzz Engine](https://github.com/johnnyrockett/JavaFuzzer). In it are two example functions that test some small, buggy classes. BuzzFuzz will create random inputs to these functions and test their outcome.

## Running the demo
Since this repo uses the BuzzFuzz and buzztools repos as git submodules, you will need to clone the repo with the command:
```
git clone --recurse-submodules -j8 https://github.com/johnnyrockett/BuzzFuzzDemo.git
```
In order for the demo to run, the jars from these two submodules will need to be created. To do this, you must run ` mvn install ` in each of the git submodules. I have written a small script, ` run.sh ` that will do this for you as well as run the demo's tests.

## Expected Output
BuzzFuzz is used as a maven plugin that is used during the testing lifecycle. BuzzFuzz will find the methods annotated with ` @Fuzz ` and generate random inputs for them until 500 successful runs are completed.

In this demo, BuzzFuzz finds NullPointerExceptions as well as custom Exceptions within the example classes.

A successful run of the demo should look like this:

```
[INFO] --- buzz-maven-plugin:0.0.1-SNAPSHOT:test (default) @ demo ---
-------------------------------------------------------
 F U Z Z  T E S T S
-------------------------------------------------------
Fuzzing Method listTest
Valid runs: 500, Crashes: 642, Time elapsed: 602 ms

Exceptions found:
    NullPointerException

Fuzzing Method treeTest
Valid runs: 500, Crashes: 1000, Time elapsed: 1170 ms

Exceptions found:
    NullPointerException
    Exception
```
You can view individual logs, stacktraces, and configurations used of fuzz tests in the target/buzz-reports/ directory. The hierarchy should look something like this:

```
buzz-reports
└───NullPointerException
│   └───DemoTest_listTest_30
│       │   stacktrace.txt
│       └───corpus
│           └───configHash1
│           │   │   config.xml
│           │   │   log.txt
│           └───configHash2
│               │   config.xml
│               │   log.txt
│
└───Exception
    └───DemoTest_treeTest_24
        │   stacktrace.txt
        └───corpus
            └───configHash1
            │   │   config.xml
            │   │   log.txt
            └───configHash2
                │   config.xml
                │   log.txt
```
