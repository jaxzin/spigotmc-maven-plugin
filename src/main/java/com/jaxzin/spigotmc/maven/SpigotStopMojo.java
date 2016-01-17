package com.jaxzin.spigotmc.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * SpigotStopMojo - stops a running instance of spigot.
 */
@Mojo(
    name = "stop",
    defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST
)
public class SpigotStopMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Shutting down Spigot...");
        SpigotStartMojo.spigotProcess.destroy();
        try {
            SpigotStartMojo.spigotProcess.waitFor();
        } catch (InterruptedException e) {
            throw new MojoFailureException("Interrupted while waiting for Spigot to stop.", e);
        }
        SpigotStartMojo.spigotProcess = null;
        getLog().info("Shut down Spigot.");
    }
}
