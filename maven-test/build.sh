#!/bin/bash

echo "build ..."
if [ "local_bundle_mock" = $1 ] ; then
    mvn clean package -pl maven-test-bundle-mock -am -Dbdmgc.skip=false -Dcodeg.author=fastjrun
elif [ "provider_mock" = $1 ] ; then
    mvn clean package -pl maven-test-provider-mock -am -Dbdmgc.skip=false -Dcodeg.author=fastjrun
    cp maven-test-provider-mock/target/maven-test-provider-mock.war ~/server/tomcat8/webapps/maven-test-provider-mock.war
elif [ "package_api_test" = $1 ] ; then
    mvn clean package -pl maven-test-api-test -am -Dclientgc.skip=false -Dcodeg.author=fastjrun
elif [ "unitTest" = $1 ] ; then
    mvn clean verify -pl maven-test-test -PunitTest -am
elif [ "mock_test" = $1 ] ; then
    mvn clean package -pl maven-test-api-test -Dclientgc.skip=false -Dcodeg.author=fastjrun -Pmock
elif [ "package_provider" = $1 ] ; then
    mvn clean package -pl maven-test-provider -am -Dbasegc.skip=false -Dbdgc.skip=false -Dcodeg.author=fastjrun -P$2
    cp maven-test-provider/target/maven-test-provider.war ~/server/tomcat8/webapps/maven-test-provider.war
elif [ "api_test" = $1 ] ; then
    mvn clean package -pl maven-test-api-test -Dclientgc.skip=false -Dcodeg.author=fastjrun -P$2
elif [ "package_task" = $1 ] ; then
    mvn clean package -pl maven-test-task -am -Dbasegc.skip=false -Dbdgc.skip=false -Dcodeg.author=fastjrun -P$2
    rm -rf ~/app/maven-test/maven-test-task
    cp -r maven-test-task/target/maven-test-task/maven-test-task ~/app/maven-test/maven-test-task
elif [ "package_ci" = $1 ] ; then
    mvn clean package -pl maven-test-base -am -Dbasegc.skip=false -Dcodeg.author=fastjrun
    mvn clean package -pl maven-test-bundle -am -Dbdgc.skip=false -Dcodeg.author=fastjrun
    mvn clean package -pl maven-test-api-test -am -Dclientgc.skip=false -Dcodeg.author=fastjrun -Dmaven.test.skip=true
    mvn clean package -pl maven-test-bundle-mock -am -Dbdmgc.skip=false -Dcodeg.author=fastjrun
    mvn clean package -pl maven-test-api -am -Dapigc.skip=false -Dcodeg.author=fastjrun
elif [ "service_ut" = $1 ] ; then
    mvn clean package -pl maven-test-test -am -Dbasegc.skip=false -Dbdgc.skip=false -Dcodeg.author=fastjrun -P$2
fi
echo "build done."