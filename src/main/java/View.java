import javax.swing.*;
import java.awt.*;
import java.io.File;

public class View extends JFrame {
    private File a;
    private File files;
    private File[] contents;

    private final JLabel l1 =new JLabel();
    private final JLabel l2 =new JLabel();

    View(){
        openWindow();
    }


    private void openWindow(){
        setLayout(new GridLayout(3,1));
        JPanel p;
        p=new JPanel();
        JButton b;


        b= new JButton("Wähle die xls.- Datei");
        b.addActionListener(e -> {
            final JFileChooser fi =new JFileChooser();
            fi.addActionListener(e1 ->{
                a =fi.getSelectedFile();
                l1.setText(a.getName());
            });
            fi.showOpenDialog(null);
        });
        p.add(b);
        p.add(l1);
        add(p);
        p= new JPanel();
        b=new JButton("Wähle den Ordner mit Bildern");
        b.addActionListener(e->{
            final JFileChooser fi =new JFileChooser();
            fi.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fi.setAcceptAllFileFilterUsed(false);
            fi.addActionListener(e1 -> {
                files=fi.getSelectedFile();
                contents = files.listFiles();
                l2.setText(files.getPath());
            });
            fi.showOpenDialog(null);
        });
        p.add(b);
        p.add(l2);
        add(p);
        p=new JPanel();
        b=new JButton("Umbenennen");
        b.addActionListener(e-> {
            System.out.println(files);
            FileManager ding=new FileManager();
            ding.renameFiles(contents,a);
        });
        p.add(b);
        add(p);


        setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth()/4,GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()/4,1000,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;


    }
}
