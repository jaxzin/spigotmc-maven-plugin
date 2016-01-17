package com.jaxzin.spigotmc.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;
import java.io.PrintWriter;

import static java.lang.Thread.sleep;

/**
 *  <p>
 *  This goal is similar to the spigotmc:run goal, EXCEPT that it is designed to be bound to an execution inside your pom, rather
 *  than being run from the command line.
 *  </p>
 *  <p>
 *  When using it, be careful to ensure that you bind it to a phase in which all necessary generated files and classes for the bukkit plugin
 *  will have been created. If you run it from the command line, then also ensure that all necessary generated files and classes for
 *  the bukkit plugin already exist.
 *  </p>
 *
 */
@Mojo(
    name = "start",
    defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST,
    requiresDependencyResolution = ResolutionScope.TEST,
    executionStrategy = "phase='validate'"
)
public class SpigotStartMojo extends AbstractMojo {

    static protected Process spigotProcess;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Starting Spigot...");
        try {
            // Create the working dir for spigot to run
            File spigotWorkingDir = new File("target/it/spigotmc");
            spigotWorkingDir.mkdirs();

            // Accept the EULA so Spigot will run
            File eulaFile = new File(spigotWorkingDir, "eula.txt");
            PrintWriter out = new PrintWriter(eulaFile);
            out.println("eula=true");
            out.close();

            // TODO: Get the spigot jar in a less fragile way (ex. copy into local dir with dependency plugin)
            String[] args = {"/bin/bash", "-c", "java -jar ~/.m2/repository/org/spigotmc/spigot/1.8.8/spigot-1.8.8.jar"};
            spigotProcess =
                new ProcessBuilder(args)
                        .directory(spigotWorkingDir)
                        .redirectErrorStream(true)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start();
            // TODO: A better waitFor condition, rather than waiting 15 seconds. Watch output for "Done"
            sleep(15000);
        } catch (Throwable t) {
            throw new MojoFailureException("Unable to start Spigot server.", t);
        }
    }

}
