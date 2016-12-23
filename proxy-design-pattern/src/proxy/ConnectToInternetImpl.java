package proxy;

public class ConnectToInternetImpl implements ConnectToInternet {

	@Override
	public void connect(String url) throws Exception {
		System.out.println(String.format("Connecting to [%s] ... ", url));

	}

}
