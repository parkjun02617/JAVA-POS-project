package chickenpos;

import java.io.IOException;

public class MainProcess{
    LoginView loginView;
    POS testFrm;
   
    public static void main(String[] args) throws IOException {
        MainProcess main = new MainProcess();
        main.loginView = new LoginView(); // �α���â ���̱�
        main.loginView.setMain(main); // �α���â���� ���� Ŭ����������
    }
   
    // �׽�Ʈ������â
    public void showFrameTest(){
        loginView.dispose(); // �α���â�ݱ�
        this.testFrm = new POS();
    }
 
}