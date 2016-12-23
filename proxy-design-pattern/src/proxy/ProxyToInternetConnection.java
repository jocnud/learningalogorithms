package proxy;

import java.util.Arrays;

public class ProxyToInternetConnection implements ConnectToInternet {

	public static final String restrictedSites[] = { "www.facebook.com", "www.twitter.com", "www.gmail.com" };

	private ConnectToInternetImpl connectToInternet = new ConnectToInternetImpl();

	@Override
	public void connect(String url) throws Exception {
		if (Arrays.asList(restrictedSites).contains(url))
			throw new Exception("Access Restricted :(");
		
		connectToInternet.connect(url);
	}

}
