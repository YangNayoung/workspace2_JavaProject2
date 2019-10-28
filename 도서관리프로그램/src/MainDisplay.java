package 도서관리프로그램;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import 도서관리프로그램.Book;
import 도서관리프로그램.Person;

public class MainDisplay implements ActionListener{

	JFrame iFrame;
	JPanel iPaneLbl, temp;
	JButton byPerson, byBook, byPolicy,  Borrow, Return, extProgram;
	JLabel iName;
	
	JTable bookTable, personTable;
	String category[] = {"책이름", "저자", "대출자"};
	String category2[] = {"회원이름", "나이", "대출책 갯수", "직업"};
	String category3[] = {"학생", "교사", "Guest", "직원 "};
	String category4[] = {"FULL", "HALF", "BASIC"};
	DefaultTableModel model, model2;
	JScrollPane tbl_sp, tbl_sp2;
	Person[] libPerson;
	int countPerson;
	Book[] libBook;
	int countBook;
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	
	String sql=null;
	
	public MainDisplay(){	
		try {	
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();	
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/javap2", "root", "1234");     
			System.out.println("DB 연결 완료");			
		}catch(SQLException ex) {
            System.out.println("SQLException:" + ex);
        }catch(Exception ex) {
            System.out.println("Exception:" + ex);
        }
			
		libPerson = new Person[100];
		libBook = new Book[100];		
		countPerson = countBook = 0;
		
		iFrame=new JFrame("도서 정보 관리 시스템");
		iFrame.setLayout(null);
		iFrame.setBounds(40, 40, 1270, 380);
		iFrame.setResizable(false);

		iPaneLbl=new JPanel(null);
		iPaneLbl.setBounds(10, 0, 530, 60);
		iPaneLbl.setBackground(Color.black);
		iName=new JLabel("도서관리 시스템");
		iName.setBounds(135, 5, 500, 50);
		iName.setForeground(Color.white);
		iName.setFont(new Font("Helvitica", Font.BOLD, 20));
		iPaneLbl.add(iName);
		iFrame.add(iPaneLbl);

		byPerson=new JButton("회원 정보");
		byPerson.setBounds(140, 90, 250, 30);
		byPerson.addActionListener(this);
		iFrame.add(byPerson);

		byBook=new JButton("책 정보");
		byBook.setBounds(140, 140, 250, 30);
		byBook.addActionListener(this);
		iFrame.add(byBook);


		extProgram=new JButton("종료");
		extProgram.setBounds(140, 240, 250, 30);
		extProgram.addActionListener(this);
		iFrame.add(extProgram);
		
		Borrow=new JButton("대여");
		Borrow.setBounds(140, 190, 120, 30);
		Borrow.addActionListener(this);
		iFrame.add(Borrow);
		
		Return=new JButton("반납");
		Return.setBounds(270, 190, 120, 30);
		Return.addActionListener(this);
		iFrame.add(Return);
		
		model = new DefaultTableModel(category,0);
		bookTable = new JTable(model);		
		tbl_sp = new JScrollPane(bookTable);
		tbl_sp.setBounds(550, 0, 250, 400);
		iFrame.add(tbl_sp);
	
		model2 = new DefaultTableModel(category2, 0);
		personTable = new JTable(model2);
		tbl_sp2 = new JScrollPane(personTable);
		tbl_sp2.setBounds(805, 0, 440, 400);
		iFrame.add(tbl_sp2);		
		iFrame.setVisible(true);
	}
	private void loadLibPerson() {
		try {
		    String sql = "select * from LibPerson";
		    pstmt= conn.prepareStatement(sql);			
		    ResultSet srs = pstmt.executeQuery();	    
	    
		    while(srs.next()){
		    	libPerson[countPerson] = new Person() {	};
				libPerson[countPerson].setName(srs.getString("name"));
				libPerson[countPerson].setAge(srs.getInt("age"));
				libPerson[countPerson].setAddress(srs.getString("address"));				
				libPerson[countPerson++].setNumofbook(srs.getInt("numofbook"));		
				
		    }		   
		} catch (Exception e) {
			refresh();
			return;
		}
		refresh();
	}
	
	private void loadBook() {
		try {
		    String sql = "select * from Book";
		    pstmt= conn.prepareStatement(sql);			
		    ResultSet srs = pstmt.executeQuery();		    		   
		    while(srs.next()){
		    	libBook[countBook] = new Book();
				libBook[countBook].setName(srs.getString("name"));
				libBook[countBook].setAuth(srs.getString("auth"));
				libBook[countBook++].setPersonname(srs.getString("personname"));
		    }	    
				
		} catch (Exception e) {
			refresh();
			return;
		}
		refresh();
	}
	
	public void actionPerformed(ActionEvent iEvent){
		try {
			int cnt =0;
		if(iEvent.getSource()==byPerson) {
			String name = JOptionPane.showInputDialog("이름을 입력하세요");
			int age = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요"));
			String address = JOptionPane.showInputDialog("주소를 입력하세요");
			int abc = JOptionPane.showOptionDialog(temp, "선택", "뮤", 0, 0, null, category3, 0);
			System.out.println(abc);
			switch (abc) {
			case 0:				
				cnt = countPerson++;
				libPerson[cnt] = new Student(name, age, address);				
				System.out.println(cnt);
				System.out.println(libPerson[cnt].getName());
				System.out.println(libPerson[cnt].getAge());
				System.out.println(libPerson[cnt].getAddress());						
				libPerson[cnt].setNumofbook(0);
				libPerson[cnt].setStatus("stuent");
				System.out.println(libPerson[cnt].getNumofbook());
				System.out.println(libPerson[cnt].getStatus());
				
				insertLibPerson(libPerson[cnt]);
				refresh();
				break;
			case 1:
				cnt = countPerson++;
				libPerson[cnt] = new Faculty(name, age, address);
				libPerson[cnt].setNumofbook(0);
				libPerson[cnt].setStatus("faculty");
				insertLibPerson(libPerson[cnt]);
				refresh();
				break;
			case 2:
				String visit = JOptionPane.showInputDialog("방문 목적을 입력하세요"); // guest 클래스만 존재
				cnt = countPerson++;
				libPerson[cnt] = new guest(name, age, address, visit); // 테이블에 방문 목적은 출력 X
				insertLibPerson(libPerson[cnt]);
				refresh();
				break;
			case 3:
				cnt = countPerson++;
				libPerson[cnt] = new Staff(name, age, address);
				insertLibPerson(libPerson[cnt]);
				refresh();
				break;
			}
		}
		else if(iEvent.getSource()==byBook) {
			String name = JOptionPane.showInputDialog("책 제목을 입력하세요");
			String auth = JOptionPane.showInputDialog("저자를 입력하세요");			
			cnt = countBook++;
			System.out.println("name :" + name);
			System.out.println("auth :" + auth);
			libBook[cnt] = new Book(name, auth);
			insertBook(libBook[cnt]);
			refresh();	
		}
		else if(iEvent.getSource()==Borrow){
			System.out.println("borrow");
			int book = bookTable.getSelectedRow();
			int person = personTable.getSelectedRow();
			System.out.println(book);
			System.out.println(person);
			String bookname = (String) model.getValueAt(book, 0);
			String personname = (String) model2.getValueAt(person, 0);
			System.out.println(bookname);
			System.out.println(personname);
			if(model.getValueAt(book, 2)!=null){
				JOptionPane.showMessageDialog(temp, "먼저 \"" + bookname +"\"을 반납해 주세요");
				return;
			}
			System.out.println(bookname);
			System.out.println(personname);
			borrow(bookname, personname);
		}
		else if(iEvent.getSource()==Return){
			int book = bookTable.getSelectedRow();
			if(model.getValueAt(book, 2)==null){
				JOptionPane.showMessageDialog(temp, "이 책을 빌린사람이 아무도 없습니다");
			}
			else{
				String personname = (String) model.getValueAt(book, 2);
				Return(personname, (String) model.getValueAt(book, 0));
				refresh();
			}			
		}	
		}catch(SQLException ex) {
            System.out.println("SQLException:" + ex);
        }catch(Exception ex) {
            System.out.println("Exception:" + ex);
        }
	}
	private void Return(String personname, String bookname) throws SQLException{
		for (int i = 0; i < countPerson; i++) {
			if(libPerson[i].getName().equals(personname)){
				int num = libPerson[i].getNumofbook()-1;
				libPerson[i].setNumofbook(libPerson[i].getNumofbook()-1);
				updateLibPerson(personname, num);
				break;
			}
		}
		for (int i = 0; i < countBook; i++) {
			if(libBook[i].getName().equals(bookname)){
				libBook[i].setPersonname(null);
				updateBook(bookname, "");
				return;
			}
		}		
	}
	private void borrow(String bookname, String personname) throws SQLException{
		for(int i=0; i<countPerson; i++){
			if(libPerson[i].getName().equals(personname)){
				int num = libPerson[i].getNumofbook();
				System.out.println("0 num" + num);
				System.out.println("1personname" + personname);
				libPerson[i].setNumofbook(num+1);
				updateLibPerson(libPerson[i].getName(),  num+1 );
				break;
			}
		}
		for(int i=0; i<countBook; i++){
			if(libBook[i].getName().equals(bookname)){
				libBook[i].setPersonname(personname);
				updateBook(libBook[i].getName(), personname);
				break;
			}
		}		
		refresh();
	}
	private void refresh() {
		model = new DefaultTableModel(category, 0);
		for(int i=0; i<countBook; i++){
			model.addRow(libBook[i].getall());
		}
		model2 = new DefaultTableModel(category2, 0);
		for(int i=0; i<countPerson; i++){
			model2.addRow(libPerson[i].getall());
		}
		bookTable.setModel(model);
		personTable.setModel(model2);
		iFrame.invalidate();
	}
	
	public void insertLibPerson(Person s) throws Exception {		
		String sql="insert into libPerson (name,  age, address, numofbook, status) values(?,?,?, ?, ?)";		
		pstmt= conn.prepareStatement(sql);
		String imsi = new String(s.getName().getBytes(),"ISO-8859-1");		
		pstmt.setString(1, imsi);
		pstmt.setInt(2, s.getAge());
		imsi = new String(s.getAddress().getBytes(),"ISO-8859-1");
		pstmt.setString(3, imsi);			
		pstmt.setInt(4, s.getNumofbook());
		pstmt.setString(5, s.getStatus());
		pstmt.executeUpdate();
				
	}
	
	public void insertBook(Book b) throws Exception {
		String sql="insert into book (borrow,  name, auth, publisher, personname) values(?,?,?, ?, ?)"; 
		pstmt= conn.prepareStatement(sql);
		String imsi = new String(b.getName().getBytes(),"ISO-8859-1");
		pstmt.setInt(1, 0);
		pstmt.setString(2, imsi);
		imsi = new String(b.getAuth().getBytes(),"ISO-8859-1");
		pstmt.setString(3, imsi);			
		if(b.getPublisher() !=null)
				imsi = new String(b.getPublisher().getBytes(),"ISO-8859-1");
		else imsi = "";
		pstmt.setString(4, imsi);
		pstmt.setString(5, b.getPersonname());
		pstmt.executeUpdate();
				
	}
	public void updateLibPerson(String name, int numofbook) throws SQLException{
		 String sql = "update libperson set numofbook = ? where name =?";		 
	     pstmt= conn.prepareStatement(sql);	
	     pstmt.setInt(1,  numofbook);
	     pstmt.setString(2,  name);
	     pstmt.executeUpdate();	     
   } 
	
   public void updateBook(String name, String personname) throws SQLException{
		 String sql = "update book set personname = ? where name =?";
	     pstmt= conn.prepareStatement(sql);	
	     pstmt.setString(1,  name);
	     pstmt.setString(2,  personname);
	     pstmt.executeUpdate();	     
  } 
		
	public static void main(String[] args) {		
		MainDisplay MDisMDis=new MainDisplay();		
		MDisMDis.loadBook();
		MDisMDis.loadLibPerson();
	}
}