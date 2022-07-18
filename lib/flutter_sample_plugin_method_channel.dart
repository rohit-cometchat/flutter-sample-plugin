import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter/services.dart';

import 'call_settings_builder.dart';
import 'flutter_sample_plugin_platform_interface.dart';

/// An implementation of [FlutterSamplePluginPlatform] that uses method channels.
class MethodChannelFlutterSamplePlugin extends FlutterSamplePluginPlatform {
  
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('flutter_sample_plugin');
  
  /*for native relative layout view*/
  @override
  Future<Widget?> getCometChatCallingView(CometChatRTCViewBuilder cometChatRTCViewBuilder) async{
    final initResult = await initCometChatCalling(cometChatRTCViewBuilder);
    if(initResult){
      return const AndroidView(
          viewType: "viewCometChatCalling"
      );
    }else{
      return Container();
    }
  }

  @override
  Future<bool> initCometChatCalling(CometChatRTCViewBuilder cometChatRTCViewBuilder) async {
    final result = await methodChannel.invokeMethod<bool>(
        'initCometChatCalling', 
        {
          "appID" : cometChatRTCViewBuilder.appID,
          "domain" : cometChatRTCViewBuilder.domain,
          "rtcUserUID" : cometChatRTCViewBuilder.rtcUser.uid,
          "rtcUserName" : cometChatRTCViewBuilder.rtcUser.name,
          "rtcUserAvatar" : cometChatRTCViewBuilder.rtcUser.avatar,
          "rtcUserJWT" : cometChatRTCViewBuilder.rtcUser.jwt,
          "rtcUserResource" : cometChatRTCViewBuilder.rtcUser.resource,
          "isInitiator" : cometChatRTCViewBuilder.isInitiator,
          "analyticsSettingsHost" : cometChatRTCViewBuilder.analyticsSettings.analyticsHost,
          "analyticsSettingsVersion" : cometChatRTCViewBuilder.analyticsSettings.analyticsVersion,
          "analyticsSettingsPingDisabled" : cometChatRTCViewBuilder.analyticsSettings.analyticsPingDisabled,
          "analyticsSettingsUseSSL" : cometChatRTCViewBuilder.analyticsSettings.analyticsUseSSL,
          "defaultLayout" : cometChatRTCViewBuilder.defaultLayout,
          "audioOnly" : cometChatRTCViewBuilder.audioOnly,
          "sessionId" : cometChatRTCViewBuilder.sessionId,
          "region" : cometChatRTCViewBuilder.region,
          "mode" : cometChatRTCViewBuilder.mode,
          "showEndCallButton" : cometChatRTCViewBuilder.showEndCallButton,
          "showSwitchCameraButton" : cometChatRTCViewBuilder.showSwitchCameraButton,
          "showMuteAudioButton" : cometChatRTCViewBuilder.showMuteAudioButton,
          "showPauseVideoButton" : cometChatRTCViewBuilder.showPauseVideoButton,
          "showAudioModeButton" : cometChatRTCViewBuilder.showAudioModeButton,
          "startCallWithAudioMuted" : cometChatRTCViewBuilder.startCallWithAudioMuted,
          "startCallWithVideoMuted" : cometChatRTCViewBuilder.startCallWithVideoMuted,
          "audioMode" : cometChatRTCViewBuilder.audioMode,
          "switchToVideoCallButton" : cometChatRTCViewBuilder.switchToVideoCallButton,
          "recordingButton" : cometChatRTCViewBuilder.recordingButton,
          "startRecording" : cometChatRTCViewBuilder.startRecording,
          "avatarMode" : cometChatRTCViewBuilder.avatarMode,
          "height" : cometChatRTCViewBuilder.height,
          "width" : cometChatRTCViewBuilder.width
        }
    );
    return result ?? false;
  }

}
