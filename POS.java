package chickenpos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
public class POS extends JFrame {

    int count[]= {0,0,0,0,0,0,0,0,0,0,0,0}; // �޴� ���� ī��Ʈ ���� --> �ߺ�����
    int result[] = {0,0,0,0,0,0,0,0,0,0,0,0}; //�޴� ������ �Ѱ���
    int total = 0; //�޴� ������ �Ѱ����� �ջ�
        

    String show = "";

 

    POS() {
        // �����Ӹ����
        JFrame frame = new JFrame("KNUġŲ"); //������ �̸�

        frame.setBounds(0, 0, 720, 1050); // ������ ũ��

        frame.setBackground(Color.gray); //������ ����


        // ��Ʈ

        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 24);


        // ���� ������ �ϳ� ���� (ġŲ�޴�)

        Panel pNORTH = new Panel();

        pNORTH.setBackground(new Color(250, 230, 215));

        pNORTH.setLayout(null);

        pNORTH.setSize(0, 500);

        pNORTH.setFont(font);

       

        // ġŲ�޴� ���� �κ�

        String menu[] = {"�Ķ��̵�","���ġŲ","���ġ��","�ſ���","�Ͷ�ġŲ","�ݹ�ġŲ","�Ͷ�����","�ֽ�����","����ġŲ","����Ƣ��","�����߰�","�ַ��߰�"}; // ġŲ���� �Է�

        int price[] = { 16000, 17000, 17000, 17000, 19000, 17000, 18000, 18000, 17000, 5000, 2000, 4000 }; // �����Է�

        JButton button[] = new JButton[menu.length]; // �޴������� ���� ��ư����

        TextField zero[] = new TextField[menu.length]; // �ʱ� 0�� �ֹ�

        Button minus[] = new Button[menu.length]; //���̳ʽ���ư�߰�

        Button plus[] = new Button[menu.length]; //�÷�����ư�߰�

        JButton ok[] = new JButton[menu.length]; //ok ��ư �߰�

        Label l[] = new Label[menu.length];

        ImageIcon icon[] = new ImageIcon[menu.length];
        
        // �����ܸ��� �̹��� ����
        
        icon[0] = new ImageIcon("huride.png");
        icon[1] = new ImageIcon("yangnyum.png"); 
        icon[2] = new ImageIcon("white.png"); 
        icon[3] = new ImageIcon("spiceyangnyum.png"); 
        icon[4] = new ImageIcon("warak.png"); 
        icon[5] = new ImageIcon("banban.png"); 
        icon[6] = new ImageIcon("warakwing.png"); 
        icon[7] = new ImageIcon("supreme.png"); 
        icon[8] = new ImageIcon("hoonjae.png"); 
        icon[9] = new ImageIcon("potato.png"); 
        icon[10] = new ImageIcon("juice.png"); 
        icon[11] = new ImageIcon("soju.png"); 
       
        
        
        


        // ġŲ�޴� ��ư ���� �κ�

        for (int i = 0; i < menu.length; i++) {	 
        	// ġŲ ��ư

            button[i] = new JButton(menu[i]);
            button[i].setIcon(icon[i]);


            if (i < 6) {

               button[i].setBounds(10 + i * 100, 50, 100, 100); // ġŲ�޴� ù�� 6���޴� ��ġ����

               }

            else {

               button[i].setBounds(10 + (i - 6) * 100, 250, 100, 100); // ġŲ�޴� �ι�°�� ������ 6���޴� ��ġ����

           }
           
           

          

 

            // ���� ǥ��ĭ

            zero[i] = new TextField("  0"); // �ֹ����ҽ� �ʱⰪ 0

            zero[i].setBackground(Color.white); // ����

            zero[i].setEditable(false); 

            zero[i].setBounds(button[i].getX() + 30, button[i].getY() + 130, 40, 20); // ��ư ��ġ����

 

            // "-" ��ư

            minus[i] = new Button("-");

            minus[i].setBounds(button[i].getX() +5, zero[i].getY(), 20, 20);

            minus[i].setEnabled(true);

            

 

            // "+" ��ư

            plus[i] = new Button("+");

            plus[i].setBounds(button[i].getX() + (100 - 25), zero[i].getY(), 20, 20);

            plus[i].setEnabled(true);

 

            // ����

            l[i] = new Label(price[i] + "��");

            l[i].setBounds(button[i].getX() + 20, zero[i].getY() - 25, 100, 20);

 

            // Ȯ�� ��ư

            ok[i] = new JButton("Ȯ��");

            ok[i].setBounds(button[i].getX(), zero[i].getY() + 30, 100, 30);

            ok[i].setEnabled(false);

 

            // ��ġ������ ��ư ����

            pNORTH.add(button[i]);

            pNORTH.add(zero[i]);

            pNORTH.add(minus[i]);

            pNORTH.add(plus[i]);

            pNORTH.add(l[i]);

            pNORTH.add(ok[i]);

        }

 

        // �߾ӿ� ���� �Է�â

        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);

        ta.setText("--------------------------------------------------\n      �ֹ�        ����        ����        �հ�\n--------------------------------------------------");
       
        ta.setBackground(Color.PINK);

        ta.setEditable(false);

        ta.setFont(font1);

 

        // ���ʿ� ���� ��ư

        Panel pSouth = new Panel();

        pSouth.setFont(font);

        pSouth.setBackground(new Color(250, 200, 215));

        Button bt1 = new Button("�ֹ�Ȯ��");

        Button bt2 = new Button("�ʱ�ȭ");

        Button bt3 = new Button("�ֹ����");

        pSouth.add(bt1);

        pSouth.add(bt2);

        pSouth.add(bt3);

        

        

              

        // �ֹ�Ȯ�ι�ư Ŭ����

        bt1.addActionListener(new ActionListener() {

           

           

            @Override

            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "�Ѱ����� "+total+"�� �Դϴ�. \n�̿����ּż� �����մϴ�."); //�Ѱ��� ǥ���ؾ��� !!!

                for (int i = 0; i < menu.length; i++) {

                   button[i].setEnabled(true);

                    minus[i].setEnabled(true);

                    plus[i].setEnabled(true);

                    zero[i].setText("0");

                    ta.setText("   ��ǰ��        ����        ����        �հ�\n");
                    count[i]=0;
                    

 
                   result[i]=0;
                }
                total = 0;

            }

        });

 

        // �ʱ�ȭ��ư Ŭ����

        bt2.addActionListener(new ActionListener() {

 

            @Override

            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < menu.length; i++) {

                   button[i].setEnabled(true);

                    minus[i].setEnabled(false);

                    plus[i].setEnabled(false);

                    zero[i].setText("0");

                    ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n");

 

                }

            }

        });

 

 

        //bt3 �ֹ���ҹ�ư Ŭ����

        

        bt3.addActionListener(new ActionListener() {

            

            @Override

            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });

 

        // ������Ʈ

        frame.add(pNORTH, BorderLayout.NORTH);

        frame.add(ta, BorderLayout.CENTER);

        frame.add(pSouth, BorderLayout.SOUTH);

        frame.setVisible(true);

 

        // �̺�Ʈ��

        for (int i = 0; i < menu.length; i++) {

            int j = i;

 

            // ġŲ ��ư �̺�Ʈ

            button[i].addActionListener(new ActionListener() {

                @Override

                public void actionPerformed(ActionEvent e) {

                    minus[j].setEnabled(true); // ��ư�� ������ �ʰ� ���̳ʽ� ��ư Ŭ�� ����

                    plus[j].setEnabled(true); // ��ư�� ������ �ʰ� �÷��� ��ư Ŭ�� ����

                    button[j].setEnabled(true);

                    ok[j].setEnabled(true);
                    
                    show = button[j].getActionCommand();
                    count[j]+=1; //�̹��� Ŭ���� ī��Ʈ �ϳ��� �߰�
                    
                  

                    
                    zero[j].setText(count[j] + ""); // ��� ���� ǥ��
                    ok[j].setEnabled(true);

                }

            });

 

            // "-" ��ư �̺�Ʈ����

            minus[i].addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                	

                        count[j]-=1; // ���̳ʽ� ��ư Ŭ���� ī��Ʈ �ϳ��� �ٿ�
                       
                        zero[j].setText(count[j] + "");
                        ok[j].setEnabled(true);

                    
                    }

                }

            );

            

            // "+" ��ư �̺�Ʈ����

            plus[i].addActionListener(new ActionListener() {

 

                @Override

                public void actionPerformed(ActionEvent e) {

                    count[j] += 1; // �÷��� ��ư Ŭ���� ī��Ʈ �ϳ��� ����
                   

                    zero[j].setText(count[j] + "");
                    ok[j].setEnabled(true);

                    if (count[j] > 0) {

                        minus[j].setEnabled(true);

                    }

                }

            });

            

            // "Ȯ��" ��ư �̺�Ʈ����
            ok[i].addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {

                    show = button[j].getActionCommand();
                    
                    // ����>=0 �Ͻ� "+����"���� ǥ��.
                    if(count[j]>=0) {
                    if(j>=9){
                    ta.append("\n    " + show + "     "+"  " + price[j] +   "        "+"+" + count[j] + "         "+"+" + price[j] * count[j] + "��" + "");
                    }                    
                    else {
                    ta.append("\n    " + show + "      " + price[j] + "        " +"+" + count[j] + "         "+"+" + price[j] * count[j] + "��" + "");
                    }
                    }
                    
                    // ����<0 �Ͻ� "-����"���� ǥ��
                    else {
                    if(j>=9){
                    ta.append("\n    " + show + "     "+"  " + price[j] +   "        " + count[j] + "         " + price[j] * count[j] + "��" + "");
                    }                    
                    else {
                    ta.append("\n    " + show + "      " + price[j] + "        "  + count[j] + "         " + price[j] * count[j] + "��" + "");
                    }
                    }

                    result[j]=price[j]*count[j];
                    ok[j].setEnabled(false);
                    count[j] = 0;
                    zero[j].setText(count[j] + "");
                   total+=result[j];

                }

            });

 

        }

 

        // ����

        frame.addWindowListener(new WindowAdapter() {

            @Override

            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        });
    }
}