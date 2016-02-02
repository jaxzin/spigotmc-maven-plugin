// Check build.log for "Preparing spawn area"
File buildLog = new File( basedir, "build.log" );
if(!buildLog.isFile()) {
    throw new FileNotFoundException( "Could not find build.log: " + buildLog );
}

isServerStarted = false
buildLog.eachLine { line ->
    if((matcher = line =~ /Preparing spawn area/)) {
        isServerStarted = true
    }
}

if(!isServerStarted) {
    throw new AssertionError("The SpigotMC server did not start. Check the log for details.")
}