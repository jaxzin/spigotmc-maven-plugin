// Check build.log for "BUILD SUCCESS"
File buildLog = new File( basedir, "build.log" );
if(!buildLog.isFile()) {
    throw new FileNotFoundException( "Could not find build.log: " + buildLog );
}

isServerStarted = false
buildLog.eachLine { line ->
    if((matcher = line =~ /BUILD SUCCESS/)) {
        isServerStarted = true
    }
}

if(!isServerStarted) {
    throw new AssertionError("The SpigotMC plugin build was not successful. Check the log for details.")
}