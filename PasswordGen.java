import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PasswordGenerator extends Frame implements ActionListener {

   private static final long serialVersionUID = 1L;
   private TextField passLength;
   private Label passLabel;
   private Button generateButton;
   private TextArea passArea;

   public PasswordGenerator() {
      super("Password Generator");

      passLabel = new Label("Password Length:");
      add(passLabel);

      passLength = new TextField("8", 4);
      add(passLength);

      generateButton = new Button("Generate");
      add(generateButton);
      generateButton.addActionListener(this);

      passArea = new TextArea(5, 20);
      passArea.setEditable(false);
      add(passArea);

      setLayout(new FlowLayout());
      setSize(250, 200);
      setVisible(true);
   }

   public static void main(String[] args) {
      new PasswordGenerator();
   }


   public void actionPerformed(ActionEvent e) {
      int length = Integer.parseInt(passLength.getText());
      String password = generatePassword(length);
      passArea.setText(password);
   }

   private String generatePassword(int length) {
      String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+";
      StringBuilder password = new StringBuilder();

      Random rnd = new Random();
      while (password.length() < length) { // generate the password
         int index = (int) (rnd.nextFloat() * chars.length());
         password.append(chars.charAt(index));
      }

      return password.toString();
   }
}
