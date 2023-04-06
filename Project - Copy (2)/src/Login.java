
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {
    private String loginId, loginPass;
    HashMap<String, String> account = new HashMap<String, String>();
    HashMap<String, String> adminAccount = new HashMap<String, String>();
    JFrame frame = new JFrame("Steel Fitness ");
    JButton loginB = new JButton("Login");
    JButton resetB = new JButton("Reset");
    JTextField id = new JTextField();
    JPasswordField pass = new JPasswordField();
    JLabel userId = new JLabel("User: ");
    JLabel userPass = new JLabel("Password: ");
    JLabel mes = new JLabel();
    JPanel panelB = new JPanel(new FlowLayout());
    JLabel logo = new JLabel(new ImageIcon(((new ImageIcon("D:\\Project\\edit.png")).getImage()).getScaledInstance(100,
            100, java.awt.Image.SCALE_SMOOTH)));

    Login(HashMap<String, String> admin) {
        adminAccount = admin;
        userId.setBounds(50, 100, 75, 25);
        userPass.setBounds(50, 150, 75, 25);

        mes.setBounds(125, 250, 250, 35);
        mes.setFont(new Font(null, Font.ITALIC, 25));

        id.setBounds(125, 100, 200, 25);
        pass.setBounds(125, 150, 200, 25);
        logo.setBounds(50, 50, 200, 25);
        logo.repaint();
        loginB.setFont(new Font(null, Font.BOLD, 18));
        loginB.setFocusable(true);
        loginB.addActionListener(this);
        resetB.setFont(new Font(null, Font.BOLD, 18));
        resetB.setFocusable(true);
        resetB.addActionListener(this);

        panelB.setBackground(Color.black);
        panelB.add(loginB);
        panelB.add(resetB);

        frame.add(userId);
        frame.add(id);
        frame.add(pass);
        frame.add(userPass);
        frame.add(mes);
        frame.add(panelB);
        frame.add(panelB, BorderLayout.SOUTH);
        frame.add(logo, BorderLayout.NORTH);
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetB) {
            id.setText("");
            pass.setText("");
        }
        if (e.getSource() == loginB) {
            loginId = id.getText();
            loginPass = String.valueOf(pass.getPassword());
            String adminId = id.getText();
            String adminPass = String.valueOf(pass.getPassword());
            if (adminAccount.containsKey(loginId)) {
                if (adminAccount.get(adminId).equals(adminPass)) {
                    mes.setForeground(Color.green);
                    mes.setText("Complete ");
                    System.out.println("Admin Login Success");
                    frame.dispose();
                    AdminPage ad = new AdminPage();
                } else {
                    mes.setForeground(Color.red);
                    mes.setText("ERROR");
                }
            } else {
                mes.setForeground(Color.red);
                mes.setText("UNKNOWN");
            }
        }
    }
}