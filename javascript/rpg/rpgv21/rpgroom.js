function Room(number, name, roominfo, eastRoom, westRoom, southRoom, northRoom){
    this.number = number;
    this.name = name;
    this.roominfo = roominfo;
    this.eastRoomNum = eastRoom;
    this.westRoomNum = westRoom;
    this.southRoomNum = southRoom;
    this.northRoomNum = northRoom;

    this.PrintRoomInfo = function(){
        stRoom("방 번호 : " + this.number + "\n" + "방 이름: " + this.name + "\n" + "방 설명 : " + this.roominfo + "\n" +
        "동쪽 방 : " + GetRoom(this.eastRoomNum).name + "\n" + "서쪽 방 : " + GetRoom(this.westRoomNum).name + "\n" + "남쪽 방 : " + GetRoom(this.southRoomNum).name + "\n" + "북쪽 방 : " + GetRoom(this.northRoomNum).name);
    }
}