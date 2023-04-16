import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CaptchaEngine extends Frame implements ActionListener {

   private static final long serialVersionUID = 1L;
   private TextField inputField;
   private Label captchaLabel;
   private Button submitButton;
   private String captcha;

   public CaptchaEngine() {
      super("Captcha Engine");

      captcha = generateCaptcha();

      captchaLabel = new Label(captcha);
      add(captchaLabel);

      inputField = new TextField(20);
      add(inputField);

      submitButton = new Button("Submit");
      add(submitButton);
      submitButton.addActionListener(this);

      setLayout(new FlowLayout());
      setSize(250, 200);
      setVisible(true);
   }

   public static void main(String[] args) {
      new CaptchaEngine();
   }


   public void actionPerformed(ActionEvent e) {
      String input = inputField.getText();
      if (input.equals(captcha)) {
         System.out.println("Captcha matched!");
      } else {
         System.out.println("Captcha did not match!");
      }
      captcha = generateCaptcha(); 
      captchaLabel.setText(captcha);
      inputField.setText(""); 
   }

   private String generateCaptcha() {
      String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      StringBuilder captcha = new StringBuilder();

      Random rnd = new Random();
      while (captcha.length() < 6) {
         int index = (int) (rnd.nextFloat() * chars.length());
         captcha.append(chars.charAt(index));
      }

      return captcha.toString();
   }
}
