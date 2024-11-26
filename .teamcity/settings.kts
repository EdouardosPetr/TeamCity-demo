import jetbrains.buildServer.configs.kotlin.*

version = "2024.03"

project {

    // Define a simple build type
    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)  // Use the root VCS defined for the project
    }

    steps {
        script {
            name = "Simple Script"
            scriptContent = "echo 'Hello, TeamCity!'"  // Just a simple echo command for debugging
        }
    }
})
