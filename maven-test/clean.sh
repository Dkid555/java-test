#!/bin/bash

echo "clean ..."
# rm maven-test-api
rm -rf maven-test-api/src/

# rm maven-test-api-test
rm -rf maven-test-api-test/src/main/
rm -rf maven-test-api-test/src/test/java/
rm -rf maven-test-api-test/src/test/resources/testng.xml
rm -rf maven-test-api-test/src/test/data/

# rm maven-test-base
rm -rf maven-test-base/src/

# rm maven-test-api
rm -rf maven-test-api/src/

# rm maven-test-bundle
rm -rf maven-test-bundle/src/

# rm maven-test-bundle-mock
rm -rf maven-test-bundle-mock/src/

mvn clean
echo "clean done."