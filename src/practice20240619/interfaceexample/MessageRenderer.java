package practice20240619.interfaceexample;

public interface MessageRenderer {

    void render();

   void setMessageProvider (MessageProvider messageProvider);

   MessageProvider getMessageProvider();
}
