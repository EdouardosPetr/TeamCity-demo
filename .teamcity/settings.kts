import jetbrains.buildServer.configs.kotlin.v2024_1.*

version = "2024.1"

project {
    name = "Hello World Project"

    // Link the VCS root (GitHub repository)
    vcsRoot(DslContext.settingsRoot)

    // Register the build configuration
    buildType(BuildHelloWorld)
}

