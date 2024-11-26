import jetbrains.buildServer.configs.kotlin.v2024_1.*

object BuildHelloWorld : BuildType({
    name = "Build Hello World"

    // Define the VCS root
    vcs {
        root(DslContext.settingsRoot)  // Bind to the VCS defined in settings.kts
    }

    // Define the build steps
    steps {
        script {
            name = "Check Node Version"
            scriptContent = "node -v"  // Verifies that Node.js is installed
        }
        script {
            name = "Run Hello World"
            scriptContent = "node index.js" // Runs the Hello World script
        }
    }

    // Define triggers
    triggers {
        vcs {  // Automatically trigger builds on VCS changes
        }
    }
})

