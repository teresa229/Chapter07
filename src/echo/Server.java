package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		
		//서버 소켓 객체 생성
		ServerSocket serverSocket = new ServerSocket();

		//ip 포트번호 설정해주어야 한다.
		serverSocket.bind(new InetSocketAddress("192.168.168.104",10001));
		
		System.out.println("<서버시작>");
		System.out.println("=========================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		while(true) {
			//accept 
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 연결되었습니다.");
			
			//출장 보내기 .start();
			Thread thread = new ServerThread(socket);
			thread.start();
		}
        /*  //수업중에는 반복되는 경우라 지금은 사용하지 않음.
		System.out.println("=========================");
		System.out.println("<서버 종료>");
		serverSocket.close(); 
		*/
	}
	

}
