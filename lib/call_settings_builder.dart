import 'package:flutter_sample_plugin/analytics_settings.dart';
import 'package:flutter_sample_plugin/rtc_user.dart';

class CometChatRTCViewBuilder {
  late String appID;
  late String domain;
  late RTCUser rtcUser;
  late bool isInitiator;
  late AnalyticsSettings analyticsSettings;
  bool defaultLayout = true;
  bool audioOnly = false;
  String sessionId = "DEFAULT";
  String region = "DEFAULT";
  String mode = "DEFAULT";
  bool showEndCallButton = true;
  bool showSwitchCameraButton = true;
  bool showMuteAudioButton = true;
  bool showPauseVideoButton = true;
  bool showAudioModeButton = true;
  bool startCallWithAudioMuted = false;
  bool startCallWithVideoMuted = false;
  String audioMode = "SPEAKER";
  bool switchToVideoCallButton = true;
  bool recordingButton = false;
  bool startRecording = false;
  String avatarMode = "circle";
  int height = 0;
  int width = 0;

  CometChatRTCViewBuilder setSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  CometChatRTCViewBuilder setAppId(String appID) {
    this.appID = appID;
    return this;
  }

  CometChatRTCViewBuilder setRegion(String region) {
    this.region = region;
    return this;
  }

  CometChatRTCViewBuilder setDomain(String domain) {
    this.domain = domain;
    return this;
  }

  CometChatRTCViewBuilder setRTCUser(RTCUser rtcUser) {
    this.rtcUser = rtcUser;
    return this;
  }

  CometChatRTCViewBuilder setIsInitiator(bool isInitiator) {
    this.isInitiator = isInitiator;
    return this;
  }

  CometChatRTCViewBuilder setDefaultLayoutEnable(bool defaultLayout) {
    this.defaultLayout = defaultLayout;
    return this;
  }

  CometChatRTCViewBuilder setIsAudioOnly(bool audioOnly) {
    this.audioOnly = audioOnly;
    return this;
  }

  CometChatRTCViewBuilder setMode(String mode) {
    this.mode = mode;
    return this;
  }

  CometChatRTCViewBuilder setDefaultAudioMode(String audioMode) {
    this.audioMode = audioMode;
    return this;
  }

  CometChatRTCViewBuilder setEndCallButtonDisable(bool showEndCallButton) {
    this.showEndCallButton = showEndCallButton;
    return this;
  }

  CometChatRTCViewBuilder startWithAudioMuted(bool startCallWithAudioMuted) {
    this.startCallWithAudioMuted = startCallWithAudioMuted;
    return this;
  }

  CometChatRTCViewBuilder startWithVideoMuted(bool startCallWithVideoMuted) {
    this.startCallWithVideoMuted = startCallWithVideoMuted;
    return this;
  }

  CometChatRTCViewBuilder showRecordingButton(bool recordingButton) {
    this.recordingButton = recordingButton;
    return this;
  }

  CometChatRTCViewBuilder startRecordingOnCallStart(bool startRecording) {
    this.startRecording = startRecording;
    return this;
  }

  CometChatRTCViewBuilder showSwitchToVideoCallButton(
      bool switchToVideoCallButton) {
    this.switchToVideoCallButton = switchToVideoCallButton;
    return this;
  }

  CometChatRTCViewBuilder setAvatarMode(String avatarMode) {
    this.avatarMode = avatarMode;
    return this;
  }

  CometChatRTCViewBuilder setAnalyticsSettings(AnalyticsSettings analyticsSettings) {
    this.analyticsSettings = analyticsSettings;
    return this;
  }

  CometChatRTCViewBuilder setWidth(int width) {
    this.width = width;
    return this;
  }

  CometChatRTCViewBuilder setHeight(int height) {
    this.height = height;
    return this;
  }
}
