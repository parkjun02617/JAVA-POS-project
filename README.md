
# java - 포스기 구성

1. 구성

MainProcess와 LoginView, POS로 나누었고 MainProcess 실행 시 나머지 클래스들이 실행된다.

![로그인 화면](https://user-images.githubusercontent.com/58385126/69912275-48482d00-146a-11ea-881a-d4a5ad3fb777.png)

-> 처음 실행 시 화면. 
public void isLoginCheck(){
        if(userText.getText().equals("admin") && 
        		new String(passText.getPassword()).equals("admin")) 
 아이디와 비밀번호를 admin으로 설정하였으며 동일할 경우 로그인 성공 화면과 함께 로그인이 된다.

![로그인 성공](https://user-images.githubusercontent.com/58385126/69912276-48482d00-146a-11ea-8ad1-b3c91145ba53.png)

-> 로그인 성공 시

 JOptionPane.showMessageDialog(null, "안녕하십니까 관리자님, POS 프로그램을 실행합니다.");
            bLoginCheck = true;
           
            // 로그인 성공이라면 매니져창 뛰우기

![치킨포스기](https://user-images.githubusercontent.com/58385126/69912274-47af9680-146a-11ea-9de8-32d08dbe2119.png)

로그인 성공 후에 나오는 치킨 포스기의 화면이다.

-,+를 누를 경우 각각의 수량이 하나씩 위, 아래로 카운트가 되며 확인을 누를시 메뉴의 가격과 수량을 곱하여 합계가 표시된다.

여러 메뉴를 누른 후에 마지막으로 주문확인을 누를 경우 총 가격이 표시가 되게끔 설정을 해놓았다.

초기화를 누를 시 현재까지 주문했던 목록들이 모두 취소가 되며, 주문취소를 누르면 자동적으로 로그아웃과 함께 프로그램이 종료가 된다.
