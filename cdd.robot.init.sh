BASEDIR=$(dirname "$0")
echo Executing init script from $BASEDIR

$BASEDIR/gradlew -p $BASEDIR :build -xtest :compileRobotJava :dumpRobotFrameworkClasspath
cat $BASEDIR/build/cdd.robot.classpath.txt > $BASEDIR/cdd.robot.init.out