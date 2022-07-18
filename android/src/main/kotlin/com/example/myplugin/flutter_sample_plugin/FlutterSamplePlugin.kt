package com.example.myplugin.flutter_sample_plugin

import android.util.Log
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result


/** FlutterSamplePlugin */
class FlutterSamplePlugin: FlutterPlugin, MethodCallHandler {
  private val TAG = "FlutterSamplePlugin"
  private lateinit var channel : MethodChannel
  private lateinit var mFlutterPluginBinding : FlutterPlugin.FlutterPluginBinding

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter_sample_plugin")
    channel.setMethodCallHandler(this)
    mFlutterPluginBinding = flutterPluginBinding
  }

  override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
    when (call.method) {
      "initCometChatCalling" -> {
        try {
          val appID = call.argument<String>("appID") ?: ""
          val domain = call.argument<String>("domain") ?: ""
          val rtcUserUID = call.argument<String>("rtcUserUID") ?: ""
          val rtcUserName = call.argument<String>("rtcUserName") ?: ""
          val rtcUserAvatar = call.argument<String>("rtcUserAvatar") ?: ""
          val rtcUserJWT = call.argument<String>("rtcUserJWT") ?: ""
          val rtcUserResource = call.argument<String>("rtcUserResource") ?: ""
          val analyticsSettingsHost = call.argument<String>("analyticsSettingsHost") ?: ""
          val analyticsSettingsVersion = call.argument<String>("analyticsSettingsVersion") ?: ""
          val analyticsSettingsPingDisabled = call.argument<Boolean>("analyticsSettingsPingDisabled") ?: ""
          val analyticsSettingsUseSSL = call.argument<Boolean>("analyticsSettingsUseSSL") ?: ""
          val isInitiator = call.argument<Boolean>("isInitiator") ?: false
          val defaultLayout = call.argument<Boolean>("defaultLayout") ?: false
          val audioOnly = call.argument<Boolean>("audioOnly") ?: false
          val sessionId = call.argument<String>("sessionId") ?: ""
          val region = call.argument<String>("region") ?: ""
          val mode = call.argument<String>("mode") ?: ""
          val showEndCallButton = call.argument<Boolean>("showEndCallButton") ?: false
          val showSwitchCameraButton = call.argument<Boolean>("showSwitchCameraButton") ?: false
          val showMuteAudioButton = call.argument<Boolean>("showMuteAudioButton") ?: false
          val showPauseVideoButton = call.argument<Boolean>("showPauseVideoButton") ?: false
          val showAudioModeButton = call.argument<Boolean>("showAudioModeButton") ?: false
          val startCallWithAudioMuted = call.argument<Boolean>("startCallWithAudioMuted") ?: false
          val startCallWithVideoMuted = call.argument<Boolean>("startCallWithVideoMuted") ?: false
          val audioMode = call.argument<String>("audioMode") ?: ""
          val switchToVideoCallButton = call.argument<Boolean>("switchToVideoCallButton") ?: false
          val recordingButton = call.argument<Boolean>("recordingButton") ?: false
          val startRecording = call.argument<Boolean>("startRecording") ?: false
          val avatarMode = call.argument<String>("avatarMode") ?: ""
          val width = call.argument<Int>("widht") ?: 0
          val height = call.argument<Int>("height") ?: 0

          mFlutterPluginBinding
            .platformViewRegistry
            .registerViewFactory(
              "viewCometChatCalling",
              CometChatCallingViewFactory(
                appID,
                domain,
                rtcUserUID,
                rtcUserName,
                rtcUserAvatar,
                rtcUserJWT,
                rtcUserResource,
                analyticsSettingsHost,
                analyticsSettingsVersion,
                analyticsSettingsPingDisabled.toString(),
                analyticsSettingsUseSSL.toString(),
                isInitiator,
                defaultLayout,
                audioOnly,
                sessionId,
                region,
                mode,
                showEndCallButton,
                showSwitchCameraButton,
                showMuteAudioButton,
                showPauseVideoButton,
                showAudioModeButton,
                startCallWithAudioMuted,
                startCallWithVideoMuted,
                audioMode,
                switchToVideoCallButton,
                recordingButton,
                startRecording,
                avatarMode,
                width,
                height
              )
            )
          result.success(true)
        }catch (e: Exception){
          Log.e(TAG, "Error ==>>>: $e")
          result.success(false)
        }
      }
      else -> {
        result.notImplemented()
      }
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
