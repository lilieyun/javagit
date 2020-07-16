package lilieyun.study.SerialPortTest2;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TwoWaySerialComm2 {
	
	private static byte[] buffer = new byte[1024];
	private static boolean isNewBuffer=false;
	
	public TwoWaySerialComm2() {
		super();
	}

	void connect(String portName) throws Exception {
		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);

				InputStream in = serialPort.getInputStream();
				OutputStream out = serialPort.getOutputStream();

				(new Thread(new SerialWriter(out))).start();
				// (new Thread(new SerialWriter(out))).start();

				serialPort.addEventListener(new SerialReader(in));
				serialPort.notifyOnDataAvailable(true);

			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	/**
	 * Handles the input coming from the serial port. A new line character is
	 * treated as the end of a block in this example.
	 */
	public static class SerialReader implements SerialPortEventListener {
		private InputStream in;
		

		public SerialReader(InputStream in) {
			this.in = in;
		}

		@Override
		public void serialEvent(SerialPortEvent arg0) {
			// TODO Auto-generated method stub
			int data;

			try {
				int len = 0;
				while ((data = in.read()) > -1) {
					if (data == '\n') {
						break;
					}
					buffer[len++] = (byte) data;
				}
                isNewBuffer=true;
                /*
				StringBuilder sb = new StringBuilder();
				sb.append("接收: ");
				for (int i = 0; i < len; i++) {
					sb.append(String.format("%02X ", buffer[i]));
				}
				System.out.print(sb.toString());
				*/

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}

		}
	}

		/** */
		public static class SerialWriter implements Runnable {
			OutputStream out;

			public SerialWriter(OutputStream out) {
				this.out = out;
			}

			public void run() {
				try {
					int c = 0;
					while ((c = System.in.read()) > -1) {
						System.out.println(c);
						if (c == 83) {
							this.out.write(new byte[] { 0x01, 0x03, 0x00, 0x00, 0x00, 0x03, 0x05, (byte) 0xCB });
						}
						if (isNewBuffer) {
							StringBuilder sb = new StringBuilder();
							sb.append("接收: ");
							for (int i = 0; i < 11; i++) {
								sb.append(String.format("%02X ", buffer[i]));
							}
							System.out.print(sb.toString());
							isNewBuffer=false;
							
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		public static void main(String[] args) {
			try {
				(new TwoWaySerialComm2()).connect("COM1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}