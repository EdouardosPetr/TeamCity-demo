import jetbrains.buildServer.configs.kotlin.v2019_2.*

// TeamCity configuration version (match your TeamCity server version)
version = "2024.1"

// Define the project
project {
    name = "Hello World Project"

    // Add build configurations
    buildType(HelloWorldBuild)
}

// Define the build configuration
object HelloWorldBuild : BuildType({
    name = "Build Hello World"

    // Add build steps
    steps {
        script {
            name = "Run Hello World"
            scriptContent = "node index.js"
        }
    }

    // Add triggers for automatic builds
    triggers {
        vcs {
            // Trigger builds on code changes
        }
    }

    // Version control settings
    vcs {
        root(DslContext.settingsRoot)
    }
})
