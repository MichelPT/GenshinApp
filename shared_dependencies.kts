dependencies {
    implementation("androidx.compose.runtime:runtime:1.6.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.2")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.6.2")

    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")

    testImplementation("org.mockito:mockito-core:4.4.0")
    testImplementation("org.mockito:mockito-inline:4.4.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    androidTestImplementation("androidx.room:room-testing:2.6.1")

    implementation("io.insert-koin:koin-core:3.6.0-wasm-alpha2")
    implementation("io.insert-koin:koin-android:3.6.0-wasm-alpha2")
    implementation("io.insert-koin:koin-androidx-compose:3.6.0-wasm-alpha2")
    testImplementation("io.insert-koin:koin-test:3.6.0-wasm-alpha2")
    testImplementation("io.insert-koin:koin-test-junit4:3.6.0-wasm-alpha2")
}