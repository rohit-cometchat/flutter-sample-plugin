import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter_sample_plugin/analytics_settings.dart';
import 'package:flutter_sample_plugin/call_settings_builder.dart';
import 'package:flutter_sample_plugin/rtc_user.dart';
import 'package:flutter_sample_plugin/flutter_sample_plugin.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  Widget? _cometChatCallingView;
  final _flutterSamplePlugin = FlutterSamplePlugin();

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  Future<void> initPlatformState() async {
    Widget cometChatCallingView;

    //set the default widget
    setState(() {
      _cometChatCallingView = dummyWidgetHolder("Loading native text view...");
    });
    
    //call the native text loader
    cometChatCallingView = await initCometChatCalling();

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;
    
    setState(() {
      _cometChatCallingView = cometChatCallingView;
    });
  }

  Widget dummyWidgetHolder(String txt){
    return Text(txt);
  }
  
  Future<Widget> initCometChatCalling() async{
    AnalyticsSettings settings = AnalyticsSettings("", "");
    RTCUser rtcUser = RTCUser("userID", "userName", "avatar", "jwt", "resource");
    CometChatRTCViewBuilder cometChatRTCViewBuilder = CometChatRTCViewBuilder()
        .setSessionId("")
        .setAppId("")
        .setRegion("")
        .setDomain("")
        .setRTCUser(rtcUser)
        .setIsInitiator(true)
        .setDefaultLayoutEnable(true)
        .setIsAudioOnly(false)
        .setMode("default")
        .setDefaultAudioMode("EARPIECE")
        .setEndCallButtonDisable(false)
        .startWithAudioMuted(true)
        .startWithVideoMuted(true)
        .setAnalyticsSettings(settings)
        .showRecordingButton(false)
        .startRecordingOnCallStart(false)
        .showSwitchToVideoCallButton(true)
        .setHeight(1500)
        .setWidth(0)
        .setAvatarMode("square");

    final widgetCometChatCalling = await _flutterSamplePlugin.getCometChatCallingView(cometChatRTCViewBuilder) ?? dummyWidgetHolder("Fail to load native relative layout");
    return widgetCometChatCalling;
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        /*appBar: AppBar(
          title: const Text('Plugin example app'),
        ),*/
        body: Column(
          children: [
            Expanded(
              child: _cometChatCallingView ?? dummyWidgetHolder("Init for native call"),
            )
          ],
        )
      ),
    );
  }
}

