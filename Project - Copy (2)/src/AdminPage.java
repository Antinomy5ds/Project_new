import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.datatransfer.FlavorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class AdminPage extends JFrame implements ActionListener {
    // Variable
    String[] col = { "Name", "Date", "Class" };
    int baseSalary = 25000;
    IDandPass ac = new IDandPass();
    AdminPass adAc = new AdminPass();
    IDandPass name = new IDandPass();
    HashMap<String, String> value = ac.getAccountInfo();
    // Table
    DefaultTableModel model = new DefaultTableModel(col, 0);
    JTable table2 = new JTable();
    JScrollPane memList;
    // Button
    JButton logout;
    JButton member;
    JButton table;
    JButton coach;
    JButton add;
    JComboBox nameBox;
    // Text
    JTextField user = new JTextField();
    JTextField date = new JTextField();
    JTextField fitClass = new JTextField();

    // Image
    ImageIcon yami = new ImageIcon("D:\\Project\\yami.png");
    ImageIcon tonfin = new ImageIcon("D:\\Project\\tonfin.png");
    ImageIcon vageta = new ImageIcon("D:\\Project\\vageta.png");
    ImageIcon gut = new ImageIcon("D:\\Project\\gut.png");
    ImageIcon mushashi = new ImageIcon("D:\\Project\\musashi.png");
    ImageIcon logoutBtn = new ImageIcon("D:\\Project\\download.png");
    ImageIcon tableBtn = new ImageIcon("D:\\Project\\table.png");
    ImageIcon coachBtn = new ImageIcon("D:\\Project\\coach.png");
    ImageIcon memberBtn = new ImageIcon("D:\\Project\\member.png");
    ImageIcon main = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile1 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile2 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile3 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile4 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile5 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile6 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile7 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile8 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile9 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon profile10 = new ImageIcon("D:\\Project\\mainpage.png");
    ImageIcon scale = new ImageIcon(logoutBtn.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    ImageIcon tableScale = new ImageIcon(tableBtn.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
    ImageIcon coachScale = new ImageIcon(coachBtn.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
    ImageIcon memberScale = new ImageIcon(memberBtn.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
    // Label
    JLabel yamiLabel = new JLabel(new ImageIcon(yami.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    JLabel gutLabel = new JLabel(new ImageIcon(gut.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    JLabel tonfinLabel = new JLabel(new ImageIcon(tonfin.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    JLabel vagetaLabel = new JLabel(new ImageIcon(vageta.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    JLabel mushshiLabel = new JLabel(
            new ImageIcon(mushashi.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    JLabel welcome = new JLabel("Welcome Admin");
    // Panel
    JPanel bar = new JPanel();

    JPanel memberPanel;
    JPanel coachPanel;
    JPanel tablePanel = new JPanel();
    JPanel mainPanel;
    JPanel menu = new JPanel(new GridLayout(3, 1, 0, 20));

    // Fonts
    Font headFont = new Font("Cloud", Font.BOLD, 20);
    Font title = new Font("Comic Sans MS", Font.PLAIN, 13);
    Font big = new Font("Comic Sans MS", Font.PLAIN, 25);

    // Color
    Color gray = new Color(76, 100, 100);
    Color darkRed = new Color(187, 4, 42);
    Color nonBlack = new Color(21, 8, 10);
    Color pigRed = new Color(112, 13, 35);
    Color lightPink = new Color(222, 124, 148);
    Color lightColor = new Color(233, 196, 203);

    AdminPage() {
        // MemberList
        ArrayList<String> memberName = new ArrayList<String>();
        for (int i = 0; i < name.countMember(); i++) {
            memberName.add(name.getName(i));
        }
        String[] count = memberName.toArray(new String[0]);
        JList<String> memberList = new JList<>(count);
        // Store Value
        Collection<String> valu = value.values();
        String[] valueCount = new String[valu.size()];
        int index = 0;
        for (int i = 0; i < name.countMember(); i++) {
            valueCount[i] = name.getValue(i);
        }

        // Button
        member = new JButton(memberScale);
        member.setFont(title);
        table = new JButton(tableScale);
        table.setFont(title);
        coach = new JButton(coachScale);
        coach.setFont(title);
        logout = new JButton("Logout", scale);
        logout.setFocusable(false);
        logout.setFont(headFont);
        logout.setBounds(933, 0, 50, 50);
        nameBox = new JComboBox<>(count);
        //
        bar.setBounds(0, 0, 1000, 50);
        welcome.setFont(headFont);
        welcome.setForeground(Color.white);
        bar.add(welcome);
        bar.setBackground(lightPink);
        bar.setBackground(darkRed);
        // menu
        menu.add(member);
        menu.add(table);
        menu.add(coach);
        menu.setBounds(0, 50, 120, 515);
        menu.setBackground(new Color(201, 69, 90));
        // main panel
        mainPanel = new JPanel();
        JLabel mainLabel = new JLabel(main);
        mainPanel.add(mainLabel);
        mainPanel.setBackground(new Color(128, 0, 28));
        mainPanel.setBounds(120, 50, 1000, 1000);
        // panel member
        memberPanel = new JPanel();
        memberPanel.setBounds(120, 50, 1000, 1000);
        memberPanel.setBackground(new Color(201, 69, 90));
        member.addActionListener(this);
        memberPanel.setLayout(null);
        memList = new JScrollPane(memberList);
        // Show people data
        memberList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {

                }
            }
        });
        memberPanel.add(memList);
        memList.setBounds(90, 50, 300, 300);
        memberList.setPreferredSize(new Dimension(700, 300));
        memberList.setFont(title);
        // Table panel
        tablePanel = new JPanel();
        tablePanel.setBounds(120, 50, 1000, 1000);
        tablePanel.setBackground(new Color(201, 69, 90));
        table.addActionListener(this);
        tablePanel.setLayout(null);
        tablePanel.add(nameBox);
        // User Select
        JLabel userName = new JLabel("User");
        userName.setFont(big);
        userName.setForeground(Color.white);
        userName.setBounds(100, 20, 100, 60);
        tablePanel.add(userName);
        nameBox.setFont(headFont);
        nameBox.setBounds(50, 70, 150, 40);
        // Date input
        JLabel dateLabel = new JLabel("Date");
        date.setFont(headFont);
        date.setForeground(Color.white);
        date.setBounds(300, 70, 150, 40);
        date.setForeground(Color.black);
        dateLabel.setBounds(350, 20, 100, 60);
        dateLabel.setForeground(Color.white);
        dateLabel.setFont(big);

        tablePanel.add(dateLabel);
        tablePanel.add(date);

        // Type
        JLabel fitLabel = new JLabel("Fitness Class");
        fitLabel.setFont(big);
        fitLabel.setForeground(Color.white);
        fitLabel.setBounds(550, 20, 200, 60);
        fitClass.setBounds(550, 70, 150, 40);
        fitLabel.setFont(big);
        fitClass.setFont(headFont);

        tablePanel.add(fitLabel);
        tablePanel.add(fitClass);
        add = new JButton("Add");
        add.setFont(headFont);
        add.setBounds(50, 150, 150, 40);
        tablePanel.add(add);
        add.addActionListener(this);
        tablePanel.add(table2);
        table2.setVisible(true);
        table2.setBounds(300, 150, 500, 300);
        // Coach
        coachPanel = new JPanel();
        coachPanel.setBounds(120, 50, 1000, 1000);
        coachPanel.setBackground(new Color(201, 69, 90));
        coach.addActionListener(this);
        JLabel coachLabel = new JLabel();
        coachLabel.setPreferredSize(new Dimension(500, 500));
        coachLabel.setLayout(new GridLayout(3, 2, 10, 10));
        yamiLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String data = " Name : Yami \n Class: Weight Training \n Salary: " + baseSalary + " B";
                JOptionPane.showMessageDialog(yamiLabel, data);
            }
        });
        coachLabel.add(yamiLabel);
        gutLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String data = " Name : Gut \n Class: Power lifting \n Salary: 30,000 B";
                JOptionPane.showMessageDialog(gutLabel, data);
            }
        });
        coachLabel.add(gutLabel);
        tonfinLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String data = " Name : Tonfin \n Class: Calisthenics  \n Salary: 25,000 B";
                JOptionPane.showMessageDialog(tonfinLabel, data);
            }
        });
        coachLabel.add(tonfinLabel);
        vagetaLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String data = " Name : Vageta\n Class: Calisthenics  \n Salary: 25,000 B";
                JOptionPane.showMessageDialog(vagetaLabel, data);
            }
        });
        coachLabel.add(vagetaLabel);
        mushshiLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String data = " Name : Mushashi  \n Class: Meditate & CQC \n Salary: 50,000 B";
                JOptionPane.showMessageDialog(mushshiLabel, data);
            }
        });
        coachLabel.add(mushshiLabel);
        coachPanel.add(coachLabel, BorderLayout.CENTER);
        // frame
        setTitle("Gym Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000, 600);
        setLocation(200, 200);
        setResizable(false);
        add(mainPanel);
        add(memberPanel);
        memberPanel.setVisible(false);
        add(tablePanel);
        tablePanel.setVisible(false);
        add(coachPanel);
        add(logout);
        add(bar);
        add(menu);
        logout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            setVisible(false);
            Login mainPage = new Login(adAc.getAdmin());
            System.out.println("It back");
        }
        if (e.getSource() == member) {
            System.out.println("Member");
            mainPanel.setVisible(false);
            memberPanel.setVisible(true);
            tablePanel.setVisible(false);
            coachPanel.setVisible(false);
        }
        if (e.getSource() == table) {
            System.out.println("Table");
            mainPanel.setVisible(false);
            memberPanel.setVisible(false);
            tablePanel.setVisible(true);
            coachPanel.setVisible(false);
        }
        if (e.getSource() == coach) {
            System.out.println("Coach");
            mainPanel.setVisible(false);
            memberPanel.setVisible(false);
            tablePanel.setVisible(false);
            coachPanel.setVisible(true);
        }
        if (e.getSource() == add) {
            if (date.getText().isEmpty() || fitClass.getText().isEmpty()) {
                System.out.println("error");
                JOptionPane.showMessageDialog(this, "Please Enter All Data");
            } else {
                model.addRow(new Object[] { nameBox.getSelectedItem(), date.getText(), fitClass.getText() });
                table2.setModel(model);
                table2.repaint();
                JOptionPane.showMessageDialog(this, "Add Data Complete");
                user.setText("");
                date.setText("");
                fitClass.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new AdminPage();
    }
}
