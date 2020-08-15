package com.data;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

class MyFrame extends Frame {

    /**
     * Create the frame.
     */
    MyFrame(){
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        setVisible(true);

    }
}

public class AppData {

    private JPanel contentPane;
    private JPanel panel1;
    private JTextField Student_id;
    private JTextField txtfirstname;
    private JTextField txtlastname;
    private JTextField txtfname;
    private JTextField txtmname;
    private JTextField txtmob;
    private JTextField txtcity;
    private JTextField txtpin_code;
    private JTextField txtstate;
    private JTextField txtcountry;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;

    static MyFrame frm;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
               frm= new MyFrame();
               frm.setTitle("Student Form");
               frm.setLocation(100,100);
        AppData appdata = new AppData();
    }



    public AppData() {

        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        frm.add(contentPane);

        contentPane.setVisible(true);
        /*frm.setContentPane(contentPane);*/
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Student User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 30, 400, 50);
        lblNewUserRegister.setVisible(true);
        contentPane.add(lblNewUserRegister);


        JLabel  lblStudent_id= new JLabel("Student_Id");
        /*lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblStudent_id.setBounds(50, 100, 99, 22);
        contentPane.add(lblStudent_id);

        Student_id= new JTextField();
        Student_id.setBounds(165, 100, 99, 22);
        contentPane.add(Student_id);

        JLabel lblfirstname = new JLabel("First name");
        /*lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblfirstname.setBounds(500, 100, 99, 22);
        contentPane.add(lblfirstname);

        txtfirstname = new JTextField();
        txtfirstname.setBounds(615, 100, 99, 22);
        contentPane.add(txtfirstname);

        JLabel lbllastname = new JLabel("Last name");
        /*lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lbllastname.setBounds(50, 140, 99, 22);
        contentPane.add(lbllastname);

        txtlastname = new JTextField();
        txtlastname.setBounds(165, 140, 99, 22);
        contentPane.add(txtlastname);

        JLabel lblfname = new JLabel("Father name");
        /*lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblfname.setBounds(500, 140, 99, 22);
        contentPane.add(lblfname);

        txtfname = new JTextField();
        txtfname.setBounds(615, 140, 99, 22);
        contentPane.add(txtfname);

        JLabel lblmname = new JLabel("Mother name");
        /*lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblmname.setBounds(50, 180, 99, 22);
        contentPane.add(lblmname);

        txtmname = new JTextField();
        txtmname.setBounds(165, 180, 99, 22);
        contentPane.add(txtmname);

        JLabel lblmob = new JLabel("Mobile number");
        /*lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblmob.setBounds(500, 180, 99, 22);
        contentPane.add(lblmob);

        txtmob = new JTextField();
        txtmob.setBounds(615, 180, 99, 22);
        contentPane.add(txtmob);
        txtmob.setColumns(10);

        JLabel lblcity = new JLabel("City");
        /*lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblcity.setBounds(50, 220, 99, 22);
        contentPane.add(lblcity);

        txtcity = new JTextField();
        txtcity.setBounds(165, 220, 99, 22);
        contentPane.add(txtcity);

        JLabel lblpin_code = new JLabel("Pin_Code");
        /*lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblpin_code.setBounds(500, 220, 99, 22);
        contentPane.add(lblpin_code);

        txtpin_code = new JTextField();
        txtpin_code.setBounds(615, 220, 99, 22);
        contentPane.add(txtpin_code);

        JLabel lblstate = new JLabel("State");
        /*lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblstate.setBounds(50, 260, 99, 22);
        contentPane.add(lblstate);

        txtstate = new JTextField();
        txtstate.setBounds(165, 260, 99, 22);
        contentPane.add(txtstate);


        JLabel lblcountry = new JLabel("Country");
        /*lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));*/
        lblcountry.setBounds(500, 260, 99, 22);
        contentPane.add(lblcountry);

        txtcountry = new JTextField();
        txtcountry.setBounds(615, 260, 99, 22);
        contentPane.add(txtcountry);


        btnEdit = new JButton("Edit");
        btnEdit.setBounds(365, 500, 150, 40);
        contentPane.add(btnEdit);
        btnEdit.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         try {


                                             DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                                             Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test", "sa", "sa1");


                                         if (btnEdit.getText().equals("Edit")) {
                                             fieldEnable(true);
                                             showData(connection);
                                             btnEdit.setText("Save");
                                         } else {
                                             btnEdit.setText("Edit");
                                             updateData(connection);
                                             fieldEnable(false);
                                         }
                                         }catch (Exception e2){
                                             System.out.println(e2);
                                         }
                                     }
                                 });

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(620, 500, 150, 40);
        contentPane.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {


                    DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                    Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test", "sa", "sa1");


                    if (btnDelete.getText().equals("Delete")) {
                        fieldEnable(true);
                        showData(connection);
                        btnDelete.setText("Confirm");
                    } else {
                        btnDelete.setText("btnDelete");
                        deleteData(connection);
                        btnDelete.setText("Delete");
                        fieldEnable(false);
                        refresh();
                    }
                }catch (Exception e2){
                    System.out.println(e2);
                }
                      }
        });

        btnAdd = new JButton("New Register");
        btnAdd.setBounds(110, 500, 150, 40);
        contentPane.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (btnAdd.getText().equals("New Register")) {
                    fieldEnable(true);
                    btnAdd.setText("Save");
                } else {

                    btnAdd.setText("New Register");

                    String mobileNumber = txtmob.getText();
                    String pinCode = txtpin_code.getText();


                    int len_M = mobileNumber.length();
                    if (len_M != 10) {
                        JOptionPane.showMessageDialog(btnAdd, "Enter a valid mobile number");
                    }
                    int len_P = pinCode.length();
                    if (len_P != 6) {
                        JOptionPane.showMessageDialog(btnAdd, "Enter a valid Pin_Code");
                    }

                    try {

                        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                        /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();*/
                        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test", "sa", "sa1");


                        insert(connection);

 /*                   String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                            password + "','" + emailId + "','" + mobileNumber + "')";*/

                        //  String query = "INSERT INTO sign_up (first_name)  values('" + firstName + "'"+")";
                        String query = "select first_name from sign_up";
                        System.out.println("Hello connection with query " + query);

                        Statement sta = connection.createStatement();
                        try {
                            ResultSet rs = sta.executeQuery(query);
                            System.out.println("Hello connection10");
                            int i = 0;
                            while (rs.next()) {
                                System.out.println(rs.getString(1).toString());
                                i++;
                            }


                            System.out.println("Hello connection11 " + rs + "   " + i);
                        } catch (SQLException e1) {
                            System.out.println("Hello connection12 ");
                        }
                        /*Statement sta = con.createStatement();*/
                    /*int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Welcome, " + msg + "Your account is sucessfully created");
                    }*/
                        connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }

        });
this.fieldEnable(false);
        refresh();
    }

    public  void  fieldEnable(Boolean enable){
        this.txtcity.setEnabled(enable);
        this.txtcountry.setEnabled(enable);
        this.txtfirstname.setEnabled(enable);
        this.txtlastname.setEnabled(enable);
        this.txtfname.setEnabled(enable);
        this.txtmname.setEnabled(enable);
        this.txtmob.setEnabled(enable);
        this.txtstate.setEnabled(enable);
        this.txtpin_code.setEnabled(enable);
    }

    public  void  refresh(){
        this.Student_id.setText("");
        this.txtcity.setText("");
        this.txtcountry.setText("");
        this.txtfirstname.setText("");
        this.txtlastname.setText("");
        this.txtfname.setText("");
        this.txtmname.setText("");
        this.txtmob.setText("");
        this.txtstate.setText("");
        this.txtpin_code.setText("");
    }
    public int showId(Connection con) {
        PreparedStatement stmt1;
        int i = 0;

        String show = "select max(id) from Student_reg";
        try {
            stmt1= con.prepareStatement(show);
            ResultSet rs = stmt1.executeQuery();

            while (rs.next()) {
                i = Integer.parseInt(rs.getString(1).toString());
            }

        }catch (Exception e1) {
            System.out.println(e1);
        }
        return i;
    }


    public void deleteData(Connection con) {
        PreparedStatement stmt1;

        String show = "delete from Student_reg where id=?";
        try {
            stmt1= con.prepareStatement(show);
            stmt1.setInt(1, Integer.parseInt(this.Student_id.getText().trim()));
            stmt1.executeUpdate();

        }catch (Exception e1) {
            System.out.println(e1);
        }

    }

    public void showData(Connection con) {
        PreparedStatement stmt;
        ArrayList<Object> al = new ArrayList();
        String query = "select * from Student_reg where id= ?";
          try {
              System.out.println("Show mehtod");
            stmt = con.prepareStatement(query);
            /*stmt.setInt(1, Integer.parseInt(this.Student_id.getText().toString()));*/
            stmt.setInt(1, Integer.parseInt(this.Student_id.getText().trim()));
            ResultSet rs = stmt.executeQuery();
            int i = 1;

            while (rs.next()) {
              for(i=1;i<11;i++) {
                  al.add(rs.getString(i));
              }
            }
              System.out.println("Show mehtod" + "  "+al.size());
            this.Student_id.setText(al.get(0).toString());
            this.txtfirstname.setText(al.get(1).toString());
            this.txtlastname.setText(al.get(2).toString());
            this.txtfname.setText(al.get(3).toString());
            this.txtmname.setText(al.get(4).toString());
            this.txtmob.setText(al.get(5).toString());
            this.txtcity.setText(al.get(6).toString());
            this.txtpin_code.setText(al.get(7).toString());
            this.txtstate.setText(al.get(8).toString());
            this.txtcountry.setText(al.get(9).toString());

              System.out.println("Show mehtod  50 " + "  "+al.size());

        } catch (Exception er) {
            System.out.println(er);
            System.out.println("not Inserted10");
        }
    }

    public void updateData(Connection con) {
        PreparedStatement stmt;

        String query = "update Student_reg set first_name=? "
                /*"last_name=?,f_name=?, "
                +"m_name=?,phone_no=?,city=?,pin_code=?,state=?,country=? "*/
        +"where id=?";
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, this.txtfirstname.getText().toString().trim());
           /* stmt.setString(2, this.txtlastname.getText().trim());
            stmt.setString(3, this.txtfname.getText().trim());
            stmt.setString(4, this.txtmname.getText().trim());
            stmt.setString(5, this.txtmob.getText().trim());
            stmt.setString(6, this.txtcity.getText().trim());
            stmt.setString(7, this.txtpin_code.getText().trim());
            stmt.setString(8, this.txtstate.getText().trim());
            stmt.setString(9, this.txtcountry.getText().trim());*/
            stmt.setInt(2, Integer.parseInt(this.Student_id.getText().toString()));
stmt.executeUpdate();
            } catch (Exception er) {
            System.out.println(er);
            System.out.println("not Inserted");
        }
    }
    public void insert(Connection con){
        String query ="insert into Student_reg values(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(this.Student_id.getText().toString()));
            stmt.setString(2, this.txtfirstname.getText().toString().trim());
            stmt.setString(3, this.txtlastname.getText().trim());
            stmt.setString(4, this.txtfname.getText().trim());
            stmt.setString(5, this.txtmname.getText().trim());
            stmt.setString(6, this.txtmob.getText().trim());
            stmt.setString(7, this.txtcity.getText().trim());
            stmt.setString(8, this.txtpin_code.getText().trim());
            stmt.setString(9, this.txtstate.getText().trim());
            stmt.setString(10, this.txtcountry.getText().trim());
            /*System.out.println(stmt.toString()+"           "+query);*/
            stmt.executeUpdate();
            System.out.println("Data Inserted");

            refresh();
        }catch (Exception er){
            System.out.println(er);
System.out.println("not Inserted");
        }


    }
       }
