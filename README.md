## Summary
This repo is meant to act as a demo for the functionality and usability of the [BuzzFuzz Engine](https://github.com/johnnyrockett/JavaFuzzer). In it are two example functions that test the GSON library. BuzzFuzz will create random inputs to these functions and test their outcome.

## Expected Output
BuzzFuzz is used as a maven plugin that is used during the testing lifecycle. BuzzFuzz will find the methods annotated with ` @Fuzz ` and generate random inputs for them until 500 successful runs are completed.

In this demo, BuzzFuzz finds IllegalArgumentExceptions for serializing both List and Tree inputs using the GSON library. For Trees, it also finds a IllegalStateException caused by GSON not being able to handle recursive object trees.

A successful run of the demo should look like this:

```
[INFO] --- buzz-maven-plugin:0.0.1-SNAPSHOT:test (default) @ demo ---
-------------------------------------------------------
 F U Z Z  T E S T S
-------------------------------------------------------
Fuzzing Method listTest
Valid runs: 500, Crashes: 503, Time elapsed: 206 ms

Exceptions found:
    IllegalArgumentException

Fuzzing Method treeTest
Valid runs: 500, Crashes: 550, Time elapsed: 378 ms

Exceptions found:
    IllegalStateException
    IllegalArgumentException
```
You can view individual logs, stacktraces, and configurations used of fuzz tests in the target/buzz-reports/ directory. The hierarchy should look something like this:

```
buzz-reports
└───IllegalArgumentException
│   └───Gson.checkValidFloatingPoint()/299
│       │   stacktrace.txt
│       └───corpus
│           └───configHash1
│           │   │   config.xml
│           │   │   log.txt
│           └───configHash2
│               │   config.xml
│               │   log.txt
│
└───IllegalStateException
    └───JsonReader.beginObject()/387
        │   stacktrace.txt
        └───corpus
            └───configHash1
            │   │   config.xml
            │   │   log.txt
            └───configHash2
                │   config.xml
                │   log.txt
```
