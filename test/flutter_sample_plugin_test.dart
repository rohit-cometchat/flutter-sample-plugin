import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_sample_plugin/flutter_sample_plugin.dart';
import 'package:flutter_sample_plugin/flutter_sample_plugin_platform_interface.dart';
import 'package:flutter_sample_plugin/flutter_sample_plugin_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockFlutterSamplePluginPlatform 
    with MockPlatformInterfaceMixin
    implements FlutterSamplePluginPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final FlutterSamplePluginPlatform initialPlatform = FlutterSamplePluginPlatform.instance;

  test('$MethodChannelFlutterSamplePlugin is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelFlutterSamplePlugin>());
  });

  test('getPlatformVersion', () async {
    FlutterSamplePlugin flutterSamplePlugin = FlutterSamplePlugin();
    MockFlutterSamplePluginPlatform fakePlatform = MockFlutterSamplePluginPlatform();
    FlutterSamplePluginPlatform.instance = fakePlatform;
  
    expect(await flutterSamplePlugin.getPlatformVersion(), '42');
  });
}
