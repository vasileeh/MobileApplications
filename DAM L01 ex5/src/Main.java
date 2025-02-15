public class Main {
    public static void main(String[] args) {
        Notifiable sms = new SMSNotification("coletul tau a fost expediat");
        Notifiable email = new EmailNotification("factura ta este pregatita");
        Notifiable push = new PushNotification("cineva ti a dat like la story");

        sms.sendNotification();
        email.sendNotification();
        push.sendNotification();
    }
}