package javaBasic;

public class Topic_01_SystemProperties {
	public static void main(String[] arg) {
		String projectLocation= System.getProperty("user.dir");
		System.out.println(projectLocation);
		String osName= System.getProperty("os.name");
		System.out.println(osName);
	}
}
