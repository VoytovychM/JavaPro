package practice20240619.interfaceexample.factory;

import practice20240619.interfaceexample.MessageProvider;
import practice20240619.interfaceexample.MessageRenderer;

public class MainFactory {
    public static void main(String[] args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}

