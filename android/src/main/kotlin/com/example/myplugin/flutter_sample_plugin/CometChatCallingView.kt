package com.example.myplugin.flutter_sample_plugin

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import com.cometchat.pro.rtc.CometChatRTCView
import com.cometchat.pro.rtc.CometChatRTCView.CometChatRTCViewBuilder
import com.cometchat.pro.rtc.CometChatRTCViewListener
import com.cometchat.pro.rtc.model.*
import io.flutter.plugin.platform.PlatformView
import java.util.*
import kotlin.collections.ArrayList

class CometChatCallingView(context: Context, id: Int, creationParams: Map<String, Any>) : PlatformView {
    private val TAG = "NativeLayoutView"
    private val relativeLayout: View
    private val cometChatRTCView: CometChatRTCView

    var appID: String? = null
    var domain: String? = null
    var rtcUserUID: String? = null
    var rtcUserName: String? = null
    var rtcUserAvatar: String? = null
    var rtcUserJWT: String? = null
    var rtcUserResource: String? = null
    var analyticsSettingsHost: String? = null
    var analyticsSettingsVersion: String? = null
    var analyticsSettingsPingDisabled: String? = null
    var analyticsSettingsUseSSL: String? = null
    var isInitiator: Boolean? = null
    var defaultLayout: Boolean? = null
    var audioOnly: Boolean? = null
    var sessionId: String? = null
    var region: String? = null
    var mode: String? = null
    var showEndCallButton: Boolean? = null
    var showSwitchCameraButton: Boolean? = null
    var showMuteAudioButton: Boolean? = null
    var showPauseVideoButton: Boolean? = null
    var showAudioModeButton: Boolean? = null
    var startCallWithAudioMuted: Boolean? = null
    var startCallWithVideoMuted: Boolean? = null
    var audioMode: String? = null
    var switchToVideoCallButton: Boolean? = null
    var recordingButton: Boolean? = null
    var startRecording: Boolean? = null
    var avatarMode: String? = null
    var width: Int = 0
    var height: Int = 0

    init {
        for (map in creationParams){
            when(map.key){
                "appID" -> { appID = map.value.toString() }
                "domain" -> { domain = map.value.toString() }
                "rtcUserUID" -> { rtcUserUID = map.value.toString() }
                "rtcUserName" -> { rtcUserName = map.value.toString() }
                "rtcUserAvatar" -> { rtcUserAvatar = map.value.toString() }
                "rtcUserJWT" -> { rtcUserJWT = map.value.toString() }
                "rtcUserResource" -> { rtcUserResource = map.value.toString() }
                "analyticsSettingsHost" -> { analyticsSettingsHost = map.value.toString() }
                "analyticsSettingsVersion" -> { analyticsSettingsVersion = map.value.toString() }
                "analyticsSettingsPingDisabled" -> { analyticsSettingsPingDisabled = map.value.toString() }
                "analyticsSettingsUseSSL" -> { analyticsSettingsUseSSL = map.value.toString() }
                "isInitiator" -> { isInitiator = map.value.toString() == "true" }
                "defaultLayout" -> { defaultLayout = map.value.toString() == "true" }
                "audioOnly" -> { audioOnly = map.value.toString() == "true" }
                "sessionId" -> { sessionId = map.value.toString() }
                "region" -> { region = map.value.toString() }
                "mode" -> { mode = map.value.toString() }
                "showEndCallButton" -> { showEndCallButton = map.value.toString() == "true" }
                "showSwitchCameraButton" -> { showSwitchCameraButton = map.value.toString() == "true" }
                "showMuteAudioButton" -> { showMuteAudioButton = map.value.toString() == "true" }
                "showPauseVideoButton" -> { showPauseVideoButton = map.value.toString() == "true" }
                "showAudioModeButton" -> { showAudioModeButton = map.value.toString() == "true" }
                "startCallWithAudioMuted" -> { startCallWithAudioMuted = map.value.toString() == "true" }
                "startCallWithVideoMuted" -> { startCallWithVideoMuted = map.value.toString() == "true" }
                "audioMode" -> { audioMode = map.value.toString() }
                "switchToVideoCallButton" -> { switchToVideoCallButton = map.value.toString() == "true" }
                "recordingButton" -> { recordingButton = map.value.toString() == "true" }
                "startRecording" -> { startRecording = map.value.toString() == "true" }
                "avatarMode" -> { avatarMode = map.value.toString() }
                "widht" -> { width = map.value.toString().toInt() }
                "height" -> { height = map.value.toString().toInt() }
            }
        }

        val rtcUser = RTCUser(rtcUserUID, rtcUserName, rtcUserAvatar)
        //rtcUser.setJwt("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hcGljbGllbnQtZXUuY29tZXRjaGF0LmlvXC92Mi4wXC9tZVwvand0IiwiaWF0IjoxNjE1OTQwOTEzLCJzdWIiOiJbMjYzNDMxYjg0ODNkYjcwXXN1cGVyaGVybzEiLCJuYmYiOjE2MTU5MzczMTMsImV4cCI6MTYxNjAyNzMxMywiZGF0YSI6eyJhcHBJZCI6IjI2MzQzMWI4NDgzZGI3MCIsInJlZ2lvbiI6ImV1IiwiYXV0aFRva2VuIjoic3VwZXJoZXJvMV8xNjA1OTEzNjQ1YTc0MDc2MmI5YmE1MmQ5NjFmOGJmYzgzMDVlOTMzIiwidXNlciI6eyJ1aWQiOiJzdXBlcmhlcm8xIiwibmFtZSI6Iklyb24gTWFuIiwiYXZhdGFyIjoiaHR0cHM6XC9cL2RhdGEtZXUuY29tZXRjaGF0LmlvXC9hc3NldHNcL2ltYWdlc1wvYXZhdGFyc1wvaXJvbm1hbi5wbmciLCJzdGF0dXMiOiJvZmZsaW5lIiwicm9sZSI6ImRlZmF1bHQiLCJsYXN0QWN0aXZlQXQiOjE2MTEyMjM2NTN9LCJwYXNzdGhyb3VnaCI6eyJ1aWQiOiJzdXBlcmhlcm8xIiwic2Vzc2lvbklkIjoidjEuZXUuMjYzNDMxYjg0ODNkYjcwLnRlc3RuZXdkIn19fQ.KVdnvQjriaxUBI93d2oSWMnnBmEpXDYeDIdFYnDtwqF3uyM6IPL6scSJGTmC9FLieOOinH7pyjsR6YZs7Qq4SNPfn-KgD5jF-5PatKMbd9ykb7P5dGL_G9JCFUpZt37e835XQFInjHhj2hZsy2MVrXlpoIeYZh7pZk8KKizXf7E");
        rtcUser.resource = rtcUserResource
        val settings = AnalyticsSettings(analyticsSettingsHost, analyticsSettingsVersion)
        cometChatRTCView = CometChatRTCViewBuilder(context as Activity)
            .setSessionId(sessionId)
            .setAppId(appID)
            .setRegion(region)
            .setDomain(domain)
            .setRTCUser(rtcUser)
            .setIsInitiator(isInitiator!!)
            .setDefaultLayoutEnable(defaultLayout!!)
            .setIsAudioOnly(audioOnly!!)
            .setMode(mode)
            .setDefaultAudioMode(audioMode)
            .setEndCallButtonDisable(showEndCallButton!!)
            .startWithAudioMuted(startCallWithAudioMuted!!)
            .startWithVideoMuted(startCallWithVideoMuted!!)
            .setAnalyticsSettings(settings)
            .showRecordingButton(recordingButton!!)
            .startRecordingOnCallStart(startRecording!!)
            .showSwitchToVideoCallButton(showPauseVideoButton!!)
            .setAvatarMode(avatarMode)
            .setEventListner(object : CometChatRTCViewListener {
                override fun onCallEnded() {
                    Log.e(TAG, "onCallEnded called ......")
                }

                override fun onCallEndButtonPressed() {
                    Log.e(TAG, "onCallEndButtonPressed called ......")
                    //cometChatRTCView.endCallSession();
                }

                override fun onUserJoined(user: RTCUser) {
                    Log.e(TAG, "onUserJoined called UID ......" + user.uid)
                    Log.e(TAG, "onUserJoined called name ......" + user.name)
                    Log.e(TAG, "onUserJoined called avatar ......" + user.avatar)
                }

                override fun onUserLeft(user: RTCUser) {
                    Log.e(TAG, "onUserLeft called UID ......" + user.uid)
                    Log.e(TAG, "onUserLeft called name ......" + user.name)
                    Log.e(TAG, "onUserLeft called avatar ......" + user.avatar)
                }

                override fun onUserListChanged(users: ArrayList<RTCUser>) {
                    Log.e(TAG, "onUserListChanged called name ......")
                }

                override fun onAudioModeChanged(devices: ArrayList<AudioMode>) {
                    Log.e(TAG, "onAudioModeChanged size = " + devices.size)
                    for (i in devices.indices) {
                        val audioMode = devices[i]
                        Log.e(
                            TAG,
                            "Mode : " + audioMode.mode + "   is Selected : " + audioMode.isSelected
                        )
                    }
                }

                override fun onCallSwitchedToVideo(info: CallSwitchRequestInfo) {
                    Log.e(TAG, "onCallSwitchedToVideo session id = " + info.sessionId)
                    Log.e(TAG, "onCallSwitchedToVideo Accepted By = " + info.requestAcceptedBy.name)
                    Log.e(
                        TAG,
                        "onCallSwitchedToVideo Initiated By = " + info.requestInitiatedBy.name
                    )
                }

                override fun onUserMuted(mutedUser: RTCMutedUser) {
                    Log.e(TAG, "onUserMuted muted id = " + mutedUser.muted.uid)
                    Log.e(TAG, "onUserMuted mutedBy id = " + mutedUser.mutedBy.uid)
                }

                override fun onRecordingToggled(info: RTCRecordingInfo) {
                    Log.e(TAG, "onRecordingToggled type = " + info.recordingStarted.toString())
                    Log.e(TAG, "onRecordingToggled dduser id = " + info.user.uid)
                }
            }).build()
        relativeLayout = cometChatRTCView.view

        val size = Point()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            context.windowManager.defaultDisplay.getRealSize(size)
        }
        val params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        Log.i(TAG, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 width: 0: $width")
        Log.i(TAG, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 height: 0: $height")
        if (height > 0){
            Log.i(TAG, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 height: 1: $height")
            params.height = height
        }else{
            Log.i(TAG, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 height: 2: $height")
            params.height = size.y
        }
        if (width > 0){
            Log.i(TAG, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 width: 1: $width")
            params.width = width
        }else{
            Log.i(TAG, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 width: 2: $width")
            params.width = size.x
        }
        relativeLayout.layoutParams = params
    }

    override fun getView(): View? {
        return relativeLayout
    }

    override fun dispose() {}
}