package Chaoshi;
import java.awt.*;
import java.awt.event.*;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.*;

@SuppressWarnings("serial")
public class chaoshi extends JFrame implements ActionListener {
	//-------------�����½�������-------------
	private JTextField t1=new JTextField(12);
	private JPasswordField t2=new JPasswordField(12); // ���������NS, Xu��
	private JButton jbt=new JButton("��¼");
	private JLabel lab1=new JLabel("�û���");
	private JLabel lab2=new JLabel("����");
	private JLabel lab3=new JLabel("��ӭʹ�ó��й���ϵͳ");
	
	User user;
	
	Success sbj=new Success(this,"��½�ɹ�",true);   //��������ʼ����½�ɹ�����
	
	
	private chaoshi(String title)          //���췽��
	{
		super(title);
		getContentPane().setLayout(new FlowLayout());      //�������ݸ�Ϊ��ʽ����
		//------------�������ӵ���½��������ݸ�------------
		getContentPane().add(lab1);
		getContentPane().add(t1);
		getContentPane().add(lab2);
		getContentPane().add(t2);
		getContentPane().add(jbt);
		getContentPane().add(lab3);
		
		jbt.addActionListener(this);            //ʵ�ֵ�¼��ť�ļ���
		
		user=new User("123456","123456",10000,10000,10000);    //����ʵ�����û�����user������
		                                           //�û�������ʼ����ʹ��
	}
	
	
	public void actionPerformed(ActionEvent e)  //���嶯���¼�
	{
		
		String x,y,u,p;
		x=t1.getText();
		y=t2.getText();
		u=user.getUsername();
		p=user.getPassword();
        if(x.equals(u)&&y.equals(p))            //ʵ�ֵ�¼����
        {
        	sbj.setVisible(true);
        	t1.setText("");
        	t2.setText("");
        }
        else
        {
        	JOptionPane.showMessageDialog(this,"�������","ERROR",
     		JOptionPane.INFORMATION_MESSAGE);     
        }
		
	}
	
	public static void main(String[] args)   //main����
	{
		chaoshi frame=new chaoshi("��¼");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(210,170);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

	
	
    class Success extends JDialog implements ActionListener //�����¼�ɹ�����
    {
    	//-------------�����½�������-------------
    	private JPanel jp1=new JPanel();
    	
    	JButton jbt2=new JButton("��ѯ�ֿ�����");
    	JButton jbt3=new JButton("ȡ������");
    	JButton jbt4=new JButton("��������");
    	JButton jbt6=new JButton("��ȫ�˳�");
    	private JLabel labc=new JLabel("�������ͣ�1.ƻ��    2.�����    3.�㽶               ");
    	private JLabel labd=new JLabel("   ��Ʒ��ţ�      ");
    	private JLabel laba=new JLabel("    �����:");
    	private JLabel labb=new JLabel("      ������:");
    
    	JTextField re1=new JTextField(8);
    	JTextField re2=new JTextField(8);
    	JTextField re3=new JTextField(8);
    	JTextArea show=new JTextArea(6,12);
    	
    	public Success(Frame parent,String title,boolean modal)
    	{
    		super(parent,title,modal);
    		setSize(560,280);
    		setLocationRelativeTo(null);
    		setResizable(false);
    		
    		
    		show.setEditable(false);                    //�����ı���show���ɱ༭
			getContentPane().setLayout(new BorderLayout());
			jp1.setLayout(new FlowLayout());            //�������jp1Ϊ��ʽ����
			getContentPane().add(jbt2,BorderLayout.NORTH);
			jp1.add(labc);
			jp1.add(labd);
			jp1.add(re3);
			jp1.add(laba);
			jp1.add(re1);
            jp1.add(jbt3);
			jp1.add(labb);
			jp1.add(re2);
			jp1.add(jbt4);
    		jp1.add(show);
    		jp1.add(jbt6);
    		getContentPane().add(jp1,BorderLayout.CENTER);
    	
    		//-----------ʵ�ָ�����ť�ļ���-----------
    		jbt2.addActionListener(this);
    		jbt3.addActionListener(this);
    		jbt4.addActionListener(this);
    		jbt6.addActionListener(this);
    		
    		
    	}
    	
    	public void actionPerformed(ActionEvent e)
    	{   
    		int numb,temp;
    		int app,qiyi,ban;
			if(e.getSource()==jbt2)                 //ʵ�ֲֿ�����
    		{
    			app=user.getApp();
    			qiyi=user.getQiyi();
    			ban=user.getBan();
    			show.setText("ƻ��:"+app+"��\n"+
    			             "�����:"+qiyi+"��\n"+
    			             "�㽶:"+ban+"��");
    		}
    		else if(e.getSource()==jbt3)            //ʵ�����
    			{   
    			numb=Integer.parseInt(re3.getText());
    			temp=Integer.parseInt(re1.getText());	
    	    	if(numb==1){
    	    		app=user.getApp();
    				if(app>=0){
    				    temp=Integer.parseInt(re1.getText());
    				    user.setApp(user.getApp()-temp);
    				    app=user.getApp();
                        show.setText("�����ɹ�  �ֿ�����:ƻ�� "+app+"��");
        			    re1.setText("");
        			}
        		    if(app<0){
        		    	show.setText("�ֿ��治�㣬�����������");
        		    	user.setApp(user.getApp()+temp);
        		    }
    			}
    			else if(numb==2){
    				qiyi=user.getQiyi();
    			    if(qiyi>=0){
    				    temp=Integer.parseInt(re1.getText());
    				    user.setQiyi(user.getQiyi()-temp);
    				    qiyi=user.getQiyi();
    				    show.setText("�����ɹ�  �ֿ�����:����� "+qiyi+"��");
        			    re1.setText("");
        			}
    			    if(qiyi<0){
    			    	show.setText("�ֿ��治�㣬�����������");
        		    	user.setQiyi(user.getQiyi()+temp);
    			    }
    			}
    			else if(numb==3){
    				ban=user.getBan();
    				if(ban>=0){
    				    temp=Integer.parseInt(re1.getText());
    				    user.setBan(user.getBan()-temp);
    				    ban=user.getBan();
    				    show.setText("�����ɹ�  �ֿ�����:�㽶 "+ban+"��");
        			    re1.setText("");
        			}
    				if(ban<0){
     			    	show.setText("�ֿ��治�㣬�����������");
         		    	user.setBan(user.getBan()+temp);
     			    }
    		}
    			}
    		else if(e.getSource()==jbt4)            //ʵ�ֽ���    
        		{   numb=Integer.parseInt(re3.getText());
    			    if(numb==1){
        				
             		    temp=Integer.parseInt(re2.getText());
        				user.setApp(user.getApp()+temp);
        				app=user.getApp();
                        show.setText("�����ɹ�  �ֿ�����:Tƻ�� "+app+"��");
            			re2.setText("");
        			}
        			else if(numb==2){
        				
             		    temp=Integer.parseInt(re2.getText());
        				user.setQiyi(user.getQiyi()+temp);
        				qiyi=user.getQiyi();
        				show.setText("�����ɹ�  �ֿ�����:����� "+qiyi+"��");
            			re2.setText("");
        			}
        			else if(numb==3){
        				
             		    temp=Integer.parseInt(re2.getText());
        				user.setBan(user.getBan()+temp);
        				ban=user.getBan();
        				show.setText("�����ɹ�  �ֿ�����:�㽶 "+ban+"��");
            			re2.setText("");
        		}
        			}
    		else if(e.getSource()==jbt6)            //ʵ�ִ��ڵĹر�
    		{
    			re1.setText("");
    			re2.setText("");
    			show.setText("");
    			dispose();
    		}
    	}
    }

}