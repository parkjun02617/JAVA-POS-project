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

    int count[]= {0,0,0,0,0,0,0,0,0,0,0,0}; // 메뉴 개별 카운트 생성 --> 중복방지
    int result[] = {0,0,0,0,0,0,0,0,0,0,0,0}; //메뉴 마다의 총가격
    int total = 0; //메뉴 마다의 총가격을 합산
        

    String show = "";

 

    POS() {
        // 프레임만들기
        JFrame frame = new JFrame("KNU치킨"); //프레임 이름

        frame.setBounds(0, 0, 720, 1050); // 프레임 크기

        frame.setBackground(Color.gray); //프레임 배경색


        // 폰트

        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 24);


        // 북쪽 프레임 하나 만듬 (치킨메뉴)

        Panel pNORTH = new Panel();

        pNORTH.setBackground(new Color(250, 230, 215));

        pNORTH.setLayout(null);

        pNORTH.setSize(0, 500);

        pNORTH.setFont(font);

       

        // 치킨메뉴 설정 부분

        String menu[] = {"후라이드","양념치킨","골드치즈","매운양념","와락치킨","반반치킨","와락날개","핫슈프림","훈제치킨","감자튀김","음료추가","주류추가"}; // 치킨종류 입력

        int price[] = { 16000, 17000, 17000, 17000, 19000, 17000, 18000, 18000, 17000, 5000, 2000, 4000 }; // 가격입력

        JButton button[] = new JButton[menu.length]; // 메뉴갯수에 따른 버튼생성

        TextField zero[] = new TextField[menu.length]; // 초기 0개 주문

        Button minus[] = new Button[menu.length]; //마이너스버튼추가

        Button plus[] = new Button[menu.length]; //플러스버튼추가

        JButton ok[] = new JButton[menu.length]; //ok 버튼 추가

        Label l[] = new Label[menu.length];

        ImageIcon icon[] = new ImageIcon[menu.length];
        
        // 아이콘마다 이미지 삽입
        
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
       
        
        
        


        // 치킨메뉴 버튼 설정 부분

        for (int i = 0; i < menu.length; i++) {	 
        	// 치킨 버튼

            button[i] = new JButton(menu[i]);
            button[i].setIcon(icon[i]);


            if (i < 6) {

               button[i].setBounds(10 + i * 100, 50, 100, 100); // 치킨메뉴 첫줄 6개메뉴 위치조정

               }

            else {

               button[i].setBounds(10 + (i - 6) * 100, 250, 100, 100); // 치킨메뉴 두번째줄 나머지 6개메뉴 위치조정

           }
           
           

          

 

            // 수량 표시칸

            zero[i] = new TextField("  0"); // 주문안할시 초기값 0

            zero[i].setBackground(Color.white); // 배경색

            zero[i].setEditable(false); 

            zero[i].setBounds(button[i].getX() + 30, button[i].getY() + 130, 40, 20); // 버튼 위치조정

 

            // "-" 버튼

            minus[i] = new Button("-");

            minus[i].setBounds(button[i].getX() +5, zero[i].getY(), 20, 20);

            minus[i].setEnabled(true);

            

 

            // "+" 버튼

            plus[i] = new Button("+");

            plus[i].setBounds(button[i].getX() + (100 - 25), zero[i].getY(), 20, 20);

            plus[i].setEnabled(true);

 

            // 가격

            l[i] = new Label(price[i] + "원");

            l[i].setBounds(button[i].getX() + 20, zero[i].getY() - 25, 100, 20);

 

            // 확인 버튼

            ok[i] = new JButton("확인");

            ok[i].setBounds(button[i].getX(), zero[i].getY() + 30, 100, 30);

            ok[i].setEnabled(false);

 

            // 위치값정한 버튼 생성

            pNORTH.add(button[i]);

            pNORTH.add(zero[i]);

            pNORTH.add(minus[i]);

            pNORTH.add(plus[i]);

            pNORTH.add(l[i]);

            pNORTH.add(ok[i]);

        }

 

        // 중앙에 만들 입력창

        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);

        ta.setText("--------------------------------------------------\n      주문        가격        수량        합계\n--------------------------------------------------");
       
        ta.setBackground(Color.PINK);

        ta.setEditable(false);

        ta.setFont(font1);

 

        // 남쪽에 만들 버튼

        Panel pSouth = new Panel();

        pSouth.setFont(font);

        pSouth.setBackground(new Color(250, 200, 215));

        Button bt1 = new Button("주문확인");

        Button bt2 = new Button("초기화");

        Button bt3 = new Button("주문취소");

        pSouth.add(bt1);

        pSouth.add(bt2);

        pSouth.add(bt3);

        

        

              

        // 주문확인버튼 클릭시

        bt1.addActionListener(new ActionListener() {

           

           

            @Override

            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "총가격은 "+total+"원 입니다. \n이용해주셔서 감사합니다."); //총가격 표시해야함 !!!

                for (int i = 0; i < menu.length; i++) {

                   button[i].setEnabled(true);

                    minus[i].setEnabled(true);

                    plus[i].setEnabled(true);

                    zero[i].setText("0");

                    ta.setText("   상품명        가격        수량        합계\n");
                    count[i]=0;
                    

 
                   result[i]=0;
                }
                total = 0;

            }

        });

 

        // 초기화버튼 클리시

        bt2.addActionListener(new ActionListener() {

 

            @Override

            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < menu.length; i++) {

                   button[i].setEnabled(true);

                    minus[i].setEnabled(false);

                    plus[i].setEnabled(false);

                    zero[i].setText("0");

                    ta.setText("   상품명        단가        수량        합계\n");

 

                }

            }

        });

 

 

        //bt3 주문취소버튼 클릭시

        

        bt3.addActionListener(new ActionListener() {

            

            @Override

            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });

 

        // 컴포넌트

        frame.add(pNORTH, BorderLayout.NORTH);

        frame.add(ta, BorderLayout.CENTER);

        frame.add(pSouth, BorderLayout.SOUTH);

        frame.setVisible(true);

 

        // 이벤트단

        for (int i = 0; i < menu.length; i++) {

            int j = i;

 

            // 치킨 버튼 이벤트

            button[i].addActionListener(new ActionListener() {

                @Override

                public void actionPerformed(ActionEvent e) {

                    minus[j].setEnabled(true); // 버튼을 누르지 않고 마이너스 버튼 클릭 가능

                    plus[j].setEnabled(true); // 버튼을 누르지 않고 플러스 버튼 클릭 가능

                    button[j].setEnabled(true);

                    ok[j].setEnabled(true);
                    
                    show = button[j].getActionCommand();
                    count[j]+=1; //이미지 클릭시 카운트 하나씩 추가
                    
                  

                    
                    zero[j].setText(count[j] + ""); // 가운데 수량 표시
                    ok[j].setEnabled(true);

                }

            });

 

            // "-" 버튼 이벤트생성

            minus[i].addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                	

                        count[j]-=1; // 마이너스 버튼 클릭시 카운트 하나씩 다운
                       
                        zero[j].setText(count[j] + "");
                        ok[j].setEnabled(true);

                    
                    }

                }

            );

            

            // "+" 버튼 이벤트생성

            plus[i].addActionListener(new ActionListener() {

 

                @Override

                public void actionPerformed(ActionEvent e) {

                    count[j] += 1; // 플러스 버튼 클릭시 카운트 하나씩 증가
                   

                    zero[j].setText(count[j] + "");
                    ok[j].setEnabled(true);

                    if (count[j] > 0) {

                        minus[j].setEnabled(true);

                    }

                }

            });

            

            // "확인" 버튼 이벤트생성
            ok[i].addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {

                    show = button[j].getActionCommand();
                    
                    // 수량>=0 일시 "+수량"으로 표시.
                    if(count[j]>=0) {
                    if(j>=9){
                    ta.append("\n    " + show + "     "+"  " + price[j] +   "        "+"+" + count[j] + "         "+"+" + price[j] * count[j] + "원" + "");
                    }                    
                    else {
                    ta.append("\n    " + show + "      " + price[j] + "        " +"+" + count[j] + "         "+"+" + price[j] * count[j] + "원" + "");
                    }
                    }
                    
                    // 수량<0 일시 "-수량"으로 표시
                    else {
                    if(j>=9){
                    ta.append("\n    " + show + "     "+"  " + price[j] +   "        " + count[j] + "         " + price[j] * count[j] + "원" + "");
                    }                    
                    else {
                    ta.append("\n    " + show + "      " + price[j] + "        "  + count[j] + "         " + price[j] * count[j] + "원" + "");
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

 

        // 종료

        frame.addWindowListener(new WindowAdapter() {

            @Override

            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        });
    }
}