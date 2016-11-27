package PC;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main_Array extends JFrame {

    final static int NUMBER = 8;

    static int[] money = new int[NUMBER];
    static int[] number = new int[NUMBER];

    static int[] size_L = {50, 200, 40, 100};
    static int size_W = 40;

    static int[] axis_X = {5, 50, 250, 300};
    static int axis_Y = 55;

    JLabel JL_msg, JL_img, JL_money, JL_bg;
    JLabel[] JL_PC = new JLabel[NUMBER];
    JLabel[] JL_total = new JLabel[NUMBER];
    JComboBox[] Jcb_PC = new JComboBox[NUMBER];
    JComboBox[] Jcb_number = new JComboBox[NUMBER];

    Container ContentPane;

    //-------------------資料-------------------//
    String[] JL_Str = {"CPU", "RAM", "HD", "MB", "LCD", "Power", "Case", "Display"};
    String[] Number = {"0", "1", "2", "3", "4", "5"};

    //-------------------資料-------------------//
    String[] CPU = {
        "",
        "Intel Celeron G1820 - NT.1300",
        "Intel Pentium G3420 - NT.2200",
        "Intel Core i5 4670 - NT.7300"

    };

    int[] money_CPU = {0, 1300, 2200, 7300};

    String[] img_CPU = {"img/CPU/0.jpg", "img/CPU/1.jpg", "img/CPU/2.jpg", "img/CPU/3.jpg"};

    //-------------------資料-------------------//
    String[] RAM = {
        "",
        "威剛 DDR3 4G - NT.1100",
        "金士頓 DDR3 4GB - NT.1150",
        "創見 DDR3 4GB - NT.1200"
    };

    int[] money_RAM = {0, 1100, 1150, 1200};

    String[] img_RAM = {"img/RAM/0.jpg", "img/RAM/1.jpg", "img/RAM/2.jpg", "img/RAM/3.jpg"};

    //-------------------資料-------------------//
    String[] HD = {
        "",
        "WD 1TB 3.5吋 SATA3 - NT.1999",
        "Seagate 2TB 3.5吋 SATA3 - NT.2766",
        "TOSHIBA 3TB 3.5吋 SATA3 - NT.3688"
    };

    int[] money_HD = {0, 1999, 2766, 3688};

    String[] img_HD = {"img/HD/0.jpg", "img/HD/1.jpg", "img/HD/2.jpg", "img/HD/3.jpg"};

    //-------------------資料-------------------//
    String[] MB = {
        "",
        "華擎 H81M-ITX 主機板 - NT.2290",
        "技嘉 G1.SNIPER B5 主機板 - NT.3090",
        "華碩 Z87-K 主機板- NT.3990"
    };

    int[] money_MB = {0, 2290, 3090, 3990};

    String[] img_MB = {"img/MB/0.jpg", "img/MB/1.jpg", "img/MB/2.jpg", "img/MB/3.jpg"};

    //-------------------資料-------------------//
    String[] LCD = {
        "",
        "華碩 VX229N 22型AH-IPS寬螢幕 - NT.3988",
        "樂金 23MP65HQ-P 23型AH-IPS寬螢幕 - NT.5688",
        "戴爾 U2412M 24 吋寬螢幕顯示器 - NT.8800"
    };

    int[] money_LCD = {0, 3988, 5688, 8800};

    String[] img_LCD = {"img/LCD/0.jpg", "img/LCD/1.jpg", "img/LCD/2.jpg", "img/LCD/3.jpg"};

    //-------------------資料-------------------//
    String[] Power = {
        "",
        "七盟 82+ 銅牌 420W 電源供應器 - NT.1699",
        "銀欣 全模組SFX/ATX兩用金牌 電源供應器 - NT.2890",
        "安鈦克 HCP-1000 1000W 電源供應器 - NT.8490"
    };

    int[] money_Power = {0, 1699, 2890, 8490};

    String[] img_Power = {"img/Power/0.jpg", "img/Power/1.jpg", "img/Power/2.jpg", "img/Power/3.jpg"};

    //-------------------資料-------------------//
    String[] Case = {
        "",
        "杰強 蘇凱30戰鬥 USB3.0 電腦機殼 - NT.890",
        "Cooler Master K280 電競機殼 - NT.1390",
        "曜越 Overseer RX-I Snow Edition機殼 - NT.4290"
    };

    int[] money_Case = {0, 890, 1390, 4290};

    String[] img_Case = {"img/Case/0.jpg", "img/Case/1.jpg", "img/Case/2.jpg", "img/Case/3.jpg"};

    //-------------------資料-------------------//
    String[] Display = {
        "",
        "技嘉 GV-N210D3-1GI 顯示卡 - NT.1190",
        "華碩 GT640-1GD5-L 顯示卡 - NT.2590",
        "麗臺 GT660 2GB DDR5 192bit PCI-E 3D 圖形加速卡 - NT.6890"
    };

    int[] money_Display = {0, 1190, 2590, 6890};

    String[] img_Display = {"img/Display/.jpg", "img/Display/1.jpg", "img/Display/2.jpg", "img/Display/3.jpg"};

    String[][] name_product = {CPU, RAM, HD, MB, LCD, Power, Case, Display};
    int[][] money_product = {money_CPU, money_RAM, money_HD, money_MB, money_LCD, money_Power, money_Case, money_Display};
    String[][] img_product = {img_CPU, img_RAM, img_HD, img_MB, img_LCD, img_Power, img_Case, img_Display};

    String[] bg_jpg = {
        "img/Background/0.jpg", "img/Background/1.jpg", "img/Background/2.jpg", "img/Background/3.jpg",
        "img/Background/4.jpg", "img/Background/5.jpg", "img/Background/6.jpg", "img/Background/7.jpg"
    };

    ImageIcon img = new ImageIcon(this.getClass().getResource(bg_jpg[0]));

    //-------------------Main-------------------//
    public Main_Array() {

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

        JL_msg = new JLabel("~~~歡迎光臨~~~");
        JL_msg.setBounds(50, 10, 600, 40);
        JL_msg.setFont(new Font("", 1, 16));
        ContentPane.add(JL_msg);

        JL_img = new JLabel();
        JL_img.setBounds(380, 60, 200, 200);
        JL_img.setIcon(new ImageIcon(this.getClass().getResource(img_CPU[0])));
        ContentPane.add(JL_img);

        //-------------------價目表初始化----------------------//
        for (int i = 0; i < JL_PC.length; i++) {

            JL_PC[i] = new JLabel(JL_Str[i]);
            JL_PC[i].setBounds(axis_X[0], axis_Y * (i + 1), size_L[0], size_W);
            ContentPane.add(JL_PC[i]);

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
        JL_money.setFont(new Font("", 1, 36));
        ContentPane.add(JL_money);

        //-------------------背景-------------------//
        JL_bg = new JLabel();
        JL_bg.setIcon(img);
        JL_bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        ContentPane.add(JL_bg);

    }

    //-------------------ActionListener-------------------//
    class myActionListener_PC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JComboBox temp = (JComboBox) e.getSource();

            int index = jcb_select(e, Jcb_PC);
            money[index] = money_product[index][temp.getSelectedIndex()];
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

    //-------------------判斷按到哪一個JComboBox-------------------//
    public int jcb_select(ActionEvent e, JComboBox[] jcb) {
        for (int i = 0; i < jcb.length; i++) {
            if (e.getSource() == jcb[i]) {
                return i;
            }
        }
        return 0;
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

    //-------------------main-------------------//
    public static void main(String[] args) {
        Main_Array main1 = new Main_Array();
    }
}
