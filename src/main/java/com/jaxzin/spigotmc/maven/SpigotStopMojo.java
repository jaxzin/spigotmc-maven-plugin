package com.jaxzin.spigotmc.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.bukkit.Bukkit;

/**
 * SpigotStopMojo - stops a running instance of spigot.
 */
@Mojo( name = "stop" )
public class SpigotStopMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Shutting down Spigot...");
        Bukkit.shutdown();
        getLog().info("Shut down Spigot.");
    }
}
