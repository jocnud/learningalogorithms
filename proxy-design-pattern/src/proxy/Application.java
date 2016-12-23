package proxy;

public class Application {

	public static void main(String[] args) {

		ConnectToInternet connectToInternet = new ProxyToInternetConnection();
		try {
			connectToInternet.connect("www.m.facebook.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
