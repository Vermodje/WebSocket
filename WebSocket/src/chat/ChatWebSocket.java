package chat;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
// EndPoint for WebSocketServlet
@WebSocket
public class ChatWebSocket {
    private Session session;

    //Когда установлено соединение между клиентом и сокетом
    @OnWebSocketConnect
    public void onOpen(Session session) {
        this.session = session;
    }
    //Когда пришло сообщение сокету от клиента
    @OnWebSocketMessage
    public void onMessage(String data) {
        this.sendString(data);
    }


    //Формирование ответа
    private void sendString(String data) {
        try {
            //Переводит канал в режим ответа (session.getRemote() - возвращает ссылку на объект
            // RemoteEndPoint, кот. явл. противоположной стороной диалога) и вызывает метод "передать строку"
            session.getRemote().sendString(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
