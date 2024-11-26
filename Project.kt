import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.nodeJS
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2024.03"

project {
    
    name = "Hello World Node.js Project"

    
    buildType(Build)
}


object Build : BuildType({
    name = "Build Hello World"

    
    vcs {
        root(DslContext.settingsRoot)  // This links to the settings from GitHub
    }

    // Define the build steps (npm install and npm run test)
    steps {
        nodeJS {
            id = "nodejs_runner"
            name = "Install Dependencies"
            shellScript = "npm install"
        }
        nodeJS {
            id = "nodejs_runner_1"
            name = "Run Tests"
            shellScript = "npm run test"
        }
    }

    // Define triggers (build automatically when there's a commit in the Git repo)
    triggers {
        vcs {
            // This will trigger the build on VCS changes (GitHub commits)
        }
    }

    
    features {
        perfmon {
            
        }
    }
})
