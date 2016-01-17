package com.jaxzin.spigotmc.maven;

import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.bukkit.craftbukkit.Main;

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
                Main.main(new String[]{});
        }
}
