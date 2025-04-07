function Room(number, name, roominfo, eastRoom, westRoom, southRoom, northRoom){
    this.number = number;
    this.name = name;
    this.roominfo = roominfo;
    this.eastRoom = eastRoom;
    this.westRoom = westRoom;
    this.southRoom = southRoom;
    this.northRoom = northRoom;

    this.PrintRoomInfo = function(){
        stRoom("방 번호 : " + this.number + "\n" + "방 이름: " + this.name + "\n" + "방 설명 : " + this.roominfo + "\n" +
        "동쪽 방 : " + this.eastRoom + "\n" + "서쪽 방 : " + this.westRoom + "\n" + "남쪽 방 : " + this.southRoom + "\n" + "북쪽 방 : " + this.northRoom);
    }
}