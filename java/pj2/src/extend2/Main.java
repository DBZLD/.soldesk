package extend2;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Unit unit = new Unit("유닛", 10);
		Human human = new Human("인간", 100, 50);
		ArrayList<Object> objList = new ArrayList<Object>();
		objList.add(new Object("1번"));
		objList.add(new Object("2번"));
		objList.add(new Object("3번"));
		objList.add(new Object("4번"));
		objList.add(unit);
		objList.add(human);

//		Human human1 = (Human) unit;
//		human1.Info();

//		for (Object obj : objList) {
//			if (obj instanceof Human) {
//				((Human) obj).FunctionHuman();
//				((Human) obj).Info();
//			} else if (obj instanceof Unit) {
//				((Unit) obj).FunctionUnit();
//				obj.Info();
//			} else {
//				obj.FunctionObject();
//				obj.Info();
//			}
//		}

//		for (Object obj : objList) {
//			if (obj.ReturnClass() == 1) {
//				obj.FunctionObject();
//				obj.Info();
//			} else if (obj.ReturnClass() == 2) {
//				((Unit) obj).FunctionUnit();
//				obj.Info();
//			} else if (obj.ReturnClass() == 3) {
//				((Human) obj).FunctionHuman();
//				((Human) obj).Info();
//			}
//		}
	}

}
