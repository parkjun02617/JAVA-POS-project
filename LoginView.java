package chickenpos;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


 
public class LoginView extends JFrame{
    private MainProcess main;
    private JButton btnLogin;
    private JButton btnInit;
    private JPasswordField passText;
    private JTextField userText;
    private boolean bLoginCheck;
   
    public static void main(String[] args) {
        //new LoginView();
    }
 
    @SuppressWarnings("resource")
	public LoginView() throws IOException {
        // FileInput
    	Scanner sc = new Scanner(System.in);
    	Scanner ss = new Scanner(System.in);
    	System.out.print("--------------회원가입을 시작합니다--------------\n ID를 입력하세요:");
    	String id=sc.nextLine();
    	
    	System.out.print("비밀번호를 입력하세요:");
    	String pw=ss.nextLine();
    	
    	BufferedOutputStream bs = null;
    	try {
    		bs = new BufferedOutputStream(new FileOutputStream("id_Output.txt"));
    		bs.write(id.getBytes());
    	}catch(Exception e) {
    		e.getStackTrace();
    	}finally {
    		bs.close();
    	}
    	
    	BufferedOutputStream be = null;
    	try {
    		be = new BufferedOutputStream(new FileOutputStream("pw_Output.txt"));
    		be.write(pw.getBytes());
    	}catch(Exception e) {
    		e.getStackTrace();
    	}finally {
    		be.close();
    	}
    	// setting
    	setTitle("로그인");
        setSize(560, 200);
        setResizable(false);
        setLocation(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        // panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
       
       
        // add
        add(panel);
       
        setVisible(true);
      
		
    }
   
    public void placeLoginPanel(JPanel panel){
        panel.setLayout(null);     
        JLabel userLabel = new JLabel("사용자 ID");
        userLabel.setBounds(40, 30, 80, 25);
        panel.add(userLabel);
       
        JLabel passLabel = new JLabel("비밀번호");
        passLabel.setBounds(40, 60, 80, 25);
        panel.add(passLabel);
       
        userText = new JTextField(20);
        userText.setBounds(150, 30, 320, 25);
        panel.add(userText);
       
        passText = new JPasswordField(20);
        passText.setBounds(150, 60, 320, 25);
        panel.add(passText);
        passText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					isLoginCheck();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}        
            }
        });
       
        btnInit = new JButton("Reset");
        btnInit.setBounds(40, 120, 200, 25);
        panel.add(btnInit);
        btnInit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.setText("");
                passText.setText("");
            }
        });
       
        btnLogin = new JButton("Login");
        btnLogin.setBounds(260, 120, 200, 25);
        panel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					isLoginCheck();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
   
    public void isLoginCheck() throws IOException{
    		try {
    			FileInputStream file= null;
    			
    			file = new FileInputStream("id_Output.txt");
    			byte[] readBuffer_1 = new byte[file.available()];
    			while(file.read(readBuffer_1)!=-1) {}
    			String id = new String(readBuffer_1);
    			file.close();
    			
    			file = new FileInputStream("pw_Output.txt");
    			byte[] readBuffer_11 = new byte[file.available()];
    			while(file.read(readBuffer_11)!=-1) {}
    			String pw = new String(readBuffer_11);
    			file.close();
    		
    			if(userText.getText().equals(id) && 
                		new String(passText.getPassword()).equals(pw)){
                    JOptionPane.showMessageDialog(null, "안녕하십니까 관리자님, POS 프로그램을 실행합니다.");
                    bLoginCheck = true;
                   
                    // 로그인 성공이라면 매니져창 뛰우기
                    if(isLogin()){
                        main.showFrameTest(); // 메인창 메소드를 이용해 창뛰우기
                    }                  
                }else{
                    JOptionPane.showMessageDialog(null, "Faild");
                }
    			

    			
    		}catch(Exception e) {
    			e.getStackTrace();
    		}
    	}

	// mainProcess와 연동
    public void setMain(MainProcess main) {
        this.main = main;
    }
   
    public boolean isLogin() {     
        return bLoginCheck;
    }
 
}


