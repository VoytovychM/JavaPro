package practice20240619.interfaceexample;

public class MessageRendererSOUT implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        System.out.println( messageProvider.getMessage());

    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
