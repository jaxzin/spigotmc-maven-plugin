// Check build.log for "INFO]: Done"
File buildLog = new File( basedir, "build.log" );
if(!buildLog.isFile()) {
    throw new FileNotFoundException( "Could not find build.log: " + buildLog );
}

isServerStarted = false
buildLog.eachLine { line ->
    if((matcher = line =~ /INFO]: Done/)) {
        isServerStarted = true
    }
}

if(!isServerStarted) {
    throw new AssertionError("The SpigotMC server did not start. Check the log for details.")
}