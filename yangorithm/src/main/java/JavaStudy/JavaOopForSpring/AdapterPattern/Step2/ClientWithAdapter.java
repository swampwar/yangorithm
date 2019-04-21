package JavaStudy.JavaOopForSpring.AdapterPattern.Step2;

public class ClientWithAdapter {

	public static void main(String[] args) {
		
		AdapterServiceA asa = new AdapterServiceA();
		AdapterServiceB asb = new AdapterServiceB();
		
		asa.runService(); // �޼������ ����
		asb.runService();
		
		/* 
		 * Service ��ü�� ���� �����ؼ� ȣ���ϴ� ���� �ƴ϶�,
		 * �߰��� Service ��ü�� �Ӽ����� �ξ� �����ϴ� ����͸� ����� ȣ���ϴ� ����
		 */
	}

}
