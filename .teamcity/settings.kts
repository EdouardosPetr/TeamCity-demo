import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.v2020_2.*

version = "2024.1"

project {
    name = "Hello World Project"

    vcsRoot(DslContext.settingsRoot)  // Link to the VCS

    buildType(BuildHelloWorld)
}

object BuildHelloWorld : BuildType({
    name = "Build Hello World"

    steps {
        script {
            name = "Check Node Version"
            scriptContent = "node -v"  // Verifies Node.js is installed
        }
        script {
            name = "Run Hello World"
            scriptContent = "node index.js"
        }
    }

    triggers {
        vcs {
            // Trigger builds on changes
        }
    }
})
