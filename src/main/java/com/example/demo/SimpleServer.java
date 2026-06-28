package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleServer {
	
	private static final Logger log = LogManager.getLogger(SimpleServer.class);
	
    public static void main(String[] args) {
        int port = 5000; // 사용할 포트 번호
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("[Server] 서버가 오픈되었습니다. 포트: " + port);
            
            // 클라이언트 접속 대기
            Socket socket = serverSocket.accept();
            log.info("[Server] 클라이언트가 연결되었습니다: " + socket.getInetAddress());
            
            // 클라이언트가 보낸 데이터 읽기용 스트림 생성
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String message = reader.readLine();
            log.info("[Server] 받은 메시지: " + message);
            
            // 연결 종료
            socket.close();
            log.info("[Server] 연결을 종료합니다.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
