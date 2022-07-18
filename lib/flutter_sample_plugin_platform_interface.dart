import 'package:flutter/widgets.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'call_settings_builder.dart';
import 'flutter_sample_plugin_method_channel.dart';

abstract class FlutterSamplePluginPlatform extends PlatformInterface {
  /// Constructs a FlutterSamplePluginPlatform.
  FlutterSamplePluginPlatform() : super(token: _token);

  static final Object _token = Object();

  static FlutterSamplePluginPlatform _instance = MethodChannelFlutterSamplePlugin();

  /// The default instance of [FlutterSamplePluginPlatform] to use.
  ///
  /// Defaults to [MethodChannelFlutterSamplePlugin].
  static FlutterSamplePluginPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [FlutterSamplePluginPlatform] when
  /// they register themselves.
  static set instance(FlutterSamplePluginPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }

  Future<Widget?> getNativeTextView(String? textColor) async{
    throw UnimplementedError('nativeTextView has not been implemented.');
  }
  @override
  Future<bool> initAndroidTextProperties(String? textColor) async {
    throw UnimplementedError('initAndroidTextProperties has not been implemented.');
  }

  Future<Widget?> getCometChatCallingView(CometChatRTCViewBuilder cometChatRTCViewBuilder) async{
    throw UnimplementedError('nativeTextView has not been implemented.');
  }

  @override
  Future<bool> initCometChatCalling(CometChatRTCViewBuilder cometChatRTCViewBuilder) async {
    throw UnimplementedError('initCometChatCalling has not been implemented.');
  }

}
