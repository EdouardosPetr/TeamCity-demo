import jetbrains.buildServer.configs.kotlin.v2019_2.*

version = "2024.1"

project {
    name = "Hello World Project"

    buildType(HelloWorldBuild)
}

object HelloWorldBuild : BuildType({
    name = "Build Hello World"

    steps {
        script {
            name = "Run Hello World"
            scriptContent = "node index.js"
        }
    }

    triggers {
        vcs {}
    }

    vcs {
        root(DslContext.settingsRoot)
    }
})

