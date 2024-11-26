import jetbrains.buildServer.configs.kotlin.v2024_1.*

object BuildHelloWorld : BuildType({
    name = "Build Hello World"

    // Define the VCS (Version Control System) configuration
    vcs {
        root(DslContext.settingsRoot) // Links to the VCS root defined in settings.kts
    }

    // Define the build steps
    steps {
        // Step 1: Check Node.js version
        script {
            name = "Check Node Version"
            scriptContent = "node -v"  // Verifies that Node.js is installed
        }

        // Step 2: Run the Hello World app
        script {
            name = "Run Hello World"
            scriptContent = "node index.js" // Runs your Node.js application
        }
    }

    // Define triggers to automatically start builds
    triggers {
        vcs {
            // Automatically trigger builds when code changes in the repository
        }
    }
})
