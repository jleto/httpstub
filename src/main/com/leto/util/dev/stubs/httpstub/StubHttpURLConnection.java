package com.leto.util.dev.stubs.httpstub;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.io.InputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;

public class StubHttpURLConnection extends HttpURLConnection
{
	private boolean isInput = true;

	protected StubHttpURLConnection(URL url)
	{
		super(url);
	}

	public InputStream getInputStream() throws IOException
	{
		if (!isInput)
		{
			throw new ProtocolException("Cannot read URLConnection" + " if doInput=false (call setDoInput(true))");
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(new String("It works").getBytes());
		return bais;
	}

	public void disconnect()
	{
	}

	public void connect() throws IOException
	{	
	}

	public boolean usingProxy()
	{
		return false;
	}
}
