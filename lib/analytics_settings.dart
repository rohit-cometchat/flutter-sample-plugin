class AnalyticsSettings {
  String? analyticsHost;
  String? analyticsVersion;
  bool? analyticsPingDisabled;
  bool? analyticsUseSSL;

  AnalyticsSettings(this.analyticsHost, this.analyticsVersion);

  String? getAnalyticsHost() {
    return analyticsHost;
  }

  void setAnalyticsHost(String analyticsHost) {
    this.analyticsHost = analyticsHost;
  }

  String? getAnalyticsVersion() {
    return analyticsVersion;
  }

  void setAnalyticsVersion(String analyticsVersion) {
    this.analyticsVersion = analyticsVersion;
  }

  bool? getAnalyticsPingDisabled() {
    return analyticsPingDisabled;
  }

  void setAnalyticsPingDisabled(bool analyticsPingDisabled) {
    this.analyticsPingDisabled = analyticsPingDisabled;
  }

  bool? getAnalyticsUseSSL() {
    return analyticsUseSSL;
  }

  void setAnalyticsUseSSL(bool analyticsUseSSL) {
    this.analyticsUseSSL = analyticsUseSSL;
  }
}
