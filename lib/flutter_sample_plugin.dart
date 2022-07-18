import 'package:flutter/widgets.dart';
import 'package:flutter_sample_plugin/call_settings_builder.dart';
import 'flutter_sample_plugin_platform_interface.dart';

class FlutterSamplePlugin {
  Future<String?> getPlatformVersion() {
    return FlutterSamplePluginPlatform.instance.getPlatformVersion();
  }

  Future<Widget?> getNativeTextView(String? color) {
    return FlutterSamplePluginPlatform.instance.getNativeTextView(color);
  }

  Future<Widget?> getCometChatCallingView(CometChatRTCViewBuilder cometChatRTCViewBuilder) {
    return FlutterSamplePluginPlatform.instance.getCometChatCallingView(cometChatRTCViewBuilder);
  }

}
