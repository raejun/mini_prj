package Mini_BasketballDB;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bk_mainPanel extends JPanel {
	// 1) ��ü ���� 
	JTextField tfPlayer, tfP3p, tfP2p, tfFtp, tfTrb, tfAst, tfStl, tfBlk, tfTov, tfPts, tfPsal;
	JPanel pSeason;
	JComboBox cbSeason; // Ŭ���� ���� ī�װ��� �Ʒ��������� Ȯ��Ǵ� ��ư
	
	// 2) ������
	public Bk_mainPanel () {
		setLayout(new GridLayout(12,2, 5, 5)); //���̾ƿ� ����  GridLayout(����,����, �¿� ���� , ���� ����)

	// 3) panel�� field  ����	
		// ���� �Է� ����
		tfPlayer = new JTextField();
		pSeason = new JPanel();
		String[] arrSeason = {"2013/2014"
							,"2014/2015"
							,"2015/2016"
							,"2016/2017"
							,"2017/2018"
							,"2018/2019"};
		cbSeason = new JComboBox(arrSeason);
		pSeason.add(cbSeason);
		tfP3p = new JTextField();
		tfP2p = new JTextField();
		tfFtp = new JTextField();
		tfTrb = new JTextField();
		tfAst = new JTextField();
		tfStl = new JTextField();
		tfBlk = new JTextField();
		tfTov = new JTextField();
		tfPts = new JTextField();
		tfPsal = new JTextField();
		
	// 4) ���̱� 
		add(new JLabel("������")); // Bk_mainPanel�� �����ڳ����� ���̱⿡ ���̴� ��� ���� ����
		add(tfPlayer);
		add(new JLabel("����"));
		add(pSeason);
		add(new JLabel("3�� ������"));
		add(tfP3p);
		add(new JLabel("2�� ������"));
		add(tfP2p);
		add(new JLabel("������ ������"));
		add(tfFtp);
		add(new JLabel("���ٿ��"));
		add(tfTrb);
		add(new JLabel("��ý�Ʈ"));
		add(tfAst);
		add(new JLabel("��ƿ"));
		add(tfStl);
		add(new JLabel("���"));
		add(tfBlk);
		add(new JLabel("�Ͽ���"));
		add(tfTov);
		add(new JLabel("��� ����"));
		add(tfPts);
		add(new JLabel("����"));
		add(tfPsal);
	}//������
}//end


