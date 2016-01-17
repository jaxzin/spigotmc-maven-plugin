package com.jaxzin.spigotmc.maven;

import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.bukkit.craftbukkit.Main;
import org.bukkit.craftbukkit.libs.joptsimple.OptionException;
import org.bukkit.craftbukkit.libs.joptsimple.OptionParser;
import org.bukkit.craftbukkit.libs.joptsimple.OptionSet;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 *  <p>
 *  This goal is similar to the spigot:run goal, EXCEPT that it is designed to be bound to an execution inside your pom, rather
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
    requiresDependencyResolution = ResolutionScope.TEST,
    executionStrategy = "phase='validate'"
)
public class SpigotStartMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Starting Spigot...");
        try {
//            Main.main(new String[]{});
            // TODO: Get the spigot jar in a less fragile way (ex. copy into local dir with dependency plugin)
            String[] args = {"/bin/bash", "-c", "java -jar ~/.m2/repository/org/spigotmc/spigot/1.8.8/spigot-1.8.8.jar"};
            Process process =
                new ProcessBuilder(args)
                    .redirectErrorStream(true)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start();
            process.waitFor();
        } catch (Throwable t) {
            throw new MojoFailureException("Unable to start Spigot server.", t);
        }
    }

}
