package PC;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Main_List extends JFrame {

    final static int NUMBER = 8;
    final static int size_font_money = 36;
    final static String[] Number = {"0", "1", "2", "3", "4", "5"};
    final static String[] bg_jpg = {
        "img/Background/0.jpg", "img/Background/1.jpg", "img/Background/2.jpg", "img/Background/3.jpg",
        "img/Background/4.jpg", "img/Background/5.jpg", "img/Background/6.jpg", "img/Background/7.jpg"
    };
    final static String[] JL_Str = {"CPU", "RAM", "HD", "MB", "LCD", "Power", "Case", "Display"};
    final static String[] path_txt = {
        "data/CPU.txt", "data/RAM.txt", "data/HD.txt", "data/MB.txt",
        "data/LCD.txt", "data/Power.txt", "data/Case.txt", "data/Display.txt"
    };
    static int[] money = new int[NUMBER];
    static int[] number = new int[NUMBER];
    static String[][] name_product;
    static String[][] money_product;
    static String[][] img_product;

    static boolean flag = false;
    static int bg_jpg_no = 1;

    JLabel JL_msg, JL_img, JL_money, JL_temp, JL_PC, JL_bg;
    //JLabel[] JL_PC = new JLabel[NUMBER];
    JLabel[] JL_total = new JLabel[NUMBER];
    JComboBox[] Jcb_PC = new JComboBox[NUMBER];
    JComboBox[] Jcb_number = new JComboBox[NUMBER];
    JButton Jb_resize, Jb_img;

    Container ContentPane;

    ArrayList<ArrayList<String>> array_data = new ArrayList<>();

    //-------------------Main_List-------------------//
    public Main_List() {

        ContentPane = this.getContentPane();
        ContentPane.setLayout(null);

        init();

        this.setTitle("我不是原價屋 @ 內容圖片皆由網路下載 @ 僅使用於教學用途");
        this.setBounds(400, 120, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    //-------------------畫面初始化----------------------//
    private void init() {

        int[] size_L = {50, 200, 40, 100};
        int size_W = 40;

        int[] axis_X = {5, 50, 250, 300};
        int axis_Y = 55;

        String[][] tempArray;
        String[][] nameProduct = new String[NUMBER][];
        String[][] moneyProduct = new String[NUMBER][];
        String[][] imgProduct = new String[NUMBER][];

        ImageIcon img = new ImageIcon(this.getClass().getResource(bg_jpg[0]));

        //---------------------資料初始化---------------------//
        for (int i = 0; i < path_txt.length; i++) {

            tempArray = reverse_file(read_file(path_txt[i]));

            nameProduct[i] = tempArray[0];
            moneyProduct[i] = tempArray[1];
            imgProduct[i] = tempArray[2];
        }

        String[][] name_all = {nameProduct[0], nameProduct[1], nameProduct[2], nameProduct[3], nameProduct[4], nameProduct[5], nameProduct[6], nameProduct[7]};
        String[][] money_all = {moneyProduct[0], moneyProduct[1], moneyProduct[2], moneyProduct[3], moneyProduct[4], moneyProduct[5], moneyProduct[6], moneyProduct[7]};
        String[][] img_all = {imgProduct[0], imgProduct[1], imgProduct[2], imgProduct[3], imgProduct[4], imgProduct[5], imgProduct[6], imgProduct[7]};

        //---------------------畫面初始化---------------------//
        name_product = name_all;
        img_product = img_all;
        money_product = money_all;

        JL_msg = new JLabel("~~~歡迎光臨~~~", JLabel.CENTER);
        JL_msg.setBounds(40, 10, 500, 30);
        JL_msg.setFont(new Font("", 1, 16));
        ContentPane.add(JL_msg);

        JL_img = new JLabel();
        JL_img.setBounds(380, 60, 200, 200);
        JL_img.setIcon(new ImageIcon(this.getClass().getResource(imgProduct[0][0])));
        ContentPane.add(JL_img);

        //-------------------價目表初始化----------------------//
        for (int i = 0; i < Jcb_PC.length; i++) {

            JL_PC = new JLabel(JL_Str[i]);
            JL_PC.setBounds(axis_X[0], axis_Y * (i + 1), size_L[0], size_W);
            ContentPane.add(JL_PC);

            Jcb_PC[i] = new JComboBox(name_product[i]);
            Jcb_PC[i].setEditable(false);
            Jcb_PC[i].addActionListener(new myActionListener_PC());
            Jcb_PC[i].setBounds(axis_X[1], axis_Y * (i + 1), size_L[1], size_W);
            ContentPane.add(Jcb_PC[i]);

            Jcb_number[i] = new JComboBox(Number);
            Jcb_number[i].setEditable(false);
            Jcb_number[i].addActionListener(new myActionListener_Number());
            Jcb_number[i].setBounds(axis_X[2], axis_Y * (i + 1), size_L[2], size_W);
            ContentPane.add(Jcb_number[i]);

            JL_total[i] = new JLabel("NT...");
            JL_total[i].setBounds(axis_X[3], axis_Y * (i + 1), size_L[3], size_W);
            ContentPane.add(JL_total[i]);
        }

        //-------------------價格-------------------//
        JL_money = new JLabel("總共：0元");
        JL_money.setBounds(150, 510, 300, size_W);
        JL_money.setFont(new Font("", Font.BOLD, size_font_money));
        ContentPane.add(JL_money);

        //-------------------背景-------------------//
        JL_bg = new JLabel();
        JL_bg.setIcon(img);
        JL_bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        ContentPane.add(JL_bg);

        //-------------------按鈕-------------------//
        Jb_resize = new JButton("編譯--->");
        Jb_resize.setBounds(430, 280, 100, 20);
        Jb_resize.addActionListener(new myActionListener_Editor());
        JL_bg.add(Jb_resize);

        Jb_img = new JButton("更換背景");
        Jb_img.setBounds(430, 330, 100, 20);
        Jb_img.addActionListener(new myActionListener_img());
        JL_bg.add(Jb_img);

    }

    //-------------------ActionListener_PC-------------------//
    class myActionListener_PC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JComboBox temp = (JComboBox) e.getSource();

            int index = jcb_select(e, Jcb_PC);
            money[index] = Integer.parseInt(money_product[index][temp.getSelectedIndex()]);
            money_total(index);

            String str = (String) temp.getSelectedItem();
            JL_msg.setText("《" + str + "》");
            JL_img.setIcon(new ImageIcon(this.getClass().getResource(img_product[index][temp.getSelectedIndex()])));
        }
    }

    //-------------------ActionListener_Number-------------------//
    class myActionListener_Number implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JComboBox temp = (JComboBox) e.getSource();

            int index = jcb_select(e, Jcb_number);

            number[index] = Integer.parseInt(Number[temp.getSelectedIndex()]);
            money_total(index);

        }
    }

    //-------------------ActionListener_Editor-------------------//
    class myActionListener_Editor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setSize();
        }
    }

    //-------------------ActionListener_img-------------------//
    class myActionListener_img implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (bg_jpg_no >= bg_jpg.length) {
                bg_jpg_no = 0;
            }

            JL_bg.setIcon(new ImageIcon(this.getClass().getResource(bg_jpg[bg_jpg_no])));
            ++bg_jpg_no;
        }
    }

    //-------------------判斷按到哪一個JComboBox-------------------//
    public int jcb_select(ActionEvent e, JComboBox[] jcb) {
        for (int i = 0; i < jcb.length; i++) {
            if (e.getSource() == jcb[i]) {
                return i;
            }
        }
        return 0;
    }

    //-------------------------------------//   
    private void setSize() {

        flag = !flag;

        if (flag) {
            this.setSize(1200, 600);
            Jb_resize.setText("<---關閉");
        } else {
            this.setSize(600, 600);
            Jb_resize.setText("編譯--->");
        }
    }

    //-------------------金錢總計-------------------//
    public void money_total(int index) {
        int total_temp = 0;

        for (int i = 0; i < money.length; i++) {
            total_temp = total_temp + money[i] * number[i];
        }

        JL_total[index].setText("NT." + money[index] * number[index] + "元");
        JL_money.setText("總共：" + total_temp + "元");
    }

    //-------------------檔案讀取-------------------//
    private ArrayList<ArrayList<String>> read_file(String path) {

        ArrayList<ArrayList<String>> array_list = new ArrayList<>();
        path = this.getClass().getResource(path).getPath();

        try {
            //將路徑轉成UTF-8編碼
            path = URLDecoder.decode(path, "UTF-8");

            FileReader fr = new FileReader(path);
            //InputStreamReader ip = new InputStreamReader(this.getClass().getResourceAsStream(path));
            BufferedReader br = new BufferedReader(fr);

            // 讀取第一行
            br.readLine();

            String temp_str;

            while ((temp_str = br.readLine()) != null) {

                //利用分隔字元\t，來分割字串
                String item[] = temp_str.split("\t");

                ArrayList<String> temp_list = new ArrayList<>();

                for (int i = 0; i < item.length; i++) {
                    temp_list.add(item[i]);
                }

                array_list.add(temp_list);
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, path);
            System.exit(-1);
        }

        return array_list;
    }

    //--------------------------------------//
    private String[][] reverse_file(ArrayList<ArrayList<String>> array_list) {

        int size_X = array_list.size();
        int size_Y = array_list.get(0).size();//3

        String[][] array_str = new String[size_Y][size_X];
        String[][] temp = new String[size_X][size_Y];

        for (int i = 0; i < size_X; i++) {
            temp[i] = (String[]) array_list.get(i).toArray(new String[0]);
        }

        for (int i = 0; i < size_Y; i++) {
            for (int j = 0; j < size_X; j++) {
                array_str[i][j] = temp[j][i];
            }
        }
        return array_str;
    }

    //-------------------main-------------------//
    public static void main(String[] args) {
        Main_List main1 = new Main_List();
    }
}
