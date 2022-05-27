import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

 class calculator extends JFrame implements ActionListener {
     static JFrame fr;
     static JTextField l;
     String s0,s1,s2;

     calculator(){
         s0 = s1 = s2 = "";
     }

     public static void main(String[] args) {
         fr = new JFrame("calculator");
         try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         }
         catch(Exception e){
             System.err.println(e.getMessage());
         }
         calculator c = new calculator();
         l = new JTextField(15);
         l.setEditable(false);
         JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bsub,bdev,bmulti,be,beq,bclear;
         b0 = new JButton("0");
         b1 = new JButton("1");
         b2 = new JButton("2");
         b3 = new JButton("3");
         b4 = new JButton("4");
         b5 = new JButton("5");
         b6 = new JButton("6");
         b7 = new JButton("7");
         b8 = new JButton("8");
         b9 = new JButton("9");
         badd = new JButton("+");
         bsub = new JButton("-");
         bdev = new JButton("/");
         bmulti = new JButton("*");
         be = new JButton(".");
         beq = new JButton("=");
         bclear = new JButton("C");

         JPanel p = new JPanel();

         bclear.addActionListener(c);
         beq.addActionListener(c);
         be.addActionListener(c);
         bmulti.addActionListener(c);
         bdev.addActionListener(c);
         bsub.addActionListener(c);
         badd.addActionListener(c);
         b9.addActionListener(c);
         b8.addActionListener(c);
         b7.addActionListener(c);
         b6.addActionListener(c);
         b5.addActionListener(c);
         b4.addActionListener(c);
         b3.addActionListener(c);
         b2.addActionListener(c);
         b1.addActionListener(c);
         b0.addActionListener(c);

         p.add(l);
         p.add(badd);
         p.add(b1);
         p.add(b2);
         p.add(b3);
         p.add(bsub);
         p.add(b4);
         p.add(b5);
         p.add(b6);
         p.add(bmulti);
         p.add(b7);
         p.add(b8);
         p.add(b9);
         p.add(bdev);
         p.add(be);
         p.add(b0);
         p.add(bclear);
         p.add(beq);

         p.setBackground(Color.LIGHT_GRAY);
         fr.add(p);
         fr.setSize(200,220);
         fr.show();
     }
     public void actionPerformed(ActionEvent e)
     {
         String s = e.getActionCommand();
         if((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.'){
             if(!s1.equals(""))
                 s2 = s2 + s;
             else
                 s0 = s0 + s;
             l.setText(s0+s1+s2);
         }
         else if(s.charAt(0) == 'C'){
             s0=s1=s2="";
             l.setText(s0 +s1 +s2);
         }
         else if (s.charAt(0) == '='){
             double pt = 0;
             if(s1.equals("+"))
                 pt = (Double.parseDouble(s0) + Double.parseDouble(s2));
             else if (s1.equals("-"))
                 pt = (Double.parseDouble(s0) - Double.parseDouble(s2));
             else if (s1.equals("/"))
                 pt = (Double.parseDouble(s0) / Double.parseDouble(s2));
             else if (s1.equals("*"))
                 pt = (Double.parseDouble(s0) * Double.parseDouble(s2));

             l.setText(s0 + s1 + s2 + "=" + pt);
             s0 = Double.toString(pt);
             s1 = s2 = "";
         }
         else{
             if(s1.equals("") || s2.equals(""))
                 s1 = s;
             else{
                 double pt;
                 if (s1.equals("+"))
                     pt = (Double.parseDouble(s0) + Double.parseDouble(s2));
                 else if (s1.equals("-"))
                     pt = (Double.parseDouble(s0) - Double.parseDouble(s2));
                 else if (s1.equals("/"))
                     pt = (Double.parseDouble(s0) / Double.parseDouble(s2));
                 else
                     pt = (Double.parseDouble(s0) * Double.parseDouble(s2));
                 s0 = Double.toString(pt);
                 s1 = s;
                 s2 = "";
            }
             l.setText(s0 + s1 + s2);
         }
     }

}
