# Homework 1

## Виконала
Дулгер Лія

## IMPORTANT
IntelliJ Idea 2020.2.2(Community Edition), на якому виконувалась
робота, не розпізнає наступний плагін, тому в файлі pom.xml
його закоментовано.
````
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-pmd-plugin</artifactId>
                <version>3.5</version>
                <configuration>
                    <linkXref>true</linkXref>
                    <sourceEncoding>UTF8</sourceEncoding>
                    <minimumTokens>30</minimumTokens>
                    <targetJdk>1.7</targetJdk>
                </configuration>
                <executions>
                    <execution>
                        <phase>verify</phase>
                        <goals>
                            <goal>pmd</goal>
                            <goal>cpd</goal>
                        </goals>

                    </execution>
                </executions>
            </plugin>
````
Для роботи org.testng.annotations.Test використовувалась наступна 
dependency:
````
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.8</version>
            <scope>test</scope>
        </dependency>
````
В зв'язку з цими змінами при виконанні тестів, в яких очікується
помилка заголовок тесту виглядає натупним чином:
````
@Test(expectedExceptions = IllegalArgumentException.class)
````
замість:
````
@Test(expected = IllegalArgumentException.class)
````