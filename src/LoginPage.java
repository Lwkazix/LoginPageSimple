import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage {
    JFrame frame = new JFrame();
    JButton button =  new JButton("Login: ");
    JButton resetbutton =  new JButton("Reset: ");
    JTextField userIdField = new JTextField();
    JPasswordField userPassWord = new JPasswordField();
    JLabel userILbel = new JLabel("User ID :");
    JLabel userPassWordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel();
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    LoginPage(HashMap<String,String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;

        userILbel.setBounds(50,100,75,25);
        userPassWordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIdField.setBounds(125,100,200,25);
        userPassWord.setBounds(125,150,200,25);

        button.setBounds(125,200,100,25);
        button.setFocusable(false);
        button.addActionListener(this::actionPerfomed);


        resetbutton.setBounds(225,200,100,25);
        resetbutton.setFocusable(false);
        resetbutton.addActionListener(this::actionPerfomed);

        frame.add(userILbel);
        frame.add(userPassWordLabel);
        frame.add(messageLabel);
        frame.add(userPassWord);
        frame.add(userIdField);
        frame.add(button);
        frame.add(resetbutton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,800);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerfomed(ActionEvent event){

        if (event.getSource()==resetbutton){
            userIdField.setText("");
            userPassWord.setText("");
        }
        if (event.getSource()==button){
            String userID = userIdField.getText();
            String password = String.valueOf(userPassWord.getPassword());

            if ( loginInfo.containsKey(userID)){
                if (loginInfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful");
                    frame.dispose();
                    Welcome wc = new Welcome(userID);
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password");
                }

            }else {

                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not Found");
            }
        }

    }

}
