call mvn clean
echo "mvn clean finished and install started"
call mvn  install
echo "mvn install finished and compile started"
call mvn compile
echo "mvn compile finished and program will start"
mvn exec:java -Dexec.mainClass=com.hexad.HexadMain -Dexec.args="file_inputs.txt"