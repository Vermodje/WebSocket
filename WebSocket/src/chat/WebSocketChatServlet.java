package chat;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "WebSocketChatServlet", urlPatterns = {"/chat"})
public class WebSocketChatServlet extends WebSocketServlet {

    @Override
    public void configure(WebSocketServletFactory factory) {
        //Настраиваем сокет на работу с Req и Resp
        factory.setCreator((req, resp) -> new ChatWebSocket());
    }
}
