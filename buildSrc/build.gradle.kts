import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// compile bytecode to java 8 (default is java 6)
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

plugins{
    `kotlin-dsl`
}
repositories {
    jcenter()
}