class PushNotification extends Notification implements Notifiable {
    public PushNotification(String message) {
        super(message);
    }

    @Override
    public void sendNotification() {
        System.out.println( "Notificare Push: " + getMessage());
    }
}