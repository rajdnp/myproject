import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
        String[] email = {
                "samplmail1@gmail.com",
                "samplemail2@gmail.com",
                "samplemail3@gmail.com"
        };

        for(String i : email) {

            Email from = new Email("rajeshdonepudi1@gmail.com");
            String subject = "SAMPLE MAIL from rajesh";
            Email to = new Email(i);
            Content content = new Content("text/plain", "Hello , the following Mail is send from me consuming SEND GRID Java API");
            Mail mail = new Mail(from, subject, to, content);
            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            Request request = new Request();
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);
                System.out.println(response.getStatusCode());
                System.out.println(response.getBody());
                System.out.println(response.getHeaders());
            } catch (IOException ex) {
                throw ex;
            }
        }

    }
}