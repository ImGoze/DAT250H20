#DAT250-expass2
* *Technical problems that you encountered during installation and use of Java Persistence Architecture (JPA) and how you resolved*

When downloading the Apache Derby database, I encountered some issues. Especially when trying to ```Configure Embedded Derby```. The command: ```set CLASSPATH=%DERBY_INSTALL%\lib\derby.jar;%DERBY_INSTALL%\lib\derbytools.jar;``` Gave me the error: 
>%DERBY_INSTALL%\lib\derbytools.jar : The module '%DERBY_INSTALL%' could not be loaded. 

The way I fixed this, was to manually configure the enviroment variable %DERBY_INSTALL% and %CLASSPATH% in the config-settings of my machine. Then I encountered some more issued when trying to test the *IJ-scripting tool*. When I used the java org.apache.derby.tools.ij, it wouldnt compile all files, as shown in the screenshot below: 
![](screenshots\jre.png)

Ofcoure, I then checked the ```java -version```in powershell, and I found out that I run the 1.8 version, when I should run the 14 version. I fixed this by uninstalling the other versions of java from my computer, and its now working as it should. 

Then I cloned the maven-project from this repo on github: [https://github.com/lmkr/dat250-jpa-examples/tree/master/eclipselink/jpa-basic](https://github.com/lmkr/dat250-jpa-examples/tree/master/eclipselink/jpa-basic)

Trying to run the project in IntellIJ I got a load of errors. The biggest of them all was when i cloned the project, it did'nt "import" it as maven, som I needed to manually import the project as Maven to fix the massive import-errors I got. After this, everything worked besides one thing: *the database..* The database wouldn't start. Here you can see the error: ![](screenshots\dbfeil.JPG)

 and I found out it was because I gave it a bad path in the ```persistence.xml```. I then changed the path to: 
 
```XML
 <property name="javax.persistence.jdbc.url"
           value="jdbc:derby:./persistence/testdb;create=true"/>
```
Then the final result after som iterations of running ```main.java``` looked like this: 

![](screenshots\kjøring.JPG)

***We can see the elements of the database and its corresponding size.***


* *A link to your code for experiment 1 and 2 above*

* *An explanation of how you inspected the database tables and what tables were created. For the latter you may provide screenshots.*

* *Any pending issues with this assignment which you did not manage to solve*