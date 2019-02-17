
#!/bin/bash
cd buzztools
mvn install
cd ../JavaFuzzer
mvn install
cd ..
mvn test