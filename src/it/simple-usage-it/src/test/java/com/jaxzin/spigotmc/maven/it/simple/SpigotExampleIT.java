package com.jaxzin.spigotmc.maven.it.simple;

import org.testng.annotations.Test;

public class SpigotExampleIT {

    @Test
    public void shouldWaitOSeconds() throws InterruptedException {
        Thread.sleep(1000);
    }
}