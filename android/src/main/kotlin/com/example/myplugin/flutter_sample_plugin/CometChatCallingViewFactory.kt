package com.example.myplugin.flutter_sample_plugin


import android.content.Context
import android.icu.lang.UCharacter
import com.example.myplugin.flutter_sample_plugin.CometChatCallingView
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import java.util.*

class CometChatCallingViewFactory : PlatformViewFactory {
    var appID: String? = ""
    var domain: String? = ""
    var rtcUserUID: String? = ""
    var rtcUserName: String? = ""
    var rtcUserAvatar: String? = ""
    var rtcUserJWT: String? = ""
    var rtcUserResource: String? = ""
    var analyticsSettingsHost: String? = ""
    var analyticsSettingsVersion: String? = ""
    var analyticsSettingsPingDisabled: String? = ""
    var analyticsSettingsUseSSL: String? = ""
    var isInitiator: Boolean = false
    var defaultLayout: Boolean = false
    var audioOnly: Boolean = false
    var sessionId: String? = ""
    var region: String? = ""
    var mode: String? = ""
    var showEndCallButton: Boolean = false
    var showSwitchCameraButton: Boolean = false
    var showMuteAudioButton: Boolean = false
    var showPauseVideoButton: Boolean = false
    var showAudioModeButton: Boolean = false
    var startCallWithAudioMuted: Boolean = false
    var startCallWithVideoMuted: Boolean = false
    var audioMode: String? = ""
    var switchToVideoCallButton: Boolean = false
    var recordingButton: Boolean = false
    var startRecording: Boolean = false
    var avatarMode: String? = ""
    var width: Int = 0
    var height: Int = 0

    constructor() : super(StandardMessageCodec.INSTANCE) {}

    constructor(
        appID: String?,
        domain: String?,
        rtcUserUID: String?,
        rtcUserName: String?,
        rtcUserAvatar: String?,
        rtcUserJWT: String?,
        rtcUserResource: String?,
        analyticsSettingsHost: String?,
        analyticsSettingsVersion: String?,
        analyticsSettingsPingDisabled: String?,
        analyticsSettingsUseSSL: String?,
        isInitiator: Boolean,
        defaultLayout: Boolean,
        audioOnly: Boolean,
        sessionId: String?,
        region: String?,
        mode: String?,
        showEndCallButton: Boolean,
        showSwitchCameraButton: Boolean,
        showMuteAudioButton: Boolean,
        showPauseVideoButton: Boolean,
        showAudioModeButton: Boolean,
        startCallWithAudioMuted: Boolean,
        startCallWithVideoMuted: Boolean,
        audioMode: String?,
        switchToVideoCallButton: Boolean,
        recordingButton: Boolean,
        startRecording: Boolean,
        avatarMode: String?,
        width: Int,
        height: Int
    ) : super(StandardMessageCodec.INSTANCE) {
        this.appID = appID
        this.domain = domain
        this.rtcUserUID = rtcUserUID
        this.rtcUserName = rtcUserName
        this.rtcUserAvatar = rtcUserAvatar
        this.rtcUserJWT = rtcUserJWT
        this.rtcUserResource = rtcUserResource
        this.analyticsSettingsHost = analyticsSettingsHost
        this.analyticsSettingsVersion = analyticsSettingsVersion
        this.analyticsSettingsPingDisabled = analyticsSettingsPingDisabled
        this.analyticsSettingsUseSSL = analyticsSettingsUseSSL
        this.isInitiator = isInitiator
        this.defaultLayout = defaultLayout
        this.audioOnly = audioOnly
        this.sessionId = sessionId
        this.region = region
        this.mode = mode
        this.showEndCallButton = showEndCallButton
        this.showSwitchCameraButton = showSwitchCameraButton
        this.showMuteAudioButton = showMuteAudioButton
        this.showPauseVideoButton = showPauseVideoButton
        this.showAudioModeButton = showAudioModeButton
        this.startCallWithAudioMuted = startCallWithAudioMuted
        this.startCallWithVideoMuted = startCallWithVideoMuted
        this.audioMode = audioMode
        this.switchToVideoCallButton = switchToVideoCallButton
        this.recordingButton = recordingButton
        this.startRecording = startRecording
        this.avatarMode = avatarMode
        this.width = width
        this.height = height
    }

    override fun create(context: Context?, viewId: Int, args: Any?): PlatformView {
        val creationParams = HashMap<String, String?>()
        creationParams["appID"] = appID
        creationParams["domain"] = domain
        creationParams["rtcUserUID"] = rtcUserUID
        creationParams["rtcUserName"] = rtcUserName
        creationParams["rtcUserAvatar"] = rtcUserAvatar
        creationParams["rtcUserJWT"] = rtcUserJWT
        creationParams["rtcUserResource"] = rtcUserResource
        creationParams["analyticsSettingsHost"] = analyticsSettingsHost
        creationParams["analyticsSettingsVersion"] = analyticsSettingsVersion
        creationParams["analyticsSettingsPingDisabled"] = analyticsSettingsPingDisabled
        creationParams["analyticsSettingsUseSSL"] = analyticsSettingsUseSSL
        creationParams["isInitiator"] = isInitiator.toString()
        creationParams["defaultLayout"] = defaultLayout.toString()
        creationParams["audioOnly"] = audioOnly.toString()
        creationParams["sessionId"] = sessionId
        creationParams["region"] = region
        creationParams["mode"] = mode
        creationParams["showEndCallButton"] = showEndCallButton.toString()
        creationParams["showSwitchCameraButton"] = showSwitchCameraButton.toString()
        creationParams["showMuteAudioButton"] = showMuteAudioButton.toString()
        creationParams["showPauseVideoButton"] = showPauseVideoButton.toString()
        creationParams["showAudioModeButton"] = showAudioModeButton.toString()
        creationParams["startCallWithAudioMuted"] = startCallWithAudioMuted.toString()
        creationParams["startCallWithVideoMuted"] = startCallWithVideoMuted.toString()
        creationParams["audioMode"] = audioMode
        creationParams["switchToVideoCallButton"] = switchToVideoCallButton.toString()
        creationParams["recordingButton"] = recordingButton.toString()
        creationParams["startRecording"] = startRecording.toString()
        creationParams["avatarMode"] = avatarMode
        creationParams["width"] = width.toString()
        creationParams["height"] = height.toString()
        val map: Map<String, Any> = HashMap<String, Any>(creationParams)
        return CometChatCallingView(context!!, viewId, map)
    }


}