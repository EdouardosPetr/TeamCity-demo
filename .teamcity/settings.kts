import jetbrains.buildServer.configs.kotlin.v2024_1.*

version = "2024.1"

project {
    name = "Hello World Project"

    vcsRoot(DslContext.settingsRoot)  // Reference the VCS root

    buildType(BuildHelloWorld)        // Reference the build configuration
}
