# SpigotMC Maven Plugin

A Maven Plugin for running a SpigotMC server.
The main use case is integration testing Bukkit/Spigot plugins.

# Usage

## Add this plugin to your pom.xml:
```
<project>
...
    <build>
        <plugins>
            <plugin>
                <groupId>com.jaxzin.spigotmc.maven</groupId>
                <artifactId>spigotmc-maven-plugin</artifactId>
                <version>0.0.1-SNAPSHOT</version>
                <executions>
                    <execution>
                        <id>start-server</id>
                        <goals>
                            <goal>start</goal>
                            <goal>stop</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

## Write an integration test

TBD

## Run the integration test

```
mvn integration-test
```
