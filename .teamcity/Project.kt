import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.v2019_2.*

version = "2024.1"

project {
    name = "Minimal Project"

    buildType(MinimalBuild)
}

object MinimalBuild : BuildType({
    name = "Minimal Build"

    steps {
        script {
            name = "Print Hello"
            scriptContent = "echo 'Hello World'"
        }
    }
})

