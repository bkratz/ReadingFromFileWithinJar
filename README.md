# Reading from file within JAR file

This project is to showcase the the topic of my blogpost.

The project has two modules (SpringBootApplications)
- CrashingApp
- SuccessApp
 
### Build
```shell
mvn clean verify
```
Should run successfully

### Start apps from Start Configuration within IntelliJ
Should start successfully for both applications

### Start apps from command line
```shell
java -jar <path_to_application_jar_file>
```

This should start the `SuccessApp` successfully.
This should crash for `CrashingApp` with an `BeanCrationException` caused by a `FileNotFoundException`.


