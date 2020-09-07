#DAT250-expass2
* *Technical problems that you encountered during installation and use of Java Persistence Architecture (JPA) and how you resolved*

When downloading the Apache Derby database, I encountered some issues. Especially when trying to ```Configure Embedded Derby```. The command: ```set CLASSPATH=%DERBY_INSTALL%\lib\derby.jar;%DERBY_INSTALL%\lib\derbytools.jar;``` Gave me the error: 
>%DERBY_INSTALL%\lib\derbytools.jar : The module '%DERBY_INSTALL%' could not be loaded. 

The way I fixed this, was to manually configure the enviroment variable %DERBY_INSTALL% and %CLASSPATH% in the config-settings of my machine. Then I encountered some more issued when trying to test the *IJ-scripting tool*. When I used the java org.apache.derby.tools.ij, it would'nt compile all files, as shown in the screenshot below: 
![jre-error](images\jre.png)

Ofcoure, I then checked the ```java -version``` in powershell, and I found out that I run the 1.8 version, when I should run the 14 version. I fixed this by uninstalling the other versions of java from my computer, and its now working as it should. 

Then I cloned the maven-project from this repo on github: [https://github.com/lmkr/dat250-jpa-examples/tree/master/eclipselink/jpa-basic](https://github.com/lmkr/dat250-jpa-examples/tree/master/eclipselink/jpa-basic)

Trying to run the project in IntellIJ I got a load of errors. The biggest of them all was when i cloned the project, it did'nt "import" it as maven, som I needed to manually import the project as Maven to fix the massive import-errors I got. After this, everything worked besides one thing: *the database..* The database wouldn't start. Here you can see the error: ![](images\dbfeil.JPG)

 and I found out it was because I gave it a bad path in the ```persistence.xml```. I then changed the path to: 
 
```XML
 <property name="javax.persistence.jdbc.url"
           value="jdbc:derby:./persistence/testdb;create=true"/>
```

Also when working with the banking-example, I added some more to the ```persistence.xml```

``` XML
<persistence-unit name="Banking" transaction-type="RESOURCE_LOCAL">
        <class>banking.entities.Person</class>
        <class>banking.entities.CreditCard</class>
        <class>banking.entities.PinCode</class>
        <class>banking.entities.Address</class>
        <class>banking.entities.Bank</class>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.EmbeddedDriver" />
            <property name="javax.persistence.jdbc.url"
                      value="jdbc:derby:./persistence/bankdb;create=true"/>
            <property name="javax.persistence.jdbc.user" value="banking" />
            <property name="javax.persistence.jdbc.password" value="banking" />

            <!-- EclipseLink should create the database schema automatically -->
            <property name="eclipselink.ddl-generation" value="create-tables" />
            <property name="eclipselink.ddl-generation.output-mode" value="database" />
        </properties>
    </persistence-unit>
```

***We can see the elements of the database and its corresponding size.***


* *A link to your code for experiment 1 and 2 above*

### Experiment 1
[EXP 1: Application using JPA](https://github.com/ImGoze/DAT250H20/tree/master/expass2/dat250-jpa-code/eclipselink/jpa-basic/src/main/java/no/hvl/dat250/jpa/basicexample)

The final results after some iterations of running ```main.java``` looked like this: 

![](images\kjøring.JPG)

### Experiment 2 
[EXP 2: Banking example JPA](https://github.com/ImGoze/DAT250H20/tree/master/expass2/dat250-jpa-code/eclipselink/jpa-basic/src/main/java/banking)

Diagram for the entities in the banking-example
![](images\diagram.png)

Running ```banking.java``` a few times, outputs this: 

```
Person(name = 'Andrè', creditCard = CreditCard(number = 4, limit = 0, balance=250000, bank=Bank(name = 'Sparebank >1'), pinCode=****), address = Address(street = Lille Damsgårdsveien', Number = 10))

Person(name = 'Andrè', creditCard = CreditCard(number = 54, limit = 0, balance=250000, bank=Bank(name = 'Sparebank 1'), pinCode=****), address = Address(street = Lille Damsgårdsveien', Number = 10))

Person(name = 'Andrè', creditCard = CreditCard(number = 104, limit = 0, balance=250000, bank=Bank(name = 'Sparebank 1'), pinCode=****), address = Address(street = Lille Damsgårdsveien', Number = 10))

Person(name = 'Andrè', creditCard = CreditCard(number = 154, limit = 0, balance=250000, bank=Bank(name = 'Sparebank 1'), pinCode=****), address = Address(street = Lille Damsgårdsveien', Number = 10))

Person(name = 'Andrè', creditCard = CreditCard(number = 204, limit = 0, balance=250000, bank=Bank(name = 'Sparebank 1'), pinCode=****), address = Address(street = Lille Damsgårdsveien', Number = 10))
Size: 5
```


* *An explanation of how you inspected the database tables and what tables were created. For the latter you may provide screenshots.*

When first trying to peek the banking database, I got this error: 
>ERROR XSLAN: Database at C:\Users\andre\Google Drive\Skole\7. Semester\DAT250\Repo\expass2\dat250-jpa-code\eclipselink\jpa-basic\persistence\bankdb has an incompatible format with the current version of the software.  The database was created by or upgraded by version 10.15.

And it may have something with that I am trying to run derby 10.15.2.0, when IntellIJ only supports 14 or something like that. So I had to manually do it from terminal using ij-tools. And using simple SQL to show tables, and all from one table. It looked like this: 

![](images\dbbanking.JPG)

Here we see the entities' corresponding tables. I also peeked the ```banking.person``` whick looks like this: 

![](images\banking.person.JPG)

* *Any pending issues with this assignment which you did not manage to solve*

The only unsolved problem I have is trying to inspect the database in IntellIJ, which do not work because IntellIJ supports the 14-version and im using 10.15.2.0. 