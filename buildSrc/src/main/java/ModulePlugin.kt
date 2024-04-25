import org.gradle.api.Plugin
import org.gradle.api.Project


open class ModulePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            setupPlugins()
            setupModule()
        }
    }

    private fun Project.setupPlugins() = plugins.apply {
        apply("com.android.library")
        apply("com.google.dagger.hilt.android")
        apply("androidx.navigation.safeargs")
        apply("kotlin-android")
        apply("kotlin-parcelize")
        apply("kotlin-kapt")
    }

    companion object {
        const val MODULE_NAME = "module-plugin"
    }
}
