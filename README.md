# cometchat-calling-flutter-plugin

================

## Usage ##

To use this library in your code:

* add a dependency in your `pubspec.yaml` :

  ```yaml
  dependencies:
    flutter_sample_plugin: ^0.0.1
  ```

* add gradle dependencies in your `build.gradle (project level)` code:

  ```
  allprojects {
    repositories {
        maven {
            url "https://dl.cloudsmith.io/public/cometchat/cometchat-pro-android/maven/"
        } // Add this
    }
  }

  ```
* add gradle dependencies in your `build.gradle (app level)` code:

  ```
  implementation 'com.cometchat:pro-android-calls-sdk:2.2.0' // Add this
    
  ```

## Examples ##

Examples found at https://pub.dev/packages/flutter_sample_plugin/example are available in a `dart` version at https://pub.dev/packages/flutter_sample_plugin/ in the example directory.

## License ##

MIT
