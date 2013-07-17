import java.io.*;
import javax.bluetooth.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;

public class MyBluethooth {

	private RemoteDevice btrd = null;
	private BTConnection btc = null;

	public DataInputStream dis;
	public DataOutputStream dos;

	void MyBluethoth() {
		String name = "NXT";

		this.btrd = Bluetooth.getKnownDevice(name);
		this.btc = Bluetooth.connect(this.btrd);

		if (this.btc != null) {
			this.dis = this.btc.openDataInputStream();
			this.dos = this.btc.openDataOutputStream();
		}

	}

	void run() {
		
		try{
			if(dis.available()!=0)
			{
				String data = dis.readUTF();
				LCD.drawString(data, 0, 1);
			}
		}
		catch (IOException ioe)
		{
			System.exit(1);
		}

	}
	
}
