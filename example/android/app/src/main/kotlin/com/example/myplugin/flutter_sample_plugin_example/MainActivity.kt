package com.example.myplugin.flutter_sample_plugin_example

import android.util.Log
import com.cometchat.pro.rtc.CometChatRTCView
import com.cometchat.pro.rtc.CometChatRTCView.CometChatRTCViewBuilder
import com.cometchat.pro.rtc.CometChatRTCViewListener
import com.cometchat.pro.rtc.model.*
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine


class MainActivity: FlutterActivity() {
    //private var cometChatRTCView: CometChatRTCView? = null

    /*override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
         super.configureFlutterEngine(flutterEngine)
         flutterEngine
             .platformViewsController
             .registry
             .registerViewFactory("view1", NativeViewFactory())
     }*/

    /*private fun startCallSession() {
        val rtcUser = RTCUser("r1", "R1", "")
        //rtcUser.setJwt("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hcGljbGllbnQtZXUuY29tZXRjaGF0LmlvXC92Mi4wXC9tZVwvand0IiwiaWF0IjoxNjE1OTQwOTEzLCJzdWIiOiJbMjYzNDMxYjg0ODNkYjcwXXN1cGVyaGVybzEiLCJuYmYiOjE2MTU5MzczMTMsImV4cCI6MTYxNjAyNzMxMywiZGF0YSI6eyJhcHBJZCI6IjI2MzQzMWI4NDgzZGI3MCIsInJlZ2lvbiI6ImV1IiwiYXV0aFRva2VuIjoic3VwZXJoZXJvMV8xNjA1OTEzNjQ1YTc0MDc2MmI5YmE1MmQ5NjFmOGJmYzgzMDVlOTMzIiwidXNlciI6eyJ1aWQiOiJzdXBlcmhlcm8xIiwibmFtZSI6Iklyb24gTWFuIiwiYXZhdGFyIjoiaHR0cHM6XC9cL2RhdGEtZXUuY29tZXRjaGF0LmlvXC9hc3NldHNcL2ltYWdlc1wvYXZhdGFyc1wvaXJvbm1hbi5wbmciLCJzdGF0dXMiOiJvZmZsaW5lIiwicm9sZSI6ImRlZmF1bHQiLCJsYXN0QWN0aXZlQXQiOjE2MTEyMjM2NTN9LCJwYXNzdGhyb3VnaCI6eyJ1aWQiOiJzdXBlcmhlcm8xIiwic2Vzc2lvbklkIjoidjEuZXUuMjYzNDMxYjg0ODNkYjcwLnRlc3RuZXdkIn19fQ.KVdnvQjriaxUBI93d2oSWMnnBmEpXDYeDIdFYnDtwqF3uyM6IPL6scSJGTmC9FLieOOinH7pyjsR6YZs7Qq4SNPfn-KgD5jF-5PatKMbd9ykb7P5dGL_G9JCFUpZt37e835XQFInjHhj2hZsy2MVrXlpoIeYZh7pZk8KKizXf7E");
        rtcUser.resource = "WEB-2_2_1-b32afe0d-dd0b-4e16-8486-233d81d7388f-1615574029784"
        val settings = AnalyticsSettings("metrics-eu.cometchat.io", "v1")
        cometChatRTCView = CometChatRTCViewBuilder(this)
            .setSessionId("test")
            .setAppId("324158ac3b4be0c")
            .setRegion("eu")
            .setDomain("rtc-eu.cometchat.io")
            .setRTCUser(rtcUser)
            .setIsInitiator(true)
            .setDefaultLayoutEnable(true)
            .setIsAudioOnly(false)
            .setMode(CometChatRTCViewBuilder.MODE_DEFAULT)
            .setDefaultAudioMode("EARPIECE")
            .setEndCallButtonDisable(false)
            .startWithAudioMuted(true)
            .startWithVideoMuted(true)
            .setAnalyticsSettings(settings)
            .showRecordingButton(false)
            .startRecordingOnCallStart(false)
            .showSwitchToVideoCallButton(true)
            .setAvatarMode("square")
            .setEventListner(object : CometChatRTCViewListener {
                override fun onCallEnded() {
                    Log.e("TAG", "onCallEnded called ......")
                    finish()
                }

                override fun onCallEndButtonPressed() {
                    Log.e("TAG", "onCallEndButtonPressed called ......")
                    //cometChatRTCView.endCallSession();
                    finish()
                }

                override fun onUserJoined(user: RTCUser) {
                    Log.e("TAG", "onUserJoined called UID ......" + user.uid)
                    Log.e("TAG", "onUserJoined called name ......" + user.name)
                    Log.e("TAG", "onUserJoined called avatar ......" + user.avatar)
                }

                override fun onUserLeft(user: RTCUser) {
                    Log.e("TAG", "onUserLeft called UID ......" + user.uid)
                    Log.e("TAG", "onUserLeft called name ......" + user.name)
                    Log.e("TAG", "onUserLeft called avatar ......" + user.avatar)
                }

                override fun onUserListChanged(users: ArrayList<RTCUser>) {
                    Log.e("TAG", "onUserListChanged called name ......")
                }

                override fun onAudioModeChanged(devices: ArrayList<AudioMode>) {
                    Log.e("TAG", "onAudioModeChanged size = " + devices.size)
                    for (i in devices.indices) {
                        val audioMode = devices[i]
                        Log.e(
                            "TAG",
                            "Mode : " + audioMode.mode + "   is Selected : " + audioMode.isSelected
                        )
                    }
                }

                override fun onCallSwitchedToVideo(info: CallSwitchRequestInfo) {
                    Log.e("TAG", "onCallSwitchedToVideo session id = " + info.sessionId)
                    Log.e(
                        "TAG",
                        "onCallSwitchedToVideo Accepted By = " + info.requestAcceptedBy.name
                    )
                    Log.e(
                        "TAG",
                        "onCallSwitchedToVideo Initiated By = " + info.requestInitiatedBy.name
                    )
                }

                override fun onUserMuted(mutedUser: RTCMutedUser) {
                    Log.e("TAG", "onUserMuted muted id = " + mutedUser.muted.uid)
                    Log.e("TAG", "onUserMuted mutedBy id = " + mutedUser.mutedBy.uid)
                }

                override fun onRecordingToggled(info: RTCRecordingInfo) {
                    Log.e("TAG", "onRecordingToggled type = " + info.recordingStarted.toString())
                    Log.e("TAG", "onRecordingToggled dduser id = " + info.user.uid)
                }
            }).build()
    }*/
}
