1.Setup Locally 
======================
Set environment variable:

```SERVICING_CONF_DIR=<your local configuration>```

Change *com.h2database* dependency scope from **test** to **provided**

2.Change default profile
======================
If you want to access the [h2 console](http://localhost:9090/servicing-web/h2-console) and [swagger UI](http://localhost:9090/servicing-web/swagger-ui.html), you need to change application profile to **dev**.

Option 1: Java System Properties (VM Arguments)
----------------------------------------------

It's important that the *-D* parameters are before your application.jar otherwise they are not recognized.

```java -jar -Dspring.profiles.active=dev application.jar```

Option 2: Program arguments
---------------------------

```java -jar application.jar --spring.profiles.active=dev --spring.config.location=c:\config```

Option 3: Environment variable
-------------------------------


```JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=dev"```

Option 4: For Tomcat 8
----------------------


**Linux :**

Create *setenv.sh* and update it with following:
```export SPRING_PROFILES_ACTIVE=dev```

**Windows:**

Create *setenv.bat* and update it with following:
```set SPRING_PROFILES_ACTIVE=dev```
