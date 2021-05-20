package javaBasic;

public class Topic_03_String_Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="Xin moi a/c: %s";
		String[] khachMoi= {"Nguyen Van A", "Nguyen Van B", "Nguyen Van C"};
		for (String khach : khachMoi) {
			System.out.println(String.format(name, khach));
		}
	}

}
