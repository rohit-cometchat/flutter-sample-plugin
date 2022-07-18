class RTCUser {
  String? uid;
  String? avatar;
  String? name;
  String? jwt;
  String? resource;

  RTCUser(this.uid, this.name, this.avatar, this.jwt, this.resource);

  RTCUser setUID(String uid){
    this.uid = uid;
    return this;
  }

  RTCUser setAvatar(String avatar){
    this.avatar = avatar;
    return this;
  }

  RTCUser setName(String name){
    this.name = name;
    return this;
  }

  RTCUser setJWT(String jwt){
    this.jwt = jwt;
    return this;
  }

  RTCUser setResource(String resource){
    this.resource = resource;
    return this;
  }

}