import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.v2020_2.*

version = "2024.1"

project {
    name = "Hello World Project"

    buildType(BuildHelloWorld)
}

object BuildHelloWorld : BuildType({
    name = "Build Hello World"

    vcs {
        root(DslContext.settingsRoot) // This binds the VCS root to the GitHub repo
    }

    steps {
        script {
            name = "Run Hello World"
            scriptContent = "node index.js" // This runs the 'Hello World' app
        }
    }

    triggers {
        vcs {
            // This trigger will automatically build the project on code changes.
        }
    }
})
