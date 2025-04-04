function Room(number, name){
    this.number;
    this.name;
    this.eastRoom;
    this.westRoom;
    this.southRoom;
    this.northRoom;

    this.RoomInfo = function(){
        stRoom("방 번호 : " + this.number + "\n" + "방 이름: " + this.name + "\n" + 
        "동쪽 방 : " + this.eastRoom + "서쪽 방 : " + this.westRoom + "남쪽 방 : " + this.southRoom + "북쪽 방 : " + this.northRoom);
    }
}

var RoomList = new Room();