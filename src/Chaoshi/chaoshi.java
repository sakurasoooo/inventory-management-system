package Chaoshi;
import java.awt.*;
import java.awt.event.*;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.*;

@SuppressWarnings("serial")
public class chaoshi extends JFrame implements ActionListener {
	//-------------定义登陆界面组件-------------
	private JTextField t1=new JTextField(12);
	private JPasswordField t2=new JPasswordField(12); // 密码输入框（NS, Xu）
	private JButton jbt=new JButton("登录");
	private JLabel lab1=new JLabel("用户名");
	private JLabel lab2=new JLabel("密码");
	private JLabel lab3=new JLabel("欢迎使用超市管理系统");
	
	User user;
	
	Success sbj=new Success(this,"登陆成功",true);   //声明并初始化登陆成功窗口
	
	
	private chaoshi(String title)          //构造方法
	{
		super(title);
		getContentPane().setLayout(new FlowLayout());      //设置内容格窗为流式布局
		//------------将组件添加到登陆界面的内容格窗------------
		getContentPane().add(lab1);
		getContentPane().add(t1);
		getContentPane().add(lab2);
		getContentPane().add(t2);
		getContentPane().add(jbt);
		getContentPane().add(lab3);
		
		jbt.addActionListener(this);            //实现登录按钮的监听
		
		user=new User("123456","123456",10000,10000,10000);    //声明实例化用户对象user，设置
		                                           //用户名、初始密码和存款
	}
	
	
	public void actionPerformed(ActionEvent e)  //定义动作事件
	{
		
		String x,y,u,p;
		x=t1.getText();
		y=t2.getText();
		u=user.getUsername();
		p=user.getPassword();
        if(x.equals(u)&&y.equals(p))            //实现登录方法
        {
        	sbj.setVisible(true);
        	t1.setText("");
        	t2.setText("");
        }
        else
        {
        	JOptionPane.showMessageDialog(this,"密码错误","ERROR",
     		JOptionPane.INFORMATION_MESSAGE);     
        }
		
	}
	
	public static void main(String[] args)   //main函数
	{
		chaoshi frame=new chaoshi("登录");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(210,170);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

	
	
    class Success extends JDialog implements ActionListener //定义登录成功界面
    {
    	//-------------定义登陆界面组件-------------
    	private JPanel jp1=new JPanel();
    	
    	JButton jbt2=new JButton("查询仓库余量");
    	JButton jbt3=new JButton("取出货物");
    	JButton jbt4=new JButton("订购货物");
    	JButton jbt6=new JButton("安全退出");
    	private JLabel labc=new JLabel("货物类型：1.苹果    2.奇异果    3.香蕉               ");
    	private JLabel labd=new JLabel("   商品编号：      ");
    	private JLabel laba=new JLabel("    提货量:");
    	private JLabel labb=new JLabel("      进货量:");
    
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
    		
    		
    		show.setEditable(false);                    //设置文本区show不可编辑
			getContentPane().setLayout(new BorderLayout());
			jp1.setLayout(new FlowLayout());            //设置面板jp1为流式布局
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
    	
    		//-----------实现各个按钮的监听-----------
    		jbt2.addActionListener(this);
    		jbt3.addActionListener(this);
    		jbt4.addActionListener(this);
    		jbt6.addActionListener(this);
    		
    		
    	}
    	
    	public void actionPerformed(ActionEvent e)
    	{   
    		int numb,temp;
    		int app,qiyi,ban;
			if(e.getSource()==jbt2)                 //实现仓库余量
    		{
    			app=user.getApp();
    			qiyi=user.getQiyi();
    			ban=user.getBan();
    			show.setText("苹果:"+app+"个\n"+
    			             "奇异果:"+qiyi+"个\n"+
    			             "香蕉:"+ban+"根");
    		}
    		else if(e.getSource()==jbt3)            //实现提货
    			{   
    			numb=Integer.parseInt(re3.getText());
    			temp=Integer.parseInt(re1.getText());	
    	    	if(numb==1){
    	    		app=user.getApp();
    				if(app>=0){
    				    temp=Integer.parseInt(re1.getText());
    				    user.setApp(user.getApp()-temp);
    				    app=user.getApp();
                        show.setText("出货成功  仓库余量:苹果 "+app+"个");
        			    re1.setText("");
        			}
        		    if(app<0){
        		    	show.setText("仓库库存不足，请重新提货：");
        		    	user.setApp(user.getApp()+temp);
        		    }
    			}
    			else if(numb==2){
    				qiyi=user.getQiyi();
    			    if(qiyi>=0){
    				    temp=Integer.parseInt(re1.getText());
    				    user.setQiyi(user.getQiyi()-temp);
    				    qiyi=user.getQiyi();
    				    show.setText("出货成功  仓库余量:奇异果 "+qiyi+"个");
        			    re1.setText("");
        			}
    			    if(qiyi<0){
    			    	show.setText("仓库库存不足，请重新提货：");
        		    	user.setQiyi(user.getQiyi()+temp);
    			    }
    			}
    			else if(numb==3){
    				ban=user.getBan();
    				if(ban>=0){
    				    temp=Integer.parseInt(re1.getText());
    				    user.setBan(user.getBan()-temp);
    				    ban=user.getBan();
    				    show.setText("出货成功  仓库余量:香蕉 "+ban+"根");
        			    re1.setText("");
        			}
    				if(ban<0){
     			    	show.setText("仓库库存不足，请重新提货：");
         		    	user.setBan(user.getBan()+temp);
     			    }
    		}
    			}
    		else if(e.getSource()==jbt4)            //实现进货    
        		{   numb=Integer.parseInt(re3.getText());
    			    if(numb==1){
        				
             		    temp=Integer.parseInt(re2.getText());
        				user.setApp(user.getApp()+temp);
        				app=user.getApp();
                        show.setText("进货成功  仓库余量:T苹果 "+app+"个");
            			re2.setText("");
        			}
        			else if(numb==2){
        				
             		    temp=Integer.parseInt(re2.getText());
        				user.setQiyi(user.getQiyi()+temp);
        				qiyi=user.getQiyi();
        				show.setText("进货成功  仓库余量:奇异果 "+qiyi+"个");
            			re2.setText("");
        			}
        			else if(numb==3){
        				
             		    temp=Integer.parseInt(re2.getText());
        				user.setBan(user.getBan()+temp);
        				ban=user.getBan();
        				show.setText("进货成功  仓库余量:香蕉 "+ban+"根");
            			re2.setText("");
        		}
        			}
    		else if(e.getSource()==jbt6)            //实现窗口的关闭
    		{
    			re1.setText("");
    			re2.setText("");
    			show.setText("");
    			dispose();
    		}
    	}
    }

}